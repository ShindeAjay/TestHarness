package BusinessComponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import ObjectRepository.NavigatorAccountSetupOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorAccountSetupPage extends SeleniumHelper{
	
	public NavigatorAccountSetupPage(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	
	public String setUpAccountOnNavigator(){		
		String insuredName = null;
		try {
			clickOnAccountSetupLink(_objDetailedReport);
			// Selecting Insured Product from Dropdown
			selectDropDownValuesByEnteringText(_testDataManage.getData("Insurance Product"),
					NavigatorAccountSetupOR.INSURED_PRODUCT_CONTAINER, NavigatorAccountSetupOR.INSURED_PRODUCT_TXTBOX,
					NavigatorAccountSetupOR.INSURED_PRODUCT_LIST, "Insured Product",_objDetailedReport);
			// Enter Start Date
			int startDateAndEndDate = getTodaysDay();
			selectDateByFromAndTo(NavigatorAccountSetupOR.STARTDATE_INPUTTEXTBOX,
					String.valueOf(startDateAndEndDate),
					NavigatorAccountSetupOR.ACCOUNT_STARTDATE_ENDDATE, NavigatorAccountSetupOR.TODAYS_DATE_DONE_BTN,"Start Date");
			// Enter End Date
			selectDateByFromAndTo(NavigatorAccountSetupOR.ENDDATE_INPUTTEXTBOX,
					String.valueOf(startDateAndEndDate),
					NavigatorAccountSetupOR.ACCOUNT_STARTDATE_ENDDATE, NavigatorAccountSetupOR.TODAYS_DATE_DONE_BTN,"End date");
			
			selectDropDownValuesByEnteringText(_testDataManage.getData("Three Letter code"), 
					NavigatorAccountSetupOR.THREE_LETTER_CODE_CONTAINER, NavigatorAccountSetupOR.INSURED_PRODUCT_TXTBOX,
					NavigatorAccountSetupOR.THREE_LETTER_CODE_LIST, "Three Letter",_objDetailedReport);
			// Selecting Broker from Dropdown
			selectDropDownValuesByEnteringText(_testDataManage.getData("Broker"),
					NavigatorAccountSetupOR.EDIT_BROKER_LIST, NavigatorAccountSetupOR.INSURED_PRODUCT_TXTBOX,
					NavigatorAccountSetupOR.BROKER_SELECT_OPTION, "Broker",_objDetailedReport);
			// Selecting Underwriter from Dropdown
			selectDropDownValuesByEnteringText(_testDataManage.getData("Underwriter"),
					NavigatorAccountSetupOR.UNDERWRITER_LOOKUP_CONTAINER, NavigatorAccountSetupOR.INSURED_PRODUCT_TXTBOX,
					NavigatorAccountSetupOR.UNDERWRITER_LIST, "Underwriter",_objDetailedReport);
			// Enter Insured Name
		//	insuredName = getInsuredRandomName(_testDataManage.getData("Insured Name"));
			selectDropDownValuesByEnteringText(_testDataManage.getData("Insured Name"), NavigatorAccountSetupOR.ACCOUNT_INSURED_NAME,
					NavigatorAccountSetupOR.INSURED_PRODUCT_TXTBOX, NavigatorAccountSetupOR.INSURED_NAME, "Insured Name",_objDetailedReport);
			// Enter Address Details
			enterTextByStepDetails(_testDataManage.getData("Address1"),
					NavigatorAccountSetupOR.ACCOUNTSETUP_ADDRESS,"Address",_objDetailedReport);
			// Enter City Details
			enterTextByStepDetails(_testDataManage.getData("City"),
					NavigatorAccountSetupOR.ACCOUNTSETUP_CITY,"City",_objDetailedReport);
			// Selecting State
			selectDropDownValuesByEnteringText(_testDataManage.getData("Select State/Province"),
					NavigatorAccountSetupOR.STATELOOKUP_CONTAINER, NavigatorAccountSetupOR.INSURED_PRODUCT_TXTBOX,
					NavigatorAccountSetupOR.STATE_LIST, "State",_objDetailedReport);
			// Enter Postal Code
			enterTextByStepDetails(_testDataManage.getData("Postal Code"),
					NavigatorAccountSetupOR.POSTAL_CODE,"Postal Code",_objDetailedReport);
			// Click on Clear and Continue button
			clickOnClearAndContinue(_objDetailedReport);
			
			getClearanceResultTab(_objDetailedReport);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return insuredName;
	}
	
	public void clickOnAccountSetupLink(DetailedReport test) throws Exception {
		waitForTheElementToBeLoad(NavigatorAccountSetupOR.ACCOUNT_SETUP_LINK,"Account Setup");
		// clickOnElement(navigSetupOR.getACCOUNT_SETUP_LINK());
		clickOnButton(NavigatorAccountSetupOR.ACCOUNT_SETUP_LINK, test, "Account Setup Link :");
		_Browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		waitForPageElementToLoad();
	}

	public void clickOnClearAndContinue(DetailedReport test) {
		try {
			waitForTheElementToBeLoad(NavigatorAccountSetupOR.CLEAR_AND_CONTINUE,"Clear And Continue");
			clickOnButton(NavigatorAccountSetupOR.CLEAR_AND_CONTINUE, test, "Clear and Continue");
			waitForPageElementToLoad();
			_Browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public boolean getClearanceResultTab(DetailedReport test) throws InterruptedException {
		waitForPageElementToLoad();
		_Browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			waitForTheElementToBeLoad(NavigatorAccountSetupOR.CLEARANCE_RESULT,"clearance Result");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getMissingFieldsMessageOnAccountSetup() throws Exception {

		String STATUS = null;
		waitForPageElementToLoad();
		waitForTheElementToBeLoad(NavigatorAccountSetupOR.MISSING_FIELD_MESSAGE,"Missing Field Message");
		String getStatusValue = _Browser.findElement(NavigatorAccountSetupOR.MISSING_FIELD_MESSAGE).getText();
		if (!getStatusValue.isEmpty()) {
			STATUS = getStatusValue.trim();
		} else {
			STATUS = "";
		}
		return STATUS;
	}
	
	public String getCommentAndAttachements(DetailedReport test) throws Exception{
		waitForTheElementToBeLoad(NavigatorAccountSetupOR.INSURED_PRODUCT_CONTAINER,"Insured Product");
		waitForTheElementToBeLoad(NavigatorAccountSetupOR.COMMENT_ATTACHMENT__LINK,"Comment Attachment");
		clickOnElement(NavigatorAccountSetupOR.COMMENT_ATTACHMENT__LINK);
		waitForTheElementToBeLoad(NavigatorAccountSetupOR.COMMENT_ACCOUNTSETUPSCREEN,"Account Screen");
		String getString = _Browser.findElement(NavigatorAccountSetupOR.COMMENT_ACCOUNTSETUPSCREEN).getText();		
		return getString;	
	}	
}
