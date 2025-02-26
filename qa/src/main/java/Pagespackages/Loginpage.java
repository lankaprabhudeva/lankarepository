package Pagespackages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	
	private WebDriver driver;
	
	private By uname=By.xpath("//input[@name=\"username\"]");
	private By Password=By.xpath("//input[@name=\"password\"]");
	private By loginbutton=By.xpath("//button[@type=\"submit\"]");
	
	
	
	public Loginpage(WebDriver driver ) {
		this.driver=driver;
		
	}
		
	public void enterusername(String username)
	{
		driver.findElement(uname).sendKeys("Admin");
	}
	public void enterpassword(String password)
	{
		driver.findElement(Password).sendKeys("admin123");
		
	}
	public void clicklogin()
	{
		driver.findElement(loginbutton).click();
	}

}
