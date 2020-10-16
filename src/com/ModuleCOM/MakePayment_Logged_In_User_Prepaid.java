package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Login;
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

public class MakePayment_Logged_In_User_Prepaid extends TestBase {

    @Test
    public void MAKE_PAYMENT_LOGGED_IN_USER_PREPAID() throws IOException, InterruptedException {

        test = extent.createTest("MAKE PAYMENT LOGGED IN USER PREPAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        login.LoginPrePaid();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("MakepAYMENTbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SingleAccountPayment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ss_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("PrepaidPayByCard_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PayMakePAyment_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("AgreePaymemtCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNowBTN_XPATH"))).click();

        System.out.println("********************MAKE PAYMENT USER LOGGED IN PREPAID TEST IS COMPLETED********************");
        driver.quit();
    }
}
