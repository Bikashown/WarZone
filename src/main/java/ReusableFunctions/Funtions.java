package ReusableFunctions;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import PageObject.Login;

import Utility.Basenew;

public class Funtions extends Basenew{
	
	public static void login() throws IOException, ParserConfigurationException, SAXException
	{
		driver=openapplication();
		Login.emailaddress().sendKeys("78bikash.hyd@gmail.com");
		Login.password().sendKeys("india1988");
		Login.loginbutton().click();
	}
	
	
	

}
