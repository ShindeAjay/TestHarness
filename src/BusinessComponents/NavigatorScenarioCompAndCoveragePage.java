package BusinessComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.host.Navigator;

import ObjectRepository.ApplicationCommonOR;
import ObjectRepository.NavigatorAccountSetupOR;
import ObjectRepository.NavigatorComponentAndCoveragePageOR;
import Report.DetailedReport;
import SeleniumHelper.SeleniumHelper;
import TestDataManagement.TestDataManage;

public class NavigatorScenarioCompAndCoveragePage extends SeleniumHelper {

	private String LIMIT_TYPE_STR = "/td[%d]";

	public NavigatorScenarioCompAndCoveragePage(WebDriver Browser, DetailedReport objDetailedReport,
			TestDataManage testDataManage, String BrowserDetails) {
		this._objDetailedReport = objDetailedReport;
		this._Browser = Browser;
		this._testDataManage = testDataManage;
	}

	public void setExposureAndRatingForCGL() {
		try {
			setCompositeRatingForLimtAndExposureOnCGL();
		} catch (Exception e) {
			System.out.println("Not able to set the Valuee");
		}
	}

	/*
	 * NP3 Screen - Component and coverage Screen
	 */
	private void setCompositeRatingForLimtAndExposureOnCGL() {
		try {
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.EXPOSURE_AND_RATING_TAB,
					"Exposure And Rating");
			clickOnButton(NavigatorComponentAndCoveragePageOR.EXPOSURE_AND_RATING_TAB);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.EXPOSURE_RATING_CLASS,
					"Composite Rating Table");
			clickOnElement(NavigatorComponentAndCoveragePageOR.EXPOSURE_RATING_CLASS);
			selectDropDownValueFromTable(NavigatorComponentAndCoveragePageOR.EXPOSURE_RATING_CLASS_CONTAINER,
					ApplicationCommonOR.BROKER_INPUT_TXT,
					NavigatorComponentAndCoveragePageOR.EXPOSURE_RATING_CLASS_LIST, "AM");
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.EXPOSURE_RATE, "Rate");
			enterInputTextvalue(NavigatorComponentAndCoveragePageOR.EXPOSURE_RATE, "56487", "Exposure Rate/Amount",
					_objDetailedReport);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.EXPOSURE_TYPE, "Exposure Type");
			selectDropDownValueBytext("Liquor Liability", NavigatorComponentAndCoveragePageOR.EXPOSURE_TYPE);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.GOTO_EXPOSURE_BTN, "goto button");
		} catch (Exception e) {
			System.out.println("Not able to set the Composite Rating");
		}
	}

	public void setCoverageForEachRatingTabEXC() {
		int counter = -1;
		int secondCounter = -1;
		try {

			List<WebElement> coverageSubTabList = _Browser
					.findElements(NavigatorComponentAndCoveragePageOR.COVERAGE_CHILD_TAB_LIST);
			int getCoverageSubTabSize = coverageSubTabList.size();
			System.out.println(getCoverageSubTabSize);
			for (int i = 1; i <= getCoverageSubTabSize; i++) {
				String getCoverageTabText = _Browser
						.findElement(By.xpath(
								String.format(NavigatorComponentAndCoveragePageOR.COVERAGE_CHILD_GET_TAB_NAME, i)))
						.getText();
				System.out.println(getCoverageTabText);
				if (i == 3) {
					secondCounter = i;
				}
				if (!(i == 4)) {
					setCoverageWithInputtingTabName(getCoverageTabText);
				} else {
					counter = i;
				}
			}
			if (counter == 4) {
				setSetNavOneToOnePremiumOnExcessRating("Excess Rating");
			}
			if (secondCounter == 3) {
				setQuotedPermiumOnPricingDetailSection("Pricing Details / Premium");
				NavigatorScenarioCompAndCoveragePage _Scenario = new NavigatorScenarioCompAndCoveragePage(_Browser,
						_objDetailedReport, _testDataManage, null);
				waitForPageToLoadByCounter(55);
				clickOnButton(NavigatorComponentAndCoveragePageOR.GOTO_EXPOSURE_BTN);
				_Scenario.clickOnComponentCoverageLink(_objDetailedReport);
				waitForPageToLoadByCounter(15);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setCoverageWithInputtingTabName(String coverageTabName) {
		try {
			switch (coverageTabName) {
			case "Limits":
				setLimitOnExcessCoverageSection();
				break;
			case "Primary Rating":
				setPrimaryGLModelLimit(coverageTabName);
				break;
			case "Actual UL Rating":
				setPrimaryunderLyerOnActualULRatingTab(coverageTabName);
				break;
			case "Pricing Details / Premium":
				setQuotedPermiumOnPricingDetailSection(coverageTabName);
				break;
			case "Rating Notes":
				waitForPageToLoadByCounter(50);
				setRatingNoteOnRatingNotestSection(coverageTabName);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setRatingNoteOnRatingNotestSection(String tabName) {
		try {
			clickOnLinkByText(tabName, _objDetailedReport, NavigatorComponentAndCoveragePageOR.COVERAGE_CHID_TAB);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.RATING_NOTE, "Rating Notes");
			enterInputTextvalue(NavigatorComponentAndCoveragePageOR.RATING_NOTE, "Rated", "Rated", _objDetailedReport);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void setQuotedPermiumOnPricingDetailSection(String tabName) {
		try {
			clickOnLinkByText(tabName, _objDetailedReport, NavigatorComponentAndCoveragePageOR.COVERAGE_CHID_TAB);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.QUOTE_PREMIUM_EXCESS_ONLY_TXT,
					"Quoted Permium Excess");
			/*
			 * enterInputTextvalue(NavigatorComponentAndCoveragePageOR.
			 * QUOTE_PREMIUM_EXCESS_ONLY_TXT, "12000", "Quoted Permium Excess",
			 * _objDetailedReport);
			 */
			clickOnButton(NavigatorComponentAndCoveragePageOR.COVERAGE_DIAPLAY_SAVE_BTN, _objDetailedReport,
					"Coverage Display Save ");
			waitForPageToLoadByCounter(50);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.QUOTE_PRICING_DETIAL_RATING_BTN,
					"Validate Rating");
			clickOnButton(NavigatorComponentAndCoveragePageOR.QUOTE_PRICING_DETIAL_RATING_BTN, _objDetailedReport,
					"Validate Rating:");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/****
	 * Setting Up Limit and Coverage on Limit Tab
	 */
	private void setLimitOnExcessCoverageSection() {
		try {
			setLimitOnCoverageTab(_objDetailedReport);
			setUnderLyerLimitWithOption(_objDetailedReport);
			setExcessUnderlyerWithPolicyType("Auto Liability");
			setUnderLyerLimitWithOption(_objDetailedReport);
			setExcessUnderlyerWithPolicyType("General Liability");
			setunderLyerLimit(_testDataManage.getData("UnderLyer Limit"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setunderLyerLimit(String dataValue) {
		try {
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.UNDERLYER_LIMIT, "underlyer Limit");
			enterInputTextvalue(NavigatorComponentAndCoveragePageOR.UNDERLYER_LIMIT, dataValue, "underlyer Limit",
					_objDetailedReport);
		} catch (Exception e) {
			System.out.println("Underlyer Limit TextBox not Found");
		}
	}

	private void setSetNavOneToOnePremiumOnExcessRating(String tabName) {
		try {
			clickOnLinkByText(tabName, _objDetailedReport, NavigatorComponentAndCoveragePageOR.COVERAGE_CHID_TAB);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.EXCESS_RATING_PRICE_FLOOR_AUTO, "Auto ");
			clickOnButton(NavigatorComponentAndCoveragePageOR.EXCESS_RATING_PRICE_FLOOR_AUTO);
			_Browser.findElement(NavigatorComponentAndCoveragePageOR.EXCESS_RATING_PRICE_INPUT_AUTO).clear();
			enterInputTextvalue(NavigatorComponentAndCoveragePageOR.EXCESS_RATING_PRICE_INPUT_AUTO, "5000",
					"Auto Navg1X1P", _objDetailedReport);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.EXCESS_RATING_PRICE_FLOOR_GL, "GL ");
			clickOnButton(NavigatorComponentAndCoveragePageOR.EXCESS_RATING_PRICE_FLOOR_GL);
			_Browser.findElement(NavigatorComponentAndCoveragePageOR.EXCESS_RATING_PRICE_INPUT_GL).clear();
			enterInputTextvalue(NavigatorComponentAndCoveragePageOR.EXCESS_RATING_PRICE_INPUT_GL, "5000",
					"Auto Navg1X1P", _objDetailedReport);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.COVERAGE_DIAPLAY_SAVE_BTN, "Save Button");
			/*
			 * clickOnButton(NavigatorComponentAndCoveragePageOR.
			 * COVERAGE_DIAPLAY_SAVE_BTN, _objDetailedReport,
			 * "Coverage Display Save ");
			 */
			waitForPageToLoadByCounter(15);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.EXCESS_RATING_RATE_BTN, "Validate Rating");
			clickOnButton(NavigatorComponentAndCoveragePageOR.EXCESS_RATING_RATE_BTN, _objDetailedReport,
					"Validate Rating:");
			waitForPageToLoadByCounter(100);
		} catch (Exception e) {
			System.out.println("One To One P is not found");
		}
	}

	private void setPrimaryunderLyerOnActualULRatingTab(String tabName) {
		int counter = 1;
		try {
			clickOnLinkByText(tabName, _objDetailedReport, NavigatorComponentAndCoveragePageOR.COVERAGE_CHID_TAB);
			List<WebElement> PRIMARY_UNDERLYER = _Browser
					.findElements(By.xpath(NavigatorComponentAndCoveragePageOR.PRIMARY_UNDERLYER));
			List<WebElement> PRIMARY_HEADER = _Browser.findElements(NavigatorComponentAndCoveragePageOR.PRIMARY_HEADER);

			for (int counterIndex = 2; counterIndex <= PRIMARY_UNDERLYER.size(); counterIndex++) {
				String primaryUnderlyerTdList = String.format(NavigatorComponentAndCoveragePageOR.PRIMARY_LIMIT_TYPE,
						counterIndex);
				String getText = _Browser.findElement(By.xpath(primaryUnderlyerTdList)).getText();
				if (!"Liquor".equals(getText.trim())) {
					setLimitAmountforPrimaryunderlyers(counterIndex, PRIMARY_HEADER);
					setRetentionTypeForPrimaryUnderlyer(counter, PRIMARY_HEADER);
					setRetentionAmountforPrimaryUnderlyer(counter, PRIMARY_HEADER);
					setActualPremiumForPrimaryUnderlyer(counter, PRIMARY_HEADER);
				}
				counter++;
			}
		} catch (Exception e) {
			System.out.println("Primary Underlyer Not Found");
		}
	}

	private void setActualPremiumForPrimaryUnderlyer(int counter, List<WebElement> primaryHeader) {
		try {
			String getActualPremium = String.format(NavigatorComponentAndCoveragePageOR.PRIMARY_ACTUAL_PREMIUM,
					counter);
			By xpathActualPremium = By.xpath(getActualPremium);
			waitForTheElementToBeLoad(xpathActualPremium, "Retention Amount");
			_Browser.findElement(xpathActualPremium).clear();
			enterInputTextvalue(xpathActualPremium, "85265", "Retention Amount", _objDetailedReport);
			waitForPageToLoadByCounter(5);
		} catch (Exception e) {
			System.out.println("Actual Premium Not Found");
		}
	}

	private void setRetentionAmountforPrimaryUnderlyer(int counter, List<WebElement> primaryHeader) {
		try {
			String getRetentionAmount = String.format(NavigatorComponentAndCoveragePageOR.PRIMARY_RETENTION_AMOUNT,
					counter);
			By xpathRetentionAmount = By.xpath(getRetentionAmount);
			waitForTheElementToBeLoad(xpathRetentionAmount, "Retention Amount");
			_Browser.findElement(xpathRetentionAmount).clear();
			enterInputTextvalue(xpathRetentionAmount, "852654", "Retention Amount", _objDetailedReport);
		} catch (Exception e) {
			System.out.println("Retention Amount Not Found");
		}
	}

	private void setRetentionTypeForPrimaryUnderlyer(int counter, List<WebElement> primaryHeader) {
		try {
			String getRetentionType = String.format(NavigatorComponentAndCoveragePageOR.PRIMARY_RETENTION_TYPE,
					counter);
			By xpathRetentionType = By.xpath(getRetentionType);
			waitForTheElementToBeLoad(xpathRetentionType, "Retention Type");
			WebElement elm = _Browser.findElement(xpathRetentionType);
			selectDropDownValueByLocator("SIR", elm);
		} catch (Exception e) {
			System.out.println("Retention Amount Not Found");
		}
	}

	private void setLimitAmountforPrimaryunderlyers(int counter, List<WebElement> primaryHeader) {
		String finalLimitAmountStr = null;
		try {
			int getPrimaryLimitAmountIndex = getHeaderCountByValue("Limit Amount", primaryHeader);
			String getLimitAmount = String.format(NavigatorComponentAndCoveragePageOR.PRIMARY_UNDERLYER_FINAL_ROW,
					counter);
			String getLimitAmount_td = String.format(NavigatorComponentAndCoveragePageOR.PRIMARY_UNDERLYER_TABLE_COLS,
					getPrimaryLimitAmountIndex);
			finalLimitAmountStr = getLimitAmount + getLimitAmount_td;
			By xpathLimitAmount = By.xpath(finalLimitAmountStr);
			waitForTheElementToBeLoad(xpathLimitAmount, "Limit Amount");
			clickOnButton(xpathLimitAmount);
			waitForPageToLoadByCounter(5);
			String inputLimitAmount = finalLimitAmountStr + "/input";
			By xpathLimitAmountInput = By.xpath(inputLimitAmount);
			waitForTheElementToBeLoad(xpathLimitAmountInput, "Limit Amount");
			_Browser.findElement(xpathLimitAmountInput).clear();
			enterInputTextvalue(xpathLimitAmountInput, "1200000", "Limit Amount", _objDetailedReport);
			waitForPageToLoadByCounter(3);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void setPrimaryGLModelLimit(String tabName) {
		int counter = 1;
		try {
			clickOnLinkByText(tabName, _objDetailedReport, NavigatorComponentAndCoveragePageOR.COVERAGE_CHID_TAB);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.PRIMARY_GL_MODEL_ADD_BTN,
					"Priamry GL Addition Btn");
			clickOnButton(NavigatorComponentAndCoveragePageOR.PRIMARY_GL_MODEL_ADD_BTN);
			List<WebElement> PRIMARY_MODEL_LIST = _Browser
					.findElements(NavigatorComponentAndCoveragePageOR.PRIMARY_GL_TR);
			int getPrimaryGLModelcount = PRIMARY_MODEL_LIST.size();
			for (int i = 2; i <= getPrimaryGLModelcount; i++) {
				counter = counter + i;
				setPrimaryGLModelClassCode(counter);
				setPrimaryGLModelState(counter);
				setPrimaryGLModelLocationType(counter);
				setPrimaryGLModelPremiumBasis(counter);
				setPrimaryGLModelAmount(counter);
				setOpsCostLoss(counter);
				waitForPageToLoadByCounter(5);

			}
			setAutoModelOnPrimaryLimit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setAutoModelOnPrimaryLimit() {
		int counter = 1;
		try {
			List<WebElement> AUTO_MODEL_ROW = _Browser
					.findElements(By.xpath(NavigatorComponentAndCoveragePageOR.AUTO_MODEL_BODY_ROW));
			List<WebElement> elmAutoModel = _Browser
					.findElements(NavigatorComponentAndCoveragePageOR.AUTO_MODEL_HEADERLIST);
			for (int counterStart = 2; counterStart < AUTO_MODEL_ROW.size(); counterStart++) {
				setInputForPPTVehicletype(counterStart, elmAutoModel, counter);
				setUseInputForPPTVechileType(counterStart, elmAutoModel, counter);
				setTerritoryInputForPPTVehicleType(counterStart, elmAutoModel, counter);
				setRadiusInputForPPTVehicleType(counterStart, elmAutoModel, counter);
				counter++;
			}
			counter = 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void setRadiusInputForPPTVehicleType(int counter, List<WebElement> elmAutoModel, int fieldcounter) {
		String finalRadius = null;
		try {
			int getUseIndex = getHeaderCountByValue("Radius", elmAutoModel);
			String getPPTVehicleRow = String.format(NavigatorComponentAndCoveragePageOR.AUTO_MODEL_BODY_PARENT,
					counter);
			String getActualRadius = String.format(NavigatorComponentAndCoveragePageOR.AUTO_MODEL_BODY__COLS,
					getUseIndex);
			finalRadius = getPPTVehicleRow + getActualRadius;
			By xpathToClickNoOfUnitCol = By.xpath(finalRadius);
			String getAttr = _Browser.findElement(xpathToClickNoOfUnitCol).getAttribute("class");
			if (!getAttr.contains("not")) {
				String strRadius = String.format(NavigatorComponentAndCoveragePageOR.AUTO_RADIUS, fieldcounter);
				By xpathRadius = By.xpath(strRadius);
				WebElement elm = _Browser.findElement(xpathRadius);
				selectDropDownValueByLocator("Local", elm);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void setTerritoryInputForPPTVehicleType(int counter, List<WebElement> elmAutoModel, int fieldCounter) {

		try {
			String getTerritoryInput = String.format(NavigatorComponentAndCoveragePageOR.TERRITORY, fieldCounter);
			By xpathTerritoryElm = By.xpath(getTerritoryInput);
			waitForTheElementToBeLoad(xpathTerritoryElm, "Territory");
			WebElement elmTerritory = _Browser.findElement(xpathTerritoryElm);
			selectDropDownValueByLocator("Rural", elmTerritory);

		} catch (Exception e) {
			System.out.println("Territory Not found");
		}
	}

	private void setUseInputForPPTVechileType(int counter, List<WebElement> elmAutoModel, int fieldCounter) {
		String finalAutoModelUse = null;
		try {
			int getUseIndex = getHeaderCountByValue("Use", elmAutoModel);
			String getPPTVehicleRow = String.format(NavigatorComponentAndCoveragePageOR.AUTO_MODEL_BODY_PARENT,
					counter);
			String getActualNoOfUnits = String.format(NavigatorComponentAndCoveragePageOR.AUTO_MODEL_BODY__COLS,
					getUseIndex);
			finalAutoModelUse = getPPTVehicleRow + getActualNoOfUnits;
			By xpathToClickNoOfUnitCol = By.xpath(finalAutoModelUse);
			String getAttr = _Browser.findElement(xpathToClickNoOfUnitCol).getAttribute("class");
			if (!getAttr.contains("not")) {
				String strServiceType = String.format(NavigatorComponentAndCoveragePageOR.AUTO_MODEL_USE, fieldCounter);
				By xpathServiceType = By.xpath(strServiceType);
				WebElement elm = _Browser.findElement(xpathServiceType);
				selectDropDownValueByLocator("Service", elm);
			}
		} catch (Exception e) {
			System.out.println("Not Able to find Use Row");
		}
	}

	private void setInputForPPTVehicletype(int counter, List<WebElement> elmAutoModel, int fieldCounter) {
		String finalAutoModelNoOfunit = null;
		try {
			int getNoOfUnitsIndex = getHeaderCountByValue("# of Units", elmAutoModel);
			String getPPTVehicleRow = String.format(NavigatorComponentAndCoveragePageOR.AUTO_MODEL_BODY_PARENT,
					counter);
			String getActualNoOfUnits = String.format(NavigatorComponentAndCoveragePageOR.AUTO_MODEL_BODY__COLS,
					getNoOfUnitsIndex);
			finalAutoModelNoOfunit = getPPTVehicleRow + getActualNoOfUnits;
			By xpathToClickNoOfUnitCol = By.xpath(finalAutoModelNoOfunit);
			waitForTheElementToBeLoad(xpathToClickNoOfUnitCol, "No Of units");
			clickOnButton(xpathToClickNoOfUnitCol);
			finalAutoModelNoOfunit = String.format(NavigatorComponentAndCoveragePageOR.NO_OF_UNITS, fieldCounter);
			By xpathInputNoOfUnits = By.xpath(finalAutoModelNoOfunit);
			waitForTheElementToBeLoad(xpathInputNoOfUnits, "Input");
			enterInputTextvalue(xpathInputNoOfUnits, "2", "No of Units", _objDetailedReport);

		} catch (Exception e) {
			System.out.println("Not Able to find PPT vechile type Row");
		}
	}

	private void setPrimaryGLModelAmount(int headerIndex) {
		try {
			String AMOUNT = String.format(NavigatorComponentAndCoveragePageOR.AMOUNT, headerIndex);
			By xpathAmount = By.xpath(AMOUNT);
			waitForTheElementToBeLoad(xpathAmount, "Amount");
			_Browser.findElement(xpathAmount).clear();
			enterInputTextvalue(xpathAmount, _testDataManage.getData("OverAll Gross Revenue"), "Gross Amount",
					_objDetailedReport);

		} catch (Exception e) {
			System.out.println("Amount Not found");
		}
	}

	private void setOpsCostLoss(int headerIndex) {
		try {
			String OPS_LOSS_COST = String.format(NavigatorComponentAndCoveragePageOR.OPS_LOSS_COST, headerIndex);
			By xpathAmount = By.xpath(OPS_LOSS_COST);
			waitForTheElementToBeLoad(xpathAmount, "Amount");
			_Browser.findElement(xpathAmount).clear();
			enterInputTextvalue(xpathAmount, "0.35", "Ops Loss Cost", _objDetailedReport);

		} catch (Exception e) {
			System.out.println("Amount Not found");
		}
	}

	private void setPrimaryGLModelPremiumBasis(int headerIndex) {
		try {
			String PREMIUM_BASIS = String.format(NavigatorComponentAndCoveragePageOR.PREMIUM_BASIS, headerIndex);
			By xpathPremiumBasis = By.xpath(PREMIUM_BASIS);
			waitForTheElementToBeLoad(xpathPremiumBasis, "Premium Basis");
			selectDropDownValueBytext("Revenue", xpathPremiumBasis);

		} catch (Exception e) {
			System.out.println("Premium Basis Not found");
		}
	}

	private void setPrimaryGLModelLocationType(int headerIndex) {
		try {
			String CLASS_LOCATION_TYPE = String.format(NavigatorComponentAndCoveragePageOR.LOCATION_TYPE, headerIndex);
			By xpathLocationType = By.xpath(CLASS_LOCATION_TYPE);
			waitForTheElementToBeLoad(xpathLocationType, "Location Type");
			selectDropDownValueBytext("Rural", xpathLocationType);

		} catch (Exception e) {
			System.out.println("Location type Not Found");
		}

	}

	private void setPrimaryGLModelClassCode(int headerIndex) throws Exception {
		try {
			String CLASS_CODE_CONTAINER = String.format(NavigatorComponentAndCoveragePageOR.CLASS_CODE_CONTANIER,
					headerIndex);
			String CLASS_CODE_LIST = String.format(NavigatorComponentAndCoveragePageOR.CLASS_CODE_LIST, headerIndex);
			By xpathClass_Code = By.xpath(CLASS_CODE_CONTAINER);
			By xpathClass_Code_List = By.xpath(CLASS_CODE_LIST);
			waitForTheElementToBeLoad(xpathClass_Code, "Class code");
			selectDropDownValueFromTable(xpathClass_Code, ApplicationCommonOR.BROKER_INPUT_TXT, xpathClass_Code_List,
					"Class Code");
		} catch (Exception e) {
			System.out.println("Class Code is not Found");
		}

	}

	private void setPrimaryGLModelState(int headerIndex) throws Exception {
		try {
			String STATE = String.format(NavigatorComponentAndCoveragePageOR.STATE_LST, headerIndex);
			By xpathState = By.xpath(STATE);
			waitForTheElementToBeLoad(xpathState, "State");
			selectDropDownValueBytext("California", xpathState);
		} catch (Exception e) {
			System.out.println("State Not found");
		}
	}

	private void setUnderLyerLimitWithOption(DetailedReport test) {
		try {
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.UNDERLYER_ADDITION_BTN, "Underlyer Addition");
			clickOnButton(NavigatorComponentAndCoveragePageOR.UNDERLYER_ADDITION_BTN, test, "Underlyer Addition");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcessUnderlyerWithPolicyType(String policyType) {
		try {
			By elm = null;
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.POLICY_TYPE_CONTAINER, "Policy Type Field");
			selectDropDownValuesByEnteringText(policyType, NavigatorComponentAndCoveragePageOR.POLICY_TYPE_CONTAINER,
					ApplicationCommonOR.BROKER_INPUT_TXT, NavigatorComponentAndCoveragePageOR.POLICY_TYPE_LIST,
					"Policy Type", _objDetailedReport);
			enterInputTextvalue(NavigatorComponentAndCoveragePageOR.CARRIER, "AON", "Carrier", _objDetailedReport);
			enterInputTextvalue(NavigatorComponentAndCoveragePageOR.POLICY_REF, "CHF67888", "Policy Reference",
					_objDetailedReport);
			if ("Auto Liability".equals(policyType)) {
				enterInputTextvalue(NavigatorComponentAndCoveragePageOR.LIMIT_COMBINED_SINGLE_LIMIT, "1000000",
						"Limit Combined single Limit", _objDetailedReport);
			} else if ("General Liability".equals(policyType)) {
				enterInputTextvalue(NavigatorComponentAndCoveragePageOR.LIMIt_EACH_OCC, "1000000",
						"Limit Each Occurence", _objDetailedReport);
				enterInputTextvalue(NavigatorComponentAndCoveragePageOR.LIMIT_PERSONAL, "1000000", "Limit Personal",
						_objDetailedReport);
				enterInputTextvalue(NavigatorComponentAndCoveragePageOR.LIMIT_GENERAL_AGG, "1000000",
						"Limit Gereral Aggregation", _objDetailedReport);
				enterInputTextvalue(NavigatorComponentAndCoveragePageOR.LIMIT_PRODUCTS, "1000000", "Limit Product",
						_objDetailedReport);
			}
			int gettodayDate = getTodaysDay();
			selectDateByFromAndTo(NavigatorComponentAndCoveragePageOR.EFFECTIVE_DATE, String.valueOf(gettodayDate),
					NavigatorComponentAndCoveragePageOR.EFFECTIVE_DATE_LIST, elm, "Effective Date");
			waitForPageToLoadByCounter(5);
			selectDateByFromAndTo(NavigatorComponentAndCoveragePageOR.EXPIRATION_DATE, String.valueOf(gettodayDate + 1),
					NavigatorComponentAndCoveragePageOR.EFFECTIVE_DATE_LIST, elm, "Expiration Date");
			waitForPageToLoadByCounter(15);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.EXCESS_UNDERLYER_SAVE_BTN,
					"Excerss Underlyer Save button");
			clickWithJavaScriptEXecutor(NavigatorComponentAndCoveragePageOR.EXCESS_UNDERLYER_SAVE_BTN,
					_objDetailedReport, "Excess Underlyer Save");
			waitForPageToLoadByCounter(15);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setLimitOnCoverageTab(DetailedReport test) {
		int counter = 1;
		try {
			List<WebElement> LIMIT_COVERAGE_HEADER = _Browser
					.findElements(NavigatorComponentAndCoveragePageOR.LIMIT_COVERAGE_TYPE);
			int getTypeindex = getHeaderCountByValue("Type", LIMIT_COVERAGE_HEADER);
			int getDescription = getHeaderCountByValue("Description", LIMIT_COVERAGE_HEADER);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.LIMIT_COVERAGE_TABLE_ROW_COUNT,
					"Limit coverage Table");
			List<WebElement> LIMIT_COVERGAE_TABLE_SIZE = _Browser
					.findElements(NavigatorComponentAndCoveragePageOR.LIMIT_COVERAGE_TABLE_ROW_COUNT);
			System.out.println(LIMIT_COVERGAE_TABLE_SIZE.size());
			for (int i = 2; i <= LIMIT_COVERGAE_TABLE_SIZE.size(); i++) {
				String strLimitType = String.format(NavigatorComponentAndCoveragePageOR.LIMIT_COVERAGE_GET_TYPE, i);
				String getActualStr = strLimitType + String.format(LIMIT_TYPE_STR, getTypeindex);
				By xpathCovergaeType = By.xpath(getActualStr);
				waitForTheElementToBeLoad(xpathCovergaeType, "Coverage Type");
				String getTypeStringFromTable = _Browser.findElement(xpathCovergaeType).getText();
				System.out.println("Get Coverage Type " + getTypeStringFromTable);
				enterAmountAsPerCoverageType(getTypeStringFromTable, i, test, counter);
				String getDescriptionTableRow = strLimitType + String.format(LIMIT_TYPE_STR, getDescription);
				By xpathDescriptionRow = By.xpath(getDescriptionTableRow);
				waitForTheElementToBeLoad(xpathDescriptionRow, "Coverage Description");
				selectDescriptionFromCoverageDropDown(xpathDescriptionRow, _objDetailedReport);
				waitForPageToLoadByCounter(5);
				counter = counter + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void selectDescriptionFromCoverageDropDown(By byDescriptionElm, DetailedReport test) {
		try {
			waitForTheElementToBeLoad(byDescriptionElm, "Coverage Description");
			clickOnElement(byDescriptionElm, "Description Select DropDown Box");
			waitForPageToLoadByCounter(5);
			selectDropDownValueByLocator("16", NavigatorComponentAndCoveragePageOR.DESCRIPTION_SELECT_ID, "Select");
			waitForPageToLoadByCounter(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void enterAmountAsPerCoverageType(String coverageType, int counter, DetailedReport test, int fieldCounter) {

		try {
			String getTableRowToEnter = String.format(NavigatorComponentAndCoveragePageOR.LIMIT_COVERAGE_TR, counter);
			String getActualTableTypeRowByPuttingName = getTableRowToEnter
					+ String.format(NavigatorComponentAndCoveragePageOR.LIMIT_AMOUNT_ROW, coverageType);
			By xpathCoverageAmountElm = By.xpath(getActualTableTypeRowByPuttingName);
			waitForTheElementToBeLoad(xpathCoverageAmountElm, "Limit Coverage Amount");
			clickOnElement(xpathCoverageAmountElm, "Coverage Amount TextBox");
			waitForPageToLoadByCounter(5);
			String getXpathCoverageAmountInput = String.format(NavigatorComponentAndCoveragePageOR.UNDERLYER_AMOUNT,
					fieldCounter);
			By xpathCoverageAmountInput = By.xpath(getXpathCoverageAmountInput);
			enterInputTextvalue(xpathCoverageAmountInput, _testDataManage.getData(coverageType),
					"Coverage" + coverageType + "Amount", test);
			waitForPageToLoadByCounter(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectRetroActiveTermRatingFactor(DetailedReport test) throws Exception {
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.RETRO_TERM_RATING, "Retro term");
		selectDropDownValuesByEnteringText("Policy Effective", NavigatorComponentAndCoveragePageOR.RETRO_TERM_RATING,
				NavigatorComponentAndCoveragePageOR.INSURED_PRODUCT_TXTBOX,
				NavigatorComponentAndCoveragePageOR.POLICY_EFFECTIVE_STRING, "Retroactive Term", test);
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.COVERAGE_DIAPLAY_SAVE_BTN,
				"Coverage Display Save Buton");
		clickOnButton(NavigatorComponentAndCoveragePageOR.COVERAGE_DIAPLAY_SAVE_BTN, test, "Save");
		waitForPageToLoadByCounter(5);
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.EXPOSURE_TAB, "Exposure Button");
		clickOnButton(NavigatorComponentAndCoveragePageOR.EXPOSURE_TAB, test, "Exposures");
		waitForPageToLoadByCounter(5);
	}

	public void setAlltheFieldsOnExposureTab(DetailedReport test) throws Exception {

		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.POLICY_AGGREGATE_LIMIT, "");
		enterInputTextvalueByJavaScript(NavigatorComponentAndCoveragePageOR.POLICY_AGGREGATE_LIMIT, "1000000",
				"Policy Aggregate Limit: ", test);
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.EXPOSURE_BASIC_REVENUE, "");
		enterInputTextvalueByJavaScript(NavigatorComponentAndCoveragePageOR.EXPOSURE_BASIC_REVENUE, "4000000",
				"Exposure Basic Revenue: ", test);
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.CONTRACTOR_ADDITION_BTN, "");
		clickOnElement(NavigatorComponentAndCoveragePageOR.CONTRACTOR_ADDITION_BTN, "Contractor Addition");
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.SERVICETYPE_SELECT_OPTION, "");
		selectDropDownValueBy("", NavigatorComponentAndCoveragePageOR.SERVICETYPE_SELECT_OPTION);
		enterInputTextvalueByJavaScript(NavigatorComponentAndCoveragePageOR.SUBCONTRACTOR_TEXTFIELD, "15",
				"Sub Contractor %: ", test);
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.GROSS_REVENUE_TXTFIELD, "");
		enterInputTextvalueByJavaScript(NavigatorComponentAndCoveragePageOR.GROSS_REVENUE_TXTFIELD, "500000",
				"Gross Revenue", test);
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.COVERAGE_DIAPLAY_SAVE_BTN,
				"Coverage Display button");
		clickOnButton(NavigatorComponentAndCoveragePageOR.COVERAGE_DIAPLAY_SAVE_BTN, test, "Coverage Display Save ");
		waitForPageToLoadByCounter(50);
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.VALIDATE_RATING_BTN, "Validate Rating");
		clickOnButton(NavigatorComponentAndCoveragePageOR.VALIDATE_RATING_BTN, test, "Validate Rating:");
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.GOTO_EXPOSURE_BTN, "Goto Exposure Button");
		waitforElementToLoadByFluentWait(NavigatorComponentAndCoveragePageOR.GOTO_EXPOSURE_BTN);
		waitForPageToLoadByCounter(90);
		clickOnButton(NavigatorComponentAndCoveragePageOR.GOTO_EXPOSURE_BTN, test, "Goto Exposure :");
		clickOnComponentCoverageLink(test);
		waitForPageToLoadByCounter(6);
	}

	/*
	 * Calculation Rating on Rating Premium tab -> Scenario Section
	 */
	public void setRatingOnRatingOverviewTab(DetailedReport test) throws Exception {
		clickOnLinkByText("Rating Overview", test, NavigatorComponentAndCoveragePageOR.SCENARIO_TAB);
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.CALCULATE_RATING, "Calculate Rating Button");
		clickOnButton(NavigatorComponentAndCoveragePageOR.CALCULATE_RATING, test, "Calculate Rating");
		waitForPageElementToLoad();

	}

	/*
	 * Setting up the form in Forms and Endorsement Section -> Scenarios &
	 * Option Section
	 */

	private void setAutoOnFormsAndEndorsment(DetailedReport test) {
		try {
			clickOnLinkByText("Forms & Endorsements", test, NavigatorComponentAndCoveragePageOR.SCENARIO_TAB);
			waitforElementToLoadByFluentWait(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN, "Auto button");
			clickOnButton(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN, test, "Auto:");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void setFormsAndEndorsementOnScenarioSectionforEXC(DetailedReport test, String action) {

		try {
			waitForPageToLoadByCounter(15);

			switch (action) {
			case "Quote":
				setAutoOnFormsAndEndorsment(test);
				waitForTheElementToBeLoad(ApplicationCommonOR.VALIDATE_PACKAGE, "Validate Package");
				clickOnButton(ApplicationCommonOR.VALIDATE_PACKAGE, _objDetailedReport, "Validate Package");
				break;
			case "Bind":				
				setSubjectivityRecieved("Scenarios & Options");
				waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.ACKNOWLEDGE_CHECKBOX_ERROR_TAB,
						"Acknowleded CheckBox");
				moveTotheCheckboxAndClick(NavigatorComponentAndCoveragePageOR.ACKNOWLEDGE_CHECKBOX_ERROR_TAB,
						"Acknowleded CheckBox");
				waitForPageElementToLoad();
				break;
			case "Policy":
				setAutoOnFormsAndEndorsment(test);
				waitForTheElementToBeLoad(ApplicationCommonOR.VALIDATE_PACKAGE, "Validate Package");
				clickOnButton(ApplicationCommonOR.VALIDATE_PACKAGE, _objDetailedReport, "Validate Package");
				waitForPageElementToLoad();
			default:
				break;
			}
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.GENERATE_DOCS, "Generate Docs");
			clickOnButton(NavigatorComponentAndCoveragePageOR.GENERATE_DOCS);
			waitForPageElementToLoad();

		} catch (Exception e) {
			System.out.println("forms And Endorsement not Found");
		}
	}

	public void setSubjectivityForEXC(DetailedReport test, String action) {
		try {
			clickOnLinkByText("Subjectivities", test, NavigatorComponentAndCoveragePageOR.SCENARIO_TAB);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.SUBJECTIVITY_CHECKBOX,
					"Subjectivity CheckBox");
			moveTotheCheckboxAndClick(NavigatorComponentAndCoveragePageOR.SUBJECTIVITY_CHECKBOX, "Subjectivity");
			waitForPageElementToLoad();
			waitForTheElementToBeLoad(ApplicationCommonOR.VALIDATE_PACKAGE, "Validate Package");
			clickOnButton(ApplicationCommonOR.VALIDATE_PACKAGE, test, "Validate Package: ");
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.GENERATE_DOCS, "Generate Docs");
			clickOnButton(NavigatorComponentAndCoveragePageOR.GENERATE_DOCS);
			waitForPageElementToLoad();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void setFormsAndEndoresmentsOnScenarioPage(DetailedReport test, String action) throws Exception {
		PackageAdministrationPage packagePage = new PackageAdministrationPage(_Browser, _objDetailedReport,
				_testDataManage, null);
		waitForPageElementToLoad();
		switch (action) {
		case "Quote":
			setRatingOnRatingOverviewTab(test);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.SCENARIO_TABS, "Scenarios Tab");
			clickOnLinkByText("Forms & Endorsements", test, NavigatorComponentAndCoveragePageOR.SCENARIO_TAB);
			waitforElementToLoadByFluentWait(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN, "Auto button");
			clickOnButton(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN, test, "Auto: ");
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX,
					"Selected forms TextBox");
			enterInputTextvalueByJavaScript(NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX,
					"NAV-ML-TERR", "Form 1 :", test);
			_Browser.findElement(NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX).sendKeys(Keys.SPACE);
			List<WebElement> elm = _Browser.findElements(NavigatorComponentAndCoveragePageOR.ATTACH_HEADER);
			checkCheckBoxFormsThroughTextBox(elm, test, " Attach");
			_Browser.findElement(NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX).clear();
			enterInputTextvalueByJavaScript(NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX,
					"NAV-ML-002", "Form 2 :", test);
			_Browser.findElement(NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX).sendKeys(Keys.SPACE);
			checkCheckBoxFormsThroughTextBox(elm, test, " Attach");
			clickOnButton(ApplicationCommonOR.VALIDATE_PACKAGE, test, "Validate Package");
			break;
		case "Bind":
			setSubjectivityRecieved(action);
			break;
		case "Policy":
			waitForPageElementToLoad();
			clickOnLinkByText("Scenarios & Options", test, NavigatorComponentAndCoveragePageOR.SCENARIO_TAB);
			packagePage.clickOnScenario(test);
			clickOnLinkByText("Forms & Endorsements", test, NavigatorComponentAndCoveragePageOR.SCENARIO_TAB);
			waitforElementToLoadByFluentWait(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN,
					"Auto forms Endorsement");
			clickOnButton(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN, test, "Auto: ");
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX,
					"Selected forms TextBox");
			enterInputTextvalueByJavaScript(NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX,
					"Forms and Endorsements", "Form 1 :", test);
			_Browser.findElement(NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX).sendKeys(Keys.SPACE);
			_Browser.findElement(NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX)
					.sendKeys(Keys.BACK_SPACE);
			waitForPageToLoadByCounter(9);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.VIEW_FORMS_ENDORS_LINK,
					"view Form Endors Link");
			clickOnButton(NavigatorComponentAndCoveragePageOR.VIEW_FORMS_ENDORS_LINK, test, "View: ");
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.DOCUMENT_VIEWER_CLOSE_BTN, "Document Viewer");
			clickOnButton(NavigatorComponentAndCoveragePageOR.DOCUMENT_VIEWER_CLOSE_BTN, test,
					"Document Viewer Close: ");
			waitForTheElementToBeLoad(ApplicationCommonOR.VALIDATE_PACKAGE, "Validate Package");
			clickOnButton(ApplicationCommonOR.VALIDATE_PACKAGE, test, "Validate Package: ");
			break;
		case "External Endorsed":
			waitForPageElementToLoad();
			clickOnLinkByText("Scenarios & Options", test, NavigatorComponentAndCoveragePageOR.SCENARIO_TAB);
			packagePage.clickOnScenario(test);
			clickOnLinkByText("Forms & Endorsements", test, NavigatorComponentAndCoveragePageOR.SCENARIO_TAB);
			waitforElementToLoadByFluentWait(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN, "Auto");
			clickOnButton(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN, test, "Auto: ");
			enterformsinSearchBox("Available Forms: ", test,
					NavigatorComponentAndCoveragePageOR.AVAILABLE_FORMS_NAME_TXTBOX);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.ATTACH_CHECKBOX_AVAILABLE, "Attach Checkbox");
			clickOnElement(NavigatorComponentAndCoveragePageOR.ATTACH_CHECKBOX_AVAILABLE);
			waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.ADD_FORMS, "Add forms");
			clickOnButton(NavigatorComponentAndCoveragePageOR.ADD_FORMS, test, "Add Forms");
			enterformsinSearchBox("Selected Forms: ", test,
					NavigatorComponentAndCoveragePageOR.SELECTED_FORMS_NAME_TXTBOX);
			List<WebElement> fromeAndEndorsedSelectedformHeaderList = _Browser
					.findElements(NavigatorComponentAndCoveragePageOR.ATTACH_HEADER);
			checkCheckBoxFormsThroughTextBox(fromeAndEndorsedSelectedformHeaderList, test, "Edit");
			waitForTheElementToBeLoad(ApplicationCommonOR.VALIDATE_PACKAGE, "Validate Package");
			clickOnButton(ApplicationCommonOR.VALIDATE_PACKAGE, test, "Validate Package: ");
			break;
		default:
			break;
		}
		waitForPageElementToLoad();
		waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.GENERATE_DOCS, "Generate Docs");
		clickOnButton(NavigatorComponentAndCoveragePageOR.GENERATE_DOCS);
		waitForPageElementToLoad();
	}

	private void setSubjectivityRecieved(String action) throws Exception {
		PackageAdministrationPage packagePage = new PackageAdministrationPage(_Browser, _objDetailedReport,
				_testDataManage, null);
		SubjectivityPage _page = new SubjectivityPage(_Browser, _objDetailedReport, _testDataManage, null);
		waitForPageElementToLoad();
		clickOnLinkByText(action, _objDetailedReport, NavigatorComponentAndCoveragePageOR.SCENARIO_TAB);		
		packagePage.clickOnScenario(_objDetailedReport);
		clickOnLinkByText("Subjectivities", _objDetailedReport, NavigatorComponentAndCoveragePageOR.SCENARIO_TAB);
		_page.selectCheckBoxToRecievedSubjectives(_objDetailedReport);
		waitForTheElementToBeLoad(ApplicationCommonOR.VALIDATE_PACKAGE, "Validate Package");
		clickOnButton(ApplicationCommonOR.VALIDATE_PACKAGE, _objDetailedReport, "Validate Package");
	}

	public void enterformsinSearchBox(String str, DetailedReport test, By elm) throws Exception {
		waitForTheElementToBeLoad(elm, str);
		enterInputTextvalueByJavaScript(elm, "NENV 8001", str, test);
		_Browser.findElement(elm).sendKeys(Keys.SPACE);
		_Browser.findElement(elm).sendKeys(Keys.BACK_SPACE);
	}

	public void addingFormsFromAvailableForms() {

	}

	public void checkCheckBoxFormsThroughTextBox(List<WebElement> elm, DetailedReport test, String optionheader)
			throws Exception {
		String getFinalFormElementString = null;
		int getAttachIndexPosition = getHeaderCountByValue(optionheader, elm);
		if (!"Edit".equalsIgnoreCase(optionheader)) {
			getFinalFormElementString = String.format(NavigatorComponentAndCoveragePageOR.ATTACH_CHECKBOX,
					getAttachIndexPosition);
		} else {
			getFinalFormElementString = String.format(NavigatorComponentAndCoveragePageOR.ATTACH_CHECKBOX,
					getAttachIndexPosition);
			getFinalFormElementString = getFinalFormElementString.replace("/input", "".trim());
		}
		By xpathFinalElement = By.xpath(getFinalFormElementString);
		WebElement elment = _Browser.findElement(xpathFinalElement);
		if (elment != null) {
			clickOnButton(xpathFinalElement, test, "Attached: ");
			if (!"Edit".equalsIgnoreCase(optionheader)) {
				waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.AUTO_FORMS_ENDORS_BTN,
						"Auto Forms Button");
			} else {
				waitForTheElementToBeLoad(NavigatorComponentAndCoveragePageOR.ADD_FILLINS_FORM_OK_BTN,
						"Add Fillins Form Button");
				clickOnButton(NavigatorComponentAndCoveragePageOR.ADD_FILLINS_FORM_OK_BTN, test,
						"Add FilIns form Button");
			}
		}
	}

	public void clickOnComponentCoverageLink(DetailedReport test) throws Exception {

		WebElement webElmActualComponentLink = getExactXpathPathAfterStringFormatting(
				NavigatorComponentAndCoveragePageOR.GOTO_PAGELIST_STRING, "Component");
		if (webElmActualComponentLink != null) {
			clickOnButton(webElmActualComponentLink, test, "Component coverage");
		}
	}

	/******
	 * Author : Date : LOB - NP3
	 */

	private void setPollutionLegalLiabilityForNP3() {
		try {
			List<WebElement> HEADER_POLLUTION_LIABILITY = _Browser
					.findElements(ApplicationCommonOR.POLLUTION_LEGAL_LIABILITY);
			int getHeaderDetailIndex = getHeaderCountByValue("Details", HEADER_POLLUTION_LIABILITY);
			List<WebElement> TR_POLLUTION_LIABILITY = _Browser
					.findElements(ApplicationCommonOR.POLLUTION_LEGAL_LIABILITY_TR);
			for (int eachCounter = 2; eachCounter <= TR_POLLUTION_LIABILITY.size(); eachCounter++) {
				String eachRowCountForPLL = String.format(ApplicationCommonOR.POLL_LEGAL_LIABILITY_EACH_ROW,
						eachCounter);
				String tableEditRowforPPL = String.format(ApplicationCommonOR.POLL_LEGAL_LIAB_EACH_TBL_DATA,
						getHeaderDetailIndex);
				eachRowCountForPLL = eachRowCountForPLL + tableEditRowforPPL;
				By xpathEditSectionForPPL = By.xpath(eachRowCountForPLL);
				waitForTheElementToBeLoad(xpathEditSectionForPPL, "PPL Edit Section");
				clickOnElement(xpathEditSectionForPPL);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
