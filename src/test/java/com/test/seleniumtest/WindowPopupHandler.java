package com.test.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPopupHandler {

    @Test
    void handlePopup() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

        Thread.sleep(2000);

        WebElement webElement1 = chromeDriver.findElement(By.xpath("//h5[text()='Window']//parent::a"));
        handleClickOn(chromeDriver,webElement1,Duration.ofSeconds(20));

        Thread.sleep(2000);

        WebElement webElement2 = chromeDriver.findElement(By.id("home"));
        handleClickOn(chromeDriver,webElement2,Duration.ofSeconds(20));

        Thread.sleep(2000);
        Set<String> handler = chromeDriver.getWindowHandles();

        Iterator<String> it = handler.iterator();
        String parentWindowId = it.next();
        System.out.println("parent window id : " + parentWindowId); //will give you first value

        String childWindowId = it.next();
        System.out.println("child window id : " + childWindowId );

        chromeDriver.switchTo().window(childWindowId);
        System.out.println("child window popup title " + chromeDriver.getTitle());

        chromeDriver.close();

        chromeDriver.switchTo().window(parentWindowId);
        System.out.println("parent window title " + chromeDriver.getTitle());
    }

    static void handleClickOn(WebDriver chromeDriver, WebElement webElement, Duration timeout){
        new WebDriverWait(chromeDriver,timeout).until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
}
