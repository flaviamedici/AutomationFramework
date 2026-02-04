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

### Install Intellij IDEA
Search for Intellij IDEA in Google
Click Download to go to the download page
Scroll down to the page for download the Community Edition and open the file

### Setup Selenium WebDriver Chrome
in Intellij click File -> New
Setup dependencies
pom.xml 
