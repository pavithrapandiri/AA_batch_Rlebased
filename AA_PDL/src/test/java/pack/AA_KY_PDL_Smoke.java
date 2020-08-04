
package pack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class AA_KY_PDL_Smoke  extends AA_PDL{


	@Test(priority=1,groups = "chenna_KY_PDL_Smoke") 
	public void BorrowerNewLoan_Rule() throws Exception 
	{
		String FileName= "AA_BorrowerRegistration_NewLoanRule_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_Smoke_path_chenna") + FileName);  			
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
			       
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_Scenario_No_01"+"_"+PayFrequency+"_"+CollateralType,"Login-->customer having already having Open Loan-->perform New Loan(depends on rule )");
				/*if(Income_PayFrequency.equals("Monthly")) // Added by pradeep for Monthly pay freq
				{
					//SetDate.SetDate(SSN, FileName, "02","08","2020");
					SetCurrentDate.SetCurrentDate(SSN, FileName);
				}
				
				if(Income_PayFrequency.equals("Semi-Monthly"))
				{
					SetDate.SetDate(SSN, FileName, "02","08","2020");
				}
				if(Income_PayFrequency.equals("Bi-Weekly"))
				{
					SetCurrentDate.SetCurrentDate(SSN, FileName);
				}
				if(Income_PayFrequency.equals("Weekly"))
				{
					SetCurrentDate.SetCurrentDate(SSN, FileName);
				}*/

				//SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
			    RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoanRule.NewLoanRule(SSN, FileName);
				//HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}

	

	//@Test(priority=2,groups = "chenna_KY_PDL_Smoke") 

	public void NewLoan_Void() throws Exception {


		String FileName= "AA_VoidLoan_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_Smoke_path_chenna") + FileName);  			
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
			    String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;


				test = reports.startTest(Header+"_Scenario_No_02"+"_"+PayFrequency+"_"+CollateralType,"Loan– same day Void");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				Void.Void(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
				
			}
		}

	}

	

	//@Test(priority=3,groups = "chenna_KY_PDL_Smoke") 

	public void Rescind() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_RescindLoan_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_Smoke_path_chenna") + FileName);  			
		//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_Smoke_path_chenna") + FileName);  		
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
			    String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_Scenario_No_03"+"_"+PayFrequency+"_"+CollateralType, "Loan– same day Rescind");

				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				Rescind.Rescind(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}


	}

	//@Test(priority=4,groups = "chenna_KY_PDL_Smoke") 

	public void BuyBack_Void() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_BuybackLoan_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_Smoke_path_chenna") + FileName);  		
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
			    
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				//test = reports.startTest("S.NO:19:AA_BuybackLoan_"+Header, "Void_Txn");
				test = reports.startTest(Header+"_Scenario_No_04"+"_"+PayFrequency+"_"+CollateralType,"Loan--Age the store--Perform the Buyback  ->void on same day");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,0);
				Buyback.Buyback(SSN, FileName); 
				BuybackVoid.BuybackVoid(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}


	//@Test(priority=5,groups = "chenna_KY_PDL_Smoke") 
	public void LoanWithCheck_ConvertACH_Deposit_ACHClear() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Newloan_Dep (Convert ACH)_Deposit_ACH Clear_Txn_Testdata.xls";
		//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_PDL_path_pradeep") + FileName); 
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_Smoke_path_chenna") + FileName);  		
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
			    
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);

				test = reports.startTest(Header+"_Scenario_No_05"+"_"+PayFrequency+"_"+CollateralType,"Loan(Check)-->Dep(Convert ACH)-->Deposit -->ACH Clear)");


			
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName); 
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0); 
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName,27);
				ACH_Clear_History.ACH_Clear_History(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}


	//@Test(priority=6,groups = "chenna_KY_PDL_Smoke") 

	public void NewLoan_Perform_EPP() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoan_AgeStore_Perform_EPP_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_Smoke_path_chenna") + FileName);  		
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
			    
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				//test = reports.startTest("AA_NewLoan_PartialPayment_throghEOD_CheckDepositdAmount"+Header, "NewLoan_PartialPayment_throghEOD_CheckDepositdAmount");
				//appUrl = AppURL;
				test = reports.startTest(Header+"_Scenario_No_06"+"_"+PayFrequency+"_"+CollateralType,"Loan--Age the store --perform EPP)");

				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				Perform_EPP.Perform_EPP(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test(priority=7,groups = "chenna_KY_PDL_Smoke") 

	public void NewLoan_ReturnPosting_60days_Writeoff() throws Exception {

		String FileName= "AA_NewLoan_ReturnPosting_60days_Writeoff_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_Smoke_path_chenna") + FileName);  		
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
			   
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				//test = reports.startTest("NewLoan_ReturnPosting_60days_Writeoff_Txn"+Header, "Loan -> Return Posting -> WO Check whether Write off is done 60days from return date.");
				//appUrl = AppURL;
				test = reports.startTest(Header+"_Scenario_No_07"+"_"+PayFrequency+"_"+CollateralType,"Loan->Return Posting --> WO Check whether Write off is done 60days from return date.)");


				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);					     
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				writeoff_Process.writeoff_Process(SSN, FileName, 60);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
				

			}
		}


	}

	
	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			// test.log(LogStatus.FAIL, "Test Case Failed is
			// "+result.getThrowable());

			String screenshotPath = getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		reports.flush();
		// driver.quit();

	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		// TakesScreenshot ts = (TakesScreenshot) driver;
		// File source = ts.getScreenshotAs(OutputType.FILE);

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/ExecutionReports/LOC/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		// Ending Test
		reports.endTest(test);

		// writing everything into HTML report
		reports.flush();
	}

	@AfterClass(alwaysRun = true)
	public void quit() {
		// Closing browser
		driver.quit();

	}
	public static void IETaskKiller() throws IOException, InterruptedException {

		Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
		Thread.sleep(2000); //Allow OS to kill the process
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
		driver = new InternetExplorerDriver();		
	}
	public void takeScreenShot(WebDriver driver, String filePath) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass(alwaysRun = true)
	public synchronized void initialize() {
		// Create an instance of ExtentsReports class and pass report storage
		// path as a parameter
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("C:/AA_Batch/AA_PDL/src/test/java/pack/Config.properties"));

			prop = new Properties();
			prop.load(reader);
			reader.close();

		}

		catch (Exception e) {

			System.out.println("Object proprties file not found");
		}

		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		// Date D = new Date();

		String kfilename = prop.getProperty("AA_SC_Store_extent_report_file_name") + timestamp + ".html";

		//String rpt = prop.getProperty("AA_SC_Store_extent_report_file_name") + timestamp + ".html";
		reports = new ExtentReports(System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + kfilename, true);
		reports.addSystemInfo("Product", "AA_KY_PDL_Smoke_Testing");
		/*
		 * reports = new ExtentReports(System.getProperty("user.dir") +
		 * "/ExecutionReports/CO_ILP/AA_CO_ILP_Generic Scenarios_" + timestamp +
		 * ".html", true); reports.addSystemInfo("Browser Version", "IE 11.0");
		 */
	}

	@BeforeTest(alwaysRun = true)
	public void setup_Grid() throws IOException, InterruptedException {

		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("C:/AA_Batch/AA_PDL/src/test/java/pack/Config.properties"));

			prop = new Properties();
			prop.load(reader);
			reader.close();

		}

		catch (Exception e) {

			System.out.println("Object proprties file not found");
		}

		Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
		Thread.sleep(5000); // Allow OS to kill the process
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * String Node = "http://192.168.2.123:5555/wd/hub"; DesiredCapabilities
		 * cap = DesiredCapabilities.internetExplorer();
		 * 
		 * 
		 * System.setProperty("webdriver.ie.driver",System.getProperty(
		 * "user.dir")+"/IEDriverServer.exe");
		 * 
		 * driver = new RemoteWebDriver(new URL(Node), cap);
		 */
		/*
		 * System.setProperty("webdriver.ie.driver",System.getProperty(
		 * "user.dir")+"/IEDriverServer.exe"); driver = new
		 * InternetExplorerDriver();
		 */
	}

	public boolean IsElementExits(String Value) {
		int secondsToWait = 5;

		try {
			new WebDriverWait(driver, secondsToWait)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Value)));
			return true;
		} catch (org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	public static WebElement Field(WebDriver driver) {

		try {
			Thread.sleep(500);
			WebElement element = (new WebDriverWait(driver, 9)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table")));
			return element;
		} catch (Exception e) {
			return null;
		}
	}

	public void proc(String ReturnFormat) throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");

		// Open a connection
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2",
					"QFUNDX_LOCAL_AUTOMATION", "QFUNDX_LOCAL_AUTOMATION");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");

		try {
			String A = null;

			String content;

			String fw = "E:\\AdminLogin.txt";
			// String content = "\r\n";

			// content=A;
			// fw = "E:\\AdminLogin.txt";

			appendUsingFileWriter(fw, ReturnFormat);
			// appendUsingFileWriter(fw,"\r\n");
			// appendUsingFileWriter(fw,content);

			// String str = content.readLine();

			fw.replaceAll("[0-9,a-z,A-Z]{17,21}", A);

			// fw.close();

			System.out.println("after query");

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}

	private static void appendUsingFileWriter(String filePath, String text) {
		File file = new File(filePath);
		FileWriter fr = null;
		try {
			// Below constructor argument decides whether to append or override
			fr = new FileWriter(file);
			fr.write(text);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
