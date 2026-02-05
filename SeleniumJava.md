Input in chatGPT
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

<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.x.x</version> <!-- Use the latest stable version -->
</dependency>
Save the file. Maven will automatically download the necessary libraries. 

4. Download Web Browser Driver 
You need a browser-specific driver (e.g., ChromeDriver for Google Chrome) to automate the browser. 

Download the appropriate driver from the official sources:
ChromeDriver https://developer.chrome.com/docs/chromedriver/downloads
GeckoDriver (Firefox) https://github.com/mozilla/geckodriver/releases
Place the downloaded executable file in a central location on your computer.
Optional: Add the driver's directory to your system's PATH environment variable for easier access. Alternatively, you can specify the path in your test code

5. Write and Run Your First Selenium Script 
In your project's src/main/java (or src/test/java) folder, you can create a Java class with a main method to run a test script. 
Create a new Java file, for example, SeleniumTest.java.
Add the following sample code, making sure to update the driver path if you didn't add it to the system PATH: 

>import org.openqa.selenium.WebDriver;
>import org.openqa.selenium.chrome.ChromeDriver;
>
>public class SeleniumTest {
>    public static void main(String[] args) {
>        // Set the path to your Chromedriver executable (if not in PATH)
>        System.setProperty("webdriver.chrome.driver", "C:/path/to/your/chromedriver.exe"); // Example path for Windows
>
>        // Initialize the ChromeDriver
>        WebDriver driver = new ChromeDriver();
>
>        // Navigate to a website
>        driver.get("https://www.google.com");
>
>        // Print the title of the page
>        System.out.println("Page title is: " + driver.getTitle());
>
>        // Close the browser
>        driver.quit();
>    }
>}

Run the script by clicking the Run button that appears above the main method or by right-clicking the file in the Java Projects panel and selecting Run Java. 
A Chrome browser instance should open, navigate to Google, print the page title to the console, and then close.
