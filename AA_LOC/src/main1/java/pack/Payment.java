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

public class Payment extends AA_LOC {
	public static void Payment(String SSN,String FileName) throws Exception{
		
		
		  // Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LOC/"+FileName);	
		   	int lastrow=TestData.getLastRow("NewLoan");
		   	String sheetName="NewLoan";		
		   	test.log(LogStatus.INFO, "Payment Transaction");
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
		   			 String StoreId = TestData.getCellData(sheetName,"StoreID",row);
		   			String SSN1 = SSN.substring(0, 3);
		   			String SSN2 = SSN.substring(3,5);
		   			String SSN3 = SSN.substring(5,9);
		   			// CSRLoginpage login = new CSRLoginpage();
		   			Login.Login(UserName, Password, StoreId);
		   			driver.switchTo().defaultContent();				
		   			driver.switchTo().frame("topFrame");
		   			driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
		   			test.log(LogStatus.PASS, "Clicked on Loan Transactions");
		   			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   			driver.switchTo().defaultContent();
		   			driver.switchTo().frame("mainFrame");
		   			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		   			    	//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
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
		   					 if(ProductID.equals("LOC"))
		   					 {
		   						driver.findElement(By.name("requestBean.paymentAmt")).clear();
		   						driver.findElement(By.name("requestBean.paymentAmt")).sendKeys("20");
		   					
		   						 driver.findElement(By.name("requestBean.tenderType")).sendKeys(TenderType);
		   						 test.log(LogStatus.PASS, "Tender Type is Selected as "+TenderType);	
		   						driver.findElement(By.name("requestBean.tenderAmt")).sendKeys("20");
		   						test.log(LogStatus.PASS, "Tender Amt is entered as 50");							
		   						 driver.findElement(By.name("password")).sendKeys(Password);
		   						 driver.findElement(By.name("Submit22")).click();
		   						 
		   						 test.log(LogStatus.PASS, "Password is selected as "+Password);																					
		   							test.log(LogStatus.PASS, "Clicked on Finish Payment button ");
		   							for( String winHandle1 : driver.getWindowHandles())
		   							{
		   							    driver.switchTo().window(winHandle1);
		   							}			
		   							 driver.switchTo().defaultContent();
		   							 driver.switchTo().frame("mainFrame");
		   							 driver.switchTo().frame("main");
		   							 
		   							 if(driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/input")).isDisplayed())
		   								{
		   								 test.log(LogStatus.PASS, "Payment Completed Successfully ");
		   									driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/input")).click();
		   								}
		   							 else
		   								{
		   									test.log(LogStatus.FAIL, " Payment is not completed ");
		   								}
		   						 
		   				    	
		   					 }
		   				
		   		}
		   		
		   	}
		   }
	 				}
