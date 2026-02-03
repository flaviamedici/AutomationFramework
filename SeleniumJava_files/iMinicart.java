import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(fExtentReportListener.class)

public class iMinicart {

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
        driver.findElement(By.xpath("//p[text()='Consent']")).click();
    }

    @Test
    public void testPricesOrder() throws InterruptedException {
        Thread.sleep(2000);
        // Hover over the element by XPath
        WebElement element = driver.findElement(By.xpath("//li[@id='comp-jy5vlzj82']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(4000);

        // Click on the "Shop" element of the Java drop-down menu by XPath
        WebElement shopElement = driver.findElement(By.xpath("//p[@id='comp-jy5vlzj8moreContainer5label']"));
        shopElement.click();
        Thread.sleep(5000);

        //Product1
        WebElement product1 = driver.findElement(By.xpath("//p[text()='ChatGPT']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product1);
        product1.click();
        Thread.sleep(5000);

        //Add to Cart
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(span, 'Add to Cart')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        addToCartButton.click();
        Thread.sleep(5000);

        // Assuming you have identified the iframe element
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        // Switching the driver's focus to the iframe
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
        // Now you can interact with elements inside the iframe
        // For example, if you want to click on an element inside the iframe
        driver.findElement(By.xpath("//button[@id='cart-widget-close']")).click();
        Thread.sleep(2000);
        // After you are done with actions inside the iframe, switch back to the default content
        driver.switchTo().defaultContent();

        //allProductsLink
        WebElement allProductsLink = driver.findElement(By.xpath("//a[text()='All Products']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allProductsLink);
        allProductsLink.click();
        Thread.sleep(2000);
        Thread.sleep(2000);

        //Product2
        WebElement product2 = driver.findElement(By.xpath("//p[text()='Latte']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product2);
        product2.click();
        Thread.sleep(5000);

        //Color picker
        new Actions(driver).click(driver.findElement(By.xpath("//input[@aria-label='Black']"))).perform();
        Thread.sleep(2000);

        //Add to cart1
        WebElement addToCartButton1 = driver.findElement(By.xpath("//button[@data-hook='add-to-cart']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton1);
        addToCartButton1.click();
        Thread.sleep(5000);

        // Assuming you have identified the iframe element
        iframeElement = driver.findElement(By.tagName("iframe"));

        // Switching the driver's focus to the iframe
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);

        // Get the web elements for order total and item prices
        WebElement orderTotalElement = driver.findElement(By.xpath("//div[@data-hook='cart-widget-total']"));
        WebElement itemPriceElement1 = driver.findElement(By.xpath("(//span[@data-hook='cart-widget-item-price'])[1]"));
        WebElement itemPriceElement2 = driver.findElement(By.xpath("(//span[@data-hook='cart-widget-item-price'])[2]"));

        // Get the text values of the elements
        String orderTotal = orderTotalElement.getText().trim();
        String itemPrice1 = itemPriceElement1.getText().trim();
        String itemPrice2 = itemPriceElement2.getText().trim();

        // Parse the text values to extract the numerical values
        double orderTotalValue = Double.parseDouble(orderTotal.replace("$", "").replace(",", ""));
        double itemPrice1Value = Double.parseDouble(itemPrice1.replace("$", "").replace(",", ""));
        double itemPrice2Value = Double.parseDouble(itemPrice2.replace("$", "").replace(",", ""));

        // Calculate the expected total
        double expectedTotal = itemPrice1Value + itemPrice2Value;

        // Assert that the order total equals the sum of the item prices
        Assert.assertEquals(orderTotalValue, expectedTotal, "Order total does not match the sum of item prices");

    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
