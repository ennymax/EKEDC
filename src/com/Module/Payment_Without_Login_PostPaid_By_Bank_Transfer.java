package com.Module;

import com.base.TestBase;
import com.utility.ScreenShot;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Payment_Without_Login_PostPaid_By_Bank_Transfer extends TestBase {

    @Test
    public void PAYMENT_WITHOUT_LOGIN_BANK_TRANSFER_POSTPAID() throws IOException, InterruptedException {

        test = extent.createTest("PAYMENT WITHOUT LOGIN BANK TRANSFER POSTPAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenShot = new ScreenShot(driver);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("MakePaymentBTNnotLogedIN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayBill_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("prepaidPayByCard_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PostPaidEnterAccountNumber_XPATH"))).sendKeys(Utility.fetchLocator("AccountNumber_TEXT"));

        Thread.sleep(2300);
        driver.findElement(By.xpath(Utility.fetchLocator("ContinueAccountNumber_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentEmail_XPATH"))).sendKeys(Utility.fetchLocator("Pemail_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        Thread.sleep(1200);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("PayByBankTr_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(3);

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("PrepaidMakePayment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowBaj_XPATH"))).click();

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();

        System.out.println("********************PAYMENT WITHOUT LOGIN BANK TRANSFER POSTPAID TEST IS COMPLETED********************");
        driver.quit();
    }
}
