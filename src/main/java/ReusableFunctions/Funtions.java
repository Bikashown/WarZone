package ReusableFunctions;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import PageObject.Homepage;
import PageObject.Login;

import Utility.Basenew;

public class Funtions extends Basenew{
	
	
	public static void login() throws IOException, ParserConfigurationException, SAXException
	{
		driver=openapplication();
		Login.emailaddress().sendKeys(Funtions.fngetenvironmentaldata("uiusername"));
		Login.password().sendKeys(Funtions.fngetenvironmentaldata("uipassword"));
		Funtions.fnclickonbutton(Login.loginbutton());
	}
	
	
	
	
	   public static String fngetenvironmentaldata(String tagname) throws ParserConfigurationException, SAXException, IOException
		{
		  
			try
			{
				 String envname=null;
				//String path="C:\\Users\\DELL\\Desktop\\Duplicate\\WarZone\\src\\main\\java\\Utility\\info.xml";
				String path=System.getProperty("user.dir")+"\\src\\main\\java\\Utility\\info.xml";
				File file=new File(path);
				DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
				DocumentBuilder builder=dbf.newDocumentBuilder();
				Document doc=builder.parse(file);
				doc.getDocumentElement().normalize();
				//New code
				NodeList nodelistforplatform=doc.getElementsByTagName("project");
				Node nNode=nodelistforplatform.item(0);
				Element eElement=(Element)nNode;
				if(eElement.getAttribute("id").equals("Test"))
				{
					 envname="Test";
				}
				else if(eElement.getAttribute("id").equals("Stage"))
				{
					envname="Stage";
				}
				//End of new code
				NodeList nodelist=doc.getElementsByTagName("environment");
				int length=nodelist.getLength();
				for(int i=0;i<length;i++)
				{
					Node node=nodelist.item(i);
					Element element=(Element)node;
					if(element.getAttribute("env").equalsIgnoreCase(envname))
					{
						 return element.getElementsByTagName(tagname).item(0).getTextContent();
					}
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return null;
			
		}
	   
	   public static void fnclickonbutton(WebElement element)
	   {
          try {
        	
        	  element.click(); 
        	  
          }	
          catch(Exception e)
          {
        	  e.printStackTrace();
          }
	   }
	   
	   public static void fnmovethemouseon(WebElement element)
	   {
          try {
        	
        	  Actions a=new Actions(driver);
        	  a.moveToElement(element).click().build().perform();
        	  
        	  String[] itemstoverifywithDesktops= {"PC (0)","Ma","Show All Desktops"};
        	  List items=Arrays.asList(itemstoverifywithDesktops);
        	  Thread.sleep(10000);
        	  WebElement popup=driver.findElement(By.cssSelector(".dropdown.open>div"));
        	  Thread.sleep(4000);
        	  int count=popup.findElements(By.tagName("a")).size();
        	  
        	  for(int i=0;i<count;i++)
        	  {
        		String itemName= popup.findElements(By.tagName("a")).get(i).getText();
        		if(items.contains(itemName))
        		{
        			Assert.assertTrue(true);
        			
        		}
        		else
        		{
        			Assert.assertTrue(false);
        		}
        	  }
        	  
          }	
          catch(Exception e)
          {
        	  e.printStackTrace();
          }
	   }
	   
	   
	 

}
