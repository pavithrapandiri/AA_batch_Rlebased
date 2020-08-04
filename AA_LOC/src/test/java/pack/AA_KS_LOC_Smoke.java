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

public class AA_KS_LOC_Smoke extends AA_LOC {

	@Test (priority=1,groups = "srikanth_KS_LOC_Smoke")
	public void Draw_Deliquent_Statement() throws Exception {
	
		// Start test. Mention test script name
		String FileName= "AA_Draw_Statement_Deliquent_Cure_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")+ prop.getProperty("AA_Store_Test_data_KS_LOC_Smoke_path_srikanth") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
		{	
				AppURL = prop.getProperty("AppURL_KS_LOC_Smoke_srikanth");
				UserName = prop.getProperty("UserName_KS_LOC_Smoke_srikanth");
				Password = prop.getProperty("Password_KS_LOC_Smoke_srikanth");
		        StoreId = prop.getProperty("StoreID_KS_LOC_Smoke_srikanth");
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		       test = reports.startTest("Cure"+Header, "Initiate LOC Loan with CASH_Draw_Statement_Draw_Delinquent_Payment_void_Statement_cure");
		       SetDate.SetDate(SSN, FileName, "01", "28", "2020");
		       Login.Login(UserName, Password, StoreId);
		        BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
			    NewLoan.NewLoan(SSN, FileName);
			    DrawLoan1.DrawLoan1(SSN, FileName);
		        StatementGeneration.StatementGeneration(SSN, FileName);
		
		        DLQ_Batch.DLQ_Batch(SSN,FileName,0);
	
		        Payment_Payoff.Payment_Payoff(SSN, FileName);
		        Payment_PayoffVoid.Payment_PayoffVoid(SSN, FileName);
		        StatementGeneration.StatementGeneration(SSN, FileName);
		    	
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
		
		        CurePaymentStatus.CurePaymentStatus(SSN, FileName);
		        Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
		      	}
		}
	  }

	//@Test (priority=2,groups = "srikanth_KS_LOC_Smoke")
	 public void LOCInitiation_Payoff_EODStatement() throws Exception {
	
		// Start test. Mention test script name
		String FileName= "AA_LOCInitialtion_Payoff_EODStatement_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")+ prop.getProperty("AA_Store_Test_data_KS_LOC_Smoke_path_srikanth") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
		
		if(RunFlag.equals("Y"))
		{	
				AppURL = prop.getProperty("AppURL_KS_LOC_Smoke_srikanth");
				UserName = prop.getProperty("UserName_KS_LOC_Smoke_srikanth");
				Password = prop.getProperty("Password_KS_LOC_Smoke_srikanth");
		     
		        StoreId = prop.getProperty("StoreID_KS_LOC_Smoke_srikanth");
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		       test = reports.startTest("AA_LOCInitialtion_Payoff_EODStatement_Txn_"+Header, "Initiate LOC Loan with ACH_Draw_Statement_Payoff_Draw_On Due Date_EOD_Statement");
		       SetDate.SetDate(SSN, FileName, "10", "01", "2020");
		       Login.Login(UserName, Password, StoreId);
			    
			    BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
		       
			    NewLoan.NewLoan(SSN, FileName);
				   DrawLoan1.DrawLoan1(SSN, FileName);
		        StatementGeneration.StatementGeneration(SSN, FileName);
		        DrawerDeassign.DrawerDeassign(SSN, FileName);
		        StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
		        StoreInfo.StoreInfo(SSN, FileName);
		        Safeassign.Safeassign(SSN, FileName);
		        Drawerassign.Drawerassign(SSN, FileName);
		        PayOffLoan.PayOffLoan(SSN, FileName);
		        DrawLoan1.DrawLoan1(SSN, FileName);
		        AgeStore1.AgeStore1(SSN, FileName);
		        StatementGeneration.StatementGeneration(SSN, FileName);
		        Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
		}
		}
	}

	@Test (priority=3,groups = "srikanth_KS_LOC_Smoke")
	 public void RegistrationTest() throws Exception {
			
			// Start test. Mention test script name
			String FileName= "AA_Loan_Statement_Default_Rcc_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir")+ prop.getProperty("AA_Store_Test_data_KS_LOC_Smoke_path_srikanth") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";   
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_KS_LOC_Smoke_srikanth");
					UserName = prop.getProperty("UserName_KS_LOC_Smoke_srikanth");
					Password = prop.getProperty("Password_KS_LOC_Smoke_srikanth");
			        StoreId = prop.getProperty("StoreID_KS_LOC_Smoke_srikanth");
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String StateID = TestData.getCellData(sheetName,"StateID",row);
			        String SSN = TestData.getCellData(sheetName,"SSN",row);	
			        String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			    	String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			        String Header = StateID+ "_" + ProductID;
			        test = reports.startTest("Loan_Statement_Default_Rcc"+Header, "Initiate LOC Loan with CASH_Draw_Statement_Draw_pay less that min payment amount_Delinquent_statement_cure_Default_RCC schedule should be generated 10 days before due date");
			        
			       SetDate.SetDate(SSN, FileName, "10", "01", "2020");
			        Login.Login(UserName, Password, StoreId);
			        BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
			        NewLoan.NewLoan(SSN, FileName);
				    DrawLoan1.DrawLoan1(SSN, FileName);
			        StatementGeneration.StatementGeneration(SSN, FileName);  
			        DrawLoan1.DrawLoan1(SSN, FileName);
			        Payment.Payment(SSN, FileName);
			        DLQ_Batch.DLQ_Batch(SSN,FileName,0);
			        StatementGeneration.StatementGeneration(SSN, FileName);		
			        DLQ_Batch.DLQ_Batch(SSN,FileName,10);
			        CurePaymentStatus.CurePaymentStatus(SSN, FileName); 
			        CustomerDefault.CustomerDefault(SSN, FileName);
			        DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName); 
			        RCCSchduleStatus.RCCSchduleStatus(SSN, FileName);
			        if(PayFrequency.equals("Weekly"))
			        {
			        	EditBorrower1.EditBorrower1(SSN, FileName,-10); 	
			        }
			        else
			        {
			        	EditBorrower.EditBorrower(SSN, FileName, -10);
			        }
			        Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
			       
			}
			}
			}
	 
	 
	//@Test (priority=4,groups = "srikanth_KS_LOC_Smoke")
		
		 public void Default_CustomerWO() throws Exception {
		
			// Start test. Mention test script name
			String FileName= "AA_Default_CustomerWO_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir")+ prop.getProperty("AA_Store_Test_data_KS_LOC_Smoke_path_srikanth") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";   
			
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				
			if(RunFlag.equals("Y"))
			{	
				
					AppURL = prop.getProperty("AppURL_KS_LOC_Smoke_srikanth");
					UserName = prop.getProperty("UserName_KS_LOC_Smoke_srikanth");
					Password = prop.getProperty("Password_KS_LOC_Smoke_srikanth");
			       
			        StoreId = prop.getProperty("StoreID_KS_LOC_Smoke_srikanth");
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String StateID = TestData.getCellData(sheetName,"StateID",row);
			        String SSN = TestData.getCellData(sheetName,"SSN",row);	
			        String Header = StateID+ "_" + ProductID;
			       
			        test = reports.startTest("Default_CustomerWO"+Header, "Initiate Loan->Draw->Statement Generation->Default_CustomerWO");
			        
			        SetDate.SetDate(SSN, FileName, "01", "28", "2020");
			        Login.Login(UserName, Password, StoreId);
			        BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
			        NewLoan.NewLoan(SSN, FileName);
					   DrawLoan1.DrawLoan1(SSN, FileName);
			        StatementGeneration.StatementGeneration(SSN, FileName);
			        DLQ_Batch.DLQ_Batch(SSN,FileName,0);

			      
			        DLQ_Batch.DLQ_Batch(SSN,FileName,10);
			       
			        CustomerDefault.CustomerDefault(SSN, FileName);
			        DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
			       Default_WOProc1.Default_WOProc1(SSN, FileName);
			        WOPaymentStatus.WOPaymentStatus(SSN, FileName);
			        Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName); 		        		        	        	        
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

			test.log(LogStatus.PASS, result.getName() + "Test Case is Passed");
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

					new FileReader("C:/AA_Batch/AA_LOC/src/test/java/pack/Config.properties"));

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
