package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class GlassAccountSetupPageOR {
	public GlassAccountSetupPageOR() {
		// TODO Auto-generated constructor stub
	}

	public static final By POSTAL_CODE = By.xpath(".//*[@id='PostalCode']");
	/*@FindBy(xpath=".//input[@class='select2-search__field'][@role='textbox']")*/
	public static final By COMMON_DROPDOWN_TXTBOX = By.xpath(".//input[@class='select2-search__field'][@role='textbox']");
	
	/*@FindBy(xpath=".//span[contains(text(),'Setup New Account')]")*/
	//public static final By ACCOUNTSETUP_LINK = By.xpath(".//span[contains(text(),'Setup New Account')]");
	//changed in OR - 07-30-2018 
	public static final By ACCOUNTSETUP_LINK = By.xpath(".//li/a[contains(text(),'Setup New Account')]");
	/*****OR for Insured Name DropDown ********/
	/*@FindBy(xpath=".//*[@id='select2-ProductId-container']")*/
	public static final By INSURED_PRODUCT_CONTAINER = By.xpath(".//*[@id='select2-ProductId-container']");
	
	public static final String INSURED_RESULT_TEXTSEARCH =".//*[@id='select2-ProductId-results']/li[contains(text(),'%s')]";
	/**************************/
	/******OR for 3 Letter Code Dropdown************/
	/*@FindBy(xpath=".//*[@id='select2-ProductCodeId-container']")*/
	public static final By LETTERCODE_CONTAINER = By.xpath(".//*[@id='select2-ProductCodeId-container']");
		
	public static final String LETTER_RESULT_TEXTSEARCH = ".//*[@id='select2-ProductCodeId-results']/li[contains(text(),'%s')]";
	/**************************/
	/******OR for UnderWriter Dropdown************/
	@FindBy(xpath=".//*[@id='select2-UnderwriterId-container']")
	public static final By UW_PRODUCT_CONTAINER = By.xpath(".//*[@id='select2-UnderwriterId-container']");
	
	public static final String UW_RESULT_TEXTSEARCH = ".//*[@id='select2-UnderwriterId-results']/li[contains(text(),'%s')]";
	/**************************/
	/******OR for Broker Dropdown************/
	/*@FindBy(xpath=".//*[@id='select2-BrokerCode-container']")*/
	public static final By BROKER_CONTAINER = By.xpath(".//*[@id='select2-BrokerCode-container']");
	
	public static final String BROKER_RESULT_TEXTSEARCH = ".//*[@id='select2-BrokerCode-results']/li[1]/span[contains(text(),'%s')]";
	/**************************/
	/******OR for Broker Contact Dropdown************/
	/*@FindBy(xpath=".//*[@id='select2-BrokerContact-container']")*/
	public static final By BROKER_CONTACT_CONTAINER = By.xpath(".//*[@id='select2-BrokerContact-container']");
	
	public static final String BROKER_CONTACT_RESULT_TEXTSEARCH = ".//*[@id='select2-BrokerContact-results']/li[contains(text(),'%s')][1]";
	/**************************/
	/******OR for Add/Edit Insured************/
	/*@FindBy(xpath=".//*[@id='add_btn']/div/span")*/
	public static final By INSURED_ADD_BTN = By.xpath(".//*[@id='add_btn']/div/span");
	/***OR for Name Search In Insured Details Page****/
	/*@FindBy(xpath=".//*[@id='select2-insured-name-select-container']")*/
	public static final By INSURED_SEARCH_CONTAINER = By.xpath(".//*[@id='select2-insured-name-select-container']");
		
	/*@FindBy(xpath=".//*[@id='select2-insured-name-select-results']/li")*/
	public static final By INSURED_SEARCH_RESULt_LIST = By.xpath(".//*[@id='select2-insured-name-select-results']/li");
	
	/*@FindBy(xpath=".//*[@id='InsuredName']")*/
	public static final By INSURED_NAME = By.xpath(".//*[@id='InsuredName']");	

	/*@FindBy(xpath=".//*[@id='Address1']")*/
	public static final By ADDRESS = By.xpath(".//*[@id='Address1']");
	
	/*@FindBy(xpath=".//*[@id='City']")*/
	public static final By CITY = By.xpath(".//*[@id='City']");
	
	/*@FindBy(xpath=".//*[@id='StateId']")*/
	public static final By STATE = By.xpath(".//*[@id='StateId']");
		
	/*@FindBy(xpath=".//*[@id='InsuredRoleId']")*/
	public static final By SELECT_INSUREDROLE = By.xpath(".//*[@id='InsuredRoleId']");
	
	public static final String INSURED_SEARCH_TEXTSEARCH = ".//*[@id='select2-insured-name-select-results']/li[contains(text(),'%s')]";
	/**************************/
	/***OR for Save And Closed Button****/
	/*@FindBy(xpath=".//*[@id='edit-insured-modal-save-close']")*/
	public static final By SAVE_AND_CLOSED_BTN = By.xpath(".//*[@id='edit-insured-modal-save-close']");
	/***********************************/
	/***OR for Triage Button****/
	/*@FindBy(xpath=".//*[@id='triage-check']")*/
	public static final By TRIAGE_BTN = By.xpath(".//*[@id='triage-check']");	
	/***********************************/
	/***OR for Continue button****/
	/*@FindBy(xpath=".//*[@id='continue']")*/
	public static final By CONTINUE = By.xpath(".//*[@id='continue']");
	public static final By NAME_CLEARAED_INSURED = By.xpath(".//*[@id='select2-Interests-container']");
	public static final By GENERAL_INFO_CONTINUE = By.xpath(".//*[@id='continue'][@title='General Information']");
	public static final By INSURED_INT_CONTINUE = By.xpath(".//*[@id='continue'][@title='Insured Interests']");
	public static final By INSURED_CLEARANCE_CONTAINUE = By.xpath((".//*[@id='continue'][@title='Insured Clearance']"));
	public static final By FINISH = By.xpath(".//*[@id='continue'][@title='My Work Grid']");
	public static final By INSURED_INTERESTNAME = By.xpath(".//*[@id='select2-Interests-container']");
	public static final By INSURED_TABLE = By.xpath(".//*[@class='ui-jqgrid-view']");
	public static final By EXIT_SETUP = By.xpath(".//*[@id='exit-setup']");
	public static final By DELETE_INPROGRESS = By.xpath(".//*[@id='delete-in-progress']");
	public static final By SAVE_INPROGRESS = By.xpath(".//*[@id='save-in-progress']");
	public static final By GENERAL_INFO_CARRIER = By.xpath(".//*[@id='select2-CarrierId-container']");
	public static String CARRIER_STRING = ".//*[@id='select2-CarrierId-results']/li[contains(text(),'%s')]";
	public static final By GENERAL_INFO_MASTER = By.xpath(".//*[@id='select2-MasterPolicyId-container']");
	public static final By GENERAL_INFO_MGA = By.xpath(".//*[@id='select2-ManagingGeneralAgentId-container']");
	public static final By GENERAL_INFO_REF = By.xpath(".//*[@id='ManagingGeneralAgentReferenceNumber']");
	public static final By INSURED_INT_CONTENT = By.xpath((".//*[@id='myTabContent']"));
	/********/
	public static final By SUBMISSION_HOLD_CONTAINER = By.xpath(".//*[@id='select2-SubmittalActionReasonIdClearedHold-container']");
	public static final String HOLD_REASON_LIST= ".//*[@id='select2-SubmittalActionReasonIdClearedHold-results']/li[contains(text(),'%s')]";
	public static final By SUBMISSION_HOLD_CHCKBX = By.xpath(".//*[@id='SubmittalActionIdClearedHold']");
	public static final By SUBMISSION_LETTER_DECLINE_CHKBOX = By.xpath(".//*[@id='SubmittalActionIdDeclineWithLetter']");
	public static final By SUBMISSION_DECLINE_WITH_LETTER = By.xpath(".//*[@id='SubmittalActionIdDeclineWithLetter']");
	public static final By SUBMISSION_WITH_LETTER_CONTAINER = By.xpath((".//*[@id='select2-SubmittalActionReasonIdDeclineWithLetter-container']"));
	public static final String DECLINE_WITH_LETTER_LIST = ".//*[@id='select2-SubmittalActionReasonIdDeclineWithLetter-results']/li[contains(text(),'%s')]";
	public static final By SUBMISSION_DECLINE_NO_LETTER_CHKBOX= By.xpath(".//*[@id='SubmittalActionIdDeclineNoLetter']");
	public static final By SUBMISSION_DECLINE_NO_LETTER_CONTAINER = By.xpath(".//*[@id='select2-SubmittalActionReasonIdDeclineNoLetter-container']");
	public static final String DECLINE_NO_LETTER_LIST = ".//*[@id='select2-SubmittalActionReasonIdDeclineNoLetter-results']/li[contains(text(),'%s')]";
	
	/***************/
	/**OR for Validation Message****/
	/*@FindBy(xpath=".//*[@id='validation-message']/li/span")*/
	public static final By VALIDATION_MSG_SPAN = By.xpath(".//*[@id='validation-message']/span/li");
	
	/*@FindBy(xpath=".//*[@id='validation-message']")*/
	public static final By ERROR_MESSAGE_VALIDATION = By.xpath(".//*[@id='validation-message']");
	
	/*@FindBy(xpath=".//*[@id='validation-message-alert']/div/a")*/
	public static final By VALIDATION_POPUP_CLOSE = By.xpath(".//*[@id='validation-message-alert']/div/a");
	/**OR for Submission Completion**/
	/*@FindBy(xpath=".//*[@id='ImageRightTempId']")*/
	public static final By TEMPIR_TXTBOX = By.xpath(".//*[@id='ImageRightTempId']");
	
	/*@FindBy(xpath=".//*[@id='SubmittalActionIdClearedFinish']")*/
	public static final By CLEAREDCHCKBX = By.xpath(".//*[@id='SubmittalActionIdClearedFinish']");
	public static final By HOLDCHECKBOX = By.xpath(".//*[@id='SubmittalActionIdClearedHold']");
	
	
	public static final By VALIDATION_POPUP = By.xpath(".//*[@id='validation-message-alert']/div/a");
	/******OR for Work PLan*******/
	public static final By INSURED_SEARCH_BOX = By.xpath(".//*[@id='gs_PrimaryInsuredName']");

}
