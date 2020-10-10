package com.Module;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;

public class Login_with_Wrong_Email extends TestBase {
    @Test
    public void LOGIN_WITH_WRONG_EMAIL() throws IOException {
        test = extent.createTest("LOGIN WITH WRONG EMAIL");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.Login_with_Wrong_Email();

        if (driver.findElements(By.xpath(Utility.fetchLocator("UserAlreadyExist_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Already Exist message was displayed Successfully");
        } else {
            test.log(Status.FAIL, "Already Exist message was not displayed Successfully");
        }

        System.out.println("********************Login with Wrong Email TEST IS COMPLETED********************");
        driver.quit();
    }
}
