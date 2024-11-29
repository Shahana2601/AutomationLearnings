package com.test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    WebDriver webDriver;

    @Test
    @Parameters({"env","browser","url","emailId"})
    public void yahooLoginTest(String env,String browser,String url, String emailId) throws InterruptedException {
        if (browser.equals("chrome")){
            webDriver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            webDriver = new FirefoxDriver();
        }

        webDriver.get(url);
        webDriver.findElement(By.id("login-username")).sendKeys(emailId);
        webDriver.findElement(By.xpath("//input[@id='login-signin' and @name='signin']")).click();

        Thread.sleep(2000);
        webDriver.quit();
    }
}
