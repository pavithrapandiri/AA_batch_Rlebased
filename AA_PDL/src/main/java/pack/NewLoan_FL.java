



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

	public class NewLoan_FL  extends AA_PDL{
		
		public static void NewLoan_FL(String SSN,String FileName) throws Exception
		{
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
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					//String ProductName = prop.getProperty("ProductName");
					String ProductName = TestData.getCellData(sheetName,"ProductName",row);
					String stateProductType=State+" "+ProductType;
					String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					System.out.println(ESign_CollateralType);
					String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
					String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
					String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
					String ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);
					String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
					String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);			
					String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
					System.out.println(last4cheknum);
					System.out.println(stateProductType);
					String Parent_Window = driver.getWindowHandle();
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					test.log(LogStatus.INFO, "Navigate New Loan ");
					if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
					{

						int rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")).size();

						test.log(LogStatus.INFO, "Rows count :: "+rows);

						for (int a=2;a<=rows;a++)
						{
							String prod = driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]")).getText();
							test.log(LogStatus.INFO, "Product name is :: "+prod);
							if (prod.equals(ProductName))
							{

								Thread.sleep(3000);				
								 driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/input")).click();                          
								//driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")).click();
								test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
							}
						}
						Thread.sleep(1000);
						driver.findElement(By.name("ShareScreenBtn")).click();

						test.log(LogStatus.PASS, "ShareScreen Button clicked");

						for( String winHandle1 : driver.getWindowHandles())

						{

							if(!(winHandle1.equals(Parent_Window)))

							{

								driver.switchTo().window(winHandle1);
								Thread.sleep(2000);
								driver.findElement(By.name("confirmSummary")).click();
								test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");
							}

						}
						Thread.sleep(2000);
						driver.switchTo().window(Parent_Window);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(By.id("LoanButtonId")).click();
						test.log(LogStatus.PASS, "Clicked on New Loan button");
			
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						if(!(ESign_LoanAmt.isEmpty()))
						{
							driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[13]/td[3]/input")).sendKeys(ESign_LoanAmt);
							test.log(LogStatus.PASS, "Loan amount is enterted as "+ESign_LoanAmt);
						}
						try{
							driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
							test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as : "+last4cheknum);	
							Thread.sleep(1000);
						}
						catch(Exception e){
							test.log(LogStatus.PASS, "	Disb type not a check ");	
						}// advanceRequestBean.disbAmtFirst
						driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);
						test.log(LogStatus.PASS, "Disb Type is Selected as "+ESign_DisbType);
						Thread.sleep(1000);
						String Instamt=driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
						System.out.println(Instamt);
						driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Instamt);

						test.log(LogStatus.PASS, "Disb Amt is enterted as "+Instamt);
						Thread.sleep(1000);
						driver.findElement(By.name("advanceRequestBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Electronic Communication Consent is selected as "+ESign_CourtesyCallConsent);
						Thread.sleep(1000);
						try{
							if(ESign_CollateralType.equalsIgnoreCase("Check"))
							{
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@id='idNoChecks']/td[3]/select")).sendKeys(ESign_Checks);

								test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Checks);
								WebDriverWait wait2 = new WebDriverWait(driver, 1000);	
								wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chkNbr0']")));
								driver.findElement(By.xpath("//*[@id='chkNbr0']")).sendKeys(ESign_CheckNbr);
								test.log(LogStatus.PASS, "Check number is "+ESign_CheckNbr);
							}
						}
						catch(Exception e){
							test.log(LogStatus.PASS, "disb is not check");
						}
						driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);
						test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
						driver.findElement(By.name("finishadvance")).click();
						test.log(LogStatus.PASS, "click on Finish Loan button ");
						Thread.sleep(3000);

						try { 
							Alert alert = driver.switchTo().alert();
							alert.accept();	
							driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Instamt);
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
							try{
								Alert alert1 = driver.switchTo().alert();
								alert1.accept();
							}
							catch(NoAlertPresentException e){
								test.log(LogStatus.PASS, "No alert encountered ");	
							}
						}							
						catch (NoAlertPresentException e) {
						}
					/*	try{
						driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Instamt);
						driver.findElement(By.name("finishadvance")).click();
						test.log(LogStatus.PASS, "click on Finish Loan button ");
						try{
							Alert alert = driver.switchTo().alert();
							alert.accept();
						}
						catch(NoAlertPresentException e){
							test.log(LogStatus.PASS, "No alert encountered ");	
						}
						}
						catch(Exception e){
							test.log(LogStatus.PASS, "Disb is entered in the first instance ");
						}*/
						for( String winHandle1 : driver.getWindowHandles())
						{
							driver.switchTo().window(winHandle1);
						}			
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id='OKBut']")).click();	
						test.log(LogStatus.PASS, "clicked on Yes button ");
						if(driver.findElement(By.name("Ok")).isDisplayed())
						{
							driver.findElement(By.name("Ok")).click();
							test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
						}
						else
						{
							test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
						}
					}		
				}
			}
		}
		
	}
		
		

	
	

		



