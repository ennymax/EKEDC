package com.ModuleEKEDC;

import com.base.TestBase;
import com.utility.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class Remember_Me extends TestBase {

    @Test
    public void REMEMBER_ME() throws IOException, InterruptedException {

        test = extent.createTest("REMEMBER ME");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        Login login = new Login(driver);

        login.LoginMultipleAccount();

        driver.quit();
    }
}
