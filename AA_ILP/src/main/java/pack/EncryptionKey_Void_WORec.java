package pack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class EncryptionKey_Void_WORec extends AA_CO_ILP{

	

	public static void EncryptionKey_Void_WORec(String SSN, String FileName) throws Exception {

		//Excel TestData = new Excel(System.getProperty("user.dir") + "/TestData/CO_ILP/" + FileName);
		int lastrow = TestData.getLastRow("NewLoan");
		System.out.println("NewLoan " + lastrow);
		String sheetName = "NewLoan";
		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			if (SSN.equals(RegSSN)) {
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				//String Password = TestData.getCellData(sheetName, "Password", row);
				String AdminURL = TestData.getCellData(sheetName, "AdminURL", row);
				//String UserName = TestData.getCellData(sheetName, "UserName", row);
				//String StoreId = TestData.getCellData(sheetName, "StoreID", row);
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				String Eankey = null;
				Thread.sleep(4000);
				driver.switchTo().defaultContent();
				WebDriverWait wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
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
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				// driver.findElement(By.xpath("
				// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();

				test.log(LogStatus.PASS, "Click on GO Button");
				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("Void");
				test.log(LogStatus.PASS, "Transaction Type is selected as Void");
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				// driver.findElement(By.id("go_Button")).click();
				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				String TranID = driver
						.findElement(By
								.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td"))
						.getText();
				                                           
				//String TranID = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr[6]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/select")).getText();
				
				test.log(LogStatus.PASS, "TranId captured:" + TranID);
				String TranID0[] = TranID.split(":");
				String TranID1 = TranID0[0];
				String TranID2 = TranID0[1];
				Thread.sleep(3000);
				//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr[6]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/input")).click();
				
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/input[2]")).click();
				test.log(LogStatus.PASS, "No button is clicked ");
				// name="NO"
				driver.close();

				driver = new InternetExplorerDriver();
				driver.get(AdminURL);

				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
				test.log(LogStatus.PASS, "Username is entered: admin");
				driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "Password is entered: " + Password);
				// Click Login Button
				driver.findElement(By.name("login")).click();
				test.log(LogStatus.PASS, "Clicked on Submit button");
				Thread.sleep(8000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Employee')]")).click();
				test.log(LogStatus.PASS, "Clicked on Transactions");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Encryption Key")).click();
				test.log(LogStatus.PASS, "Clicked on Encryption Key");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Encryption")).click();
				test.log(LogStatus.PASS, "Clicked on Encryption");
				Thread.sleep(5000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreId);
				test.log(LogStatus.PASS, "Store number Entered");

				driver.findElement(By.name("requestBean.tranNbr")).sendKeys(TranID2);
				test.log(LogStatus.PASS, "Tran number Entered");

				/*
				 * driver.findElement(By.name("trancd")).sendKeys("Advance-ADV")
				 * ; test.log(LogStatus.PASS, "Trancd selected");
				 * 
				 * driver.findElement(By.name("trancd")).sendKeys(
				 * "Early pay off-EPAY"); test.log(LogStatus.PASS,
				 * "Trancd selected");
				 * 
				 * driver.findElement(By.name("trancd")).sendKeys(
				 * "Payment-PAYIL"); test.log(LogStatus.PASS, "Trancd selected"
				 * );
				 */

				driver.findElement(By.name("trancd")).sendKeys("Write Off Recovery-WOR");
				test.log(LogStatus.PASS, "Trancd selected");

				driver.findElement(By.name("GetKey")).click();
				test.log(LogStatus.PASS, "GetKey clicked");

				Eankey = driver.findElement(By.name("EanKey")).getAttribute("value");
				test.log(LogStatus.PASS, "GetKey clicked:" + Eankey);

				driver.close();
				driver = new InternetExplorerDriver();
				Login.Login(UserName, Password, StoreId);
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

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				// driver.findElement(By.xpath("
				// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();

				test.log(LogStatus.PASS, "Click on GO Button");
				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("Void");
				test.log(LogStatus.PASS, "Transaction Type is selected as Void");
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				// driver.findElement(By.id("go_Button")).click();
				Thread.sleep(5000);

				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				// driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[7]/td/input[1]")).click();
				driver.findElement(By
						.xpath(" /html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/input[1]"))
						.click();
				// driver.findElement(By.xpath("//input[@name='YES' and
				// @type='button']")).click();
				test.log(LogStatus.PASS, "Yes Button clicked");

				driver.findElement(By.name("transactionDataBean.disbursementType")).sendKeys(TenderType);
				test.log(LogStatus.PASS, "DisbType Type is entered as " + TenderType);
				/*
				 * String Pmt= driver.findElement(By.xpath(
				 * " /html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]"
				 * )).getText(); System.out.println(Pmt);
				 * driver.findElement(By.name(
				 * "transactionDataBean.tenderAmtFirst")).sendKeys(Pmt);
				 * test.log(LogStatus.PASS, "Tender Amt is entered as "+Pmt);
				 */

				driver.findElement(By.name("transactionDataBean.encryptionKey")).sendKeys(Eankey);
				test.log(LogStatus.PASS, "Encryption key is entered as " + Eankey);

				driver.findElement(By.name("password")).sendKeys(Password);
				// Robot robot = new Robot();
				// Thread.sleep(2000);
				// robot.keyPress(KeyEvent.VK_F11);
				driver.findElement(By.name("Submit22")).click();
				// robot.keyPress(KeyEvent.VK_F11);
				test.log(LogStatus.PASS, "Password is selected as " + Password);
				test.log(LogStatus.PASS, "Clicked on Finish Void Loan button ");

				try {
					Alert alert = driver.switchTo().alert();
					alert.accept();

				} catch (NoAlertPresentException e) {
				}
				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				if (driver.findElement(By.xpath("//input[ @type='button']")).isDisplayed()) {
					test.log(LogStatus.PASS, "WriteOff Recovery Void  is Completed Successfully ");
					driver.findElement(By.xpath("//input[@type='button']")).click();
					// driver.findElement(By.name("checkyes")).click();
				} else {
					test.log(LogStatus.FAIL, "WriteOff Recovery Voidt is not Completed Successfully ");
				}

			}
		}
	}
	
	
	
	
	
	
}
