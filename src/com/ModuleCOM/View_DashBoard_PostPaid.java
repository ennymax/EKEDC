package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class View_DashBoard_PostPaid extends TestBase {
    @Test
    public void VIEW_DASHBOARD_POSTPAID() throws IOException, InterruptedException {

        test = extent.createTest("VIEW DASHBOARD POSTPAID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        Login login = new Login(driver);

        login.Login();

        System.out.println("********************VIEW DASHBOARD POSTPAID TEST IS COMPLETED********************");
        driver.quit();
    }
}
