package com.test.testng;

import org.testng.annotations.*;

public class LaunchChromeTest {

    @BeforeSuite
    public void setUp(){
        System.out.println("Instantiate chrome browser!!");
    }

    @BeforeTest
    public void LaunchBrowser(){
        System.out.println("Launching the browser!!!");
    }

    @BeforeClass
    public void loginToApp(){
        System.out.println("login to app!!");
    }

    @BeforeMethod
    public void enterUrl(){
        System.out.println("enter the url!!");
    }

    @Test
    public void googleTitleTest(){
        System.out.println("title is google");
    }

    @AfterMethod
    public void pageLogout(){
        System.out.println("logging out from the page!!");
    }

    @AfterClass
    public void deleteAllCookies(){
        System.out.println("delete all the cookies!!");
    }

    @AfterTest
    public void closeBrowser(){
        System.out.println("Browser getting closed!!");
    }

    /*
        Instantiate chrome browser!!
        Launching the browser!!!
        login to app!!
        enter the url!!
        title is google
        logging out from the page!!
        delete all the cookies!!
        Browser getting closed!!
     */
}
