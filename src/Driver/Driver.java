package Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import Report.TestCaseFailException;
import TestDataManagement.TestDataManage;

public class Driver {
	public static String strConfigPath;
	public static String strSilo = "NA";
	public static String strTestType = "NA";
	TestDataManage testDataManage = new TestDataManage();

	public Driver() {
		String strRootPath = System.getProperty("user.dir").substring(0,
				System.getProperty("user.dir").lastIndexOf("\\"));
		String strConfigFolderPath = strConfigPath;
		System.out.println(strConfigFolderPath);
		System.setProperty("ConfigPath", strConfigFolderPath);
		String strparentURL = strRootPath + "\\Applications\\";
		System.setProperty("RootPath", strRootPath);
		Properties property = new Properties();
		try {
			property.load(new FileInputStream("config.ini"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.setProperty("ApplicationURL", property.getProperty("ApplicationName"));
		System.setProperty("ResultPath", property.getProperty("ResultPath"));
		System.setProperty("ProjectName", property.getProperty("ProjectName"));
		System.setProperty("LogDefectOnFailure", property.getProperty("LogDefectOnFailure"));
		if (strSilo.equalsIgnoreCase("NA")) {
			System.setProperty("Region", property.getProperty("Region"));
		} else {
			System.setProperty("Region", strSilo);
		}
		System.setProperty("TestType", strTestType);
		System.setProperty("ApplicationURL", strparentURL + System.getProperty("ApplicationURL") + "\\");
		System.out.println(System.getProperty("ApplicationURL") + "\\" + "Run Manager.xls");
		System.setProperty("MasterFilePath", System.getProperty("ApplicationURL") + "\\" + "Run Manager.xls");

		// System.setProperty("ResultsEmail", property.getProperty("ResultsEmail"));
		// System.setProperty("ResultsEmailTo", property.getProperty("ResultsEmailTo"));
		// System.setProperty("ResultsEmailCC", property.getProperty("ResultsEmailCC"));

		String strPath = System.getProperty("ResultPath");
		if (strPath.equalsIgnoreCase("Default")) {
			System.setProperty("ResultPath", strRootPath + "\\" + "TestResults\\");
			File f = new File(
					System.getProperty("ResultPath").substring(0, System.getProperty("ResultPath").length() - 1));
			if (f.exists() && f.isDirectory()) {
				System.out.println("INFO: Results Folder Found");
			} else {
				f.mkdir();
				System.out.println("INFO: Results Folder Not Found. so Created one as : " + f.getAbsolutePath());
			}
		} else {

			System.setProperty("ResultPath", strRootPath + "\\" + "TestResults\\");
			File f = new File(
					System.getProperty("ResultPath").substring(0, System.getProperty("ResultPath").length() - 1));
			if (f.exists() && f.isDirectory()) {
				System.out.println("INFO: Results Folder Found");
			} else {
				f.mkdir();
				System.out.println("INFO: Results Folder Not Found. so Created one as : " + f.getAbsolutePath());
			}

		}
		System.out.println(System.getProperty("ApplicationURL") + "\\" + "Run Manager.xls");

		testDataManage.initialize(null, "Main", System.getProperty("MasterFilePath"));
		ArrayList<String> arrayListScenarios = testDataManage.getScenariosExecutableDetail("Main", "Test Scenarios");
		testDataManage.closeConnection();

		for (int iScenario = 0; iScenario < arrayListScenarios.size(); iScenario++) {
			System.out.println(arrayListScenarios.size());
			System.setProperty("ParalleCount",
					testDataManage.ScenarioData("Main", arrayListScenarios.get(iScenario), 3));
			System.setProperty("ScreenShotFlag",
					testDataManage.ScenarioData("Main", arrayListScenarios.get(iScenario), 4));
			System.setProperty("TimeOut", testDataManage.ScenarioData("Main", arrayListScenarios.get(iScenario), 5));
			System.setProperty("RemoteRun", testDataManage.ScenarioData("Main", arrayListScenarios.get(iScenario), 6));
			new TestNGSuiteCreation.TestNGSuiteCreation(arrayListScenarios.get(iScenario));
		}
	}

	public static void main(String args[]) throws IOException, InterruptedException, TestCaseFailException {
		try {
			System.out.println("Argument + 0 :" + args[0]);
			File f = new File(args[0]);
			if (f.exists() && f.isDirectory()) {
				System.out.println("INFO: Package Path verified as :" + args[0]);
				strConfigPath = args[0];
				try {
					System.out.println("Argument 2 : " + args[2]);
					String strArgsTwo = args[2].trim();
					if (!args[2].contains("${value3}") && !args[2].contains("%3") && !args[2].contains("-Dvalue2")) {
						if (strArgsTwo.contains("_")) {
							String[] argstwoarray = strArgsTwo.split("_");
							strSilo = argstwoarray[0];
							strTestType = argstwoarray[1];
							System.out.println("INFO: Silo environment passed as : " + strSilo);
							System.out.println("INFO: Test Type passed as :" + strTestType);
						} else {
							strSilo = strArgsTwo;
							System.out.println("INFO: Silo environment passed as : " + strSilo);
						}
					}
				} catch (Exception ein) {
					System.out.println("INFO - No Silo Information Passed to Driver Script");
				}
				new Driver();
			} else {
				System.out.println(
						"WARNING: Please check whether the given Package Path is valid. Value given as : " + args[0]);
			}
			System.out.println("Argument 0 : " + args[0]);
		} catch (NullPointerException e) {
			System.out.println("WARNING: Package Path is NULL. Please pass it as argument.");
			System.out.println("INFO: To run it from Eclipse, set up Run configuration as one time activity");
			System.out.println("INFO: To run it from Run.Bat, Pass Package Folder Path as argument ");
			System.out.println(
					"INFO: To run it from Jenkin, Add Invoke Ant Step and Pass Package Folder Path as argument in Properties tab ");
			e.printStackTrace();
		} catch (Exception ep) {
			System.out.println("WARNING: Package Path is NULL. Please pass it as argument.");
			ep.printStackTrace();
		}
		try {
			if (System.getProperty("test.teststatus").equalsIgnoreCase("FAIL")) {
				throw new TestCaseFailException(
						"WARNING: Not all the Test Cases Given in the List are Passed. Hence Failing Ant Build, check Detailed Report in workspace");
			}
		} catch (NullPointerException e) {
		}
		System.out.println("Exiting Program");
		try {
			System.out.println("Args [1] : " + args[1]);

			if (!args[1].equalsIgnoreCase("") && !args[1].isEmpty() && !(args[1] == null)
					&& !args[1].equalsIgnoreCase("-Dvalue3") && !args[1].equalsIgnoreCase("value3")
					&& !args[1].equalsIgnoreCase("%2")) {

				String BatPath = strConfigPath + "\\SendEmail.BAT";
				String[] command = { "cmd.exe", "/C", "Start", BatPath, args[1], System.getProperty("ResultPath") };
				Process p = Runtime.getRuntime().exec(command);

				p.waitFor();
				p.destroy();
				System.out.println("Sent Email to :" + args[1]);
			}

		} catch (InterruptedException ie) {
		} catch (IOException ioe) {
		} catch (ArrayIndexOutOfBoundsException arrayException) {
			System.out.println("INFO: Second Argument is not passed");
		} catch (NullPointerException npe) {
		} catch (Exception e) {
		}

		System.exit(0);
	}
}