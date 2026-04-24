# 🧪 SweetShop Automation Framework

## 📌 Project Overview

This project is a Selenium-based automation framework built using Java + TestNG to test a retail web application (**SweetShop**).

The framework follows the Page Object Model (POM) design pattern and supports:

* Scalable test design
* Retry mechanism for flaky tests
* Screenshot capture on failure
* Extent Reports for execution results
* Config-driven execution
* Clean separation of concerns

---

## ⚙️ Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Extent Reports

---

## 📂 Project Structure

```
SweetCart
│
├── src/main/java
│   ├── base
│   │   ├── BasePage.java          → Common reusable Selenium methods (click, wait, getText)
│   │   └── DriverFactory.java     → Manages WebDriver instance using ThreadLocal
│   │
│   ├── pages
│   │   ├── AccountPage.java       → Handles account page actions & validations
│   │   ├── BasketPage.java        → Basket/cart related operations
│   │   ├── LoginPage.java         → Login functionality
│   │   ├── ProductDetailPage.java → Product details and interactions
│   │   └── SweetsPage.java        → Product listing and navigation methods
│   │
│   └── utils
│       ├── ConfigReader.java      → Reads data from config.properties
│       ├── ExcelUtil.java         → Handles test data from Excel
│       ├── ExtentManager.java     → Initializes and manages Extent Reports
│       └── ScreenshotUtil.java    → Captures screenshots on failure
│
├── src/test/java
│   ├── base
│   │   └── BaseTest.java          → Test setup & teardown (driver initialization)
│   │
│   ├── listeners
│   │   ├── RetryListener.java     → Applies retry logic automatically to tests
│   │   └── TestListener.java      → Handles reporting & screenshots on failure
│   │
│   ├── tests
│   │   ├── AccountTest.java       → Account & order history test cases
│   │   ├── BasketTest.java        → Add/remove products & basket validation
│   │   ├── LoginTest.java         → Login functionality validation
│   │   ├── NavigationTest.java    → Navigation & static content checks
│   │   └── ProductTest.java       → Product-related test scenarios
│   │
│   └── utils
│       └── RetryAnalyzer.java     → Retry mechanism logic (re-run failed tests)
│
├── src/test/resources
│   └──  testdata                  → External test data
│        └── LoginData.xlsx        → Excel sheet for login
│   └── config.properties        → Configuration (URL, username, password, timeout, browser)
│
├── reports                      → Extent report output
├── screenshots                  → Screenshots captured on failure
├── target                       → Maven build output
├── test-output                  → TestNG default reports
│
├── pom.xml                      → Maven dependencies & build configuration
└── testng.xml                   → Test suite configuration
```

---

## 🧪 Test Modules

### 1. User Authentication

* Verify successful login with valid credentials
* Verify login failure with invalid credentials and validate the error message
* Verify logout removes the logged-in state *(handled as demo due to UI limitation)*
* Verify the account page is not accessible without login *(validated as observation due to UI limitation)*

---

### 2. Product Browse

* Verify the sweets listing page displays multiple products
* Apply a product category filter and verify only relevant products are shown
* Open a product detail page and verify the name, price, and description
* Verify the Add to Basket button is present on the product detail page

---

### 3. Shopping Basket

* Add a product and verify basket count updates in navigation
* Navigate to basket and verify product name and price
* Remove product and verify basket becomes empty
* Add multiple products and verify all appear in basket

---

### 4. Account and Order History

* Login and navigate to account page and verify the user's name is displayed
* Verify the order history section is present
* Verify each order history row shows a valid date and total amount

---

### 5. Navigation and Static Content

* Verify all navigation links (Sweets, About, Login, Basket) are visible and clickable
* Navigate to the About page and verify the page heading
* Verify the footer is displayed and contains expected text

---


---

## ⚠️ Known Limitations

* ❌ No logout functionality in UI
* ❌ Account page is accessible only after login redirect

👉 These scenarios are handled using **demo tests / skipped tests** instead of strict assertions.

---

## 🔁 Retry Mechanism

* Failed tests are retried automatically using:

  * `RetryAnalyzer`
  * `RetryListener`

---

## 📸 Screenshot Handling

* Screenshots captured automatically on failure
* Stored in `/screenshots` folder

---

## 📊 Reporting

* Extent Reports generated in `/reports`
* Includes:

  * Test status (Pass/Fail/Skip)
  * Screenshots for failures
    
---

## 🚀 How to Run

### Using Maven

```bash
mvn clean test
```

### Using TestNG

* Right click → **Run as TestNG Suite**

---

## 🔧 Configuration

Update `config.properties`:

```
browser=chrome
baseUrl=https://sweetshop.netlify.app
username=oneorder@sweetshop.local
password=qwerty
timeout=10
```

---

## 👩‍💻 Author

Vaishnavi

---

## 📌 Conclusion
The SweetShop automation framework was successfully developed using Selenium, Java, and TestNG with a structured POM design, covering all key functional modules.
