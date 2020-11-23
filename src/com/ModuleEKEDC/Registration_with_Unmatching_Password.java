package com.ModuleEKEDC;

import com.base.TestBase;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Registration_with_Unmatching_Password extends TestBase {

    @Test
    public void REGISTER_WITH_UNMATCHED_PASSWORD() throws IOException, InterruptedException {
        test = extent.createTest("REGISTRATION WITH UNMATCHED PASSWORD");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238/register/setup/3OwLfCgdoTqAZy2vHn%252BdV5cLGjELeEV%252F%252BgMTWp0xP6mpFVz%252BJhzVTiEc9%252FhMEjw%253D");
        test.log(Status.PASS, "Password Change page fully loaded");

        driver.findElement(By.xpath(Utility.fetchLocator("Regpasswodone_XPATH"))).sendKeys(Utility.fetchLocator("RegPassword_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Regpasswordtwo_XPATH"))).sendKeys(Utility.fetchLocator("UmatchedPassword_XPATH"));
        driver.findElement(By.xpath(Utility.fetchLocator("RegContinueBtn_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("ErrorPasswordAssert_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Unmatched Password Field error was displayed");
        } else {
            test.log(Status.FAIL, "Unmatched Password Field was not displayed");
        }

        driver.quit();
    }
}
