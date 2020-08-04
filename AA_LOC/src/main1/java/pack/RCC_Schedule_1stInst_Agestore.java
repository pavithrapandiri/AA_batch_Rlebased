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

public class RCC_Schedule_1stInst_Agestore extends AA_LOC {
	public static void RCC_Schedule_1stInst_Agestore(String SSN,String FileName,int Days,int i) throws Exception
	{

		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/LOC/"+FileName);	
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
				////String StoreId = TestData.getCellData(sheetName,"StoreId",row);
				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);

				String Parent_Window = driver.getWindowHandle();  
				System.out.println(AdminURL);
				test.log(LogStatus.INFO, "RCC_Schedule_1stInst_Agestore");

				System.out.println(ProductID);	
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				
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
					driver.findElement(By.name("button")).click(); 
				}

				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");


				//	/html/body/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[8]/input
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
							dt =	driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+i+"]/td[3]")).getText();
							test.log(LogStatus.PASS, "date is"+dt);
							System.out.println(dt);


							driver.close();
							driver.quit();

							driver = new InternetExplorerDriver();
							driver.get(AdminURL);
							test.log(LogStatus.PASS, "date in outside loop"+dt);




							String DDe[] =dt.split(" ");

							DateFormat  df=new SimpleDateFormat("yyyy-mm-dd");	


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



							driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
							test.log(LogStatus.PASS, "Username is entered: admin");			        
							driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
							test.log(LogStatus.PASS, "Password is entered: "+Password);					  	        			   
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
							driver.findElement(By.linkText("QA Jobs")).click();
							test.log(LogStatus.PASS, "Clicked on QA Jobs");
							Thread.sleep(5000);
							driver.findElement(By.linkText("Process Date Change")).click();
							test.log(LogStatus.PASS, "Clicked on Process Date Change");
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							WebElement elements1 = driver.findElement(By.linkText("QA Jobs"));
							Actions actions1 = new Actions(driver);								        
							actions1.moveToElement(elements1).build().perform();
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");

							driver.findElement(By.name("storeCode")).click();
							driver.findElement(By.name("storeCode")).sendKeys(StoreId);
							test.log(LogStatus.PASS, "Store number is entered: "+StoreId);
							Thread.sleep(5000);
							driver.findElement(By.name("beginMonth")).clear();
							driver.findElement(By.name("beginMonth")).sendKeys(DueDate1); 
							test.log(LogStatus.PASS, "beginMonth is entered: "+DueDate1);
							driver.findElement(By.name("beginDay")).clear();
							driver.findElement(By.name("beginDay")).sendKeys(DueDate2);
							test.log(LogStatus.PASS, "beginDay is entered: "+DueDate2);
							driver.findElement(By.name("beginYear")).clear();
							driver.findElement(By.name("beginYear")).sendKeys(DueDate3);
							test.log(LogStatus.PASS, "beginYear is entered: "+DueDate3);
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							Thread.sleep(1000);
							Thread.sleep(5000);
							driver.findElement(By.name("btnPreview")).click();
							test.log(LogStatus.PASS, "Clicked on submit button");
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							if( driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input")).isDisplayed())
							{									        								
								test.log(LogStatus.PASS, "Process Date updated successfully");
								driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input")).click();
							}
							else
							{
								test.log(LogStatus.FAIL, "Process Date not updated successfully.");
							}

						}





					}

				}



			}
		}
	}


	 				}
