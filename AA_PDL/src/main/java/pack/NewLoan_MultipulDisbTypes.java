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

public class NewLoan_MultipulDisbTypes extends AA_PDL{
	public static void NewLoan_MultipulDisbTypes(String SSN,String FileName) throws Exception{



		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL/"+FileName);
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
				String ProductName = prop.getProperty("ProductName");
				//String ProductName = TestData.getCellData(sheetName,"ProductName",row);
				String VehicleType= TestData.getCellData(sheetName,"VehicleType",row);
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				//String StoreID = TestData.getCellData(sheetName,"StoreID",row); 
				String stateProductType=State+" "+ProductType;
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				System.out.println(ESign_CollateralType);
				String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
				String Esign_DisbType1 = TestData.getCellData(sheetName,"Esign_DisbType1",row);
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
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				} 
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				try{
				 if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
				 {
					 //driver.findElement(By.xpath("//input[contains(text(),"+stateProduct+")]")).click();
				//test.log(LogStatus.PASS, "Borrower is Registered Successfully with SSN as " +SSN);	
						//WebElement htmltable=driver.findElement(By.xpath("//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));	

					 int rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")).size();
						//List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
					 test.log(LogStatus.INFO, "Rows count :: "+rows);
					 
						for (int a=2;a<=rows;a++)
						{
							                         
							//String prod = driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).getText();
							String prod = driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]")).getText();
							test.log(LogStatus.INFO, "Product name is :: "+prod);
							if (prod.equals(ProductName))
							{
							
								Thread.sleep(3000);
								//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")));
								//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input
								//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/input
								 //driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")).click();

								driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")).click();
								test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
							}
						}
						Thread.sleep(1000);
						WebDriverWait wait = new WebDriverWait(driver, 10);
						
						// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]
						// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]
						// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]
						
						
				 }
				}
						// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/input
						// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input
						// //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/input

						 catch(Exception e){
							 test.log(LogStatus.PASS, "Single product exists");	 
						 }
					
					driver.findElement(By.name("ShareScreenBtn")).click();
				test.log(LogStatus.PASS, "ShareScreen Button clicked");
			
				/*if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
				{
					if(ProductName.equals("TNPAYDAY"))
					{
						driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input")).click();

						test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);

					}

					if(ProductName.equals("TNPDL all coll"))

						driver.findElement(By.name("prodSel")).click();

						test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);

					}

				driver.findElement(By.name("ShareScreenBtn")).click();
				test.log(LogStatus.PASS, "ShareScreen Button clicked");*/
				for( String winHandle1 : driver.getWindowHandles())

				{
					if(!(winHandle1.equals(Parent_Window)))
					{
						driver.switchTo().window(winHandle1);
						Thread.sleep(1000);
						driver.findElement(By.name("confirmSummary")).click();
						test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");
					}

				}
				Thread.sleep(2000);
				driver.switchTo().window(Parent_Window);

				for( String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}                    

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

					driver.findElement(By.id("LoanButtonId")).click();


					test.log(LogStatus.PASS, "Clicked on New Loan button");

					if(ProductID.equals("PDL"))

					{ 


						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);

						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

						if(!(ESign_LoanAmt.isEmpty()))

						{

							driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[13]/td[3]/input")).sendKeys(ESign_LoanAmt);

							test.log(LogStatus.PASS, "Loan amount is enterted as "+ESign_LoanAmt);

						}

						driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);

						test.log(LogStatus.PASS, " Chkg Acct Nbr(Last 4 Digits Only) is enterted as "+last4cheknum);
						Select cash = new Select(driver.findElement(By.name("advanceRequestBean.disbursementTypeSecond")));
						cash.selectByVisibleText("Cash");
						

						driver.findElement(By.name("advanceRequestBean.disbursementTypeSecond")).sendKeys("Check");

						test.log(LogStatus.PASS, "Disb Type1 is selected as ::Check");

						//driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);

						//test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

						Thread.sleep(1000);
						
						String TotAmt = driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
						
						Double totamt1 = Double.valueOf(TotAmt);
						
						Double totamt2 = totamt1-100;
						String totamt3 = String.valueOf(totamt2);

						driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(totamt3); 

						test.log(LogStatus.PASS, "Disb Amt is enterted as :: "+totamt3);


						//driver.findElement(By.name("advanceRequestBean.disbursementTypeSecond")).sendKeys("Cash");

						test.log(LogStatus.PASS, "Disb Type2 is selected as ::Cash");

						driver.findElement(By.name("advanceRequestBean.disbAmtSecond")).sendKeys("100");

						test.log(LogStatus.PASS, "Disb Amt1 is enterted as 100");

						driver.findElement(By.name("advanceRequestBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);

						test.log(LogStatus.PASS, "Electronic Communication Consent is selected as "+ESign_CourtesyCallConsent);

						if(ESign_CourtesyCallConsent.equals("Yes"))

						{

							if(ESign_Preference.equals("Call")) 

							{

								driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							}

							if(ESign_Preference.equals("Mail")) 

							{

								driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							}

							if(ESign_Preference.equals("SMS")) 

							{

								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);


								try { 

									Alert alert = driver.switchTo().alert();

									alert.dismiss();


								}

								catch (NoAlertPresentException e) {

									//do what you normally would if you didn't have the alert.

								}

							}


						}

						if(AllowPromotion.equals("Yes"))

						{

							driver.findElement(By.xpath("//*[@id='allowCoupons']/td[3]/input")).click();

							test.log(LogStatus.PASS, "AllowPromotion is selected ");

							driver.findElement(By.xpath("//*[@id='coupon']/td[3]/div[1]/input")).sendKeys(CouponNbr);

							test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);

						}

						driver.findElement(By.xpath("//*[@id='idNoChecks']/td[3]/select")).sendKeys(ESign_Checks);

						test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Checks);

						WebDriverWait wait1 = new WebDriverWait(driver, 1000); 

						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chkNbr0']")));

						driver.findElement(By.xpath("//*[@id='chkNbr0']")).sendKeys(ESign_CheckNbr);

						test.log(LogStatus.PASS, "Check number is "+ESign_CheckNbr);

						driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);

						test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);

						driver.findElement(By.name("finishadvance")).click();

						test.log(LogStatus.PASS, "click on Finish Loan button ");

						try { 

							Alert alert = driver.switchTo().alert();

							alert.accept();


						}

						catch (NoAlertPresentException e) {


						}

						try { 

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

						driver.findElement(By.xpath("//*[@id='OKBut']")).click(); 

						test.log(LogStatus.PASS, "click on Yes button ");

						for( String winHandle1 : driver.getWindowHandles())

						{

							driver.switchTo().window(winHandle1);

						} 

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						driver.switchTo().frame("bdyLoad");

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

