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

public class StatementGeneration extends AA_LOC {
	public static void StatementGeneration(String SSN,String FileName) throws Exception
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
	                        //String StoreID = TestData.getCellData(sheetName,"StoreID",row);
	                        //String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
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
	                                ///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]
	                               // driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
	                        	driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
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

	                        /* driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).click();
	                        }

	                         //String winHandleBefore = driver.getWindowHandle();
	                         for(String winHandle : driver.getWindowHandles()){
	                                    driver.switchTo().window(winHandle);
	                                }
	                         Thread.sleep(8000);
	                          // driver.findElement(By.xpath("//*[@id='home']")).click();*/

	                        //DueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[11]/td[2]/span[2]")).getText();
	                        DueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[11]/td[2]/span[2]")).getText();
	                        test.log(LogStatus.PASS, "Captured Statement Generation Date: "+DueDate);
	                        //DueDate=driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[4]/td[3]/span[2]")).getText();
	                        System.out.print(DueDate);
	                        driver.close();

	                        driver = new InternetExplorerDriver();
	                        driver.get(AdminURL);
	                        test.log(LogStatus.INFO, "Admin portal is launched");
	            			driver.manage().window().maximize();
	                        // storeupdate(UserName,Password,StoreID,DueDate,AdminURL);
	                        DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
	                        driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
	                        test.log(LogStatus.PASS, "Username is entered: admin");
	                        driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
	                        test.log(LogStatus.PASS, "Password is entered: "+Password);
	                        //Click Login Button
	                        driver.findElement(By.name("login")).click();
	                        test.log(LogStatus.PASS, "Clicked on Submit button");
	                        	Thread.sleep(8000);
	                        	Thread.sleep(8000);
	                        String DueDate0[] =DueDate.split("/");
	                        String DueDate1 = DueDate0[0];
	                        String DueDate2 = DueDate0[1];
	                        String DueDate3 = DueDate0[2];
	                        driver.switchTo().defaultContent();
	                        driver.switchTo().frame("topFrame");
	                        Thread.sleep(8000);
	                    	Thread.sleep(8000);
	                        WebDriverWait wait = new WebDriverWait(driver, 10000);
	   					    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));
	                        driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();
	                        test.log(LogStatus.PASS, "Clicked on Transactions");
	                        driver.switchTo().defaultContent();
	                        driver.switchTo().frame("mainFrame");
	                        Thread.sleep(5000);
	                        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("QA Jobs")));
	                        driver.findElement(By.linkText("QA Jobs")).click();
	                        test.log(LogStatus.PASS, "Clicked on QA Jobs");
	                        Thread.sleep(5000);
	                        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Process Date Change")));
	                        driver.findElement(By.linkText("Process Date Change")).click();
	                        test.log(LogStatus.PASS, "Clicked on Process Date Change");
	                        //Thread.sleep(2000);
	                       /* driver.switchTo().defaultContent();
	                        driver.switchTo().frame("mainFrame");
	                        driver.switchTo().frame("main");
	                        WebElement element = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[3]/div[6]/a/img"));
	                         Actions action = new Actions(driver);
	                         action.moveToElement(element).build().perform();*/
	                        Thread.sleep(6000);
	                        driver.switchTo().defaultContent();
	                        driver.switchTo().frame("mainFrame");
	                        driver.switchTo().frame("main");
	                        driver.findElement(By.name("storeCode")).click();
	                        //driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td")).click();
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
	                        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	                        Thread.sleep(1000);
	                        Thread.sleep(8000);
	                        test.log(LogStatus.PASS, "Clicked on submit button");
	                        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

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
	                        driver.findElement(By.linkText("LOC")).click();
	                        test.log(LogStatus.PASS, "Clicked on LOC");

	                        //driver.switchTo().defaultContent();
	                        //driver.switchTo().frame("mainFrame");
	                        Thread.sleep(5000);
	                        driver.findElement(By.linkText("Unsecure Loc Statement")).click();
	                        test.log(LogStatus.PASS, "Clicked on Unsecure Loc Statement");

	                        ///Thread.sleep(6000);  /html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img
	                        driver.switchTo().defaultContent();
	                        driver.switchTo().frame("mainFrame");
	                        driver.switchTo().frame("main");
	                        // /html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img
	                        WebElement elements = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/div[6]/a/img"));
	                        Actions actions = new Actions(driver);
	                        actions.moveToElement(elements).build().perform();

	                        Thread.sleep(6000);

	                        driver.findElement(By.name("requestBean.storeCode")).sendKeys(StoreId);
	                        test.log(LogStatus.PASS, "StoreID is entered: "+StoreId);


	                        driver.switchTo().defaultContent();
	                        driver.switchTo().frame("mainFrame");
	                        driver.switchTo().frame("main");

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
	                        driver.findElement(By.name("submit")).click();
	                        test.log(LogStatus.PASS, "Clicked on submit button");
	                        test.log(LogStatus.PASS, "Statement Generated");
	                }
	        }
	}

	 				}
