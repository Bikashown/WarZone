package ReusableFunctions;

import java.io.IOException;

import PageObject.Login;
import Utility.Base;

public class Funtions extends Base{
	
	public static void login() throws IOException
	{
		driver=opentheapplication();
		Login.emailaddress().sendKeys("78bikash.hyd@gmail.com");
		Login.password().sendKeys("india1988");
		Login.loginbutton().click();
	}

}
