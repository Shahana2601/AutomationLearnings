package com.test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ChromeLauncherTest {

    WebDriver chromeDriver;

    @BeforeMethod
    public void setUP(){
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();
        chromeDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        chromeDriver.get("https://google.com");
        System.out.println("before setup");
    }

    @Test(priority = 1,groups = "smoke")
    public void testChromeTitle(){
        String browserTitle = chromeDriver.getTitle();
        System.out.println(browserTitle);
    }

    @Test(priority = 2,groups = "regression ")
    public void mailLinkTest(){
        boolean b = chromeDriver.findElement(By.linkText("Gmail")).isDisplayed();
        //int i=9/0;
        System.out.println("test2");
    }

    @Test(priority = 3,groups = "Link test", dependsOnMethods = "mailLinkTest")
    public void logoDisplayTest(){
        boolean logo = chromeDriver.findElement(By.className("lnXdpd")).isDisplayed();
        System.out.println("test3");
    }

    @AfterMethod
    public void tearDown(){
        chromeDriver.quit();
        System.out.println("after teardown");
    }
}
