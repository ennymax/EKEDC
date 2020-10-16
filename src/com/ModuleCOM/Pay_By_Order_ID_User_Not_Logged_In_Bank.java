package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Pay_By_Order_ID_User_Not_Logged_In_Bank extends TestBase {

    @Test
    public void PAY_ORDER_ID_USER_NOT_LOGGED_IN_BANK() throws IOException, InterruptedException {

        test = extent.createTest("PAY ORDER ID BY BANK USER NOT LOGGED IN");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        driver.manage().timeouts().implicitlyWait(39, TimeUnit.SECONDS);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("MakePaymentBTNnotLogedIN_XPATH"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOrderID_XPATH"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("InputPayOrderID_XPATH"))).sendKeys(Utility.fetchLocator("OrderID_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("SubmitPaymentIDBTN_XPATH"))).click();

        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("MakePayementBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayByBank_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentEmail_XPATH"))).sendKeys(Utility.fetchLocator("Pemail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayPayBTN_XPATH"))).click();

        System.out.println("********************PAY BY ORDER ID USER NOT LOGGED IN (BANK) TEST IS COMPLETED********************");
        driver.quit();
    }
}
