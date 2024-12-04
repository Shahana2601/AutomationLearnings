package com.test.seleniumtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SvgElements {

    @Test
    void svgElements() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://127.0.0.1:5500/index.html");

        String color = chromeDriver.findElement(By.xpath("//*[name()='svg']//*[local-name()='circle']")).getAttribute("fill");
        System.out.println(color);

        String rectColor = chromeDriver.findElement(By.xpath("//*[name()='svg']//*[local-name()='rect']")).getAttribute("fill");
        System.out.println(rectColor);

        String text = chromeDriver.findElement(By.xpath("//*[name()='svg']//*[local-name()='text' and @id='pointline']")).getText();
        System.out.println(text);

        Thread.sleep(2000);
//        chromeDriver.switchTo().frame(chromeDriver.findElement(By.id("index.html-4f48d382-9965-f570-3cba-1746a6e2e9dc")));
//        chromeDriver.findElement(By.xpath("//*[name()='svg']//following-sibling::p[text()='Just drag with mouse to rotate it!']"));
    }
}
