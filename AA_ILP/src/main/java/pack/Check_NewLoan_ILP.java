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
public class Check_NewLoan_ILP extends AA_CO_ILP{

	public static void Check_NewLoan_ILP(String SSN,String FileName) throws Exception{


		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/CO_ILP/"+FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		System.out.println("NewLoan "+lastrow);
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String State =TestData.getCellData(sheetName,"StateID",row);
				String ProductID=TestData.getCellData(sheetName,"ProductID",row);

				//String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				System.out.println(ProductID);
				//String UserName =TestData.getCellData(sheetName,"UserName",row);
				//String Password =TestData.getCellData(sheetName,"Password",row);
				String ProductType =TestData.getCellData(sheetName,"ProductType",row);
				String ProductName = TestData.getCellData(sheetName,"ProductName",row);
				//String Term = TestData.getCellData(sheetName,"Term",row);
				String VehicleType=TestData.getCellData(sheetName,"VehicleType",row);
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				//System.out.println(Term);
				//String StoreId =
				TestData.getCellData(sheetName,"StoreID",row);
				//String stateProduct=State+" "+ProductID;
				String stateProductType=State+" "+ProductType;
				String ESign_CollateralType =TestData.getCellData(sheetName,"ESign_CollateralType",row);
				System.out.println(ESign_CollateralType);
				String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
				 String ChkgAcctNbr=SSN.substring(3, 9);
				//String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
				String ESign_CourtesyCallConsent =TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String AllowPromotion =TestData.getCellData(sheetName,"Allow Promotion",row);
				String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
				String ESign_Preference =TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_Checks =TestData.getCellData(sheetName,"ESign_Checks",row);
				String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
				 String ESign_CheckNbr=SSN.substring(3, 9);

				//String ESign_CheckNbr =TestData.getCellData(sheetName,"ESign_CheckNbr",row);
				String last4cheknum=ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String Parent_Window = driver.getWindowHandle();
				System.out.println(last4cheknum);
				System.out.println(stateProductType);
				 String Parent_Window1 = driver.getWindowHandle();  
					System.out.println(ProductID);	
					//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					//appUrl = AppURL;
					Login.Login(UserName, Password, StoreId);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					Thread.sleep(5000);
					Thread.sleep(5000);
					driver.switchTo().frame("topFrame");
			
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					//*[@id="911100"]/a
					driver.findElement(By.cssSelector("li[id='911100']")).click();			
					test.log(LogStatus.PASS, "Clicked on New Loan");			
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



				test.log(LogStatus.INFO, "Navigated to Loan decisioning Screen");
			
				//    Selection of Product based on the Name provided in
				//Test Data
				// if(driver.findElement(By.id("LoanButtonId")).isEnabled())
			if(driver.findElement(By.xpath("//*[@id='errMsg']/ul/li")).getText().contains("Active"))
			{
				test.log(LogStatus.PASS, "Loan is unable to process");
			}
			}
		}

	}
	
	
	
	
	
	
	
}
