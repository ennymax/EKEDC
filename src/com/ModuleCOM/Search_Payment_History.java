package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Search_Payment_History extends TestBase {
    @Test
    public void SEARCH_PAYMENT_HISTORY() throws IOException, InterruptedException {

        test = extent.createTest("SEARCH PAYMENT HISTORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.Login();

        driver.findElement(By.xpath(Utility.fetchLocator("PaymentHistory_XPATH"))).click();

        WebElement PayH = driver.findElement(By.xpath(Utility.fetchLocator("SearchPaymentHistory_XPATH")));
        PayH.clear();
        PayH.sendKeys(Utility.fetchLocator("TransactionID_TEXT"));
        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTransactionID_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search Payment History By Transaction ID Passed");
        } else {
            test.log(Status.FAIL, "Search Payment History By Transaction ID Failed");
        }

        PayH.clear();
        PayH.sendKeys(Utility.fetchLocator("Amount_TEXT"));
        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertAmount_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search Payment History By Amount Passed");
        } else {
            test.log(Status.FAIL, "Search Payment History By Amount Failed");
        }

        PayH.clear();
        PayH.sendKeys(Utility.fetchLocator("TransactionReference_TEXT"));
        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("PaymentHistoryAssertion_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search Payment History By Transaction Reference was successful");
        } else {
            test.log(Status.FAIL, "Search Payment History By Transaction Reference Failed");
        }

        System.out.println("********************SEARCH PAYMENT HISTORY TEST IS COMPLETED********************");
        driver.quit();
    }
}
