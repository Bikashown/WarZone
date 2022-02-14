package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Basenew;

public class Login extends Basenew{
	
	private static By emailaddress=By.id("input-email");
	private static By password=By.id("input-password");
	private static By loginbutton=By.xpath("//*[@type='submit']");
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public static WebElement emailaddress()
	{
		return driver.findElement(emailaddress);
	}
	
	
	public static WebElement password()
	{
		return driver.findElement(password);
	}
	
	public static WebElement loginbutton()
	{
		return driver.findElement(loginbutton);
	}


}
