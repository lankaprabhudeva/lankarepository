package Pagespackages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	private WebDriver driver;
	
	
	@FindBy(xpath="//input[@name=\"username\"]")
	WebElement usernamefield;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement passwordfield;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement longinbutton;
	
	
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void username(String username) {
		usernamefield.sendKeys("Admin");
	}
	
	public void password(String password) {
		passwordfield.sendKeys("admin123");
	}
	public void loginbutton() {
		longinbutton.click();
	}
	
	
	//without using pagefactory class
	/*private By uname=By.xpath("//input[@name=\"username\"]");
	private By Password=By.xpath("//input[@name=\"password\"]");
	private By loginbutton=By.xpath("//button[@type=\"submit\"]")
	
	
	
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
	}*/

}
