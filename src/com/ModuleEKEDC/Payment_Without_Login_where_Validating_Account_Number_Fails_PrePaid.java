package com.ModuleEKEDC;

import com.base.TestBase;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Payment_Without_Login_where_Validating_Account_Number_Fails_PrePaid extends TestBase {
    @Test
    public void PAYMENT_WITHOUT_LOGIN_VALIDATE_METER_NUMBER_FAILS_PREPAID() throws IOException, InterruptedException {

        test = extent.createTest("PAYMENT WITHOUT LOGIN VALIDATE METER NUMBER FAILS PREPAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        driver.findElement(By.xpath(Utility.fetchLocator("MakePaymentBTNnotLogedIN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("BuyToken_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PostPaidPayByCard_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PostPaidEnterAccountNumber_XPATH"))).sendKeys(Utility.fetchLocator("WrongAccountNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ContinueAccountNumber_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("UnableTovalidaTEaCCOUNTnUMBER_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Error Alert Unable to validate account Number Was Displayed Successfully");
        } else {
            test.log(Status.FAIL, "Error Message wasnt displayed");
        }

        driver.quit();
    }
}
