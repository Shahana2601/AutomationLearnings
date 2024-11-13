import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LaunchCromeDriver {

    @Test
    void faceBookLogin(){
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://facebook.com/login");
        String chromeTitle = driver.getTitle();
        System.out.println(chromeTitle);
        //current url
        System.out.println(driver.getCurrentUrl());
        driver.close();

        //System.setProperty("webdriver.gecko.driver" , "geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://facebook.com/login");
        System.out.println(webDriver.getTitle());
        webDriver.close();

        if(chromeTitle.equals("Log in to Facebook")){
            System.out.println("It is correct title");
        }
        else {
            System.out.println("incorrect title");
        }
    }
}
