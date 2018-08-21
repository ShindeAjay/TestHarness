package BusinessComponents;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.ApplicationCommonOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class DocumentReviewPage extends SeleniumHelper {

	public DocumentReviewPage(WebDriver Browser, DetailedReport objDetailedReport, TestDataManage testDataManage,
			String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}

	public void reviewDocumentByStatus(String passValueBy, DetailedReport test, int counter) {

		try {
			waitForPageElementToLoad();			
			switch (passValueBy) {
			case "Decline":
				viewDocumentByStatus(passValueBy, test, counter);
				break;
			case "Quote":
				viewDocumentByStatus(passValueBy, test, counter);
				break;
			case "Binder":
				viewDocumentByStatus(passValueBy, test, counter);
				break;
			case "Policy":
				Thread.sleep(25000);
				viewDocumentByStatus(passValueBy, test, counter);
				break;
			case "Endorsement":
				Thread.sleep(10000);
				viewDocumentByStatus(passValueBy, test, counter);
				break;
			case "BinderCancelled":
				viewDocumentByStatus(passValueBy, test, counter);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void viewDocumentByStatus(String option, DetailedReport test, int counter) throws Exception {
		By xpathdocumentViewer = null;
		if (!"Endorsement".equals(option)) {
			xpathdocumentViewer = By.xpath(".//*[@class='tree-documents']/div/div[2]/i[@class='fa fa-circle-thin']/../a[contains(text(),'View')]");
			waitForTheElementToBeLoad(xpathdocumentViewer,"View Link");			
			try {
				List<WebElement> elm = _Browser.findElements(ApplicationCommonOR.VIEW_DOC_LIST);
				waitForTheElementToBeLoad(ApplicationCommonOR.VIEW_DOC_LIST,"document List");				
				for (int i = 0; i < elm.size(); i++) {
					if ("quote".equalsIgnoreCase(option) || "policy".equalsIgnoreCase(option) || "binder".equalsIgnoreCase(option)) {
						waitForTheElementToBeLoad(ApplicationCommonOR.MAKECHANGES,"Make Changes");
						waitForTheElementToBeLoad(ApplicationCommonOR.SEND_FOR_REVIEW,"Send Review");
						clickOnButton(xpathdocumentViewer, test, "View button Clicked: ");
						handleParentWindow();
					}else{						
						clickOnButton(xpathdocumentViewer, test, "View button Clicked: ");
						handleParentWindow();
					}
					if (!"BinderCancelled".equals(option)) {
						waitForTheElementToBeLoad(ApplicationCommonOR.REVIEWER_CONTAINER,"Review Container");
						waitforElementToLoadByFluentWait(ApplicationCommonOR.SEND_FOR_REVIEW);
					}				
				}
				if (("policy".equalsIgnoreCase(option) && counter == 0) || ("quote".equalsIgnoreCase(option) && counter == 0) || ("binder".equalsIgnoreCase(option) && counter == 0) || ("Endorsement".equalsIgnoreCase(option) && counter == 0)) {
					waitForTheElementToBeLoad(ApplicationCommonOR.REVIEWER_CONTAINER,"Review Container");
					selectDropDownValuesByEnteringText("Crotty, Patrick", ApplicationCommonOR.REVIEWER_CONTAINER, ApplicationCommonOR.REVIEWER_TEXTBOX, ApplicationCommonOR.REVIEWER_LIST, "Reviewer Name :",test);
					clickOnButton(ApplicationCommonOR.SEND_FOR_REVIEW, test, "Review: ");
				} else {
					waitForTheElementToBeLoad(ApplicationCommonOR.REVIEWED_DOCUMENT,"Review document");
					clickOnElement(ApplicationCommonOR.REVIEWED_DOCUMENT);
					waitForTheElementToBeLoad(ApplicationCommonOR.RELEASE_BTN,"Release button");
					clickOnElement(ApplicationCommonOR.RELEASE_BTN);
				}
				waitforElementToLoadByFluentWait(ApplicationCommonOR.MYWORK_GRID);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			if (counter == 0) {
				waitForTheElementToBeLoad(ApplicationCommonOR.REVIEWED_DOCUMENT,"Review document");
				clickOnElement(ApplicationCommonOR.REVIEWED_DOCUMENT);
				waitForTheElementToBeLoad(ApplicationCommonOR.RELEASE_BTN,"Release button");
				clickOnElement(ApplicationCommonOR.RELEASE_BTN);
				waitforElementToLoadByFluentWait(ApplicationCommonOR.MYWORK_GRID);
			}else{
				waitForTheElementToBeLoad(ApplicationCommonOR.REVIEWER_CONTAINER,"Review Container");
				selectDropDownValuesByEnteringText("Crotty, Patrick", ApplicationCommonOR.REVIEWER_CONTAINER, ApplicationCommonOR.REVIEWER_TEXTBOX, ApplicationCommonOR.REVIEWER_LIST, "Reviewer Name :",test);
				clickOnButton(ApplicationCommonOR.SEND_FOR_REVIEW, test, "Review: ");
			}
			
		}						
	}

	public void handleParentWindow() {
		waitForPageElementToLoad();
		ArrayList<String> tabs = new ArrayList<String>(_Browser.getWindowHandles());		
		_Browser.switchTo().window(tabs.get(0));
	}

}
