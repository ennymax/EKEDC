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

public class Complete_Reg_ValidBilling_PostPaid_Tenant extends TestBase {

    @Test
    public void COMPLETE_REG_VALID_BILLING_POSTPAID_TENANT() throws IOException, InterruptedException {
        test = extent.createTest("COMPLETE REGISTRATION VALID BILLING POST-POST PAID TENANT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.Login_PostPaidLandlord();

        driver.findElement(By.xpath(Utility.fetchLocator("AccountNumber_XPATH"))).sendKeys(Utility.fetchLocator("AccountNumber_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SubmitAccountNumber_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("TenantCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("FirstName_XPATH"))).sendKeys(Utility.fetchLocator("FirstName_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LastName_XPATH"))).sendKeys(Utility.fetchLocator("LastNAme_TEXT"));
        // driver.findElement(By.xpath(Utility.fetchLocator("AddAccountBTN_XPATH"))).click();

        System.out.println("********************COMPLETE REGISTRATION TEST VALID BILLING POSTPAID TENANT IS COMPLETED********************");
        driver.quit();
    }
}
