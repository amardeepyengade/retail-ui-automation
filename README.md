# Retail UI Automation Framework

This repository contains a **UI automation testing framework** built using **Java, Selenium WebDriver, TestNG, Maven**, and **Allure Reports**.  
The framework is designed following **Page Object Model (POM)** principles for better readability, scalability, and maintainability.

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
- Centralized WebDriver management
- JSON-based expected test data
- Test grouping using TestNG (`smoke`, `sanity`)
- Cross-browser support (Chrome / Firefox)
- Allure HTML reports
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

📊 Allure Reports
Generate report
allure serve target/allure-results


This will open the Allure report automatically in your browser.

⚠️ allure-results and target folders are ignored via .gitignore.

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

📌 Author

Amardeep Yengade
QA Automation Engineer

📜 License

This project is for learning and demonstration purposes.



