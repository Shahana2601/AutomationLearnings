package com.test.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchTest {

    @Test
    void launchChrome(){
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://google.com");
        System.out.println(chromeDriver.getTitle());

        chromeDriver.quit();
    }
}
