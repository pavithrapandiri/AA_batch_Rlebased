package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class CHECK_CCMO_Record_EODProcessing extends AA_PDL {

	public static void CHECK_CCMO_Record_EODProcessing(String SSN,String FileName) throws Exception{

		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_SmokeTest/"+FileName); 
		///Excel TestData = new Excel("E:/AA/TestData/"+FileName);
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
				//String StoreId = TestData.getCellData(sheetName,"StoreID",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				
				Login.Login(UserName, Password, StoreId);
				//Thread.sleep(2000);	    
				driver.switchTo().defaultContent();				
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Daily Processing')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Daily Processing");
				//Thread.sleep(1000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.name("eod")).click();
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				//driver.switchTo().frame("main");
				
				driver.findElement(By.name("requestBean.noOf100Dollars")).sendKeys("500");
				test.log(LogStatus.PASS,"Count of Dollar Coins is entered as 500");
				WebElement webElement = driver.findElement(By.name("requestBean.noOf100Dollars"));
				webElement.sendKeys(Keys.TAB);
			//	webElement.sendKeys(Keys.ENTER);
				//Thread.sleep(2000);
				WebElement element = driver.findElement(By.name("Submit2"));
				Actions actions = new Actions(driver);
				actions.moveToElement(element);
				actions.perform();
				driver.findElement(By.name("requestBean.comments")).sendKeys("comment");
				test.log(LogStatus.PASS,"Count of Dollar Coins is entered as comment");
				// requestBean.comments
				//Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.name("Submit2")).click();
				test.log(LogStatus.PASS,"Clicked on Balance Safe");
				Thread.sleep(2000);
				
				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					Thread.sleep(1000);
					driver.findElement(By.name("Submit2")).click();
					test.log(LogStatus.PASS,"Clicked on Balance Safe");
					//driver.findElement(By.name("Next")).click();
					//test.log(LogStatus.PASS,"Clicked on Next");

					Thread.sleep(1000);
					for(String winHandle : driver.getWindowHandles()){
						driver.switchTo().window(winHandle);
					}				    
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					//String SafeOverShortAmount = driver.findElement(By.name("diffCashBal")).getAttribute("value");
					String SafeOverShortAmount = driver.findElement(By.name("requestBean.safeOverShort")).getAttribute("value");
					driver.findElement(By.name("requestBean.amount")).sendKeys(SafeOverShortAmount);

					/// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[3]/td/table/tbody/tr[7]/td[3]

					// driver.findElement(By.name("requestBean.amount")).sendKeys("SafeOverShortAmount");
					test.log(LogStatus.PASS,"Enter the Balance 50");

					driver.findElement(By.name("requestBean.primary")).sendKeys("Deposit Issue");
					test.log(LogStatus.PASS, "Primary Reason is selected as Deposit Issue");
					driver.findElement(By.name("requestBean.notes")).sendKeys("Notes");
					test.log(LogStatus.PASS, "Notes Entered ");	
					driver.findElement(By.name("bt_AddDrawer")).click();
					test.log(LogStatus.PASS, "Click on Add O/S Instance Button");	
					//Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@type='button'][@value='Next']")).click();
					//if alert present, accept and move on.														

					try { 
						Alert alert1 = driver.switchTo().alert();
						alert1.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.

					}
				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.

				}
				
				//Thread.sleep(1000);
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				//Thread.sleep(2000);

				driver.findElement(By.name("Next"));
				// Next
				test.log(LogStatus.PASS, "Clicked on Next");
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}	
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td[2]/input[3]")).click();
				test.log(LogStatus.PASS, "Clicked on Next");
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}	
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				//*[@id="currentCCKBalancePdl"]/td/table
				
				
				
				try { 
					if(driver.findElement(By.xpath("//*[@id='currentCCKBalancePdl']/td/table")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Records Displayed in EOD Processing");	
					}
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.

				}
			}
		}
	}
	}	
	
	
	// //*[@id="currentCCKBalancePdl"]/td/table

