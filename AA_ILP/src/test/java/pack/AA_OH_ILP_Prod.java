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

public class AA_OH_ILP_Prod extends AA_ILP {

	// Venkat scenarios

	//@Test(priority = 0, groups = "venkat_OH_ILP_Prod")

	public void Login_Homescreen_Borrower_Registration_NewLoan_verify_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Login_Homescreen_Borrower_Registration_NewLoan_verify_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:01" + "_" + PayFrequency + "_" + CollateralType,
						"Login_ Home screen_ Borrower _Registration_New loan_verifyOrigination fee and MHC fee");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				// History.History(SSN, FileName, 0);

			}
		}

	}

	//@Test(priority = 1, groups = "venkat_OH_ILP_Prod")

	public void Login_Homescreen_Borrower_Registration_NewLoan_Monthly() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Login_Homescreen_Borrower_Registration_NewLoan_Monthly_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:02" + "_" + PayFrequency + "_" + CollateralType,
						"Login_ Home screen_ Borrower _Registration monthly income frequency_New loan");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				// History.History(SSN, FileName, 0);

			}
		}

	}

	@Test(priority = 42, groups = "venkat_OH_ILP_Prod") // 2

	public void Login_Homescreen_Borrower_Registration_NewLoan_SemiMonthly() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Login_Homescreen_Borrower_Registration_NewLoan_SemiMonthly_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:03" + "_" + PayFrequency + "_" + CollateralType,
						"Login_ Home screen_ Borrower _Registration semimonthly income frequency_New loan");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				// History.History(SSN, FileName, 0);

			}
		}

	}

	//@Test(priority = 3, groups = "venkat_OH_ILP_Prod")

	public void Login_Homescreen_Borrower_Registration_NewLoan_BiWeekly__() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Login_Homescreen_Borrower_Registration_NewLoan_BiWeekly__TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:04" + "_" + PayFrequency + "_" + CollateralType,
						"Login_ Home screen_ Borrower _Registration biweekly income frequency_New loan");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				// History.History(SSN, FileName, 0);

			}
		}

	}

	//@Test(priority = 4, groups = "venkat_OH_ILP_Prod")

	public void Login_Homescreen_Borrower_Registration_NewLoan_Weekly_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Login_Homescreen_Borrower_Registration_NewLoan_Weekly_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:05" + "_" + PayFrequency + "_" + CollateralType,
						"Login_ Home screen_ Borrower _Registration weekly income frequency_New loan");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				// History.History(SSN, FileName, 0);

			}
		}

	}

	//@Test(priority = 5, groups = "venkat_OH_ILP_Prod")

	public void Login_Homescreen_Borrower_Registration_NewLoan_ACH_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Login_Homescreen_Borrower_Registration_NewLoan_ACH_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:05" + "_" + PayFrequency + "_" + CollateralType,
						"Login_ Home screen_ Borrower _Registration weekly income frequency_New loan");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_OHILP_AccuralDate.NewLoan_OHILP_AccuralDate(SSN, FileName, "200");

			}
		}

	}

	//@Test(priority = 6, groups = "venkat_OH_ILP_Prod")

	public void Login_Homescreen_Borrower_Registration_NewLoan_MultiDisb_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Login_Homescreen_Borrower_Registration_NewLoan_MultiDisb_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:07" + "_" + PayFrequency + "_" + CollateralType,
						"Login_ Home screen_ Borrower _Registration_select multiple disbursement types");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_MultiDisb.NewLoan_ILP_MultiDisb(SSN, FileName, "200");
				// History.History(SSN, FileName, 0);

			}
		}

	}

	//@Test(priority = 7, groups = "venkat_OH_ILP_Prod")

	public void CO_ILP_NewLoanVoid() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_COILP_NewLoan_Void_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:8" + "_" + PayFrequency + "_" + CollateralType,
						"Loan– same day Void");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				Void.Void(SSN, FileName);
			}

		}
	}

	//@Test(priority = 8, groups = "venkat_OH_ILP_Prod")

	public void loan_VoidEncryption() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_loan_VoidEncryption_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:9" + "_" + PayFrequency + "_" + CollateralType,
						"Loan – void on next day with encryption key");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, 1);
				EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);

			}
		}

	}

	//@Test(priority = 9, groups = "venkat_OH_ILP_Prod")

	public void CO_ILP_NewLoanRescind() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_COILP_NewLoan_Rescind_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:10" + "_" + PayFrequency + "_" + CollateralType,
						"Loan– Rescind");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				Rescind.Rescind(SSN, FileName);

			}

		}

	}

	//@Test(priority = 10, groups = "venkat_OH_ILP_Prod")

	public void CO_ILP_MultipleDisbNewLoan_Void() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_COILP_MultipleDisb_Void_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y"))

			{

				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:11" + "_" + PayFrequency + "_" + CollateralType,
						"Loan with multiple disbursement (cash& check)->void with cash");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_MultiDisb.NewLoan_ILP_MultiDisb(SSN, FileName, "200");
				Void.Void(SSN, FileName);
				/// History.History(SSN, FileName);
				// Drawerassign.Drawerassign(SSN, FileName);

			}

		}

	}

	//@Test(priority = 12, groups = "venkat_OH_ILP_Prod") // Run scenario.scenario with
													// store date need to check
													// again for the date

	public void LonI_StoreDateafterRescindPeriod_Payment_selectpayanyotheramt_Pymtamtlessthan1stint() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_StoreDateafterRescindPeriod_Payment_selectpayanyotheramt_Pymtamtlessthan1stint_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:13" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_age the store date to after rescind period_select payment option from CSR dropdown_Payment screen should show the follwing options  1.Pay Off the balance 2.Pay Installment Am t 3.Pay any other Amt>select pay any other amt_enter Payment amount less than 1# amount");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -6);
				Payment_LessthanAmount.Payment_LessthanAmount(SSN, FileName);
				// History.History1(SSN, FileName);

			}
		}

	}

	//@Test(priority = 13, groups = "venkat_OH_ILP_Prod") // Run scenario.scenario with
													// store date need to check
													// again for the date

	public void LonI_RunEODbatchon1Instduedate_Payment_PayPastDue_NextInstallment() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_RunEODbatchon1Instduedate_Payment_PayPastDue_NextInstallment_Txn_TestData.xls";

		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:14" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>Run EOD batch process on 1# due date>Run again EOD batch process from 10th day of 1# due date>Payment(past due +installment amount");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Customer_Status.Customer_Status(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 1, 2);
				Payment_Pastdue_NextInst.Payment_Pastdue_NextInst(SSN, FileName);
				// History.History1(SSN, FileName);
				Customer_Status.Customer_Status(SSN, FileName);

			}
		}

	}

	//@Test(priority = 14, groups = "venkat_OH_ILP_Prod") // Run scenario.scenario with
													// store date need to check
													// again for the date

	public void LonI_RunEODbatchon1Instduedate_AgainEODbatchfrom10thdayof1stInstduedate_Payment_Pastdue_1stInstamt()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_RunEODbatchon1Instduedate_AgainEODbatchfrom10thdayof1stInstduedate_Payment_Pastdue_Pymtamt_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:15" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>Run EOD batch process on 1# due date>Run again EOD batch process from 10th day of 1# due date>Payment(past due +installment amount");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Customer_Status.Customer_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				Payment_2ndEODbatchprocess.Payment_2ndEODbatchprocess(SSN, FileName);
				Customer_Status.Customer_Status(SSN, FileName);
				// Apportions_List.Apportions_List(SSN, FileName, 2);

			}
		}

	}

	//@Test(priority = 15, groups = "venkat_OH_ILP_Prod") // Run scenario.scenario with
													// store date need to check
													// again for the date

	public void LonI_StoreDateafterRescindPeriod_Payment_selectpayanyotheramt_Pymtamtlessthan1stint_VoidPymt()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_StoreDateafterRescindPeriod_Payment_selectpayanyotheramt_Pymtamtlessthan1stint_VoidPymt_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:16" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_age the store date to after rescind period_select payment option from CSR dropdown_Payment screen should show the follwing options  1.Pay Off the balance 2.Pay Installment Am t 3.Pay any other Amt>select pay any other amt_enter Payment amount less than 1# amount");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -6);
				Payment_LessthanAmount.Payment_LessthanAmount(SSN, FileName);
				// Apportions_List.Apportions_List(SSN, FileName, row);
				Void_Payment.Void_Payment(SSN, FileName);
				// Void.Void(SSN, FileName);
				// Apportions_List.Apportions_List(SSN, FileName, row);

			}
		}

	}

	/*@Test(priority = 16, groups = "venkat_OH_ILP_Prod") // Dubilicate

	public void LonI_RunEODbatchon1Instduedate_Payment_PayPastDue_NextInstallment_VoidPymt() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_RunEODbatchon1Instduedate_Payment_PayPastDue_NextInstallment_VoidPymt_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:17" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>Run EOD batch process on 1# due date>Run again EOD batch process from 10th day of 1# due date>Payment(past due +installment amount");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 0);
				Customer_Status.Customer_Status(SSN, FileName);
				// Apportions_List.Apportions_List(SSN, FileName, 2);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 1, 2);
				Payment_Pastdue_NextInst.Payment_Pastdue_NextInst(SSN, FileName);
				// History.History1(SSN, FileName);
				Customer_Status.Customer_Status(SSN, FileName);
				Void_Payment.Void_Payment(SSN, FileName);
				// Apportions_List.Apportions_List(SSN, FileName, 2);
				Customer_Status.Customer_Status(SSN, FileName);

			}
		}

	}
*/
	//@Test(priority = 17, groups = "venkat_OH_ILP_Prod")

	public void LonI_RunEODbatchon1Instduedate_AgainEODbatchfrom10thdayof1stInstduedate_Payment_Pastdue_1stInstamt_Void()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_RunEODbatchon1Instduedate_AgainEODbatchfrom10thdayof1stInstduedate_Payment_Pastdue_1stInstamt_Void_Txn_TestData.xls";

		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:18" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>Run EOD batch process on 1# due date>Run again EOD batch process from 10th day of 1# due date>Payment(past due +installement amount)>void payment on next day");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Customer_Status.Customer_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				Payment_2ndEODbatchprocess.Payment_2ndEODbatchprocess(SSN, FileName);
				Customer_Status.Customer_Status(SSN, FileName);
				// Apportions_List.Apportions_List(SSN, FileName, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 12, 2);
				// Void_Payment.Void_Payment(SSN, FileName);
				Payment_EncryptionKey_Void.Payment_EncryptionKey_Void(SSN, FileName);

			}
		}

	}

	//@Test(priority = 18, groups = "venkat_OH_ILP_Prod")

	public void Loan_Deposit_Rtn_paymentLessthanLoanAmount() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Deposit_Rtn_paymentLessthanLoanAmount_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:19" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1# deposit_rtn_payment(less than 1# amount)");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Payment_LessthanAmount.Payment_LessthanAmount(SSN, FileName);
				// History.History(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
			}
		}

	}

	//@Test(priority = 19, groups = "venkat_OH_ILP_Prod")

	public void Loan_Deposit_Rtn_paymentGreaterthanLoanAmount() throws Exception {

		// Start test. Mention test script name
		String FileName = "Loan_Deposit_Rtn_paymentGreaterthanLoanAmount.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:20" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1# deposit_rtn_payment(greaterthan 1# amount)");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				// inst.inst1_AgeStore(SSN, FileName, 8);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				inst1_AgeStore.inst1_AgeStore(SSN, FileName, 0);
				Payment_gaterthanAmount.Payment_gaterthanAmount(SSN, FileName);
				// History.History(SSN, FileName );
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
			}
		}

	}

	//@Test(priority = 20, groups = "venkat_OH_ILP_Prod")

	public void Loan_Deposit_RTN_EODBatchon10days_PaymentGeterthanLoanAmount() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Deposit_RTN_EODBatchon10days_PaymentGeterthanLoanAmount_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:21" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1# deposit_rtn_Run EOB batch process from 10th day of due date_payment(greater  than 1# amount)");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");

				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);

				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// AgeStore_ILP.AgeStore_ILP(SSN, FileName, 8, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);

				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

				Payment_gaterthanAmount.Payment_gaterthanAmount(SSN, FileName);

				// History.History(SSN, FileName);
				// History.History1(SSN, FileName);

			}
		}

	}

	//@Test(priority = 21, groups = "venkat_OH_ILP_Prod")

	public void LonI_1stInstdeposit_return_Payment_lessthan1stInstamount_VoidPayment() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_1stInstdeposit_return_Payment_lessthan1stInstamount_VoidPayment_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:22" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>default>Run EOD batch process(default date+60 days)");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				// AgeStore_ILP.AgeStore_ILP(SSN, FileName, 8, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Payment_LessthanAmount_venkat.Payment_LessthanAmount_venkat(SSN, FileName, 2);
				Void_Payment.Void_Payment(SSN, FileName);
				// Apportions_List.Apportions_List(SSN, FileName, 2);
				Customer_Status.Customer_Status(SSN, FileName);
				// History.History(SSN, FileName);
			}
		}

	}

	//@Test(priority = 22, groups = "venkat_OH_ILP_Prod")

	public void Loan_Deposit_Rtn_paymentLessthanLoanAmount_Void() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Deposit_Rtn_paymentLessthanLoanAmount_Void_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:23" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1# deposit_rtn_payment(greater  than 1# amount)_void payment on next day  (Encryption key issue)");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Payment_gaterthanAmount.Payment_gaterthanAmount(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 1);
				Payment_EncryptionKey_Void.Payment_EncryptionKey_Void(SSN, FileName);
				// History.History(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
			}
		}

	}

	@Test(priority = 23, groups = "venkat_OH_ILP_Prod")

	public void Loan_1stDep_Ret_EODBatch10daysDueDate_PmtGreaterthanInstAmt_Void_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_1stDep_Ret_EODBatch10daysDueDate_PmtGreaterthanInstAmt_Void_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:24" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1# deposit_rtn_Run EOB batch process from 10th day of due date>payment(greater  than 1# amount)_Void");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");

				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);

				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// AgeStore_ILP.AgeStore_ILP(SSN, FileName, 8, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				PayAnyAmt_Installments_venkat.PayAnyAmt_Installments_venkat(SSN, FileName);//  changes
				PayAny_Void.PayAny_Void(SSN, FileName);
				// History.History(SSN, FileName);
				// History.History1(SSN, FileName);

			}
		}

	}

	@Test(priority = 24)
	public void Loan_PaymentinCSRPortel() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Payments_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:25" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>select payment option from CSR dropdown> Payment screen ");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);

				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -5);
				Payoff.Payoff(SSN, FileName);
				// History_Paymentcaluculation.History_Paymentcaluculation(SSN,
				// FileName);

			}
		}

	}

	@Test(priority = 25)
	public void AA_Loan_1stInstallmentPayments() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_1stInstallmentPayments_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:26" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>1# payment on due date>payoff");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 0);
				Payoff.Payoff(SSN, FileName);
				// History_Paymentcaluculation.History_Paymentcaluculation(SSN,
				// FileName);

			}
		}

	}

	@Test(priority = 26)
	public void Loan_PaymentinCSRPortel_Void() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Payment_Void_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:28" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>select payment option from CSR dropdown> Payment screen should show the follwing options  1.Pay Off the balance 2.Pay Installment Am t3.Pay any other Amt>select payoff balance>Enter amount>");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -5);
				Payoff.Payoff(SSN, FileName);
				PayAny_Void.PayAny_Void(SSN, FileName);
				// History_Paymentcaluculation.History_Paymentcaluculation(SSN,
				// FileName);

			}
		}

	}

	/*
	 * @Test(priority = 27) Dubilecate public void
	 * AA_Loan_1stInstallmentPayments_Void() throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName =
	 * "AA_Loan_1stInstallmentPayments_Void_Txn_Testdata.xls"; TestData = new
	 * Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
	 * int lastrow = TestData.getLastRow("NewLoan"); String sheetName =
	 * "NewLoan"; // int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for (int row = 2; row <= lastrow; row++) {
	 * String RunFlag = TestData.getCellData(sheetName, "Run", row); //
	 * System.out.println(RunFlag); if (RunFlag.equals("Y")) { //
	 * driver.get(appUrl); // test.log(LogStatus.INFO, "Application is launched"
	 * ); // driver.manage().window().maximize(); AppURL =
	 * prop.getProperty("AppURL_OH_ILP_venkat"); UserName =
	 * prop.getProperty("UserName_OH_ILP_venkat"); Password =
	 * prop.getProperty("Password_OH_ILP_venkat"); String PayFrequency =
	 * TestData.getCellData(sheetName, "Income_PayFrequency", row); String
	 * CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType",
	 * row); // System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_OH_ILP_venkat"); String ProductID =
	 * TestData.getCellData(sheetName, "ProductID", row); String StateID =
	 * TestData.getCellData(sheetName, "StateID", row); String SSN =
	 * TestData.getCellData(sheetName, "SSN", row); String Header = StateID +
	 * "_" + ProductID; // System.out.println(SSN); test =
	 * reports.startTest(Header + "_S.No:29" + "_" + PayFrequency + "_" +
	 * CollateralType,"Loan>1# payment on due date>void>payoff>void"); appUrl =
	 * AppURL;
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test,
	 * AppURL, SSN, FileName); NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
	 * AgeStore_.AgeStore_1stInstallment(SSN, FileName, 0); Payoff.Payoff(SSN,
	 * FileName); //
	 * History_Paymentcaluculation.History_Paymentcaluculation(SSN, FileName);
	 * 
	 * } }
	 * 
	 * }
	 */
	@Test(priority = 28, groups = "venkat_OH_ILP_Prod")

	public void Loan_Pmt1stInstdate_Pmt2ndInstdate_void_EODBatch10days2Inst_payoff_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Pmt1stInstdate_Pmt2ndInstdate_void_EODBatch10days2Inst_payoff_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:30" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1# payment on due date_2#payment on due date_void_run EOD batch process on 10th day of 2# _payoff_(consider loan has only three installements)_void");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				Payment_ILP.Payment_ILP(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				Payment_ILP.Payment_ILP(SSN, FileName);
				PayAny_Void.PayAny_Void(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 3);
				Payoff_Installments.Payoff_Installments(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				PayAny_Void.PayAny_Void(SSN, FileName);
				// History.History2(SSN, FileName);

			}
		}

	}

	//@Test(priority = 29, groups = "venkat_OH_ILP_Prod")

	public void Loan_Deposit_Rtn_payoff() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan1stInsatallmentDeposit_Return_Payoff_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:31" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>1#depsoit >rtn>payoff>");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 8);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 8);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Payoff_Return.Payoff_Return(SSN, FileName);
				// History_Payoffcaluculation.History_Payoffcaluculation(SSN,
				// FileName);
			}
		}

	}

	//@Test(priority = 30, groups = "venkat_OH_ILP_Prod")

	public void Loan_Deposit_Rtn_clear_2InstDeposit_Return_EODBatchprocess_payoff() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan1stInsatallmentDeposit_2ndInstDeposit_Return_EodBatch_3rdInst_Payoff_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:32" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>1#deposit >clr>2# dep>rtn>run EOD batch process on 10th from 2# due date>payoff>age the store date to one day before 3# due date(banking day)>run EOD");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 8, 2);
				AgeStore_2ndInstallment.AgeStore_2ndInstallment(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 3);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 3);
				Payoff_Return.Payoff_Return(SSN, FileName);
				AgeStore_3rdInstallment.AgeStore_3rdInstallment(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// History_Payoffcaluculation_.History_Payoffcaluculation_3rdInst(SSN,
				// FileName);
			}
		}

	}

	//@Test(priority = 31, groups = "venkat_OH_ILP_Prod")

	public void Loan_Deposit_Rtn_Payoff_Void() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan1stInsatallmentDeposit_Return_Payoff_void_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:33" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>1#depsoit >rtn>payoff>void");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 8);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Payoff_Return.Payoff_Return(SSN, FileName);
				PayAny_Void.PayAny_Void(SSN, FileName);
				// Void.Void(SSN, FileName);
				// History_Payoffcaluculation.History_Payoffcaluculation(SSN,
				// FileName);
			}
		}
	}

	//@Test(priority = 32, groups = "venkat_OH_ILP_Prod")

	public void Loan_DepositACH_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_DepositACH_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:35" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_age the store date to one day before 1# due date(banking day)_Run EOD process_Run payliance origination file_Process depsoit on due by clicking on Process ILP pre ach depsoits");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);

			}
		}

	}

	//@Test(priority = 33, groups = "venkat_OH_ILP_Prod")

	public void Loan_1stInstpartialpayment_1stInstdeposit_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_1stInstpartialpayment_1stInstdeposit_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:36" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1st Inst partial payment_1st Inst deposit");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				PartialPayment.PartialPayment(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_RecordVerify.StatementGeneration_EODProcessing_RecordVerify(SSN,
						FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);

			}
		}

	}

	/*@Test(priority = 34, groups = "venkat_OH_ILP_Prod") // dubilacate

	public void Loan_1stInstpaymentFullCash_1stInstdeposit_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_1stInstpaymentFullCash_1stInstdeposit_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:37" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1st Inst  full cash payment_1st Inst deposit");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				Payment_ILP.Payment_ILP(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				// StatementGeneration_EODProcessing_RecordVerify.StatementGeneration_EODProcessing_RecordVerify(SSN,
				// FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);

			}
		}

	}
*/
	//@Test(priority = 35, groups = "venkat_OH_ILP_Prod")
	public void AA_Loan_ACHRevoke_1stInsatallmentDeposit() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_ACHRevoke__1stInsatllmentDeposit_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:38" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>ach revoke >1# deposit");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				ACH_Revoke.ACH_Revoke(SSN, FileName);
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				// EODProcessing_with_recordsChecking.EODProcessing_with_recordsChecking(SSN,
				// FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

			}
		}

	}

	//@Test(priority = 36, groups = "venkat_OH_ILP_Prod")
	public void AA_Loan_ACHRevoke_1stInsatallmentPayment_ACHAuthorization_2ndIsatallmentDeposit() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_ACHRevoke__1stInsatllmentPayment_ACHAuthorigation_ACHDeposit_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:39" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>ach revoke >1# payment>ach auth>2# deposit");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				ACH_Revoke.ACH_Revoke(SSN, FileName);
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 0);
				Payment_ILP.Payment_ILP(SSN, FileName);
				ACHAuthorization.ACHAuthorization(SSN, FileName);
				AgeStore_2ndInstallment.AgeStore_2ndInstallment(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);

			}
		}

	}

	/*@Test(priority = 37, groups = "venkat_OH_ILP_Prod") // dubilicate

	public void CO_ILP_Loan_Instwisepayment_last_deposit() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_CO_ILP_Loan_Instwisepayment_LastInst_deposit_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:40" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>payment all the installements acc to respective due dates except last installement>last # deposit");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				// NewLoan_ILP_NegAmt.NewLoan_ILP_NegAmt(SSN, FileName, "200");
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				installmentPayment.installmentPayment(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				installmentPayment.installmentPayment(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 4);
				installmentPayment.installmentPayment(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 5);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

			}

		}
	}*/

	@Test(priority = 38, groups = "venkat_OH_ILP_Prod")

	public void Loan_1stInstDeposit_Rtn() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_1stInsatallmentDeposit_Return_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:41" + "_" + PayFrequency + "_" + CollateralType,
						"Laon>1# deposit>Return");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				// History_LoanStatus.History_LoanStatus(SSN, FileName);

			}
		}

	}

	@Test(priority = 39, groups = "venkat_OH_ILP_Prod")

	public void Loan_1stParPmt_1stDep_Ret_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_1stParPmt_1stDep_Ret_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:42" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1# partial payment_1# deposit_Return");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -6, 2);
				PayAnyAmt_Installments_venkat.PayAnyAmt_Installments_venkat(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				// AgeStore_ILP.AgeStore_ILP(SSN, FileName, 8, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	/*
	 * // @Test (priority=40,groups = "venkat_OH_ILP_Prod")//Dubilicate
	 * 
	 * public void
	 * Loan_PaymentallInstOnduedate_ExceptLastInst_LastDeposit_Return() throws
	 * Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_Loan_PaymentallInstOnduedate_ExceptLastInst_LastDeposit_Return_Testdata.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * 
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize();
	 * 
	 * 
	 * String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); AppURL =
	 * prop.getProperty("AppURL_OH_ILP_venkat"); UserName =
	 * prop.getProperty("UserName_OH_ILP_venkat"); Password =
	 * prop.getProperty("Password_OH_ILP_venkat"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_OH_ILP_venkat"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String Header = StateID+ "_" +
	 * ProductID; //System.out.println(SSN); test =
	 * reports.startTest(Header+"_S.No:43"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan_payment all the installements acc to respective due dates except last installement_last # deposit_Return"
	 * ); Login.Login(UserName,Password,StoreId);
	 * RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test,
	 * AppURL, SSN, FileName); NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
	 * AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
	 * Payment_Inst_Amount.Payment_Inst_Amount(SSN, FileName, 2);
	 * AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
	 * Payment_Inst_Amount.Payment_Inst_Amount(SSN, FileName, 3);
	 * AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 4);
	 * Payment_Inst_Amount.Payment_Inst_Amount(SSN, FileName, 4);
	 * 
	 * AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 5);
	 * DrawerDeassign.DrawerDeassign(SSN, FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1,5);
	 * ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0); //
	 * AgeStore_ILP.AgeStore_ILP(SSN, FileName, 8, 5);
	 * ACHReturnPosting.ACHReturnPosting(SSN, FileName);
	 * Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
	 * Check_Payment.Check_Payment(SSN, FileName);
	 * 
	 * 
	 * 
	 * } }
	 * 
	 * 
	 * }
	 */

	@Test(priority = 41, groups = "venkat_OH_ILP_Prod")
	public void AA_Loan_ACHRevoke_1stInsatallmentDeposit_Clear() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_ACHRevoke__1stInsatllmentDeposit_Clear_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_venkat");
				UserName = prop.getProperty("UserName_OH_ILP_venkat");
				Password = prop.getProperty("Password_OH_ILP_venkat");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:44" + "_" + PayFrequency + "_" + CollateralType,
						"Laon>1# deposit>Clear");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 8, 2);

			}
		}

	}

	//// Leela----- Starts ------- ////

	@Test(priority = 42, groups = "leela_OH_ILP_Prod")

	public void Loan_PmtAllExceptLast_DepLast_Clear_Return_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_PmtAllExceptLast_DepLast_Clear_Return_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:45" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>payment all the installements acc to respective due dates except last installement>last # deposit>clear>Return");
				//

				// SetCurrentDate.SetCurrentDate(SSN, FileName);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				Payment_ILP.Payment_ILP(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				Payment_ILP.Payment_ILP(SSN, FileName);

				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// History.History(SSN, FileName, 0);

				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 4);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 4);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);

				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 8, 4);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);

				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);

				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}
	}

	@Test(priority = 43, groups = "leela_OH_ILP_Prod")

	public void Loan_1stdeposit_clr_payoff_clear_return_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_1stdeposit_clr_payoff_clear_return_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:46" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1# deposit_clr_payoff_clear return");

				SetCurrentDate.SetCurrentDate(SSN, FileName);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");

				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);

				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 8, 2);
				Payoff_Installments.Payoff_Installments(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 44, groups = "leela_OH_ILP_Prod")
	public void AA_Loan1stInsatallmentEODbatchprocess_Cure_Default() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan1stInsatallmentEODbatchprocess_Cure_Default_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:47" + "_" + PayFrequency + "_" + CollateralType,
						"Laon>Run EOD batch process on 1# due date>Run EOD Batch process(due date+10 days)>Run EOD batch process on Cure end date");

				SetCurrentDate.SetCurrentDate(SSN, FileName);

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// History_Paymentcaluculation.History_Paymentcaluculation(SSN,
				// FileName);

			}
		}

	}

	@Test(priority = 45, groups = "leela_OH_ILP_Prod")
	public void AA_Loan1stInsatallmentEODbatchprocess_Cure_BeforeCureenddateDefault() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan1stInsatallmentEODbatchprocess_Cure_BeforecureendDateDefault_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:48" + "_" + PayFrequency + "_" + CollateralType,
						"Laon>Run EOD batch process on 1# due date>Run EOD Batch process(due date+10 days)>Run EOD batch process on Before Cure end date");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				if (CollateralType.contains("CASH")) {

					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 28, 2);
				}
				if (CollateralType.contains("ACH")) {
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 28);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
				}
				// History_LoanStatus.History_LoanStatus(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 46, groups = "leela_OH_ILP_Prod")

	public void Loan_PmtAllInstExceptLast_DFLTLastInst_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_PmtAllInstExceptLast_DFLTLastInst_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:49" + "_" + PayFrequency + "_" + CollateralType,
						"Laon_paymet all the installement except last #_Run EOD batch process on last # due date_Run EOD Batch process(due date+10 days)_Run EOD batch process on Cure end date");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				Payment_ILP.Payment_ILP(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				Payment_ILP.Payment_ILP(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 4);
				Payment_ILP.Payment_ILP(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 5);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 5);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 5);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 5);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// History.History(SSN, FileName, 0);
			}
		}

	}

	@Test(priority = 47, groups = "leela_OH_ILP_Prod")
	public void AA_Loan1stInsatallmentEODbatchprocess_Cure_1stInsatllPayment_CureenddateDefault() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan1stInsatallmentEODbatchprocess_Cure_IstInsatllPMT_CureEndDateEODbatchProcess_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:50" + "_" + PayFrequency + "_" + CollateralType,
						"Laon>Run EOD batch process on 1# due date>Run EOD Batch process(due date+10 days)>payment(1# amount)>Run EODbatch process on Cure end date");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				if (CollateralType.contains("CASH")) {

					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 31);

					Payment_ILP.Payment_ILP(SSN, FileName);

					// PaymentcureAmount_ILP.PaymentcureAmount_ILP(SSN,
					// FileName); // not required this step
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				}

				if (CollateralType.contains("ACH")) {
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 31);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
				}

				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}
	}

	@Test(priority = 48, groups = "leela_OH_ILP_Prod") // Last
	public void AA_Loan1stInsatallmentEODbatchprocess_Cure_1stInsatllPayment_void_CureenddateDefault()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan1stInsatallmentEODbatchprocess_Cure_IstInsatllPMT_void_CureEndDateEODbatchProcess_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:51" + "_" + PayFrequency + "_" + CollateralType,
						"Laon>Run EOD batch process on 1# due date>Run EOD Batch process(due date+10 days)>payment(1# amount)>void>Run EOD batch process on Cure end date");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				if (CollateralType.contains("CASH")) {

					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 31);
					Payment_ILP.Payment_ILP(SSN, FileName);
					// PaymentcureAmount_ILP.PaymentcureAmount_ILP(SSN,
					// FileName);
					Void_Payment.Void_Payment(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				}
				if (CollateralType.contains("ACH")) {
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 31);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
				}
				// History_Paymentcaluculation.History_Paymentcaluculation(SSN,
				// FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 49, groups = "leela_OH_ILP_Prod")
	public void AA_Loan1stInsatallmentEODbatchprocess_Cure_Less1stInsatllPayment_CureenddateDefault() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan1stInsatallmentEODbatchprocess_Cure_IstInsatllLessPMT_CureEndDateEODbatchProcess_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:52" + "_" + PayFrequency + "_" + CollateralType,
						"Laon>Run EOD batch process on 1# due date>Run EOD Batch process(due date+10 days)>payment(less than1# amount)>Run EOD batch process on Cure end date");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				if (CollateralType.contains("CASH")) {

					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 31);
					PaymentLess_ILP.PaymentLess_ILP(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				}
				if (CollateralType.contains("ACH")) {
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 31);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
				}
				// History_Paymentcaluculation.History_Paymentcaluculation(SSN,
				// FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 50, groups = "leela_OH_ILP_Prod")

	public void CO_ILP_Loan_DefaultPayment() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_CO_ILP_Loan_DefaultPayment_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:53" + "_" + PayFrequency + "_" + CollateralType,
						"Laon>Run EOD batch process on 1# due date>Run EOD Batch process(due date+10 days)>Run EOD batch process on Cure end date>select default payment option form drop down>enter full amount(with all possible tender types)");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);

				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 0, 2);

				Default_Payment_ILP.Default_Payment_ILP(SSN, FileName, 1);
				// History.History(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}

		}
	}

	@Test(priority = 51, groups = "leela_OH_ILP_Prod")

	public void CO_ILP_Loan_DefaulPartialPayment_Void() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_CO_ILP_Loan_DefaultPartialPayment_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:54" + "_" + PayFrequency + "_" + CollateralType,
						"Loan >Run EOD batch process on 1# due date>Run EOD Batch process(due date+10 days)>Run EOD batch process on Cure end date>partial default amount");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 0, 2);
				Default_Payment_ILP.Default_Payment_ILP(SSN, FileName, 0.5);
				Void_Default_Payment_ILP.Void_Default_Payment_ILP(SSN, FileName);
				// History.History(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}

		}
	}

	@Test(priority = 52, groups = "leela_OH_ILP_Prod")

	public void CO_ILP_Loan_DefaultPayment_Void() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_CO_ILP_Loan_DefaultPayment_Void_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:55" + "_" + PayFrequency + "_" + CollateralType,
						"Loan >Run EOD batch process on 1# due date>Run EOD Batch process(due date+10 days)>Run EOD batch process on Cure end date>Full default amount > Void");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 0, 2);
				Default_Payment_ILP.Default_Payment_ILP(SSN, FileName, 1);
				Void_Default_Payment_ILP.Void_Default_Payment_ILP(SSN, FileName);
				// History.History(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}

		}
	}

	@Test(priority = 53, groups = "leela_OH_ILP_Prod")

	public void CO_ILP_Loan_DefaulPartialPayment_EncryptionVoid() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_CO_ILP_Loan_DefaultPartialPayment_Encryption_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:56" + "_" + PayFrequency + "_" + CollateralType,
						"Laon>Run EOD batch process on 1# due date>Run EOD Batch process(due date+10 days)>Run EOD batch process on Cure end date>partial default amount>void on next day of the payment (with all possible tender types)");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 0, 2);
				Default_Payment_ILP.Default_Payment_ILP(SSN, FileName, 0.5);

				AgeStore_ILP_DEF.AgeStore_ILP_DEF(SSN, FileName, 1);
				Default_Payment_EncryptionKey_Void.Default_Payment_EncryptionKey_Void(SSN, FileName);

				// History.History(SSN, FileName);

			}

		}
	}

	@Test(priority = 54, groups = "leela_OH_ILP_Prod") // Leela

	public void LonI_DFLT_EODbatchprocess_DFLTPLUS60() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_DFLT_EODbatchprocess_DFLTPLUS60_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:57" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>default>Run EOD batch process(default date+60 days)");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				// Apportions_List.Apportions_List(SSN, FileName, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 91, 2);
				// Apportions_List.Apportions_List(SSN, FileName, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
			}
		}

	}

	@Test(priority = 55, groups = "leela_OH_ILP_Prod") // Leela

	public void LonI_DFLT_Pymt_15percentofDFLTamt_EODbatchprocess_DFLTPLUS120() throws Exception {

		// Start test. Mention test script name
		String FileName = "LonI_DFLT_Pymt_15percentofDFLTamt_EODbatchprocess_DFLTPLUS120.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:58" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>default>payment(15% of default payment)Run EOD batch process(default date+120 days)");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				Payment_PercentofDFLTAmt.Payment_PercentofDFLTAmt(SSN, FileName, 0.15);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 151, 2);
				// History.History1(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
			}
		}

	}

	@Test(priority = 56, groups = "leela_OH_ILP_Prod") // Leela

	public void LonI_DFLT_Pymt_20percentofDFLTamt_EODbatchprocess_DFLTPLUS60() throws Exception {

		// Start test. Mention test script name
		String FileName = "LonI_DFLT_Pymt_20percentofDFLTamt_EODbatchprocess_DFLTPLUS60.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:59" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>default>payment(15% of default payment)Run EOD batch process(default date+120 days)");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				Payment_PercentofDFLTAmt.Payment_PercentofDFLTAmt(SSN, FileName, 0.20);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 91, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
			}
		}

	}

	@Test(priority = 57, groups = "leela_OH_ILP_Prod")

	public void Loan_DFLT_30PerDFLTPmt_void_EODBatchProcessDFLTdate60days_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_DFLT_30PerDFLTPmt_void_EODBatchProcessDFLTdate60days_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:60" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_default_payment(30% of default payment)_void_Run EOD batch process(default date+60 days)");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");

				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);

				// EOD_BatchProcess_Default.EOD_BatchProcess_Default(SSN,
				// FileName, 2);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// History.History(SSN, FileName);
				Default_Payment_ILP.Default_Payment_ILP(SSN, FileName, 0.3);
				// History.History(SSN, FileName);
				DefaultPmt_Void_ILP.DefaultPmt_Void_ILP(SSN, FileName);
				// History.History(SSN, FileName);
				EOD_BatchProcess_WO_OH.EOD_BatchProcess_WO_OH(SSN, FileName, 60,2);
				// History.History(SSN, FileName);

			}
		}

	}

	@Test(priority = 58, groups = "leela_OH_ILP_Prod")

	public void Loan_DFLT_WO_WORecFullWithAllTenderTypes_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_DFLT_WO_WORecFullWithAllTenderTypes_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:61" + "_" + PayFrequency + "_" + CollateralType,
						"Laon_default_write off_writeoff recovery(full amount)(with all possible tender types)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);

				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 0, 2);
				// EOD_BatchProcess_Default.EOD_BatchProcess_Default(SSN,
				// FileName, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

				// History.History(SSN, FileName);

				EOD_BatchProcess_WO_OH.EOD_BatchProcess_WO_OH(SSN, FileName, 91,2);
				// History.History(SSN, FileName);
				Writoff_RecoveryFull_ILP.Writoff_RecoveryFull_ILP(SSN, FileName);
				// History.History(SSN, FileName);
			}
		}

	}

	@Test(priority = 59, groups = "leela_OH_ILP_Prod")

	public void Loan_DFLT_WO_WORecPartPmtWithAllTenderTypes_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_DFLT_WO_WORecPartPmtWithAllTenderTypes_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:62" + "_" + PayFrequency + "_" + CollateralType,
						"Laon_default_write off_writeoff recovery(partial amount)(with all possible tender types)");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");

				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);

				// EOD_BatchProcess_Default.EOD_BatchProcess_Default(SSN,
				// FileName, 2);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

				// History.History(SSN, FileName);
				EOD_BatchProcess_WO_OH.EOD_BatchProcess_WO_OH(SSN, FileName, 91,2);
				// History.History(SSN, FileName);

				Writoff_RecoveryPartPmt_ILP.Writoff_RecoveryPartPmt_ILP(SSN, FileName);

				// History.History(SSN, FileName);

			}
		}

	}

	@Test(priority = 60, groups = "leela_OH_ILP_Prod")

	public void Loan_DFLT_WO_WORecFull_VoidWithAllTenderTypes() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_DFLT_WO_WORecFull_VoidWithAllTenderTypes_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:63" + "_" + PayFrequency + "_" + CollateralType,
						"Laon_default_write off_writeoff recovery(full amount)_Loan_DFLT_WO_WORecFull_VoidWithAllTenderTypes_Void(with all possible tender types)");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");

				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);

				// EOD_BatchProcess_Default.EOD_BatchProcess_Default(SSN,
				// FileName, 2);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

				// History.History(SSN, FileName);
				EOD_BatchProcess_WO_OH.EOD_BatchProcess_WO_OH(SSN, FileName, 91,2);

				// History.History(SSN, FileName);
				Writoff_RecoveryFull_ILP.Writoff_RecoveryFull_ILP(SSN, FileName);

				Void_WO.Void_WO(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// History.History(SSN, FileName);

			}
		}

	}

	@Test(priority = 61, groups = "leela_OH_ILP_Prod")

	public void Loan_DFLT_WO_WORecPartPmt_VoidNextDay() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_DFLT_WO_WORecPartPmt_VoidNextDay_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:64" + "_" + PayFrequency + "_" + CollateralType,
						"Laon_default_write off_writeoff recovery(partial amount)_void on next day(with all possible tender types)");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");

				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);

				// EOD_BatchProcess_Default.EOD_BatchProcess_Default(SSN,
				// FileName, 2);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

				// History.History(SSN, FileName);
				EOD_BatchProcess_WO_OH.EOD_BatchProcess_WO_OH(SSN, FileName, 91,2);
				// History.History(SSN, FileName);

				Writoff_RecoveryPartPmt_ILP.Writoff_RecoveryPartPmt_ILP(SSN, FileName);
				AgeStore_AfterWO.AgeStore_AfterWO(SSN, FileName, 61);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// History.History(SSN, FileName);

				EncryptionKey_Void_WORec.EncryptionKey_Void_WORec(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 62, groups = "leela_OH_ILP_Prod") // Leela

	public void DFLTLoan_EPPConvert_PpayAllInst_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTLoan_EPPConvert_PpayAllInst_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:65" + "_" + PayFrequency + "_" + CollateralType,
						"Pick anILP Loan which is default status _ Convert to EPP _ PPAY all installments accordingly before due date");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_Default_leela.EOD_BatchProcess_Default_leela(SSN, FileName, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				EPP_ILP.EPP_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 2);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 3);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 4);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 5);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 6);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 63, groups = "leela_OH_ILP_Prod") // - Need to execute last

	public void DFLTLoan_EPPConvert_DepositAll_ClearAll_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTLoan_EPPConvert_DepositAll_ClearAll_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:66" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an ILP Loan which is default status _ Convert to EPP _ Deposit all installments on due date accordingly and clear them");

				SetCurrentDate.SetCurrentDate(SSN, FileName);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");

				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_Default_leela.EOD_BatchProcess_Default_leela(SSN, FileName, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				EPP_ILP.EPP_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile_PPN.Payliance_OriginationFile_PPN(SSN, FileName, -1, 2);
				ACH_Deposit_RPP_ILP.ACH_Deposit_RPP_ILP(SSN, FileName, 0, 2);
				EOD_BatchProcess_EPPDueDate.EOD_BatchProcess_EPPDueDate(SSN, FileName, 10, 2);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);

				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile_PPN.Payliance_OriginationFile_PPN(SSN, FileName, -1, 3);
				ACH_Deposit_RPP_ILP.ACH_Deposit_RPP_ILP(SSN, FileName, 0, 3);
				EOD_BatchProcess_EPPDueDate.EOD_BatchProcess_EPPDueDate(SSN, FileName, 9, 3);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);

				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -1, 4);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile_PPN.Payliance_OriginationFile_PPN(SSN, FileName, -1, 4);
				ACH_Deposit_RPP_ILP.ACH_Deposit_RPP_ILP(SSN, FileName, 0, 4);
				EOD_BatchProcess_EPPDueDate.EOD_BatchProcess_EPPDueDate(SSN, FileName, 9, 4);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -1, 5);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile_PPN.Payliance_OriginationFile_PPN(SSN, FileName, -1, 5);
				ACH_Deposit_RPP_ILP.ACH_Deposit_RPP_ILP(SSN, FileName, 0, 5);
				EOD_BatchProcess_EPPDueDate.EOD_BatchProcess_EPPDueDate(SSN, FileName, 9, 5);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -1, 6);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile_PPN.Payliance_OriginationFile_PPN(SSN, FileName, -1, 6);
				ACH_Deposit_RPP_ILP.ACH_Deposit_RPP_ILP(SSN, FileName, 0, 6);
				EOD_BatchProcess_EPPDueDate.EOD_BatchProcess_EPPDueDate(SSN, FileName, 9, 6);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
			}
		}

	}

	@Test(priority = 64, groups = "leela_OH_ILP_Prod")

	public void DFLTLoan_EPPConvert_PpayAllInst_VoidLastInst_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTLoan_EPPConvert_PpayAllInst_VoidLastInst_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:67" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an ILP Loan which is default status_ Convert to EPP _ PPAY all installments accordingly before due date _void last installment payment");

				SetCurrentDate.SetCurrentDate(SSN, FileName);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_Default_leela.EOD_BatchProcess_Default_leela(SSN, FileName, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				EPP_ILP.EPP_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 2);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 3);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 4);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				RPP_Payment_Void.RPP_Payment_Void(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}
	}

	// Scenarios 68 to 75 were blocked

	@Test(priority = 65, groups = "leela_OH_ILP_Prod") // Not Required - Duplicate

	public void LonI_DFLT_PPN_1stInstpymt_VoidPymt_RunEODbatch35daysfromduedate() throws Exception {

		// Start test. Mention test script name
		String FileName = "LonI_DFLT_PPN_1stInstpymt_VoidPymt_RunEODbatch35daysfromduedate.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:76" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an ILP Loan which is default status -> PPN=>1# paymnet >void >Run EOD batch process on 35 days from the due dateNOTE:In between 1# due date to 35 days if 2# is there then that amount should be missed payment)");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				// History.History(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RPP.RPP(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0, 2);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				Void_PaymentPlanPayment.Void_PaymentPlanPayment(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, 35, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);

			}
		}

	}

	// Scenarios 77 and 78 were blocked

	@Test(priority = 66, groups = "leela_OH_ILP_Prod2") // Not Required - Duplicate

	public void Pick_ILP_WriteoffLoan_ConvertEPP_PPayAllInstallementBeforeDueDate() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Pick_ILP_WriteoffLoan_ConvertEPP_PPayAllInstallementBeforeDueDate_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:79" + "_" + PayFrequency + "_" + CollateralType,
						"Pick anILP Loan which is writeoff status_Convert to EPP_PPAY all installments accordingly before due date");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 151, 2);
				EPP_ILP.EPP_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 2);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 3);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 4);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 5);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 67, groups = "leela_OH_ILP_Prod2") // need to run last

	public void Pick_ILP_WriteOff_ConvertEpp_DepositAllinstOnduedate_Clear() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Pick_ILP_WriteOff_ConvertEpp_DepositAllinstOnduedate_Clear_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:80" + "_" + PayFrequency + "_" + CollateralType,
						"Pick anILP Loan which is writeoff status_Convert to EPP_PPAY all installments accordingly before due datePick an ILP Loan which is writeoff status_Convert to EPP_Deposit all installments on due date accordingly and clear them");

				Login.Login(UserName, Password, StoreId);

				// SetCurrentDate.SetCurrentDate(SSN, FileName);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 151, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				EPP_ILP.EPP_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile_PPN.Payliance_OriginationFile_PPN(SSN, FileName, -1, 2);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0, 2);
				EOD_BatchProcess_EPPDueDate.EOD_BatchProcess_EPPDueDate(SSN, FileName, 8, 2);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);

				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile_PPN.Payliance_OriginationFile_PPN(SSN, FileName, -1, 2);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0, 3);
				EOD_BatchProcess_EPPDueDate.EOD_BatchProcess_EPPDueDate(SSN, FileName, 8, 3);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);

				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -1, 4);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile_PPN.Payliance_OriginationFile_PPN(SSN, FileName, -1, 2);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0, 4);
				EOD_BatchProcess_EPPDueDate.EOD_BatchProcess_EPPDueDate(SSN, FileName, 8, 4);
				// Check_TransactionRecords.Check_TransactionRecords(SSN,
				// FileName);

				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 68, groups = "leela_OH_ILP_Prod2")

	public void Pick_ILP_WriteoffLoan_ConvertEPP_PPayAllInstallementBeforeDueDate_Void() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Pick_ILP_WriteoffLoan_ConvertEPP_PPayAllInstallementBeforeDueDate_Void_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();

				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:81" + "_" + PayFrequency + "_" + CollateralType,
						"Pick anILP Loan which is writeoff status_Convert to EPP_PPAY all installments accordingly before due date");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 151, 2);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				EPP_ILP.EPP_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 2);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 3);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 4);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				AgeStore_RPP_ILP.AgeStore_RPP_ILP(SSN, FileName, -4, 5);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				Void_Afterallinstallment.Void_Afterallinstallment(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	// Scenarios Blocked from 82 to 89

	@Test(priority = 69, groups = "leela_OH_ILP_Prod1")

	public void LonI_WO_PPN_1stInstpymt_VoidPymt_RunEODbatch35daysfromduedate() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_WO_PPN_1stInstpymt_VoidPymt_RunEODbatch35daysfromduedate_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:90" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is writeoff status_PPN=>1# paymnet _void _Run EOD batch process on 35 days from the due dateNOTE:In between 1#  due date to 35  days if 2# is there then that  amount should be missed payment))");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 151, 2);
				// History.History(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RPP.RPP(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0, 2);
				RPP_Payment_ILP.RPP_Payment_ILP(SSN, FileName);
				Void_PaymentPlanPayment.Void_PaymentPlanPayment(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, 35, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 70, groups = "leela_OH_ILP_Prod") // Leela

	public void Loan_Bankrupt_Void_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Bankrupt_Void_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:91" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_Select Void Status from Status dropdown in Bankruptcy Deceased Suite pageEnter all mandatory fields and click on Save");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				Bankrupt.Bankrupt(SSN, FileName);
				Bankrupt_Void.Bankrupt_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

				// History.History(SSN, FileName);

			}
		}

	}

	// Scenario 92 - Duplicate

	@Test(priority = 71, groups = "leela_OH_ILP_Prod") // Not Required - Duplicate

	public void Loan_Bankrupt_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Bankrupt_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:93" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_Select Bankruptcy Status from Status dropdown in Bankruptcy Deceased Suite page Enter all mandatory fields and click on Save");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

				// History.History(SSN, FileName, 0);
			}
		}

	}

	@Test(priority = 72, groups = "leela_OH_ILP_Prod") // Not Required - Duplicate
	public void CO_ILP_Loan_BNK_Void() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_COILP_NewLoan_BNK_Void_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:94" + "_" + PayFrequency + "_" + CollateralType,
						"Loan–BNK-Void");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "100");
				AgeStore.AgeStore(SSN, FileName, 0);
				Bankrupt.Bankrupt(SSN, FileName);
				Bankrupt_VV.Bankrupt_VV(SSN, FileName);
				;

			}
		}

	}

	@Test(priority = 73, groups = "leela_OH_ILP_Prod")

	public void CO_ILP_Loan_first_payment_BNK_Second_deposit() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_OH_ILP_Loan_first_payment_BNK_Second_deposit_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:95" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>1 payment > mark customer to BNK>2 deposit");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore.AgeStore(SSN, FileName, -2);
				installmentPayment.installmentPayment(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				AgeStore_2ndInstallment.AgeStore_2ndInstallment(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

			}

		}
	}

	@Test(priority = 74, groups = "leela_OH_ILP_Prod") // leela

	public void LonI_Bnkrupt_Dismissed() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_Bnkrupt_Dismissed_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:96" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>Select 'Bankruptcy' Status from Status dropdown in Bankruptcy/Deceased Suite page Enter all mandatory fields and click on Save. 2) Go to Edit bankrupt information >> Click on Go Button and select dismissed from drop down >> enter manditory fields and Clickon save.");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				Bankrupt.Bankrupt(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// Customer_Status.Customer_Status(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				// Customer_Status.Customer_Status(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 75, groups = "leela_OH_ILP_Prod") // Leela

	public void LonI_Bnkrupt_Deceased() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_Bnkrupt_Deceased_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:97" + "_" + PayFrequency + "_" + CollateralType,
						"1)Select 'Bankruptcy' Status from Status dropdown in Bankruptcy/Deceased Suite pageEnter all manatory fields and click on Save.2) Go to Edit bankrupt information >> Click on Go Button and select deaceased from drop down >> enter manditory fields andClick on save.");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				Bankrupt.Bankrupt(SSN, FileName);
				// Customer_Status.Customer_Status(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				Deceased_AfterBANKRUPT_leela.Deceased_AfterBANKRUPT_leela(SSN, FileName, 6);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// Customer_Status.Customer_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 76, groups = "leela_OH_ILP_Prod") // Leela

	public void LonI_Bnkrupt_Discharge() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_Bnkrupt_Discharge_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:98" + "_" + PayFrequency + "_" + CollateralType,
						"1)Select 'Bankruptcy' Status from Status dropdown in Bankruptcy/Deceased Suite page Enter all mandatory fields and click on Save.2) Go to Edit bankrupt information >> Click on Go Button and select Discharge from drop down >> enter manditory fields and Clickon save.");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				Bankrupt.Bankrupt(SSN, FileName);
				Discharge_AfterBANKRUPT.Discharge_AfterBANKRUPT(SSN, FileName, 6);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// Customer_Status.Customer_Status(SSN, FileName);

			}
		}

	}

	@Test(priority = 77, groups = "leela_OH_ILP_Prod") // Leela

	public void LonI_Deceased() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_Deceased_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:99" + "_" + PayFrequency + "_" + CollateralType,
						"Select 'deceased' Status from Status dropdown in Bankruptcy/Deceased Suite page Enter all mandatory fields and click on Save");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				Deceased.Deceased(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				// Customer_Status.Customer_Status(SSN, FileName);
			}
		}

	}

	@Test(priority = 78, groups = "leela_OH_ILP_Prod") // Leela

	public void LonI_DFLT_PPN_BNK_1InstDeposit() throws Exception {

		// Start test. Mention test script name
		String FileName = "LonI_DFLT_PPN_BNK_1InstDeposit.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:100" + "_" + PayFrequency + "_" + CollateralType,
						"Loan>default>payment(15% of default payment)Run EOD batch process(default date+120 days)");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 31, 2);
				// History.History(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				EPP_ILP.EPP_ILP(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				EODProcessing_with_recordsChecking.EODProcessing_with_recordsChecking(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

			}
		}

	}

	@Test(priority = 79, groups = "leela_OH_ILP_Prod") // Leela

	public void Loan_1stpayment_activemilitary_2ndpayment_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_1stpayment_activemilitary_2ndpayment_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:101" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1st Inst payment_active military_2nd Inst payment");

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);

				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -3, 2);
				Payment_ILP.Payment_ILP(SSN, FileName);
				Active_Military_Start.Active_Military_Start(SSN, FileName);

				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -3, 3);
				Payment_ILP.Payment_ILP(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);

				// History.History(SSN, FileName, 0);
			}
		}

	}

	@Test(priority = 80, groups = "leela_OH_ILP_Prod") // Leela

	public void BorrowerRegistration_ActiveMilitary_NewLoanNotProcessed_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_BorrowerRegistration_ActiveMilitary_NewLoanNotProcessed_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:102" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_1st Inst payment_active military_2nd Inst payment");

				/*
				 * Login.Login(UserName, Password, StoreId);
				 * RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(
				 * driver, test, AppURL, SSN, FileName);
				 */

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				Check_NewLoan_ILP.Check_NewLoan_ILP(SSN, FileName);
			}
		}

	}

	@Test(priority = 81, groups = "leela_OH_ILP_Prod") // Not Required - Duplicate

	public void LonI_IstInstPayment_ACTM_ACTMEnd_2ndInstpymt_Verify_Apportions() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_IstInstPayment_ACTM_ACTMEnd_2ndInstpymt_Verify_Apportions_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:103" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_age the store date to after rescind period_select payment option from CSR dropdown_Payment screen should show the follwing options  1.Pay Off the balance 2.Pay Installment Am t 3.Pay any other Amt>select pay any other amt_enter Payment amount less than 1# amount");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				Payment_Inst_Amount.Payment_Inst_Amount(SSN, FileName, 2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 2, 2);
				Active_Military_End.Active_Military_End(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				Payment_Inst_Amount.Payment_Inst_Amount(SSN, FileName, 3);
				Apportions_List.Apportions_List(SSN, FileName, row);

			}
		}

	}

	@Test(priority = 82, groups = "leela_OH_ILP_Prod") // Leela

	public void LonI_IstInstPayment_ACTM_2ndInstDeposit_Verify_Record() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_IstInstPayment_ACTM_2ndInstDeposit_Verify_Record_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:104" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_age the store date to after rescind period_select payment option from CSR dropdown_Payment screen should show the follwing options  1.Pay Off the balance 2.Pay Installment Am t 3.Pay any other Amt>select pay any other amt_enter Payment amount less than 1# amount");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				Payment_Inst_Amount.Payment_Inst_Amount(SSN, FileName, 2);
				Apportions_List.Apportions_List(SSN, FileName, 2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 3);
				ACH_Deposit_ILP.ACH_Deposit_ILP(SSN, FileName, 0);
				// Apportions_List.Apportions_List(SSN, FileName, 3);
				Deposit_Record_Verification.Deposit_Record_Verification(SSN, FileName);

			}
		}

	}

	@Test(priority = 83, groups = "leela_OH_ILP_Prod") // Leela

	public void LonI_IstInstPayment_ACTM_ACHRevoke_2ndInstDeposit_Verify_Record() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LonI_IstInstPayment_ACTM_ACHRevoke_2ndInstDeposit_Verify_Record_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OH_ILP_path_leela") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OH_ILP_leela");
				UserName = prop.getProperty("UserName_OH_ILP_leela");
				Password = prop.getProperty("Password_OH_ILP_leela");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_OH_ILP_leela");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:105" + "_" + PayFrequency + "_" + CollateralType,
						"Loan_age the store date to after rescind period_select payment option from CSR dropdown_Payment screen should show the follwing options  1.Pay Off the balance 2.Pay Installment Am t 3.Pay any other Amt>select pay any other amt_enter Payment amount less than 1# amount");

				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_ILP_Prod(SSN, FileName, "200");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				Payment_Inst_Amount.Payment_Inst_Amount(SSN, FileName, 2);
				// Apportions_List.Apportions_List(SSN, FileName, 2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				ACHRevoke.ACHRevoke(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				EODProcessing_with_recordsChecking.EODProcessing_with_recordsChecking(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

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

	@AfterMethod(alwaysRun = true)
	//@AfterTest(alwaysRun = true)
	public void tearDown() {
		// Ending Test
		//driver.quit();
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
