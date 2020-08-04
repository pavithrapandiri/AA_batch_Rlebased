package pack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Payment_Payoff extends AA_LOC {
	public static void Payment_Payoff(String SSN,String FileName) throws Exception
	{
		
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LOC/"+FileName);	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";		
		test.log(LogStatus.INFO, "Payment Payoff Transaction");
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
				//String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				 //  appUrl = AppURL;
				Login.Login(UserName, Password, StoreId);
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
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
				    
				 
				    if(ProductID.equals("LOC"))
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
					 driver.findElement(By.name("transactionList")).sendKeys("Payments");
					 if(ProductID.equals("LOC"))
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
						 
						String pmtamt =  driver.findElement(By.name("totalOwed")).getAttribute("value");
						
					
							driver.findElement(By.name("requestBean.tenderType")).sendKeys(TenderType);
							test.log(LogStatus.PASS, "TenderType is entered: "+TenderType);
							driver.findElement(By.name("requestBean.tenderAmt")).sendKeys(pmtamt);
							test.log(LogStatus.PASS, "tenderAmt is entered: "+pmtamt);
							driver.findElement(By.name("password")).sendKeys(Password);
							test.log(LogStatus.PASS, "Password is entered: "+Password);
							driver.findElement(By.name("Submit22")).click();
							test.log(LogStatus.PASS, "Clicked on finishpayment Button");	

							 for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(By.id("btnADV_Yes")).click();
									test.log(LogStatus.PASS, "Clicked on finishpayment Button");
								 
								 								 
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
								 
									String pmtamt1 =  driver.findElement(By.name("payOffAmount")).getAttribute("value");
									
									
									driver.findElement(By.name("tenderType")).sendKeys(TenderType);
									test.log(LogStatus.PASS, "TenderType is entered: "+TenderType);
									driver.findElement(By.name("tenderAmount")).sendKeys(pmtamt1);
									test.log(LogStatus.PASS, "tenderAmt is entered: "+pmtamt);
									driver.findElement(By.name("password")).sendKeys(Password);
									test.log(LogStatus.PASS, "Password is entered: "+Password);
									driver.findElement(By.name("Submit22")).click();
									test.log(LogStatus.PASS, "Click on finishpayment Button");	
									if(driver.findElement(By.name("ok")).isDisplayed())
									{
										driver.findElement(By.name("ok")).click();
										test.log(LogStatus.PASS, "Clicked on finishPayoffpayment Button");
										test.log(LogStatus.INFO, "Payment Payoff is completed");
									}
						
			}
			
		}
	}


	 				}
