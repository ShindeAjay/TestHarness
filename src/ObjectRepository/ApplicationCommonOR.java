package ObjectRepository;

import org.openqa.selenium.By;

public class ApplicationCommonOR {
	
	
	/*
	 * subjectivity Page OR
	 */
	
	public static final By SUBJECTIVEITY_HEADER = By.xpath(".//*[@id='gview_selectedGrid']/*[@class='ui-jqgrid-hdiv']//th/div");
	public static final String RECIEVED_STRING = ".//*[@id='gview_selectedGrid']/*[@class='ui-jqgrid-bdiv']//tr[%d]";
	public static final String SUBSTRING_RECIEVED_CHECKBOX = "/td[%d]/input";
	public static final By RECIEVED_TR_LIST = By.xpath(".//*[@id='gview_selectedGrid']/*[@class='ui-jqgrid-bdiv']//tr");
	
	/*
	 * Component And Coverage Page OR 
	 */
	public static final String EXCESS_HEADER_LIST_DIV = ".//*[@id='components-tab']//legend[contains(text(),'Excess')]/following-sibling::section[2]";
	public static final String EXCESS_HEADER_LIST = "//*[@class='ui-jqgrid-hdiv']//th/div";
	public static final By EXCESS_FINAL_HEADER_LIST = By.xpath(EXCESS_HEADER_LIST_DIV + EXCESS_HEADER_LIST);
	public static final String EXCESS_COMPONENT_NAME = ".//*[@id='components-tab']//legend[contains(text(),'Excess')]/following-sibling::section[2]//*[@class='ui-jqgrid-bdiv']//tr[2]/td[contains(text(),'%s')]";
	public static final String EXCESS_COMPONENT_EDIT_SECTION = "/../td[%d]";
	
	/*
	 * Navigator Clearance Page OR 
	 */	
	
	public static final By CLEARANCE_RESULT = By.xpath(".//div[@class='modal-dialog']/div[@id='clearance-results-modal-content']");
	public static final By TEMP_IR_NUMBER = By.xpath(".//input[@id='temp-ir-number']");
	public static final String PROCEED_TO_QUOTE = ".//button[@type='button'][contains(text(),'%s')]";
	public static final  By IMAGERIGHT_PROCEED_POPUP = By.xpath(".//div[@class='modal-content']/div[@class='modal-footer']/button[contains(text(),'Proceed')][@id='modal-ir-not-found-proceed']");
	public static final By IR_NOT_FOUND_PROCEED =By.xpath(".//*[@id='modal-ir-not-found-proceed']");
	public static final String DECLINE_SUBMISSION_RESONS = ".//*[@id='decline-sub-reasons']/li/a[contains(text(),'%s')]";
	public static final String CLOSE_SUBMISSION_RESONS = ".//*[@id='close-sub-reasons']/li/a[contains(text(),'%s')]";
	public static final By VALIDATE_PACKAGE = By.xpath(".//*[@id='package-validate']");
	
	/*
	 * Login Page OR Date :- 08-01-2018 Author :- LNT
	 */
	public static final By LOGIN_EMAIL_TXT = By.name("Email");
	public static final By LOGIN_PWD_TXT = By.name("Password");
	public static final By LOGIN_BTN = By.xpath("//button[contains(text(),'Login')]");
	/*
	 * Navigator My Work Page
	 */
	public final static By ACTION_PROGRESS_MODAL = By.xpath(".//*[@id='action-progress-modal-body']");
	public final static By ACTION_PROGRESS_MODAL_CLOSE = By.xpath(".//*[@id='action-progress-modal-close']");
	public final static By ACTION_MESSAGE = By.xpath(".//*[@id='quote-processed-alert']//h4");
	public final static String INSUREDNAME = "Insured Name";
	public final static String ACTIONS = "Actions";
	public final static String STATUS = "Status";
	public final static By ACTIONS_DROPDOWN = By.xpath(".//button[contains(text(),'Actions')]");
	public final static By HEADER_NAME = By
			.xpath(".//*[@id='gview_myWorkGrid']//*[@class='ui-jqgrid-hdiv']//table/thead/tr[1]/th/div");
	public final static By STATUS_SELECT_DROPDOWN = By.xpath(".//*[@id='gs_RiskStatusName']");
	public final static String TABLE_SEARCHFILTER = ".//*[@id='gview_myWorkGrid']//*[@class='ui-jqgrid-hdiv']//table/thead/tr[2]/th[%d]/div/*[@class='ui-search-table']/tbody/tr/td/input";
	public final static String ACTION_BTN_MYWORK = ".//*[@id='myWorkGrid']/tbody/tr[2]/td[%d]/div/button";
	public final static String ACTION_BTN_INPROGRESS = ".//*[@id='myWorkGrid']/tbody/tr[2]/td[%d]/span[2]";
	public final static String ACTION_LISTTAG = ".//*[@id='myWorkGrid']/tbody/tr[2]/td[%d]/div/button";
	public final static String SUBACTION_LISTTAG = "/following-sibling::ul/li/a[contains(text(),'%s')]";
	public final static String SUB_ACTION_LIST_TAG = "/../ul/li/a[contains(text(),'%s')]";
	public final static By MYWORK_DIV = By.xpath(".//*[@id='myWorkGridParent']");
	public final static By SCENARIO_BIND_POPUP = By.xpath(".//*[@id='bind-scenario-modal-content']");
	public final static By INITIATE_BIND_PROCEED_BTN = By.xpath(".//*[@id='initiate-bind-proceed']");
	public final static By ADDREMARK_TEXTAREA = By.xpath(".//*[@id='Comment']");
	public final static By ADD_BTN = By.xpath(".//*[@id='modal-add-comment']");
	public final static By MY_WORK_LINK = By.xpath((".//span[contains(text(),'My Work')]"));
	public final static String TR_SEARCH_CLEAR = ".//*[@id='gview_myWorkGrid']//*[@class='ui-jqgrid-hdiv']//table/thead/tr[2]/th[%d]//table/tbody/tr/td[3]";

	/*
	 * Navigator General Info Page OR
	 */
	public final static By NUMBER_OF_US_EMPLOYEE = By.xpath(".//*[@id='numeric_3560']");
	public final static By OVER_ALL_GROSS_REVENUE = By.xpath(".//*[@id='numeric_4189']");
	public final static By OVERRIDE_GENINFO = By
			.xpath(".//*[@class='checkbox-inline'][contains(text(),'Override')]/input");
	public final static By CHECKBOX_STATUS = By.xpath(".//*[@id='QuoteBinderValidUntilDateOverride']");
	public final static By VALIDUTILDATE = By.xpath(".//*[@id='QuoteBinderValidUntilDate']");
	public final static By VALID_DATE_DONE = By
			.xpath(".//*[@class='ui-datepicker-buttonpane ui-widget-content']/*[contains(text(),'Done')]");
	public final static String VALID_DATE = ".//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),'%s')]";
	public final static By ENDORSMENT_DESC = By.xpath(".//*[@id='EndorsementDescription']");
	public final static By GENERATE_DOCS = By.xpath(".//*[@id='package-generate-docs']");
	public final static By CANCELLATION_REASON_CONTAINER = By
			.xpath(".//*[@id='select2-EndorsementCancellationReasonId-container']");
	public final static String CANCELLATION_RESON_LIST = ".//*[@id='select2-EndorsementCancellationReasonId-results']/li[contains(text(),'%s')]";
	public final static By SEARCH_BOX = By.xpath(".//*[@class='select2-search__field'][@role='textbox']");
	
	/*
	 * Navigator Broker Info Page OR
	 */
	
	public final static By BROKERTYPE_ID = By.xpath(".//*[@id='select2-BrokerTypeId-container']");	
	public final static By BROKER_INPUT_TXT = By.xpath(".//input[@class='select2-search__field'][@role='textbox']");	
	public final static String BROKERTYPE_RESULT=".//ul[@id='select2-BrokerTypeId-results']/li[contains(text(),'%s')]";
	
	/*
	 * Navigator Insured Page OR 
	 */
	public final static By BUSINESS_TYPE_SELECT_TAG = By.xpath(".//*[@name='BusinessTypeId']");
	public final static By BUSINESS_TYPE = By.xpath(".//*[@class='ui-jqgrid-hdiv']//tr/th/div");
	public final static String BUSINESSTYPE_SELECT = ".//*[@class='ui-jqgrid-bdiv']//tr[2]/td[%d]";
	public final static By SIC_CODE_ID = By.xpath(".//*[@id='select2-SICCodeId-container']");	
	public final static By SIC_CODE_TEXTBOX = By.xpath(".//input[@class='select2-search__field'][@role='textbox']");	
	public final static String SIC_CODE_LIST = ".//ul[@id='select2-SICCodeId-results']/li[contains(text(),'%s')]";
	public final static By PRIMARY_SIC_CODE = By.xpath(".//*[@id='select2-SICGroupId-container']");
	public final static String PRIMARY_SIC_LIST = (".//*[@id='select2-SICGroupId-results']/li[contains(text(),'%s')]");	
	
	/*
	 * document Review Page - OR
	 */
	
	public final static String SEND_TO_BROKER_CHECKBOX = ".//*[@class='tree-documents']/div/div[2]/strong[contains(text(),'%s')]//../preceding-sibling::div/label/*[@id='SendToBroker_33881']";
	public final static String VIEW_DOC_SEND_TO_BROKER = ".//*[@class='tree-documents']/div/div[2]/i[@class='fa fa-circle-thin']/../strong[contains(text(),'%s')]/preceding-sibling::a[2]";
	public final static By SEND_TO_TEXTBOX = By.xpath(".//*[@id='send-to']");
	public final static By CARBON_COPY_TEXTBOX = By.xpath(".//*[@id='carbon-copy']");
	public final static By RELEASE_BTN = By.xpath(".//*[@id='doc-review-release']");
	public final static By REVIEWED_DOCUMENT = By.xpath(".//*[@id='ReviewCheck']");
	public final static By MAKECHANGES = By.xpath(".//*[@id='doc-review-make-changes']");
	public final static By SEND_FOR_REVIEW = By.xpath(".//*[@id='doc-review-send-for-review']");
	public final static By MYWORK_GRID = By.xpath(".//*[@id='myWorkGridParent']");
	public final static By VIEW_DOC_LIST = By.xpath(".//*[@class='tree-documents']/div/div[2]/i[@class='fa fa-circle-thin']/../strong/preceding-sibling::a[2]");
	public final static By REVIEWER_CONTAINER = By.xpath(".//*[@id='select2-ReviewerId-container']");
	public final static By REVIEWER_TEXTBOX = By.xpath(".//input[@class='select2-search__field']");
	public final static String REVIEWER_LIST = ".//*[@id='select2-ReviewerId-results']/li[contains(text(),'%s')]";
	public final static By DOCUMENT_VIEW_STATUS = By.xpath(".//*[@class='tree-documents']/div/div[2]/i[@class='fa fa-circle-thin']/../strong");
	
	/*****NP3*************************/
	
	/*
	 * Component and Coverage Page
	 */
	
	public final static By POLLUTION_LEGAL_LIABILITY = By.xpath(".//*[@id='pollutionlegalliabilityParent']//*[@class='ui-jqgrid-hdiv']//tr/th/div");
	public final static By POLLUTION_LEGAL_LIABILITY_TR=By.xpath(".//*[@id='pollutionlegalliabilityParent']//*[@class='ui-jqgrid-bdiv']//tr");
	public final static String POLL_LEGAL_LIABILITY_EACH_ROW = ".//*[@id='pollutionlegalliabilityParent']//*[@class='ui-jqgrid-bdiv']//tr[%d]";
	public final static String POLL_LEGAL_LIAB_EACH_TBL_DATA = "/td[%d]";

	

}
