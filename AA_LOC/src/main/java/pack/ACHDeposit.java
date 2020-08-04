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

public class ACHDeposit extends AA_LOC {
	public static void ACHDeposit(String SSN,String FileName) throws Exception
	{
		test.log(LogStatus.INFO, "ACH Deposit");
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LOC_Regression/"+FileName);	
		int lastrow=TestData.getLastRow("NewLoan");
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
				//String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
				test.log(LogStatus.INFO, "Scheduler-Store Aging");
								
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				 //  appUrl = AppURL;
				Login.Login(UserName,Password,StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
				    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
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
						 String DueDate=null;
						DueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[4]/td[3]/span[2]")).getText();
						test.log(LogStatus.PASS, "Due Date is Captured:"+DueDate);	
					
				    driver.close();
				    
				         driver = new InternetExplorerDriver();
				         driver.manage().window().maximize();
				         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				         driver.get(AdminURL);
				         test.log(LogStatus.INFO, "Admin portal is launched");
							driver.manage().window().maximize();
					    DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");		
					   driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
				        test.log(LogStatus.PASS, "Username is entered: admin");			        
				        driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
				        test.log(LogStatus.PASS, "Password is entered: "+Password);					  	        			   
				        //Click Login Button
				        driver.findElement(By.name("login")).click();
				        test.log(LogStatus.PASS, "Clicked on Submit button");
				        driver.switchTo().defaultContent();
						 driver.switchTo().frame("topFrame");
						 WebDriverWait wait = new WebDriverWait(driver, 30);
						 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));
					     driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();	
						 test.log(LogStatus.PASS, "Clicked on Transactions");
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 driver.findElement(By.linkText("ACH")).click();
						 test.log(LogStatus.PASS, "Clicked on ACH");
						driver.findElement(By.linkText("Green Bank")).click();
						 test.log(LogStatus.PASS, "Clicked on Green Bank");
						 driver.findElement(By.linkText("Green Bank NACHA File")).click();
						 test.log(LogStatus.PASS, "Clicked on Green Bank NACHA File");
						
						 driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							WebElement elements1 = driver.findElement(By.linkText("QA Jobs"));
							Actions actions1 = new Actions(driver);								        
							actions1.moveToElement(elements1).build().perform();
							Thread.sleep(1000);
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
						 
						  driver.switchTo().defaultContent();
						    driver.switchTo().frame("mainFrame");
						    driver.switchTo().frame("main");
						    Date DDueDate = df.parse(DueDate);
						    Calendar cal = Calendar.getInstance();
							 cal.setTime(DDueDate);
							cal.add(Calendar.DATE,-1);
						      Date DDueDateminus1= cal.getTime();
							 						 
							String DueDateminus1 =df.format(DDueDateminus1);
						    String DDueDate0[] =DueDateminus1.split("/");
						     String DDueDate1 = DDueDate0[0];
					        String DDueDate2 = DDueDate0[1];
					        String DDueDate3 = DDueDate0[2];
					        Thread.sleep(2000);
					         driver.findElement(By.name("beginMonth")).click();
						    driver.findElement(By.name("beginMonth")).clear();
					        driver.findElement(By.name("beginMonth")).sendKeys(DDueDate1); 
					        test.log(LogStatus.PASS, "beginMonth is entered: "+DDueDate1);
					        driver.findElement(By.name("beginDay")).clear();
					        driver.findElement(By.name("beginDay")).sendKeys(DDueDate2);
					        test.log(LogStatus.PASS, "beginDay is entered: "+DDueDate2);
					        driver.findElement(By.name("beginYear")).clear();
					        driver.findElement(By.name("beginYear")).sendKeys(DDueDate3);
					        test.log(LogStatus.PASS, "beginYear is entered: "+DDueDate3);
					       driver.findElement(By.name("btnPreview")).click();
					        test.log(LogStatus.PASS, "Clicked on submit button");
					        
					        if( driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/input")).isDisplayed())
					        {									        								
					        	test.log(LogStatus.PASS, "Green Bank updated successfully");
					        }
					        else
					        {
					        	test.log(LogStatus.FAIL, "Green Bank Not updated successfully.");
					        }  
					        
					       			        
					    String DueDate0[] =DueDate.split("/");
						 
				        String DueDate1 = DueDate0[0];
				        String DueDate2 = DueDate0[1];
				        String DueDate3 = DueDate0[2];
				        
				        driver.switchTo().defaultContent();
						 driver.switchTo().frame("topFrame");
							driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();	
							test.log(LogStatus.PASS, "Clicked on Transactions");
				        
				     
				             driver.switchTo().defaultContent();
						      driver.switchTo().frame("mainFrame");
								driver.findElement(By.linkText("QA Jobs")).click();
								test.log(LogStatus.PASS, "Clicked on QA Jobs");
						   driver.findElement(By.linkText("Process Date Change")).click();
							test.log(LogStatus.PASS, "Clicked on Process Date Change");
							
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");

							WebElement elements2 = driver.findElement(By.linkText("QA Jobs"));

							Actions actions2 = new Actions(driver);

							actions1.moveToElement(elements1).build().perform();

							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
							
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(By.name("storeCode")).click();
							 driver.findElement(By.name("storeCode")).sendKeys(StoreId);
							 test.log(LogStatus.PASS, "Store number is entered: "+StoreId);
							 Thread.sleep(2000);
							 driver.findElement(By.name("beginMonth")).clear();
						        driver.findElement(By.name("beginMonth")).sendKeys(DueDate1); 
						        test.log(LogStatus.PASS, "beginMonth is entered: "+DueDate1);
						        driver.findElement(By.name("beginDay")).clear();
						        driver.findElement(By.name("beginDay")).sendKeys(DueDate2);
						        test.log(LogStatus.PASS, "beginDay is entered: "+DueDate2);
						        driver.findElement(By.name("beginYear")).clear();
						        driver.findElement(By.name("beginYear")).sendKeys(DueDate3);
						        test.log(LogStatus.PASS, "beginYear is entered: "+DueDate3);
						        driver.findElement(By.name("btnPreview")).click();
						        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						       test.log(LogStatus.PASS, "Clicked on submit button");
						        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						        
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
						        	test.log(LogStatus.FAIL, "Process Date updated successfully.");
						        } 
	        
				                    
					//PreACHDeposit 
						        
						        driver.switchTo().defaultContent();
								 driver.switchTo().frame("topFrame");
									driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();	
									test.log(LogStatus.PASS, "Clicked on Transactions"); 
									
									driver.switchTo().defaultContent();
									driver.switchTo().frame("mainFrame");
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								 driver.findElement(By.linkText("ACH")).click();
								 test.log(LogStatus.PASS, "Clicked on ACH");
						 
						 
						 driver.findElement(By.linkText("LOC")).click();
						 test.log(LogStatus.PASS, "Clicked on LOC");
						 
						 driver.findElement(By.linkText("LOC Pre ACH Deposit")).click();
						 test.log(LogStatus.PASS, "Clicked on Loc pre ACH Deposit");
						 
						 
						 
						 
					    	 driver.switchTo().defaultContent();
						    driver.switchTo().frame("mainFrame");
						    driver.switchTo().frame("main");
						  
						   Thread.sleep(2000);
					        driver.findElement(By.name("beginMonth")).click();
						    driver.findElement(By.name("beginMonth")).clear();
					        driver.findElement(By.name("beginMonth")).sendKeys(DueDate1); 
					        test.log(LogStatus.PASS, "beginMonth is entered: "+DueDate1);
					        driver.findElement(By.name("beginDay")).clear();
					        driver.findElement(By.name("beginDay")).sendKeys(DueDate2);
					        test.log(LogStatus.PASS, "beginDay is entered: "+DueDate2);
					        driver.findElement(By.name("beginYear")).clear();
					        driver.findElement(By.name("beginYear")).sendKeys(DueDate3);
					        test.log(LogStatus.PASS, "beginYear is entered: "+DueDate3);
					        driver.findElement(By.name("btnPreview")).click();
					        test.log(LogStatus.PASS, "Clicked on submit button");
					        test.log(LogStatus.PASS, "Completed ACH Deposit");
					        
					        
			}
		}
	}

	
	 				}
