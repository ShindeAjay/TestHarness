package BusinessComponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.ApplicationCommonOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class SubjectivityPage extends SeleniumHelper {

	public SubjectivityPage(WebDriver Browser, DetailedReport objDetailedReport,
			TestDataManage testDataManage, String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}
	
	public void selectCheckBoxToRecievedSubjectives(DetailedReport test) {

		try {
			waitForTheElementToBeLoad(ApplicationCommonOR.SUBJECTIVEITY_HEADER,"Subjectivity");
			List<WebElement> elmSubjectivityHeader = _Browser.findElements(ApplicationCommonOR.SUBJECTIVEITY_HEADER);
			int getRevievedIndex = getHeaderCountByValue("Received", elmSubjectivityHeader);
			String getFinalRecievedchekcBoxString = String.format(ApplicationCommonOR.SUBSTRING_RECIEVED_CHECKBOX, getRevievedIndex);
			List<WebElement> elmSubjectiveSelectedGrid = _Browser.findElements(ApplicationCommonOR.RECIEVED_TR_LIST);

			for (int i = 2; i <= elmSubjectiveSelectedGrid.size(); i++) {
				String subjectivityRecievedConcat = String.format(ApplicationCommonOR.RECIEVED_STRING, i);
				String getCheckBoxString = subjectivityRecievedConcat + getFinalRecievedchekcBoxString;
				By xpathRecievedCheckbox = By.xpath(getCheckBoxString);
				waitForTheElementToBeLoad(xpathRecievedCheckbox,"Recieved Column");
				clickOnElement(xpathRecievedCheckbox);
			}

			waitForPageElementToLoad();
			

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
