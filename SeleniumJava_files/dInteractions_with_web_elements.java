import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class dInteractions_with_web_elements {
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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\andrii.kuchyrenko\\IdeaProjects\\Testing101_\\drivers\\chromedriver.exe");
        driver.get("https://www.testing101.net/seleniumlocators");
        //Click on element
        //driver.findElement(By.xpath("//input[@data-testid='input']")).click();
        //Send key
        //driver.findElement(By.xpath("//input[@name='first-name' and contains(@id, 'input_comp')]"))
                //.sendKeys("Testing");
        //Clear
        //driver.findElement(By.xpath("//input[@name='first-name' and contains(@id, 'input_comp')]"))
                //.clear();
        //Thread.sleep(5000);
        //Submit
        //driver.findElement(By.xpath("//form[@id='comp-lkl9beww']"))
                //.submit();
    }
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

