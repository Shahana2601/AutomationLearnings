package com.test.seleniumtest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {

    static WebDriver webDriver;
    @Test
    void handlePropFile() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:/Users/shahana.shajahan/Desktop/AutomationLearnings/src/test/resources/config.properties");
        properties.load(fileInputStream);

        String url = properties.getProperty("URL");
        String browserName = properties.getProperty("browser");

        System.out.println(url);
        System.out.println(browserName);

        if (browserName.equals("chrome")){
            webDriver = new ChromeDriver();
        }
        else if (browserName.equals("firefox")){
            webDriver = new FirefoxDriver();
        }

        webDriver.get(url);
    }

    @Test
    void handleAlertBoxWithConfig() throws IOException, InterruptedException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:/Users/shahana.shajahan/Desktop/AutomationLearnings/src/test/resources/config.properties");
        properties.load(fileInputStream);

        String url = properties.getProperty("URL");
        String alertXpath = properties.getProperty("alert_xpath");
        String alertButtonXpath = properties.getProperty("alert_button_xpath");

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(url);

        chromeDriver.findElement(By.xpath(alertXpath)).click();
        chromeDriver.findElement(By.xpath(alertButtonXpath)).click();

        Thread.sleep(3000);

        Alert alert = chromeDriver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

}
