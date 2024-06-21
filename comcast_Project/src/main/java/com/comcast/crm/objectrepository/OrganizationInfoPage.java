package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(className = "dvHeaderText")
	private WebElement OrgHeaderText;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement ActualOrgnameText;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	public WebElement getActualOrgnameText() {
		// TODO Auto-generated method stub
		return ActualOrgnameText;
	}
	
	@FindBy(id = "dtlview_Phone")
	private WebElement ActualPhoneText;
	
	@FindBy(id = "mouseArea_Industry")
	private WebElement IndustryDropDownText;

	public WebElement getActualPhoneText() {
		return ActualPhoneText;
	}
	public WebElement getIndustryDropDownText() {
		return IndustryDropDownText;
	}
	
	}
	

