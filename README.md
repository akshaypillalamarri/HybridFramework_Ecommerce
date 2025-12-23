# Hybrid Test Automation Framework (E-Commerce)

![Java](https://img.shields.io/badge/Java-17-orange) ![Selenium](https://img.shields.io/badge/Selenium-4.21-green) ![Maven](https://img.shields.io/badge/Maven-3.8-blue) ![TestNG](https://img.shields.io/badge/TestNG-7.10-red) ![Jenkins](https://img.shields.io/badge/CI%2FCD-Jenkins-lightgrey)

## 📌 Project Overview

This repository contains a scalable **Hybrid Test Automation Framework** designed to automate the regression testing of an E-Commerce application. The framework is architected using the **Page Object Model (POM)** design pattern to ensure code reusability and maintainability. It integrates **Data-Driven Testing** capabilities to validate workflows against multiple datasets and includes a fully automated **CI/CD pipeline** using Jenkins.

## 🚀 Key Features

- **Hybrid Architecture:** Combines Modular (POM) and Data-Driven frameworks.
- **Page Object Model (POM):** Separates page locators (`src/main/java`) from test logic (`src/test/java`) for easy maintenance.
- **Data-Driven Testing:** Utilizes **Apache POI** to read test data (usernames/passwords) from external Excel sheets.
- **Robust Reporting:** Integrated **ExtentReports 5.x** to generate interactive HTML dashboards.
- **Automatic Evidence:** Implemented **TestNG Listeners** to automatically capture and attach **Screenshots** to the report upon test failure.
- **CI/CD Integration:** Configured a **Jenkins Pipeline** that triggers nightly builds (`0 0 * * *`) automatically from GitHub.
- **Cross-Browser Support:** Configurable via `config.properties` to run on Chrome, Firefox, or Edge.

## 🛠 Tech Stack

| Component           | Tool / Library              |
| :------------------ | :-------------------------- |
| **Language**        | Java (JDK 17)               |
| **Web Automation**  | Selenium WebDriver (4.21.0) |
| **Test Runner**     | TestNG                      |
| **Build Tool**      | Maven                       |
| **Reporting**       | ExtentReports 5             |
| **Data Handling**   | Apache POI (Excel)          |
| **CI/CD**           | Jenkins                     |
| **Version Control** | Git & GitHub                |

## 📂 Folder Structure

````text
src/main/java
├── com.ecommerce.base       # BaseClass (Driver Initialization)
├── com.ecommerce.pages      # Page Object Classes (Locators & Actions)
├── com.ecommerce.utils      # Utilities (Excel Reader, ExtentReporter, Listeners)
├── com.ecommerce.config     # Configuration handling

src/test/java
├── com.ecommerce.tests      # Test Scripts (LoginTest, etc.)

src/main/resources
├── config.properties        # Global properties (URL, Browser, etc.)
├── testdata                 # Excel sheets for Data-Driven tests

⚙️ How to Run the Tests
Option 1: Via Command Line (Maven)
Open your terminal/command prompt and run:

Bash

mvn clean test
This will execute the testng.xml suite and generate reports in the test-output folder.

Option 2: Via Jenkins (CI/CD)
Pull this repository into a Jenkins Job.

Configure build step: Invoke top-level Maven targets.

Goal: clean test.

Run Build.

📊 Sample Reports
After execution, the HTML report is generated at: test-output/myReport.html

The report includes:

Pass/Fail status with timestamps.

Screenshots for failed test cases.

Execution environment details.

👨‍💻 Author
Akshay Pillalamarri

Automation Engineer | Java | Selenium | CI/CD


---

### **Step 2: Push it to GitHub**
Once you save the file, send it to your repository so recruiters can see it on the front page.

1.  **Open Terminal**.
2.  Run:
    ```bash
    git add README.md
    git commit -m "Added Project Documentation"
    git push
    ```

**Go check your GitHub link.** You will see your beautiful documentation right on the homepage!

---
````
