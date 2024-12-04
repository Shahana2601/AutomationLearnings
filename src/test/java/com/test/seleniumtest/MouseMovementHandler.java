package com.test.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseMovementHandler {

    @Test
    void handleMouseMovements() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");
        chromeDriver.findElement(By.xpath("//h5[text()='Mouse Hover']//parent::a")).click();

        Actions actions = new Actions(chromeDriver);
        Thread.sleep(2000);
        actions.moveToElement(chromeDriver.findElement(By.linkText("TestLeaf Courses"))).build().perform();

        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath("//a[@class='listener' and text()='Selenium']")).click();

        chromeDriver.switchTo().alert().accept();
    }
}
