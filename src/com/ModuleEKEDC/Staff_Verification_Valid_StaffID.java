package com.ModuleEKEDC;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Staff_Verification_Valid_StaffID extends TestBase {

    @Test
    public void STAFF_VERIFICATION_VALID_STAFF() throws IOException, InterruptedException {

        test = extent.createTest("STAFF VERIFICATION VALID STAFF");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.Login();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NavigatetoHomepageBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("StaffID_XPATH"))).sendKeys(Utility.fetchLocator("StaffID_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("VerifyBTN_XPATH"))).click();

        Thread.sleep(1000);
        JavascriptExecutor jej = (JavascriptExecutor) driver;
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("SrowltoViewStaff_XPATH")));
        jej.executeScript("arguments[0].scrollIntoView(true);", element11);

        Thread.sleep(4000);
        driver.quit();
    }
}
