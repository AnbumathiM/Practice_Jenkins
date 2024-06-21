package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtilty;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.ContactInfoPage;
import com.comcast.crm.objectrepository.ContactPage;
import com.comcast.crm.objectrepository.CreateNewContactPage;
import com.comcast.crm.objectrepository.CreateNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.OrganizationInfoPage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class CreateContactTest extends BaseClass {
//
	//changes
	@Test(groups = "Smoke Testing")
	public void createContactTest() throws Throwable {

		String lastName = elib.getDataFromExcelFile("contact", 1, 2) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateOrgLookUpImg().click();

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.getLastNameEdt().sendKeys(lastName);
		ccp.getSaveBtn().click();

		ContactInfoPage cip = new ContactInfoPage(driver);

		String headerInfo = cip.getContactHeaderText().getText();
		
		
		 boolean status = headerInfo.contains(lastName);
		 
		 Assert.assertTrue(status);
			System.out.println(lastName + "contact successfully created");
		

		String actualcontact = cip.getLastnameText().getText();

		boolean status2 = actualcontact.equals(lastName);
		
		SoftAssert assertobj=new SoftAssert();
		assertobj.assertTrue(status2);
			System.out.println(lastName + " information is verified==PASS");
			
			assertobj.assertAll();
		

	}

	@Test(groups = "Regression Testing")
	public void createContactWithSupportDateTest() throws Throwable {

		String lastName = elib.getDataFromExcelFile("contact", 1, 2) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateOrgLookUpImg().click();

		String StartDate = jlib.getSystemDateYYYYMMDD();
		String EndDate = jlib.getSystemDateYYYYMMDD(30);
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactWithSupportDate(lastName, StartDate, EndDate);
		ContactInfoPage cip=new ContactInfoPage(driver);
		
		String actualdate = cip.getActualstartdate().getText();

		boolean status = actualdate.equals(StartDate);
			SoftAssert assertobj=new SoftAssert();
		assertobj.assertTrue(status);
		
			System.out.println(actualdate + " information is verified==PASS");
		
		

		String actualenddate = cip.getActualenddate().getText();

		boolean status2=actualenddate.equals(EndDate);
		assertobj.assertTrue(status);
			System.out.println(EndDate + " information is verified==PASS");
			

			assertobj.assertAll();
	}
	
	@Test(groups = "Regression Testing")
	public void createContactWithOrgTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrgLookUpImg().click();
		
	 String orgName = elib.getDataFromExcelFile("org",1, 2)+jlib.getRandomNumber();
	 System.out.println(orgName);
	 
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.getOrgnameEdt().sendKeys(orgName);
		cnop.getSaveBtn().click();
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String headerInfo = oip.getOrgHeaderText().getText();
		
		
		  boolean status = headerInfo.contains(orgName);
		  Assert.assertEquals(status, true);
		  System.out.println(orgName+" Organization successfully created"); 
		 
		hp.getContactLink().click();
		ContactPage cp=new ContactPage(driver);
		cp.getCreateOrgLookUpImg().click();
		
		String lastname = elib.getDataFromExcelFile("contact", 1, 2)+jlib.getRandomNumber();
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.getOrgLookUpImg().click();
		cncp.createContact(driver, lastname, orgName);
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerInfo1 = cip.getContactHeaderText().getText();
		boolean status2 = headerInfo1.contains(lastname);
		 
		 Assert.assertTrue(status2);
			System.out.println(lastname + "contact successfully created");
		
		
	}
}
