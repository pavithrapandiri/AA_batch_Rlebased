package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class PaymentcureAmount_ILP extends AA_CO_ILP{

	public static void PaymentcureAmount_ILP(String SSN, String FileName) throws Exception {

		//Excel TestData = new Excel(System.getProperty("user.dir") + "/TestData/CO_ILP/" + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		System.out.println("NewLoan " + lastrow);
		String sheetName = "NewLoan";
		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			if (SSN.equals(RegSSN)) {
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String DisbType = TestData.getCellData(sheetName, "TenderType", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				//String UserName = TestData.getCellData(sheetName, "UserName", row);
				//String Password = TestData.getCellData(sheetName, "Password", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				// System.out.println(Password);
				//String StoreId = TestData.getCellData(sheetName, "StoreID", row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				Thread.sleep(4000);
				String Payment = null;
				Login.Login(UserName, Password, StoreId);
				driver.switchTo().defaultContent();
				WebDriverWait wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				test.log(LogStatus.INFO, "Payment_ILP Transaction with-SSN: " + SSN + " :: is Starts");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();
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
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				test.log(LogStatus.PASS, "Click on GO Button");
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				/// html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]
				// driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
				// driver.findElement(By.name("button")).click();

				// driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				String cureAmount = driver.findElement(By.xpath("//*[@id='CustGrid']/tbody/tr[2]/td[7]")).getText();
				test.log(LogStatus.PASS, "cure amount captured " + cureAmount);
				driver.findElement(By.name("transactionList")).sendKeys("Payment");
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if (ProductID.equals("ILP"))

				{

					/// driver.findElement(By.name("requestBean.paymentType")).click();
					// name="requestBean.paymentType"
					/// name="requestBean.paymentType"
					/// name="requestBean.paymentType"
					// value="PD4" payment value="PD3" payoff value="PD5"
					/// payanyotherAmt
					// /html/body/form[1]/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr[2]/td[1]/input[2]
					/// payoff value
					// /html/body/form[1]/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input[2]
					/// payment value
					driver.findElement(By.xpath("//*[@id='PD5']")).click();
					test.log(LogStatus.PASS, "pay any another Amount option is selected ");

					/// Payment=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input[2]")).getAttribute("value");
					driver.findElement(By.name("requestBean.siilBean.payAmt")).sendKeys(cureAmount);
					test.log(LogStatus.PASS, "Eneter the cure amount  " + cureAmount);

					Thread.sleep(500);
					// name="requestBean.siilBean.tenderTypeFirst"
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is selected " + TenderType);

					// name="requestBean.siilBean.tenderAmtFirst"
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(cureAmount);
					test.log(LogStatus.PASS, "Tender Amount is Entered " + cureAmount);

					Thread.sleep(500);
					// name="requestBean.password"
					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is selected as " + Password);

					// name="finish"
					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, "Clicked on Finish button ");
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

					// driver.findElement(By.name("ok")).click();

					// name="checkyes"
					// if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td[1]/input")).isDisplayed())
					if (driver.findElement(By.name("checkyes")).isDisplayed()) {
						test.log(LogStatus.INFO,
								"cure payment completed  Transaction with-SSN: " + SSN + " :: is Successful");
						// driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td[1]/input")).click();
						driver.findElement(By.name("checkyes")).click();
					} else {
						test.log(LogStatus.FAIL, "cure payment completed  is not Completed Successfully ");
					}

				}
			}

		}
	}
	
	
	
	
	
	
	
}
