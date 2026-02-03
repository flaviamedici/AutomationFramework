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

public class eAssertionNotNull {
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
    public void testInputField() {
        try {
            // Locate the input element using XPath
            WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='first-name']"));

            // Perform any actions you want with the input element, for example, enter text
            firstNameInput.sendKeys("John");

            // Pause briefly to see the result
            Thread.sleep(2000);

            // Assert that maxlength attribute is not null
            Assert.assertNull(firstNameInput.getAttribute("maxlength"), "Maxlength attribute is not null");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An exception occurred: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
