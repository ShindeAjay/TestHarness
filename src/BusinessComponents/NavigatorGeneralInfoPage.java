package BusinessComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ObjectRepository.ApplicationCommonOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorGeneralInfoPage extends SeleniumHelper {

	public NavigatorGeneralInfoPage(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails){
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}	
	
	public void validateAllGeneralInfoSection(DetailedReport test) throws Exception {
		
		getCheckboxStatusCheckedOrNot(ApplicationCommonOR.CHECKBOX_STATUS);
		waitForTheElementToBeLoad(ApplicationCommonOR.VALIDUTILDATE,"Valid util Date");
		WebElement elment = _Browser.findElement(ApplicationCommonOR.VALIDUTILDATE);
		if (!elment.isEnabled()) {
			getCheckboxStatusCheckedOrNot(ApplicationCommonOR.CHECKBOX_STATUS);
			waitForPageElementToLoad();
		}
		clickOnElement(ApplicationCommonOR.VALIDUTILDATE);
		int todayDate = getTodaysDay();
		selectDateByFromAndTo(test, ApplicationCommonOR.VALIDUTILDATE, String.valueOf(todayDate), ApplicationCommonOR.VALID_DATE, ApplicationCommonOR.VALID_DATE_DONE,"Valid Util Date");
	}

	public void setOverAllGrossRevenue(DetailedReport test) throws Exception{
		
		waitForTheElementToBeLoad(ApplicationCommonOR.OVER_ALL_GROSS_REVENUE, "Over All Gross Revenue");
		enterInputTextvalue(ApplicationCommonOR.OVER_ALL_GROSS_REVENUE, _testDataManage.getData("OverAll Gross Revenue"), "Over All Gross Revenue", test);
		waitForPageToLoadByCounter(5);
	}
	
	public void setNumberOfUSEmployee(DetailedReport test) throws Exception{
		
		waitForTheElementToBeLoad(ApplicationCommonOR.NUMBER_OF_US_EMPLOYEE, "Number Of US Employee");
		enterInputTextvalue(ApplicationCommonOR.NUMBER_OF_US_EMPLOYEE, "105", "Number Of US Employee", test);
		waitForPageToLoadByCounter(5);
	}
	
	public void setEndorsmentDescription(DetailedReport test,String option) throws Exception {
		waitForTheElementToBeLoad(ApplicationCommonOR.ENDORSMENT_DESC,"Endorsmenr Description");	
		enterInputTextvalueByJavaScript(ApplicationCommonOR.ENDORSMENT_DESC, "Test", "Enter Endorsment Description: ",test);
		waitForTheElementToBeLoad(ApplicationCommonOR.VALIDATE_PACKAGE,"Validate Package");		
		clickOnButton(ApplicationCommonOR.VALIDATE_PACKAGE, test, "Validated button: ");
		waitForPageElementToLoad();
		if (!"External".equalsIgnoreCase(option)) {
			waitForTheElementToBeLoad(ApplicationCommonOR.GENERATE_DOCS,"Generate document");
			clickOnButton(ApplicationCommonOR.GENERATE_DOCS);
			waitForPageToLoadByCounter(9);
			waitForPageElementToLoad();
		}		
	}

	public void selectCancellationReason(DetailedReport test) throws Exception {
		waitForTheElementToBeLoad(ApplicationCommonOR.CANCELLATION_REASON_CONTAINER,"Cancellation Reason");
		selectDropDownValuesByEnteringText("Material Change In Risk",ApplicationCommonOR.CANCELLATION_REASON_CONTAINER, 
				ApplicationCommonOR.SEARCH_BOX, ApplicationCommonOR.CANCELLATION_RESON_LIST, "Cancellation Reason",test);
		waitForTheElementToBeLoad(ApplicationCommonOR.VALIDATE_PACKAGE,"Validate Package");		
		clickOnButton(ApplicationCommonOR.VALIDATE_PACKAGE, test, "Validated button: ");
		waitForPageElementToLoad();
		waitForTheElementToBeLoad(ApplicationCommonOR.GENERATE_DOCS,"Generate docs");
		clickOnButton(ApplicationCommonOR.GENERATE_DOCS);
		waitForPageElementToLoad();
	}

}
