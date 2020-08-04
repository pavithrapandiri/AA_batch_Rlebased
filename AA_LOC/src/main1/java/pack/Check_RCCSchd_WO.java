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

public class Check_RCCSchd_WO extends AA_LOC {
	public static void Check_RCCSchd_WO(String SSN,String FileName,int Days) throws Exception{

		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/LOC/"+FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		System.out.println("NewLoan "+lastrow);
		String sheetName="NewLoan";
		String dt = null;
		String dt1 = null;
		for(int row=2;row<=lastrow;row++)
		{
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{

				String
				ProductID=TestData.getCellData(sheetName,"ProductID",row);
				String UserName
				=TestData.getCellData(sheetName,"UserName",row);
				String Password
				=TestData.getCellData(sheetName,"Password",row);
				String StoreId =TestData.getCellData(sheetName,"StoreId",row);
				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
				String CollateralType =
						TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String PayFrequency =
						TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String Parent_Window = driver.getWindowHandle();
				System.out.println(AdminURL);
				test.log(LogStatus.INFO, "Scheduler-Store Aging");

				System.out.println(ProductID);
				String AppURL =TestData.getCellData(sheetName,"AppURL",row);
				
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(5000);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60,
						TimeUnit.SECONDS);
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

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					//driver.findElement(By.id("go_Button")).click();
				}

				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				//  <input type="button" value="RCC Schedule" class="sortbuttons"onclick="rccSchedule()">
				String val =driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input")).getAttribute("value");
				///html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input
				//    driver.findElement(By.xpath("//input[@value='Go' and@type='button']")).click();

				//if (driver.findElement(By.xpath("//input[@type='button'and @value='RCC Schedule']")).isDisplayed())
				//if(driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input")).isDisplayed())
				if(val.contains("RCC"))
				{
					test.log(LogStatus.PASS, "RCC Schedule Generated");

				}
				else
				{
					// this.EditBorrower_WO(SSN3, FileName);
					String
					TxnType=TestData.getCellData(sheetName,"TxnType",row);

					String TenderType =
							TestData.getCellData(sheetName,"TenderType",row);


					String
					MonthlyPayDay=TestData.getCellData(sheetName,"MonthlyPayDay",row);

					String
					Income_PayFrequency=TestData.getCellData(sheetName,"Income_PayFrequency",row);

					String
					SemiMonOthFirstDay=TestData.getCellData(sheetName,"SemiMonOthFirstDay",row);

					System.out.println(AdminURL);

					test.log(LogStatus.INFO, "Scheduler-Store Aging");

					System.out.println(ProductID);

					

					Login.Login(UserName, Password, StoreId);


					Thread.sleep(5000);

					String Monthlydate=null;

					String Monthlydate1=null;

		/*			if(MonthlyPayDay.length()==3)

					{

						Monthlydate = MonthlyPayDay.substring(0, 1);

						Monthlydate1="0"+Monthlydate;

					}

					if(MonthlyPayDay.length()==4)

					{

						Monthlydate1 = MonthlyPayDay.substring(0, 2);

					}

					System.out.println(Monthlydate1);*/

					WebDriverWait wait = new WebDriverWait(driver, 1000);

					driver.switchTo().frame("topFrame");

					driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();

					test.log(LogStatus.PASS, "Clicked on Borrower");

					driver.manage().timeouts().implicitlyWait(120,
							TimeUnit.SECONDS);

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
						//do what you normally would if you didn't havethe alert.
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

					String NextPayday =null;

					if(Income_PayFrequency.equals("Bi-Weekly"))

					{

						// //*[@id="biWk_second"]
						//*[@id="biWk_second"]/text()
						//*[@id="biWk_second"]
					/*	NextPayday =
								driver.findElement(By.xpath("//*[@id='biWeekly']/td/table/tbody/tr[2]/td[2]/input")).getAttribute("value");
*/
					      driver.findElement(By.xpath("//*[@id='rad_wk4']")).click();
					      // //*[@id="biWk_second"]
							NextPayday = driver.findElement(By.xpath("//*[@id='biwksndid']")).getAttribute("value");
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

						String BusinessDt=
								driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();

						String Busdate[]=BusinessDt.split(":");

						String date = Busdate[1];

						DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

						Date d1 = df.parse(date);

						Calendar cal = Calendar.getInstance();

						cal.setTime(d1);

						cal.add(Calendar.DATE, Days);

						Date PayStubReviewedDate1= cal.getTime();

						String PayStubReviewedDate
						=df.format(PayStubReviewedDate1);

						//Date D=Add(date1,7);

						//System.out.println(date);

						//System.out.println(PayStubReviewedDate);

						String PayStubReviewedDate0[]
								=PayStubReviewedDate.split("/");

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

						String BusinessDt=
								driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();

						String Busdate[]=BusinessDt.split(":");

						String date = Busdate[1];

						DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

						Date d1 = df.parse(date);

						Calendar cal = Calendar.getInstance();

						cal.setTime(d1);

						cal.add(Calendar.DATE, 0);

						Date PayStubReviewedDate1= cal.getTime();

						String PayStubReviewedDate
						=df.format(PayStubReviewedDate1);

						//Date D=Add(date1,7);

						//System.out.println(date);

						//System.out.println(PayStubReviewedDate);

						String PayStubReviewedDate0[]
								=PayStubReviewedDate.split("/");

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

						String BusinessDt=
								driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();

						String Busdate[]=BusinessDt.split(":");

						String date = Busdate[1];

						DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

						Date d1 = df.parse(date);

						Calendar cal = Calendar.getInstance();

						cal.setTime(d1);

						if(SemiMonOthFirstDay.equals("Monday"))

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

						}

						//Date D=Add(date1,7);

						//System.out.println(date);

						//System.out.println(PayStubReviewedDate);

					}

					test.log(LogStatus.PASS,"Next Paydate."+NextPayday);

					/* driver.switchTo().defaultContent();

		                         driver.switchTo().frame("topFrame");

		    driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();*/

					driver.close(); //need to change to c

					driver = new InternetExplorerDriver();

					driver.get(AdminURL);

					test.log(LogStatus.INFO, "Admin portal is launched");

					driver.manage().window().maximize();

					//storeupdate(UserName,Password,StoreId,DueDate,AdminURL);



					DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

					driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");

					test.log(LogStatus.PASS, "Username is entered: admin");

					driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

					test.log(LogStatus.PASS, "Password is entered:"+Password);

					//Click Login Button

					driver.findElement(By.name("login")).click();

					test.log(LogStatus.PASS, "Clicked on Submit button");

					Thread.sleep(8000);

					Thread.sleep(8000);

					/* DateFormat df=new SimpleDateFormat("MM/dd/yyyy");

		                         Date d1 = df.parse(date);

		                         Calendar cal = Calendar.getInstance();

		                         cal.setTime(d1);

		                         cal.add(Calendar.DATE, -10);*/

					Date DDueDate = df.parse(NextPayday);

					Calendar cal = Calendar.getInstance();

					cal.setTime(DDueDate);

					cal.add(Calendar.DATE, Days);

					Date DDueDateminus1= cal.getTime();

					String DueDateminus1 =df.format(DDueDateminus1);

					String NextPayday0[] =DueDateminus1.split("/");

					String NextPayday1 = NextPayday0[0];

					String NextPayday2 = NextPayday0[1];

					String NextPayday3 = NextPayday0[2];

					//WebDriverWait wait = new WebDriverWait(driver,10000);

					driver.switchTo().defaultContent();

					driver.switchTo().frame("topFrame");

					//
					//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

					driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();

					test.log(LogStatus.PASS, "Clicked on Transactions");

					driver.manage().timeouts().implicitlyWait(120,
							TimeUnit.SECONDS);

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.manage().timeouts().implicitlyWait(60,
							TimeUnit.SECONDS);

					driver.findElement(By.linkText("QA Jobs")).click();

					test.log(LogStatus.PASS, "Clicked on QA Jobs");

					Thread.sleep(3000);

					driver.findElement(By.linkText("Process Date Change")).click();

					test.log(LogStatus.PASS, "Clicked on Process DateChange");

					driver.manage().timeouts().implicitlyWait(120,
							TimeUnit.SECONDS);

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					driver.findElement(By.name("storeCode")).click();

					//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td")).click();

					driver.findElement(By.name("storeCode")).sendKeys(StoreId);

					test.log(LogStatus.PASS, "Store number is entered:"+StoreId);

					Thread.sleep(5000);

					driver.findElement(By.name("beginMonth")).clear();

					driver.findElement(By.name("beginMonth")).sendKeys(NextPayday1);

					test.log(LogStatus.PASS, "beginMonth is entered:"+NextPayday1);

					driver.findElement(By.name("beginDay")).clear();

					driver.findElement(By.name("beginDay")).sendKeys(NextPayday2);

					test.log(LogStatus.PASS, "beginDay is entered:"+NextPayday2);

					driver.findElement(By.name("beginYear")).clear();

					driver.findElement(By.name("beginYear")).sendKeys(NextPayday3);

					test.log(LogStatus.PASS, "beginYear is entered:"+NextPayday3);

					Thread.sleep(2000);

					driver.manage().timeouts().implicitlyWait(120,
							TimeUnit.SECONDS);

					Thread.sleep(1000);

					Thread.sleep(5000);

					driver.findElement(By.name("btnPreview")).click();

					test.log(LogStatus.PASS, "Clicked on submit button");

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					if(
							driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input")).isDisplayed())

					{

						test.log(LogStatus.PASS, "Process Date updatedsuccessfully");

					}

					else

					{

						test.log(LogStatus.FAIL, "Process Date updatedsuccessfully.");

					}


					driver.switchTo().defaultContent();

					driver.switchTo().frame("topFrame");

					//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

					driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();

					test.log(LogStatus.PASS, "Clicked on Transactions");

					driver.manage().timeouts().implicitlyWait(120,
							TimeUnit.SECONDS);

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.manage().timeouts().implicitlyWait(60,
							TimeUnit.SECONDS);

					driver.findElement(By.linkText("ACH")).click();

					test.log(LogStatus.PASS, "Clicked on ACH");


					Thread.sleep(5000);

					driver.findElement(By.linkText("LOC")).click();

					test.log(LogStatus.PASS, "Clicked on LOC");

					//driver.switchTo().defaultContent();

					//driver.switchTo().frame("mainFrame");

					Thread.sleep(5000);

					driver.findElement(By.linkText("Default Loc")).click();

					test.log(LogStatus.PASS, "Clicked on Default Loc");



					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					//Thread.sleep(6000);

					/* WebElement element =
		    driver.findElement(By.name("cancel"));

		                         Actions action = new Actions(driver);

		    action.moveToElement(element).build().perform();*/

					//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img")).click();

					Thread.sleep(6000);

					WebElement element =
							driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img"));

					Actions action = new Actions(driver);

					action.moveToElement(element).build().perform();

					driver.manage().timeouts().implicitlyWait(120,
							TimeUnit.SECONDS);

					try {

						Alert alert = driver.switchTo().alert();

						alert.dismiss();

						//if alert present, accept and move on.

					}

					catch (NoAlertPresentException e) {

						//do what you normally would if you didn't have thealert.

					}

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					driver.findElement(By.name("requestBean.storeCode")).sendKeys(StoreId);

					test.log(LogStatus.PASS, "StoreId is entered:"+StoreId);

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					driver.findElement(By.name("beginMonth")).clear();

					driver.findElement(By.name("beginMonth")).sendKeys(NextPayday1);

					test.log(LogStatus.PASS, "beginMonth is entered:"+NextPayday1);

					driver.findElement(By.name("beginDay")).clear();

					driver.findElement(By.name("beginDay")).sendKeys(NextPayday2);

					test.log(LogStatus.PASS, "beginDay is entered:"+NextPayday2);

					driver.findElement(By.name("beginYear")).clear();

					driver.findElement(By.name("beginYear")).sendKeys(NextPayday3);

					test.log(LogStatus.PASS, "beginYear is entered:"+NextPayday3);



					// driver.findElement(By.linkText("iPads")).click();

					driver.findElement(By.name("submit")).click();

					test.log(LogStatus.PASS, "Clicked on submit button");

					Thread.sleep(6000);

				}

				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input")).click();




				/*

		                     ///////////////////
		                     for( String winHandle1 : driver.getWindowHandles())

		                     {
		                         if(!(winHandle1.equals(Parent_Window)))

		                         {
		                             driver.switchTo().window(winHandle1);
		                             Thread.sleep(6000);
		                             System.out.println(driver.getTitle());
		                             int ee =222;
		                             List<WebElement> rows
		    =driver.findElements(By.tagName("tr"));
		                             int ScdCnt = rows.size();
		                             test.log(LogStatus.PASS, "Rows count is"+ScdCnt);


		                             for(int j=2;j<=ScdCnt-1;j++)
		                             {
		                                 //String
		    transactino_value=driver.findElement(By.xpath("//select[@name='transactionList']/option["+j+"]")).getText();
		                                 int k =j+1;
		                             //    String
		    transactino_value1=driver.findElement(By.xpath("//select[@name='transactionList']/option["+k+"]")).getText();

		                                 dt =
		    driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+j+"]/td[3]")).getText();
		                                 dt1 =
		    driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+k+"]/td[3]")).getText();

		                                 test.log(LogStatus.PASS, "date is"+dt);
		                                 System.out.println(dt);
		                                 test.log(LogStatus.PASS, "date is"+dt1);
		                                 System.out.println(dt1);
		                                 String DDe1[]=dt.split(" ");

		                                 String DDe2[]=dt1.split(" ");
		                             //    DateFormat df=new
		    SimpleDateFormat("yyyy-mm-dd");
		                                 String DueDate1 =DDe1[0];
		                                 String DueDate2 = DDe2[0];
		                                 SimpleDateFormat sdf = new
		    SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		                                 Date firstDate = sdf.parse(DueDate1);
		                                 Date secondDate = sdf.parse(DueDate2);
		    ///////////////
		                                 int DAY = (1000 * 60 * 60 * 24);
		                                 long utc1 =
		    Date.UTC(firstDate.getFullYear(), firstDate.getMonth(),
		    firstDate.getDate());
		                                   long utc2 =
		    Date.UTC(secondDate.getFullYear(),secondDate.getMonth(),
		    secondDate.getDate());

		                                   return Math.floor((utc2 - utc1) / DAY);
		                                 //long diff1 = (long)
		    Math.floor(diffInMillies / (1000 * 3600 * 24));

		                                     int diffDays =
		    secondDate.diff(firstDate, days);
		                                 //long diffInMillies = secondDate.getDate()
		    - firstDate.getDate();

		                                 long diffInMillies
		    =Math.negateExact(secondDate.getTime()-firstDate.getTime());
		                                 double diff1 = Math.ceil(diffInMillies /
		    (1000 * 3600 * 24));
		                                 ///////////////



		                                 //long diffInMillies =Math.abs
		    (secondDate.getTime()-firstDate.getTime());
		                                 //long diff1 =
		    TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
		                                 test.log(LogStatus.PASS, "Difference in
		    Schedule Payment Days for PayFrequency ::"+PayFrequency+"is ::"+diff1);
		                                 if (PayFrequency.equals("Bi-Weekly"))
		                                 {

		                                     test.log(LogStatus.PASS, "Date
		    Difference for Bi-WeeklyShould be 14 day");

		                                     test.log(LogStatus.PASS, "Difference in
		    Schedule Payment Days for PayFrequency ::"+PayFrequency+"is ::"+diff1);
		                                     //Long i = Long.parseLong(String)
		                                     String a = Double.toString(diff1);
		                                     //String a = Long.toString(diff1);
		                                     if (a.equals("14"))
		                                     {
		                                         test.log(LogStatus.PASS, "Date
		    Difference for Bi-Weekly is as Expected");
		                                     }
		                                     else
		                                     {
		                                         test.log(LogStatus.PASS, "Date
		    Difference for Bi-Weekly is not as Expected");
		                                     }



		                                 }
		                                 if (PayFrequency.equals("Monthly"))
		                                 {
		                                     test.log(LogStatus.PASS, "Date
		    Difference for Monthly Should be 30 day");
		                                     test.log(LogStatus.PASS, "Difference in
		    Schedule Payment Days for PayFrequency ::"+PayFrequency+"is ::"+diff1);
		                                     String a = Double.toString(diff1);
		                                     //String a = Long.toString(diff1);
		                                     if (a.equals("30"))
		                                     {
		                                         test.log(LogStatus.PASS, "Date
		    Difference for Monthly is as Expected");
		                                     }
		                                     else
		                                     {
		                                         test.log(LogStatus.PASS, "Date
		    Difference for Monthly is not as Expected");
		                                     }

		                                 }
		                                 if (PayFrequency.equals("Semi-Monthly"))
		                                 {

		                                     test.log(LogStatus.PASS, "Date
		    Difference for Semi-Monthly Should be 15 days");
		                                     test.log(LogStatus.PASS, "Difference in
		    Schedule Payment Days for PayFrequency ::"+PayFrequency+"is ::"+diff1);
		                                     //String a =  Long.toString(long)
		                                     if (diff1<=15)
		                                     {
		                                         test.log(LogStatus.PASS, "Date
		    Difference for Semi-Monthly is as Expected");
		                                     }
		                                     else
		                                     {
		                                         test.log(LogStatus.PASS, "Date
		    Difference for Semi-Monthly is not as Expected");
		                                     }
		                                 }
		                                 if (PayFrequency.equals("Weekly"))
		                                 {

		                                     test.log(LogStatus.PASS, "Date
		    Difference for Weekly Should be 14 days");
		                                     test.log(LogStatus.PASS, "Difference in
		    Schedule Payment Days for PayFrequency ::"+PayFrequency+"is ::"+diff1);
		                                     //String a =  Long.toString(long)
		                                     if (diff1<=14)
		                                     {
		                                         test.log(LogStatus.PASS, "Date
		    Difference for Weekly is as Expected");
		                                     }
		                                     else
		                                     {
		                                         test.log(LogStatus.PASS, "Date
		    Difference for Weekly is not as Expected");
		                                     }
		                                 }
		                             }

		                         }

				 */



			}

		}

	}
	 				}
