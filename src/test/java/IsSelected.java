import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IsSelected {

    @Test
    void isSelected() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");
        driver.switchTo().frame("iframeResult");
        Thread.sleep(2000);
        WebElement htmlBtn = driver.findElement(By.cssSelector("input#html"));

        //isSelected() value before selecting radio button
        boolean flag = htmlBtn.isSelected();
        System.out.println("HTML radio button is selected: " + flag);

        htmlBtn.click();

        //isSelected() value after selecting radio button
        boolean flag1 = htmlBtn.isSelected();
        System.out.println("HTML radio button is selected: " + flag1);
    }
}
