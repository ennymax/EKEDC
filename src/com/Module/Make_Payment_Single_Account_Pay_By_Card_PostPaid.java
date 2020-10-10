package com.Module;

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
import java.util.concurrent.TimeUnit;

public class Make_Payment_Single_Account_Pay_By_Card_PostPaid extends TestBase {

    @Test
    public void MAKE_PAYMENT_SINGLE_ACCOUNT_BY_BANK_POST_PAID() throws IOException, InterruptedException {

        test = extent.createTest("MAKE PAYMENT SINGLE ACCOUNT BY BANK POST PAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        login.Login();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("MakepAYMENTbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SingleAccountPayment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("apj_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("postPaidPayByCard_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBuyTokenpage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Buy Token Page was Displayed");
        } else {
            test.log(Status.FAIL, "Buy Token Page wasnt Dispalyed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayMakePAyment_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("ComfirmationPaymentPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Confirmation page was displayed");
        } else {
            test.log(Status.FAIL, "Confirmation Page wasn't displayed");
        }

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("AgreePaymemtCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNowBTN_XPATH"))).click();

        System.out.println("********************MAKE PAYMENT SINGLE ACCOUNT BY BANK POST PAID TEST IS COMPLETED********************");
        driver.quit();
    }
}
