package com.Module;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class Add_Account_With_Wrong_Billing_ID_Prepaid extends TestBase {

    @Test
    public void ADD_ACCOUNT_WITH_WRONG_BILLING_PREPAID() throws InterruptedException, IOException {

        test = extent.createTest("ADD ACCOUNT WITH WRONG BILLING ID PRE-PAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        Login login = new Login(driver);

        login.Login();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AccountBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageAccountBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddAccountBTN_XPATH"))).click();

        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("AccountIndex_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(0);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddAccountContinueBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("AccountInput_XPATH"))).sendKeys(Utility.fetchLocator("WPpAccountNumber_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("CcontinueBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("WrongaccAssert_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Unable to validate customer Error Message was displayed successfully Displayed");
        } else {
            test.log(Status.FAIL, "Error message was not displayed");
        }

        System.out.println("********************Add account Wrong Billing ID billing Pre-Paid TEST IS COMPLETED********************");
        driver.quit();
    }
}
