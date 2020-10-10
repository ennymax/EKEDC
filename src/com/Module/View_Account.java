package com.Module;

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

public class View_Account extends TestBase {

    @Test
    public void VIEW_ACCOUNT() throws IOException, InterruptedException {

        test = extent.createTest("VIEW ACCOUNT ");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.Login();

        Thread.sleep(2700);
        if (driver.findElements(By.xpath(Utility.fetchLocator("DashBoard_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Account Details was Displayed Successfully");
        } else {
            test.log(Status.FAIL, "Account Details was not displayed");
        }

        System.out.println("********************VIEW ACCOUNT TEST IS COMPLETED********************");
        driver.quit();
    }
}
