import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(fExtentReportListener.class)

public class eAssertionFalse {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\IdeaProjects\\Testing101_\\drivers\\chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://www.testing101.net/seleniumlocators");
        //Use this line of code in case the test script is failed due to Consent Pop-up
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//p[text()='Consent']")).click();
    }

    @Test
    public void testFillEmailFields() {
        // Find the first Email field using XPath
        WebElement emailField = driver.findElement(By.xpath("//input[@id='input_comp-lkl9bexf2']"));

        // Fill in the first Email field
        emailField.sendKeys("example@example.com");

        // Find the Confirm Email field using XPath
        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@id='input_comp-lkl9zef6']"));

        // Fill in the Confirm Email field
        confirmEmailField.sendKeys("ex@example.com");

        // Get the values of both fields
        String emailValue = emailField.getAttribute("value");
        String confirmEmailValue = confirmEmailField.getAttribute("value");

        // Assert whether the values are the same
        Assert.assertFalse(emailValue.equals(confirmEmailValue), "Email and Confirm Email values are not the same.");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
