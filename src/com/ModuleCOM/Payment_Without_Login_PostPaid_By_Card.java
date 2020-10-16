package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Payment_Without_Login_PostPaid_By_Card extends TestBase {
    @Test
    public void PAYMENT_WITHOUT_LOGIN_BANK_CARD_PREPAID() throws IOException, InterruptedException {

        test = extent.createTest("PAYMENT WITHOUT LOGIN BANK TRANSFER POSTPAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        driver.findElement(By.xpath(Utility.fetchLocator("MakePaymentBTNnotLogedIN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PaybyCard_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("prepaidPayByCard_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PostPaidEnterAccountNumber_XPATH"))).sendKeys(Utility.fetchLocator("AccountNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ContinueAccountNumber_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentEmail_XPATH"))).sendKeys(Utility.fetchLocator("Pemail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("PrepaidMakePayment_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("ConfirmPaymentPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Confirmation page was displayed");
        } else {
            test.log(Status.FAIL, "Comfirmation Page wasnt dispalyed");
        }

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("AgreePaymemtCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNowBTN_XPATH"))).click();

        System.out.println("********************PAYMENT WITHOUT LOGIN BANK TRANSFER POSTPAID TEST IS COMPLETED********************");
        driver.quit();
    }
}
