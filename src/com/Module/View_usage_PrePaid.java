package com.Module;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class View_usage_PrePaid extends TestBase {
    @Test
    public void VIEW_USAGE_PREPAID() throws IOException, InterruptedException {

        test = extent.createTest("VIEW USAGE PRE-PAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.LoginPrePaid();

        driver.findElement(By.xpath(Utility.fetchLocator("View_Usage_XPATH"))).click();

        System.out.println("********************VIEW USAGE PRE-PAID TEST IS COMPLETED********************");
        driver.quit();
    }
}
