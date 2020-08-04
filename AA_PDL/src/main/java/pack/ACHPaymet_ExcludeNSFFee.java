package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class ACHPaymet_ExcludeNSFFee  extends AA_PDL{
	public static void  ACHPaymet_ExcludeNSFFee (String SSN,String FileName) throws Exception
	{
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

				////String StoreId = TestData.getCellData(sheetName,"StoreId",row); 

				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);

				System.out.println(AdminURL);
				System.out.println(ProductID);

				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);

				//appUrl = AppURL;
				test.log(LogStatus.INFO,"<FONT color=green style=Arial>ACH Payment Excluding NSF Fee");


				Login.Login(UserName, Password, StoreId);

				String SSN1 = SSN.substring(0, 3);

				String SSN2 = SSN.substring(3,5);

				String SSN3 = SSN.substring(5,9);

				Thread.sleep(2000);

				Thread.sleep(1000);

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

				for(String winHandle : driver.getWindowHandles()){

					driver.switchTo().window(winHandle);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");


				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				// driver.findElement(By.name("button")).click();

				test.log(LogStatus.PASS, "Click on GO Button");

				for( String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("transactionList")).sendKeys("ACH Payment");

				test.log(LogStatus.INFO, "transactionList as Selected :: ACH Payment " );

				if(ProductID.equals("PDL"))

				{

					driver.findElement(By.id("go_Button")).click();

					test.log(LogStatus.PASS, "Click on GO Button");

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
					String TotPaymentAmount = null;
					String NSFPaymentAmount = null;
					TotPaymentAmount = driver.findElement(By.name("transactionDataBean.amtOwed")).getAttribute("value");
					NSFPaymentAmount = driver.findElement(By.name("transactionDataBean.nsfFeeAmt")).getAttribute("value");
					// test.log(LogStatus.PASS, "Capture the Payment
					// Amt":+PaymentAmount);
					Thread.sleep(2000);

					double totpmtamt = Double.parseDouble(TotPaymentAmount);
					double NSFpmtamt1 = Double.parseDouble(NSFPaymentAmount);
					double amttopay =totpmtamt-NSFpmtamt1;// Amount after exclusion of NSF Fee
					test.log(LogStatus.PASS, "Amount to pay after excluding NSF Fee is ::"+amttopay);
	
					String amttopay1 = String.valueOf(amttopay);
					String amttopay2 = String.valueOf(totpmtamt);
					driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					test.log(LogStatus.PASS, "Amount edited from::"+amttopay2+"::to ::"+amttopay1);
					driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(amttopay1);
					test.log(LogStatus.PASS, "Amount to pay after excluding NSF Fee is ::"+amttopay);
					Thread.sleep(2000);
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Cash");
					test.log(LogStatus.PASS, "Tender Type is selected as :: Cash");
					Thread.sleep(2000);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(amttopay1);
					test.log(LogStatus.PASS, "Tender Type is selected as ::"+amttopay1);
					Thread.sleep(2000);
					
					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					driver.findElement(By.name("Submit22")).click();
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
					// type="button"
					// value="Yes"
					// name="checkyes"
			/*		if(driver.findElement(By.name("checkyes")).isDisplayed())
					{
						test.log(LogStatus.PASS, "ACH Payment excluding NSF Fee is Completed Successfully ");
						driver.findElement(By.name("checkyes")).click();
					}
					else
					{
						test.log(LogStatus.FAIL, "ACH Payment excluding NSF Fee  is not Completed Successfully ");
					}*/
				}
					
			}
		}
	}
}






