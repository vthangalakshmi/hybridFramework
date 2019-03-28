package customcommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import config.StartBrowser;

public class ActionsDriver extends StartBrowser {
	/**WebDriver driver;
	
	public ActionsDriver()
	{
		driver=StartBrowser.driver;
	}
	/** 
	 * Used to launch application
	 * @param url Application URL
	 * Example https://cmpqa.cloud-marketplace.jp
	 */
	public void launchApplication(String url){
		try{
			driver.get(url);
			log.info("Opened URL");
		}catch (Exception e){
			log.error("Failed to load the application and the exception is "+e);
		}
		
	}
	/**
	 * Perform click operation of button,check box,radio,links
	 * @param locator Get the locator from object repository package
	 */
	public void click(By locator,String element){
		try{
			driver.findElement(locator).click();
			log.info("Clicked the element "+element);
		}catch (Exception e){
			System.out.println("Failed to click the element "+element);
			log.error("Failed to click the element "+element+" and the exception is "+e);
		}
		
	}
	/**
	 * Used to set value for text box and text areas attributes
	 * @param locator Get the locator from object repository package
	 * @param testData Get the data from hardcode or from external files
	 */
	public void type(By locator,String testData,String element){
		try{
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(testData);
			log.info("Passed keys to the element "+element);
		}catch (Exception e){
			log.error("Failed to enter the input for the element "+element+" and the exception is "+e);
		}
		
	}
	/**
	 * Perform mouse over on particular element and click
	 * @param locator get locator from object repository package
	 * @param locator1 
	 */
	public void mouseHoverAndClick(By locator,By locator1,String element){
		try{
			Actions act=new Actions(driver);
			WebElement we=driver.findElement(locator);
			WebElement we2=driver.findElement(locator1);
			act.moveToElement(we).click(we2).build().perform();
			log.info("Mouseover and click is successful for the element "+element);
		}catch (Exception e){
			log.error("Failed to mouse over and click the element "+element+" and the exception is "+e);
		}
		
	}
	/**Perform the dropdown selection
	 * 
	 * @param locator - get locator from object repository package
	 * @param testData - Data to select from dropdown
	 */	
	public void dropdownSelection(By locator,String testData,String element){
		try{
			WebElement we=driver.findElement(locator);
			Select s1=new Select(we);
			s1.selectByVisibleText(testData);
			log.info("Dropdown selection is successful for the element "+element);
		}catch(Exception e) {
			log.error("Failed to select the input from the element "+element+" and the exception is "+e);
		}
		
	}
	
	public String generatePassword(){
		return "12345678";
	}
}
