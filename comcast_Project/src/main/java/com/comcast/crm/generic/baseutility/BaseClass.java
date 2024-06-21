package com.comcast.crm.generic.baseutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtilty;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
/**
 * This class consists of all the basic configuration annotations for
 *  all the common actions
 * 
 * @author Nithish
 *
 */

public class BaseClass {
	
	public	WebDriverUtility wlib=new WebDriverUtility();
	public	DataBaseUtility dlib=new DataBaseUtility();
	public	FileUtility flib=new FileUtility();
	public	ExcelUtility elib=new ExcelUtility();
	public	JavaUtilty jlib=new JavaUtilty();
	
	//only used for listener to take screenshot
	public static WebDriver sdriver;
	public	WebDriver driver=null;
	
	@BeforeSuite
	public void configBS() {
		dlib.getDbconnection();
		System.out.println("==connect to DB, Report Config==");
	}
	
	//@Parameters("BROWSER")//only for cross browser execution for others we should remove this
	@BeforeClass(groups = {"Smoke Testing","Regression Testing"})
	
	public void configBC() throws Throwable {
		//String BROWSER1=flib.getDataFromPropertyFile("browser");
		
		//to pass parameter in run time
	String BROWSER=System.getProperty("browser",flib.getDataFromPropertyFile("browser"));
	//only for cross browser execution
	//public void configBC(String browser) {
		//String BROWSER=browser;
		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))	
		{
			driver=new EdgeDriver();	
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		//only used for listener to take screenshot
				sdriver=driver;
				
				UtilityClassObject.setTest(driver);
		
		System.out.println(BROWSER+" ==Launch the Browser==");
	}
	
	@BeforeMethod(groups = {"Smoke Testing","Regression Testing"})
	public void configBM() throws Throwable {
		
		//to pass parameter in run time
		
		String URL = System.getProperty("url",flib.getDataFromPropertyFile("url"));
		String USERNAME=System.getProperty("username",flib.getDataFromPropertyFile("username"));
		String PASSWORD=System.getProperty("password",flib.getDataFromPropertyFile("password"));
		
		/*
		String URL1 = flib.getDataFromPropertyFile("url");
		String USERNAME1=flib.getDataFromPropertyFile("username");
		String PASSWORD1=flib.getDataFromPropertyFile("password");
		*/
		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginApp(USERNAME, PASSWORD);
		System.out.println("=== Login successful ===");
	}
	
	@AfterMethod(groups = {"Smoke Testing","Regression Testing"})
	public void configAM() {
		HomePage hp=new HomePage(driver);
		hp.Logout(driver);
		System.out.println("=== Logout successful ===");
	}
	
	@AfterClass(groups = {"Smoke Testing","Regression Testing"})
	public void configAC() {
		driver.quit();
		System.out.println("===Browser closed===");
	}
	
	@AfterSuite
	public void configAs() throws Throwable {
		dlib.closeDbconnection();
		System.out.println("=== DB connection closed,Report backup ===");
	}
	
}
