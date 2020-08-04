package pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
public class APR_Caluculation extends AA_ILP{

	@BeforeTest(alwaysRun = true)
	public void setup_Grid() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("C:/AA_Batch/AA_ILP/src/test/java/pack/Config.properties"));

			prop = new Properties();
			prop.load(reader);
			reader.close();

		}

		catch (Exception e) {

			System.out.println("Object proprties file not found");
		}


	}
	@Test    
	public void executSessionOne()throws Exception{
		//First session of WebDriver
		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		// Date D = new Date();
		String kfilename = prop.getProperty("AA_APR_extent_report_file_name") + timestamp + ".html";
		reports = new ExtentReports(System.getProperty("user.dir") + prop.getProperty("AA_APR_extent_report_path") + kfilename, true);
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
		WebDriver driver1 = new InternetExplorerDriver();
		driver1.manage().window().maximize();

		String FileName= "AA_Apr_Calclation_TestData2.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna") + FileName); 
		System.out.println(prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna"));
		int lastrow=TestData.getLastRow("Data");
		String sheetName="Data";
		for(int row=2;row<=lastrow;row++)
		{
			String LoanCode = TestData.getCellData(sheetName,"Loan_code",row);
			String RegLoan = TestData.getCellData(sheetName,"Loan_code",row);
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			String set = TestData.getCellData(sheetName,"Set",row);
			if(RunFlag.equals("Y"))
			{	

				String NumberofInstallments=TestData.getCellData(sheetName,"Number of Installments",row);
				String Unit_Period=TestData.getCellData(sheetName,"Unit_Period",row);
				String Unit_days = Unit_Period.substring(0,3);
				int inum = Integer.parseInt(NumberofInstallments);
				String PayFrequency = TestData.getCellData(sheetName,"Loan_freq",row);
				String Loan_amt = TestData.getCellData(sheetName,"Loan_amt",row);
				String Fee_amt = TestData.getCellData(sheetName,"Fee_amt",row);
				String APR = TestData.getCellData(sheetName,"APR",row);
				//String Loan_freq = TestData.getCellData(sheetName,"Loan_freq",row);
				String Loan_code=TestData.getCellData(sheetName,"Loan_code",row);
				String Loan_date = TestData.getCellData(sheetName,"Loan_date",row);
				String APR_APRInApplication = TestData.getCellData(sheetName,"APR_APRInApplication",row);
				
				//String set = TestData.getCellData(sheetName,"Set",row);
				test = reports.startTest(LoanCode+"_"+PayFrequency+"_"+NumberofInstallments);
				test.log(LogStatus.PASS, "Installment number ::"+NumberofInstallments);
				driver1.get("https://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");
				driver1.navigate().refresh();
				driver1.switchTo().defaultContent();	
				WebDriverWait wait = new WebDriverWait(driver1, 100);
				driver1.findElement(By.name("amountFinanced")).sendKeys(Loan_amt);
				test.log(LogStatus.PASS, "Loan Amount   is ::"+Loan_amt);
				driver1.findElement(By.id("disclosedAPR")).sendKeys(APR);
				test.log(LogStatus.PASS,"Enterd Disclosed APR Value :"+APR);
				//driver1.findElement(By.id("disclosedFinanceCharge")).sendKeys("200");
				//driver1.findElement(By.id("radio-installmentLoan")).click();

				if(Unit_Period.equals(" 13/360"))
				{
					//driver1.findElement(By.id("radio-multiples")).click();
					test.log(LogStatus.PASS,"Monthly redio button selected :");
				}
				else{
					if(Unit_Period.equals(" 15/360"))
					{
						driver1.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label")).click();
						//driver1.findElement(By.id("radio-semiMonthly")).click();
						test.log(LogStatus.PASS,"semimonthly redio button selected :");
					}
					else
						//if(PayFrequency.equals(" BI"))
					{
						driver1.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[4]/label")).click();
						test.log(LogStatus.PASS,"actualDays redio button selected :");
						//driver1.findElement(By.id("radio-actualDaysInstallment")).click();
						// Thread.sleep(5000);
						driver1.findElement(By.id("installmentDaysInUnitPeriod")).sendKeys(Unit_days);
						test.log(LogStatus.PASS,"actualDays entered :"+Unit_days);
					}
				}
				if(PayFrequency.equals("MM"))
				{
					driver1.findElement(By.id("radio-multiples")).click();
					test.log(LogStatus.PASS,"multipule of monthly redio button selected :");
					driver1.findElement(By.id("monthsInUnitPeriod")).sendKeys("14");
				}


				driver1.findElement(By.name("goToResultsBtn")).click();
				test.log(LogStatus.PASS,"Continue  button is clicked :");
				//Thread.sleep(1000);
				for( String winHandle1 : driver1.getWindowHandles())
				{
					driver1.switchTo().window(winHandle1);
				}			
				driver1.switchTo().defaultContent();
				int i;
				int j=1;
				int k=inum-1;
				for (i = 1; i <= inum; i++) {

					WebElement element = driver1.findElement(By.xpath("//table[@id='#table']/tbody["+j+"]"));

					//WebElement element = driver1.findElement(By.xpath("///*[@id='paymentAmount']"));
					Thread.sleep(500);
					element.sendKeys(TestData.getCellData(sheetName,"INST_amt_"+i,row));
					//est.log(LogStatus.PASS,"Loan Amount entered :"+INST_amt_+i);
					List<WebElement> elements = driver1.findElements(By.name("numberOfPayments"));
					WebElement element1 = elements.get(i-1);
					element1.sendKeys("1");
					//test.log(LogStatus.PASS,"number Of Payments entered :"+1);
					driver1.findElement(By.xpath("//*[@id='#table']/tbody/tr["+i+"]/td[4]/div/div/div/button")).click();

					Thread.sleep(1000);
					driver1.findElement(By.id("loanDate")).sendKeys(TestData.getCellData(sheetName,"Loan_date",row));
					//test.log(LogStatus.PASS,"Loan Date entered :"+Loan_date);
					driver1.findElement(By.id("paymentDate")).sendKeys(TestData.getCellData(sheetName,"INST_due_date_"+i,row));
					//test.log(LogStatus.PASS,"Loan Date entered :"+"INST_due_date_"+i);
					driver1.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")).click();
					Thread.sleep(2000);
					if(i<=k) 
					{
						driver1.findElement(By.name("addItem")).click();
					}
				}
				driver1.findElement(By.name("goToResultsBtn")).click();
				Thread.sleep(5000);
				String Apr = driver1.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[1]/div[8]")).getText();
				test.log(LogStatus.PASS,"Loan APR Value :"+Apr);
				String DApr = driver1.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[2]/div[4]")).getText();
				test.log(LogStatus.PASS,"Loan DAPR Value :"+DApr);
				String Capr =Apr.replace("%","");

				//String Capr1 =Capr.trim();
				//float NCapr = Float.parseFloat(Capr);
				double NCapr = Double.parseDouble(Capr);
				//int NCapr = Integer.parseInt(Capr1);
				String CDapr =DApr.replace("%","");
				//double NCapr = Double.parseDouble(Capr);
				//int NCDapr = Integer.parseInt(CDapr);
				double NCDapr = Double.parseDouble(CDapr);

				double Diff = NCapr-NCDapr;
				//String Diff4 = Double.parseDouble(Diff);
				String Diff4 = String.format("%.4f", Diff);
				//Int Diff1 = Integer.parseInt(Diff);
				test.log(LogStatus.PASS,"APR Values Differnce:: "+Diff4);
				String status = null;
				if(Diff<=0.25 & Diff>=-0.25)
				{
					status="PASS";
					test1.log(LogStatus.PASS,"APR Value are equal ");
					//driver1.navigate().refresh();
				}
				else
				{
					status="FAIL";
					test1.log(LogStatus.FAIL,"APR Value are not equal ");
					//driver1.navigate().refresh();
				}
				
				String content = null;
				content = content+"\n"+LoanCode+"_"+PayFrequency+"_"+NumberofInstallments+"_"+Loan_amt+"_"+Unit_days+"_"+APR+"_"+Apr+"_"+Diff+"_"+status;
				//fw.write(contenet);
				
				reports1.endTest(test1);
				
				reports1.flush();
				//try{
		            // Create new file
		            //String content = "This is the content to write into create file";
		            String path="D:\\Data.txt";
		            File file1 = new File(path);

		            // If file doesn't exists, then create it
		            if (!file1.exists()) {
		                file1.createNewFile();
		            }

		            FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());
		            BufferedWriter bw1 = new BufferedWriter(fw1);

		            // Write in file
		            bw1.write(content);

		            // Close connection
		            bw1.close();
		      
			}
					
		}
			
					driver1.close();

	    	}



	@Test    
	public void executeSessionTwo()throws Exception {
		//Second session of WebDriver
		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		// Date D = new Date();

		String kfilename = prop.getProperty("AA_APR_extent_report_file_name1") + timestamp + ".html";
		reports1 = new ExtentReports(System.getProperty("user.dir") + prop.getProperty("AA_APR_extent_report_path1") + kfilename, true);
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		String FileName= "AA_Apr_Calclation_TestData2.xls";
		TestData1 = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna") + FileName); 
		int lastrow=TestData1.getLastRow("Data1");
		String sheetName="Data1";
		for(int row=2;row<=lastrow;row++)
		{
			String LoanCode = TestData1.getCellData(sheetName,"Loan_code",row);
			String RegLoan = TestData1.getCellData(sheetName,"Loan_code",row);
			String RunFlag = TestData1.getCellData(sheetName,"Run",row);
			String set = TestData1.getCellData(sheetName,"Set",row);
			if(RunFlag.equals("Y"))
			{	
				if(LoanCode.equals(RegLoan))
				{

					String NumberofInstallments=TestData1.getCellData(sheetName,"Number of Installments",row);
					String Unit_Period=TestData1.getCellData(sheetName,"Unit_Period",row);
					String Unit_days = Unit_Period.substring(0,3);

					int inum = Integer.parseInt(NumberofInstallments);
					String PayFrequency = TestData1.getCellData(sheetName,"Loan_freq",row);
					String Loan_amt = TestData1.getCellData(sheetName,"Loan_amt",row);
					String Fee_amt = TestData1.getCellData(sheetName,"Fee_amt",row);
					String APR = TestData1.getCellData(sheetName,"APR",row);
					//String Loan_freq = TestData1.getCellData(sheetName,"Loan_freq",row);
					String Loan_code=TestData1.getCellData(sheetName,"Loan_code",row);
					String Loan_date = TestData1.getCellData(sheetName,"Loan_date",row);	
					//String set = TestData1.getCellData(sheetName,"Set",row);
					test1 = reports1.startTest(LoanCode+"_"+PayFrequency+"_"+NumberofInstallments);
					test1.log(LogStatus.PASS, "Installment number ::"+NumberofInstallments);
					driver.get("https://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");	
					driver.navigate().refresh();
					//Thread.sleep(3000);
					driver.switchTo().defaultContent();	
					WebDriverWait wait = new WebDriverWait(driver, 100);
					driver.findElement(By.name("amountFinanced")).sendKeys(Loan_amt);
					test1.log(LogStatus.PASS, "Loan Amount   is ::"+Loan_amt);
					driver.findElement(By.id("disclosedAPR")).sendKeys(APR);
					test1.log(LogStatus.PASS,"Enterd Disclosed APR Value :"+APR);
					//driver.findElement(By.id("disclosedFinanceCharge")).sendKeys("200");
					//driver.findElement(By.id("radio-installmentLoan")).click();

					if(Unit_Period.equals(" 13/360"))
					{
						//driver.findElement(By.id("radio-multiples")).click();
						test1.log(LogStatus.PASS,"Monthly redio button selected :");
					}
					else{
						if(Unit_Period.equals(" 15/360"))
						{
							driver.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label")).click();
							//*[@id="maincontent"]/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label
							//driver.findElement(By.id("radio-semiMonthly")).click();
							test1.log(LogStatus.PASS,"semimonthly redio button selected :");
						}
						else
							//if(PayFrequency.equals(" BI"))
						{
							driver.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[4]/label")).click();
							test1.log(LogStatus.PASS,"actualDays redio button selected :");
							//driver.findElement(By.id("radio-actualDaysInstallment")).click();
							// Thread.sleep(5000);
							driver.findElement(By.id("installmentDaysInUnitPeriod")).sendKeys(Unit_days);
							test1.log(LogStatus.PASS,"actualDays entered :"+Unit_days);
						}
					}
					if(PayFrequency.equals("MM"))
					{
						driver.findElement(By.id("radio-multiples")).click();
						test1.log(LogStatus.PASS,"multipule of monthly redio button selected :");
						driver.findElement(By.id("monthsInUnitPeriod")).sendKeys("14");
					}


					//driver.findElement(By.id("radio-actualDaysInstallment")).click();
					driver.findElement(By.name("goToResultsBtn")).click();
					//test1.log(LogStatus.PASS,"Continue  button is clicked :");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					int i;
					int j=1;
					int k=inum-1;
					for (i = 1; i <= inum; i++) {

						new WebDriverWait(driver, 9).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='#table']/tbody["+j+"]")));

						//WebElement element = driver.findElement(By.xpath("//table[@id='#table']/tbody["+j+"]"));
						WebElement element = driver.findElement(By.xpath("/html/body/app/div[3]/paymentschedule/form/div[1]/div/table/tbody/tr["+i+"]/td[2]/div/input"));
						Thread.sleep(500);
						element.sendKeys(TestData1.getCellData(sheetName,"INST_amt_"+i,row));
						List<WebElement> elements = driver.findElements(By.name("numberOfPayments"));
						WebElement element1 = elements.get(i-1);
						element1.sendKeys("1");
						driver.findElement(By.xpath("//*[@id='#table']/tbody/tr["+i+"]/td[4]/div/div/div/button")).click();

						Thread.sleep(1000);
						driver.findElement(By.id("loanDate")).sendKeys(TestData1.getCellData(sheetName,"Loan_date",row));
						driver.findElement(By.id("paymentDate")).sendKeys(TestData1.getCellData(sheetName,"INST_due_date_"+i,row));
						driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")).click();
						Thread.sleep(2000);
						if(i<=k) 
						{
							driver.findElement(By.name("addItem")).click();
						}
					}
					driver.findElement(By.name("goToResultsBtn")).click();
					Thread.sleep(5000);
					String Apr = driver.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[1]/div[8]")).getText();
					test1.log(LogStatus.PASS,"Loan APR Value :"+Apr);
					String DApr = driver.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[2]/div[4]")).getText();
					test1.log(LogStatus.PASS,"Loan DAPR Value :"+DApr);
					String Capr =Apr.replace("%","");

					//String Capr1 =Capr.trim();
					//float NCapr = Float.parseFloat(Capr);
					double NCapr = Double.parseDouble(Capr);
					//int NCapr = Integer.parseInt(Capr1);
					String CDapr =DApr.replace("%","");
					//double NCapr = Double.parseDouble(Capr);
					//int NCDapr = Integer.parseInt(CDapr);
					double NCDapr = Double.parseDouble(CDapr);

					double Diff = NCapr-NCDapr;
					//String Diff4 = Double.parseDouble(Diff);
					String Diff4 = String.format("%.4f", Diff);
					//Int Diff1 = Integer.parseInt(Diff);
					test1.log(LogStatus.PASS,"APR Values Differnce:: "+Diff4);
					String status=null;
					if(Diff<=0.25 & Diff>=-0.25)
					{
						status="PASS";
						test1.log(LogStatus.PASS,"APR Value are equal ");
						//driver.navigate().refresh();
					}
					else
					{
						status="FAIL";
						test1.log(LogStatus.FAIL,"APR Value are not equal ");
						//driver.navigate().refresh();
					}
					String content = null;
					content = content+"\n"+LoanCode+"_"+PayFrequency+"_"+NumberofInstallments+"_"+Loan_amt+"_"+Unit_days+"_"+APR+"_"+Apr+"_"+Diff+"_"+status;
					//fw.write(contenet);
					
					reports1.endTest(test1);
					
					reports1.flush();
			            String path="D:\\Data1.txt";
			            File file2 = new File(path);

			            // If file doesn't exists, then create it
			            if (!file2.exists()) {
			                file2.createNewFile();
			            }

			            FileWriter fw2 = new FileWriter(file2.getAbsoluteFile());
			            BufferedWriter bw2 = new BufferedWriter(fw2);

			            // Write in file
			            bw2.write(content);

			            // Close connection
			            bw2.close();
			    
				}
				
					
			}
				
				
						driver.close();
			} 
	}
	




	@Test    
	public void executSessionThree() throws Exception{
		//Third session of WebDriver
		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		// Date D = new Date();

		String kfilename = prop.getProperty("AA_APR_extent_report_file_name2") + timestamp + ".html";
		reports2 = new ExtentReports(System.getProperty("user.dir") + prop.getProperty("AA_APR_extent_report_path2") + kfilename, true);
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
		WebDriver driver2 = new InternetExplorerDriver();
		driver2.manage().window().maximize();
		String FileName= "AA_Apr_Calclation_TestData2.xls";
		TestData2 = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna") + FileName); 
		int lastrow=TestData2.getLastRow("Data2");
		System.out.println(lastrow);
		String sheetName="Data2";
		for(int row=2;row<=lastrow;row++)
		{
			String LoanCode = TestData2.getCellData(sheetName,"Loan_code",row);
			String RegLoan = TestData2.getCellData(sheetName,"Loan_code",row);
			String RunFlag = TestData2.getCellData(sheetName,"Run",row);
			String set = TestData2.getCellData(sheetName,"Set",row);
			if(RunFlag.equals("Y"))
			{	
				if(LoanCode.equals(RegLoan))
				{

					String NumberofInstallments=TestData2.getCellData(sheetName,"Number of Installments",row);
					String Unit_Period=TestData2.getCellData(sheetName,"Unit_Period",row);
					String Unit_days = Unit_Period.substring(0,3);

					int inum = Integer.parseInt(NumberofInstallments);
					String PayFrequency = TestData2.getCellData(sheetName,"Loan_freq",row);
					String Loan_amt = TestData2.getCellData(sheetName,"Loan_amt",row);
					String Fee_amt = TestData2.getCellData(sheetName,"Fee_amt",row);
					String APR = TestData2.getCellData(sheetName,"APR",row);
					//String Loan_freq = TestData2.getCellData(sheetName,"Loan_freq",row);
					String Loan_code=TestData2.getCellData(sheetName,"Loan_code",row);
					String Loan_date = TestData2.getCellData(sheetName,"Loan_date",row);	
					//String set = TestData2.getCellData(sheetName,"Set",row);
					test2 = reports2.startTest(LoanCode+"_"+PayFrequency+"_"+NumberofInstallments);
					test2.log(LogStatus.PASS, "Installment number ::"+NumberofInstallments);
					driver2.get("http://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");
					driver2.navigate().refresh();
					//Thread.sleep(3000);
					driver2.switchTo().defaultContent();	
					WebDriverWait wait = new WebDriverWait(driver2, 100);
					driver2.findElement(By.name("amountFinanced")).sendKeys(Loan_amt);
					test2.log(LogStatus.PASS, "Loan Amount   is ::"+Loan_amt);
					driver2.findElement(By.id("disclosedAPR")).sendKeys(APR);
					test2.log(LogStatus.PASS,"Enterd Disclosed APR Value :"+APR);
					//driver2.findElement(By.id("disclosedFinanceCharge")).sendKeys("200");
					//driver2.findElement(By.id("radio-installmentLoan")).click();

					if(Unit_Period.equals(" 13/360"))
					{
						//driver2.findElement(By.id("radio-multiples")).click();
						test2.log(LogStatus.PASS,"Monthly redio button selected :");
					}
					else{
						if(Unit_Period.equals(" 15/360"))
						{
							driver2.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label")).click();
							//*[@id="maincontent"]/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label
							//driver2.findElement(By.id("radio-semiMonthly")).click();
							test2.log(LogStatus.PASS,"semimonthly redio button selected :");
						}
						else
							//if(PayFrequency.equals(" BI"))
						{
							driver2.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[4]/label")).click();
							test2.log(LogStatus.PASS,"actualDays redio button selected :");
							//driver2.findElement(By.id("radio-actualDaysInstallment")).click();
							// Thread.sleep(5000);
							driver2.findElement(By.id("installmentDaysInUnitPeriod")).sendKeys(Unit_days);
							test2.log(LogStatus.PASS,"actualDays entered :"+Unit_days);
						}
					}
					if(PayFrequency.equals("MM"))
					{
						driver2.findElement(By.id("radio-multiples")).click();
						test2.log(LogStatus.PASS,"multipule of monthly redio button selected :");
						driver2.findElement(By.id("monthsInUnitPeriod")).sendKeys("14");
					}


					//driver2.findElement(By.id("radio-actualDaysInstallment")).click();
					driver2.findElement(By.name("goToResultsBtn")).click();
					//test2.log(LogStatus.PASS,"Continue  button is clicked :");
					for( String winHandle1 : driver2.getWindowHandles())
					{
						driver2.switchTo().window(winHandle1);
					}			
					driver2.switchTo().defaultContent();
					int i;
					int j=1;
					int k=inum-1;
					for (i = 1; i <= inum; i++) {

						//new WebdriverWait(driver2, 9).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='#table']/tbody["+j+"]")));
						WebDriverWait wait1 = new WebDriverWait(driver2, 100);
						//WebElement element = driver2.findElement(By.xpath("//table[@id='#table']/tbody["+j+"]"));
						WebElement element = driver2.findElement(By.xpath("/html/body/app/div[3]/paymentschedule/form/div[1]/div/table/tbody/tr["+i+"]/td[2]/div/input"));
						///html/body/app/div[3]/paymentschedule/form/div[2]/div/table/tbody/tr[2]/td[3]/div/input
						Thread.sleep(500);
						element.sendKeys(TestData2.getCellData(sheetName,"INST_amt_"+i,row));
						//est.log(LogStatus.PASS,"Loan Amount entered :"+INST_amt_+i);
						List<WebElement> elements = driver2.findElements(By.name("numberOfPayments"));
						WebElement element1 = elements.get(i-1);
						element1.sendKeys("1");
						//test2.log(LogStatus.PASS,"number Of Payments entered :"+1);
						driver2.findElement(By.xpath("//*[@id='#table']/tbody/tr["+i+"]/td[4]/div/div/div/button")).click();

						Thread.sleep(1000);
						driver2.findElement(By.id("loanDate")).sendKeys(TestData2.getCellData(sheetName,"Loan_date",row));
						//test2.log(LogStatus.PASS,"Loan Date entered :"+Loan_date);
						driver2.findElement(By.id("paymentDate")).sendKeys(TestData2.getCellData(sheetName,"INST_due_date_"+i,row));
						//test2.log(LogStatus.PASS,"Loan Date entered :"+"INST_due_date_"+i);
						driver2.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")).click();
						Thread.sleep(2000);
						if(i<=k) 
						{
							driver2.findElement(By.name("addItem")).click();
						}
					}
					driver2.findElement(By.name("goToResultsBtn")).click();
					Thread.sleep(5000);
					String Apr = driver2.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[1]/div[8]")).getText();
					test2.log(LogStatus.PASS,"Loan APR Value :"+Apr);
					String DApr = driver2.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[2]/div[4]")).getText();
					test2.log(LogStatus.PASS,"Loan DAPR Value :"+DApr);
					String Capr =Apr.replace("%","");

					//String Capr1 =Capr.trim();
					//float NCapr = Float.parseFloat(Capr);
					double NCapr = Double.parseDouble(Capr);
					//int NCapr = Integer.parseInt(Capr1);
					String CDapr =DApr.replace("%","");
					//double NCapr = Double.parseDouble(Capr);
					//int NCDapr = Integer.parseInt(CDapr);
					double NCDapr = Double.parseDouble(CDapr);

					double Diff = NCapr-NCDapr;
					//String Diff4 = Double.parseDouble(Diff);
					String Diff4 = String.format("%.4f", Diff);
					//Int Diff1 = Integer.parseInt(Diff);
					test2.log(LogStatus.PASS,"APR Values Differnce:: "+Diff4);
					String status=null;
					if(Diff<=0.25 & Diff>=-0.25)
					{
						status="PASS";
						test2.log(LogStatus.PASS,"APR Value are equal ");
						//driver2.navigate().refresh();
					}
					else
					{
					status = "FAIL";	
						test2.log(LogStatus.FAIL,"APR Value are not equal ");
						//driver2.navigate().refresh();
					}
					String content = null;
					content = content+"\n"+LoanCode+"_"+PayFrequency+"_"+NumberofInstallments+"_"+Loan_amt+"_"+Unit_days+"_"+APR+"_"+Apr+"_"+Diff+"_"+status;
					 String path="D:\\Data2.txt";
			         File file3 = new File(path);

			         // If file doesn't exists, then create it
			         if (!file3.exists()) {
			             file3.createNewFile();
			         }

			         FileWriter fw3 = new FileWriter(file3.getAbsoluteFile());
			         BufferedWriter bw3 = new BufferedWriter(fw3);

			         // Write in file
			         bw3.write(content);

			         // Close connection
			         bw3.close();
					reports2.endTest(test2);
					reports2.flush();
				}
					
			}
				
						driver2.close();
			}
	}
	
	 private static void appendUsingFileWriter(String filePath, String text) {
			File file = new File(filePath);
			FileWriter fr = null;
			try {
				// Below constructor argument decides whether to append or override
				fr = new FileWriter(file);
				fr.write(text);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	@AfterTest(alwaysRun = true)
	public void setup_Grid1() throws IOException, InterruptedException {
		/*driver.quit();
    	driver1.quit();
    	driver2.quit();
		 */	Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
	}

}