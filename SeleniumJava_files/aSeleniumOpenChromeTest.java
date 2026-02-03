import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class aSeleniumOpenChromeTest {

    @Test
    public void openGoogleChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\SimpleAutomation\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/chrome/");
        Thread.sleep(10000);
        driver.quit();
    }
    
}
