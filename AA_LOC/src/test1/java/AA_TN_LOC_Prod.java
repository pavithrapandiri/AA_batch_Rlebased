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

import pack.AA_LOC;
import pack.AgeStore;
import pack.Bankrupt;
import pack.BankruptStatus;
import pack.Bankrupt_AfterDismissed;
import pack.Bankrupt_Deceased;
import pack.BorrowerRegistrationpage;
import pack.Check_Draw;
import pack.Check_NewLoan;
import pack.Check_RCCSchd;
import pack.Check_RCCSchd_WO;
import pack.CurePaymentStatus;
import pack.CustomerDefault;
import pack.DLQ_Batch;
import pack.Deceased_Void_WO;
import pack.DefaultPaymentStatus;
import pack.Default_WOProc;
import pack.Dismissed_AfterBANKRUPT;
import pack.DrawLoan1;
import pack.EditBorrower;
import pack.Excel;
import pack.Login;
import pack.NewLoan;
import pack.StatementGeneration;
import pack.WOPaymentStatus;
import pack.Writoff_Recovery;

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

public class AA_TN_LOC_Prod extends AA_LOC {


	// Kiran scenarios
	
	//@Test (priority=120,groups = "kiran_TN_LOC_Prod")

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

				
				Login.Login(UserName, Password, StoreId);
				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan1.DrawLoan1(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	
	 //@Test (priority=122,groups = "kiran_TN_LOC_Prod")
	
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

	
	 //@Test (priority=124,groups = "kiran_TN_LOC_Prod")
	 
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

	
	 //@Test (priority=125,groups = "kiran_TN_LOC_Prod")
	 
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
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);		
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
			}
		}
	}

	
	 //@Test (priority=126,groups = "kiran_TN_LOC_Prod")
	 
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
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				Bankrupt.Bankrupt(SSN, FileName);
				Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
				BankruptStatus.BankruptStatus(SSN, FileName);
			}
		}
	}

	 //@Test (priority=127,groups = "kiran_TN_LOC_Prod")
	 
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
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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
	
	 //@Test (priority=128,groups = "kiran_TN_LOC_Prod")
	 
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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	
	 //@Test (priority=130,groups = "kiran_TN_LOC_Prod")
	 
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

	
	 
	//@Test (priority=131,groups = "kiran_TN_LOC_Prod")
	
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

	
	 //@Test (priority=132,groups = "kiran_TN_LOC_Prod")
	 
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

	//@Test (priority=133,groups = "kiran_TN_LOC_Prod")
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

	 //@Test (priority=134,groups = "kiran_TN_LOC_Prod")

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	 //@Test (priority=135,groups = "kiran_TN_LOC_Prod")

	public void Loan_Draw_StGn_Dfault_RCCRevoke_RPP_Dismissed_LinestatusWO() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_StGn_Default_RCCRevoke_RPP_Dismissed_LinestatusWO_Txn_Testdata.xls";
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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

 //@Test (priority=136,groups = "kiran_TN_LOC_Prod")

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	
	 //@Test (priority=137,groups = "kiran_TN_LOC_Prod")

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	 //@Test (priority=139,groups = "kiran_TN_LOC_Prod")

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RPP.RPP(SSN, FileName);
				Min_Four_PercentAmt.Min_Four_PercentAmt(SSN, FileName);

			}
		}

		// Login.Login("CSR353","1234","353");

	}
 //@Test (priority=140,groups = "kiran_TN_LOC_Prod")

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	 //@Test (priority=141,groups = "kiran_TN_LOC_Prod")

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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
	/*			AgeStore_4rthins.AgeStore_4rthins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);*/

			}
		}

	}

	 //@Test (priority=142,groups = "kiran_TN_LOC_Prod")

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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
				/*AgeStore_4rthins.AgeStore_4rthins(SSN, FileName, -2);
				EPP_Payment.EPP_Payment(SSN, FileName);*/

			}
		}

	}

	 //@Test (priority=143,groups = "kiran_TN_LOC_Prod")

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

	 //@Test (priority=144,groups = "kiran_TN_LOC_Prod") //Deposit Issue

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	//@Test(priority = 145, groups = "kiran_TN_LOC_Prod")

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	//@Test(priority = 146, groups = "kiran_TN_LOC_Prod") // Deposit Issue

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	//@Test(priority = 147, groups = "kiran_TN_LOC_Prod") // Deposit Issue

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	//@Test(priority = 148, groups = "kiran_TN_LOC_Prod")

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	//@Test(priority = 149, groups = "kiran_TN_LOC_Prod") //// Deposit Issue

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

	//@Test(priority = 150, groups = "kiran_TN_LOC_Prod") //// Deposit Issue

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

	//@Test(priority = 151, groups = "kiran_TN_LOC_Prod") // Deposit Issue

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
				Bankrupt.Bankrupt(SSN, FileName);
				Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
				Check_RCCSchd_WO1.Check_RCCSchd_WO1(SSN, FileName);

			}

		}

	}

	//@Test(priority = 153, groups = "kiran_TN_LOC_Prod") // Deposit Issue

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

	//@Test(priority = 154, groups = "kiran_TN_LOC_Prod") // Deposit Issue

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

	//@Test(priority = 157, groups = "kiran_TN_LOC_Prod")

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
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}

	}

	//@Test(priority = 158, groups = "kiran_TN_LOC_Prod") // Deposit Issue

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
		
					DLQ_Batch.DLQ_Batch(SSN,FileName,0);
					DLQ_Batch.DLQ_Batch(SSN,FileName,10);
					// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
					// FileName, 0);
				
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				Check_RCCSchd_Dates.Check_RCCSchd_Dates(SSN, FileName);

			}
		}

	}

	//@Test(priority = 160, groups = "kiran_TN_LOC_Prod")

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
				if (CollateralType.equals("CASH")) {
					DLQ_Batch.DLQ_Batch(SSN,FileName,10);

					// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
					// FileName, 0);
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

	@Test(priority = 161, groups = "kiran_TN_LOC_Prod")

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
		/*		if (CollateralType.equals("CASH")) {
					DLQ_Batch.DLQ_Batch(SSN,FileName,0);

					
				}*/
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
		/*		if (CollateralType.equals("CASH")) {
					DLQ_Batch.DLQ_Batch(SSN,FileName,10);
				}*/
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

	@Test(priority = 165, groups = "kiran_TN_LOC_Prod")

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
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
		/*		if (CollateralType.equals("ACH")) {
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
				}
*/
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	//@Test(priority = 167, groups = "kiran_TN_LOC_Prod")

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
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);

/*				if (CollateralType.equals("ACH")) {
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
				}
*/
				
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

	@Test(priority = 169, groups = "kiran_TN_LOC_Prod")

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
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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
				RCC_Revoke.RCC_Revoke(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCCSchduleStatus.RCCSchduleStatus(SSN, FileName);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, 0, 3);
				RCCAuthorization.RCCAuthorization(SSN, FileName);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);

			}
		}
	}

	@Test(priority = 171, groups = "kiran_TN_LOC_Prod") // Run scenario.scenario with
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
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				

				 
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				EditBorrower.EditBorrower(SSN, FileName, -10);
				EditBorrower.EditBorrower(SSN, FileName, -3);
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				//RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				Default_pymt_BeforeDueDate_1stInst.Default_pymt_BeforeDueDate_1stInst(SSN, FileName, -1, 2);
				//RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				Void_1st_inst_Payment.Void_1st_inst_Payment(SSN, FileName);
				//RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
				RCC_Revoke.RCC_Revoke(SSN, FileName);
			
				RCCStatus.RCCStatus(SSN, FileName);

			}
		}
	}

	@Test(priority = 174, groups = "kiran_TN_LOC_Prod")

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

				
				  Login.Login(UserName, Password, StoreId);
				 
				  BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
				  test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN,FileName);
				  DrawLoan1.DrawLoan1(SSN, FileName);
				  StatementGeneration.StatementGeneration(SSN, FileName);
					DLQ_Batch.DLQ_Batch(SSN,FileName,0);
					DLQ_Batch.DLQ_Batch(SSN,FileName,10);
				CurePaymentStatus.CurePaymentStatus(SSN,FileName);
				CustomerDefault.CustomerDefault(SSN, FileName);
				  DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				  EditBorrower.EditBorrower(SSN, FileName, -10);
				  RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
				  DrawerDeassign.DrawerDeassign(SSN, FileName);
				  StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				  StoreInfo.StoreInfo(SSN, FileName);
				 Safeassign.Safeassign(SSN, FileName);
				  Drawerassign.Drawerassign(SSN, FileName);
				 RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore( SSN, FileName, 0, 2);
				 Default_pymt_onduedate_1stInst_MorethaninstAmount.Default_pymt_onduedate_1stInst_MorethaninstAmount(SSN,FileName, 0, 2);
				 DFLTPmt_Void.DFLTPmt_Void(SSN, FileName);
				 
				RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);

			}
		}

	}

	
	@Test(priority = 176, groups = "kiran_TN_LOC_Prod")
	
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


	
					DLQ_Batch.DLQ_Batch(SSN,FileName,0);
					// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
					// FileName, 0);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	@Test(priority = 177, groups = "kiran_TN_LOC_Prod")

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
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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

	@Test(priority = 178, groups = "kiran_TN_LOC_Prod")

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
	
				DLQ_Batch.DLQ_Batch(SSN,FileName,0);
			
				DLQ_Batch.DLQ_Batch(SSN,FileName,10);
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
	public synchronized void initialize()  {
		// Create an instance of ExtentsReports class and pass report storage
		// path as a parameter
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
		
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
