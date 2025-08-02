package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactoryClass;

public class MackBookProducPage
{
	WebDriver driver;
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantityTextBox;
	
	@FindBy(xpath="//button[@id='button-cart']")//*[@id="cart-total"]/text()
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"cart-total\"]")
	private WebElement addToCartText;
	
	@FindBy(xpath="//span[@id='cart-total']")
	private WebElement textOfAddToCart;
	
	public MackBookProducPage(WebDriver driver)
	{
		this.driver=DriverFactoryClass.getDriver();
		PageFactory.initElements(driver,this);
	}
	
	public void addQuantity(String quantity)
	{
		quantityTextBox.sendKeys(quantity);
	}
	
	public void emptyQuantityTextBox()
	{
		quantityTextBox.clear();
	}
	
	public void clickOnAddToCartButton()
	{
		addToCartBtn.click();
	}

	public String getTitle()
	{
		String titleOfMacPage=DriverFactoryClass.getDriver().getTitle();
		return titleOfMacPage;
	}
	
	public String getTextAddToCartText()
	{
		String text=addToCartText.getText();
		return text;
	}
	
	public String textOfAddToCart()
	{
		String text = textOfAddToCart.getText();
		return text;
	}
}
