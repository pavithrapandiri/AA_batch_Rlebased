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

public class AA_MI_PDL extends AA_PDL{
	//@Test (priority=41,groups = "pavithra_MI_PDL")

	public void CheckingPartialPmt_SomeDaysAfterDueDate() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_CheckingPartialPmt_SomeDaysAfterDueDate_Txn_Testdata.xls";
		//			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:42" + "_" + PayFrequency + "_" + CollateralType, "New Loan_Age store up to some days after due date_Check Partial Payment transaction is displayed or not.");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				//NewLoanMI.NewLoanMI(SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,5);
				CheckPartialPayment.CheckPartialPayment(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				AA_FL_PDL.IETaskKiller();


				//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
				//wait(100);
				// RegistrationPage.RegistrationPage(SSN);
			}
		}
		//Login.Login("CSR353","1234","353");

	}

	//@Test (priority=42,groups = "pavithra_MI_PDL")

	public void PartialPayment_MultipleTenderTypes() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoan_PartialPayment_MultipleTenderTypes.xls";
		//			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:43" + "_" + PayFrequency + "_" + CollateralType, "Loan_partial payment with multiple tender types_check updates");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,-2);
				LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender(SSN, FileName);
				check_updates.check_updates(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				AA_FL_PDL.IETaskKiller();


				//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
				//wait(100);
				// RegistrationPage.RegistrationPage(SSN);
			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
	
	//@Test (priority=43,groups = "pavithra_MI_PDL")

	public void NewLoan_Deposit_CheckPartialPaymentDisplay_AfterDeposit() throws Exception {
		          
		// Start test. Mention test script name
		String FileName= "AA_NewLoan_Deposit_CheckPartialPaymentDisplay_AfterDepositTestData.xls";
		//Excel TestData = new Excel("E:/AA/TestData/PDL/"+FileName);
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:44" + "_" + PayFrequency + "_" + CollateralType, "Adv --> Deposit --> Check whether Partial payment is displayed after check is deposited .");
				
			    SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CheckPartialPaymentinDropdown.CheckPartialPaymentinDropdown(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				AA_FL_PDL.IETaskKiller();
			}
		}
	}
	
	//@Test (priority=44,groups = "pavithra_MI_PDL")

	public void PartialPayment_Agestore_CheckLoanDisplayedEOD() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Partialpayment_Agestore_CheckRecordEOD_Txn_Testdata.xls";
		//			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				
				test = reports.startTest(Header + "_S.No:45" + "_" + PayFrequency + "_" + CollateralType, "Loan_Age store to some days_Partial Payment_Age the store  to due date_Check Whether Loan is displayed in EOD");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				// RegistrationPage.RegistrationPage(SSN, FileName);
				
				//Bor.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,-4);
				LoanPartialPayment.LoanPartialPayment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				CheckStatus.CheckStatus(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				AA_FL_PDL.IETaskKiller();
				
			}
		}
	}
	
//@Test (priority=45,groups = "pavithra_MI_PDL")

	public void Loan_AgeStore_ProcessDeposit_Payliance_DepositShouldPost() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_AgeStore_ProcessDeposit_Nacha_DepositShouldPost_TestData.xls";
		//			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:46" + "_" + PayFrequency + "_" + CollateralType, "Loan_Age the store up to due date_Process the deposit_Process GB Nacha File from admin Interface_Deposit should post");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit_Status.ACH_Deposit_Status(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				AA_FL_PDL.IETaskKiller();

				//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
				//wait(100);
				// RegistrationPage.RegistrationPage(SSN);
			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
	//@Test (priority=46,groups = "pavithra_MI_PDL")

	public void LoanWithCheck_DepConvertToACH_ACHDep_ProcessEOD() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_LoanWithCheck_DepConvertToACH_ACHDep_ProcessEOD_Txn_Testdata.xls";
		//			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:47" + "_" + PayFrequency + "_" + CollateralType, "Loan(Check)_Dep (Convert ACH)_Deposit_Process EOD");
				 
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);

				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
			
				
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				ACH_History_Status.ACH_History_Status	(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				AA_FL_PDL.IETaskKiller();


			}
		}
	

	}
	
	//@Test (priority=47,groups = "pavithra_MI_PDL") 

	public void LoanWithCheck_ConvertACH_Deposit_ACHClear() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Newloan_Dep (Convert ACH)_Deposit_ACH Clear1.xls";
		//			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:48" + "_" + PayFrequency + "_" + CollateralType, "Loan(Check)_Dep (Convert ACH)_Deposit_ACH Clear");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
			
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,0);
				
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 7);
				ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				AA_FL_PDL.IETaskKiller();
				
			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
	//@Test (priority=48,groups = "pavithra_MI_PDL") 

	public void LoanwithCheck__DepConvertACH__Deposit__ACHReturn() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_LoanwithCheck__DepConvertACH__Deposit__ACHReturn_Txn_Testdata.xls";
		//			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:49" + "_" + PayFrequency + "_" + CollateralType, "Loan(Check)_Dep (Convert ACH)_Deposit_ACH Return");
				
	             SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
								
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				
				AA_FL_PDL.IETaskKiller();



			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
	//@Test (priority=49,groups = "pavithra_MI_PDL") 

	public void Loan_Full_PrePayment() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_Full_PrePayment_Txn_Testdata.xls";
		//			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:50" + "_" + PayFrequency + "_" + CollateralType, "Loan_Age the store  upto duedate_perform deposit_age the store_perform the Prepayment");
				 
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);			     
				
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				ACH_Prepayment_History.ACH_Prepayment_History(SSN, FileName);
				////HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				AA_FL_PDL.IETaskKiller();

			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
	//@Test (priority=50,groups = "pavithra_MI_PDL")  

	public void Newloan_VoidPrePayment() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_BorrowerRegistration_NewLoan_Void_Txn_Testdata.xls";
		//			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:51" + "_" + PayFrequency + "_" + CollateralType, "Loan_Age the store  upto duedate_perform deposit_age the store_perform the Prepayment_Void");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);			     
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				Void_PrePayment.Void_PrePayment(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				AA_FL_PDL.IETaskKiller();
				

				
			}
		}
		//Login.Login("CSR353","1234","353");
	}



	//Srikanth scenarios
	
//@Test (priority=51,groups = "pavithra_MI_PDL")

	public void PartialPayment_ACH_Deposit() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Prenote_Verification_within5businessdays_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:52" + "_" + PayFrequency + "_" + CollateralType, "Loan_Age the store  upto duedate_Partial Payment_perform deposit(Convert Check to ACH_age perform the Prepayment_Check whether check amount is displayed or due amount is displayed");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,-2);
				LoanPartialPayment.LoanPartialPayment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				

			}
		}
}
///////////////////////
	@Test (priority=52,groups = "pavithra_MI_PDL") 

	public void Nacha_ACHDepositProcess_ACHReturn() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Nacha_DepositProcess_ReturnPosting_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
			;
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				//test = reports.startTest("Scenario_No_60_"+Header, "Loan (ACH) -->  Nacha --> Ach Deposit process --> Ach Return posting");
				test = reports.startTest(Header+"_S.No:53"+"_"+PayFrequency+"_"+CollateralType,"Loan (ACH)_Nacha_Ach Deposit process_Ach Return posting");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);			
				StoreInfo.StoreInfo(SSN, FileName); 
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
	@Test (priority=53,groups = "pavithra_MI_PDL")

	public void ConvertCheckToACHNacha_ACHDepositProcess_ACHReturn() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_ConvertCheckToACHNacha_DepositProcess_ReturnPosting_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				//test = reports.startTest("Scenario_No_62_"+Header,"Loan (Check) -->  (Convert to ACH) Ach Deposit process --> Ach Return Posting");
				test = reports.startTest(Header+"_S.No:54"+"_"+PayFrequency+"_"+CollateralType,"Loan (Check)_(Convert to ACH) Ach Deposit process_Ach Return Posting");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName); 
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName); 
				Safeassign.Safeassign(SSN, FileName); 
				Drawerassign.Drawerassign(SSN, FileName); 
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
			

				
			}
		}
		

	}
	
	@Test (priority=54,groups = "pavithra_MI_PDL")

	public void Loan_Deposit_PrePayment_Return() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_DepositProcess_PrePayment_ReturnPosting_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				//test = reports.startTest("Scenario_No_64_"+Header,"Loan  --> Age the store  upto duedate --> perform deposit --> age perform the Prepayment--> age the store --> return");
				test = reports.startTest(Header+"_S.No:55"+"_"+PayFrequency+"_"+CollateralType,"Loan_Age the store  upto duedate_perform deposit_age perform the Prepayment_age the store_return");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName); 
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName); 
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 2);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 4);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
	@Test (priority=55,groups = "pavithra_MI_PDL") 

	public void LoanwithCheck_Deposit_ReturnwithoutR01R09_FutureDepositNotposted() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoan(check)_Deposit_ReturnPostingwithout(R01R09)_FetureDepositnotPost_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				//test = reports.startTest("Scenario_No_67_"+Header,"loan with check->deposit->return with return reason id other than R01,R09 then should not allow for future deposit");
				test = reports.startTest(Header+"_S.No:56"+"_"+PayFrequency+"_"+CollateralType,"loan with check->deposit_return with return reason id other than R01,R09 then should not allow for future deposit");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName); 
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName); 
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName); 
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACHReturnPostingWithoutR01R09.ACHReturnPostingWithoutR01R09(SSN, FileName); 
				ACHEffectiveDate_AgeStore.ACHEffectiveDate_AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);  
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				
			}
		}
		
	}
	
	@Test (priority=56,groups = "pavithra_MI_PDL")

	public void LoanwithACH_NACHA_ACHDepProc_ProcessClear() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_LoanwithACH_NACHA_ACHDepProc_ProcessClear_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:57"+"_"+PayFrequency+"_"+CollateralType, "Loan (ACH)_Nacha_Ach Deposit process_Process Clear");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				//ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);//this method not perform clear so need to use eod batch
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 7);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
 /*@Test (priority=57,groups = "pavithra_MI_PDL2")	

	public void NewLoan_PreNoteDeposit_PreNoteClear() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoan_PreNoteDeposit_PreNoteClearTestData.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:58"+"_"+PayFrequency+"_"+CollateralType, "Loan (ACH/Check)_Pre Note Deposit_PreNote clear");
				
				 SetCurrentDate.SetCurrentDate(SSN, FileName);
				 Login.Login(UserName,Password,StoreId);
				
				   RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				   NewLoanMI.NewLoanMI(SSN, FileName);
				   AgeStore.AgeStore(SSN, FileName, 0);
			        DrawerDeassign.DrawerDeassign(SSN, FileName);
                	UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);						     
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore_ACHEffectiveDate.AgeStore_ACHEffectiveDate(SSN, FileName, -7);
					ACHEffectivedate_6DaysBeforeDuedate.ACHEffectivedate_6DaysBeforeDuedate(SSN, FileName, 0);
					EOD_BatchProcess_Clear.EOD_BatchProcess_PrenoteClear_FL(SSN, FileName, 7);
					//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
			       
	
			}
		}
		//Login.Login("CSR353","1234","353");

	}*/
	
	@Test (priority=58,groups = "pavithra_MI_PDL")

	public void LoanwithCheck_ConverttoACH_ACHDepproc_ProcClear() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_LoanwithCheck_ConverttoACH_ACHDepproc_ProcClear_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:59"+"_"+PayFrequency+"_"+CollateralType, "Loan (Check)_(Convert to ACH) Ach Deposit process_Process Clear");
				 
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 7);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);


			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
	@Test (priority=59,groups = "pavithra_MI_PDL")

	public void Loan_Agestoreduedate_performdepositPrepayment_agestore_ProcessClear() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_Agestoreduedate_performdepositPrepayment_agestore_ProcessClear_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    			int lastrow=TestData.getLastRow("NewLoan");
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:60"+"_"+PayFrequency+"_"+CollateralType, "Loan_Age the store  upto duedate_perform deposit_age perform the Prepayment_age the store_Process Clear");
				 

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				AgeStore_ACH.AgeStore_ACH(SSN, FileName, 5);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 7);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);


			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
	

@Test (priority=60,groups = "pavithra_MI_PDL")

	public void Newloan_PartialPayment_Deposit_Clear_Refund() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Newloan_PartialPayment_Deposit_Clear_Refund.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:61"+"_"+PayFrequency+"_"+CollateralType, "Loan_Partial Payment_Deposit_Clear_Refund");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,-6);
				LoanPartialPayment.LoanPartialPayment(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName); 
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 7);
				ACH_ReFund.ACH_ReFund(SSN, FileName);
				ACH_ReFund_History.ACH_ReFund_History(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
				
			}
		}
		//Login.Login("CSR353","1234","353");

	}

@Test (priority=61,groups = "pavithra_MI_PDL")

	public void Loan_Deposit_FullPrePayment_Clear_Refund() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_Deposit_FullPrePayment_Clear_Refund_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:62"+"_"+PayFrequency+"_"+CollateralType, "Loan_Deposit_Pre Payment full_Clear_Refund");
				 
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 7);
				ACH_ReFund.ACH_ReFund(SSN, FileName);
				ACH_ReFund_History.ACH_ReFund_History(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
			}
		}
		

	}

@Test (priority=62,groups = "pavithra_MI_PDL")

	public void LoanWithCheck_ConvertAch_AchPrePayment_AchClr_Refund() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_LoanWithCheck_ConvertAch_AchPrePayment_AchClr_Refund_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:63"+"_"+PayFrequency+"_"+CollateralType, "Loan With Check_Deposit (Convert to ACH)_ACH Pre Payment Partially_ACH CLR_Refund");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_PartialPrePayment.ACH_PartialPrePayment(SSN, FileName);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName, 7);
				ACH_ReFund.ACH_ReFund(SSN, FileName);
				ACH_History_Status.ACH_History_Status(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

				
			}
		}
		

	}

@Test (priority=63,groups = "pavithra_MI_PDL") 

	public void NewLoan_ReturnPosting_60days_Writeoff() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoan_ReturnPosting_60days_Writeoff_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:64"+"_"+PayFrequency+"_"+CollateralType, "Loan_Return Posting_WO Check whether Write off is done 60days from return date.");
				


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);						     
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				writeoff_Process.writeoff_Process(SSN, FileName, 60);					      
				LoanStatus.LoanStatus(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

			}
		}
		

	}

 // @Test (priority=64,groups = "pavithra_MI_PDL")

	public void Loan_ReturnPosting_15PerofTotalDue__CheckWriteOff120daystoretdate() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_ReturnPosting_15PerofTotalDue__CheckWriteOff120daystoretdate_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:65"+"_"+PayFrequency+"_"+CollateralType, "Loan_Return Posting_NSF Payment 15% of Total Due_WO Check whether Write off is done 120 days from return date.");
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				// NewLoan_EODProcessing.NewLoan_EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				//PaylianceOrigination_PDL.PaylianceOrigination_PDL(SSN, FileName, 0, 2);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				// ACH_PartialPrePayment.ACH_PartialPrePayment(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPayment.ACHPayment(SSN, FileName, 0.15);
				WriteOff.WriteOff(SSN, FileName, 121);
				WriteOff_History.WriteOff_History(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);



			}
		}
		

	}

// @Test (priority=65,groups = "pavithra_MI_PDL")

	public void Loan_ReturnPosting_NSF15_Void_WO60days_Returndate() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_ReturnPosting_NSF15_Void_WO60days_Returndate_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:66"+"_"+PayFrequency+"_"+CollateralType, "Loan->Return Posting_NSF Payment 15% of Total Due_Void_WO Check whether Write off is done 60 days from return date.");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPayment.ACHPayment(SSN, FileName, 0.15);
				NSF_Void.NSF_Void(SSN, FileName);
				WriteOff.WriteOff(SSN, FileName, 60);
				WriteOff_History.WriteOff_History(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

				
			}
		}
		

	}
  
@Test (priority=66,groups = "pavithra_MI_PDL")

	public void Loan_ReturnPosting_30PerofTotalDue__CheckWriteOff180daystoretdate() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_ReturnPosting_30PerofTotalDue__CheckWriteOff180daystoretdate_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:67"+"_"+PayFrequency+"_"+CollateralType, "Loan->Return Posting_NSF Payment 30% of Total Due_WO Check whether Write off is done 180 days from return date.");
				


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPayment.ACHPayment(SSN, FileName, 0.3);
				WriteOff.WriteOff(SSN, FileName, 181);
				WriteOff_History.WriteOff_History(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);



			}
		}
		

	}


/*@Test(priority=67,groups = "pavithra_MI_PDL") 

	public void NewLoan_DueDate_Holiday_Verification() throws Exception {

		// Start test. Mention test script name

		String FileName= "AA_NewLoan_Duedate_Holiday_Verification_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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

				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");

				String ProductID = TestData.getCellData(sheetName,"ProductID",row);

				String StateID = TestData.getCellData(sheetName,"StateID",row);

				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);


				String Header = StateID+ "_" + ProductID;

				//System.out.println(SSN);

				test = reports.startTest(Header+"_S.No:68"+"_"+PayFrequency+"_"+CollateralType, "Borrower_Next Payment date on Holiday Date_New Loan_Check Due Date for Holiday Date");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);

			}

		}


	}*/

	@Test (priority=68,groups = "pavithra_MI_PDL")

	public void Loan_Deposit_PrePaymentfull_Return_RefundnotDisplay() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_Deposit_PrePaymentfull_Return_RefundnotDisplay_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"_S.No:69"+"_"+PayFrequency+"_"+CollateralType, "Loan_Deposit_Pre Payment full_Return_Refund not display");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);				
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);						     
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				Prepaymentfull.Prepaymentfull(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting_AfterfullPayment(SSN, FileName);
				Refund_Status.Refund_Status(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

			}
		}
		
	}
	
	
	@Test (priority=69,groups = "pavithra_MI_PDL") 

	public void NewLoanwithcheck_VerifycheckAmountfield() throws Exception {

		// Start test. Mention test script name
		String FileName = "AA_NewLoanwithCheck_VerifyCheckAmountfield_Txn_Testdata.xls";

					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") +
		// FileName);
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				// System.out.println(SSN);
				test = reports.startTest(Header + "_S.No:70" + "_" + PayFrequency + "_" + CollateralType,"New Loan Check disbursement_Validate whether check amount field is disabled .");

				 SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanwithcheck_VerifyCheckAmountField.NewLoanwithcheck_VerifyCheckAmountField(SSN, FileName);
				


			}
		}

	}


	/*@Test (priority=70,groups = "pavithra_MI_PDL")

	public void NewLoan_LoginPAM_RescindACHoptioncheck() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Deposit_ACHReturn_WORwithtendertypesCCKwithsamenumbers_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_PDL_path_chenna") + FileName);

		//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_PDL_path_chenna") + FileName);     
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				//System.out.println(SSN);
				//test = reports.startTest(Header + "_S.No:05" + "_" + PayFrequency + "_" + CollateralType, "New Loan Check disbursement => Validate whether check amount field is disabled .");

				test = reports.startTest(Header+"_S.No:71"+"_"+PayFrequency+"_"+CollateralType,"New Loan_Login PAM_Select Rescind =>Only ACH option should be displayed.");

				//SetCurrentDate.SetCurrentDate(SSN, FileName);				
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				PAMRescind.PAMRescind(SSN, FileName);


			}
		}

	}*/





	@Test (priority=71,groups = "pavithra_MI_PDL")

	public void Partialpayment_MO_DifNumber() throws Exception {

		String FileName = "AA_Partialpayment_Mo_Dif_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") +
		// FileName);
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				// System.out.println(Password);

				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				//test = reports.startTest(Header + "S.NO:06:_Partialpayment_MO_diff Refnumbers");
				test = reports.startTest(Header+"_S.No:72"+"_"+PayFrequency+"_"+CollateralType,"Advance =>Partial Pay with 2 tender types as MO with different numbers =>Transaction should be processed)");

				 SetCurrentDate.SetCurrentDate(SSN, FileName);
			    Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
			}
		}

	}

	@Test (priority=72,groups = "pavithra_MI_PDL")

	public void Partialpayment_Mo_DifNumber_void() throws Exception {

		String FileName = "AA_Partialpayment_Mo_Dif_void_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") +
		// FileName);
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				// System.out.println(Password);

				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				//test = reports.startTest(Header + "S.NO:07:_Partialpayment_Mo_DifNumber_void");
				test = reports.startTest(Header+"_S.No:73"+"_"+PayFrequency+"_"+CollateralType,"Advance =>Partial Pay  with 2 tender types as MO with different numbers =>Transaction should be processed ->Void Partial Pay  with Original tender type.Validate screen if its displaying tender details properly)");

				 SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
				Partialpayment_Original_Tender_Void.Partialpayment_Original_Tender_Void(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
			}
		}

	}

	@Test (priority=73,groups = "pavithra_MI_PDL")  

	public void Partialpayment_Mo_DifNumber_Cashvoid() throws Exception {

		String FileName = "AA_Partialpayment_Mo_Dif_CashVoid_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");

				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				//test = reports.startTest(Header + "S.NO:08:AA_Partialpayment_Mo_Dif_CashVoid");
				test = reports.startTest(Header+"_S.No:74"+"_"+PayFrequency+"_"+CollateralType,"Advance =>Partial Pay  with 2 tender types as MO with different numbers =>Transaction should be processed ->Void Partial Pay  with cash.)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
				Partialpayment_Cash_Tender_Void.Partialpayment_Cash_Tender_Void(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
			}
		}

	}

@Test (priority=74,groups = "pavithra_MI_PDL")

	public void Partialpayment_Mo_DifNumber_AgestoreCashvoid() throws Exception {

		String FileName = "AA_Partialpayment_Mo_Dif_EncryCashVoid_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") +
		// FileName);
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");

				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				//test = reports.startTest(Header + "S.NO:09:AA_Partialpayment_Mo_Dif_EncryCashVoid");
				test = reports.startTest(Header+"_S.No:75"+"_"+PayFrequency+"_"+CollateralType,"Advance =>Partial Pay  with 2 tender types as MO with different numbers =>Transaction should be processed ->Void Partial Pay  next processing day ->Only cash should be available.)");

				 SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				PartialPayment_VoidEncryptionKey.PartialPayment_VoidEncryptionKey(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
			}
		}

	}

	@Test (priority=75,groups = "pavithra_MI_PDL")

	public void Partialpayment_MO_SameNumber() throws Exception {

		String FileName = "AA_Partialpayment_Mo_Same_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") +
		// FileName);
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");

				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				//test = reports.startTest(Header + "S.NO:10:_Partialpayment_MO_same Refnumbers");
				test = reports.startTest(Header+"_S.No:76"+"_"+PayFrequency+"_"+CollateralType,"Advance =>Partial Pay  with 2 tender types as MO with same numbers =>Transaction should not be processed)");

				 SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				LoanPartialPayment_Same.LoanPartialPayment_Same(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);
			}
		}

	}

	@Test (priority=76,groups = "pavithra_MI_PDL")

	public void Partialpayment_CCK_DifNumber() throws Exception {

		String FileName = "AA_Partialpayment_CCK_Dif_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") +
		// FileName);
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");

				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				//test = reports.startTest(Header + "S.NO:11:_Partialpayment_CCK_Diff_Refnumbers");
				test = reports.startTest(Header+"_S.No:77"+"_"+PayFrequency+"_"+CollateralType,"Advance =>Partial Pay  with 2 tender types as CCK with different numbers =>Transaction should be processed)");

				 SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

			}
		}

	}

	@Test (priority=77,groups = "pavithra_MI_PDL")

	public void Partialpayment_CCK_DifNumber_Void_OriginalTender() throws Exception {

		String FileName = "AA_Partialpayment_CCK_Dif_OriginalTender_Void_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") +
		// FileName);
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				//test = reports.startTest(Header + "S.NO:12:_Partialpayment_CCK_DifNumber_Void_OriginalTender");
				test = reports.startTest(Header+"_S.No:78"+"_"+PayFrequency+"_"+CollateralType,"Advance =>Partial Pay  with 2 tender types as CCK with different numbers =>Transaction should be processed ->Void Partial Pay  with Original tender type.Validate screen if its displaying tender details properly)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
				Partialpayment_Original_Tender_Void.Partialpayment_Original_Tender_Void(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

			}
		}

	}

	@Test (priority=78,groups = "pavithra_MI_PDL")

	public void Partialpayment_CCK_DifNumber_Void_Cash() throws Exception {

		String FileName = "AA_Partialpayment_CCK_Dif_Cash_Void_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") +
		// FileName);
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				//test = reports.startTest(Header + "S.NO:13:__Partialpayment_CCK_DifNumber_Void_Cash");
				test = reports.startTest(Header+"_S.No:79"+"_"+PayFrequency+"_"+CollateralType,"Advance =>Partial Pay  with 2 tender types as CCK with different numbers =>Transaction should be processed ->Void Partial Pay  with cash.)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
				Partialpayment_Cash_Tender_Void.Partialpayment_Cash_Tender_Void(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

			}
		}

	}

	@Test (priority=79,groups = "pavithra_MI_PDL")

	public void Partialpayment_CCK_DifNumber_Encryption_Void_Cash() throws Exception {

		String FileName = "AA_Partialpayment_CCK_Dif_Cash_EncryptionVoid_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") +
		// FileName);
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				//test = reports.startTest(Header + "S.NO:14:_Partialpayment_CCK_DifNumber_Encryption_Void_Cash");
				test = reports.startTest(Header+"_S.No:80"+"_"+PayFrequency+"_"+CollateralType,"Advance =>Partial Pay  with 2 tender types as CCk with different numbers =>Transaction should be processed ->Void Partial Pay  next processing day ->Only cash should be available.)");

				 SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -4);
				LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				PartialPayment_VoidEncryptionKey.PartialPayment_VoidEncryptionKey(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

			}
		}

	}

	@Test (priority=80,groups = "pavithra_MI_PDL")

	public void Partialpayment_CCK_SameNumber() throws Exception {

		String FileName = "AA_Partialpayment_CCK_Same_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_MI_PDL_path_Pavitra") + FileName);    

		// TestData = new Excel(System.getProperty("user.dir") +
		// prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") +
		// FileName);
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
				AppURL = prop.getProperty("AppURL_MI_PDL_pavitra");
				UserName = prop.getProperty("UserName_MI_PDL_pavitra");
				Password = prop.getProperty("Password_MI_PDL_pavitra");
				StoreId = prop.getProperty("StoreID_MI_PDL_pavitra");

				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				// System.out.println(SSN);
				//test = reports.startTest(Header + "S.NO:15:_Partialpayment_CCK_same Refnumbers");
				test = reports.startTest(Header+"_S.No:81"+"_"+PayFrequency+"_"+CollateralType,"Advance =>Partial Pay  with 2 tender types as CCK with same numbers =>Transaction should not be processed)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanMI.NewLoanMI(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				LoanPartialPayment_Same.LoanPartialPayment_Same(SSN, FileName);
				//HistoryValidation_PDL.HistoryValidation_PDL(SSN, FileName);

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
		Runtime.getRuntime().exec("taskkill /T /F /IM iexplore.exe");
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

					new FileReader("C:/AA_Batch/AA_PDL1/src/test/java/pack/Config.properties"));

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
		Runtime.getRuntime().exec("taskkill /T /F /IM iexplore.exe");
		
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
