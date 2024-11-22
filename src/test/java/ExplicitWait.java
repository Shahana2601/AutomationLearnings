import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicitWait {

    @Test
    void handleExplicitWait(){
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //chromeDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");
        WebElement buttonElement = chromeDriver.findElement(By.xpath("//h5[text()='Edit']//parent::a"));

        clickOn(chromeDriver, buttonElement, Duration.ofSeconds(10));

        WebElement inputFieldBox = chromeDriver.findElement(By.id("email"));
        sendKeys(chromeDriver,inputFieldBox, Duration.ofSeconds(10),"shah@123");
    }

    @Test
    void handleTextChange() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

        // Locate and click the 'Wait for Text Change' link
        WebElement textChangeElement = chromeDriver.findElement(By.xpath("//h5[text()='Wait for Text Change']//parent::a"));
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(20));
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(textChangeElement));
        clickableElement.click();

        // Locate the button that will change text
        WebElement buttonClickMe = chromeDriver.findElement(By.xpath("//button[@id='btn' and @onClick='clicked()']"));

        // Click the button and wait for the first alert
        clickableElement = wait.until(ExpectedConditions.elementToBeClickable(buttonClickMe));
        clickableElement.click();

        // Wait for the first alert to appear and accept it
        Alert changeAlert2 = wait.until(ExpectedConditions.alertIsPresent());
        changeAlert2.accept();

        Thread.sleep(2000);
        // Now, wait for the button text to change to "Click Me"
        wait.until(ExpectedConditions.textToBePresentInElement(buttonClickMe, "Click ME!"));

        // After the button text changes, click it again
        clickableElement = wait.until(ExpectedConditions.elementToBeClickable(buttonClickMe));
        clickableElement.click();

        Thread.sleep(2000);

        // Wait for the second alert to appear and accept it
        Alert changeAlert3 = wait.until(ExpectedConditions.alertIsPresent());
        changeAlert3.accept();

        chromeDriver.quit();
    }


    public static void sendKeys(WebDriver webDriver, WebElement webElement, Duration timeout, String value){
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.visibilityOf(webElement))
                .sendKeys(value);
    }

    public static void clickOn(WebDriver webDriver, WebElement webElement, Duration timeout){
        new WebDriverWait(webDriver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}
