package com.Module;

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

public class Registration_with_incomplete_PhoneNumber extends TestBase {

    @Test
    public void REGISTRATION_INCOMPLETE_PHONE_NUMBER() throws IOException, InterruptedException {
        test = extent.createTest("REGISTRATION INCOMPLETE PHONE NUMBER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        driver.findElement(By.xpath(Utility.fetchLocator("RegisterBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("RegEmail_XPATH"))).sendKeys(Utility.fetchLocator("Regemail_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("RegNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegINnvalidnumber_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("RegCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

        System.out.println("********************REGISTRATION WITH INCOMPLETE PHONE NUMBER TEST IS COMPLETED********************");
        driver.quit();
    }
}
