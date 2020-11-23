package com.ModuleEKEDC;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;

public class Complete_Registration_Wrong_BillingID_Prepaid extends TestBase {


    @Test
    public void COMPLETE_REG_WRONG_BILLING_PREPAID() throws IOException, InterruptedException {
        test = extent.createTest("COMPLETE REGISTRATION WRONG BILLING ID PREPAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.Login_PostPaidLandlord();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AccountNumber_XPATH"))).sendKeys(Utility.fetchLocator("WPpAccountNumber_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SubmitAccountNumber_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("UnableError_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Unable to validate customer was displayed Successfully");
        } else {
            test.log(Status.FAIL, "Unable to validate was not displayed Successfully");
        }

        driver.quit();
    }

}
