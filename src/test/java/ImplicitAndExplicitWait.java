import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitAndExplicitWait {

    @Test
    void implicitWait() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");
        chromeDriver.findElement(By.xpath("//h5[text()='Frame']//parent::a")).click();
        //chromeDriver.switchTo().frame("wrapframe");
        chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//div[@id='wrapframe']//child::iframe[@src='default.html']")));

        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath("//button[@id='Click']")).click();
    }
}
