package BusinessComponents;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.host.Symbol;

import ObjectRepository.ApplicationCommonOR;
import ObjectRepository.NavigatorComponentAndCoveragePageOR;
import ObjectRepository.PackageAdministrationPageOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class PackageAdministrationPage extends SeleniumHelper {
	
	public PackageAdministrationPage(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails){
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}

	public String getStringValueFromMethod(String value) {
		try {
			if (value != null) {
				return _Browser.findElement(By.xpath(value)).getText();
			} else {
				return "";
			}
		} catch (Exception e) {
			return null;
		}
	}

	public String getActualString(String value) {
		String getActualName = null;
		try {
			if (value.contains(PackageAdministrationPageOR.INSURED_NAME)) {
				getActualName = value.substring(value.indexOf(PackageAdministrationPageOR.INSURED_NAME), value.lastIndexOf(" "));
			} else if (value.contains(PackageAdministrationPageOR.GENERALINFO)) {
				getActualName = value.substring(value.indexOf(PackageAdministrationPageOR.GENERALINFO), value.lastIndexOf(" "));
			} else if (value.contains(PackageAdministrationPageOR.BROKER_INFO)) {
				getActualName = value.substring(value.indexOf(PackageAdministrationPageOR.BROKER_INFO), value.lastIndexOf(" "));
			}
		} catch (Exception e) {
			return null;
		}
		return getActualName;
	}
	// Resolving the Error's which occur in Error tab Apart from Scenario section
	public void proceedQuoteInProgressToQouteIssued(DetailedReport test,String _letterCode) throws Exception {
		waitForPageToLoadByCounter(12);		
		waitForTheElementToBeLoad(PackageAdministrationPageOR.VALIDATE_PACKAGE,"ValidatePackage");
		clickOnButton(PackageAdministrationPageOR.VALIDATE_PACKAGE, test, "Validate Package");	
		waitForPageToLoadByCounter(50);	
		waitForTheElementToBeLoad(PackageAdministrationPageOR.ERROR_TAB,"Error Tab");
		try {
			resolveValidationError(test,_letterCode);	
			if ("ECP".equals(_letterCode)) {					
				validateScenarioAndOptionPage(test,"Contractor");
			}else if ("EXC Excess - Wholesale".equals(_letterCode)) {
				validateScenarioAndOptionPage(test,"Excess");
			}else if ("NP3".equals(_letterCode)) {
				
			} else {

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateScenarioAndOptionPage(DetailedReport test,String component) throws Exception {

		waitForTheElementToBeLoad(PackageAdministrationPageOR.SCENARIO_OPTION_TAB,"Scenario Option tab");
		clickWithJavaScriptEXecutor(PackageAdministrationPageOR.SCENARIO_OPTION_TAB, test, "Scenario & Options");
		waitForPageElementToLoad();
		clickOnScenario(test);
		clickOnLinkByText("Components/Coverages", test, PackageAdministrationPageOR.SCENARIO_TAB);
		if ("Excess".equals(component)) {
			setCommissionAndTriaPercentageOnCoverageSection();
			clickOnEditByComponentName("Details",test,"Excess");
		}else{
			List<WebElement> COMPONENT_HEADER_LIST = _Browser.findElements(PackageAdministrationPageOR.COMPONENT_HEADER_LIST);
			clickOnEditbyComponentValue("Name", test, COMPONENT_HEADER_LIST, component);
		}
		
	}

	// Will click on Scenario under Scenario & Options
	public void clickOnScenario(DetailedReport test) throws Exception {
		List<WebElement> HEADER_LIST = _Browser.findElements(PackageAdministrationPageOR.SCENARIO_HEADER_LIST);
		int getHeaderCount = getHeaderCountByValue("Name", HEADER_LIST);
		String finalScenarioName = String.format(PackageAdministrationPageOR.SCENARIO_LIST, getHeaderCount);
		By xpathScenarioName = By.xpath(finalScenarioName);
		waitForTheElementToBeLoad(xpathScenarioName, "Scenario");
		WebElement elm = _Browser.findElement(xpathScenarioName);
		if (elm != null) {
			clickWithJavaScriptEXecutor(xpathScenarioName, test, "Scenario");
			waitForPageToLoadByCounter(10);
		}
	}

	public void clickOnEditbyComponentValue(String header, DetailedReport test, List<WebElement> elm, String componentValue) {

		int getComponentNameIndex = getHeaderCountByValue(header, elm);
		String strComponentName = String.format(PackageAdministrationPageOR.COMPONENT_TABLE_TD, getComponentNameIndex);
		String strComponentNameWithSubString = String.format(PackageAdministrationPageOR.COMPONENT_TABLE_TD_SUB, componentValue);
		String finalComponentString = strComponentName + strComponentNameWithSubString;
		int getDetailheaderIndex = getHeaderCountByValue("Details", elm);
		String strGetEditSectionLink = String.format(PackageAdministrationPageOR.COMPONENT_EDIT_SECTION, getDetailheaderIndex);
		String strGetFinalEditSectionLink = finalComponentString + strGetEditSectionLink;
		By xpathEditSection = By.xpath(strGetFinalEditSectionLink);		
		clickWithJavaScriptEXecutor(xpathEditSection, test, "Edit");
		waitForPageElementToLoad();
	}
	
	public void setCommissionAndTriaPercentageOnCoverageSection(){
		try {
			clickOnCommissionLink();
			setTriaTerrorism();
			clickOnTriaTerrorism();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void clickOnCommissionLink(){
		try {
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.COMMISSION, "Commission Link");
			clickOnElement(NavigatorComponentAndCoveragePageOR.COMMISSION, "Commission");
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.TRIA_TERRORISM, "Tria Terrorism");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setTriaTerrorism(){
		try {
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.TRIA_TERRORISM, "Tria Terrorism");
			_Browser.findElement(NavigatorComponentAndCoveragePageOR.TRIA_TERRORISM).clear();
			enterInputTextvalue(NavigatorComponentAndCoveragePageOR.TRIA_TERRORISM, "1", "Tria Terrorism", _objDetailedReport);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.APPLY_ALL_COMPONENTS, "Apply All Component");
			moveTotheCheckboxAndClick(NavigatorComponentAndCoveragePageOR.APPLY_ALL_COMPONENTS, "Apply All Component");
			clickOnButton(NavigatorComponentAndCoveragePageOR.COMMISSION_SAVE_BTN, "Save Button");
			waitForPageToLoadByCounter(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void clickOnTriaTerrorism(){
		try {
			NavigatorScenarioCompAndCoveragePage _Scenario = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
			List<WebElement> TRIA_HEADER = _Browser.findElements(NavigatorComponentAndCoveragePageOR.TRIA_TERR_HEADER_XPATH);
			int getTriaDetailIndex = getHeaderCountByValue("Details", TRIA_HEADER);
			String getActualDetailEditsection = String.format(NavigatorComponentAndCoveragePageOR.TRIA_TERR_ROW_XPATH, getTriaDetailIndex);
			By xpathEditSection = By.xpath(getActualDetailEditsection);
			waitForTheElementToBeLoad(xpathEditSection, "TRIA TERRORISM");
			clickOnButton(xpathEditSection, _objDetailedReport, "TRIA TERRORISM");
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.TRIA_PERCENT, "TRIA PERCENTAGE");
			enterInputTextvalue(NavigatorComponentAndCoveragePageOR.TRIA_PERCENT, "25", "Tria Percentage", _objDetailedReport);
			selectDropDownValuesByEnteringText("Government", NavigatorComponentAndCoveragePageOR.TERRORISM_CLASS, ApplicationCommonOR.BROKER_INPUT_TXT,NavigatorComponentAndCoveragePageOR.TERRORISM_CLASS_LIST, "Terrorism Classes", _objDetailedReport);
			clickOnButton(NavigatorComponentAndCoveragePageOR.COVERAGE_DIAPLAY_SAVE_BTN, _objDetailedReport, "Save Button");			
			waitForPageToLoadByCounter(15);
			clickOnButton(NavigatorComponentAndCoveragePageOR.GOTO_EXPOSURE_BTN);
			_Scenario.clickOnComponentCoverageLink(_objDetailedReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnEditByComponentName(String header,DetailedReport test,String ComponentValue) throws Exception{
		
		try {
			List<WebElement> elm = _Browser.findElements(ApplicationCommonOR.EXCESS_FINAL_HEADER_LIST);
			int getDetailHeaderIndex = getHeaderCountByValue(header, elm);
			String getEditString = String.format(ApplicationCommonOR.EXCESS_COMPONENT_EDIT_SECTION, getDetailHeaderIndex);
			String getExcessComponentName = String.format(ApplicationCommonOR.EXCESS_COMPONENT_NAME, ComponentValue);
			String getFinalExcessEditStr = getExcessComponentName + getEditString;
			By xpathEditSection = By.xpath(getFinalExcessEditStr);
			waitForTheElementToBeLoad(xpathEditSection, "Excess Edit");
			clickOnElement(xpathEditSection, "Excess Edit");
			waitForPageElementToLoad();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// Resolving Error validation on Error Page
	public void resolveValidationError(DetailedReport test,String _letterCode) throws Exception {
		System.out.println("Resolve Validation on Error Tab");
		List<WebElement> VALIDATION_H_LIST_ERROR_TAB = _Browser.findElements(PackageAdministrationPageOR.VALIDATION_HEADER_LIST);
		int getNavigatecolumnIndex = getHeaderCountByValue("Navigate", VALIDATION_H_LIST_ERROR_TAB);
		int getContextColumnIndex = getHeaderCountByValue("Context", VALIDATION_H_LIST_ERROR_TAB);
		int counter = VALIDATION_H_LIST_ERROR_TAB.size();
		System.out.println("Counter Is **************"+counter);
		while (counter > 0) {
			String getStringNavigate = String.format(PackageAdministrationPageOR.SUBPART_VALIDATION_MESSAGE, getNavigatecolumnIndex);
			String getStringContext = String.format(PackageAdministrationPageOR.VALIDATION_CONTEXT_LOG, getContextColumnIndex);
			String getcontextValueFromMethod = getStringValueFromMethod(getStringContext);
			System.out.println("*********************GetContextMethod Name******"+getcontextValueFromMethod);
			String getFinalString = getStringContext + getStringNavigate;
			By getNavigateLink = By.xpath(getFinalString);			
			String getActualName = getActualString(getcontextValueFromMethod);
			System.out.println("*********************Actual String****************"+getActualName);
			if (getcontextValueFromMethod.contains("Scenario")) {
				break;
			}
			switch (getActualName) {
			case "Insureds":
				NavigatorNameInsuredPage insuredPage = new NavigatorNameInsuredPage(_Browser, _objDetailedReport, _testDataManage, null);
				waitForTheElementToBeLoad(getNavigateLink, "Insureds");	
				clickWithJavaScriptEXecutor(getNavigateLink, test, "Insureds ");
				setInsuredInputByThreeLetterCode(_letterCode, insuredPage, test);					
				clickWithJavaScriptEXecutor(PackageAdministrationPageOR.VALIDATE_PACKAGE, test, "Validate Package");
				counter--;
				break;
			case "GeneralInfo":
				NavigatorGeneralInfoPage generalInfo = new NavigatorGeneralInfoPage(_Browser, _objDetailedReport, _testDataManage, null);
				waitForTheElementToBeLoad(getNavigateLink, "General info");				
				clickWithJavaScriptEXecutor(getNavigateLink, test, "General Info Link");
				setGeneralInfoInputByThreeLetterCode(_letterCode, generalInfo, test);		
				waitForTheElementToBeLoad(PackageAdministrationPageOR.VALIDATE_PACKAGE, "Validate Package");
				clickWithJavaScriptEXecutor(PackageAdministrationPageOR.VALIDATE_PACKAGE, test, "Validate Package");
				counter--;
				break;
			case "BrokerInfo":
				NavigatorBrokerInfoPage brokerInfo = new NavigatorBrokerInfoPage(_Browser, _objDetailedReport, _testDataManage, null);
				brokerInfo.setBrokerInformation(getNavigateLink, test);				
				clickWithJavaScriptEXecutor(PackageAdministrationPageOR.VALIDATE_PACKAGE, test, "Validate Package");
				counter--;
				break;
			default:
				counter--;
				break;
			}
		}
	}
	
	public void setGeneralInfoInputByThreeLetterCode(String _letterCode,NavigatorGeneralInfoPage generalInfo,DetailedReport test) throws Exception{
		if ("ECP".equals(_letterCode)) {
			generalInfo.validateAllGeneralInfoSection(test);	
		}else if ("EXC Excess - Wholesale".equals(_letterCode)) {
			generalInfo.setOverAllGrossRevenue(test);
			generalInfo.validateAllGeneralInfoSection(test);	
		}else if ("NP3".equals(_letterCode)) {
			generalInfo.setOverAllGrossRevenue(test);
			generalInfo.setOverAllGrossRevenue(test);
			generalInfo.validateAllGeneralInfoSection(test);	
		}	
	}
	
	public void setInsuredInputByThreeLetterCode(String _letterCode,NavigatorNameInsuredPage insuredPage,DetailedReport test) throws Exception{
		if ("ECP".equals(_letterCode)) {
			insuredPage.selectPrimarySICCode(test);	
		}else if ("EXC Excess - Wholesale".equals(_letterCode)) {
			insuredPage.selectBusinessType(test);	
			insuredPage.selectSICCategory(test);
			insuredPage.selectPrimarySICCode(test);			
		}else if ("NP3".equals(_letterCode)) {
			insuredPage.selectBusinessType(test);
			insuredPage.selectPrimarySICCode(test);	
		}	
	}

	public String getStatusFromPackageAdministrationPage() throws Exception {

		String STATUS = null;
		String accStatus = "quote";
		String getStatusValue = null;
		waitForPageElementToLoad();
		waitForTheElementToBeLoad(PackageAdministrationPageOR.ACTIVE_ACCOUNT_INFO,"Active Account Info");		
		if ("Quote".equalsIgnoreCase(accStatus)) {
			getStatusValue = _Browser.findElement(PackageAdministrationPageOR.ACCOUNT_STATUS).getText();
			STATUS = getStatusValue.trim();
		} else {
			getStatusValue = _Browser.findElement(PackageAdministrationPageOR.ACCOUNT_STATUS_AFTER_QUOTE).getText();
			STATUS = getStatusValue.trim();
		}
		return STATUS;
	}

	// Comments & Attachments
	public String getCommentAndAttachmentOnpackageAdministration(DetailedReport test) throws Exception {
		waitForTheElementToBeLoad(ApplicationCommonOR.VALIDATE_PACKAGE,"Validate Package");
		clickOnLinkByText("Comments & Attachments", test, PackageAdministrationPageOR.SCENARIO_TAB);
		waitForTheElementToBeLoad(PackageAdministrationPageOR.COMMMENT_ATTACHMENT_PCK_ADMIN,"Comment Attachment Package Admin");		
		return _Browser.findElement(PackageAdministrationPageOR.COMMMENT_ATTACHMENT_PCK_ADMIN).getText();
	}
}
