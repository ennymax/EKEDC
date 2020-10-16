package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Log_The_User_Out_After_30_Minute_Of_Inactivity extends TestBase {

    @Test
    public void LOG_THE_USER_OUT_AFTER_30_MINUTE_OF_INACTIVITY() throws IOException, InterruptedException {

        test = extent.createTest("LOG THE USER OUT AFTER 30 MINUTE OF IN ACTIVITY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        Login login = new Login(driver);

        login.Login();
        Thread.sleep(300);
        driver.navigate().refresh();

        System.out.println("********************LOG THE USER OUT AFTER 30 MINUTE OF INACTIVITY TEST IS COMPLETED********************");
        driver.quit();
    }
}
