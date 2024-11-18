import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ElementVisibilityTest {

    @Test
    void handleElementVisibility() throws IOException, InterruptedException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:/Users/shahana.shajahan/Desktop/AutomationLearnings/src/test/resources/config.properties");
        properties.load(fileInputStream);

        String url = properties.getProperty("URL");
        String alertXpath = properties.getProperty("alert_xpath");
        String alertButtonXpath = properties.getProperty("alert_button_xpath");

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(url);

        //1. isDisplayed() method : applicable for all the elements.
        boolean b1 = chromeDriver.findElement(By.xpath("//h5[text()='Button']//parent::a")).isDisplayed();
        System.out.println(b1);

        //2. isEnabled() method :
        boolean b2 = chromeDriver.findElement(By.xpath("//button[@id='color']")).isEnabled();
        System.out.println(b2);
    }
}
