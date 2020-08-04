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

public class AA_OK_ILP extends AA_ILP{

	//@Test(priority=0,groups = "pavithra_OK_ILP")

	public void Login_Homescreen_Borrower_Registration_NewLoan_verify_() throws Exception {
		String FileName= "AA_Login_Homescreen_Borrower_Registration_NewLoan_verify_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   	
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:01"+"_"+PayFrequency+"_"+CollateralType, "Login_ Home screen_ Borrower _Registration_New loan_verifyOrigination fee and MHC fee");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);


			}
		}

	}


	//@Test(priority=1,groups = "pavithra_OK_ILP")//pending

	public void Login_Homescreen_Borrower_Registration_NewLoan_Monthly() throws Exception {

		String FileName= "AA_Login_Homescreen_Borrower_Registration_NewLoan_Semi_MonthlyTestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{					
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:02"+"_"+PayFrequency+"_"+CollateralType, "Login_ Home screen_ Borrower _Registration semimonthly income frequency_New loan");
				appUrl = AppURL;


				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}
		}


	}


	//@Test(priority=2,groups = "pavithra_OK_ILP")

	public void Login_Homescreen_Borrower_Registration_NewLoan_SemiMonthly() throws Exception {

		String FileName= "AA_Login_Homescreen_Borrower_Registration_NewLoan_Monthly_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:03"+"_"+PayFrequency+"_"+CollateralType, "Login_ Home screen_ Borrower _Registration semimonthly income frequency_New loan");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName); 		        		        	        	        
			}
		}


	}

	//@Test(priority=3,groups = "pavithra_OK_ILP")

	public void Login_Homescreen_Borrower_Registration_NewLoan_BiWeekly__() throws Exception {

		String FileName= "AA_Login_Homescreen_Borrower_Registration_NewLoan_BiWeekly__TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:04"+"_"+PayFrequency+"_"+CollateralType, "Login_ Home screen_ Borrower _Registration biweekly income frequency_New loan");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);       		        	        	        
			}
		}


	}

	//@Test (priority=4,groups = "pavithra_OK_ILP")

	public void Login_Homescreen_Borrower_Registration_NewLoan_Weekly_() throws Exception {

		String FileName= "AA_Login_Homescreen_Borrower_Registration_NewLoan_Weekly_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:05"+"_"+PayFrequency+"_"+CollateralType, "Login_ Home screen_ Borrower _Registration weekly income frequency_New loan");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName); 
			}
		}


	}

	// @Test (priority=5,groups = "pavithra_OK_ILP")

	public void Login_Homescreen_Borrower_Registration_NewLoan_ACH_() throws Exception {

		String FileName= "AA_Login_Homescreen_Borrower_Registration_NewLoan_ACH_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:06"+"_"+PayFrequency+"_"+CollateralType, "Login_Homescreen_Borrower_Registration_NewLoan_ACH");
				appUrl = AppURL;

				/*SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_OHILP_AccuralDate.NewLoan_OHILP_AccuralDate(SSN, FileName,"200");*/
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);	        		        	        	        
			}
		}


	}


	//@Test (priority=6,groups = "pavithra_OK_ILP")

	public void Login_Homescreen_Borrower_Registration_NewLoan_MultiDisb_() throws Exception {

		String FileName= "AA_Login_Homescreen_Borrower_Registration_NewLoan_MultiDisb_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:07"+"_"+PayFrequency+"_"+CollateralType, "Login_ Home screen_ Borrower _Registration_select multiple disbursement types");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_MultiDisb.NewLoan_ILP_MultiDisb(SSN, FileName,"300");
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);    		        		        	        	        
			}
		}


	}

	//@Test (priority=7,groups = "pavithra_OK_ILP")		


	public void NewLoanVoid() throws Exception {

		String FileName= "AA_NewLoan_Void_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	

				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);		 

				test = reports.startTest(Header+"_S.No:8"+"_"+PayFrequency+"_"+CollateralType,"Loan– same day Void");

				Assert.assertTrue(true);
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				Void.Void(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}

		}	
	}
	//@Test (priority=8,groups = "pavithra_OK_ILP")

	public void loan_VoidEncryption() throws Exception {

		String FileName= "AA_loan_VoidEncryption_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:9"+"_"+PayFrequency+"_"+CollateralType,"Loan – void on next day with encryption key");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName,1);
				EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}       
		}


	}

	//@Test (priority=9,groups = "pavithra_OK_ILP")

	public void CO_ILP_NewLoanRescind() throws Exception {
		String FileName= "AA_NewLoan_Rescind_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);		 

				test = reports.startTest(Header+"_S.No:10"+"_"+PayFrequency+"_"+CollateralType,"Loan– Rescind");
				Assert.assertTrue(true);
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				Rescind.Rescind(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);


			}

		}

	}


	//@Test (priority=10,groups = "pavithra_OK_ILP")

	public void CO_ILP_MultipleDisbNewLoan_Void() throws Exception {
		String FileName= "AA_MultipleDisb_Void_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))

			{	

				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);		 

				test = reports.startTest(Header+"_S.No:11"+"_"+PayFrequency+"_"+CollateralType,"Loan with multiple disbursement (cash& check)->void with cash");

				Assert.assertTrue(true);
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_MultiDisb.NewLoan_ILP_MultiDisb(SSN, FileName,"300");
				Void.Void(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}

		}

	}



	//@Test (priority=11,groups = "pavithra_OK_ILP") 

	public void LonI_StoreDateafterRescindPeriod_Payment_selectpayanyotheramt_Pymtamtlessthan1stint() throws Exception {

		String FileName= "AA_LonI_StoreDateafterRescindPeriod_Payment_selectpayanyotheramt_Pymtamtlessthan1stint_Txn_TestData.xls";		 
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;      		        
				test = reports.startTest(Header+"_S.No:13"+"_"+PayFrequency+"_"+CollateralType,"Loan_age the store date to after rescind period_select payment option from CSR dropdown_Payment screen should show the follwing options  1.Pay Off the balance 2.Pay Installment Am t 3.Pay any other Amt>select pay any other amt_enter Payment amount less than 1# amount");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);			        
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -6);				
				Payment_LessthanAmount.Payment_LessthanAmount(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}
		}

	}


	//@Test (priority=12,groups = "pavithra_OK_ILP") //Run scenario.scenario with store date need to check again for the date

	public void LonI_RunEODbatchon1Instduedate_Payment_PayPastDue_NextInstallment() throws Exception {

		String FileName= "AA_LonI_RunEODbatchon1Instduedate_Payment_PayPastDue_NextInstallment_Txn_TestData.xls";	

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;      		        
				test = reports.startTest(Header+"_S.No:14"+"_"+PayFrequency+"_"+CollateralType,"Loan>Run EOD batch process on 1# due date>Run again EOD batch process from 10th day of 1# due date>Payment(past due +installment amount");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);			        
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0,2);  //brahmith changed the arguments
				Customer_Status.Customer_Status(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 1, 2);
				Payment_Pastdue_NextInst.Payment_Pastdue_NextInst(SSN, FileName);				
				Customer_Status.Customer_Status(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}
		}

	}


	//@Test (priority=13,groups = "pavithra_OK_ILP") //Run scenario.scenario with store date need to check again for the date

	public void LonI_RunEODbatchon1Instduedate_AgainEODbatchfrom10thdayof1stInstduedate_Payment_Pastdue_1stInstamt() throws Exception {

		String FileName= "AA_LonI_RunEODbatchon1Instduedate_AgainEODbatchfrom10thdayof1stInstduedate_Payment_Pastdue_Pymtamt_Txn_TestData.xls";		 
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;      		        
				test = reports.startTest(Header+"_S.No:15"+"_"+PayFrequency+"_"+CollateralType,"Loan>Run EOD batch process on 1# due date>Run again EOD batch process from 10th day of 1# due date>Payment(past due +installment amount");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);			        
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0,2);   //brahmith changed the arguments
				Customer_Status.Customer_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10,2); //brahmith changed the arguments
				Payment_2ndEODbatchprocess.Payment_2ndEODbatchprocess(SSN, FileName);
				Customer_Status.Customer_Status(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}
		}

	}





	//@Test (priority=14,groups = "pavithra_OK_ILP") //Run scenario.scenario with store date need to check again for the date

	public void LonI_StoreDateafterRescindPeriod_Payment_selectpayanyotheramt_Pymtamtlessthan1stint_VoidPymt() throws Exception {

		String FileName= "AA_LonI_StoreDateafterRescindPeriod_Payment_selectpayanyotheramt_Pymtamtlessthan1stint_VoidPymt_Txn_TestData.xls";		 
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;      		        
				test = reports.startTest(Header+"_S.No:16"+"_"+PayFrequency+"_"+CollateralType,"Loan_age the store date to after rescind period_select payment option from CSR dropdown_Payment screen should show the follwing options  1.Pay Off the balance 2.Pay Installment Am t 3.Pay any other Amt>select pay any other amt_enter Payment amount less than 1# amount");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);			        
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -6);				
				Payment_LessthanAmount.Payment_LessthanAmount(SSN, FileName);
				Void_Payment.Void_Payment(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}
		}

	}






	//@Test (priority=15,groups = "pavithra_OK_ILP") 

	public void LonI_RunEODbatchon1Instduedate_AgainEODbatchfrom10thdayof1stInstduedate_Payment_Pastdue_1stInstamt_Void() throws Exception {

		String FileName= "AA_LonI_RunEODbatchon1Instduedate_AgainEODbatchfrom10thdayof1stInstduedate_Payment_Pastdue_1stInstamt_Void_Txn_TestData.xls";		

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	

				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;      		        
				test = reports.startTest(Header+"_S.No:18"+"_"+PayFrequency+"_"+CollateralType,"Loan>Run EOD batch process on 1# due date>Run again EOD batch process from 10th day of 1# due date>Payment(past due +installement amount)>void payment on next day");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);			        
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				Customer_Status.Customer_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				Payment_2ndEODbatchprocess.Payment_2ndEODbatchprocess(SSN, FileName);
				Customer_Status.Customer_Status(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 12, 2);
				Payment_EncryptionKey_Void.Payment_EncryptionKey_Void(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);


			}
		}

	}





        // @Test (priority=16,groups = "pavithra_OK_ILP")//testdata problem

	public void Loan_Deposit_Rtn_paymentLessthanLoanAmount() throws Exception {

		String FileName= "AA_Loan_Deposit_Rtn_paymentLessthanLoanAmount_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			{	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:19"+"_"+PayFrequency+"_"+CollateralType,"Loan_1# deposit_rtn_payment(less than 1# amount)");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Payment_LessthanAmount.Payment_LessthanAmount(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}       
		}


	}




	//@Test (priority=17,groups = "pavithra_OK_ILP")

	public void Loan_Deposit_Rtn_paymentGreaterthanLoanAmount() throws Exception {

		String FileName= "AA_Loan_Deposit_Rtn_paymentGreaterthanLoanAmount.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;		     
				test = reports.startTest(Header+"_S.No:20"+"_"+PayFrequency+"_"+CollateralType,"Loan_1# deposit_rtn_payment(greaterthan 1# amount)");
				appUrl = AppURL;
			       SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				inst1_AgeStore.inst1_AgeStore(SSN, FileName, 0);
				Payment_gaterthanAmount.Payment_gaterthanAmount(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}       
		}


	}



	//@Test (priority=18,groups = "pavithra_OK_ILP")

	public void Loan_Deposit_RTN_EODBatchon10days_PaymentGeterthanLoanAmount() throws Exception {


		String FileName= "AA_Loan_Deposit_RTN_EODBatchon10days_PaymentGeterthanLoanAmount_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   

		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	

				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:21"+"_"+PayFrequency+"_"+CollateralType, "Loan_1# deposit_rtn_Run EOB batch process from 10th day of due date_payment(greater  than 1# amount)");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);

				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				Payment_gaterthanAmount.Payment_gaterthanAmount(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}
		}

	}


	//@Test (priority=19,groups = "pavithra_OK_ILP") 

	public void LonI_1stInstdeposit_return_Payment_lessthan1stInstamount_VoidPayment() throws Exception {

		String FileName= "AA_LonI_1stInstdeposit_return_Payment_lessthan1stInstamount_VoidPayment_Txn_TestData.xls";		 
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;      		        
				test = reports.startTest(Header+"_S.No:22"+"_"+PayFrequency+"_"+CollateralType,"Loan>default>Run EOD batch process(default date+60 days)");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);			        
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				//Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1, 2);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName); 
				Payment_LessthanAmount.Payment_LessthanAmount(SSN, FileName);
				Void_Payment.Void_Payment(SSN, FileName);
				Customer_Status.Customer_Status(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}
		}

	}



	//@Test (priority=20,groups = "pavithra_OK_ILP")

	public void Loan_Deposit_Rtn_paymentLessthanLoanAmount_Void() throws Exception {

		String FileName= "AA_Loan_Deposit_Rtn_paymentLessthanLoanAmount_Void_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:23"+"_"+PayFrequency+"_"+CollateralType,"Loan_1# deposit_rtn_payment(greater  than 1# amount)_void payment on next day  (Encryption key issue)");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Payment_gaterthanAmount.Payment_gaterthanAmount(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName,1);
				Payment_EncryptionKey_Void.Payment_EncryptionKey_Void(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}       
		}


	}



	@Test (priority=21,groups = "pavithra_OK_ILP")

	public void Loan_1stDep_Ret_EODBatch10daysDueDate_PmtGreaterthanInstAmt_Void_() throws Exception {

		String FileName= "AA_Loan_1stDep_Ret_EODBatch10daysDueDate_PmtGreaterthanInstAmt_Void_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:24"+"_"+PayFrequency+"_"+CollateralType, "Loan_1# deposit_rtn_Run EOB batch process from 10th day of due date>payment(greater  than 1# amount)_Void");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 2);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				PayAnyAmt_Installments.PayAnyAmt_Installments(SSN, FileName);
				PayAny_Void.PayAny_Void(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}
		}


	}

	@Test(priority = 22,groups = "pavithra_OK_ILP")
	public void Loan_PaymentinCSRPortel() throws Exception {
		String FileName = "AA_Loan_Payments_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {				// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:25" + "_" + PayFrequency + "_" + CollateralType,"Loan>select payment option from CSR dropdown> Payment screen ");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -5);
				Payoff.Payoff(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}
		}

	}

	@Test	(priority =23,groups = "pavithra_OK_ILP")
	public void AA_Loan_1stInstallmentPayments() throws Exception {

		String FileName = "AA_Loan_1stInstallmentPayments_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:26" + "_" + PayFrequency + "_" + CollateralType,"Loan>1# payment on due date>payoff");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 0);
				Payoff.Payoff(SSN, FileName);
				//  History_Paymentcaluculation.History_Paymentcaluculation(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}
		}

	}

	@Test(priority = 24,groups = "pavithra_OK_ILP")
	public void Loan_PaymentinCSRPortel_Void() throws Exception {
		String FileName = "AA_Loan_Payment_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:28" + "_" + PayFrequency + "_" + CollateralType,"Loan>select payment option from CSR dropdown> Payment screen should show the follwing options  1.Pay Off the balance 2.Pay Installment Am t3.Pay any other Amt>select payoff balance>Enter amount>");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -5);
				Payoff.Payoff(SSN, FileName);
				PayAny_Void.PayAny_Void(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);  

			}
		}

	}

	@Test(priority = 25,groups = "pavithra_OK_ILP") //Dubilecate
	public void AA_Loan_1stInstallmentPayments_Void() throws Exception {

		String FileName = "AA_Loan_1stInstallmentPayments_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:29" + "_" + PayFrequency + "_" + CollateralType,"Loan>1# payment on due date>void>payoff>void");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 0);
				Payment_ILP.Payment_ILP(SSN, FileName);
				PayAny_Void.PayAny_Void(SSN, FileName);
				Payoff.Payoff(SSN, FileName);
				PayAny_Void.PayAny_Void(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}
		}

	}

	@Test (priority=26,groups = "pavithra_OK_ILP")

	public void Loan_Pmt1stInstdate_Pmt2ndInstdate_void_EODBatch10days2Inst_payoff_() throws Exception {

		String FileName= "AA_Loan_Pmt1stInstdate_Pmt2ndInstdate_void_EODBatch10days2Inst_payoff_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	

				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:30"+"_"+PayFrequency+"_"+CollateralType, "Loan_1# payment on due date_2#payment on due date_void_run EOD batch process on 10th day of 2# _payoff_(consider loan has only three installements)_void");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				Payment_ILP.Payment_ILP(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				Payment_ILP.Payment_ILP(SSN, FileName);	
				PayAny_Void.PayAny_Void(SSN, FileName);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 10, 3);
				Payoff_Installments.Payoff_Installments(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				PayAny_Void.PayAny_Void(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);   	        	        
			}
		}


	}

	@Test (priority=27,groups = "pavithra_OK_ILP")

	public void Loan_Deposit_Rtn_payoff() throws Exception {

		String FileName= "AA_Loan1stInsatallmentDeposit_Return_Payoff_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	

				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:31"+"_"+PayFrequency+"_"+CollateralType,"Loan>1#depsoit >rtn>payoff>");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 8);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Payoff_Return.Payoff_Return(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}       
		}


	}


	@Test (priority=28,groups = "pavithra_OK_ILP")

	public void Loan_Deposit_Rtn_clear_2InstDeposit_Return_EODBatchprocess_payoff() throws Exception {
		String FileName= "AA_Loan1stInsatallmentDeposit_2ndInstDeposit_Return_EodBatch_3rdInst_Payoff_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	

				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:32"+"_"+PayFrequency+"_"+CollateralType,"Loan>1#deposit >clr>2# dep>rtn>run EOD batch process on 10th from 2# due date>payoff>age the store date to one day before 3# due date(banking day)>run EOD");
				appUrl = AppURL;
				SetDate.SetDate(SSN, FileName, "01", "19", "2020");
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
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
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}       
		}


	}	



	@Test (priority=29,groups = "pavithra_OK_ILP")

	public void Loan_Deposit_Rtn_Payoff_Void() throws Exception {

		String FileName= "AA_Loan1stInsatallmentDeposit_Return_Payoff_void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	

				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:33"+"_"+PayFrequency+"_"+CollateralType,"Loan>1#depsoit >rtn>payoff>void");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, 8);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Payoff.Payoff(SSN, FileName);
				
				PayAny_Void.PayAny_Void(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}       
		}
	}

	@Test (priority=30,groups = "pavithra_OK_ILP")

	public void Loan_DepositACH_() throws Exception {

		String FileName= "AA_Loan_DepositACH_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:35"+"_"+PayFrequency+"_"+CollateralType, "Loan_age the store date to one day before 1# due date(banking day)_Run EOD process_Run payliance origination file_Process depsoit on due by clicking on Process ILP pre ach depsoits");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}
		}

	}

	@Test (priority=31,groups = "pavithra_OK_ILP")

	public void Loan_1stInstpartialpayment_1stInstdeposit_() throws Exception {

		String FileName= "AA_Loan_1stInstpartialpayment_1stInstdeposit_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:36"+"_"+PayFrequency+"_"+CollateralType, "Loan_1st Inst partial payment_1st Inst deposit");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);

				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				PartialPayment.PartialPayment(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing_RecordVerify.StatementGeneration_EODProcessing_RecordVerify(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}
		}


	}

	/*@Test(priority = 32,groups = "pavithra_OK_ILP")// No deposit after ACH revoke
	public void AA_Loan_ACHRevoke_1stInsatallmentDeposit() throws Exception {

		String FileName = "AA_Loan_ACHRevoke__1stInsatllmentDeposit_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:38" + "_" + PayFrequency + "_" + CollateralType,"Loan>ach revoke >1# deposit");
				appUrl = AppURL;


				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				ACH_Revoke.ACH_Revoke(SSN, FileName);
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);   
			}
		}

	}

*/

	@Test(priority = 33,groups = "pavithra_OK_ILP")
	public void AA_Loan_ACHRevoke_1stInsatallmentPayment_ACHAuthorization_2ndIsatallmentDeposit() throws Exception {

		String FileName = "AA_Loan_ACHRevoke__1stInsatllmentPayment_ACHAuthorigation_ACHDeposit_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {							// driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:39" + "_" + PayFrequency + "_" + CollateralType,"Loan>ach revoke >1# payment>ach auth>2# deposit");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
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
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}
		}

	}
	


	@Test (priority=34,groups = "pavithra_OK_ILP")

	public void CO_ILP_Loan_Instwisepayment_last_deposit() throws Exception {
		String FileName= "AA_Loan_Instwisepayment_LastInst_deposit_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	

				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);		 

				test = reports.startTest(Header+"_S.No:40"+"_"+PayFrequency+"_"+CollateralType,"Loan>payment all the installements acc to respective due dates except last installement>last # deposit");

				Assert.assertTrue(true);
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				installmentPayment.installmentPayment(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				installmentPayment.installmentPayment(SSN, FileName);
				/*AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 4);
				installmentPayment.installmentPayment(SSN, FileName);*/
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 4);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}

		}	
	}

	@Test (priority=35,groups = "pavithra_OK_ILP")

	public void Loan_1stInstDeposit_Rtn() throws Exception {

		String FileName= "AA_Loan_1stInsatallmentDeposit_Return_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		System.out.println(lastrow);

		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	

				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:41"+"_"+PayFrequency+"_"+CollateralType,"Laon>1# deposit>Return");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore.AgeStore(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}       
		}


	}	


	@Test (priority=36,groups = "pavithra_OK_ILP")

	public void Loan_1stParPmt_1stDep_Ret_() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_1stParPmt_1stDep_Ret_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:42"+"_"+PayFrequency+"_"+CollateralType, "Loan_1# partial payment_1# deposit_Return");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -6, 2);
				PayAnyAmt_Installments_FL_ILP.PayAnyAmt_Installments_FL_ILP(SSN, FileName,"15");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);  		        		        	        	        
			}
		}


	}		

	@Test (priority=37,groups = "pavithra_OK_ILP1")

	public void Loan_PaymentallInstOnduedate_ExceptLastInst_LastDeposit_Return() throws Exception {

		String FileName= "AA_Loan_PaymentallInstOnduedate_ExceptLastInst_LastDeposit_Return_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	

				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:43"+"_"+PayFrequency+"_"+CollateralType,"Loan_payment all the installements acc to respective due dates except last installement_last # deposit_Return");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				Payment_Inst_Amount.Payment_Inst_Amount(SSN, FileName, 2);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				Payment_Inst_Amount.Payment_Inst_Amount(SSN, FileName, 3);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 4);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				Check_Payment.Check_Payment(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);    

			}       
		}


	}


	@Test(priority=38,groups = "pavithra_OK_ILP1")
	public void AA_Loan_ACHRevoke_1stInsatallmentDeposit_Clear() throws Exception {

		String FileName = "AA_Loan_ACHRevoke__1stInsatllmentDeposit_Clear_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
				String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String Header = StateID + "_" + ProductID;
				test = reports.startTest(Header + "_S.No:44" + "_" + PayFrequency + "_" + CollateralType,"Laon>1# deposit>Clear");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_1stInstallment.AgeStore_1stInstallment(SSN, FileName, -1);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);  
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 8, 2);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
			}
		}

	}	


	@Test (priority=39,groups = "pavithra_OK_ILP1") 

	public void Loan_PmtAllExceptLast_DepLast_Clear_Return_() throws Exception {

		String FileName= "AA_Loan_PmtAllExceptLast_DepLast_Clear_Return_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{			
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:45"+"_"+PayFrequency+"_"+CollateralType, "Loan>payment all the installements acc to respective due dates except last installement>last # deposit>clear>Return");
				appUrl = AppURL;

				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 2);
				Payment_ILP.Payment_ILP(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, 0, 3);
				Payment_ILP.Payment_ILP(SSN, FileName);		
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 4);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				//Payliance_OriginationFile.Payliance_OriginationFile(SSN, FileName, -1,4);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 8, 4);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);

			}
		}
	}
	@Test (priority=40,groups = "pavithra_OK_ILP1")  

	public void Loan_1stdeposit_clr_payoff_clear_return_() throws Exception {

		String FileName= "AA_Loan_1stdeposit_clr_payoff_clear_return_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_OK_ILP_path_kiran") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_OK_ILP_kiran");
				UserName = prop.getProperty("UserName_OK_ILP_kiran");
				Password = prop.getProperty("Password_OK_ILP_kiran");
				StoreId = prop.getProperty("StoreID_OK_ILP_kiran");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:46"+"_"+PayFrequency+"_"+CollateralType, "Loan_1# deposit_clr_payoff_clear return");
				appUrl = AppURL;
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName, Password, StoreId);
				RegistrationPage_NewLoan_ILP.RegistrationPage_NewLoan_ILP(driver, test, AppURL, SSN, FileName);
				NewLoan_ILP_Prod.NewLoan_OK_ILP_Prod(SSN, FileName, "300");
				AgeStore_ILP.AgeStore_ILP(SSN, FileName, -1, 2);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				REPAY_NACHA.REPAY_NACHA(SSN, FileName, 0);
				ACH_Deposit1.ACH_Deposit1(SSN, FileName, 0);
				EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 9, 2);
				Payoff_Installments.Payoff_Installments(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				ACHReturnPosting.ACHReturnPosting(SSN, FileName);
				Loan_Balance_Status.Loan_Balance_Status(SSN, FileName);
				//HistoryFieldValidation_ILP.HistoryFieldValidation_ILP(SSN, FileName);
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
