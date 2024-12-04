package com.test.seleniumtest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertAndPopUpHandler {

    @Test
    void handleAlertBoxPopUp() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

        chromeDriver.findElement(By.xpath("//h5[text()='Alert']//parent::a")).click();
        chromeDriver.findElement(By.xpath("//button[@onClick='normalAlert()']")).click();

        Thread.sleep(5000);

        Alert alert = chromeDriver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        //chromeDriver.close();
    }

    @Test
    void handleConfirmBoxPopUp() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

        chromeDriver.findElement(By.xpath("//h5[text()='Alert']//parent::a")).click();
        chromeDriver.findElement(By.xpath("//button[@onClick='confirmAlert()']")).click();

        Thread.sleep(5000);

        Alert alert = chromeDriver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    void handlePromptBoxPopUp() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

        chromeDriver.findElement(By.xpath("//h5[text()='Alert']//parent::a")).click();
        chromeDriver.findElement(By.xpath("//button[@onClick='confirmPrompt()']")).click();

        Thread.sleep(5000);

        Alert alert = chromeDriver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("test");
        alert.accept();
    }

    @Test
    void alertHandle() throws InterruptedException {
        WebDriver webDriver =  new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();

        webDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");
        webDriver.findElement(By.xpath("//h5[text()='Alert']//parent::a")).click();

        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//button[@onclick='confirmPrompt()']")).click();

        Alert alert = webDriver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("The elixr labs");
        alert.accept();
    }
}
