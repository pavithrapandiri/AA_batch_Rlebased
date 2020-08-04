package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class MidDayDeposit extends AA_PDL
{
	public static void MidDayDeposit(String SSN,String FileName) throws Exception{

		////Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL/"+FileName);
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);
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
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				//String UserName = TestData.getCellData(sheetName,"UserName",row);
				//String Password = TestData.getCellData(sheetName,"Password",row);
				//String StoreId = TestData.getCellData(sheetName,"StoreId",row);
				
				Login.Login(UserName, Password, StoreId);
				Thread.sleep(2000);
				driver.switchTo().defaultContent();				
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Cash Management");
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Safe")).click();
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Clicked on Assign");	
				driver.findElement(By.linkText("Deposit")).click();
				test.log(LogStatus.PASS, "Clicked on Deposit");
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
			

				driver.findElement(By.name("safeDepositRequestBean.noOf100Dollars")).sendKeys("0");
				test.log(LogStatus.PASS, "safeAssignRequestBean.noOf100Dollars 0");
				// safeDepositRequestBean.ccMoSlipNbr
				// safeDepositRequestBean.ccMoSlipNbr
				//  //*[@id="pdlPaymentChecks"]
				//  //*[@id="pdlPaymentChecks"]
				//driver.findElement(By.xpath("(//input[@id='pdlPaymentChecks'])[0]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//tr[@class='trodd']/td[6]/input[@name='safeDepositRequestBean.ccMoSlipNbr']")).click();
				driver.findElement(By.xpath("//tr[@class='treven']/td[6]/input[@name='safeDepositRequestBean.ccMoSlipNbr']")).click();

				                              
				//driver.findElement(By.xpath("(//input[@id='pdlPaymentChecks'])[1]")).click();
				//driver.findElement(By.xpath("//input[@value='2603128~100~CCK~Alan , Karri ~Wells Fargo Bank~4100~15026512~CCK~1000409020~1758422~PDL' and @type='checkbox']")).click();
				//driver.findElement(By.xpath("//input[@value='2603129~282.35~CCK~Alan , Karri ~Wells Fargo Bank~1444~15026512~CCK~1000409020~1758422~PDL' and @type='checkbox']")).click();
				test.log(LogStatus.PASS, "Cashiers Check CheckBox1 selected");
				test.log(LogStatus.PASS, "Cashiers Check CheckBox2 selected");
				driver.findElement(By.name("safeDepositRequestBean.bagNbr")).sendKeys("34");
				test.log(LogStatus.PASS, "Bag Number is entered as ::34");
				driver.findElement(By.name("safeDepositRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "Password is Entered ");
				driver.findElement(By.name("finishdeposit")).click();
				test.log(LogStatus.PASS, "Clicked on Finish Deposit Button");
				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();

				}
				catch (NoAlertPresentException e) {

				}
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				Thread.sleep(2000);
				driver.findElement(By.name("finishdeposit")).click();
				test.log(LogStatus.PASS, "Clicked on Finish MidDay Deposit Button Button");
				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();

				}
				catch (NoAlertPresentException e) {

				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@value='Ok' and @type='submit']")).click();
				
				// finishdeposit
			}
		}
	}
}
