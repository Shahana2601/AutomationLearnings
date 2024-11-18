import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BackAndForwardHandler{

    @Test
    void forwardAndBackMovement() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        chromeDriver.get("https://www.google.com/");
        chromeDriver.navigate().to("https://www.amazon.com/");

        chromeDriver.navigate().back();

        Thread.sleep(3000);
        chromeDriver.navigate().forward();

        Thread.sleep(3000);
        chromeDriver.navigate().back();
        chromeDriver.navigate().refresh();

        chromeDriver.close();
    }
}
