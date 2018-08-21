package BusinessComponents;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.ApplicationCommonOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorNameInsuredPage extends SeleniumHelper 
{		
	public NavigatorNameInsuredPage(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails){
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}	
	
	public void selectBusinessType(DetailedReport test) throws Exception{
		try {
			List<WebElement> HEADERLIST = _Browser.findElements( ApplicationCommonOR.BUSINESS_TYPE);
			int getHeaderCount = getHeaderCountByValue("Business Type",HEADERLIST);
			String getfinalBusinessType = String.format(ApplicationCommonOR.BUSINESSTYPE_SELECT, getHeaderCount);
			By xpathbusinessType = By.xpath(getfinalBusinessType);
			waitForTheElementToBeLoad(xpathbusinessType, "business Type");
			clickOnElement(xpathbusinessType);
			waitForTheElementToBeLoad(ApplicationCommonOR.BUSINESS_TYPE_SELECT_TAG, "Select Business Type");
			selectDropDownValueByLocator("1", ApplicationCommonOR.BUSINESS_TYPE_SELECT_TAG, "Select Business Type");
			waitForTheElementToBeLoad(ApplicationCommonOR.SIC_CODE_ID,"SIC Code");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void selectPrimarySICCode(DetailedReport test) throws Exception{
		
		waitForTheElementToBeLoad(ApplicationCommonOR.SIC_CODE_ID,"SIC Code");
		selectDropDownValuesByEnteringText(_testDataManage.getData("Primary SIC Code"), ApplicationCommonOR.SIC_CODE_ID, ApplicationCommonOR.SIC_CODE_TEXTBOX, ApplicationCommonOR.SIC_CODE_LIST, "Primary SIC code",test);
		waitForPageToLoadByCounter(10);
	}
	
	public void selectSICCategory(DetailedReport test) throws Exception{
		
		waitForTheElementToBeLoad(ApplicationCommonOR.PRIMARY_SIC_CODE, "SIC Category");
		selectDropDownValuesByEnteringText(_testDataManage.getData("SIC Category"), ApplicationCommonOR.PRIMARY_SIC_CODE, ApplicationCommonOR.SIC_CODE_TEXTBOX, ApplicationCommonOR.PRIMARY_SIC_LIST, "SIC Category", test);
		waitForPageToLoadByCounter(10);
	}

	public void selectDropDownValuesByEnteringText(DetailedReport test, String dataValue, By elment,
			By textBoxElement, String strElm, String valueName) throws Exception {
		waitForTheElementToBeLoad(elment,valueName);
		clickOnElement(elment);
		_Browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		waitForTheElementToBeLoad(textBoxElement,valueName);
		_Browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		enterInputTextvalueByJavaScript(textBoxElement, dataValue, "Entered Value is :- ",test);
		if ("Broker".equals(valueName)) {
			_Browser.findElement(textBoxElement).sendKeys(Keys.BACK_SPACE);
		} else if ("Insured Name".equals(valueName)) {
			_Browser.findElement(textBoxElement).sendKeys(Keys.SPACE);
		}
		waitForPageElementToLoad();
		WebElement selectionElement = getExactXpathPathAfterStringFormatting(strElm, dataValue);
		clickOnElement(selectionElement);
		_Browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		waitForPageElementToLoad();
	}
}
