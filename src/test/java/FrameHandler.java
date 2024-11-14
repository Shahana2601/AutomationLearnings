import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameHandler {

    @Test
    void handleWebDriverFrame(){
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");
        chromeDriver.findElement(By.xpath("//h5[text()='Frame']//parent::a")).click();

    }
}
