package com.test.datadriventest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FormSubmitTest {

    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        webDriver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
    }

    @DataProvider
    public void getTestData(){

    }

    @Test
    public void formSubmitTest(String fname, String lname, String phone, String country, String city, String email, String gender, String days, String time) throws InterruptedException {
        webDriver.findElement(By.id("RESULT_TextField-1")).sendKeys("Shahana");
        webDriver.findElement(By.id("RESULT_TextField-2")).sendKeys("Sha");
        webDriver.findElement(By.id("RESULT_TextField-3")).sendKeys("567890567856");
        webDriver.findElement(By.id("RESULT_TextField-4")).sendKeys("Qatar");
        webDriver.findElement(By.id("RESULT_TextField-5")).sendKeys("Doha");
        webDriver.findElement(By.id("RESULT_TextField-6")).sendKeys("shah123@gmail.com");
//        webDriver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_1']//following-sibling::label")).click();
//
//        webDriver.findElement(By.xpath("//input[@id='RESULT_CheckBox-8_0']//following-sibling::label")).click();
//        webDriver.findElement(By.xpath("//input[@id='RESULT_CheckBox-8_1']//following-sibling::label")).click();
//        webDriver.findElement(By.xpath("//input[@id='RESULT_CheckBox-8_2']//following-sibling::label")).click();

        Thread.sleep(2000);
        webDriver.findElement(By.id("FSsubmit"));
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
