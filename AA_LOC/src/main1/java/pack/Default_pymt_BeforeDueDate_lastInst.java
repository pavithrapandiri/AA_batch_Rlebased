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

public class Default_pymt_BeforeDueDate_lastInst extends AA_LOC {
	public static void Default_pymt_BeforeDueDate_lastInst(String SSN,String FileName,int Days, int i) throws Exception
	{

		Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/LOC/"+FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		System.out.println("NewLoan "+lastrow);
		String sheetName="NewLoan";
		String dt = null;
		for(int row=2;row<=lastrow;row++)
		{
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{

				String ProductID=TestData.getCellData(sheetName,"ProductID",row);
				//String UserName = TestData.getCellData(sheetName,"UserName",row);
				//String Password = TestData.getCellData(sheetName,"Password",row);
				//String StoreId = TestData.getCellData(sheetName,"StoreId",row);
				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
				String ESign_TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String Parent_Window = driver.getWindowHandle();
				System.out.println(AdminURL);
				test.log(LogStatus.INFO, "Scheduler-Store Aging");

				System.out.println(ProductID);
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				//appUrl = AppURL;
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(5000);
				Thread.sleep(1000);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
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


				if(ProductID.equals("LOC"))
				{

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				}
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.name("transactionList")).sendKeys("History");
				if(ProductID.equals("LOC"))
				{
					driver.findElement(By.name("button")).click();
				}

				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");


				///html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input
				if(driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input")).isDisplayed())
				{
					test.log(LogStatus.PASS, "RCC Schedule Generated");

					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input")).click();


					for( String winHandle1 : driver.getWindowHandles())

					{
						if(!(winHandle1.equals(Parent_Window)))
						{
							driver.switchTo().window(winHandle1);
							Thread.sleep(6000);
							System.out.println(driver.getTitle());
							String PaymentAmount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+i+"]/td[2]")).getText();
							//    /html/body/form/table/tbody/tr[2]/td[2]
							test.log(LogStatus.PASS, "Payment Amount"+PaymentAmount);
							System.out.println(PaymentAmount);
							dt = driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+i+"]/td[3]")).getText();
							test.log(LogStatus.PASS, "Date" +dt);
							System.out.println(PaymentAmount);

							driver.quit();
							//driver.close();
							driver = new InternetExplorerDriver();
							driver.get(AdminURL);
							test.log(LogStatus.PASS, "date in outside loop"+dt);




							String DDe[] =dt.split(" ");

							DateFormat  df=new SimpleDateFormat("yyyy-MM-dd");


							String DueDate = DDe[0];

							String DDueDate[] =DueDate.split("-");


							Date DDueDateminus1 = df.parse(DueDate);

							Calendar cal = Calendar.getInstance();

							cal.setTime(DDueDateminus1);

							cal.add(Calendar.DATE, Days);

							Date DDueDate1= cal.getTime();

							DueDate =df.format(DDueDate1);

							String DueDate0[] =DueDate.split("-");

							String DueDate3 = DueDate0[0];
							String DueDate1 = DueDate0[1];

							String DueDate2 = DueDate0[2];


							//driver.close();
							//appUrl = AppURL;
							Login.Login(UserName, Password, StoreId);
							//String SSN1 = SSN.substring(0, 3);
							//String SSN2 = SSN.substring(3,5);
							//String SSN3 = SSN.substring(5,9);
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


							if(ProductID.equals("LOC"))
							{

								//driver.findElement(By.name("button")).click();
								///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
								driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[11]/input[1]")).click();
							}
							//  driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Click on GO Button");
							for( String winHandle2 : driver.getWindowHandles())
							{
								driver.switchTo().window(winHandle2);
							}			
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							driver.findElement(By.name("transactionList")).sendKeys("Default Payment");
							if(ProductID.equals("LOC"))
							{
								driver.findElement(By.name("button")).click(); 
							}

							for( String winHandle2 : driver.getWindowHandles())
							{
								driver.switchTo().window(winHandle2);
							}			
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");

							//String PaymentAmount=null;

						   driver.findElement(By.name("requestBean.paymentAmt")).clear();
						    driver.findElement(By.name("requestBean.paymentAmt")).sendKeys(PaymentAmount);
							test.log(LogStatus.PASS, "Capture the Payment Amt"+PaymentAmount);
							Thread.sleep(2000);
							driver.findElement(By.name("requestBean.tenderType")).sendKeys(ESign_TenderType);
							test.log(LogStatus.PASS, "Select the Tender Type");

							driver.findElement(By.name("requestBean.tenderAmt")).sendKeys(PaymentAmount);
							test.log(LogStatus.PASS, "Enter the Tender Amount");

							driver.findElement(By.name("password")).sendKeys(Password);
							test.log(LogStatus.PASS, "Enter the Password");

							driver.findElement(By.name("Submit22")).click();
							test.log(LogStatus.PASS, "Click on Finish Payment Button");

							test.log(LogStatus.INFO, "Default_Payment with-SSN: " +SSN +" :: is ::"+"Successful");

							driver.close();
							driver = new InternetExplorerDriver();




						}

					}

				}



			}
		}
	}
	 				}
