import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class cSeleniumLocatorsXpathTestWithChatGTP {
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
    public void testOpenPage() throws InterruptedException {
        // Open the specified URL
        driver.get(baseUrl);
        // Optional: Add test assertions or interactions here
        //driver.findElement(By.xpath("//*[@id='input_comp-lkl9bex61']")).click();
        //driver.findElement(By.xpath("//select[contains(@class, 'wixui-dropdown__input')]")).click();
        //Thread.sleep(1000);
        //driver.findElement(By.xpath("//option[text()='Personal' and @class='R4tv1w']")).click();
        //Thread.sleep(1000);
        //Thread.sleep(1000);
        //driver.findElement(By.xpath("//input[@id='input_comp-lkl9bexf2' and @name='email']")).click();
        //Thread.sleep(2000);
        //Thread.sleep(1000);
        //driver.findElement(By.xpath("//select[@class='wixui-dropdown__input McLPII has-custom-focus T6F83Z']")).click();
        //Thread.sleep(1000);
        //driver.findElement(By.xpath("//div[@class='P6sHUt' and text()='Personal']")).click();
        //Thread.sleep(5000);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='uDW_Qe wixui-button PlZyDq']//span[text()='Submit']")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser window
        driver.quit();
    }
}
