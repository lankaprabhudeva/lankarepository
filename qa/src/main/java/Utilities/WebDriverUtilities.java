package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilities {
	
	public void Maximizewindow(WebDriver driver) {
		
		driver.manage().window().maximize();
		
	}
    public void Minimizewindow(WebDriver driver) {
    	driver.manage().window().minimize();
    }
    public void waitforpageload(WebDriver driver) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
    }
    public void WaitforElementtobevisibility(WebDriver driver,WebElement element){
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void WaitForElementtobeclickable(WebDriver driver ,WebElement element) {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    	
    }
    public void Handledropdown(WebElement element ,int index) {
    	Select s=new Select(element);
    	s.selectByIndex(index);
    }
    public void Handledropdown1(WebElement element ,String value) {
    	Select s=new Select(element);
    	s.selectByValue(value);
    }
    
    	
    
    public void Handledropdown(WebElement element,String text) {
    	Select s=new Select(element);
    	s.selectByVisibleText(text);
    	
    }
    public void RightclickonPage(WebDriver driver) {
    	Actions act=new Actions(driver);
    	act.contextClick().build().perform();
    }
    public void Rightclickonwebelement(WebDriver driver,WebElement element) {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).contextClick().build().perform();;
    }
    public void mousehover(WebDriver driver,WebElement element) {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).click().build().perform();
    }
    public void Doubleclick(WebDriver driver ,WebElement element) {
    	Actions act=new Actions(driver);
    	act.doubleClick().build().perform();
    	
    }
    public void PressEnterKey() throws AWTException {
    	Robot r=new Robot();
    	r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
    }
    public void CopyText() throws AWTException {
    	Robot r=new Robot();
    	r.keyPress(KeyEvent.VK_CONTROL);
    	r.keyPress(KeyEvent.VK_C);
    	
    	r.keyRelease(KeyEvent.VK_CONTROL);
    	r.keyRelease(KeyEvent.VK_C);
    }
    public void PasteText() throws AWTException {
    	Robot r=new Robot();
    	r.keyPress(KeyEvent.VK_CONTROL);
    	r.keyPress(KeyEvent.VK_V);
    	
    	r.keyRelease(KeyEvent.VK_CONTROL);
    	r.keyRelease(KeyEvent.VK_V);
    	
    }
    
    public void ScrollActions(WebDriver driver) {
    	 
    	JavascriptExecutor js =(JavascriptExecutor)driver;
    	js.executeScript("windows.scrollBy(0,500)", " ");
    	
    }
    
    public void ScrollActions(WebDriver driver,WebElement element) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	int y=element.getLocation().getY();
    	js.executeScript("windows.scrollBy(0,"+y+")", " ");
    	
    }
    public String TakesScreenshot(WebDriver driver ,String screenshotname) throws IOException {
    	
    	org.openqa.selenium.TakesScreenshot screenshot=(org.openqa.selenium.TakesScreenshot)driver;
    	File src=screenshot.getScreenshotAs(OutputType.FILE);
    	
    	File dest=new File(".\\Qascreenshot\\"+screenshotname+".png");
    	FileUtils.moveFile(src,dest);
    	return dest.getAbsolutePath();
    	
    }
    
}
