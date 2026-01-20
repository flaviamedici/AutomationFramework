Setting up Playwright/JavaScript environment
- Install Node.js, VSCode, and Git Bash

Playwright
- Open Git bash: npm init playwright@latest
- Open project folder in VSCode

#### Write test script

tests/example.spec.js 

#### Setup configurations

Find playwright.config.js is a configuration file used in Playwright to define various settings and options that control how your tests are executed.
It's essentially the command center for your test suite.
- Choose your browser in the playwright.config.js file. Delete the ones you don't need
package.json file is a vital component in Node.js projects. It serves as a manifest file, containing key details about your project such as: Project Metadata, Dependencies, Scripts
In package.json, the script configuration tells Node.js to run Playwright tests in headless mode when you execute the npm test command.
> "scripts": {
>   "test": "playwright test --headed"
> },

#### Run test scripts
open folder in Git Bash
> npm run test

Use await page.pause() to pause the script while running

Write a manual test case for the test scenario that you want to automate
Positive scenario: Login with valid credentials
1. Navigate to the www.testing101.net/ website
2. Click on the Login button on the header
3. Click on the Login button on the Signup page
4. Input valid data into the Email field
5. Input valid data into the Password field
6. Click on the Login button of the Login form
   **Expected result:** The user is successfully logged on the testing website
Next step: Write a JS/Playwright script
Under the tests folder, create a new file "1Login.spec.js"

Open chatGPT and type: "Write JS/Playwright test script to open the https://www.testing101.net/

Playwright Inspector: can provide suggestions for the locators for the elements you interact with. This saves time and ensures that the generated locators are optimized for stability and accuracy
Add the command: await page.pause()
Click the option to Pick Locator -> hover the mouse over the Consent button and click on it
With the locator generated, go back to chatGPT and type Write a single line of JS.Playwright code to click on the button button.clasName

test('Login with valid credentials', async ({ page }) => {
// Navigate to the Testing101 website
await page.goto('https://www.testing101.net/');
await page.waitForTimeout(5000);
//Click on the Consent button on Cookie pop-up
//await page.getByLabel('Consent', { exact: true }).click();
//Click on the Login button on the header
await page.getByRole('button', { name: 'Log In' }).click();
//Click on the Login button on the Signup page
await page.getByTestId('signUp.switchToSignUp').click();
//Input valid data into the Email field
await page.getByLabel('Email').fill('andriitest7799@gmail.com');
//Input valid data into the Password field
await page.getByLabel('Password').fill('Aa123_123');
//Click on the Login button of the Login form
await page.getByTestId('buttonElement').click();

Add assertion to the script
Assertions are crucial for validating that the script is producing the correct results. They help ensure the automated test is passing or failing based on predefined conditions
**prompt**: Add js/playwright assertion to check if this menu is displayed after login
getByLabel('andriitest7799 account menu')
// Assertion: Check if 'andriitest7799 account menu' is visible after login
await expect(page.getByTestId('handle-button')).toBeVisible();
});

How a QA Enginenr can automate and run multiple login scenarions?
1. Write manual test cases for the test scenarios that you want to automate

Negative scenarios
- Login with an empty Login Form field
- Login with an empty email field
- Login with an empty password field
- Login with an invalid format of the email
- Log In with an incorrect password
- Log In with a non-existent user email

test('Login with empty fields of the login form', async ({ page }) => {
// Navigate to the Testing101 website
await page.goto('https://www.testing101.net/');
await page.waitForTimeout(5000);
//Click on the Consent button on Cookie pop-up
//await page.getByLabel('Consent', { exact: true }).click();
//Click on the Login button on the header
await page.getByRole('button', { name: 'Log In' }).click();
//Click on the Login button on the Signup page
await page.getByTestId('signUp.switchToSignUp').click();

//Click on the Login button of the Login form
await page.getByTestId('buttonElement').click();

// Assertion: Check for error messages for both Email and Password fields
await expect(page.getByText('Email cannot be blank')).toBeVisible();
await expect(page.getByText('Make sure you enter a password.')).toBeVisible();

});

To run only one single test inside a js file add .only
for example
test.only('Login with invalid email format', async ({ page }) => {
// Navigate to the Testing101 website
await page.goto('https://www.testing101.net/');
await page.waitForTimeout(5000);
//Click on the Consent button on Cookie pop-up
//await page.getByLabel('Consent', { exact: true }).click();
//Click on the Login button on the header
await page.getByRole('button', { name: 'Log In' }).click();
//Click on the Login button on the Signup page
await page.getByTestId('signUp.switchToSignUp').click();
//Input valid data into the Email field
await page.getByLabel('Email').fill('andriitest7799%gmail.com');
//Input valid data into the Password field
await page.getByLabel('Password').fill('Aa123_123');
//Click on the Login button of the Login form
await page.getByTestId('buttonElement').click();

// Assertion: Check for error messages for both Email field
await expect(page.getByText('Double check your email and try again.')).toBeVisible();
});

Manual test case for the scenario "Add a new address in My Account"
1. navigate to the www.testing101.net website
2. Click on the Login button on the header
3. Click on the Login button on the Signup page
4. Input valid data into the Email field
5. Input valid data into the Password field
6. Click on the button of the Login form
7. Click on Account menu on the header
8. Click on My Addresses in the navigation menu
9. Click on New Address button
10. Fill in First Name field
11. Fill in Last Name field
12. Fill in Company Name field
13. Fill in Address field
14. Fill in Address line 2 field
15. Fill in City field
16. Fill in Country field
17. Fill in Zip code/Postal Code field
18. Fill in Phone field
19. Click on Add Address button
20. Verify that the new Address added

Create a manual test case for the End-to-End Purchase Flow for a Single Product
1. Navigate to the www.testing101.net/category/all-products
2. Click on the Sorting option of the Filter tab
3. Click on the Add To Cart button on the Americano product
4. Click on the View Cart button on the Cart sidebar
5. Click on the Checkout button on the My Cart page
6. Fill in Email field
7. Fill in First Name field
8. Fill in Last Name field
9. Fill in Phone field
10. Choose Country/Region in the drop-down menu
11. Fill in Address field
12. Fill in City field
13. Fill in Zip/Postal code field
14. Click on Continue button on the first step of the checkout
15. Clink on Continue button on the second step of the checkout
16. Click on Place Order & Pay button
17. Verify the confirmation message appearance

____________________________________________________________________________________________________________________

QA Engineer must understand the basics of automation to effectivelly implement it in real-world scenario

#### Xpath Playwright Locators
Xpath is a query language used for selecting nodes from an XML document. It's commonly associated with XML, but it's also applicable to HTML documents
Xpath is commonly used to locate elements within a web page for automated testing purposes
Two main types:
- Absolute Xpath: starts from the root node of the HTML document and includes the complete path to the element being located. It begins with a single forward slash.
- Relative Xpath: start from any node in the document, not necessarily the root, and are based on the relationship between elements
//input[@id='username]

##### Xpath selector
Using website hhtp://www.testing101.net/playwrightlocators

**//tag**
Uses the HTML tag name to locate elements. It can return multiple elements with the same tag name

**//tag[text()='text']**
allows you to locate elements based on their contained text. This is particularly useful when you want to find elements that have specific text content, such as buttons with specific labels, headings, links, and more

**//tag[@attribute='value']**
It allows you to target elements that have specific attribute-value combinations

**(_//*_)**
* (asterisk) is a wildcard character that represents any element node. It's used to select all elements regardless of their tag name

##### Xpath functions and operators
**and**
The and operator is used to combine multiple conditions, and it returns true if both conditions are satisfied 
//tag[text()='text' and @attribute='value')] 

**or**
The or operator is used to combine conditions, and it returns true if at least one of the conditions is satisfied.
//tag[text()='text' or @attribute='value']

**contains**
The contains() function in XPath is used to find elements whose attribute values contain a specific substring.
//tag[contains(text(), 'text')]
//tag[contains(@attribute, 'value')]

**//parent//child**
Double slash // can be used to traverse the DOM hierarchy without specifying the exact path 
//tag//tag

The .waitFor() method in Playwright is a powerful tool for synchronizing your tests with the browser's actions. It allows you to pause your test execution until a specific condition is met, ensuring that your tests are reliable and don't fail due to timing issues.

### Page Object Model
Design pattern commonly used in test automation to create an abstraction layer for web elements on a page
How does it work?
The POM helps organize your code by grouping interactions into a single class (a JS file you create in your project)
Using POM simplifies maintenance, as changes to elements or interaction logic only need to be updated in one place rather than across all tests
Step-by-step:
1. Create a new folder for Page Object (Common)
2. Create a JS File for URLs (URLs.js)
3. Define a class for URLs
4. Import and Use the URLs Class in your Test Files


