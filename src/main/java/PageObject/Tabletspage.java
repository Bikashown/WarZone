package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utility.Basenew;

public class Tabletspage extends Basenew{
	
	private static By tablet=By.xpath("//*[@class='nav navbar-nav']/li[4]/a");
	
	private static By messageOnTabletpage=By.cssSelector("#content>h2");
	
	public static WebElement tablet()
	{
		return driver.findElement(tablet);
	}
	
	public static WebElement messageOnTabletpage()
	{
		return driver.findElement(messageOnTabletpage);
	}

}
