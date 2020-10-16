package com.ModuleCOM;

import com.base.TestBase;
import com.utility.BrokenLink;
import com.utility.Login;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_with_Registered_Email extends TestBase {

    @Test
    public void LOGIN_WITH_REGISTERED_EMAIL() throws IOException, InterruptedException {
        test = extent.createTest("LOGIN WITH REGISTERED EMAIL");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");


        BrokenLink brokenLink = new BrokenLink(driver);
        Login login = new Login(driver);

        login.Login_with_RegEmail();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertDashBoard_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Already Exist message was displayed Successfully");
        } else {
            test.log(Status.FAIL, "Already Exist message was not displayed Successfully");
        }

        System.out.println("********************Login with registered Email TEST IS COMPLETED********************");
        driver.quit();
    }
}
