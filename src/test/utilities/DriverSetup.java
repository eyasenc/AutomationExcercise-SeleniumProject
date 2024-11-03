package src.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

// Class to set up and manage browser drivers
public class DriverSetup {

    // Retrieves the browser name from system properties (defaulting to "Firefox" if none provided)
    private static String browserName = System.getProperty("browser", "Firefox");

    // ThreadLocal to maintain separate WebDriver instances per thread (useful for parallel tests)
    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    // Sets the WebDriver instance for the current thread
    public static void setDriver(WebDriver driver) {
        LOCAL_DRIVER.set(driver);
    }

    // Retrieves the WebDriver instance for the current thread
    public static WebDriver getDriver() {
        return LOCAL_DRIVER.get();
    }

    // Returns a WebDriver instance based on the specified browser name
    public WebDriver getBrowser(String browser_name) {
        if (browser_name.equalsIgnoreCase("chrome")) {
            return new ChromeDriver(); // returns Chrome WebDriver
        } else if (browser_name.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver(); // returns Firefox WebDriver
        } else if (browser_name.equalsIgnoreCase("edge")) {
            return new EdgeDriver(); // returns Edge WebDriver
        } else {
            // Throws an error if the browser name is unsupported
            throw new RuntimeException("Browser is not available with the name: " + browser_name);
        }
    }

    // Method annotated with @BeforeMethod to run before each test method
    @BeforeMethod
    public void openABrowser() {
        // Gets a WebDriver instance for the specified browser
        WebDriver driver = getBrowser(browserName);

        // Sets up implicit wait and maximizes the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        // Sets the WebDriver for the current thread
        setDriver(driver);
    }

    // Method annotated with @AfterMethod to run after each test method
    @AfterMethod
    public void closeBrowser() {
        // Quits the WebDriver instance for the current thread
        getDriver().quit();
    }
}

