package ObjectRepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;


public class NavigatorAccountSetupOR{
	
	public final static By COMMENT_ATTACHMENT__LINK = By.xpath(".//*[@id='initiate-remarks']");
	public final static By COMMENT_ACCOUNTSETUPSCREEN = By.xpath(".//*[@class='message-text-value']");
	public final static String UNDERWRITER_ID = "select2-underwriterLookup-results";
	public final static String INSURED_PRODUCT = "select2-productlookup-results";
	public final static String BROKER_ID = "select2-editBrokerSelect-results";
	public final static String STATE_LOOKUP_ID = "select2-statelookup-results";	

	public final static By CLEAR_AND_CONTINUE = By.xpath(".//div[@class='shadow-wrapper']/following-sibling::div/a");
	public final static By POSTAL_CODE = By.xpath(".//input[@id='postal']");
	public final static By STATELOOKUP_CONTAINER = By.xpath(".//span[@id='select2-statelookup-container']");	
	public final static By ACCOUNT_INSURED_NAME = By.xpath(".//span[@id='select2-editInsuredNameSelect-container']");
	public final static By ACCOUNTSETUP_CITY = By.xpath(".//input[@id='city']");	
	public final static By ACCOUNTSETUP_ADDRESS = By.xpath( ".//input[@id='address']");	
	public final static By STARTDATE_INPUTTEXTBOX = By.xpath(".//input[@id='requestFromDate']");	
	public final static By ENDDATE_INPUTTEXTBOX = By.xpath(".//input[@id='requestToDate']");	
	public final static By ACCOUNT_SETUP_LINK = By.xpath(".//span[contains(text(),'Account Setup')]");
	public final static By INSURED_PRODUCT_CONTAINER = By.xpath(".//span[@id='select2-productlookup-container']");	
	public final static By INSURED_PRODUCT_TXTBOX = By.xpath(".//input[@class='select2-search__field'][@role='textbox']");	
	public final static By INSURED_PRODUCT_LIST_SELECTION = By.xpath(".//ul[@id='select2-productlookup-results']/li");	
	public final static By EDIT_BROKER_LIST = By.xpath(".//span[@id='select2-editBrokerSelect-container']");	
	public final static By BROKER_LIST_SELECTION = By.xpath(".//ul[@id='select2-editBrokerSelect-results']/li");	
	public final static By UNDERWRITER_LOOKUP_CONTAINER = By.xpath(".//span[@id='select2-underwriterLookup-container']");
	public final static By INSURED_NAME_LIST = By.xpath(".//span[@id='select2-editInsuredNameSelect-results']/li");	
	public final static By MISSING_FIELD_MESSAGE = By.xpath(".//*[@id='insured-info-error']");	
	public final static By TODAYS_DATE_DONE_BTN = By.xpath(".//*[@class='ui-datepicker-buttonpane ui-widget-content']/*[contains(text(),'Done')]");
	public final static By THREE_LETTER_CODE_CONTAINER = By.xpath(".//*[@id='select2-productCodeLookup-container']");
	public final static String THREE_LETTER_CODE_LIST = ".//ul[@id='select2-productCodeLookup-results']/li[contains(text(),'%s')]"; 
	
	public final static By CLEARANCE_RESULT = By.xpath(".//div[@class='modal-dialog']/div[@id='clearance-results-modal-content']");
	public final static String ACCOUNT_STARTDATE_ENDDATE = ".//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),'%s')]";
	public final static String INSURED_PRODUCT_LIST = ".//ul[@id='select2-productlookup-results']/li[contains(text(),'%s')]";
	public final static String BROKER_SELECT_OPTION = ".//ul[@id='select2-editBrokerSelect-results']//li[contains(text(),'%s')][1]";
	public final static String UNDERWRITER_LIST = ".//ul[@id='select2-underwriterLookup-results']/li[contains(text(),'%s')][1]";
	public final static String STATE_LIST = ".//ul[@id='select2-statelookup-results']/li[contains(text(),'%s')]";
	public final static String INSURED_NAME = ".//ul[@id='select2-editInsuredNameSelect-results']/li[contains(text(),'%s')][1]";
}
