package BusinessComponents;

import org.openqa.selenium.WebDriver;

import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorBinderIssued extends SeleniumHelper {

	public NavigatorBinderIssued(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	
	public void setBinderIssuedByInsuredName(String insuredName,int counterflag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorScenarioCompAndCoveragePage _nScenarioCompandCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QI", _objDetailedReport, "Bind");
		_nScenarioCompandCoverage.setFormsAndEndoresmentsOnScenarioPage(_objDetailedReport, "Bind");
		_dReviewPage.reviewDocumentByStatus("Binder", _objDetailedReport, counterflag);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setBinderinProgressByinsuredName(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QI", _objDetailedReport, "Bind");
		String getStatus = _pAdminPage.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);
		
	}
	
	public void setBinderCancellationInProgress(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BI", _objDetailedReport, "Cancel Binder");
		_nMyWorkPage.clearFilter();
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setbinderCancelledAccount(String insuredName,int counterflag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BCIP", _objDetailedReport, "Document Review");
		_dReviewPage.reviewDocumentByStatus("BinderCancelled", _objDetailedReport, counterflag);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setbinderReinstate(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BC", _objDetailedReport, "Reinstate");
		_nMyWorkPage.clearFilter();
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	/**
	 *  LOB - EXC
	 * @throws Exception 
	 * Date :- 8-14-2018
	 */
	
	public void setBindIssuedForEXC(String insuredName, int counterFlag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorScenarioCompAndCoveragePage _nScenarioCompandCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QI", _objDetailedReport, "Bind");
		_nScenarioCompandCoverage.setFormsAndEndorsementOnScenarioSectionforEXC(_objDetailedReport,"Bind");
		_dReviewPage.reviewDocumentByStatus("Binder", _objDetailedReport, counterFlag);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);	
	}
	
	public void setBinderIssuedToReBindEXC(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BI", _objDetailedReport, "Re-Bind");
		String getStatus = _pAdminPage.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setBindPendingReviewToBinderIssuedEXC(String insuredName,int counterFlag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BPR", _objDetailedReport, "Document Review");
		_dReviewPage.reviewDocumentByStatus("Binder", _objDetailedReport, counterFlag);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);			
	}
	
	public void setBinderInProgress(String insuredName,int counterFlag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QNO", _objDetailedReport, "Bind");
		String getStatus = _pAdminPage.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setBinderInProgressToQuoteIssued(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.clickOnMyWorkPlan(_objDetailedReport);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BIP", _objDetailedReport,action);
		_nMyWorkPage.getActionMessage();
		_nMyWorkPage.clearFilter();
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setBinderIssuedToCancelBinder(String insuredName,String action,String action1,int counterFlag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BI", _objDetailedReport,action);
		_nMyWorkPage.getActionMessage();
		_nMyWorkPage.clearFilter();
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BCIP", _objDetailedReport,action1);
		_dReviewPage.reviewDocumentByStatus("Binder", _objDetailedReport, counterFlag);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);		
	}
	
	public void setBinderIssuedToPolicyInProgress(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BI", _objDetailedReport,action);
		String getStatus = _pAdminPage.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setBinderCancelToBinderIssued(String insuredName,String action,String action1,int counterFlag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BC", _objDetailedReport,action);
		_nMyWorkPage.getActionMessage();
		_nMyWorkPage.clearFilter();
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BRIP", _objDetailedReport,action1);
		_dReviewPage.reviewDocumentByStatus("Binder", _objDetailedReport, counterFlag);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);				
	}
	
	public void setBinderCancelToReQuote(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BC", _objDetailedReport,action);
		String getStatus = _pAdminPage.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setBinderPendingReviewToRevise(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BPR", _objDetailedReport,"Revise");
		String getStatus = _pAdminPage.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);
	}
}
