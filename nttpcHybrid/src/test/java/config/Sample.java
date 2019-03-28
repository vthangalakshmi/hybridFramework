package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Sample {
	public static WebDriver driver;
	public static String locale="Japanese";
	public static Select s1;
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("url");
		Thread.sleep(10000);
		Actions act=new Actions(driver);
		WebElement w2=driver.findElement(By.xpath("//*[@id='toponemenu']/ul[1]/li/a"));
		act.moveToElement(w2).build().perform();
		WebElement w1=driver.findElement(By.xpath("//*[@id='toponemenu']/ul[1]/li/ul"));
		s1=new Select(w1);
		if(locale.equalsIgnoreCase("English")){
			s1.selectByVisibleText("Japanese（日本語）");
			
		    //s1.selectByVisibleText("English（英語）");
			
		}else{
			s1.selectByVisibleText("Japanese（日本語）");
		}
		driver.close();
	}
}
