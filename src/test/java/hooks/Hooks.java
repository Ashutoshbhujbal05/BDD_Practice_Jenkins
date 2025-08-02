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
//		Properties prop = new Properties();
//		String path =System.getProperty("user.dir")+"//src//test//resources//CucumberConfig.properties";
//		FileInputStream fis=new FileInputStream(path);
//		prop.load(fis);
		ConfigReader.loadProperties();
		String browserName=ConfigReader.getProperty("Browser");
//		String browserName=prop.getProperty("Browser");
		DriverFactoryClass df= new DriverFactoryClass();
		System.out.println(browserName);
//		RemoteWebDriverClass def = new RemoteWebDriverClass();
		driver=df.initBrowser(browserName);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@After(order =1)
	public void tearDown()
	{
		driver.quit();
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
