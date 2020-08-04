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
//import pack.*;

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

public class practice extends AA_ILP {
	
	
@Test (priority=06)
	
	public void Loanpartialpmt() throws Exception   {
		//start test
		String Filename = "AA_ILP_TESTDATA1.xls";
	 TestData = new Excel("C:/Users/pavithra.k/Desktop/"+Filename);


		
		//barrowregistration1

		int lastrow=TestData.getLastRow("barrowregistration1");

		String sheetName="barrowregistration1";
		//for(int row=2;row<=lastrow;row++)
		for(int row=2;row<=lastrow;row++)
		{
	String RunFlag = TestData.getCellData(sheetName, "Run", row);
	if (RunFlag.equals("Y"))
	{
		AppURL = prop.getProperty("AppURL_AA_Practice_pavithra");
		UserName = prop.getProperty("UserName_AA_Practice_pavithra");
		Password = prop.getProperty("Password_AA_Practice_pavithra");
		StoreId = prop.getProperty("StoreID_AA_Practice_pavithra");
		
		String ProductID = TestData.getCellData(sheetName, "ProductID", row);
		String StateID = TestData.getCellData(sheetName, "StateID", row);
		String SSN = TestData.getCellData(sheetName, "SSN", row);
		String PayFrequency = TestData.getCellData(sheetName,"PayFrequency" , row);
		String CollateralType = TestData.getCellData(sheetName, "CollateralType", row);
		String Header = StateID +"_"+ ProductID;
		test = reports.startTest(Header + "s.no:01" + CollateralType , "Loanpartialpm");
		Login.Login(UserName, Password, StoreId);
		
		
		
		

	
		
		
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

				new FileReader("C:/AA_Batch/AA_ILP/src/test/java/pack/Config.properties"));

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

				new FileReader("C:/AA_Batch/AA_ILP/src/test/java/pack/Config.properties"));

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

