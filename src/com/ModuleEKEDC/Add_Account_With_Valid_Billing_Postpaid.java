package com.ModuleEKEDC;

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

public class Add_Account_With_Valid_Billing_Postpaid extends TestBase {

    @Test
    public void ADD_ACCOUNT_WITH_VALID_BILLING_POSTPAID() throws InterruptedException, IOException {

        test = extent.createTest("ADD ACCOUNT WITH VALID BILLING POSTPAID");
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
        sel11.selectByIndex(1);

        driver.findElement(By.xpath(Utility.fetchLocator("AddAccountContinueBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AccountInput_XPATH"))).sendKeys(Utility.fetchLocator("AccountNumber_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CcontinueBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AassertDetails_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Account Details was successfully Displayed");
        } else {
            test.log(Status.FAIL, "Account Details wasn't displayed");
        }

        driver.quit();
    }
}
