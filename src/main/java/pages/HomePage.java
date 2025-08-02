package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactoryClass;

public class HomePage 
{
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/h4/a")
	private WebElement macBookProduct;
	
	public HomePage(WebDriver driver)
	{
		this.driver=DriverFactoryClass.getDriver();
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnMacBookProduct()
	{
		macBookProduct.click();
	}
	
	public String getTitle()
	{
		String titleOfHomePage=DriverFactoryClass.getDriver().getTitle();
		return titleOfHomePage;
	}

}
