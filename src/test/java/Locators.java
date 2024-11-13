import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Locators {

    @Test
    void findLocators(){
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        chromeDriver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("sha123@gmail.com");
        chromeDriver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("sha123");

        chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
    }
}
