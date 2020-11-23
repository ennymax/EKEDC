package com.ModuleEKEDC;

import com.base.TestBase;
import com.utility.*;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class WhistleBlowing extends TestBase {

    @Test
    public void WHISTLBLOWING() throws IOException, InterruptedException, AWTException {

        test = extent.createTest("WHISTLE BLOWING");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        RandomStuff randomStuff = new RandomStuff();
        FileUpload fileUpload = new FileUpload();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WhistlblowingBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("TellUs_XPATH"))).click();

        WebElement ele3 = driver.findElement(By.xpath(Utility.fetchLocator("BizzUnit_XPATH")));
        Select sel2 = new Select(ele3);
        sel2.selectByIndex(4);

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("AddressInputBox_XPATH"))).sendKeys(Utility.fetchLocator("Address_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NearestBusStop_XPATH"))).sendKeys(randomStuff.ListRandom());

        Thread.sleep(2000);
        WebElement ele3aa = driver.findElement(By.xpath(Utility.fetchLocator("SubCategory_XPATH")));
        Select sel2aa = new Select(ele3aa);
        sel2aa.selectByIndex(3);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CustomerName_XPATH"))).sendKeys(randomStuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Phoner_XPATH"))).sendKeys("08155341117");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("EkedpEmailer_XPATH"))).sendKeys(randomStuff.ListRandom() + "@gmail.com");

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("Summary_XPATH"))).sendKeys(Utility.fetchLocator("Summary_TEXT"));

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Discription_XPATH"))).sendKeys(Utility.fetchLocator("Discription_TEXT"));

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("EkedpUploader_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);

        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(Utility.fetchLocator("EkedpUploader_XPATH")))).click().build().perform();

        fileUpload.UploadAbove5MB();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Agrrere_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WhistleSubmit_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertWhistleBlowing_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Complaint was successfully Submitted");
        } else {
            test.log(Status.FAIL, "Complaint wasn't Submitted");
        }

        driver.quit();
    }
}
