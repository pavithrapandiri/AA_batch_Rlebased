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

public class HistoryValidation_PDL extends AA_PDL{
	public static void HistoryValidation_PDL(String SSN,String FileName) throws Exception
	{

		
		//int lastrow=TestData.getLastRow("Borrower_Registration");
		//String sheetName="Borrower_Registration";
		String sheetName_calc="HistoryFieldsValidation";
		String sheetName_new_loan="NewLoan";

		//String sheetName="NewLoan";
		test.log(LogStatus.INFO, "Admin Checks");

		int lastrow=TestData.getLastRow("NewLoan");
		System.out.println("NewLoan "+lastrow);
		String sheetName="NewLoan";		
		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String TxnType=TestData.getCellData(sheetName,"TxnType",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);	
				String ProductID=TestData.getCellData(sheetName,"ProductID",row);
				/*String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
				String StoreId = TestData.getCellData(sheetName,"StoreID",row); */
				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
	            String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);


				String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;
				String primary_source_of_income = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",4);
				String NetIncomeAmt = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",5);
				//String NetIncomeAmt1=NetIncomeAmt+".00";
				String GrossIncome = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",6);
				GrossIncome = GrossIncome+".00";
				String pay_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
				String loan_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",8);
				String check_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",9);
				String product_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",11);
				String loan_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",12);
				String finance_charge=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",13);
				String apr=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",14);
				String loan_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",17);
				String Status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",21);
				String principal_balance=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",22);
				String fee_due=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",23);
				String pay_off_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",24);
				String principal_paid_to_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",25);
				String fee_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",26);
				String Product_Name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",30);
				String total_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
				String advance_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",3);
			       String advance_fees=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",4);
			       String NSF_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",5);
			       String WO_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",6);
			       String interest_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",7);
			       String origination_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",8);
			       String credit_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",9);
			       String EPP_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",10);
			       String ACH_type=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",2);
			       String ACH_transaction=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",3);
			       String ACH_status=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",4);
			       String ACH_amount=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",5);
			       String ACH_ABA_code=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",6);
			       String ACH_check_acc_no=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",7);
			       String transactions=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",11);


				System.out.println(AdminURL);
				test.log(LogStatus.INFO, "Scheduler-Store Aging");
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(2000);
				driver.switchTo().frame("topFrame");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				test.log(LogStatus.PASS, "Clicked on Transactions");		
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");		
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if(ProductID.equals("PDL"))
				{

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				}
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("History");
				test.log(LogStatus.PASS, "In Transaction selected List HISTORY as selecte");
				driver.findElement(By.xpath("//*[@id='go_Button']")).click();
				test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
				test.log(LogStatus.PASS, "Start for HISTORY Fields Validation");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				String Customer = driver.findElement(By.xpath(" //*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[2]/td/span[2]")).getText();
				test.log(LogStatus.PASS,"CustomerName is ::::"+Customer);
				           
				String CustomerNumber = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[3]/td/span[2]")).getText();
				
				test.log(LogStatus.PASS,"Customer Nbr is ::::"+CustomerNumber);

				String SSNNumber = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[5]/td/span[2]")).getText();

				test.log(LogStatus.PASS, "SSN / ITIN  is ::::"+SSNNumber);

				String PrimarySourceOfIncome = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[2]/td/span[2]")).getText();

				if(primary_source_of_income.equalsIgnoreCase(PrimarySourceOfIncome))
				{
					test.log(LogStatus.PASS, "primary_source_of_income->Expected value:"+primary_source_of_income +"; == Actual value:"+PrimarySourceOfIncome);
				}
				else
				{
					test.log(LogStatus.FAIL, "primary_source_of_income->Expected value:"+primary_source_of_income +"; not equals to Actual value:"+PrimarySourceOfIncome);

				}


				String NetPay = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[4]/td/span[2]")).getText();
				String NetPay1 =  "$"+" "+NetPay;
				if(NetIncomeAmt.equalsIgnoreCase(NetPay1))
				{
					test.log(LogStatus.PASS, "NetIncomeAmt->Expected value:"+NetIncomeAmt +"; == Actual value:"+NetPay1);
				}
				else
				{
					test.log(LogStatus.FAIL, "NetIncomeAmt->Expected value:"+NetIncomeAmt +"; not equals to Actual value:"+NetPay1);

				}

				String GrossPay = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[5]/td/span[2]")).getText();
				String GrossPay1 =  "$"+" "+GrossPay;
				if(GrossIncome.equalsIgnoreCase(GrossPay1))
				{
					test.log(LogStatus.PASS, "GrossIncome->Expected value:"+GrossIncome +"; == Actual value:"+GrossPay1);
				}
				else
				{
					test.log(LogStatus.FAIL, "GrossIncome->Expected value:"+GrossIncome +"; not equals to Actual value:"+GrossPay1);

				}

				String PayFrequency = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[6]/td/span[2]")).getText();

				if(pay_frequency.equalsIgnoreCase(PayFrequency))
				{
					test.log(LogStatus.PASS, "pay_frequency->Expected value:"+pay_frequency +"; == Actual value:"+PayFrequency);
				}
				else
				{
					test.log(LogStatus.FAIL, "pay_frequency->Expected value:"+pay_frequency +"; not equals to Actual value:"+PayFrequency);

				}

				String LoanStatus = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[2]/td/span[2]")).getText();

				if(loan_status.equalsIgnoreCase(LoanStatus))
				{
					test.log(LogStatus.PASS, "loan_status->Expected value:"+loan_status +"; == Actual value:"+LoanStatus);
				}
				else
				{
					test.log(LogStatus.FAIL, "loan_status->Expected value:"+loan_status +"; not equals to Actual value:"+LoanStatus);

				}

				String CheckStatus = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();
				if(check_status.equalsIgnoreCase(CheckStatus))
				{
					test.log(LogStatus.PASS, "check_status->Expected value:"+check_status +"; == Actual value:"+CheckStatus);
				}
				else
				{
					test.log(LogStatus.FAIL, "check_status->Expected value:"+check_status +"; not equals to Actual value:"+CheckStatus);

				}

				String DueDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();

				test.log(LogStatus.PASS,"Due Date   is ::::"+DueDate);

				String ProductType = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[3]/td/span[2]")).getText();

				if(product_type.equalsIgnoreCase(ProductType))
				{
					test.log(LogStatus.PASS, "product_type->Expected value:"+product_type +"; == Actual value:"+ProductType);
				}
				else
				{
					test.log(LogStatus.FAIL, "product_type->Expected value:"+product_type +"; not equals to Actual value:"+ProductType);

				}

				String LoanAmount = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[6]/td/span[2]")).getText();

				if(loan_amount.equalsIgnoreCase(LoanAmount))
				{
					test.log(LogStatus.PASS, "loan_amount->Expected value:"+loan_amount +"; == Actual value:"+LoanAmount);
				}
				else
				{
					test.log(LogStatus.FAIL, "loan_amount->Expected value:"+loan_amount +"; not equals to Actual value:"+LoanAmount);

				}

				String FinanceCharge = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[7]/td/span[2]")).getText();

				if(finance_charge.equalsIgnoreCase(FinanceCharge))
				{
					test.log(LogStatus.PASS, "finance_charge->Expected value:"+finance_charge +"; == Actual value:"+FinanceCharge);
				}
				else
				{
					test.log(LogStatus.FAIL, "finance_charge->Expected value:"+finance_charge +"; not equals to Actual value:"+FinanceCharge);

				}

				String APR = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[8]/td/span[2]")).getText();

				if(apr.equalsIgnoreCase(APR))
				{
					test.log(LogStatus.PASS, "apr->Expected value:"+apr +"; == Actual value:"+APR);
				}
				else
				{
					test.log(LogStatus.FAIL, "apr->Expected value:"+apr +"; not equals to Actual value:"+APR);

				}

				String LoanDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[10]/td/span[2]")).getText();

				test.log(LogStatus.PASS,"Loan Date   is ::::"+LoanDate);


				String CollateralType = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[11]/td/span[2]")).getText();

				test.log(LogStatus.PASS,"Collateral Type  is ::::"+CollateralType);

				String LoanFrequency = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[12]/td/span[2]")).getText();

				if(loan_frequency.equalsIgnoreCase(LoanFrequency))
				{
					test.log(LogStatus.PASS, "loan_frequency->Expected value:"+loan_frequency +"; == Actual value:"+LoanFrequency);
				}
				else
				{
					test.log(LogStatus.FAIL, "loan_frequency->Expected value:"+loan_frequency +"; not equals to Actual value:"+LoanFrequency);

				}
				String status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[12]/td/span[2]")).getText();
				if(Status.equalsIgnoreCase(Status))
				{
					test.log(LogStatus.PASS, "Status->Expected value:"+Status +"; == Actual value:"+status);
				}
				else
				{
					test.log(LogStatus.FAIL, "Status->Expected value:"+Status +"; not equals to Actual value:"+status);

				}


				String PrincipalBalance = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[18]/td/span[2]")).getText();

				if(principal_balance.equalsIgnoreCase(PrincipalBalance))
				{
					test.log(LogStatus.PASS, "principal_balance->Expected value:"+principal_balance +"; == Actual value:"+PrincipalBalance);
				}
				else
				{
					test.log(LogStatus.FAIL, "principal_balance->Expected value:"+principal_balance +"; not equals to Actual value:"+PrincipalBalance);

				}

				String FeeDue = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[19]/td/span[2]")).getText();

				if(fee_due.equalsIgnoreCase(FeeDue))
				{
					test.log(LogStatus.PASS, "fee_due->Expected value:"+fee_due +"; == Actual value:"+FeeDue);
				}
				else
				{
					test.log(LogStatus.FAIL, "fee_due->Expected value:"+fee_due +"; not equals to Actual value:"+FeeDue);

				}


				String PayOffAMT = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[19]/td/span[2] ")).getText();
				if(pay_off_amount.equalsIgnoreCase(PayOffAMT))
				{
					test.log(LogStatus.PASS, "pay_off_amount->Expected value:"+pay_off_amount +"; == Actual value:"+PayOffAMT);
				}
				else
				{
					test.log(LogStatus.FAIL, "pay_off_amount->Expected value:"+pay_off_amount +"; not equals to Actual value:"+PayOffAMT);

				}

				String PrincipalPaidToDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[25]/td/span/span")).getText();
				if(principal_paid_to_date.equalsIgnoreCase(PrincipalPaidToDate))
				{
					test.log(LogStatus.PASS, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; == Actual value:"+PrincipalPaidToDate);
				}
				else
				{
					test.log(LogStatus.FAIL, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; not equals to Actual value:"+PrincipalPaidToDate);

				}
				String FeePaidToDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[26]/td/span/span")).getText();
				if(fee_paid_date.equalsIgnoreCase(FeePaidToDate))
				{
					test.log(LogStatus.PASS, "fee_paid_date->Expected value:"+fee_paid_date +"; == Actual value:"+FeePaidToDate);
				}
				else
				{
					test.log(LogStatus.FAIL, "fee_paid_date->Expected value:"+fee_paid_date +"; not equals to Actual value:"+FeePaidToDate);

				}

				String Productname = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[2]/td/span[2] ")).getText();
				if(Product_Name.equalsIgnoreCase(Productname))
				{
					test.log(LogStatus.PASS, "ProductName->Expected value:"+Product_Name +"; == Actual value:"+Productname);
				}
				else
				{
					test.log(LogStatus.FAIL, "ProductName->Expected value:"+Product_Name +"; not equals to Actual value:"+Productname);	

				}
				
				
				
				List<WebElement> options =  driver.findElements(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr"));
				int schsize = options.size();
				
				String Transaction = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+schsize+"]/td[5]")).getText();
				test.log(LogStatus.PASS, "Transaction :::"+Transaction);
				if(transactions.equalsIgnoreCase(Transaction))
				{
					test.log(LogStatus.PASS, "transactions->Expected value:"+transactions +"; == Actual value:"+Transaction);
				}
				else
				{
					test.log(LogStatus.FAIL, "transactions->Expected value:"+transactions +"; not equals to Actual value:"+Transaction);	

				}

				
					String TotalAMT = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+schsize+"]/td[7]")).getText();
					if(total_amount.equalsIgnoreCase(TotalAMT))
					{
						test.log(LogStatus.PASS, "total_amount->Expected value:"+total_amount +"; == Actual value:"+TotalAMT);
					}
					else
					{
						test.log(LogStatus.FAIL, "total_amount->Expected value:"+total_amount +"; not equals to Actual value:"+TotalAMT);	

					}
					
					String AdvAMT = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+schsize+"]/td[8]")).getText();
					if(advance_amount.equalsIgnoreCase(AdvAMT))
					{
						test.log(LogStatus.PASS, "advance_amount->Expected value:"+advance_amount +"; == Actual value:"+AdvAMT);
					}
					else
					{
						test.log(LogStatus.FAIL, "advance_amount->Expected value:"+advance_amount +"; not equals to Actual value:"+AdvAMT);	

					}
					
					String AdvFee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+schsize+"]/td[9]")).getText();
					if(advance_fees.equalsIgnoreCase(AdvFee))
					{
						test.log(LogStatus.PASS, "advance_fees->Expected value:"+advance_fees +"; == Actual value:"+AdvFee);
					}
					else
					{
						test.log(LogStatus.FAIL, "advance_fees->Expected value:"+advance_fees +"; not equals to Actual value:"+AdvFee);	

					}
					
					String NsfAMT = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+schsize+"]/td[10]")).getText();
					if(NSF_amount.equalsIgnoreCase(NsfAMT))
					{
						test.log(LogStatus.PASS, "NSF_amount->Expected value:"+NSF_amount +"; == Actual value:"+NsfAMT);
					}
					else
					{
						test.log(LogStatus.FAIL, "NSF_amount->Expected value:"+NSF_amount +"; not equals to Actual value:"+NsfAMT);	

					}
					
					String WOAMT = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+schsize+"]/td[11]")).getText();
					if(WO_amount.equalsIgnoreCase(WOAMT))
					{
						test.log(LogStatus.PASS, "WO_amount->Expected value:"+WO_amount +"; == Actual value:"+WOAMT);
					}
					else
					{
						test.log(LogStatus.FAIL, "WO_amount->Expected value:"+WO_amount +"; not equals to Actual value:"+WOAMT);	

					}
					
					String InterestFee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+schsize+"]/td[12]")).getText();
					if(interest_fee.equalsIgnoreCase(InterestFee))
					{
						test.log(LogStatus.PASS, "interest_fee->Expected value:"+interest_fee +"; == Actual value:"+InterestFee);
					}
					else
					{
						test.log(LogStatus.FAIL, "interest_fee->Expected value:"+interest_fee +"; not equals to Actual value:"+InterestFee);	

					}
					
					String OriginationFee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+schsize+"]/td[13]")).getText();
					if(origination_fee.equalsIgnoreCase(OriginationFee))
					{
						test.log(LogStatus.PASS, "origination_fee->Expected value:"+origination_fee +"; == Actual value:"+OriginationFee);
					}
					else
					{
						test.log(LogStatus.FAIL, "origination_fee->Expected value:"+origination_fee +"; not equals to Actual value:"+OriginationFee);	

					}
					
					String VerificationFee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+schsize+"]/td[14]")).getText();
					if(credit_or_verification_fee.equalsIgnoreCase(VerificationFee))
					{
						test.log(LogStatus.PASS, "credit_or_verification_fee->Expected value:"+credit_or_verification_fee +"; == Actual value:"+VerificationFee);
					}
					else
					{
						test.log(LogStatus.FAIL, "credit_or_verification_fee->Expected value:"+credit_or_verification_fee +"; not equals to Actual value:"+VerificationFee);	

					}
					
					String RPPFee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+schsize+"]/td[15]")).getText();
					if(EPP_fee.equalsIgnoreCase(RPPFee))
					{
						test.log(LogStatus.PASS, "EPP_fee->Expected value:"+EPP_fee +"; == Actual value:"+RPPFee);
					}
					else
					{
						test.log(LogStatus.FAIL, "EPP_fee->Expected value:"+EPP_fee +"; not equals to Actual value:"+RPPFee);	


						
						String ABACode = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[7]")).getText();
						if(ACH_ABA_code.equalsIgnoreCase(ABACode))
						{
							test.log(LogStatus.PASS, "ACH_ABA_code->Expected value:"+ACH_ABA_code +"; == Actual value:"+ABACode);
						}
						else
						{
							test.log(LogStatus.FAIL, "ACH_ABA_code->Expected value:"+ACH_ABA_code +"; not equals to Actual value:"+ABACode);	

						}
						
						String CheckAcountNo = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[8]")).getText();
						if(ACH_check_acc_no.equalsIgnoreCase(CheckAcountNo))
						{
							test.log(LogStatus.PASS, "ACH_check_acc_no->Expected value:"+ACH_check_acc_no +"; == Actual value:"+CheckAcountNo);
						}
						else
						{
							test.log(LogStatus.FAIL, "ACH_check_acc_no->Expected value:"+ACH_check_acc_no +"; not equals to Actual value:"+CheckAcountNo);	

						}
					}
			}
		}
	}
		


}







				
				
				