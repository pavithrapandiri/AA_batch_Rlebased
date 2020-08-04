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

public class Payments_Partial extends AA_LOC {
	public static void Payments_Partial(String SSN,String FileName) throws Exception{


		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/LOC/"+FileName);	
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
				Thread.sleep(5000);
				//driver.get(appUrl);		
				// for(String winHandle : driver.getWindowHandles()){
				//	    driver.switchTo().window(winHandle);
				//	}
				//driver.manage().window().maximize();
				
				Login.Login(UserName, Password, StoreId);
				driver.switchTo().defaultContent();	
				Thread.sleep(1000);
				driver.switchTo().frame("topFrame");
				test.log(LogStatus.INFO, "Payment with-SSN: " +SSN +" :: Starts");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
					///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
				}
				//  driver.findElement(By.name("button")).click();
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
				if(ProductID.equals("LOC"))
				{

					// String Pmt= driver.findElement(By.name("currentBalance")).getAttribute("value");
					// String Pmt= driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]")).getText();
					// /html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]
					// name="requestBean.paymentAmt"
					driver.findElement(By.name("requestBean.paymentAmt")).clear();
					driver.findElement(By.name("requestBean.paymentAmt")).sendKeys("30");
					driver.findElement(By.name("requestBean.tenderType")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is Selected as "+TenderType);	
					driver.findElement(By.name("requestBean.tenderAmt")).sendKeys("30");
					test.log(LogStatus.PASS, "Tender Amt is entered as ::  Pmt");							
					driver.findElement(By.name("password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is selected as "+Password);			
					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Payment button ");

					Thread.sleep(2000);

					/* driver.findElement(By.id("btnADV_Yes")).click();
											test.log(LogStatus.PASS, "Clicked on Navigate to  Payoff Screen button ");																	


											 driver.switchTo().defaultContent();
											 driver.switchTo().frame("mainFrame");
											 driver.switchTo().frame("main");

											 String Pmt1= driver.findElement(By.name("payOffAmount")).getAttribute("value");
											 driver.findElement(By.name("tenderType")).sendKeys(TenderType);
											 test.log(LogStatus.PASS, "Tender Type is Selected as "+TenderType);	
											driver.findElement(By.name("tenderAmount")).sendKeys(Pmt1);
											test.log(LogStatus.PASS, "Tender Amt is entered as "+Pmt1);							
											 driver.findElement(By.name("password")).sendKeys(Password);
											 test.log(LogStatus.PASS, "Password is selected as "+Password);			
											 driver.findElement(By.name("Submit22")).click();
												test.log(LogStatus.PASS, "Clicked on Finish payOff button ");


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
												}*/
					/*		

										 try { 
											    Alert alert = driver.switchTo().alert();
											    alert.accept();
											    //if alert present, accept and move on.														

											}
											catch (NoAlertPresentException e) {



											    //do what you normally would if you didn't have the alert.
											}
					 */
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(2000);
					Thread.sleep(2000);
					/*	 if(driver.findElement(By.name("Ok")).isDisplayed())
												{*/
					test.log(LogStatus.INFO, "Payment with-SSN: " +SSN +" :: is Successful");
					/* driver.findElement(By.name("Ok")).click();*/
					/*	}
											 else
												{
													test.log(LogStatus.FAIL, "Payment not Completed Successfully ");
												}*/


				}

			}

		}
	}

	 				}
