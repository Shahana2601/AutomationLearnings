package com.test.seleniumtest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenShotHandler {

    @Test
    void generateScreenshot() throws IOException, InterruptedException {
        WebDriver chromeDriver =  new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        chromeDriver.get("https://www.google.com/");
        File src = ((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\shahana.shajahan\\Desktop\\AutomationLearnings\\Screenshots\\google.png"));

        Thread.sleep(2000);
        chromeDriver.quit();
    }
}
