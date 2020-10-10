package com.Module;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Edit_PhoneNumber_On_Profile_Page extends TestBase {

    @Test
    public void EDIT_PHONE_NUMBER_ON_PROFILE_PAGE() throws IOException, InterruptedException {

        test = extent.createTest("EDIT PHONE NUMBER ON PROFILE PAGE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        Login login = new Login(driver);

        login.Login();

        driver.findElement(By.xpath(Utility.fetchLocator("ProfileBTN_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("EditProfile_XPATH"))).click();

        WebElement mj = driver.findElement(By.xpath(Utility.fetchLocator("PhoneNoInput_XPATH")));
        mj.clear();
        mj.sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("SavePhoneNumber_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertPhoneNumberChange_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Phone number was Changed Successfully");
        } else {
            test.log(Status.FAIL, "Phone Number cant be changed");
        }

        System.out.println("********************EDIT PHONE NUMBER ON PROFILE PAGE TEST IS COMPLETED********************");
        driver.quit();
    }

}
