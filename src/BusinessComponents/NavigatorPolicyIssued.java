package BusinessComponents;

import org.openqa.selenium.WebDriver;

import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorPolicyIssued extends SeleniumHelper{

	public NavigatorPolicyIssued(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	
	public void setPolicyIssuedByinsuredName(String insuredName,int counterFlag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorScenarioCompAndCoveragePage _nScenarioCompandCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BI", _objDetailedReport,"Assemble Policy");
		_nScenarioCompandCoverage.setFormsAndEndoresmentsOnScenarioPage(_objDetailedReport,"Policy");
		_dReviewPage.reviewDocumentByStatus("Policy",_objDetailedReport,0);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PPR", _objDetailedReport,"Document Review");		
		_dReviewPage.reviewDocumentByStatus("Policy",_objDetailedReport,1);
		getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setPolicyPendingReviewByinsuredName(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorScenarioCompAndCoveragePage _nScenarioCompandCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BI", _objDetailedReport,"Assemble Policy");
		_nScenarioCompandCoverage.setFormsAndEndoresmentsOnScenarioPage(_objDetailedReport,"Policy");
		_dReviewPage.reviewDocumentByStatus("Policy",_objDetailedReport,0);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setPolicyCancelledByInsuredName(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorGeneralInfoPage _nGenInfo = new NavigatorGeneralInfoPage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PI", _objDetailedReport, "Cancel Policy");
		_nGenInfo.selectCancellationReason(_objDetailedReport);
		_dReviewPage.reviewDocumentByStatus("Endorsement",_objDetailedReport,1);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setPolicyReinstateByInsuredName(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PRIP", _objDetailedReport, "Document Review");
		_dReviewPage.reviewDocumentByStatus("Policy",_objDetailedReport,1);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setPolicyReinstateinProgressByInsuredName(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PC", _objDetailedReport,"Reinstate");
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	/******
	 * LOB - EXC
	 * Date :- 8-14-2018
	 * @throws Exception 
	 */
	
	public void setPolicyIssuedForEXC(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorScenarioCompAndCoveragePage _nScenarioCompandCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BI", _objDetailedReport,"Assemble Policy");
		_nScenarioCompandCoverage.setFormsAndEndorsementOnScenarioSectionforEXC(_objDetailedReport, "Policy");
		_dReviewPage.reviewDocumentByStatus("Policy",_objDetailedReport, 0);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PPR", _objDetailedReport,"Document Review");		
		_dReviewPage.reviewDocumentByStatus("Policy",_objDetailedReport,1);
		getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);		
	}
	
	public void setPolicyInProgressToPolicyPendingReview(String insuredName,int counterFlag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorScenarioCompAndCoveragePage _nScenarioCompandCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "BI", _objDetailedReport,"Assemble Policy");
		_nScenarioCompandCoverage.setFormsAndEndorsementOnScenarioSectionforEXC(_objDetailedReport, "Policy");
		_dReviewPage.reviewDocumentByStatus("Policy",_objDetailedReport, counterFlag);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setPolicyIssuedToPolicyReIssue(String insuredName,int counterFlag) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdmin = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName,"PI", _objDetailedReport,"Re-issue Policy");
		String getStatus = _pAdmin.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);
		
	}
	
	public void setPolicyIssuedToRenew(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName,"PI", _objDetailedReport,"Renew");
	}
	
	public void setPolicyInProgressToDeleteInProgress(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName,"BI", _objDetailedReport,"Assemble Policy");
		_nMyWorkPage.clickOnMyWorkPlan(_objDetailedReport);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName,"PIP", _objDetailedReport,"Delete In Progress");
		_nMyWorkPage.getActionMessage();
		_nMyWorkPage.clearFilter();
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
}
