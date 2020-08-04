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

public class NewLoanRule extends AA_PDL{
	public static void NewLoanRule(String SSN,String FileName) throws Exception{

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
					String State = TestData.getCellData(sheetName,"StateID",row);
					String ProductID=TestData.getCellData(sheetName,"ProductID",row);
					System.out.println(ProductID);
					//String UserName = TestData.getCellData(sheetName,"UserName",row);
					//String Password = TestData.getCellData(sheetName,"Password",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String ProductName = TestData.getCellData(sheetName,"ProductName",row);
					String VehicleType= TestData.getCellData(sheetName,"VehicleType",row);
					String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
					////String StoreId = TestData.getCellData(sheetName,"StoreId",row); 
					String stateProductType=State+" "+ProductType;
					String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					System.out.println(ESign_CollateralType);
					String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
					String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
					String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
					String AllowPromotion = TestData.getCellData(sheetName,"Allow Promotion",row);
					String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
					String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
					String ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);
					String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
					String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);			
					String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
					System.out.println(last4cheknum);
					System.out.println(stateProductType);
					String Parent_Window = driver.getWindowHandle();
					System.out.println(ProductID);	
					//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					//appUrl = AppURL;
					Login.Login(UserName, Password, StoreId);
					 String SSN1 = SSN.substring(0, 3);
					 String SSN2 = SSN.substring(3,5);
					 String SSN3 = SSN.substring(5,9);
					 Thread.sleep(2000);
					 driver.switchTo().frame("topFrame");
					 //driver.findElement(By.name("//*[contains(text(),'Loan Transactions')]")).click();
					 driver.findElement(By.name("Loan Transactions")).click();
					 test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 driver.findElement(By.xpath("//*[@id='911100']/a")).click();
					 test.log(LogStatus.PASS, "Clicked on NewLoan");		
					 driver.switchTo().frame("main");		
					 driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					 test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					 driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					 test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					 driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					 test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
					 test.log(LogStatus.PASS, "Click on submit Button");		
					 for(String winHandle : driver.getWindowHandles()){
						 driver.switchTo().window(winHandle);
					 }
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					 driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[8]/input")).click();
					 test.log(LogStatus.PASS, "Click on GO Button");
					 for(String winHandle : driver.getWindowHandles()){
						 driver.switchTo().window(winHandle);
					 }				    
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					 int count = 1;
					 for(int i=1;i<=count;i++)
						 
						 if(driver.findElement(By.xpath("//*[@id='errMsg']/ul/li")).isDisplayed())
						 {
							 Thread.sleep(2000);
							 String message = driver.findElement(By.xpath("//*[@id='errMsg']/ul/li")).getText();
							 test.log(LogStatus.PASS, "Maximum loans given and the message displayed is:"+ message);
							 int LoanCount = i ;
							 test.log(LogStatus.PASS, "Maximum loans given is :"+ LoanCount);
						 }
						 else
						 {
							 NewLoan.NewLoan(SSN, FileName);
						 }

				}
			}
		}


	}


	}
