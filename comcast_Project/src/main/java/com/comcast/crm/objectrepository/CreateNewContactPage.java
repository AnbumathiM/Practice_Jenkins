package com.comcast.crm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(name = "support_start_date")
	private WebElement SupportStartDateText;

	public WebElement getSupportStartDateText() {
		return SupportStartDateText;
	}
	
	@FindBy(name = "support_end_date")
	private WebElement SupportEndDateText;

	public WebElement getSupportEndDateText() {
		return SupportEndDateText;
	}
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement OrgLookUpImg;
	
	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}
	
	@FindBy(id = "search_txt")
	private WebElement searchTxt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void createContactWithSupportDate(String lastname,String startDate,String endDate) {
		LastNameEdt.sendKeys(lastname);
		SupportStartDateText.clear();
		SupportStartDateText.sendKeys(startDate);
		SupportEndDateText.clear();
		SupportEndDateText.sendKeys(endDate);
		
		saveBtn.click();
	}
	
	public void createContact(WebDriver driver,String LASTNAME,String OrgName) {
		
		LastNameEdt.sendKeys(LASTNAME);
		String parentwindow = driver.getWindowHandle();
		OrgLookUpImg.click();
		switchToTabOnURL(driver, "module=Accounts");
		searchTxt.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		driver.switchTo().window(parentwindow);
		
		saveBtn.click();
	}
	
	

}
