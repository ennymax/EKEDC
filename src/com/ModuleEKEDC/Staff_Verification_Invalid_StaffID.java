package com.ModuleEKEDC;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Staff_Verification_Invalid_StaffID extends TestBase {
    @Test
    public void STAFF_VERIFICATION_INVALID_STAFFID() throws IOException, InterruptedException {

        test = extent.createTest("STAFF VERIFICATION INVALID STAFF ID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        Login login = new Login(driver);

        login.Login();

        driver.findElement(By.xpath(Utility.fetchLocator("NavigatetoHomepageBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("StaffID_XPATH"))).sendKeys(Utility.fetchLocator("StaffIDINVALID_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("VerifyBTN_XPATH"))).click();


        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertWrongStaffID_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Incorrect Staff ID Error Message was displayed");
        } else {
            test.log(Status.FAIL, "Incorrect Staff ID Error Message was not displayed");
        }

        driver.quit();
    }
}
