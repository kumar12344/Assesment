package com.QA_TechM.StepDefinition;

import com.QA_TechM.pages.QA_TechM_dashboardPage;
import com.QA_TechM.utils.QA_TechM_TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QA_TechM_dashboardSteps extends QA_TechM_TestBase {
	QA_TechM_dashboardPage dashboardpge;
	
	@Given("User navigate to home page by using URL")
	public void user_navigate_to_home_page_by_using_url() throws InterruptedException {
	   
		QA_TechM_TestBase.initilization();
		dashboardpge = new QA_TechM_dashboardPage();
		dashboardpge.ValidatePageTitle();
		
	
	}
		@Then("User capture list of different request types, end points")
		public void user_capture_list_of_different_request_types_end_points() {
			dashboardpge.CaptureEndPoints();
		}

		@Then("User select specific option and capture the sample request and response")
		public void user_select_specific_option_and_capture_the_sample_request_and_response() {
			dashboardpge.SelectSpecificEndPoint();
		    
		}
	

}