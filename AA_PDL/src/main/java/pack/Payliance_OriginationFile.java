package pack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.LogStatus;

public class Payliance_OriginationFile extends AA_PDL{

	
	public static void Payliance_OriginationFile(String SSN, String FileName, int Days) throws Exception {

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
				//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				//appUrl = AppURL;
				//appUrl = AppURL;

				Login.Login(UserName, Password, StoreId);
				System.out.println(AdminURL);
				test.log(LogStatus.PASS,
						"<FONT color=green style=Arial> ----------- Payliance Origination -----------");

				System.out.println(ProductID);

				//appUrl = AppURL;

				Thread.sleep(5000);
				Thread.sleep(1000);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
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

			
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				
				test.log(LogStatus.PASS, "Click on GO Button");
				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("History");
			
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					// driver.findElement(By.id("go_Button")).click();
				

				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				String DueDate = null;

				DueDate = driver
						.findElement(By
								.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]"))
						.getText();
				//DueDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();

				// DueDate =
				// driver.findElement(By.xpath("//*[@id='PPNScheduleHistoryTable']/tbody/tr["+instnum+"]/td[2]")).getText();

				// *[@id="revolvingCreditHistTable"]/tbody/tr[4]/td[3]/span[2]
				test.log(LogStatus.PASS, "Capture DueDate" + DueDate);
				System.out.print(DueDate);
				driver.close();

				driver = new InternetExplorerDriver();
				driver.get(AdminURL);

				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
				test.log(LogStatus.PASS, "Username is entered: admin");
				driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "Password is entered: " + Password);

				driver.findElement(By.name("login")).click();
				test.log(LogStatus.PASS, "Clicked on Submit button");
				Thread.sleep(8000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();
				test.log(LogStatus.PASS, "Clicked on Transactions");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.linkText("ACH")).click();
				test.log(LogStatus.PASS, "Clicked on ACH");
				Thread.sleep(5000);
				driver.findElement(By.linkText("Payliance")).click();
				test.log(LogStatus.PASS, "Clicked on Payliance");
				Thread.sleep(5000);
				driver.findElement(By.linkText("Payliance Origination File")).click();
				test.log(LogStatus.PASS, "Clicked on Payliance Origination File");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

				/*
				 * driver.manage().timeouts().implicitlyWait(120,
				 * TimeUnit.SECONDS); driver.switchTo().defaultContent();
				 * driver.switchTo().frame("mainFrame");
				 * driver.manage().timeouts().implicitlyWait(60,
				 * TimeUnit.SECONDS); driver.findElement(By.linkText(
				 * "Daily Jobs")).click(); test.log(LogStatus.PASS,
				 * "Clicked on Daily Jobs"); Thread.sleep(5000);
				 */

				String DDueDate[] = DueDate.split("/");

				Date DDueDateminus1 = df.parse(DueDate);
				Calendar cal = Calendar.getInstance();
				cal.setTime(DDueDateminus1);
				cal.add(Calendar.DATE, Days);
				Date DDueDate1 = cal.getTime();
				DueDate = df.format(DDueDate1);
				String DueDate0[] = DueDate.split("/");
				String DueDate1 = DueDate0[0];
				String DueDate2 = DueDate0[1];
				String DueDate3 = DueDate0[2];

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.name("beginMonth")).click();
				driver.findElement(By.name("beginMonth")).clear();
				driver.findElement(By.name("beginMonth")).sendKeys(DueDate1);
				test.log(LogStatus.PASS, "beginMonth is entered: " + DueDate1);
				driver.findElement(By.name("beginDay")).clear();
				driver.findElement(By.name("beginDay")).sendKeys(DueDate2);
				test.log(LogStatus.PASS, "beginDay is entered: " + DueDate2);
				driver.findElement(By.name("beginYear")).clear();
				driver.findElement(By.name("beginYear")).sendKeys(DueDate3);
				test.log(LogStatus.PASS, "beginYear is entered: " + DueDate3);
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				Thread.sleep(1000);
				Thread.sleep(5000);
				driver.findElement(By.name("btnPreview")).click();
				test.log(LogStatus.PASS, "Clicked on submit button");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if (driver
						.findElement(By
								.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input"))
						.isDisplayed()) {
					test.log(LogStatus.PASS, "Process NACHA file successfully.");
					driver.findElement(By
							.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input"))
							.click();
				} else {
					test.log(LogStatus.FAIL, "Process NACHA is not updated successfully.");
				}

			}
		}
	}
	
	
	
	
	public static void Payliance_OriginationFile_Resch(String SSN, String FileName, int Days) throws Exception {

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
				//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				//appUrl = AppURL;
				//appUrl = AppURL;

				Login.Login(UserName, Password, StoreId);
				System.out.println(AdminURL);
				test.log(LogStatus.PASS,
						"<FONT color=green style=Arial> ----------- Payliance Origination -----------");

				System.out.println(ProductID);

				//appUrl = AppURL;

				Thread.sleep(5000);
				Thread.sleep(1000);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
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

			
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				
				test.log(LogStatus.PASS, "Click on GO Button");
				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("History");
			
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					// driver.findElement(By.id("go_Button")).click();
				

				for (String winHandle1 : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
	/*			String DueDate = null;

				DueDate = driver
						.findElement(By
								.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]"))
						.getText();*/
				String DueDate=null;

				//DueDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
				//DueDate = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[4]")).getText();
				List<WebElement> options = driver.findElements(By.xpath("//*[@id='achHistoryTable']/tbody/tr"));
				int schsize = options.size();
			//	DueDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
				DueDate = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr["+schsize+"]/td[4]")).getText();

				
				//DueDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();

				// DueDate =
				// driver.findElement(By.xpath("//*[@id='PPNScheduleHistoryTable']/tbody/tr["+instnum+"]/td[2]")).getText();

				// *[@id="revolvingCreditHistTable"]/tbody/tr[4]/td[3]/span[2]
				test.log(LogStatus.PASS, "Capture DueDate" + DueDate);
				System.out.print(DueDate);
				driver.close();

				driver = new InternetExplorerDriver();
				driver.get(AdminURL);

				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
				test.log(LogStatus.PASS, "Username is entered: admin");
				driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "Password is entered: " + Password);

				driver.findElement(By.name("login")).click();
				test.log(LogStatus.PASS, "Clicked on Submit button");
				Thread.sleep(8000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();
				test.log(LogStatus.PASS, "Clicked on Transactions");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.linkText("ACH")).click();
				test.log(LogStatus.PASS, "Clicked on ACH");
				Thread.sleep(5000);
				driver.findElement(By.linkText("Payliance")).click();
				test.log(LogStatus.PASS, "Clicked on Payliance");
				Thread.sleep(5000);
				driver.findElement(By.linkText("Payliance Origination File")).click();
				test.log(LogStatus.PASS, "Clicked on Payliance Origination File");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

				/*
				 * driver.manage().timeouts().implicitlyWait(120,
				 * TimeUnit.SECONDS); driver.switchTo().defaultContent();
				 * driver.switchTo().frame("mainFrame");
				 * driver.manage().timeouts().implicitlyWait(60,
				 * TimeUnit.SECONDS); driver.findElement(By.linkText(
				 * "Daily Jobs")).click(); test.log(LogStatus.PASS,
				 * "Clicked on Daily Jobs"); Thread.sleep(5000);
				 */

				String DDueDate[] = DueDate.split("/");

				Date DDueDateminus1 = df.parse(DueDate);
				Calendar cal = Calendar.getInstance();
				cal.setTime(DDueDateminus1);
				cal.add(Calendar.DATE, Days);
				Date DDueDate1 = cal.getTime();
				DueDate = df.format(DDueDate1);
				String DueDate0[] = DueDate.split("/");
				String DueDate1 = DueDate0[0];
				String DueDate2 = DueDate0[1];
				String DueDate3 = DueDate0[2];

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.name("beginMonth")).click();
				driver.findElement(By.name("beginMonth")).clear();
				driver.findElement(By.name("beginMonth")).sendKeys(DueDate1);
				test.log(LogStatus.PASS, "beginMonth is entered: " + DueDate1);
				driver.findElement(By.name("beginDay")).clear();
				driver.findElement(By.name("beginDay")).sendKeys(DueDate2);
				test.log(LogStatus.PASS, "beginDay is entered: " + DueDate2);
				driver.findElement(By.name("beginYear")).clear();
				driver.findElement(By.name("beginYear")).sendKeys(DueDate3);
				test.log(LogStatus.PASS, "beginYear is entered: " + DueDate3);
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				Thread.sleep(1000);
				Thread.sleep(5000);
				driver.findElement(By.name("btnPreview")).click();
				test.log(LogStatus.PASS, "Clicked on submit button");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if (driver
						.findElement(By
								.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input"))
						.isDisplayed()) {
					test.log(LogStatus.PASS, "Process NACHA file successfully.");
					driver.findElement(By
							.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input"))
							.click();
				} else {
					test.log(LogStatus.FAIL, "Process NACHA is not updated successfully.");
				}

			}
		}
	}
	
		
	
	
}
