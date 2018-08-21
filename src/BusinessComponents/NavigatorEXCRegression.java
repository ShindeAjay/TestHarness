package BusinessComponents;

import org.openqa.selenium.WebDriver;

import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorEXCRegression extends SeleniumHelper {
	private int _issuedFlag = 1;
	private int _pendingReviewFlag = 0;
	public NavigatorEXCRegression(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails){
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	
	/***
	 * Quote Issued - 08/06/2018
	 * LOB - Excess Casualty - END to END
	 * @throws Exception 
	 ***/
	
	public void setEndToEndForEXCWholeSale() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		NavigatorPolicyIssued _pIssued = new NavigatorPolicyIssued(_Browser, _objDetailedReport, _testDataManage, null);
		NavigatorEndorsementPage _EPolicy = new NavigatorEndorsementPage(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"), _testDataManage.getData("Three Letter code"),_issuedFlag);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"), _issuedFlag);
		_pIssued.setPolicyIssuedForEXC(_testDataManage.getData("Insured Name"));
		_EPolicy.setPolicyInternalEndorsedByInsuredName(_testDataManage.getData("Insured Name"));		
	}
	
	/***
	 * Regression For EXC - Quote
	 * @throws Exception 
	 */
	
	public void testQIPToDQIP() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteInProgressToDeleteQuoteInProgress(_testDataManage.getData("Insured Name"),"Delete In Progress");
	}
	
	public void testQIP_To_QPR() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"), _testDataManage.getData("Three Letter code"),_pendingReviewFlag);
	}
	
	public void testQIP_To_QI() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"), _testDataManage.getData("Three Letter code"),_issuedFlag);
	}
	
	public void testQI_To_ReQuote() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"), _testDataManage.getData("Three Letter code"),_issuedFlag);
		_qIssued.setReQuoteEXC(_testDataManage.getData("Insured Name"),"Re-Quote");
	}
	
	public void testQI_To_QD() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"), _testDataManage.getData("Three Letter code"), _issuedFlag);
		_qIssued.setQuoteDeclineByInsuredName(_testDataManage.getData("Insured Name"),"Decline");
	}
	
	public void testQIP_To_QNO() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"),_testDataManage.getData("Three Letter code"),_issuedFlag);
		_qIssued.setQuoteIssuedToQuoteNoOrderAndQuoteClosed(_testDataManage.getData("Insured Name"), "Quote No Order");
	}
	
	public void testQI_To_QC() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"),_testDataManage.getData("Three Letter code"),_issuedFlag);
		_qIssued.setQuoteIssuedToQuoteNoOrderAndQuoteClosed(_testDataManage.getData("Insured Name"), "Close");		
	}
	
	public void testQPR_To_ReviseQuote() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"),_testDataManage.getData("Three Letter code"),_pendingReviewFlag);
		_qIssued.setQuoteReviedByQuoteIssued(_testDataManage.getData("Insured Name"), "Revised");		
	}
	
	public void testQPR_To_QI() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"),_testDataManage.getData("Three Letter code"),_pendingReviewFlag);
		_qIssued.setQuotePendingReviewToQuoteIssued(_testDataManage.getData("Insured Name"), "Document Review",_issuedFlag);			
	}
	
	public void testQC_To_ReQuote() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"),_testDataManage.getData("Three Letter code"),_issuedFlag);
		_qIssued.setQuoteIssuedToQuoteNoOrderAndQuoteClosed(_testDataManage.getData("Insured Name"), "Close");	
		_qIssued.setReQuoteEXC(_testDataManage.getData("Insured Name"), "Re-Quote");
	}
	
	public void testQD_To_ReQuote() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"),_testDataManage.getData("Three Letter code"),_issuedFlag);
		_qIssued.setQuoteDeclineByInsuredName(_testDataManage.getData("Insured Name"),"Decline");
		_qIssued.setReQuoteEXC(_testDataManage.getData("Insured Name"), "Re-Quote");		
	}
	
	public void testQNO_To_ReQuote() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"),_testDataManage.getData("Three Letter code"),_issuedFlag);
		_qIssued.setQuoteIssuedToQuoteNoOrderAndQuoteClosed(_testDataManage.getData("Insured Name"), "Quote No Order");
		_qIssued.setReQuoteEXC(_testDataManage.getData("Insured Name"), "Re-Quote");
	}
	
	public void testQD_To_BIP() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"),_testDataManage.getData("Three Letter code"),_issuedFlag);
		_qIssued.setQuoteDeclineByInsuredName(_testDataManage.getData("Insured Name"), "Decline");
		_qIssued.setQuoteDeclineAndCloseToBinderInProgress(_testDataManage.getData("Insured Name"), "Bind","QD");
	}
	
	public void test_S_QI() throws Exception{		
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"), _testDataManage.getData("Three Letter code"),_issuedFlag);		
	}
	
	public void testQC_To_BIP() throws Exception{
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"),_testDataManage.getData("Three Letter code"),_issuedFlag);
		_qIssued.setQuoteIssuedToQuoteNoOrderAndQuoteClosed(_testDataManage.getData("Insured Name"), "Close");
		_qIssued.setQuoteDeclineAndCloseToBinderInProgress(_testDataManage.getData("Insured Name"), "Bind","QC");
	}
	
	/**
	 * Regression For EXC - Bind
	 * @throws Exception 
	 * 
	 */
	
	public void testQNO_To_BIP() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBinderInProgress(_testDataManage.getData("Insured Name"), _issuedFlag);
	}
	
	public void testBIP_to_QI() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBinderinProgressByinsuredName(_testDataManage.getData("Insured Name"));
		_bIssued.setBinderInProgressToQuoteIssued(_testDataManage.getData("Insured Name"), "Delete");
	}
	
	public void testBIP_To_BPR() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"),_pendingReviewFlag);
	}
	
	public void testBIP_To_BI() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"),_issuedFlag);		
	}
	
	public void testBPR_To_BI() throws Exception{		
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"),_pendingReviewFlag);	
		_bIssued.setBindPendingReviewToBinderIssuedEXC(_testDataManage.getData("Insured Name"), _issuedFlag);
	}
	
	public void testBI_To_ReBind() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"),_issuedFlag);
		_bIssued.setBinderIssuedToReBindEXC(_testDataManage.getData("Insured Name"));		
	}
	
	public void testBI_To_CB() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"),_issuedFlag);
		_bIssued.setBinderIssuedToCancelBinder(_testDataManage.getData("Insured Name"), "Cancel Binder", "Document Review", _issuedFlag);
	}
	
	public void testBI_To_PIP() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"),_issuedFlag);
		_bIssued.setBinderIssuedToPolicyInProgress(_testDataManage.getData("Insured Name"), "Assemble Policy");
	}
	
	public void testBC_To_ReInstate() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"),_issuedFlag);
		_bIssued.setBinderIssuedToCancelBinder(_testDataManage.getData("Insured Name"), "Cancel Binder", "Document Review", _issuedFlag);
		_bIssued.setBinderCancelToBinderIssued(_testDataManage.getData("Insured Name"), "Reinstate","Document Review",_issuedFlag);
	}
	
	public void testBC_To_ReQuote() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"),_issuedFlag);
		_bIssued.setBinderIssuedToCancelBinder(_testDataManage.getData("Insured Name"), "Cancel Binder", "Document Review", _issuedFlag);
		_bIssued.setBinderCancelToReQuote(_testDataManage.getData("Insured Name"), "Re-Quote");
	}
	
	public void test_S_QI_BI() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setQuoteIssued(_testDataManage.getData("Insured Name"), _testDataManage.getData("Three Letter code"),_issuedFlag);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"), _issuedFlag);
	}
	
	public void testBPR_To_ToRevise() throws Exception{
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"),_pendingReviewFlag);		
	}
	
	/*
	 * 
	 */
	
	public void testPIP_to_PPR() throws Exception{
		NavigatorPolicyIssued _pIssued = new NavigatorPolicyIssued(_Browser, _objDetailedReport,_testDataManage,null);
		_pIssued.setPolicyInProgressToPolicyPendingReview(_testDataManage.getData("Insured Name"), _pendingReviewFlag);		
	}
	
	public void testPIP_To_PI() throws Exception{
		NavigatorPolicyIssued _pIssued = new NavigatorPolicyIssued(_Browser, _objDetailedReport,_testDataManage,null);
		_pIssued.setPolicyIssuedForEXC(_testDataManage.getData("Insured Name"));
	}
	
	public void testS_PI() throws Exception{
		NavigatorPolicyIssued _pIssued = new NavigatorPolicyIssued(_Browser, _objDetailedReport,_testDataManage,null);
		NavigatorQuoteIssued _qIssued = new NavigatorQuoteIssued(_Browser, _objDetailedReport, _testDataManage, null);
		NavigatorBinderIssued _bIssued = new NavigatorBinderIssued(_Browser, _objDetailedReport, _testDataManage, null);
		_qIssued.setReQuoteEXC(_testDataManage.getData("Insured Name"), "quote");
		_bIssued.setBindIssuedForEXC(_testDataManage.getData("Insured Name"), _issuedFlag);		
		_pIssued.setPolicyIssuedForEXC(_testDataManage.getData("Insured Name"));
	}
}
