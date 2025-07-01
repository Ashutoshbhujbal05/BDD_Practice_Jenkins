package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactoryClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.FileInputStream;
import java.io.IOException;

public class Hooks 
{
	WebDriver driver;
	@Before
	public void initBrowser() throws IOException
	{
		Properties prop = new Properties();
		String path =System.getProperty("user.dir")+"//src//test//resources//CucumberConfig.properties";
		FileInputStream fis=new FileInputStream(path);
		prop.load(fis);
		String browserName=prop.getProperty("Browser");
		DriverFactoryClass df= new DriverFactoryClass();
		driver=df.initBrowser(browserName);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@After(order =1)
	public void tearDown()
	{
		driver.quit();
	}
	
	@After(order =2)
	public void captureSs(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String name = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot ts = ((TakesScreenshot)driver);
			byte[] source = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", name);			
		}
	}

}
