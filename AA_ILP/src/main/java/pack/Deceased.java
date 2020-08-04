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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Deceased extends AA_CO_ILP{

	public static void Deceased(String SSN,String FileName) throws Exception
	{
	//Excel TestData = new
	//Excel(System.getProperty("user.dir")+"/TestData/CO_ILP/"+FileName);
	int lastrow=TestData.getLastRow("NewLoan");
	System.out.println("NewLoan "+lastrow);
	String sheetName="NewLoan";
	for(int row=2;row<=lastrow;row++)
	{
	    String RegSSN = TestData.getCellData(sheetName,"SSN",row);
	    if(SSN.equals(RegSSN))
	    {
	        String TxnType=TestData.getCellData(sheetName,"TxnType",row);
	        String TenderType =
	TestData.getCellData(sheetName,"TenderType",row);
	        String
	ProductID=TestData.getCellData(sheetName,"ProductID",row);
	       // String UserName =
	TestData.getCellData(sheetName,"UserName",row);
	       // String Password =
	TestData.getCellData(sheetName,"Password",row);
	        //String StoreID = TestData.getCellData(sheetName,"StoreID",row);
	        //String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
	        String
	BNKstatus=TestData.getCellData(sheetName,"BNKstatus",row);
	        String AttorneyPhone =
	TestData.getCellData(sheetName,"AttorneyPhone",row);
	        String AttorneyP1 = AttorneyPhone.substring(0, 3);
	        String AttorneyP2 = AttorneyPhone.substring(3, 6);
	        String AttorneyP3 = AttorneyPhone.substring(6, 10);
	        String SSN1 = SSN.substring(0, 3);
	        String SSN2 = SSN.substring(3,5);
	        String SSN3 = SSN.substring(5,9);
	        System.out.println(AdminURL);
	        ///////////////////////////////////////
	        Login.Login(UserName, Password, StoreId);

	        Thread.sleep(5000);
	        Thread.sleep(1000);
	        driver.switchTo().frame("topFrame");
	        driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();
	        test.log(LogStatus.PASS, "Clicked on Loan Transactions");
	        driver.manage().timeouts().implicitlyWait(120,
	TimeUnit.SECONDS);
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
	        driver.findElement(By.xpath("//input[@value='Go' and @name='button']")).click();

	        // driver.findElement(By.name("button")).click();
	        test.log(LogStatus.PASS, "Click on GO Button");
	        for(String winHandle : driver.getWindowHandles()){
	            driver.switchTo().window(winHandle);
	        }
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame("mainFrame");
	        driver.switchTo().frame("main");
	 


	            driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

	        test.log(LogStatus.PASS, "Click on GO Button");
	        for( String winHandle1 : driver.getWindowHandles())
	        {
	            driver.switchTo().window(winHandle1);
	        }
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame("mainFrame");
	        driver.switchTo().frame("main");
	driver.findElement(By.name("transactionList")).sendKeys("History");


	            driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
	            //driver.findElement(By.id("go_Button")).click();


	        for( String winHandle1 : driver.getWindowHandles())
	        {
	            driver.switchTo().window(winHandle1);
	        }
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame("mainFrame");
	        driver.switchTo().frame("main");
	        String DueDate=null;

	/*    //    DueDate =
	driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();

	         DueDate =
	driver.findElement(By.xpath("//*[@id='ContractScheduleTable']/tbody/tr[2]/td[2]")).getText();*/
			DueDate = driver.findElement(By.xpath("//*[@id='ContractScheduleTable']/tbody/tr[4]/td[2]")).getText();
		//	DueDate = driver.findElement(By.xpath("//*[@id='ContractScheduleTable']/tbody/tr[4]/td[2]")).getText();

	//*[@id="revolvingCreditHistTable"]/tbody/tr[4]/td[3]/span[2]
	        test.log(LogStatus.PASS, "Capture DueDate"+DueDate);
	        System.out.print(DueDate);
	        driver.close();

	        driver = new InternetExplorerDriver();
	        driver.get(AdminURL);
	        test.log(LogStatus.INFO, "Admin portal is launched");


	        DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
	        String DDueDate[] =DueDate.split("/");


	        Date DDueDateminus1 = df.parse(DueDate);

	        Calendar cal = Calendar.getInstance();

	        cal.setTime(DDueDateminus1);

	        cal.add(Calendar.DATE, -2);

	        Date DDueDate1= cal.getTime();

	        DueDate =df.format(DDueDate1);

	        String DueDate0[] =DueDate.split("/");

	        String DueDate1 = DueDate0[0];

	        String DueDate2 = DueDate0[1];

	        String DueDate3 = DueDate0[2];


	        ////////////////////////////////////
	        driver.get(AdminURL);
	        test.log(LogStatus.INFO, "Admin portal is launched");
	        driver.manage().window().maximize();
	         Thread.sleep(1000);



	driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
	test.log(LogStatus.PASS, "Username is entered: "+UserName);
	driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
	test.log(LogStatus.PASS, "Password is entered: "+Password);
	//Click Login Button
	driver.findElement(By.name("login")).click();
	test.log(LogStatus.PASS, "Clicked on Submit button");
	Thread.sleep(10000);
	Thread.sleep(8000);
	driver.switchTo().frame("topFrame");
	WebDriverWait wait = new WebDriverWait(driver, 10000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));

	driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();
	test.log(LogStatus.PASS, "Clicked on Transactions");
	Thread.sleep(10000);
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("mainFrame");
	Thread.sleep(10000);
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Borrower")));
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 driver.findElement(By.linkText("Borrower")).click();
	 test.log(LogStatus.PASS, "Clicked on Borrower");

	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Bankrupt/Deceased Suite")));
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 driver.findElement(By.linkText("Bankrupt/Deceased Suite")).click();
	test.log(LogStatus.PASS, "Clicked on Bankrupt/Deceased Suite");

	  for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	        }


	       driver.switchTo().defaultContent();
	        driver.switchTo().frame("mainFrame");
	        driver.switchTo().frame("main");
	        driver.findElement(By.name("ssn1")).sendKeys(SSN1);
	        test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
	        driver.findElement(By.name("ssn2")).sendKeys(SSN2);
	        test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
	        driver.findElement(By.name("ssn3")).sendKeys(SSN3);
	        test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
	        Thread.sleep(5000);
	        Actions action = new Actions(driver);
	        action.moveByOffset(200,100).perform();
	        Thread.sleep(10000);
	        action.click();
	        Thread.sleep(5000);

	        //name="submit"
	        driver.findElement(By.name("submit")).click();
	        test.log(LogStatus.PASS, "Click on submit Button");



	     driver.switchTo().defaultContent();
	     driver.switchTo().frame("mainFrame");
	     driver.switchTo().frame("main");


	//driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[9]/input")).click();
	driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

	     test.log(LogStatus.PASS,"Click on Go button");

	     driver.switchTo().defaultContent();
	     driver.switchTo().frame("mainFrame");
	     driver.switchTo().frame("main");
	     Thread.sleep(3000);
	     if( driver.findElement(By.name("loanCode")).isDisplayed())
	     {
	     driver.findElement(By.name("loanCode")).click();
	     test.log(LogStatus.PASS, "Selecting Check box for loan");
	     }
	driver.findElement(By.name("requestBean.bnkStatus")).sendKeys("Deceased");
	     test.log(LogStatus.PASS, "select status as :: Deceased");

	driver.findElement(By.name("bankruptcyFilingDate1")).sendKeys(DueDate1.trim());
	        test.log(LogStatus.PASS, "Bankrupt Filing Month is:: "+DueDate1);
	        Thread.sleep(500);
	driver.findElement(By.name("bankruptcyFilingDate2")).sendKeys(DueDate2.trim());

	        test.log(LogStatus.PASS, "Bankrupt Filing Day is:: "+DueDate2);
	        Thread.sleep(500);
	driver.findElement(By.name("bankruptcyFilingDate3")).sendKeys(DueDate3.trim());

	        test.log(LogStatus.PASS, "Bankrupt Filing Year is:: "+DueDate3);

	driver.findElement(By.name("bkrCaseNbr")).sendKeys(SSN3);
	         test.log(LogStatus.PASS, "Bankrupt case Number is ::"+SSN3);

	driver.findElement(By.name("requestBean.typeOfBankruptcy")).sendKeys("chapter7");
	         test.log(LogStatus.PASS, "Bankrupt type is ::Chapter7");


	driver.findElement(By.name("attorneyName")).sendKeys("Attorny");
	     test.log(LogStatus.PASS, "Entered Attorny Name");


	driver.findElement(By.name("debtorAttorneyPhone1")).sendKeys(AttorneyP1.trim());
	        test.log(LogStatus.PASS, "PP1 is entered: "+AttorneyP1);
	        Thread.sleep(500);
	driver.findElement(By.name("debtorAttorneyPhone2")).sendKeys(AttorneyP2.trim());

	        test.log(LogStatus.PASS, "PP2 is entered: "+AttorneyP2);
	        Thread.sleep(500);
	driver.findElement(By.name("debtorAttorneyPhone3")).sendKeys(AttorneyP3.trim());

	        test.log(LogStatus.PASS, "PP3 is entered: "+AttorneyP3);
	        driver.findElement(By.name("ubnkDate1")).sendKeys(DueDate1.trim());			
			test.log(LogStatus.PASS, "Dismissed Filing Month is:: "+DueDate1);			
			Thread.sleep(500);		    
			driver.findElement(By.name("ubnkDate2")).sendKeys(DueDate2.trim());			
			test.log(LogStatus.PASS, "Dismissed Filing Day is:: "+DueDate2);			
			Thread.sleep(500);			
			driver.findElement(By.name("ubnkDate3")).sendKeys(DueDate3.trim());			
			test.log(LogStatus.PASS, "Dismissed Filing Year is:: "+DueDate3);	

	driver.findElement(By.name("bt_AddBankruptcy")).click();
	         test.log(LogStatus.PASS, "Status Deceased is Saved");

	         Thread.sleep(50000);
	    ///html/body/form/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td[9]/table/tbody/tr[2]/td
	       /*  if(driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td[9]/table/tbody/tr[2]/td")).isDisplayed())
	         {
	         test.log(LogStatus.PASS,"<FONT color=green style=Arial> Customer got Deceased");
	         }
	      */  /*    driver.close();

	            driver = new InternetExplorerDriver();*/

	        }

	    }


	/*
	if(driver.findElement(By.name("submitButton")).isDisplayed())
	        {
	         test.log(LogStatus.PASS, "Store Aging is Successfully ");
	driver.findElement(By.name("submitButton")).click();
	        }
	     else
	        {
	            test.log(LogStatus.FAIL, "Store Aging is not Successfully ");
	        }*/
	    //driver.close();
	}	
	
	
	
	
	
	
	
}
