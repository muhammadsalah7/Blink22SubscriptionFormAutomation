# 🧪 Blink22 Blog Subscription Test Automation
This UI automation project validates the blog subscription form on the Blink22 website using Selenium WebDriver and TestNG, adhering to the Page Object Model (POM) design pattern for enhanced modularity and maintainability.
- 🧡 The test suite simulates a user interacting with the blog subscription form, checking placeholder values, form validation errors, and successful submission.
- 🔗 Base URL: https://www.blink22.com

---

## ✅ What It Does

- Opens the Blink22 website and navigates to the blog page  
- Gets and prints placeholder text for "Full Name" and "Email" fields  
- Tests these scenarios:
  - Missing full name
  - Missing email
  - Invalid email format
  - Valid submission

---

🛠 Tools & Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven (for build and dependency management)
- Page Object Model (for clean architecture)
- IntelliJ IDEA / Eclipse (any Java IDE)

---

## 🚀 Setup Instructions
- Clone the Repository
- Run the following commands in your terminal:
- git clone https://github.com/muhammadsalah7/eSpaceAutomationTask.git
- cd eSpaceAutomationTask
- Install Dependencies
- Make sure Maven and JDK are installed on your system. Then run:
- mvn clean install
- Configure WebDriver
Ensure your desired browser driver (e.g., ChromeDriver) is downloaded and added to your system path.
Alternatively, use WebDriverManager in your BaseTest class to automatically manage driver setup.

## ▶️ How to Run the Test
Through the IDE:
- Open the project in IntelliJ IDEA, Eclipse, or any Java IDE
- Navigate to BlogSubscriptionTest.java
- Right-click the file and select Run
- Using TestNG Suite:
You can also run the full suite using the testng.xml configuration file by executing:
mvn test -DsuiteXmlFile=testng.xml

---


Made with ☕ by Muhammad
