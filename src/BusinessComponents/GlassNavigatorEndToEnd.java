package BusinessComponents;

import org.openqa.selenium.WebDriver;

import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class GlassNavigatorEndToEnd extends SeleniumHelper {
	public int _issuedFlag = 1;
	public int _pendingReviewFlag = 0;
	public static String insuredName = null;
	public GlassNavigatorEndToEnd(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	
	public void setSubmissionNavigator() throws Exception{
		NavigatorAccountSetupPage _nAccSetup = new NavigatorAccountSetupPage(_Browser, _objDetailedReport, _testDataManage, null);
		ClearanceResultPage _cResult = new ClearanceResultPage(_Browser, _objDetailedReport, _testDataManage, null);
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdmin = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage, null);
		String insuredName = _nAccSetup.setUpAccountOnNavigator();
		_cResult.performActionOnClearanceResultPage(_objDetailedReport, _testDataManage.getData("TempNo"), _testDataManage.getData("status"));
		if (_testDataManage.getData("status").contains("Proceed")) {
			String getStatus = _pAdmin.getStatusFromPackageAdministrationPage();
			_nMyWorkPage.setStatusInReport(getStatus);	
		}else{
			String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
			_nMyWorkPage.setStatusInReport(getStatus);		
		}	
	}
	
	public void setSubmissionGlass() throws Exception{
		GlassAccountSetupPage g = new GlassAccountSetupPage(_Browser, _objDetailedReport, _testDataManage,null);			
		g.setupGlobalAccount(_testDataManage.getData("Insured Name"));		
		g.completeSubmission(_testDataManage.getData("Action"));	
		g.getStatusByInsuredName(_testDataManage.getData("Insured Name"), _objDetailedReport);				
	}
	/********************
	 *  Quote Regression Test Cases - 02-08-2018
	 * */
	
	public void testQuoteIssued() throws Exception{		
		System.out.println("Insured name is-"+_testDataManage.getData("Insured Name")+"-Quote issued");		
		NavigatorQuoteIssued _nQIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);		
		_nQIssued.setQuoteByInsuredName(_testDataManage.getData("Insured Name"),_issuedFlag,_testDataManage.getData("Three Letter code"));
	}
	
	public void testQuoteInProgress() throws Exception{
		NavigatorQuoteIssued _nQIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);		
		_nQIssued.setQuoteInProgressByInsuredname(_testDataManage.getData("Insured Name"));
	}
	
	public void testQuotePendingReview() throws Exception{
		NavigatorQuoteIssued _nQIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);		
		_nQIssued.setQuoteByInsuredName(_testDataManage.getData("Insured Name"), _pendingReviewFlag,_testDataManage.getData("Three Letter code"));
	}
	
	public void testQuoteDecline() throws Exception{
		NavigatorQuoteIssued _nQIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);				
		_nQIssued.setQuoteDeclineByInsuredName(_testDataManage.getData("Insured Name"),"Decline");
	}
	
	public void testQuoteClosed() throws Exception{
		NavigatorQuoteIssued _nQIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);				
		_nQIssued.setQuoteDeclineByInsuredName(_testDataManage.getData("Insured Name"),"Close");
	}

	public void testQuoteNoOrder() throws Exception{
		NavigatorQuoteIssued _nQIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);			
		_nQIssued.setQuoteDeclineByInsuredName(_testDataManage.getData("Insured Name"),"Quote No Order");
	}
	
	public void testQuoteIssuedExistingAccount() throws Exception{
		NavigatorQuoteIssued _nQIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);		
		_nQIssued.setQuoteByInsuredName(_testDataManage.getData("Insured Name"), _issuedFlag,_testDataManage.getData("Three Letter code"));
	}
	
	/**********************
	 * Binder Regression test Cases - 02-08-2018
	 * @throws Exception 
	 * */
	
	public void testBindInProgress() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBinderinProgressByinsuredName(_testDataManage.getData("Insured Name"));
	}
	
	public void testBinderCancellationInProgress() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBinderCancellationInProgress(_testDataManage.getData("Insured Name"));
	}
	
	public void testBindIssued() throws Exception{
		System.out.println("Insured name is-"+insuredName+"-Binder issued");
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBinderIssuedByInsuredName(_testDataManage.getData("Insured Name"),_issuedFlag);
	}
	
	public void testbinderCancelledAccount() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setbinderCancelledAccount(_testDataManage.getData("Insured Name"), _pendingReviewFlag);
	}
	
	public void testBinderPendingReview() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBinderIssuedByInsuredName(_testDataManage.getData("Insured Name"),_pendingReviewFlag);
	}
	
	/**
	 * Policy Issued Regression - 08-02-2018 
	 * @throws Exception 
	 */
	
	public void testPolicyInProgress() throws Exception{
		
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(_testDataManage.getData("Insured Name"), "BI", _objDetailedReport, "Assemble Policy");
		String getStatus = _pAdminPage.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);	
	}
	
	public void testPolicyIssued() throws Exception{
		System.out.println("Insured name is-"+insuredName+"-Policy issued");
		NavigatorPolicyIssued _pIssued = new NavigatorPolicyIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_pIssued.setPolicyIssuedByinsuredName(_testDataManage.getData("Insured Name"),_issuedFlag);
	}
	
	public void testPolicyPendingReview() throws Exception{
		NavigatorPolicyIssued _pIssued = new NavigatorPolicyIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_pIssued.setPolicyPendingReviewByinsuredName(_testDataManage.getData("Insured Name"));
	}
	
	public void testPolicyCancelled() throws Exception{
		NavigatorPolicyIssued _pIssued = new NavigatorPolicyIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_pIssued.setPolicyCancelledByInsuredName(_testDataManage.getData("Insured Name"));
	}
	
	public void testPolicyReinstate() throws Exception{
		NavigatorPolicyIssued _pIssued = new NavigatorPolicyIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_pIssued.setPolicyReinstateByInsuredName(_testDataManage.getData("Insured Name"));
	}
	
	public void testPolicyReInstateInProgress() throws Exception{
		NavigatorPolicyIssued _pIssued = new NavigatorPolicyIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_pIssued.setPolicyReinstateinProgressByInsuredName(_testDataManage.getData("Insured Name"));
	}
	
	/***
	 * Policy Endorsement Regression Test Case - 08-02-2018
	 * @throws Exception
	 */
	
	public void testAuditEndorsedInProgress() throws Exception{
		NavigatorEndorsementPage _pEndorsed = new NavigatorEndorsementPage(_Browser, _objDetailedReport, _testDataManage, null);
		_pEndorsed.setAuditEndorsedInProgress(_testDataManage.getData("Insured Name"));
	}
	
	public void testAuditEndorsedPendingReview() throws Exception{
		NavigatorEndorsementPage _pEndorsed = new NavigatorEndorsementPage(_Browser, _objDetailedReport, _testDataManage, null);
		_pEndorsed.setAuditEndorsedPendingReview(_testDataManage.getData("Insured Name"));
	}
	
	public void testInternalEndorsmentInProgress() throws Exception{
		NavigatorEndorsementPage _pEndorsed = new NavigatorEndorsementPage(_Browser, _objDetailedReport, _testDataManage, null);
		_pEndorsed.setEIIPAndEEIP(_testDataManage.getData("Insured Name"),"Internal Endorse");
	}
	
	public void testEndorsedInternalPendingReview() throws Exception{
		NavigatorEndorsementPage _pEndorsed = new NavigatorEndorsementPage(_Browser, _objDetailedReport, _testDataManage, null);
		_pEndorsed.setEndorsedInternalPendingReview(_testDataManage.getData("Insured Name"));
	}
	
	public void testExternalEndorsementInProgress() throws Exception{
		NavigatorEndorsementPage _pEndorsed = new NavigatorEndorsementPage(_Browser, _objDetailedReport, _testDataManage, null);
		_pEndorsed.setEIIPAndEEIP(_testDataManage.getData("Insured Name"),"External Endorsed");
	}
	
	public void testEndorsedExternalPendingReview() throws Exception{
		NavigatorEndorsementPage _pEndorsed = new NavigatorEndorsementPage(_Browser, _objDetailedReport, _testDataManage, null);
		_pEndorsed.setEndorsedExternalPendingReview(_testDataManage.getData("Insured Name"));
	}
	
	public void testPolicyEndorsed() throws Exception{
		System.out.println("Insured name is-"+insuredName+"-Endorsed issued");
		NavigatorEndorsementPage _pEndorsed = new NavigatorEndorsementPage(_Browser, _objDetailedReport, _testDataManage, null);
		_pEndorsed.setPolicyInternalEndorsedByInsuredName(_testDataManage.getData("Insured Name"));
	}	
	
	
	 
}
