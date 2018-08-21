package BusinessComponents;


import org.openqa.selenium.WebDriver;

import ObjectRepository.NavigatorLoginPageOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorPolicyEndorsed extends SeleniumHelper{

	public NavigatorPolicyEndorsed(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	public void navigateNavigator() {

		hitGivenURL("URL", _objDetailedReport, _testDataManage.getData("URL"));
	}

	public void enterUserName() throws Exception {

		enterInputTextvalue(NavigatorLoginPageOR.getLoginEmailTxt(), _testDataManage.getData("UserName"), "userName",
				_objDetailedReport);
	}

	public void enterPassword() throws Exception {

		enterInputTextvalue(NavigatorLoginPageOR.getLoginPwdTxt(), _testDataManage.getData("Password"), "Password",
				_objDetailedReport);
	}

	public void login() throws Exception {

		clickOnButton(NavigatorLoginPageOR.getLoginBtn(), "LoginBtn");
	}
	
	
	/*************
	 * Date - 07/31/2018
	 * author - LNT Infotech
	 */
		
}
