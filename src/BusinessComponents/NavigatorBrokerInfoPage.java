package BusinessComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ObjectRepository.ApplicationCommonOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorBrokerInfoPage extends SeleniumHelper {

	public NavigatorBrokerInfoPage(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails){
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}	
	
	public void setBrokerInformation(By elm,DetailedReport test) throws Exception{
		
		waitForTheElementToBeLoad(elm,"Broker Info");		
		clickWithJavaScriptEXecutor(elm,test,"Broker Info Link");
		waitForTheElementToBeLoad(ApplicationCommonOR.BROKERTYPE_ID,"Broker Type");		
		selectDropDownValuesByEnteringText("Retailer", ApplicationCommonOR.BROKERTYPE_ID, ApplicationCommonOR.BROKER_INPUT_TXT, ApplicationCommonOR.BROKERTYPE_RESULT, "Broker Type",test);
		
	}	
}
