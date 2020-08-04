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

public class AA_TN_LOC extends AA_LOC {

	// Revathi scenarios

	//@Test(priority = 0, groups = "revathi_TN_LOC")

	public void Loan_draw_statment_draw_DLQ_statment() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_statment_Deliquent_statement_Txn_Testdata.xls";
		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") +
		// FileName);
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:01" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash =>Draw =>Stmnt =>Draw 2 => Draw 3=> EOD on Due Date =>DLQ =>Stmnt2");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				DrawLoan.DrawLoan(SSN, FileName, "350");
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				StatementGeneration_2.StatementGeneration_2(SSN, FileName);
			}
		}
	}

	//@Test(priority = 1, groups = "revathi_TN_LOC")

	public void Loan_statement_Draw_DLQ_Cure_MinPayment_Draw_statment() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_statment_Draw_Deliquent_Cure_MinPayment_Draw_statement_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:02" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash => Stmnt1 =>  Draw 1  on due date => DLQ =>Cure =>Payment of Min Pmnt Amnt => Draw => Stmnt2");
				// test = reports.startTest("Scenario-NO_1"+Header, "LOCI Cash
				// =>Draw =>Stmnt =>Draw 2 => Draw 3=> EOD on Due Date =>DLQ
				// =>Stmnt2");

				// StatementGeneration.StatementGeneration(SSN, FileName);
				// AgeStore.AgeStore(SSN,FileName);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				PayOffLoan.PayOffLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				StatementGeneration.StatementGeneration(SSN, FileName);
				// StatementGeneration_.StatementGeneration_2(SSN, FileName);

			}
		}

	}

	//@Test(priority = 2, groups = "revathi_TN_LOC")

	public void Loan_Draw_statement_VoidDraw_EOD__Draw_statment() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_VoidDraw_EOD_Draw_statement_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:03" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash => Draw On stmnt date => Void Draw => `RUN EOD No deposits should be posted => Draw =>Stmnt2");
				// test = reports.startTest("Scenario-NO_1"+Header, "LOCI Cash
				// =>Draw =>Stmnt =>Draw 2 => Draw 3=> EOD on Due Date =>DLQ
				// =>Stmnt2");

				// StatementGeneration.StatementGeneration(SSN, FileName);
				// AgeStore.AgeStore(SSN,FileName);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				Agestore_StatementGeneration.Agestore_StatementGeneration(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				Void.Void(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				StatementGeneration.StatementGeneration(SSN, FileName);
			}
		}
	}

	//@Test(priority = 3, groups = "revathi_TN_LOC") //wrong scenario

	public void Loan_Draw1_Draw2ACH_statement_Rescind_Draw_EOD_DLQ() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_Draw_statment_Rescind_Draw_EOD_DLQ_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:04" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash => Draw 1 => Draw 2 ACH => Stmnt => Rescind => Draw => EOD On Due Date => DLQ ");
				// test = reports.startTest("Scenario-NO_1"+Header, "LOCI Cash
				// =>Draw =>Stmnt =>Draw 2 => Draw 3=> EOD on Due Date =>DLQ
				// =>Stmnt2");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				DrawLoanwithACH.DrawLoanwithACH(SSN, FileName);
				StatementGeneration_2.StatementGeneration_2(SSN, FileName);
				Rescind.Rescind(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);

			}
		}
	}

	//@Test(priority = 4, groups = "revathi_TN_LOC")//wrong scenario

	public void Loan_Draw_statement_Draw_Void_Rescind() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_Draw_Void_Rescind_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:05" + "_" + PayFrequency + "_" + CollateralType,
						"LOC I Cash =>Draw => Stmnt => Draw 2 =>Void Draw =>Rescind Draw 1");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				Void.Void(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				Rescind.Rescind(SSN, FileName);
			}
		}
	}

	//@Test(priority = 5, groups = "revathi_TN_LOC")

	public void Loan_Draw_PartialPMT_MinPayment_EOD() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_PartialPayment_MinPayment_EOD_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:06" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash => Draw => Stmnt => Pmnt Partial => Pmnt Min Payment => EOD on Due Date  ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				PartialPayment.PartialPayment(SSN, FileName);
				Payments.Payments(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
			}
		}
	}

	//@Test(priority = 6, groups = "revathi_TN_LOC")

	public void Loan_Draw_statement_Partialpayment_EOD_DLQ_Cure_Default() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_PartialPayment_EOD_DLQ_Cure_Default_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:07" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash => Draw => Stmnt => Pmnt Partial => EOD on Due Date  =>DLQ =>Cure =>Def");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				PartialPayment.PartialPayment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 7, groups = "revathi_TN_LOC")

	public void Loan_Draw_statement_PartialPayment_EOD_DLQ_MinPayment_LoanCurrent_Draw() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_PartialPayment_EOD_DLQ_MinPayment_Loancurrent_Draw_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:08" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash => Draw => Stmnt => Pmnt Partial => EOD on Due Date  =>DLQ =>Paymnt MinPayment Amount =>Loan in CURRENT => Draw ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				PartialPayment.PartialPayment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				Payments.Payments(SSN, FileName);
				PaymentStatus.PaymentStatus(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");

			}
		}

	}

	//@Test(priority = 8, groups = "revathi_TN_LOC")

	public void Loan_Draw_statement_Draw_MinPayment_EOD_PartialPayment_statement_Draw() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_Draw_MinPayment_EOD_PartialPayment_statement_Draw_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:09" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash => Draw => Stmnt => Draw => Pmnt Min Pmnt Amnt =>EOD on Due Date => Pmnt Partial =>Stmnt =>Draw");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "150");
				StatementGeneration.StatementGeneration(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				AgeStore.AgeStore(SSN, FileName, 0);
				MinPayment.MinPayment(SSN, FileName);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				PartialPayment.PartialPayment(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
			}
		}

	}

	//@Test(priority = 9, groups = "revathi_TN_LOC")

	public void Loan_Draw_statment_MinPayment_Void_DLQ_Cure_Default() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_MinPayment_Void_DLQ_Cure_Default_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:10" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash =>Draw =>Stmnt => Pmnt Min Payment =>On Due Date Void Pmnt => DLQ =>Cure=>DEF");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "150");
				StatementGeneration.StatementGeneration(SSN, FileName);
				Payments.Payments(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 10, groups = "revathi_TN_LOC")

	public void LOCICash_Draw_Draw2_MakePmt_Stmnt_PmtRTN_EODduedate_DLQ() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCICash_Draw_Draw2_MakePmt_Stmnt_PmtRTN_EODduedate_DLQ_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:15_" + PayFrequency + "_" + CollateralType,
						"LOC I Cash _Draw _ Draw 2 _ Make Pmnt _Stmnt _ Payment Return _ EOD on Due Date _DLQ");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				DrawLoan.DrawLoan(SSN, FileName, "50");
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 5);
				Payments.Payments(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				//EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
				Void_Payment.Void_Payment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);

			}
		}
	}

	/*
	 * //-----////@Test (priority=11,groups = "revathi_TN_LOC")
	 * 
	 * public void LOCICash_Draw_Draw2_Stmnt_Payoff_EODDueDate_() throws
	 * Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCICash_Draw_Draw2_Stmnt_Payoff_EODDueDate_Txn_Testdata.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row);
	 * 
	 * String CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; //System.out.println(SSN); test =
	 * reports.startTest(Header+"_S.No:16_"+PayFrequency+"_"+CollateralType,
	 * "LOC I Cash _Draw _ Draw 2 _Stmnt _ Payoff_EOD On Due Date");
	 * Assert.assertTrue(true);
	 * 
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN, FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350"); DrawLoan.DrawLoan(SSN,
	 * FileName,"50"); StatementGeneration.StatementGeneration(SSN, FileName);
	 * PayOffLoan.PayOffLoan(SSN, FileName); AgeStore.AgeStore(SSN, FileName,
	 * 0); DrawerDeassign.DrawerDeassign(SSN, FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * 
	 * 
	 * } } }
	 */
	//@Test (priority=12,groups = "revathi_TN_LOC")

	public void LOCICash_Draw_Stmnt_Payoff_PayoffVoidDueDate_DLQ_Cure_Payoff_Closure_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCICash_Draw_Stmnt_Payoff_PayoffVoidDueDate_DLQ_Cure_Payoff_Closure_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:17_" + PayFrequency + "_" + CollateralType,
						"LOC I Cash_ Draw _Stmnt _Payoff _ On Due date Void Payoff _ DLQ _ Cure _ Payoff _ Line Closure");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -4);
				PayOffLoan.PayOffLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				PayOffLoan.PayOffLoan(SSN, FileName);
				Closure.Closure(SSN, FileName);

			}
		}
	}

	//@Test (priority=13,groups = "revathi_TN_LOC")

	public void LOCICash_Draw_Stmnt_PartialPmt_PayoffDueDate_Payoffvoid_DLQ_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCICash_Draw_Stmnt_PartialPmt_PayoffDueDate_Payoffvoid_DLQ_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:18_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash _ Draw _Stmnt _ Pmnt Partial _ On Due Date Payoff _ Void Payoff _DLQ");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -4);
				LoanPartialPayment.LoanPartialPayment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				PayOffLoan.PayOffLoan(SSN, FileName);
				Void_Payoff.Void_Payoff(SSN, FileName);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);

			}
		}
	}

	/*
	 * //------------////@Test (priority=14,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCICash_Draw_Stmnt_Payoff_Draw_EODDueDate_Stmnt_Payoff_PayOffVoidDueDate_DLQ_
	 * () throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCICash_Draw_Stmnt_Payoff_Draw_EODDueDate_Stmnt_Payoff_PayOffVoidDueDate_DLQ_Txn_Testdata.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row);
	 * 
	 * String CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; //System.out.println(SSN); test =
	 * reports.startTest(Header+"_S.No:19_"+PayFrequency+"_"+CollateralType,
	 * "LOCI Cash _ Draw _ Stmnt _ Payoff _ Draw _ RUN EOD On Due Date _ Stmnt _ Payoff _ On Due Date Void Payoff_DLQ"
	 * ); Assert.assertTrue(true);
	 * 
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN, FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -4); PayOffLoan.PayOffLoan(SSN,
	 * FileName); DrawLoan.DrawLoan(SSN, FileName,"50"); AgeStore.AgeStore(SSN,
	 * FileName, 0); DrawerDeassign.DrawerDeassign(SSN, FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * PayOffLoan.PayOffLoan(SSN, FileName); AgeStore.AgeStore(SSN, FileName,
	 * 0); EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
	 * DrawerDeassign.DrawerDeassign(SSN, FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
	 * 
	 * 
	 * } } }
	 */

	//@Test (priority=15,groups = "revathi_TN_LOC1") issue

	public void LOCICash_Draw_Stmnt_EODDueDate_DLQ_CURE_Payoff_Draw_Stmnt_Pmnt_EOD_DLQ_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCICash_Draw_Stmnt_EODDueDate_DLQ_CURE_Payoff_Draw_Stmnt_Pmnt_EOD_DLQ_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:22_" + PayFrequency + "_" + CollateralType,
						"LOC I Cash _ Draw _ Stmnt _ RUN EOD on Due Date _DLQ _ CURE _Payoff _ Draw _Stmnt _ Make Pmnt _ RUN EOD_DLQ");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				
				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				//DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				PayOffLoan.PayOffLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				StatementGeneration.StatementGeneration(SSN, FileName);
				Payments.Payments(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus1.DeliquentPaymentStatus1(SSN, FileName);
			}
		}
	}

	/*
	 * //----////@Test (priority=16,groups = "revathi_TN_LOC")
	 * 
	 * public void LOCICash_Draw_Stmnt_EOD_DLQ_CURE_DEF_DFPPartial_DFPFull_()
	 * throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCICash_Draw_Stmnt_EOD_DLQ_CURE_DEF_DFPPartial_DFPFull_Txn_Testdata.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row);
	 * 
	 * String CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; //System.out.println(SSN); test =
	 * reports.startTest(Header+"_S.No:25_"+PayFrequency+"_"+CollateralType,
	 * "LOCI Cash _Draw _Stmnt _ EOD On Due Date _DLQ _ CURE _DEF _DFP Partial _ DFP Full"
	 * ); Assert.assertTrue(true);
	 * 
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN, FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 0); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 10); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * CurePaymentStatus.CurePaymentStatus(SSN, FileName);
	 * CustomerDefault.CustomerDefault(SSN, FileName);
	 * DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
	 * Default_PartialPayment.Default_PartialPayment(SSN, FileName);
	 * Default_Payment.Default_Payment(SSN, FileName);
	 * DefaultPaymentStatus.DefaultPaymentStatus1(SSN, FileName); } } }
	 */

	//@Test (priority=17,groups = "revathi_TN_LOC")

	public void LOCICash_Draw_Stmnt_EOD_DLQ_CURE_DEF_PartialDFP_DFPFull_VoidDFP_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCICash_Draw_Stmnt_EOD_DLQ_CURE_DEF_PartialDFP_DFPFull_VoidDFP_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:26_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash _Draw _Stmnt _ EOD On Due Date _DLQ _ CURE _DEF _DFP Partial _ DFP Full _Void DFP");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_PartialPayment.Default_PartialPayment(SSN, FileName);
				Default_Payment.Default_Payment(SSN, FileName);
				DefaultPayment_Void.DefaultPayment_Void(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);

			}
		}
	}

	/*
	 * //----////@Test (priority=18,groups = "revathi_TN_LOC")
	 * 
	 * public void LOCI_ACTM_Drawavailable_stmt() throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCI_ACTM_Drawshouldnotavailable_Statement_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:60"+"_"+PayFrequency+"_"+CollateralType,
	 * "LOC Initiation - active Military - Draw should be available - Statement"
	 * );
	 * 
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN, FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * Check_Draw.Check_Draw(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName); } } }
	 */
	//@Test (priority=19,groups = "revathi_TN_LOC")

	public void LOCI_Draw_ACTMSamedrawday_stmt() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_ACTMSamedrawday_stmt_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:61" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Initiation - Draw - active Military(same day) =>Statement");
				/*
				 * 
				 * Login.Login(UserName,Password,StoreId);
				 * 
				 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
				 * test,AppURL, SSN,FileName);
				 */

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);

				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 3); // changed
																		// this
																		// to
																		// AgeStore
																		// from
																		// Agestore
				DrawLoan.DrawLoan(SSN, FileName, "350");
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

			}
		}
	}

	//@Test (priority=20,groups = "revathi_TN_LOC1")//DLQ issue

	public void LOCI_ACTM_Drawshouldnotbeavailable_stmt_DLQ_CURE_DFLT_Sc62() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_ACTM_Drawshouldnotbeavailable_stmt_DLQ_CURE_DFLT_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:62" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Initiation - active Military - Draw - Statement - DLQ - CURE - Default");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				
				
				/*AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 35); // added extra
																	// parameter
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);*/
				
				
				
				
				
				
				
				
				
				
				
				

				
				/*DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
*/
			}
		}
	}

//@Test (priority=21,groups = "revathi_TN_LOC")

	public void LOCI_Draw_ACTM_stmt_ACTMEnd_Payoff_Clear() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Payoff_Clear_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:63" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Initiation - Draw -> active Military - Statement - Terminate active Military - Payoff =>Clear");
				/*
				 * 
				 * Login.Login(UserName,Password,StoreId);
				 * 
				 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
				 * test,AppURL, SSN,FileName);
				 */

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				Active_Military_End.Active_Military_End(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -3);
				PayOffLoan.PayOffLoan(SSN, FileName);

			}
		}
	}

	/*
	 * //----////@Test (priority=22,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_ACTM_stmt_Draw_ACTMEnd_PaymentwithCash_ACTM_ACTMEnd_Stmt_Sc64()
	 * throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCI_Draw_ACTM_stmt_Draw_ACTMEnd_PaymentwithCash_ACTM_ACTMEnd_Stmt_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:64"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation - Draw - Generate Statement - Active Military Start- Draw - Payment@store wd Cash - Draw - Active Military end - Payment - Generate Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 9);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -1); DrawLoan.DrawLoan(SSN,
	 * FileName,"350"); Active_Military_End.Active_Military_End(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 1); Payments.Payments(SSN, FileName);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 3);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName); } } }
	 */

	//@Test (priority=23,groups = "revathi_TN_LOC1")// No record returns

	public void LOCI_Draw_ACTM_stmt_ACTMEnd_Deposit_ACTM_PaymentwithCash_ACTMEnd_Stmt2_Sc64() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Deposit_ACTM_PaymentwithCash_ACTMEnd_Stmt2_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:65" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation -> Draw -> Active Military start -> Statement -> Active Military end -> Deposit -> Active Military start -> Payment@ Store CASH -> Active Military end -> Statement Generation");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				Active_Military_End.Active_Military_End(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 3);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 4);
				Payments.Payments(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 7);
				Active_Military_End.Active_Military_End(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
			}
		}
	}

	/*
	 * //----////@Test (priority=24,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_ACTM_ACTMEnd_stmt_ACTM_ACTMEnd_Stmt2_ACTM_ACTMEnd_Stmt3_Sc66()
	 * throws Exception {
	 * 
	 * // Start test. Mention test script name //
	 * AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Deposit_ACTM_PaymentwithCash_ACTMEnd_Stmt2_Txn_TestData
	 * String FileName=
	 * "AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Deposit_ACTM_ACTMEnd_Stmt2_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:66"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation -> Draw -> Active Military start -> Active Military end -> Statement -> Active Military start -> Active Military end -> Statement -> Active Military start -> Active Military end -> Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 5);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 1);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 5);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 1);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 5);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName); } } }
	 */
	/*
	 * //------////@Test (priority=25,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_ACTM_stmt_ACTMEnd_Draw_ACTM_WaiveFee_ACTMEnd_Stmt2_Sc67()
	 * throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Draw_ACTM_WaiveFee_ACTMEnd_Stmt2_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:67"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation -> Draw -> Active Military start -> Statement -> Active Military end -> Draw -> Active Military start -> Waive Fee -> Active Military end -> Statement Generation"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 2); DrawLoan.DrawLoan(SSN,
	 * FileName,"350"); AgeStore.AgeStore(SSN, FileName, 3);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 6); WaiveFee.WaiveFee(SSN, FileName);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * 
	 * 
	 * } } }
	 */

	//@Test (priority=26,groups = "revathi_TN_LOC")

	public void LOCI_ACTM_ACTMEnd_Stmt_ACMT_Draw_ACTMEnd_stmt2_Sc69() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_ACTM_ACTMEnd_Stmt_ACMT_Draw_ACTMEnd_stmt2_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:69" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation -> Active Military Start -> Active Military end -> Generate Statement ->Active Military Start -> Draw -> Active Military end-> Statement Generation ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				Active_Military_End.Active_Military_End(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -7);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -6);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				AgeStore.AgeStore(SSN, FileName, 0);
				Active_Military_End.Active_Military_End(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

			}
		}
	}

	//@Test (priority=27,groups = "revathi_TN_LOC1")//waive fee issue 12-12-2019  migration

	public void LOCI_ACTM_Draw_stmt_ACTMEnd_Draw_ACTM_WaiveFee_Pymtwithcash_ACTMEnd_Stmt2_Sc70() throws Exception {

		// Start test. Mention test script name
		String FileName = "LOCI_ACTM_Draw_stmt_ACTMEnd_Draw_ACTM_WaiveFee_Pymtwithcash_ACTMEnd_Stmt2_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:70" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation -> Active Military start -> Draw -> Statement -> Active Military end -> Draw -> Active Military start -> Waive Fee -> Payment @ Store Wd CASH -> Active Military end -> Statement Generation");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				Active_Military_End.Active_Military_End(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 1);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				AgeStore.AgeStore(SSN, FileName, 2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				WaiveFee.WaiveFee(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 4);
				Payments.Payments(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 6);
				Active_Military_End.Active_Military_End(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

			}
		}
	}

	/*
	 * //---////@Test (priority=28,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_ACTM_PayoffwithCash_ACTMEnd_stmt_Draw_ACTM_ACTMEnd_stmt2_ACTM_Pymt_ACTMEnd_stmt3_Sc71
	 * () throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCI_Draw_ACTM_PayoffwithCash_ACTMEnd_stmt_Draw_ACTM_ACTMEnd_stmt2_ACTM_Pymt_ACTMEnd_stmt3_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:71"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation - Draw - Active Military start - Payoff@ Store wd CASH - Active Military end - Statement - Draw - Active Military start - Active Military end - Statement - Active Military start - Payment @ Store wd CASH- Active Military end - Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 6);
	 * PayOffLoan.PayOffLoan(SSN, FileName);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 1); DrawLoan.DrawLoan(SSN,
	 * FileName,"50"); AgeStore.AgeStore(SSN, FileName, 3);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 5);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -3);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 2); Payments.Payments(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 4);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * 
	 * } } }
	 */

	//@Test (priority=29,groups = "revathi_TN_LOC")

	public void LOCI_Draw_ACTM_stmt_ACTMEnd_Payoff_ACMT_VoidPayoff_ACTMEnd_stmt2_Sc72() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Payoff_ACMT_VoidPayoff_ACTMEnd_stmt2_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:72" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation -> Draw -> Active Military start -> Statement -> Active Military end -> Payoff ->Active Military start -> Payoff Void -> Active Military end -> Statement Generation");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 8);
				Active_Military_End.Active_Military_End(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				PayOffLoan.PayOffLoan(SSN, FileName);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				Void_Payoff.Void_Payoff(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 4);
				Active_Military_End.Active_Military_End(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

			}
		}
	}

	@Test (priority=30,groups = "revathi_TN_LOC1")

	public void LOCI_Draw_ACTM_stmt_ACTMEnd_Deposit_Return_Payment_ACTM_PaymentVoid_ACTMEnd_Stmt_Sc73()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Deposit_Return_Payment_ACTM_PaymentVoid_ACTMEnd_Stmt_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:73" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation -> Draw -> Active Military start -> Statement -> Active Military end -> Deposit -> Return -> Payment -> Active Military start -> Payment Void -> Active Military end -> Statement Generation");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -3);
				Active_Military_End.Active_Military_End(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 3);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 4);
				Payments.Payments(SSN, FileName);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				Void_PartialPayment.Void_PartialPayment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				Active_Military_End.Active_Military_End(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

			}
		}
	}

	//@Test (priority=31,groups = "revathi_TN_LOC")

	public void LOCI_Draw_ACTM_Payoffwithcash_STMT_Sc74() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_ACTM_Payoffwithcash_STMT_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:74" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation -> Draw -> Active Military start -> Payoff @store wd CASH -> Generate Statement");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 6);
				PayOffLoan.PayOffLoan(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

			}
		}
	}

	//@Test (priority=32,groups = "revathi_TN_LOC")

	public void LOCI_Draw_Stmt_ACTM_Payoff_STMT2_Sc75() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_ACTM_Payoff_STMT2_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:75" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation -> Draw -> Generate Statement -> Active Military -> Payoff -> Generate Statement");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -3);
				PayOffLoan.PayOffLoan(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

			}
		}
	}

	/*
	 * //----////@Test (priority=33,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * Loan_Draw_GenerateStatement_ACHDepositFlight_ActiveMilaitary_PaymentWDcash_ActiveMiltaryEnd_GenerateStatement
	 * () throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_Loan_Draw_GenerateStatement_ACHDepositFlight_ActiveMilaitary_PaymentWDcash_ActiveMiltaryEnd_GenerateStatement_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; //System.out.println(SSN); test =
	 * reports.startTest(Header+"_S.No:76"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation_Draw_Generate Statement_ACH Deposit in Flight_Active Military Start_Payment @ Store wd CASH_Active Military end_Generate Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN, FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -1); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName); NACHA.NACHA(SSN,
	 * FileName, 0); ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
	 * ACHReturnPosting.ACHReturnPosting(SSN, FileName);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 3); Payments.Payments(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 3);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName); } } }
	 */

	@Test (priority=34,groups = "revathi_TN_LOC")

	public void LOCI_Draw_Stmt_DLQ_CURE_Default_Writeoff_RCCSchedule_1stinstallmentPaid_ActiveMiltary_RccPlacementshouldStop()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_DLQ_CURE_Default_Writeoff_RCCSchedule_1stinstallmentPaid_ActiveMiltary_RccPlacementshouldStop_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				// driver.get(appUrl);
				// test.log(LogStatus.INFO, "Application is launched");
				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:77" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation_Draw_Generate Statement_DLQ_Cure_Default_Write off_RCC Enabled and Schedule generated_One instalment paid_Active Military_RCC Placements should stop");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				WO_Recovery_pymt_BeforeDueDate_4thInst.WO_Recovery_pymt_BeforeDueDate_4thInst(SSN, FileName, 0, 2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test (priority=35,groups = "revathi_TN_LOC2")

	public void Loanintialitation_Draw_Generatestatement_DLQ_CURE_Default_Activemiltary_PaymentPlan_writeoff()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loanintialitation_Draw_Generatestatement_DLQ_CURE_Default_Activemiltary_PaymentPlan_writeoff_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:78" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation_Draw_Generate Statement_DLQ _Cure_Default_Active Military_Payment Plan_Write off");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				PaymentPlan.PaymentPlan(SSN, FileName);
				CustomerDefault_WO.CustomerDefault_WO(SSN, FileName, 35);
				Default_WOProc_60days.Default_WOProc_60days(SSN, FileName);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);

			}
		}

	}

	/*
	 * //----//@Test (priority=36,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LoanInition_Draw_Generatestatement_DLQ_Cure_ActiveMilitary_GenerateStatement
	 * () throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LoanInition_Draw_Generatestatement_DLQ_Cure_ActiveMilitary_GenerateStatementTestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; //System.out.println(SSN); test =
	 * reports.startTest(Header+"_S.No:79"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation_Draw_Generate Statement_DLQ_Cure_Active Military_Generate Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN, FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 0); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 10); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * CurePaymentStatus.CurePaymentStatus(SSN, FileName);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * 
	 * 
	 * } }
	 * 
	 * 
	 * }
	 */
	/*
	 * //----//@Test (priority=37,groups = "revathi_TN_LOC")
	 * 
	 * public void Loan_Draw_Stmt__DLQ_Cure_ActMlty_Stmt_DFLT_Writeoff_() throws
	 * Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_Loan_Draw_Stmt__DLQ_Cure_ActMlty_Stmt_DFLT_Writeoff_Txn_Testdata.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row);
	 * 
	 * String CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; //System.out.println(SSN); test =
	 * reports.startTest(Header+"_S.No:80_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation _ Draw _ Generate Statement _ DLQ _ Cure _ Active Military _ Generate Statement _ Default _ Write off"
	 * ); Assert.assertTrue(true);
	 * 
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 0); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 10); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * CurePaymentStatus.CurePaymentStatus(SSN, FileName);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * CustomerDefault.CustomerDefault(SSN, FileName);
	 * DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
	 * Default_WOProc.Default_WOProc(SSN, FileName);
	 * WOPaymentStatus.WOPaymentStatus(SSN, FileName);
	 * 
	 * 
	 * 
	 * } } }
	 * 
	 */

	/*
	 * //----//@Test (priority=38,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * Loan_Draw_Stmt_DLQ_Cure_Default_EnableRCC_ScdlGenerate_OneInstPay_ActMlty_RCCPlacementsStop_
	 * () throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_Loan_Draw_Stmt_DLQ_Cure_Default_EnableRCC_ScdlGenerate_OneInstPay_ActMlty_RCCPlacementsStop_Txn_Testdata.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; //System.out.println(SSN); test =
	 * reports.startTest(Header+"_S.No:81_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation _ Draw _ Generate Statement _ DLQ _ Cure _ Default _ RCC Enabled and Schedule generated _ One instalment paid _ Active Military _ RCC Placements should stop"
	 * ); Assert.assertTrue(true);
	 * 
	 * 
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -1); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName); NACHA.NACHA(SSN,
	 * FileName, -1); ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
	 * ACHReturnPosting.ACHReturnPosting(SSN, FileName);
	 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 10); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * CurePaymentStatus.CurePaymentStatus(SSN, FileName);
	 * CustomerDefault.CustomerDefault(SSN, FileName);
	 * DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
	 * EditBorrower1.EditBorrower1(SSN, FileName);
	 * RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN,
	 * FileName,-1,2); DrawerDeassign.DrawerDeassign(SSN, FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
	 * LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
	 * RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN,
	 * FileName,10,2); Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * RCCSchduleStatus_ActiveMilitary.RCCSchduleStatus_ActiveMilitary(SSN,
	 * FileName);
	 * 
	 * } } }
	 * 
	 */

	//@Test (priority=39,groups = "revathi_TN_LOC")

	public void LoanInitiation_Draw_GenerateStatement_DLQ_CURE_Default_Writeoff_Activemilitary_PaymentPlan()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LoanInitiation_Draw_GenerateStatement_DLQ_CURE_Default_Writeoff_Activemilitary_PaymentPlan_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:82" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation_Draw_ Generate Statement_DLQ_Cure_Default_Write off _Active Military_Payment Plan");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 35); // added extra
																	// parameter
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				PaymentPlan.PaymentPlan(SSN, FileName);

			}
		}

	}

	@Test (priority=40,groups = "revathi_TN_LOC")

	public void Loanintillation_Draw_Generatestatement_Payoff_ActiveMilatary_payoffvoid_Activemilataryend_payment_GenerateStatement()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loanintillation_Draw_Generatestatement_Payoff_ActiveMilatary_payoffvoid_Activemilataryend_payment_GenerateStatement_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:83" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation_Draw_Generate Statement_Payoff_Active Military Start_Payoff Void_Active Military end_Payment_Generate Statement");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				PayOffLoan.PayOffLoan(SSN, FileName);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				Void.Void(SSN, FileName);
				Active_Military_End.Active_Military_End(SSN, FileName);
				Payments.Payments(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
			}
		}

	}

	/*
	 * //----//@Test (priority=41,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * Loaninitiation_Draw_Payment_Activemiltaray_Draw_Generatestatement_Waivefee_ActivemilataryEnd_Payment_GenerateStatement
	 * () throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_Loaninitiation_Draw_Payment_Activemiltaray_Draw_Generatestatement_Waivefee_ActivemilataryEnd_Payment_GenerateStatement_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; //System.out.println(SSN); test =
	 * reports.startTest(Header+"_S.No:85"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation_Draw_Payment_Active Military Start_Draw_Generate Statement_Waive Fee_Active Military end_Payment_Generate Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 3);
	 * Payments.Payments(SSN, FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 4);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * WaiveFee.WaiveFee(SSN, FileName); AgeStore.AgeStore(SSN, FileName, 0);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 4); Payments.Payments(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * 
	 * 
	 * 
	 * 
	 * } }
	 * 
	 * 
	 * }
	 */
	/*
	 * //---//@Test (priority=42,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_ACTM_stmt_Draw_ACTMEnd_PaymentwithCash_ACTM_ACTMEnd_Stmt2_Sc86(
	 * ) throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCI_Draw_ACTM_stmt_Draw_ACTMEnd_PaymentwithCash_ACTM_ACTMEnd_Stmt2_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:86"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation -> Draw -> Generate Statement -> Active Military Start-> Draw -> Payment@store wd Cash -> Draw -> Active Military end -> Payment  -> Generate Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 9);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -1); DrawLoan.DrawLoan(SSN,
	 * FileName,"50"); AgeStore.AgeStore(SSN, FileName, 1);
	 * Payments.Payments(SSN, FileName); DrawLoan.DrawLoan(SSN, FileName,"50");
	 * AgeStore.AgeStore(SSN, FileName, 3);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * Payments.Payments(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName); } } }
	 */
	/*
	 * //-----//@Test (priority=43,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * Loan_Draw_StGn_Draw_Deposit_Activemillatrystart_RTN_Activemillitryend_StGn
	 * () throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_Loan_Draw_StGn_Draw_ACHDeposit_StartActiveMillatry_RTN_ActivemillartyEnd_StGn_Txn_Testdata.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String Header = StateID+ "_" +
	 * ProductID; //System.out.println(SSN); test =
	 * reports.startTest(Header+"_S.No:87"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation -> Draw -> Generate Statement -> Draw ->  Deposit -Active Military Start-> Return-> Active Military end -> Generate Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN, FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350"); AgeStore.AgeStore(SSN, FileName,
	 * -1); DrawerDeassign.DrawerDeassign(SSN, FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName); NACHA.NACHA(SSN,
	 * FileName, -1); ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * ACHReturnPosting.ACHReturnPosting(SSN, FileName);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * 
	 * 
	 * } }
	 * 
	 * 
	 * }
	 */
	@Test (priority=44,groups = "revathi_TN_LOC")

	public void LOCI_ACTM_Draw_stmt_Pymtlessminpayamt_Draw_Pymt_VoidPymt_Draw_ACTMEnd_stmt2_Sc88() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_Pymtlessminpayamt_ACTM_Draw_DrawVoid_Draw_ACTMEnd_stmt2_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:88" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation -> Active Military Start -> Draw -> Generate Statement -> Payment less than Min Payment Amount @ store -> Draw -> Payment@store -> Payment Void -> Draw -> Active Military end -> Draw -> Generate Statement");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan.DrawLoan(SSN, FileName, "150");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 11);
				Payments_Lessthan_Min_Payment_Amount.Payments_Lessthan_Min_Payment_Amount(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 12);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				AgeStore.AgeStore(SSN, FileName, -4);
				Payments.Payments(SSN, FileName); // Payments1 changed
				Void_PartialPayment.Void_PartialPayment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -3);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				AgeStore.AgeStore(SSN, FileName, -2);
				Active_Military_End.Active_Military_End(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				;
				StatementGeneration.StatementGeneration(SSN, FileName);

			}
		}
	}

	/*
	 * //-----//@Test (priority=45,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_stmt_Pymtlessminpayamt_ACTM_Draw_DrawVoid_Draw_ACTMEnd_stmt2_Sc90
	 * () throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCI_Draw_stmt_Pymtlessminpayamt_ACTM_Draw_DrawVoid_Draw_ACTMEnd_stmt2__Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:90"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation -> Draw -> Generate Statement -> Payment less than Min Payment Amount -> Active Military Start-> Draw -> Draw Void -> Draw -> Active Military end -> Generate Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 7);
	 * Payments_Lessthan_Min_Payment_Amount.Payments_Lessthan_Min_Payment_Amount
	 * (SSN, FileName); AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 8);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 9);
	 * DrawLoan.DrawLoan(SSN, FileName,"50"); VoidDrawLoan.VoidDrawLoan(SSN,
	 * FileName); AgeStore.AgeStore(SSN,FileName, 0); DrawLoan.DrawLoan(SSN,
	 * FileName,"50"); AgeStore.AgeStore(SSN,FileName, 2);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName); } } }
	 */

	/*
	 * //-----//@Test (priority=46,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_stmt_ACTM_DLQ_Payment_Draw_ACTMEnd_Draw_stmt2_Sc91() throws
	 * Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCI_Draw_stmt_ACTM_DLQ_Payment_Draw_ACTMEnd_Draw_stmt2_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:91"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation -> Draw -> Generate Statement -> Active Military Start -> Delinquent -> Payment -> Draw -> Active Military end -> Draw -> Generate Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -5);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, 0); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 2); Payments.Payments(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 3); DrawLoan.DrawLoan(SSN,
	 * FileName,"50"); AgeStore.AgeStore(SSN, FileName, 5);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 7); DrawLoan.DrawLoan(SSN,
	 * FileName,"50"); StatementGeneration.StatementGeneration(SSN, FileName);
	 * 
	 * } } }
	 * 
	 */
	@Test (priority=47,groups = "revathi_TN_LOC")

	public void LOCI_Draw_Stmt_ACTM_DLQ_CURE_Payment_VoidPymt_Pymt_Draw_ACTMEnd_Draw_Payment_stmt2_Sc92()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_ACTM_DLQ_CURE_Payment_VoidPymt_Pymt_Draw_ACTMEnd_Draw_Payment_stmt2_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:92" + "_" + PayFrequency + "_" + CollateralType,
						"Loan Initiation -> Draw -> Generate Statement -> Active Military Start -> Delinquent -> Cure -> Payment -> Payment Void -> Payment -> Draw -> Active Military end -> Draw -> Payment -> Generate Statement");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -4);
				Payments.Payments(SSN, FileName);
				Void_PartialPayment.Void_PartialPayment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -3);
				Payments.Payments(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				Active_Military_End.Active_Military_End(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				AgeStore.AgeStore(SSN, FileName, 2);
				Payments_Partial.Payments_Partial(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

			}
		}
	}

	/*
	 * //----//@Test (priority=48,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_Stmt_DLQ_CURE_ACTM_Payment_Stmt2_Draw_Payment_stmt3_ACTMEnd_Sc93
	 * () throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCI_Draw_Stmt_DLQ_CURE_ACTM_Payment_Stmt2_Draw_Payment_stmt3_ACTMEnd_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:93"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation -> Draw -> Generate Statement -> Delinquent -> Cure -> Active Military Start -> Payment -> Generate Statement -> Draw -> Payment -> Generate Statement -> Active Military end"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, 0); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, 10); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * CurePaymentStatus.CurePaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, 1);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, 2); Payments.Payments(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, -3); DrawLoan.DrawLoan(SSN,
	 * FileName,"50"); AgeStore.AgeStore(SSN,FileName, -1);
	 * Payments.Payments(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, 0);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * 
	 * 
	 * 
	 * } } }
	 * 
	 */

	/*
	 * //----//@Test (priority=49,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_Stmt_ACTM_Payment_Payoff_Payoffvoid_ACTMEnd_Payment_Stmt2_Sc94(
	 * ) throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "LOCI_Draw_Stmt_ACTM_Payment_Payoff_Payoffvoid_ACTMEnd_Payment_Stmt2_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:94"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation -> Draw -> Generate Statement -> Active Military Start-> Payment -> Payoff -> Payoff Void -> Active Military end -> Payment  -> Generate Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -4);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -2); Payments.Payments(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 0); PayOffLoan.PayOffLoan(SSN,
	 * FileName); PayOff_Void.PayOff_Void(SSN, FileName); AgeStore.AgeStore(SSN,
	 * FileName, 3); Active_Military_End.Active_Military_End(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 5); Payments.Payments(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } } }
	 */
	/*
	 * //-----//@Test (priority=50,groups = "revathi_TN_LOC")
	 * 
	 * public void LOCI_Draw_Payment_ACTM_Draw_Stmt_ACTMEnd_Payment_Stmt2_Sc95()
	 * throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "LOCI_Draw_Payment_ACTM_Draw_Stmt_ACTMEnd_Payment_Stmt2_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:95"+"_"+PayFrequency+"_"+CollateralType,
	 * "Loan Initiation -> Draw -> Payment -> Active Military Start -> Draw -> Generate Statement -> Active Military end -> Payment -> Generate Statement"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
	 * Payments.Payments(SSN, FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 3);
	 * Active_Military_Start.Active_Military_Start(SSN, FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 4);
	 * DrawLoan.DrawLoan(SSN, FileName,"50");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -2);
	 * Active_Military_End.Active_Military_End(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 0); Payments.Payments(SSN, FileName);
	 * StatementGeneration.StatementGeneration(SSN, FileName); } } }
	 */
	/*
	 * //----//@Test (priority=51,groups = "revathi_TN_LOC")
	 * 
	 * public void LOCI_Draw_PNBK_Drawnotavailble() throws Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOC_Draw_PBNK_Drawnot_Txn_Testdata.xls"; TestData = new
	 * Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * //int lastrow=TestData.getLastRow("Borrower");
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) {
	 * //driver.get(appUrl); //test.log(LogStatus.INFO,
	 * "Application is launched"); //driver.manage().window().maximize(); AppURL
	 * = prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String Header = StateID+ "_" +
	 * ProductID; String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row);
	 * 
	 * test =
	 * reports.startTest(Header+"_S.No:96"+"_"+PayFrequency+"_"+CollateralType,
	 * "LOCI =>Draw =>Pending Bankruptcy =>Draw not availble");
	 * 
	 * Assert.assertTrue(true);
	 * 
	 * 
	 * Login.Login(UserName, Password, StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN, FileName);
	 * DrawLoan.DrawLoan(SSN, FileName,"350"); PendingBNK.PendingBNK(SSN,
	 * FileName); DrawStatust.DrawStatust(SSN, FileName);
	 * 
	 * } }
	 * 
	 * 
	 * }
	 */

	@Test (priority=52,groups = "revathi_TN_LOC")

	public void LOCI_Draw_PNBK_VoidPNBK_Drawavailable() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_Draw_PBNK_VoidPBNK_DrawAvailable_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:97" + "_" + PayFrequency + "_" + CollateralType,
						" LOCI =>Draw =>Pending Bankruptcy =>Draw not availble =.> Void PBNK =>Draw Available");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				PendingBNK.PendingBNK(SSN, FileName);
				PendingBNK_Void.PendingBNK_Void(SSN, FileName);
				DrawStatus_PNBK.DrawStatus_PNBK(SSN, FileName);

			}
		}

	}

	@Test (priority=53,groups = "revathi_TN_LOC")

	public void LOCI_Draw_PNBK_Drawnotavailble_VoidDraw() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_Draw_PBNK_Drawnot__Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:98" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>Pending Bankruptcy =>Draw not availble=>Void of Past Draw");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				PendingBNK.PendingBNK(SSN, FileName);
				DrawStatust.DrawStatust(SSN, FileName);
				VoidDrawLoan.VoidDrawLoan(SSN, FileName);

			}
		}
		// Login.Login("CSR353","1234","353");

	}

	//@Test (priority=54,groups = "revathi_TN_LOC")
	public void LOCI_Draw_Statement_Draw_PBNK_Drawnotavailable() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_Draw_Statment_Draw_PBNK_DrawnotAvailable_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:99" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>Statement =>Draw => PBNK=> Draw not available");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				PendingBNK.PendingBNK(SSN, FileName);
				DrawStatust.DrawStatust(SSN, FileName);
			}
		}
		// Login.Login("CSR353","1234","353");

	}

	@Test (priority=55,groups = "revathi_TN_LOC")

	public void LOCI_Draw_Statement_Draw_PBNKbeforeduedate_NoDeposit() throws Exception {

		String FileName = "AA_LOC_Draw_Statement_Draw_PBNKbeforeDD_NoDeposit_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(
						Header + "Regression_Scenario.No_100" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI=> Draw =>Statement =>PBNK before due date => No Deposit presentment");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

			}

		}

	}

	@Test (priority=56,groups = "revathi_TN_LOC")

	public void LOCI_Draw_Statement_Draw_PBNKbeforeduedate_VoidPBNK_Deposit() throws Exception {

		String FileName = "AA_LOC_Draw_Statement_Draw_PBNKbeforeDD_VoidPBNK_YesDeposit_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(
						Header + "Regression_Scenario.No_101" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI=> Draw =>Statement =>PBNK before due date=>Void PBNK on due date => Deposit presentment");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				PendingBNK_Void.PendingBNK_Void(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

			}

		}

		// Login.Login("CSR353","1234","353");

	}

	@Test (priority=57,groups = "revathi_TN_LOC")
	public void LOCI_Draw_Statement_Draw_PBNKbeforeduedate_VoidPBNKAfterduedate_Deposit() throws Exception {

		String FileName = "AA_LOC_Draw_Statement_Draw_PBNKbeforeDD_VoidPBNKAfterDue_YesDeposit_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_TN_LOC_revathi");
				UserName = prop.getProperty("UserName_TN_LOC_revathi");
				Password = prop.getProperty("Password_TN_LOC_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_revathi");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(
						Header + "Regression_Scenario.No_102" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI=> Draw =>Statement =>PBNK before due date=>Void PBNK after due date => Deposit presentment");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 4);
				PendingBNK_Void.PendingBNK_Void(SSN, FileName);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

			}

		}

	}

	/*
	 * //----//@Test (priority=58,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_StopRPP_Sc103() throws
	 * Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_StopRPP_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:103"+"_"+PayFrequency+"_"+CollateralType,
	 * "LOCI=>Draw=>Statement =>Depsoit=>Rtn=>DLQ=>CURE=>DFLT=> PBNK=> Stop RPP"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -1); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName); NACHA.NACHA(SSN,
	 * FileName, -1); ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
	 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 3);
	 * ACHReturnPosting.ACHReturnPosting(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, 10); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * CurePaymentStatus.CurePaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, 30); CustomerDefault.CustomerDefault(SSN,
	 * FileName); DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
	 * PendingBNK.PendingBNK(SSN, FileName); Check_RPP.Check_RPP(SSN, FileName);
	 * 
	 * 
	 * } } }
	 */

	/*
	 * //----//@Test (priority=59,groups = "revathi_TN_LOC")
	 * 
	 * public void
	 * LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_StopRCC_Sc104() throws
	 * Exception {
	 * 
	 * // Start test. Mention test script name String FileName=
	 * "AA_LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_StopRCC_Txn_TestData.xls";
	 * TestData = new Excel(System.getProperty("user.dir") +
	 * prop.getProperty("AA_Store_Test_data_TN_LOC_path_revathi") + FileName);
	 * int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
	 * System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
	 * RunFlag = TestData.getCellData(sheetName,"Run",row);
	 * //System.out.println(RunFlag); if(RunFlag.equals("Y")) { AppURL =
	 * prop.getProperty("AppURL_TN_LOC_revathi"); UserName =
	 * prop.getProperty("UserName_TN_LOC_revathi"); Password =
	 * prop.getProperty("Password_TN_LOC_revathi"); //
	 * System.out.println(Password); StoreId =
	 * prop.getProperty("StoreID_TN_LOC_revathi"); String ProductID =
	 * TestData.getCellData(sheetName,"ProductID",row); String StateID =
	 * TestData.getCellData(sheetName,"StateID",row); String SSN =
	 * TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
	 * TestData.getCellData(sheetName,"Income_PayFrequency",row); String
	 * CollateralType =
	 * TestData.getCellData(sheetName,"ESign_CollateralType",row); String Header
	 * = StateID+ "_" + ProductID; test =
	 * reports.startTest(Header+"_S.No:104"+"_"+PayFrequency+"_"+CollateralType,
	 * "LOCI=>Draw=>Statement =>Depsoit=>Rtn=>DLQ=>CURE=>DFLT=> PBNK=> Stop RCC"
	 * );
	 * 
	 * 
	 * Login.Login(UserName,Password,StoreId);
	 * 
	 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
	 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
	 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
	 * DrawLoan.DrawLoan(SSN, FileName,"350");
	 * StatementGeneration.StatementGeneration(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, -1); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName); //EODProcessing.EODProcessing(SSN, FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName); NACHA.NACHA(SSN,
	 * FileName, -1); ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
	 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN, FileName, 3);
	 * ACHReturnPosting.ACHReturnPosting(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, 10); DrawerDeassign.DrawerDeassign(SSN,
	 * FileName);
	 * StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,
	 * FileName); StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,
	 * FileName); Drawerassign.Drawerassign(SSN, FileName);
	 * CurePaymentStatus.CurePaymentStatus(SSN, FileName);
	 * AgeStore.AgeStore(SSN,FileName, 30); CustomerDefault.CustomerDefault(SSN,
	 * FileName); DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
	 * PendingBNK.PendingBNK(SSN, FileName); RCCStatus.RCCStatus(SSN, FileName);
	 * 
	 * 
	 * } } }
	 */

	// Srikanth scenarios
	// //@Test (priority=60,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_RPP_VoidPBNK_RPP_Sc105() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_RPP_VoidPBNK_RPP_Txn_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++)

		{
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:105" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI=>Draw=>Statement =>Depsoit=>Rtn=>DLQ=>CURE=>DFLT=> PBNK=> RPP => void PBNK => RPP is not displayed");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan.DrawLoan(SSN, FileName, "100"); // added parameter
				/*
				 * StatementGeneration.StatementGeneration(SSN, FileName);
				 * AgeStore.AgeStore(SSN, FileName, -1);
				 * DrawerDeassign.DrawerDeassign(SSN, FileName);
				 * StatementGeneration_EODProcessing.
				 * StatementGeneration_EODProcessing(SSN, FileName);
				 * StoreInfo.StoreInfo(SSN, FileName);
				 * Safeassign.Safeassign(SSN, FileName);
				 * Drawerassign.Drawerassign(SSN, FileName); NACHA.NACHA(SSN,
				 * FileName, -1); ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				 */
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				ACHDeposit.ACHDeposit(SSN, FileName);

				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 3);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				Check_RPP.Check_RPP(SSN, FileName);
				PendingBNK_Void.PendingBNK_Void(SSN, FileName);
				Check_RPP.Check_RPP(SSN, FileName);

			}
		}
	}

	// //@Test (priority=61,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_RCC_VoidPBNK_RCC_Sc106() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_RCC_VoidPBNK_RCC_Txn_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:106" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_RCC_VoidPBNK_RCC");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan1.DrawLoan1(SSN, FileName); // addded parameter
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);

				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 3);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);
				PendingBNK_Void.PendingBNK_Void(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}
	}

	// //@Test (priority=62,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_stmt_Deposit_ReturnwithR01_DLQ_Cure_DFLT_RPP_PPAYwithCash_PBNKbeforeduedate_NoRepDepRecord_Sc107()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_Deposit_ReturnwithR01_DLQ_Cure_DFLT_RPP_PPAYwithCash_PBNKbeforeduedate_NoRepDepRecord_Txn_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:107" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI=>Draw=>Statement =>Depsoit=>Rtn=>DLQ=>CURE=>DFLT=> RPP=>PPAY WD Cash => PBNK Before Due date =>NO deposit reperesenment");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan.DrawLoan(SSN, FileName, "100"); // added parameter
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);

				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);

				AgeStore.AgeStore(SSN, FileName, 3);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 3);
				RPP.RPP(SSN, FileName);
				RPP_Status.RPP_Status(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, -3, 2);
				RPP_Payment.RPP_Payment(SSN, FileName);
				Represent_Status.Represent_Status(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, -2, 2);
				PendingBNK.PendingBNK(SSN, FileName);
				Represent_Status.Represent_Status(SSN, FileName);

			}
		}
	}
	// //@Test (priority=63,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_stmt_Deposit_ReturnwithR01_DLQ_Cure_DFLT_RPP_PPAYwithCash_PBNKbeforeduedate_VoidPBNKonduedate_RepDepRecordshouldpost_Sc108()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_Deposit_ReturnwithR01_DLQ_Cure_DFLT_RPP_PPAYwithCash_PBNKbeforeduedate_VoidPBNKonduedate_RepDepRecordshouldpost_Txn_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:108" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI=>Draw=>Statement =>Depsoit=>Rtn=>DLQ=>CURE=>DFLT=> RPP=>PPAY WD Cash => PBNK Before Due date =>Void PBNK on due date=> deposit reperesenment");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 3);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 3);
				RPP.RPP(SSN, FileName);
				RPP_Status.RPP_Status(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, -3, 2);
				RPP_Payment.RPP_Payment(SSN, FileName);
				Represent_Status.Represent_Status(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, -2, 2);
				PendingBNK.PendingBNK(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0, 2);
				PendingBNK_Void.PendingBNK_Void(SSN, FileName);
				Represent_Status.Represent_Status(SSN, FileName);
			}
		}
	}

	// --////@Test (priority=64,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_BNK_DfltOrWOB_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_BNK_DfltOrWOB_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:109_" + PayFrequency + "_" + CollateralType,
						"LOCI _Draw _ BNK loan selected in bnk process _ Loan to be def Or WOB");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}
	}

	//@Test(priority = 65, groups = "srikanth_TN_LOC") // --PASS

	public void LOCI_Draw_BNK_LoanShouldDefOrWOB_WORShouldbeprocessedPPNshouldnotbedisplayed_WORFullPmt_Lineshouldbeclosed_VoidWOR_CustStatusBNK_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_BNK_LoanShouldDefOrWOB_WORShouldbeprocessedPPNshouldnotbedisplayed_WORFullPmt_Lineshouldbeclosed_VoidWOR_CustStatusBNK_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:110_" + PayFrequency + "_" + CollateralType,
						"LOCI _Draw _ BNK loan selected in bnk process _ Loan to be def  Or WOB_ WOR Should be processed PPN should not be displayed_WOR Full Payment _ Line should be closed _ Void WOR Cust Status should be BNK");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Check_PPN.Check_PPN(SSN, FileName, 0);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				WOStatus_Bankrupt.WOStatus_Bankrupt(SSN, FileName);
				WORecovery_Void.WORecovery_Void(SSN, FileName);
				WORECStatus_Bankrupt.WORECStatus_Bankrupt(SSN, FileName);
			}
		}
	}

	// //@Test (priority=66,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNK_Pmt_Payoff_VoidPayoff_DLQ_Cure_CureAmtPmt_CUSTinBNKStatus_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNK_Pmt_Payoff_VoidPayoff_DLQ_Cure_CureAmtPmt_CUSTinBNKStatus_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:111_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure Period starts _ Paymnt of Cure amount Loan should Come out DLQ cust status should be BNK");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);

				NewLoan.NewLoan(SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				Payments_CureAmt.Payments_CureAmt(SSN, FileName);
				CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);

			}
		}
	}

	// --////@Test (priority=67,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_CheckCustStatus_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_CheckCustStatus_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:112_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _Check cust status or Loan status");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);

			}
		}
	}

	// //@Test (priority=68,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNKLoannotSelected_Pmt_Payoff_VoidPayoff_DLQ_Cure_DFLT_PPNnotDisplayed_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoannotSelected_Pmt_Payoff_VoidPayoff_DLQ_Cure_DFLT_PPNnotDisplayed_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:113_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure _DFLT _ PPN should not be displayed");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				CustomerDefault_1.CustomerDefault_1(SSN, FileName);
				DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
				Check_PPN_1.Check_PPN_1(SSN, FileName);

			}
		}
	}

	// --////@Test (priority=69,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_DFLTPmtFull_CheckLoanorCustStatus_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_DFLTPmtFull_CheckLoanorCustStatus_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:114_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure _DFLT _ DFP Full _Check cust status or Loan Status");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				CustomerDefault_1.CustomerDefault_1(SSN, FileName);
				DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
				Default_Payment_1.Default_Payment_1(SSN, FileName);
				DFLTPmtFull_Status_1.DFLTPmtFull_Status_1(SSN, FileName);

			}
		}
	}

	// //@Test (priority=70,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_DFLTPmtFull_DFLTPmtVoid_CheckLoanorCustStatus_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_DFLTPmtFull_DFLTPmtVoid_CheckLoanorCustStatus_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:115_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure _DFLT _ DFP Full_Void DFP Full _Check cust status or Loan Status.");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);

				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				CustomerDefault_1.CustomerDefault_1(SSN, FileName);
				DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
				Default_Payment_1.Default_Payment_1(SSN, FileName);
				// DefaultPayment_Void_.DefaultPayment_Void_1(SSN, FileName);
				DFLTPmtFull_Status_1.DFLTPmtFull_Status_1(SSN, FileName);

			}
		}
	}

	// //@Test (priority=71)

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_15PerAboveDFLTPmt_60daysWO_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_15PerAboveDFLTPmt_60daysWO_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:116_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure _DFLT _ DFP more than 15% _WO should be happen 60 days from last payment date.");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				CustomerDefault_1.CustomerDefault_1(SSN, FileName);
				Default_Payment_PercentageAmt_1.Default_Payment_PercentageAmt_1(SSN, FileName, 0.18);
				Default_WOProc_1.Default_WOProc_1(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);

			}
		}
	}

	// --////@Test (priority=72,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_WO_PPNShouldnotdisplayed_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_WO_PPNShouldnotdisplayed_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:117_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure _DFLT _  WO_PPN Should not be displayed");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				CustomerDefault_1.CustomerDefault_1(SSN, FileName);
				Default_WOProc_1.Default_WOProc_1(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				Check_PPN_2.Check_PPN_2(SSN, FileName);

			}
		}
	}

	// -////@Test (priority=73,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_WO_WORFull_VOidWOR_CheckCustStatusorLoanStatus_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_WO_WORFull_VOidWOR_CheckCustStatusorLoanStatus_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:118_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure _DFLT _  WO_WOR Full _Void WOR Full _Check Cust Status or Loan Status");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				CustomerDefault_1.CustomerDefault_1(SSN, FileName);
				Default_WOProc_1.Default_WOProc_1(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				Writoff_Recovery_1.Writoff_Recovery_1(SSN, FileName);
				WORecovery_Void_1.WORecovery_Void_1(SSN, FileName);
				DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
			}
		}
	}

	// --////@Test (priority=74,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_WO_WORFull_CheckCustStatusorLoanStatus_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_WO_WORFull_CheckCustStatusorLoanStatus_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:119_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure _DFLT _  WO_WOR Full  _Check Cust Status or Loan Status");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				CustomerDefault_1.CustomerDefault_1(SSN, FileName);
				Default_WOProc_1.Default_WOProc_1(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);

				Writoff_Recovery_1.Writoff_Recovery_1(SSN, FileName);

				DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);

			}
		}
	}
	// //@Test (priority=75,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_RCCnotDisplayed_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_RCCnotDisplayed_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:121_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure _DFLT _ RCC should not be displayed");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				CustomerDefault_1.CustomerDefault_1(SSN, FileName);
				DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
				Check_RCC_1.Check_RCC_1(SSN, FileName);

			}
		}
	}

	// --////@Test (priority=76,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_CheckCustStatusorLoanStatus()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_CheckCustStatusorLoanStatus_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:122_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff  _Check Cust Status or Loan Status");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Payments_1.Payments_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				Void_Payoff_1.Void_Payoff_1(SSN, FileName);
				Cust_Loan_Status.Cust_Loan_Status(SSN, FileName);

			}
		}
	}

	// --////@Test (priority=77,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_PaymentsShoulddisplayed_DrawDepositnotDisplayed_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_PaymentsShoulddisplayed_DrawDepositnotDisplayed_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);

				test = reports.startTest(Header + "_S.No:123_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw _ BNK Loan not selected in BNK Process _ Cust in BNK _ Here Only payments should be processed no Draw and No Deposit and no statement generation");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				Check_TransactionList.Check_TransactionList(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);

			}
		}
	}

	//@Test(priority = 78, groups = "srikanth_TN_LOC") // --PASS

	public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payoff_CustomerStatusshouldbeBNK() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payoff_CustomerStatusshouldbeBNK_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:124_" + PayFrequency + "_" + CollateralType,
						"LOCI _Draw _ BNK Customer should have another PDL Loan _ Select Only PDL loan in BNK Process _Payoff on LOC Loan _Customer status should be BNK");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -4);
				Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
				BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				PayOffLoan_1.PayOffLoan_1(SSN, FileName);
				CustomerStatus.CustomerStatus(SSN, FileName);

			}
		}
	}
	// --////@Test (priority=79,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_BNKIntrstCalcShuldhappen_LoanShouldDefOrWOB_WO_WORFull_VoidWOR_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_BNKIntrstCalcShuldhappen_LoanShouldDefOrWOB_WO_WORFull_VoidWOR_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:125_" + PayFrequency + "_" + CollateralType,
						"LOCI _ Draw _ Statement _ BNK Intrst Calc Shuld happen=>Loan to def/WOB _WO _WOR Full _Void WOR full");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration_Interest.StatementGeneration_Interest(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				WOStatus_Bankrupt.WOStatus_Bankrupt(SSN, FileName);
				WORecovery_Void.WORecovery_Void(SSN, FileName);
				WORECStatus_Bankrupt.WORECStatus_Bankrupt(SSN, FileName);

			}
		}
	}

	// //@Test (priority=80,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_Dep_RTN_BNKIntrstCalcShuldhappen_LoanShouldDefOrWOB_WO_WORFull_VoidWOR()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Dep_RTN_BNKIntrstCalcShuldhappen_LoanShouldDefOrWOB_WO_WORFull_VoidWOR_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:126_" + PayFrequency + "_" + CollateralType,
						"LOCI _ Draw _ Statement_ Deposit _RTN_ BNK _Loan to def or WOB _WO _WOR Full _Void WOR full");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				WOStatus_Bankrupt.WOStatus_Bankrupt(SSN, FileName);
				WORecovery_Void.WORecovery_Void(SSN, FileName);
				WORECStatus_Bankrupt.WORECStatus_Bankrupt(SSN, FileName);

			}
		}
	}

	// --////@Test (priority=81,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_Deposit_RTN_DLQ_DFLT_BNK_WO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Deposit_RTN_DLQ_DFLT_BNK_WO_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:127" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_Statement_Deposit_RTN-DLQ_DFLT_BNK_WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);

				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus_1.WOPaymentStatus_1(SSN, FileName);

			}
		}

	}

	// --////@Test (priority=82,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Statement_Deposit_RTN_DLQ_DFLT_DFPFull_BNK_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Statement_Deposit_RTN_DLQ_DFLT_DFPFull_BNK_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:128_" + PayFrequency + "_" + CollateralType,
						"LOCI _ Draw _ Statement_ Deposit _RTN_DLQ _DFLT_DFP Full_BNK _NO VOID DFP Void Should not displayed after DFP");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_Payment.Default_Payment(SSN, FileName);
				Bankrupt_NoRecord.Bankrupt_NoRecord(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Check_Draw.Check_Draw(SSN, FileName);

			}
		}
	}

	// //@Test (priority=83,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_Deposit_RTN_DLQ_DFLT_RPP_BNK_WO_AllSchdlsCancel_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Deposit_RTN_DLQ_DFLT_RPP_BNK_WO_AllSchdlsCancel_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:129_" + PayFrequency + "_" + CollateralType,
						"LOCI _ Draw _ Statement_ Deposit _RTN_DLQ _DFLT_RPP_BN_WO all ach should be cancelled");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCCRevoke.RCCRevoke(SSN, FileName);
				RPP.RPP(SSN, FileName);
				RPP_Status.RPP_Status(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				RPP_Status.RPP_Status(SSN, FileName);

			}
		}
	}

	// --////@Test (priority=84,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_Depo_RTN_DLQ_DFLT_RPP_BNKPDL_RPPFull_RPP_CheckStatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Depo_RTN_DLQ_DFLT_RPP_BNKPDL_RPPFull_CheckStatus_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:130_" + PayFrequency + "_" + CollateralType,
						"LOCI => Draw => Statement=> Deposit =>RTN=>DLQ =>DFLT=>RPP=> BNK(Other PDL Loan)=>RPP Full check loan /cust status");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA_1.NACHA_1(SSN, FileName, -1);
				ACH_Deposit_1.ACH_Deposit_1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				CustomerDefault_1.CustomerDefault_1(SSN, FileName);
				DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
				RCCRevoke_1.RCCRevoke_1(SSN, FileName);
				RPP_1.RPP_1(SSN, FileName);
				RPP_Status_1.RPP_Status_1(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				RPP_Payment_1.RPP_Payment_1(SSN, FileName);
				BankruptStatus_1.BankruptStatus_1(SSN, FileName);
				RPP_Status_1.RPP_Status_1(SSN, FileName);

			}
		}
	}

	// //@Test (priority=85,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_Depo_RTN_DLQ_DFLT_RPP_BNKPDL_RPPFull_RPP_Void_CheckStatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI _ Draw _ Statement_ Deposit _RTN_DLQ _DFLT_RPP_ BNK Other PDL Loan_RPP Full _Void RPP check loan cust status_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:131_" + PayFrequency + "_" + CollateralType,
						"LOCI => Draw => Statement=> Deposit =>RTN=>DLQ =>DFLT=>RPP=> BNK(Other PDL Loan)=>RPP Full check loan /cust status");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoan_PDL.NewLoan_PDL(SSN, FileName);
				DrawLoan_1.DrawLoan_1(SSN, FileName);
				StatementGeneration_1.StatementGeneration_1(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA_1.NACHA_1(SSN, FileName, -1);
				ACH_Deposit_1.ACH_Deposit_1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore_1.AgeStore_1(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
				CustomerDefault_1.CustomerDefault_1(SSN, FileName);
				DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
				RCCRevoke_1.RCCRevoke_1(SSN, FileName);
				RPP_1.RPP_1(SSN, FileName);
				RPP_Status_1.RPP_Status_1(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				RPP_Payment_1.RPP_Payment_1(SSN, FileName);
				RPP_Void.RPP_Void(SSN, FileName);
				BankruptStatus_1.BankruptStatus_1(SSN, FileName);
				RPP_Status_1.RPP_Status_1(SSN, FileName);

			}
		}
	}

	// //@Test (priority=86,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_Stmt_Depo_RTN_DLQ_DFLT_WO_BNK_WOR() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Depo_RTN_DLQ_DFLT_WO_BNK_WOR_Txn_Testdata.xls";
		// AA_LOCI_Draw_Stmt_Dep_Clear_BNK_RTN_Txn_Testdata
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:132_" + PayFrequency + "_" + CollateralType,
						"LOCI _ Draw _ Statement_ Deposit _RTN_DLQ _DFLT_WO_BNK _WOR");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus_1.WOPaymentStatus_1(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				// RPP_Status.RPP_Status(SSN, FileName);

			}
		}
	}

	// //@Test (priority=87,groups = "srikanth_TN_LOC")

	public void AA_LOCI_Draw_Stmt_Dep_Clear_BNK_RTN_Txn_Testdata() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Dep_Clear_BNK_RTN_Txn_Testdata.xls";
		// AA_LOCI_Draw_Stmt_Dep_Clear_BNK_RTN_Txn_Testdata
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:133_" + PayFrequency + "_" + CollateralType,
						"LOCI _ Draw _ Deposit _ Clear _BNK_RTN _Status should be in BNK");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				ACH_Clear1.ACH_Clear1(SSN, FileName, 8);
				AgeStore.AgeStore(SSN, FileName, 8);
				Loanclosed_Bankrupt.Loanclosed_Bankrupt(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				RPP_Status.RPP_Status(SSN, FileName);

			}
		}
	}

	// --////@Test (priority=88,groups = "srikanth_TN_LOC")

	public void LOCI_DRAW_BNK_LoanTobeDEForWOB_VoidBNK_LoanInWOstatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_BNK_LoanTobeDEForWOB_VoidBNK_LoanInWOstatus_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:134" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_BNK(loan selected in bnk process)_Loan to be def /WOB_Void BNK_Loan in WO Status");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Void.Bankrupt_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 89, groups = "srikanth_TN_LOC") // --PASS

	public void LOCI_DRAW_Statement_BNK_LoanTobeDEForWOB_VoidBNK_LoanInWOstatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_Statement_BNK_LoanTobeDEForWOB_VoidBNK_LoanInWOstatus_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:135" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_Statement_BNK(loan selected in bnk process)_Loan to be def /WOB_Void BNK_Loan in WO Status");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Void.Bankrupt_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	// --////@Test (priority=90,groups = "srikanth_TN_LOC")

	public void LOCI_DRAW_DLQ_DFLT_BNK_LoanTobeDEForWOB_VoidBNK_LoanInWOstatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_DLQ_DFLT_BNK_LoanTobeDEForWOB_VoidBNK_LoanInWOstatus_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:136" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_DLQ_DFLT_BNK(loan selected in bnk process)_Loan to be def /WOB_Void BNK_Loan in WO Status");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Void.Bankrupt_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	// //@Test (priority=91,groups = "srikanth_TN_LOC")

	public void LOCI_DRAW_DLQ_DFLT_DEPFull_BNK_VoidBNK_Status() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_DLQ_DFLT_DEPFull_BNK_VoidBNK_Status_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:137" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_DLQ_DFLT _DFPFULL_BNK(loan selected in bnk process)_Loan to be WOB_Void BNK_Loan in WO Status");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_Payment.Default_Payment(SSN, FileName);
				DFLTPmtFull_Status.DFLTPmtFull_Status(SSN, FileName);
				Loanclosed_Bankrupt.Loanclosed_Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Loanclosed_Bankrupt_Void.Loanclosed_Bankrupt_Void(SSN, FileName);
				BankruptStatus_CustmerStatus.BankruptStatus_CustmerStatus(SSN, FileName);

			}
		}

	}

	// //@Test (priority=92,groups = "srikanth_TN_LOC")

	public void LOCI_DRAW_DLQ_DFLT_WO_BNK_LoanTobeWOB_VoidBNK_LoanInWOstatus_WOR() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_DLQ_DFLT_WO_BNK_LoanTobeWOB_VoidBNK_LoanInWOstatus_WOR_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:138" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_DLQ_DFLT_WO_BNK(loan selected in bnk process)_Loan to be WOB_Void BNK_Loan in WO Status_WOR");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus_1.WOPaymentStatus_1(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Void.Bankrupt_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);

			}
		}

	}

	// --////@Test (priority=93,groups = "srikanth_TN_LOC")

	public void LOCI_DRAW_DLQ_DFLT_WO_WORFull_BNK_LoanTobeWOB_VoidBNK_CheckStatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_DLQ_DFLT_WO_WORFull_BNK_LoanTobeWOB_VoidBNK_LoanInWOstatus_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:139" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_DLQ_DFLT_WO__WOR FULL_BNK(loan selected in bnk process)_Loan to be WOB_Void BNK_CheckStatus");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus_1.WOPaymentStatus_1(SSN, FileName);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				WOPaymentStatus_1.WOPaymentStatus_1(SSN, FileName);
				Loanclosed_Bankrupt.Loanclosed_Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Void_Loanclosed.Bankrupt_Void_Loanclosed(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				BankruptStatus_CustmerStatus.BankruptStatus_CustmerStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 94, groups = "srikanth_TN_LOC") // --PASS

	public void LOCI_DRAW_Discharge_CustmertoInactive_LineClosureShouldhappen() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_Discharge_CustmertoInactive_LineClosureShouldhappen_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:140" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_BNK_Discharge_Satus of cust to be Inactive_Line Closure should happen");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Discharged.Bankrupt_Discharged(SSN, FileName);
				BankruptStatus_CustmerStatus.BankruptStatus_CustmerStatus(SSN, FileName);

			}
		}

	}

	// //@Test (priority=95,groups = "srikanth_TN_LOC")

	public void LOCI_DRAW_Deposit_BNK_Discharge_CUSTtobeINACTIVE_LineClouser() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_Deposit_BNK_Discharge_CUSTtobeINACTIVE_LineClouser_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:141" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_Deposit_BNK_Discharge_Satus of cust to be Inactive_Line Closure should happen");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				ACH_Clear.ACH_Clear(SSN, FileName);
				Loanclosed_Bankrupt.Loanclosed_Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Discharged.Bankrupt_Discharged(SSN, FileName);
				BankruptStatus_CustmerStatus.BankruptStatus_CustmerStatus(SSN, FileName);

			}
		}

	}

	// //@Test (priority=96,groups = "srikanth_TN_LOC")

	public void Loan_Draw_GenerateStatement_ACHDepositFlight_ActiveMilaitary_PaymentWDcash_ActiveMiltaryEnd_GenerateStatement()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_STMT_DEPOSIT_CLR_BNK_Discharge_RTN _TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:142" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_Deposit_Clear_BNK_Discharged_RTN ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 7);
				ACH_Clear.ACH_Clear(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Discharged.Bankrupt_Discharged(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);

			}
		}

	}

	//@Test(priority = 97, groups = "srikanth_TN_LOC") // --PASS

	public void LOCI_Draw_Deceased_NextDrawshouldnotbeavailble() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Deceased_NextDrawshouldnotbeavailble_TestData.xls";

		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:143" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_Deceased_NextDrawshouldnotbeavailble");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Deceased_AfterBankrupt.Bankrupt_Deceased_AfterBankrupt(SSN, FileName);
				Check_Draw.Check_Draw(SSN, FileName);

			}
		}

	}

	//@Test(priority = 98, groups = "srikanth_TN_LOC") // --PASS

	public void LOCI_Draw_Deceased_NextDrawshouldnotbeavailble_VoidDeceased_WOR_NewloanOptionShouldBeAvalabile()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Deceased_NextDrawshouldnotbeavailble_VoidDeceased_WOR_NewloanOptionShouldBeAvalabile_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:144" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_Deceased_Draw not availble_Void Deceased_WOR_NewloanOptionShouldBeAvalabile");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Deceased_AfterBankrupt.Bankrupt_Deceased_AfterBankrupt(SSN, FileName);
				Check_Draw.Check_Draw(SSN, FileName);
				Deceased_Void.Deceased_Void(SSN, FileName);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				WOPaymentStatus_1.WOPaymentStatus_1(SSN, FileName);
				NewLoan_Verification_WithProduct.NewLoan_Verification_WithProduct(SSN, FileName);

			}
		}

	}

	// --////@Test (priority=99,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_StGn_DeceasedBeforeDueDate_LineStatusWo() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_StGn_DeceasedBeforeDueDate_LineStatusWo_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:145" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_St Gn_Deceased before due date_Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_DeceasedBeforeDueDate.Bankrupt_DeceasedBeforeDueDate(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 100, groups = "srikanth_TN_LOC") // --PASS

	public void LOCI_DRAW_Statement_Deceased_LCstatusWO_VoidDeceased_ValidateLCstatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_Statement_Deceased_LCstatusWO_VoidDeceased_ValidateLCstatus_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:146" + "_" + PayFrequency + "_" + CollateralType,
						"LonI_Draw_Statement_Deceased_LC status WO_Void Deceased_Validate LC status");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Deceased_AfterBankrupt.Bankrupt_Deceased_AfterBankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Deceased_Void.Deceased_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 101, groups = "srikanth_TN_LOC") // --PASS

	public void LOCI_Draw_StGn_DeceasedBeforeDueDate_LineStatusWo_WOR_OldLoanShouldClosed_NewLoanShouldnotBeEnabled()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_StGn_DeceasedBeforeDueDate_LineStatusWo_WOR_OldLoanShouldClosed_NewLoanShouldnotBeEnabled_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:147" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_St Gn_Deceased before due date_Line status to WO-WO Recovery_Old loan should get closed_New loan option should be enabled");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_DeceasedBeforeDueDate.Bankrupt_DeceasedBeforeDueDate(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 2);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				WOPaymentStatus_LoanStatus.WOPaymentStatus_LoanStatus(SSN, FileName);
				NewLoan_Verification_WithoutProduct.NewLoan_Verification_WithoutProduct(SSN, FileName);

			}
		}
	}

	// --////@Test (priority=102,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_StGn_DeceasedBeforeDueDate_LineStatusWo_WOR_Partially_NewLoanShouldnotBeEnabled()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_StGn_DeceasedBeforeDueDate_LineStatusWo_WOR_Partially_NewLoanShouldnotBeEnabled_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:148" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_St Gn_Deceased before due date_Line status to WO_WO Recovery-Paid partially_New loan option should not be enabled");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_DeceasedBeforeDueDate.Bankrupt_DeceasedBeforeDueDate(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 2);
				Writoff_Recovery_PartialPayment.Writoff_Recovery_PartialPayment(SSN, FileName);
				WOPaymentStatus_LoanStatus.WOPaymentStatus_LoanStatus(SSN, FileName);
				NewLoan_Verification_WithoutProduct.NewLoan_Verification_WithoutProduct(SSN, FileName);

			}
		}

	}

	//@Test(priority = 103, groups = "srikanth_TN_LOC") // --PASS

	public void LOCI_Draw_stmt_DLQ_Deceasedonduedate_LineStatustoWO_Sc149() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_DLQ_Deceasedonduedate_LineStatustoWO_Txn_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:149" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => Deceased on due date (in DLQ) => Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
			}
		}
	}

	//@Test(priority = 104, groups = "srikanth_TN_LOC") // --PASS

	public void Loan_Draw_statement_DLQ_DeceasedincurePeriod_WO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_DLQ_DeceasedCurePeriod_WO_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:151" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => DLQ => Deceased in Cure Period => Line status to WO  ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	// --////@Test (priority=105,groups = "srikanth_TN_LOC")

	public void Loan_Draw_statement_DLQ_DeceasedDFLT_WO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statement_DLQ_DeceasedinDFLTPeriod_WO_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:153" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => DLQ => Deceased in DFLT => Line status to WO ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault_Agestore.CustomerDefault_Agestore(SSN, FileName);
				Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	// //@Test (priority=106,groups = "srikanth_TN_LOC")

	public void Loan_Draw_statement_DLQ_DeceasedDFLT_WO_Void_Linestatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statement_DLQ_DeceasedinDFLTPeriod_WO_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:154" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => DLQ => Deceased in DFLT => Line status to WO   => Void Deceased => check Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault_Agestore.CustomerDefault_Agestore(SSN, FileName);
				Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Void.Bankrupt_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	// --////@Test (priority=107,groups = "srikanth_TN_LOC")

	public void Loan_Draw_statement_DLQ_DFLT_DeceasedWO_Linestatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statement_DLQ_DFLT_DeceasedinWO_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:155" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => DLQ => DFLT => WO => Deceased in WO => Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				Default_WOProc1.Default_WOProc1(SSN, FileName);
				Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	// //@Test (priority=108,groups = "srikanth_TN_LOC")

	public void Loan_Draw_statement_DLQ_DFLT_DeceasedWO_VoidDeceased_Linestatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statement_DLQ_DFLT_DeceasedinWO_VoidDeceased_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:156" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => DLQ => DFLT => WO => Deceased in WO => Line status to WO  => Void Deceased => Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				Default_WOProc1.Default_WOProc1(SSN, FileName);
				Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Void.Bankrupt_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 109, groups = "srikanth_TN_LOC") // --FAIL

	public void Loan_Draw_Payoff_Loanclosure_Deceased_NewloanOriginationshouldnotbeallowed() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_Payoff_Loanclosure_Deceased_NewloanOrigination_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:157" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw => Pay Off => Loan Closure => Deceased => New loan Origination should not be allowed");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -3);
				PayOffLoan.PayOffLoan(SSN, FileName);
				Closure.Closure(SSN, FileName);
				Bankrupt_Deceased_Loanclosuer.Bankrupt_Deceased_Loanclosuer(SSN, FileName);
				NewLoanValidation.NewLoanValidation(SSN, FileName);
			}
		}
	}

	//@Test(priority = 110, groups = "srikanth_TN_LOC") // --PASS

	public void Loan_Draw_Payoff_Deceased_Nextdrawnotavailable() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_Payoff_Deceased_DrawnotavailableTxn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:158" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw => Pay Off => Deceased => Draw should not be allowed");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -6);
				PayOffLoan.PayOffLoan(SSN, FileName);
				Bankrupt_Deceased_Loanclosuer.Bankrupt_Deceased_Loanclosuer(SSN, FileName);
				Check_Draw.Check_Draw(SSN, FileName);

			}
		}
	}

	//@Test(priority = 111, groups = "srikanth_TN_LOC") // --PASS

	public void Loan_Draw_Payoff_Deceased_Void_Nextdrawavailable() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_Payoff_Deceased_Void_DrawavailableTxn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:159" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw => Pay Off =>  Deceased => Void deceased => Next draw should be available");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -3);
				PayOffLoan.PayOffLoan(SSN, FileName);
				Bankrupt_Deceased_Loanclosuer.Bankrupt_Deceased_Loanclosuer(SSN, FileName);
				Void_Deceased.Void_Deceased(SSN, FileName);
				Check_Draw.Check_Draw(SSN, FileName);
			}
		}
	}

	//@Test(priority = 112, groups = "srikanth_TN_LOC") // --PASS

	public void Loan_Draw_MinPayment_Deceased_Drawnotavailable() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_MinPayment_Deceased_Drawavailable_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:160" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw => On Due date Minimum payment made => Deceased => Next draw not available");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				Payments.Payments(SSN, FileName);
				Bankrupt_Deceased_Loanclosuer.Bankrupt_Deceased_Loanclosuer(SSN, FileName);
				Check_Draw.Check_Draw(SSN, FileName);

			}
		}

	}

	// //@Test (priority=113,groups = "srikanth_TN_LOC")

	public void LOCI_DRAW_STGN_Deceased_ACHShouldnotGetDeposited() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_STGN_Deceased_ACHShouldnotGetDeposited_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:163" + "_" + PayFrequency + "_" + CollateralType,
						" LOCI_Draw_St Gn_Deceased on due date_ACH should not get deposited");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Deceased_ONDueDate.Bankrupt_Deceased_ONDueDate(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				Check_Record.Check_Record(SSN, FileName);

			}
		}

	}

	//@Test(priority = 114, groups = "srikanth_TN_LOC") // --PASS

	public void Loan_Draw_StGn_ACHDeposit_RTN_Deceased_ACHDepositnotRedeposit() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_StGn_Draw_ACHDeposit_StartActiveMillatry_RTN_ActivemillartyEnd_StGn_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:164" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn =>  on due date ACH deposited => RTN => Deceased => ACH should not be re deposited");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				// Bankrupt.Bankrupt(SSN, FileName);
				Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
				LineStatus.LineStatus(SSN, FileName);
			}
		}
	}

	// --////@Test (priority=115,groups = "srikanth_TN_LOC")

	public void LOCI_DRAW_StGn_DFLT_RccRevoke_Rpp_Deceased_LinestatusWO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_StGn_DFLT_RccRevoke_Rpp_Deceased_LinestatusWO_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:165" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_St Gn_DFLT_RCC Revoke_RPP_Deceased_Line status to WO ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				PaymentPlan.PaymentPlan(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Deceased_AfterBankrupt.Bankrupt_Deceased_AfterBankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
			}
		}

	}

	// //@Test (priority=116,groups = "srikanth_TN_LOC")

	public void LOCI_DRAW_StGn_DFLT_RccRevoke_Rpp_Deceased_LinestatusWO_VoidDeceased_LineStatusWO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_StGn_DFLT_RccRevoke_Rpp_Deceased_LinestatusWO_VoidDeceased_LineStatusDFLT_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:166" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_St Gn_DFLT_RCC Revoke_RPP_Deceased_Line status to WO_Void Deceased_Line status to DFLT  ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				PaymentPlan.PaymentPlan(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Deceased_AfterBankrupt.Bankrupt_Deceased_AfterBankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Deceased_Void.Deceased_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	// //@Test (priority=117,groups = "srikanth_TN_LOC")

	public void LOCI_DRAW_StGn_WO_RccRevoke_Rpp_Deceased_LinestatusWO_VoidDeceased_LineStatusWO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_StGn_WO_RccRevoke_Rpp_Deceased_LinestatusWO_VoidDeceased_LineStatusWO_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:167" + "_" + PayFrequency + "_" + CollateralType,
						" LOCI_Draw_St Gn_ WO_RCC Revoke_RPP_Deceased_Line status to WO_Void Deceased_Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 90);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				PaymentPlan.PaymentPlan(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Deceased_AfterBankrupt.Bankrupt_Deceased_AfterBankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Deceased_Void.Deceased_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	// --////@Test (priority=118,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_StGn_DFLT_RCC_Deceased_LineStatusWO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_StGn_DFLT_RCC_Deceased_LineStatusWO_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:168" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_St Gn_DFLT_RCC_Deceased_Line status to WO ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Deceased_AfterBankrupt.Bankrupt_Deceased_AfterBankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	// //@Test (priority=119,groups = "srikanth_TN_LOC")

	public void LOCI_Draw_StGn_DFLT_RCC_Deceased_LineStatusWO_VoidDeceased_LineStatusWO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_StGn_DFLT_RCC_Deceased_LineStatusWO_VoidDeceased_LineStatusWO_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir")
				+ prop.getProperty("AA_Store_Test_data_TN_LOC_path_srikanth") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_srikanth");
				UserName = prop.getProperty("UserName_TN_LOC_srikanth");
				Password = prop.getProperty("Password_TN_LOC_srikanth");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_srikanth");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:169" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI_Draw_St Gn_DFLT_RCC_Deceased_Line status to WO_VoidDecased_LineStatusWo ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Deceased_AfterBankrupt.Bankrupt_Deceased_AfterBankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Deceased_Void.Deceased_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}
	}

	// Kiran scenarios
	 ////@Test (priority=120,groups = "kiran_TN_LOC")

	public void LOCI_Draw_StGn_DFLT_WO_RCC_Deceased_LineStatusWO_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_StGn_DFLT_WO_RCC_Deceased_LineStatusWO_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:170" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI _Draw _St Gn _ WO _RCC_ Deceased _ Line status to WO _ Void Deceased _  Line status to WO ");

				/*
				 * ////////// Safeassign.Safeassign(SSN, FileName);
				 * Drawerassign.Drawerassign(SSN, FileName);///////
				 */
				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				// DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				Check_RCCSchd.Check_RCCSchd(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Deceased_Void_WO.Deceased_Void_WO(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}

	}

	// //@Test (priority=122,groups = "kiran_TN_LOC")

	 ////@Test (priority=122,groups = "kiran_TN_LOC")
	public void LOCI_Draw_Dismissed_NextDrawshouldnotbeavailble_Bankrupt_CheckDraw_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Dismissed_NextDrawshouldnotbeavailble_Bankrupt_CheckDraw_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:172_" + PayFrequency + "_" + CollateralType,
						" LOCI _Draw _Dismissed _ Next Draw should not be availble_ Edited and Changed to BNK _ next draw should not be available ");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -6);
				Bankrupt.Bankrupt(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				Check_Draw.Check_Draw(SSN, FileName);
				Bankrupt_AfterDismissed.Bankrupt_AfterDismissed(SSN, FileName);
				Check_Draw.Check_Draw(SSN, FileName);

				// BankruptStatus.BankruptStatus(SSN, FileName);

			}
		}
	}

	// //@Test (priority=124,groups = "kiran_TN_LOC")

	 ////@Test (priority=124,groups = "kiran_TN_LOC")
	public void LOCI_Draw_StmtGn_DismissedBeforeDueDate_WORecovery_OldLoanClosed_NewLoanEnable_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_StmtGn_DismissedBeforeDueDate_WORecovery_OldLoanClosed_NewLoanEnable_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:174_" + PayFrequency + "_" + CollateralType,
						" LOCI _Draw _St Gn _ Dismissed before due date  _ Line status to WO  _ WO Recovery _ Old loan should get closed _ New loan option should be enabled");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -6);
				Bankrupt.Bankrupt(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				Check_NewLoan.Check_NewLoan(SSN, FileName);

			}
		}
	}

	// //@Test (priority=125,groups = "kiran_TN_LOC")

	 ////@Test (priority=125,groups = "kiran_TN_LOC")
	public void LOCI_Draw_stmt_DismissedonDuedate_LineStatustoWO_Sc176() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_DismissedonDuedate_LineStatustoWO_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:176" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => Dismissed on due date (in DLQ) => Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
			}
		}
	}

	// //@Test (priority=126,groups = "kiran_TN_LOC")

	 ////@Test (priority=126,groups = "kiran_TN_LOC")
	public void LOCI_Draw_stmt_DLQ_DismissedinCureperiod_LineStatustoWO2_Sc177() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_DLQ_DismissedinCureperiod_LineStatustoWO2_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:177" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => DLQ => Dismissed in Cure Period => Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
			}
		}
	}

	// //@Test (priority=127,groups = "kiran_TN_LOC")

	 ////@Test (priority=127,groups = "kiran_TN_LOC")
	public void LOCI_Draw_stmt_DLQ_DFLT_DismissedinDFLT_LineStatustoWO_Sc178() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_DLQ_DFLT_DismissedinDFLT_LineStatustoWO_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:178" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => DLQ => Dismissed in DFLT => Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				Dismissed_AfterBANKRUPT_DismissedinDFLT.Dismissed_AfterBANKRUPT_DismissedinDFLT(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
			}
		}
	}
	// //@Test (priority=128,groups = "kiran_TN_LOC")

	 //@Test (priority=128,groups = "kiran_TN_LOC")//k
	public void LOCI_Draw_stmt_DLQ_DFLT_WO_Dismissedonduedate_LineStatustoWO_Sc179() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_DLQ_DFLT_WO_Dismissedonduedate_LineStatustoWO_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:179" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => DLQ => DFLT => WO => Dismissed in WO => Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc1.Default_WOProc1(SSN, FileName);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
			}
		}
	}

	// //@Test (priority=130,groups = "kiran_TN_LOC")

	 //@Test (priority=130,groups = "kiran_TN_LOC")//k
	public void LOCI_Draw_Payoffwithcash_Dismissed_DrawnotAvailable_Sc181() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Payoffwithcash_Dismissed_DrawnotAvailable_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:181" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw => Pay Off =>  Dismissed => Next draw not available");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan1.DrawLoan1(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 7);
				PayOffLoan.PayOffLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 8);
				Bankrupt_NoRecord.Bankrupt_NoRecord(SSN, FileName);
				Dismissed_AfterBANKRUPT_NoRecord.Dismissed_AfterBANKRUPT_NoRecord(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				Check_Draw.Check_Draw(SSN, FileName);

			}
		}
	}

	// //@Test (priority=131,groups = "kiran_TN_LOC")

	 @Test (priority=131,groups = "kiran_TN_LOC")
	public void Loan_Draw_MinPayment_Dismissed_Drawnotavilable_Txn_Testdata() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_MinPayment_Dismissed_Drawnotavilable_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:182" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw => On Due date Minimum payment made => Dismissed => Next draw not available");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan1.DrawLoan1(SSN, FileName);
				// NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				MinPayments.MinPayments(SSN, FileName);
				Bankrupt_Dismissed.Bankrupt_Dismissed(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				Check_Draw.Check_Draw(SSN, FileName);

			}
		}

	}

	// //@Test (priority=132,groups = "kiran_TN_LOC")

	 //@Test (priority=132,groups = "kiran_TN_LOC")//k
	public void Loan_Draw_StGn_Dismissedonduedate_ACHshouldnotgetdeposited() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_StGn_Dismissedonduedate_ACHshouldnotgetdeposited_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:183" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => Dismissed on due date =>  ACH should not get deposited");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan1.DrawLoan1(SSN, FileName);
				// NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				Bankrupt_Dismissed.Bankrupt_Dismissed(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				EODProcessing_with_recordsChecking.EODProcessing_with_recordsChecking(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

				// Check_Draw.Check_Draw(SSN, FileName);

			}
		}

	}

	// //@Test (priority=133,groups = "kiran_TN_LOC")

	 //@Test (priority=133,groups = "kiran_TN_LOC")
	public void Loan_Draw_StGn_ACHDeposit_RTN_Dismissed_ACHDepositnotRedeposit() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_ Loan_Draw_StGn_ACHDeposit_Dismissed_ACHDepositshouldnotgetRedeposited_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:184" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn =>  on due date ACH deposited => RTN => Dismissed => ACH should not be re deposited");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 2);
				ACH_Return_withloannum.ACH_Return_withloannum(SSN, FileName);
				Bankrupt_Dismissed.Bankrupt_Dismissed(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				LineStatus.LineStatus(SSN, FileName);

			}
		}

	}

	 //@Test (priority=134,groups = "kiran_TN_LOC")//k

	public void Loan_Draw_StGn_Default_RCC_Dismissed_RCCNotgetDeposit_LinestatusWO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_ Loan_Draw_StGn_Default_RCC_Dismissed_RCCshouldnotget_LinestatusWO_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:185" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => DFLT => RCC => Dismissed => RCC should not get deposited => Line status to WO");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Bankrupt_Dismissed.Bankrupt_Dismissed(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				LineStatus.LineStatus(SSN, FileName);

			}
		}

	}

	 //@Test (priority=135,groups = "kiran_TN_LOC")

	public void Loan_Draw_StGn_Dfault_RCCRevoke_RPP_Dismissed_LinestatusWO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_ Loan_Draw_StGn_Default_RCCRevoke_RPP_Dismissed_LinestatusWO_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:186" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI =>Draw =>St Gn => DFLT => RCC Revoke => RPP => Dismissed => Line status to WO ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RPP.RPP(SSN, FileName);
				RPP_Status.RPP_Status(SSN, FileName);
				Bankrupt_Dismissed.Bankrupt_Dismissed(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				LineStatus.LineStatus(SSN, FileName);

			}
		}

	}

 //@Test (priority=136,groups = "kiran_TN_LOC")

	public void LOCI_Draw_Default_RCCRevoke_ConverEPP_MinPay_Minper_Month() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_Draw_Default_RCCRevoke_ConverEPP_MinPay_MinperM_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:187" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP check the schedule which is generated for Monthly customer according to Minpayment and Min percentage rule value");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				Edit_Reg_Rpp_Month.Edit_Reg_Rpp_Month(SSN, FileName);
				RPP.RPP(SSN, FileName);
				Min_Eight_PercentAmt.Min_Eight_PercentAmt(SSN, FileName);

			}
		}

		// Login.Login("CSR353","1234","353");

	}

	// //@Test (priority=137,groups = "kiran_TN_LOC")

	 ////@Test (priority=137,groups = "kiran_TN_LOC")

	public void LOCI_Draw_Default_RCCRevoke_ConverEPP_MinPay_Minper_Semi() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_Draw_Default_RCCRevoke_ConverEPP_MinPay_MinperS_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:188" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP check the schedule which is generated for Semi Monthly customer according to Minpayment and Min percentage rule value");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);

				Edit_Reg_Rpp_Semi.Edit_Reg_Rpp_Semi(SSN, FileName);
				RPP.RPP(SSN, FileName);
				Min_Four_PercentAmt.Min_Four_PercentAmt(SSN, FileName);

			}
		}

		// Login.Login("CSR353","1234","353");

	}

	 //@Test (priority=139,groups = "kiran_TN_LOC")

	public void LOCI_Draw_Default_RCCRevoke_ConverEPP_MinPay_Minper_Bweek() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_Draw_Default_RCCRevoke_ConverEPP_MinPay_MinperB_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:190" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP check the schedule which is generated for Monthly customer according to Minpayment and Min percentage rule value");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RPP.RPP(SSN, FileName);
				Min_Four_PercentAmt.Min_Four_PercentAmt(SSN, FileName);

			}
		}

		// Login.Login("CSR353","1234","353");

	}
 //@Test (priority=140,groups = "kiran_TN_LOC")

	public void LOC_default_RCCRevoke_EPP_Instwisepayment_Monthly() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_default_RCCRevoke_EPP_InswisePayment_M_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:191" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP -> PPAY all installments accordingly before due date for Monthly customer");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RPP.RPP(SSN, FileName);
				AgeStore_1stins.AgeStore_1stins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_2ndins.AgeStore_2ndins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_3rdins.AgeStore_3rdins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_4rthins.AgeStore_4rthins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);

			}
		}

	}

	 //@Test (priority=141,groups = "kiran_TN_LOC")

	public void LOC_default_RCCRevoke_EPP_Instwisepayment_Semmonthly() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_default_RCCRevoke_EPP_InswisePayment_S_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:192" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status->Perform RCC Revoke -> Convert to EPP -> PPAY all installments accordingly before due date for Semi monthly customer");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				Edit_Reg_Rpp_Semi.Edit_Reg_Rpp_Semi(SSN, FileName);
				RPP.RPP(SSN, FileName);
				AgeStore_1stins.AgeStore_1stins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_2ndins.AgeStore_2ndins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_3rdins.AgeStore_3rdins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_4rthins.AgeStore_4rthins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);

			}
		}

	}

	 //@Test (priority=142,groups = "kiran_TN_LOC")

	public void LOC_default_RCCRevoke_EPP_Instwisepayment_Week() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_default_RCCRevoke_EPP_InswisePayment_W_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:193" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP -> PPAY all installments accordingly before due date for weekly customer");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan1.DrawLoan1(SSN, FileName);
				// NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RPP.RPP(SSN, FileName);
				AgeStore_1stins.AgeStore_1stins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_2ndins.AgeStore_2ndins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_3rdins.AgeStore_3rdins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_4rthins.AgeStore_4rthins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);

			}
		}

	}

	 //@Test (priority=143,groups = "kiran_TN_LOC")

	public void LOC_default_RCCRevoke_EPP_Instwisepayment_Biweekly() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_default_RCCRevoke_EPP_InswisePayment_BW_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:194" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP -> PPAY all installments accordingly before due date for Bi Weekly customer");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan1.DrawLoan1(SSN, FileName);
				// NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RPP.RPP(SSN, FileName);
				AgeStore_1stins.AgeStore_1stins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_2ndins.AgeStore_2ndins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_3rdins.AgeStore_3rdins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);
				AgeStore_4rthins.AgeStore_4rthins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);

			}
		}

	}

	 //@Test (priority=144,groups = "kiran_TN_LOC") //Deposit Issue

	public void LOCI_Draw_Default_RCCRevoke_ConverEPP_DepositandClearInswise_Monthly() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_Draw_Default_RCCRevoke_ConverEPP_DepositandClearInswise_Monthly_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:195" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP -> Deposit all installments on due date accordingly for monthly customer and clear them after that");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan1.DrawLoan1(SSN, FileName);
				// NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RPP.RPP(SSN, FileName);
				AgeStore_1stins.AgeStore_1stins(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit_EPPfirst.ACH_Deposit_EPPfirst(SSN, FileName, 0);
				ACH_Clear_Firtinst.ACH_Clear_Firtinst(SSN, FileName, 4);
				AgeStore_2ndins.AgeStore_2ndins(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA_RPP_Second.NACHA_RPP_Second(SSN, FileName, -1);
				ACH_Clear_Secondinst.ACH_Clear_Secondinst(SSN, FileName, 4);
				ACHCLEARstatus.ACHCLEARstatus(SSN, FileName);

			}

		}

		// Login.Login("CSR353","1234","353");

	}

	//@Test(priority = 145, groups = "kiran_TN_LOC")

	public void LOCI_Draw_Default_RCCRevoke_ConverEPP_DepositandClearInswise_SemiMonthly() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_Draw_Default_RCCRevoke_ConverEPP_DepositandClearInswise_SemiMonthly_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:196" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP -> Deposit all installments on due date accordingly for monthly customer and clear them after that");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_NODep.StatementGeneration_EODProcessing_NODep(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				// Edit_Reg_Rpp_Semi_Datechange.Edit_Reg_Rpp_Semi_Datechange(SSN,
				// FileName);
				Edit_Reg_Rpp_Semi.Edit_Reg_Rpp_Semi(SSN, FileName);
				RPP.RPP(SSN, FileName);
				AgeStore_1stins.AgeStore_1stins(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit_EPPfirst.ACH_Deposit_EPPfirst(SSN, FileName, 0);
				ACH_Clear_Firtinst.ACH_Clear_Firtinst(SSN, FileName, 0);
				AgeStore_2ndins.AgeStore_2ndins(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Clear_Secondinst.ACH_Clear_Secondinst(SSN, FileName, 0);

			}

		}

		// Login.Login("CSR353","1234","353");

	}

	//@Test(priority = 146, groups = "kiran_TN_LOC") // Deposit Issue

	public void DFLTLoan_RCCRev_RPP_DepoAllInstWeekly() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTLoan_RCCRev_RPP_DepoAllInstWeekly_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:197" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP -> Deposit all installments on due date accordingly for Weekly customer and clear them after that");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCCRevoke.RCCRevoke(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 3);
				RPP.RPP(SSN, FileName);
				RPP_Status.RPP_Status(SSN, FileName);
				AgeStore_RPP.AgeStore_RPP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA_RPP.NACHA_RPP(SSN, FileName, -1, 2);
				ACH_Deposit_RPP.ACH_Deposit_RPP(SSN, FileName, 0, 2);
				ACH_Clear2.ACH_Clear2(SSN, FileName, 7, 2);
				AgeStore_RPP.AgeStore_RPP(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA_RPP.NACHA_RPP(SSN, FileName, -1, 3);
				ACH_Deposit_RPP.ACH_Deposit_RPP(SSN, FileName, 0, 3);
				ACH_Clear2.ACH_Clear2(SSN, FileName, 7, 3);

			}
		}
	}

	//@Test(priority = 147, groups = "kiran_TN_LOC") // Deposit Issue

	public void DFLTcustomer_RCCRevoke_ConvertEPP_DepositallInst_ClearallInst_Weekly_CheckStatus_Sc198()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTcustomer_RCCRevoke_ConvertEPP_DepositallInst_ClearallInst_Weekly_CheckStatus_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:198" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP -> Deposit all installments on due date accordingly for Bi Weekly customer and clear them after that");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 3);
				RPP.RPP(SSN, FileName);
				RPP_Status.RPP_Status(SSN, FileName);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA_RPP.NACHA_RPP(SSN, FileName, -1, 2);
				ACH_Deposit_RPP.ACH_Deposit_RPP(SSN, FileName, 0, 2);
				ACH_Clear_EPP.ACH_Clear_EPP(SSN, FileName, 7, 2);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA_RPP.NACHA_RPP(SSN, FileName, -1, 3);
				ACH_Deposit_RPP.ACH_Deposit_RPP(SSN, FileName, 0, 3);
				ACH_Clear_EPP.ACH_Clear_EPP(SSN, FileName, 7, 3);
				AgeStore_EPP.AgeStore_EPP(SSN, FileName, -1, 4);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA_RPP.NACHA_RPP(SSN, FileName, -1, 4);
				ACH_Deposit_RPP.ACH_Deposit_RPP(SSN, FileName, 0, 4);
				ACH_Clear_EPP.ACH_Clear_EPP(SSN, FileName, 7, 4);
				EPPStatus.EPPStatus(SSN, FileName, 2);

			}
		}
	}

	//@Test(priority = 148, groups = "kiran_TN_LOC")

	public void DFLT_RccRevoke_Epp_voidEpp__CheckWhetherStatusDefault() throws Exception {

		String FileName = "AA_DFLT_RccRevoke_Epp_voidEpp__CheckWhetherStatusDefault_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:211" + "_" + PayFrequency + "_" + CollateralType,
						"Pick an LOC Loan which is default status_Perform RCC Revoke_Convert to EPP_Void EPP Check whether status is Default ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan_Amountveriation.DrawLoan_Amountveriation(SSN, FileName, "50");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 3);
				RPP.RPP(SSN, FileName);
				EPP_Void.EPP_Void(SSN, FileName);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);

			}
		}
	}

	//@Test(priority = 149, groups = "kiran_TN_LOC") //// Deposit Issue

	public void LOCI_Draw_Stmt_Deposit_RTN_DLQ_DFLT_Rccrevoke_BNK_RccStatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Deposit_RTN_DLQ_DFLT_Rccrevoke_BNK_RccStatus_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:219" + "_" + PayFrequency + "_" + CollateralType,
						"Pick the loan to which deposit is processed with Return file with R01/R09  reason_Def_RCC revoke_BNK_RCC status should be ineligible");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 150, groups = "kiran_TN_LOC") //// Deposit Issue

	public void LOCI_Draw_Stmt_Deposit_RTN_PendingBNK_DLQ_DFLT_RccEligibility_CheckRccStatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Deposit_RTN_PendingBNK_DLQ_DFLT_RccEligibility_CheckRccStatus_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:220" + "_" + PayFrequency + "_" + CollateralType,
						"Pick the loan to which deposit is processed with Return file with R01/R09  reason_Pending BNK_Default_RCC eligibility_Check RCC eligibility");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 151, groups = "kiran_TN_LOC") // Deposit Issue

	public void LOC_Draw_Deposit_Return_BNK_Decease_Writoff() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOC_Draw_Deposit_Return_BNK_Decease_Writoff_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				test = reports.startTest(Header + "_S.No:221" + "_" + PayFrequency + "_" + CollateralType,
						"AA_LOC_Draw_Deposit_Return_BNK_Decease_Writoff_RCC Ineligible");

				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA_Regular.NACHA_Regular(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 3);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
				Check_RCCSchd_WO1.Check_RCCSchd_WO1(SSN, FileName);

			}

		}

	}

	//@Test(priority = 153, groups = "kiran_TN_LOC") // Deposit Issue

	public void LocI_Draw_Stmt_Deposit_Return_DLQ_Cure_DEF_WO_CheckEligibilityofRCC() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Deposit_RTN_PendingBNK_DLQ_DFLT_RccEligibility_CheckRccStatus_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:220" + "_" + PayFrequency + "_" + CollateralType,
						"Pick the loan to which deposit is processed with Return file with R01/R09  reason_Pending BNK_Default_RCC eligibility_Check RCC eligibility");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 154, groups = "kiran_TN_LOC") // Deposit Issue

	public void LOCI_Draw_Stmt_Deposit_RTN_DFLT_RCCRevoke_RCCStatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Deposit_RTN_DFLT_RCCRevoke_RCCStatus_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:224" + "_" + PayFrequency + "_" + CollateralType,
						"Pick the loan to which deposit is processed with Return file with R01/R09 reason_Default_Check RCC revoke option is available_If available process it_Check RCC eligibility(should not be eligible for RCC)");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, -1);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 157, groups = "kiran_TN_LOC")

	public void LOCI_DRAW_DLQ_DFLT_RccElesibilityStatus() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DRAW_DLQ_DFLT_RccElesibilityStatus_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:227" + "_" + PayFrequency + "_" + CollateralType,
						"Pick the customer who is in Default status and Verify whether he is eligible for RCC process with collateral type as 'ACH 'or 'NOC'");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 158, groups = "kiran_TN_LOC") // Deposit Issue

	public void DFLTLoan_CheckRCCStatus_RCCSchedule_CheckInstBasedOnFrequency_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTLoan_CheckRCCStatus_RCCSchedule_CheckInstBasedOnFrequency_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:229" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan_Check RCC status should be Eligible that is 7 or Loan in RCC equal to Y_RCC schedule Or letter should be generated before 10days to the next pay date based on pay frequency _Check Installment dates should be generated based on same frequency");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				/*
				 * NACHA.NACHA(SSN, FileName, -1); ACH_Deposit.ACH_Deposit(SSN,
				 * FileName, 0); ACHReturnPosting.ACHReturnPosting(SSN,
				 * FileName);
				 */
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_Dates.Check_RCCSchd_Dates(SSN, FileName);

			}
		}

	}

	//@Test(priority = 160, groups = "kiran_TN_LOC")

	public void DFLTLoan_RCCStatusShouldbeY_ChangeFrequency_RCCSchedule_InstDatesBaseOnNewFrequency_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTLoan_RCCStatusShouldbeY_ChangeFrequency_RCCSchedule_InstDatesBaseOnNewFrequency_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:231" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan_Check RCC status should be Eligible that is 7 or Loan in RCC is Y Change customer pay frequency_ Generate RCC schedule _Check Installment due date on which frequency base its been generated It should consider the new pay frequency");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				if (CollateralType.equals("CASH")) {
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
					// FileName, 0);
				}
				if (CollateralType.equals("ACH")) {
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					NACHA.NACHA(SSN, FileName, -1);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}

				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);

				EditBorrower_ChangeFrequency_Monthly.EditBorrower_ChangeFrequency_Monthly(SSN, FileName);
				EditBorrower_Monthly.EditBorrower_Monthly(SSN, FileName, -10);
				Check_RCCSchd_Dates_Monthly.Check_RCCSchd_Dates_Monthly(SSN, FileName);

			}
		}

	}

	//@Test(priority = 161, groups = "kiran_TN_LOC")

	public void Return_ChangeFrequency_Default_LoanInRCCisY_RCCSchedule_InstDateWithNewFrequency_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Return_ChangeFrequency_Default_LoanInRCCisY_RCCSchedule_InstDateWithNewFrequency_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:232" + "_" + PayFrequency + "_" + CollateralType,
						"Return _ Change the customer pay frequency _ Default _ Check RCC status should be Eligible that is 7 or Loan in RCC is Y _ Generate RCC schedule _ Check Installment due date on which frequency schedule is generated It should consider the new pay frequency");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				if (CollateralType.equals("CASH")) {
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
					// FileName, 0);
				}
				if (CollateralType.equals("ACH")) {
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					NACHA.NACHA(SSN, FileName, -1);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				EditBorrower_ChangeFrequency_Monthly.EditBorrower_ChangeFrequency_Monthly(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower_Monthly.EditBorrower_Monthly(SSN, FileName, -10);
				Check_RCCSchd_Dates_Monthly.Check_RCCSchd_Dates_Monthly(SSN, FileName);

			}
		}

	}

	//@Test(priority = 165, groups = "kiran_TN_LOC")

	public void DFLTLoan_CheckRCCStatus_RCCRevoke_CheckRCCIneligibity_RCCAuthorization_RCCSchedule_RCCRevoke_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTLoan_CheckRCCStatus_RCCRevoke_CheckRCCIneligibity_RCCAuthorization_RCCSchedule_RCCRevoke_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:238" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan _ Check RCC status should be Eligible that is 7 or Loan in RCC is Y _ RCC revoke _ Check RCC eligibility should be Ineligible _ RCC authorization _ Check RCC schedule or letter should be generated before 10days to the next pay date based on pay frequency _ Perform RCC revoke again");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				if (CollateralType.equals("ACH")) {

					NACHA.NACHA(SSN, FileName, -1);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}

				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCCStatus_1.RCCStatus_1(SSN, FileName);
				RCCRevoke.RCCRevoke(SSN, FileName);
				RCCStatus_1.RCCStatus_1(SSN, FileName);
				RCCAuthorization.RCCAuthorization(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd.Check_RCCSchd(SSN, FileName);
				RCCRevoke.RCCRevoke(SSN, FileName);
				Check_RCCSchd.Check_RCCSchd(SSN, FileName);

			}
		}

	}

	//@Test(priority = 167, groups = "kiran_TN_LOC")

	public void DFLT_CheckRCCisY_CheckRCCBasedOnFrequency_BNK_WO_RCCInEligible_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLT_CheckRCCisY_CheckRCCBasedOnFrequency_BNK_WO_RCCInEligible_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:240" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan _ Check RCC status should be Eligible that is 7 or Loan in RCC is Y _ Check RCC schedule or letter should be generated before 10days to the next pay date based on pay frequency _ BNK _ Write off _ RCC should become Ineligible");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				if (CollateralType.equals("ACH")) {

					NACHA.NACHA(SSN, FileName, -1);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}

				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCCStatus_1.RCCStatus_1(SSN, FileName);
				RCCRevoke.RCCRevoke(SSN, FileName);
				RCCStatus_1.RCCStatus_1(SSN, FileName);
				RCCAuthorization.RCCAuthorization(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_Dates.Check_RCCSchd_Dates(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				RCCStatus_1.RCCStatus_1(SSN, FileName);
			}
		}

	}

	//@Test(priority = 169, groups = "kiran_TN_LOC")

	public void DFLTcustomer_RCC7_RCCSchedule_R1Deposit_RCCOrg_RCCoptout_CheckSch_RCCauth2ndDuedate_CheckSch_Sc246()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule_R1Deposit_RCCOrg_RCCoptout_CheckSch_RCCauth2ndDuedate_CheckSch_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:246" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan - RCC status should be 7 - Generate RCC schedule - RCC 1# deposit - Process RCC Origination - RCC opt out - Check updates whether schedule been canceled during revocation - RCC authorization on 2nd due date - Check revised schedule");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				/*
				 * AgeStore.AgeStore(SSN,FileName, 30);
				 * DrawerDeassign.DrawerDeassign(SSN, FileName);
				 * StatementGeneration_EODProcessing.
				 * StatementGeneration_EODProcessing(SSN, FileName);
				 * StoreInfo.StoreInfo(SSN, FileName);
				 * Safeassign.Safeassign(SSN, FileName);
				 * Drawerassign.Drawerassign(SSN, FileName);
				 */
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCCSchduleStatus.RCCSchduleStatus(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, 0, 3);
				RCCAuthorization.RCCAuthorization(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);

			}
		}
	}

	//@Test(priority = 171, groups = "kiran_TN_LOC") // Run scenario.scenario with
													// store date need to check
													// again for the date

	public void DFLTcustomer_RCC7_RCCSchedule_Beforeduedate_Payfirstinsttwithcash_Voidpymt_CheckRevisedSch_RCCRevoke_CheckSch_Sc253()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule_Beforeduedate_Payfirstinsttwithcash_Voidpymt_CheckRevisedSch_RCCRevoke_CheckSch_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:253" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan - RCC eligibility should be 7- Generate RCC letter - RCC 1 - Before due date pay full through cash - last installment should be cancelled in ACH_STAGING- Void payment - check Revised schedule- RCC revoke - Check schedule ,no further deposits processed in future(IS_RCCP_REJECETD column should be 'Y')");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				/*
				 * AgeStore.AgeStore(SSN,FileName, 30);
				 * DrawerDeassign.DrawerDeassign(SSN, FileName);
				 * StatementGeneration_EODProcessing.
				 * StatementGeneration_EODProcessing(SSN, FileName);
				 * StoreInfo.StoreInfo(SSN, FileName);
				 * Safeassign.Safeassign(SSN, FileName);
				 * Drawerassign.Drawerassign(SSN, FileName);
				 */
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				Default_pymt_BeforeDueDate_1stInst.Default_pymt_BeforeDueDate_1stInst(SSN, FileName, -1, 2);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				Void_1st_inst_Payment.Void_1st_inst_Payment(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}
	}

	//@Test(priority = 174, groups = "kiran_TN_LOC")

	public void DeflutLoan_RccElegibility_GenerateRcc_Morethan1stinstallmentPayment_Void_CheckTheRccChanges()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DeflutLoan_RccElegibility_GenerateRcc_Morethan1stinstallmentPayment_Void_CheckTheRccChanges_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:260" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan_RCC eligibility should be '7'_Generate RCC letter_On due date pay excess amount than installment amount_Check RCC schedule for updated changes_The paid excess amount should be apportioned to last installment amount_Void payment_Check Revised schedule(Deleted/Cancelled installments should be revised ) )");

				/*
				 * Login.Login(UserName, Password, StoreId);
				 * 
				 * BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
				 * test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
				 * DrawLoan1.DrawLoan1(SSN, FileName);
				 * StatementGeneration.StatementGeneration(SSN, FileName);
				 * 
				 * if(CollateralType.equals("ACH")){ AgeStore.AgeStore(SSN,
				 * FileName, -1); DrawerDeassign.DrawerDeassign(SSN, FileName);
				 * StatementGeneration_EODProcessing.
				 * StatementGeneration_EODProcessing(SSN, FileName);
				 * StoreInfo.StoreInfo(SSN, FileName);
				 * Safeassign.Safeassign(SSN, FileName);
				 * Drawerassign.Drawerassign(SSN, FileName); NACHA.NACHA(SSN,
				 * FileName, -1); AgeStore.AgeStore(SSN, FileName, 0);
				 * ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				 * ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				 * } if(CollateralType.equals("CASH")) { AgeStore.AgeStore(SSN,
				 * FileName, 0); DrawerDeassign.DrawerDeassign(SSN, FileName);
				 * StatementGeneration_EODProcessing.
				 * StatementGeneration_EODProcessing(SSN, FileName);
				 * StoreInfo.StoreInfo(SSN, FileName);
				 * Safeassign.Safeassign(SSN, FileName);
				 * Drawerassign.Drawerassign(SSN, FileName);
				 * //EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				 * FileName, 0);
				 * DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				 * } AgeStore.AgeStore(SSN, FileName, 10);
				 * DrawerDeassign.DrawerDeassign(SSN, FileName);
				 * StatementGeneration_EODProcessing.
				 * StatementGeneration_EODProcessing(SSN, FileName);
				 * StoreInfo.StoreInfo(SSN, FileName);
				 * Safeassign.Safeassign(SSN, FileName);
				 * Drawerassign.Drawerassign(SSN, FileName);
				 * //EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				 * FileName, 10); CurePaymentStatus.CurePaymentStatus(SSN,
				 * FileName); CustomerDefault.CustomerDefault(SSN, FileName);
				 * DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				 * EditBorrower.EditBorrower(SSN, FileName, -10);
				 * RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(
				 * SSN, FileName, -1, 2); DrawerDeassign.DrawerDeassign(SSN,
				 * FileName); StatementGeneration_EODProcessing.
				 * StatementGeneration_EODProcessing(SSN, FileName);
				 * StoreInfo.StoreInfo(SSN, FileName);
				 * Safeassign.Safeassign(SSN, FileName);
				 * Drawerassign.Drawerassign(SSN, FileName);
				 * RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(
				 * SSN, FileName, 0, 2); Default_pymt_onduedate_.
				 * Default_pymt_onduedate_1stInst_MorethaninstAmount(SSN,
				 * FileName, 0, 2); DFLTPmt_Void.DFLTPmt_Void(SSN, FileName);
				 */
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);

			}
		}

	}

	// //@Test (priority=176,groups = "kiran_TN_LOC")

	//@Test(priority = 176, groups = "kiran_TN_LOC")
	public void LOCI_DFLT_GenerateRCCSchedule_RCC1stDeposit_RccOrigination_RccOutout_CheckUpdates_RccAuthorization_CheckUpdates()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DFLT_GenerateRCCSchedule_RCC1stDeposit_RccOrigination_RccOutout_CheckUpdates_RccAuthorization_CheckUpdates_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:262" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan_RCC status should be 7_Generate RCC schedule_RCC 1# deposit_Process RCC Origination_RCC opt out_Check updates whether schedule been canceled during revocation_New perform RCC Authorization_Check updates for is_canceled flag is updated to N");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

				if (CollateralType.equals("ACH")) {
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					NACHA.NACHA(SSN, FileName, -1);
					AgeStore.AgeStore(SSN, FileName, 0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				if (CollateralType.equals("CASH")) {
					AgeStore.AgeStore(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
					// FileName, 0);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);

				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);
				RCCAuthorization.RCCAuthorization(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
			}
		}

	}

	//@Test(priority = 177, groups = "kiran_TN_LOC")

	public void LOCI_DEF_RccSechdule_Deposit_ReturnWithR02_ElegibleforRpp() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_DEF_RccSechdule_Deposit_ReturnWithR02_ElegibleforRpp_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:266" + "_" + PayFrequency + "_" + CollateralType,
						"Def_RCC Schedule_deposit_return_return with R02_Eligible for RPP");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);

				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				RCC_Return_WithR02.RCC_Return_WithR02(SSN, FileName);
				Check_EPP.Check_EPP(SSN, FileName);

			}
		}

	}

	//@Test(priority = 178, groups = "kiran_TN_LOC")

	public void LOCInit_Draw_Stmt_DLQ_Cure_DFLT_RCCSchedule_DepositlastInst_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCInit_Draw_Stmt_DLQ_Cure_DFLT_RCCSchedule_DepositlastInst_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_kiran") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_kiran");
				UserName = prop.getProperty("UserName_TN_LOC_kiran");
				Password = prop.getProperty("Password_TN_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:267" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init _ Draw _Stat _ delinquent _ Cure _ Default  _ generate RCC Schedule  _  Deposit the last installment ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 3);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 3);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 3);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 4);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 4);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 4);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);

			}
		}
	}

	// Venkat scenarios

	////@Test(priority = 180, groups = "venkat_TN_LOC")

	public void LOCInit_Draw_Stmt_DLQ_Cure_DFLT_RCCSchedule_DepositlastInst_ClearLastInst_ReturnLastInst_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCInit_Draw_Stmt_DLQ_Cure_DFLT_RCCSchedule_DepositlastInst_ClearLastInst_ReturnLastInst_Txn_TestData.xls";
		
		String path=System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat");     
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:269" + "_" + PayFrequency + "_" + CollateralType, "LOC Init _ Draw _ Stat _ delinquent _ Cure _ Default   _ generate RCC Schedule  _  Deposit the last installment _ Clear_ Then return the last installment ACH/RCC/NOC STORE/Online/PAM  ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 3);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 3);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 3);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 4);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 4);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 4);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 4);
				RCC_Return.RCC_Return(SSN, FileName);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);

			}
		}
	}

	// //@Test (priority=181,groups = "venkat_TN_LOC")

	public void LOCInit_Draw_Stmt_DLQ_Cure_DFLT_RCCSchedule_DepositlastInst_ReturnLastInst_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCInit_Draw_Stmt_DLQ_Cure_DFLT_RCCSchedule_DepositlastInst_ReturnLastInst_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:270" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init _ Draw _ Stat _ delinquent _ Cure _ Default   _ generate RCC Schedule  _  Deposit the last installment _ Then return the last installment ACH/RCC/NOC STORE/Online/PAM  ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan_LOC.NewLoan_LOC(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 3);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 3);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 3);
				RCC_Return.RCC_Return(SSN, FileName);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);

			}
		}
	}

	//@Test(priority = 182, groups = "venkat_TN_LOC")

	public void LOCInit_Draw_Stmt_delinquent_Cure_Default_RCCschedulewith2Inst_1stInstDeposit_Clear_2ndDFLTPmt_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCInit_Draw_Stmt_delinquent_Cure_Default_RCCschedulewith2Inst_1stInstDeposit_Clear_2ndDFLTPmt_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:271" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init _ Draw _ Stat _ delinquent _ Cure _ Default  _ generate RCC Schedule with 2 installments  _  1st installment Deposit _ Clear _ Next Default Payment ACH RCC NOC STORE Online PAM ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName); DrawLoan1.DrawLoan1(SSN,
				 * FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				Default_pymt_BeforeDueDate_lastInst.Default_pymt_BeforeDueDate_lastInst(SSN, FileName, -2, 3);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);

			}
		}
	}

	//@Test(priority = 183, groups = "venkat_TN_LOC")

	public void LOCI_Draw_stmt_DLQ_Cure_DFLT_GenerateRCC_ACTM_ACTMEnd_EODbeforeDueDate_Sc277() throws Exception {

		// Start test. Mention test script name
		String FileName = "LOCI_Draw_stmt_DLQ_Cure_DFLT_GenerateRCC_ACTM_ACTMEnd_EODbeforeDueDate_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:277" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init - Draw – Stat – delinquent - Cure – Default  – generate RCC Schedule  ? Active military ? Terminate form Active Military ? EOD before Deposit due date	");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName);
				 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				 * DrawLoan1.DrawLoan1(SSN, FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -5, 2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -3, 2);
				Active_Military_End.Active_Military_End(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				EODProcessing_with_recordsChecking.EODProcessing_with_recordsChecking(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

			}
		}
	}

	//@Test(priority = 184, groups = "venkat_TN_LOC")

	public void LOCI_Draw_stmt_DLQ_Cure_DFLT_GenerateRCC_ACTM_ACTMEnd_EODonDueDate_Sc278() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_DLQ_Cure_DFLT_GenerateRCC_ACTM_ACTMEnd_EODonDueDate_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:278" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init - Draw – Stat – delinquent - Cure – Default  – generate RCC Schedule  ? Active military ? Terminate form Active Military ? EOD on Deposit due date	");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName);
				 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				 * DrawLoan1.DrawLoan1(SSN, FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -5, 2);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, 0, 2);
				Active_Military_End.Active_Military_End(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, 0, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				EODProcessing_with_recordsChecking.EODProcessing_with_recordsChecking(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

			}
		}
	}

	//@Test(priority = 185, groups = "venkat_TN_LOC")

	public void DFLTcustomer_RCC7_RCCSchedule__lastinstdeposit_Bnkruptwithoutclear_Sc280() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule__lastinstdeposit_Bnkruptwithoutclear_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:280" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan ? RCC eligibility should be 7 ?  Generate RCC letter ? After the last installment Deposit  ? Don't process clear ? Bankrupt ? Customer should not be allowed to Bankrupt. ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName);
				 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				 * DrawLoan1.DrawLoan1(SSN, FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, 1, 2);
				Bankrupt_Notprocessed.Bankrupt_Notprocessed(SSN, FileName);

			}
		}
	}

	// //@Test (priority=186,groups = "venkat_TN_LOC") - Not required

	public void DFLTcustomer_RCC7_RCCSchedule__lastinstdeposit_Bnkruptwithclear_Sc281() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule__lastinstdeposit_Bnkruptwithclear_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:281" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan ? RCC eligibility should be 7-> Generate RCC letter ? After the last installment Deposit  ? Process clear ? Bankrupt ? Customer should be allowed to Bankrupt.");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan_LOC.NewLoan_LOC(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 3);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 3);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 3);
				Bankrupt_NoRecord.Bankrupt_NoRecord(SSN, FileName);

			}
		}
	}

	//@Test(priority = 187, groups = "venkat_TN_LOC")

	public void DFLTcustomer_RCC7_RCCSchedule__lastinstdeposit_Bnkruptwithclear_VoidBNK_Sc282() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule__lastinstdeposit_Bnkruptwithclear_VoidBNK_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:282" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan ? RCC eligibility should be 7-> Generate RCC letter ? After the last installment Deposit  ? Process clear ? void Bankrupt.");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName);
				 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				 * DrawLoan_Amountveriation.DrawLoan_Amountveriation(SSN,
				 * FileName, "50");
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				Bankrupt_NoRecord.Bankrupt_NoRecord(SSN, FileName);
				Bankrupt_NoRecord_void.Bankrupt_NoRecord_void(SSN, FileName);

			}
		}
	}

	// //@Test (priority=188,groups = "venkat_TN_LOC") //Not Required

	public void DFLTcustomer_RCC7_RCCSchedule__Bankruptcy_RCCStatusverification_Sc283() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule__Bankruptcy_RCCStatusverification_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:283" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan_RCC eligibilityshouldbe7_Generate RCC letter_After the Schedule generation_Bankrupt");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan_LOC.NewLoan_LOC(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -3, 2);
				Bankrupt.Bankrupt(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);
			}
		}
	}

	//@Test(priority = 189, groups = "venkat_TN_LOC")

	public void DFLTcustomer_RCC7_RCCSchedule__Bankruptcy_VoidBNK_RCCStatusverification_Sc284() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule__Bankruptcy_VoidBNK_RCCStatusverification_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:284" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan_RCC eligibility should be 7_Generate RCC letter_After the Schedule generation_Bankrupt_Void Bankrupt");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName);
				 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				 * DrawLoan1.DrawLoan1(SSN, FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -3, 2);
				Bankrupt.Bankrupt(SSN, FileName);
				Bankrupt_Void.Bankrupt_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);
			}
		}
	}

	// //@Test (priority=190,groups = "venkat_TN_LOC") - Not required

	public void DFLTcustomer_RCC7_RCCSchedule__PendingBankruptcy_RCCSchnotgenerated_Sc285() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule__PendingBankruptcy_RCCSchnotgenerated_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:285" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan_Place customer in Pending Bankrupt_Try to generate schedule 10 days before next pay date.");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}
	}

	//@Test(priority = 191, groups = "venkat_TN_LOC")

	public void DFLTcustomer_RCC7_RCCSchedule__PendingBankruptcy_VoidPendingBnkrupt_VerifyRCCSchedule_Sc286()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule__PendingBankruptcy_VoidPendingBnkrupt_VerifyRCCSchedule_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:286" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan_Void Pending Bankrupt_Try to generate schedule 10 days before next pay date_schedule must be generated");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName);
				 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				 * DrawLoan1.DrawLoan1(SSN, FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				PendingBNK_Void.PendingBNK_Void(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);

			}
		}
	}

	//@Test(priority = 192, groups = "venkat_TN_LOC")

	public void DeflutLoan__GenerateRcc_PendingBNK_DepositNotBeProcessed() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DeflutLoan__GenerateRcc_PendingBNK_DepositNotBeProcessed_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:287" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan_RCC eligibility should be 7_Generate RCC letter_Place customer in Pending Bankrupt_Deposits must not be processed for the customer )");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

				if (CollateralType.equals("ACH")) {
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					NACHA.NACHA(SSN, FileName, -1);
					AgeStore.AgeStore(SSN, FileName, 0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				if (CollateralType.equals("CASH")) {
					AgeStore.AgeStore(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 193, groups = "venkat_TN_LOC")

	public void DeflutLoan__GenerateRcc_PendingBNK_VoidPendingBNK_DepositNotBeProcessed() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_DeflutLoan__GenerateRcc_PendingBNK_VoidPendingBNK_DepositNotBeProcessed_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:288" + "_" + PayFrequency + "_" + CollateralType,
						"Pick Default status loan_RCC eligibility should be 7_Generate RCC letter_Place customer in Pending Bankrupt_Deposits must not be processed for the customer )");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

				if (CollateralType.equals("ACH")) {
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					NACHA.NACHA(SSN, FileName, -1);
					AgeStore.AgeStore(SSN, FileName, 0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				if (CollateralType.equals("CASH")) {
					AgeStore.AgeStore(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				PendingBNK.PendingBNK(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);
				PendingBNK_Void.PendingBNK_Void(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 194, groups = "venkat_TN_LOC")

	public void LocI_Draw_Stmt_Deposit_Return_DLQ_Cure_DEF_WO_CheckEligibilityofRCC1() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LocI_Draw_Stmt_Deposit_Return_DLQ_Cure_DEF_WO_CheckEligibilityofRCC_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:289" + "_" + PayFrequency + "_" + CollateralType,
						" LOC Init_Draw_Stat_Deposit_Return with R01 and R09_delinquent_Cure_DEF_WO_Check Eligibility of RCC  )");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				if (CollateralType.equals("ACH")) {
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					NACHA.NACHA(SSN, FileName, -1);
					AgeStore.AgeStore(SSN, FileName, 0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				if (CollateralType.equals("CASH")) {
					AgeStore.AgeStore(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 90);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	// //@Test (priority=195,groups = "venkat_TN_LOC") - Not required

	public void LocI_Draw_Stmt_Deposit_otherthan1and9Return_DLQ_Cure_DEF_WO_CheckEligibilityofRCC() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LocI_Draw_Stmt_Deposit_otherthan1and9Return_DLQ_Cure_DEF_WO_CheckEligibilityofRCC_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:290" + "_" + PayFrequency + "_" + CollateralType,
						"  LOC Init_Draw_Stat_Deposit_Return with other than R01 and R09_delinquent_Cure_DEF_WO_Check Eligibility of RCC   )");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);

				if (CollateralType.equals("ACH")) {
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					NACHA.NACHA(SSN, FileName, -1);
					AgeStore.AgeStore(SSN, FileName, 0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting_OtherthanR01_R09.ACHReturnPosting_OtherthanR01_R09(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				if (CollateralType.equals("CASH")) {
					AgeStore.AgeStore(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 196, groups = "venkat_TN_LOC")

	public void LOCI_Draw_stmt_Deposit_ReturnwithR01_DLQ_Cure_WO_PendingBNK_Deceased_EligibilityRCC_Sc291()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_Deposit_ReturnwithR01_DLQ_Cure_WO_PendingBNK_Deceased_EligibilityRCC_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:291" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init – Draw – Stat – Deposit – Return with R01 and R09 - delinquent – Cure – WO – WO – Bankrupt/Pending Bankrupt/Deceased -Check Eligibility of RCC");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName);
				 * AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				 * DrawLoan1.DrawLoan1(SSN, FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 3);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 30);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				PendingBNK.PendingBNK(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}
	}

	//@Test(priority = 197, groups = "venkat_TN_LOC")

	public void LOCInit_Draw_Stmt_Dep_ReturnR01andR09_DLQT_Cure_ACHRevoke_WO_CheckRCC_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCInit_Draw_Stmt_Dep_ReturnR01andR09_DLQT_Cure_ACHRevoke_WO_CheckRCC_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:291" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init _ Draw _ Statmnt _ Deposit _ Return with R01 and R09 _ delinquent _ Cure _ ACH Optout _ WO _ WO _Check Eligibility of RCC");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName); DrawLoan1.DrawLoan1(SSN,
				 * FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);

				if (CollateralType.equals("ACH")) {
					NACHA.NACHA(SSN, FileName, -1);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				}
				// EditBorrower_ChangeFrequency_Monthly.EditBorrower_ChangeFrequency_Monthly(SSN,
				// FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				// EODProcessing.EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				ACH_Revoke.ACH_Revoke(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 90);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 198, groups = "venkat_TN_LOC")

	public void LOCInit_Draw_Stmt_delinquent_Cure_WO_RCCSchd_WORecoveryfullPmt_RCCSCheduleCancel_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCInit_Draw_Stmt_delinquent_Cure_WO_RCCSchd_WORecoveryfullPmt_RCCSCheduleCancel_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:293" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init _ Draw _ Stat _ delinquent _ Cure _ WO _ WO _ RCC Schedule _ Full WO Recovery payment _RCC Schedules should be canceled ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName); DrawLoan1.DrawLoan1(SSN,
				 * FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				Check_RCCSchd.Check_RCCSchd(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);

			}
		}

	}

	//@Test(priority = 199, groups = "venkat_TN_LOC")

	public void LOCInit_Draw_Stmt_delinquent_Cure_WO_RCCSchd_WORecoveryfullPmt_VoidWORecovery_RCCSCheduleRevise_IsLoanRCCN()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCInit_Draw_Stmt_delinquent_Cure_WO_RCCSchd_WORecoveryfullPmt_VoidWORecovery_RCCSCheduleRevise_IsLoanRCCN_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:294" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init _ Draw _ Stat _ delinquent _ Cure _ WO _ WO _ RCC Schedule _ Full WO Recovery payment _ Void WO Recovery payment _RCC Schedules should be revised, is_ canceled flag should be updated to N ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName); DrawLoan1.DrawLoan1(SSN,
				 * FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				Check_RCCSchd.Check_RCCSchd(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				WORecovery_Void.WORecovery_Void(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);

			}
		}

	}

	//@Test(priority = 200, groups = "venkat_TN_LOC")

	public void LOCI_Draw_Stmt_delinquent_Cure_DFLT_WO_RCCScdl_RCCRev_RCCCancelled_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_delinquent_Cure_DFLT_WO_RCCScdl_RCCRev_RCCCancelled_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_venkat") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_venkat");
				UserName = prop.getProperty("UserName_TN_LOC_venkat");
				Password = prop.getProperty("Password_TN_LOC_venkat");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_venkat");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:295" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init – Draw – Stat – delinquent – Cure – WO - WO – RCC Schedule – RCC Revoke --RCC Schedules should be canceled ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				/*
				 * NewLoan.NewLoan(SSN,FileName); DrawLoan1.DrawLoan1(SSN,
				 * FileName);
				 */
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower1.EditBorrower1(SSN, FileName);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				Check_RCCSchd.Check_RCCSchd(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCCRevoke.RCCRevoke(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}
	

	// Anji Reddy scenarios

	// //@Test(priority=201,groups = "anji_TN_LOC")

	public void LOCI_Draw_Stmt_delinquent_Cure_WO_RCCScdl_RCCRevoke_Authorizeafter1month_RCCRevise() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_delinquent_Cure_WO_RCCScdl_RCCRevoke_Authorizeafter1month_RCCRevise_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:296" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init _ Draw _ Stat _ delinquent _ Cure _ WO _ WO _ RCC Schedule _ RCC Revoke _ Authorize after 1 month _RCC Schedules should be extended with revised schedule. ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				Check_RCCSchd.Check_RCCSchd(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCCRevoke.RCCRevoke(SSN, FileName);
				AgeStore_RCC.AgeStore_RCC(SSN, FileName, 30);
				RCCAuthorization.RCCAuthorization(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCCStatus.RCCStatus(SSN, FileName);
				// history.history(SSN, FileName);

			}
		}

	}

	//@Test(priority = 203, groups = "anji_TN_LOC")

	public void LOCI_Draw_Stmt_Dlqt_Cure_WO_RCCSchdl_1stInstDep_clear_NextInstPartPmt_RCCScdlReviseBalAmt_()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Dlqt_Cure_WO_RCCSchdl_1stInstDep_clear_NextInstPartPmt_RCCScdlReviseBalAmt_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:298" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init _ Draw _ Stat _ delinquent _ Cure _ DFLT _ WO _ RCC Schedule _ 1st installment deposit _ clear _ Next installment make partial installment amount payment _RCC Schedules should be revised with balance amount only  ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, 4, 3);
				Writoff_Recovery.Writoff_Recovery(SSN, FileName);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 0);
				// history.history(SSN, FileName);

			}
		}
	}

	// //@Test(priority=204,groups = "anji_TN_LOC")

	public void DFLTLoan_WO_RCCStatusShouldbeY_ChangeFrequency_RCCSchedule_InstDatesBaseOnNewFrequency_()
			throws Exception {

		String FileName = "AA_DFLTLoan_WO_RCCStatusShouldbeY_ChangeFrequency_RCCSchedule_InstDatesBaseOnNewFrequency__Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:299" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init _ Draw _ Stat _ delinquent _ Cure _ WO _ WO _ Check RCC status should be Eligible i.e. 7 or Loan in RCC is Y _Change customer pay frequency _ Generate RCC schedule _Check Installment due date on which frequency base its been generated _Application should consider the new pay frequency  ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan_Amountveriation.DrawLoan_Amountveriation(SSN, FileName, "400");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower_ChangeFrequency_Monthly.EditBorrower_ChangeFrequency_Monthly(SSN, FileName);
				EditBorrower_Monthly.EditBorrower_Monthly(SSN, FileName, -10);
				EditBorrower_Monthly.EditBorrower_Monthly(SSN, FileName, -3);
				Check_RCCSchd_Dates_Monthly.Check_RCCSchd_Dates_Monthly(SSN, FileName);
				// history.history(SSN, FileName);

			}
		}

	}

	//@Test(priority = 206, groups = "anji_TN_LOC")

	public void LOCI_Draw_Stmt_Dlqt_Cure_WO_RCCSchdl_1stInstDep_clear_2ndInstDep_1stInstRet() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_Dlqt_Cure_WO_RCCSchdl_1stInstDep_clear_2ndInstDep_1stInstRet_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:301" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init _ Draw _ Stat _ delinquent _ Cure _ DFLT _ WO _ RCC Schedule _ 1st installment deposit _ clear _2nd installment deposit _ 1st installment Return  ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan_Amountveriation.DrawLoan_Amountveriation(SSN, FileName, "400");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 3);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 3);
				RCC_Return.RCC_Return(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 0);
				// history.history(SSN, FileName);

			}
		}
	}

	//@Test(priority = 207, groups = "anji_TN_LOC")

	public void LOCI_Draw_Stmt_DLQ_Cure_Default_WO_1stinst_return_2ndinst_Return_3rdinst_Return() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_DLQ_Cure_Default_WO_1stinst_return_2ndinst_Return_3rdinst_Return_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:303" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init_Draw_Stat_delinquent_Cure_Dfult_WO_1st installment deposit_Return_2nd installment deposit_Return_3rd installment deposit_Return");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan_Amountveriation.DrawLoan_Amountveriation(SSN, FileName, "170");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, 2, 2);
				RCC_Return.RCC_Return(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 3);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 3);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, 2, 3);
				RCC_Return.RCC_Return(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 4);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 4);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 4);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, 2, 4);
				RCC_Return.RCC_Return(SSN, FileName);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
				// history.history(SSN, FileName);

			}
		}
	}

	//@Test(priority = 208, groups = "anji_TN_LOC")

	public void DFLT_WO_RccSChedule_RccRevoke_Epp_voidEpp_RccAuthorzation_CustomershouldeligibleforRCCnow()
			throws Exception {

		// Start test. Mention test script name

		String FileName = "AA_DFLT_WO_RccSChedule_RccRevoke_Epp_voidEpp_RccAuthorzation_CustomershouldeligibleforRCCnow_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);

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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:304" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init_Draw_Stat_delinquent_Cure_WO_WO_RCC Schedule generated_RCC Revoke_EPP_Void EPP_RCC Authozation_Customer should eligible for RCC now ");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan_Amountveriation.DrawLoan_Amountveriation(SSN, FileName, "50");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 3);
				RPP.RPP(SSN, FileName);
				EPP_Void.EPP_Void(SSN, FileName);
				RCCAuthorization.RCCAuthorization(SSN, FileName);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
				// history.history(SSN, FileName);

			}
		}
	}

	//@Test(priority = 209, groups = "anji_TN_LOC")

	public void LOCI_Draw_Stmt_DLQ_Cure_Default_WO_DepositLastInstall_LoanshouldnotBeClosed() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmt_DLQ_Cure_Default_WO_DepositLastInstall_LoanshouldnotBeClosed_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:305" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init_Draw -Stat_delinquent_Cure_WO_WO_WO_generate RCC Schedule_Deposit the last installment_Loan should not be closed");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan_Amountveriation.DrawLoan_Amountveriation(SSN, FileName, "70");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
				// history.history(SSN, FileName);

			}
		}
	}

	//@Test(priority = 210, groups = "anji_TN_LOC")

	public void LOCI_Draw_Stmt_DLQ_Cure_Default_WO_DepositandClearLastInstall_LoanshouldBeClosed() throws Exception {

		// Start test. Mention test script name

		String FileName = "AA_LOCI_Draw_Stmt_DLQ_Cure_Default_WO_DepositandClearLastInstall_LoanshouldBeClosed_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:306" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init_Draw_Stat_delinquent_Cure_WO_WO_generate RCC Schedule_Deposit the last installmentClear last installment_Last installment deposit and clear Loan should be closed");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan_Amountveriation.DrawLoan_Amountveriation(SSN, FileName, "70");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
				// history.history(SSN, FileName);

			}
		}
	}

	//@Test(priority = 211, groups = "anji_TN_LOC")

	public void LOCI_Draw_Stmt_DLQ_Cure_Default_WO_DepositandReturnLastInstall_Loanshouldbeupdatedtopreviousstatusandscheduleshouldberevised()
			throws Exception {

		// Start test. Mention test script name

		String FileName = "AA_LOCI_Draw_Stmt_DLQ_Cure_Default_WO_DepositandReturnLastInstall_Loanshouldbeupdatedtopreviousstatusandscheduleshouldberevised_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:308" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init_Draw_Stat_delinquent_Cure_WO_WO_generate RCC Schedule_Deposit the last installment_Then return the last installment_Loan should be updated to previous status and schedule should be revised");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
				DrawLoan_Amountveriation.DrawLoan_Amountveriation(SSN, FileName, "120");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Default_WOProc.Default_WOProc(SSN, FileName, 60);
				WOPaymentStatus.WOPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
				Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 3);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 3);
				LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 3);
				RCC_Return.RCC_Return(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
				// history.history(SSN, FileName);

			}
		}
	}

	//@Test(priority = 213, groups = "anji_TN_LOC")

	public void LOCI_WKY_Bim_Bi_Draw_Stmt_Dep_Return_PartialPayment_RepDep() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_WKY_Bim_Bi_Draw_Stmt_Dep_Return_PartialPayment_RepDep_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:311" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init MON) Customer =>Draw_Stmnt_Dep_Return_Rep Dep should not be posted");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				NACHA.NACHA(SSN, FileName, -1);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				PartialPayment.PartialPayment(SSN, FileName);
				Represent_Status.Represent_Status(SSN, FileName);
				Represent_AgeStore.Represent_AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Represent_NACHA.Represent_NACHA(SSN, FileName, 0);
				Represent_ACHDep.Represent_ACHDep(SSN, FileName, 1);
				Represent_Status.Represent_Status(SSN, FileName);
				// history.history(SSN, FileName);

			}
		}

	}

	//@Test(priority = 214, groups = "anji_TN_LOC")

	public void LOCI_wky_Bim_Bi_Draw_Stmt_Dep_Return_RepDep_Clear_Return() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_wky_Bim_Bi_Draw_Stmt_Dep_Return_RepDep_Clear_Return_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:312" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init WKY/BIM/BI) Customer_Draw-Stmnt_Dep-Return_Rep Dep_Clear_return");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoanDraw.NewLoanDraw(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				NACHA.NACHA(SSN, FileName, -1);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 2);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Represent_AgeStore.Represent_AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Represent_NACHA.Represent_NACHA(SSN, FileName, 0);
				Represent_ACHDep.Represent_ACHDep(SSN, FileName, 1);
				Represen_ACH_Clear.Represen_ACH_Clear(SSN, FileName, 7);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				// history.history(SSN, FileName);

			}
		}

	}

	//@Test(priority = 215, groups = "anji_TN_LOC")

	public void LOCI_Draw_Stmnt_Dep_Return_RepDep_ActMilitary_RepresrecCancel_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_Stmnt_Dep_Return_RepDep_ActMilitary_RepresrecCancel_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
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
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:313_" + PayFrequency + "_" + CollateralType,
						"LOC Init WKY or BIM or BI Customer _Draw _ Stmnt _Dep _Return _Rep Dep record posted _Active Military _ Representment record should be cancelled");
				Assert.assertTrue(true);

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Represent_Status.Represent_Status(SSN, FileName);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				Represent_Status.Represent_Status(SSN, FileName);
				// history.history(SSN, FileName);

			}
		}
	}

	//@Test(priority = 216, groups = "anji_TN_LOC")

	public void LOCI_Draw_stmt_Deposit_ReturnwithR01_ACTM_ACTMEnd_RepDepRecordchouldpickforDeposit_Sc314()
			throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCI_Draw_stmt_Deposit_ReturnwithR01_ACTM_ACTMEnd_RepDepRecordchouldpickforDeposit_Txn_TestData.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_LOC_path_anji") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_TN_LOC_anji");
				UserName = prop.getProperty("UserName_TN_LOC_anji");
				Password = prop.getProperty("Password_TN_LOC_anji");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_LOC_anji");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:314" + "_" + PayFrequency + "_" + CollateralType,
						"LOC Init WKY/BIM/BI) Customer =>Draw => Stmnt =>Dep =>Return =>Rep Dep record posted =>Active Military => Terminate before representment due date =>Rep record should be picked for deposit");

				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
				// FileName, 0);
				NACHA.NACHA(SSN, FileName, -1);
				ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 3);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 4);
				Active_Military_Start.Active_Military_Start(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				Active_Military_End.Active_Military_End(SSN, FileName);
				Represent_AgeStore.Represent_AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Represent_NACHA.Represent_NACHA(SSN, FileName, 0);
				Represent_ACHDep.Represent_ACHDep(SSN, FileName, 1);
				// history.history(SSN, FileName);

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
