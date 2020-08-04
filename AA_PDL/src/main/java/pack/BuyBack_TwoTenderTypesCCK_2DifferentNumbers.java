package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class BuyBack_TwoTenderTypesCCK_2DifferentNumbers extends AA_PDL {
	public static void BuyBack_TwoTenderTypesCCK_2DifferentNumbers (String SSN,String FileName, double PerAmt) throws Exception{

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
				//String UserName = TestData.getCellData(sheetName,"UserName",row);
				//String Password = TestData.getCellData(sheetName,"Password",row);
				//String StoreId = TestData.getCellData(sheetName,"StoreID",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(2000);
				Login.Login(UserName, Password, StoreId);	
				driver.switchTo().defaultContent();		
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
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
				Thread.sleep(2000);
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				Thread.sleep(2000);
				driver.findElement(By.name("transactionList")).sendKeys("Buy Back");
				test.log(LogStatus.PASS, "Transaction Type is selected as: BuyBack");	
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if(ProductID.equals("PDL"))
				{
					String PaymentAmount = null;

					PaymentAmount = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					// test.log(LogStatus.PASS, "Capture the Payment
					// Amt":+PaymentAmount);
					Thread.sleep(2000);

					double pmtamt1 = Double.parseDouble(PaymentAmount);
				/*	double pmtamt2 = pmtamt1 * PerAmt;*/
					double pmtamt2 = 100;
					test.log(LogStatus.PASS, pmtamt2 + ": is :" + PerAmt + ": of Total Default Amount");
					double pmtamt4 =pmtamt1-pmtamt2;
					String pmtamt5 = String.valueOf(pmtamt4);
					String pmtamt3 = String.valueOf(pmtamt2);
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Cashiers Check");
					test.log(LogStatus.PASS, "Tender Type is selected as :: Cashiers Check");
					Thread.sleep(2000);
				/*	String Pmt= driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");						 
					System.out.println(Pmt);	*/
	
					driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(SSN3);						 
					test.log(LogStatus.PASS, "Tender Amt is entered as ::"+SSN3);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(pmtamt3);						 
					test.log(LogStatus.PASS, "Tender Amt is entered as "+pmtamt3);
		
					driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys("Cashiers Check");
					test.log(LogStatus.PASS, "Tender Type is selected as :: Cashiers Check");
					Thread.sleep(2000);
			String SSN4 ="1"+SSN1;
					driver.findElement(By.name("transactionDataBean.ccmoNbrSecond")).sendKeys(SSN4);						 
					test.log(LogStatus.PASS, "Tender Amt is entered as "+SSN4);
					driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys(pmtamt5);						 
					test.log(LogStatus.PASS, "Tender Amt is entered as "+pmtamt5);
					driver.findElement(By.name("transactionDataBean.password")).sendKeys(Password);
					driver.findElement(By.name("finish")).click();
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
					if(driver.findElement(By.name("checkyes")).isDisplayed())
					{
						test.log(LogStatus.PASS, "BuyBack Loan is Completed Successfully ");
						driver.findElement(By.name("checkyes")).click();
					}
					else
					{
						test.log(LogStatus.FAIL, "BuyBack Loan is not Completed Successfully ");
					}
				}
											
			}

		}
	}
}
