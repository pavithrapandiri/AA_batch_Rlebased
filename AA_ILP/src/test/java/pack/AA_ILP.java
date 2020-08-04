package pack;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

class AA_ILP {

	public static String AdminURL="https://aeaqxsecuritytest.qfund.net/cc/adminIndex.do";
	public static String AppURL="https://aeaqxsecuritytest.qfund.net/cc/trainingIndex.do";
	
	public static Properties prop;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	public WebDriverWait wait;
	static WebDriver driver;
	public static String appUrl;

	static ExtentReports reports;
	public static String UserName;
	public static String Password;
	public static String StoreId;
	public static ExtentTest test;
	public static Excel TestData;
	
	
	//static ExtentReports reports;
	static ExtentReports reports1;
	static ExtentReports reports2;
	static ExtentReports reports3;
	static ExtentReports reports4;
	//public static String UserName;
	//public static String Password;
	//public static String StoreId;
	//public static ExtentTest test;
	public static ExtentTest test1;
	public static ExtentTest test2;
	public static ExtentTest test3;
	//public static Excel TestData;
	public static Excel TestData1;
	public static Excel TestData2;
	public static Excel TestData3;
	public static Excel TestData4;
	public static String Due_Date;
	
	
	
	
	
}
