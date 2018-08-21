package SeleniumHelper;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Report.DetailedReport;
import Report.DetailedReport.Status;
import TestDataManagement.TestDataManage;
import junit.framework.TestCase;

public class SeleniumHelper extends TestCase {

		public TestDataManage _testDataManage = new TestDataManage();		
		protected WebDriver _Browser = null;
		public	DetailedReport _objDetailedReport = null;
		public String sheetName = null;
		public String testCase = null;
		String[] BCBrowser;
		String BrowserKind;
		String DeviceType;
		String MobileBrowser;
		String SystemName;
		
		public JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) _Browser;
		
		public boolean clickOnElement(WebElement WEBELEMENT,String button) throws Exception {
			try {
				if (WEBELEMENT != null) {
					Actions a = new Actions(_Browser);
					a.moveToElement(WEBELEMENT);
					a.click().build().perform();				
					return true;
				} else {
					_objDetailedReport.WriteLog(Status.PASS, "Element Should be Clicked"+button, "Element to be Clicked"+button, null);
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				_objDetailedReport.WriteLog(Status.PASS, "Element Should be Clicked"+button, "Element to be Clicked"+e, null);
				return false;
			}
		}
		
		public boolean clickOnElement(By WEBELEMENT,String button) throws Exception {
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			WebElement elm = _Browser.findElement(WEBELEMENT);
			try {
				if (elm != null) {
					webDriverWait.until(ExpectedConditions.elementToBeClickable(WEBELEMENT));
					Actions a = new Actions(_Browser);
					a.moveToElement(elm);
					a.click().build().perform();				
					return true;
				} else {
					_objDetailedReport.WriteLog(Status.PASS, "Element Should be Clicked"+button, "Element to be Clicked"+button, null);
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				_objDetailedReport.WriteLog(Status.PASS, "Element Should be Clicked"+button, "Element to be Clicked"+e, null);
				return false;
			}
		}
		
		public void clickOnLinkByText(String value, DetailedReport test, String stringWebElement) throws Exception {

			String getScenarioTabString = String.format(stringWebElement, value);
			By xpathGetScenarioTab = By.xpath(getScenarioTabString);
			waitForTheElementToBeLoad(xpathGetScenarioTab,stringWebElement);
			clickOnButton(xpathGetScenarioTab, test, value);
			waitForPageElementToLoad();
		}
		
		public void selectDateByFromAndTo(DetailedReport test, By elm, String dataValue, String elm2, By elm1,String action) {
			try {
				waitForTheElementToBeLoad(elm,action);
				int startDateAndEndDate = getTodaysDay();
				clickOnButton(elm);
				waitForPageToLoadByCounter(10);
				String getActualTodayDateXpath = String.format(elm2, startDateAndEndDate);				
				By xpathTodayDate = By.xpath(getActualTodayDateXpath);
				WebElement webElementTodayDate = _Browser.findElement(xpathTodayDate);
				if (webElementTodayDate != null) {
					_Browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					//need to Write - 27/06/2018
					clickOnElement(xpathTodayDate);
				}
				waitForPageToLoadByCounter(10);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		
		public boolean getCheckboxStatusCheckedOrNot(By elm) {
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			webDriverWait.until(ExpectedConditions.elementToBeClickable(elm));
			WebElement elment = _Browser.findElement(elm);
			try {
				if (elment.isSelected()) {
					clickCheckToUnchecked(elm);
				} else if (!elment.isSelected()) {
					clickCheckToUnchecked(elm);
				}
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		
		public boolean moveToElementByLocator(WebElement locator,By subLocator,String action){
			WebElement elm = _Browser.findElement(subLocator);
			try {
				if (locator != null) {
					Actions a = new Actions(_Browser);
					a.moveToElement(locator).perform();
					waitForTheElementToBeLoad(subLocator,action);
					a.moveToElement(elm);
					a.click().build().perform();
					return true;
				}else{
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}
		public void clickWithJavaScriptEXecutor(By elm, DetailedReport report, String text) {
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			WebElement elm1 = _Browser.findElement(elm);
			try {
				if (elm1 != null) {
					webDriverWait.until(ExpectedConditions.elementToBeClickable(elm));
					JavascriptExecutor executor = (JavascriptExecutor) _Browser;
					executor.executeScript("arguments[0].click();", elm1);					
					report.WriteLog(Status.PASS,"User should be able to click on"+text, "User to click on"+text, null);
				} else {
					report.WriteLog(Status.FAIL,"User should be able to click on"+text, "User to click on"+text, null);
				}
			} catch (Exception e) {
				report.WriteLog(Status.FAIL,"User should be able to click on"+text, "User to click on"+e, null);
			}
		}
		
		public void getStatusIntoReportByName(String Actualstatus,String requiredStatus) throws Exception{
			if (requiredStatus.equals(Actualstatus)) {
				_objDetailedReport.WriteLog(Status.PASS, "Status Should be"+requiredStatus, "Status is "+Actualstatus, null);
			}else{
				_objDetailedReport.WriteLog(Status.FAIL, "Status Should be"+requiredStatus, "Status is "+Actualstatus, null);
			}
		}
		public WebElement getExactXpathPathAfterStringFormatting(String locator, String value) {
			By byFinalLocator = null;
			try {
				String getFinalLocator = String.format(locator, value);
				byFinalLocator = By.xpath(getFinalLocator);	
				waitForTheElementToBeLoad(byFinalLocator, value);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return _Browser.findElement(byFinalLocator);
		}
	
		public WebDriverWait waitforElementToLoadByExplicit() {
			WebDriverWait webDriverWait = new WebDriverWait(_Browser, 85);	
					return webDriverWait;
		}

		public void waitforElementToLoadByFluentWait(By locator) {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(_Browser).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		public void moveTotheCheckboxAndClick(By byLob, String action){
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			WebElement elm = _Browser.findElement(byLob);
			try {
				if (!elm.isSelected()) {
					webDriverWait.until(ExpectedConditions.elementToBeClickable(elm));
					elm.click();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public boolean waitForTheElementToBeLoad(By WEBELEMENT,String action) throws Exception {

			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			WebElement elm = _Browser.findElement(WEBELEMENT);
			try {
				
				if (elm != null) {				
					webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(WEBELEMENT));
					return true;
				} else {
				
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
				return false;
			}
		}
		
		public void selectDropDownValueFromTable(By elm,By elmTextBox,By elm3,String value){
			try {
				clickOnElement(elm);
				waitForTheElementToBeLoad(elmTextBox,"Class code");
				enterInputTextvalue(elmTextBox,"AM","class Code",_objDetailedReport);
				waitForPageToLoadByCounter(5);
				clickOnElement(elm3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void hitGivenURL(String action,DetailedReport _objDetailedReport,String url){
			if (!url.equals(" ") && !url.equals(null)) {
				_Browser.get(url);
				_objDetailedReport.WriteLog(Status.PASS, "Entered "+action+" value should be "+url, "Entered "+action+" value is "+url, _Browser);
			}else{
				_objDetailedReport.WriteLog(Status.FAIL, "Entered "+action+" value should be "+url, "Entered "+action+" value is "+url, _Browser);
			}
		}
		
		public void clickOnLink(By locator,String value, String action,DetailedReport _objDetailedReport){
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			WebElement elm = _Browser.findElement(locator);
			try {
				if (elm != null) {
					webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
					Actions a = new Actions(_Browser);
					a.moveToElement(elm);
					a.click().build().perform();	
					_objDetailedReport.WriteLog(Status.PASS, "Entered "+action+" value should be "+value, "Entered "+action+" value is "+value, _Browser);
				}else{
					_objDetailedReport.WriteLog(Status.FAIL, "Entered "+action+" value should be "+value, "Entered "+action+" value is "+value, _Browser);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public boolean enterInputTextvalue(By locator, String value, String action,DetailedReport _objDetailedReport) throws Exception {
			System.out.println("Values are is "+value);
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			WebElement WEBELEMENT = _Browser.findElement(locator);	
			try {
				if (WEBELEMENT != null) {
					webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
					WEBELEMENT.sendKeys(value);					
					_objDetailedReport.WriteLog(Status.PASS, "Entered "+action+" value should be "+value, "Entered "+action+" value is "+value, _Browser);			
					return true;					
				} else {
					_objDetailedReport.WriteLog(Status.FAIL, "Entered "+action+" value should be "+value, "Entered "+action+" value is "+value, _Browser);
					return false;
				}
			} catch (Exception e) {								
				_objDetailedReport.WriteLog(Status.FAIL, "Entered "+action+" value should be "+value, "Entered "+action+" value is "+e, _Browser);
				return false;
			}
		}

		public boolean enterInputTextvalueByJavaScript(By locator, String value,String action,DetailedReport _objDetailedReport) throws Exception {
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) _Browser;
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			WebElement WEBELEMENT = _Browser.findElement(locator);
		
			try {
				if (WEBELEMENT != null) {
					webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
					javaScriptExecutor.executeScript("arguments[0].value='" + value + "';", WEBELEMENT);														
					_objDetailedReport.WriteLog(Status.PASS, "Entered "+action+" value should be "+value, "Entered "+action+" value is "+value, _Browser);
					return true;
				} else {	
					_objDetailedReport.WriteLog(Status.FAIL, "Entered "+action+" value should be "+value, "Entered "+action+" value is "+value, _Browser);
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception				
				_objDetailedReport.WriteLog(Status.FAIL, "Entered "+action+" value should be "+value, "Entered "+action+" value is "+e, _Browser);
				return false;
			}
		}
		
		public void setStatusIntoDetailReporting(){
			
		}

		public String getInsuredRandomName(String insuredName,String letterCode) {
			Random r = new Random();
			int rand_int1 = r.nextInt(1000);
			return insuredName + "_" + String.valueOf(rand_int1)+"_"+letterCode;
		}
		
		public boolean clickOnElement(By WEBELEMENT) {
			waitforElementToLoadByFluentWait(WEBELEMENT);
			WebElement elm = _Browser.findElement(WEBELEMENT);		
			try {
				if (elm != null) {				
					/*Actions a = new Actions(driver);
					a.moveToElement(elm);
					a.click().build().perform();	*/
					elm.click();
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}	
		
		public boolean clickOnElement(WebElement WEBELEMENT) {
		
			try {
				if (WEBELEMENT != null) {				
					/*Actions a = new Actions(driver);
					a.moveToElement(elm);
					a.click().build().perform();	*/
					WEBELEMENT.click();
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}	

		public boolean clickOnButton(By WEBELEMENT) {
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			WebElement elm = _Browser.findElement(WEBELEMENT);
			
			try {
				if (elm != null) {
					webDriverWait.until(ExpectedConditions.elementToBeClickable(WEBELEMENT));
					Actions a = new Actions(_Browser);
					a.moveToElement(elm);
					a.click().build().perform();
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}	
		
		public boolean clickOnButton(WebElement WEBELEMENT,String text) {
			
			try {
				if (WEBELEMENT != null) {					
					Actions a = new Actions(_Browser);
					a.moveToElement(WEBELEMENT);
					a.click().build().perform();
					return true;
				} else {
					_objDetailedReport.WriteLog(Status.FAIL, "User Should be able to click: "+text, "User click on: "+text, _Browser);
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}	

		public void clickOnButton(By WEBELEMENT,String text) throws Exception {
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			WebElement elm = _Browser.findElement(WEBELEMENT);
			try {
				if (elm != null) {
					webDriverWait.until(ExpectedConditions.elementToBeClickable(WEBELEMENT));
					Actions a = new Actions(_Browser);
					a.moveToElement(elm);
					a.click().build().perform();					
				} else {					
				}
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
		
		public void clickOnButton(By WEBELEMENT,DetailedReport _objDetailReporting,String text) throws Exception {
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			WebElement elm = _Browser.findElement(WEBELEMENT);
			try {
				if (elm != null) {
					webDriverWait.until(ExpectedConditions.elementToBeClickable(WEBELEMENT));
					Actions a = new Actions(_Browser);
					a.moveToElement(elm);
					a.click().build().perform();
					_objDetailedReport.WriteLog(Status.PASS, "User Should be able to click: "+text, "User click on: "+text, _Browser);
				} else {					
					_objDetailedReport.WriteLog(Status.FAIL, "User Should be able to click: "+text, "User click on: "+text, _Browser);
				}
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception				
				_objDetailedReport.WriteLog(Status.FAIL, "User Should be able to click: "+text, "User click on: "+e, _Browser);
				
			}
		}
		public void clickOnButton(WebElement WEBELEMENT,DetailedReport _objDetailReporting,String text) throws Exception {
			
			try {
				if (WEBELEMENT != null) {					
					Actions a = new Actions(_Browser);
					a.moveToElement(WEBELEMENT);
					a.click().build().perform();
					_objDetailedReport.WriteLog(Status.PASS, "User Should be able to click: "+text, "User click on: "+text, _Browser);
				} else {					
					_objDetailedReport.WriteLog(Status.FAIL, "User Should be able to click: "+text, "User click on: "+text, _Browser);
				}
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception				
				_objDetailedReport.WriteLog(Status.FAIL, "User Should be able to click: "+text, "User click on: "+e, _Browser);
				
			}
		}

		public int getTodaysDay() {
			java.util.Date date = new java.util.Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.DAY_OF_MONTH);
		}
		
		/*public String getMonth(){
			java.util.Date date = new java.util.Date();
			Calendar calendar = Calendar.getInstance();
			return calendar.get(Calendar.MONTH)
		}*/

		public void waitForPageElementToLoad() {
			_Browser.manage().timeouts().pageLoadTimeout(Long.parseLong("25"), TimeUnit.SECONDS);
		}		

		public void selectDropDownValueByLocator(String dataValue, By loBy,String action) throws Exception {

			waitForTheElementToBeLoad(loBy,action);
			WebElement elm = _Browser.findElement(loBy);
			if (elm != null) {
				Select select = new Select(elm);
				select.selectByValue(dataValue);
				waitForPageElementToLoad();
			}
		}

		public void selectDropDownValueByLocator(String dataValue, WebElement elm) {
			
			if (elm != null && dataValue != null) {
				Select select = new Select(elm);
				select.selectByValue(dataValue);
				waitForPageElementToLoad();
			}
		}
		
		public void selectDropDownValueBytext(String text,By elm){
			try {
				WebElement selectElm = _Browser.findElement(elm);
				if (selectElm != null) {
					Select select = new Select(selectElm);
					select.selectByVisibleText(text);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		public void selectDropDownValueBy(String dataValue, By loBy) {
			WebElement elm = _Browser.findElement(loBy);
			if (elm != null) {
				Select select = new Select(elm);
				select.selectByIndex(6);
				waitForPageElementToLoad();
			}		
		}

		public void waitForPageToLoadByCounter(int counter) {
			try {
				Thread.sleep(counter * 100);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		public int getHeaderCountByValue(String headercolumn, List<WebElement> elm) {

			int colIndex = -1;
			int counter = 0;
			for (Iterator<WebElement> iterator = elm.iterator(); iterator.hasNext();) {
				counter++;
				WebElement webElement = iterator.next();
				String getHeaderName = webElement.getText();
				if (getHeaderName.equals(headercolumn)) {
					colIndex = counter;
					break;
				}
			}
			return colIndex;
		}

		public boolean clickCheckToUnchecked(By elm) {
			WebDriverWait webDriverWait = waitforElementToLoadByExplicit();
			webDriverWait.until(ExpectedConditions.elementToBeClickable(elm));
			WebElement elment = _Browser.findElement(elm);
			try {
				if (elment != null) {
					Actions a = new Actions(_Browser);
					a.moveToElement(elment);
					a.click().build().perform();
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}		

		public void selectDateByFromAndTo(By elm, String dataValue, String elm2, By elm1,String action) {
			try {
				waitForTheElementToBeLoad(elm,action);
				int startDateAndEndDate = getTodaysDay();
				clickOnButton(elm);
				waitForPageToLoadByCounter(10);
				String getActualTodayDateXpath = String.format(elm2, startDateAndEndDate);
				By xpathTodayDate = By.xpath(getActualTodayDateXpath);
				WebElement webElementTodayDate = _Browser.findElement(xpathTodayDate);
				if (webElementTodayDate != null) {
					_Browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					//need to Write - 27/06/2018
					clickOnElement(xpathTodayDate);
				}
				waitForPageToLoadByCounter(10);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

		public void enterTextByStepDetails(String dataValue, By by,String option,DetailedReport _obj) {
			try {
				waitForTheElementToBeLoad(by,option);
				switch (option) {
				case "Address":
					enterInputTextvalueByJavaScript(by, dataValue,option,_obj);
					break;
				case "City":
					enterInputTextvalueByJavaScript(by, dataValue,option,_obj);
					break;
				case "Postal Code":
					enterInputTextvalueByJavaScript(by, dataValue, option,_obj);
					break;
				default:
					break;
				}			
				waitForPageElementToLoad();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
				

		public void selectDropDownValuesByEnteringText(String dataValue, By elment, By textBoxElement,
				String strElm, String valueName,DetailedReport _DetailedReport) throws Exception {
			waitForPageElementToLoad();
			if (dataValue != null) {
				waitForTheElementToBeLoad(elment,valueName);
				//clickWithJavaScriptEXecutor(elment, test, valueName);
				if ("Underwriter".equals(valueName)) {
					waitForPageToLoadByCounter(20);				
				}
				clickOnElement(elment);
				waitForTheElementToBeLoad(textBoxElement,valueName);
				switch (valueName) {
				case "Insured Product":
					enterInputTextvalueByJavaScript(textBoxElement, dataValue,"Enter Insured Product",_DetailedReport);
					break;			
				case "Broker":
					enterInputTextvalue(textBoxElement, dataValue, "Enter Broker ",_DetailedReport);
					break;
				case "Underwriter":
					enterInputTextvalueByJavaScript(textBoxElement, dataValue,"Enter Underwriter",_DetailedReport);
					break;
				case "Insured Name":
					enterInputTextvalueByJavaScript(textBoxElement, dataValue,"Enter Insured Name ",_DetailedReport);
					break;
				case "State":
					enterInputTextvalueByJavaScript(textBoxElement, dataValue,"Enter State",_DetailedReport);
					break;
				case "Three Letter":
					enterInputTextvalueByJavaScript(textBoxElement, dataValue, "Enter Three Letter Code",_DetailedReport);
					break;
				case "Broker Contact":
					enterInputTextvalue(textBoxElement, dataValue, "Enter Broker contact",_DetailedReport);
					break;
				default:
					break;
				}	
				if ("Insured Name".equals(valueName)) {
					_Browser.findElement(textBoxElement).sendKeys(Keys.SPACE);
				}
				if ("Broker".equals(valueName)) {
					waitForPageToLoadByCounter(10);
				}
				WebElement selectionElement = getExactXpathPathAfterStringFormatting(strElm, dataValue);							
				clickOnButton(selectionElement,valueName);
			}
		}		

		public String getDayfromDate(String value) {

			String strArray[] = value.split(" ");
			return strArray[0].trim();
		}

		// Clicking on Link by Text
		public void clickOnLinkByText(String value, String stringWebElement) throws Exception {

			String getScenarioTabString = String.format(stringWebElement, value);
			By xpathGetScenarioTab = By.xpath(getScenarioTabString);
			waitForTheElementToBeLoad(xpathGetScenarioTab,stringWebElement);
			clickOnButton(xpathGetScenarioTab, value);
			waitForPageElementToLoad();
		}

		public void waitForJQueryLoad() {
			// Wait for jQuery to load
			WebDriverWait webDriverWait = new WebDriverWait(_Browser, 15);
			javaScriptExecutor = (JavascriptExecutor) _Browser;
			ExpectedCondition<Boolean> jQueryLoad = _Browser -> ((Long) ((JavascriptExecutor) _Browser)
					.executeScript("return jQuery.active") == 0);

			// Get JQuery is Ready
			boolean jqueryReady = (Boolean) javaScriptExecutor.executeScript("return jQuery.active==0");

			// Wait JQuery until it is Ready!
			if (!jqueryReady) {				
				// Wait for jQuery to load
				webDriverWait.until(jQueryLoad);
			} 
		}					
		
}
