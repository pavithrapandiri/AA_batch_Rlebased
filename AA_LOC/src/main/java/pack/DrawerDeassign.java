package pack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*import Test.CO_ILP.Need;
import Test.CO_ILP.scenario;*/
import pack.*;

import bsh.*;
//import scala.collection.Iterator;
//import scala.collection.Set;

//import Pages.HomePage;
//import Pages.LoginPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileReader;

public class DrawerDeassign extends AA_LOC{
		
	public static void DrawerDeassign(String SSN,String FileName) throws Exception{
		//-------------done updating
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/TLP/"+FileName);	
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";	
			test.log(LogStatus.INFO, "Drawer Deassign");
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
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					
					Login.Login(UserName, Password, StoreId);
					Thread.sleep(3000);
					driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();			
					test.log(LogStatus.PASS, "Clicked on Cash Management");
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.linkText("Drawer")).click();
					test.log(LogStatus.PASS, "Clicked on Drawer");	
					driver.findElement(By.linkText("Deassign")).click();
					test.log(LogStatus.PASS, "Clicked on Deassign");	
					driver.switchTo().frame("main");		
					driver.findElement(By.name("drawerDeassignRequestBean.noOfDollars")).sendKeys("0");
					test.log(LogStatus.PASS, "Current Cash Balance is provided as 0");	
					driver.findElement(By.name("drawerDeassignRequestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Banker PIN# is enetered as"+Password);	
					driver.findElement(By.name("drawerdeassign")).click();
					test.log(LogStatus.PASS, "Click on Finish De-assign Button");
					
					
					
					try{
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//driver.close();
					}
					catch (Exception e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(2000);
					
					driver.findElement(By.name("drawerDeassignRequestBean.password")).clear();
					driver.findElement(By.name("drawerDeassignRequestBean.password")).click();
					driver.findElement(By.name("drawerDeassignRequestBean.password")).sendKeys(Password);				
					driver.findElement(By.name("drawerdeassign")).click();
					Thread.sleep(2000);
					Robot rb=new Robot();
					rb.keyPress(KeyEvent.VK_ENTER);
					try{
						Alert alert = driver.switchTo().alert();
						alert.accept();
						
					}
					catch (Exception e) {
					}
					Thread.sleep(2000);
					for(String winHandle : driver.getWindowHandles()){
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[9]/td[2]/table")).isDisplayed())
					{
						 WebElement htmltable=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[9]/td[2]/table"));	
						    
							List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
							//System.out.println("current row num "+rows.size());
							int count=0;							
							 count=driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[9]/td[2]/table/tbody/tr")).size();				 				
							for(int rnum=1;rnum<rows.size();rnum++)
							{                      
								//System.out.println("current row num "+rnum);						
								driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[9]/td[2]/table/tbody/tr[2]/td[5]/select")).sendKeys("Delete");
								driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[9]/td[2]/table/tbody/tr[2]/td[6]/input")).click();
								Thread.sleep(2000);
								Robot rb2=new Robot();
								rb2.keyPress(KeyEvent.VK_ENTER);
								try { 
									Alert alert = driver.switchTo().alert();
									alert.accept();
									//if alert present, accept and move on.														

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
														}
					}
					Thread.sleep(2000);			
					String DrawerOverShortAmount =driver.findElement(By.name("drawerRequestBean.drawerOverShort")).getAttribute("value");
					driver.findElement(By.name("drawerRequestBean.amount")).sendKeys(DrawerOverShortAmount);
					test.log(LogStatus.PASS, "Amount entered as "+DrawerOverShortAmount);
					driver.findElement(By.name("drawerRequestBean.primary")).sendKeys("Cash Handling");
					test.log(LogStatus.PASS, "Primary Reason is selected as Cash Handling");
					driver.findElement(By.name("drawerRequestBean.notes")).sendKeys("Notes");
					test.log(LogStatus.PASS, "Notes Entered ");	
					driver.findElement(By.name("bt_AddDrawer")).click();
					test.log(LogStatus.PASS, "Click on Add O/S Instance Button");	
					driver.findElement(By.name("transactionDataBean.password")).sendKeys(Password);
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[4]/tbody/tr[3]/td[1]/input")).click();

					test.log(LogStatus.PASS, "Click on Finish Drawer O/S");
					Thread.sleep(2000);
					Robot rb1=new Robot();
					rb1.keyPress(KeyEvent.VK_ENTER);
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					for(String winHandle : driver.getWindowHandles()){
						driver.switchTo().window(winHandle);
					}				    
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
						test.log(LogStatus.FAIL,"Drawer is not De-assigned");
					}
				}
			}
		}

}
