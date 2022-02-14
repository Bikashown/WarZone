package Regression;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import PageObject.Homepage;
import ReusableFunctions.Funtions;

import Utility.Basenew;

public class Home extends Basenew{
	@Test
	public void Verify_the_message() throws IOException, ParserConfigurationException, SAXException
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
