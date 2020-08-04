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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pack.Void;

public class KS_LOC_Final extends AA_LOC {




	@Test(priority = 0, groups = "kiran_KS_LOC_Prod")

	public void Loan_draw_statment_draw_DLQ_statment() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_statment_Deliquent_statement_Txn_Testdata.xls";

		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
				UserName = prop.getProperty("UserName_KS_LOC_kiran");
				Password = prop.getProperty("Password_KS_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:01" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash =>Draw =>Stmnt =>Draw 2 => Draw 3=> EOD on Due Date =>DLQ =>Stmnt2");
				
               SetDate.SetDate(SSN, FileName, "01", "28", "2020");
				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				StatementGeneration.StatementGeneration(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				DrawLoan.DrawLoan(SSN, FileName, "50");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
			}
		}
	}

	@Test(priority = 1, groups = "kiran_KS_LOC_Prod")

	public void Loan_statement_Draw_DLQ_Cure_MinPayment_Draw_statment() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_statment_Draw_Deliquent_Cure_MinPayment_Draw_statement_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
				UserName = prop.getProperty("UserName_KS_LOC_kiran");
				Password = prop.getProperty("Password_KS_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:02" + "_" + PayFrequency + "_" + CollateralType,"LOCI Cash => Stmnt1 =>  Draw 1  on due date => DLQ =>Cure =>Payment of Min Pmnt Amnt => Draw => Stmnt2");
				 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
				CurePaymentStatus.CurePaymentStatus(SSN, FileName);
				PayOffLoan.PayOffLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				StatementGeneration.StatementGeneration(SSN, FileName);
				Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

			}
		}

	}

	@Test(priority = 2, groups = "kiran_KS_LOC_Prod")

	public void Loan_Draw_statement_VoidDraw_EOD__Draw_statment() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_VoidDraw_EOD_Draw_statement_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
				UserName = prop.getProperty("UserName_KS_LOC_kiran");
				Password = prop.getProperty("Password_KS_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:03" + "_" + PayFrequency + "_" + CollateralType,"LOCI Cash => Draw On stmnt date => Void Draw => `RUN EOD No deposits should be posted => Draw =>Stmnt2");
				 SetDate.SetDate(SSN, FileName, "01", "28", "2020");

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
				Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
			}
		}
	}

	@Test(priority = 3, groups = "kiran_KS_LOC_Prod")   

	public void Loan_Draw1_Draw2ACH_statement_Rescind_Draw_EOD_DLQ() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_Draw_statment_Rescind_Draw_EOD_DLQ_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
	
				AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
				UserName = prop.getProperty("UserName_KS_LOC_kiran");
				Password = prop.getProperty("Password_KS_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:04" + "_" + PayFrequency + "_" + CollateralType,"LOCI Cash => Draw 1 => Draw 2 ACH => Stmnt => Rescind => Draw => EOD On Due Date => DLQ ");

				 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				DrawLoanwithACH.DrawLoanwithACH(SSN, FileName);
				StatementGeneration_2.StatementGeneration_2(SSN, FileName);
				Rescind.Rescind(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

			}
		}
	}

	/*//@Test(priority = 4, groups = "kiran_KS_LOC_Prod")  // issue

	public void Loan_Draw_statement_Draw_Void_Rescind() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_Draw_Void_Rescind_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
				UserName = prop.getProperty("UserName_KS_LOC_kiran");
				Password = prop.getProperty("Password_KS_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:05" + "_" + PayFrequency + "_" + CollateralType,"LOC I Cash =>Draw => Stmnt => Draw 2 =>Void Draw =>Rescind Draw 1");

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

	
*/
	@Test(priority = 5, groups = "kiran_KS_LOC_Prod")

	public void Loan_Draw_statement_PartialPayment_EOD_DLQ_MinPayment_LoanCurrent_Draw() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_PartialPayment_EOD_DLQ_MinPayment_Loancurrent_Draw_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
				UserName = prop.getProperty("UserName_KS_LOC_kiran");
				Password = prop.getProperty("Password_KS_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:08" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash => Draw => Stmnt => Pmnt Partial => EOD on Due Date  =>DLQ =>Paymnt MinPayment Amount =>Loan in CURRENT => Draw ");
				 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				StatementGeneration.StatementGeneration(SSN, FileName);
				PartialPayment.PartialPayment(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				Payments.Payments(SSN, FileName);
				PaymentStatus.PaymentStatus(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "50");
				Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

			}
		}

	}

	@Test(priority = 6, groups = "kiran_KS_LOC_Prod")

	public void Loan_Draw_statment_MinPayment_Void_DLQ_Cure_Default() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_Loan_Draw_statment_MinPayment_Void_DLQ_Cure_Default_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
				UserName = prop.getProperty("UserName_KS_LOC_kiran");
				Password = prop.getProperty("Password_KS_LOC_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:10" + "_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash =>Draw =>Stmnt => Pmnt Min Payment =>On Due Date Void Pmnt => DLQ =>Cure=>DEF");
				 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "150");
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 5);
				Payments.Payments(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 6);
				EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
				CustomerDefault.CustomerDefault(SSN, FileName);
				DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
				Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
			}
		}

	}

	@Test(priority = 7, groups = "kiran_KS_LOC_Prod")

	public void LOCICash_Draw_Draw2_MakePmt_Stmnt_PmtRTN_EODduedate_DLQ() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCICash_Draw_Draw2_MakePmt_Stmnt_PmtRTN_EODduedate_DLQ_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
				UserName = prop.getProperty("UserName_KS_LOC_kiran");
				Password = prop.getProperty("Password_KS_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:15_" + PayFrequency + "_" + CollateralType,
						"LOC I Cash _Draw _ Draw 2 _ Make Pmnt _Stmnt _ Payment Return _ EOD on Due Date _DLQ");
				
				 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
				Login.Login(UserName, Password, StoreId);

				BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DrawLoan.DrawLoan(SSN, FileName, "350");
				DrawLoan.DrawLoan(SSN, FileName, "50");
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 5);
				Payments.Payments(SSN, FileName);
				StatementGeneration.StatementGeneration(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 6);
				EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

			}
		}
	}

	 @Test (priority=8,groups = "kiran_KS_LOC_Prod")

	public void LOCICash_Draw_Stmnt_PartialPmt_PayoffDueDate_Payoffvoid_DLQ_() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_LOCICash_Draw_Stmnt_PartialPmt_PayoffDueDate_Payoffvoid_DLQ_Txn_Testdata.xls";
		TestData = new Excel(
				System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
				UserName = prop.getProperty("UserName_KS_LOC_kiran");
				Password = prop.getProperty("Password_KS_LOC_kiran");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:18_" + PayFrequency + "_" + CollateralType,
						"LOCI Cash _ Draw _Stmnt _ Pmnt Partial _ On Due Date Payoff _ Void Payoff _DLQ");
				
				 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
				DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
				Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

			}
		}
	}
	
	 @Test (priority=9,groups = "kiran_KS_LOC_Prod")

		public void LOCICash_Draw_Stmnt_EOD_DLQ_CURE_DEF_PartialDFP_DFPFull_VoidDFP_() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCICash_Draw_Stmnt_EOD_DLQ_CURE_DEF_PartialDFP_DFPFull_VoidDFP_Txn_Testdata.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:26_" + PayFrequency + "_" + CollateralType,
							"LOCI Cash _Draw _Stmnt _ EOD On Due Date _DLQ _ CURE _DEF _DFP Partial _ DFP Full _Void DFP");
			
					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);

					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "350");
					StatementGeneration.StatementGeneration(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);
					CustomerDefault.CustomerDefault(SSN, FileName);
					DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
					Default_PartialPayment.Default_PartialPayment(SSN, FileName);
					Default_Payment.Default_Payment(SSN, FileName);
					DefaultPayment_Void.DefaultPayment_Void(SSN, FileName);
					DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}
		
		 @Test (priority=10,groups = "kiran_KS_LOC_Prod")

		public void LOCI_Draw_ACTMSamedrawday_stmt() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_Draw_ACTMSamedrawday_stmt_Txn_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:61" + "_" + PayFrequency + "_" + CollateralType,
							"LOC Initiation - Draw - active Military(same day) =>Statement");
			
					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);

					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);

					AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 3); 
					DrawLoan.DrawLoan(SSN, FileName, "350");
					Active_Military_Start.Active_Military_Start(SSN, FileName);
					StatementGeneration.StatementGeneration(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}

		/*@Test (priority=11,groups = "kiran_KS_LOC_Prod6")  // Deliquent issue after active military 26-02-2020

		public void LOCI_ACTM_Drawshouldnotbeavailable_stmt_DLQ_CURE_DFLT_Sc62() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_ACTM_Drawshouldnotbeavailable_stmt_DLQ_CURE_DFLT_Txn_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:62" + "_" + PayFrequency + "_" + CollateralType,
							"LOC Initiation - active Military - Draw - Statement - DLQ - CURE - Default");
					SetCurrentDate_Default.SetCurrentDate1(SSN, FileName, "01","11","2020");
					Login.Login(UserName, Password, StoreId);

					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
					Active_Military_Start.Active_Military_Start(SSN, FileName);
					AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
					DrawLoan.DrawLoan(SSN, FileName, "350");
					StatementGeneration.StatementGeneration(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);
					CustomerDefault.CustomerDefault(SSN, FileName);
					DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
					Default_WOProc.Default_WOProc(SSN, FileName, 35); 
					WOPaymentStatus.WOPaymentStatus(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}
*/
		@Test (priority=12,groups = "kiran_KS_LOC_Prod")

		public void LOCI_Draw_ACTM_stmt_ACTMEnd_Payoff_Clear() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Payoff_Clear_Txn_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:63" + "_" + PayFrequency + "_" + CollateralType,
							"LOC Initiation - Draw -> active Military - Statement - Terminate active Military - Payoff =>Clear");
					SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}
		
		@Test (priority=13,groups = "kiran_KS_LOC_Prod") //deposit issue after Active_Military

		public void LOCI_Draw_ACTM_stmt_ACTMEnd_Deposit_ACTM_PaymentwithCash_ACTMEnd_Stmt2_Sc64() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Deposit_ACTM_PaymentwithCash_ACTMEnd_Stmt2_Txn_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:65" + "_" + PayFrequency + "_" + CollateralType,
							"Loan Initiation -> Draw -> Active Military start -> Statement -> Active Military end -> Deposit -> Active Military start -> Payment@ Store CASH -> Active Military end -> Statement Generation");
					SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
					Payliance.Payliance(SSN, FileName,0);
					AgeStore.AgeStore(SSN, FileName, 0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
				   AgeStore.AgeStore(SSN, FileName, 2);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 3);
					Active_Military_Start.Active_Military_Start(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 4);
					Payments.Payments(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 7);
					Active_Military_End.Active_Military_End(SSN, FileName);
					StatementGeneration.StatementGeneration(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}
		}
		@Test (priority=14,groups = "kiran_KS_LOC_Prod")

		public void LOCI_ACTM_ACTMEnd_Stmt_ACMT_Draw_ACTMEnd_stmt2_Sc69() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_ACTM_ACTMEnd_Stmt_ACMT_Draw_ACTMEnd_stmt2_Txn_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:69" + "_" + PayFrequency + "_" + CollateralType,
							"Loan Initiation -> Active Military Start -> Active Military end -> Generate Statement ->Active Military Start -> Draw -> Active Military end-> Statement Generation ");
					/*SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
					StatementGeneration.StatementGeneration(SSN, FileName);*/
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}

		//@Test (priority=15,groups = "kiran_KS_LOC_Prod") // wavefee is not in transsion list

		public void LOCI_ACTM_Draw_stmt_ACTMEnd_Draw_ACTM_WaiveFee_Pymtwithcash_ACTMEnd_Stmt2_Sc70() throws Exception {

			// Start test. Mention test script name
			String FileName = "LOCI_ACTM_Draw_stmt_ACTMEnd_Draw_ACTM_WaiveFee_Pymtwithcash_ACTMEnd_Stmt2_Txn_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
					DrawLoan.DrawLoan(SSN, FileName, "350");
					AgeStore.AgeStore(SSN, FileName, 2);
					Active_Military_Start.Active_Military_Start(SSN, FileName);
					WaiveFee.WaiveFee(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 4);
					Payments.Payments(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 6);
					Active_Military_End.Active_Military_End(SSN, FileName);
					StatementGeneration.StatementGeneration(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}
		
		@Test (priority=16,groups = "kiran_KS_LOC_Prod")

		public void LOCI_Draw_ACTM_stmt_ACTMEnd_Payoff_ACMT_VoidPayoff_ACTMEnd_stmt2_Sc72() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Payoff_ACMT_VoidPayoff_ACTMEnd_stmt2_Txn_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:72" + "_" + PayFrequency + "_" + CollateralType,
							"Loan Initiation -> Draw -> Active Military start -> Statement -> Active Military end -> Payoff ->Active Military start -> Payoff Void -> Active Military end -> Statement Generation");
					/*SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
					StatementGeneration.StatementGeneration(SSN, FileName);*/
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}

		@Test (priority=17,groups = "kiran_KS_LOC_Prod") // deposit for After Active milataray

		public void LOCI_Draw_ACTM_stmt_ACTMEnd_Deposit_Return_Payment_ACTM_PaymentVoid_ACTMEnd_Stmt_Sc73()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_Draw_ACTM_stmt_ACTMEnd_Deposit_Return_Payment_ACTM_PaymentVoid_ACTMEnd_Stmt_Txn_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:73" + "_" + PayFrequency + "_" + CollateralType,
							"Loan Initiation -> Draw -> Active Military start -> Statement -> Active Military end -> Deposit -> Return -> Payment -> Active Military start -> Payment Void -> Active Military end -> Statement Generation");
					SetDate.SetDate(SSN, FileName, "01", "28", "2020");;
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
					Payliance.Payliance(SSN, FileName,0);
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
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}

		
		  @Test (priority=18,groups = "kiran_KS_LOC_Prod")  
		  
		 public void Loan_Draw_GenerateStatement_ACHDepositFlight_ActiveMilaitary_PaymentWDcash_ActiveMiltaryEnd_GenerateStatement() throws Exception {
		  
		  // Start test. Mention test script name 
			 String FileName="AA_Loan_Draw_GenerateStatement_ACHDepositFlight_ActiveMilaitary_PaymentWDcash_ActiveMiltaryEnd_GenerateStatement_TestData.xls";
		  TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
		 int lastrow=TestData.getLastRow("NewLoan"); String sheetName="NewLoan";
		  //int lastrow=TestData.getLastRow("Borrower");
		  System.out.println(lastrow); for(int row=2;row<=lastrow;row++) { String
		  RunFlag = TestData.getCellData(sheetName,"Run",row);
		  //System.out.println(RunFlag);
		  if(RunFlag.equals("Y")) {
		  //driver.get(appUrl); //test.log(LogStatus.INFO"Application is launched"); //driver.manage().window().maximize();
			  AppURL= prop.getProperty("AppURL_KS_LOC_kiran");
			  UserName =prop.getProperty("UserName_KS_LOC_kiran"); 
			  Password =prop.getProperty("Password_KS_LOC_kiran"); //
		  System.out.println(Password); StoreId =
		  prop.getProperty("StoreID_KS_LOC_kiran"); String ProductID =
		  TestData.getCellData(sheetName,"ProductID",row); String StateID =
		  TestData.getCellData(sheetName,"StateID",row); String SSN =
		  TestData.getCellData(sheetName,"SSN",row); String PayFrequency =
		  TestData.getCellData(sheetName,"Income_PayFrequency",row); 
		  String CollateralType =TestData.getCellData(sheetName,"ESign_CollateralType",row); 
		  String Header= StateID+ "_" + ProductID; //System.out.println(SSN); 
		  test =reports.startTest(Header+"_S.No:76"+"_"+PayFrequency+"_"+CollateralType,"Loan Initiation_Draw_Generate Statement_ACH Deposit in Flight_Active Military Start_Payment @ Store wd CASH_Active Military end_Generate Statement");
		  
		  SetDate.SetDate(SSN, FileName, "01", "28", "2020");
		  Login.Login(UserName, Password, StoreId);
		  
		  BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver,
		  test,AppURL, SSN,FileName); NewLoan.NewLoan(SSN, FileName);
		  DrawLoan.DrawLoan(SSN, FileName,"350");
		  StatementGeneration.StatementGeneration(SSN, FileName);
		  AgeStore.AgeStore(SSN, FileName, -1); DrawerDeassign.DrawerDeassign(SSN,FileName);
		  StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN,FileName);
		  StoreInfo.StoreInfo(SSN, FileName); Safeassign.Safeassign(SSN,FileName); 
		  Drawerassign.Drawerassign(SSN, FileName); 
		  Payliance.Payliance(SSN, FileName,0);
		  ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
		  ACHReturnPosting.ACHReturnPosting(SSN, FileName);
		  Active_Military_Start.Active_Military_Start(SSN, FileName);
		  AgeStore.AgeStore(SSN, FileName, 3); Payments.Payments(SSN, FileName);
		  AgeStore.AgeStore(SSN, FileName, 3);
		  Active_Military_End.Active_Military_End(SSN, FileName);
		  StatementGeneration.StatementGeneration(SSN, FileName);
		  Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
		 
		  }
		  }
		  }
		 

		@Test (priority=19,groups = "kiran_KS_LOC_Prod6")

		public void LOCI_Draw_Stmt_DLQ_CURE_Default_Writeoff_RCCSchedule_1stinstallmentPaid_ActiveMiltary_RccPlacementshouldStop()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_Draw_Stmt_DLQ_CURE_Default_Writeoff_RCCSchedule_1stinstallmentPaid_ActiveMiltary_RccPlacementshouldStop_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:77" + "_" + PayFrequency + "_" + CollateralType,
							"Loan Initiation_Draw_Generate Statement_DLQ_Cure_Default_Write off_RCC Enabled and Schedule generated_One instalment paid_Active Military_RCC Placements should stop");
					/*SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);

					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "350");
					StatementGeneration.StatementGeneration(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);
					CustomerDefault.CustomerDefault(SSN, FileName);
					DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
					Default_WOProc.Default_WOProc(SSN, FileName, 60);
					WOPaymentStatus.WOPaymentStatus(SSN, FileName);
					EditBorrower.EditBorrower(SSN, FileName, -10);
					Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
					WO_Recovery_pymt_BeforeDueDate_4thInst.WO_Recovery_pymt_BeforeDueDate_4thInst(SSN, FileName, 0, 2);
					Active_Military_Start.Active_Military_Start(SSN, FileName);
					RCCStatus.RCCStatus(SSN, FileName);*/
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}

		}
		@Test (priority=20,groups = "kiran_KS_LOC_Prod")

		public void LoanInitiation_Draw_GenerateStatement_DLQ_CURE_Default_Writeoff_Activemilitary_PaymentPlan()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LoanInitiation_Draw_GenerateStatement_DLQ_CURE_Default_Writeoff_Activemilitary_PaymentPlan_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:82" + "_" + PayFrequency + "_" + CollateralType,
							"Loan Initiation_Draw_ Generate Statement_DLQ_Cure_Default_Write off _Active Military_Payment Plan");
					/*SetDate.SetDate(SSN, FileName, "01", "28", "2020");;
					Login.Login(UserName, Password, StoreId);

					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "350");
					StatementGeneration.StatementGeneration(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);
					CustomerDefault.CustomerDefault(SSN, FileName);
					DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
					Default_WOProc.Default_WOProc(SSN, FileName, 60);
					WOPaymentStatus.WOPaymentStatus(SSN, FileName);
					Active_Military_Start.Active_Military_Start(SSN, FileName);
					PaymentPlan.PaymentPlan(SSN, FileName);*/
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}

		}

	/*@Test (priority=21,groups = "kiran_KS_LOC_Prod")

		public void Loanintillation_Draw_Generatestatement_Payoff_ActiveMilatary_payoffvoid_Activemilataryend_payment_GenerateStatement()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_Loanintillation_Draw_Generatestatement_Payoff_ActiveMilatary_payoffvoid_Activemilataryend_payment_GenerateStatement_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:83" + "_" + PayFrequency + "_" + CollateralType,
							"Loan Initiation_Draw_Generate Statement_Payoff_Active Military Start_Payoff Void_Active Military end_Payment_Generate Statement");
					SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);

					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "350");
					StatementGeneration.StatementGeneration(SSN, FileName);
					PayOffLoan.PayOffLoan(SSN, FileName);
					Active_Military_Start.Active_Military_Start(SSN, FileName);
					Void.Void_AfterActive_Military(SSN, FileName);
					Active_Military_End.Active_Military_End(SSN, FileName);
					Payments.Payments(SSN, FileName);
					StatementGeneration.StatementGeneration(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}

		}
*/
		@Test (priority=22,groups = "kiran_KS_LOC_Prod") // payment issue after Active start

		public void LOCI_ACTM_Draw_stmt_Pymtlessminpayamt_Draw_Pymt_VoidPymt_Draw_ACTMEnd_stmt2_Sc88() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_Draw_stmt_Pymtlessminpayamt_ACTM_Draw_DrawVoid_Draw_ACTMEnd_stmt2_Txn_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
				
					StatementGeneration.StatementGeneration(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}
		
		@Test (priority=23,groups = "kiran_KS_LOC_Prod")   // payment issue

		public void LOCI_Draw_Stmt_ACTM_DLQ_CURE_Payment_VoidPymt_Pymt_Draw_ACTMEnd_Draw_Payment_stmt2_Sc92()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_Draw_Stmt_ACTM_DLQ_CURE_Payment_VoidPymt_Pymt_Draw_ACTMEnd_Draw_Payment_stmt2_Txn_TestData.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}
		
		@Test (priority=24,groups = "kiran_KS_LOC_Prod")

		public void LOCI_Draw_PNBK_VoidPNBK_Drawavailable() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOC_Draw_PBNK_VoidPBNK_DrawAvailable_Txn_Testdata.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}

		}
		
		@Test (priority=25,groups = "kiran_KS_LOC_Prod")
		public void LOCI_Draw_Statement_Draw_PBNK_Drawnotavailable() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOC_Draw_Statment_Draw_PBNK_DrawnotAvailable_Txn_Testdata.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}


		}

		@Test (priority=26,groups = "kiran_KS_LOC_Prod")

		public void LOCI_Draw_Statement_Draw_PBNKbeforeduedate_NoDeposit() throws Exception {

			String FileName = "AA_LOC_Draw_Statement_Draw_PBNKbeforeDD_NoDeposit_Txn_Testdata.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);

			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}

			}

		}

		@Test (priority=27,groups = "kiran_KS_LOC_Prod")

		public void LOCI_Draw_Statement_Draw_PBNKbeforeduedate_VoidPBNK_Deposit() throws Exception {

			String FileName = "AA_LOC_Draw_Statement_Draw_PBNKbeforeDD_VoidPBNK_YesDeposit_Txn_Testdata.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);

			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}

			}



		}

		@Test (priority=28,groups = "kiran_KS_LOC_Prod")
		public void LOCI_Draw_Statement_Draw_PBNKbeforeduedate_VoidPBNKAfterduedate_Deposit() throws Exception {

			String FileName = "AA_LOC_Draw_Statement_Draw_PBNKbeforeDD_VoidPBNKAfterDue_YesDeposit_Txn_Testdata.xls";
			TestData = new Excel(
					System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);

			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}

			}

		}
	

		@Test(priority=29,groups = "kiran_KS_LOC_Prod") 

		public void LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_RPP_VoidPBNK_RPP_Sc105() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_RPP_VoidPBNK_RPP_Txn_TestData.xls";		 
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)

			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;      		        
					test = reports.startTest(Header+"_S.No:105"+"_"+PayFrequency+"_"+CollateralType,"LOCI=>Draw=>Statement =>Depsoit=>Rtn=>DLQ=>CURE=>DFLT=> PBNK=> RPP => void PBNK => RPP is not displayed");
					appUrl = AppURL;

					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
				Payliance.Payliance(SSN, FileName,0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACH_Return_withloannum.ACH_Return_withloannum(SSN, FileName);
					/*AgeStore.AgeStore(SSN, FileName, 10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);*/
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 30);		       
					CustomerDefault.CustomerDefault(SSN, FileName);
					DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
					PendingBNK.PendingBNK(SSN, FileName);
					Check_RPP.Check_RPP(SSN, FileName);
					PendingBNK_Void.PendingBNK_Void(SSN, FileName);
					Check_RPP.Check_RPP(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}
		}

		@Test (priority=30,groups = "kiran_KS_LOC_Prod") 

		public void LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_RCC_VoidPBNK_RCC_Sc106() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_RCC_VoidPBNK_RCC_Txn_TestData.xls";		 
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password= prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;      		        
					test = reports.startTest(Header+"_S.No:106"+"_"+PayFrequency+"_"+CollateralType,"LOCI_Draw_stmt_Deposit_Return_DLQ_Cure_DFLT_PBNK_RCC_VoidPBNK_RCC");
					appUrl = AppURL;

					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
					Payliance.Payliance(SSN, FileName,0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					AgeStore.AgeStore(SSN, FileName, 2);
					ACH_Return_withloannum.ACH_Return_withloannum(SSN, FileName); 
					/*AgeStore.AgeStore(SSN, FileName, 10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);*/
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 30);		       
					CustomerDefault.CustomerDefault(SSN, FileName);
					DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName); 
					PendingBNK.PendingBNK(SSN, FileName);
					RCCStatus.RCCStatus(SSN, FileName);
					//PendingBNK_Void.PendingBNK_Void(SSN, FileName);
					PendingBNK_Void.PendingBNK_Void(SSN, FileName);
					RCCStatus.RCCStatus(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);


				}
			}
		}


		@Test(priority=31,groups = "kiran_KS_LOC_Prod") 

		public void LOCI_Draw_stmt_Deposit_ReturnwithR01_DLQ_Cure_DFLT_RPP_PPAYwithCash_PBNKbeforeduedate_VoidPBNKonduedate_RepDepRecordshouldpost_Sc108() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_Draw_stmt_Deposit_ReturnwithR01_DLQ_Cure_DFLT_RPP_PPAYwithCash_PBNKbeforeduedate_VoidPBNKonduedate_RepDepRecordshouldpost_Txn_TestData.xls";		 
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;      		        
					test = reports.startTest(Header+"_S.No:108"+"_"+PayFrequency+"_"+CollateralType,"LOCI=>Draw=>Statement =>Depsoit=>Rtn=>DLQ=>CURE=>DFLT=> RPP=>PPAY WD Cash => PBNK Before Due date =>Void PBNK on due date=> deposit reperesenment");
					appUrl = AppURL;

					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
					Payliance.Payliance(SSN, FileName,0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					AgeStore.AgeStore(SSN, FileName, 2);
					ACH_Return_withloannum.ACH_Return_withloannum(SSN, FileName);			    
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
			/*		AgeStore.AgeStore(SSN, FileName, 10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);*/
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 30);		       
					CustomerDefault.CustomerDefault(SSN, FileName);
					DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
					RCC_Revoke.RCC_Revoke(SSN, FileName);	
					AgeStore.AgeStore(SSN, FileName, 1);
					RPP.RPP(SSN, FileName);
					RPP_Status.RPP_Status(SSN, FileName);
					AgeStore_EPP.AgeStore_EPP(SSN, FileName,-3,2);
					RPP_Payment.RPP_Payment(SSN, FileName);
					Represent_Status.Represent_Status(SSN, FileName);
					AgeStore_EPP.AgeStore_EPP(SSN, FileName,-2,2);
					PendingBNK.PendingBNK(SSN, FileName);
					AgeStore_EPP.AgeStore_EPP(SSN, FileName,0,2);
					PendingBNK_Void.PendingBNK_Void(SSN, FileName);
					Represent_Status.Represent_Status(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}
		}


		//@Test (priority=32,groups = "kiran_KS_LOC_Prod")// ISSUE REGARDING TO PDL LOAN

		public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_15PerAboveDFLTPmt_60daysWO_() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_15PerAboveDFLTPmt_60daysWO_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);  
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

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest(Header+"_S.No:116_"+PayFrequency+"_"+CollateralType, "LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure _DFLT _ DFP more than 15% _WO should be happen 60 days from last payment date.");
					Assert.assertTrue(true);
					appUrl = AppURL;

					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);
					//BorrowerRegistrationpage Reg = new BorrowerRegistrationpage();
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
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
					CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
					BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
					CustomerDefault_1.CustomerDefault_1(SSN, FileName);
					//Default_Payment_PercentageAmt_1.Default_Payment_PercentageAmt_1(SSN, FileName, 0.18);
					Default_Payment_PercentageAmt_1.Default_Payment_PercentageAmt_1(SSN, FileName, 0.18);
					//Default_WOProc_1.Default_WOProc_1(SSN, FileName, 60);
					Default_WOProc_1.Default_WOProc_1(SSN, FileName, 60);
					WOPaymentStatus.WOPaymentStatus(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}			
		}


		@Test (priority=33,groups = "kiran_KS_LOC_Prod5")

		public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_WO_WORFull_VOidWOR_CheckCustStatusorLoanStatus_()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_Cure_DFLT_WO_WORFull_VOidWOR_CheckCustStatusorLoanStatus_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir")
					+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
					DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
					CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
					BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
					CustomerDefault_1.CustomerDefault_1(SSN, FileName);
					Default_WOProc_1.Default_WOProc_1(SSN, FileName, 60);
					WOPaymentStatus.WOPaymentStatus(SSN, FileName);
					Writoff_Recovery_1.Writoff_Recovery_1(SSN, FileName);
					WORecovery_Void_1.WORecovery_Void_1(SSN, FileName);
					DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}
		}


		//@Test (priority=34,groups = "kiran_KS_LOC_Prod") // ISSUE REGARDING TO PDL LOAN

		public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_RCCnotDisplayed_() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payment_Payoff_VoidPayoff_DLQ_RCCnotDisplayed_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);  
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

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest(Header+"_S.No:121_"+PayFrequency+"_"+CollateralType, "LOCI_Draw _ Statement Generation _ BNK Loan not selected in BNK Process _Cust in BNK _Payment _Payoff _Void Payoff _DLQ _Cure _DFLT _ RCC should not be displayed");
					Assert.assertTrue(true);
					appUrl = AppURL;


					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);
					//BorrowerRegistrationpage Reg = new BorrowerRegistrationpage();
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
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
					DeliquentPaymentStatus_1.DeliquentPaymentStatus_1(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
					CureStatus_Bankrupt.CureStatus_Bankrupt(SSN, FileName);
					BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
					CustomerDefault_1.CustomerDefault_1(SSN, FileName);
					DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
					//Check_RCC_1.Check_RCC_1(SSN, FileName);
					Check_RCC_1.Check_RCC_1(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}			
		}

		//@Test(priority=35,groups = "ISSUE") //--PASS// ISSUE REGARDING TO PDL LOAN

		public void LOCI_Draw_Stmt_BNKLoanNotSelect_Payoff_CustomerStatusshouldbeBNK() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_Draw_Stmt_BNKLoanNotSelect_Payoff_CustomerStatusshouldbeBNK_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);  
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

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest(Header+"_S.No:124_"+PayFrequency+"_"+CollateralType, "LOCI _Draw _ BNK Customer should have another PDL Loan _ Select Only PDL loan in BNK Process _Payoff on LOC Loan _Customer status should be BNK");
					Assert.assertTrue(true);
					appUrl = AppURL;


					Login.Login(UserName, Password, StoreId);
					//BorrowerRegistrationpage Reg = new BorrowerRegistrationpage();
					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					NewLoan_PDL.NewLoan_PDL(SSN, FileName);
					DrawLoan_1.DrawLoan_1(SSN, FileName);
					AgeStore_1.AgeStore_1(SSN, FileName, -1);
					Bankrupt_PDL.Bankrupt_PDL(SSN, FileName);
					BankruptStatus_PDL.BankruptStatus_PDL(SSN, FileName);
					StatementGeneration_1.StatementGeneration_1(SSN, FileName);
					PayOffLoan_1.PayOffLoan_1(SSN, FileName);
					CustomerStatus.CustomerStatus(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}			
		}


		@Test (priority=36,groups = "kiran_KS_LOC_Prod") 

		public void LOCI_Draw_Stmt_Dep_RTN_BNKIntrstCalcShuldhappen_LoanShouldDefOrWOB_WO_WORFull_VoidWOR() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_Draw_Stmt_Dep_RTN_BNKIntrstCalcShuldhappen_LoanShouldDefOrWOB_WO_WORFull_VoidWOR_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);  
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

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest(Header+"_S.No:126_"+PayFrequency+"_"+CollateralType, "LOCI _ Draw _ Statement_ Deposit _RTN_ BNK _Loan to def or WOB _WO _WOR Full _Void WOR full");
					Assert.assertTrue(true);
					appUrl = AppURL;

					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);
					//BorrowerRegistrationpage Reg = new BorrowerRegistrationpage();
					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "50");
					StatementGeneration.StatementGeneration(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Payliance.Payliance(SSN, FileName,0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					Bankrupt.Bankrupt(SSN, FileName);
					BankruptStatus.BankruptStatus(SSN, FileName);
					Writoff_Recovery.Writoff_Recovery(SSN, FileName);
					WOStatus_Bankrupt.WOStatus_Bankrupt(SSN, FileName);
					WORecovery_Void.WORecovery_Void(SSN, FileName);
					WORECStatus_Bankrupt.WORECStatus_Bankrupt(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}			
		}


		@Test(priority=37,groups = "kiran_KS_LOC_Prod5") 

		public void LOCI_Draw_Stmt_Deposit_RTN_DLQ_DFLT_RPP_BNK_WO_AllSchdlsCancel_() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_Draw_Stmt_Deposit_RTN_DLQ_DFLT_RPP_BNK_WO_AllSchdlsCancel_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);  
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

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest(Header+"_S.No:129_"+PayFrequency+"_"+CollateralType, "LOCI _ Draw _ Statement_ Deposit _RTN_DLQ _DFLT_RPP_BN_WO all ach should be cancelled");
					Assert.assertTrue(true);
					appUrl = AppURL;

					
					Login.Login(UserName, Password, StoreId);
					//BorrowerRegistrationpage Reg = new BorrowerRegistrationpage();
					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "50");
					StatementGeneration.StatementGeneration(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Payliance.Payliance(SSN, FileName,0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName); 
					AgeStore.AgeStore(SSN, FileName, 10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);	  
					//AgeStore.AgeStore(SSN, FileName, 30);
					CustomerDefault.CustomerDefault(SSN, FileName);
					DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName); 
					RCCRevoke.RCCRevoke(SSN, FileName);
					RPP.RPP(SSN, FileName);
					RPP_Status.RPP_Status(SSN, FileName);
					Bankrupt.Bankrupt(SSN, FileName);
					BankruptStatus.BankruptStatus(SSN, FileName);
					RPP_Status.RPP_Status(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}			
		}

		//@Test(priority=38,groups = "kiran_KS_LOC_Prod") // TN_PDL LOAN ISSUE

		public void LOCI_Draw_Stmt_Depo_RTN_DLQ_DFLT_RPP_BNKPDL_RPPFull_RPP_Void_CheckStatus() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI _ Draw _ Statement_ Deposit _RTN_DLQ _DFLT_RPP_ BNK Other PDL Loan_RPP Full _Void RPP check loan cust status_Txn_Testdata.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);  
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

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest(Header+"_S.No:131_"+PayFrequency+"_"+CollateralType, "LOCI => Draw => Statement=> Deposit =>RTN=>DLQ =>DFLT=>RPP=> BNK(Other PDL Loan)=>RPP Full check loan /cust status");
					Assert.assertTrue(true);
					appUrl = AppURL;

					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);
					//BorrowerRegistrationpage Reg = new BorrowerRegistrationpage();
					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					NewLoan_PDL.NewLoan_PDL(SSN, FileName);
					DrawLoan_1.DrawLoan_1(SSN, FileName);
					//StatementGeneration_1.StatementGeneration_1(SSN, FileName);
					StatementGeneration_1.StatementGeneration_1(SSN, FileName);
					//AgeStore_1.AgeStore_1(SSN, FileName, -1);
					AgeStore_1.AgeStore_1(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					//NACHA_1.NACHA_1(SSN, FileName, -1);
					Payliance.Payliance(SSN, FileName,0);
					//ACH_Deposit_1.ACH_Deposit_1(SSN, FileName, 0);
					ACH_Deposit_1.ACH_Deposit_1(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);  
					//AgeStore_1.AgeStore_1(SSN, FileName, 10);
					AgeStore_1.AgeStore_1(SSN, FileName, 10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					//CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
					CurePaymentStatus_1.CurePaymentStatus_1(SSN, FileName);
					//CustomerDefault_1.CustomerDefault_1(SSN, FileName);
					CustomerDefault_1.CustomerDefault_1(SSN, FileName);
					//DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
					DefaultPaymentStatus_1.DefaultPaymentStatus_1(SSN, FileName);
					//RCCRevoke_1.RCCRevoke_1(SSN, FileName);
					RCCRevoke_1.RCCRevoke_1(SSN, FileName);
					//RPP_1.RPP_1(SSN, FileName);
					RPP_1.RPP_1(SSN, FileName);
					//RPP_Status_1.RPP_Status_1(SSN, FileName);
					RPP_Status_1.RPP_Status_1(SSN, FileName);
					Bankrupt.Bankrupt(SSN, FileName);
					//RPP_Payment_1.RPP_Payment_1(SSN, FileName);
					RPP_Payment_1.RPP_Payment_1(SSN, FileName);
					RPP_Void.RPP_Void(SSN, FileName);
					//BankruptStatus_1.BankruptStatus_1(SSN, FileName);
					BankruptStatus_1.BankruptStatus_1(SSN, FileName);
					RPP_Status_1.RPP_Status_1(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);



				}
			}			
		}



		@Test (priority=39,groups = "kiran_KS_LOC_Prod5") 

		public void LOCI_Draw_Stmt_Depo_RTN_DLQ_DFLT_WO_BNK_WOR() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_Draw_Stmt_Depo_RTN_DLQ_DFLT_WO_BNK_WOR_Txn_Testdata.xls";
			// AA_LOCI_Draw_Stmt_Dep_Clear_BNK_RTN_Txn_Testdata
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);  
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

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest(Header+"_S.No:132_"+PayFrequency+"_"+CollateralType, "LOCI _ Draw _ Statement_ Deposit _RTN_DLQ _DFLT_WO_BNK _WOR");
					Assert.assertTrue(true);
					appUrl = AppURL;

					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);
					//BorrowerRegistrationpage Reg = new BorrowerRegistrationpage();
					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "50");
					StatementGeneration.StatementGeneration(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Payliance.Payliance(SSN, FileName,0);
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
					Default_WOProc.Default_WOProc(SSN, FileName,60);
					//WOPaymentStatus_1.WOPaymentStatus_1(SSN, FileName);
					WOPaymentStatus_1.WOPaymentStatus_1(SSN, FileName);
					Bankrupt.Bankrupt(SSN, FileName);
					Writoff_Recovery.Writoff_Recovery(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);


				}
			}			
		}

		@Test (priority=40,groups = "kiran_KS_LOC_Prod5") 

		public void AA_LOCI_Draw_Stmt_Dep_Clear_BNK_RTN_Txn_Testdata() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_Draw_Stmt_Dep_Clear_BNK_RTN_Txn_Testdata.xls";
			// AA_LOCI_Draw_Stmt_Dep_Clear_BNK_RTN_Txn_Testdata
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);  
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

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest(Header+"_S.No:133_"+PayFrequency+"_"+CollateralType, "LOCI _ Draw _ Deposit _ Clear _BNK_RTN _Status should be in BNK");
					Assert.assertTrue(true);
					appUrl = AppURL;


					Login.Login(UserName, Password, StoreId);
					//BorrowerRegistrationpage Reg = new BorrowerRegistrationpage();
					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "50");
					StatementGeneration.StatementGeneration(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Payliance.Payliance(SSN, FileName,0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					ACH_Clear.ACH_Clear(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 8);
					Loanclosed_Bankrupt.Loanclosed_Bankrupt(SSN, FileName);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					RPP_Status.RPP_Status(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}			
		}


		@Test(priority=41,groups = "kiran_KS_LOC_Prod") 

		public void LOCI_DRAW_DLQ_DFLT_DEPFull_BNK_VoidBNK_Status() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_LOCI_DRAW_DLQ_DFLT_DEPFull_BNK_VoidBNK_Status_TestData.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);  
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

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest(Header+"_S.No:137"+"_"+PayFrequency+"_"+CollateralType, "LOCI_Draw_DLQ_DFLT _DFPFULL_BNK(loan selected in bnk process)_Loan to be WOB_Void BNK_Loan in WO Status");
					appUrl = AppURL;
					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);
					//BorrowerRegistrationpage Reg = new BorrowerRegistrationpage();
					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "50");
					StatementGeneration.StatementGeneration(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
					CurePaymentStatus.CurePaymentStatus(SSN, FileName);
					CustomerDefault.CustomerDefault(SSN, FileName);
					DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
					Default_Payment.Default_Payment(SSN, FileName);
					DFLTPmtFull_Status.DFLTPmtFull_Status(SSN, FileName);
					Loanclosed_Bankrupt.Loanclosed_Bankrupt(SSN, FileName);
					BankruptStatus.BankruptStatus(SSN, FileName);
					Loanclosed_Bankrupt_Void.Loanclosed_Bankrupt_Void(SSN, FileName);
					BankruptStatus_CustmerStatus.BankruptStatus_CustmerStatus(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}
		}
		

		 @Test (priority=42,groups = "kiran_KS_LOC_Prod")

		public void LOCI_DRAW_DLQ_DFLT_WO_BNK_LoanTobeWOB_VoidBNK_LoanInWOstatus_WOR() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_DRAW_DLQ_DFLT_WO_BNK_LoanTobeWOB_VoidBNK_LoanInWOstatus_WOR_TestData.xls";
			TestData = new Excel(System.getProperty("user.dir")
					+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
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
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "50");
					StatementGeneration.StatementGeneration(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
					DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}

		}

		 @Test (priority=43,groups = "kiran_KS_LOC_Prod5")

		public void LOCI_DRAW_Deposit_BNK_Discharge_CUSTtobeINACTIVE_LineClouser() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_DRAW_Deposit_BNK_Discharge_CUSTtobeINACTIVE_LineClouser_TestData.xls";
			TestData = new Excel(System.getProperty("user.dir")
					+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:141" + "_" + PayFrequency + "_" + CollateralType,
							"LOCI_Draw_Deposit_BNK_Discharge_Satus of cust to be Inactive_Line Closure should happen");
					 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
					Login.Login(UserName, Password, StoreId);

					BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "50");
					StatementGeneration.StatementGeneration(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
				Payliance.Payliance(SSN, FileName,0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					//Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 10, 2);
			       ACH_Clear.ACH_Clear(SSN, FileName);
					Loanclosed_Bankrupt.Loanclosed_Bankrupt(SSN, FileName);
					BankruptStatus.BankruptStatus(SSN, FileName);
					Bankrupt_Discharged.Bankrupt_Discharged(SSN, FileName);
					BankruptStatus_CustmerStatus.BankruptStatus_CustmerStatus(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

				}
			}

		}

		 @Test (priority=44,groups = "kiran_KS_LOC_Prod")

		public void LOCI_Draw_Deposit_Clear_BNK_Discharged_RTN()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_LOCI_DRAW_STMT_DEPOSIT_CLR_BNK_Discharge_RTN _TestData.xls";
			TestData = new Excel(System.getProperty("user.dir")
					+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
	
					AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
					UserName = prop.getProperty("UserName_KS_LOC_kiran");
					Password = prop.getProperty("Password_KS_LOC_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
					NewLoan.NewLoan(SSN, FileName);
					DrawLoan.DrawLoan(SSN, FileName, "50");
					StatementGeneration.StatementGeneration(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -1);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
				Payliance.Payliance(SSN, FileName,0);
					ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
					Admin_ACH_Clear.Admin_ACH_Clear(SSN, FileName, 8);
					//AgeStore.AgeStore(SSN, FileName, 8);
					//ACH_Clear.ACH_Clear(SSN, FileName);
					Bankrupt.Bankrupt(SSN, FileName);
					BankruptStatus.BankruptStatus(SSN, FileName);
					Bankrupt_Discharged.Bankrupt_Discharged(SSN, FileName);
					BankruptStatus.BankruptStatus(SSN, FileName);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
				}
			}

		}

			@Test(priority = 45, groups = "kiran_KS_LOC_Prod") 

			public void LOCI_Draw_Deceased_NextDrawshouldnotbeavailble_VoidDeceased_WOR_NewloanOptionShouldBeAvalabile()
					throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_LOCI_Draw_Deceased_NextDrawshouldnotbeavailble_VoidDeceased_WOR_NewloanOptionShouldBeAvalabile_TestData.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
						UserName = prop.getProperty("UserName_KS_LOC_kiran");
						Password = prop.getProperty("Password_KS_LOC_kiran");
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						Bankrupt.Bankrupt(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						Bankrupt_Deceased_AfterBankrupt.Bankrupt_Deceased_AfterBankrupt(SSN, FileName);
						Check_Draw.Check_Draw(SSN, FileName);
						Deceased_Void.Deceased_Void(SSN, FileName);
						Writoff_Recovery.Writoff_Recovery(SSN, FileName);
						WOPaymentStatus_1.WOPaymentStatus_1(SSN, FileName);
						NewLoan_Verification_WithProduct.NewLoan_Verification_WithProduct(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}

			}

			@Test(priority = 46, groups = "kiran_KS_LOC_Prod") 

			public void LOCI_DRAW_Statement_Deceased_LCstatusWO_VoidDeceased_ValidateLCstatus() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_LOCI_DRAW_Statement_Deceased_LCstatusWO_VoidDeceased_ValidateLCstatus_TestData.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
						UserName = prop.getProperty("UserName_KS_LOC_kiran");
						Password = prop.getProperty("Password_KS_LOC_kiran");
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						StatementGeneration.StatementGeneration(SSN, FileName);
						Bankrupt.Bankrupt(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						Bankrupt_Deceased_AfterBankrupt.Bankrupt_Deceased_AfterBankrupt(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						Deceased_Void.Deceased_Void(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}

			}

			@Test(priority = 47, groups = "kiran_KS_LOC_Prod") 

			public void LOCI_Draw_StGn_DeceasedBeforeDueDate_LineStatusWo_WOR_OldLoanShouldClosed_NewLoanShouldnotBeEnabled()
					throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_LOCI_Draw_StGn_DeceasedBeforeDueDate_LineStatusWo_WOR_OldLoanShouldClosed_NewLoanShouldnotBeEnabled_TestData.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
						UserName = prop.getProperty("UserName_KS_LOC_kiran");
						Password = prop.getProperty("Password_KS_LOC_kiran");
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						StatementGeneration.StatementGeneration(SSN, FileName);
						Bankrupt.Bankrupt(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						Bankrupt_DeceasedBeforeDueDate.Bankrupt_DeceasedBeforeDueDate(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 2);
						Writoff_Recovery.Writoff_Recovery(SSN, FileName);
						WOPaymentStatus_LoanStatus.WOPaymentStatus_LoanStatus(SSN, FileName);
						NewLoan_Verification_WithoutProduct.NewLoan_Verification_WithoutProduct(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}
			}

			@Test(priority = 48, groups = "kiran_KS_LOC_Prod") 

			public void LOCI_Draw_stmt_DLQ_Deceasedonduedate_LineStatustoWO_Sc149() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_LOCI_Draw_stmt_DLQ_Deceasedonduedate_LineStatustoWO_Txn_TestData.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
						UserName = prop.getProperty("UserName_KS_LOC_kiran");
						Password = prop.getProperty("Password_KS_LOC_kiran");
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
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
						EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
						DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
						Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}
			}

			@Test(priority = 49, groups = "kiran_KS_LOC_Prod") 

			public void Loan_Draw_statement_DLQ_DeceasedincurePeriod_WO() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_Loan_Draw_statment_DLQ_DeceasedCurePeriod_WO_Txn_Testdata.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
						UserName = prop.getProperty("UserName_KS_LOC_kiran");
						Password = prop.getProperty("Password_KS_LOC_kiran");
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String StateID = TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:151" + "_" + PayFrequency + "_" + CollateralType,
								"LOCI =>Draw =>St Gn => DLQ => Deceased in Cure Period => Line status to WO  ");

						Login.Login(UserName, Password, StoreId);

						BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						StatementGeneration.StatementGeneration(SSN, FileName);
						EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
						DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 10);
						Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}

			}

			@Test (priority=50,groups = "kiran_KS_LOC_Prod")

			public void Loan_Draw_statement_DLQ_DFLT_DeceasedWO_VoidDeceased_Linestatus() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_Loan_Draw_statement_DLQ_DFLT_DeceasedinWO_VoidDeceased_Txn_Testdata.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_kiran") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_kiran");
						UserName = prop.getProperty("UserName_KS_LOC_kiran");
						Password = prop.getProperty("Password_KS_LOC_kiran");
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_kiran");
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String StateID = TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:156" + "_" + PayFrequency + "_" + CollateralType,
								"LOCI =>Draw =>St Gn => DLQ => DFLT => WO => Deceased in WO => Line status to WO  => Void Deceased => Line status to WO");

						Login.Login(UserName, Password, StoreId);

						BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						StatementGeneration.StatementGeneration(SSN, FileName);
						EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
						DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
						EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
						CurePaymentStatus.CurePaymentStatus(SSN, FileName);
						CustomerDefault.CustomerDefault(SSN, FileName);
						Default_WOProc1.Default_WOProc1(SSN, FileName);
						Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						Bankrupt_Void.Bankrupt_Void(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}

			}

			@Test(priority = 51, groups = "venkat_KS_LOC_Prod") 

			public void Loan_Draw_Payoff_Loanclosure_Deceased_NewloanOriginationshouldnotbeallowed() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_Loan_Draw_Payoff_Loanclosure_Deceased_NewloanOrigination_Txn_Testdata.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
						UserName = prop.getProperty("UserName_KS_LOC_venkat");
						Password = prop.getProperty("Password_KS_LOC_venkat");
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String StateID = TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:157" + "_" + PayFrequency + "_" + CollateralType,
								"LOCI =>Draw => Pay Off => Loan Closure => Deceased => New loan Origination should not be allowed");

						Login.Login(UserName, Password, StoreId);

						BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						AgeStore.AgeStore(SSN, FileName, -3);
						PayOffLoan.PayOffLoan(SSN, FileName);
						Closure.Closure(SSN, FileName);
						Bankrupt_Deceased_Loanclosuer.Bankrupt_Deceased_Loanclosuer(SSN, FileName);
						NewLoanValidation.NewLoanValidation(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}
			}

			@Test(priority = 52, groups = "venkat_KS_LOC_Prod") 

			public void Loan_Draw_Payoff_Deceased_Nextdrawnotavailable() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_Loan_Draw_Payoff_Deceased_DrawnotavailableTxn_Testdata.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
						UserName = prop.getProperty("UserName_KS_LOC_venkat");
						Password = prop.getProperty("Password_KS_LOC_venkat");
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String StateID = TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:158" + "_" + PayFrequency + "_" + CollateralType,
								"LOCI =>Draw => Pay Off => Deceased => Draw should not be allowed");

						Login.Login(UserName, Password, StoreId);

						BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						AgeStore.AgeStore(SSN, FileName, -6);
						PayOffLoan.PayOffLoan(SSN, FileName);
						Bankrupt_Deceased_Loanclosuer.Bankrupt_Deceased_Loanclosuer(SSN, FileName);
						Check_Draw.Check_Draw(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}
			}

			@Test(priority = 53, groups = "venkat_KS_LOC_Prod") 

			public void Loan_Draw_Payoff_Deceased_Void_Nextdrawavailable() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_Loan_Draw_Payoff_Deceased_Void_DrawavailableTxn_Testdata.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
						UserName = prop.getProperty("UserName_KS_LOC_venkat");
						Password = prop.getProperty("Password_KS_LOC_venkat");
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String StateID = TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:159" + "_" + PayFrequency + "_" + CollateralType,
								"LOCI =>Draw => Pay Off =>  Deceased => Void deceased => Next draw should be available");

						Login.Login(UserName, Password, StoreId);

						BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						AgeStore.AgeStore(SSN, FileName, -3);
						PayOffLoan.PayOffLoan(SSN, FileName);
						Bankrupt_Deceased_Loanclosuer.Bankrupt_Deceased_Loanclosuer(SSN, FileName);
						Void_Deceased.Void_Deceased(SSN, FileName);
						Check_Draw.Check_Draw(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}
			}

			@Test(priority = 54, groups = "venkat_KS_LOC_Prod") 

			public void Loan_Draw_MinPayment_Deceased_Drawnotavailable() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_Loan_Draw_MinPayment_Deceased_Drawavailable_Txn_Testdata.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
						UserName = prop.getProperty("UserName_KS_LOC_venkat");
						Password = prop.getProperty("Password_KS_LOC_venkat");
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String StateID = TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:160" + "_" + PayFrequency + "_" + CollateralType,
								"LOCI =>Draw => On Due date Minimum payment made => Deceased => Next draw not available");

						Login.Login(UserName, Password, StoreId);

						BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						StatementGeneration.StatementGeneration(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 0);
						Payments.Payments(SSN, FileName);
						Bankrupt_Deceased_Loanclosuer.Bankrupt_Deceased_Loanclosuer(SSN, FileName);
						Check_Draw.Check_Draw(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}

			}

			 @Test (priority=55,groups = "venkat_KS_LOC_Prod")

			public void LOCI_DRAW_STGN_Deceased_ACHShouldnotGetDeposited() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_LOCI_DRAW_STGN_Deceased_ACHShouldnotGetDeposited_TestData.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
						UserName = prop.getProperty("UserName_KS_LOC_venkat");
						Password = prop.getProperty("Password_KS_LOC_venkat");
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						StatementGeneration.StatementGeneration(SSN, FileName);
						Bankrupt.Bankrupt(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						Bankrupt_Deceased_ONDueDate.Bankrupt_Deceased_ONDueDate(SSN, FileName);
						BankruptStatus.BankruptStatus(SSN, FileName);
						
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						Payliance.Payliance(SSN, FileName,0);
						ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
						Check_Record.Check_Record(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}

			}

			@Test(priority = 56, groups = "venkat_KS_LOC_Prod") 

			public void Loan_Draw_StGn_ACHDeposit_RTN_Deceased_ACHDepositnotRedeposit() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_Loan_Draw_StGn_Draw_ACHDeposit_StartActiveMillatry_RTN_ActivemillartyEnd_StGn_Txn_Testdata.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
						UserName = prop.getProperty("UserName_KS_LOC_venkat");
						Password = prop.getProperty("Password_KS_LOC_venkat");
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String StateID = TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:164" + "_" + PayFrequency + "_" + CollateralType,
								"LOCI =>Draw =>St Gn =>  on due date ACH deposited => RTN => Deceased => ACH should not be re deposited");

						Login.Login(UserName, Password, StoreId);

						BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						StatementGeneration.StatementGeneration(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, -1);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						Payliance.Payliance(SSN, FileName,0);
						ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
						ACHReturnPosting.ACHReturnPosting(SSN, FileName);
						Bankrupt.Bankrupt(SSN, FileName);
						Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
						LineStatus.LineStatus(SSN, FileName);
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}
			}

			 @Test (priority=57,groups = "venkat_KS_LOC_Prod")

			public void LOCI_DRAW_StGn_WO_RccRevoke_Rpp_Deceased_LinestatusWO_VoidDeceased_LineStatusWO() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_LOCI_DRAW_StGn_WO_RccRevoke_Rpp_Deceased_LinestatusWO_VoidDeceased_LineStatusWO_TestData.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
						UserName = prop.getProperty("UserName_KS_LOC_venkat");
						Password = prop.getProperty("Password_KS_LOC_venkat");
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						StatementGeneration.StatementGeneration(SSN, FileName);
						EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
						DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
						EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}

			}

			 @Test (priority=58,groups = "venkat_KS_LOC_Prod")

			public void LOCI_Draw_StGn_DFLT_RCC_Deceased_LineStatusWO_VoidDeceased_LineStatusWO() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_LOCI_Draw_StGn_DFLT_RCC_Deceased_LineStatusWO_VoidDeceased_LineStatusWO_TestData.xls";
				TestData = new Excel(System.getProperty("user.dir")
						+ prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
						UserName = prop.getProperty("UserName_KS_LOC_venkat");
						Password = prop.getProperty("Password_KS_LOC_venkat");
						// System.out.println(Password);
						StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String StateID = TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:169" + "_" + PayFrequency + "_" + CollateralType,
								"LOCI_Draw_St Gn_DFLT_RCC_Deceased_Line status to WO_VoidDecased_LineStatusWo ");
						 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
						Login.Login(UserName, Password, StoreId);

						BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						DrawLoan.DrawLoan(SSN, FileName, "50");
						StatementGeneration.StatementGeneration(SSN, FileName);
						EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
						DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
						EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
						Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
					}
				}
			}

			


				@Test (priority=59,groups = "venkat_KS_LOC_Prod")

				public void LOCI_Draw_StGn_DFLT_WO_RCC_Deceased_LineStatusWO_() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_StGn_DFLT_WO_RCC_Deceased_LineStatusWO_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:170" + "_" + PayFrequency + "_" + CollateralType,
									"LOCI _Draw _St Gn _ WO _RCC_ Deceased _ Line status to WO _ Void Deceased _  Line status to WO ");

							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);
							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan1.DrawLoan1(SSN, FileName);
							StatementGeneration.StatementGeneration(SSN, FileName);				
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
							//BankruptStatus.BankruptStatus(SSN, FileName);
							Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
							//BankruptStatus.BankruptStatus(SSN, FileName);
							Deceased_Void_WO.Deceased_Void_WO(SSN, FileName);
							BankruptStatus.BankruptStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
						}
					}

				}


				@Test (priority=60,groups = "venkat_KS_LOC_Prod")

				public void LOCI_Draw_Dismissed_NextDrawshouldnotbeavailble_Bankrupt_CheckDraw_() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_Dismissed_NextDrawshouldnotbeavailble_Bankrupt_CheckDraw_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}
				}


				@Test (priority=61,groups = "venkat_KS_LOC_Prod")

				public void LOCI_Draw_StmtGn_DismissedBeforeDueDate_WORecovery_OldLoanClosed_NewLoanEnable_() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_StmtGn_DismissedBeforeDueDate_WORecovery_OldLoanClosed_NewLoanEnable_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
						}
					}
				}


				@Test (priority=62,groups = "venkat_KS_LOC_Prod")//com

				public void LOCI_Draw_stmt_DismissedonDuedate_LineStatustoWO_Sc176() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_stmt_DismissedonDuedate_LineStatustoWO_Txn_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
			
							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);		
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							Bankrupt.Bankrupt(SSN, FileName);
							Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
							BankruptStatus.BankruptStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
						}
					}
				}


				@Test (priority=63,groups = "venkat_KS_LOC_Prod")//com

				public void LOCI_Draw_stmt_DLQ_DismissedinCureperiod_LineStatustoWO2_Sc177() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_stmt_DLQ_DismissedinCureperiod_LineStatustoWO2_Txn_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							Bankrupt.Bankrupt(SSN, FileName);
							Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
							BankruptStatus.BankruptStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
						}
					}
				}

				@Test (priority=64,groups = "venkat_KS_LOC_Prod")//com

				public void LOCI_Draw_stmt_DLQ_DFLT_DismissedinDFLT_LineStatustoWO_Sc178() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_stmt_DLQ_DFLT_DismissedinDFLT_LineStatustoWO_Txn_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
						}
					}
				}

				@Test (priority=65,groups = "venkat_KS_LOC_Prod")//com

				public void LOCI_Draw_stmt_DLQ_DFLT_WO_Dismissedonduedate_LineStatustoWO_Sc179() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_stmt_DLQ_DFLT_WO_Dismissedonduedate_LineStatustoWO_Txn_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
	
							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:179" + "_" + PayFrequency + "_" + CollateralType,
									"LOCI =>Draw =>St Gn => DLQ => DFLT => WO => Dismissed in WO => Line status to WO");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
							DrawLoan1.DrawLoan1(SSN, FileName);
							StatementGeneration.StatementGeneration(SSN, FileName);

							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
						}
					}
				}


				@Test (priority=66,groups = "venkat_KS_LOC_Prod")//

				public void LOCI_Draw_Payoffwithcash_Dismissed_DrawnotAvailable_Sc181() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_Payoffwithcash_Dismissed_DrawnotAvailable_Txn_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}
				}



				@Test (priority=67,groups = "venkat_KS_LOC_Prod")  //payment

				public void Loan_Draw_MinPayment_Dismissed_Drawnotavilable_Txn_Testdata() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_Loan_Draw_MinPayment_Dismissed_Drawnotavilable_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
	
							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
						}
					}

				}


				@Test (priority=68,groups = "venkat_KS_LOC_Prod")

				public void Loan_Draw_StGn_Dismissedonduedate_ACHshouldnotgetdeposited() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_Loan_Draw_StGn_Dismissedonduedate_ACHshouldnotgetdeposited_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
							// Check_Draw.Check_Draw(SSN, FileName);

						}
					}

				}

				@Test (priority=69,groups = "venkat_KS_LOC_Prod")
				public void Loan_Draw_StGn_ACHDeposit_RTN_Dismissed_ACHDepositnotRedeposit() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_ Loan_Draw_StGn_ACHDeposit_Dismissed_ACHDepositshouldnotgetRedeposited_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:184" + "_" + PayFrequency + "_" + CollateralType,
									"LOCI =>Draw =>St Gn =>  on due date ACH deposited => RTN => Dismissed => ACH should not be re deposited");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
							Payliance.Payliance(SSN, FileName,0);
							ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
							AgeStore.AgeStore(SSN, FileName, 2);
							ACH_Return_withloannum.ACH_Return_withloannum(SSN, FileName);
							Bankrupt_Dismissed.Bankrupt_Dismissed(SSN, FileName);
							Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
							LineStatus.LineStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

				}

				@Test (priority=70,groups = "venkat_KS_LOC_Prod")

				public void Loan_Draw_StGn_Default_RCC_Dismissed_RCCNotgetDeposit_LinestatusWO() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_ Loan_Draw_StGn_Default_RCC_Dismissed_RCCshouldnotget_LinestatusWO_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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

							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							EditBorrower.EditBorrower(SSN, FileName, -10);
							Bankrupt_Dismissed.Bankrupt_Dismissed(SSN, FileName);
							Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
							LineStatus.LineStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

				}

				@Test (priority=71,groups = "venkat_KS_LOC_Prod")

				public void Loan_Draw_StGn_Dfault_RCCRevoke_RPP_Dismissed_LinestatusWO() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_Loan_Draw_StGn_Default_RCCRevoke_RPP_Dismissed_LinestatusWO_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:186" + "_" + PayFrequency + "_" + CollateralType,
									"LOCI =>Draw =>St Gn => DFLT => RCC Revoke => RPP => Dismissed => Line status to WO ");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan1.DrawLoan1(SSN, FileName);
							StatementGeneration.StatementGeneration(SSN, FileName);

							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							RCC_Revoke.RCC_Revoke(SSN, FileName);
							RPP.RPP(SSN, FileName);
							RPP_Status.RPP_Status(SSN, FileName);
							Bankrupt_Dismissed.Bankrupt_Dismissed(SSN, FileName);
							Dismissed_AfterBANKRUPT.Dismissed_AfterBANKRUPT(SSN, FileName);
							LineStatus.LineStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

				}

				@Test (priority=72,groups = "venkat_KS_LOC_Prod")

				public void LOCI_Draw_Default_RCCRevoke_ConverEPP_MinPay_Minper_Month() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOC_Draw_Default_RCCRevoke_ConverEPP_MinPay_MinperM_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

							test = reports.startTest(Header + "_S.No:187" + "_" + PayFrequency + "_" + CollateralType,
									"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP check the schedule which is generated for Monthly customer according to Minpayment and Min percentage rule value");

							Assert.assertTrue(true);
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan1.DrawLoan1(SSN, FileName);
							StatementGeneration.StatementGeneration(SSN, FileName);

							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							RCC_Revoke.RCC_Revoke(SSN, FileName);
							Edit_Reg_Rpp_Month.Edit_Reg_Rpp_Month(SSN, FileName);
							RPP.RPP(SSN, FileName);
							Min_Eight_PercentAmt.Min_Eight_PercentAmt(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

					// Login.Login("CSR353","1234","353");

				}


			@Test (priority=73,groups = "venkat_KS_LOC_Prod")

				public void LOCI_Draw_Default_RCCRevoke_ConverEPP_MinPay_Minper_Bweek() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOC_Draw_Default_RCCRevoke_ConverEPP_MinPay_MinperB_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

							test = reports.startTest(Header + "_S.No:190" + "_" + PayFrequency + "_" + CollateralType,
									"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP check the schedule which is generated for Monthly customer according to Minpayment and Min percentage rule value");

							Assert.assertTrue(true);
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan1.DrawLoan1(SSN, FileName);
							StatementGeneration.StatementGeneration(SSN, FileName);

							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							RCC_Revoke.RCC_Revoke(SSN, FileName);
							RPP.RPP(SSN, FileName);
							Min_Four_PercentAmt.Min_Four_PercentAmt(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}


				}
				@Test (priority=74,groups = "venkat_KS_LOC_Prod")

				public void LOC_default_RCCRevoke_EPP_Instwisepayment_Monthly() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOC_default_RCCRevoke_EPP_InswisePayment_M_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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

							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							RCC_Revoke.RCC_Revoke(SSN, FileName);
							RPP.RPP(SSN, FileName);
							AgeStore_1stins.AgeStore_1stins(SSN, FileName, -2);
							EPP_Payment.EPP_Payment(SSN, FileName);
							AgeStore_2ndins.AgeStore_2ndins(SSN, FileName, -2);
							EPP_Payment.EPP_Payment(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
							/*		AgeStore_3rdins.AgeStore_3rdins(SSN, FileName, -2);
							EPP_Payment.EPP_Payment(SSN, FileName);
							AgeStore_4rthins.AgeStore_4rthins(SSN, FileName, -2);
							EPP_Payment.EPP_Payment(SSN, FileName);*/

						}
					}

				}

				@Test (priority=75,groups = "venkat_KS_LOC_Prod") //Deposit Issue

				public void LOCI_Draw_Default_RCCRevoke_ConverEPP_DepositandClearInswise_Monthly() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOC_Draw_Default_RCCRevoke_ConverEPP_DepositandClearInswise_Monthly_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

							test = reports.startTest(Header + "_S.No:195" + "_" + PayFrequency + "_" + CollateralType,
									"Pick an LOC Loan which is default status => Perform RCC Revoke -> Convert to EPP -> Deposit all installments on due date accordingly for monthly customer and clear them after that");

							Assert.assertTrue(true);
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 1);
							DrawLoan1.DrawLoan1(SSN, FileName);
							// NewLoanDraw.NewLoanDraw(SSN, FileName);
							StatementGeneration.StatementGeneration(SSN, FileName);

							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
							Payliance.Payliance(SSN, FileName,0);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}

					}



				}

				@Test(priority =76, groups = "venkat_KS_LOC_Prod")

				public void DFLT_RccRevoke_Epp_voidEpp__CheckWhetherStatusDefault() throws Exception {

					String FileName = "AA_DFLT_RccRevoke_Epp_voidEpp__CheckWhetherStatusDefault_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
				
							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:211" + "_" + PayFrequency + "_" + CollateralType,
									"Pick an LOC Loan which is default status_Perform RCC Revoke_Convert to EPP_Void EPP Check whether status is Default ");

							Login.Login(UserName, Password, StoreId);
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							// AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 2);
							DrawLoan_Amountveriation.DrawLoan_Amountveriation(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);

							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							RCC_Revoke.RCC_Revoke(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 3);
							RPP.RPP(SSN, FileName);
							EPP_Void.EPP_Void(SSN, FileName);
							RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}
				}

				@Test(priority =77, groups = "venkat_KS_LOC_Prod") //// Deposit Issue//nnnnnnnn

				public void LOCI_Draw_Stmt_Deposit_RTN_DLQ_DFLT_Rccrevoke_BNK_RccStatus() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_Stmt_Deposit_RTN_DLQ_DFLT_Rccrevoke_BNK_RccStatus_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:219" + "_" + PayFrequency + "_" + CollateralType,
									"Pick the loan to which deposit is processed with Return file with R01/R09  reason_Def_RCC revoke_BNK_RCC status should be ineligible");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
							Payliance.Payliance(SSN, FileName,0);
							AgeStore.AgeStore(SSN, FileName, 0);
							ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
							AgeStore.AgeStore(SSN, FileName, 2);
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
							RCC_Revoke.RCC_Revoke(SSN, FileName);
							Bankrupt.Bankrupt(SSN, FileName);
							RCCStatus.RCCStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

				}

				@Test(priority =78, groups = "venkat_KS_LOC_Prod") 

				public void LOCI_Draw_Stmt_Deposit_RTN_PendingBNK_DLQ_DFLT_RccEligibility_CheckRccStatus() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_Stmt_Deposit_RTN_PendingBNK_DLQ_DFLT_RccEligibility_CheckRccStatus_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:220" + "_" + PayFrequency + "_" + CollateralType,
									"Pick the loan to which deposit is processed with Return file with R01/R09  reason_Pending BNK_Default_RCC eligibility_Check RCC eligibility");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
							Payliance.Payliance(SSN, FileName,0);
							AgeStore.AgeStore(SSN, FileName, 0);
							ACH_Deposit.ACH_Deposit(SSN, FileName, 0);

							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 2);
							PendingBNK.PendingBNK(SSN, FileName);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

				}

				@Test(priority =79, groups = "venkat_KS_LOC_Prod") // Deposit Issue//nnnnnnnn

				public void LOC_Draw_Deposit_Return_BNK_Decease_Writoff() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOC_Draw_Deposit_Return_BNK_Decease_Writoff_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

							test = reports.startTest(Header + "_S.No:221" + "_" + PayFrequency + "_" + CollateralType,
									"AA_LOC_Draw_Deposit_Return_BNK_Decease_Writoff_RCC Ineligible");

							Assert.assertTrue(true);
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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

							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 3);
							Bankrupt.Bankrupt(SSN, FileName);
							Bankrupt_Deceased.Bankrupt_Deceased(SSN, FileName);
							Check_RCCSchd_WO1.Check_RCCSchd_WO1(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}

					}

				}

				@Test(priority =80, groups = "venkat_KS_LOC_Prod") // Create Duplicate Testdata 02-20-2020

				public void LocI_Draw_Stmt_Deposit_Return_DLQ_Cure_DEF_WO_CheckEligibilityofRCC() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_Stmt_Deposit_RTN_PendingBNK_DLQ_DFLT_CheckRccStatusEligibility_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:220" + "_" + PayFrequency + "_" + CollateralType,
									"Pick the loan to which deposit is processed with Return file with R01/R09  reason_Pending BNK_Default_RCC eligibility_Check RCC eligibility");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
							Payliance.Payliance(SSN, FileName,0);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

				}

				@Test(priority =81, groups = "venkat_KS_LOC_Prod") // Deposit Issue//nnnnnnnn

				public void LOCI_Draw_Stmt_Deposit_RTN_DFLT_RCCRevoke_RCCStatus() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_Stmt_Deposit_RTN_DFLT_RCCRevoke_RCCStatus_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:224" + "_" + PayFrequency + "_" + CollateralType,
									"Pick the loan to which deposit is processed with Return file with R01/R09 reason_Default_Check RCC revoke option is available_If available process it_Check RCC eligibility(should not be eligible for RCC)");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
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
							Payliance.Payliance(SSN, FileName,0);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
						}
					}

				}

				@Test(priority =82, groups = "venkat_KS_LOC_Prod")

				public void LOCI_DEF_RccSechdule_Deposit_ReturnWithR02_ElegibleforRpp() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_DEF_RccSechdule_Deposit_ReturnWithR02_ElegibleforRpp_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:266" + "_" + PayFrequency + "_" + CollateralType,
									"Def_RCC Schedule_deposit_return_return with R02_Eligible for RPP");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan1.DrawLoan1(SSN, FileName);
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

				}

				@Test(priority =83, groups = "venkat_KS_LOC_Prod") 

				public void LOCInit_Draw_Stmt_DLQ_Cure_DFLT_RCCSchedule_DepositlastInst_ClearLastInst_ReturnLastInst_()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCInit_Draw_Stmt_DLQ_Cure_DFLT_RCCSchedule_DepositlastInst_ClearLastInst_ReturnLastInst_Txn_TestData.xls";
					
					String path=System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat");     
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:269" + "_" + PayFrequency + "_" + CollateralType, "LOC Init _ Draw _ Stat _ delinquent _ Cure _ Default   _ generate RCC Schedule  _  Deposit the last installment _ Clear_ Then return the last installment ACH/RCC/NOC STORE/Online/PAM  ");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan1.DrawLoan1(SSN, FileName);
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
							Admin_ACH_Clear.Admin_ACH_Clear_RCC(SSN, FileName, 10, 2);
							RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 3);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 3);
							LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 3);
							Admin_ACH_Clear.Admin_ACH_Clear_RCC(SSN, FileName, 10, 3);
							RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 4);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 4);
							LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 4);
							Admin_ACH_Clear.Admin_ACH_Clear_RCC(SSN, FileName, 10, 4);
							RCC_Return.RCC_Return(SSN, FileName);
							RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}
				}

				@Test(priority =84, groups = "venkat_KS_LOC_Prod")

				public void LOCI_Draw_stmt_DLQ_Cure_DFLT_GenerateRCC_ACTM_ACTMEnd_EODonDueDate_Sc278() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_stmt_DLQ_Cure_DFLT_GenerateRCC_ACTM_ACTMEnd_EODonDueDate_Txn_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}
				}

				@Test(priority =85, groups = "venkat_KS_LOC_Prod")  

				public void DFLTcustomer_RCC7_RCCSchedule__lastinstdeposit_Bnkruptwithclear_VoidBNK_Sc282() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule__lastinstdeposit_Bnkruptwithclear_VoidBNK_Txn_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
							Admin_ACH_Clear.Admin_ACH_Clear_RCC(SSN, FileName, 10, 2);
							Bankrupt_NoRecord.Bankrupt_NoRecord(SSN, FileName);
							Bankrupt_NoRecord_void.Bankrupt_NoRecord_void(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}
				}

				@Test(priority =86, groups = "venkat_KS_LOC_Prod")

				public void DFLTcustomer_RCC7_RCCSchedule__Bankruptcy_VoidBNK_RCCStatusverification_Sc284() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule__Bankruptcy_VoidBNK_RCCStatusverification_Txn_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:284" + "_" + PayFrequency + "_" + CollateralType,
									"Pick Default status loan_RCC eligibility should be 7_Generate RCC letter_After the Schedule generation_Bankrupt_Void Bankrupt");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
						}
					}
				}

				@Test(priority =87, groups = "venkat_KS_LOC_Prod")

				public void DFLTcustomer_RCC7_RCCSchedule__PendingBankruptcy_VoidPendingBnkrupt_VerifyRCCSchedule_Sc286()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_DFLTcustomer_RCC7_RCCSchedule__PendingBankruptcy_VoidPendingBnkrupt_VerifyRCCSchedule_Txn_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:286" + "_" + PayFrequency + "_" + CollateralType,
									"Pick Default status loan_Void Pending Bankrupt_Try to generate schedule 10 days before next pay date_schedule must be generated");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
	
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}
				}

				@Test(priority =88, groups = "venkat_KS_LOC_Prod")

				public void LocI_Draw_Stmt_Deposit_Return_DLQ_Cure_DEF_WO_CheckEligibilityofRCC1() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LocI_Draw_Stmt_Deposit_Return_DLQ_Cure_DEF_WO_CheckEligibilityofRCC_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:289" + "_" + PayFrequency + "_" + CollateralType,
									" LOC Init_Draw_Stat_Deposit_Return with R01 and R09_delinquent_Cure_DEF_WO_Check Eligibility of RCC  )");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							if (CollateralType.equals("ACH")) {
								AgeStore.AgeStore(SSN, FileName, -1);
								DrawerDeassign.DrawerDeassign(SSN, FileName);
								StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
								StoreInfo.StoreInfo(SSN, FileName);
								Safeassign.Safeassign(SSN, FileName);
								Drawerassign.Drawerassign(SSN, FileName);
								Payliance.Payliance(SSN, FileName,0);
								AgeStore.AgeStore(SSN, FileName, 0);
								ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
								ACHReturnPosting.ACHReturnPosting(SSN, FileName);
								DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							}
							if (CollateralType.equals("CASH")) {
								EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
								DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							}
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							Default_WOProc.Default_WOProc(SSN, FileName, 90);
							WOPaymentStatus.WOPaymentStatus(SSN, FileName);
							RCCStatus.RCCStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

				}

				@Test(priority =89, groups = "venkat_KS_LOC_Prod")

				public void LOCI_Draw_stmt_Deposit_ReturnwithR01_DLQ_Cure_WO_PendingBNK_Deceased_EligibilityRCC_Sc291()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_stmt_Deposit_ReturnwithR01_DLQ_Cure_WO_PendingBNK_Deceased_EligibilityRCC_Txn_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:291" + "_" + PayFrequency + "_" + CollateralType,
									"LOC Init – Draw – Stat – Deposit – Return with R01 and R09 - delinquent – Cure – WO – WO – Bankrupt/Pending Bankrupt/Deceased -Check Eligibility of RCC");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -1);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
						Payliance.Payliance(SSN, FileName,0);
							ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
							AgeStore.AgeStore(SSN, FileName, 3);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 30);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							Default_WOProc.Default_WOProc(SSN, FileName, 60);
							PendingBNK.PendingBNK(SSN, FileName);
							Bankrupt.Bankrupt(SSN, FileName);
							RCCStatus.RCCStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}
				}

				@Test(priority =90, groups = "venkat_KS_LOC_Prod")

				public void LOCInit_Draw_Stmt_Dep_ReturnR01andR09_DLQT_Cure_ACHRevoke_WO_CheckRCC_() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCInit_Draw_Stmt_Dep_ReturnR01andR09_DLQT_Cure_ACHRevoke_WO_CheckRCC_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:292" + "_" + PayFrequency + "_" + CollateralType,
									"LOC Init _ Draw _ Statmnt _ Deposit _ Return with R01 and R09 _ delinquent _ Cure _ ACH Optout _ WO _ WO _Check Eligibility of RCC");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);

							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -1);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);

							if (CollateralType.equals("ACH")) {
								Payliance.Payliance(SSN, FileName,0);
								ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
								ACHReturnPosting.ACHReturnPosting(SSN, FileName);
								DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							}
		
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							ACH_Revoke.ACH_Revoke(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							Default_WOProc.Default_WOProc(SSN, FileName, 90);
							RCCStatus.RCCStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

				}

				@Test(priority =91, groups = "venkat_KS_LOC_Prod")

				public void LOCInit_Draw_Stmt_delinquent_Cure_WO_RCCSchd_WORecoveryfullPmt_VoidWORecovery_RCCSCheduleRevise_IsLoanRCCN()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCInit_Draw_Stmt_delinquent_Cure_WO_RCCSchd_WORecoveryfullPmt_VoidWORecovery_RCCSCheduleRevise_IsLoanRCCN_TestData.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:294" + "_" + PayFrequency + "_" + CollateralType,
									"LOC Init _ Draw _ Stat _ delinquent _ Cure _ WO _ WO _ RCC Schedule _ Full WO Recovery payment _ Void WO Recovery payment _RCC Schedules should be revised, is_ canceled flag should be updated to N ");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							Default_WOProc.Default_WOProc(SSN, FileName, 60);
							WOPaymentStatus.WOPaymentStatus(SSN, FileName);
							EditBorrower_AfterWO.EditBorrower_AfterWO(SSN, FileName);
							
							Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
							Check_RCCSchd.Check_RCCSchd(SSN, FileName);
							RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
							Writoff_Recovery.Writoff_Recovery(SSN, FileName);
							WORecovery_Void.WORecovery_Void(SSN, FileName);
							RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);

						}
					}

				}
				

		@Test(priority =92, groups = "venkat_KS_LOC_Prod")

				public void LOCI_Draw_Stmt_delinquent_Cure_DFLT_WO_RCCScdl_RCCRev_RCCCancelled_() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_Stmt_delinquent_Cure_DFLT_WO_RCCScdl_RCCRev_RCCCancelled_TestData.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:295" + "_" + PayFrequency + "_" + CollateralType,
									"LOC Init – Draw – Stat – delinquent – Cure – WO - WO – RCC Schedule – RCC Revoke --RCC Schedules should be canceled ");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);

							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							Default_WOProc.Default_WOProc(SSN, FileName, 60);
							WOPaymentStatus.WOPaymentStatus(SSN, FileName);
							EditBorrower_AfterWO.EditBorrower_AfterWO(SSN, FileName);
							Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
							Check_RCCSchd.Check_RCCSchd(SSN, FileName);
							RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
							RCCRevoke.RCCRevoke(SSN, FileName);
							RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 2);
							RCCStatus.RCCStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
						}
					}

				}
				

				@Test(priority =93, groups = "venkat_KS_LOC_Prod") 

				public void LOCI_Draw_Stmt_Dlqt_Cure_WO_RCCSchdl_1stInstDep_clear_NextInstPartPmt_RCCScdlReviseBalAmt_()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_Stmt_Dlqt_Cure_WO_RCCSchdl_1stInstDep_clear_NextInstPartPmt_RCCScdlReviseBalAmt_Txn_TestData.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:298" + "_" + PayFrequency + "_" + CollateralType,
									"LOC Init _ Draw _ Stat _ delinquent _ Cure _ DFLT _ WO _ RCC Schedule _ 1st installment deposit _ clear _ Next installment make partial installment amount payment _RCC Schedules should be revised with balance amount only  ");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan1.DrawLoan1(SSN, FileName);
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							Default_WOProc.Default_WOProc(SSN, FileName, 60);
							WOPaymentStatus.WOPaymentStatus(SSN, FileName);
							EditBorrower_AfterWO.EditBorrower_AfterWO(SSN, FileName);
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
							Admin_ACH_Clear.Admin_ACH_Clear_RCC(SSN, FileName, 10, 2);
							RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, 4, 2);
							Writoff_Recovery.Writoff_Recovery(SSN, FileName);
							RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
							RCC_Schedule_Status_verification.RCC_Schedule_Status_verification(SSN, FileName, 0);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
							// history.history(SSN, FileName);

						}
					}
				}

				@Test(priority =94, groups = "venkat_KS_LOC_Prod")

				public void DFLT_WO_RccSChedule_RccRevoke_Epp_voidEpp_RccAuthorzation_CustomershouldeligibleforRCCnow()
						throws Exception {

					// Start test. Mention test script name

					String FileName = "AA_DFLT_WO_RccSChedule_RccRevoke_Epp_voidEpp_RccAuthorzation_CustomershouldeligibleforRCCnow_TestData.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);

					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:304" + "_" + PayFrequency + "_" + CollateralType,
									"LOC Init_Draw_Stat_delinquent_Cure_WO_WO_RCC Schedule generated_RCC Revoke_EPP_Void EPP_RCC Authozation_Customer should eligible for RCC now ");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							Default_WOProc.Default_WOProc(SSN, FileName, 60);
							WOPaymentStatus.WOPaymentStatus(SSN, FileName);
							EditBorrower_AfterWO.EditBorrower_AfterWO(SSN, FileName);
							Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
							RCC_Revoke.RCC_Revoke(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 3);
							RPP.RPP(SSN, FileName);
							EPP_Void.EPP_Void(SSN, FileName);
							RCCAuthorization.RCCAuthorization(SSN, FileName);
							RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
							// history.history(SSN, FileName);

						}
					}
				}

				@Test(priority =95, groups = "venkat_KS_LOC_Prod")

				public void LOCI_Draw_Stmt_DLQ_Cure_Default_WO_DepositandClearLastInstall_LoanshouldBeClosed() throws Exception {

					// Start test. Mention test script name

					String FileName = "AA_LOCI_Draw_Stmt_DLQ_Cure_Default_WO_DepositandClearLastInstall_LoanshouldBeClosed_TestData.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:306" + "_" + PayFrequency + "_" + CollateralType,
									"LOC Init_Draw_Stat_delinquent_Cure_WO_WO_generate RCC Schedule_Deposit the last installmentClear last installment_Last installment deposit and clear Loan should be closed");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							Default_WOProc.Default_WOProc(SSN, FileName, 60);
							WOPaymentStatus.WOPaymentStatus(SSN, FileName);
							EditBorrower_AfterWO.EditBorrower_AfterWO(SSN, FileName);
							Check_RCCSchd_WO.Check_RCCSchd_WO(SSN, FileName, -3);
							RCC_Schedule_1stInst_Agestore.RCC_Schedule_1stInst_Agestore(SSN, FileName, -1, 2);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							AfterDFLT_RCCOrigination.AfterDFLT_RCCOrigination(SSN, FileName, -1, 2);
							LOC_PreRCC_Deposit.LOC_PreRCC_Deposit(SSN, FileName, 0, 2);
							Admin_ACH_Clear.Admin_ACH_Clear_RCC(SSN, FileName, 10, 2);
							RCCStatus_LoanStatus.RCCStatus_LoanStatus(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
							// history.history(SSN, FileName);

						}
					}
				}

				@Test(priority =96, groups = "venkat_KS_LOC_Prod1")

				public void LOCI_Draw_Stmt_DLQ_Cure_Default_WO_DepositandReturnLastInstall_Loanshouldbeupdatedtopreviousstatusandscheduleshouldberevised()
						throws Exception {

					// Start test. Mention test script name

					String FileName = "AA_LOCI_Draw_Stmt_DLQ_Cure_Default_WO_DepositandReturnLastInstall_Loanshouldbeupdatedtopreviousstatusandscheduleshouldberevised_TestData.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:308" + "_" + PayFrequency + "_" + CollateralType,
									"LOC Init_Draw_Stat_delinquent_Cure_WO_WO_generate RCC Schedule_Deposit the last installment_Then return the last installment_Loan should be updated to previous status and schedule should be revised");
							 SetDate.SetDate(SSN, FileName, "01", "28", "2020");
							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoanDraw_3installment.NewLoanDraw_3installment(SSN, FileName);
							StatementGeneration.StatementGeneration(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10);
							CurePaymentStatus.CurePaymentStatus(SSN, FileName);
							CustomerDefault.CustomerDefault(SSN, FileName);
							DefaultPaymentStatus.DefaultPaymentStatus(SSN, FileName);
							Default_WOProc.Default_WOProc(SSN, FileName, 60);
							WOPaymentStatus.WOPaymentStatus(SSN, FileName);
							EditBorrower_AfterWO.EditBorrower_AfterWO(SSN, FileName);
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
							Admin_ACH_Clear.Admin_ACH_Clear_RCC(SSN, FileName, 10, 2);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
							

						}
					}
				}

				@Test(priority =97, groups = "venkat_KS_LOC_Prod")

				public void LOCI_WKY_Bim_Bi_Draw_Stmt_Dep_Return_PartialPayment_RepDep() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_WKY_Bim_Bi_Draw_Stmt_Dep_Return_PartialPayment_RepDep_TestData.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:310" + "_" + PayFrequency + "_" + CollateralType,
									"LOC Init MON) Customer =>Draw_Stmnt_Dep_Return_Rep Dep should not be posted");

							Login.Login(UserName, Password, StoreId);

							BorrowerRegistrationpage.RegistrationPage_NewLoan_LOC(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -1);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
							// FileName, 0);
							Payliance.Payliance(SSN, FileName,0);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
							// history.history(SSN, FileName);

						}
					}

				}

				@Test(priority =98, groups = "venkat_KS_LOC_Prod")

				public void LOCI_wky_Bim_Bi_Draw_Stmt_Dep_Return_RepDep_Clear_Return() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_wky_Bim_Bi_Draw_Stmt_Dep_Return_RepDep_Clear_Return_TestData.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);

					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							NewLoan.NewLoan(SSN, FileName);
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -1);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							// EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN,
							// FileName, 0);
							Payliance.Payliance(SSN, FileName,0);
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
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
							// history.history(SSN, FileName);

						}
					}

				}

				@Test(priority =99, groups = "venkat_KS_LOC_Prod")

				public void LOCI_Draw_Stmnt_Dep_Return_RepDep_ActMilitary_RepresrecCancel_() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_LOCI_Draw_Stmnt_Dep_Return_RepDep_ActMilitary_RepresrecCancel_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KS_LOC_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_KS_LOC_venkat");
							UserName = prop.getProperty("UserName_KS_LOC_venkat");
							Password = prop.getProperty("Password_KS_LOC_venkat");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_KS_LOC_venkat");
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
							DrawLoan.DrawLoan(SSN, FileName, "50");
							StatementGeneration.StatementGeneration(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -1);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							
							Payliance.Payliance(SSN, FileName,0);
							ACH_Deposit.ACH_Deposit(SSN, FileName, 0);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							Represent_Status.Represent_Status(SSN, FileName);
							DeliquentPaymentStatus.DeliquentPaymentStatus(SSN, FileName);
							Active_Military_Start.Active_Military_Start(SSN, FileName);
							Represent_Status.Represent_Status(SSN, FileName);
							Historyvalidation_LOC.Historyvalidation_LOC(SSN, FileName);
							// history.history(SSN, FileName);

						}
					}
				}
				



				@AfterMethod(alwaysRun = true)

				public void getResult(ITestResult result) throws Exception {
					if (result.getStatus() == ITestResult.FAILURE) {
						test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());


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

					File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
					String destination = System.getProperty("user.dir") + "/ExecutionReports/KS_LOC/FailedTestsScreenshots/"
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
				

					String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
			

					String kfilename = prop.getProperty("AA_Store_extent_report_file_name_TN") + timestamp + ".html";

					reports = new ExtentReports(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_extent_report_path_KS") + kfilename, true);
					reports.addSystemInfo("Product", "AA_KS_LOC_Regression");

				
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
					Thread.sleep(5000); 
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
