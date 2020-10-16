package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;

public class Download_Bills extends TestBase {

    @Test
    public void Download_Bills() throws IOException, InterruptedException {

        test = extent.createTest("DOWNLOAD BILLS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.Login();

        driver.findElement(By.xpath(Utility.fetchLocator("ViewBill_XPATH"))).click();

        Thread.sleep(10000);
        System.out.println("*******************DOWNLOAD BILLS TEST IS COMPLETED********************");
        driver.quit();
    }
}
