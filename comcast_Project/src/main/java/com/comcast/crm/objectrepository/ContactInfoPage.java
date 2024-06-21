package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(className = "dvHeaderText")
	private WebElement ContactHeaderText;
	
	public ContactInfoPage(WebDriver driver)//test script
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement LastnameText;

	public WebElement getLastnameText() {
		return LastnameText;
	}
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement actualstartdate;
	
	public WebElement getActualstartdate() {
		return actualstartdate;
	}

	public WebElement getActualenddate() {
		return actualenddate;
	}

	@FindBy(id = "dtlview_Support End Date")
	private WebElement actualenddate;
}
