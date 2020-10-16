package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class View_DashBoard_PrePaid extends TestBase {

    @Test
    public void VIEW_DASHBOARD_PREPAID() throws IOException {

        test = extent.createTest("VIEW DASHBOARD PRE-PAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.LoginPrePaid();

        System.out.println("********************VIEW DASHBOARD PRE-PAID TEST IS COMPLETED********************");
        driver.quit();
    }
}
