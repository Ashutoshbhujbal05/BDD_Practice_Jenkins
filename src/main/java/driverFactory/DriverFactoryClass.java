package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactoryClass 
{
	private static WebDriver driver;

    public static WebDriver initBrowser(String browser) {
        if (driver != null) {
            return driver; // ✅ Avoid multiple browsers
        }

        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome";
        }

        browser = browser.trim().toLowerCase();

        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                System.out.println("✅ Firefox browser launched");
                break;

            case "edge":
                driver = new EdgeDriver();
                System.out.println("✅ Edge browser launched");
                break;

            default:
                driver = new ChromeDriver();
                System.out.println("✅ Chrome browser launched");
                break;
        }
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException("❌ WebDriver is not initialized. Call initBrowser() first.");
        }
        return driver;
    }
    
 // ✅ Added method
    public static void resetDriver() {
        driver = null;
    }
}
