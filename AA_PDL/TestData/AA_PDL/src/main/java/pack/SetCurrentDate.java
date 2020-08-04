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

public class SetCurrentDate extends AA_PDL{
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
					String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
					String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
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
					
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

					//get current date time with Date()
					Date date = new Date();

					// Now format the date
					String dateFormatted= dateFormat.format(date);
					
					String Date0[] =dateFormatted.split("/");

					String Date1 = Date0[0];
					String Date2 = Date0[1];
					String Date3 = Date0[2];
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.name("storeCode")).click();
					driver.findElement(By.name("storeCode")).sendKeys(StoreId);
					test.log(LogStatus.PASS, "Store number is entered: "+StoreId);
					
					driver.findElement(By.name("beginMonth")).clear();
					driver.findElement(By.name("beginMonth")).sendKeys(Date1); 
					test.log(LogStatus.PASS, "beginMonth is entered: "+Date1);
					driver.findElement(By.name("beginDay")).clear();
					driver.findElement(By.name("beginDay")).sendKeys(Date2);
					test.log(LogStatus.PASS, "beginDay is entered: "+Date2);
					driver.findElement(By.name("beginYear")).clear();
					driver.findElement(By.name("beginYear")).sendKeys(Date3);
					test.log(LogStatus.PASS, "beginYear is entered: "+Date3);
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
