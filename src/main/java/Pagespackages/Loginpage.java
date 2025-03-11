package Pagespackages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Loginpage {
	
	private WebDriver driver;
	private WebDriverWait wait; // Declare WebDriverWait
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement usernamefield;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordfield;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginbutton;
	
	
	@FindBy(xpath="//h6[text()=\"Dashboard\"]")
	private WebElement dashboardHeader ;
	
	@FindBy(xpath="//p[contains(@class, \"oxd-alert-content-text\")]")
	private WebElement erormessage;
	
	// Constructor
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait
		PageFactory.initElements(driver, this);
	}
	
	// Method to enter username with explicit wait
	public void enterUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(usernamefield)); // Wait until visible
		usernamefield.sendKeys(username);
	}
	
	// Method to enter password with explicit wait
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordfield)); // Wait until visible
		passwordfield.sendKeys(password);
	}
	
	// Method to click login button with explicit wait
	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton)); // Wait until clickable
		loginbutton.click();
	}
	
	public boolean isDashboarddisplayed() {
		return dashboardHeader.isDisplayed();
	}
    
	public String Errormessage() {
		return erormessage.getText();
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
