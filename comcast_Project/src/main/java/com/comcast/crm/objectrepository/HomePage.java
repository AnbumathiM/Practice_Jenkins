package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility  {
	
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement CompaignLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstratorImg;
	
	@FindBy(linkText = "Sign Out")
	WebElement SignOutBtn;
	
	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCompaignLink() {
		return CompaignLink;
	}

	public WebElement getAdminstratorImg() {
		return AdminstratorImg;
	}

	public WebElement getSignOutBtn() {
		return SignOutBtn;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void Logout(WebDriver driver)  {
		mousemoveOnElement(driver, AdminstratorImg);
		
		SignOutBtn.click();
		
	}
}
