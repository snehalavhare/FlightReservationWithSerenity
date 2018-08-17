package com.serenity.test.Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import TestBase.ExtentReportListener;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/flight_featuredetails",
		glue = {"com.serenity.test.stepDefinition"},
		format = {"pretty"},
		monochrome = true
		)


@Listeners(ExtentReportListener.class)
public class TestRunner 
{
//	 private TestNGCucumberRunner testNGCucumberRunner;
//	  
//	 @BeforeClass(alwaysRun = true)
//	    public void setUpClass() throws Exception 
//	 	{
//	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//	    }
//
//	 
//	 @AfterClass(alwaysRun = true)
//	    public void tearDownClass() throws Exception 
//	 	{
//	        if (testNGCucumberRunner == null) 
//	        {
//	            return;
//	        }
//	        testNGCucumberRunner.finish();
//	 	} 
	
}

