import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitAndExplicitWait {

    @Test
    void implicitWait() {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

        Actions actions = new Actions(chromeDriver);
        actions.clickAndHold(chromeDriver.findElement(By.xpath("//button[@id='drag_source']")))
                .moveToElement(chromeDriver.findElement(By.xpath("//div[@id='drop_target']")))
                .release().build().perform();
    }
}
