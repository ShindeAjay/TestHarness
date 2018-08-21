package BusinessComponents;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.GlassAccountSetupPageOR;
import ObjectRepository.NavigatorLoginPageOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class GlassAccountSetupPage extends SeleniumHelper {	

	public GlassAccountSetupPage(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	public static String insuredName;
	private By HEADER_NAME = By
			.xpath(".//*[@id='gview_myWorkGrid']//*[@class='ui-jqgrid-hdiv']//table/thead/tr[1]/th/div");
	private String STATUS_STRING = ".//*[@id='myWorkGrid']//tr[2]/td[%d]";
	//Navigate Glass URL
	public void navigateGlassLink() {
		hitGivenURL("URL", _objDetailedReport, _testDataManage.getData("URL"));
	}
	//Clicking on Account Setup Link
	public void accountSetupLink() throws Exception {
		waitForTheElementToBeLoad(GlassAccountSetupPageOR.ACCOUNTSETUP_LINK, "Account Setup");
		clickOnLink(GlassAccountSetupPageOR.ACCOUNTSETUP_LINK,"New Account Setup", "Account Setup",
				_objDetailedReport);
	}
	//Calling Setup Account 
	public String setupGlobalAccount(String insuredName) throws Exception {
		navigateGlassLink();
		accountSetupLink();
		return setUPGlassAccount(insuredName,_testDataManage.getData("Insurance Product"), _testDataManage.getData("Three Letter code"),
				_testDataManage.getData("Underwriter"), _testDataManage.getData("Broker"),
				_testDataManage.getData("Broker Contact"));		 
	}
	// Calling Clearance Page
	public void completeSubmission(String action) throws Exception {
		setTempIROnSubmissionCompletion(action);
	}
	// calling Status Method
	public String getStatusByInsuredName(String insuredName,DetailedReport test){
		return getStatus(insuredName, test);
	}
	/***************************************************
	 * Declaration of Functions Page wise Date :- 7/31/2018 Author :- LNT
	 * Infotech.
	 * 
	 * @return
	 */
	private String setUPGlassAccount(String _iName,String _insuredP, String _threeLC, String _underWriter, String _broker,
			String _brokerC) {
		boolean isflag = true;
		String returnInsuredName =null;
		try {
			// waitForJQueryLoad();
			// Selecting Insured Name from the DropDown.
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.INSURED_PRODUCT_CONTAINER, "Insured Product");
			selectDropDownValuesByEnteringText(_insuredP, GlassAccountSetupPageOR.INSURED_PRODUCT_CONTAINER,
					GlassAccountSetupPageOR.COMMON_DROPDOWN_TXTBOX, GlassAccountSetupPageOR.INSURED_RESULT_TEXTSEARCH,
					"Insured Product", _objDetailedReport);
			// Selecting 3 Letter Code from the Dropdown.
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.LETTERCODE_CONTAINER, "Three Letter");
			selectDropDownValuesByEnteringText(_threeLC, GlassAccountSetupPageOR.LETTERCODE_CONTAINER,
					GlassAccountSetupPageOR.COMMON_DROPDOWN_TXTBOX, GlassAccountSetupPageOR.LETTER_RESULT_TEXTSEARCH,
					"Three Letter", _objDetailedReport);
			// Selecting UnderWriter Code from the Dropdown
			waitForPageToLoadByCounter(5);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.UW_PRODUCT_CONTAINER, "UnderWriter Container");
			selectDropDownValuesByEnteringText(_underWriter, GlassAccountSetupPageOR.UW_PRODUCT_CONTAINER,
					GlassAccountSetupPageOR.COMMON_DROPDOWN_TXTBOX, GlassAccountSetupPageOR.UW_RESULT_TEXTSEARCH,
					"Underwriter", _objDetailedReport);
			// Selecting Broker from the Dropdown
			waitForPageToLoadByCounter(5);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.BROKER_CONTAINER, "Broker Container");
			selectDropDownValuesByEnteringText(_broker, GlassAccountSetupPageOR.BROKER_CONTAINER,
					GlassAccountSetupPageOR.COMMON_DROPDOWN_TXTBOX, GlassAccountSetupPageOR.BROKER_RESULT_TEXTSEARCH,
					"Broker", _objDetailedReport);
			// Selecting Broker Contact from the DropDown
			waitForPageToLoadByCounter(10);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.BROKER_CONTACT_CONTAINER, "Broker Container");
			selectDropDownValuesByEnteringText(_brokerC, GlassAccountSetupPageOR.BROKER_CONTACT_CONTAINER,
					GlassAccountSetupPageOR.COMMON_DROPDOWN_TXTBOX,
					GlassAccountSetupPageOR.BROKER_CONTACT_RESULT_TEXTSEARCH, "Broker Contact", _objDetailedReport);
			// Entering Insured Details
			if (isflag) {
				enterInsuredDetails(_objDetailedReport,_iName);
			}
			// Click on Triage and Continue
			clickOnTriage(_objDetailedReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnInsuredName;
	}

	private String enterInsuredDetails(DetailedReport test,String insuredName) {
		String getInsuredName = null;
		try {
			waitForPageElementToLoad();
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.INSURED_ADD_BTN, "Insured Add Button");
			clickOnButton(GlassAccountSetupPageOR.INSURED_ADD_BTN, test, "Insured Add ");
			waitForPageToLoadByCounter(5);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.INSURED_SEARCH_CONTAINER, "Insured Search Container");
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.INSURED_NAME, "Insured Name");
			clickOnButton(GlassAccountSetupPageOR.INSURED_SEARCH_CONTAINER);			
			enterInputTextvalueByJavaScript(GlassAccountSetupPageOR.INSURED_NAME, insuredName,
					"Enter Insured Name: ", test);
			enterInputTextvalueByJavaScript(GlassAccountSetupPageOR.ADDRESS, "Street1", "Enter Address ", test);
			enterInputTextvalueByJavaScript(GlassAccountSetupPageOR.CITY, "Bekersfields", "Enter City ", test);
			selectDropDownValueByLocator("6", GlassAccountSetupPageOR.STATE, "Select State");
			enterInputTextvalueByJavaScript(GlassAccountSetupPageOR.POSTAL_CODE, "45150", "Enter Postal-Code", test);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.SAVE_AND_CLOSED_BTN, "Save And Closed button");
			clickOnButton(GlassAccountSetupPageOR.SAVE_AND_CLOSED_BTN, test, "Save And Close: ");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getInsuredName;
	}

	// Triage button Functionality
	private void clickOnTriage(DetailedReport test) {
		try {
			waitForPageToLoadByCounter(9);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.TRIAGE_BTN, "Triage Button");
			clickOnButton(GlassAccountSetupPageOR.TRIAGE_BTN, test, "Triage: ");
			waitForPageToLoadByCounter(50);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.CONTINUE, "continue");
			clickOnButton(GlassAccountSetupPageOR.CONTINUE, test, "continue");
			waitForPageToLoadByCounter(9);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Get Status from Work Plan
	private String getStatus(String insuredName, DetailedReport test) {
		String getStatus = null;
		try {
			waitForPageToLoadByCounter(9);
			System.out.println("Insured Name is " + insuredName);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.INSURED_SEARCH_BOX, "Insured Search");
			enterInputTextvalueByJavaScript(GlassAccountSetupPageOR.INSURED_SEARCH_BOX, insuredName,
					"Insured Text Search:", test);
			_Browser.findElement(GlassAccountSetupPageOR.INSURED_SEARCH_BOX).sendKeys(Keys.SPACE);
			_Browser.findElement(GlassAccountSetupPageOR.INSURED_SEARCH_BOX).sendKeys(Keys.BACK_SPACE);
			List<WebElement> elm = _Browser.findElements(HEADER_NAME);
			int getStatusIndex = getHeaderCountByValue("Status", elm);
			String getActualString = String.format(STATUS_STRING, getStatusIndex);
			By xpathString = By.xpath(getActualString);
			WebElement elment = _Browser.findElement(xpathString);
			if (elment != null) {
				getStatus = elment.getText();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return getStatus;
	}

		// waitForJQueryLoad();
	private void setTempIROnSubmissionCompletion(String action) throws Exception {
		System.out.println("In Our Script Action is " + action);
		waitForPageToLoadByCounter(100);
		waitForTheElementToBeLoad(GlassAccountSetupPageOR.NAME_CLEARAED_INSURED, "Cleared Insured Name");
		waitForTheElementToBeLoad(GlassAccountSetupPageOR.GENERAL_INFO_CONTINUE, "General Continue");
		clickOnButton(GlassAccountSetupPageOR.GENERAL_INFO_CONTINUE, _objDetailedReport, "Name clearance Continue");
		// waitForJQueryLoad();
		waitForPageToLoadByCounter(50);
		waitForTheElementToBeLoad(GlassAccountSetupPageOR.GENERAL_INFO_CARRIER, "Info Carrier");
		selectDropDownValuesByEnteringText("NIC", GlassAccountSetupPageOR.GENERAL_INFO_CARRIER,
				GlassAccountSetupPageOR.COMMON_DROPDOWN_TXTBOX, GlassAccountSetupPageOR.CARRIER_STRING, "Carrier",
				_objDetailedReport);
		waitForTheElementToBeLoad(GlassAccountSetupPageOR.GENERAL_INFO_CARRIER, "General Info Carrier");
		waitForTheElementToBeLoad(GlassAccountSetupPageOR.INSURED_INT_CONTINUE, "Insured Continue");
		clickOnButton(GlassAccountSetupPageOR.INSURED_INT_CONTINUE, _objDetailedReport, "General Info Continue");
		// waitForJQueryLoad();
		if (!"Professional Liability".equals(_testDataManage.getData("Insurance Product"))) {
			waitForPageToLoadByCounter(70);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.INSURED_INT_CONTENT, "Insured Content");
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.INSURED_CLEARANCE_CONTAINUE,
					"Insured Clearance Continue");
			clickOnButton(GlassAccountSetupPageOR.INSURED_CLEARANCE_CONTAINUE, _objDetailedReport,
					"Insured Interest Continue");
		}
		// waitForJQueryLoad();
		waitForPageToLoadByCounter(15);
		submissionCompleteWithTempIR(_objDetailedReport, _testDataManage.getData("TempNo"), action);
		waitForPageToLoadByCounter(90);
	}

	private void submissionCompleteWithTempIR(DetailedReport _objDetailedReport, String tempIR, String action)
			throws Exception {

		waitForTheElementToBeLoad(GlassAccountSetupPageOR.TEMPIR_TXTBOX, "Temp IR TextBox");
		waitForTheElementToBeLoad(GlassAccountSetupPageOR.CLEAREDCHCKBX, "Cleared CheckBox");
		waitForTheElementToBeLoad(GlassAccountSetupPageOR.FINISH, "Finish");

		switch (action) {
		case "cleared":
			clickOnElement(GlassAccountSetupPageOR.CLEAREDCHCKBX);
			break;
		case "Hold":
			clickOnElement(GlassAccountSetupPageOR.SUBMISSION_HOLD_CHCKBX);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.SUBMISSION_HOLD_CONTAINER, "Submission Hold Container");
			selectDropDownValuesByEnteringText("BOR", GlassAccountSetupPageOR.SUBMISSION_HOLD_CONTAINER,
					GlassAccountSetupPageOR.COMMON_DROPDOWN_TXTBOX, GlassAccountSetupPageOR.HOLD_REASON_LIST,
					"Missing Info: ", _objDetailedReport);
			break;
		case "Decline with Letter":
			clickOnElement(GlassAccountSetupPageOR.SUBMISSION_LETTER_DECLINE_CHKBOX);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.SUBMISSION_WITH_LETTER_CONTAINER,
					"Submission Letter Container");
			selectDropDownValuesByEnteringText("Pricing", GlassAccountSetupPageOR.SUBMISSION_WITH_LETTER_CONTAINER,
					GlassAccountSetupPageOR.COMMON_DROPDOWN_TXTBOX, GlassAccountSetupPageOR.DECLINE_WITH_LETTER_LIST,
					"Decline with Letter: ", _objDetailedReport);
			break;
		case "Decline no Letter":
			clickOnElement(GlassAccountSetupPageOR.SUBMISSION_DECLINE_NO_LETTER_CHKBOX);
			waitForTheElementToBeLoad(GlassAccountSetupPageOR.SUBMISSION_DECLINE_NO_LETTER_CONTAINER,
					"Submission Decline");
			selectDropDownValuesByEnteringText("Pricing",
					GlassAccountSetupPageOR.SUBMISSION_DECLINE_NO_LETTER_CONTAINER,
					GlassAccountSetupPageOR.COMMON_DROPDOWN_TXTBOX, GlassAccountSetupPageOR.DECLINE_NO_LETTER_LIST,
					"Decline No Letter: ", _objDetailedReport);
			break;
		default:
			break;
		}
		enterInputTextvalueByJavaScript(GlassAccountSetupPageOR.TEMPIR_TXTBOX, tempIR, "Temp IR No. ",
				_objDetailedReport);
		waitForTheElementToBeLoad(GlassAccountSetupPageOR.FINISH, "finsih");
		clickOnButton(GlassAccountSetupPageOR.FINISH, _objDetailedReport, "Submission Continue: ");
		waitForPageToLoadByCounter(5);
	}

}
