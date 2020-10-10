package com.Module;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class View_Payment_History extends TestBase {

    @Test
    public void VIEW_PAYMENT_HISTORY() throws IOException, InterruptedException {

        test = extent.createTest("VIEW PAYMENT HISTORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        Login login = new Login(driver);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        login.Login();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentHistory_XPATH"))).click();

        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("Scroll1_XPATH")));
        JavascriptExecutor jej = (JavascriptExecutor) driver;
        jej.executeScript("arguments[0].scrollIntoView(true);", element11);

        if (driver.findElements(By.xpath(Utility.fetchLocator("PaymentHistoryAssertion_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Payment History was displayed was displayed");
        } else {
            test.log(Status.FAIL, "Payment History  was not displayed");
        }

        System.out.println("********************VIEW PAYMENT HISTORY TEST IS COMPLETED********************");
        driver.quit();
    }
}
