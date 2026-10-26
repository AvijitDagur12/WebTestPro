markdown
# WebTestPro

A Selenium + TestNG automation framework for testing [SauceDemo](https://www.saucedemo.com/).

## Tech Stack
- Java 17
- Selenium WebDriver 4.25
- TestNG 7.10
- Maven
- Page Object Model (POM)

## Project Structure
src/test/java/com/webtestpro/
├── base/ BaseTest (setup/teardown)
├── pages/ Page Objects (LoginPage, InventoryPage)
├── tests/ Test classes
└── utilities/ Screenshot utility

src/test/resources/
├── config.properties
└── testng.xml

text

## Test Scenarios
1. Home page opens
2. Valid login
3. Invalid login (error message shown)
4. Add item to cart (cart count = 1)

## How to Run
mvn test

text

## Features
- Reusable BaseTest for browser setup/teardown
- Config-driven URL and waits
- Page Object Model for maintainability
- Screenshots captured automatically on failure
- TestNG suite for organized execution

## Author
Avijit Dagur

