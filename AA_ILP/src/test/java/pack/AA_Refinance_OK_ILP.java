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

public class AA_Refinance_OK_ILP extends AA_ILP{

	@Test(priority=8,groups = "pavithra_OK_ILP_Refinance")

	public void Login_Newloan_Deposit_Clear_RefinanceinPAM() throws Exception {
		String FileName= "AA_Loan_Deposit_clear_RefinaceinPAM_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_Refinance_OK_ILP_path_pavithra") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   	
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_Refinance_pavithra");
				UserName = prop.getProperty("UserName_OK_ILP_Refinance_pavithra");
				Password = prop.getProperty("Password_OK_ILP_Refinance_pavithra");
				StoreId = prop.getProperty("StoreID_OK_ILP_Refinance_pavithra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:08"+"_"+PayFrequency+"_"+CollateralType, "Login_ Home screen_ Borrower _Registration_New loan_verifyOrigination fee and MHC fee");
				appUrl = AppURL;

			
				/*SetDate.SetDate(SSN, FileName,"03", "16", "2020");
			    Login.Login(UserName,Password,StoreId);           
			    RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
			    NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
			    AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
			    DrawerDeassign.DrawerDeassign(SSN, FileName);
			    StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			    StoreInfo.StoreInfo(SSN, FileName);
			    Safeassign.Safeassign(SSN, FileName);
			    Drawerassign.Drawerassign(SSN, FileName);
		    REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0,2);
			    ACH_Deposit.ACH_Deposit(SSN, FileName, 0,2);
			    EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 12, 2);
			    AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 3);
			    DrawerDeassign.DrawerDeassign(SSN, FileName);
			    StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			    StoreInfo.StoreInfo(SSN, FileName);
			    Safeassign.Safeassign(SSN, FileName);
			    Drawerassign.Drawerassign(SSN, FileName);
			    REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0,3);
			    ACH_Deposit.ACH_Deposit(SSN, FileName, 0,3);
			    EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 12, 3); */
			   // AgeStore_ILP.AgeStore_ILP(SSN, FileName, 2, 4);
			   AgeStore_PAM.AgeStoreBusinessdate_PAM(SSN, FileName, 0);
			   // PAM_Refinance.PAM_Refinace_Perform(SSN, FileName, "2");
			    
			    



			}
		}

	}
	//@Test(priority=9,groups = "pavithra_OK_ILP_Refinance")

	public void Login_NewLoan_Deposit_ClearINOtherstore_Refinace() throws Exception {
		String FileName= "AA_Loan_Depositsamestore_Clear otherstore_Refinance in samestore_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_Refinance_OK_ILP_path_pavithra") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   	
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_Refinance_pavithra");
				UserName = prop.getProperty("UserName_OK_ILP_Refinance_pavithra");
				Password = prop.getProperty("Password_OK_ILP_Refinance_pavithra");
				StoreId = prop.getProperty("StoreID_OK_ILP_Refinance_pavithra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:09"+"_"+PayFrequency+"_"+CollateralType, "Login_ Home screen_ Borrower _Registration_New loan_verifyOrigination fee and MHC fee");
				appUrl = AppURL;
				
				SetDate.SetDate(SSN, FileName,"03", "16", "2020");
			    Login.Login(UserName,Password,StoreId);           
			    RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
			    NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
			    AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
			    DrawerDeassign.DrawerDeassign(SSN, FileName);
			    StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			    StoreInfo.StoreInfo(SSN, FileName);
			    Safeassign.Safeassign(SSN, FileName);
			    Drawerassign.Drawerassign(SSN, FileName);
			    REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0,2);
			    ACH_Deposit.ACH_Deposit(SSN, FileName, 0,2);
			    EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 12, 2);
			    AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 3);
			    DrawerDeassign.DrawerDeassign(SSN, FileName);
			    StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			    StoreInfo.StoreInfo(SSN, FileName);
			    Safeassign.Safeassign(SSN, FileName);
			    Drawerassign.Drawerassign(SSN, FileName);
			    REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0,3);
			    ACH_Deposit.ACH_Deposit(SSN, FileName, 0,3);
			    EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 12, 3); 
			    AgeStore_ILP.AgeStore_ILP(SSN, FileName, 2, 4);
			    AgeStore_PAM.AgeStore_PAM(SSN, FileName, 2);
			    PAM_Refinance.PAM_Refinace_Perform(SSN, FileName, "2");
			    


			}
		}

	}
	//@Test(priority=11,groups = "pavithra_OK_ILP_Refinance")

	public void Login_Newloan_Deposit_Clear_Refinace_Manualclear() throws Exception {
		String FileName= "AA_Loan_Deposit_clear_Refinance_Manualclear_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_Refinance_OK_ILP_path_pavithra") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   	
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_Refinance_pavithra");
				UserName = prop.getProperty("UserName_OK_ILP_Refinance_pavithra");
				Password = prop.getProperty("Password_OK_ILP_Refinance_pavithra");
				StoreId = prop.getProperty("StoreID_OK_ILP_Refinance_pavithra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:01"+"_"+PayFrequency+"_"+CollateralType, "Login_ Home screen_ Borrower _Registration_New loan_verifyOrigination fee and MHC fee");
				appUrl = AppURL;

				SetDate.SetDate(SSN, FileName,"03", "16", "2020");
			    Login.Login(UserName,Password,StoreId);           
			    RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
			    NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
			    AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
			    DrawerDeassign.DrawerDeassign(SSN, FileName);
			    StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			    StoreInfo.StoreInfo(SSN, FileName);
			    Safeassign.Safeassign(SSN, FileName);
			    Drawerassign.Drawerassign(SSN, FileName);
			    REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0,2);
			    ACH_Deposit.ACH_Deposit(SSN, FileName, 0,2);
			    EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 12, 2);
			    AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 3);
			    DrawerDeassign.DrawerDeassign(SSN, FileName);
			    StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			    StoreInfo.StoreInfo(SSN, FileName);
			    Safeassign.Safeassign(SSN, FileName);
			    Drawerassign.Drawerassign(SSN, FileName);
			    REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0,3);
			    ACH_Deposit.ACH_Deposit(SSN, FileName, 0,3);
			    EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 12, 3); 
			    Refinance_ILP.Refinance_ILP(SSN, FileName, 100);
			    AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
			    DrawerDeassign.DrawerDeassign(SSN, FileName);
			    StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			    StoreInfo.StoreInfo(SSN, FileName);
			    Safeassign.Safeassign(SSN, FileName);
			    Drawerassign.Drawerassign(SSN, FileName);
			    REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0,2);
			    ACH_Deposit.ACH_Deposit(SSN, FileName, 0,2);
			    //TN_Manual_Clear.TN_Manual_Clear(SSN, FileName, 2);

			}
		}

	}
	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());

			String screenshotPath = getScreenhot(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		reports.flush();

	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/ExecutionReports/LOC/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		reports.endTest(test);

		reports.flush();
	}

	@AfterClass(alwaysRun = true)
	public void quit() {
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

		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());

		String kfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

		reports = new ExtentReports(System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + kfilename, true);
		reports.addSystemInfo("Product","FL-ILP");
	}

	@BeforeTest(alwaysRun = true)
	public void setup_Grid() throws IOException, InterruptedException {

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

		Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
		Runtime.getRuntime().exec("taskkill /T /F /IM iexplore.exe");
		Thread.sleep(5000); // Allow OS to kill the process
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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



	public static void IETaskKiller() throws IOException, InterruptedException {

		Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
		Thread.sleep(2000); //Allow OS to kill the process
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
		driver = new InternetExplorerDriver();		
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
		Statement stmt = null;
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


			appendUsingFileWriter(fw, ReturnFormat);

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

