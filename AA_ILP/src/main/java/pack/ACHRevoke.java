package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class ACHRevoke extends AA_CO_ILP{

	
	public static void ACHRevoke(String SSN, String FileName) throws Exception {

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

				System.out.println(AdminURL);

				test.log(LogStatus.INFO, "Scheduler-Store Aging");

				System.out.println(ProductID);

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);

				appUrl = AppURL;

				Login.Login(UserName, Password, StoreId);

				String SSN1 = SSN.substring(0, 3);

				String SSN2 = SSN.substring(3, 5);

				String SSN3 = SSN.substring(5, 9);

				Thread.sleep(5000);

				Thread.sleep(1000);

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

				if (ProductID.equals("ILP"))

				{

					/// html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]

					// driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				}

				// driver.findElement(By.name("button")).click();

				test.log(LogStatus.PASS, "Click on GO Button");

				for (String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("transactionList")).sendKeys("ACH Revoke");
				test.log(LogStatus.PASS, "ACH Revoke Transaction Selected");

				if (ProductID.equals("ILP"))

				{

					driver.findElement(By.id("go_Button")).click();

				}

				try {
					Alert alert = driver.switchTo().alert();
					alert.accept();
					// if alert present, accept and move on.

				} catch (NoAlertPresentException e) {
					// do what you normally would if you didn't have the alert.
				}

				for (String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				// Thread.sleep(5000);
				// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/input[2]
				/*
				 * wait.until(ExpectedConditions.elementToBeClickable(By.
				 * cssSelector("li[id='900000']")));
				 * driver.findElement(By.cssSelector("li[id='900000']")).click()
				 * ;
				 */
				driver.findElement(By
						.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/input[2]"))
						.click();
				// wait.until(ExpectedConditions.elementToBeClickable(By.name("bt_BankDetails")));
				// driver.findElement(By.name("bt_BankDetails")).click();
				test.log(LogStatus.PASS, "Clicked on ACH Revoke Button");
				try {
					Alert alert = driver.switchTo().alert();
					alert.accept();
					// if alert present, accept and move on.

				} catch (NoAlertPresentException e) {
					// do what you normally would if you didn't have the alert.
				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				//// *[@id="totPart"]/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table[2]/tbody/tr/td/input[1]
				driver.findElement(By.name("checkyes")).click();
				test.log(LogStatus.PASS, "ACH Revoke Transaction is Completed");

			}
		}
	}
	
	
	
	
	
	
}
