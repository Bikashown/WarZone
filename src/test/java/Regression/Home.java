package Regression;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import PageObject.Homepage;
import ReusableFunctions.Funtions;

import Utility.Basenew;

public class Home extends Basenew{
	@BeforeMethod
	public void settings() throws IOException, ParserConfigurationException, SAXException
	{
		Funtions.login();
	}
	@Test
	public void Home_TC01_Verify_the_message() throws IOException, ParserConfigurationException, SAXException, InterruptedException
	{
		
		Assert.assertEquals("My Account", Homepage.message().getText());
		
	}
	
	@Test
	public void Home_TC02_Verify_desktop_option() throws IOException, ParserConfigurationException, SAXException
	{
		//Hello this is my code.
		//Hello this is my second code push.
		Funtions.fnmovethemouseon(Homepage.desktop());
	}
	
	@Test
	public void Home_TC03_Verify_Laptops_and_Notebooks_option() throws IOException, ParserConfigurationException, SAXException
	{

		Funtions.fnmovethemouseon(Homepage.Laptops_and_Notebooks());
	}
	
	
	
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}


}
