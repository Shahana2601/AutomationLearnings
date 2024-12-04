package com.test.assertion;

import com.test.datadriventest.ExcelDataSupplier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver webDriver;

    @Test(dataProvider = "getData", dataProviderClass = ExcelDataSupplier.class)
    public void adminLogin(String username, String password){
        webDriver = new ChromeDriver();
        Assert.assertEquals("true","false");

        webDriver.get("https://practicetestautomation.com/practice-test-login/");

        webDriver.findElement(By.id("username")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);

        webDriver.findElement(By.id("submit")).click();
        System.out.println("test passed");

        webDriver.quit();
    }
}
