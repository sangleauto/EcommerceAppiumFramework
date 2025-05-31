## Overview

- This self-practice project reinforces my Appium skills through a demo mobile automation framework built from scratch using Appium and Java. It automates basic test flows for the E-Commerce Android application, following the Page Object Model for maintainable and scalable test design
## Technologies Used

- Java
- Appium
- TestNG
- Maven
- Android SDK (for generating Android emulators)
- BrowserStack
## Framework Structure

```css
E-Commerce/
│
├── src/main/java/
│   ├── common/
│   │   └── BasePage.java          
│   │   └── DataHelper.java         
│   └── pages/
│       └── CartPage.java        
│       └── HomePage.java        
│       └── ProductPage.java        
│
├── src/test/java/
│   ├── common/
│   │   └── BaseTest.java          
│   │   └── ConfigReader.java       
│   │   └── OptionsConfig.java      
│   ├── dataProvider/
│   │   └── DataProviders.java     
│   └── tests/
│       └── [TestCases].java         
│
├── src/test/resources/
│   ├── appAPK/       
│   ├── config/ 
│   ├── data/
│   └── executions/                
└── browserstack.yml
```

### 1. src/main/java/
#### common/

- `BasePage.java`: Initializes PageFactory for page objects and provides reusable utility methods
- `DataHelper.java`: Generates dynamic test data (random names, emails, ...)
#### pages/

- `PageObjects.java`: Includes UI elements and interaction methods for each PageObject
### 2. src/test/java

#### common/

- `BaseTest.java`: Handles Appium server initialization and AndroidDriver management
- `ConfigReader.java`: Loads emulator-specific settings from .properties files
- `OptionsConfig.java`: Sets up Capabilities for parallel testing across emulators
#### dataProvider/

- `DataProviders.java`: Supplies test data from JSON files for data-driven testing
#### tests/

- `[TestCases].java`: Contains test cases for the E-Commerce app
### 3. src/test/resources

- `appAPK/`: Contains APK files for tests app
- `config/`: Contains .properties files with device/emulator configurations
- `data/`: JSON data files used in data-driven tests
- `executions/`: TestNG XML files for different test execution strategies
### 4. browserstack.yml

- Configuration to run cloud-based tests on BrowserStack

## Limitations

- Currently supports Android only
- Limited to basic functionalities of the E-Commerce app
