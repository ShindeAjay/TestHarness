package BusinessComponents;

import org.openqa.selenium.WebDriver;

import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorEndorsementPage extends SeleniumHelper {

	public NavigatorEndorsementPage(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	
	public void setPolicyInternalEndorsedByInsuredName(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorGeneralInfoPage _nGeneralInfo = new NavigatorGeneralInfoPage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PI", _objDetailedReport, "Internal Endorse");
		_nGeneralInfo.setEndorsmentDescription(_objDetailedReport,"Internal");
		_dReviewPage.reviewDocumentByStatus("Endorsement",_objDetailedReport,0);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);		
	}
	
	public void setEndorsedInternalPendingReview(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorGeneralInfoPage _nGeneralInfo = new NavigatorGeneralInfoPage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PI", _objDetailedReport, "Internal Endorse");
		_nGeneralInfo.setEndorsmentDescription(_objDetailedReport,"Internal");
		_dReviewPage.reviewDocumentByStatus("Endorsement",_objDetailedReport,1);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);		
	}
	
	public void setEndorsedExternalPendingReview(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorGeneralInfoPage _nGeneralInfo = new NavigatorGeneralInfoPage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		NavigatorScenarioCompAndCoveragePage _nCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PI", _objDetailedReport, "External Endorse");
		_nGeneralInfo.setEndorsmentDescription(_objDetailedReport,"External");
		_nCoverage.setFormsAndEndoresmentsOnScenarioPage(_objDetailedReport, "External Endorsed");
		_dReviewPage.reviewDocumentByStatus("Endorsement",_objDetailedReport,0);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
	public void setEIIPAndEEIP(String insuredName,String option) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		PackageAdministrationPage _pAdmin = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PI", _objDetailedReport, option);
		String getStatus = _pAdmin.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);	
	}
	
	public void setAuditEndorsedInProgress(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorGeneralInfoPage _nGeneralInfo = new NavigatorGeneralInfoPage(_Browser, _objDetailedReport, _testDataManage, null);
		NavigatorScenarioCompAndCoveragePage _nCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		PackageAdministrationPage _pAdmin = new PackageAdministrationPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PI", _objDetailedReport, "Audit Endorse");
		_nGeneralInfo.setEndorsmentDescription(_objDetailedReport,"External");
		_nCoverage.setFormsAndEndoresmentsOnScenarioPage(_objDetailedReport, "External Endorsed");		
		String getStatus = _pAdmin.getStatusFromPackageAdministrationPage();
		_nMyWorkPage.setStatusInReport(getStatus);	
	}
	
	public void setAuditEndorsedPendingReview(String insuredName) throws Exception{
		NavigatorMyWorkPage _nMyWorkPage = new NavigatorMyWorkPage(_Browser, _objDetailedReport, _testDataManage,null);
		NavigatorGeneralInfoPage _nGeneralInfo = new NavigatorGeneralInfoPage(_Browser, _objDetailedReport, _testDataManage, null);
		NavigatorScenarioCompAndCoveragePage _nCoverage = new NavigatorScenarioCompAndCoveragePage(_Browser, _objDetailedReport, _testDataManage, null);
		DocumentReviewPage _dReviewPage = new DocumentReviewPage(_Browser, _objDetailedReport, _testDataManage, null);
		_nMyWorkPage.editByNameAndAccountStatus(insuredName, "PI", _objDetailedReport, "Audit Endorse");
		_nGeneralInfo.setEndorsmentDescription(_objDetailedReport,"External");
		_nCoverage.setFormsAndEndoresmentsOnScenarioPage(_objDetailedReport, "External Endorsed");
		_dReviewPage.reviewDocumentByStatus("Endorsement",_objDetailedReport,0);
		String getStatus = _nMyWorkPage.getInsuredNameStatusByPassingvalue(insuredName, _objDetailedReport);
		_nMyWorkPage.setStatusInReport(getStatus);
	}
	
}
