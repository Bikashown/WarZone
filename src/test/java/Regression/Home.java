package Regression;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageObject.Homepage;
import ReusableFunctions.Funtions;
import Utility.Base;

public class Home extends Base{
	@Test
	public void verify_the_message() throws IOException
	{
		Funtions.login();
		Assert.assertEquals("My Account", Homepage.message().getText());
		//driver.switchTo().frame(0);
	
	}
	
	@AfterTest
	public void closebrowser()
	{
		driver.quit();
	}

}
