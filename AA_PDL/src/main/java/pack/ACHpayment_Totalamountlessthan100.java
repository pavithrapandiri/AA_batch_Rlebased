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

public class ACHpayment_Totalamountlessthan100 extends AA_PDL{
	public static void ACHPayment_Totalamountlessthan100(String SSN,String FileName) throws Exception
	{

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
				//String UserName = TestData.getCellData(sheetName,"UserName",row);
				//String Password = TestData.getCellData(sheetName,"Password",row);
				////String StoreId = TestData.getCellData(sheetName,"StoreId",row); 
				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
				System.out.println(AdminURL);
				test.log(LogStatus.INFO, "Scheduler-Store Aging");

				System.out.println(ProductID);	
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				//appUrl = AppURL;
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(2000);
				driver.switchTo().frame("topFrame");
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


				/*if(ProductID.equals("PDL"))
		{*/

				Thread.sleep(2000);
				//	/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[11]/input[1]")).click();
				/*	                          //   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
		}*/
				//  driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("ACH Pre-Payment");
				/*	if(ProductID.equals("LOC"))
		{*/
				//*[@id="go_Button"]
				driver.findElement(By.xpath("//*[@id='go_Button']")).click();
				test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
				//driver.findElement(By.name("button")).click(); 
				//}
				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.

				}

				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");



				//String PmtAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
				driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
				driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys("300");
				driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Cash");
				test.log(LogStatus.PASS, "TenderType Select as ::Cash");
				driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys("300");
				test.log(LogStatus.PASS, "TenderAmount Entered is::100");
				//transactionDataBean.tenderTypeSecond
				driver.findElement(By.name("requestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "Passwor Entered as::"+Password);
				driver.findElement(By.name("Submit22")).click();
				test.log(LogStatus.PASS, "Clicked on Finish ACH PrePayment Button");

				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.

				}
				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.

				}

				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				if(driver.findElement(By.xpath("//*[@id='totPart']/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/p[2]/input[1]")).isDisplayed())
				{
					driver.findElement(By.xpath("//*[@id='totPart']/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/p[2]/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked on Confirmation Yes Button");
				}		

				//*[@id="totPart"]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/p[2]/input[1]      Confirm Yes button

				//String CheckStaus=null;
				/*	//	CheckStaus = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[6]/td[3]/span[2]")).getText();
		CheckStaus = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();
		//CheckStaus1 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[4]/td[5]")).getText();
		if((CheckStaus).contains("Deposit"))
		{
			test.log(LogStatus.PASS,"CheckStatus is  Displayed as::"+CheckStaus);
		}
		else
		{
			test.log(LogStatus.PASS,"CustomerEOD Record is not Displayed.");
		}*/

			}
		}
	}
	
public static void ACHPayment_Totalamountlessthan100_SC(String SSN,String FileName) throws Exception
{

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
			//String UserName = TestData.getCellData(sheetName,"UserName",row);
			//String Password = TestData.getCellData(sheetName,"Password",row);
			////String StoreId = TestData.getCellData(sheetName,"StoreId",row); 
			//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
			System.out.println(AdminURL);
			test.log(LogStatus.INFO, "Scheduler-Store Aging");

			System.out.println(ProductID);	
			//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
			//appUrl = AppURL;
			Login.Login(UserName, Password, StoreId);
			String SSN1 = SSN.substring(0, 3);
			String SSN2 = SSN.substring(3,5);
			String SSN3 = SSN.substring(5,9);
			Thread.sleep(2000);
			driver.switchTo().frame("topFrame");
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


			/*if(ProductID.equals("PDL"))
	{*/

			Thread.sleep(2000);
			//	/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]
			driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
			//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[11]/input[1]")).click();
			/*	                          //   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
	}*/
			//  driver.findElement(By.name("button")).click();
			test.log(LogStatus.PASS, "Click on GO Button");
			for( String winHandle1 : driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle1);
			}			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			driver.findElement(By.name("transactionList")).sendKeys("ACH Pre-Payment");
			/*	if(ProductID.equals("LOC"))
	{*/
			//*[@id="go_Button"]
			driver.findElement(By.xpath("//*[@id='go_Button']")).click();
			test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
			//driver.findElement(By.name("button")).click(); 
			//}
			try { 
				Alert alert = driver.switchTo().alert();
				alert.accept();
				//if alert present, accept and move on.														

			}
			catch (NoAlertPresentException e) {
				//do what you normally would if you didn't have the alert.

			}

			for( String winHandle1 : driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle1);
			}			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");



			//String PmtAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
			driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
			driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys("200");
			driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Cash");
			test.log(LogStatus.PASS, "TenderType Select as ::Cash");
			driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys("200");
			test.log(LogStatus.PASS, "TenderAmount Entered is::100");
			//transactionDataBean.tenderTypeSecond
			driver.findElement(By.name("requestBean.password")).sendKeys(Password);
			test.log(LogStatus.PASS, "Passwor Entered as::"+Password);
			driver.findElement(By.name("Submit22")).click();
			test.log(LogStatus.PASS, "Clicked on Finish ACH PrePayment Button");

			try { 
				Alert alert = driver.switchTo().alert();
				alert.accept();
				//if alert present, accept and move on.														

			}
			catch (NoAlertPresentException e) {
				//do what you normally would if you didn't have the alert.

			}
			try { 
				Alert alert = driver.switchTo().alert();
				alert.accept();
				//if alert present, accept and move on.														

			}
			catch (NoAlertPresentException e) {
				//do what you normally would if you didn't have the alert.

			}

			for( String winHandle1 : driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle1);
			}			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");

			if(driver.findElement(By.xpath("//*[@id='totPart']/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/p[2]/input[1]")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[@id='totPart']/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/p[2]/input[1]")).click();
				test.log(LogStatus.PASS, "Clicked on Confirmation Yes Button");
			}		

			//*[@id="totPart"]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/p[2]/input[1]      Confirm Yes button

			//String CheckStaus=null;
			/*	//	CheckStaus = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[6]/td[3]/span[2]")).getText();
	CheckStaus = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();
	//CheckStaus1 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[4]/td[5]")).getText();
	if((CheckStaus).contains("Deposit"))
	{
		test.log(LogStatus.PASS,"CheckStatus is  Displayed as::"+CheckStaus);
	}
	else
	{
		test.log(LogStatus.PASS,"CustomerEOD Record is not Displayed.");
	}*/

		}
	}
}
}

