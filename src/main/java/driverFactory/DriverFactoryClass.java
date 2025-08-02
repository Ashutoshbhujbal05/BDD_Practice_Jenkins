package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactoryClass 
{
	 // ThreadLocal for parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initBrowser(String browser) 
    {
        if (browser == null || browser.trim().isEmpty())
        {
            browser = "chrome";
        }

        WebDriver drv;
        switch (browser.toLowerCase()) 
        {
            case "firefox":
                drv = new FirefoxDriver();
                System.out.println("✅ Firefox browser launched");
                break;

            case "edge":
                drv = new EdgeDriver();
                System.out.println("✅ Edge browser launched");
                break;

            default:
                drv = new ChromeDriver();
                System.out.println("✅ Chrome browser launched");
                break;
        }

        // Set WebDriver to current thread
        driver.set(drv);
        return getDriver();
    }

    public static WebDriver getDriver() 
    {
        return driver.get();
    }

    public static void quitDriver() 
    {
        if (driver.get() != null) 
        {
            driver.get().quit();
            driver.remove();  // Remove WebDriver instance for the current thread
            System.out.println("✅ Browser closed successfully.");
        }
    }
}
