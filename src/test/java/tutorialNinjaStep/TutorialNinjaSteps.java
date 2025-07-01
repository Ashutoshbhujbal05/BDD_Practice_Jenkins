package tutorialNinjaStep;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactoryClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MackBookProducPage;

public class TutorialNinjaSteps 
{
	WebDriver driver;
	HomePage home = new HomePage(DriverFactoryClass.getDriver());
	MackBookProducPage mac =new MackBookProducPage(DriverFactoryClass.getDriver());
	@Given("The user should be on the Tutorial Ninja Home Page")
	public void the_user_should_be_on_the_tutorial_ninja_home_page() 
	{
	    driver=DriverFactoryClass.getDriver();
	    driver.get("https://tutorialsninja.com/demo/");
	}
	
	@Then("the title of webPage should contains the text {string}")
	public void the_page_should_contains_the_text(String string)
	{
	    String title=home.getTitle();
        boolean isPresent = title.contains(string);
        Assert.assertTrue(isPresent);
	}

	@When("the user click on mackbook product available on the page")
	public void the_user_click_on_mackbook_product_available_on_the_page() throws InterruptedException
	{
		Thread.sleep(3000);
	    home.clickOnMacBookProduct();
	}

	@Then("the title of the web page should contains {string}")
	public void the_title_of_the_web_page_should_contains(String string) 
	{
		String title=mac.getTitle();
        boolean isPresent = title.contains(string);
        Assert.assertTrue(isPresent);
	}

	@Then("verifies the Add to cart text should contains {string}")
	public void verifies_the_add_to_cart_text_should_contains(String string)
	{
	    String text=mac.getTextAddToCartText();
	    boolean isPresent = text.contains(string);
	    Assert.assertTrue(isPresent);
	}

	@When("the user add the quantity as {string}")
	public void the_user_add_the_quantity_as(String string) 
	{
		mac.emptyQuantityTextBox();
	    mac.addQuantity(string);
	}

	@When("click on the add to cart button")
	public void click_on_the_add_to_cart_button() 
	{
		mac.clickOnAddToCartButton();
	}

	@Then("then the add to cart text should contains {string}")
	public void then_the_add_to_cart_text_should_contains(String string) throws InterruptedException 
	{
		Thread.sleep(3000);
	    String text1 = mac.textOfAddToCart();
	    String pageSource= driver.getPageSource();
	    if(pageSource.contains(string))
	    {
	    	Assert.assertEquals( string,text1);
	    }
	    
	}


}
