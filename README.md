# Retail UI Automation Framework

This repository contains a UI automation framework built using Selenium + TestNG + Maven, with parallel execution support and Allure reporting.
The framework follows Page Object Model (POM) and is designed to be scalable, stable, and CI-friendly.

---

## 🚀 Tech Stack

- **Java** (JDK 17)
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Allure Reporting**
- **WebDriverManager**
- **Jackson (JSON handling)**
- **Git & GitHub**

## 📁 Project Structure
---retail.ui.automation
│
├── src
│ ├── main
│ │ └── java
│ │ ├── base → BaseTest (driver setup & teardown)
│ │ ├── pages → Page Object classes
│ │ ├── utils → Utility classes (WaitUtils, TestUtils)
│ │ └── config → config.properties
│ │
│ └── test
│ ├── java
│ │ └── test → Test classes
│ └── resources
│ ├── testng.xml
│ └── expectedResults.json
│
├── pom.xml
├── README.md
└── .gitignore


---

## ⚙️ Framework Features

- Page Object Model (POM) design
- Thread-safe WebDriver using ThreadLocal
- Parallel execution using TestNG
- Explicit waits (no Thread.sleep)
- Automatic screenshot capture on failure
- Allure reporting integration
- JSON-based expected test data
- Test grouping using TestNG (`smoke`, `sanity`)
- Cross-browser support (Chrome / Firefox)
- Clean Git hygiene (target & reports ignored)
- Maven-based execution

---

## 🔧 Prerequisites

Make sure the following are installed:

- Java JDK 17+
- Maven 3.9+
- Chrome / Firefox browser
- Git

Verify installation:
```bash
java -version
mvn -version
git --version

🧪 How to Run Tests
▶️Run all tests
mvn clean test

▶️ Run via TestNG suite
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml

⚡ Parallel Execution

Parallel execution is enabled using TestNG and ThreadLocal WebDriver.

- Each test runs in its own thread

- Each thread has its own browser instance

- Execution time is significantly reduced

  Example (testng.xml):
  <suite name="Smoke Suite" parallel="methods" thread-count="3">
  

📊 Allure Reports

What Allure Captures:

-Test execution status

-Failure screenshots

-Step-level details

-Execution timeline

Generate report
allure serve target/allure-results

This will open the Allure report automatically in your browser.

⚠️ allure-results and target folders are ignored via .gitignore.

📸 Screenshot on Failure

Screenshots are automatically attached to Allure reports when a test fails.

🧾 Configuration

Update browser and URL in:

src/main/java/com/retail/ui/automation/config/config.properties


Example:

browser=chrome
url=https://www.apple.com/in/retail/

🧠 Design Principles Used

POM (Page Object Model)

Single Responsibility

Reusable utilities

Separation of test logic & UI logic 


🧹 Git Ignore Strategy

- Ignored files/folders:

- target/

- allure-results/

- allure-report/

- IDE config files (.classpath, .settings, .idea)

This keeps the repository clean and lightweight.

📌 Author

Amardeep Yengade
UI Automation Engineer

📜 License

This project is for learning and demonstration purposes.



