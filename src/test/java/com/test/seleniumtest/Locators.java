package com.test.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Locators {

    @Test
    void findLocators(){
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

        chromeDriver.findElement(By.xpath("//h5[text()='Edit']//parent::a")).click();
        chromeDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("sha123@gmail.com");
        chromeDriver.findElement(By.xpath("//input[@type='text' and @value='Append ']")).sendKeys("hey this is me");

        chromeDriver.findElement(By.xpath("//input[@type='text' and @value='TestLeaf']")).sendKeys("testLeaf");
        chromeDriver.findElement(By.xpath("//input[@type='text' and @value='Clear me!!']")).sendKeys("clear it");

        chromeDriver.close();
    }

    @Test
    void findButtonLocators() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

        chromeDriver.findElement(By.xpath("//h5[text()='Button']//parent::a")).click();
        chromeDriver.findElement(By.xpath("//button[@id='home']")).click();

        Thread.sleep(2000);
        chromeDriver.close();
    }
}
