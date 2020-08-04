package pack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EditBorrower_ChangeFrequency_Monthly extends AA_LOC {
	public static void EditBorrower_ChangeFrequency_Monthly(String SSN,String FileName) throws Exception

	{

		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/LOC/"+FileName);

		int lastrow=TestData.getLastRow("NewLoan");

		System.out.println("NewLoan"+lastrow);

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

				String MonthlyPayDay=TestData.getCellData(sheetName,"MonthlyPayDay",row);

				String Income_PayFrequency=TestData.getCellData(sheetName,"Income_PayFrequency",row);

				String SemiMonOthFirstDay=TestData.getCellData(sheetName,"SemiMonOthFirstDay",row);

				System.out.println(AdminURL);

				test.log(LogStatus.INFO, "Scheduler-Store Aging");

				System.out.println(ProductID);

				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);

				

				Login.Login(UserName, Password, StoreId);

				String SSN1 = SSN.substring(0, 3);

				String SSN2 = SSN.substring(3,5);

				String SSN3 = SSN.substring(5,9);

				Thread.sleep(5000);




				WebDriverWait wait = new WebDriverWait(driver, 1000);

				driver.switchTo().frame("topFrame");

				driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();

				test.log(LogStatus.PASS, "Clicked on Borrower");

				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='902000']")));

				driver.findElement(By.cssSelector("li[id='902000']")).click();

				//driver.findElement(By.cssSelector("//*[@id='902000']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Edit");

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

				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}

				for(String winHandle : driver.getWindowHandles()){

					driver.switchTo().window(winHandle);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[2]/td[8]/div[3]/input")).click();
				
                try {

                    Alert alert = driver.switchTo().alert();

                    alert.accept();

                    //if alert present, accept and move on.

                }

                catch (NoAlertPresentException e) {

                    //do what you normally would if you didn't have the alert.

                }


				driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys("Monthly");
				test.log(LogStatus.PASS, "Monthly PayFrequency Selected as :: Monthly");
				driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("10th");

				test.log(LogStatus.PASS, "Monthly PayFrequency day is Selected as :: 10");
				driver.findElement(By.id("btnShowModalExit")).click();  
				test.log(LogStatus.PASS, "Click on save and exit");


				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
			}

		}

	}

	 				}
