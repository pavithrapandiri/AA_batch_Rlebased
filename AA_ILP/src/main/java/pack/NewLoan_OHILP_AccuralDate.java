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
public class NewLoan_OHILP_AccuralDate extends AA_CO_ILP{

	public static void NewLoan_OHILP_AccuralDate(String SSN,String FileName, CharSequence NegAmt) throws Exception{


		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/CO_ILP/Local/"+FileName);
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
				String ChkgAcctNbr=SSN.substring(3, 9);
				//String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
				String ESign_CourtesyCallConsent =TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String AllowPromotion =TestData.getCellData(sheetName,"Allow Promotion",row);
				String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
				String ESign_Preference =TestData.getCellData(sheetName,"ESign_Preference",row);

				String last4cheknum=ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String Parent_Window = driver.getWindowHandle();
				System.out.println(last4cheknum);
				System.out.println(stateProductType);
				String Parent_Window1 = driver.getWindowHandle();  
				System.out.println(ProductID);	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				appUrl = AppURL;
			    Login.Login(UserName,Password,StoreId);
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
				try {
					if(driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input")).isDisplayed()
)
					{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input")).click();
					test.log(LogStatus.PASS, "Product is selected  ");
					//if alert present, accept and move on.
					}
				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				

				//    Selection of Product based on the Name provided in
				//Test Data
				// if(driver.findElement(By.id("LoanButtonId")).isEnabled())
				if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
				{




					driver.findElement(By.name("ShareScreenBtn")).click();
					test.log(LogStatus.PASS, "ShareScreen Button clicked");

					for (String winHandle1 : driver.getWindowHandles())

					{
						if (!(winHandle1.equals(Parent_Window1))) {
							driver.switchTo().window(winHandle1);
							Thread.sleep(1000);
							driver.findElement(By.name("confirmSummary")).click();
							test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");
						}

					}
					Thread.sleep(3000);
					driver.switchTo().window(Parent_Window1);

					for (String winHandle1 : driver.getWindowHandles())

					{

						driver.switchTo().window(winHandle1);

					}

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

			//driver.findElement(By.id("LoanLengthDocBtn")).click();
					driver.findElement(By.id("LoanButtonId")).click();
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}

					for (String winHandle1 : driver.getWindowHandles())

					{
						if (!(winHandle1.equals(Parent_Window1))) {
							driver.switchTo().window(winHandle1);
							Thread.sleep(1000);
							driver.findElement(By.name("confirmSummary")).click();
							test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");
						}

					}
					Thread.sleep(3000);
					if (ProductID.equals("ILP")) {



						if(ProductID.equals("ILP"))
						{

							driver.switchTo().window(Parent_Window1);

							for (String winHandle1 : driver.getWindowHandles())

							{

								driver.switchTo().window(winHandle1);

							}
							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");

							driver.switchTo().frame("main");

							driver.findElement(By.name("negLoanAmt")).click();
							test.log(LogStatus.PASS, "NegotiableAmmount Button clicked");
							for( String winHandle1 : driver.getWindowHandles())

							{
								if(!(winHandle1.equals(Parent_Window1)))
								{

									Thread.sleep(3000);
									driver.switchTo().window(winHandle1);
									Thread.sleep(1000);
									driver.manage().window().maximize();
									Thread.sleep(3000);
									Robot robot = new Robot();
									Thread.sleep(2000);
									robot.keyPress(KeyEvent.VK_F11);
									test.log(LogStatus.PASS, "F11 button clicked");
									System.out.println("Before");
									Thread.sleep(8000);
									//WebElement element = driver.findElement(By.name("requestBean.siilBean.advAmt"));                                       
									///Actions builder = new Actions(driver); 

									Thread.sleep(3000);

									WebElement element = driver.findElement(By.name("requestBean.siilBean.advAmt"));  
									if(element.isDisplayed()){


										Actions builder = new Actions(driver); 
										builder.doubleClick()
										/* .sendKeys(element, Keys.ARROW_RIGHT)
											   .sendKeys(element, Keys.ARROW_RIGHT)
											   .doubleClick()*/
										//.sendKeys(element, Keys.DELETE)
										//.sendKeys(element, Keys.ARROW_RIGHT)
										.sendKeys(element, Keys.DELETE)
										//.sendKeys(element, Keys.CLEAR)
										.sendKeys(element,Keys.BACK_SPACE)
										.sendKeys(element,Keys.BACK_SPACE)
										.sendKeys(element,Keys.BACK_SPACE)
										.sendKeys(element,Keys.BACK_SPACE)
										.sendKeys(element,Keys.BACK_SPACE)
										.sendKeys(element,Keys.BACK_SPACE)
										.sendKeys(element,Keys.BACK_SPACE)
										.build()
										.perform();
									}


									Thread.sleep(8000);


									driver.findElement(By.name("requestBean.siilBean.advAmt")).sendKeys(NegAmt);
									test.log(LogStatus.PASS, "Negotiable Amount Entered is::"+NegAmt);
									// name="requestBean.siilBean.advAmt"
									driver.findElement(By.name("reCalculate")).click();
									test.log(LogStatus.PASS, "ReCalculate button clicked");
									Thread.sleep(2000);
									driver.findElement(By.name("requestBean.siilBean.collateralType")).sendKeys(ESign_CollateralType);
									test.log(LogStatus.PASS, "Collateral type is selected as ::"+ESign_CollateralType);
									Actions builder = new Actions(driver); 
									builder.doubleClick()
									.sendKeys(element, Keys.ARROW_DOWN)
									.sendKeys(element, Keys.ARROW_DOWN)
									.sendKeys(element, Keys.ARROW_DOWN)
									.sendKeys(element, Keys.ARROW_DOWN)

									.build()
									.perform();
									Thread.sleep(4000);

									//     /html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[15]/td/input
									//	/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[5]/table/tbody/tr[15]/td
									driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table/tbody/tr[13]/td/input")).click();
									test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
									Thread.sleep(5000);
									robot.keyRelease(KeyEvent.VK_F11);
									test.log(LogStatus.PASS, "F11 button clicked");
								}




							}
							Thread.sleep(3000);
							driver.switchTo().window(Parent_Window);

							for( String winHandle1 : driver.getWindowHandles())

							{

								driver.switchTo().window(winHandle1);

							}

							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");

							driver.switchTo().frame("main");
							Thread.sleep(3000);
							String	Instamt=driver.findElement(By.name("requestBean.siilBean.disbAmt")).getAttribute("value");
							System.out.println(Instamt);






							driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);


							driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys("Cash");
							test.log(LogStatus.PASS, "Disb Type is entered as ::ACH");

							Thread.sleep(3000);

							String AccMon = driver.findElement(By.name("acrDate1")).getAttribute("value");
							test.log(LogStatus.PASS, "Accural Month for Cash Collateral is "+AccMon);

							String AccDay = driver.findElement(By.name("acrDate2")).getAttribute("value");
							test.log(LogStatus.PASS, "Accural Day for Cash Collateral is "+AccDay);

							String AccYear = driver.findElement(By.name("acrDate3")).getAttribute("value");
							test.log(LogStatus.PASS, "Accural Year for Cash Collateral is "+AccYear);

							driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
							test.log(LogStatus.PASS, "Disb Type is entered as "+ESign_DisbType);

							Thread.sleep(3000);
							String AccMon1 = driver.findElement(By.name("acrDate1")).getAttribute("value");
							test.log(LogStatus.PASS, "Accural Month for ACH Collateral is "+AccMon1);

							String AccDay1 = driver.findElement(By.name("acrDate2")).getAttribute("value");
							test.log(LogStatus.PASS, "Accural Day for ACH Collateral is "+AccDay1);

							String AccYear1 = driver.findElement(By.name("acrDate3")).getAttribute("value");
							test.log(LogStatus.PASS, "Accural Year for ACH Collateral is "+AccYear1);

							driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(Instamt);
							test.log(LogStatus.PASS, "Disb Amt is entered as "+Instamt);
							driver.findElement(By.name("requestBean.siilBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS,"requestBean.siilBean.emailConsentFlag as "+ESign_CourtesyCallConsent);


							if(ESign_CourtesyCallConsent.equals("Yes"))
							{
								if(ESign_Preference.equals("Call"))
								{
									driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
									test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
								}
								if(ESign_Preference.equals("Mail"))
								{
									driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
									test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
								}
								if(ESign_Preference.equals("SMS"))
								{
									driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
									test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

									try {
										Alert alert = driver.switchTo().alert();
										alert.dismiss();
										//if alert present, accept and move on.

									}
									catch (NoAlertPresentException e) {
										//do what you normally would if you didn't have the alert.
									}
								}

							}
							if(AllowPromotion.equals("Yes"))
							{
								driver.findElement(By.name("allowPromotion")).click();
								test.log(LogStatus.PASS, "AllowPromotion is selected ");
								//String mwh=driver.getWindowHandle();
								driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);
								test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
								//String winHandle =
								driver.getWindowHandle(); //Get current window handle.
							}
							WebElement ele =
									driver.findElement(By.name("requestBean.siilBean.nbrOfInst"));
							String NumofInst=ele.getAttribute("value");
							/*
	//*[@id="errorMessage"]/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[5]/td[2]/input
	                        System.out.println(NumofInst);
	                        int installments = Integer.parseInt(NumofInst);
	                        for(int i=0;i<installments;i++)
	                        {
	                            Random rand = new Random();
	                            int rand1 = rand.nextInt(100000);
	                            String chknum = Integer.toString(rand1);
	driver.findElement(By.id("checkNbrs"+i)).sendKeys(chknum);

	                        }             */
							driver.findElement(By.name("requestBean.password")).sendKeys("1234");
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
							test.log(LogStatus.PASS, "ESign_Checks is selected as 1234");
							driver.findElement(By.name("finishLoan")).click();
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
							try {
								Alert alert = driver.switchTo().alert();
								alert.accept();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
							Thread.sleep(500);

							for( String winHandle1 : driver.getWindowHandles())
							{
								driver.switchTo().window(winHandle1);
							}
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							//

							//driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
							/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='OKBut' and @type='button' and @value='Yes']")));
					driver.findElement(By.xpath("//input[@id='OKBut' and @type='button' and @value='Yes']")).click();*/
							//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[  @value='Yes' and @type='button' ]")));
							//driver.findElement(By.xpath("//input[ @value='Yes' and @type='button' ]")).click();
							driver.findElement(By.xpath("//*[@id='OKBut']")).click();
							//*[@id="OKBut"]
							//driver.findElement(By.name("OKBut")).click();
							//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]")).click();

							test.log(LogStatus.PASS, "click on Yes button ");
							for( String winHandle1 : driver.getWindowHandles())
							{
								driver.switchTo().window(winHandle1);
							}
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							if(		driver.findElement(By.xpath("//input[@type='button' and @value='Ok']")).isDisplayed())
							{
								test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
								//driver.findElement(By.name("ok")).click();
							}
							else
							{
								test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
							}
						}


					}
					else
					{
						test.log(LogStatus.FAIL, "Borrower is not Registered Successfully with SSN as " +SSN);
					}
				}
			}
		}

	}

	
	
	
	
	
	
	
}
