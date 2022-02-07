package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Base;

public class Homepage extends Base{
	
	private static By message=By.xpath("//*[@id='account-account']/div/div/h2[1]");
	
	public static WebElement message()
	{
		return driver.findElement(message);
	}
	

}
