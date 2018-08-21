package BusinessComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.ApplicationCommonOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class ClearanceResultPage extends SeleniumHelper{
	
	public ClearanceResultPage(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}	
	
	public void performActionOnClearanceResultPage(DetailedReport test,String tempNo,String buttonOption){
		try {
			waitForPageElementToLoad();
			waitForTheElementToBeLoad(ApplicationCommonOR.CLEARANCE_RESULT,"Clearance tab");
			enterInputTextvalueByJavaScript(ApplicationCommonOR.TEMP_IR_NUMBER, tempNo,"Enter Temp IR No.",_objDetailedReport);
			String getActualString = String.format(ApplicationCommonOR.PROCEED_TO_QUOTE, buttonOption);
			By xpathString = By.xpath(getActualString);
			WebElement elmString = _Browser.findElement(xpathString);
			waitForTheElementToBeLoad(xpathString,"clearance page");			
			clickOnButton(elmString,test,buttonOption);
			if (buttonOption.contains("Decline")) {
				String strActualString = String.format(ApplicationCommonOR.DECLINE_SUBMISSION_RESONS, "Pricing");
				By xpath = By.xpath(strActualString);
				WebElement elm = _Browser.findElement(xpath);
				if (elm != null) {
					clickOnButton(elm, test, "Pricing: ");
					
				}
				//Close Submission
			}else if (buttonOption.contains("Close")) {
				String strActualString = String.format(ApplicationCommonOR.CLOSE_SUBMISSION_RESONS, "Lapsed");
				By xpath = By.xpath(strActualString);
				WebElement elm = _Browser.findElement(xpath);
				if (elm != null) {
					clickOnButton(elm, test, "Lapsed: ");
				}
			}
			waitForPageElementToLoad();					
			waitForTheElementToBeLoad(ApplicationCommonOR.IMAGERIGHT_PROCEED_POPUP,"ImageRight Proceed Popup");			
			waitForTheElementToBeLoad(ApplicationCommonOR.IR_NOT_FOUND_PROCEED,"Proceed button");			
			clickWithJavaScriptEXecutor(ApplicationCommonOR.IR_NOT_FOUND_PROCEED, test,"Proceed to Quote For Not found");
			waitForPageElementToLoad();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	
}
