import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class bSeleniumLocatorsXpathTest {
    private WebDriver driver;
    private String baseUrl = "https://www.testing101.net/seleniumlocators";

    @BeforeClass
    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\IdeaProjects\\Testing101_\\drivers\\chromedriver.exe");
        // Create a new instance of the Chrome driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the browser window
        driver = new ChromeDriver(options);
        //Use this line of code in case the test script is failed due to Consent Pop-up
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//p[text()='Consent']")).click();
    }


    @Test
    public void findElements() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\IdeaProjects\\Testing101_\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.testing101.net/seleniumlocatorsxpath");
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//select")).click();
        //driver.findElement(By.xpath("//button[@data-testid=\"buttonElemen\"]")).click();
        //driver.findElement(By.xpath("//span[text()='Submit']")).click();
        //driver.findElement(By.xpath("//*[text()='Submit']")).click();
        //driver.findElement(By.xpath("//*[contains(text(), 'terms')]")).click();
        //driver.findElement(By.xpath("//*[text() ='Submit' and @class='l7_2fn wixui-button__label']")).click();
        //driver.findElement(By.xpath("//select")).click();
        //driver.findElement(By.xpath("//*[text() = 'Personal' and @class='P6sHUt']")).click();
        //driver.findElement(By.xpath("//*[@id='input_comp-lkl9bex61']")).click();
    }
    @AfterClass
    public void tearDown() {
        // Close the browser window
        driver.quit();
    }
}
