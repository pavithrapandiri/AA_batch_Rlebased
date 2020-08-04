package pack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class Drawerassign extends AA_CO_ILP{

	
	public static void Drawerassign(String SSN, String FileName) throws Exception {

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

					Thread.sleep(2000);

					
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
					//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.linkText("Drawer")).click();
					test.log(LogStatus.PASS, "Clicked on Drawer");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.linkText("Assign")).click();
					test.log(LogStatus.PASS, "Clicked on Assign");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.name("drawerAssignRequestBean.noOf100Dollars")).sendKeys("500");
					test.log(LogStatus.PASS,"Count of Dollar Coins is entered as 500");

					driver.findElement(By.name("drawerAssignRequestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Passwored is Entered");
					driver.findElement(By.name("drawerassign")).click();
					test.log(LogStatus.PASS, "Clicked on Drawer Assigen Button");
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();

					}
					catch (NoAlertPresentException e) {

					}

					Thread.sleep(2000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(AA_MO_ILP_Smoke.Field(driver) != null )
					{                    		                   
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElement(By.linkText("Safe")).click();
						test.log(LogStatus.PASS, "Clicked on Safe");
						driver.findElement(By.linkText("Deassign")).click();
						test.log(LogStatus.PASS, "Clicked on Deassign");
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");                            
						driver.switchTo().frame("main");
						driver.findElement(By.name("safeDeassignRequestBean.noOfDollars")).sendKeys("0");
						test.log(LogStatus.PASS, "Enter the Value 0");


						driver.findElement(By.name("safeDeassignRequestBean.password")).sendKeys(Password);
						test.log(LogStatus.PASS, "Enter the Password");

						driver.findElement(By.name("safedeassign")).click();
						test.log(LogStatus.PASS, "Click on the Safe Deassign Button");

						try { 
							Alert alert = driver.switchTo().alert();
							alert.accept();

						}
						catch (NoAlertPresentException e) {

						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						if(driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).isDisplayed())
						{
							test.log(LogStatus.PASS,"Safe De-assigned successfully with over/short.");
							driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).click();
						}
						else
						{
							driver.findElement(By.name("safeDeassignRequestBean.password")).sendKeys(Password);
							test.log(LogStatus.PASS, "Enter the Password");
							driver.findElement(By.name("safedeassign")).click();
							test.log(LogStatus.PASS, "Click on the Deassign");
							for(String winHandle : driver.getWindowHandles()){
								driver.switchTo().window(winHandle);
							}				    
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							String DrawerOverShortAmount =driver.findElement(By.name("safeRequestBean.safeOverShort")).getAttribute("value");
							driver.findElement(By.name("safeRequestBean.amount")).sendKeys(DrawerOverShortAmount);
							test.log(LogStatus.PASS, "Amount entered as "+DrawerOverShortAmount);
							driver.findElement(By.name("safeRequestBean.primary")).sendKeys("Counterfeit Bill");
							test.log(LogStatus.PASS, "Primary Reason is selected as Counterfeit Bill");
							driver.findElement(By.name("safeRequestBean.notes")).sendKeys("Notes");
							test.log(LogStatus.PASS, "Notes Entered ");	
							driver.findElement(By.name("bt_AddDrawer")).click();
							test.log(LogStatus.PASS, "Click on Add O/S Instance Button");	
							Thread.sleep(2000);
							driver.findElement(By.name("transactionDataBean.password")).sendKeys(Password);
							driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[4]/tbody/tr[3]/td[1]/input")).click();

							test.log(LogStatus.PASS, "Click on Finish Safe O/S");
							try { 
								Alert alert = driver.switchTo().alert();
								alert.accept();

							}
							catch (NoAlertPresentException e) {
							}
							Thread.sleep(2000);
							for(String winHandle : driver.getWindowHandles()){
								driver.switchTo().window(winHandle);
							}				    
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");

							if(driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).isDisplayed())
							{

								test.log(LogStatus.PASS,"Safe De-assigned successfully with over/short.");
								driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).click();
							}
							else
							{
								test.log(LogStatus.PASS,"Safe not De-assigned successfully with over/short.");
							}                            
						}
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElement(By.linkText("Safe")).click();
						test.log(LogStatus.PASS, "Clicked on Assign");
						driver.findElement(By.linkText("Assign")).click();
						test.log(LogStatus.PASS, "Clicked on Assign");
						Thread.sleep(2000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.name("safeAssignRequestBean.empPwd")).sendKeys("1234");
						test.log(LogStatus.PASS,"Passwored is Entered");

						driver.findElement(By.name("safeAssignRequestBean.noOf100Dollars")).sendKeys("500");
						test.log(LogStatus.PASS,"Count of Dollar Coins is entered as 500");


						driver.findElement(By.name("safeassign")).click();
						test.log(LogStatus.PASS,"Click on Safe Assigen");
						
						Robot rb =new Robot();
						rb.keyPress(KeyEvent.VK_ENTER);

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

						if(driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).isDisplayed())
						{

							test.log(LogStatus.PASS,"Safe assigned successfully.");
							driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).click();
						}
						else
						{
							test.log(LogStatus.PASS,"Safe not assigned successfully.");
						}

						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElement(By.linkText("Drawer")).click();
						test.log(LogStatus.PASS, "Clicked on Drawer");
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.findElement(By.linkText("Assign")).click();
						test.log(LogStatus.PASS, "Clicked on Assign");

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.name("drawerAssignRequestBean.noOf100Dollars")).sendKeys("500");
						test.log(LogStatus.PASS,"Count of Dollar Coins is entered as 500");

						driver.findElement(By.name("drawerAssignRequestBean.password")).sendKeys(Password);
						test.log(LogStatus.PASS,"Passwored is Entered");
						driver.findElement(By.name("drawerassign")).click();
						test.log(LogStatus.PASS,"Click on drawer Assigen Button");
						
						Robot rb1 =new Robot();
						rb1.keyPress(KeyEvent.VK_ENTER);
						try {
							Alert alert = driver.switchTo().alert();
							alert.accept();

						}
						catch (NoAlertPresentException e) {

						}
						Thread.sleep(2000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).isDisplayed())
						{

							test.log(LogStatus.PASS,"Drawer De-assigned successfully with over/short.");
							driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).click();
						}
						else
						{
							test.log(LogStatus.PASS,"Drawer not De-assigned successfully with over/short.");
						}

					}                                        
					else
					{                    	
						if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).isDisplayed())
						{

							test.log(LogStatus.PASS,"Drawer Assigned successfully with over/short.");
							//driver.findElement(By.name("done")).click();
							driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).click();
						}
						else
						{
							test.log(LogStatus.PASS,"Drawer not Assigned successfully with over/short.");
						}
					}

				}
			}
		}


		}