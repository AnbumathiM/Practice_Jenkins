package com.comcast.crm.organizationTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepository.CreateNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationInfoPage;
import com.comcast.crm.objectrepository.OrganizationPage;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass {

	//change
	  @Test(groups = "Smoke Testing")
	  public void createOrgTest() throws Throwable {
	 
	  HomePage hp=new HomePage(driver); 
	  hp.getOrgLink().click();
	  
	  OrganizationPage op=new OrganizationPage(driver);
	  op.getCreateOrgLookUpImg().click();
	  
	  String orgName = elib.getDataFromExcelFile("org",1,2)+jlib.getRandomNumber();
	  //System.out.println(orgName);
	  UtilityClassObject.getTest().log(Status.INFO, orgName);
	  
	  CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	  cnop.getOrgnameEdt().sendKeys(orgName); 
	  cnop.getSaveBtn().click();
	 
	  OrganizationInfoPage oip=new OrganizationInfoPage(driver); 
	  String headerInfo= oip.getOrgHeaderText().getText();
	 
	  boolean status = headerInfo.contains(orgName);
	  Assert.assertEquals(status, true);
	  UtilityClassObject.getTest().log(Status.INFO,orgName+" Organization successfully created"); 
	 System.out.println(orgName+" Organization successfully created");
	  }
	 
}
