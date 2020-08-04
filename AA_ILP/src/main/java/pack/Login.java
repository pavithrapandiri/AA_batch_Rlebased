package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
public class Login extends AA_CO_ILP{
 
        private static WebElement element = null;
        static ExtentReports reports;
      // ExtentTest test;
 
    public static WebElement txtbx_UserName(WebDriver driver){
 
         element = driver.findElement(By.name("loginRequestBean.userId"));
 
         return element;
 
         }
 
     public static WebElement txtbx_PIN(WebDriver driver){
 
         element = driver.findElement(By.name("loginRequestBean.password"));
 
         return element;
 
         }
     
     public static WebElement txtbx_StoreId(WebDriver driver){
    	 
         element = driver.findElement(By.name("loginRequestBean.locNbr"));
 
         return element;
 
         }
 
     public static WebElement btn_LogIn(WebDriver driver){
 
         element = driver.findElement(By.name("login"));
 
         return element;
 
         }
     public static void Login(String username, String password, String storenumber) {

 		// JavascriptExecutor js = (JavascriptExecutor)driver;

 		// Launch URL
    	 
 		
 		driver.get(AppURL);
 		test.log(LogStatus.INFO, "CSR Application is launched");
 		driver.manage().window().maximize();
 		String usenameId = "loginRequestBean.userId";
 		String passwordId = "loginRequestBean.password";
 		String StoreID = "loginRequestBean.locNbr";
 		String Login = "login";

 		test.log(LogStatus.PASS, "<FONT color=green style=Arial> ----------- Application Login -----------");

 		driver.findElement(By.name(usenameId)).clear();
 		driver.findElement(By.name(usenameId)).sendKeys(UserName);
 		test.log(LogStatus.PASS, "Username is entered: " + UserName);

 		driver.findElement(By.name(passwordId)).clear();

 		driver.findElement(By.name(passwordId)).sendKeys(Password);
 		test.log(LogStatus.PASS, "Password is entered: " + Password);

 		// writeText(By.name(StoreId), storenumber);
 		driver.findElement(By.name(StoreID)).sendKeys(StoreId);
 		
 		test.log(LogStatus.PASS, "Storenumber is entered: " + StoreId);

 		driver.findElement(By.name(Login)).click();
 		test.log(LogStatus.PASS, "Clicked on Submit button");
 	}
 
}
