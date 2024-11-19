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
    void handleTextChange(){
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        chromeDriver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        chromeDriver.get("https://manojkumar4636.github.io/Selenium_Practice_Hub/home.html");

        WebElement textChangeElement = chromeDriver.findElement(By.xpath("//h5[text()='Wait for Text Change']//parent::a"));
        clickOn(chromeDriver, textChangeElement, Duration.ofSeconds(20));

        WebElement buttonClickMe = chromeDriver.findElement(By.xpath("//button[@id='btn' and @onClick='clicked()']"));
        clickOn(chromeDriver, buttonClickMe, Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

        Alert changeAlert2 = wait.until(ExpectedConditions.alertIsPresent());
        String alertText2 = changeAlert2.getText();

        // if (Objects.equals(alertText2, "Click ME!")){
        changeAlert2.accept();

//        Alert changeAlert1 = wait.until(ExpectedConditions.alertIsPresent());
//        changeAlert1.accept();
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
