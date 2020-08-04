package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class SetCurrentDate_Default extends AA_LOC {
public static void SetCurrentDate(String SSN, String FileName) throws Exception{
		
		
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);
		
			String sheetName="NewLoan";
			test.log(LogStatus.INFO, "Admin Checks");
			int lastrow=TestData.getLastRow("NewLoan");
			
			for(int row=2;row<=lastrow;row++)
			{
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
			{
					//String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
					//String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
					//String Password = TestData.getCellData(sheetName,"Password",row);
					////String StoreId = TestData.getCellData(sheetName,"StoreId",row); 
							
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					driver.get(AdminURL);
					  driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
				        test.log(LogStatus.PASS, "Username is entered:admin");			        
				        driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
				        test.log(LogStatus.PASS, "Password is entered: "+Password);					  	        			   
				        //Click Login Button
				        driver.findElement(By.name("login")).click();
				        test.log(LogStatus.PASS, "Clicked on Submit button");
										
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
					
/*					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

					//get current date time with Date()
					Date date = new Date();

					// Now format the date
					String dateFormatted= dateFormat.format(date);
					
					String Date0[] =dateFormatted.split("/");

					String Date1 = Date0[0];
					String Date2 = Date0[1];
					String Date3 = Date0[2];*/
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.name("storeCode")).click();
					driver.findElement(By.name("storeCode")).sendKeys(StoreId);
					test.log(LogStatus.PASS, "Store number is entered: "+StoreId);
					
					driver.findElement(By.name("beginMonth")).clear();
					driver.findElement(By.name("beginMonth")).sendKeys("01"); 
					test.log(LogStatus.PASS, "beginMonth is entered: 01");
					driver.findElement(By.name("beginDay")).clear();
					driver.findElement(By.name("beginDay")).sendKeys("30");
					test.log(LogStatus.PASS, "beginDay is entered: 30");
					driver.findElement(By.name("beginYear")).clear();
					driver.findElement(By.name("beginYear")).sendKeys("2020");
					test.log(LogStatus.PASS, "beginYear is entered: 2020");
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



public static void SetCurrentDate1(String SSN, String FileName,String month,String day,String year) throws Exception{
	
	
	//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);
	
		String sheetName="NewLoan";
		test.log(LogStatus.INFO, "Admin Checks");
		int lastrow=TestData.getLastRow("NewLoan");
		
		for(int row=2;row<=lastrow;row++)
		{
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
		{
				//String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
				//String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
				//String Password = TestData.getCellData(sheetName,"Password",row);
				////String StoreId = TestData.getCellData(sheetName,"StoreId",row); 
						
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(AdminURL);
				  driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
			        test.log(LogStatus.PASS, "Username is entered:admin");			        
			        driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
			        test.log(LogStatus.PASS, "Password is entered: "+Password);					  	        			   
			        //Click Login Button
			        driver.findElement(By.name("login")).click();
			        test.log(LogStatus.PASS, "Clicked on Submit button");
							Thread.sleep(3000);		
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
				
/*					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

				//get current date time with Date()
				Date date = new Date();

				// Now format the date
				String dateFormatted= dateFormat.format(date);
				
				String Date0[] =dateFormatted.split("/");

				String Date1 = Date0[0];
				String Date2 = Date0[1];
				String Date3 = Date0[2];*/
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.name("storeCode")).click();
				driver.findElement(By.name("storeCode")).sendKeys(StoreId);
				test.log(LogStatus.PASS, "Store number is entered: "+StoreId);
				
				driver.findElement(By.name("beginMonth")).clear();
				driver.findElement(By.name("beginMonth")).sendKeys(month); 
				test.log(LogStatus.PASS, "beginMonth is entered: "+month);
				driver.findElement(By.name("beginDay")).clear();
				driver.findElement(By.name("beginDay")).sendKeys(day);
				test.log(LogStatus.PASS, "beginDay is entered: "+month);
				driver.findElement(By.name("beginYear")).clear();
				driver.findElement(By.name("beginYear")).sendKeys(year);
				test.log(LogStatus.PASS, "beginYear is entered: "+year);
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
