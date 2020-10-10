package com.Module;

import com.base.TestBase;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Registration_With_Matching_Password extends TestBase {

    @Test
    public void REGISTER_WITH_MATCHING_PASSWORD() throws IOException, InterruptedException {
        test = extent.createTest("REGISTRATION WITH MATCHING PASSWORD");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238/register/setup/3OwLfCgdoTqAZy2vHn%252BdV5cLGjELeEV%252F%252BgMTWp0xP6mpFVz%252BJhzVTiEc9%252FhMEjw%253D");
        test.log(Status.PASS, "Gmail .is fully loaded");

        driver.findElement(By.xpath(Utility.fetchLocator("Regpasswodone_XPATH"))).sendKeys(Utility.fetchLocator("RegPassword_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Regpasswordtwo_XPATH"))).sendKeys(Utility.fetchLocator("RegPassword_TEXT"));
        //driver.findElement(By.xpath(Utility.fetchLocator("RegContinueBtn_XPATH"))).click();


        System.out.println("********************REGISTRATION WITH MATCHING PASSWORD TEST********************");
        driver.quit();
    }
}
