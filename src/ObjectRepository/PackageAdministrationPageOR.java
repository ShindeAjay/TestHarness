package ObjectRepository;

import org.openqa.selenium.By;

public class PackageAdministrationPageOR {
	
	public final static String GENERALINFO = "GeneralInfo";
	public final static String INSURED_NAME = "Insureds";
	public final static String SCENARIO = "Scenarios & Options";
	public final static String BROKER_INFO = "BrokerInfo";

	// Active Account Info
	public final static By ACTIVE_ACCOUNT_INFO = By.xpath(".//div[@id='active-account-info']");
	// Account Status
	public final static By ACCOUNT_STATUS = By.xpath(".//div[@id='active-account-info']//li[3]");
	// Account Status After Quote
	public final static By ACCOUNT_STATUS_AFTER_QUOTE = By.xpath(".//div[@id='active-account-info']//li[4]");
	// Validate Package
	public final static By VALIDATE_PACKAGE = By.xpath(".//*[@id='package-validate']");
	// Error Tab
	public final static By ERROR_TAB = By.xpath(".//*[@id='package-tabs']/li/*[contains(text(),'Errors')]");
	// Validation List - Need to Change the Code as well
	public final static By VALIDATION_LIST = By.xpath(".//*[@class='table table-bordered']/tbody/tr");
	// Validation header List
	public final static By VALIDATION_HEADER_LIST = By.xpath(".//*[@class='table table-bordered']/thead/tr/th");
	// Scenario option tab
	public final static By SCENARIO_OPTION_TAB = By.xpath(".//*[contains(text(),'Scenarios & Options')]");
	// Scenario Header List on S&OPtion tab
	public final static By SCENARIO_HEADER_LIST = By.xpath(".//*[@class='ui-jqgrid-hbox']/table/thead/tr/th/div");
	// Component and Coverages Page
	public final static By COMPONENT_HEADER_LIST = By
			.xpath(".//*[@id='coverage-grids']/div[2]//section[2]//*[@class='ui-jqgrid-hdiv']//table/thead/tr/th/div");

	public final static String VALIDATION_RESULT_ERROR = ".//*[@class='table table-bordered']/thead/tr/th[contains(text(),'%s')]";
	public final static String VALIDATION_RESULT_LOG = ".//*[@class='table table-bordered']/tbody/tr/td[contains(text(),'%s')]";
	public final static String VALIDATION_CONTEXT_LOG = ".//*[@class='table table-bordered']/tbody/tr[1]/td[%d]";
	public final static String SUBPART_VALIDATION_MESSAGE = "/../td[%d]/a";
	public final static String SCENARIO_LIST = ".//*[@id='scenarioGrid']/tbody/tr[2]/td[%d]";
	public final static String SCENARIO_TAB = ".//*[@id='package-tabs']/li/a[contains(text(),'%s')]";
	public final static String COMPONENT_TABLE_TD = ".//*[@id='coverage-grids']/div[2]//section[2]//*[@class='ui-jqgrid-bdiv']//*[@id='pollutionlegalliability']//tr/td[%d]";
	public final static String COMPONENT_TABLE_TD_SUB = "[contains(text(),'%s')]";
	public final static String COMPONENT_EDIT_SECTION = "/../td[%d]";
	public final static By COMMMENT_ATTACHMENT_PCK_ADMIN = By.xpath(".//*[@class='message-text-value']");
}
