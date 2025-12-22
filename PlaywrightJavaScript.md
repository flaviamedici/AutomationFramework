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

#### Troubleshooting

