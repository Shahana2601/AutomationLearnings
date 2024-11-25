package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLauncher {
    public static void main(String[] args) throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver chromeDriver = new ChromeDriver();
       chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

       chromeDriver.manage().window().maximize();
       chromeDriver.manage().deleteAllCookies();

       Thread.sleep(2000);
       System.out.println(chromeDriver.getTitle());

       chromeDriver.quit();
    }
}
