package Basepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.WebDriverUtilities;

public class Baseclass extends WebDriverUtilities {
	protected WebDriver driver;
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}else
		{
			throw new IllegalArgumentException("Invalid browser value: "+ browser);
		}
		
		
		WebDriverUtilities utils=new WebDriverUtilities();
		utils.Maximizewindow(driver);
		utils.waitforpageload(driver);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null)
		{
			driver.quit();
		}
	}
}
