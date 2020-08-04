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


public class SafeDeAssign extends AA_PDL {
	public static void SafeDeAssign(String SSN,String FileName) throws Exception{

		////Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL/"+FileName);
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
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				//String UserName = TestData.getCellData(sheetName,"UserName",row);
				//String Password = TestData.getCellData(sheetName,"Password",row);
				//String StoreId = TestData.getCellData(sheetName,"StoreId",row);

				Login.Login(UserName, Password, StoreId);
				Thread.sleep(2000);
				driver.switchTo().defaultContent();				
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Cash Management");
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Safe")).click();
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Clicked on Assign");	
				driver.findElement(By.linkText("Deassign")).click();
				test.log(LogStatus.PASS, "Clicked on DeAssign");
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				//name="safeDeassignRequestBean.noOf100Dollars"
				driver.findElement(By.name("safeDeassignRequestBean.noOf100Dollars")).sendKeys("0");
				test.log(LogStatus.PASS, "safeAssignRequestBean.noOf100Dollars entered is  0");
				driver.findElement(By.name("safeDeassignRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "Password is Entered ");
				driver.findElement(By.name("safedeassign")).click();
				test.log(LogStatus.PASS, "Clicked on Safe DeAssigen Button");

				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();

				}
				catch (NoAlertPresentException e) {

				}
				try{
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(2000);
					if(AA_TN_PDL.Field(driver) != null )
					{
					driver.findElement(By.name("safeDeassignRequestBean.password")).clear();
					driver.findElement(By.name("safeDeassignRequestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is Entered ");
					driver.findElement(By.name("safedeassign")).click();
					test.log(LogStatus.PASS, "Clicked on Safe DeAssigen Button");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(2000);
					//	name="safeRequestBean.safeOverShort"
					String SafeOverShortAmt = driver.findElement(By.name("safeRequestBean.safeOverShort")).getAttribute("value");	
					// safeRequestBean.amount
					driver.findElement(By.name("safeRequestBean.amount")).sendKeys(SafeOverShortAmt);
					test.log(LogStatus.PASS, "safeRequestBean amount is entered as :: "+SafeOverShortAmt);
					//safeRequestBean.primary
					driver.findElement(By.name("safeRequestBean.primary")).sendKeys("Counterfeit Bill");
					test.log(LogStatus.PASS, "Primary reason for Deassign is entered as :: Counterfeit Bill");
					// safeRequestBean.notes
					driver.findElement(By.name("safeRequestBean.notes")).sendKeys("Safe DeAssign for Counterfeit Bill");
					test.log(LogStatus.PASS, "Notes entered is ::Safe DeAssign for Counterfeit Bill");
					driver.findElement(By.name("bt_AddDrawer")).click();
					test.log(LogStatus.PASS, "Clicked on Add O/S  Button");
					driver.findElement(By.name("transactionDataBean.password")).clear();
					driver.findElement(By.name("transactionDataBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is Entered ");
					driver.findElement(By.xpath("//input[@value='Finish Safe O/S' and @type='button']")).click();
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();

					}
					catch (NoAlertPresentException e) {

					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@value='Ok' and @type='submit']")).click();
				}
				}

				catch (NoAlertPresentException e) {

				}
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				Thread.sleep(2000);
		/*		try { 
					driver.findElement(By.xpath("//input[@value='Ok' and @type='submit']")).click();

				}
				catch (NoAlertPresentException e) {

				}*/
			
				// finishdeposit
			}
			
		}
}
