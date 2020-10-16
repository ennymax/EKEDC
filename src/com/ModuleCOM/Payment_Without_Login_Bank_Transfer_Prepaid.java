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

public class Payment_Without_Login_Bank_Transfer_Prepaid extends TestBase {

    @Test
    public void PAYMENT_WITHOUT_LOGIN_BANK_TRANSFER_PREPAID() throws IOException, InterruptedException {

        test = extent.createTest("PAYMENT WITHOUT LOGIN BANK TRANSFER PREPAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        driver.findElement(By.xpath(Utility.fetchLocator("MakePaymentBTNnotLogedIN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("BuyToken_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PrepaidByBankTransfer_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PostPaidEnterAccountNumber_XPATH"))).sendKeys(Utility.fetchLocator("PpAccountNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ContinueAccountNumber_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentEmail_XPATH"))).sendKeys(Utility.fetchLocator("Pemail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        Thread.sleep(3000);

        driver.findElement(By.xpath(Utility.fetchLocator("PrepaidMakePayment_XPATH"))).click();

        Thread.sleep(3000);

        if (driver.findElements(By.xpath(Utility.fetchLocator("ConfirmPaymentPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Confirmation page was displayed");
        } else {
            test.log(Status.FAIL, "Comfirmation Page wasnt dispalyed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("PayNowNow_XPATH"))).click();

        System.out.println("********************PAYMENT WITHOUT LOGIN BANK TRANSFER PREPAID TEST IS COMPLETED********************");
        driver.quit();
    }
}
