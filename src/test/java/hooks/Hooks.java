package hooks;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactoryClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.io.IOException;
import utils.ConfigReader;

public class Hooks 
{
	WebDriver driver;
	@Before
	public void initBrowser() throws IOException
	{
		ConfigReader.loadProperties();  // ✅ Load only once
        String browserName = ConfigReader.getProperty("browser");
        System.out.println("🚀 Starting test in browser: " + browserName);

        driver = DriverFactoryClass.initBrowser(browserName);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
	}
	
	@After(order =1)
	public void tearDown()
	{
		 DriverFactoryClass.quitDriver();
	}
	
//	@After(order =2)
//	public void captureSs(Scenario scenario)
//	{
//		if(scenario.isFailed())
//		{
//			String name = scenario.getName().replaceAll(" ", "_");
//			TakesScreenshot ts = ((TakesScreenshot)driver);
//			byte[] source = ts.getScreenshotAs(OutputType.BYTES);
//			scenario.attach(source, "image/png", name);			
//		}
//	}

}
