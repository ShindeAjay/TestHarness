package BusinessComponents;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ObjectRepository.ApplicationCommonOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;
public class NavigatorMyWorkPage extends SeleniumHelper {

	public NavigatorMyWorkPage(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
		
	public int myWorkActionTableCount() {
		_Browser.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		List<WebElement> ACTION_DROPDOWN_LIST = _Browser.findElements(ApplicationCommonOR.ACTIONS_DROPDOWN);
		return ACTION_DROPDOWN_LIST.size();
	}

	public void initiateBindToProceed(DetailedReport test) throws Exception {

		waitForTheElementToBeLoad(ApplicationCommonOR.SCENARIO_BIND_POPUP,"Bind Popup");
		waitForTheElementToBeLoad(ApplicationCommonOR.INITIATE_BIND_PROCEED_BTN,"Bind Proceed Button");		
		clickOnButton(ApplicationCommonOR.INITIATE_BIND_PROCEED_BTN, test, "Binder To Proceed");
		waitForPageElementToLoad();
	}

	public String getInsuredNameStatusByPassingvalue(String insuredName, DetailedReport test) throws Exception {

		waitForPageElementToLoad();
		waitForTheElementToBeLoad(ApplicationCommonOR.MYWORK_DIV,"My Work Div");
		List<WebElement> Header_Elment = _Browser.findElements(ApplicationCommonOR.HEADER_NAME);
		int getRequiredheaderIndex = getHeaderCountByValue(ApplicationCommonOR.INSUREDNAME, Header_Elment);
		String getActualFilterXpath = String.format(ApplicationCommonOR.TABLE_SEARCHFILTER, getRequiredheaderIndex);
		By xpathElement = By.xpath(getActualFilterXpath);
		waitForTheElementToBeLoad(xpathElement,"Insured Filter TextBox");
		WebElement elment = _Browser.findElement(xpathElement);
		waitForPageElementToLoad();
		if (elment != null) {
			enterInputTextvalueByJavaScript(xpathElement, insuredName,"Enter Insured Name in Search Field:",test);
			waitForPageElementToLoad();
		}
		return getTheInsuredStatus(test);
	}
	
	public String getInsuredNameStatusByPassingvalue(String insuredName, DetailedReport test,String header) throws Exception {

		waitForPageElementToLoad();
		waitForTheElementToBeLoad(ApplicationCommonOR.MYWORK_DIV,"My Work Div");
		List<WebElement> Header_Elment = _Browser.findElements(ApplicationCommonOR.HEADER_NAME);
		int getRequiredheaderIndex = getHeaderCountByValue(header, Header_Elment);
		String getActualFilterXpath = String.format(ApplicationCommonOR.TABLE_SEARCHFILTER, getRequiredheaderIndex);
		By xpathElement = By.xpath(getActualFilterXpath);
		waitForTheElementToBeLoad(xpathElement,"Insured Filter TextBox");
		WebElement elment = _Browser.findElement(xpathElement);
		waitForPageElementToLoad();
		if (elment != null) {
			enterInputTextvalueByJavaScript(xpathElement, insuredName,"Enter Insured Name in Search Field:",test);
			elment.sendKeys(Keys.BACK_SPACE);
			waitForPageToLoadByCounter(50);
		}
		return getTheInsuredStatus(test);
	}

	public String getTheInsuredStatus(DetailedReport test) {
		String getStatusfromTheString = ".//*[@id='myWorkGrid']//tr[2]/td[%d]";
		List<WebElement> Header_Elment = _Browser.findElements(ApplicationCommonOR.HEADER_NAME);
		int getStatusIndex = getHeaderCountByValue(ApplicationCommonOR.STATUS, Header_Elment);
		String getStatus = null;
		try {
			String getActualStatusString = String.format(getStatusfromTheString, getStatusIndex);
			By xpathString = By.xpath(getActualStatusString);
			waitForTheElementToBeLoad(xpathString,"Status");
			WebElement elm = _Browser.findElement(xpathString);
			if (elm != null) {
				getStatus = elm.getText();
				//Need to Write the Code change
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getStatus;
	}

	public void editByNameAndAccountStatus(String InsuredName, String status, DetailedReport test, String action) throws Exception {

		waitForPageElementToLoad();
		List<WebElement> Header_Elment = _Browser.findElements(ApplicationCommonOR.HEADER_NAME);
		int getRequiredHeaderIndex = getHeaderCountByValue(ApplicationCommonOR.INSUREDNAME, Header_Elment);
		String getActualFilterXpath = String.format(ApplicationCommonOR.TABLE_SEARCHFILTER, getRequiredHeaderIndex);
		By xpathElement = By.xpath(getActualFilterXpath);
		waitForTheElementToBeLoad(xpathElement,"Insured Name Search Text");
		WebElement elment = _Browser.findElement(xpathElement);
		waitForPageElementToLoad();
		if (elment != null) {
			enterInputTextvalueByJavaScript(xpathElement, InsuredName, "Enter insured Name in SearchBox",test);
			elment.sendKeys(Keys.SPACE);
			elment.sendKeys(Keys.BACK_SPACE);
			waitForPageElementToLoad();
		}
		waitForPageElementToLoad();
		selectDropDownValueByLocator(status, ApplicationCommonOR.STATUS_SELECT_DROPDOWN,action);
		waitForPageToLoadByCounter(20);
		clickOnActionButtonWithEditOption(test, action);
		if ("Bind".equals(action)) {
			initiateBindToProceed(test);
		}	
	}
	
	public void getActionMessage(){
		try {
			waitForTheElementToBeLoad(ApplicationCommonOR.ACTION_PROGRESS_MODAL, "Alert Message");
			String getStr = _Browser.findElement(ApplicationCommonOR.ACTION_MESSAGE).getText();
			clickOnButton(ApplicationCommonOR.ACTION_PROGRESS_MODAL_CLOSE);
			waitForPageToLoadByCounter(5);
		} catch (Exception e) {
			System.out.println("Action Message Not Found");
		}
	}
	
	public void clearFilter() throws Exception{
		waitForPageToLoadByCounter(100);
		List<WebElement> Header_Elment = _Browser.findElements(ApplicationCommonOR.HEADER_NAME);
		int getStatusIndex = getHeaderCountByValue(ApplicationCommonOR.STATUS, Header_Elment);		
		String getActualStatusFilterCancellationXpath = String.format(ApplicationCommonOR.TR_SEARCH_CLEAR, getStatusIndex);		
		By xpathFilterClearSearchXpath = By.xpath(getActualStatusFilterCancellationXpath);
		waitForTheElementToBeLoad(xpathFilterClearSearchXpath,"clear Filter");		
		clickOnElement(xpathFilterClearSearchXpath);
	}

	public void clickOnActionButtonWithEditOption(DetailedReport test, String option) throws Exception {
		int getActionColumnIndex = 0;
		try {
			List<WebElement> Header_Elment = _Browser.findElements(ApplicationCommonOR.HEADER_NAME);
			getActionColumnIndex = getHeaderCountByValue(ApplicationCommonOR.ACTIONS, Header_Elment);
			String getActualActionXpath = String.format(ApplicationCommonOR.ACTION_BTN_MYWORK, getActionColumnIndex);
			By xpathElment = By.xpath(getActualActionXpath);						
			waitForTheElementToBeLoad(xpathElment,"Action Button");
			waitForPageToLoadByCounter(15);
			clickOnButton(xpathElment, test, "Actions:");
			getActionListValueByName(option, test,xpathElment);
		} catch (Exception e) {		
			e.printStackTrace();
			String getInProgressStatusXpath = String.format(ApplicationCommonOR.ACTION_BTN_INPROGRESS, getActionColumnIndex);
			By xpathInProgressXpath = By.xpath(getInProgressStatusXpath);		
			waitForTheElementToBeLoad(xpathInProgressXpath,"Transaction In Progress");
			if (_Browser.findElement(xpathInProgressXpath).getAttribute("class").contains("action")) {
				/*String dateName = CaptureScreenShot.getTransactionErrorScreenShot(driver);
				//Email Sending.........
				SendMail.sendMail("Transaction",dateName);*/
			}	
		}		
	}

	public void getActionListValueByName(String option, DetailedReport test,By elm) throws Exception {
		String getSubListActionXpath = null;
		List<WebElement> Header_Elment = _Browser.findElements(ApplicationCommonOR.HEADER_NAME);
		int getActionColumnIndex = getHeaderCountByValue(ApplicationCommonOR.ACTIONS, Header_Elment);
		String getDraftActionXPath = String.format(ApplicationCommonOR.ACTION_LISTTAG, getActionColumnIndex);
		String getDraftActionXpath1 = String.format(ApplicationCommonOR.SUBACTION_LISTTAG, option);
		String getFinalActionXpath = getDraftActionXPath + getDraftActionXpath1;
		By xpathElement = By.xpath(getFinalActionXpath);		
		WebElement elment = _Browser.findElement(xpathElement);
		if (elment != null) {
			if (!"Decline".equalsIgnoreCase(option) && !"Close".equalsIgnoreCase(option) && !"Quote No Order".equalsIgnoreCase(option)) {				
				waitForTheElementToBeLoad(xpathElement,option);				
				clickWithJavaScriptEXecutor(xpathElement, test, option);			
				waitForPageToLoadByCounter(8);
			} else {
				if ("Close".equalsIgnoreCase(option)) {
					getSubListActionXpath = String.format(ApplicationCommonOR.SUB_ACTION_LIST_TAG, "Lapsed");
					String getFinalActionXpathDecline = getFinalActionXpath + getSubListActionXpath;
					By xpathElmentXpath = By.xpath(getFinalActionXpathDecline);
					moveToElementByLocator(elment, xpathElmentXpath,option);
				}else if ("Decline".equalsIgnoreCase(option)) {
					getSubListActionXpath = String.format(ApplicationCommonOR.SUB_ACTION_LIST_TAG, "Pricing");
					String getFinalActionXpathDecline = getFinalActionXpath + getSubListActionXpath;
					By xpathElmentXpath = By.xpath(getFinalActionXpathDecline);
					moveToElementByLocator(elment, xpathElmentXpath,option);
				}else if ("Quote No Order".equalsIgnoreCase(option)) {
					getSubListActionXpath = String.format(ApplicationCommonOR.SUB_ACTION_LIST_TAG, "Other");
					String getFinalActionXpathDecline = getFinalActionXpath + getSubListActionXpath;
					By xpathElmentXpath = By.xpath(getFinalActionXpathDecline);
					moveToElementByLocator(elment, xpathElmentXpath,option);
				}					
				waitForPageToLoadByCounter(8);
				waitForPageElementToLoad();
			}
		}
	}

	public void setStatusInReport(String getStatus) throws Exception {
		System.out.println("Status is ************** "+getStatus);
		switch (getStatus) {
		case "Submission":
			getStatusIntoReportByName(getStatus, "Submission");
			break;
		case "Quote Issued":
			getStatusIntoReportByName(getStatus, "Quote Issued");
			break;
		case "Binder Issued":
			getStatusIntoReportByName(getStatus, "Binder Issued");
			break;
		case "Policy Issued":
			getStatusIntoReportByName(getStatus, "Policy Issued");
			break;
		case "Quote In Progress":
			getStatusIntoReportByName(getStatus, "Quote In Progress");
			break;
		case "Policy In Progress":
			getStatusIntoReportByName(getStatus, "Policy In Progress");
			break;
		case "Quote Decline":
			getStatusIntoReportByName(getStatus, "Quote Decline");
			break;
		default:
			break;
		}
	}
	
	public void setAddRemarkForAllIssuedStatus(DetailedReport test) throws Exception{
		
		waitForTheElementToBeLoad(ApplicationCommonOR.ADDREMARK_TEXTAREA,"Add Remark");
		waitForTheElementToBeLoad(ApplicationCommonOR.ADD_BTN,"Add Button");
		enterInputTextvalueByJavaScript(ApplicationCommonOR.ADDREMARK_TEXTAREA, "test", "Add Remark :",test);
		waitForTheElementToBeLoad(ApplicationCommonOR.MYWORK_DIV,"My Work");		
	}
	
	public void clickOnMyWorkPlan(DetailedReport test) throws Exception{
		
		waitForTheElementToBeLoad(ApplicationCommonOR.MY_WORK_LINK,"My Work Link");
		clickOnButton(ApplicationCommonOR.MY_WORK_LINK, test, "My Work Plan:");
		waitForTheElementToBeLoad(ApplicationCommonOR.MYWORK_DIV,"My Work");
	}

	public void getActionSubList(String option) {

	}
	
	/*
	 * Created By Shan
	 */
	
	

}
