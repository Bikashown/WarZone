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
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ReusableFunctions.Funtions;

public class Basenew {
   public static WebDriver driver;
   
   

   public static WebDriver openapplication() throws ParserConfigurationException, SAXException, IOException
	{
	       
	        	System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
		    	driver= new EdgeDriver();
		    	  driver.get(Funtions.fngetenvironmentaldata("url"));
	        
			
			
		  		
		  		
		  		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		  		driver.manage().window().maximize();
		  		return driver;
			}
   
   public void screenshot(String testcasename,WebDriver driver) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/target/Screenshots/"+testcasename+".png";
		FileUtils.copyFile(src, new File(destination));
		
	}
   
 

	
}
  

	

