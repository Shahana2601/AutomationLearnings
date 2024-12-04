import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LaunchFireFoxDriver {
    @Test
    void faceBookLogin(){
        //System.setProperty("webdriver.gecko.driver" , "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://facebook.com/login");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
