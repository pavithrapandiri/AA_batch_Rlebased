package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class Writoff_RecoveryPartPmt_ILP extends AA_CO_ILP{

	
	public static void Writoff_RecoveryPartPmt_ILP(String SSN, String FileName) throws Exception {

		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/CO_ILP/" + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		System.out.println("NewLoan " + lastrow);
		String sheetName = "NewLoan";
		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			if (SSN.equals(RegSSN)) {
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				//String UserName = TestData.getCellData(sheetName, "UserName", row);
				//String Password = TestData.getCellData(sheetName, "Password", row);
				//String StoreID = TestData.getCellData(sheetName, "StoreID", row);
				//String AdminURL = TestData.getCellData(sheetName, "AdminURL", row);
				String Bank_ChkgAcctNbr = TestData.getCellData(sheetName, "Bank_ChkgAcctNbr", row);
				//String ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
				String ESign_CheckNbr=SSN.substring(3, 9);

				String ESign_TenderType = TestData.getCellData(sheetName, "TenderType", row);
				System.out.println(AdminURL);
				test.log(LogStatus.INFO, "Scheduler-Store Aging");

				System.out.println(ProductID);
				//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				//appUrl = AppURL;
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				Thread.sleep(5000);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transactions");
				driver.switchTo().frame("main");
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");
				String PaymentAMT = null;
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				// driver.findElement(By.name("button")).click();
				/// html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]
				// driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();

				// driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("WO Recovery");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				// driver.findElement(By.name("button")).click();

				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				// String PaymentAmount=null;
				if (TenderType.equals("Cash")) {
					PaymentAMT = driver.findElement(By.name("transactionDataBean.paymentBalAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Capture the Payment Value :" + PaymentAMT);

					driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();

					driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys("50");
					test.log(LogStatus.PASS, "Enter the Payment Amount");

					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select the Tender Type::");

					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys("50");
					test.log(LogStatus.PASS, "Enter the Tender Amount");

					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Enter the Password");

					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, "Click on the Finish Write off Recovery");
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						// if alert present, accept and move on.

					} catch (NoAlertPresentException e) {
						// do what you normally would if you didn't have the
						// alert.
					}
				}
				if (TenderType.equals("Cashiers Check")) {
					PaymentAMT = driver.findElement(By.name("transactionDataBean.paymentBalAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Capture the Payment Value :" + PaymentAMT);

					driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();

					driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys("20");
					test.log(LogStatus.PASS, "Enter the Payment Amount");

					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select the Tender Type::");

					driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(ESign_CheckNbr);
					test.log(LogStatus.PASS, "Banking Checking number entered is::" + ESign_CheckNbr);

					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys("20");
					test.log(LogStatus.PASS, "Enter the Tender Amount");

					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Enter the Password");

					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, "Click on the Finish Write off Recovery");
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						// if alert present, accept and move on.

					} catch (NoAlertPresentException e) {
						// do what you normally would if you didn't have the
						// alert.
					}
				}

				if (TenderType.equals("Money Order")) {
					PaymentAMT = driver.findElement(By.name("transactionDataBean.paymentBalAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Capture the Payment Value :" + PaymentAMT);

					driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();

					driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys("20");
					test.log(LogStatus.PASS, "Enter the Payment Amount");

					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select the Tender Type::");

					driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(ESign_CheckNbr);
					test.log(LogStatus.PASS, "Banking Checking number entered is::" + ESign_CheckNbr);

					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys("20");
					test.log(LogStatus.PASS, "Enter the Tender Amount");

					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Enter the Password");

					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, "Click on the Finish Write off Recovery");
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						// if alert present, accept and move on.

					} catch (NoAlertPresentException e) {
						// do what you normally would if you didn't have the
						// alert.
					}
				}
				test.log(LogStatus.PASS, "Write off Recovery completed Sucessfully");

				/*
				 * if(driver.findElement(By.name("Ok")).isDisplayed()) {
				 * test.log(LogStatus.PASS,
				 * "Write off Recovery completed Sucessfully");
				 * driver.findElement(By.name("Ok")).click(); }
				 * 
				 * 
				 * else {
				 * 
				 * test.log(LogStatus.PASS,
				 * "Write off Recovery not completed Sucessfully"); }
				 */

			}
		}
	}
	
	
	
	
	
	
}
