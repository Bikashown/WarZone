package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Utility.Basenew;

public class Homepage extends Basenew{
	
	private static By message=By.xpath("//*[@id='account-account']/div/div/h2[1]");
	
	private static By desktop=By.cssSelector(".nav.navbar-nav>li:first-of-type");
	
	public static WebElement message()
	{
		return driver.findElement(message);
	}
	
	
	public static WebElement desktop()
	{
		return driver.findElement(desktop);
	}
	

}
