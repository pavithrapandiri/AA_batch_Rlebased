package pack;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class AA_LOC {

	//public static String AdminURL="https://aeaqxsecuritytest.qfund.net/cc/adminIndex.do";
	//public static String AppURL="https://aeaqxsecuritytest.qfund.net/cc/trainingIndex.do";
	public static String AdminURL="http://integration.qfund.net/cc/adminIndex.do";
	public static String AppURL="http://integration.qfund.net/cc/trainingIndex.do";
	//public static String AdminURL=" http://aeaintegration.qfund.net/cc/adminIndex.do";
	//public static String AppURL="http://aeaintegration.qfund.net/cc/trainingIndex.do";
	public static Properties prop;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	public static WebDriverWait wait;
	static WebDriver driver;
	static String appUrl;

	static ExtentReports reports;
	public static String UserName;
	public static String Password;
	public static String StoreId;
	public static ExtentTest test;
	public static Excel TestData;
	
}
