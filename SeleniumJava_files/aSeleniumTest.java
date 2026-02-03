import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(fExtentReportListener.class)

public class aSeleniumTest {
    private WebDriver driver;
    private String baseUrl = "https://www.testing101.net/seleniumlocators";

    @BeforeClass
    public void setUp() {
        // Set the path to the chromedriv
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\IdeaProjects\\Testing101_\\drivers\\chromedriver.exe");
        // Create a new instance of the Chrome driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the browser window
        driver = new ChromeDriver(options);
    }

    @Test
    public void testOpenPage() throws InterruptedException {
        // Open the specified URL
        driver.get(baseUrl);
        //Use this line of code in case the test script is failed due to Consent Pop-up
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='Consent']")).click();
        Thread.sleep(1000); // Wait for 1 second after clicking Consent
        // Optional: Add test assertions or interactions here
        //First Name field
        driver.findElement(By.id("input_comp-lkl9bex61")).sendKeys("Testing");
        Thread.sleep(1000);
        //Last Name field
        driver.findElement(By.id("input_comp-lkl9bexd1")).sendKeys("101");
        Thread.sleep(1000);
        //Email field
        Thread.sleep(1000);
        driver.findElement(By.id("input_comp-lkl9bexf2")).sendKeys("example@example.com");
        //15%Scroll
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight * 0.15)");
        //Confirm Email field
        driver.findElement(By.id("input_comp-lkl9zef6")).sendKeys("example@example.com");
        Thread.sleep(1000);
        //Choose My Account Type drop-down menu
        driver.findElement(By.xpath("//select")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='P6sHUt' and text()='Personal']")).click();
        Thread.sleep(1000);
        //Terms and Conditions checkbox
        driver.findElement(By.xpath("//input[@data-testid='input']")).click();
        //Submit button
        driver.findElement(By.xpath("//span[text()='Submit']")).click();
        Thread.sleep(2000);

        // Find the success message element by XPath
        WebElement successMessage = driver.findElement(By.xpath("//span[@class='wixui-rich-text__text' and @style='color:#1D67CD;']"));
        // Assert that the success message is displayed
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed.");
    }
    @AfterClass
    public void tearDown() {
        // Close the browser window
        driver.quit();
    }
}
