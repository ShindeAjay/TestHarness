package ObjectRepository;

import org.openqa.selenium.By;

public class NavigatorComponentAndCoveragePageOR {

	// Component And Coverage Section
	public static final By RETRO_TERM_RATING = By.xpath(".//*[@id='select2-questionid3487-container']");
	public static final By INSURED_PRODUCT_TXTBOX = By
			.xpath(".//input[@class='select2-search__field'][@role='textbox']");
	public static final By INSURED_PRODUCT_LIST = By.xpath(".//*[@id='select2-questionid3487-results']/li");
	public static final By COVERAGE_DIAPLAY_SAVE_BTN = By.xpath(".//*[@id='coverage-display-save-bottom']");
	public static final By EXPOSURE_TAB = By.xpath(".//li/a[contains(text(),'Exposures')]");
	public static final By POLICY_AGGREGATE_LIMIT = By.xpath(".//*[@id='numeric_3644']");
	public static final By EXPOSURE_BASIC_REVENUE = By.xpath(".//*[@id='numeric_3645']");
	public static final By CONTRACTOR_ADDITION_BTN = By.xpath(".//*[@id='contractorsGrid_iladd']/div/span");
	public static final By SERVICETYPE_SELECT_OPTION = By.xpath(".//*[@id='jqg1_ServiceType']");
	public static final By SUBCONTRACTOR_TEXTFIELD = By.xpath(".//*[@id='jqg1_SubcontractedPercent']");
	public static final By GROSS_REVENUE_TXTFIELD = By.xpath(".//*[@id='jqg1_GrossRevenues']");
	public static final By GOTO_EXPOSURE_BTN = By.xpath(".//*[@class='dropup btn-group']/button/span");
	public static final By VALIDATE_RATING_BTN = By
			.xpath(".//*[@id='question3506']//*[@class='text-align-center']//button");
	public static final By AUTO_FORMS_ENDORS_BTN = By.xpath(".//button[contains(text(),'Auto')]");
	public static final By ACKNOWLEDGE_CHECKBOX_ERROR_TAB = By.xpath(".//*[@id='Acknowledged']");
	public static final By SELECTED_FORMS_NAME_TXTBOX = By
			.xpath(".//*[@id='form-container']/div[3]/div[2]//input[@id='gs_DisplayName']");
	public static final By AVAILABLE_FORMS_NAME_TXTBOX = By
			.xpath(".//*[@id='form-container']/div[3]/div[1]//input[@id='gs_DisplayName']");
	public static final By ATTACH_HEADER = By
			.xpath(".//*[@id='form-container']/div[3]/div[2]//*[@class='ui-jqgrid-hbox']//th/div");
	public static final By CALCULATE_RATING = By
			.xpath(".//*[@id='scenarioratingoverviewGridPager_left']/table//*[@title='Calculate']/div");
	public static final String SCENARIO_TAB = ".//*[@id='package-tabs']/li/a[contains(text(),'%s')]";
	public static final By SCENARIO_TABS = By.xpath(".//*[@id='package-tabs']/li");
	public static final String GOTO_PAGELIST_STRING = ".//*[@class='dropup btn-group open']/ul/li/a[contains(text(),'%s')]";
	public static final String POLICY_EFFECTIVE_STRING = ".//*[@id='select2-questionid3487-results']/li[contains(text(),'%s')]";
	public static final String ATTACH_CHECKBOX = ".//*[@id='form-container']/div[3]/div[2]//*[@class='ui-jqgrid-bdiv']//*[@id='selectedGrid']/tbody/tr[2]/td[%d]/input";
	public static final By ATTACH_CHECKBOX_AVAILABLE = By.xpath(
			".//*[@id='form-container']/div[3]/div[1]//*[@class='ui-jqgrid-bdiv']//table/tbody/tr[2]/td[1]/input");
	public static final By GENERATE_DOCS = By.xpath(".//*[@id='package-generate-docs']");
	public static final By VIEW_FORMS_ENDORS_LINK = By.xpath(".//*[@id='selectedGrid']//tr/td[@title='View']");
	public static final By DOCUMENT_VIEWER_CLOSE_BTN = By.xpath(".//*[@id='document-viewer-close']");
	public static final By ADD_FORMS = By.xpath(".//*[@id='btnAddForms']");
	public static final By ADD_FILLINS_FORM_OK_BTN = By.xpath(".//*[@id='form-fillin-save']");
	
	/***
	 * Excess Casualty - Rating OR
	 * Date :- 8/07/2018
	 */
	public static final By COMMISSION = By.xpath(".//a[contains(text(),'Commission')]");
	public static final By TRIA_TERRORISM = By.xpath(".//*[@id='comm-percent']");
	public static final By APPLY_ALL_COMPONENTS = By.xpath(".//*[@id='chk-apply-commission']");
	public static final By COMMISSION_SAVE_BTN = By.xpath(".//*[@id='commission-modal-save']");
	
	public static final String TRIA_TERRORISM_SECTION = ".//*[@id='coverage-grids']//legend[contains(text(),'TRIA Terrorism')]/following-sibling::section[2]";
	public static final String TRIA_TERRORISM_HEADER_SECTION = "//*[@class='ui-jqgrid-hdiv']//th/div";
	public static final By TRIA_TERR_HEADER_XPATH = By.xpath(TRIA_TERRORISM_SECTION+TRIA_TERRORISM_HEADER_SECTION);
	public static final String TRIA_TERR_ROW_XPATH = TRIA_TERRORISM_SECTION + "//*[@class='ui-jqgrid-bdiv']//tr[2]/td[%d]";
	
	public static final By TRIA_PERCENT = By.xpath("//*[@id='numeric_6010']");
	public static final By TERRORISM_CLASS = By.xpath("//*[@id='select2-questionid6016-container']");
	public static final String TERRORISM_CLASS_LIST = ".//*[@id='select2-questionid6016-results']/li[contains(text(),'%s')]";
	public static final String LIMIT_COVERAGE_GET_TYPE = ".//*[@id='layout-container-content']/div/div/div[2]//*[@id='limitDeductibleGrid']//tr[%d]";

	public static final By PRIMARY_GL_MODEL_ADD_BTN = By.xpath(".//*[@id='isogeneralliabilityGrid_iladd']/div");
	public static final String COVERAGE_CHID_TAB = ".//*[@id='layout-container-tabs']/li/a[contains(text(),'%s')]";
	public static final By COVERAGE_CHILD_TAB_LIST = By.xpath(".//*[@id='layout-container-tabs']/li/a");
	public static final String COVERAGE_CHILD_GET_TAB_NAME = ".//*[@id='layout-container-tabs']/li[%d]/a";
	public static final By LIMIT_COVERAGE_TABLE_ROW_COUNT = By.xpath(".//*[@id='layout-container-content']/div/div/div[2]//*[@id='limitDeductibleGrid']//tr");
	public static final String LIMIT_COVERAGE_TR = ".//*[@id='layout-container-content']/div/div/div[2]//*[@id='limitDeductibleGrid']//tr[%d]";
	public static final String LIMIT_AMOUNT_ROW = "/td[contains(text(),'%s')]/following-sibling::td[1]";
	public static final By LIMIT_COVERAGE_TYPE = By.xpath(".//*[@id='layout-container-content']/div/div/div[2]//*[@class='ui-jqgrid-hdiv']//tr/th/div");
	public static final By DESCRIPTION_SELECT_ID = By.xpath(".//*[@name='Description']");
	public static final By UMBRELLA_LIMIT = By.xpath(".//*[@id='numeric_5026']");
	public static final By UNDERLYER_ADDITION_BTN = By.xpath(".//*[@id='excessunderlyerGrid_iladd']/div");
	public static final String UNDERLYER_AMOUNT = ".//*[@id='%d_Amount']";
	public static final By UNDERLYER_LIMIT = By.xpath(".//*[@id='numeric_6210']");
	/*****Excess UnderLyer Screen OR****/
	public static final By POLICY_TYPE_CONTAINER = By.xpath(".//*[@id='select2-LiabilityTypeId-container']");
	public static final String POLICY_TYPE_LIST = ".//*[@id='select2-LiabilityTypeId-results']/li[contains(text(),'%s')]";
	public static final By CARRIER = By.xpath(".//*[@id='Carrier']");
	public static final By POLICY_REF = By.xpath(".//*[@id='PolicyReference']");
	public static final By LIMIT_COMBINED_SINGLE_LIMIT = By.xpath(".//*[@id='LimitCombined']");
	public static final By EFFECTIVE_DATE = By.xpath(".//*[@id='EffectiveDate']");
	public static final By EXPIRATION_DATE = By.xpath(".//*[@id='ExpirationDate']");
	public static final String EFFECTIVE_DATE_LIST = ".//*[@class='ui-datepicker-calendar']//tr/td/a[contains(text(),'%d')]";
	public static final By EXCESS_UNDERLYER_SAVE_BTN = By.xpath(".//*[@id='modal-excessunderlyerGrid-button']");
	/************ General Liability Additional fields**********/
	public static final By LIMIt_EACH_OCC = By.xpath(".//*[@id='LimitEach']");
	public static final By LIMIT_PERSONAL = By.xpath(".//*[@id='PersonalAndAdvertisingInjuryAnyOnePersonOrOrganization ']");
	public static final By LIMIT_GENERAL_AGG = By.xpath(".//*[@id='LimitGeneralAggregate ']");
	public static final By LIMIT_PRODUCTS = By.xpath(".//*[@id='ProductsCompletedOperationsAggregate']");
	
	
	/*************Primary Rating Tab***************/
	public static final By PRIMARY_GL_MODEL_LIST = By.xpath(".//*[@data-grid-caption='Primary GL Model']//div[@class='ui-jqgrid-hdiv']//th/div");
	public static final By PRIMARY_GL_ADD_BTN = By.xpath(".//*[@id='isogeneralliabilityGrid_iladd']/div");
	public static final By PRIMARY_GL_TR = By.xpath(".//*[@data-grid-caption='Primary GL Model']//div[@class='ui-jqgrid-bdiv']//tr");
	public static final String PRIMARY_GL_TR_TD = ".//*[@data-grid-caption='Primary GL Model']//div[@class='ui-jqgrid-bdiv']//tr[%d]/td[%d]";
	public static final String CLASS_CODE_CONTANIER = ".//*[@id='select2-jqg%d_Class-container']";
	public static final String CLASS_CODE_LIST = ".//*[@id='select2-jqg%d_Class-results']/li[1]";
	public static final String STATE_LST = ".//*[@id='jqg%d_State']";
	public static final String LOCATION_TYPE = ".//*[@id='jqg%d_LocationType']";
	public static final String PREMIUM_BASIS = ".//*[@id='jqg%d_ExposureBasis']";
	public static final String OPS_LOSS_COST = ".//*[@id='jqg%d_OpsLossCost']";
	public static final String AMOUNT = ".//*[@id='jqg%d_Amount']";
	public static final By AUTO_MODEL_HEADERLIST = By.xpath(".//*[@data-grid-caption='Auto Model']//div[@class='ui-jqgrid-hdiv']//th/div");
	public static final String AUTO_MODEL_BODY_ROW = ".//*[@data-grid-caption='Auto Model']//div[@class='ui-jqgrid-bdiv']//tr";
	public static final String AUTO_MODEL_BODY_ROW_SUB = "[%d]";
	public static final String AUTO_MODEL_BODY_PARENT = AUTO_MODEL_BODY_ROW+AUTO_MODEL_BODY_ROW_SUB;
	public static final String AUTO_MODEL_BODY__COLS = "/td[%d]";
	public static final String AUTO_FINAL_COL = AUTO_MODEL_BODY_PARENT+AUTO_MODEL_BODY__COLS;
	public static final String NO_OF_UNITS = ".//*[@id='%d_NumUnits']";
	public static final String TERRITORY = ".//*[@id='%d_Territory']";
	public static final String AUTO_MODEL_USE = ".//*[@id='%d_Use']";
	public static final String AUTO_RADIUS = ".//*[@id='%d_Radius']";

	/***********************Actual UL Rating************/
	public static final String PRIMARY_UNDERLYER = ".//*[@data-grid-caption='Primary Underlyers']//*[@class='ui-jqgrid-bdiv']//tr";
	public static final String PRIMARY_UNDERLYER_ROW = "[%d]";
	public static final String PRIMARY_UNDERLYER_FINAL_ROW = PRIMARY_UNDERLYER+PRIMARY_UNDERLYER_ROW;
	public static final By PRIMARY_HEADER = By.xpath(".//*[@data-grid-caption='Primary Underlyers']//*[@class='ui-jqgrid-hdiv']//th/div");
	public static final String PRIMARY_UNDERLYER_TABLE_COLS = "/td[%d]";
	public static final String PRIMARY_RETENTION_TYPE = ".//*[@id='%d_RetentionType']";
	public static final String PRIMARY_LIMIT_AMOUNT = ".//*[@id='%d_LimitAmount']";
	public static final String PRIMARY_RETENTION_AMOUNT = ".//*[@id='%d_RetentionAmount']";
	public static final String PRIMARY_ACTUAL_PREMIUM = ".//*[@id='%d_ActualPremium']";
	public static final String PRIMARY_LIMIT_TYPE = ".//*[@data-grid-caption='Primary Underlyers']//*[@class='ui-jqgrid-bdiv']//tr[%d]/td[2]";
	public static final By PRIMARY_LIMIT_HAZARD = By.xpath(".//*[@id='select2-questionid6293-container']");
	public static final String PRIMARY_LIMIT_HAZARD_LIST = (".//*[@id='select2-questionid6293-results']/li[contains(text(),'%s')]");
	/*******************Excess Rating******************/
	public static final By EXCESS_RATING_PRICE_FLOOR_AUTO = By.xpath(".//*[@data-grid-caption='Price Floor 1x1P']//*[@class='ui-jqgrid-bdiv']//tr[2]/td[6]");
	public static final By EXCESS_RATING_PRICE_FLOOR_GL = By.xpath((".//*[@data-grid-caption='Price Floor 1x1P']//*[@class='ui-jqgrid-bdiv']//tr[3]/td[6]"));
	public static final By EXCESS_RATING_PRICE_INPUT_AUTO = By.xpath(".//*[@id='1_NavgAmount']");
	public static final By EXCESS_RATING_PRICE_INPUT_GL = By.xpath(".//*[@id='2_NavgAmount']");
	/******************** Pricing Details/Premium*******************/
	public static final By QUOTE_PREMIUM_EXCESS_ONLY_TXT = By.xpath(".//*[@id='numeric_6258']");
	public static final By QUOTE_PRICING_DETIAL_RATING_BTN = By.xpath(".//*[@id='layout-container-content']/div[7]/div/div[7]//button[contains(text(),'Not rated')]");
	public static final By EXCESS_RATING_RATE_BTN = By.xpath(".//*[@id='layout-container-content']/div[4]/div/div[3]//button[contains(text(),'Rating is invalid')]");
	
	/****************** Rating Note *********/
	public static final By RATING_NOTE = By.xpath(".//*[@id='textfield_6262']"); 
	/*****Subjectivity*******/
	public static final By SUBJECTIVITY_CHECKBOX = By.xpath(".//*[@id='NoSubjectivitiesApply']");
	
	/***
	 * LOB - NP3
	 * Date : 8/10/2018
	 */
	
	public static final By EXPOSURE_AND_RATING_TAB = By.xpath(".//*[contains(text(),'Exposures & Rating')]");
	public static final By EXPOSURE_RATING_CLASS = By.xpath(".//*[@data-grid-caption='Composite Rating (Techincal Premium):']//*[@class='ui-jqgrid-bdiv']//tr[2]/td[3]");
	public static final By EXPOSURE_RATING_CLASS_CONTAINER = By.xpath(".//*[@id='select2-1_Class-container']");
	public static final By EXPOSURE_RATING_CLASS_LIST = By.xpath(".//*[@id='select2-1_Class-results']/li[1]");
	public static final By EXPOSURE_RATE = By.xpath("//*[@id='1_Rate']");
	public static final By EXPOSURE_TYPE = By.xpath(".//*[@id='1_ExposureType']");
	
	
	
}
