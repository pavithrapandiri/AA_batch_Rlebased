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

public class WaiveFee extends AA_LOC {
	public static void WaiveFee(String SSN,String FileName) throws Exception{


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
				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
				String TranID=null;
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(4000);

				String Eankey=null;
				//driver.get(appUrl);		
				// for(String winHandle : driver.getWindowHandles()){
				//	    driver.switchTo().window(winHandle);
				//	}
				//driver.manage().window().maximize();
				//driver = new InternetExplorerDriver();
				
				Login.Login(UserName, Password, StoreId);
				driver.switchTo().defaultContent();	
				Thread.sleep(2000);
				driver.switchTo().frame("topFrame");
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

				String mainwindow=driver.getWindowHandle();
				test.log(LogStatus.PASS, "title is"+mainwindow);
				/*	String TranID = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[9]/td[4]/input")).getText();

							test.log(LogStatus.PASS, "TranId captured:"+TranID);	
							String TranID0[] =TranID.split(":");
							String TranID1 = TranID0[0];
							String TranID2 =  TranID0[1]; */
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
				driver.findElement(By.name("transactionList")).sendKeys("WaiveFee");
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
				Thread.sleep(1000);                                                      	//origTranNbr
				TranID = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[9]/td[4]/input")).getAttribute("value");
				System.out.println(TranID);                                             
				test.log(LogStatus.PASS, "TranId captured:"+TranID);	
				/*String TranID0[] =TranID.split(":");
								String TranID1 = TranID0[0];
								String TranID2 =  TranID0[1]; */
				Thread.sleep(3000);
				//driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[7]/td/input[2]")).click();

				//         	
				//name="NO"





				InternetExplorerDriver driver1= new InternetExplorerDriver();
				driver1.get(AdminURL);


				DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");		
				driver1.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
				test.log(LogStatus.PASS, "Username is entered: admin");			        
				driver1.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "Password is entered: "+Password);					  	        			   
				//Click Login Button
				driver1.findElement(By.name("login")).click();
				test.log(LogStatus.PASS, "Clicked on Submit button");
				Thread.sleep(8000);

				driver1.switchTo().defaultContent();
				driver1.switchTo().frame("topFrame");
				driver1.findElement(By.xpath("//*[contains(text(),'Employee')]")).click();	
				test.log(LogStatus.PASS, "Clicked on Transactions");
				driver1.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver1.switchTo().defaultContent();
				driver1.switchTo().frame("mainFrame");
				driver1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
				driver1.findElement(By.linkText("Encryption Key")).click();
				test.log(LogStatus.PASS, "Clicked on Encryption Key");
				driver1.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver1.switchTo().defaultContent();
				driver1.switchTo().frame("mainFrame");
				driver1.findElement(By.linkText("Encryption")).click();
				test.log(LogStatus.PASS, "Clicked on Encryption");
				Thread.sleep(5000);

				driver1.switchTo().defaultContent();
				driver1.switchTo().frame("mainFrame");
				driver1.switchTo().frame("main");
				driver1.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreId);
				test.log(LogStatus.PASS, "Store number Entered");	
				Thread.sleep(3000);
				driver1.findElement(By.name("requestBean.tranNbr")).sendKeys(TranID);
				test.log(LogStatus.PASS, "Tran number Entered");	

				/*		driver.findElement(By.name("trancd")).sendKeys("Advance-ADV");
			test.log(LogStatus.PASS, "Trancd selected");*/

				/*	driver.findElement(By.name("trancd")).sendKeys("Early pay off-EPAY");
			test.log(LogStatus.PASS, "Trancd selected");*/

				/*	driver.findElement(By.name("trancd")).sendKeys("Payment-PAYIL");
			test.log(LogStatus.PASS, "Trancd selected");*/

				driver1.findElement(By.name("trancd")).sendKeys("Waive Fee-WF");
				test.log(LogStatus.PASS, "Trancd selected");

				driver1.findElement(By.name("GetKey")).click();
				test.log(LogStatus.PASS, "GetKey clicked");

				Eankey = driver1.findElement(By.name("EanKey")).getAttribute("value");
				test.log(LogStatus.PASS, "GetKey clicked:" +Eankey);
				Thread.sleep(2000);
				driver1.close();
				/*driver = new InternetExplorerDriver();
			Login.Login(UserName,Password,StoreId);	
			Thread.sleep(4000);
			driver.switchTo().defaultContent();				
			driver.switchTo().frame("topFrame");
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
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				//driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
			}

			test.log(LogStatus.PASS, "Click on GO Button"); 
			for( String winHandle1 : driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle1);
			}			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			driver.findElement(By.name("transactionList")).sendKeys("WaiveFee");
			test.log(LogStatus.PASS, "Transaction Type is selected as WaiveFee");					
			driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();	*/		 



				test.log(LogStatus.PASS,"title is"+mainwindow);
				driver.switchTo().window(mainwindow);
				test.log(LogStatus.PASS,"title is"+driver.getTitle());	


				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if(ProductID.equals("LOC"))
				{
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[4]/input")).clear();
					String 	Interest=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[3]/input")).getAttribute("value");

					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[4]/input")).sendKeys(Interest);
					test.log(LogStatus.PASS, "Interest Amt is entered as "+Interest);	

					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[8]/td[4]/input")).clear();
					String CustomaryFee=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[8]/td[3]/input")).getAttribute("value");

					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[8]/td[4]/input")).sendKeys(CustomaryFee);
					test.log(LogStatus.PASS, "Interest Amt is entered as "+CustomaryFee);

					driver.findElement(By.name("encryptionKey")).sendKeys(Eankey);
					test.log(LogStatus.PASS, "Encryption Key entered as "+Eankey);
					driver.findElement(By.name("password")).sendKeys(Password);
					driver.findElement(By.name("Submit22")).click();

					test.log(LogStatus.PASS, "Password is selected as "+Password);																					
					test.log(LogStatus.PASS, "Clicked on Finish Waive button ");
					// driver.findElement(By.xpath("//*[@id='btnADV_No']")).click();
					//*[@id="btnADV_Yes"]
					//*[@id="revolvingCreditHistTable"]/tbody/tr[11]/td[2]/span[2]

					//for( String winHandle1 : driver.getWindowHandles())
					//{
					//driver.switchTo().window(winHandle1);
					//}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");


					if(driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/input")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Waive fee Completed Successfully ");
						driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/input")).click();

					}
					else
					{
						test.log(LogStatus.FAIL, "waive fee not Completed Successfully ");
					}




				}

			}

		}
	}
	 				}
