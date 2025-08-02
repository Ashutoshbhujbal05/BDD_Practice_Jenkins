package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactoryClass 
{
	private static WebDriver driver;

    public WebDriver initBrowser(String browser) {
        if (browser == null || browser.trim().isEmpty()) {
            System.out.println("⚠️ Browser is null or empty, defaulting to Chrome.");
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

            case "chrome":
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
}
