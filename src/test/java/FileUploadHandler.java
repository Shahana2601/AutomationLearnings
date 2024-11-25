import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadHandler {

    @Test
    void handleFileUpload() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");
        chromeDriver.findElement(By.xpath("//h5[text()='Upload Files']//parent::a")).click();

        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath("//input[@type='file' and @name='filename']")).sendKeys("C:/Users/shahana.shajahan/Desktop/AutomationLearnings/Selenium_Logo.png");
    }
}
