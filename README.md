# 📱 Appium Mobile Automation Framework (Android + iOS, TestNG)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Appium](https://img.shields.io/badge/Appium-662D91?style=for-the-badge&logo=appium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=for-the-badge)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![iOS](https://img.shields.io/badge/iOS-000000?style=for-the-badge&logo=apple&logoColor=white)

A **mobile test automation framework** for **Android and iOS** apps, built with **Appium 2 (Java client 9)**, **TestNG** and the **Page Object Model**. It starts and stops the Appium server from code, reads test data from JSON and data providers, groups tests into smoke and regression suites, and produces **Extent Reports** with screenshots on failure.

---

## ✨ Key features

| Area | What's implemented |
|---|---|
| **Page Object Model** | Android pages (`FormPage`, `ProductCataloguePage`, `CartPage`) and iOS pages (`HomePage`, `AlertViews`) using `@AndroidFindBy` and `@iOSXCUITBy` (class chain, NSPredicate, accessibility ID) with `AppiumFieldDecorator` |
| **Cross-platform base classes** | `AndroidBaseTest` (UiAutomator2) and `IOSBaseTest` (XCUITest) set up drivers and capabilities |
| **Programmatic Appium server** | `AppiumServiceBuilder` starts the Appium server before tests and stops it afterwards, so no manual server start is needed |
| **Gesture library** | `AndroidActions` and `IOSActions` wrap long press, scroll, swipe, fling, pinch zoom in/out, drag and drop, clipboard and app/activity launch using Appium `mobile:` commands |
| **Data-driven testing** | TestNG `@DataProvider` with inline data and with JSON files (`eCommerce.json`) read through a Jackson `jsonReader` utility |
| **Test isolation** | `@BeforeMethod` restarts the app (`terminateApp` / `activateApp`) so each test starts from a clean state |
| **Externalized config** | Appium host, port and device name live in `data.properties` |
| **Suites and groups** | `testng.xml` (regression) and `testng_smoke.xml` (`Smoke` group), selected with Maven profiles |
| **Reporting** | Extent Spark report through a TestNG `ITestListener`, with a screenshot attached for every failed test |

## 🧪 Test coverage

| Test class | Platform | What it checks |
|---|---|---|
| `E_commerce_test_Android_dataParam` | Android | Toast error message when name is empty; form filled with data-provider inputs |
| `E_commerce_test_Android_json` | Android | Form flow driven by JSON test data |
| `HybridAppTest_Android` | Android | Adds products to cart, checks that the sum of item prices equals the cart total, accepts terms with a long press, continues to the website |
| `AppiumIOSBasics` | iOS | Alert views: fills a text-entry alert and verifies the confirmation message |

## 🧰 Tech stack

| Tool | Version | Purpose |
|---|---|---|
| Java | 11+ | Language |
| Appium Java Client | 9.2.2 | Mobile automation (UiAutomator2, XCUITest) |
| Selenium | 4.21.0 (BOM) | WebDriver core |
| TestNG | 7.10.2 | Runner, data providers, listeners, groups |
| ExtentReports | 5.1.1 | HTML reporting |
| Jackson Databind | 2.22.1 | JSON test data |
| Maven Surefire | 3.5.3 | Suite execution through profiles |

## 📁 Project structure

```
AppiumTestNGFramework/
├── pom.xml                              # Dependencies + Regression/Smoke profiles
├── testNGSuites/
│   ├── testng.xml                       # Regression suite
│   └── testng_smoke.xml                 # Smoke group (Android + iOS)
└── src/
    ├── main/java/
    │   ├── PageObjects/Android/         # FormPage, ProductCataloguePage, CartPage
    │   ├── PageObjects/IOS/             # HomePage, AlertViews
    │   ├── utils/
    │   │   ├── AndroidActions.java      # Android gestures + screenshot helper
    │   │   ├── IOSActions.java          # iOS gestures
    │   │   └── jsonReader.java          # JSON → List<HashMap>
    │   └── Resources/data.properties    # Appium IP, port, device name
    └── test/java/
        ├── TestUtils/
        │   ├── AndroidBaseTest.java     # Appium service + UiAutomator2 driver
        │   ├── IOSBaseTest.java         # Appium service + XCUITest driver
        │   ├── Listeners.java           # Extent logging + failure screenshots
        │   └── ExtentReporter.java
        ├── Test/                        # Test classes
        ├── TestData/eCommerce.json
        └── Resources/                   # Sample .apk and .app files
```

## 🚀 Getting started

**Prerequisites**

- JDK 11+ and Maven 3.x
- Node.js and Appium 2 (`npm install -g appium`)
- Drivers: `appium driver install uiautomator2` (Android) and `appium driver install xcuitest` (iOS, macOS only)
- Android SDK with an emulator or real device; Xcode with an iOS simulator for iOS tests

```bash
git clone https://github.com/nancyabcec1058/AppiumTestNGFramework.git
cd AppiumTestNGFramework
```

> **Local setup note:** the base classes point to the Appium `main.js`, the app files and the report folder using absolute Windows paths. Update them for your machine, and set your device name in `src/main/java/Resources/data.properties`.

### Run tests

```bash
mvn test -PRegression     # full regression suite
mvn test -PSmoke          # smoke group
```

The Extent report is written to `reports/index.html`, with screenshots of failed tests next to it.

## 👩‍💻 Author

**Nancy**, SDET / Senior QA Automation Engineer
[GitHub](https://github.com/nancyabcec1058) · [LinkedIn](https://www.linkedin.com/in/nancy1912)

> The apps under test are public sample apps used for Appium practice.
