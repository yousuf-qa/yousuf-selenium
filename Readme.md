# Selenium Add to Cart Automation Framework

This is a Selenium Java automation framework for testing the "Add to Cart" feature of an eCommerce website.

## Prerequisites
- Java JDK 11 or higher
- Maven
- ChromeDriver (or WebDriverManager will handle it automatically)

## How to Run

### 1. Clone the Repository
   ```bash
   git clone https://github.com/your-repo-link.git
   ```

### 2. Navigate to the Project Directory
   ```bash
   cd yousuf-selenium
   ```

### 3. Run the Tests Using Maven
   Run the tests with the default goal `test` by using the following command:
   ```bash
   mvn test
   ```

## Running Tests Using Maven Configuration in Eclipse

To run tests using the `clean test` goal in Eclipse with Maven configuration, follow these steps:

### Step 1: Import the Project in Eclipse
- Open Eclipse and import the project as a Maven project.
- Go to **File** > **Import** > **Existing Maven Projects**.
- Browse to the directory where you cloned the project and select it.

### Step 2: Create a Maven Run Configuration
1. **Open the Run Configurations** dialog:
   - Go to **Run** > **Run Configurations**.
   
2. **Create a New Maven Configuration**:
   - In the left panel, right-click **Maven Build** and select **New**.
   
3. **Configure the Maven Goal**:
   - In the **Name** field, give your configuration a name (e.g., `Selenium Add to Cart Tests`).
   - In the **Base directory** field, ensure the directory points to the root of the project.
   - In the **Goals** field, enter the following Maven goal:
     ```bash
     clean test
     ```

4. **Save and Run**:
   - Click **Apply** and then **Run**.
   - Eclipse will clean the project and run the tests defined in your `pom.xml`.

### Step 3: View Test Results
- After the tests are executed, view the test results in the **Console** tab in Eclipse.
- You can also check the **Maven** tab in Eclipse for additional details about the build process.
   
   
   ## Future Enhancements

### Cross-Browser Testing
To support multiple browsers (e.g., Firefox, Edge), modify the `WebDriverSetup.java` file to handle browser selection dynamically.

Example:

```java
// For Firefox
WebDriverManager.firefoxdriver().setup();
return new FirefoxDriver();

// For Edge
WebDriverManager.edgedriver().setup();
return new EdgeDriver();
```

### Parallel Execution
Use TestNG's `parallel` attribute in the `testng.xml` file to run tests in parallel, improving execution time for large test suites.

Example configuration for parallel execution in `testng.xml`:

```xml
<suite name="Suite" parallel="tests" thread-count="2">
    <test name="Test1">
        <classes>
            <class name="com.test.AddToCartTest"/>
        </classes>
    </test>
    <test name="Test2">
        <classes>
            <class name="com.test.CheckoutTest"/>
        </classes>
    </test>
</suite>
```

### Reporting
Integrate **ExtentReports** or **Allure** for more detailed and customizable test reports. This will provide clear and attractive reports for test execution results.

#### Example with ExtentReports:
```java
ExtentReports extent = new ExtentReports();
ExtentTest test = extent.createTest("Add to Cart Test");
test.log(Status.PASS, "Item successfully added to cart");
extent.flush();
```

### CI/CD Integration
To automate test execution on code changes, integrate the framework with **Jenkins** or **GitHub Actions**.

#### Example: Jenkinsfile
```groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
```
