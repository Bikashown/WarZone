package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	public static WebDriver opentheapplication() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\WarZone\\src\\main\\java\\Utility\\Info.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Desktop\\WebDriver\\chromedriver.exe");        
	      driver=new ChromeDriver(); 
	      driver.get(prop.getProperty("url"));
	    }
	    else if(browserName.equalsIgnoreCase("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver","C:\\Users\\DELL\\Desktop\\WebDriver\\geckodriver.exe");
	    	driver= new FirefoxDriver();
	    	 driver.get(prop.getProperty("url"));
	    }
	    else
	    {
	    	System.setProperty("webdriver.edge.driver","C:\\Users\\DELL\\Desktop\\WebDriver\\msedgedriver.exe");
	    	   driver = new EdgeDriver();
	    	  driver.get(prop.getProperty("url"));
	    }
		
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
