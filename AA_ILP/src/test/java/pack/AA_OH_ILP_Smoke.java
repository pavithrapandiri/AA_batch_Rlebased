package pack;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import pack.*;

/*import Test.CO_ILP.Need;
import Test.CO_ILP.scenario;*/
import pack.Excel;

//import scala.collection.Iterator;
//import scala.collection.Set;

//import Pages.HomePage;
//import Pages.LoginPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileReader;

public class AA_OH_ILP_Smoke extends AA_ILP{

	/*public static String AdminURL;
	public static String AppURL;
	public static Properties prop;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	public WebDriverWait wait;
	static WebDriver driver;
	static String appUrl;

	static ExtentReports reports;
	public static String UserName;
	public static String Password;
	public static String StoreId;
	public static ExtentTest test;
	public static Excel TestData;*/

		
	@Test (priority=2,groups = "venkat_OH_ILP_Smoke")

	public void LOAN_partialpayment_DLQ_Cure_DEF_PartialdefPayment_PPN_1payment_Void_PPNdefpayment_WO120_WOR() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_LOAN_partialpayment_DLQ_Cure_DEF_PartialdefPayment_PPN_1payment_Void_PPNdefpayment_WO120_WOR_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_Smoke_path_venkat") + FileName);	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
			if(RunFlag.equals("Y"))
			{	
				//driver.get(appUrl);
				//test.log(LogStatus.INFO, "Application is launched");
				//driver.manage().window().maximize();


				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OH_ILP_Smoke_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_Smoke_venkat");
				Password = prop.getProperty("Password_OH_ILP_Smoke_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_Smoke_venkat");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:1"+"_"+PayFrequency+"_"+CollateralType,"LONI_Partial payment_EOD_DLQ_CURE_DEF_Partial def payment_PPN_1# payment_void_PPN default_partial def payment(>15% DEF amt)_WO(DEF DATE+120 DAYS)_WOR(pay total due amt)");
				
			   Login.Login(UserName,Password,StoreId);
			  
		     	RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP.NewLoan_ILP(SSN, FileName,"200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -5, 2);
				Payment_LessthanAmount.Payment_LessthanAmount(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);				
				//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName,2,2);    //Added extra two parameters
				Payment_PercentofDFLTAmt.Payment_PercentofDFLTAmt(SSN, FileName, 0.35);				
                RCC_Revoke.RCC_Revoke(SSN, FileName);
				EPP_ILP.EPP_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, 0, 2);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				Void_PaymentPlanPayment.Void_PaymentPlanPayment(SSN, FileName);
				EPP_EOD_BatchProcess_DueDate.EPP_EOD_BatchProcess_DueDate(SSN, FileName, 35, 2);
				Payment_PercentofDFLTAmt.Payment_PercentofDFLTAmt(SSN, FileName, 0.15);
				EPP_AfterDFLT_WO_EOD_BatchProcess_DueDate.EPP_AfterDFLT_WO_EOD_BatchProcess_DueDate(SSN, FileName, 180, 2);
				Writoff_RecoveryFull_ILP.Writoff_RecoveryFull_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName); 


			}       
		}


	}

//@Test (priority=3,groups = "venkat_OH_ILP_Smoke")


	public void LOAN_Payment_PBNK_Void_BNK_Dismiss_WOR() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_LOAN_Payment_PBNK_Void_BNK_Dismiss_WOR_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_Smoke_path_venkat") + FileName);	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
			if(RunFlag.equals("Y"))
			{	
				//driver.get(appUrl);
				//test.log(LogStatus.INFO, "Application is launched");
				//driver.manage().window().maximize();


				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OH_ILP_Smoke_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_Smoke_venkat");
				Password = prop.getProperty("Password_OH_ILP_Smoke_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_Smoke_venkat");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:6"+"_"+PayFrequency+"_"+CollateralType,"LONI_1#PAYMENT_PBNK_VOID_BNK_DISMISS_WOR");
				
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP.NewLoan_ILP(SSN, FileName,"300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				Payment_Inst_Amount.Payment_Inst_Amount(SSN, FileName, 2);
				PendingBNK.PendingBNK(SSN, FileName);
				PendingBNK_Void.PendingBNK_Void(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				Writoff_RecoveryFull_ILP.Writoff_RecoveryFull_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}       
		}


		
	}

	//@Test (priority=1,groups = "venkat_OH_ILP_Smoke") 

	public void LonI_1stInstDep_CLR_RTN_Cure_DEF_DFPpartialpymt_PPN_1stInstonduedate_Void_PPNDFLT_DFPfullpymt() throws Exception {

		// Start test. Mention test script name
		String FileName= "LonI_1stInstDep_CLR_RTN_Cure_DEF_DFPpartialpymt_PPN_1stInstonduedate_Void_PPNDFLT_DFPfullpymt.xls";		 
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_Smoke_path_venkat") + FileName);	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
			if(RunFlag.equals("Y"))
			{	
				//driver.get(appUrl);
				//test.log(LogStatus.INFO, "Application is launched");
				//driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_Smoke_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_Smoke_venkat");
				Password = prop.getProperty("Password_OH_ILP_Smoke_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_Smoke_venkat");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;      		        
				test = reports.startTest(Header+"_S.No:07"+"_"+PayFrequency+"_"+CollateralType,"LONI>1#DEPOSIT>CLR>RTN>CURE>DEF>DFP(partial payment)>PPN>1#payment on due date>void>PPN default>DFP(FULL)");
				
				//SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);			        
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP.NewLoan_ILP(SSN,FileName,"300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0,2);			
			    EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 8, 2);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 9, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				Payment_PercentofDFLTAmt.Payment_PercentofDFLTAmt(SSN, FileName, 0.35);	
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				EPP_ILP.EPP_ILP(SSN, FileName);				
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, 0, 2);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				Void_PaymentPlanPayment.Void_PaymentPlanPayment(SSN, FileName);
				EPP_EOD_BatchProcess_DueDate.EPP_EOD_BatchProcess_DueDate(SSN, FileName, 35, 2);
				Payment_PercentofDFLTAmt.Payment_PercentofDFLTAmt(SSN, FileName, 1.00);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
			}
		}

	}

	//@Test (priority=0,groups = "venkat_OH_ILP_Smoke") //15day/05m/2019 // wendensday
	public void LOAN_Deposit_CLR_Activemiltary_BNK_DEC_WOR() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_LOAN_Deposit_CLR_Activemiltary_BNK_DEC_WOR_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_Smoke_path_venkat") + FileName);	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
			if(RunFlag.equals("Y"))
			{	
				//driver.get(appUrl);
				//test.log(LogStatus.INFO, "Application is launched");
				//driver.manage().window().maximize();


				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OH_ILP_Smoke_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_Smoke_venkat");
				Password = prop.getProperty("Password_OH_ILP_Smoke_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_Smoke_venkat");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:12"+"_"+PayFrequency+"_"+CollateralType,"LONI_1#DEPSOIT_CLR_ACTIVE MILITARY_BNK>DECEASED_WOR");
				
			   // SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
			    RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP.NewLoan_ILP(SSN, FileName,"300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0,2);
				//ACHClear_admin.ACHClear_admin(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 12, 2);
				//AgeStore_ILP.AgeStore_ILP(SSN, FileName, 10, 2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				Deceased_AfterBANKRUPT.Deceased_AfterBANKRUPT(SSN, FileName);
				Writoff_RecoveryFull_ILP.Writoff_RecoveryFull_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);



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
		//driver.quit();

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
		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		// Date D = new Date();

		try {
			BufferedReader reader;
			reader = new BufferedReader(

					new FileReader("C:/AA_Batch/AA_ILP/src/test/java/pack/Config.properties"));

			prop = new Properties();
			prop.load(reader);
			reader.close();

		}

		catch (Exception e) {

			System.out.println("Object proprties file not found");
		}
		String kfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

		reports = new ExtentReports(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + kfilename, true);
		/*
		 * reports = new ExtentReports(System.getProperty("user.dir") +
		 * "/ExecutionReports/CO_ILP/AA_CO_ILP_Generic Scenarios_" + timestamp +
		 * ".html", true); reports.addSystemInfo("Browser Version", "IE 11.0");
		 */
	}

	@BeforeTest(alwaysRun = true)
	public void setup_Grid() throws IOException, InterruptedException {

		

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

