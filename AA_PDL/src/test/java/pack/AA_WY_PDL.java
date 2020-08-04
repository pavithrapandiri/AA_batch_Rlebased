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
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					
					test = reports.startTest(Header+"Scenario_No_01"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan");					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);				
					NewLoan_WY.NewLoan_WY(SSN, FileName);
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
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					//test = reports.startTest("S.NO:02:BorrowerRegistration_NewLoan_Rule"+Header, "New Loan_Maximum Open Loan");
					
					test = reports.startTest(Header+"Scenario_No_02"+"_"+PayFrequency+"_"+CollateralType,"Login-->customer having already having Open Loan-->perform New Loan(depends on rule )");
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					//NewLoan.NewLoan(SSN, FileName);
					NewLoan_WY.NewLoan_WY(SSN, FileName);
					NewLoanRule.NewLoanRule(SSN, FileName);
				}
			}
		}

      // @Test(priority=2,groups = "chenna_WY_PDL")

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
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					
					test = reports.startTest(Header+"Scenario_No_03"+"_"+PayFrequency+"_"+CollateralType,"Borrower -> PayFrequency (Bi Weekly) -> New Loan ->Check Due Date for Min Term");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);			
					//NewLoan.NewLoan(SSN, FileName);
					NewLoan_WY.NewLoan_WY(SSN, FileName);
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
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					
					test = reports.startTest(Header+"Scenario_No_04"+"_"+PayFrequency+"_"+CollateralType,"Borrower -> PayFrequency (Monthly) -> New Loan ->Check Due Date for Min Term");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan_WY.NewLoan_WY(SSN, FileName);
					Monthly_duedate.Monthly_duedate(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");
		}


         // @Test (priority=4,groups = "chenna_WY_PDL") // Semi monthly has issue with loandate and duedate, so Not executing scenario.scenario , Not Ran in Staging

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
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					
					test = reports.startTest(Header+"Scenario_No_05"+"_"+PayFrequency+"_"+CollateralType,"Borrower -> PayFrequency (SemiMonthly) -> New Loan ->Check Due Date for Min Term");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					//NewLoan.NewLoan(SSN, FileName);
					NewLoan_WY.NewLoan_WY(SSN, FileName);
					semimonthly_duedate.semimonthly_duedate(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");
		}
	 
        //  @Test(priority=5,groups = "chenna_WY_PDL")

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
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					
					test = reports.startTest(Header+"Scenario_No_06"+"_"+PayFrequency+"_"+CollateralType,"Borrower -> PayFrequency (Weekly) -> New Loan ->Check Due Date for Min Term");


					Login.Login(UserName,Password,StoreId);			
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					//NewLoan.NewLoan(SSN, FileName);
					NewLoan_WY.NewLoan_WY(SSN, FileName);
					Weekly_duedate.Weekly_duedate(SSN, FileName);

	              }
			}

		}

    // @Test(priority=6,groups = "chenna_WY_PDL")

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

             @Test(priority=7,groups = "chenna_WY_PDL")

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
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					
					test = reports.startTest(Header+"Scenario_No_07"+"_"+PayFrequency+"_"+CollateralType,"Newloan with multiple disbursements like check& cash--> check whether loan is processedsmoothly .");
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
				}
			}
		}
             
             
          // @Test(priority=7,groups = "chenna_WY_PDL")

             public void Newloan_Checking_CheckEligibleInMultipullDisb() throws Exception
             {
             	String FileName= "AA_Newloan_Checking_CheckEligibleInMultipullDisb.xls";
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
             			String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
    					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
             			String Header = StateID+ "_" + ProductID;
             			
             			test = reports.startTest(Header+"Scenario_No_08"+"_"+PayFrequency+"_"+CollateralType,"New Loan Check disbursement => Validate whether check amount field is disabled .");
             			
             			Login.Login(UserName,Password,StoreId);				
    					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
             			NewLoan_MultiDisb_CheckAmountField_Validation.NewLoan_MultiDisb_CheckAmountField_Validation(SSN, FileName);
             		}
             	}
             }


            // @Test(priority = 8, groups = "chenna_WY_PDL") // completed
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
TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
	StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
String ProductID = TestData.getCellData(sheetName, "ProductID", row);
String StateID = TestData.getCellData(sheetName, "StateID", row);
String SSN = TestData.getCellData(sheetName, "SSN", row);
String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
String Header = StateID + "_" + ProductID;
// System.out.println(SSN);
test = reports.startTest(Header+"Scenario_No_09"+"_"+PayFrequency+"_"+CollateralType,"Register Any Payfrequency customer which does not satisfy Minterm --> verify whether loan due date is moved as payfrequency according to the date selected .");

// SetCurrentDate.SetCurrentDate(SSN, FileName);
Login.Login(UserName, Password, StoreId);

RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL1(driver, test, AppURL, SSN, FileName);
//NewLoan.NewLoan(SSN, FileName);
NewLoan_WY.NewLoan_WY(SSN, FileName);
DueDate_Check.DueDate_Check(SSN, FileName);

}
}

}
             
             
             

       //@Test(priority=9,groups = "chenna_WY_PDL")

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
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

					test = reports.startTest(Header+"Scenario_No_10"+"_"+PayFrequency+"_"+CollateralType,"Loan– same day Void");
					
									
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					//NewLoan.NewLoan(SSN, FileName);
					NewLoan_WY.NewLoan_WY(SSN, FileName);
					Void.Void(SSN, FileName);
				
				}
			}
			
		}


         // @Test(priority=10,groups = "chenna_WY_PDL")

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
					//NewLoan.NewLoan(SSN, FileName);
					NewLoan_WY.NewLoan_WY(SSN, FileName);
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,3);
					EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");

		}
		
		
		// @Test(priority=11,groups = "chenna_WY_PDL")

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
		
	 // @Test(priority=12,groups = "chenna_WY_PDL")

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
		
			  //@Test(priority=13,groups = "chenna_WY_PDL")
			  
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
							NewLoan_WY.NewLoan_WY(SSN, FileName);
							Void.Void(SSN, FileName);
							
						}
					}
					//Login.Login("CSR353","1234","353");

				}
		
		

     //@Test (priority=14,groups = "chenna_WY_PDL") 

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
					/*RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					//NewLoan.NewLoan(SSN, FileName);
					NewLoan_WY.NewLoan_WY(SSN, FileName);*/
					Rescind.Rescind(SSN, FileName);
					
				}
			}


		}

        @Test(priority=15,groups = "chenna_WY_PDL1")

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
					/*RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,1);*/
					Rescind.Rescind(SSN, FileName);


				}
			}

		}
		
		
//		@Test (priority=16,groups = "chenna_WY_PDL")

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
							String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
							String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
							String Header = StateID+ "_" + ProductID;
							//test = reports.startTest("S.NO:18:AEA_NewLoan_Agestore_BuybackLoan_Txn"+Header, "AEA_NewLoan_Agestore_BuybackLoan_Txn");
							test = reports.startTest(Header + "_S.No:19" + "_" + PayFrequency + "_" + CollateralType,"Loan--Age the store--Perform the Buyback");
							Login.Login(UserName,Password,StoreId);
							
							RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
							NewLoan.NewLoan(SSN, FileName);
							AgeStore.AgeStore(SSN, FileName,-4);
							Buyback_Cash.Buyback_Cash(SSN, FileName);
						}
					}
				}
		
		
		
		@Test (priority=18,groups = "chenna_WY_PDL")

		public void NewLoan_Buyback_freeze_veirfy() throws Exception {

			String FileName = "AA_Partialpayment_MO_Dif_EODDeposit_CashVoid_Txn_freeze_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_anji") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");

					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					
					
					test = reports.startTest(Header + "_S.No:20" + "_" + PayFrequency + "_" + CollateralType,"Advance => Buyback => Check whether screen is been freezed with message as Transaction under procesing.This is been fixed to avoid duplicate for buyback transaction");
					// SetCurrentDate.SetCurrentDate(SSN, FileName);
					Login.Login(UserName, Password, StoreId);
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -2);
					Buyback_freeze.Buyback(SSN, FileName);
					//Buyback_Verifacation.Buyback_Verifacation(SSN, FileName);

				}
			}

		}
		
		
		@Test(priority = 19, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_Advance_Buyback2tendertypeAs_DiffNum_TranssionShouldBeprocessed.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:21" + "_" + PayFrequency + "_" + CollateralType,
							"Advance_Buyback with 2 tender types as MO with different numbers_Transaction should be processed");

					Login.Login(UserName, Password, StoreId);

					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 5);
					BuyBack_MO_With2tendertypes_Withdiffnumbers.BuyBack_MO_With2tendertypes_Withdiffnumbers(SSN, FileName);

				}
			}
		}
		
		
		
		
		
		
		
		@Test(priority = 20, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_2Tendertype_Mo_SameNum_TranssionShouldnotbeprocessed() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_Mo_SameNum_TranssionShouldnotbeprocessed.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:22" + "_" + PayFrequency + "_" + CollateralType,
							"Advance_Buyback with 2 tender types as MO with same numbers_Transaction should not be processed");

					Login.Login(UserName, Password, StoreId);

					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 5);
					BuyBack_MO_With2tendertypes_WithSamenumbers.BuyBack_MO_With2tendertypes_WithSamenumbers(SSN, FileName);

				}
			}
		}
		
		
		@Test(priority = 21, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:23" + "_" + PayFrequency + "_" + CollateralType,
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
		
		
			
		
		
		@Test(priority =22, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_2Tendertype_CCK_SameNum_TranssionShouldnotbeprocessed() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_CCK_SameNum_TranssionShouldnotbeprocessed.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:24" + "_" + PayFrequency + "_" + CollateralType,
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

		@Test(priority = 23, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_2Tendertype_CashTranssionShouldnotbeprocessed() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_Cash_TranssionShouldnotbeprocessed.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:25" + "_" + PayFrequency + "_" + CollateralType,
							"Advance_Buyback with 2 tender types as Cash_Transaction should not be processed");

					Login.Login(UserName, Password, StoreId);

					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 5);
					BuyBack__2tendertypes_With_Cash.BuyBack__2tendertypes_With_Cash(SSN, FileName);

				}
			}
		}
		
		
		@Test(priority=24,groups = "chenna_WY_PDL")

		public void BuyBack_Void() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_BuybackLoan_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {

					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					//test = reports.startTest("_S.NO:26" + Header, "Void_Txn");
					test = reports.startTest(Header + "_S.No:26" + "_" + PayFrequency + "_" + CollateralType,"Loan--Age the store--Perform the Buyback  ->void on same day");

					Login.Login(UserName, Password, StoreId);
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 0);
					Buyback.Buyback(SSN, FileName);
					BuybackVoid.BuybackVoid(SSN, FileName);
				}
			}
		}

		@Test (priority=25,groups = "chenna_WY_PDL")

		public void Byback_agestore_void() throws Exception {
			String FileName = "AA_Byback_Agestore_void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:27" + "_" + PayFrequency + "_" + CollateralType,"Loan--Age the store--Perform the Buyback--Void on next day ");
					Login.Login(UserName, Password, StoreId);
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 0);
					Buyback.Buyback(SSN, FileName);
					AgeStore_Buyback_encryptionKeyVoid.AgeStore_Buyback_encryptionKeyVoid(SSN, FileName, 1);
					Byback_AgestoreVoid.Byback_AgestoreVoid(SSN, FileName);
				}
			}
		}
		
		
		@Test(priority=26,groups = "chenna_WY_PDL")

		public void VerifyBuyBack_TotalDue() throws Exception {
			String FileName = "AA_VerifyBuyBack_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:28" + "_" + PayFrequency + "_" + CollateralType,"loan->verify buyback should accept only total due");

					Login.Login(UserName, Password, StoreId);

					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 0);
					Buyback.Buyback(SSN, FileName);
				}
			}
		}
		
		
		@Test(priority = 27, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:29" + "_" + PayFrequency + "_" + CollateralType,
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
		
		@Test(priority = 28, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidwithCash()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidwithCash.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:30" + "_" + PayFrequency + "_" + CollateralType,
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
		
		@Test(priority = 29, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:31" + "_" + PayFrequency + "_" + CollateralType,
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
		
		@Test(priority = 30, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithOriginalTender.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:32" + "_" + PayFrequency + "_" + CollateralType,
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
		
		@Test(priority = 31, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithCash()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackVoidWithCash.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:33" + "_" + PayFrequency + "_" + CollateralType,
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
		
		@Test(priority = 32, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_CCK_2Tendertype_DiffNum_TranssionShouldBeprocessed_BuyBackNextProcessingday_OnlyCashshouldbeAvalible.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:34" + "_" + PayFrequency + "_" + CollateralType,
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
		
		
		@Test(priority = 33, groups = "chenna_WY_PDL")

		public void NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_MiddayDeposit_BuyBackVoid() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_AgeStore_BuyBack_2Tendertype_DiffNum_MiddayDeposit_BuyBackVoid.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:35" + "_" + PayFrequency + "_" + CollateralType,
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
		
		
		@Test (priority=34,groups = "chenna_WY_PDL")

		public void Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateMidDayDeposit_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_WY_PDL_Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateMidDayDeposit_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay_Txn_Testdata.xls";

			// Start test. Mention test script name
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:36" + "_" + PayFrequency + "_" + CollateralType,
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
		
		
		
		//@Test (priority=35,groups = "chenna_WY_PDL")

		public void Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateEOD_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay()
				throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_WY_PDL_Advance_BuyBackWithtwotendertypesasCCKwithDifferentNumbers_TransactionShouldProcess_DrawerDeAssign_ValidateEOD_deposit_MidDayDeposit_VoidBuyBackCashOnlyDisplay_Txn_Testdata.xls";

			// Start test. Mention test script name
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = prop.getProperty("ProductID");
					String StateID = prop.getProperty("StateID");
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:37" + "_" + PayFrequency + "_" + CollateralType,
							"Advance =>Buyback with 2 tender types as CCK with different numbers =>Transaction should be processed =>deassign drawer =>Validate they are available for eod deposit.Process Mid day deposit =>Void Buyback Only cash should be displayed.");

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
		
		//@Test(priority=36,groups = "chenna_WY_PDL")
		public void NewLoan_PartialPayment() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_Newloan_PartialPayment_Txn_TestData.xls";
			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					AppURL = prop.getProperty("AppURL_WY_PDL_chenna");
					UserName = prop.getProperty("UserName_WY_PDL_chenna");
					Password = prop.getProperty("Password_WY_PDL_chenna");
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:38" + "_" + PayFrequency + "_" + CollateralType,
							"New Loan _ Age store up to some days before due datE _ Partial Payment");

					//test = reports.startTest("AEA_Newloan_PartialPayment_Txn_" + Header, "AEA_Newloan_PartialPayment_Txn");

					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -6);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);

				}
			}
			// Login.Login("CSR353","1234","353");

		}

		//@Test (priority=37,groups = "chenna_WY_PDL")

		public void CheckingPartialPmt_SomeDaysAfterDueDate() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_CheckingPartialPmt_SomeDaysAfterDueDate_Txn_Testdata.xls";
			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:39" + "_" + PayFrequency + "_" + CollateralType,
							"New Loan _ Age store up to some days after due date _ Check Partial Payment transaction is displayed or not");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 5);
					CheckPartialPayment.CheckPartialPayment(SSN, FileName);

				}
			}

		}
		
		//@Test(priority=38,groups = "chenna_WY_PDL")

		public void PartialPayment_MultipleTenderTypes() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes.xls";
			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:40" + "_" + PayFrequency + "_" + CollateralType,
							"Loan _ partial payment with multiple tender types _ check updates");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -5);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender(SSN, FileName);
					check_updates.check_updates(SSN, FileName);

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		//@Test(priority=39,groups = "chenna_WY_PDL")

		public void PartialPayment_MultipleTenderTypes_MO() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_MO.xls";
			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:41" + "_" + PayFrequency + "_" + CollateralType,
							"Advance _ Partial Pay with 2 tender types as MO with different numbers _ Transaction should be processed");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -5);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_MO(SSN, FileName);
					check_updates.check_updates(SSN, FileName);

				}
			}
			// Login.Login("CSR353","1234","353");

		}





		//@Test(priority=40,groups = "chenna_WY_PDL")

		public void PartialPayment_MultipleTenderTypes_MO_Same() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_MO_same.xls";
			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:42" + "_" + PayFrequency + "_" + CollateralType,
							"Advance _ Partial Pay with 2 tender types as MO with same numbers _ Transaction should not  be processed");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -5);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_MO_Same(SSN, FileName);
					//check_updates.check_updates(SSN, FileName);

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		//@Test(priority=41,groups = "chenna_WY_PDL")

		public void PartialPayment_MultipleTenderTypes_CCK() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_MO.xls";
			String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_CCK.xls";

			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:43" + "_" + PayFrequency + "_" + CollateralType,
							"Advance _ Partial Pay with 2 tender types as CCK with different numbers _ Transaction should be processed");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -5);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_CCK(SSN, FileName);
					//check_updates.check_updates(SSN, FileName);

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		//@Test(priority=42,groups = "chenna_WY_PDL")

		public void PartialPayment_MultipleTenderTypes_CCK_Same() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_MO_same.xls";
			String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_CCK_same.xls";

			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:44" + "_" + PayFrequency + "_" + CollateralType,
							"Advance _ Partial Pay with 2 tender types as CCK with same numbers _ Transaction should  not be processed");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -5);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_CCK_Same(SSN, FileName);
					//check_updates.check_updates(SSN, FileName);

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		//@Test(priority=43,groups = "chenna_WY_PDL")

		public void PartialPayment_MultipleTenderTypes_CashasTwoTenders() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_MO_same.xls";
			String FileName = "AA_PartialPayment_MultipleTenderTypes_CashasTwoTenders.xls";

			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:45" + "_" + PayFrequency + "_" + CollateralType,
							"Advance _ Partial Pay with 2 tender types as Cash  _ Transaction should not be processed");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -5);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_Cash(SSN, FileName);
					//check_updates.check_updates(SSN, FileName);

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		//@Test(priority=44,groups = "chenna_WY_PDL")
		public void NewLoan_PartialPayment_Void() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_PartialPayment_Void_Txn_TestData.xls";
			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:46" + "_" + PayFrequency + "_" + CollateralType,
							"New Loan _ Age store up to some days before due datE _ Partial Payment_Void");

					//test = reports.startTest("AEA_Newloan_PartialPayment_Txn_" + Header, "AEA_Newloan_PartialPayment_Txn");

					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -4);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);
					PartialPayment_Void_WY.PartialPayment_Void_WY(SSN, FileName);

				}
			}
			// Login.Login("CSR353","1234","353");

		}


		//@Test(priority=45,groups = "chenna_WY_PDL")
		public void NewLoan_PartialPayment_VoidEncryption() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_PartialPayment_VoidEncryption_Txn_TestData.xls";
			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:47" + "_" + PayFrequency + "_" + CollateralType,
							"New Loan _ Age store up to some days before due datE  _ Partial Payment_ Age the store to  1 day_Void with encryption");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -4);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -3);
					PartialPayment_Void_WY.EncryptionKey_Void(SSN, FileName);


				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		//@Test(priority=46,groups = "chenna_WY_PDL")
		public void NewLoan_PartialPaymentMO2tender_CheckTenderDetailsVoidScreen() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_PartialPaymentMO2tender_CheckTenderDetailsVoidScreen_Txn_TestData.xls";
			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:48" + "_" + PayFrequency + "_" + CollateralType,
							"Advance =>Partial Pay  with 2 tender types as MO with different numbers =>Transaction should be processed ->Void Partial Pay  with Original tender type.Validate screen if its displaying tender details properly");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -4);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_MO(SSN, FileName);
					PartialPayment_Void_WY.PartialPayment_Void_WY_CheckTenderDetails_OriginalTender(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		//@Test(priority=47,groups = "chenna_WY_PDL")
		public void NewLoan_PartialPaymentMO2tender_Voidwithcash() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_PartialPaymentMO2tender_Voidwithcash_Txn_TestData.xls";
			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:49" + "_" + PayFrequency + "_" + CollateralType,
							"Advance =>Partial Pay  with 2 tender types as MO with different numbers =>Transaction should be processed ->Void Partial Pay  with cash.");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -4);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_MO(SSN, FileName);
					PartialPayment_Void_WY.PartialPayment_Void_WY_CheckTenderDetails(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		//@Test(priority=48,groups = "chenna_WY_PDL")
		public void NewLoan_PartialPaymentMO2tender_VoidwithEncryption() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:50" + "_" + PayFrequency + "_" + CollateralType,
							"Advance =>Partial Pay  with 2 tender types as MO with different numbers =>Transaction should be processed ->Void Partial Pay  next processing day ->Only cash should be available.");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -4);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_MO(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -3);
					PartialPayment_Void_WY.EncryptionKey_Void(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		//@Test(priority=49,groups = "chenna_WY_PDL")
		public void NewLoan_PartialPaymentCCK2tender_CheckTenderDetailsVoidScreen() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_CheckTenderDetailsVoidScreen_Txn_TestData.xls";
			String FileName = "AA_NewLoan_PartialPaymentCCK2tender_CheckTenderDetailsVoidScreen_Txn_TestData.xls";

			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:51" + "_" + PayFrequency + "_" + CollateralType,
							"Advance =>Partial Pay  with 2 tender types as CCK with different numbers =>Transaction should be processed ->Void Partial Pay  with Original tender type.Validate screen if its displaying tender details properly");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -4);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_CCK(SSN, FileName);
					PartialPayment_Void_WY.PartialPayment_Void_WY_CheckTenderDetails_OriginalTender(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		//@Test(priority=50,groups = "chenna_WY_PDL")
		public void NewLoan_PartialPaymentCCK2tender_Voidwithcash() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_Voidwithcash_Txn_TestData.xls";
			String FileName = "AA_NewLoan_PartialPaymentCCK2tender_Voidwithcash_Txn_TestData.xls";

			// TestData = new Excel(System.getProperty("user.dir") +
			// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
			// FileName);
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:52" + "_" + PayFrequency + "_" + CollateralType,
							"Advance =>Partial Pay  with 2 tender types as CCK with different numbers =>Transaction should be processed ->Void Partial Pay  with cash.");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -4);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_CCK(SSN, FileName);
					PartialPayment_Void_WY.PartialPayment_Void_WY_CheckTenderDetails(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		//@Test(priority=51,groups = "chenna_WY_PDL")
		public void NewLoan_PartialPaymentCCK2tender_VoidwithEncryption() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
			String FileName = "AA_NewLoan_PartialPaymentCCK2tender_VoidwithEncryption_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:53" + "_" + PayFrequency + "_" + CollateralType,
							"Advance =>Partial Pay  with 2 tender types as CCk with different numbers =>Transaction should be processed ->Void Partial Pay  next processing day ->Only cash should be available.");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -4);
					LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_CCK(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -3);
					PartialPayment_Void_WY.EncryptionKey_Void(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		@Test (priority=52,groups = "chenna_WY_PDL")

		public void Advance_deposit_ACHPPwith2tendertypessCCKwithsamenumbers_Transactionnotprocessed() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_WY_PDL_Advance_deposit_ACHR_ACHPPwith2tendertypessCCKwithsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";

			// Start test. Mention test script name
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:54" + "_" + PayFrequency + "_" + CollateralType,
							"Advance_deposit_ACHR_ACHP with 2 tender types as CCK with same numbers_Transaction should not be processed");

					// SetCurrentDate.SetCurrentDate(SSN, FileName);
					Login.Login(UserName, Password, StoreId);

					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					//Payliance.Payliance(SSN, FileName, 0);
					REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_SameNumbers(SSN, FileName);

				}
			}

		}	
		
		@Test (priority=53,groups = "chenna_WY_PDL")

		public void Advance_deposit_ACHPPwith2tendertypessMOwithsamenumbers_Transactionnotprocessed() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_WY_PDL_Advance_deposit_ACHR_ACHPPwith2tendertypessCCKwithsamenumbers_Transactionnotprocessed_Txn_Testdata.xls";

			// Start test. Mention test script name
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:55_" + "_" + PayFrequency + "_" + CollateralType,
							"Advance_deposit_ACHR_ACHP with 2 tender types as MO with same numbers_Transaction should not be processed");

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
					REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					ACHPP_MO_2tendertypes.ACHPP_MO_2tendertypes_SameNumbers(SSN, FileName);

				}
			}

		}	
		
		@Test (priority=54,groups = "chenna_WY_PDL")

		public void Advance_deposit_ACHPPwith2tendertypessMOwithDiffnumbers_TransactionShouldbeprocessed_VoidWithcash() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_WY_PDL_Advance_deposit_ACHR_ACHPPwith2tendertypessMOwithDiffnumbers_TransactionShoudbeprocessed_VoidWithCashTxn_Testdata.xls";

			// Start test. Mention test script name
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:56_" + "_" + PayFrequency + "_" + CollateralType,
							"Advance_deposit_ACHR_ACHP with 2 tender types as MO with different numbers_Transaction should be processed_Void ACHP with cash.");

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
					REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					ACHPP_MO_2tendertypes.ACHPP_MO_2tendertypes_DiffNumbers(SSN, FileName);
					Voidwith_Cash.Voidwith_Cash(SSN, FileName);

				}
			}

		}	
		
		
		@Test (priority=55,groups = "chenna_WY_PDL")

		public void Advance_deposit_ACHPPwith2tendertypessCCKwithDiffnumbers_TransactionShouldBeprocessed_VoidwithOrignaltender() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_WY_PDL_Advance_deposit_ACHR_ACHPPwith2tendertypessCCKwithDiffnumbers_TransactionShoudbeprocessed_VoidWithOrignalTenderTxn_Testdata.xls";

			// Start test. Mention test script name
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
					StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:57" + "_" + PayFrequency + "_" + CollateralType,
							"Advance_deposit_ACHR_ACHP with 2 tender types as CCK with different numbers_Transaction should be processed_Void ACHP with Original tender type.Validate screen if its displaying tender details properly");

					// SetCurrentDate.SetCurrentDate(SSN, FileName);
					Login.Login(UserName, Password, StoreId);

					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					//Payliance.Payliance(SSN, FileName, 0);
					REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					ACHPP_CCK_2tendertypes.ACHPP_CCK_2tendertypes_DiffNumbers(SSN, FileName);
					Voidwith_Orginaltender.Voidwith_Orginaltender(SSN, FileName);
				}
			}

		}
		
		//@Test(priority=56,groups = "chenna_WY_PDL")
		public void Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_PreNoteDep() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
			String FileName = "AA_Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_PreNoteDep_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:58" + "_" + PayFrequency + "_" + CollateralType,
							"Loan _ Age the store to six bussiness days before Due date _ Process Pre Note Deposit process from Admin Portal_ PreNote deposit should post");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -6);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);


			

				}
			}
			// Login.Login("CSR353","1234","353");

		}	
		
		//@Test(priority=57,groups = "chenna_WY_PDL")
		public void Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_PreNoteDep_Weekly() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
			String FileName = "AA_Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_PreNoteDep_Weekly_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:59" + "_" + PayFrequency + "_" + CollateralType,
							"Register Customer(Weekly PayFrequency) --> Loan --> Age the store to six bussiness days before Due date --> Process Pre Note Deposit process from Admin Portal --> PreNote deposit should not post");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-7);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);


			

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		//@Test(priority=58,groups = "chenna_WY_PDL")
		public void Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_SKipDepo_PreNoteDep_Depnotpost() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
			String FileName = "AA_Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_SKipDepo_PreNoteDep_Depnotpost_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:60" + "_" + PayFrequency + "_" + CollateralType,
							"Loan -->  Age the store to six bussiness days before Due date --> Process Pre Note Deposit process from Admin Portal --> PreNote deposit should post --> Miss the Deposit --> Age the store to six bussiness days before next Due date --> Process Pre Note Deposit process from Admin Portal --> PreNote deposit should Not post");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -6);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);						     
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					ACHEffectiveDate_AgeStore.ACHEffectiveDate_AgeStore(SSN, FileName, -6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate_SkipDepo(SSN, FileName, -6);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		//@Test(priority=59,groups = "chenna_WY_PDL") //  07-16-2020 , select first paydate as next paydate
		public void Loanwithin5daysduedate_SKipDepo_PreNoteDep_Deppost() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
			String FileName = "AA_Loanwithin5daysduedate_SKipDepo_PreNoteDep_Deppost_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:61" + "_" + PayFrequency + "_" + CollateralType,
							"Loan (Due date with in five bussiness days) --> Miss the deposit --> Age the store to six bussiness days before Due date --> Process Pre Note Deposit process from Admin Portal --> PreNote deposit should  post");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);						     
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					ACHEffectiveDate_AgeStore.ACHEffectiveDate_AgeStore(SSN, FileName, -6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate_SkipDepo(SSN, FileName, -6);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
					Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}	
		
		
		//@Test(priority=60,groups = "chenna_WY_PDL")// 07-16-2020 , (REPAYNACHA Issue-10-07-2019) select first paydate as next paydate
		public void Loanwithin5daysduedate_Deposit_Return_PreNoteDep_Deppost() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
			String FileName = "AA_Loanwithin5daysduedate_Deposit_Return_PreNoteDep_Deppost_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:60" + "_" + PayFrequency + "_" + CollateralType,
							"Loan (Due date with in five bussiness days) --> Process the Deposit --> Return the deposit --> Age the store to six bussiness days before Due date --> Process Pre Note Deposit process from Admin Portal --> PreNote deposit should  post");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					//UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);						     
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					ACHEffectiveDate_AgeStore.ACHEffectiveDate_AgeStore(SSN, FileName, -6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate_SkipDepo(SSN, FileName, -6);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
					Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}




		@Test(priority=61,groups = "chenna_WY_PDL")// 07-16-2020 , select first paydate as next paydate // //not completed Issue
		public void Loan_PerformACHOptoutBeforePreNoteDate_PreNotedepnotpost() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
			String FileName = "AA_Loan_PerformACHOptoutBeforePreNoteDate_PreNotedepnotpost_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:63" + "_" + PayFrequency + "_" + CollateralType,
							"Loan _ Perform ACH Opt Out before PreNote date _ PreNote deposit should not post");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -8);
					ACHRevoke.ACHRevoke(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -7);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
					Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

					


				}
			}
			// Login.Login("CSR353","1234","353");

		}



		//@Test(priority=62,groups = "chenna_WY_PDL")//not completed Issue
		public void Loan_PerformACHOptoutBeforePreNoteDate_ACHOptinonPreNoteDate_PreNotedepnotpost() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
			String FileName = "AA_Loan_PerformACHOptoutBeforePreNoteDate_ACHOptinonPreNoteDate_PreNotedepnotpost_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:64" + "_" + PayFrequency + "_" + CollateralType,
							"Loan _ Perform ACH Opt Out before PreNote date _ Perform ACH Opt In on PreNote date _ Process Pre Note Deposit process from Admin Portal _ PreNote deposit should post");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -9);
					ACHRevoke.ACHRevoke(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -6);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
					Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}



		//@Test(priority=63,groups = "chenna_WY_PDL")//not completed Issue
		public void Loan_PerformACHOptoutBeforePreNoteDate_ACHOptinafterPreNoteDate_DeponDueDate() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
			String FileName = "AA_Loan_PerformACHOptoutBeforePreNoteDate_ACHOptinafterPreNoteDate_DeponDueDate_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:65" + "_" + PayFrequency + "_" + CollateralType,
							"Loan _ Perform ACH Opt Out before PreNote date _ ACH Opt In after PreNote date _ Customer should go for Deposit on his Due date");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -9);
					ACHRevoke.ACHRevoke(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -6);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
					Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}



		//@Test(priority=64,groups = "chenna_WY_PDL")//not completed Issue
		public void Loan_PerformACHOptoutBeforePreNoteDate_ACHOptonafterPreNoteDate_DeponDueDate_CheckNewBankDetails() throws Exception {

			// Start test. Mention test script name
			//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
			String FileName = "AA_Loan_PerformACHOptoutBeforePreNoteDate_ACHOptonafterPreNoteDate_DeponDueDate_CheckNewBankDetails_Txn_TestData.xls";

			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
					String StateID =TestData.getCellData(sheetName, "StateID", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					// System.out.println(SSN);
					test = reports.startTest(Header + "_S.No:66" + "_" + PayFrequency + "_" + CollateralType,
							"Loan with ACH_ Before due date process Ach Revoke _ On Due Date Ach Authorize _ Perform Ach Deposit_ Check whether deposit is done with New Bank details .");


					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -9);
					ACHRevoke.ACHRevoke(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -6);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
					Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

			

				}
			}
			// Login.Login("CSR353","1234","353");

		}
		
		
		@Test(priority = 65, groups = "chenna_WY_PDL")

		public void Loan_PrenoteDeposit_PrenoteClear_InactivestatusBNK_DepositIsNotProcessed() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_Loan_PrenoteDeposit_PrenoteClear_InactivestatusBNK_DepositIsNotProcessed_TextData.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     

			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

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
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:67" + "_" + PayFrequency + "_" + CollateralType,
							"Loan -- > Pre Note DEP > PreNote Clr --> Change BNK status to Inactive before due date --> Custmr should not come for DEPosit on due date.");

					Login.Login(UserName, Password, StoreId);
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -7);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
					AgeStore.AgeStore(SSN, FileName, -1); 
					PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName, -1);   
					Clear_Status.Clear_Status(SSN, FileName);
					EditBorrower_Inactive.EditBorrower_Inactive(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					//EODProcessing.EODProcessing(SSN, FileName); 
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);
					Deposit_History.Deposit_History(SSN, FileName);
					
					

				}
			}
		}

		//@Test(priority = 66, groups = "chenna_WY_PDL")

		public void Loan_PrenoteDeposit_PrenoteClear_InactivestatusBNK_ActiveBNK_DepositIsProcessed() throws Exception {

			// Start test. Mention test script name
			String FileName = "AA_Loan_PrenoteDeposit_PrenoteClear_InactivestatusBNK_ActiveBNK_DepositIsProcessed_TextData.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     

			int lastrow = TestData.getLastRow("NewLoan");
			String sheetName = "NewLoan";

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
					String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String Header = StateID + "_" + ProductID;
					test = reports.startTest(Header + "_S.No:68" + "_" + PayFrequency + "_" + CollateralType,
							"Loan_Pre Note DEP_PreNote Clr_Change BNK status to Inactive before due date_again Change BNK status to ACT on due dt_Custmr should come for DEPosit on due date");

					Login.Login(UserName, Password, StoreId);
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -7);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
					AgeStore.AgeStore(SSN, FileName, -1); 
					PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName, -1);   
					Clear_Status.Clear_Status(SSN, FileName);
					EditBorrower_Inactive.EditBorrower_Inactive(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 0);
					EditBorrower_Active.EditBorrower_Active(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					CustomerEodS_Recoredtatus.CustomerEodS_Recoredtatus(SSN, FileName);
					Deposit_History.Deposit_History(SSN, FileName);
					
					

				}
			}
		}
		
			//@Test (priority=67,groups = "chenna_WY_PDL")

			public void LoanWithACH_Deposit_Return() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_LoanWithACH_Deposit_Return_TextData.xls";

				// Start test. Mention test script name
				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
						StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String StateID = TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:69" + "_" + PayFrequency + "_" + CollateralType,
								 "Loan (ACH)_Nacha_Ach Deposit process_Ach Return posting");

						// SetCurrentDate.SetCurrentDate(SSN, FileName);
						Login.Login(UserName, Password, StoreId);

						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName,0);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						//Payliance.Payliance(SSN, FileName, 0);
						REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
						ACHReturnPosting.ACHReturnPosting(SSN, FileName);
						
					}
				}

			}
			//@Test (priority=68,groups = "chenna_WY_PDL")

			public void LoanWithCHECk_Deposit_Return() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_LoanWithCHECk_Deposit_Return_TextData.xls";

				// Start test. Mention test script name
				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     
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
						StoreId = prop.getProperty("StoreID_WY_PDL_chenna");
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String StateID = TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:70" + "_" + PayFrequency + "_" + CollateralType,
								 "Loan(Check)_Nacha_Ach Deposit process_Ach Return posting");

						// SetCurrentDate.SetCurrentDate(SSN, FileName);
						Login.Login(UserName, Password, StoreId);

						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName,0);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						//Payliance.Payliance(SSN, FileName, 0);
						REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
						ACHReturnPosting.ACHReturnPosting(SSN, FileName);
						
					}
				}

			}
		
			@Test (priority=69,groups = "chenna_WY_PDL")

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
						NewLoan_FL.NewLoan_FL(SSN, FileName); 
						AgeStore.AgeStore(SSN, FileName, 0);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName); 
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						Payliance.Payliance(SSN, FileName, 0);
						AgeStore.AgeStore(SSN, FileName, 2);
						ACH_PrePayment.ACH_PrePayment(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 4);
						ACHReturnPosting.ACHReturnPosting(SSN, FileName);
						
					}
				}

			}
		
			//@Test(priority=70,groups = "chenna_WY_PDL")//not completed Issue
			public void Loan_Deposit_Return() throws Exception {

				// Start test. Mention test script name
				//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
				String FileName = "AA_Loan_Deposit_Return_Txn_TestData.xls";

				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
						String StateID =TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:72" + "_" + PayFrequency + "_" + CollateralType,
								"loan with check _ deposit _ return with return reason id other than R01,R09 then should not allow for future deposit");


						Login.Login(UserName,Password,StoreId);
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 0);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);						     
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
						AgeStore.AgeStore(SSN, FileName, 2);
						ACHReturnPosting.ACHReturnPosting(SSN, FileName);
						//ACHReturnPostingWithoutR01R09.ACHReturnPostingWithoutR01R09(SSN, FileName);
						Redeposit_Count_Check_History.Redeposit_Count_Check_History(SSN, FileName);

					}
				}

			}
			
			
			@Test (priority=71,groups = "chenna_WY_PDL")

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
						
						test = reports.startTest(Header+"_S.No:73"+"_"+PayFrequency+"_"+CollateralType,"LoanwithACH__Nacha__AchDepositProcess__ProcessClear");
						
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
						AgeStore.AgeStore(SSN, FileName, 0);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);
						ACHClear_History.ACHClear_History(SSN, FileName);

					}
				}
				//Login.Login("CSR353","1234","353");

			}
			
			//@Test (priority=72,groups = "chenna_WY_PDL")	

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
						
						test = reports.startTest(Header+"_S.No:74"+"_"+PayFrequency+"_"+CollateralType,"Loan(ACH/Check)_PreNoteDeposit_PreNoteClear");

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
			
			
			//@Test (priority=73,groups = "chenna_WY_PDL")

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
						
						test = reports.startTest(Header+"_S.No:75"+"_"+PayFrequency+"_"+CollateralType,"Loan (Check) -->(Convert to ACH) Ach Deposit process-->Process Clear");	 
						
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
			
			//@Test (priority=74,groups = "chenna_WY_PDL")

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
						test = reports.startTest(Header+"_S.No:76"+"_"+PayFrequency+"_"+CollateralType,"Loan__Agethestoreuptoduedate__performdeposit__ageperformthePrepayment__agethestore__ProcessClear");

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
			
			@Test (priority=75,groups = "chenna_WY_PDL")

			public void NewLoan_Perform_EPP() throws Exception {

				// Start test. Mention test script name
				String FileName= "AA_NewLoan_Perform_EPP.xls";
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
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String Header = StateID+ "_" + ProductID;
						//System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:77" + "_" + PayFrequency +Header, "Loan_Age the store_perform EPP");
						
						
						//SetCurrentDate.SetCurrentDate(SSN, FileName);
						Login.Login(UserName,Password,StoreId);
				
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName,-2);
						RPPPerform.RPPPerform(SSN, FileName);			        
					
					}
				}
			}
			@Test (priority=76,groups = "chenna_WY_PDL")

			public void NewLoan_Perform_EPP_AgestoreInstWise_PerformPaymentPlan() throws Exception {

				// Start test. Mention test script name
				String FileName= "AA_NewLoan_Perform_EPP_AgestoreInstWise_PerformPaymentPlan_TextData.xls";
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
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String Header = StateID+ "_" + ProductID;
						//System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:78" + "_" + PayFrequency +Header, "Loan-EPP_age the store installment wise_perform Paymentplan Payment");
						
						
						//SetCurrentDate.SetCurrentDate(SSN, FileName);
						Login.Login(UserName,Password,StoreId);
				
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName,-2);
						RPPPerform.RPPPerform(SSN, FileName);		        
						AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0,3);
						RPP_Payment_PDL.RPP_Payment_PDL(SSN, FileName);
						AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0, 4);
						RPP_Payment_PDL.RPP_Payment_PDL(SSN, FileName);
						AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0, 5);
						RPP_Payment_PDL.RPP_Payment_PDL(SSN, FileName);
						AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0, 6);
						RPP_Payment_PDL.RPP_Payment_PDL(SSN, FileName);
					}
				}
			}
			@Test (priority=77,groups = "chenna_WY_PDL")

			public void NewLoan_Perform_EPP_CheckEoD_RecordDispalyORNot() throws Exception {

				// Start test. Mention test script name
				String FileName= "AA_NewLoan_Perform_EPP_CheckEoD_RecordDispalyORNot_TextData.xls";
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
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String Header = StateID+ "_" + ProductID;
						//System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:79" + "_" + PayFrequency +Header, "Loan_EPP_Miss the EPP Payment_Age the store_Perform EOD_Customer record should display in EOD process with Check box selected");
						
						
						//SetCurrentDate.SetCurrentDate(SSN, FileName);
						Login.Login(UserName,Password,StoreId);
				
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName,-2);
						RPPPerform.RPPPerform(SSN, FileName);			        
						AgeStore_EPP.AgeStore_EPP(SSN, FileName, 0,3);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						AfterEPPEODProcessing_with_recordsChecking.AfterEPPEODProcessing_with_recordsChecking(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						
						
					}
				}
			}
			@Test (priority=78,groups = "chenna_WY_PDL")

			public void NewLoan_Perform_EPP_AgeStore14DaysFormEPPDueDate_CheckEoD_RecordDispalyed() throws Exception {

				// Start test. Mention test script name
				String FileName= "AA_NewLoan_Perform_EPP_AgeStore14DaysFormEPPDueDate_CheckEoD_RecordDispalyed_TextData.xls";
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
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String Header = StateID+ "_" + ProductID;
						//System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:80" + "_" + PayFrequency +Header, "Loan_EPP_Miss the EPP Payment_Age the store to 14 days from EPP due date_Perform EOD_Customer record should display in EOD process and should comes out forcefully from EPP.");
						
						
						//SetCurrentDate.SetCurrentDate(SSN, FileName);
						Login.Login(UserName,Password,StoreId);
				
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName,-2);
						RPPPerform.RPPPerform(SSN, FileName);			        
						AgeStore_EPP.AgeStore_EPP(SSN, FileName, 14,3);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						AfterEPPEODProcessing_with_recordsChecking.AfterEPPEODProcessing_with_recordsChecking(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						CheckRPPinDropdown.CheckRPPinDropdown(SSN, FileName);
						
						
					}
				}
			}

			@Test(priority = 79, groups = "chenna_WY_PDL")

			public void AA_RPPPayment_With2tenderMO_Diffnumbers_Trans_ShouldBeProcessed_VoidWithCash() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_RPPPayment_With2tenderMO_Diffnumbers_Trans_ShouldBeProcessed_VoidWithCash_TextData.xls";
				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     

				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";

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
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						test = reports.startTest(Header + "_S.No:81" + "_" + PayFrequency + "_" + CollateralType,
								"Advance_EPP_PPAY with 2 tender types as MO with different numbers_Transaction should be processed_Void ACHPP with cash.");

						Login.Login(UserName, Password, StoreId);
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 0);
						EPP.EPP(SSN, FileName);
						RPPPayment_With2tenderMO_Diffnumbers.RPPPayment_With2tenderMO_Diffnumbers(SSN, FileName);
						Voidwith_Cash.Voidwith_Cash(SSN, FileName);

					}
				}
			}

			@Test(priority = 80, groups = "chenna_WY_PDL")

			public void AA_RPPPayment_With2tenderMO_Same_numbers_Trans_ShouldNotBeProcessd() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_RPPPayment_With2tenderMO_Same_numbers_Trans_ShouldNotBeProcessd_TextData.xls";
				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     

				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";

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
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						test = reports.startTest(Header + "_S.No:82" + "_" + PayFrequency + "_" + CollateralType,
								"Advance_EPP_PPAY with 2 tender types as MO with same numbers_Transaction should not be processed.");

						Login.Login(UserName, Password, StoreId);
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 0);
						EPP.EPP(SSN, FileName);
						RPPPayment_With2tenderMO_Samenumbers.RPPPayment_With2tenderMO_Samenumbers(SSN, FileName);
				         

					}
				}
			}

			@Test(priority = 81, groups = "chenna_WY_PDL")

			public void AA_RPPPayment_With2tenderCCK_Diffnumbers_Trans_ShouldBeProcessed_VoidWithOriginalTender() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_RPPPayment_With2tenderCCK_Diffnumbers_Trans_ShouldBeProcessed_VoidWithOriginalTender_TextData.xls";
				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     

				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";

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
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						test = reports.startTest(Header + "_S.No:83" + "_" + PayFrequency + "_" + CollateralType,
								"Advance_EPP_PPAY with 2 tender types as CCK with different numbers_Transaction should be processed_Void ACHPP with Original tender type.Validate screen if its displaying tender details properly.");

						Login.Login(UserName, Password, StoreId);
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 0);
						EPP.EPP(SSN, FileName);
						RPPPayment_With2tenderCCK_Diffnumbers.RPPPayment_With2tenderCCK_Diffnumbers(SSN, FileName);
						Voidwith_Orginaltender.Voidwith_Orginaltender(SSN, FileName);

					}
				}
			}
			@Test(priority = 82, groups = "chenna_WY_PDL")

			public void AA_RPPPayment_With2tenderCCK_Same_numbers_Trans_ShouldNotBeProcessd() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_RPPPayment_With2tenderCCK_Same_numbers_Trans_ShouldNotBeProcessd_TextData.xls";
				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     

				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";

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
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						test = reports.startTest(Header + "_S.No:84" + "_" + PayFrequency + "_" + CollateralType,
								"Advance_EPP_PPAY with 2 tender types as CCK with same numbers_Transaction should not be processed.");

						Login.Login(UserName, Password, StoreId);
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 0);
						EPP.EPP(SSN, FileName);
						RPPPayment_With2tenderCCK_Samenumbers.RPPPayment_With2tenderCCK_Samenumbers(SSN, FileName);
				         

					}
				}
			}
			@Test(priority = 83, groups = "chenna_WY_PDL")

			public void AA_RPPPayment_With2tenderCCK_Diffnumbers_Trans_ShouldBeProcessed_MidDayDeposit() throws Exception {

				// Start test. Mention test script name
				String FileName = "AA_RPPPayment_With2tenderCCK_Diffnumbers_Trans_ShouldBeProcessed_MidDayDeposit_TextData.xls";
				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);     

				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";

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
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						test = reports.startTest(Header + "_S.No:85" + "_" + PayFrequency + "_" + CollateralType,
								"Advance =>EPP =>PPAY with 2 tender types as CCk with different numbers =>Transaction should be processed =>deassign drawer =>Validate they are available for mid day deposit.Process Mid day deposit =>Void ACHPP Only cash should be displayed.");

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
						Voidwith_Cash.Voidwith_Cash(SSN, FileName);
						

					}
				}
			}	
			
			
			//@Test(priority=84,groups = "chenna_WY_PDL")//not completed Issue
			public void Loan_Deposit_PrePayment_Return_Redeposit_Clear_RefundwithCashandCheckDisplayed() throws Exception {

				// Start test. Mention test script name
				//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
				String FileName = "AA_Loan_Deposit_PrePayment_Return_Redeposit_Clear_RefundwithCashandCheckDisplayed_Txn_TestData.xls";

				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
						String StateID =TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:86" + "_" + PayFrequency + "_" + CollateralType,
								"Loan _ Age the store upto duedate _ perform deposit_ age perform the Prepayment_ Return posting _ Redeposit _ Process Clear_ Process refund for the excess amount paid options in store should be only cash and check");


						Login.Login(UserName,Password,StoreId);
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 0);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						//UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);						     
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
						AgeStore.AgeStore(SSN, FileName, 2);
						ACHPaymet_ExcludeNSFFee.ACHPaymet_ExcludeNSFFee(SSN, FileName);
						ACHReturnPosting.ACHReturnPosting(SSN, FileName);
						ACHEffectiveDate_AgeStore.ACHEffectiveDate_AgeStore(SSN, FileName, 0);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						//UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);						     
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						REPAY_NACHA.REPAY_NACHA_ReDep(SSN, FileName, 0);
						ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);

					}
				}
				// Login.Login("CSR353","1234","353");

			}
			
			//@Test(priority=85,groups = "chenna_WY_PDL")//not completed Issue
			public void Loan_ReturnPosting_WO60days() throws Exception {

				// Start test. Mention test script name
				//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
				String FileName = "AA_Loan_ReturnPosting_WO60days_Txn_TestData.xls";

				TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_chenna") + FileName);
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
						String StateID =TestData.getCellData(sheetName, "StateID", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
						String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						String Header = StateID + "_" + ProductID;
						// System.out.println(SSN);
						test = reports.startTest(Header + "_S.No:87" + "_" + PayFrequency + "_" + CollateralType,
								"Loan _ Return Posting _ WO Check whether Write off is done 60days from return date.");


						Login.Login(UserName,Password,StoreId);
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 0);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						//UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);						     
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
						ACHReturnPosting.ACHReturnPosting(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 61);
						WO_HistoryCheck.Prenote_deposit_History(SSN, FileName);



					}
				}
				// Login.Login("CSR353","1234","353");

			}
			
			
			
			@Test(priority=86,groups = "chenna_WY_PDL")

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
						String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
						String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
						String Header = StateID+ "_" + ProductID;
						//System.out.println(SSN);
						//test = reports.startTest("Loan_ReturnPosting_15PerofTotalDue__CheckWriteOff120daystoretdate"+Header, "Loan__ReturnPosting___NSFPayment15PercentofTotalDue__WOCheckwhetherWriteoffisdone120daysfromreturndate");
						//appUrl = AppURL;
						test = reports.startTest(Header+"_S.No:88"+"_"+PayFrequency+"_"+CollateralType,"Loan->Return Posting --> NSF Payment 15% of Total Due --> WO Check whether Write off is done 120 days from return date.)");


						//this.SetCurrentDate(SSN, FileName);
						Login.Login(UserName,Password,StoreId);	
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 0);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);
						NACHA.NACHA(SSN, FileName, 0);
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						// this.ACH_PartialPrePayment(SSN, FileName);
						ACHReturnPosting.ACHReturnPosting(SSN, FileName);
						ACHPayment.ACHPayment(SSN, FileName, 0.15);
						WriteOff.WriteOff(SSN, FileName, 121);
						WriteOff_History.WriteOff_History(SSN, FileName);
						//this.IETaskKiller();



					}
				}
				//this.Login("CSR353","1234","353");

			}

			
			@Test(priority=87,groups = "chenna_WY_PDL")

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
						String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
						String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
						String SSN = TestData.getCellData(sheetName,"SSN",row);	
						String Header = StateID+ "_" + ProductID;
						//System.out.println(SSN);
						//test = reports.startTest("Loan_ReturnPosting_NSF15_Void_WO60days_Returndate_TestData"+Header, "Loan->Return Posting_NSF Payment 15% of Total Due_Void_WO Check whether Write off is done 60 days from return date.");
						//appUrl = AppURL;
						test = reports.startTest(Header+"_S.No:89"+"_"+PayFrequency+"_"+CollateralType,"Loan->Return Posting --> NSF Payment 15% of Total Due --> Void --> WO Check whether Write off is done 60 days from return date.)");

						//this.SetCurrentDate(SSN, FileName);
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
						ACHPayment.ACHPayment(SSN, FileName, 0.15);
						NSF_Void.NSF_Void(SSN, FileName);
						WriteOff.WriteOff(SSN, FileName, 60);
						WriteOff_History.WriteOff_History(SSN, FileName);

					}
				}


			}

			
			@Test(priority=88,groups = "chenna_WY_PDL")

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
						String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
						String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
						String Header = StateID+ "_" + ProductID;
						//System.out.println(SSN);
						//test = reports.startTest("Loan_ReturnPosting_30PerofTotalDue__CheckWriteOff180daystoretdate"+Header, "Loan__ReturnPosting___NSFPayment30PercentofTotalDue__WOCheckwhetherWriteoffisdone180daysfromreturndate");
						//appUrl = AppURL;
						test = reports.startTest(Header+"_S.No:90"+"_"+PayFrequency+"_"+CollateralType,"Loan->Return Posting --> NSF Payment 30% of Total Due --> WO Check whether Write off is done 180 days from return date.)");


						//this.SetCurrentDate(SSN, FileName);
						Login.Login(UserName,Password,StoreId);	
						RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
						NewLoan.NewLoan(SSN, FileName);
						AgeStore.AgeStore(SSN, FileName, 0);
						DrawerDeassign.DrawerDeassign(SSN, FileName);
						StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
						StoreInfo.StoreInfo(SSN, FileName);
						NACHA.NACHA(SSN, FileName, 0);
						Safeassign.Safeassign(SSN, FileName);
						Drawerassign.Drawerassign(SSN, FileName);
						// this.ACH_PartialPrePayment(SSN, FileName);
						ACHReturnPosting.ACHReturnPosting(SSN, FileName);
						ACHPayment.ACHPayment(SSN, FileName, 0.3);
						WriteOff.WriteOff(SSN, FileName, 181);
						WriteOff_History.WriteOff_History(SSN, FileName);

						//this.IETaskKiller();



					}
				}
				//this.Login("CSR353","1234","353");

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
