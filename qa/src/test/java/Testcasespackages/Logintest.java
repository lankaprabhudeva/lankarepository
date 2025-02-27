package Testcasespackages;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Basepackage.Baseclass;
import Pagespackages.Loginpage;

public class Logintest extends Baseclass {

	@Test
	
	
	@Parameters({"username","password"})
	
	public void testLogin(String username,String password)
	{
		Loginpage lp=new Loginpage(driver);
		lp.username(username);
		lp.password(password);
		lp.loginbutton();
		
	}

	
}
