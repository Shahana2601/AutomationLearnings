import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IsEnabled {

    @Test
    void check() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_pushbutton_disabled2");
        driver.switchTo().frame("iframeResult");

        Thread.sleep(2000);
        WebElement button = driver.findElement(By.cssSelector("button#myBtn"));

        //isEnabled() value before clicking try it button
        boolean flag = button.isEnabled();

        System.out.println("My Button is enabled: " + flag);
        WebElement tryBtn = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryBtn.click();

        //isEnabled() value after clicking try it button
        boolean flag1 = button.isEnabled();
        System.out.println("My Button is enabled: " + flag1);

    }
}