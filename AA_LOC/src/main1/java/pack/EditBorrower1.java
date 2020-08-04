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

public class EditBorrower1 extends AA_LOC {
	
	
	public static void EditBorrower1(String SSN,String FileName) throws Exception

	{

		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LOC_Regression/"+FileName);

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
				String NextPayday1;

				String NextPayday2 ;

				String NextPayday3 ;

				//String UserName = TestData.getCellData(sheetName,"UserName",row);

				//String Password = TestData.getCellData(sheetName,"Password",row);

				//String StoreID = TestData.getCellData(sheetName,"StoreID",row);

				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);

				String MonthlyPayDay=TestData.getCellData(sheetName,"MonthlyPayDay",row);

				String Income_PayFrequency=TestData.getCellData(sheetName,"Income_PayFrequency",row);

				String SemiMonOthFirstDay=TestData.getCellData(sheetName,"SemiMonOthFirstDay",row);

				System.out.println(AdminURL);

				test.log(LogStatus.INFO, "Scheduler-Store Aging");

				System.out.println(ProductID);

				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);

				//appUrl = AppURL;

				Login.Login(UserName,Password,StoreId);

				String SSN1 = SSN.substring(0, 3);

				String SSN2 = SSN.substring(3,5);

				String SSN3 = SSN.substring(5,9);

				Thread.sleep(2000);

				String Monthlydate=null;

				String Monthlydate1=null;

				if(MonthlyPayDay.length()==3)

				{

					Monthlydate = MonthlyPayDay.substring(0, 1);

					Monthlydate1="0"+Monthlydate;

				}

				if(MonthlyPayDay.length()==4)

				{

					Monthlydate1 = MonthlyPayDay.substring(0, 2);

				}

				System.out.println(Monthlydate1);

				WebDriverWait wait = new WebDriverWait(driver, 30);

				driver.switchTo().frame("topFrame");

				driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();

				test.log(LogStatus.PASS, "Clicked on Borrower");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

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
				
				/*driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");*/

				String NextPayday =null;

				if(Income_PayFrequency.equals("Bi-Weekly"))

				{

					// //*[@id="biWk_second"] //*[@id="biWk_second"]/text()
					//NextPayday = driver.findElement(By.xpath("//*[@id='biWeekly']/td/table/tbody/tr[2]/td[2]/input")).getAttribute("value");
					//*[@id="biWk_second"]
					NextPayday = driver.findElement(By.id("biwksndid")).getAttribute("value");
					
                      Thread.sleep(50000);
					String PayStubReviewedDate0[] =NextPayday.split("/");

					String PayStubReviewedDate2 = PayStubReviewedDate0[0];

					String month=null;

					if(PayStubReviewedDate2.length()==1)

					{

						month = "0"+PayStubReviewedDate0[0];

					}

					else

					{

						month = PayStubReviewedDate0[0];

					}

					// int day= Integer.parseInt(PayStubReviewedDate2);

					String Day = PayStubReviewedDate0[1];

					if(Day.length()==1)

					{

						Day = "0"+PayStubReviewedDate0[1];

					}

					else

					{

						Day = PayStubReviewedDate0[1];

					}

					String Year = PayStubReviewedDate0[2];

					NextPayday = month+"/"+Day+"/"+Year;

				}

				if(Income_PayFrequency.equals("Monthly"))

				{

					driver.switchTo().defaultContent();

					driver.switchTo().frame("bottom");

					String BusinessDt= driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();

					String Busdate[]=BusinessDt.split(":");

					String date = Busdate[1];

					DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

					Date d1 = df.parse(date);

					Calendar cal = Calendar.getInstance();

					cal.setTime(d1);

					cal.add(Calendar.DATE, -10);

					Date PayStubReviewedDate1= cal.getTime();

					String PayStubReviewedDate =df.format(PayStubReviewedDate1);

					//Date D=Add(date1,7);

					//System.out.println(date);

					//System.out.println(PayStubReviewedDate);

					String PayStubReviewedDate0[] =PayStubReviewedDate.split("/");

					String PayStubReviewedDate2 = PayStubReviewedDate0[0];

					int day= Integer.parseInt(PayStubReviewedDate2);

					String PayStubReviewedDate3 = PayStubReviewedDate0[1];

					String PayStubReviewedDate4 = PayStubReviewedDate0[2];

					int yyyy= Integer.parseInt(PayStubReviewedDate4);

					int DD= day+1;

					String month="0"+String.valueOf(DD);

					String days=Monthlydate1;

					String year=null;

					if(day==12)

					{

						yyyy=yyyy+1;

						year=String.valueOf(yyyy);

					}

					else

					{

						year=PayStubReviewedDate4;

					}

					NextPayday = month+"/"+days+"/"+year;

				}

				if(Income_PayFrequency.equals("Semi-Monthly"))

				{

					driver.switchTo().defaultContent();

					driver.switchTo().frame("bottom");

					String BusinessDt= driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();

					String Busdate[]=BusinessDt.split(":");

					String date = Busdate[1];

					DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

					Date d1 = df.parse(date);

					Calendar cal = Calendar.getInstance();

					cal.setTime(d1);

					cal.add(Calendar.DATE, 0);

					Date PayStubReviewedDate1= cal.getTime();

					String PayStubReviewedDate =df.format(PayStubReviewedDate1);

					//Date D=Add(date1,7);

					//System.out.println(date);

					//System.out.println(PayStubReviewedDate);

					String PayStubReviewedDate0[] =PayStubReviewedDate.split("/");

					String PayStubReviewedDate2 = PayStubReviewedDate0[0];

					int day= Integer.parseInt(PayStubReviewedDate2);

					String PayStubReviewedDate3 = PayStubReviewedDate0[1];

					String PayStubReviewedDate4 = PayStubReviewedDate0[2];

					int yyyy= Integer.parseInt(PayStubReviewedDate4);

					int DD= day+1;

					String month="0"+String.valueOf(DD);

					String days="01";

					String year=null;

					if(day==12)

					{

						yyyy=yyyy+1;

						year=String.valueOf(yyyy);

					}

					else

					{

						year=PayStubReviewedDate4;

					}

					NextPayday = month+"/"+days+"/"+year;

				}

				if(Income_PayFrequency.equals("Weekly"))

				{

					driver.switchTo().defaultContent();

					driver.switchTo().frame("bottom");
                     Thread.sleep(2000);
					String BusinessDt= driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					// /html/body/blink/table/tbody/tr/td[4]/text()
				 //                                             	/html/body/blink/table/tbody/tr/td[4]/text()
					//String BusinessDt= driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();


					String Busdate[]=BusinessDt.split(":");

					String date = Busdate[1];

					DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

					Date d1 = df.parse(date);

					Calendar cal = Calendar.getInstance();

					cal.setTime(d1);

					/*if(SemiMonOthFirstDay.equals("Monday"))

					{

						cal.add(Calendar.DATE, 1);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Tuesday"))

					{

						cal.add(Calendar.DATE, 2);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Wednesday"))

					{

						cal.add(Calendar.DATE, 3);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Thursday"))

					{

						cal.add(Calendar.DATE, 4);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Friday"))

					{

						cal.add(Calendar.DATE, 5);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Saturday"))

					{

						cal.add(Calendar.DATE, 6);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Sunday"))

					{

						cal.add(Calendar.DATE, 7);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}*/

					//Date D=Add(date1,7);

					//System.out.println(date);

					//System.out.println(PayStubReviewedDate);
					DateFormat df1=new SimpleDateFormat("MM/dd/yyyy");
					Date DDueDate = df.parse(NextPayday);

					Calendar cal1 = Calendar.getInstance();

					cal1.setTime(DDueDate);

					cal1.add(Calendar.DATE, -10);

					Date DDueDateminus1= cal1.getTime();

					String DueDateminus1 =df1.format(DDueDateminus1);

					String NextPayday0[] =DueDateminus1.split("/");

					 NextPayday1 = NextPayday0[0];

					 NextPayday2 = NextPayday0[1];

					 NextPayday3 = NextPayday0[2];

				test.log(LogStatus.PASS,"Next Paydate."+NextPayday);

				/* driver.switchTo().defaultContent();

		driver.switchTo().frame("topFrame");

		driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();*/

				driver.quit(); //need to change to c

				Launch.Launch();

				driver.get(AdminURL);

				test.log(LogStatus.INFO, "Admin portal is launched");

				driver.manage().window().maximize();

				// storeupdate(UserName,Password,StoreID,DueDate,AdminURL);



				

				driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");

				test.log(LogStatus.PASS, "Username is entered: admin");

				driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

				test.log(LogStatus.PASS, "Password is entered: "+Password);

				//Click Login Button

				driver.findElement(By.name("login")).click();

				test.log(LogStatus.PASS, "Clicked on Submit button");

				Thread.sleep(1000);

				Thread.sleep(1000);

				/* DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

		Date d1 = df.parse(date);

		Calendar cal = Calendar.getInstance();

		cal.setTime(d1);

		cal.add(Calendar.DATE, -10);*/

				

				//WebDriverWait wait = new WebDriverWait(driver, 30);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();

				test.log(LogStatus.PASS, "Clicked on Transactions");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.linkText("QA Jobs")).click();

				test.log(LogStatus.PASS, "Clicked on QA Jobs");

				Thread.sleep(2000);

				driver.findElement(By.linkText("Process Date Change")).click();

				test.log(LogStatus.PASS, "Clicked on Process Date Change");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("storeCode")).click();

				//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td")).click();

				driver.findElement(By.name("storeCode")).sendKeys(StoreId);

				test.log(LogStatus.PASS, "Store number is entered: "+StoreId);

				Thread.sleep(2000);

				driver.findElement(By.name("beginMonth")).clear();

				driver.findElement(By.name("beginMonth")).sendKeys(NextPayday1);

				test.log(LogStatus.PASS, "beginMonth is entered: "+NextPayday1);

				driver.findElement(By.name("beginDay")).clear();

				driver.findElement(By.name("beginDay")).sendKeys(NextPayday2);

				test.log(LogStatus.PASS, "beginDay is entered: "+NextPayday2);

				driver.findElement(By.name("beginYear")).clear();

				driver.findElement(By.name("beginYear")).sendKeys(NextPayday3);

				test.log(LogStatus.PASS, "beginYear is entered: "+NextPayday3);

				Thread.sleep(2000);

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				Thread.sleep(1000);

				Thread.sleep(2000);

				driver.findElement(By.name("btnPreview")).click();

				test.log(LogStatus.PASS, "Clicked on submit button");

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				if( driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input")).isDisplayed())

				{

					test.log(LogStatus.PASS, "Process Date updated successfully");

				}

				else

				{

					test.log(LogStatus.FAIL, "Process Date updated successfully.");

				}


				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();

				test.log(LogStatus.PASS, "Clicked on Transactions");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.linkText("ACH")).click();

				test.log(LogStatus.PASS, "Clicked on ACH");


				Thread.sleep(2000);

				driver.findElement(By.linkText("LOC")).click();

				test.log(LogStatus.PASS, "Clicked on LOC");

				//driver.switchTo().defaultContent();

				//driver.switchTo().frame("mainFrame");

				Thread.sleep(2000);

				driver.findElement(By.linkText("Default Loc")).click();

				test.log(LogStatus.PASS, "Clicked on Default Loc");



				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				//Thread.sleep(1000);

				/* WebElement element = driver.findElement(By.name("cancel"));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();*/

				//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img")).click();

				Thread.sleep(1000);

				WebElement element = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img"));

				Actions action = new Actions(driver);

				action.moveToElement(element).build().perform();

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				try {

					Alert alert = driver.switchTo().alert();

					alert.dismiss();

					//if alert present, accept and move on.

				}

				catch (NoAlertPresentException e) {

					//do what you normally would if you didn't have the alert.

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("requestBean.storeCode")).sendKeys(StoreId);

				test.log(LogStatus.PASS, "StoreID is entered: "+StoreId);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("beginMonth")).clear();

				driver.findElement(By.name("beginMonth")).sendKeys(NextPayday1);

				test.log(LogStatus.PASS, "beginMonth is entered: "+NextPayday1);

				driver.findElement(By.name("beginDay")).clear();

				driver.findElement(By.name("beginDay")).sendKeys(NextPayday2);

				test.log(LogStatus.PASS, "beginDay is entered: "+NextPayday2);

				driver.findElement(By.name("beginYear")).clear();

				driver.findElement(By.name("beginYear")).sendKeys(NextPayday3);

				test.log(LogStatus.PASS, "beginYear is entered: "+NextPayday3);



				// driver.findElement(By.linkText("iPads")).click();

				driver.findElement(By.name("submit")).click();

				test.log(LogStatus.PASS, "Clicked on submit button");

				Thread.sleep(1000);



					
					
					
				}
				try
				{
					DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
				
					Date DDueDate = df.parse(NextPayday);

					Calendar cal = Calendar.getInstance();

					cal.setTime(DDueDate);

					cal.add(Calendar.DATE, -10);

					Date DDueDateminus1= cal.getTime();

					String DueDateminus1 =df.format(DDueDateminus1);

					String NextPayday0[] =DueDateminus1.split("/");

					 NextPayday1 = NextPayday0[0];

					 NextPayday2 = NextPayday0[1];

					 NextPayday3 = NextPayday0[2];

				test.log(LogStatus.PASS,"Next Paydate."+NextPayday);

				/* driver.switchTo().defaultContent();

		driver.switchTo().frame("topFrame");

		driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();*/

				driver.quit(); //need to change to c

				Launch.Launch();

				driver.get(AdminURL);

				test.log(LogStatus.INFO, "Admin portal is launched");

				driver.manage().window().maximize();

				// storeupdate(UserName,Password,StoreID,DueDate,AdminURL);



				

				driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");

				test.log(LogStatus.PASS, "Username is entered: admin");

				driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

				test.log(LogStatus.PASS, "Password is entered: "+Password);

				//Click Login Button

				driver.findElement(By.name("login")).click();

				test.log(LogStatus.PASS, "Clicked on Submit button");

				Thread.sleep(1000);

				Thread.sleep(1000);

				/* DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

		Date d1 = df.parse(date);

		Calendar cal = Calendar.getInstance();

		cal.setTime(d1);

		cal.add(Calendar.DATE, -10);*/

				

				//WebDriverWait wait = new WebDriverWait(driver, 30);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();

				test.log(LogStatus.PASS, "Clicked on Transactions");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.linkText("QA Jobs")).click();

				test.log(LogStatus.PASS, "Clicked on QA Jobs");

				Thread.sleep(2000);

				driver.findElement(By.linkText("Process Date Change")).click();

				test.log(LogStatus.PASS, "Clicked on Process Date Change");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("storeCode")).click();

				//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td")).click();

				driver.findElement(By.name("storeCode")).sendKeys(StoreId);

				test.log(LogStatus.PASS, "Store number is entered: "+StoreId);

				Thread.sleep(2000);

				driver.findElement(By.name("beginMonth")).clear();

				driver.findElement(By.name("beginMonth")).sendKeys(NextPayday1);

				test.log(LogStatus.PASS, "beginMonth is entered: "+NextPayday1);

				driver.findElement(By.name("beginDay")).clear();

				driver.findElement(By.name("beginDay")).sendKeys(NextPayday2);

				test.log(LogStatus.PASS, "beginDay is entered: "+NextPayday2);

				driver.findElement(By.name("beginYear")).clear();

				driver.findElement(By.name("beginYear")).sendKeys(NextPayday3);

				test.log(LogStatus.PASS, "beginYear is entered: "+NextPayday3);

				Thread.sleep(2000);

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				Thread.sleep(1000);

				Thread.sleep(2000);

				driver.findElement(By.name("btnPreview")).click();

				test.log(LogStatus.PASS, "Clicked on submit button");

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				if( driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input")).isDisplayed())

				{

					test.log(LogStatus.PASS, "Process Date updated successfully");

				}

				else

				{

					test.log(LogStatus.FAIL, "Process Date updated successfully.");

				}


				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();

				test.log(LogStatus.PASS, "Clicked on Transactions");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.linkText("ACH")).click();

				test.log(LogStatus.PASS, "Clicked on ACH");


				Thread.sleep(2000);

				driver.findElement(By.linkText("LOC")).click();

				test.log(LogStatus.PASS, "Clicked on LOC");

				//driver.switchTo().defaultContent();

				//driver.switchTo().frame("mainFrame");

				Thread.sleep(2000);

				driver.findElement(By.linkText("Default Loc")).click();

				test.log(LogStatus.PASS, "Clicked on Default Loc");



				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				//Thread.sleep(1000);

				/* WebElement element = driver.findElement(By.name("cancel"));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();*/

				//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img")).click();

				Thread.sleep(1000);

				WebElement element = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img"));

				Actions action = new Actions(driver);

				action.moveToElement(element).build().perform();

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				try {

					Alert alert = driver.switchTo().alert();

					alert.dismiss();

					//if alert present, accept and move on.

				}

				catch (NoAlertPresentException e) {

					//do what you normally would if you didn't have the alert.

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("requestBean.storeCode")).sendKeys(StoreId);

				test.log(LogStatus.PASS, "StoreID is entered: "+StoreId);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("beginMonth")).clear();

				driver.findElement(By.name("beginMonth")).sendKeys(NextPayday1);

				test.log(LogStatus.PASS, "beginMonth is entered: "+NextPayday1);

				driver.findElement(By.name("beginDay")).clear();

				driver.findElement(By.name("beginDay")).sendKeys(NextPayday2);

				test.log(LogStatus.PASS, "beginDay is entered: "+NextPayday2);

				driver.findElement(By.name("beginYear")).clear();

				driver.findElement(By.name("beginYear")).sendKeys(NextPayday3);

				test.log(LogStatus.PASS, "beginYear is entered: "+NextPayday3);



				// driver.findElement(By.linkText("iPads")).click();

				driver.findElement(By.name("submit")).click();

				test.log(LogStatus.PASS, "Clicked on submit button");

				Thread.sleep(1000);

				}
				catch(Exception e){
					test.log(LogStatus.PASS, "Execution other than weekly");
				}

			}

		}

	}

	
	
	public static void EditBorrower2(String SSN,String FileName) throws Exception

	{

		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LOC_Regression/"+FileName);

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
				String NextPayday1;

				String NextPayday2 ;

				String NextPayday3 ;

				//String UserName = TestData.getCellData(sheetName,"UserName",row);

				//String Password = TestData.getCellData(sheetName,"Password",row);

				//String StoreID = TestData.getCellData(sheetName,"StoreID",row);

				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);

				String MonthlyPayDay=TestData.getCellData(sheetName,"MonthlyPayDay",row);

				String Income_PayFrequency=TestData.getCellData(sheetName,"Income_PayFrequency",row);

				String SemiMonOthFirstDay=TestData.getCellData(sheetName,"SemiMonOthFirstDay",row);

				System.out.println(AdminURL);

				test.log(LogStatus.INFO, "Scheduler-Store Aging");

				System.out.println(ProductID);

				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);

				//appUrl = AppURL;

				Login.Login(UserName,Password,StoreId);

				String SSN1 = SSN.substring(0, 3);

				String SSN2 = SSN.substring(3,5);

				String SSN3 = SSN.substring(5,9);

				Thread.sleep(2000);

				String Monthlydate=null;

				String Monthlydate1=null;

				if(MonthlyPayDay.length()==3)

				{

					Monthlydate = MonthlyPayDay.substring(0, 1);

					Monthlydate1="0"+Monthlydate;

				}

				if(MonthlyPayDay.length()==4)

				{

					Monthlydate1 = MonthlyPayDay.substring(0, 2);

				}

				System.out.println(Monthlydate1);

				WebDriverWait wait = new WebDriverWait(driver, 30);

				driver.switchTo().frame("topFrame");

				driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();

				test.log(LogStatus.PASS, "Clicked on Borrower");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

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
				
				/*driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");*/

				String NextPayday =null;

				if(Income_PayFrequency.equals("Bi-Weekly"))

				{

					// //*[@id="biWk_second"] //*[@id="biWk_second"]/text()
					//NextPayday = driver.findElement(By.xpath("//*[@id='biWeekly']/td/table/tbody/tr[2]/td[2]/input")).getAttribute("value");
					//*[@id="biWk_second"]
					NextPayday = driver.findElement(By.id("biwksndid")).getAttribute("value");
					
                      Thread.sleep(50000);
					String PayStubReviewedDate0[] =NextPayday.split("/");

					String PayStubReviewedDate2 = PayStubReviewedDate0[0];

					String month=null;

					if(PayStubReviewedDate2.length()==1)

					{

						month = "0"+PayStubReviewedDate0[0];

					}

					else

					{

						month = PayStubReviewedDate0[0];

					}

					// int day= Integer.parseInt(PayStubReviewedDate2);

					String Day = PayStubReviewedDate0[1];

					if(Day.length()==1)

					{

						Day = "0"+PayStubReviewedDate0[1];

					}

					else

					{

						Day = PayStubReviewedDate0[1];

					}

					String Year = PayStubReviewedDate0[2];

					NextPayday = month+"/"+Day+"/"+Year;

				}

				if(Income_PayFrequency.equals("Monthly"))

				{

					driver.switchTo().defaultContent();

					driver.switchTo().frame("bottom");

					String BusinessDt= driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();

					String Busdate[]=BusinessDt.split(":");

					String date = Busdate[1];

					DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

					Date d1 = df.parse(date);

					Calendar cal = Calendar.getInstance();

					cal.setTime(d1);

					cal.add(Calendar.DATE, -10);

					Date PayStubReviewedDate1= cal.getTime();

					String PayStubReviewedDate =df.format(PayStubReviewedDate1);

					//Date D=Add(date1,7);

					//System.out.println(date);

					//System.out.println(PayStubReviewedDate);

					String PayStubReviewedDate0[] =PayStubReviewedDate.split("/");

					String PayStubReviewedDate2 = PayStubReviewedDate0[0];

					int day= Integer.parseInt(PayStubReviewedDate2);

					String PayStubReviewedDate3 = PayStubReviewedDate0[1];

					String PayStubReviewedDate4 = PayStubReviewedDate0[2];

					int yyyy= Integer.parseInt(PayStubReviewedDate4);

					int DD= day+1;

					String month="0"+String.valueOf(DD);

					String days=Monthlydate1;

					String year=null;

					if(day==12)

					{

						yyyy=yyyy+1;

						year=String.valueOf(yyyy);

					}

					else

					{

						year=PayStubReviewedDate4;

					}

					NextPayday = month+"/"+days+"/"+year;

				}

				if(Income_PayFrequency.equals("Semi-Monthly"))

				{

					driver.switchTo().defaultContent();

					driver.switchTo().frame("bottom");

					String BusinessDt= driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();

					String Busdate[]=BusinessDt.split(":");

					String date = Busdate[1];

					DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

					Date d1 = df.parse(date);

					Calendar cal = Calendar.getInstance();

					cal.setTime(d1);

					cal.add(Calendar.DATE, 0);

					Date PayStubReviewedDate1= cal.getTime();

					String PayStubReviewedDate =df.format(PayStubReviewedDate1);

					//Date D=Add(date1,7);

					//System.out.println(date);

					//System.out.println(PayStubReviewedDate);

					String PayStubReviewedDate0[] =PayStubReviewedDate.split("/");

					String PayStubReviewedDate2 = PayStubReviewedDate0[0];

					int day= Integer.parseInt(PayStubReviewedDate2);

					String PayStubReviewedDate3 = PayStubReviewedDate0[1];

					String PayStubReviewedDate4 = PayStubReviewedDate0[2];

					int yyyy= Integer.parseInt(PayStubReviewedDate4);

					int DD= day+1;

					String month="0"+String.valueOf(DD);

					String days="01";

					String year=null;

					if(day==12)

					{

						yyyy=yyyy+1;

						year=String.valueOf(yyyy);

					}

					else

					{

						year=PayStubReviewedDate4;

					}

					NextPayday = month+"/"+days+"/"+year;

				}

				if(Income_PayFrequency.equals("Weekly"))

				{

					driver.switchTo().defaultContent();

					driver.switchTo().frame("bottom");
Thread.sleep(2000);
					String BusinessDt= driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					// /html/body/blink/table/tbody/tr/td[4]/text()
				 //                                             	/html/body/blink/table/tbody/tr/td[4]/text()
					//String BusinessDt= driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();


					String Busdate[]=BusinessDt.split(":");

					String date = Busdate[1];

					DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

					Date d1 = df.parse(date);

					Calendar cal = Calendar.getInstance();

					cal.setTime(d1);

					/*if(SemiMonOthFirstDay.equals("Monday"))

					{

						cal.add(Calendar.DATE, 1);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Tuesday"))

					{

						cal.add(Calendar.DATE, 2);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Wednesday"))

					{

						cal.add(Calendar.DATE, 3);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Thursday"))

					{

						cal.add(Calendar.DATE, 4);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Friday"))

					{

						cal.add(Calendar.DATE, 5);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Saturday"))

					{

						cal.add(Calendar.DATE, 6);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}

					if(SemiMonOthFirstDay.equals("Sunday"))

					{

						cal.add(Calendar.DATE, 7);

						Date PayStubReviewedDate1= cal.getTime();

						NextPayday =df.format(PayStubReviewedDate1);

					}*/

					//Date D=Add(date1,7);

					//System.out.println(date);

					//System.out.println(PayStubReviewedDate);
					DateFormat df1=new SimpleDateFormat("MM/dd/yyyy");
					Date DDueDate = df.parse(NextPayday);

					Calendar cal1 = Calendar.getInstance();

					cal1.setTime(DDueDate);

					cal1.add(Calendar.DATE, -10);

					Date DDueDateminus1= cal1.getTime();

					String DueDateminus1 =df1.format(DDueDateminus1);

					String NextPayday0[] =DueDateminus1.split("/");

					 NextPayday1 = NextPayday0[0];

					 NextPayday2 = NextPayday0[1];

					 NextPayday3 = NextPayday0[2];

				test.log(LogStatus.PASS,"Next Paydate."+NextPayday);

				/* driver.switchTo().defaultContent();

		driver.switchTo().frame("topFrame");

		driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();*/

				driver.quit(); //need to change to c

				Launch.Launch();

				driver.get(AdminURL);

				test.log(LogStatus.INFO, "Admin portal is launched");

				driver.manage().window().maximize();

				// storeupdate(UserName,Password,StoreID,DueDate,AdminURL);



				

				driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");

				test.log(LogStatus.PASS, "Username is entered: admin");

				driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

				test.log(LogStatus.PASS, "Password is entered: "+Password);

				//Click Login Button

				driver.findElement(By.name("login")).click();

				test.log(LogStatus.PASS, "Clicked on Submit button");

				Thread.sleep(1000);

				Thread.sleep(1000);

				/* DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

		Date d1 = df.parse(date);

		Calendar cal = Calendar.getInstance();

		cal.setTime(d1);

		cal.add(Calendar.DATE, -10);*/

				

				//WebDriverWait wait = new WebDriverWait(driver, 30);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();

				test.log(LogStatus.PASS, "Clicked on Transactions");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.linkText("QA Jobs")).click();

				test.log(LogStatus.PASS, "Clicked on QA Jobs");

				Thread.sleep(2000);

				driver.findElement(By.linkText("Process Date Change")).click();

				test.log(LogStatus.PASS, "Clicked on Process Date Change");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("storeCode")).click();

				//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td")).click();

				driver.findElement(By.name("storeCode")).sendKeys(StoreId);

				test.log(LogStatus.PASS, "Store number is entered: "+StoreId);

				Thread.sleep(2000);

				driver.findElement(By.name("beginMonth")).clear();

				driver.findElement(By.name("beginMonth")).sendKeys(NextPayday1);

				test.log(LogStatus.PASS, "beginMonth is entered: "+NextPayday1);

				driver.findElement(By.name("beginDay")).clear();

				driver.findElement(By.name("beginDay")).sendKeys(NextPayday2);

				test.log(LogStatus.PASS, "beginDay is entered: "+NextPayday2);

				driver.findElement(By.name("beginYear")).clear();

				driver.findElement(By.name("beginYear")).sendKeys(NextPayday3);

				test.log(LogStatus.PASS, "beginYear is entered: "+NextPayday3);

				Thread.sleep(2000);

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				Thread.sleep(1000);

				Thread.sleep(2000);

				driver.findElement(By.name("btnPreview")).click();

				test.log(LogStatus.PASS, "Clicked on submit button");

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				if( driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input")).isDisplayed())

				{

					test.log(LogStatus.PASS, "Process Date updated successfully");

				}

				else

				{

					test.log(LogStatus.FAIL, "Process Date updated successfully.");

				}


				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();

				test.log(LogStatus.PASS, "Clicked on Transactions");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.linkText("ACH")).click();

				test.log(LogStatus.PASS, "Clicked on ACH");


				Thread.sleep(2000);

				driver.findElement(By.linkText("LOC")).click();

				test.log(LogStatus.PASS, "Clicked on LOC");

				//driver.switchTo().defaultContent();

				//driver.switchTo().frame("mainFrame");

				Thread.sleep(2000);

				driver.findElement(By.linkText("Default Loc")).click();

				test.log(LogStatus.PASS, "Clicked on Default Loc");



				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				//Thread.sleep(1000);

				/* WebElement element = driver.findElement(By.name("cancel"));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();*/

				//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img")).click();

				Thread.sleep(1000);

				WebElement element = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img"));

				Actions action = new Actions(driver);

				action.moveToElement(element).build().perform();

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				try {

					Alert alert = driver.switchTo().alert();

					alert.dismiss();

					//if alert present, accept and move on.

				}

				catch (NoAlertPresentException e) {

					//do what you normally would if you didn't have the alert.

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("requestBean.storeCode")).sendKeys(StoreId);

				test.log(LogStatus.PASS, "StoreID is entered: "+StoreId);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("beginMonth")).clear();

				driver.findElement(By.name("beginMonth")).sendKeys(NextPayday1);

				test.log(LogStatus.PASS, "beginMonth is entered: "+NextPayday1);

				driver.findElement(By.name("beginDay")).clear();

				driver.findElement(By.name("beginDay")).sendKeys(NextPayday2);

				test.log(LogStatus.PASS, "beginDay is entered: "+NextPayday2);

				driver.findElement(By.name("beginYear")).clear();

				driver.findElement(By.name("beginYear")).sendKeys(NextPayday3);

				test.log(LogStatus.PASS, "beginYear is entered: "+NextPayday3);



				// driver.findElement(By.linkText("iPads")).click();

				driver.findElement(By.name("submit")).click();

				test.log(LogStatus.PASS, "Clicked on submit button");

				Thread.sleep(1000);



					
					
					
				}
				try
				{
					DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
				
					Date DDueDate = df.parse(NextPayday);

					Calendar cal = Calendar.getInstance();

					cal.setTime(DDueDate);

					cal.add(Calendar.DATE, -10);

					Date DDueDateminus1= cal.getTime();

					String DueDateminus1 =df.format(DDueDateminus1);

					String NextPayday0[] =DueDateminus1.split("/");

					 NextPayday1 = NextPayday0[0];

					 NextPayday2 = NextPayday0[1];

					 NextPayday3 = NextPayday0[2];

				test.log(LogStatus.PASS,"Next Paydate."+NextPayday);

				/* driver.switchTo().defaultContent();

		driver.switchTo().frame("topFrame");

		driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();*/

				driver.quit(); //need to change to c

				Launch.Launch();

				driver.get(AdminURL);

				test.log(LogStatus.INFO, "Admin portal is launched");

				driver.manage().window().maximize();

				// storeupdate(UserName,Password,StoreID,DueDate,AdminURL);



				

				driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");

				test.log(LogStatus.PASS, "Username is entered: admin");

				driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

				test.log(LogStatus.PASS, "Password is entered: "+Password);

				//Click Login Button

				driver.findElement(By.name("login")).click();

				test.log(LogStatus.PASS, "Clicked on Submit button");

				Thread.sleep(1000);

				Thread.sleep(1000);

				/* DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

		Date d1 = df.parse(date);

		Calendar cal = Calendar.getInstance();

		cal.setTime(d1);

		cal.add(Calendar.DATE, -10);*/

				

				//WebDriverWait wait = new WebDriverWait(driver, 30);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();

				test.log(LogStatus.PASS, "Clicked on Transactions");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.linkText("QA Jobs")).click();

				test.log(LogStatus.PASS, "Clicked on QA Jobs");

				Thread.sleep(2000);

				driver.findElement(By.linkText("Process Date Change")).click();

				test.log(LogStatus.PASS, "Clicked on Process Date Change");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("storeCode")).click();

				//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td")).click();

				driver.findElement(By.name("storeCode")).sendKeys(StoreId);

				test.log(LogStatus.PASS, "Store number is entered: "+StoreId);

				Thread.sleep(2000);

				driver.findElement(By.name("beginMonth")).clear();

				driver.findElement(By.name("beginMonth")).sendKeys(NextPayday1);

				test.log(LogStatus.PASS, "beginMonth is entered: "+NextPayday1);

				driver.findElement(By.name("beginDay")).clear();

				driver.findElement(By.name("beginDay")).sendKeys(NextPayday2);

				test.log(LogStatus.PASS, "beginDay is entered: "+NextPayday2);

				driver.findElement(By.name("beginYear")).clear();

				driver.findElement(By.name("beginYear")).sendKeys(NextPayday3);

				test.log(LogStatus.PASS, "beginYear is entered: "+NextPayday3);

				Thread.sleep(2000);

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				Thread.sleep(1000);

				Thread.sleep(2000);

				driver.findElement(By.name("btnPreview")).click();

				test.log(LogStatus.PASS, "Clicked on submit button");

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				if( driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input")).isDisplayed())

				{

					test.log(LogStatus.PASS, "Process Date updated successfully");

				}

				else

				{

					test.log(LogStatus.FAIL, "Process Date updated successfully.");

				}


				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();

				test.log(LogStatus.PASS, "Clicked on Transactions");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.linkText("ACH")).click();

				test.log(LogStatus.PASS, "Clicked on ACH");


				Thread.sleep(2000);

				driver.findElement(By.linkText("LOC")).click();

				test.log(LogStatus.PASS, "Clicked on LOC");

				//driver.switchTo().defaultContent();

				//driver.switchTo().frame("mainFrame");

				Thread.sleep(2000);

				driver.findElement(By.linkText("Default Loc")).click();

				test.log(LogStatus.PASS, "Clicked on Default Loc");



				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				//Thread.sleep(1000);

				/* WebElement element = driver.findElement(By.name("cancel"));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();*/

				//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img")).click();

				Thread.sleep(1000);

				WebElement element = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img"));

				Actions action = new Actions(driver);

				action.moveToElement(element).build().perform();

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				try {

					Alert alert = driver.switchTo().alert();

					alert.dismiss();

					//if alert present, accept and move on.

				}

				catch (NoAlertPresentException e) {

					//do what you normally would if you didn't have the alert.

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("requestBean.storeCode")).sendKeys(StoreId);

				test.log(LogStatus.PASS, "StoreID is entered: "+StoreId);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("beginMonth")).clear();

				driver.findElement(By.name("beginMonth")).sendKeys(NextPayday1);

				test.log(LogStatus.PASS, "beginMonth is entered: "+NextPayday1);

				driver.findElement(By.name("beginDay")).clear();

				driver.findElement(By.name("beginDay")).sendKeys(NextPayday2);

				test.log(LogStatus.PASS, "beginDay is entered: "+NextPayday2);

				driver.findElement(By.name("beginYear")).clear();

				driver.findElement(By.name("beginYear")).sendKeys(NextPayday3);

				test.log(LogStatus.PASS, "beginYear is entered: "+NextPayday3);



				// driver.findElement(By.linkText("iPads")).click();

				driver.findElement(By.name("submit")).click();

				test.log(LogStatus.PASS, "Clicked on submit button");

				Thread.sleep(1000);

				}
				catch(Exception e){
					test.log(LogStatus.PASS, "Execution other than weekly");
				}

			}

		}

	}


	}
