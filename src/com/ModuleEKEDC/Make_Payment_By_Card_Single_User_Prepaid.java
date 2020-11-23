package com.ModuleEKEDC;

import com.base.TestBase;
import com.utility.Login;
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

public class Make_Payment_By_Card_Single_User_Prepaid extends TestBase {

    @Test
    public void MAKE_PAYMENT_BY_CARD_SINGLE_USER_PREPAID() throws IOException, InterruptedException {

        test = extent.createTest("MAKE PAYMENT BY CARD SINGLE USER PREPAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://staging-ekedp.convergenceondemand.net/");
       //driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.LoginPrePaid();

        driver.findElement(By.xpath(Utility.fetchLocator("MakepAYMENTbtn_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("SingleAccountPayment_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("apj_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PrePaidPayByCard_XPATH"))).click();


        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBuyTokenpage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Buy Token Page was Displayed");
        } else {
            test.log(Status.FAIL, "Buy Token Page wasnt Dispalyed");
        }
        Thread.sleep(3000);

        driver.findElement(By.xpath(Utility.fetchLocator("PayMakePAyment_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("ComfirmationPaymentPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Confirmation page was displayed");
        } else {
            test.log(Status.FAIL, "Comfirmation Page wasnt dispalyed");
        }

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("AgreePaymemtCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNowBTN_XPATH"))).click();

        driver.quit();
    }
}
