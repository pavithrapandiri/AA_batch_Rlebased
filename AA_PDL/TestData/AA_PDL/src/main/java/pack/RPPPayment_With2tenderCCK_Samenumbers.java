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

public class RPPPayment_With2tenderCCK_Samenumbers extends AA_PDL{
	public static void RPPPayment_With2tenderCCK_Samenumbers (String SSN,String FileName) throws Exception{

		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);     	
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
			/*	String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
				String StoreId = TestData.getCellData(sheetName,"StoreID",row);*/
	/*			String Refno1 = TestData.getCellData(sheetName,"Refno1",row);
				String Refno2 = TestData.getCellData(sheetName,"Refno2",row);
				String TenderType1 = TestData.getCellData(sheetName,"TenderType1",row);
				String TenderType2 = TestData.getCellData(sheetName,"TenderType2",row);*/
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Login.Login(UserName, Password, StoreId);
				Thread.sleep(4000);
				driver.switchTo().defaultContent();				
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(1000);
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
				Thread.sleep(1000);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");


				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("RPP Payment");
				
				if(ProductID.equals("PDL"))
				{
					driver.findElement(By.name("button")).click(); 
				}

				for( String winHandle1 : driver.getWindowHandles())
				
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				String PaymentAmount = null;

				PaymentAmount = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
				// test.log(LogStatus.PASS, "Capture the Payment
				// Amt":+PaymentAmount);
				Thread.sleep(2000);

				double pmtamt1 = Double.parseDouble(PaymentAmount);
			/*	double pmtamt2 = pmtamt1 * PerAmt;*/
				double pmtamt2 = 50;
				//test.log(LogStatus.PASS, pmtamt2 + ": is :" + PerAmt + ": of Total Default Amount");
				double pmtamt4 =pmtamt1-pmtamt2;
				String pmtamt5 = String.valueOf(pmtamt4);
				String pmtamt3 = String.valueOf(pmtamt2);
				String SSN4 ="1"+SSN1;
				
				
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Cashiers Check");
					test.log(LogStatus.PASS, "Tender Type is Selected as :: Cashiers Check");
					Thread.sleep(5000);					
					driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "First MO Number is::"+SSN3);	
					
					Thread.sleep(2000);
									
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(pmtamt3);
					test.log(LogStatus.PASS, "Tender Type 1 AMT is ::"+pmtamt3);
										
						
					driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys("Cashiers Check");
					test.log(LogStatus.PASS, "Tender Type is Selected as Cashiers Check");
					Thread.sleep(5000);
					
					driver.findElement(By.name("transactionDataBean.ccmoNbrSecond")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "Second MO Number is :: "+SSN3);
					
					Thread.sleep(2000);
									
					driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys(pmtamt5);
					test.log(LogStatus.PASS, "Tender Type 2 AMT is ::"+pmtamt5);
					Thread.sleep(2000);	
					
				
											
					driver.findElement(By.name("password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is selected as "+Password);						
					driver.findElement(By.name("Submit22")).click();																									
					test.log(LogStatus.PASS, "Clicked on Finish ACH Pre Payment button ");
					Thread.sleep(1000);
					Thread.sleep(3000);

					String alertmsg=driver.switchTo().alert().getText();
					driver.switchTo().alert().accept();
					//alert.accept();
					test.log(LogStatus.PASS, alertmsg);
					test.log(LogStatus.PASS, "Rpp Payment is not Processed::"+alertmsg);
					

					/*try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();

					}
					catch (NoAlertPresentException e) {
					}

					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					
					if(driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).isDisplayed())
						
					{
						driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
													///html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr[4]/td/table/tbody/tr[5]/td/input[3]
						test.log(LogStatus.PASS, "ACH Pre Payment Completed Successfully ");
					}
					
					
					else
						
					{
						test.log(LogStatus.FAIL, "ACH Pre  Payment not Completed Successfully ");
					}*/


				}

			}
		}
	

	public static void ACHPP_CCK_2tendertypes_SameNumbers(String SSN,String FileName) throws Exception{


		
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
			/*	String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
				String StoreId = TestData.getCellData(sheetName,"StoreID",row);*/
	/*			String Refno1 = TestData.getCellData(sheetName,"Refno1",row);
				String Refno2 = TestData.getCellData(sheetName,"Refno2",row);
				String TenderType1 = TestData.getCellData(sheetName,"TenderType1",row);
				String TenderType2 = TestData.getCellData(sheetName,"TenderType2",row);*/
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Login.Login(UserName, Password, StoreId);	
				driver.switchTo().defaultContent();				
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(1000);
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
				Thread.sleep(1000);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");


				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("RPP Payment");
				
				if(ProductID.equals("PDL"))
				{
					driver.findElement(By.name("button")).click(); 
				}

				for( String winHandle1 : driver.getWindowHandles())
				
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				String PaymentAmount = null;

				PaymentAmount = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
				// test.log(LogStatus.PASS, "Capture the Payment
				// Amt":+PaymentAmount);
				Thread.sleep(2000);

				double pmtamt1 = Double.parseDouble(PaymentAmount);
			/*	double pmtamt2 = pmtamt1 * PerAmt;*/
				double pmtamt2 = 50;
				//test.log(LogStatus.PASS, pmtamt2 + ": is :" + PerAmt + ": of Total Default Amount");
				double pmtamt4 =pmtamt1-pmtamt2;
				String pmtamt5 = String.valueOf(pmtamt4);
				String pmtamt3 = String.valueOf(pmtamt2);
				String SSN4 ="1"+SSN1;
				
				
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Cashiers Check");
					test.log(LogStatus.PASS, "Tender Type is Selected as :: Cashiers Check");
					Thread.sleep(5000);					
					driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "First MO Number is::"+SSN3);	
					
					Thread.sleep(2000);
									
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(pmtamt3);
					test.log(LogStatus.PASS, "Tender Type 1 AMT is ::"+pmtamt3);
										
						
					driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys("Cashiers Check");
					test.log(LogStatus.PASS, "Tender Type is Selected as Cashiers Check");
					Thread.sleep(5000);
					
					driver.findElement(By.name("transactionDataBean.ccmoNbrSecond")).sendKeys(SSN4);
					test.log(LogStatus.PASS, "Second MO Number is :: "+SSN4);
					
					Thread.sleep(2000);
									
					driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys(pmtamt5);
					test.log(LogStatus.PASS, "Tender Type 2 AMT is ::"+pmtamt5);
					Thread.sleep(2000);	
					
				
											
					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is selected as "+Password);						
					driver.findElement(By.name("Submit22")).click();																									
					test.log(LogStatus.PASS, "Clicked on Finish ACH Pre Payment button ");
					Thread.sleep(1000);

					try { 
						Alert alert = driver.switchTo().alert();
					
						//Two CC/MO Nbrs can not be same.
						String C=alert.getText();
						test.log(LogStatus.PASS, "Message thrown when Same Numbers are given for two tender types of MO is  :: "+C);

						alert.accept();
						test.log(LogStatus.PASS, "Alert Accepted");

					}
					catch (NoAlertPresentException e) {
					}

					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					
				


				}

			}
		}
	
	
	
}