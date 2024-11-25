import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameHandler {

    @Test
    void handleWebDriverFrame() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");
        chromeDriver.findElement(By.xpath("//h5[text()='Frame']//parent::a")).click();
        //chromeDriver.switchTo().frame("wrapframe");
        chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//div[@id='wrapframe']//child::iframe[@src='default.html']")));

        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath("//button[@id='Click']")).click();
        //Thread.sleep(3000);
        //chromeDriver.quit();
    }

    @Test
    void handleWebDriverFrame2() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");
        chromeDriver.findElement(By.xpath("//h5[text()='Frame']//parent::a")).click();
        chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//iframe[@src='page.html']")));
        chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//iframe [@src='nested.html']")));

        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath("//button[@id='Click1']")).click();
        //chromeDriver.switchTo().defaultContent(); // outermost frame
    }
}
