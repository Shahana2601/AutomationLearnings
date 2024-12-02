package com.test.datadriventest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHrmLogin {

    WebDriver webDriver;

    @Test(dataProvider = "loginTestData")
    public void adminLogin(String username, String password){
        webDriver = new ChromeDriver();
        webDriver.get("https://practicetestautomation.com/practice-test-login/");

        webDriver.findElement(By.id("username")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);

        webDriver.findElement(By.id("submit")).click();
    }

    @DataProvider(name = "loginTestData")
    public Object[][] loginData(){
        Object[][] data = new Object[2][2];
        data[0][1] = "student";
        data[0][0] = "Password123";

        data[1][0] = "Test123";
        data[1][1] = "test123";

        return data;
    }
}
