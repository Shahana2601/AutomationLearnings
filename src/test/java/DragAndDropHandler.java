import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DragAndDropHandler {

    @Test
    void handleDragAndDrop(){
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();
    }
}
