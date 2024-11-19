package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLauncher {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver webDriver =  new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://google.com");
        Thread.sleep(2000);
        webDriver.quit();
    }
}
