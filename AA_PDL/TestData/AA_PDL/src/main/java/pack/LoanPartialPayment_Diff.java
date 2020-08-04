package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;

import com.relevantcodes.extentreports.LogStatus;



public class LoanPartialPayment_Diff extends AA_PDL{
	
	public static void LoanPartialPayment_Diff(String SSN,String FileName) throws Exception
	{
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/TN_PDL/"+FileName);	
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
				String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				//String UserName = TestData.getCellData(sheetName,"UserName",row);
				//String Password = TestData.getCellData(sheetName,"Password",row);
				//String StoreId = TestData.getCellData(sheetName,"StoreID",row);
				String Refno1 = TestData.getCellData(sheetName,"Refno1",row);
				String Refno2 = TestData.getCellData(sheetName,"Refno2",row);
				String TenderType1 = TestData.getCellData(sheetName,"TenderType1",row);
				String TenderType2 = TestData.getCellData(sheetName,"TenderType2",row);
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				//CSRLoginpage login = new CSRLoginpage();
				Login.Login(UserName, Password, StoreId);
				
				Thread.sleep(3000);
				driver.switchTo().defaultContent();				
				driver.switchTo().frame("topFrame");
				WebElement transaction_tab=driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]"));
				wait.until(ExpectedConditions.elementToBeClickable(transaction_tab));
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				
				
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
			
				Thread.sleep(3000);
				WebElement loan_transaction=driver.findElement(By.cssSelector("li[id='911101']"));
				wait.until(ExpectedConditions.elementToBeClickable(loan_transaction));
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
				Thread.sleep(1000);
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
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[11]/input[1]")).click();
				}
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("Partial Payment");
				
				if(ProductID.equals("PDL"))
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
				
				
				if(ProductID.equals("PDL"))
					
				{
										
					if(TenderType.equals("Money Order"))			
					
					{
					
					driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys("20");					
					test.log(LogStatus.PASS, "Payment Amt is entered as 20");
					
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Money Order");
					test.log(LogStatus.PASS, "Tender Type is Selected as Money Order ");
					Thread.sleep(5000);					
					driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys("1234");
					test.log(LogStatus.PASS, "Tender Type ref is 1234");	
					
					Thread.sleep(2000);
									
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys("10");
					test.log(LogStatus.PASS, "Tender1 AMT is 10");
										
						
					driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys("Money Order");
					test.log(LogStatus.PASS, "Tender Type is Selected as "+TenderType);
					Thread.sleep(5000);
					
					driver.findElement(By.name("transactionDataBean.ccmoNbrSecond")).sendKeys("4564");
					test.log(LogStatus.PASS, "Tender Type ref is 1234");
					
					Thread.sleep(2000);
									
					driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys("10");
					test.log(LogStatus.PASS, "Tender2 AMT is 10");
					Thread.sleep(2000);	
					
				}
					
					
					if(TenderType.equals("Cashiers Check"))
						
			{	
						driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys("20");					
					test.log(LogStatus.PASS, "Payment Amt is entered as 20");
					
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Cashiers Check");
					test.log(LogStatus.PASS, "Tender Type is Selected as Cashiers Check");
					Thread.sleep(5000);					
					driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys("1234");
					test.log(LogStatus.PASS, "Tender Type ref is 1234");	
					
					Thread.sleep(2000);
									
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys("10");
					test.log(LogStatus.PASS, "Tender1 AMT is 10");
										
						
					driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys("Cashiers Check");
					test.log(LogStatus.PASS, "Tender Type is Selected as Cashiers Check");
					Thread.sleep(5000);
					
					driver.findElement(By.name("transactionDataBean.ccmoNbrSecond")).sendKeys("4564");
					test.log(LogStatus.PASS, "Tender Type ref in 1234");
					
					Thread.sleep(2000);
									
					driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys("10");
					test.log(LogStatus.PASS, "Tender2 AMT is 10");
					Thread.sleep(2000);	
					
				}
					
					if(TenderType.equals("Cash"))
						
					{	
								driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys("20");					
							test.log(LogStatus.PASS, "Payment Amt is entered as 20");
							
							driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Cash");
							test.log(LogStatus.PASS, "Tender Type is Selected as Cash");									
							
							Thread.sleep(1000);
											
							driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys("10");
							test.log(LogStatus.PASS, "Tender1 AMT is 10");
							Thread.sleep(1000);
								
							driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys("Cash");
							test.log(LogStatus.PASS, "Tender Type is Selected as Cash");
														
							Thread.sleep(2000);
											
							driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys("10");
							test.log(LogStatus.PASS, "Tender2 AMT is 10");
							Thread.sleep(2000);	
							
						}
					
					driver.findElement(By.name("transactionDataBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is selected as "+Password);						
					driver.findElement(By.name("finish")).click();																									
					test.log(LogStatus.PASS, "Clicked on Finish Payment button ");
					Thread.sleep(1000);

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
					
					
					if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/p/input[2]")).isDisplayed())
						
					{
						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/p/input[2]")).click();
													///html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr[4]/td/table/tbody/tr[5]/td/input[3]
						test.log(LogStatus.PASS, "Partial Payment Completed Successfully ");
					}
					
					
					else
						
					{
						test.log(LogStatus.FAIL, "Partial Payment not Completed Successfully ");
					}


				}

			}
		}
		}

		

	}