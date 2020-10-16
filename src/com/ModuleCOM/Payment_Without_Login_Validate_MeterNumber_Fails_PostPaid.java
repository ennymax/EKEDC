package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Payment_Without_Login_Validate_MeterNumber_Fails_PostPaid extends TestBase {

    @Test
    public void PAYMENT_WITHOUT_LOGIN_VALIDATE_METER_NUMBER_FAILS_POSTPAID() throws IOException, InterruptedException {

        test = extent.createTest("PAYMENT WITHOUT LOGIN VALIDATE METER NUMBER FAILS POSTPAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        driver.findElement(By.xpath(Utility.fetchLocator("MakePaymentBTNnotLogedIN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PayBill_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PostPaidPayByCard_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PostPaidEnterAccountNumber_XPATH"))).sendKeys(Utility.fetchLocator("WrongAccountNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ContinueAccountNumber_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("UnableTovalidaTEaCCOUNTnUMBER_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Error Alert Unable to validate account Number Was Displayed Successfully");
        } else {
            test.log(Status.FAIL, "Error Message wasnt displayed");
        }

        System.out.println("********************PAYMENT WITHOUT LOGIN VALIDATE ACCOUNT NUMBER FAILS POSTPAID TEST IS COMPLETED********************");
        driver.quit();
    }
}
