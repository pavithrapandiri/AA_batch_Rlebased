package pack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
public class Safeassign extends AA_CO_ILP{
 
	public static void Safeassign(String SSN, String FileName) throws Exception {

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
				//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				//String UserName = TestData.getCellData(sheetName, "UserName", row);
				//String Password = TestData.getCellData(sheetName, "Password", row);
				//String StoreId = TestData.getCellData(sheetName, "StoreID", row);
				Login.Login(UserName, Password, StoreId);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> ----------- Safe Assign -----------");

				Thread.sleep(5000);
				/*
				 * driver.switchTo().defaultContent();
				 * driver.switchTo().frame("topFrame");
				 * driver.findElement(By.xpath(
				 * "//*[contains(text(),'Cash Management')]")).click();
				 * test.log(LogStatus.PASS, "Clicked on Cash Management");
				 * Thread.sleep(1000);
				 * driver.manage().timeouts().implicitlyWait(120,
				 * TimeUnit.SECONDS); driver.switchTo().defaultContent();
				 * driver.switchTo().frame("mainFrame");
				 * //driver.switchTo().frame("main");
				 * driver.manage().timeouts().implicitlyWait(60,
				 * TimeUnit.SECONDS);
				 * //driver.findElement(By.cssSelector("li[id='911101']")).click
				 * (); driver.findElement(By.linkText("Safe")).click();
				 * test.log(LogStatus.PASS, "Clicked on safe");
				 * //driver.findElement(By.xpath("//*[@id="931010"]/a']")).click
				 * (); //driver.findElement(By.linkText("Drawer")).click();
				 * 
				 * driver.findElement(By.linkText("Assign")).click();
				 * test.log(LogStatus.PASS, "Clicked on Assign");
				 * 
				 * 
				 * 
				 * driver.manage().timeouts().implicitlyWait(120,
				 * TimeUnit.SECONDS);
				 * 
				 * driver.switchTo().defaultContent();
				 * driver.switchTo().frame("mainFrame");
				 * driver.switchTo().frame("main");
				 * 
				 * 
				 * //if(driver.findElement(By.name("previous")).isDisplayed())
				 * 
				 * 
				 * 
				 * 
				 * driver.findElement(By.name("previous")).click();
				 * 
				 * driver.manage().timeouts().implicitlyWait(120,
				 * TimeUnit.SECONDS); driver.switchTo().defaultContent();
				 * driver.switchTo().frame("mainFrame");
				 * driver.switchTo().frame("main");
				 * 
				 * 
				 * driver.findElement(By.name("yes")).click();
				 */

				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();
				test.log(LogStatus.PASS, "Clicked on Cash Management");
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				// driver.findElement(By.cssSelector("li[id='911101']")).click();
				driver.findElement(By.linkText("Safe")).click();
				test.log(LogStatus.PASS, "Clicked on Assign");
				// driver.findElement(By.xpath("//*[@id="931010"]/a']")).click();
				// driver.findElement(By.linkText("Drawer")).click();
				driver.findElement(By.linkText("Assign")).click();
				test.log(LogStatus.PASS, "Clicked on Assign");

				// login.Login(UserName, Password, StoreId, driver, AppURL,
				// test);
				Thread.sleep(5000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.name("safeAssignRequestBean.empPwd")).sendKeys(Password);

				driver.findElement(By.name("safeAssignRequestBean.noOf100Dollars")).sendKeys("500");

				driver.findElement(By.name("safeassign")).click();

				try {
					Alert alert = driver.switchTo().alert();
					alert.accept();
					// if alert present, accept and move on.

				} catch (NoAlertPresentException e) {
					// do what you normally would if you didn't have the alert.

				}
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				/// html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input
				/// html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[1]/input
				// if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[1]/input")).isDisplayed())
				if (driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).isDisplayed()) {

					test.log(LogStatus.PASS, "Safe assigned successfully with over/short.");
					driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).click();
					// driver.findElement(By.name("done")).click();
				} else {
					test.log(LogStatus.PASS, "Safe not assigned successfully with over/short.");
				}
			}
		}
	}
}
