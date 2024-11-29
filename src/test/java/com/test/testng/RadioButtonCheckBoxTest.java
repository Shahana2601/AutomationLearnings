package com.test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RadioButtonCheckBoxTest {

    WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void radioCheck() throws InterruptedException {
        webDriver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']//following-sibling::label")).click();
        Thread.sleep(3000);

        webDriver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_1']//following-sibling::label")).click();
        Thread.sleep(3000);

        webDriver.findElement(By.id("FSsubmit")).click();
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
