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

public class PAM_WPN_Perform extends AA_PDL{
	public static void PAM_WPN_Perform (String SSN,String FileName,String Instnum) throws Exception{


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

				String SSN1 = SSN.substring(0, 3);

				String SSN2 = SSN.substring(3,5);

				String SSN3 = SSN.substring(5,9);


				PAMLogin.PAMLogin();

				/*	

	Login.Login(UserName, Password, StoreId);
				 */Thread.sleep(3000);
				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				//driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();
              driver.findElement(By.linkText("Loan Transactions")).click();
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


					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();

				}

				// driver.findElement(By.name("button")).click();

				test.log(LogStatus.PASS, "Click on GO Button");

				for( String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("transactionList")).sendKeys("WPN");

				test.log(LogStatus.PASS, "TxnType is selected as :: WPN");

				if(ProductID.equals("PDL"))

				{

					driver.findElement(By.name("button")).click();

				}


				try {

					Alert alert = driver.switchTo().alert();

					alert.accept();

					//if alert present, accept and move on.

				}

				catch (NoAlertPresentException e) {

					//do what you normally would if you didn't have the alert.

				}
				//driver.findElement(By.name("transactionList")).sendKeys("Partial Payment");



				for( String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				if(ProductID.equals("PDL"))

				{
                          driver.findElement(By.name("wapOption")).click();
                          driver.findElement(By.name("wapInstNo")).sendKeys(Instnum);
					// driver.findElement(By.name("requestBean.tenderType")).sendKeys(TenderType);

					//String Pmt= driver.findElement(By.name("htmlPayAmt")).getAttribute("value");

					// System.out.println(Pmt);
					driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[3]/tbody/tr[8]/td[2]/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked on Next");

					for( String winHandle1 : driver.getWindowHandles())

					{

						driver.switchTo().window(winHandle1);

					}

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					
					
					driver.findElement(By.name("collateralTypeId")).sendKeys("ACH");
					test.log(LogStatus.PASS, "collateral is selected as ACH");


					driver.findElement(By.name("password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is selected as "+Password);


					driver.findElement(By.name("submitBtn")).click();				
					test.log(LogStatus.PASS, "Clicked on Finish WPN");

					Thread.sleep(1000);			


					for( String winHandle1 : driver.getWindowHandles())

					{

						driver.switchTo().window(winHandle1);

					}

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					// /html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/p/input[2]
					
					       driver.findElement(By.name("checkyes")).click();
					
						test.log(LogStatus.PASS, "WPN Completed Successfully ");

						
						//*[@id="OKBut"]
					

					



				}

			}

		}

	}
	public static void PAM_Notallow_WPN (String SSN,String FileName,String Instnum) throws Exception{


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

				String SSN1 = SSN.substring(0, 3);

				String SSN2 = SSN.substring(3,5);

				String SSN3 = SSN.substring(5,9);


				PAMLogin.PAMLogin();

				/*	

	Login.Login(UserName, Password, StoreId);
				 */Thread.sleep(3000);
				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				//driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();
              driver.findElement(By.linkText("Loan Transactions")).click();
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


					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();

				}

				// driver.findElement(By.name("button")).click();

				test.log(LogStatus.PASS, "Click on GO Button");

				for( String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				/*driver.findElement(By.name("transactionList")).click();
				 
				Select wpn = new Select(driver.findElement(By.name("transactionList")));
				wpn.deselectByVisibleText("WPN");*/
				
				/*List<WebElement> l=driver.findElements(By.xpath("//*[@name='transactionList']/option"));
				int list=l.size();
				for (int i = 1; i<l.size(); i++) {
					//String value = driver.findElement(By.xpath("(//*[@name='collateralTypeId']/option)["+j+"]")).getText();
					String value = driver.findElement(By.xpath("(//*[@name='transactionList']/option)["+i+"]")).getText();
					test.log(LogStatus.PASS, "Tansaction values "+value);
					if(value.equals("WPN")){
						test.log(LogStatus.PASS, "WPN not displayed");
					}
					else{
						test.log(LogStatus.FAIL, "WPN  displayed");
					}
				}
				*/
				 Select trans = new Select(driver.findElement(By.name("transactionList")));
				 List<WebElement> elementcount = trans.getOptions();
				 int isize = elementcount.size();
				 for (int i = 0; i < isize; i++) {
					 String svalue = elementcount.get(i).getText();
					 test.log(LogStatus.PASS, "transaction dropdown value:" +svalue);
					 if(svalue.equalsIgnoreCase("WPN"))
					 {
						 test.log(LogStatus.FAIL, "wpn is displyed");
					 }
					 else
					 {
						 test.log(LogStatus.PASS, "wpn is not displayed");
					 }
					
				}
						 
				
				//List<WebElement> l=driver.findElements("//*[@name='transactionList']/option").

				//driver.findElement(By.name("transactionList")).sendKeys("WPN");

				//test.log(LogStatus.PASS, "TxnType is Notselected as :: WPN");

				/*if(ProductID.equals("PDL"))

				{

					driver.findElement(By.name("button")).click();

				}


				try {

					Alert alert = driver.switchTo().alert();

					alert.accept();

					//if alert present, accept and move on.

				}

				catch (NoAlertPresentException e) {

					//do what you normally would if you didn't have the alert.

				}
				//driver.findElement(By.name("transactionList")).sendKeys("Partial Payment");



				for( String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				if(ProductID.equals("PDL"))

				{
                          driver.findElement(By.name("wapOption")).click();
                          driver.findElement(By.name("wapInstNo")).sendKeys(Instnum);
					// driver.findElement(By.name("requestBean.tenderType")).sendKeys(TenderType);

					//String Pmt= driver.findElement(By.name("htmlPayAmt")).getAttribute("value");

					// System.out.println(Pmt);
					driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[3]/tbody/tr[8]/td[2]/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked on Next");

					for( String winHandle1 : driver.getWindowHandles())

					{

						driver.switchTo().window(winHandle1);

					}

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					
					
					driver.findElement(By.name("collateralTypeId")).sendKeys("ACH");
					test.log(LogStatus.PASS, "collateral is selected as ACH");


					driver.findElement(By.name("password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is selected as "+Password);


					driver.findElement(By.name("submitBtn")).click();				
					test.log(LogStatus.PASS, "Clicked on Finish WPN");

					Thread.sleep(1000);			


					for( String winHandle1 : driver.getWindowHandles())

					{

						driver.switchTo().window(winHandle1);

					}

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					// /html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/p/input[2]
					
					       driver.findElement(By.name("checkyes")).click();
					
						test.log(LogStatus.PASS, "WPN Completed Successfully ");

						
						//*[@id="OKBut"]
					

					



				}*/

			}

		}

	}
}

			
		
