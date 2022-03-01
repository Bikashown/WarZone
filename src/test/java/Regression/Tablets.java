package Regression;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import PageObject.Homepage;
import PageObject.Tabletspage;
import ReusableFunctions.Funtions;
import Utility.Basenew;

public class Tablets extends Basenew{
	
	@BeforeMethod
	public void settings() throws IOException, ParserConfigurationException, SAXException
	{
		Funtions.login();
	}
	
	@Test
	public void Tablets_TC01_Verify_the_message_on_tablet_page() throws IOException, ParserConfigurationException, SAXException
	{
		Funtions.fnclickonbutton(Tabletspage.tablet());
		Assert.assertEquals("Tablets", Tabletspage.messageOnTabletpage().getText());
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}

}
