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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Payment_LessthanAmount extends AA_CO_ILP{

	public static void Payment_LessthanAmount (String SSN,String FileName) throws Exception{
		
		
		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/CO_ILP/Local/"+FileName);	
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
					// String StoreId = TestData.getCellData(sheetName,"StoreID",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					Thread.sleep(5000);

					Login.Login(UserName, Password, StoreId);
				 	Thread.sleep(5000);
					driver.switchTo().defaultContent();
				
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
					    
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();		 
			/*		    if(ProductID.equals("ILP"))
						 {
					    	///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
					    	driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					    	// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input
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
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 if(ProductID.equals("ILP"))
						 {
							  driver.findElement(By.name("button")).click();
							// String PastDueAmt = null;
							 String InstAmt = null;
							 double Pymt;
							
							//*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[22]/td/span[2]
						                                            
							// PastDueAmt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[22]/td/span[2]")).getText();
							 InstAmt = driver.findElement(By.xpath("//*[@id='ContractScheduleTable']/tbody/tr[2]/td[5]")).getText();
						 
							// double PDA = double.valueOf(PastDueAmt);
							 
							 //double PDA = Double.valueOf(PastDueAmt);
							 
							 double InstAmount = Double.valueOf(InstAmt);
							 
							 Pymt =  InstAmount-10.0;
							 String Payment = String.valueOf(Pymt);
						 
						 driver.close();
						 

						 driver = new InternetExplorerDriver();

						 driver.get(AppURL);
						 
						// CSRLoginpage login = new CSRLoginpage();
						 Login.Login(UserName, Password, StoreId);
						driver.switchTo().defaultContent();
						Thread.sleep(5000);
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
						    
						 
						    if(ProductID.equals("ILP"))
							 {
						    	///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
					    	driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						    //	 /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input
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
							 driver.findElement(By.name("transactionList")).sendKeys("Payment");
						 
						 for( String winHandle1 : driver.getWindowHandles())
							{
							 driver.findElement(By.name("button")).click();
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 if(ProductID.equals("ILP"))
							 {
							
								driver.findElement(By.xpath("//*[@id='PD5']")).click();
								
								//CharSequence Payment;
								 driver.findElement(By.name("requestBean.siilBean.payAmt")).clear();
								driver.findElement(By.name("requestBean.siilBean.payAmt")).sendKeys(Payment);
								test.log(LogStatus.PASS, "Payment Amount (past due +installment amount): "+Payment);
								 driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
								 test.log(LogStatus.PASS, "Tender Type is Selected as ::Cash");	
								driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(Payment);
								test.log(LogStatus.PASS, "Tender Amount (past due +installment amount) "+Payment);						
								 driver.findElement(By.name("requestBean.password")).sendKeys(Password);
								 test.log(LogStatus.PASS, "Password is selected as "+Password);			
								 driver.findElement(By.name("finish")).click();
									test.log(LogStatus.PASS, "Clicked on Finish Payment button ");
								 
								 Thread.sleep(2000);							
									 
									 
										try { 
										    Alert alert = driver.switchTo().alert();
										    alert.accept();
										    //if alert present, accept and move on.														
											
										}
										catch (NoAlertPresentException e) {
										    //do what you normally would if you didn't have the alert.
										}
										
										 test.log(LogStatus.INFO, "Payment with-SSN: " +SSN +" :: is Successful");
										
								/*		try { 
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
								/*	for( String winHandle1 : driver.getWindowHandles())
									{
									    driver.switchTo().window(winHandle1);
									}			
									 driver.switchTo().defaultContent();
									 driver.switchTo().frame("mainFrame");
									 driver.switchTo().frame("main");
										Thread.sleep(2000);
										
									 if(driver.findElement(By.name("checkno")).isDisplayed())
										{
										 
										 driver.findElement(By.name("checkno")).click();
										 test.log(LogStatus.INFO, "Payment with-SSN: " +SSN +" :: is Successful");
										}
									 else
										{
											test.log(LogStatus.FAIL, "Payment not Completed Successfully ");
										}
								*/
						    	
							 }
						
				}
				
			}
			}
		}
	
	
	
	
	
	
	
}
