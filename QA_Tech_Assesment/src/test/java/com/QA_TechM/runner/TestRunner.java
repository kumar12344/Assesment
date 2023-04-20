package com.QA_TechM.runner;



import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions 
		(
		features = {"src/test/resources/Features"},  //tags to run feature file
		//features = "classpath:Features",
		glue = {"com.QA_TechM.StepDefinition"}, //path of the step def file
		//plugin = {"pretty","html:test-output/index.html","json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //To generating the different reports
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true, //OutPut in console in a readable format
		//strict = true, // It will check if any step is not define in step def file
		dryRun = false, // To check the mapping is proper between feature file and step def file
		tags = "@TestHomePage"
		
		
		
		
	//	publish = true
				
				)


 public class TestRunner {
	
  
 
		}

