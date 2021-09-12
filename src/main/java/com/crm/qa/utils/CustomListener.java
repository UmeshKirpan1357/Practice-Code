package com.crm.qa.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;

public class CustomListener extends TestBase implements ITestListener {

	public void onFinish(ITestContext result) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onStart(ITestContext result) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    	System.out.println("Test Case Fail");
   
    }		

    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		
}
