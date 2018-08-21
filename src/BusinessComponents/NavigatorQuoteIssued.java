package BusinessComponents;

import org.openqa.selenium.WebDriver;

import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorQuoteIssued extends SeleniumHelper {
	
	public NavigatorQuoteIssued(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	
	/***
	 * 
	 * @param insuredName
	 * @param counterFlag
	 * @param _tlCode
	 * @throws Exception
	 * LOB - ECP 
	 */
	
	public void setQuoteByInsuredName(String insuredName,int counterFlag,String _tlCode) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorScenarioCompAndCoveragePage _nScenarioCompandCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);		
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "S", _objDetailedReport, "Quote");
		_pAdminPage.proceedQuoteInProgressToQouteIssued(_objDetailedReport,_tlCode);
		_nScenarioCompandCoverage.selectRetroActiveTermRatingFactor(_objDetailedReport);
		_nScenarioCompandCoverage.setAlltheFieldsOnExposureTab(_objDetailedReport);
		_nScenarioCompandCoverage.setFormsAndEndoresmentsOnScenarioPage(_objDetailedReport, "Quote");
		_dReviewPage.reviewDocumentByStatus("Quote", _objDetailedReport, counterFlag);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
		System.out.println(getStatus);		
	}
	
	public void setQuoteInProgressByInsuredname(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "S", _objDetailedReport, "Quote");		
		String getStatus = _pAdminPage.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setQuoteDeclineByInsuredName(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QI", _objDetailedReport, action);			
		_nMyWorkPage.clearFilter();
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setQuoteNoOrderByInsuredName(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QI", _objDetailedReport, action);	
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setQuoteIssuedExistingAccount(String insuredName,int counterFlag,String _tlCode) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorScenarioCompAndCoveragePage _nScenarioCompandCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);		
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.clickOnMyWorkPlan(_objDetailedReport);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "S", _objDetailedReport, "Quote");
		_pAdminPage.proceedQuoteInProgressToQouteIssued(_objDetailedReport,_tlCode);
		_nScenarioCompandCoverage.selectRetroActiveTermRatingFactor(_objDetailedReport);
		_nScenarioCompandCoverage.setAlltheFieldsOnExposureTab(_objDetailedReport);
		_nScenarioCompandCoverage.setFormsAndEndoresmentsOnScenarioPage(_objDetailedReport, "Quote");
		_dReviewPage.reviewDocumentByStatus("Quote", _objDetailedReport, counterFlag);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	/**
	 *  LOB - EXC
	 * @throws Exception 
	 * 
	 */
	
	public void setQuoteIssued(String insuredName,String _tlCode,int counterFlag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorScenarioCompAndCoveragePage _nScenarioCompandCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "S", _objDetailedReport, "Quote");
		_pAdminPage.proceedQuoteInProgressToQouteIssued(_objDetailedReport,_tlCode);
		_nScenarioCompandCoverage.setCoverageForEachRatingTabEXC();
		_nScenarioCompandCoverage.setRatingOnRatingOverviewTab(_objDetailedReport);
		_nScenarioCompandCoverage.setFormsAndEndorsementOnScenarioSectionforEXC(_objDetailedReport, "Quote");
		//_nScenarioCompandCoverage.setSubjectivityForEXC(_objDetailedReport, "Quote");
		_dReviewPage.reviewDocumentByStatus("Quote", _objDetailedReport, counterFlag);	
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setQuoteInProgressToDeleteQuoteInProgress(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.clickOnMyWorkPlan(_objDetailedReport);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QIP", _objDetailedReport,action);
		_nMyWorkPage.getActionMessage();
		_nMyWorkPage.clearFilter();
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setQuoteInProgressToQuoteNoOrder(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.clickOnMyWorkPlan(_objDetailedReport);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QIP", _objDetailedReport,action);
	}
	
	public void setReQuoteEXC(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdmin = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QI", _objDetailedReport,action);
		String getStatus = _pAdmin.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);	
	}
	
	public void setQuoteDeclineByQuoteInProgress(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QI", _objDetailedReport, action);			
		_nMyWorkPage.clearFilter();
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setQuoteIssuedToQuoteNoOrderAndQuoteClosed(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QI", _objDetailedReport, action);	
		_nMyWorkPage.clearFilter();
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setQuoteReviedByQuoteIssued(String insuredName,String action) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdmin = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QPR", _objDetailedReport, action);	
		String getStatus = _pAdmin.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);	
	}
	
	public void setQuotePendingReviewToQuoteIssued(String insuredName,String action,int counterFlag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "QPR", _objDetailedReport, action);
		_dReviewPage.reviewDocumentByStatus("Quote", _objDetailedReport, counterFlag);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
		
	}
	
	public void setQuoteDeclineAndCloseToBinderInProgress(String insuredName, String action,String statusCode) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdmin = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, statusCode, _objDetailedReport, action);
		String getStatus = _pAdmin.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);	
	}
	
	/*********
	 * LOB - NP3
	 * @throws Exception 
	 * 
	 */
	public void setQuoteIssuedNP3(String insuredName,String _tlCode) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdminPage = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorScenarioCompAndCoveragePage _nScenarioCompandCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "S", _objDetailedReport, "Quote");
		_pAdminPage.proceedQuoteInProgressToQouteIssued(_objDetailedReport,_tlCode);
		
	}
	
	
}
