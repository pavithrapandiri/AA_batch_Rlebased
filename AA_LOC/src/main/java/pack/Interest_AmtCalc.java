package pack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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

public class Interest_AmtCalc extends AA_LOC {
	public static void Interest_AmtCalc(String SSN,String FileName,double d) throws Exception
	{

		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/LOC/"+FileName);	
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
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String ESign_TenderType = TestData.getCellData(sheetName,"TenderType",row);
				System.out.println(AdminURL);
				String DueDate=null;
				test.log(LogStatus.INFO, "Default_Payment with-SSN: " +SSN +" :: is ::"+"Starts");
				System.out.println(ProductID);	
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
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
					//	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[8]/td[11]/input[1]")).click();

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[8]/td[11]/input[1]")).click();
					//driver.findElement(By.name("button")).click();
					///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[11]/input[1]")).click();
				}
				//  driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				///  /html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[9]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
				String  LoanDt= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[9]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]")).getText();

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

				////////////
				/*	driver.switchTo().frame("bottom");*/
				// String  BusinessDt= driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				/*	 String Busdate[]=LoanDt.split(":");
			 String date = Busdate[1];*/

				// 
				/*			String  DueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[11]/td[2]/span[2]")).getText();
               //*[@id="revolvingCreditHistTable"]/tbody/tr[11]/td[2]/span[2]
test.log(LogStatus.PASS, "Captured Date: "+DueDate);*/

				/*	String DueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[4]/td[3]/span[2]")).getText();
				 */	
				/*	String DDueDate[] =DueDate.split("/");*/




				/*	//	DueDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
				DueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[4]/td[3]/span[2]")).getText();
				//*[@id="revolvingCreditHistTable"]/tbody/tr[4]/td[3]/span[2]
				 */				
				DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
				DueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[11]/td[2]/span[2]")).getText();

				test.log(LogStatus.PASS, "Capture DueDate"+DueDate);

				System.out.print(DueDate);	



				String DDueDate[] =DueDate.split("/");


				Date DDueDateminus1 = df.parse(DueDate);

				Calendar cal = Calendar.getInstance();

				cal.setTime(DDueDateminus1);

				cal.add(Calendar.DATE, 0);

				Date DDueDate1= cal.getTime();

				DueDate =df.format(DDueDate1);

				String DueDate0[] =DueDate.split("/");

				String DueDate1 = DueDate0[0];
				int month = Integer.valueOf(DueDate1);
				test.log(LogStatus.PASS, "month ::"+month);
				String DueDate2 = DueDate0[1];
				int date = Integer.valueOf(DueDate2);
				int day =date+1;
				test.log(LogStatus.PASS, "date ::"+day);
				String DueDate3 = DueDate0[2];
				int year = Integer.valueOf(DueDate3);
				test.log(LogStatus.PASS, "year ::"+year);



				String DDueDate4[] =LoanDt.split("/");


				Date DDueDateminus4 = df.parse(LoanDt);

				Calendar cal1 = Calendar.getInstance();

				cal1.setTime(DDueDateminus4);

				cal.add(Calendar.DATE, 0);

				Date DDueDat41= cal1.getTime();

				LoanDt =df.format(DDueDat41);
				DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
				Date firstDate = sdf.parse(DueDate);
				Date secondDate = sdf.parse(LoanDt);

				long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
				long diff1 = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				test.log(LogStatus.PASS, "Difference Days ::"+diff1);
				String DDueDat410[] =LoanDt.split("/");

				String DDueDat411 = DDueDat410[0];
				//Date month1 = format.parse(DDueDat411);
				int month1 = Integer.valueOf(DDueDat411);
				test.log(LogStatus.PASS, "month1 ::"+month1);
				String DDueDat412 = DDueDat410[1];
				//Date date = format.parse(DDueDat412);
				int date1 = Integer.valueOf(DDueDat412);

				test.log(LogStatus.PASS, "date1 ::"+date1);
				String DDueDat413 = DDueDat410[2];
				int year1 = Integer.valueOf(DDueDat413);
				test.log(LogStatus.PASS, "year1 ::"+year1);

				LocalDate endofCentury = LocalDate.of(year, month, day); 
				test.log(LogStatus.PASS, "endofCentury ::"+endofCentury);
				LocalDate endofCentury1 = LocalDate.of(year1, month1, date1); 
				test.log(LogStatus.PASS, "endofCentury1 ::"+endofCentury1);
				Period diff = Period.between(endofCentury1, endofCentury);
				test.log(LogStatus.PASS, "Date Difference ::"+diff);

				int a =diff.getDays();

				test.log(LogStatus.PASS, "Date Difference ::"+a);






				String InterestAmt=null;
				String CustFee=null;
				//*[@id="revolvingCreditDetailsTable"]/tbody/tr[5]/td[8]
				InterestAmt = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr[5]/td[8]")).getText();
				test.log(LogStatus.PASS, "Calculated  InterestAmt :: "+InterestAmt);
				CustFee = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr[4]/td[11]")).getText();
				test.log(LogStatus.PASS, "Calculated  CustFee :: "+CustFee);
				//	double RegAmt = Double.parseDouble(InterestAmt);
				double IntFee = (300*24.0*a/100)/365;
				test.log(LogStatus.PASS, "Expected  IntFee :: "+IntFee);
				//String ReqAmt = Double.toString(PerAmt);
				if(CollateralType.equals("CASH"))
				{
					//	double RegAmt1 = Double.parseDouble(CustFee);
					double CustomerFee = (300*0.7*a)/100;
					test.log(LogStatus.PASS, "Expected  CustFee :: "+CustomerFee);
				}
				if(CollateralType.equals("ACH"))
				{
					//	double RegAmt1 = Double.parseDouble(CustFee);
					double CustomerFee = (300*0.55*a)/100;
					test.log(LogStatus.PASS, "Expected  CustFee :: "+CustomerFee);
				}


			}
		}
	}
	 				}
