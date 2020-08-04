
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

public class AA_KY_PDL extends AA_PDL{
	//@Test(priority=1,groups = "Pavitra_KY_PDL") 
	public void BorrRegistration_NewLoan() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_01"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan");
			
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);				
				NewLoan.NewLoan(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}		
		}
	}

	//@Test(priority=2,groups = "Pavitra_KY_PDL") //issue
	public void BorrowerNewLoan_Rule() throws Exception 
	{
		String FileName= "AA_BorrowerRegistration_NewLoanRule_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_02"+"_"+PayFrequency+"_"+CollateralType,"Login-->customer having already having Open Loan-->perform New Loan(depends on rule )");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				NewLoanRule.NewLoanRule(SSN, FileName);
				//HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}

	//@Test(priority=3,groups = "Pavitra_KY_PDL") 
	public void NewLoan_Biweekly_Duedate() throws Exception 
	{
		String FileName= "AA_NewLoan_BiweeklyDue_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_05"+"_"+PayFrequency+"_"+CollateralType, "Borrower->PayFrequency(Bi Weekly)->New Loan->Check Due Date for Min Term");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);	
				NewLoan.NewLoan(SSN, FileName);
				Biweekly_duedate.Biweekly_duedate(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

//@Test(priority=4,groups = "Pavitra_KY_PDL") 

	public void NewLoan_Monthly_Duedate() throws Exception
	{
		String FileName= "AA_NewLoan_MonthlyDue_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_03"+"_"+PayFrequency+"_"+CollateralType,"Borrower -> PayFrequency (Monthly) -> New Loan ->Check Due Date for Min Term");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				Monthly_duedate.Monthly_duedate(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority=5,groups = "Pavitra_KY_PDL")  

	public void NewLoan_SemiMonthly_Duedate() throws Exception
	{
		String FileName= "AA_NewLoan_SemiDue_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_06"+"_"+PayFrequency+"_"+CollateralType, "Borrower->PayFrequency(SemiMonthly)->New Loan->Check Due Datefor Min Term");

				SetDate.SetDate(SSN, FileName, "02","08","2020");
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				semimonthly_duedate.semimonthly_duedate(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}

	}

	@Test(priority=6,groups = "Pavitra_KY_PDL1")//due date issue 
	public void NewLoan_Weekly_Duedate() throws Exception 
	{
		String FileName= "AA_NewLoan_WeeklyDue_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_04"+"_"+PayFrequency+"_"+CollateralType, "Borrower->PayFrequency(Weekly)->New Loan->Check Due Date for Min Term");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);			
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				Weekly_duedate.Weekly_duedate(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}

	}

	//@Test(priority=7,groups = "Pavitra_KY_PDL") 

	public void VerifyLoanAmount() throws Exception 
	{
		String FileName= "AA_BorrowerRegistration_VerifyLoanAmount_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.NO:07:"+"_"+PayFrequency+"_"+CollateralType,"Login_Home screen_Borrower_Registration_verify whether loan amount is based on CustomerIncome or not");



				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan_CustomerIncome.NewLoan_CustomerIncome(SSN, FileName);

			}
		}

	}

	//@Test(priority=8,groups = "Pavitra_KY_PDL") 

	public void Newloan_MultipullDisb() throws Exception
	{
		String FileName= "AA_Newloan_MultipullDisb_Types_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.NO:08:"+"_"+PayFrequency+"_"+CollateralType,"Newloan with multipledisbursements like check& cash--> check whether loan is processed smoothly.");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}

	//@Test(priority=9,groups = "Pavitra_KY_PDL") 

	public void NewLoan_Void() throws Exception {


		String FileName= "AA_VoidLoan_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
                
				test = reports.startTest(Header+"_S.NO:09:"+"_"+PayFrequency+"_"+CollateralType,"Loan– same day Void");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				Void.Void(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority=10,groups = "Pavitra_KY_PDL") 

	public void NewLoan_VoidEncryptionKey() throws Exception 
	{
		String FileName= "AA_NewLoan_VoidEncryptionKey_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:10"+"_"+PayFrequency+"_"+CollateralType,"Loan_void on next day with encryption key");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName); 
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,3);
				EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}


	}

	//@Test(priority=11,groups = "Pavitra_KY_PDL") 

	public void Rescind() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_RescindLoan_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
			
				test = reports.startTest(Header+"_S.No:11"+"_"+PayFrequency+"_"+CollateralType, "Loan– same day Rescind");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				Rescind.Rescind(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}


	}

	//@Test(priority=12,groups = "Pavitra_KY_PDL") 

	public void Rescind_AgeStore() throws Exception {

		String FileName= "AA_RescindLoan_Agestore_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:12"+"_"+PayFrequency+"_"+CollateralType, "Loan– Age the store to Rescind days – Rescind");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,1);
				Rescind.Rescind(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}



	//@Test(priority=13,groups = "Pavitra_KY_PDL") 

	public void NewLoanMultiDisb_Void() throws Exception {

		
		String FileName= "AA_NewLoanMultiDIsb_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				

				test = reports.startTest(Header+"_S.No:15"+"_"+PayFrequency+"_"+CollateralType, "loan with multiple disbursement (cash& check)->void with original check");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);					
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
				Void.Void(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}

	@Test(priority=14,groups = "Pavitra_KY_PDL1") //issue

	public void NewLoanMultipledisbursement_AgestoreVoid() throws Exception {

		
		String FileName= "AA_NewLoanMultiDIsb_AgeStore_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;

				test = reports.startTest(Header+"_S.No:16"+"_"+PayFrequency+"_"+CollateralType,"loan with multiple disbursement (cash& check)->void with cash(Next day with encryption)");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,1);
				EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority=15,groups = "Pavitra_KY_PDL") 

	public void NewLoan_AgeStore_BuyBack() throws Exception {

		String FileName= "AA_NewLoan_Agestore_BuybackLoan_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				
				test = reports.startTest(Header+"_S.No:18"+"_"+PayFrequency+"_"+CollateralType,"Loan--Age the store--Perform the Buyback");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,-4);
				Buyback.Buyback(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}

	//@Test(priority=16,groups = "Pavitra_KY_PDL") 

	public void BuyBack_Void() throws Exception {

		String FileName= "AA_BuybackLoan_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				
				test = reports.startTest(Header+"_S.No:19"+"_"+PayFrequency+"_"+CollateralType,"Loan--Age the store--Perform the Buyback  ->void on same day");
			
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,0);
				Buyback.Buyback(SSN, FileName); 
				BuybackVoid.BuybackVoid(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}

	//@Test(priority=17,groups = "Pavitra_KY_PDL") 
	public void Byback_agestore_void() throws Exception
	{
		String FileName= "AA_Byback_Agestore_void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:20"+"_"+PayFrequency+"_"+CollateralType,"Loan--Age the store--Perform the Buyback--Void on next day ");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,0);
				Buyback.Buyback(SSN, FileName);
				AgeStore_Buyback_encryptionKeyVoid.AgeStore_Buyback_encryptionKeyVoid(SSN, FileName, 1);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}

	//@Test(priority=18,groups = "Pavitra_KY_PDL") 
	public void VerifyBuyBack_TotalDue() throws Exception
	{
		String FileName= "AA_VerifyBuyBack_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:21"+"_"+PayFrequency+"_"+CollateralType,"loan->verify buyback should accept only total due");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,-1);
				Buyback.Buyback(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}



	//@Test(priority=19,groups = "Pavitra_KY_PDL2") 
	public void Loan_AgeStore_ProcessDeposit_Nacha_DepositShouldPost() throws Exception {

		String FileName= "AA_Loan_AgeStore_ProcessDeposit_Nacha_DepositShouldPost_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:46"+"_"+PayFrequency+"_"+CollateralType,"Loan -- Age the store up to  due date --> Process the deposit  -->  Process GB Nacha File  from admin Interface --> Deposit should post )");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);		
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACH_Deposit_Status.ACH_Deposit_Status(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority=20,groups = "Pavitra_KY_PDL") 

	public void LoanWithCheck_DepConvertToACH_ACHDep_ProcessEOD() throws Exception {

		String FileName= "AA_LoanWithCheck_DepConvertToACH_ACHDep_ProcessEOD_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
			
				test = reports.startTest(Header+"_S.No:47"+"_"+PayFrequency+"_"+CollateralType,"Loan(Check) --> Dep (Convert ACH) --> Deposit --> Process EOD)");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				ACH_History_Status.ACH_History_Status(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority=21,groups = "Pavitra_KY_PDL") 
	public void LoanWithCheck_ConvertACH_Deposit_ACHClear() throws Exception {

		String FileName= "AA_Newloan_Dep (Convert ACH)_Deposit_ACH Clear_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
			
				test = reports.startTest(Header+"_S.No:48"+"_"+PayFrequency+"_"+CollateralType,"Loan(Check)-->Dep(Convert ACH)-->Deposit -->ACH Clear)");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName,7 );
				ACH_Clear_History.ACH_Clear_History(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority=22,groups = "Pavitra_KY_PDL")

	public void LoanwithCheck__DepConvertACH__Deposit__ACHReturn() throws Exception {

		String FileName= "AA_LoanwithCheck__DepConvertACH__Deposit__ACHReturn_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
			
				test = reports.startTest(Header+"_S.No:49"+"_"+PayFrequency+"_"+CollateralType,"Loan(Check) --> Dep (Convert ACH) --> Deposit --> ACH Return)");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);				
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHReturn_History.ACHReturn_History(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority=23,groups = "Pavitra_KY_PDL") 
	public void Loan_Full_PrePayment() throws Exception {

		String FileName= "AA_NewLoan_FullPrepayment_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:50"+"_"+PayFrequency+"_"+CollateralType,"Loan --> Age the store  upto duedate --> perform deposit--> age the store --> perform the Prepayment)");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);				
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				ACH_Prepayment_History.ACH_Prepayment_History(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority=24,groups = "Pavitra_KY_PDL") 

	public void Newloan_VoidPrePayment() throws Exception {

		String FileName= "AA_NewLoan_FullPrepayment_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:51"+"_"+PayFrequency+"_"+CollateralType,"Loan --> Age the store  upto duedate --> perform deposit-->age the store -->perform the Prepayment--> Void)");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 0);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				Void_PrePayment.Void_PrePayment(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test(priority=25,groups = "Pavitra_KY_PDL") 
	public void ConvertCheckToACHNacha_ACHDepositProcess_ACHReturn() throws Exception {

		String FileName= "AA_ConvertCheckToACHNacha_DepositProcess_ReturnPosting_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:54"+"_"+PayFrequency+"_"+CollateralType,"Loan (Check) -->  (Convert to ACH) Ach Deposit process --> Ach Return Posting)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority=26,groups = "Pavitra_KY_PDL") 

	public void Loan_Deposit_PrePayment_Return() throws Exception {

		String FileName= "AA_DepositProcess_PrePayment_ReturnPosting_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
			
				test = reports.startTest(Header+"_S.No:55"+"_"+PayFrequency+"_"+CollateralType,"Loan  --> Age the store  upto duedate --> perform deposit --> age perform the Prepayment--> age the store --> return)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName); 
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);


			}
		}

	}

	//@Test(priority=27,groups = "Pavitra_KY_PDL") 
	public void LoanwithCheck_Deposit_ReturnwithoutR01R09_FutureDepositNotposted() throws Exception {

		String FileName= "AA_NewLoan(check)_Deposit_ReturnPostingwithout(R01R09)_FetureDepositnotPost_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:56"+"_"+PayFrequency+"_"+CollateralType,"loan with check->deposit->return with return reason id other than R01,R09 then should not allow for future deposit)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACHReturnPostingWithoutR01R09.ACHReturnPostingWithoutR01R09(SSN, FileName);
				FutureDeposit_RecoredSataus.FutureDeposit_RecoredSataus(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}


	//@Test(priority=28,groups = "Pavitra_KY_PDL") 
	public void LoanwithCheck_ConverttoACH_ACHDepproc_ProcClear() throws Exception {

		String FileName= "AA_LoanwithCheck_ConverttoACH_ACHDepproc_ProcClear_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:59"+"_"+PayFrequency+"_"+CollateralType,"Loan (Check) -->(Convert to ACH) Ach Deposit process --> Process Clear)");

				/*SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);*/
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName,7 );
				ACHClear_History.ACHClear_History(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//(priority=29,groups = "Pavitra_KY_PDL") 

	public void Loan_Agestoreduedate_performdepositPrepayment_agestore_ProcessClear() throws Exception {

		String FileName= "AA_Loan_Agestoreduedate_performdepositPrepayment_agestore_ProcessClear_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:60"+"_"+PayFrequency+"_"+CollateralType,"Loan  --> Age the store  upto duedate --> perform deposit --> age perform the Prepayment--> age the store -->  Process Clear)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName,7 );
				ACHClear_History.ACHClear_History(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//(priority=30,groups = "Pavitra_KY_PDL") 

	public void NewLoan_Perform_EPP() throws Exception {

		String FileName= "AA_NewLoan_AgeStore_Perform_EPP_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:61"+"_"+PayFrequency+"_"+CollateralType,"Loan--Age the store --perform EPP)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				Perform_EPP.Perform_EPP(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test(priority=31,groups = "Pavitra_KY_PDL")  // Need to update the EOD Process for checking the records in EOD Processing 
	public void EPP_MissRPPPayment_EOD_Checkbox() throws Exception {

		String FileName= "AA_RPP_MissRPPPayment_EOD_Checkbox_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:62"+"_"+PayFrequency+"_"+CollateralType,"Loan-EPP- Miss the EPP Payment --> Age the store --> Perform EOD --> Customer record should display in EOD process with  Check box selected)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				Perform_EPP.Perform_EPP(SSN, FileName);
				AgeStore1stinst.AgeStore1stinst(SSN, FileName, 3);	           
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}


	//@Test(priority=32,groups = "Pavitra_KY_PDL") // Need to update the EOD Process for checking the records in EOD Processing 

	public void EPP_MissRPPPayment_EOD_Forcefully() throws Exception {

		String FileName= "AA_EPP_MissRPPPayment_EOD_Forcefully_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:63"+"_"+PayFrequency+"_"+CollateralType,"Loan-EPP- Miss the EPP Payment --> Age the store to 14 days from EPP due date --> Perform EOD --> Customer record should display in EOD process and should comes out forcefully  from EPP.)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				Perform_EPP.Perform_EPP(SSN, FileName);
				AgeStore2ndinst.AgeStore2ndinst(SSN, FileName, -14);							
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}


	//@Test(priority=33,groups = "Pavitra_KY_PDL") 

	public void Loan_Deposit_FullPrePayment_Clear_Refund() throws Exception {

		String FileName= "AA_Loan_Deposit_FullPrePayment_Clear_Refund_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:65"+"_"+PayFrequency+"_"+CollateralType,"Loan->Deposit->Pre Payment full -> Clear->Refund)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACH_PrePayment.ACH_PrePayment(SSN, FileName);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName,27 );
				ACH_ReFund.ACH_ReFund(SSN, FileName);
				ACH_ReFund_History.ACH_ReFund_History(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}


	}

	//@Test(priority=34,groups = "Pavitra_KY_PDL") 

	public void LoanWithCheck_ConvertAch_AchPrePayment_AchClr_Refund() throws Exception {

		String FileName= "AA_LoanWithCheck_ConvertAch_AchPrePayment_AchClr_Refund_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:66"+"_"+PayFrequency+"_"+CollateralType,"Loan With Check --> Deposit (Convert to ACH) --> ACH Pre Payment Partially -> ACH CLR -> Refund)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACH_PartialPrePayment.ACH_PartialPrePayment(SSN, FileName);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName,27 );
				ACH_ReFund.ACH_ReFund(SSN, FileName);
				ACH_History_Status.ACH_History_Status(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority=35,groups = "Pavitra_KY_PDL") 

	public void NewLoan_ReturnPosting_60days_Writeoff() throws Exception {

		String FileName= "AA_NewLoan_ReturnPosting_60days_Writeoff_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:67"+"_"+PayFrequency+"_"+CollateralType,"Loan->Return Posting --> WO Check whether Write off is done 60days from return date.)");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);					     
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				writeoff_Process.writeoff_Process(SSN, FileName, 60);
				LoanStatus.LoanStatus(SSN, FileName);	
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}


	}

	//@Test(priority=36,groups = "Pavitra_KY_PDL") 

	public void Loan_ReturnPosting_15PerofTotalDue__CheckWriteOff120daystoretdate() throws Exception {

		String FileName= "AA_Loan_ReturnPosting_15PerofTotalDue__CheckWriteOff120daystoretdate_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:68"+"_"+PayFrequency+"_"+CollateralType,"Loan->Return Posting --> NSF Payment 15% of Total Due --> WO Check whether Write off is done 120 days from return date.)");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPayment.ACHPayment(SSN, FileName, 0.15);
				WriteOff.WriteOff(SSN, FileName, 121);
				WriteOff_History.WriteOff_History(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}


	}

	//@Test(priority=37,groups = "Pavitra_KY_PDL") 
	public void Loan_ReturnPosting_NSF15_Void_WO60days_Returndate() throws Exception {

		String FileName= "AA_Loan_ReturnPosting_NSF15_Void_WO60days_Returndate_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:69"+"_"+PayFrequency+"_"+CollateralType,"Loan->Return Posting --> NSF Payment 15% of Total Due --> Void --> WO Check whether Write off is done 60 days from return date.)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPayment.ACHPayment(SSN, FileName, 0.15);
				NSF_Void.NSF_Void(SSN, FileName);
				WriteOff.WriteOff(SSN, FileName, 60);
				WriteOff_History.WriteOff_History(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}


	}

	//@Test(priority=38,groups = "Pavitra_KY_PDL") 

	public void Loan_ReturnPosting_30PerofTotalDue__CheckWriteOff180daystoretdate() throws Exception {

		String FileName= "AA_Loan_ReturnPosting_30PerofTotalDue__CheckWriteOff180daystoretdate_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:70"+"_"+PayFrequency+"_"+CollateralType,"Loan->Return Posting --> NSF Payment 30% of Total Due --> WO Check whether Write off is done 180 days from return date.)");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPayment.ACHPayment(SSN, FileName, 0.3);
				WriteOff.WriteOff(SSN, FileName, 181);
				WriteOff_History.WriteOff_History(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);


			}
		}

	}

	//@Test (priority=39,groups = "Pavitra_KY_PDL")

	public void NewLoan_RPP_AgeInstwise_PPPayment() throws Exception {

		String FileName= "AA_NewLoan_Instwise_PerformRPP_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:71"+"_"+PayFrequency+"_"+CollateralType,"Loan-EPP- age the store installment wise -- perform Paymentplan Payment)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				RPPPerform.RPPPerform(SSN, FileName);
				AgeStore1stinst.AgeStore1stinst(SSN, FileName, 0);
				RPPPayment.RPPPayment(SSN, FileName);	           
				AgeStore2ndinst.AgeStore2ndinst(SSN, FileName, 0);
				RPPPayment.RPPPayment(SSN, FileName);
				AgeStore3rdinst.AgeStore3rdinst(SSN, FileName, 0);
				RPPPayment.RPPPayment(SSN, FileName);
				
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}


	}



	@Test (priority=40,groups = "Pavitra_KY_PDL1")

	public void Loan_Deposit_PrePaymentfull_Return_RefundnotDisplay() throws Exception {

		String FileName= "AA_Loan_Deposit_PrePaymentfull_Return_RefundnotDisplay_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;

				test = reports.startTest(Header+"_S.No:73"+"_"+PayFrequency+"_"+CollateralType,"Loan->Deposit->Pre Payment full -> Return-> Refund not display)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);				
				Login.Login(UserName,Password,StoreId);	
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);	
				
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
				Prepaymentfull.Prepaymentfull(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Refund_Status.Refund_Status(SSN, FileName);	
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}

	}




	//@Test (priority=41,groups = "Pavitra_KY_PDL")//issue

	public void NewLoanwithcheck_VerifycheckAmountfield() throws Exception {

		String FileName = "AA_NewLoanwithCheck_VerifyCheckAmountfield_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				
				test = reports.startTest(Header + "_S.No:74" + "_" + PayFrequency + "_" + CollateralType,"New Loan Check disbursement_Validate whether check amount field is disabled .");

			    SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoanwithcheck_VerifyCheckAmountField.NewLoanwithcheck_VerifyCheckAmountField(SSN, FileName);
				//HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test (priority=42,groups = "Pavitra_KY_PDL")

	public void NewLoan_Buyback_Verify() throws Exception {

		String FileName = "AA_NewLoan_Verify_Buyback_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header+"_S.No:91"+"_"+PayFrequency+"_"+CollateralType,"Advance => Buyback => Check whether screen is been freezed with message as Transaction under procesing.This is been fixed to avoid duplicate for buyback transaction.)");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				Buyback.Buyback(SSN, FileName);
				Buyback_Verifacation.Buyback_Verifacation(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}


	//@Test(priority =43, groups = "Pavitra_KY_PDL")

	public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed() throws Exception {

		String FileName = "AA_Advance_Buyback2tendertypeAs_DiffNum_TranssionShouldBeprocessed.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:92" + "_" + PayFrequency + "_" + CollateralType,"Advance_Buyback with 2 tender types as MO with different numbers_Transaction should be processed");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_MO_With2tendertypes_Withdiffnumbers.BuyBack_MO_With2tendertypes_Withdiffnumbers(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test(priority = 44, groups = "Pavitra_KY_PDL")

	public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender()
			throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:93" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_Buyback with 2 tender types as MO with different numbers_Transaction should be processed_Void Buyback with Original tender type.Validate screen if its displaying tender details properly");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_MO_With2tendertypes_Withdiffnumbers.BuyBack_MO_With2tendertypes_Withdiffnumbers(SSN, FileName);
				BuybackVoidwith_Orginaltender.BuybackVoidwith_Orginaltender(SSN, FileName);
				Check_TendertypesDetails_Validation.Check_TendertypesDetails_Validation(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test(priority = 45, groups = "Pavitra_KY_PDL")

	public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidwithCash()
			throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidwithCash.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);


		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:94" + "_" + PayFrequency + "_" + CollateralType,
						"Advance =>Buyback with 2 tender types as MO with different numbers =>Transaction should be processed ->Void Buyback with cash");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_MO_With2tendertypes_Withdiffnumbers.BuyBack_MO_With2tendertypes_Withdiffnumbers(SSN, FileName);
				BuybackVoidwith_Cash.BuybackVoidwith_Cash(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test(priority = 46, groups = "Pavitra_KY_PDL")//issue encryption

	public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible()
			throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:95" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_Buyback with 2 tender types as MO with different numbers_Transaction should be processed_Void Buyback next processing day_Only cash should be available.");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_MO_With2tendertypes_Withdiffnumbers.BuyBack_MO_With2tendertypes_Withdiffnumbers(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 6);
				EncryptionKey_BuybackVoidWith_Cash.EncryptionKey_BuybackVoidWith_Cash(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test(priority = 47, groups = "Pavitra_KY_PDL")

	public void NewLoan_AgeStore_BuyBack_2Tendertype_Mo_SameNum_TranssionShouldnotbeprocessed() throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_Mo_SameNum_TranssionShouldnotbeprocessed.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:96" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_Buyback with 2 tender types as MO with same numbers_Transaction should not be processed");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_MO_With2tendertypes_WithSamenumbers.BuyBack_MO_With2tendertypes_WithSamenumbers(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}



	//@Test(priority = 48, groups = "Pavitra_KY_PDL")

	public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed() throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:97" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_Buyback with 2 tender types as CCK with different numbers_Transaction should be processed");
				
				/*SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_CCK_With2tendertypes_Withdiffnumbers.BuyBack_CCK_With2tendertypes_Withdiffnumbers(SSN,FileName);*/
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}

	//@Test(priority =49, groups = "Pavitra_KY_PDL")

	public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender()
			throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:98" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_Buyback with 2 tender types as CCK with different numbers_Transaction should be processed_Void Buyback with Original tender type.Validate screen if its displaying tender details properly");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_CCK_With2tendertypes_Withdiffnumbers.BuyBack_CCK_With2tendertypes_Withdiffnumbers(SSN,FileName);
				BuybackVoidwith_Orginaltender.BuybackVoidwith_Orginaltender(SSN, FileName);
				Check_TendertypesDetails_Validation.Check_TendertypesDetails_Validation(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}

	//@Test(priority =50, groups = "Pavitra_KY_PDL")

	public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithCash()
			throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithCash.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:99" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_Buyback with 2 tender types as CCK with different numbers_Transaction should be processed_Void Buyback with cash");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_CCK_With2tendertypes_Withdiffnumbers.BuyBack_CCK_With2tendertypes_Withdiffnumbers(SSN,FileName);
				BuybackVoidwith_Cash.BuybackVoidwith_Cash(SSN, FileName);
				Check_TendertypesDetails_Validation.Check_TendertypesDetails_Validation(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}
	}

	//@Test(priority =51, groups = "Pavitra_KY_PDL")//Encry issue

	public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible()
			throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:100" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_Buyback with 2 tender types as CCk with different numbers_Transaction should be processed_Void Buyback next processing day_Only cash should be available.");
				
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_CCK_With2tendertypes_Withdiffnumbers.BuyBack_CCK_With2tendertypes_Withdiffnumbers(SSN,FileName);
				AgeStore.AgeStore(SSN, FileName, 6);
				EncryptionKey_BuybackVoidWith_Cash.EncryptionKey_BuybackVoidWith_Cash(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test(priority =52, groups = "Pavitra_KY_PDL")

	public void NewLoan_AgeStore_BuyBack_2Tendertype_CCK_SameNum_TranssionShouldnotbeprocessed() throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_CCK_SameNum_TranssionShouldnotbeprocessed.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:101" + "_" + PayFrequency + "_" + CollateralType,
						"Advance =>Buyback with 2 tender types as CCK with same numbers =>Transaction should not be processed");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_CCK_With2tendertypes_WithSamenumbers.BuyBack_CCK_With2tendertypes_WithSamenumbers(SSN,FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);


			}
		}
	}

	//@Test(priority =53, groups = "Pavitra_KY_PDL")

	public void NewLoan_AgeStore_BuyBack_2Tendertype_CashTranssionShouldnotbeprocessed() throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_Cash_TranssionShouldnotbeprocessed.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:102" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_Buyback with 2 tender types as Cash_Transaction should not be processed");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack__2tendertypes_With_Cash.BuyBack__2tendertypes_With_Cash(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);


			}
		}
	}

	//@Test(priority =54, groups = "Pavitra_KY_PDL")

	public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_MiddayDeposit_BuyBackVoid() throws Exception {

		String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_MiddayDeposit_BuyBackVoid.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:103" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_Buyback with 2 tender types as MO with different numbers_Transaction should be processed_deassign drawer_Validate they are available for mid day deposit.Process Mid day deposit_Void Buyback Only cash should be displayed.");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 5);
				BuyBack_MO_With2tendertypes_Withdiffnumbers.BuyBack_MO_With2tendertypes_Withdiffnumbers(SSN, FileName);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				MidDayDeposit.MidDayDeposit(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				SafeDeAssign.SafeDeAssign(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				BuybackVoidwith_Cash_CheckTenderType.BuybackVoidwith_Cash_CheckTenderType(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	@Test(priority =55, groups = "Pavitra_KY_PDL1")//issue

	public void NewLoan_EPP_PPAYwith2tenderTyprsCCK_Diffnumbers_VoidPPay() throws Exception {

		String FileName = "AA_NewLoan_EPP_PPAYwith2tenderTyprsCCK_Diffnumbers_VoidPPay.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:104" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_EPP_PPAY with 2 tender types as CCK with different numbers_Transaction should be processed_Void ACHPP with Original tender type.Validate screen if its displaying tender details properly");
				
				/*SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				EPP.EPP(SSN, FileName);*/
				RPPPayment_With2tenderCCK_Diffnumbers.RPPPayment_With2tenderCCK_Diffnumbers(SSN, FileName);
				Voidwith_Orginaltender.Voidwith_Orginaltender(SSN, FileName);
				Check_TendertypesDetails_Validation.Check_TendertypesDetails_Validation(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test(priority =56, groups = "Pavitra_KY_PDL")

	public void RPPPayment_With2tenderCCK_Samenumbers_Trans_ShouldNotProcessed() throws Exception {

		String FileName = "AA_RPPPayment_With2tenderCCK_Samenumbers_Trans_ShouldNotProcessed.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:105" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_EPP_PPAY with 2 tender types as CCK with same numbers_Transaction should not be processed");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				EPP.EPP(SSN, FileName);
				RPPPayment_With2tenderCCK_Samenumbers.RPPPayment_With2tenderCCK_Samenumbers(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test(priority =57, groups = "Pavitra_KY_PDL")//issue

	public void NewLoan_EPP_PPAYwith2tenderTyprsCCK_Diffnumbers__DrawerDeassign_MidDayDeposit_VoidPPay()
			throws Exception {

		String FileName = "AA_NewLoan_EPP_PPAYwith2tenderTyprsCCK_Diffnumbers__DrawerDeassign_MidDayDeposit_VoidPPay.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:106" + "_" + PayFrequency + "_" + CollateralType,"Advance_EPP_PPAY with 2 tender types as CCk with different numbers_Transaction should be processed_deassign drawer_Validate they are available for mid day deposit.Process Mid day deposit_Void ACHPP Only cash should be displayed.");
				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -1);
				EPP.EPP(SSN, FileName);
				RPPPayment_With2tenderCCK_Diffnumbers.RPPPayment_With2tenderCCK_Diffnumbers(SSN, FileName);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				MidDayDeposit.MidDayDeposit(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				SafeDeAssign.SafeDeAssign(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Voidwith_Cash_CheckTenderType.Voidwith_Cash_CheckTenderType(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}
	}

	//@Test (priority=58,groups = "Pavitra_KY_PDL")

	public void Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateMidDayDeposit_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay()
			throws Exception {


		String FileName = "AA_Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateMidDayDeposit_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:107_" + "_" + PayFrequency + "_" + CollateralType,"Advance _ Buyback with 2 tender types as CCk with different numbers _ Transaction should be processed _ deassign drawer _ Validate they are available for mid day deposit.Process Mid day deposit _ Void Buyback Only cash should be displayed");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 4);
				BuyBack_TwoTenderTypesCCK_2DifferentNumbers.BuyBack_TwoTenderTypesCCK_2DifferentNumbers(SSN, FileName,0.5);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				MidDayDeposit.MidDayDeposit(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				SafeDeAssign.SafeDeAssign(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				BuybackVoid.BuybackVoid(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test (priority=59,groups = "Pavitra_KY_PDL")

	public void Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateEOD_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay()
			throws Exception {

		String FileName = "AA_Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateEOD_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:108_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
						"Advance _ Buyback with 2 tender types as CCk with different numbers _ Transaction should be processed _ deassign drawer _ Validate they are available for mid day deposit.Process Mid day deposit _ Void Buyback Only cash should be displayed");

				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 4);
				BuyBack_TwoTenderTypesCCK_2DifferentNumbers.BuyBack_TwoTenderTypesCCK_2DifferentNumbers(SSN, FileName,0.5);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				CHECK_CCMO_Record_EODProcessing.CHECK_CCMO_Record_EODProcessing(SSN, FileName);
				MidDayDeposit.MidDayDeposit(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				SafeDeAssign.SafeDeAssign(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				BuybackVoid.BuybackVoid(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test (priority=60,groups = "Pavitra_KY_PDL")

	public void Advance_deposit_ACHPPwith2tendertypessMOwithdiffnumbers_Transactionprocessed_VoidACHPPwithcash()
			throws Exception {


		String FileName = "AA_Advance_deposit_ACHPPwith2tendertypessMOwithdiffnumbers_Transactionprocessed_VoidACHPPwithcash_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:109" + "_" + PayFrequency + "_" + CollateralType,
						"Advance _deposit _ACHPP with 2 tender types as MO with different numbers _Transaction should be processed _Void ACHPP with cash");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHPP_MO_2tendertypes.ACHPP_MO_2tendertypes_DiffNumbers(SSN, FileName);
				Void_ACHPP_MO_2tendertypes.Void_ACHPP_MO_2tendertypes_Cash(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test (priority=61,groups = "Pavitra_KY_PDL")

	public void Advance_deposit_ACHPPwith2tendertypessMOwithsamenumbers_Transactionnotprocessed() throws Exception {


		String FileName = "AA_Advance_deposit_ACHPPwith2tendertypessMOwithsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";


		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:110" + "_" + PayFrequency + "_" + CollateralType,
						"Advance_deposit _ACHPP with 2 tender types as MO with same numbers _Transaction should not be processed");

				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHPP_MO_2tendertypes.ACHPP_MO_2tendertypes_SameNumbers(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test (priority=62,groups = "Pavitra_KY_PDL")

	public void Advance_deposit_ACHPP2tenderCCKdiffnumbers_Transactionprocessed_VoidACHPPwithOriginaltender_Validatetenderdetails()
			throws Exception {

		String FileName = "AA_Advance_deposit_ACHPP2tenderCCKdiffnumbers_Transactionprocessed_VoidACHPPwithOriginaltender_Validatetenderdetails_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
			
				test = reports.startTest(Header + "_S.No:111" + "_" + PayFrequency + "_" + CollateralType,
						"Advance _ deposit _ ACHPP with 2 tender types as CCK with different numbers _ Transaction should be processed _ Void ACHPP with Original tender type Validate screen if its displaying tender details properly");

				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_DiffNumbers(SSN, FileName);
				Void_ACHPP_CCK_2tendertypes.Void_ACHPP_CCK_2tendertypes_OriginalTender(SSN, FileName);
				Check_TendertypesDetails_Validation.Check_TendertypesDetails_Validation(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test (priority=63,groups = "Pavitra_KY_PDL")

	public void Advance_deposit_ACHPP2tenderCCKsamenumbers_Transactionnotprocessed() throws Exception {

		String FileName = "AA_Advance_deposit_ACHPP2tenderCCKsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
				
				test = reports.startTest(Header + "_S.No:112" + "_" + PayFrequency + "_" + CollateralType,
						"Advance _ deposit _ ACHPP with 2 tender types as CCK with same numbers _ Transaction should not be processed ");

			
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_SameNumbers(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test (priority=64,groups = "Pavitra_KY_PDL")

	public void Advance_deposit_ACHPP2tenderCCKdiffnumbers_Transactionnprocessed_ValidateandprocessMidDayDeposit_VoidwithCashonlyDisplayed()
			throws Exception {

		String FileName = "AA_Advance_deposit_ACHPP2tenderCCKdiffnumbers_Transactionnprocessed_ValidateandprocessMidDayDeposit_VoidwithCashonlyDisplayed_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
			
				test = reports.startTest(Header + "_S.No:113_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
						"Advance _ deposit _ ACHPP with 2 tender types as CCK with different numbers _ Transaction should  be processed_deassign drawer _Validate they are available for mid day deposit_Process Mid day deposit_Void ACHPP Only cash should be displayed ");

				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				AgeStore.AgeStore(SSN, FileName, 2);
				ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_DiffNumbers(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				MidDayDeposit.MidDayDeposit(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				SafeDeAssign.SafeDeAssign(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Void_ACHPP_CCK_2tendertypes.Void_ACHPP_CCK_2tendertypes_Checktender(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}



	//@Test (priority=65,groups = "Pavitra_KY_PDL")

	public void LoanwithACH_Deposit_ReturnwithreasonotherthanR01R09_NoFutureDepositAllow() throws Exception {


		String FileName = "AA_LoanwithACH_Deposit_ReturnwithreasonotherthanR01R09_NoFutureDepositAllow_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
			
				test = reports.startTest(Header + "_S.No:116" + "_" + PayFrequency + "_" + CollateralType,"loan with ACH_deposit_return with return reason id other than R01 and R09 then should not allow for future deposit ");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPostingWithoutR01R09.ACHReturnPostingWithoutR01R09(SSN, FileName);
				ACH_ReDeposit_Status.ACH_ReDeposit_Status(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test (priority=66,groups = "Pavitra_KY_PDL")

	public void Advance_deposit_ACHR_WOR2CCKDiffNumbers_Transactionprocessed_deassigndrawer_MidDayDeposit_VoidWORCashOnly()
			throws Exception {

		String FileName = "AA_Advance_deposit_ACHR_WOR2CCKDiffNumbers_Transactionprocessed_deassigndrawer_MidDayDeposit_VoidWORCashOnly_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
			
				test = reports.startTest(Header + "_S.No:117" + "_" + PayFrequency + "_" + CollateralType,"Advance _deposit _ACHR_WOR with 2 tender types as CCk with different numbers _Transaction should be processed =>deassign drawer _Validate they are available for mid day deposit_Process Mid day deposit Void WOR Only cash should be displayed");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPostingWithoutR01R09.ACHReturnPostingWithoutR01R09(SSN, FileName);
				writeoff_Process.writeoff_Process(SSN, FileName, 60);
				WOR_CCK_2tendertypes.WOR_CCK_2tendertypes_DiffNumbers(SSN, FileName);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				MidDayDeposit.MidDayDeposit(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				SafeDeAssign.SafeDeAssign(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Void_WORecovery.Void_WORecovery_Checktender(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test (priority=67,groups = "Pavitra_KY_PDL")

	public void Advance_EPP_PPAYwith2tendertypesasMOwithdiffnumbers_Transactionprocessed_VoidACHPPCash()
			throws Exception {

		String FileName = "AA_Advance_EPP_PPAYwith2tendertypesasMOwithdiffnumbers_Transactionprocessed_VoidACHPPCash_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;

				test = reports.startTest(Header + "_S.No:118" + "_" + PayFrequency + "_" + CollateralType,"Advance _EPP _PPAY with 2 tender types as MO with different numbers _Transaction should be processed _Void ACHPP with cash");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -3);
				EPP.EPP(SSN, FileName);
				RPPPayment_Tender2MoDiffNumbers.RPPPayment_Tender2MoDiffNumbers_Diffnumbers(SSN, FileName);
				Void_RPPPayment_With2TenderMOwithDiffNumbers.Void_RPPPayment_With2TenderMOwithDiffNumbers_Cash(SSN,FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test (priority=68,groups = "Pavitra_KY_PDL")

	public void Advance_EPP_PPAYwith2tendertypesasMOwithsamenumbers_Transactionnotprocessed() throws Exception {

		String FileName = "AA_Advance_EPP_PPAYwith2tendertypesasMOwithsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;
			
				test = reports.startTest(Header + "_S.No:119" + "_" + PayFrequency + "_" + CollateralType,"Advance _EPP _PPAY with 2 tender types as MO with same numbers _Transaction should not be processed");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -2);
				EPP.EPP(SSN, FileName);
				RPPPayment_Tender2MoDiffNumbers.RPPPayment_Tender2MoDiffNumbers_SameNumbers(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}



	//@Test(priority =69, groups = "Pavitra_KY_PDL")

	public void NewLoan_Deposit_Clear_prepayment_clear_refund() throws Exception {


		String FileName = "AA_NewLoan_Deposit_Clear_prepayment_clear_refund.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
			
				test = reports.startTest(Header + "_S.No:120" + "_",
						"Loan --> Age the store upto duedate --> perform deposit --> age perform the Prepayment--> age the store --> Process Clear => Process refund for excess amount paid with Cash");

				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACH_Prepayment_extraamount.ACH_Prepayment_extraamount(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 1);
				
			EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName,27 );
				ACH_ReFund.ACH_ReFund(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}



	//@Test(priority =70, groups = "Pavitra_KY_PDL")

	public void NewLoan_Deposit_Clear_prepayment_clear_refund_check() throws Exception {

		String FileName = "AA_NewLoan_Deposit_Clear_prepayment_clear_refund_check.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;

				test = reports.startTest(Header + "_S.No:121" + "_",
						"Loan --> Age the store upto duedate --> perform deposit --> age perform the Prepayment--> age the store --> Process Clear => Process refund for excess amount paid with Check");

				
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACH_Prepayment_extraamount.ACH_Prepayment_extraamount(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 1);
				EOD_BatchProcess_DueDate_DFLT.EOD_BatchProcess_DueDate_DFLT(SSN, FileName,27 );
				ACH_Refund_Check.ACH_Refund_Check(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority =71, groups = "Pavitra_KY_PDL")

	public void NewLoan_validate_RPP() throws Exception {

		String FileName = "AA_NewLoan_validate_RPP.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);


				test = reports.startTest(Header + "_S.No:123" + "_" + PayFrequency + "_" + CollateralType, "Loan => validate RPP available after due date.");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 2);
				RPP_check.RPP_check(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);


			}
		}

	}

	//@Test(priority =72, groups = "Pavitra_KY_PDL")

	public void Deposit_ACR_ACHP_2tender_type_MO_transaction_void_with_cash() throws Exception {

		String FileName = "AA_Deposit_ACR_ACHP_2tender_type_transaction_void_with_cash.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				test = reports.startTest(Header + "_S.No:124" + "_" + PayFrequency + "_" + CollateralType,
						"Advance=>deposit =>ACHR=>ACHP with 2 tender types as MO with same numbers =>Transaction should not be processed");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPP_MO_2tendertypes.ACHPP_MO_2tendertypes_DiffNumbers(SSN, FileName);
				Void_ACHPP_MO_2tendertypes.Void_ACHPP_MO_2tendertypes_Cash(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority =73, groups = "Pavitra_KY_PDL")

	public void Deposit_ACR_ACHP_2tender_type_MO_same_transaction() throws Exception {


		String FileName = "AA_Deposit_ACR_ACHP_2tender_type_same_transaction.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);


				test = reports.startTest(Header + "_S.No:125" + "_" + PayFrequency + "_" + CollateralType,
						"Advance =>deposit =>ACHR=>ACHP with 2 tender types as MO with different numbers =>Transaction should be processed ->Void ACHP with cash.");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPP_MO_2tendertypes.ACHPP_MO_2tendertypes_SameNumbers(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}

	//@Test(priority =74, groups = "Pavitra_KY_PDL")

	public void Deposit_ACR_ACHP_2tender_type_cck_transaction_void() throws Exception {

		String FileName = "AA_Deposit_ACR_ACHP_2tender_type_cck_transaction_void.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);


				test = reports.startTest(Header + "_S.No:126" + "_" + PayFrequency + "_" + CollateralType,
						"Advance =>deposit =>ACHR=>ACHP with 2 tender types as CCK with different numbers =>Transaction should be processed ->Void ACHP with Original tender type.Validate screen if its displaying tender details properly");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_DiffNumbers(SSN, FileName);
				Void_ACHPP_CCK_2tendertypes.Void_ACHPP_CCK_2tendertypes_OriginalTender(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}

	}

	//@Test(priority =75, groups = "Pavitra_KY_PDL")

	public void Deposit_ACR_ACHP_2tender_type_cck_same_transaction() throws Exception {

		String FileName = "AA_Deposit_ACR_ACHP_2tender_type_cck_same_transaction.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);


				test = reports.startTest(Header + "_S.No:127" + "_" + PayFrequency + "_" + CollateralType,
						"Advance =>deposit =>ACHR=>ACHP with 2 tender types as MO with different numbers =>Transaction should be processed ->Void ACHP with cash.");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_SameNumbers(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}

	}

	@Test(priority =76, groups = "Pavitra_KY_PDL")

	public void Deposit_ACR_ACHP_2tender_type_cck_transaction_DrawerDeassign_Midday_Void() throws Exception {


		String FileName = "AA_Deposit_ACR_ACHP_2tender_type_cck_transaction_DrawerDeassign_Midday_Void.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				test = reports.startTest(Header + "_S.No:128" + "_" + PayFrequency + "_" + CollateralType,
						"Advance =>deposit =>ACHR=>ACHP with 2 tender types as CCk with different numbers =>Transaction should be processed =>deassign drawer =>Validate they are available for mid day deposit.Process Mid day deposit =>Void ACHP Only cash should be displayed.");


				/*SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_DiffNumbers(SSN, FileName);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				MidDayDeposit.MidDayDeposit(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				SafeDeAssign.SafeDeAssign(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Void_ACHPP_CCK_2tendertypes.Void_ACHPP_CCK_2tendertypes_Checktender(SSN, FileName);*/
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}

	}

	@Test(priority =77, groups = "Pavitra_KY_PDL")

	public void Deposit_ACR_WOR_2tender_type_MO_transaction_Void() throws Exception {

		String FileName = "AA_Deposit_ACR_WOR_2tender_type_MO_transaction_Void.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				test = reports.startTest(Header + "_S.No:129" + "_" + PayFrequency + "_" + CollateralType,
						"Advance =>deposit =>ACHR=>WOR with 2 tender types as MO with different numbers =>Transaction should be processed ->Void WOR with cash.");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				writeoff_Process.writeoff_Process(SSN, FileName, 60);
				WOR_CCK_2tendertypes.WOR_CCK_2tendertypes_DiffNumbers(SSN, FileName);
				Void_ACHPP_CCK_2tendertypes.Void_ACHPP_CCK_2tendertypes_Checktender(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}

	}

	@Test(priority =78, groups = "Pavitra_KY_PDL")

	public void Deposit_ACR_WOR_2tender_type_same_MO_transaction() throws Exception {

		String FileName = "AA_Deposit_ACR_WOR_2tender_type_same_MO_transaction.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

				test = reports.startTest(Header + "_S.No:130" + "_" + PayFrequency + "_" + CollateralType,
						"Advance=>deposit =>ACHR=>WOR with 2 tender types as MO with same numbers =>Transaction should not be processed");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				writeoff_Process.writeoff_Process(SSN, FileName, 60);
				WOR_CCK_2tendertypes.WOR_CCK_2tendertypes_SameNumbers(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}

	}



	@Test(priority =79, groups = "Pavitra_KY_PDL")

	public void Deposit_ACHReturn_WORwithtendertypesCCKwithdefferentnumbers() throws Exception {


		String FileName = "AA_Deposit_ACHReturn_WORwithtendertypesCCKwithdefferentnumbers_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				test = reports.startTest(Header + "_S.No:131" + "_" + PayFrequency + "_" + CollateralType,
						"Advance =>deposit =>ACHR=>WOR with 2 tender types as CCK with different numbers =>Transaction should be processed ->Void WOR with Original tender type.Validate screen if its displaying tender details properly");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				writeoff_Process.writeoff_Process(SSN, FileName, 60);
				WOR_CCK_2tendertypes.WOR_CCK_2tendertypes_DiffNumbers(SSN, FileName);
				VoidwithoriginalTendertype.VoidwithoriginalTendertypeextends(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);
			}
		}

	}

	@Test(priority =80, groups = "Pavitra_KY_PDL")

	public void Deposit_ACHReturn_WORwithtendertypesCCKwithsamenumbers() throws Exception {

		String FileName = "AA_Deposit_ACHReturn_WORwithtendertypesCCKwithsamenumbers_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				
				test = reports.startTest(Header + "_S.No:132" + "_" + PayFrequency + "_" + CollateralType,
						"Advance =>deposit =>ACHR=>WOR with 2 tender types as CCK with same numbers =>Transaction should not be processed");

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				NACHA.NACHA(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				writeoff_Process.writeoff_Process(SSN, FileName, 60);
				WOR_CCK_2tendertypes.WOR_CCK_2tendertypes_SameNumbers(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

			}
		}

	}


	@Test(priority =81, groups = "Pavitra_KY_PDL") // Agestore to 10-29-2019(before starting the transaction) for biweekly first paydayradio button

	public void RegistercustmerwhichdoesnotsatisifyMinterm_verifywhetherpayfrequencydatemovedaccordingtothedate()
			throws Exception {


		String FileName = "AA_Satisyfying_Minterm_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_KY_PDL_path_chenna") + FileName);

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				AppURL = prop.getProperty("AppURL_KY_PDL_chenna");
				UserName = prop.getProperty("UserName_KY_PDL_chenna");
				Password = prop.getProperty("Password_KY_PDL_chenna");
		        StoreId = prop.getProperty("StoreID_KY_PDL_chenna");
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String Header = StateID + "_" + ProductID;

				test = reports.startTest(Header + "_S.No:133_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
						"Register Any Payfrequency customer which does not satisfy Minterm _ verify whether loan due date is moved as payfrequency according to the date selected");


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL1(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DueDate_Check.DueDate_Check(SSN, FileName);
				HistoryVlidation_KYPDL.HistoryVlidation_KYPDL(SSN, FileName);

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
		reports.addSystemInfo("Product", "AA_SC_PDL_Regression");
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
