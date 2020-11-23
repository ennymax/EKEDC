package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TestBase {

    WebDriver driver;

    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest test;

    @BeforeSuite
    public void setup() {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Report\\REPORT" + System.currentTimeMillis() + ".html");
        htmlReporter.config().setDocumentTitle("CICOD Test Results");
        htmlReporter.config().setReportName("Tester's Name: Eniola Iyaomolere");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);

        extent.setSystemInfo("Hostname", "LocalHost");
        extent.setSystemInfo("TesterName", "Eniola Iyaomolere");
        extent.setSystemInfo("OS", "Window10");
        extent.setSystemInfo("Browser", "Chrome and Firefox");
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.STARTED) {
            String methodName = result.getMethod().getMethodName();
            ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
            extentTest.assignCategory(result.getTestContext().getSuite().getName());
            System.out.println( extentTest.assignCategory(methodName + " started!"));
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(MarkupHelper.createLabel(result.getName() + " The Test Case Failed", ExtentColor.RED));
            test.fail(result.getThrowable());
            System.out.println("***************************Failed********************* "+ (result.getMethod().getMethodName() + " ********************Failed******************"));
            System.out.println("***************************Failed********************* "+ getTime(result.getEndMillis()) + " ********************Failed******************");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(MarkupHelper.createLabel(result.getName() + " The Test Case Passed", ExtentColor.GREEN));
            System.out.println("***************************Passed********************* "+ (result.getMethod().getMethodName() + " ********************Passed******************"));
            System.out.println("***************************Passed********************* "+ getTime(result.getEndMillis()) + " ********************Passed******************");
            test.getModel().setEndTime(getTime(result.getEndMillis()));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(MarkupHelper.createLabel(result.getName() + " The Test Case Skipped", ExtentColor.YELLOW));
            test.skip(result.getThrowable());
            System.out.println("***************************Skipped********************* "+ (result.getMethod().getMethodName() + " ********************Skipped******************"));
            System.out.println("***************************Skipped********************* "+ getTime(result.getEndMillis()) + " ********************Skipped******************");

            try {
                test.skip(result.getThrowable(),
                        MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
            } catch (IOException e) {
                System.err.println("Exception thrown while updating test skip status " + Arrays.toString(e.getStackTrace()));
            }
            test.getModel().setEndTime(getTime(result.getEndMillis()));
        }
        extent.flush();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public String getScreenshot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public synchronized void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());

        extentTest.assignCategory(result.getTestContext().getSuite().getName());
        System.out.println( extentTest.assignCategory(result.getTestContext().getSuite().getName()) + methodName + " started!");

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println((iTestResult.getMethod().getMethodName() + " passed!"));
        test.pass("Test passed");
        test.getModel().setEndTime(getTime(iTestResult.getEndMillis()));
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println((iTestResult.getMethod().getMethodName() + " failed!"));
        try {
            test.fail(iTestResult.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
        } catch (IOException e) {
            System.err
                    .println("Exception thrown while updating test fail status " + Arrays.toString(e.getStackTrace()));
        }
        test.getModel().setEndTime(getTime(iTestResult.getEndMillis()));
    }
}
