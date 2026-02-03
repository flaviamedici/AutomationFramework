import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(fExtentReportListener.class)

public class gTesting101SearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\IdeaProjects\\Testing101_\\drivers\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the browser window
        driver = new ChromeDriver(options);

        // Navigate to the website
        driver.get("https://www.testing101.net/");

        //Use this line of code in case the test script is failed due to Consent Pop-up
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//p[text()='Consent']")).click();
    }

    @Test
    public void testSearchResultsContainChatGPT() {
        try {
            // Find the search input field using XPath
            WebElement searchInput = driver.findElement(By.xpath("//input[@id='input_search-box-input-comp-kr39u5ly']"));

            // Enter the search query
            searchInput.sendKeys("ChatGPT");

            // Submit the search
            searchInput.submit();

            // Wait for a few seconds to see the results
            Thread.sleep(3000);

            // Find all search result elements using XPath
            List<WebElement> searchResults = driver.findElements(By.xpath("//a[contains(@title, 'ChatGPT')][@data-hook='item-title']"));

            // Assert that each search result contains the text "ChatGPT"
            for (WebElement result : searchResults) {
                boolean containsChatGPT = result.getText().contains("ChatGPT");
                Assert.assertTrue(containsChatGPT, "Search result does not contain 'ChatGPT': " + result.getText());
                System.out.println("Search result contains 'ChatGPT': " + containsChatGPT);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
