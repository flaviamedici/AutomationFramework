import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners(fExtentReportListener.class)

public class hfilters_sorting {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\IdeaProjects\\Testing101_\\drivers\\chromedriver.exe");

        // Instantiate ChromeDriver
        driver = new ChromeDriver();

        // Maximize the Chrome window
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://www.testing101.net/");

        //Use this line of code in case the test script is failed due to Consent Pop-up
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//p[text()='Consent']")).click();
    }

    @Test
    public void testPricesOrder() throws InterruptedException {
        Thread.sleep(2000);
        // Hover over the element by XPath
        WebElement element = driver.findElement(By.xpath("//li[@id='comp-jy5vlzj82']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(5000);

        // Click on the "Shop" element of the Java drop-down menu by XPath
        Thread.sleep(2000);
        WebElement shopElement = driver.findElement(By.xpath("//p[@id='comp-jy5vlzj8moreContainer5label']"));
        shopElement.click();
        Thread.sleep(2000);

        // Locate and click on the element by XPath
        Thread.sleep(2000);
        WebElement recommendedElement = driver.findElement(By.xpath("//button[@data-hook='floating-dropdown-button']"));
        recommendedElement.click();
        Thread.sleep(2000);

        // Locate and click on the 'Price (low to high)' option of the dropdown menu by XPath
        WebElement priceLowToHighOption = driver.findElement(By.xpath("//span[text()='Price (low to high)']"));
        priceLowToHighOption.click();
        Thread.sleep(2000);

        // Find all elements with data-wix-price attribute
        List<WebElement> priceElements = driver.findElements(By.cssSelector("[data-wix-price]"));

        // Convert and check that prices are displayed from low to high starting from the second element
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getAttribute("data-wix-price").replace("$", "").replace(",", ".");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }

        for (int i = 0; i < prices.size() - 1; i++) {
            Assert.assertTrue(prices.get(i) >= prices.get(i + 1), "Prices are not displayed in low to high order");
        }
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
