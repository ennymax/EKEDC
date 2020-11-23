package com.ModuleEKEDC;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class View_Bill_History extends TestBase {
    @Test
    public void VIEW_BILLS_HISTORY() throws IOException, InterruptedException {

        test = extent.createTest("VIEW BILLS HISTORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.Login();

        driver.findElement(By.xpath(Utility.fetchLocator("Account_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("BillHistory_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBill_History_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Bill History Page was Displayed");
        } else {
            test.log(Status.FAIL, "Bill History page wasn't displayed");
        }

        driver.quit();
    }

}
