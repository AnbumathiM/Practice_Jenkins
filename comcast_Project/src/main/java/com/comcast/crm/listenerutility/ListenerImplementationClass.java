package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass extends BaseClass implements ITestListener,ISuiteListener{

	public ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite) {
		System.out.println("Report configurartion");
		
		//spark report config
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information & crete test
	  report=new ExtentReports();
	  report.attachReporter(spark);
	  report.setSystemInfo("OS", "Windows-10");
	  report.setSystemInfo("BROWSER", "CHROME-100");
		
	}

	
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	
	public void onTestStart(ITestResult result) {
		System.out.println("===>"+result.getMethod().getMethodName()+">===START===");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+">===STARTED===");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("===>"+result.getMethod().getMethodName()+">===END===");
		test.log(Status.PASS, result.getMethod().getMethodName()+">===COMPLETED===");
	}

	
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.FAIL, "---FAIL---"+methodName);
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,methodName+"_"+time+">===FAILED===");
		
		System.out.println(time);
	}

	
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName);
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		File dsc=new File("./Screenshot/"+methodName+time+".png");
		System.out.println(time);
		
		try {
			FileHandler.copy(src, dsc);
		} catch (IOException e) {
			System.out.println("Catch block");
			e.printStackTrace();
		}
		
		System.out.println("kkkkk");
	}
}
