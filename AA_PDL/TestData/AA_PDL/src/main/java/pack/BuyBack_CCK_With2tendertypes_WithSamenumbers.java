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

public class BuyBack_CCK_With2tendertypes_WithSamenumbers extends AA_PDL{
	public static void BuyBack_CCK_With2tendertypes_WithSamenumbers (String SSN,String FileName) throws Exception{

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
				//String StoreId = TestData.getCellData(sheetName,"StoreID",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(2000);
				Login.Login(UserName, Password, StoreId);	
				driver.switchTo().defaultContent();		
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
				Thread.sleep(2000);
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
				Thread.sleep(2000);
				driver.findElement(By.name("transactionList")).sendKeys("Buy Back");
				test.log(LogStatus.PASS, "Transaction Type is selected as:Buy Back ");	
				driver.findElement(By.id("go_Button")).click();
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if(ProductID.equals("PDL"))
				{
					String PaymentAmt = null;
			      PaymentAmt=driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
			
			      double Pmtamt = Double.valueOf(PaymentAmt);
			      
			
			      Pmtamt =  Pmtamt-100;
			      String Payment = String.valueOf(Pmtamt);
			      
			   driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Cashiers Check");
			   test.log(LogStatus.PASS, "Transaction Type is selected as Cashiers Checkr ");
			   driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys("123456");
			   test.log(LogStatus.PASS, "Enter CC&MO Number as : 123456");
			   driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Payment);
			   test.log(LogStatus.PASS, "Enter tender Amt frist as::"+Payment);
			   
			   
			   driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys("Cashiers Check");
			   test.log(LogStatus.PASS, "Transaction Type is selected as Cashiers Check ");
			   driver.findElement(By.name("transactionDataBean.ccmoNbrSecond")).sendKeys("123456");
			   test.log(LogStatus.PASS, "Enter CC&MO Number as : 123456");
			   driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys("100");
			   test.log(LogStatus.PASS, "Enter tender Amt Second as::100");
			   
			    
					driver.findElement(By.name("transactionDataBean.password")).sendKeys(Password);
					driver.findElement(By.name("finish")).click();
					
					Thread.sleep(3000);

					String alertmsg=driver.switchTo().alert().getText();
					driver.switchTo().alert().accept();
					//alert.accept();
					test.log(LogStatus.PASS, alertmsg);
					test.log(LogStatus.PASS, "BuyBack Loan is not Processed::"+alertmsg);
					
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
					if(driver.findElement(By.name("checkyes")).isDisplayed())
					{
						test.log(LogStatus.PASS, "BuyBack Loan is Completed Successfully ");
						driver.findElement(By.name("checkyes")).click();
					}
					else
					{
						test.log(LogStatus.FAIL, "BuyBack Loan is not Completed Successfully ");
					}*/
				}
											
			}

		}
	}
	}
