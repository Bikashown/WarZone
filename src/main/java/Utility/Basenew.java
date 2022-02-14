package Utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Basenew {
   public static WebDriver driver;
   
   
   public static String fngetenvironmentaldata(String tagname) throws ParserConfigurationException, SAXException, IOException
	{
	  
		try
		{
			 String envname=null;
			String path="C:\\Users\\DELL\\Desktop\\Duplicate\\WarZone\\src\\main\\java\\Utility\\info.xml";
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
   
   public static WebDriver openapplication() throws ParserConfigurationException, SAXException, IOException
	{
		
				//String urlname=element.getElementsByTagName("url");
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		    	driver= new FirefoxDriver();
		    	  driver.get(Basenew.fngetenvironmentaldata("url"));
		  		
		  		
		  		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		  		return driver;
			}
   
   public void screenshot(String testcasename,WebDriver driver) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/target/Screenshots/"+testcasename+".png";
		FileUtils.copyFile(src, new File(destination));
		
	}
			

	
}
  

	

