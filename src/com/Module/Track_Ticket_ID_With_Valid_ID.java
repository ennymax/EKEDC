package com.Module;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class Track_Ticket_ID_With_Valid_ID extends TestBase {

    @Test
    public void TRACK_VALID_ID_WITH_VALID_ID() throws InterruptedException, IOException {

        test = extent.createTest("TRACK TICKET ID WITH VALID ID");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Login login = new Login(driver);

        login.Login();

        driver.findElement(By.xpath(Utility.fetchLocator("NavigatetoHomepageBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("TIcketIDinput_XPATH"))).sendKeys(Utility.fetchLocator("ValidTicketID_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("TrackTicketIDBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTicketID_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Details of the Ticket ID was dispalyed");
        } else {
            test.log(Status.FAIL, "Details of the Ticket ID was not displayed");
        }

        // Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Scrowl1_XPATH")));
        je.executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(100);
        JavascriptExecutor jej = (JavascriptExecutor) driver;
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("Scrowl2_XPATH")));
        jej.executeScript("arguments[0].scrollIntoView(true);", element11);

        System.out.println("********************TRACK TICKET ID WITH VALID TEST IS COMPLETED********************");
        driver.quit();
    }
}
