package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactoryClass 
{
    static WebDriver driver;
	
	public WebDriver initBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		
		return driver;	   
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}

}
