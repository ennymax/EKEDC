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

public class Make_Payment_Single_Account_Pay_By_Bank_PostPaid extends TestBase {

    @Test
    public void MAKE_PAYMENT_SINGLE_ACCOUNT_BY_BANK_POST_PAID() throws IOException, InterruptedException {
        test = extent.createTest("MAKE PAYMENT SINGLE ACCOUNT BY BANK POST PAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenShot = new ScreenShot(driver);

        login.Login();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("MakepAYMENTbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SingleAccountPayment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ss_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PrepaidPayByCard_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBuyTokenpage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Buy Token Page was Displayed");
        } else {
            test.log(Status.FAIL, "Buy Token Page wasnt Dispalyed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayMakePAyment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNowBTN_XPATH"))).click();

        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);

        if (driver.getTitle() == "Welcome to Central Pay") {
            test.log(Status.PASS, "Central Pay was Displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Central Pay page wasnt displayed and enabled");
        }

        driver.quit();
    }
}
