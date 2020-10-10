package com.Module;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class View_Service_Alert_District extends TestBase {

    @Test
    public void VIEW_SERVICE_ALERT_HISTORY() throws IOException, InterruptedException {

        test = extent.createTest("VIEW SERVICE ALERT HISTORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        Login login = new Login(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.findElement(By.xpath(Utility.fetchLocator("View_XPATH"))).click();

        System.out.println("********************VIEW service ALERT HISTORY TEST IS COMPLETED********************");
        driver.quit();
    }
}
