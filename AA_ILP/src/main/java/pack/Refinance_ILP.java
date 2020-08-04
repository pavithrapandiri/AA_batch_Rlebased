
package pack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Refinance_ILP extends AA_ILP{

	public static void Refinance_ILP(String SSN, String FileName,int VAmt) throws Exception {
		int lastrow = TestData.getLastRow("NewLoan");
		System.out.println("NewLoan " + lastrow);
		String sheetName = "NewLoan";
		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			if (SSN.equals(RegSSN)) {
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String TenderType = TestData.getCellData(sheetName, "ESign_DisbType", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				//String UserName = TestData.getCellData(sheetName, "UserName", row);
				//String Password = TestData.getCellData(sheetName, "Password", row);
				//String StoreId = TestData.getCellData(sheetName, "StoreID", row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				Thread.sleep(5000);

				Login.Login(UserName, Password, StoreId);
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				driver.switchTo().frame("topFrame");
				test.log(LogStatus.INFO, "Payment with-SSN: " + SSN + " :: Starts");
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
				test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");
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

				if (ProductID.equals("ILP")) {
					/// html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input
				}
				// driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("Refinance");
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();


				for (String winHandle1 : driver.getWindowHandles()) {
					// driver.findElement(By.name("button")).click();
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if (ProductID.equals("ILP")) {
					//String TotalAmountOwed=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[3]/td/table/tbody/tr[25]/td[4]/input")).getText();
					//String TotalAmountOwed=driver.findElement(By.xpath("//input[@name='requestBean.payOffAmt' and @type='text']")).getText();                                                              
					String TotalAmountOwed=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[3]/td/table/tbody/tr[26]/td[6]/input")).getAttribute("value");
					test.log(LogStatus.PASS, "PrincipalBalance is "+TotalAmountOwed);
					float TotalAmountOwed1 = Float.parseFloat(TotalAmountOwed);
					float TotalAmountOwed2 = TotalAmountOwed1 + VAmt;
					String LoanAmtRequested = String.valueOf(TotalAmountOwed2);
					float TotalAmountOwed3 = Float.parseFloat(LoanAmtRequested);

					driver.findElement(By.name("requestBean.siilBean.advAmt")).click();
					driver.findElement(By.name("requestBean.siilBean.advAmt")).clear();
					Thread.sleep(1000);
					if(TotalAmountOwed2<(100.00))
					{
						driver.findElement(By.name("requestBean.siilBean.advAmt")).sendKeys("100");
						test.log(LogStatus.PASS, "Requested Loan Amount is entered as 100");
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[3]/td/table/tbody/tr[26]/td[6]/input")).click();
					}else{
					driver.findElement(By.name("requestBean.siilBean.advAmt")).sendKeys(LoanAmtRequested);
					test.log(LogStatus.PASS, "Requested Loan Amount is entered as "+LoanAmtRequested);
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[3]/td/table/tbody/tr[26]/td[6]/input")).click();
					}
					Thread.sleep(5000);

					if (TotalAmountOwed1<(TotalAmountOwed3)) {

						String TotalDisbAmount=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[3]/td/table/tbody/tr[37]/td[2]/input")).getAttribute("value");
						driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(TotalDisbAmount);
						test.log(LogStatus.PASS, "Disb Amount is entered as "+TotalDisbAmount);
						driver.findElement(By.name("requestBean.siilBean.emailConsentFlag")).sendKeys("No");
						driver.findElement(By.name("requestBean.password")).sendKeys(Password);
						test.log(LogStatus.PASS, "Password is selected as " + Password);
						driver.findElement(By.name("finishLoan")).click();
						test.log(LogStatus.PASS, "Clicked on finishLoan button ");

						Thread.sleep(2000);

						try {
							Alert alert = driver.switchTo().alert();
							alert.accept();
							// if alert present, accept and move on.

						} catch (NoAlertPresentException e) {

							// do what you normally would if you didn't have the
							// alert.
						}

						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						Thread.sleep(3000);


						if (driver.findElement(By.xpath("//*[@id='confirmEsign']/tbody/tr/td/table/tbody/tr[7]/td[1]/input[1]")).isDisplayed())
							// if(driver.findElement(By.name("checkyes")).isDisplayed())
						{
							driver.findElement(By.xpath("//*[@id='confirmEsign']/tbody/tr/td/table/tbody/tr[7]/td[1]/input[1]")).click();
							driver.findElement(By.xpath("//*[@id='totPart']/tbody/tr/td/table/tbody/tr[3]/td/table[2]/tbody/tr/td/table/tbody/tr/td/input")).click();
							test.log(LogStatus.PASS, "Refinace Step UP is Completed Successfully ");

						} else {
							test.log(LogStatus.FAIL, "Refinace Step UP is not Completed Successfully ");
						}
					}


					if (TotalAmountOwed.equals(LoanAmtRequested)) {
						driver.findElement(By.name("requestBean.siilBean.emailConsentFlag")).sendKeys("No");
						driver.findElement(By.name("requestBean.password")).sendKeys(Password);
						test.log(LogStatus.PASS, "Password is selected as " + Password);
						driver.findElement(By.name("finishLoan")).click();
						test.log(LogStatus.PASS, "Clicked on finishLoan button ");

						Thread.sleep(2000);

						try {
							Alert alert = driver.switchTo().alert();
							alert.accept();
							// if alert present, accept and move on.

						} catch (NoAlertPresentException e) {

							// do what you normally would if you didn't have the
							// alert.
						}

						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						Thread.sleep(3000);


						// *[@id="totPart"]/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td[1]/input
						if (driver.findElement(By.xpath("//*[@id='confirmEsign']/tbody/tr/td/table/tbody/tr[7]/td[1]/input[1]")).isDisplayed())
							// if(driver.findElement(By.name("checkyes")).isDisplayed())
						{
							driver.findElement(By.xpath("//*[@id='confirmEsign']/tbody/tr/td/table/tbody/tr[7]/td[1]/input[1]")).click();
							driver.findElement(By.xpath("//*[@id='totPart']/tbody/tr/td/table/tbody/tr[3]/td/table[2]/tbody/tr/td/table/tbody/tr/td/input")).click();
							test.log(LogStatus.PASS, "Refinace Step Same is Completed Successfully ");

						} else {
							test.log(LogStatus.FAIL, "Refinace Step Same is not Completed Successfully ");
						}
					}

					if (TotalAmountOwed1>(TotalAmountOwed3)) {

						String TotalTenderAmount=driver.findElement(By.xpath("//*[@id='showPaymentAmt']/td[2]/input")).getAttribute("value");
						test.log(LogStatus.PASS, "Tender Amount is entered as "+TotalTenderAmount);
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
						driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TotalTenderAmount);
						driver.findElement(By.name("requestBean.siilBean.emailConsentFlag")).sendKeys("No");
						driver.findElement(By.name("requestBean.password")).sendKeys(Password);
						test.log(LogStatus.PASS, "Password is selected as " + Password);
						driver.findElement(By.name("finishLoan")).click();
						test.log(LogStatus.PASS, "Clicked on finishLoan button ");

						Thread.sleep(2000);

						try {
							Alert alert = driver.switchTo().alert();
							alert.accept();
							// if alert present, accept and move on.

						} catch (NoAlertPresentException e) {

							// do what you normally would if you didn't have the
							// alert.
						}

						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						Thread.sleep(3000);



						if (driver.findElement(By.xpath("//*[@id='confirmEsign']/tbody/tr/td/table/tbody/tr[7]/td[1]/input[1]")).isDisplayed())
							// if(driver.findElement(By.name("checkyes")).isDisplayed())
						{
							driver.findElement(By.xpath("//*[@id='confirmEsign']/tbody/tr/td/table/tbody/tr[7]/td[1]/input[1]")).click();
							driver.findElement(By.xpath("//*[@id='totPart']/tbody/tr/td/table/tbody/tr[3]/td/table[2]/tbody/tr/td/table/tbody/tr/td/input")).click();
							test.log(LogStatus.PASS, "Refinace Step Down is Completed Successfully ");

						} else {
							test.log(LogStatus.FAIL, "Refinace Step Down is not Completed Successfully ");
						}
					}	

				}

			}
		}
	}
}

