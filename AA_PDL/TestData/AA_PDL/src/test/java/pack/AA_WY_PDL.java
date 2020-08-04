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

public class AA_WY_PDL extends AA_PDL{

	
//Anji Reddy scenarios
	
	//@Test(priority=0,groups = "chenna_WY_PDL")  


	  public void BorrRegistration_NewLoan() throws Exception 
		{
			String FileName= "AA_BorrRegistration_NewLoan_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.No 01 : BorrowerRegistration_NewLoan_"+Header, "New Loan");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);				
					NewLoan.NewLoan(SSN, FileName);
				}		
			}
		}
		
		
	
	//@Test(priority=1,groups = "chenna_WY_PDL")

		public void BorrowerNewLoan_Rule() throws Exception 
		{
			String FileName= "AA_BorrowerRegistration_NewLoanRule_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:02:BorrowerRegistration_NewLoan_Rule"+Header, "New Loan_Maximum Open Loan");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					NewLoanRule.NewLoanRule(SSN, FileName);
				}
			}
		}

       //@Test(priority=2,groups = "chenna_WY_PDL")

	  	public void NewLoan_Biweekly_Duedate() throws Exception 
		{
			String FileName= "AA_NewLoan_BiweeklyDue_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:03:NewLoan_Biweekly_Duedate_"+Header, "Biweekly_Duedate");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);			
					NewLoan.NewLoan(SSN, FileName);
					Biweekly_duedate.Biweekly_duedate(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");
		}
		 
      // @Test (priority=3,groups = "chenna_WY_PDL")

	  	public void NewLoan_Monthly_Duedate() throws Exception
	   {
			String FileName= "AA_NewLoan_MonthlyDue_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					// System.out.println(Password);
					//StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(" S.NO:04:AA_NewLoan_MonthlyDue_Txn_Testdata"+Header, "AA_NewLoan_MonthlyDue_Txn_Testdata");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan_WY.NewLoan_WY(SSN, FileName);
					Monthly_duedate.Monthly_duedate(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");
		}


          //@Test (priority=4,groups = "chenna_WY_PDL") // Semi monthly has issue with loandate and duedate, so Not executing scenario.scenario , Not Ran in Staging

		public void NewLoan_SemiMonthly_Duedate() throws Exception
	       {
			String FileName= "AA_NewLoan_SemiDue_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:05:NewLoan_SemiMonthly_Duedate_"+Header, "SemiMonthly_Duedate");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					semimonthly_duedate.semimonthly_duedate(SSN, FileName);
					//WebDriverWait wait = new WebDriverWait(driver, 10);
					//wait(100);
					// RegistrationPage.RegistrationPage(SSN);
				}
			}
			//Login.Login("CSR353","1234","353");
		}
	 
          //@Test(priority=5,groups = "chenna_WY_PDL")

		public void NewLoan_Weekly_Duedate() throws Exception 
		{
			String FileName= "AA_NewLoan_WeeklyDue_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:06:NewLoan_"+Header, "Weekly_Duedate");
					


					Login.Login(UserName,Password,StoreId);			
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					Weekly_duedate.Weekly_duedate(SSN, FileName);

	              }
			}

		}

        //@Test(priority=6,groups = "chenna_WY_PDL")

		public void VerifyLoanAmount() throws Exception 
		{
			String FileName= "AA_BorrowerRegistration_VerifyLoanAmount_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);	
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					//StoreId = prop.getProperty("StoreID_TN_PDL_anji");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"_S.NO:07:"+"_"+PayFrequency+"_"+CollateralType,"Login_Home screen_Borrower_Registration_verify whether loan amount is based on Customer Income or not");
					
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan_CustomerIncome.NewLoan_CustomerIncome(SSN, FileName);

				}
			}

		}

             //@Test(priority=7,groups = "chenna_WY_PDL")

		public void Newloan_MultipullDisb() throws Exception
		{
			String FileName= "AA_Newloan_MultipullDisb_Types.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 	
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:08:AA_Newloan_MultipullDisb_Type"+Header, "AEA_Newloan_MultipullDisb_Type");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
				}
			}
		}

       // @Test(priority=8,groups = "chenna_WY_PDL")

		public void NewLoan_Void() throws Exception {

		
			String FileName= "AA_VoidLoan_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";	
			System.out.println(lastrow);
			
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;

					
					test = reports.startTest(Header+"_S.NO:11"+Header, "Loan– same day Void");
									
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					Void.Void(SSN, FileName);
				
				}
			}
			
		}


         // @Test(priority=9,groups = "chenna_WY_PDL")

		public void NewLoan_VoidEncryptionKey() throws Exception 
		{
			String FileName= "AA_NewLoan_VoidEncryptionKey_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
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
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					// System.out.println(Password);
					//StoreId = prop.getProperty("StoreID_TN_PDL_anji");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"_S.No:12"+"_"+PayFrequency+"_"+CollateralType,"Loan_void on next day with encryption key");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName); 
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,3);
					EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");

		}

     // @Test (priority=10,groups = "chenna_WY_PDL") 

		public void Rescind() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_RescindLoan_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				
				if(RunFlag.equals("Y"))
				{	

					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					
					test = reports.startTest(Header+"_S.No:16"+"_"+PayFrequency+"_"+CollateralType,"Loan– same day Rescind");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					Rescind.Rescind(SSN, FileName);
					
				}
			}


		}

       // @Test(priority=11,groups = "chenna_WY_PDL")

		public void Rescind_AgeStore() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_RescindLoan_Agestore_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
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
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest(Header+"_S.No:17"+"_"+PayFrequency+"_"+CollateralType,"Loan– Age the store to Rescind days – Rescind");
					

					
					Login.Login(UserName,Password,StoreId);
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,1);
					Rescind.Rescind(SSN, FileName);


				}
			}

		}

         //@Test(priority=12,groups = "chenna_WY_PDL")

		public void Partialpayment_void() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_Partialpayment_void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
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
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					//StoreId = prop.getProperty("StoreID_TN_PDL_anji");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"S.NO:13:_Partialpayment_void"+"_"+PayFrequency+"_"+CollateralType,"Loan_Age the store up to some days before due date_Partial Payment_Void");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-4);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName); 
					Partialpayment_Void.Partialpayment_Void(SSN, FileName);
					
				}
			}
			

		}

		//@Test(priority=13,groups = "chenna_WY_PDL")

		public void Partialpayment_agestorevoid() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_Partialpayment_Agestorevoid_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{	

					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					//StoreId = prop.getProperty("StoreID_TN_PDL_anji");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"S.NO:14:_Partialpayment_Agestorevoid"+"_"+PayFrequency+"_"+CollateralType,"Loan_Age the store up to some days before due date_Partial Payment_age the store up to 1 day_Void with encryption");
					
					
						
			 		Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);			
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-4);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-1);
					PartialPaymentVoidEncryptionKey.PartialPaymentVoidEncryptionKey(SSN, FileName);

				}
			}

		}
		
		
            //@Test(priority=14,groups = "chenna_WY_PDL")

		public void NewLoanMultiDisb_Void() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_NewLoanMultiDIsb_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 	
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					
					String Header = StateID + "_" + ProductID;
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					
					
					test = reports.startTest(Header + "_S.No:13" + "_" + PayFrequency + "_" + CollateralType,"loan with multiple disbursement (cash& check)->void with original check");
					
					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
					Void.Void(SSN, FileName);
				}
			}
		}

       //  @Test(priority=15,groups = "chenna_WY_PDL")

		public void NewLoanMultipledisbursement_AgestoreVoid() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_NewLoanMultiDIsb_AgeStore_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
			
				if(RunFlag.equals("Y"))
				{	
					
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					// System.out.println(Password);
					//StoreId = prop.getProperty("StoreID_TN_PDL_anji");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
				
					test = reports.startTest(Header+"_S.No:14"+"_"+PayFrequency+"_"+CollateralType,"loan with multiple disbursement (cash& check)_void with cash(Next day with encryption)");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,1);
					EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");

		}
		
		 // @Test(priority=16,groups = "chenna_WY_PDL")
		  
		public void Newloan_DisbACH_void() throws Exception
		 {

				// Start test. Mention test script name
				String FileName= "AA_Newloan_disbACH_void.xls";
				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
				int lastrow=TestData.getLastRow("NewLoan");
				String sheetName="NewLoan";
				
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
						AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
						UserName = prop.getProperty("UserName_WY_PDL_chenna");
						Password = prop.getProperty("Password_WY_PDL_chenna");
						StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
						// System.out.println(Password);
						//StoreId = prop.getProperty("StoreID_TN_PDL_anji");
						String ProductID = TestData.getCellData(sheetName,"ProductID",row);
						String StateID = TestData.getCellData(sheetName,"StateID",row);
						String SSN = TestData.getCellData(sheetName,"SSN",row);	
						String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
						String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
						String Header = StateID+ "_" + ProductID;
						
						
						//System.out.println(SSN);
						//test = reports.startTest("S.NO:17:AA_Newloan_disbACH_void_"+Header, "AA_Newloan_disbACH_void");
						test = reports.startTest(Header+"_S.No:15"+"_"+PayFrequency+"_"+CollateralType,"loan with  disbursement (ACH)->void with original check on same day");
						//Login.Login(UserName,Password,StoreId);
						// RegistrationPage.RegistrationPage(SSN, FileName);
						
						Login.Login(UserName,Password,StoreId);				
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);			
						NewLoan.NewLoan(SSN, FileName);
						Void.Void(SSN, FileName);
						
					}
				}
				//Login.Login("CSR353","1234","353");

			}




     //@Test(priority=17,groups = "chenna_WY_PDL") 
		
		public void NewLoan_AgeStore_BuyBack() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_NewLoan_Agestore_BuybackLoan_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 	
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:18:AEA_NewLoan_Agestore_BuybackLoan_Txn"+Header, "AEA_NewLoan_Agestore_BuybackLoan_Txn");
					
					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-4);
					Buyback_Cash.Buyback_Cash(SSN, FileName);
				}
			}
		}

   //@Test(priority=18,groups = "chenna_WY_PDL") 

		public void BuyBack_Void() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_BuybackLoan_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 	
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);			
				if(RunFlag.equals("Y"))
				{	
					
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:19:AA_BuybackLoan_"+Header, "Void_Txn");
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,0);
					Buyback_Cash.Buyback_Cash(SSN, FileName); 
					BuybackVoid.BuybackVoid(SSN, FileName);
				}
			}
		}


         // @Test (priority=19,groups = "chenna_WY_PDL")


		public void Byback_agestore_void() throws Exception
		{
			String FileName= "AA_Byback_Agestore_void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					//StoreId = prop.getProperty("StoreID_TN_PDL_anji");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"S.NO:20:_AA_Byback_Agestore_void"+"_"+PayFrequency+"_"+CollateralType,"Loan_Age the store_Perform the Buyback_Void on next day");
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,0);
					Buyback_Cash.Buyback_Cash(SSN, FileName);
					AgeStore_Buyback_encryptionKeyVoid.AgeStore_Buyback_encryptionKeyVoid(SSN, FileName, 1);
					Byback_AgestoreVoid.Byback_AgestoreVoid(SSN, FileName);
				}
			}
		}

      //@Test(priority=20,groups = "chenna_WY_PDL")

		public void VerifyBuyBack_TotalDue() throws Exception
		{
			String FileName= "AA_VerifyBuyBack_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:21:VerifyBuyBack_"+Header, "VerifyBuyBack");
					
					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,0);
					Buyback_Cash.Buyback_Cash(SSN, FileName);
				}
			}
		}

      // @Test(priority=21,groups = "chenna_WY_PDL") //  	As per product config Min term is 7 days for any pay frequency, but loan issued for 4 days.

		public void PartialPayment_BuyBack() throws Exception 
		{

			
			String FileName= "AA_PartialPayment_BuyBack_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{	

					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:22:AA_PartialPayment_BuyBack_"+Header, "NewLoan_AgeStore_PartialPayment_AgeStore_BuyBack");
					
					
					Login.Login(UserName,Password,StoreId);
				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-4);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, +4);
					Buyback_Cash.Buyback_Cash(SSN, FileName);
				}
			}
		}

       //@Test(priority=22,groups = "chenna_WY_PDL")

		public void PartialPayment_BuyBack_Void() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_PartialPayment_BuyBack_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
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
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest("S.NO:23:AA_PartialPayment_BuyBack_Void_"+Header, "NewLoan_AgeStore_PartialPayment_AgeStore_BuyBack_Void");
					
					Login.Login(UserName,Password,StoreId);
									
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-4);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, +4);
					Buyback_Cash.Buyback_Cash(SSN, FileName);
				    BuybackVoid.BuybackVoid(SSN, FileName);
					
				}
			}
			
		}

        //@Test(priority=23,groups = "chenna_WY_PDL")
		
	    public void PartialPayment_BuyBackChange_Void() throws Exception {

			
			String FileName= "AA_PartialPayment_BuyBackChange_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:24:AA_PartialPayment_BuyBackChange_Void_"+Header, "NewLoan_AgeStore_PartialPayment_AgeStore_BuyBackChange_Void");
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,3);
					AgeStore.AgeStore(SSN, FileName,-2);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-2);							     
					BuybackChange.BuybackChange(SSN, FileName);
					BuybackVoid.BuybackVoid(SSN, FileName);
				}
			}
		}

   //  @Test(priority=24,groups = "chenna_WY_PDL")
		
		public void NewLoan_PreNoteDiposit_6daysBeforeDueDate() throws Exception 
		{
			String FileName= "AA_NewLoan_PreNoteDeposit_6DaysBeforeDueDate_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
				UserName = prop.getProperty("UserName_WY_PDL_chenna");
				Password = prop.getProperty("Password_WY_PDL_chenna");
				StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					//StoreId = prop.getProperty("StoreID_TN_PDL_anji");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"_S.No:25"+"_"+PayFrequency+"_"+CollateralType,"Loan_Age the store to six bussiness days before Due date_Process Pre Note Deposit process from Admin Portal_PreNote deposit should post");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName,-7);
				}
			}
		}

        //@Test(priority=25,groups = "chenna_WY_PDL")	
		
		public void NewLoan_Duedate_Holiday() throws Exception
		{
			String FileName= "AA_NewLoan_Duedate_Holiday_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{ 
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:26:NewLoan_Duedate_Holiday_"+Header, "Txn");
					
					Login.Login(UserName,Password,StoreId);
					 RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					
				}
			}
		}

       // @Test(priority=26,groups = "chenna_WY_PDL")

	    public void Prenotedeposit_Verification() throws Exception 
		{
			String FileName= "AA_Prenotedeposit_Verification_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:28:AA_Prenotedeposit_Verification_Txn_Testdata"+Header, "AA_Newloan_Prenotedeposit_Verification_Txn");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -7);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
					AgeStore.AgeStore(SSN, FileName, 0);
					PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName,0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -7);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
				}
			}
		}
		
      //@Test(priority=29,groups = "chenna_WY_PDL")

		public void NewLoan_Deposit_Return_Prenotedeposit() throws Exception 
		{
			String FileName= "AA_NewLoan_Deposit_ReturnPosting_Prenotedeposit_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{ 
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:30:NewLoan_Deposit_Return_Prenotedeposit_"+Header, "New Loan");
					
					
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
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					AgeStore_ACHEffectiveDate.AgeStore_ACHEffectiveDate(SSN, FileName, -7);
					ACHEffectivedate_6DaysBeforeDuedate.ACHEffectivedate_6DaysBeforeDuedate(SSN, FileName, 0);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
				}
			}
		}
	   

          // @Test (priority=30,groups = "chenna_WY_PDL")

				public void Loan__ACHOptOutBeforePrenotedate_PrenoteDepositShouldnotpost() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Loan__ACHOptOutBeforePrenotedate_PrenoteDepositShouldnotpost.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);    
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_Loan__ACHOptOutBeforePrenotedate_PrenoteDepositShouldnotpost"+Header, "Loan_Perform ACH Opt Out before PreNote date_PreNote deposit should not post.");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,2);
							ACHRevoke.ACHRevoke(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							ACHAuthorization.ACHAuthorization(SSN, FileName);
							PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
							CustomerEOD_PreNoteRecord.CustomerEOD_PreNoteRecord(SSN, FileName);

						}
					}
				}
				
				//@Test (priority=31,groups = "chenna_WY_PDL")

				public void Loan__ACHOptOutBeforePrenotedate__ACHOptInAfterPrenOteDate__PrenoteDepInAdmin___PreNotedep() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Loan__ACHOptOutBeforePrenotedate__ACHOptInAfterPrenOteDate__PrenoteDepInAdmin___PreNotedep_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Loan__ACHOptOutBeforePrenotedate__ACHOptInAfterPrenOteDate__PrenoteDepInAdmin___PreNotedep"+Header, "Loan__PerformACHOptOutbeforePreNotedate__PerformACHOptInonPreNotedate__ProcessPreNoteDepositprocessfromAdminPortal___PreNotedepositshouldpost");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,1);
							ACHRevoke.ACHRevoke(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -7);
							ACHAuthorization.ACHAuthorization(SSN, FileName);
							PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, 0);
							CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);
						}
				}
			}

				//@Test (priority=32,groups = "chenna_WY_PDL") 

				public void NewLoan_PerformDeposit_ThroughEOD() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan_PerformDeposit_ThroughEOD_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_NewLoan_PerformDeposit_ThroughEOD_"+Header, "PerformDeposit_ThroughEOD_Txn");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
											
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							DepositStatus.DepositStatus(SSN, FileName);
					
						}
					}
					//Login.Login("CSR353","1234","353");

				}

				//@Test (priority=33,groups = "chenna_WY_PDL") // Need more infor on .

				public void ACH_Nacha_AchDepAdmin() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_ACH_Nacha_AchDepAdmin_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("ACH_Nacha_AchDepAdmin_"+Header, "LoanwithACHcolleteraltype_Nacha_ACHdepositprocessinAdmin");
							
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							//   NACHADeposit_EODProcessing.NACHADeposit_EODProcessing(SSN, FileName, 0);
							StoreInfo.StoreInfo(SSN, FileName);
							//Safeassign.Safeassign(SSN, FileName);
							// Drawerassign.Drawerassign(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Customer_CheckStatus.Customer_CheckStatus(SSN, FileName);

							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

			}

				//@Test (priority=34,groups = "chenna_WY_PDL")

				public void NewLoan_AchRevoke_DepositShouldNotDisplay() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan_AchRevoke_DepositShouldnotDisplay_TestData.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_NewLoan_AchRevoke_DepositShouldnotDisplayt"+Header, "loan with ACH_ach revoke_deposit should not be shown on due date");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -6);
							ACHRevoke.ACHRevoke(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							CheckStatus.CheckStatus(SSN, FileName);


							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}


				//@Test (priority=35,groups = "chenna_WY_PDL")

				public void NewLoan_PartialPayment_throghEOD_CheckDepositdAmount() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan_PartialPayment_throghEOD_CheckDepositdAmount.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_NewLoan_PartialPayment_throghEOD_CheckDepositdAmount"+Header, "NewLoan_PartialPayment_throghEOD_CheckDepositdAmount");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,-5);
							LoanPartialPayment.LoanPartialPayment(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							Check_DepositAmount.Check_DepositAmount(SSN, FileName);

							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}

				//@Test (priority=36,groups = "chenna_WY_PDL")

				public void LoanWithACH_PartialPayment_Nacha_ACHDepositFromAdmin_checkherethedepositedamount() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_LoanWithACH_PartialPayment_Nacha_ACHDepositFromAdmin.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_LoanWithACH_PartialPayment_Nacha_ACHDepositFromAdmin"+Header, "Loan with ACH_Partial Payment_Nacha_Ach Deposit process from admin_check here the deposited amount");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,-5);
							LoanPartialPayment.LoanPartialPayment(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							PreACH_Deposit.PreACH_Deposit(SSN, FileName, 0);
							ACH_Deposit_History.ACH_Deposit_History(SSN, FileName);

							//  DepositAmountStatus.DepositAmountStatus(SSN, FileName);


							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}
	////////////////////////////////////////////////////////////////////////////////////////////////
				
				
				//@Test (priority=37,groups = "chenna_WY_PDL")

				public void PreNotDeposit_PreNoteClear_CustomerInactive_Deposit() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_PreNoteDeposit_Clear_CustomerInactive_Deposit_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);
							//String SSN1 = SSN.substring(0, 3);
							
							
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							
							test = reports.startTest("Scenario_No_37_"+Header, "PreNoteDeposit_Clear_CustomerInactive_Deposit");
							
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Bor.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -5);
							PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -5); 
							AgeStore.AgeStore(SSN, FileName, 0);
							PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName, 0);
							EditBorrower_Inactive.EditBorrower_Inactive(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName); 
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);

						}
						
					}
				}
				
				//@Test (priority=38,groups = "chenna_WY_PDL")

				public void PreNoteDepositClear_CustomerInactiveAndActive_EOD() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_PreNoteDeposit_Clear_CustomerActive_Deposit_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Scenario_No_38_"+Header, "PreNoteDeposit_Clear_CustomerActive_Deposit");
							
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Bor.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -5);
							PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -5);
							AgeStore.AgeStore(SSN, FileName, -1);
							PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName, -1);
							EditBorrower_Inactive.EditBorrower_Inactive(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							EditBorrower_Active.EditBorrower_Active(SSN, FileName);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName); 
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);

						}
					}
				}

				//@Test (priority=39,groups = "chenna_WY_PDL")

				public void ACHRevokeBeforePreNoteDate_ACHAuthAfterPreNoteDate() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_ACHRevokeBeforePreNoteDate_ACHAuthAfterPreNoteDate_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Scenario_No_39_"+Header,"ACHRevokeBeforePreNoteDate_ACHAuthAfterPreNoteDate");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -8);
							ACHRevoke.ACHRevoke(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -3);
							ACHAuthorization.ACHAuthorization(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);


							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}

			//	@Test (priority=40,groups = "chenna_WY_PDL")

				public void ACHLoan_ACHRev_ACHAuth_ACHDep_CheckDepwithNewBnkDet() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_ACHLoan_ACHRev_ACHAuth_ACHDep_CheckDepwithNewBnkDet_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					int lastrow=TestData.getLastRow("NewLoan");
					String sheetName="NsewLoan";
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Scenario_No_40_"+Header, "ACHLoan_ACHRev_ACHAuth_ACHDep_CheckDepwithNewBnkDet");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -5);
							ACHRevoke.ACHRevoke(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							ACHAuthorization.ACHAuthorization(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);
							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}


			//	@Test (priority=41,groups = "chenna_WY_PDL")//comp

				public void NewLoan_PartialPayment() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Newloan_PartialPayment_Txn_TestData.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AEA_Newloan_PartialPayment_Txn_"+Header, "AEA_Newloan_PartialPayment_Txn");
							
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);				
											
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);			
							LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,3);
							LoanPartialPayment.LoanPartialPayment(SSN, FileName);
							
						}
					}
					//Login.Login("CSR353","1234","353");

				}

				//@Test (priority=42,groups = "chenna_WY_PDL") //complete

				public void CheckingPartialPmt_SomeDaysAfterDueDate() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_CheckingPartialPmt_SomeDaysAfterDueDate_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_CheckingPartialPmt_SomeDaysAfterDueDate"+Header, "CheckingPartialPmt_SomeDaysAfterDueDate");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
											
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,5);
							CheckPartialPayment.CheckPartialPayment(SSN, FileName);
							
						}
					}
					

				}

				//@Test (priority=43,groups = "chenna_WY_PDL")//comp

				public void PartialPayment_MultipleTenderTypes() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan_PartialPayment_MultipleTenderTypes.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_NewLoan_PartialPayment_MultipleTenderTypes"+Header, "NewLoan_PartialPayment_MultipleTenderTypest");
							
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,3);
							LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender(SSN, FileName);
							check_updates.check_updates(SSN, FileName);
							
						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=44,groups = "chenna_WY_PDL")//comp

				public void NewLoan_Deposit_CheckPartialPaymentDisplay_AfterDeposit() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan_Deposit_CheckPartialPaymentDisplay_AfterDepositTestData.xls";
					//Excel TestData = new Excel("E:/AA/TestData/PDL/"+FileName);
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_NewLoan_Deposit_CheckPartialPaymentDisplay_AfterDeposit"+Header, "Adv_Deposit_Check whether Partial payment is displayed after check is deposited.");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
										
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							AfterDeposit_CheckPartialPaymentinDropdown.AfterDeposit_CheckPartialPaymentinDropdown(SSN, FileName);
						}
					}
				}
				
			//	@Test (priority=45,groups = "chenna_WY_PDL")// comp

				public void PartialPayment_Agestore_CheckLoanDisplayedEOD() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Partialpayment_Agestore_CheckRecordEOD_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							
							test = reports.startTest("Scenario_No_52_"+Header, "Loan->Age store to some days ->Partial Payment->Age the store  to due date->Check Whether Loan is displayed in EOD");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);				
											
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,-4);
							LoanPartialPayment.LoanPartialPayment(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							CheckStatus.CheckStatus(SSN, FileName);  
							
						}
					}
				}
				
			//	@Test (priority=46,groups = "chenna_WY_PDL")

				public void Loan_AgeStore_ProcessDeposit_Nacha_DepositShouldPost() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Loan_AgeStore_ProcessDeposit_Nacha_DepositShouldPost_TestData.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Loan_AgeStore_ProcessDeposit_Nacha_DepositShouldPost"+Header, "Loan_Age the store up to due date_Process the deposit_Process GB Nacha File from admin Interface_Deposit should post");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACH_Deposit_Status.ACH_Deposit_Status(SSN, FileName);
							
						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=47,groups = "chenna_WY_PDL")

				public void LoanWithCheck_DepConvertToACH_ACHDep_ProcessEOD() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_LoanWithCheck_DepConvertToACH_ACHDep_ProcessEOD_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("LoanWithCheck_DepConvertToACH_ACHDep_ProcessEOD"+Header, "LoanWithCheck__DepConvertTOACH__Deposit__ProcessEOD");
							 
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);

							//  NACHADeposit_EODProcessing.NACHADeposit_EODProcessing(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing_Regular.EODProcessing_Regular(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							ACH_History_Status.ACH_History_Status(SSN, FileName);


						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=48,groups = "chenna_WY_PDL")

				public void LoanWithCheck_ConvertACH_Deposit_ACHClear() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Newloan_Dep (Convert ACH)_Deposit_ACH Clear.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_Newloan_Dep (Convert ACH)_Deposit_ACH Clear"+Header, "Loan(Check)_Dep (Convert ACH)_Deposit_ACH Clear");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,0);
							//NACHADeposit_EODProcessing.NACHADeposit_EODProcessing(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							StoreInfo.StoreInfo(SSN, FileName); 
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							//ACH_Clear.ACH_Clear(SSN, FileName); //r doing ACH Clear from Admin side
							ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName); // pradeep
							ACH_Clear_History.ACH_Clear_History(SSN, FileName);
							
						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=49,groups = "chenna_WY_PDL")

				public void LoanwithCheck__DepConvertACH__Deposit__ACHReturn() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_LoanwithCheck__DepConvertACH__Deposit__ACHReturn_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("LoanwithCheck__DepConvertACH__Deposit__ACHReturn"+Header, "LoanwithCheck__DepConverttoACH__Deposit__ACHReturn");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);				
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							ACHReturn_History.ACHReturn_History(SSN, FileName);



						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=50,groups = "chenna_WY_PDL")

				public void Loan_Full_PrePayment() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_BorrowerRegistration_NewLoan_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Loan_Deposit_FullPrePayment_Clear_Refund"+Header, "Loan_Deposit_Pre Payment full _Clear_Refund	");
							 
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);				
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							ACH_PrePayment.ACH_PrePayment(SSN, FileName);
							ACH_Prepayment_History.ACH_Prepayment_History(SSN, FileName);

						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=51,groups = "chenna_WY_PDL")

				public void Newloan_VoidPrePayment() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_BorrowerRegistration_NewLoan_Void_Txn_Testdata.xls";
					//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName); 
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AEA_Newloan_voidPartialPayment_Txn_"+Header, "AEA_Newloan_voidPartialPayment_Txn");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							//Reg.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
			 				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							ACH_PrePayment.ACH_PrePayment(SSN, FileName);
							Void_PrePayment.Void_PrePayment(SSN, FileName);
										
						}
					}
					//Login.Login("CSR353","1234","353");
				}
				
				//@Test (priority=52,groups = "chenna_WY_PDL")

				public void PartialPayment_ACH_Deposit() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Prenote_Verification_within5businessdays_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AEA_Newloan_PartialPayment_Txn_"+Header, "AEA_Newloan_PartialPayment_Txn");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,-2);
							LoanPartialPayment.LoanPartialPayment(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							ACH_PrePayment.ACH_PrePayment(SSN, FileName);
							Check_Amount_History1.Check_Amount_History1(SSN, FileName);

						}
					}
			}

				//@Test (priority=53,groups = "chenna_WY_PDL") // Return posting code updated pradeep

				public void Nacha_ACHDepositProcess_ACHReturn() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Nacha_DepositProcess_ReturnPosting_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
							String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
							// System.out.println(Password);
							//StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							//test = reports.startTest("Scenario_No_60_"+Header, "Loan (ACH) -->  Nacha --> Ach Deposit process --> Ach Return posting");
							test = reports.startTest(Header+"_S.No:60"+"_"+PayFrequency+"_"+CollateralType,"Loan (ACH)_Nacha(EOD)_Ach Deposit process_Ach Return posting");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);					
							StoreInfo.StoreInfo(SSN, FileName); 
							NACHA.NACHA(SSN, FileName, 0);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);

						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=54,groups = "chenna_WY_PDL") //scenario pass , results shows fail

				public void ConvertCheckToACHNacha_ACHDepositProcess_ACHReturn() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_ConvertCheckToACHNacha_DepositProcess_ReturnPosting_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
							String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
							// System.out.println(Password);
							//StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							//test = reports.startTest("Scenario_No_62_"+Header,"Loan (Check) -->  (Convert to ACH) Ach Deposit process --> Ach Return Posting");
							test = reports.startTest(Header+"_S.No:62"+"_"+PayFrequency+"_"+CollateralType,"Loan (Check)_(Convert to ACH) Ach Deposit process_Ach Return Posting");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName); 
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName); 
							NACHA.NACHA(SSN, FileName, 0);
							Safeassign.Safeassign(SSN, FileName); 
							Drawerassign.Drawerassign(SSN, FileName); 
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
						//	DepositStatus.DepositStatus(SSN, FileName);


							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=55,groups = "chenna_WY_PDL")

				public void Loan_Deposit_PrePayment_Return() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_DepositProcess_PrePayment_ReturnPosting_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
							String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
							// System.out.println(Password);
							//StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							//test = reports.startTest("Scenario_No_64_"+Header,"Loan  --> Age the store  upto duedate --> perform deposit --> age perform the Prepayment--> age the store --> return");
							test = reports.startTest(Header+"_S.No:64"+"_"+PayFrequency+"_"+CollateralType,"Loan_Age the store  upto duedate_perform deposit_age perform the Prepayment_age the store_return");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName); 
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							//StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName); 
							NACHA.NACHA(SSN, FileName, 0);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName); 
							ACH_PrePayment.ACH_PrePayment(SSN, FileName);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							//DepositStatus.DepositStatus(SSN, FileName);


							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=56,groups = "chenna_WY_PDL") 

				public void LoanwithCheck_Deposit_ReturnwithoutR01R09_FutureDepositNotposted() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan(check)_Deposit_ReturnPostingwithout(R01R09)_FetureDepositnotPost_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
							String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
							// System.out.println(Password);
							//StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							//test = reports.startTest("Scenario_No_67_"+Header,"loan with check->deposit->return with return reason id other than R01,R09 then should not allow for future deposit");
							test = reports.startTest(Header+"_S.No:67"+"_"+PayFrequency+"_"+CollateralType,"loan with check->deposit_return with return reason id other than R01,R09 then should not allow for future deposit");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName); 
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName); 
							NACHA.NACHA(SSN, FileName, 0);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName); 
							ACHReturnPostingWithoutR01R09.ACHReturnPostingWithoutR01R09(SSN, FileName); 
							ACHEffectiveDate_AgeStore.ACHEffectiveDate_AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);  
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							FutureDeposit_RecoredSataus.FutureDeposit_RecoredSataus(SSN, FileName);
							
						}
					}
					
				}
				
				
				@Test (priority=57,groups = "chenna_WY_PDL")

				public void LoanwithACH_NACHA_ACHDepProc_ProcessClear() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_LoanwithACH_NACHA_ACHDepProc_ProcessClear_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							     AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
								UserName = prop.getProperty("UserName_WY_PDL_chenna");
								Password = prop.getProperty("Password_WY_PDL_chenna");
								StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
							String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
							
							//System.out.println(SSN);
							
							test = reports.startTest(Header+"_S.No:101"+"_"+PayFrequency+"_"+CollateralType,"LoanwithACH__Nacha__AchDepositProcess__ProcessClear");
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							/*Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
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
							ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);*/
							ACHClear_History.ACHClear_History(SSN, FileName);

						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=58,groups = "chenna_WY_PDL")	

				public void NewLoan_PreNoteDeposit_PreNoteClear() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan_PreNoteDeposit_PreNoteClearTestData.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							 AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
								UserName = prop.getProperty("UserName_WY_PDL_chenna");
								Password = prop.getProperty("Password_WY_PDL_chenna");
								StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							// System.out.println(Password);
							//StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
							String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							
							test = reports.startTest(Header+"_S.No:102"+"_"+PayFrequency+"_"+CollateralType,"Loan(ACH/Check)_PreNoteDeposit_PreNoteClear");

							//CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -7);
							PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
							AgeStore.AgeStore(SSN, FileName, -1); 
							PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName, -1);   
							Clear_Status.Clear_Status(SSN, FileName);
							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				
				//@Test (priority=59,groups = "chenna_WY_PDL")

				public void LoanwithCheck_ConverttoACH_ACHDepproc_ProcClear() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_LoanwithCheck_ConverttoACH_ACHDepproc_ProcClear_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							// System.out.println(Password);
							//StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
							String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							
							test = reports.startTest(Header+"_S.No:103"+"_"+PayFrequency+"_"+CollateralType,"Loan (Check) -->(Convert to ACH) Ach Deposit process-->Process Clear");	 
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
							ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);
							ACHClear_History.ACHClear_History(SSN, FileName);


						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=60,groups = "chenna_WY_PDL")

				public void Loan_Agestoreduedate_performdepositPrepayment_agestore_ProcessClear() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Loan_Agestoreduedate_performdepositPrepayment_agestore_ProcessClear_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							// System.out.println(Password);
							//StoreId = prop.getProperty("StoreID_WY_PDL_pradeep");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
							String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							//test = reports.startTest("Loan_Agestoreduedate_performdeposit_Prepayment_agestore_ProcessClear"+Header, "Loan__Agethestoreuptoduedate__performdeposit__ageperformthePrepayment__agethestore__ProcessClear");
							test = reports.startTest(Header+"_S.No:104"+"_"+PayFrequency+"_"+CollateralType,"Loan__Agethestoreuptoduedate__performdeposit__ageperformthePrepayment__agethestore__ProcessClear");

							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
							ACH_PrePayment.ACH_PrePayment(SSN, FileName);
							AgeStore_ACH.AgeStore_ACH(SSN, FileName, 5);
							//ACH_Clear.ACH_Clear(SSN, FileName);
							ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);
							ACHClear_History.ACHClear_History(SSN, FileName);


						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
			//	@Test (priority=61,groups = "chenna_WY_PDL")

				public void NewLoan_Perform_EPP() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan_PartialPayment_throghEOD_CheckDepositdAmount.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_NewLoan_PartialPayment_throghEOD_CheckDepositdAmount"+Header, "NewLoan_PartialPayment_throghEOD_CheckDepositdAmount");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,-5);
							Perform_EPP.Perform_EPP(SSN, FileName);			        
						
						}
					}
				}

					//@Test (priority=62,groups = "chenna_WY_PDL")

				public void EPP_MissRPPPayment_EOD_Checkbox() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_RPP_MissRPPPayment_EOD_Checkbox_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("RPP_MissRPPPayment_EOD_Checkbox_Txn_"+Header, "RPP_MissRPPPayment_EOD_Checkbox_Txn");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,-2);
							RPPPerform.RPPPerform(SSN, FileName);				           
							AgeStore1stinst.AgeStore1stinst(SSN, FileName, 3);
							DrawerDeassign.DrawerDeassign(SSN, FileName);				          
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);

						}
					}
					//Login.Login("CSR353","1234","353");

				}

			//	@Test (priority=63,groups = "chenna_WY_PDL")

				public void EPP_MissRPPPayment_EOD_Forcefully() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_EPP_MissRPPPayment_EOD_Forcefully_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("EPP_MissRPPPayment_EOD_Forcefully_Txn_"+Header, "Loan-RPP- Miss the EPP Payment --> Age the store to 14 days from RPP due date --> Perform EOD --> Customer record should display in EOD process and should comes out forcefully from RPP.");
							
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,-2);
							RPPPerform.RPPPerform(SSN, FileName);				           
							//AgeStore.AgeStore1stinst(SSN, FileName, 2);
							AgeStore2ndinst.AgeStore2ndinst(SSN, FileName, -14);
							DrawerDeassign.DrawerDeassign(SSN, FileName);				          
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);



							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				//@Test (priority=64,groups = "chenna_WY_PDL")

				public void Newloan_PartialPayment_Deposit_Clear_Refund() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Newloan_PartialPayment_Deposit_Clear_Refund.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_Newloan_PartialPayment_Deposit_Clear_Refund"+Header, "Loan_Partial Payment_Deposit_Clear_Refund");
							
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,-6);
							LoanPartialPayment.LoanPartialPayment(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,0);
							// NACHADeposit_EODProcessing.NACHADeposit_EODProcessing(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							StoreInfo.StoreInfo(SSN, FileName); 
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							//ACH_Clear.ACH_Clear(SSN, FileName);
							ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);
							ACH_ReFund.ACH_ReFund(SSN, FileName);
							ACH_ReFund_History.ACH_ReFund_History(SSN, FileName);
							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}
				//@Test (priority=65,groups = "chenna_WY_PDL")

				public void Loan_Deposit_FullPrePayment_Clear_Refund() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Loan_Deposit_FullPrePayment_Clear_Refund_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Loan_Deposit_FullPrePayment_Clear_Refund"+Header, "Loan_Deposit_Pre Payment full _Clear_Refund	");
							 
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);

							// NACHADeposit_EODProcessing.NACHADeposit_EODProcessing(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							ACH_PrePayment.ACH_PrePayment(SSN, FileName);
							//ACH_Clear.ACH_Clear(SSN, FileName);
							ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);
							ACH_ReFund.ACH_ReFund(SSN, FileName);
							ACH_ReFund_History.ACH_ReFund_History(SSN, FileName);
						}
					}
					//Login.Login("CSR353","1234","353");

				}
			//	@Test (priority=66,groups = "chenna_WY_PDL")

				public void LoanWithCheck_ConvertAch_AchPrePayment_AchClr_Refund() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_LoanWithCheck_ConvertAch_AchPrePayment_AchClr_Refund_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("LoanWithCheck_ConvertAch_AchPrePayment_AchClr_Refund"+Header, "Loan With Check_Deposit (Convert to ACH)_ACH Pre Payment Partially_ACH CLR_Refund");
							
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACH_PartialPrePayment.ACH_PartialPrePayment(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 3);
							//ACH_Clear.ACH_Clear(SSN, FileName);
							ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);
							ACH_ReFund.ACH_ReFund(SSN, FileName);
							ACH_History_Status.ACH_History_Status(SSN, FileName);

							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}
			  
				//@Test (priority=67,groups = "chenna_WY_PDL")

				public void NewLoan_ReturnPosting_60days_Writeoff() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan_ReturnPosting_60days_Writeoff_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("NewLoan_ReturnPosting_60days_Writeoff_Txn"+Header, "Loan -> Return Posting -> WO Check whether Write off is done 60days from return date.");
							


						//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);						     
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							writeoff_Process.writeoff_Process(SSN, FileName, 60);					      
							LoanStatus.LoanStatus(SSN, FileName);

						}
					}
					//Login.Login("CSR353","1234","353");

				}

			//  @Test (priority=68,groups = "chenna_WY_PDL")

				public void Loan_ReturnPosting_15PerofTotalDue__CheckWriteOff120daystoretdate() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Loan_ReturnPosting_15PerofTotalDue__CheckWriteOff120daystoretdate_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Loan_ReturnPosting_15PerofTotalDue__CheckWriteOff120daystoretdate"+Header, "Loan__ReturnPosting___NSFPayment15PercentofTotalDue__WOCheckwhetherWriteoffisdone120daysfromreturndate");
							


							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							// NewLoan_EODProcessing.NewLoan_EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							// ACH_PartialPrePayment.ACH_PartialPrePayment(SSN, FileName);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							ACHPayment.ACHPayment(SSN, FileName, 0.15);
							WriteOff.WriteOff(SSN, FileName, 121);
							WriteOff_History.WriteOff_History(SSN, FileName);



						}
					}
					//Login.Login("CSR353","1234","353");

				}

			  //@Test (priority=69,groups = "chenna_WY_PDL")

				public void Loan_ReturnPosting_NSF15_Void_WO60days_Returndate() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Loan_ReturnPosting_NSF15_Void_WO60days_Returndate_TestData.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Loan_ReturnPosting_NSF15_Void_WO60days_Returndate_TestData"+Header, "Loan->Return Posting_NSF Payment 15% of Total Due_Void_WO Check whether Write off is done 60 days from return date.");
							
							
							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							ACHPayment.ACHPayment(SSN, FileName, 0.15);
							NSF_Void.NSF_Void(SSN, FileName);
							WriteOff.WriteOff(SSN, FileName, 60);
							WriteOff_History.WriteOff_History(SSN, FileName);

							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
			 // @Test (priority=70,groups = "chenna_WY_PDL")

				public void Loan_ReturnPosting_30PerofTotalDue__CheckWriteOff180daystoretdate() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Loan_ReturnPosting_30PerofTotalDue__CheckWriteOff180daystoretdate_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Loan_ReturnPosting_30PerofTotalDue__CheckWriteOff180daystoretdate"+Header, "Loan__ReturnPosting___NSFPayment30PercentofTotalDue__WOCheckwhetherWriteoffisdone180daysfromreturndate");
							


							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							// NewLoan_EODProcessing.NewLoan_EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							// ACH_PartialPrePayment.ACH_PartialPrePayment(SSN, FileName);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							ACHPayment.ACHPayment(SSN, FileName, 0.3);
							WriteOff.WriteOff(SSN, FileName, 181);
							WriteOff_History.WriteOff_History(SSN, FileName);



						}
					}
					//Login.Login("CSR353","1234","353");

				}

				//@Test (priority=71,groups = "chenna_WY_PDL")

				public void NewLoan_RPP_AgeInstwise_PPPayment() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan_Instwise_PerformRPP_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("AA_NewLoan_Instwise_PerformRPP_Txn__"+Header, "AA_NewLoan_Instwise_PerformRPP_Txn");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,-2);
							RPPPerform.RPPPerform(SSN, FileName);				           
							AgeStore1stinst.AgeStore1stinst(SSN, FileName, 0);
							RPPPayment.RPPPayment(SSN, FileName);
							AgeStore2ndinst.AgeStore2ndinst(SSN, FileName, 0);
							RPPPayment.RPPPayment(SSN, FileName);
							AgeStore3rdinst.AgeStore3rdinst(SSN, FileName, 0);
							RPPPayment.RPPPayment(SSN, FileName);
							AgeStore4rthinst.AgeStore4rthinst(SSN, FileName, 0);
							RPPPayment.RPPPayment(SSN, FileName);
							//AgeStore.AgeStore5thinst(SSN, FileName, 0);
							//RPPPayment.RPPPayment(SSN, FileName);  

							//WebDriverWait wait = new WebDriverWait(driver, 10);		        		        		        	       
							//wait(100);
							// RegistrationPage.RegistrationPage(SSN);
						}
					}
					//Login.Login("CSR353","1234","353");

				}


				//@Test(priority=72,groups = "chenna_WY_PDL") //// No Test Data for cenario.cenario



				public void NewLoan_DueDate_Holiday_Verification() throws Exception {



					// Start test. Mention test script name

					String FileName= "AA_NewLoan_Duedate_Holiday_Verification_Txn_Testdata.xls";

					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     

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

							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);

							String StateID = TestData.getCellData(sheetName,"StateID",row);

							String SSN = TestData.getCellData(sheetName,"SSN",row); 

							String Header = StateID+ "_" + ProductID;

							//System.out.println(SSN);

							test = reports.startTest("BorrowerRegistration_NewLoan_"+Header, "New Loan");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);

						}

					}


				}

				//@Test (priority=73,groups = "chenna_WY_PDL")

				public void Loan_Deposit_PrePaymentfull_Return_RefundnotDisplay() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_Loan_Deposit_PrePaymentfull_Return_RefundnotDisplay_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("Loan_Deposit_PrePaymentfull_Return_RefundnotDisplay_Txn"+Header, "Loan_Deposit_PrePaymentfull_Return_RefundnotDisplay_Txn");
							
							
							SetCurrentDate.SetCurrentDate(SSN, FileName);				
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);						     
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							Prepaymentfull.Prepaymentfull(SSN, FileName);
							ACHReturnPosting1.ACHReturnPosting1(SSN, FileName);						   
							Refund_Status.Refund_Status(SSN, FileName);
						}
					}
					
				}

			//	@Test (priority=74,groups = "chenna_WY_PDL")

				public void LLCWriteoff_Rules_Characteristics() throws Exception {

					// Start test. Mention test script name
					String FileName= "AA_NewLoan_ReturnPosting_60days_Writeoff_Txn_Testdata.xls";
					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName,"ProductID",row);
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							String SSN = TestData.getCellData(sheetName,"SSN",row);	
							String Header = StateID+ "_" + ProductID;
							//System.out.println(SSN);
							test = reports.startTest("NewLoan_ReturnPosting_60days_Writeoff_Txn"+Header, "Loan -> Return Posting -> WO Check whether Write off is done 60days from return date.");
							


						//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							//EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);						     
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							writeoff_Process.writeoff_Process(SSN, FileName, 60);					      
							LoanStatus.LoanStatus(SSN, FileName);

						}
					}
					//Login.Login("CSR353","1234","353");

				}
				
				
			//	@Test (priority=75,groups = "chenna_WY_PDL")

				public void NewLoan_LoginPAM_RescindACHoptioncheck() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_PAMwithRescind_Txn_Testdata.xls";

					TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);

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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:18" + "_" + PayFrequency + "_" + CollateralType,"New Loan => Login PAM =>Select Rescind =>Only ACH option should be displayed.");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							PAMRescind.PAMRescind(SSN, FileName);

						}
					}

				}


				//@Test(priority = 76, groups = "chenna_WY_PDL")

				public void NewLoan_Deposit_Clear_transactions_dropdown() throws Exception {

					// Start test. Mention test script name
					String FileName = "NewLoan_Deposit_Clear_transactions_dropdown.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
							String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:48" + "_","Advance (ACH/Check) =>Process Deposit => Based on manual clear days rule value =>Validate Manual Clear transactions is been displayed in transaction drop down => Process Clear");

							//SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
							AgeStore.AgeStore(SSN, FileName, 2);
							ACH_Clear.ACH_Clear(SSN, FileName);

						}
					}

				}


	              ////////new Scenarios////////////
	
				/*// @Test (priority=74,groups = "anji_WY_PDL")

				public void Partialpayment_MO_DifNumber() throws Exception {

					String FileName = "AA_Partialpayment_Mo_Dif_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:06:_Partialpayment_MO_diff Refnumbers");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -1);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
						}
					}

				}

				// @Test (priority=75,groups = "anji_WY_PDL")

				public void Partialpayment_Mo_DifNumber_void() throws Exception {

					String FileName = "AA_Partialpayment_Mo_Dif_void_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:07:_Partialpayment_Mo_DifNumber_void");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -1);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
							Partialpayment_Original_Tender_Void.Partialpayment_Original_Tender_Void(SSN, FileName);
						}
					}

				}

				// @Test (priority=76,groups = "anji_WY_PDL")

				public void Partialpayment_Mo_DifNumber_Cashvoid() throws Exception {

					String FileName = "AA_Partialpayment_Mo_Dif_CashVoid_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:08:AA_Partialpayment_Mo_Dif_CashVoid");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -1);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
							Partialpayment_Cash_Tender_Void.Partialpayment_Cash_Tender_Void(SSN, FileName);
						}
					}

				}

				// @Test (priority=77,groups = "anji_WY_PDL")

				public void Partialpayment_Mo_DifNumber_AgestoreCashvoid() throws Exception {

					String FileName = "AA_Partialpayment_Mo_Dif_EncryCashVoid_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:09:AA_Partialpayment_Mo_Dif_EncryCashVoid");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -1);
							// Partialpayment_Cash_Tender_Void.Partialpayment_Cash_Tender_Void(SSN,
							// FileName);
							PartialPayment_VoidEncryptionKey.PartialPayment_VoidEncryptionKey(SSN, FileName);
						}
					}

				}

				// @Test (priority=78,groups = "anji_WY_PDL")

				public void Partialpayment_MO_SameNumber() throws Exception {

					String FileName = "AA_Partialpayment_Mo_Same_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:10:_Partialpayment_MO_same Refnumbers");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Same.LoanPartialPayment_Same(SSN, FileName);
						}
					}

				}

				// @Test (priority=79,groups = "anji_WY_PDL")

				public void Partialpayment_CCK_DifNumber() throws Exception {

					String FileName = "AA_Partialpayment_CCK_Dif_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:11:_Partialpayment_CCK_Diff_Refnumbers");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);

						}
					}

				}

				// @Test (priority=80,groups = "anji_WY_PDL")

				public void Partialpayment_CCK_DifNumber_Void_OriginalTender() throws Exception {

					String FileName = "AA_Partialpayment_CCK_Dif_OriginalTender_Void_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:12:_Partialpayment_CCK_DifNumber_Void_OriginalTender");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
							Partialpayment_Original_Tender_Void.Partialpayment_Original_Tender_Void(SSN, FileName);

						}
					}

				}

				// @Test (priority=81,groups = "anji_WY_PDL")

				public void Partialpayment_CCK_DifNumber_Void_Cash() throws Exception {

					String FileName = "AA_Partialpayment_CCK_Dif_Cash_Void_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:13:__Partialpayment_CCK_DifNumber_Void_Cash");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
							Partialpayment_Cash_Tender_Void.Partialpayment_Cash_Tender_Void(SSN, FileName);

						}
					}

				}

				// @Test (priority=82,groups = "anji_WY_PDL")

				public void Partialpayment_CCK_DifNumber_Encryption_Void_Cash() throws Exception {

					String FileName = "AA_Partialpayment_CCK_Dif_Cash_EncryptionVoid_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:14:_Partialpayment_CCK_DifNumber_Encryption_Void_Cash");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -4);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							PartialPayment_VoidEncryptionKey.PartialPayment_VoidEncryptionKey(SSN, FileName);

						}
					}

				}

				// @Test (priority=83,groups = "anji_WY_PDL")

				public void Partialpayment_CCK_SameNumber() throws Exception {

					String FileName = "AA_Partialpayment_CCK_Same_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:15:_Partialpayment_CCK_same Refnumbers");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Same.LoanPartialPayment_Same(SSN, FileName);

						}
					}

				}

				// @Test (priority=84,groups = "anji_WY_PDL")

				public void Partialpayment_SameTender_Cash() throws Exception {

					String FileName = "AA_Partialpayment_CCK_Same_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:15:__Partialpayment_TwoTendertype_Cash");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Same.LoanPartialPayment_Same(SSN, FileName);

						}
					}

				}

				// @Test (priority=85,groups = "anji_WY_PDL")

				public void Partialpayment_MO_Dif_MidDayDeposit_CashVoid() throws Exception {

					String FileName = "AA_Partialpayment_MO_Dif_MidDayDeposit_CashVoid_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:17:_Partialpayment_MO_Dif_MidDayDeposit_CashVoid");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							MidDayDeposit.MidDayDeposit(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							SafeDeAssign.SafeDeAssign(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							Partialpayment_Cash_Tender_Void.Partialpayment_Cash_Tender_Void(SSN, FileName);

							// StatementGeneration_EODProcessing_ChecksAvble.StatementGeneration_EODProcessing_ChecksAvble(SSN,
							// FileName);

						}
					}

				}

				// @Test (priority=86,groups = "anji_WY_PDL")

				public void Partialpayment_MO_Dif_EOD_Deposit_CasVoid() throws Exception {

					String FileName = "AA_Partialpayment_MO_Dif_EODDeposit_CashVoid_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:18:_Partialpayment_MO_Dif_EOD_MIDDAYDeposit_CashVoid");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing_ChecksAvble.StatementGeneration_EODProcessing_ChecksAvble(SSN,
									FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							SafeDeAssign.SafeDeAssign(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							Partialpayment_Cash_Tender_Void.Partialpayment_Cash_Tender_Void(SSN, FileName);

						}
					}

				}

				// @Test (priority=87,groups = "anji_WY_PDL")

				public void Partialpayment_CCK_Dif_MidDayDeposit_CashVoid() throws Exception {

					String FileName = "AA_Partialpayment_CCK_Dif_MidDayDeposit_CashVoid_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:19:_Partialpayment_CCK_Dif_MidDayDeposit_CashVoid");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							MidDayDeposit.MidDayDeposit(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							SafeDeAssign.SafeDeAssign(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							Partialpayment_Cash_Tender_Void.Partialpayment_Cash_Tender_Void(SSN, FileName);

							// StatementGeneration_EODProcessing_ChecksAvble.StatementGeneration_EODProcessing_ChecksAvble(SSN,
							// FileName);

						}
					}

				}

				// @Test (priority=88,groups = "anji_WY_PDL")

				public void Partialpayment_CCK_Dif_EOD_Deposit_CasVoid() throws Exception {

					String FileName = "AA_Partialpayment_MO_Dif_EODDeposit_CashVoid_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:18:_Partialpayment_CCK_Dif_EOD_MIDDAYDeposit_CashVoid");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							LoanPartialPayment_Diff.LoanPartialPayment_Diff(SSN, FileName);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing_ChecksAvble.StatementGeneration_EODProcessing_ChecksAvble(SSN,
									FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							SafeDeAssign.SafeDeAssign(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							Partialpayment_Cash_Tender_Void.Partialpayment_Cash_Tender_Void(SSN, FileName);

						}
					}

				}

				// @Test (priority=89,groups = "anji_WY_PDL")

				public void NewLoan_Buyback_Verify() throws Exception {

					String FileName = "AA_Partialpayment_MO_Dif_EODDeposit_CashVoid_Txn_Testdata.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							StoreId = prop.getProperty("StoreID_WY_PDL_anji");
							UserName = prop.getProperty("UserName_WY_PDL_anji");
							Password = prop.getProperty("Password_WY_PDL_anji");
							// System.out.println(Password);

							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "S.NO:18:_Partialpayment_CCK_Dif_EOD_MIDDAYDeposit_CashVoid");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_FL.NewLoan_FL(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							Buyback.Buyback(SSN, FileName);
							Buyback_Verifacation.Buyback_Verifacation(SSN, FileName);

						}
					}

				}

				// Venkat scenarios

				@Test(priority = 90, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_Advance_Buyback2tendertypeAs_DiffNum_TranssionShouldBeprocessed.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:22" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as MO with different numbers_Transaction should be processed");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack_MO_With2tendertypes_Withdiffnumbers.BuyBack_MO_With2tendertypes_Withdiffnumbers(SSN, FileName);

						}
					}
				}

				@Test(priority = 91, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:23" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as MO with different numbers_Transaction should be processed_Void Buyback with Original tender type.Validate screen if its displaying tender details properly");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack_MO_With2tendertypes_Withdiffnumbers.BuyBack_MO_With2tendertypes_Withdiffnumbers(SSN, FileName);
							BuybackVoidwith_Orginaltender.BuybackVoidwith_Orginaltender(SSN, FileName);
							Check_TendertypesDetails_Validation.Check_TendertypesDetails_Validation(SSN, FileName);

						}
					}
				}

				@Test(priority = 92, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidwithCash()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidwithCash.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:24" + "_" + PayFrequency + "_" + CollateralType,
									"Advance =>Buyback with 2 tender types as MO with different numbers =>Transaction should be processed ->Void Buyback with cash");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack_MO_With2tendertypes_Withdiffnumbers.BuyBack_MO_With2tendertypes_Withdiffnumbers(SSN, FileName);
							BuybackVoidwith_Cash.BuybackVoidwith_Cash(SSN, FileName);

						}
					}
				}

				@Test(priority = 93, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:25" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as MO with different numbers_Transaction should be processed_Void Buyback next processing day_Only cash should be available.");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack_MO_With2tendertypes_Withdiffnumbers.BuyBack_MO_With2tendertypes_Withdiffnumbers(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 6);
							EncryptionKey_BuybackVoidWith_Cash.EncryptionKey_BuybackVoidWith_Cash(SSN, FileName);

						}
					}
				}

				@Test(priority = 94, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_2Tendertype_Mo_SameNum_TranssionShouldnotbeprocessed() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_Mo_SameNum_TranssionShouldnotbeprocessed.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:26" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as MO with same numbers_Transaction should not be processed");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack_MO_With2tendertypes_WithSamenumbers.BuyBack_MO_With2tendertypes_WithSamenumbers(SSN, FileName);

						}
					}
				}

				@Test(priority = 95, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:27" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as CCK with different numbers_Transaction should be processed");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack_CCK_With2tendertypes_Withdiffnumbers.BuyBack_CCK_With2tendertypes_Withdiffnumbers(SSN,
									FileName);

						}
					}
				}

				@Test(priority = 96, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:28" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as CCK with different numbers_Transaction should be processed_Void Buyback with Original tender type.Validate screen if its displaying tender details properly");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack_CCK_With2tendertypes_Withdiffnumbers.BuyBack_CCK_With2tendertypes_Withdiffnumbers(SSN,
									FileName);
							BuybackVoidwith_Orginaltender.BuybackVoidwith_Orginaltender(SSN, FileName);
							Check_TendertypesDetails_Validation.Check_TendertypesDetails_Validation(SSN, FileName);

						}
					}
				}

				@Test(priority = 97, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithCash()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithCash.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:29" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as CCK with different numbers_Transaction should be processed_Void Buyback with cash");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack_CCK_With2tendertypes_Withdiffnumbers.BuyBack_CCK_With2tendertypes_Withdiffnumbers(SSN,
									FileName);
							BuybackVoidwith_Cash.BuybackVoidwith_Cash(SSN, FileName);
							Check_TendertypesDetails_Validation.Check_TendertypesDetails_Validation(SSN, FileName);

						}
					}
				}

				@Test(priority = 98, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:30" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as CCk with different numbers_Transaction should be processed_Void Buyback next processing day_Only cash should be available.");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack_CCK_With2tendertypes_Withdiffnumbers.BuyBack_CCK_With2tendertypes_Withdiffnumbers(SSN,
									FileName);
							AgeStore.AgeStore(SSN, FileName, 6);
							EncryptionKey_BuybackVoidWith_Cash.EncryptionKey_BuybackVoidWith_Cash(SSN, FileName);

						}
					}
				}

				@Test(priority =99, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_2Tendertype_CCK_SameNum_TranssionShouldnotbeprocessed() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_CCK_SameNum_TranssionShouldnotbeprocessed.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:31" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as CCK with same numbers_Transaction should not be processed");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack_CCK_With2tendertypes_WithSamenumbers.BuyBack_CCK_With2tendertypes_WithSamenumbers(SSN,
									FileName);

						}
					}
				}

				@Test(priority = 100, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_2Tendertype_CashTranssionShouldnotbeprocessed() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_Cash_TranssionShouldnotbeprocessed.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:32" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as Cash_Transaction should not be processed");

							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 5);
							BuyBack__2tendertypes_With_Cash.BuyBack__2tendertypes_With_Cash(SSN, FileName);

						}
					}
				}

				@Test(priority = 101, groups = "venkat_WY_PDL_New1")

				public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_MiddayDeposit_BuyBackVoid() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_MiddayDeposit_BuyBackVoid.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:33" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_Buyback with 2 tender types as MO with different numbers_Transaction should be processed_deassign drawer_Validate they are available for mid day deposit.Process Mid day deposit_Void Buyback Only cash should be displayed.");

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

						}
					}
				}

				@Test(priority = 102, groups = "venkat_WY_PDL_New1")

				public void NewLoan_EPP_PPAYwith2tenderTyprsCCK_Diffnumbers_VoidPPay() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_EPP_PPAYwith2tenderTyprsCCK_Diffnumbers_VoidPPay.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:66" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_EPP_PPAY with 2 tender types as CCK with different numbers_Transaction should be processed_Void ACHPP with Original tender type.Validate screen if its displaying tender details properly");

							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							EPP.EPP(SSN, FileName);
							RPPPayment_With2tenderCCK_Diffnumbers.RPPPayment_With2tenderCCK_Diffnumbers(SSN, FileName);
							Voidwith_Orginaltender.Voidwith_Orginaltender(SSN, FileName);
							Check_TendertypesDetails_Validation.Check_TendertypesDetails_Validation(SSN, FileName);

						}
					}
				}

				@Test(priority = 103, groups = "venkat_WY_PDL_New1")

				public void RPPPayment_With2tenderCCK_Samenumbers_Trans_ShouldNotProcessed() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_RPPPayment_With2tenderCCK_Samenumbers_Trans_ShouldNotProcessed.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:67" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_EPP_PPAY with 2 tender types as CCK with same numbers_Transaction should not be processed");

							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							EPP.EPP(SSN, FileName);
							RPPPayment_With2tenderCCK_Samenumbers.RPPPayment_With2tenderCCK_Samenumbers(SSN, FileName);

						}
					}
				}

				@Test(priority = 104, groups = "venkat_WY_PDL_New1")

				public void NewLoan_EPP_PPAYwith2tenderTyprsCCK_Diffnumbers__DrawerDeassign_MidDayDeposit_VoidPPay()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoan_EPP_PPAYwith2tenderTyprsCCK_Diffnumbers__DrawerDeassign_MidDayDeposit_VoidPPay.xls";
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_venkat") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";

					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							AppURL = prop.getProperty("AppURL_WY_PDL_venkat");
							UserName = prop.getProperty("UserName_WY_PDL_venkat");
							Password = prop.getProperty("Password_WY_PDL_venkat");
							StoreId = prop.getProperty("StoreID_WY_PDL_venkat");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							test = reports.startTest(Header + "_S.No:68" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_EPP_PPAY with 2 tender types as CCk with different numbers_Transaction should be processed_deassign drawer_Validate they are available for mid day deposit.Process Mid day deposit_Void ACHPP Only cash should be displayed.");

							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							EPP.EPP(SSN, FileName);
							RPPPayment_With2tenderCCK_Diffnumbers.RPPPayment_With2tenderCCK_Diffnumbers(SSN, FileName);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							MidDayDeposit.MidDayDeposit(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							SafeDeAssign.SafeDeAssign(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							Voidwith_Cash_CheckTenderType.Voidwith_Cash_CheckTenderType(SSN, FileName);

						}
					}
				}
				// Kiran scenarios
				// @Test (priority=105,groups = "kiran_WY_PDL_NEW")

				public void Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateMidDayDeposit_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateMidDayDeposit_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:35_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Advance _ Buyback with 2 tender types as CCk with different numbers _ Transaction should be processed _ deassign drawer _ Validate they are available for mid day deposit.Process Mid day deposit _ Void Buyback Only cash should be displayed");

							SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 4);
							BuyBack_TwoTenderTypesCCK_2DifferentNumbers.BuyBack_TwoTenderTypesCCK_2DifferentNumbers(SSN, FileName,
									0.5);

							DrawerDeassign.DrawerDeassign(SSN, FileName);
							MidDayDeposit.MidDayDeposit(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							SafeDeAssign.SafeDeAssign(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							BuybackVoid.BuybackVoid(SSN, FileName);

						}
					}

				}

				// @Test (priority=106,groups = "kiran_WY_PDL_NEW")

				public void Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateEOD_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateEOD_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:36_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Advance _ Buyback with 2 tender types as CCk with different numbers _ Transaction should be processed _ deassign drawer _ Validate they are available for mid day deposit.Process Mid day deposit _ Void Buyback Only cash should be displayed");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore_LoanDate.AgeStore_LoanDate(SSN, FileName, 4);
							BuyBack_TwoTenderTypesCCK_2DifferentNumbers.BuyBack_TwoTenderTypesCCK_2DifferentNumbers(SSN, FileName,
									0.5);

							DrawerDeassign.DrawerDeassign(SSN, FileName);
							CHECK_CCMO_Record_EODProcessing.CHECK_CCMO_Record_EODProcessing(SSN, FileName);
							MidDayDeposit.MidDayDeposit(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							SafeDeAssign.SafeDeAssign(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							BuybackVoid.BuybackVoid(SSN, FileName);

						}
					}

				}

				// @Test (priority=107,groups = "kiran_WY_PDL_NEW")

				public void Advance_deposit_ACHPPwith2tendertypessMOwithdiffnumbers_Transactionprocessed_VoidACHPPwithcash()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_deposit_ACHPPwith2tendertypessMOwithdiffnumbers_Transactionprocessed_VoidACHPPwithcash_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:37_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Advance _deposit _ACHPP with 2 tender types as MO with different numbers _Transaction should be processed _Void ACHPP with cash");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
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

						}
					}

				}

				// @Test (priority=108,groups = "kiran_WY_PDL_NEW")

				public void Advance_deposit_ACHPPwith2tendertypessMOwithsamenumbers_Transactionnotprocessed() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_deposit_ACHPPwith2tendertypessMOwithsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:38_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Advance_deposit _ACHPP with 2 tender types as MO with same numbers _Transaction should not be processed");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
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

						}
					}

				}

				// @Test (priority=109,groups = "kiran_WY_PDL_NEW")

				public void Advance_deposit_ACHPP2tenderCCKdiffnumbers_Transactionprocessed_VoidACHPPwithOriginaltender_Validatetenderdetails()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_deposit_ACHPP2tenderCCKdiffnumbers_Transactionprocessed_VoidACHPPwithOriginaltender_Validatetenderdetails_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:39_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Advance _ deposit _ ACHPP with 2 tender types as CCK with different numbers _ Transaction should be processed _ Void ACHPP with Original tender type Validate screen if its displaying tender details properly");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
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

						}
					}

				}

				// @Test (priority=110,groups = "kiran_WY_PDL_NEW")

				public void Advance_deposit_ACHPP2tenderCCKsamenumbers_Transactionnotprocessed() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_deposit_ACHPP2tenderCCKsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:40_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Advance _ deposit _ ACHPP with 2 tender types as CCK with same numbers _ Transaction should not be processed ");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
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

						}
					}

				}

				// @Test (priority=111,groups = "kiran_WY_PDL_NEW")

				public void Advance_deposit_ACHPP2tenderCCKdiffnumbers_Transactionnprocessed_ValidateandprocessMidDayDeposit_VoidwithCashonlyDisplayed()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_deposit_ACHPP2tenderCCKdiffnumbers_Transactionnprocessed_ValidateandprocessMidDayDeposit_VoidwithCashonlyDisplayed_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:41_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Advance _ deposit _ ACHPP with 2 tender types as CCK with different numbers _ Transaction should  be processed_deassign drawer _Validate they are available for mid day deposit_Process Mid day deposit_Void ACHPP Only cash should be displayed ");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
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

						}
					}

				}

				// @Test (priority=112,groups = "kiran_WY_PDL_NEW")// Issue Regarding to the
				// Re Deposit

				public void PickCustwithDirectDepasYes_Advance_UncheckDepositinEOD_Paydateshouldmoveforward_Agebeforenextpaydate_SelectScheduleACHinTransactionList_ProcessNACHA_MakeDeposit()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_PickCustwithDirectDepasYes_Advance_UncheckDepositinEOD_Paydateshouldmoveforward_Agebeforenextpaydate_SelectScheduleACHinTransactionList_ProcessNACHA_MakeDeposit_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:42_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Pick a customer who has direct deposit flag as Y _Advance _ On Due date uncheck the loan in eod deposit screen _Schedule pay date will move to next cycle _ Before next schedule pay date _age the store to some days before schedule pay date  in transaction selection screen _Select schedule ach _On that day loan should be picked for deposit process for Pre Nacha process _Process file _Process deposit for next day ");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);

							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);

							AgeStore_ACHScheduledDate.AgeStore_ACHScheduledDate(SSN, FileName, -2);
							Schedule_ACH.Schedule_ACH(SSN, FileName);

							DrawerDeassign.DrawerDeassign(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA_ScheduleACH.NACHA_ScheduleACH(SSN, FileName, 0);

						}
					}

				}

				// @Test (priority=113,groups = "kiran_WY_PDL_NEW")

				public void PickCustwithDirectDepasYes_Advance_UncheckDepositinEOD_Paydateshouldmoveforward() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_PickCustwithDirectDepasYes_Advance_UncheckDepositinEOD_Paydateshouldmoveforward_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:46_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Pick a customer who has direct deposit flag as Y _Advance _ On Due date uncheck the loan in eod deposit screen _Schedule pay date will move to next cycle ");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);

							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);

							Validate_ScheduledDate_History.Validate_ScheduledDate_History(SSN, FileName);

						}
					}

				}

				// @Test (priority=114,groups = "kiran_WY_PDL_NEW")

				public void LoanwithACH_Deposit_ReturnwithreasonotherthanR01R09_NoFutureDepositAllow() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_LoanwithACH_Deposit_ReturnwithreasonotherthanR01R09_NoFutureDepositAllow_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:47_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"loan with ACH_deposit_return with return reason id other than R01 and R09 then should not allow for future deposit ");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
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

						}
					}

				}

				// @Test (priority=115,groups = "kiran_WY_PDL_NEW")

				public void Advance_deposit_ACHR_WOR2CCKDiffNumbers_Transactionprocessed_deassigndrawer_MidDayDeposit_VoidWORCashOnly()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_deposit_ACHR_WOR2CCKDiffNumbers_Transactionprocessed_deassigndrawer_MidDayDeposit_VoidWORCashOnly_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:63_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Advance _deposit _ACHR_WOR with 2 tender types as CCk with different numbers _Transaction should be processed =>deassign drawer _Validate they are available for mid day deposit_Process Mid day deposit Void WOR Only cash should be displayed");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
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

							// ACH_ReDeposit_Status.ACH_ReDeposit_Status(SSN, FileName);

							// Advance =>EPP =>PPAY with 2 tender types as MO with different
							// numbers =>Transaction should be processed ->Void ACHPP with
							// cash.

						}
					}

				}

				// @Test (priority=116,groups = "kiran_WY_PDL_NEW")

				public void Advance_EPP_PPAYwith2tendertypesasMOwithdiffnumbers_Transactionprocessed_VoidACHPPCash()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_EPP_PPAYwith2tendertypesasMOwithdiffnumbers_Transactionprocessed_VoidACHPPCash_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:64_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Advance _EPP _PPAY with 2 tender types as MO with different numbers _Transaction should be processed _Void ACHPP with cash");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -3);
							EPP.EPP(SSN, FileName);
							RPPPayment_Tender2MoDiffNumbers.RPPPayment_Tender2MoDiffNumbers_Diffnumbers(SSN, FileName);
							Void_RPPPayment_With2TenderMOwithDiffNumbers.Void_RPPPayment_With2TenderMOwithDiffNumbers_Cash(SSN,
									FileName);

							// Advance =>EPP =>PPAY with 2 tender types as MO with different
							// numbers =>Transaction should be processed ->Void ACHPP with
							// cash.

						}
					}

				}

				// @Test (priority=117,groups = "kiran_WY_PDL_NEW")

				public void Advance_EPP_PPAYwith2tendertypesasMOwithsamenumbers_Transactionnotprocessed() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_EPP_PPAYwith2tendertypesasMOwithsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:65_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Advance _EPP _PPAY with 2 tender types as MO with same numbers _Transaction should not be processed");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, -2);
							EPP.EPP(SSN, FileName);
							RPPPayment_Tender2MoDiffNumbers.RPPPayment_Tender2MoDiffNumbers_SameNumbers(SSN, FileName);

						}
					}

				}

				@Test(priority = 118, groups = "kiran_WY_PDL_NEW1") // Agestore to
																	// 10-29-2019(before
																	// starting the
																	// transaction) for
																	// biweekly first payday
																	// radio button

				public void RegistercustmerwhichdoesnotsatisifyMinterm_verifywhetherpayfrequencydatemovedaccordingtothedate()
						throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_WY_PDL_Advance_EPP_PPAYwith2tendertypesasMOwithsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";

					// Start test. Mention test script name
					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
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

							AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
							UserName = prop.getProperty("UserName_WY_PDL_kiran");
							Password = prop.getProperty("Password_WY_PDL_kiran");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:01_Newly_Assigned" + "_" + PayFrequency + "_" + CollateralType,
									"Register Any Payfrequency customer which does not satisfy Minterm _ verify whether loan due date is moved as payfrequency according to the date selected");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL1(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							DueDate_Check.DueDate_Check(SSN, FileName);

						}
					}

				}

				// Brahmith scenarios
			

				@Test(priority = 120, groups = "brahmith_WY_PDL")

				public void NewLoan_Deposit_Clear_prepayment_clear_refund() throws Exception {

					// Start test. Mention test script name
					String FileName = "NewLoan_Deposit_Clear_prepayment_clear_refund.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_brahmith");
							UserName = prop.getProperty("UserName_WY_PDL_brahmith");
							Password = prop.getProperty("Password_WY_PDL_brahmith");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_brahmith");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:49" + "_",
									"Loan --> Age the store upto duedate --> perform deposit --> age perform the Prepayment--> age the store --> Process Clear => Process refund for excess amount paid with Cash");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_product.NewLoan_product(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);

							DrawerDeassign.DrawerDeassign(SSN, FileName);

							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);

							ACH_Prepayment_extraamount.ACH_Prepayment_extraamount(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 1);
							ACH_Clear.ACH_Clear(SSN, FileName);
							ACH_ReFund.ACH_ReFund(SSN, FileName);
						}
					}

				}

				@Test(priority = 121, groups = "brahmith_WY_PDL1")

				public void NewLoan_Deposit_Clear_prepayment_clear_refund_check() throws Exception {

					// Start test. Mention test script name
					String FileName = "NewLoan_Deposit_Clear_prepayment_clear_refund_check.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_brahmith");
							UserName = prop.getProperty("UserName_WY_PDL_brahmith");
							Password = prop.getProperty("Password_WY_PDL_brahmith");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_brahmith");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:50" + "_",
									"Loan --> Age the store upto duedate --> perform deposit --> age perform the Prepayment--> age the store --> Process Clear => Process refund for excess amount paid with Check");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_product.NewLoan_product(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);

							DrawerDeassign.DrawerDeassign(SSN, FileName);

							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);

							ACH_Prepayment_extraamount.ACH_Prepayment_extraamount(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 1);
							ACH_Clear.ACH_Clear(SSN, FileName);
							ACH_Refund_Check.ACH_Refund_Check(SSN, FileName);
						}
					}

				}

				@Test(priority = 122, groups = "brahmith_WY_PDL")

				public void NewLoan_validate_RPP() throws Exception {

					// Start test. Mention test script name
					String FileName = "NewLoan_validate_RPP.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_brahmith");
							UserName = prop.getProperty("UserName_WY_PDL_brahmith");
							Password = prop.getProperty("Password_WY_PDL_brahmith");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_brahmith");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:49" + "_", "Loan => validate RPP available after due date.");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_product.NewLoan_product(SSN, FileName);
							// AgeStore.AgeStore(SSN, FileName, 2);
							RPP_check.RPP_check(SSN, FileName);

						}
					}

				}

				@Test(priority = 123, groups = "brahmith_WY_PDL")

				public void Deposit_ACR_ACHP_2tender_type_MO_transaction_void_with_cash() throws Exception {

					// Start test. Mention test script name
					String FileName = "Deposit_ACR_ACHP_2tender_type_transaction_void_with_cash.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_brahmith");
							UserName = prop.getProperty("UserName_WY_PDL_brahmith");
							Password = prop.getProperty("Password_WY_PDL_brahmith");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_brahmith");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:54" + "_",
									"Advance=>deposit =>ACHR=>ACHP with 2 tender types as MO with same numbers =>Transaction should not be processed");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_product.NewLoan_product(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);

							DrawerDeassign.DrawerDeassign(SSN, FileName);
							// EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							// LoanACHPayment_Diff.LoanACHPayment_Diff(SSN, FileName);
							ACHPP_MO_2tendertypes.ACHPP_MO_2tendertypes_DiffNumbers(SSN, FileName);
							Void_ACHPP_MO_2tendertypes.Void_ACHPP_MO_2tendertypes_Cash(SSN, FileName);

						}
					}

				}

				@Test(priority = 124, groups = "brahmith_WY_PDL")

				public void Deposit_ACR_ACHP_2tender_type_MO_same_transaction() throws Exception {

					// Start test. Mention test script name
					String FileName = "Deposit_ACR_ACHP_2tender_type_same_transaction.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_brahmith");
							UserName = prop.getProperty("UserName_WY_PDL_brahmith");
							Password = prop.getProperty("Password_WY_PDL_brahmith");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_brahmith");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:55" + "_",
									"Advance =>deposit =>ACHR=>ACHP with 2 tender types as MO with different numbers =>Transaction should be processed ->Void ACHP with cash.");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_product.NewLoan_product(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);

							DrawerDeassign.DrawerDeassign(SSN, FileName);
							// EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							// LoanACHPayment_Diff.LoanACHPayment_Diff(SSN, FileName);
							ACHPP_MO_2tendertypes.ACHPP_MO_2tendertypes_SameNumbers(SSN, FileName);

						}
					}

				}

				@Test(priority = 125, groups = "brahmith_WY_PDL")

				public void Deposit_ACR_ACHP_2tender_type_cck_transaction_void() throws Exception {

					// Start test. Mention test script name
					String FileName = "Deposit_ACR_ACHP_2tender_type_cck_transaction_void.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_brahmith");
							UserName = prop.getProperty("UserName_WY_PDL_brahmith");
							Password = prop.getProperty("Password_WY_PDL_brahmith");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_brahmith");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:56" + "_",
									"Advance =>deposit =>ACHR=>ACHP with 2 tender types as CCK with different numbers =>Transaction should be processed ->Void ACHP with Original tender type.Validate screen if its displaying tender details properly");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_product.NewLoan_product(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);

							DrawerDeassign.DrawerDeassign(SSN, FileName);
							// EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							// LoanACHPayment_Diff.LoanACHPayment_Diff(SSN, FileName);
							ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_DiffNumbers(SSN, FileName);
							Void_ACHPP_CCK_2tendertypes.Void_ACHPP_CCK_2tendertypes_OriginalTender(SSN, FileName);

						}
					}

				}

				@Test(priority = 126, groups = "brahmith_WY_PDL")

				public void Deposit_ACR_ACHP_2tender_type_cck_same_transaction() throws Exception {

					// Start test. Mention test script name
					String FileName = "Deposit_ACR_ACHP_2tender_type_cck_same_transaction.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_brahmith");
							UserName = prop.getProperty("UserName_WY_PDL_brahmith");
							Password = prop.getProperty("Password_WY_PDL_brahmith");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_brahmith");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:57" + "_",
									"Advance =>deposit =>ACHR=>ACHP with 2 tender types as MO with different numbers =>Transaction should be processed ->Void ACHP with cash.");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_product.NewLoan_product(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);

							DrawerDeassign.DrawerDeassign(SSN, FileName);
							// EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							// LoanACHPayment_Diff.LoanACHPayment_Diff(SSN, FileName);
							ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_SameNumbers(SSN, FileName);

						}
					}

				}

				@Test(priority = 127, groups = "brahmith_WY_PDL")

				public void Deposit_ACR_ACHP_2tender_type_cck_transaction_DrawerDeassign_Midday_Void() throws Exception {

					// Start test. Mention test script name
					String FileName = "Deposit_ACR_ACHP_2tender_type_cck_transaction_DrawerDeassign_Midday_Void.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_brahmith");
							UserName = prop.getProperty("UserName_WY_PDL_brahmith");
							Password = prop.getProperty("Password_WY_PDL_brahmith");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_brahmith");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:58" + "_",
									"Advance =>deposit =>ACHR=>ACHP with 2 tender types as CCk with different numbers =>Transaction should be processed =>deassign drawer =>Validate they are available for mid day deposit.Process Mid day deposit =>Void ACHP Only cash should be displayed.");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_product.NewLoan_product(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);

							DrawerDeassign.DrawerDeassign(SSN, FileName);
							// EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);
							// LoanACHPayment_Diff.LoanACHPayment_Diff(SSN, FileName);
							ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_DiffNumbers(SSN, FileName);
							DrawerDeassign.DrawerDeassign(SSN, FileName);
							MidDayDeposit.MidDayDeposit(SSN, FileName);
							Void_ACHPP_CCK_2tendertypes.Void_ACHPP_CCK_2tendertypes_Checktender(SSN, FileName);

						}
					}

				}

				@Test(priority = 128, groups = "brahmith_WY_PDL")

				public void Deposit_ACR_WOR_2tender_type_MO_transaction_Void() throws Exception {

					// Start test. Mention test script name
					String FileName = "Deposit_ACR_WOR_2tender_type_MO_transaction_Void.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_brahmith");
							UserName = prop.getProperty("UserName_WY_PDL_brahmith");
							Password = prop.getProperty("Password_WY_PDL_brahmith");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_brahmith");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:59" + "_",
									"Advance =>deposit =>ACHR=>WOR with 2 tender types as MO with different numbers =>Transaction should be processed ->Void WOR with cash.");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_product.NewLoan_product(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName, 0);

							DrawerDeassign.DrawerDeassign(SSN, FileName);
							// EODProcessing.EODProcessing(SSN, FileName);
							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							NACHA.NACHA(SSN, FileName, 0);
							ACHReturnPosting.ACHReturnPosting(SSN, FileName);

							writeoff_Process.writeoff_Process(SSN, FileName, 60);
							WOR_CCK_2tendertypes.WOR_CCK_2tendertypes_DiffNumbers(SSN, FileName);

							Void_ACHPP_CCK_2tendertypes.Void_ACHPP_CCK_2tendertypes_Checktender(SSN, FileName);

						}
					}

				}

				@Test(priority = 129, groups = "brahmith_WY_PDL")

				public void Deposit_ACR_WOR_2tender_type_same_MO_transaction() throws Exception {

					// Start test. Mention test script name
					String FileName = "Deposit_ACR_WOR_2tender_type_same_MO_transaction.xls";
					TestData = new Excel(System.getProperty("user.dir")
							+ prop.getProperty("AA_Store_Test_data_WY_PDL_path_brahmith") + FileName);
					int lastrow = TestData.getLastRow("NewLoan");
					String sheetName = "NewLoan";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {
						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							AppURL = prop.getProperty("AppURL_WY_PDL_brahmith");
							UserName = prop.getProperty("UserName_WY_PDL_brahmith");
							Password = prop.getProperty("Password_WY_PDL_brahmith");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_brahmith");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:60" + "_",
									"Advance=>deposit =>ACHR=>WOR with 2 tender types as MO with same numbers =>Transaction should not be processed");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan_product.NewLoan_product(SSN, FileName);
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

						}
					}

				}

				// Chenna scenarios

				// @Test (priority=130,groups = "chenna_WY_PDL")

				public void NewLoanwithcheck_VerifycheckAmountfield() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_NewLoanwithCheck_VerifyCheckAmountfield_Txn_Testdata.xls";

					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);

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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:03" + "_" + PayFrequency + "_" + CollateralType,
									"New Loan Check disbursement => Validate whether check amount field is disabled .");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);

							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoanwithcheck_VerifyCheckAmountField.NewLoanwithcheck_VerifyCheckAmountField(SSN, FileName);
							// NewLoan.NewLoan(SSN, FileName);

						}
					}

				}

				@Test(priority = 131, groups = "chenna_WY_PDL")

				public void Deposit_ACHReturn_WORwithtendertypesCCKwithdefferentnumbers() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_Deposit_ACHReturn_WORwithtendertypesCCKwithdefferentnumbers_Txn_Testdata.xls";

					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);

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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:61" + "_" + PayFrequency + "_" + CollateralType,
									"Advance =>deposit =>ACHR=>WOR with 2 tender types as CCK with different numbers =>Transaction should be processed ->Void WOR with Original tender type.Validate screen if its displaying tender details properly");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							// NewLoan_product.NewLoan_product(SSN, FileName);
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

						}
					}

				}

				@Test(priority = 132, groups = "chenna_WY_PDL")

				public void Deposit_ACHReturn_WORwithtendertypesCCKwithsamenumbers() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_Deposit_ACHReturn_WORwithtendertypesCCKwithsamenumbers_Txn_Testdata.xls";

					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);

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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:62" + "_" + PayFrequency + "_" + CollateralType,
									"Advance =>deposit =>ACHR=>WOR with 2 tender types as CCK with same numbers =>Transaction should not be processed");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
							Login.Login(UserName, Password, StoreId);
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							// NewLoan_product.NewLoan_product(SSN, FileName);
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
							// VoidwithoriginalTendertype.VoidwithoriginalTendertypeextends(SSN,
							// FileName);

						}
					}

				}

				//				// @Test (priority=134,groups = "chenna_WY_PDL")

				public void NewLoan_Depost_Return_Redeposit_ProcessClear_Refund() throws Exception {

					// Start test. Mention test script name
					String FileName = "AA_Deposit_ACHReturn_ReDeposit_Clear_Refund_Txn_Testdata.xls";

					TestData = new Excel(
							System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);

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
							AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
							UserName = prop.getProperty("UserName_WY_PDL_chenna");
							Password = prop.getProperty("Password_WY_PDL_chenna");
							// System.out.println(Password);
							StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
							String ProductID = TestData.getCellData(sheetName, "ProductID", row);
							String StateID = TestData.getCellData(sheetName, "StateID", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);
							String Header = StateID + "_" + ProductID;
							String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
							String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
							// System.out.println(SSN);
							test = reports.startTest(Header + "_S.No:51" + "_" + PayFrequency + "_" + CollateralType,
									"Loan --> Age the store upto duedate --> perform deposit--> age perform the Prepayment--> Return posting -> Redeposit --> Process Clear=> Process refund for the excess amount paid options in store should be only cash and check.");

							// SetCurrentDate.SetCurrentDate(SSN, FileName);
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
							ACH_Prepayment_LessAmount.ACH_Prepayment_LessAmount(SSN, FileName);
							// ACHReturnPosting.ACHReturnPosting(SSN, FileName);

							AgeStore_ACHScheduledDate.AgeStore_ACHScheduledDate(SSN, FileName, 0);

							DrawerDeassign.DrawerDeassign(SSN, FileName);

							StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);

							// NACHA_ScheduleACH.NACHA_ScheduleACH(SSN, FileName, 0);
							ACH_Clear.ACH_Clear(SSN, FileName);
							ACH_ReFund.ACH_ReFund(SSN, FileName);

						}
					}

				}
	*/
	
 
	 
	
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
		/*
		 * reports = new ExtentReports(System.getProperty("user.dir") +
		 * "/ExecutionReports/CO_ILP/AA_CO_ILP_Generic Scenarios_" + timestamp +
		 * ".html", true); reports.addSystemInfo("Browser Version", "IE 11.0");
		 */
	}

	@BeforeTest(alwaysRun = true)
	public void setup_Grid() throws IOException, InterruptedException {

		

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
