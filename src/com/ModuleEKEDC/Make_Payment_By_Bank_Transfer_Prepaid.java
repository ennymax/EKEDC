package com.ModuleEKEDC;

import com.base.TestBase;
import com.utility.Login;
import com.utility.ScreenShot;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Make_Payment_By_Bank_Transfer_Prepaid extends TestBase {

    @Test
    public void MAKE_PAYMENT_LOGGED_IN_USER_PREPAID() throws IOException, InterruptedException {

        test = extent.createTest("MAKE PAYMENT LOGGED IN USER PREPAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenShot = new ScreenShot(driver);

        login.LoginPrePaid();

        driver.findElement(By.xpath(Utility.fetchLocator("MakepAYMENTbtn_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("SingleAccountPayment_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("apj_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PayByBankTransfer_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBuyTokenpage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Buy Token Page was Displayed");
        } else {
            test.log(Status.FAIL, "Buy Token Page wasn't Displayed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayMakePAyment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowNow_XPATH"))).click();

        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);
        if (driver.getTitle() == "Welcome to Central Pay") {
            test.log(Status.PASS, "Central Pay was Displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Central Pay page wasnt displayed and enabled");
        }

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();

        driver.quit();
    }
}
