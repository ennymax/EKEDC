package com.ModuleCOM;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class Remove_Account extends TestBase {

    @Test
    public void REMOVE_ACCOUNT() throws InterruptedException, IOException {

        test = extent.createTest("REMOVE ACCOUNT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        Login login = new Login(driver);

        login.Login();

        driver.findElement(By.xpath(Utility.fetchLocator("AccountBTN_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("ManageAccountBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("AddAccountBTN_XPATH"))).click();

        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("AccountIndex_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(0);

        driver.findElement(By.xpath(Utility.fetchLocator("AddAccountContinueBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("AccountInput_XPATH"))).sendKeys(Utility.fetchLocator("NewAccount_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("CcontinueBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AassertDetails_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Account Details was successfully Displayed");
        } else {
            test.log(Status.FAIL, "Account Details wasn't displayed");
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AddTheAccountBTN_XPATH"))));
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("AddTheAccountBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AccountAccountBNT_XPATH"))));
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("AccountAccountBNT_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("DeleteAccountBTN_XPATH"))));
        WebElement element2 = driver.findElement(By.xpath(Utility.fetchLocator("DeleteAccountBTN_XPATH")));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", element2);

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("DeleteACCT_XPATH"))));
        WebElement element3 = driver.findElement(By.xpath(Utility.fetchLocator("DeleteACCT_XPATH")));
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("arguments[0].click();", element3);

        System.out.println("********************Remove Account TEST IS COMPLETED********************");
        driver.quit();
    }
}