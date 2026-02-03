import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(fExtentReportListener.class)

public class eAssertionNotEqual {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        // Set the path to the chromedriver executable
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
    public void testCheckboxState() {
        try {
            // Find the checkbox using XPath
            WebElement checkbox = driver.findElement(By.xpath("//input[@data-testid='input' and @type='checkbox']"));

            // Scroll the checkbox into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

            // Verify the initial state of the checkbox
            Assert.assertNotEquals(checkbox.isSelected(), true, "Checkbox is initially checked");

            // Click on the checkbox
            checkbox.click();

            // Wait for a brief moment to see the effect (Optional)
            Thread.sleep(2000);

            // Verify the state of the checkbox after clicking
            Assert.assertNotEquals(checkbox.isSelected(), false, "Checkbox is not checked after clicking");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
