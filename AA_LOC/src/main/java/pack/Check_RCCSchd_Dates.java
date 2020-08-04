package pack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

public class Check_RCCSchd_Dates extends AA_LOC {
	public static void Check_RCCSchd_Dates(String SSN,String FileName) throws Exception
	{

		Excel TestData = new
				Excel("E:/QC_Workspace/AA_Automation/TestData/LOC/"+FileName);
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

				String ProductID=TestData.getCellData(sheetName,"ProductID",row);
				String UserName =TestData.getCellData(sheetName,"UserName",row);
				String Password =TestData.getCellData(sheetName,"Password",row);
				String StoreId =TestData.getCellData(sheetName,"StoreId",row);
				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
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


				///html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input
				if(driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input")).isDisplayed())
				{
					test.log(LogStatus.PASS, "RCC Schedule Generated");


					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input")).click();






					///////////////////
					for( String winHandle1 : driver.getWindowHandles())

					{
						if(!(winHandle1.equals(Parent_Window)))

						{
							driver.switchTo().window(winHandle1);
							Thread.sleep(6000);
							System.out.println(driver.getTitle());
							int ee =222;
							List<WebElement> rows =driver.findElements(By.tagName("tr"));
							int ScdCnt = rows.size();
							test.log(LogStatus.PASS, "Rows count is"+ScdCnt);


							for(int j=2;j<=ScdCnt-1;j++)
							{
								//String transactino_value=driver.findElement(By.xpath("//select[@name='transactionList']/option["+j+"]")).getText();
								int k =j+1;
								//	String transactino_value1=driver.findElement(By.xpath("//select[@name='transactionList']/option["+k+"]")).getText();

								dt = driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+j+"]/td[3]")).getText();
								dt1 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+k+"]/td[3]")).getText();

								test.log(LogStatus.PASS, "date is"+dt);
								System.out.println(dt);
								test.log(LogStatus.PASS, "date is"+dt1);
								System.out.println(dt1);
								String DDe1[]=dt.split(" ");

								String DDe2[]=dt1.split(" ");
								//	DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
								String DueDate1 =DDe1[0];
								String DueDate2 = DDe2[0];
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

								Date firstDate = sdf.parse(DueDate1);
								Date secondDate = sdf.parse(DueDate2);
								///////////////
								/*							int DAY = (1000 * 60 * 60 * 24);
							long utc1 = Date.UTC(firstDate.getFullYear(), firstDate.getMonth(), firstDate.getDate());
							  long utc2 = Date.UTC(secondDate.getFullYear(),secondDate.getMonth(), secondDate.getDate());

							  return Math.floor((utc2 - utc1) / DAY);*/
								//long diff1 = (long) Math.floor(diffInMillies / (1000 * 3600 * 24)); 

								/*	int diffDays = secondDate.diff(firstDate, days);*/
								//long diffInMillies = secondDate.getDate() - firstDate.getDate();

								long diffInMillies =Math.negateExact(secondDate.getTime()-firstDate.getTime());
								double diff1 = Math.ceil(diffInMillies / (1000 * 3600 * 24));
								///////////////



								//long diffInMillies =Math.abs (secondDate.getTime()-firstDate.getTime());
								//long diff1 = TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
								test.log(LogStatus.PASS, "Difference in Schedule Payment Days for PayFrequency ::"+PayFrequency+"is ::"+diff1);
								if (PayFrequency.equals("Bi-Weekly"))
								{

									test.log(LogStatus.PASS, "Date Difference for Bi-WeeklyShould be 14 day");

									test.log(LogStatus.PASS, "Difference in Schedule Payment Days for PayFrequency ::"+PayFrequency+"is ::"+diff1);
									//Long i = Long.parseLong(String)
									String a = Double.toString(diff1);
									//String a =  Long.toString(diff1);
									if (a.equals("14"))
									{
										test.log(LogStatus.PASS, "Date Difference for Bi-Weekly is as Expected");
									}
									else
									{
										test.log(LogStatus.PASS, "Date Difference for Bi-Weekly is not as Expected");
									}



								}
								if (PayFrequency.equals("Monthly"))
								{
									test.log(LogStatus.PASS, "Date Difference for Monthly Should be 30 day");
									test.log(LogStatus.PASS, "Difference in Schedule Payment Days for PayFrequency ::"+PayFrequency+"is ::"+diff1);
									String a = Double.toString(diff1);
									//String a =  Long.toString(diff1);
									if (a.equals("30"))
									{
										test.log(LogStatus.PASS, "Date Difference for Monthly is as Expected");
									}
									else
									{
										test.log(LogStatus.PASS, "Date Difference for Monthly is not as Expected");
									}

								}
								if (PayFrequency.equals("Semi-Monthly"))
								{

									test.log(LogStatus.PASS, "Date Difference for Semi-Monthly Should be 15 days");
									test.log(LogStatus.PASS, "Difference in Schedule Payment Days for PayFrequency ::"+PayFrequency+"is ::"+diff1);
									//String a =  Long.toString(long)
									if (diff1<=15)
									{
										test.log(LogStatus.PASS, "Date Difference for Semi-Monthly is as Expected");
									}
									else
									{
										test.log(LogStatus.PASS, "Date Difference for Semi-Monthly is not as Expected");
									}
								}
								if (PayFrequency.equals("Weekly"))
								{

									test.log(LogStatus.PASS, "Date Difference for Weekly Should be 14 days");
									test.log(LogStatus.PASS, "Difference in Schedule Payment Days for PayFrequency ::"+PayFrequency+"is ::"+diff1);
									//String a =  Long.toString(long)
									if (diff1<=14)
									{
										test.log(LogStatus.PASS, "Date Difference for Weekly is as Expected");
									}
									else
									{
										test.log(LogStatus.PASS, "Date Difference for Weekly is not as Expected");
									}
								}
							}

						}





					}

				}



			}
		}
	}
	 				}
