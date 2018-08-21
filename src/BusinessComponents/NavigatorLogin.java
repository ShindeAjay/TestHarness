package BusinessComponents;

import org.openqa.selenium.WebDriver;

import ObjectRepository.ApplicationCommonOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorLogin extends SeleniumHelper{

	public NavigatorLogin(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails){
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	
	public void navigateLogin() throws Exception{
		setNavigatorURL(_testDataManage.getData("URL"));
		setUserName(_testDataManage.getData("UserName"));
		setPassword(_testDataManage.getData("Password"));
		loginNavigator();
	}
	
	public void setNavigatorURL(String URL) throws Exception{
		hitGivenURL("URL", _objDetailedReport,URL);
		waitForTheElementToBeLoad(ApplicationCommonOR.LOGIN_EMAIL_TXT,"Login Email");
	}
	
	public void setUserName(String _userName) throws Exception{
		waitForTheElementToBeLoad(ApplicationCommonOR.LOGIN_EMAIL_TXT,"Login Email");
		enterInputTextvalueByJavaScript(ApplicationCommonOR.LOGIN_EMAIL_TXT, _userName, "UserName : ",_objDetailedReport);
		waitForTheElementToBeLoad(ApplicationCommonOR.LOGIN_PWD_TXT,"Login Password ");
	}
	
	public void setPassword(String _Password) throws Exception{
		waitForTheElementToBeLoad(ApplicationCommonOR.LOGIN_PWD_TXT,"Login Password ");
		enterInputTextvalueByJavaScript(ApplicationCommonOR.LOGIN_PWD_TXT, _Password, "passWord : ",_objDetailedReport);
		waitForTheElementToBeLoad(ApplicationCommonOR.LOGIN_BTN,"Login Button");
	}

	public void loginNavigator() throws Exception{
		waitForTheElementToBeLoad(ApplicationCommonOR.LOGIN_BTN,"Login Button");
		clickOnButton(ApplicationCommonOR.LOGIN_BTN);
		waitForPageToLoadByCounter(6);
	}	
}
