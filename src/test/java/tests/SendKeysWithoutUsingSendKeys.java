package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SendKeysWithoutUsingSendKeys 
{
	WebDriver driver;

	@Test
	public void sendKeys()
	{
        driver =new ChromeDriver();
		
		driver.get("https://www.google.com/");
		WebElement textBox = driver.findElement(By.xpath("//textarea[@name='q']"));
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='I am Ashutosh'", textBox);
	}
	

	 @Test
	 public void webTableHandling()
	 {
		 driver =new ChromeDriver();
			
			driver.get("https://seleniumpractise.blogspot.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//it will return the count of all the Headers of column present in the table
			int All_Headers=driver.findElements(By.xpath("//table[@id='customers']//th")).size();
			System.out.println("Count of the column in given table:"+All_Headers);
			
			//it will return the count of all the Row present in the table including header of table
			int count_Row=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
			System.out.println("Count of the column in given table:"+count_Row);

			//it will return the count of all the Table data(that is every field in the table) present in the table
			int count_TableData=driver.findElements(By.xpath("//table[@id='customers']//td")).size();
			System.out.println("Count of the column in given table:"+count_TableData);

			//it will return the count of all the table data present in the second column
			int count_TableDataColumn2=driver.findElements(By.xpath("//table[@id='customers']//td[2]")).size();
			System.out.println("Count of the column in given table:"+count_TableDataColumn2);

			//it will return the Particular row and cell data(That is row2 column2) of the table
			WebElement row2_coulmn2Value=driver.findElement(By.xpath("//table[@id='customers']//tr[2]//td[2]"));
			System.out.println("text of the selected data in given table:"+ row2_coulmn2Value.getText());

			//if we want to click on checkbox beside of selenium company
			WebElement checkBox = driver.findElement(By.xpath("//td[text()='Selenium']//preceding-sibling::td//input"));
	 }
	 
	 @Test
	 public void countOfCompanyWithText()
	 {
		    driver =new ChromeDriver();
			
			driver.get("https://seleniumpractise.blogspot.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		    //it will return the all element from the column 2 present in the table
			List<WebElement> dataOf_Column=driver.findElements(By.xpath("//table[@id='customers']//tr//td[2]"));
			boolean status=false;
            for(WebElement ele:dataOf_Column)
            {
            	String eleText=ele.getText();
            	System.out.println(eleText);
            	if(eleText.contains("Ola"))
            	{
            		status=true;
            		break;
            	}
            }
            
        	Assert.assertTrue(status, "The column doesnot contains the text Amazon");
	 }
	 
	 @Test
	 public void clickCheackBoxOfSelenium() throws InterruptedException
	 {
		    driver =new ChromeDriver();
			
			driver.get("https://seleniumpractise.blogspot.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		    //it will return the element from the table present in the table
			// using the Xpath Axes
			WebElement checkBox = driver.findElement(By.xpath("//td[text()='Selenium']//preceding-sibling::td//input"));
			
			//it will return the element from the table present in the table
			// using the Xpath Axes
			WebElement KnowMoreSelenium = driver.findElement(By.xpath("//td[text()='Selenium']//following-sibling::td[3]//a"));
			
		    //it will return the all element from the table present in the table
			List<WebElement> dataOf_table=driver.findElements(By.xpath("//table[@id='customers']//td"));
			boolean status=false;
            for(WebElement ele:dataOf_table)
            {
            	String eleText=ele.getText();
            	System.out.println(eleText);
            	if(eleText.contains("Selenium"))
            	{
            		status=true;
            		checkBox.click();
            		break;
            	}
            }
            
        	Assert.assertTrue(status, "The column doesnot contains the text Amazon");
        	Thread.sleep(2000);
        	KnowMoreSelenium.click();
        	
        	driver.quit();
	 }
	 

}