package com.ModuleCOM;

import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class View_Ticket_History_Logged_In_User_Mutiple_Account extends TestBase {

    @Test
    public void VIEW_TICKET_HISTORY_LOGGED_IN_MULTIPLE_USER() throws IOException, InterruptedException {

        test = extent.createTest("VIEW TICKET HISTORY LOGGED-IN MULTIPLE USER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://52.50.169.238");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        Login login = new Login(driver);

        login.LoginMultipleAccount();

        driver.findElement(By.xpath(Utility.fetchLocator("ComplaintsBTN_XPATH"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ClickOnTicketID2756127_XPATH"))));
        driver.findElement(By.xpath(Utility.fetchLocator("ClickOnTicketID2756127_XPATH"))).click();
        test.log(Status.FAIL, "Check ScreeShot below");

        driver.navigate().back();

        driver.findElement(By.xpath(Utility.fetchLocator("ClickOnTicketID3031683_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTictIDPr4sent_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Details Of the selected Ticket ID was Displayed");
        } else {
            test.log(Status.FAIL, "Details of the selected Ticket ID was not Displayed");
        }

        System.out.println("********************VIEW TICKET HISTORY LOGGED-IN MULTIPLE USER ACCOUNT TEST IS COMPLETED********************");
        driver.quit();
    }
}
