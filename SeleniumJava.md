#### Input in chatGPT
**prompt**
>Write a user story with acceptance criteria for the "Find Elements" form on the https://www.testing101.net/seleniumlocators website, which consists of:
>1. First Name field: max length - 100 characters long
>2. Second Name field: max length - 100 characters long
>3. Email pattern field: pattern="^.+@.+\.[a-zA-Z]{2,63}$"
>4. Confirm email field pattern: pattern="^.+@.+\.[a-zA-Z]{2,63}$"

**prompt**
>Write me a positive test case for submitting the Find Elements Form on the https://www.testing101.net/seleniumlocators website, which consists of:
>1. First Name field: max length - 100 characters long
>2. Second Name field: max length - 100 characters long
>3. Email pattern field: pattern="^.+@.+\.[a-zA-Z]{2,63}$"
>4. Confirm email field pattern: pattern="^.+@.+\.[a-zA-Z]{2,63}$"

**prompt**
>Write a Selenium Java test script with test NG for opening the https://www.testing101.net/seleniumlocators webpage

### Install Java
Search for "java jdk"  
Select the newest version for jdk in the Oracle page, select Windows option, and x64 Installer  
Go to the Environment Variables  
Under System variables, select Path and click Edit button  
The Edit environment variable window will open. Click the New button and add the path to Java folder  
>C:\Program FIles\Java\jdk-20\bin  
Click Ok  

Under "User variables for User" click the New button  
The New User Variable windows open  
Variable name: JAVA_HOME  
Variable value: C:\ProgramFiles\Java\jdk-20  
Click Ok to save the changes  

CMD  
>java -version  

Setting up Selenium with Java in VS Code involves installing the necessary tools, extensions, and configuring a Java project to include the Selenium libraries and a web browser driver. A common approach is to use a Maven project for easy dependency management.  

Prerequisites  
Java Development Kit (JDK): Download and install the JDK from the Oracle website.  
Visual Studio Code: Download and install VS Code from the Microsoft website.  

Step-by-Step Setup Guide  
1. Install Java Extension Pack in VS Code   
This extension pack provides comprehensive Java language support, project management, and testing capabilities.   

Open VS Code.  
Go to the Extensions view (Ctrl+Shift+X).  
Search for "Extension Pack for Java" and click Install.   

2. Create a Maven Project  
Using Maven simplifies the process of adding Selenium dependencies.   

Open the Command Palette (Ctrl+Shift+P).  
Type "Java: Create Java Project" and select it.  
Choose "Maven" as the project type.  
Follow the prompts to select a location, enter a Group Id and Artifact Id (project name), and open the newly created project in a new window.  

3. Add Selenium Dependencies to pom.xml  
Once the project is open, you need to add the Selenium Java library dependency to the pom.xml file.  
In the Explorer, open the pom.xml file.  
Add the following dependency within the <dependencies> tag:   
```
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.x.x</version> <!-- Use the latest stable version -->
</dependency>
```

Save the file. Maven will automatically download the necessary libraries.  

4. Download Web Browser Driver  
You need a browser-specific driver (e.g., ChromeDriver for Google Chrome) to automate the browser.  

Download the appropriate driver from the official sources:  
[ChromeDriver] (https://developer.chrome.com/docs/chromedriver/downloads)  
[GeckoDriver(Firefox)] (https://github.com/mozilla/geckodriver/releases)  
Place the downloaded executable file in a central location on your computer.  
Optional: Add the driver's directory to your system's PATH environment variable for easier access. Alternatively, you can specify the path in your test code  

5. Write and Run Your First Selenium Script  
In your project's src/main/java (or src/test/java) folder, you can create a Java class with a main method to run a test script.  
Create a new Java file, for example, SeleniumTest.java.  
Add the following sample code, making sure to update the driver path if you didn't add it to the system PATH:  

```
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        // Set the path to your Chromedriver executable (if not in PATH)
        System.setProperty("webdriver.chrome.driver", "C:/path/to/your/chromedriver.exe"); // Example path for Windows

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        driver.get("https://www.google.com");

        // Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
```
Run the script by clicking the Run button that appears above the main method or by right-clicking the file in the Java Projects panel and selecting Run Java. 
A Chrome browser instance should open, navigate to Google, print the page title to the console, and then close.  

#### Selenium WebDriver Browser Options  
```options.addArguments("start-maximized");```  
The browser will start in maximized mode, meaning the browser window will open in full-screen size.  

```options.addArguments("--window-size=x,y");```  
The browser will launch the initial window size according to the specified parameters.  

```options.addArguments("--lang=en");```  
This line sets the language of the browser to English("en"). This option is used to simulate usersfrom different regions by setting the browser language accordingly  

```options.addArguments("--incognito");```  
The browser will open incognito mode or private browsing mode. In this mode, the browser will not store cookies, history, or any other data after the session is closed.  

```options.addArguments("--headless");```  
The browser will run in the background without displaying a graphical user interface (GUI). Ti is commonly used for automated testing or web scraping tasks where rendering the GUI is not necessary.  

```
public class BrowserOptionsTest {
    @Test
    public void openGoogleChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--start-maximize");
        //options.addArguments("--window-size=500,500");
        //options.addArguments("lang=fr");
        options.addArguments("lang=en");
        //options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.quit();

    }
}
```

### TestNG ###
TestNG is a testing framework for Java  
Designed to simplify a broad range of testing needs, from unit testing to integration testing. The NG in TestNG stands for "Next Generation." It provides powerful features and functionalities that make it particularly suitable for test automation in Java applications.  
  
In Selenium/Java, testNG is often used as the testing framework to organize and execute test cases efficiently by adding TestNG annotations, TestNG Assertions, Generate Reports, etc.  
  
In the context of Selenium/Java automation testing, TestNG assertions are used to validate Elements, Text, Attributes and other properties of web elements on a webpage.
The main assertion methods provides byTestNG include: Assert.assertEquals, Assert.assertNotEquals, Assert.assertTrue, Assert.assertFalse, Assert.assertNotNull, Assert.assertNull  
  
>Assert.assertEquals(actualValue, expectedValue)
When assertEquals is called, thestNG compares the actual and expected values. If they are equal, the test continues to execute without any interruption. However, if they are not equal, testNG marks the test as failed, and any subsequent code in the test method is not executed.  
  
>Assert.assertNotEquals(actualValue, expectedValue)  
When you use Assert.assertNotEquals(actualValue, expectedValue), testNG compares the actualValue with the expectedValue. If they are equal, the assertion fails, and testNG will mark the test as failed  
  
>Assert.assertTrue(condition)  
condition: this parameter represents the condition that you want to test. It can be any expression that returns a Boolean value  
  
>Assert.assertFalse(condition)  
In TestNG, this is an assertion method used to verify that a given condition is false. If the condition is true, the assertion fails, indicating that the expected condition does not hold true.  
  
>Assert.assertNotNull(Object object)  
In testing frameworks like TestNG or JUnit, this is an assertion method used to verify that a given object reference is not null. If the object reference is not null, the assertion passes. However, if the object reference is null, the test fails.  
  
>Assert.assertNull(Object object)  
In testing frameworks like TestNG or JUnit, this is an assertion method used to verify that a given object reference is null. If the object reference is indeed null, the assertion passes. However, if the object reference is not null, the test fails.

### Test Report for Selenium Java test script using TestNG 
A test report is a formal document that summarizes the results and findings of software testing activities. It provides stakeholders with essential information about the quality, functionality, and performance of the software being tested.  
  
#### TestNG Reporting features
Provides listeners that allow you to generate detailed HTML reports of your test executions  
Listeners allow users to monitor and customize the test execution process. These components enable developers and testers to perform various actions or capture events before, during, or after the execution of test cases.  
**ExtendReportListener**
It is a custom listener implementation designed to integrate ExtendReports with TestNG, allowing for enhanced reporting capabilities during test execution. This listener is particularly useful for generating rich and interactive HTML reports using the ExtendReports library in conjunction with TestNG-based test automation frameworks.  
ExtendReports library is an open-source reporting library for Java and .NET frameworks that provides enhanced reporting capabilities for test automation projects. It is commonly used in conjunction with testing frameworks such as TestNG, JUnit, and NUnit to generate detailed and visually appealing reports of test execution results.  

#### Integrate ExtendReports into Selenium/Java test script:
1. Add TestNG and ExtendReports dependencies to an integrated development environment  
[https://mvnrepository.com/artifact/com.aventstack/extentreports/5.0.9]
Add the following code to pom.xml
```
<!-- Source: https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.0.9</version>
    <scope>compile</scope>
</dependency>
```

2. Write and add the ExtendReports listeners class to the project
**prompt**
Give me an example of the ExtendReportListener
4. Add Report Generation object to the test script
