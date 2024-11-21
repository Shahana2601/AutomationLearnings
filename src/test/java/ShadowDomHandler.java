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

        // Wait for the custom-button element to be visible in the DOM
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement root = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("custom-button")));

        // Use JavascriptExecutor to access the shadow root of the custom-button
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;

        // Access the shadow root of the custom-button
        Object shadowRoot1 = js.executeScript("return arguments[0].shadowRoot", root);

        // Check if the shadow root is found
        assert shadowRoot1 != null : "Shadow root 1 is null.";

        // Now access the nested shadow root inside the first shadow root
        WebElement nestedContainer = (WebElement) js.executeScript("return arguments[0].querySelector('div.nested-container')", shadowRoot1);

        // Check if the nested container is found
        assert nestedContainer != null : "Nested container not found.";

        // Now locate the button inside the nested container in the shadow DOM
        WebElement button = (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector('button#btn')", nestedContainer);

        // Check if the button is found
        assert button != null : "Button with ID 'btn' not found in the nested shadow DOM.";

        // Perform the click action on the button
        button.click();

        // Optionally, validate further actions or behavior after clicking the button
        // For example, verify if clicking the button causes some expected result.

        // Close the browser after test execution
        chromeDriver.quit();
    }
}



//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class ShadowDomHandler {
//
//    @Test
//    void executeShadowDom() {
//        // Setup WebDriver for Chrome
//        WebDriverManager.chromedriver().setup();
//        WebDriver chromeDriver = new ChromeDriver();
//
//        // Navigate to the page
//        chromeDriver.get("http://127.0.0.1:5500/shadodom-example.html");
//
//        // Wait for the custom-button element to be visible in the DOM
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
//        WebElement root = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("custom-button")));
//
//        // Use JavascriptExecutor to access the shadow root of the custom-button
//        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
//
//        // Access the shadow root without casting it to a WebElement
//        Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", root);
//
//        // Assert the shadow root is found (it will be of type ShadowRoot, not WebElement)
//        assert shadowRoot != null : "Shadow DOM root is null.";
//
//        // Now, using JavaScript, find an element within the shadow root
//        WebElement nestedContainer = (WebElement) js.executeScript("return arguments[0].querySelector('div.nested-container')", shadowRoot);
//
//        // Ensure the element exists in the shadow DOM
//        assert nestedContainer != null : "Nested container not found.";
//
//        // Find the button inside the nested container inside the shadow DOM
//        WebElement button = nestedContainer.findElement(By.cssSelector("#btn"));
//
//        // Perform actions on the button, such as clicking it
//        button.click();
//
//        // Optionally, validate further actions or behavior after clicking the button
//        // For example, verify if clicking the button causes some expected result.
//
//        // Close the browser after test execution
//        chromeDriver.quit();
//    }
//}
