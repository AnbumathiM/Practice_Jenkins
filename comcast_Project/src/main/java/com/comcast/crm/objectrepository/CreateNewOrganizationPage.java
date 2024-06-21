package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	@FindBy(name = "accountname")
	private WebElement OrgnameEdt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public CreateNewOrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getOrgnameEdt() {
		return OrgnameEdt;
	}
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}
	
	@FindBy(id = "phone")
	private WebElement phoneEdt;
	
	
	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public void createOrganization(String OrgName)
	{
		OrgnameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	
	public void createOrgwithIndustry(String OrgName,String INDUSTRY)
	{	
		OrgnameEdt.sendKeys(OrgName);
		DropDownByVisibleText(IndustryDropDown, INDUSTRY);
		
		saveBtn.click();
	}
	public void createOrgawithphone(String OrgName,String phone)
	{	
		OrgnameEdt.sendKeys(OrgName);
		phoneEdt.sendKeys(phone);
		saveBtn.click();
}
}