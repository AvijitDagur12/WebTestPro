# WebTestPro

A Selenium WebDriver and TestNG-based test automation framework designed to validate core user workflows of the SauceDemo web application. The project follows the Page Object Model (POM) design pattern to ensure maintainable, reusable, and scalable test code.

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 17 | Programming language |
| Selenium WebDriver | 4.25.0 | Browser automation |
| TestNG | 7.10.2 | Test framework and reporting |
| Maven | 3.9.11 | Build and dependency management |
| Page Object Model | — | Design pattern for maintainable tests |

## Test Scenarios

The framework currently covers **5 automated test cases**:

1. **Home Page Validation** — Verifies the application loads and the page title is correct.
2. **Valid Login** — Authenticates with valid credentials and confirms successful navigation to the inventory page.
3. **Invalid Login** — Submits incorrect credentials and verifies the appropriate error message is displayed.
4. **Add to Cart** — Adds a product to the shopping cart and validates the cart badge count.
5. **End-to-End Checkout** — Completes the full checkout flow (cart → customer details → order confirmation) and verifies the success message.

## Project Structure

WebTestPro/
├── pom.xml
├── README.md
├── .gitignore
└── src/
└── test/
├── java/
│ └── com/webtestpro/
│ ├── base/ BaseTest — browser setup, teardown, failure screenshots
│ ├── pages/ Page Objects — LoginPage, InventoryPage, CheckoutPage
│ ├── tests/ Test classes — LoginTest, HomePageTest, CartTest, CheckoutTest
│ └── utilities/ ScreenshotUtil — captures evidence on failure
└── resources/
├── config.properties Configurable URL and wait timings
└── testng.xml TestNG suite configuration



## Framework Design

- **BaseTest** — Centralized browser initialization and teardown using `@BeforeMethod` and `@AfterMethod`.
- **Page Object Model** — Locators and page actions are encapsulated in dedicated page classes, keeping test logic clean and reducing duplication.
- **Configuration Management** — Application URL and wait timings are externalized in `config.properties` rather than hard-coded.
- **Explicit Waits** — `WebDriverWait` is used to handle dynamic page loading reliably.
- **Failure Evidence** — Screenshots are automatically captured when a test fails, stored in the `screenshots/` directory.
- **Suite Execution** — Tests are organized and executed through a TestNG XML suite.

## Prerequisites

- Java 17 or higher
- Maven 3.9+
- Google Chrome (latest version)
- ChromeDriver (automatically managed by Selenium Manager)

## How to Run

1. Clone the repository:

git clone https://github.com/AvijitDagur12/WebTestPro.git

text

2. Navigate to the project directory:
cd WebTestPro

text

3. Execute the test suite:
mvn test

text

Test execution results are available in `target/surefire-reports/`, and failure screenshots (if any) are saved in the `screenshots/` directory.

## Current Limitations

- Tests run sequentially; parallel execution is not yet configured.
- The framework currently targets a single demo application (SauceDemo).
- CI/CD integration via GitHub Actions is not yet implemented.
- Test data is defined within test classes rather than externalized to data providers.

## Author

**Avijit Dagur**
B.Tech Computer Science and Engineering
