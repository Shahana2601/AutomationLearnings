import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropHandler {

    @Test
    void handleDragAndDrop() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://play1.automationcamp.ir/mouse_events.html");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        Thread.sleep(3000);
        Actions actions = new Actions(chromeDriver);
        actions.clickAndHold(chromeDriver.findElement(By.xpath("//button[@id='drag_source']")))
                .moveToElement(chromeDriver.findElement(By.xpath("//div[@id='drop_target']")))
                .release().build().perform();
    }
}
