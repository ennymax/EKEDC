package com.utility;

import org.openqa.selenium.*;

import java.io.IOException;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void AcceptAlert() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null)//switches only if alert is displayed
        {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // alert.accept();
        }
    }

    public void AlertDismis() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    public void LoginMultipleAccount() throws IOException, InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("MultiEMail_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("MultiPassword_TEXT"));

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();
    }

    public void Login() throws IOException, InterruptedException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("ExistEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("password_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();
    }


    public void Login_with_RegEmail() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("ExistEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("password_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

    }

    public void Login_with_Wrong_Email() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("WrongEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

    }

    public void Login_with_Wrong_Password() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("WrongEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("WrongPassword_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

    }


    public void Login_PostPaidLandlord() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("EEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("EPassword_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();
    }

    public void LoginPrePaid() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("PreEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("PrePassword_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

    }

}
