package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsHandler {

    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver =  new ChromeDriver();
        webDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//h5[text()='Button']//parent::a")).click();
    }
}
