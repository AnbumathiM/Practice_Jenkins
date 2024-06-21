package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void maximizeWindow(WebDriver driver) //update driver reference
	{
			driver.manage().window().maximize(); 
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void waitForElementsToPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver,String partialURL) {
		Set<String> windowhandles = driver.getWindowHandles();
		for(String s:windowhandles) 
		{
			driver.switchTo().window(s);
			String url=driver.getCurrentUrl();
			if(url.contains(partialURL))
			{
				break;
			}
			
		}
	}
	
	public void switchToTabOnParentWindow(WebDriver driver) {
		String parentwindow = driver.getWindowHandle();
		driver.switchTo().window(parentwindow);
		
	}
	
	
	public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
		Set<String> windowhandles = driver.getWindowHandles();
		for(String s:windowhandles) 
		{
			driver.switchTo().window(s);
			String title=driver.getTitle();
			if(title.contains(partialTitle))
			{
				break;
			}
			
		}
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchFrame(WebDriver driver,String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void DropDownByVisibleText(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void DropDownByIndex(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void mousemoveOnElement(WebDriver driver,WebElement element) 
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClickAction(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	

}
