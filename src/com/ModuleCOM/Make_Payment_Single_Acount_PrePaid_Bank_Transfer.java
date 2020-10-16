package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Login;
import com.utility.ScreenShot;
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
import java.util.concurrent.TimeUnit;

public class Make_Payment_Single_Acount_PrePaid_Bank_Transfer extends TestBase {

    @Test
    public void MAKE_PAYMENT_SINGLE_ACCOUNT_BY_BANK_PREPAID() throws IOException, InterruptedException {

        test = extent.createTest("MAKE PAYMENT SINGLE ACCOUNT BY BANK PRE-PAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenShot = new ScreenShot(driver);

        Login login = new Login(driver);

        login.LoginPrePaid();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("MakepAYMENTbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SingleAccountPayment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ss_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PrepaidPayByCard_XPATH"))).click();

        Thread.sleep(1200);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("PayByBankTr_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(3);

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("SingleAccountMake_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowBaj_XPATH"))).click();

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

        System.out.println("********************MAKE PAYMENT SINGLE ACCOUNT BY BANK PRE-PAID TEST IS COMPLETED********************");
        driver.quit();
    }
}
