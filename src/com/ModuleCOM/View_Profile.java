package com.ModuleCOM;

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

public class View_Profile extends TestBase {
    @Test
    public void VIEW_PROFILE() throws IOException, InterruptedException {

        test = extent.createTest("VIEW PROFILE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        Login login = new Login(driver);

        login.Login();

        driver.findElement(By.xpath(Utility.fetchLocator("ProfileBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertProfil_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Profile Page was Displayed");
        } else {
            test.log(Status.FAIL, "Profile Page was not displayed");
        }

        System.out.println("********************VIEW PROFILE TEST IS COMPLETED********************");
        driver.quit();
    }
}
