import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShadowDomHandler {

    @Test
    void executeShadowDom() {
        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();

        // Navigate to the page
        chromeDriver.get("http://127.0.0.1:5500/shadodom-example.html");

        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement root = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("custom-button")));
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;

        Object shadowRoot1 = js.executeScript("return arguments[0].shadowRoot", root);
        assert shadowRoot1 != null : "Shadow root 1 is null.";

        WebElement nestedContainer = (WebElement) js.executeScript("return arguments[0].querySelector('div.nested-container')", shadowRoot1);
        assert nestedContainer != null : "Nested container not found.";

        WebElement button = (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector('button#btn')", nestedContainer);
        assert button != null : "Button with ID 'btn' not found in the nested shadow DOM.";

        button.click();
        chromeDriver.quit();
    }

    @Test
    void chromeSettingsDomHandler() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("chrome://settings/appearance");
        WebElement element =  chromeDriver.findElement(By.xpath("//settings-ui")).getShadowRoot()
                .findElement(By.cssSelector("settings-main#main")).getShadowRoot()
                .findElement(By.cssSelector("settings-basic-page.cr-centered-card-container")).getShadowRoot()
                .findElement(By.cssSelector("settings-section[section='appearance']"))
                .findElement(By.tagName("settings-appearance-page")).getShadowRoot()
                .findElement(By.cssSelector("settings-toggle-button[label='Show bookmarks bar']")).getShadowRoot()
                .findElement(By.cssSelector("cr-toggle#control"));

        Thread.sleep(3000);
        element.click();
    }
}
