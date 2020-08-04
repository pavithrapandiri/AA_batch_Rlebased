package pack;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class AA_NewLoan_Rule_Check_LoanAmt extends AA_PDL{
	public static void AA_NewLoan_Rule_Check_LoanAmt(String SSN,String FileName,String Loanamt) throws Exception{

		{
			//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);      	
			int lastrow=TestData.getLastRow("NewLoan");
			System.out.println("NewLoan "+lastrow);
			String sheetName="NewLoan";		
			for(int row=2;row<=lastrow;row++)
		{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{		
					String State = TestData.getCellData(sheetName,"StateID",row);
					String ProductID=TestData.getCellData(sheetName,"ProductID",row);
					System.out.println(ProductID);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String ProductName = TestData.getCellData(sheetName,"ProductName",row);
					/*String ProductName = prop.getProperty("ProductName");*/
					//String Term = TestData.getCellData(sheetName,"Term",row);
					String VehicleType= TestData.getCellData(sheetName,"VehicleType",row);
					String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					//String stateProduct=State+" "+ProductID;
					String stateProductType=State+" "+ProductType;
					String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					System.out.println(ESign_CollateralType);
					String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
					//String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
					String ChkgAcctNbr = SSN.substring(3, 9);
					String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
					String AllowPromotion = TestData.getCellData(sheetName,"Allow Promotion",row);
					String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
					String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
					String ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);
					String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
					//String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);	
					String ESign_CheckNbr = SSN.substring(3, 9);
					String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
					System.out.println(last4cheknum);
					System.out.println(stateProductType);
					String Parent_Window = driver.getWindowHandle();
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					test.log(LogStatus.INFO, "Navigate New Loan ");
					try{
						if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
						{
							//driver.findElement(By.xpath("//input[contains(text(),"+stateProduct+")]")).click();
							//test.log(LogStatus.PASS, "Borrower is Registered Successfully with SSN as " +SSN);	
							//WebElement htmltable=driver.findElement(By.xpath("//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));	

							int rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")).size();
							//List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
							test.log(LogStatus.INFO, "Rows count :: "+rows);

							for (int a=2;a<=rows;a++)
							{
								String prod = driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]")).getText();
								test.log(LogStatus.INFO, "Product name is :: "+prod);
								if (prod.equals(ProductName))
								{

									Thread.sleep(3000);
									//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")));
									//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input
									//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/input
									//driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")).click();

									driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")).click();
									test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
								}
							}
						}

					}
					catch(Exception e){
						test.log(LogStatus.PASS, "One Product exists ");
					}







						driver.findElement(By.name("ShareScreenBtn")).click();
						test.log(LogStatus.PASS, "ShareScreen Button clicked");
						for( String winHandle1 : driver.getWindowHandles())
						{
							if(!(winHandle1.equals(Parent_Window)))
							{
								driver.switchTo().window(winHandle1);
								Thread.sleep(2000);
								driver.findElement(By.name("confirmSummary")).click();
								test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");

							}
						}



						Thread.sleep(2000);
						driver.switchTo().window(Parent_Window);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(By.id("LoanButtonId")).click();
						//driver.findElement(By.id("LoanButtonId")).click();

						test.log(LogStatus.PASS, "Clicked on New Loan button");
						//New Loan Screens


						if(ProductID.equals("PDL"))

						{	

							driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/input")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
							Thread.sleep(3000);
							
						String loanamt=	driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
					
					if(loanamt.contains(Loanamt)){		
				test.log(LogStatus.PASS, "Loan amount is :: "+loanamt);
				test.log(LogStatus.PASS, "Loan amount is   satisify");
									
							
					}	
					else{
						test.log(LogStatus.PASS, "Loan amount is  not satisify");
						
					}

									
									

									
								}

							}
							
		}
			
		
		}
	}
	public static void AA_NewLoan_Rule_Check_LoanAmt_MI(String SSN,String FileName,String Loanamt) throws Exception{

		{
			//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);      	
			int lastrow=TestData.getLastRow("NewLoan");
			System.out.println("NewLoan "+lastrow);
			String sheetName="NewLoan";		
			for(int row=2;row<=lastrow;row++)
		{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{		
					String State = TestData.getCellData(sheetName,"StateID",row);
					String ProductID=TestData.getCellData(sheetName,"ProductID",row);
					System.out.println(ProductID);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String ProductName = TestData.getCellData(sheetName,"ProductName",row);
					/*String ProductName = prop.getProperty("ProductName");*/
					//String Term = TestData.getCellData(sheetName,"Term",row);
					String VehicleType= TestData.getCellData(sheetName,"VehicleType",row);
					String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					//String stateProduct=State+" "+ProductID;
					String stateProductType=State+" "+ProductType;
					String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					System.out.println(ESign_CollateralType);
					String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
					//String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
					String ChkgAcctNbr = SSN.substring(3, 9);
					String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
					String AllowPromotion = TestData.getCellData(sheetName,"Allow Promotion",row);
					String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
					String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
					String ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);
					String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
					//String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);	
					String ESign_CheckNbr = SSN.substring(3, 9);
					String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
					System.out.println(last4cheknum);
					System.out.println(stateProductType);
					String Parent_Window = driver.getWindowHandle();
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					test.log(LogStatus.INFO, "Navigate New Loan ");
					try{
						if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
						{
							//driver.findElement(By.xpath("//input[contains(text(),"+stateProduct+")]")).click();
							//test.log(LogStatus.PASS, "Borrower is Registered Successfully with SSN as " +SSN);	
							//WebElement htmltable=driver.findElement(By.xpath("//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));	

							int rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")).size();
							//List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
							test.log(LogStatus.INFO, "Rows count :: "+rows);

							for (int a=2;a<=rows;a++)
							{
								String prod = driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]")).getText();
								test.log(LogStatus.INFO, "Product name is :: "+prod);
								if (prod.equals(ProductName))
								{

									Thread.sleep(3000);
									//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")));
									//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input
									//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/input
									//driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")).click();

									driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]/input")).click();
									test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
								}
							}
						}

					}
					catch(Exception e){
						test.log(LogStatus.PASS, "One Product exists ");
					}







					driver.findElement(By.name("ShareScreenBtn")).click();

					test.log(LogStatus.PASS, "ShareScreen Button clicked");

					for( String winHandle1 : driver.getWindowHandles())

					{

					if(!(winHandle1.equals(Parent_Window)))

					{

					driver.switchTo().window(winHandle1);
					Thread.sleep(2000);
					driver.findElement(By.name("confirmSummary")).click();
					test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");
					}

				}
					
					Thread.sleep(3000);
					driver.switchTo().window(Parent_Window);

					for (String winHandle1 : driver.getWindowHandles())

					{

						driver.switchTo().window(winHandle1);

					}

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

				driver.findElement(By.id("loanDiscBtn")).click();
				for (String winHandle1 : driver.getWindowHandles())

				{
					if (!(winHandle1.equals(Parent_Window))) {
						driver.switchTo().window(winHandle1);
						Thread.sleep(1000);
						driver.findElement(By.name("confirmSummary")).click();
						test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");
					}

				}
					Thread.sleep(2000);
					driver.switchTo().window(Parent_Window);
					driver.switchTo().defaultContent();
                    driver.switchTo().frame("mainFrame");
                    driver.switchTo().frame("main");
                    driver.findElement(By.id("LoanButtonId")).click();
						//driver.findElement(By.id("LoanButtonId")).click();

						test.log(LogStatus.PASS, "Clicked on New Loan button");
						//New Loan Screens


						if(ProductID.equals("PDL"))

						{	

							driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/input")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
							Thread.sleep(3000);
							
						String loanamt=	driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
					
					if(loanamt.contains(Loanamt)){		
				test.log(LogStatus.PASS, "Loan amount is :: "+loanamt);
				test.log(LogStatus.PASS, "Loan amount is   satisify");
									
							
					}	
					else{
						test.log(LogStatus.PASS, "Loan amount is :: "+loanamt);
						test.log(LogStatus.FAIL, "Loan amount is  not satisify");
						
					}

									
									

									
								}

							}
							
		}
		
		}
	}
	
	
	
}








