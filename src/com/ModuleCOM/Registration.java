package com.ModuleCOM;

import com.base.TestBase;
import com.utility.BrokenLink;
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

public class Registration extends TestBase {
    @Test
    public void REGISTRATION() throws IOException, InterruptedException {
        test = extent.createTest("REGISTRATION");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        BrokenLink brokenLink = new BrokenLink(driver);

        driver.findElement(By.xpath(Utility.fetchLocator("RegisterBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("RegEmail_XPATH"))).sendKeys(Utility.fetchLocator("Regemail_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("RegNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("RegCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertRegistration_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Registration was successful");
        } else {
            test.log(Status.FAIL, "Registration failed");
        }

        System.out.println("********************REGISTRATION TEST IS COMPLETED********************");
        driver.quit();
    }
}
