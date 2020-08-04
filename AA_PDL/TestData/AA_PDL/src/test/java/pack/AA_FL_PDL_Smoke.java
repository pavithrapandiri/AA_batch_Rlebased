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

/*import Test.CO_ILP.Need;
import Test.CO_ILP.scenario;*/
import pack.*;
import pack.Void;
import bsh.*;
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

public class AA_FL_PDL_Smoke extends AA_PDL{

	
	@Test (priority=1,groups = "leela_FL_PDL_Smoke")
	
	 public void RegistrationTest() throws Exception {
	
		// Start test. Mention test script name
		String FileName= "AA_BorrowerRegistration_NewLoan_Txn_Testdata.xls";
		//////////////////////////     E:\QC_Workspace\AA_Automation\TestData\FL_PDL\Smoke_Local
		Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/FL_PDL/Smoke_Local/"+FileName); 
		System.out.println();
	//	TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_FL_PDL_path_Smoke_leela") + FileName); 
		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/FL_PDL/Smoke_Local/AA_BorrowerRegistration_NewLoan_Txn_Testdata.xls");
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
				AppURL = prop.getProperty("AppURL_FL_PDL_Smoke_leela");
				UserName = prop.getProperty("UserName_FL_PDL_Smoke_leela");
				Password = prop.getProperty("Password_FL_PDL_Smoke_leela");
		        StoreId = prop.getProperty("StoreID_FL_PDL_Smoke_leela");
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		        //System.out.println(SSN);
		        test = reports.startTest("BorrowerRegistration_NewLoan_"+Header, "Login_Home screen_Borrower_Registration_New loan");
		       
		        Login.Login(UserName,Password,StoreId);
		        
		        RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
		        NewLoan.NewLoan(SSN, FileName);
		   	}
		}
		//Login.Login("CSR353","1234","353");
	
			}

	 @Test (priority=2,groups = "leela_FL_PDL_Smoke")

	public void VoidloanTest() throws Exception {
		
		// Start test. Mention test script name
		String FileName= "AA_Newloan_MultipullDisb_Types.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_FL_PDL_path_Smoke_leela") + FileName);  			
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
				AppURL = prop.getProperty("AppURL_FL_PDL_Smoke_leela");
				UserName = prop.getProperty("UserName_FL_PDL_Smoke_leela");
				Password = prop.getProperty("Password_FL_PDL_Smoke_leela");
		       // System.out.println(Password);
		        StoreId = prop.getProperty("StoreID_FL_PDL_Smoke_leela");
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		        //System.out.println(SSN);
		        test = reports.startTest("AEA_Newloan_MultipullDisb_Type"+Header, "Newloan with multiple disbursements like check& cash_check whether loan is processed smoothly .");
		       
		        Login.Login(UserName,Password,StoreId);
		        
		        RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
		        NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
		  	}
	}
}

@Test (priority=3,groups = "leela_FL_PDL_Smoke")
	
	 public void BuyBack_Change_Void() throws Exception {
	
		// Start test. Mention test script name
		String FileName= "AA_PartialPayment_BuyBackChange_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_FL_PDL_path_Smoke_leela") + FileName);  			
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
				AppURL = prop.getProperty("AppURL_FL_PDL_Smoke_leela");
				UserName = prop.getProperty("UserName_FL_PDL_Smoke_leela");
				Password = prop.getProperty("Password_FL_PDL_Smoke_leela");
		        StoreId = prop.getProperty("StoreID_FL_PDL_Smoke_leela");
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		        test = reports.startTest("AA_PartialPayment_BuyBackChange_Void_"+Header, "New Loan_Age store to some days before due date_Partial Payment_Age store up to some days before due date_BuyBack transaction with change_Void BuyBack Transaction_check whether change amount is displayed or not");
		       
		        Login.Login(UserName,Password,StoreId);
		        
		        RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
		        NewLoan.NewLoan(SSN, FileName);
		        AgeStore.AgeStore(SSN, FileName,-5);	
		       // LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,+5);
		       // AgeStore.AgeStore(SSN, FileName,-2);
		        LoanPartialPayment.LoanPartialPayment(SSN, FileName);
		        AgeStore.AgeStore(SSN, FileName,-2);							     
		        BuybackChange.BuybackChange(SSN, FileName);
		        Void.Void(SSN, FileName);
			}
		}
	}
@Test (priority=4,groups = "leela_FL_PDL_Smoke")
	
	 public void PreNoteDeposit_Clear_CustomerInactive_Deposit() throws Exception {
	
		// Start test. Mention test script name
		                
		String FileName= "AA_PreNoteDeposit_Clear_CustomerInactive_Deposit_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_FL_PDL_path_Smoke_leela") + FileName);  			
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
				AppURL = prop.getProperty("AppURL_FL_PDL_Smoke_leela");
				UserName = prop.getProperty("UserName_FL_PDL_Smoke_leela");
				Password = prop.getProperty("Password_FL_PDL_Smoke_leela");
		       // System.out.println(Password);
		        StoreId = prop.getProperty("StoreID_FL_PDL_Smoke_leela");
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		        //System.out.println(SSN);
		        test = reports.startTest("PreNoteDeposit_Clear_CustomerInactive_Deposit_"+Header, "Loan_Pre Note DEP_PreNote Clr_Change BNK status to Inactive before due date_Custmr should not come for DEPosit on due date");
		       
		        Login.Login(UserName,Password,StoreId);
		       	
		        RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
		        NewLoan.NewLoan(SSN, FileName);
		        AgeStore.AgeStore(SSN, FileName, -7);
		        PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
		        AgeStore.AgeStore(SSN, FileName, -1);
		        PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName, -1);
		        EditBorrower_Inactive.EditBorrower_Inactive(SSN, FileName);
		        AgeStore.AgeStore(SSN, FileName, 0);
		      //  EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
 		        DrawerDeassign.DrawerDeassign(SSN, FileName);
		        StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName); 
		        StoreInfo.StoreInfo(SSN, FileName);
		        Safeassign.Safeassign(SSN, FileName);
		        Drawerassign.Drawerassign(SSN, FileName);
		        CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);
		}
	}
}
	
@Test (priority=5,groups = "leela_FL_PDL_Smoke")
	
	 public void PreNoteDeposit_Clear_CustomerActive_Deposit() throws Exception {
	
		// Start test. Mention test script name
		String FileName= "AA_PreNoteDeposit_Clear_CustomerActive_Deposit_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_FL_PDL_path_Smoke_leela") + FileName);  			
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
				AppURL = prop.getProperty("AppURL_FL_PDL_Smoke_leela");
				UserName = prop.getProperty("UserName_FL_PDL_Smoke_leela");
				Password = prop.getProperty("Password_FL_PDL_Smoke_leela");
		       // System.out.println(Password);
		        StoreId = prop.getProperty("StoreID_FL_PDL_Smoke_leela");
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		        //System.out.println(SSN);
		        test = reports.startTest("PreNoteDeposit_Clear_CustomerActive_Deposit_"+Header, "Loan_Pre Note DEP_PreNote Clr_Change BNK status to Inactive before due date_again Change BNK status to ACT on due dt_Custmr should come for DEPosit on due date");
		      
		        
		        Login.Login(UserName,Password,StoreId);
		        
		        RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
		        NewLoan.NewLoan(SSN, FileName);
		        AgeStore.AgeStore(SSN, FileName, -7);
		        PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
		        AgeStore.AgeStore(SSN, FileName, -1);
		        PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName, -1);
		        EditBorrower_Inactive.EditBorrower_Inactive(SSN, FileName);
		        AgeStore.AgeStore(SSN, FileName, 0);
		        EditBorrower_Active.EditBorrower_Active(SSN, FileName);
		      //  EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
		        DrawerDeassign.DrawerDeassign(SSN, FileName);
		        StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName); 
		        StoreInfo.StoreInfo(SSN, FileName);
		        Safeassign.Safeassign(SSN, FileName);
		        Drawerassign.Drawerassign(SSN, FileName);
		        ActiveCustomerEodS_Recoredtatus.ActiveCustomerEodS_Recoredtatus(SSN, FileName);
		              
		}
	}
	
}
//@Test (priority=6,groups = "leela_FL_PDL_Smoke")	
	
	 	public void Newloan_missEPP_EODprocess() throws Exception {
	
		// Start test. Mention test script name
		String FileName= "AA_Newloan_missEPP_EODprocess_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_FL_PDL_path_Smoke_leela") + FileName);  			
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
				AppURL = prop.getProperty("AppURL_FL_PDL_Smoke_leela");
				UserName = prop.getProperty("UserName_FL_PDL_Smoke_leela");
				Password = prop.getProperty("Password_FL_PDL_Smoke_leela");
		       // System.out.println(Password);
		        StoreId = prop.getProperty("StoreID_FL_PDL_Smoke_leela");
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		        //System.out.println(SSN);
		       test = reports.startTest("Newloan_missEPP_EODprocess_"+Header, "Loan-EPP- Miss the EPP Payment_Age the store to 14 days from EPP due date_Perform EOD_Customer record should display in EOD process and should comes out forcefully from EPP.");
		       
		        
		        //CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);
		        //EPP.EPP(SSN, FileName);
		  
		        Login.Login(UserName,Password,StoreId);
		         
		         RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
		        //RegistrationPage.RegistrationPage(SSN, FileName);
		        NewLoan.NewLoan(SSN, FileName);
		        AgeStore.AgeStore(SSN, FileName, -5);
		      /*  EPP.EPP(SSN, FileName); 			        
		        AgeStore.AgeStore(SSN, FileName, 0);	
		      //  EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
		        DrawerDeassign.DrawerDeassign(SSN, FileName);
		        StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName); 
		        StoreInfo.StoreInfo(SSN, FileName);
		        Safeassign.Safeassign(SSN, FileName);
		        Drawerassign.Drawerassign(SSN, FileName);*/
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
			reader = new BufferedReader(

					new FileReader("C:/AA_Batch/AA_PDL/src/test/java/pack/Config.properties"));

			prop = new Properties();
			prop.load(reader);
			reader.close();

		}

		catch (Exception e) {

			System.out.println("Object proprties file not found");
		}

		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		// Date D = new Date();

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

		try {
			BufferedReader reader;
			reader = new BufferedReader(

					new FileReader("C:/AA_Batch/AA_PDL/src/test/java/pack/Config.properties"));

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
