package com.hubspot.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ExtendReportListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test is started..."+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed...."+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("the name of the test case is failed:"+result.getName());
		
	}

	public void onTestSkipped(ITestResult skipped) {
		System.out.println(skipped.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("About to begin executing test:"+context.getName(),true);
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
//reports==html,testng,emailable reports//all reports are generated after the test
	//LIstener report==>>>starts with test case and stop with test case
	//if you have aproblem it can report that promlem.
	
}
