package com.QA_TechM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA_TechM.utils.QA_TechM_TestBase;

public class QA_TechM_dashboardPage extends QA_TechM_TestBase{

	//Page factory or Object Repository
	
			@FindBy(xpath = ".//div[@class ='endpoints']")
			WebElement endPoints;
			@FindBy(xpath = ".//li[@data-id ='users-single-not-found']")
			WebElement SpecificEndPoint;
			@FindBy(xpath = ".//span[@class='url']")
			WebElement RequestUrl;
			@FindBy(xpath = ".//span[@class='response-code bad']")
			WebElement Response;
			
			
			public QA_TechM_dashboardPage()
			{
				PageFactory.initElements(driver, this);
			}
			
		//	Actions:
			public String ValidatePageTitle()
			{
				return driver.getTitle();
			
			}
			public void CaptureEndPoints() {
				String EndPoints = endPoints.getText();
				System.out.println("EndPoints are "+EndPoints);
			}
			public void SelectSpecificEndPoint() {
				SpecificEndPoint.click();
				System.out.println("Request Url is "+RequestUrl.getText());
				System.out.println("Response is "+Response.getText());
			}
			
}
