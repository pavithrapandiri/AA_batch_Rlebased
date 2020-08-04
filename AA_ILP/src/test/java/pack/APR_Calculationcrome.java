package pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
public class APR_Calculationcrome extends AA_ILP{
	
	@BeforeTest(alwaysRun = true)
	public void setup_Grid() throws IOException, InterruptedException {
	Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
	Runtime.getRuntime().exec("taskkill /T /F /IM chromedriver.exe");

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
		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		// Date D = new Date();

		String kfilename = "APRSet1" + timestamp + ".html";

		reports1 = new ExtentReports("D:\\Ram\\C\\AA_Batch\\AA_ILP\\ExecutionReports\\Set1\\"+ kfilename, true);
		//FileWriter fw=new FileWriter("D:\\testout.txt");
		//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
	    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	   WebDriver driver1 = new ChromeDriver();
	        //Goto guru99 site
	    //driver1.get("http://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");
	    driver1.manage().window().maximize();
	    //find user name text box and fill it
	   // driver1.findElement(By.name("uid")).sendKeys("Driver 2");
	   // String FileName= "Set.xls";
	    String FileName= "AA_Apr_Calclation_TestData2.xls";
		//TestData1 = new Excel(System.getProperty("user.dir") +"\\TestData\\"+ FileName);
	    TestData1 = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna") + FileName); 
		System.out.println(prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna"));
		int lastrow=TestData1.getLastRow("Data");
		String sheetName="Data";
		String content="LoanCode_PayFrequency_NumberofInstallments_LoanAmount_UnitDays_APR_APRInApplication_Diffrence_Status";
		for(int row=2;row<=lastrow;row++)
		{
			String LoanCode = TestData1.getCellData(sheetName,"Loan_code",row);
			String RegLoan = TestData1.getCellData(sheetName,"Loan_code",row);
			String RunFlag = TestData1.getCellData(sheetName,"Run",row);
			String set = TestData1.getCellData(sheetName,"Set",row);
			//String RunFlag = TestData1.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
			/*if(LoanCode.equals(RegLoan))
				{*/
			
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
			//String INST_amt_1 = TestData1.getCellData(sheetName,"1stINST_amt",row);
			//String INST_amt_1 = TestData1.getCellData(sheetName,"INST_amt",row);
			String Inst_due_date_1 = TestData1.getCellData(sheetName,"1stInst_due_date",row);
			String Inst_days_1 = TestData1.getCellData(sheetName,"1stInst_days",row);
			String INST_amt_2 = TestData1.getCellData(sheetName,"2ndINST_amt",row);
			String Inst_due_date_2 = TestData1.getCellData(sheetName,"2ndInst_due_date",row);
			String Inst_days_2 = TestData1.getCellData(sheetName,"2ndInst_days",row);
			String INST_amt_3 = TestData1.getCellData(sheetName,"3rdINST_amt",row);
			String Inst_due_date_3 = TestData1.getCellData(sheetName,"3rdInst_due_date",row);
			String Inst_days_3 = TestData1.getCellData(sheetName,"3rdInst_days",row);
			String INST_amt_4 = TestData1.getCellData(sheetName,"4thINST_amt",row);
			String Inst_due_date_4 = TestData1.getCellData(sheetName,"4thInst_due_date",row);
			String Inst_days_4 = TestData1.getCellData(sheetName,"4thInst_days",row);
			String INST_amt_5 = TestData1.getCellData(sheetName,"5thINST_amt",row);
			String Inst_due_date_5 = TestData1.getCellData(sheetName,"5thInst_due_date",row);
			String Inst_days_5 = TestData1.getCellData(sheetName,"5thInst_days",row);
			//String set = TestData1.getCellData(sheetName,"Set",row);
			test1 = reports1.startTest(LoanCode+"_"+PayFrequency+"_"+NumberofInstallments);
			test1.log(LogStatus.PASS, "Installment number ::"+NumberofInstallments);
			driver1.get("http://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");	
			driver1.navigate().refresh();
			//Thread.sleep(3000);
			driver1.switchTo().defaultContent();	
			WebDriverWait wait = new WebDriverWait(driver, 100);
			driver1.findElement(By.name("amountFinanced")).sendKeys(Loan_amt);
			test1.log(LogStatus.PASS, "Loan Amount   is ::"+Loan_amt);
			driver1.findElement(By.id("disclosedAPR")).sendKeys(APR);
			test1.log(LogStatus.PASS,"Enterd Disclosed APR Value :"+APR);
			//driver1.findElement(By.id("disclosedFinanceCharge")).sendKeys("200");
			//driver1.findElement(By.id("radio-installmentLoan")).click();
			
			       if(Unit_Period.equals(" 13/360"))
					{
					//driver1.findElement(By.id("radio-multiples")).click();
			    	   test1.log(LogStatus.PASS,"Monthly redio button selected :");
					}
			       else{
			       if(Unit_Period.equals(" 15/360"))
					{
			    	   driver1.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label")).click();
			    	 //*[@id="maincontent"]/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label
					//driver1.findElement(By.id("radio-semiMonthly")).click();
					test1.log(LogStatus.PASS,"semimonthly redio button selected :");
					}
			       else
			       //if(PayFrequency.equals(" BI"))
			       {
			    	   driver1.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[4]/label")).click();
			    	   test1.log(LogStatus.PASS,"actualDays redio button selected :");
			    	   //driver1.findElement(By.id("radio-actualDaysInstallment")).click();
			    	  // Thread.sleep(5000);
					driver1.findElement(By.id("installmentDaysInUnitPeriod")).sendKeys(Unit_days);
					test1.log(LogStatus.PASS,"actualDays entered :"+Unit_days);
					}
			       }
			      /* if(PayFrequency.equals("MM"))
			       {
					driver1.findElement(By.id("radio-multiples")).click();
					 test1.log(LogStatus.PASS,"multipule of monthly redio button selected :");
					driver1.findElement(By.id("monthsInUnitPeriod")).sendKeys("14");
					}*/
			     
			
			//driver1.findElement(By.id("radio-actualDaysInstallment")).click();
			driver1.findElement(By.name("goToResultsBtn")).click();
			//test1.log(LogStatus.PASS,"Continue  button is clicked :");
			for( String winHandle1 : driver1.getWindowHandles())
			{
				driver1.switchTo().window(winHandle1);
			}			
			driver1.switchTo().defaultContent();
			int i;
			int j=1;
			int k=inum-1;
			for (i = 1; i <= inum; i++) {
				
				/*new WebDriverWait(driver, 9).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//table[@id='#table']/tbody["+j+"]")));*/
								
				//WebElement element = driver1.findElement(By.xpath("//table[@id='#table']/tbody["+j+"]"));
				WebElement element = driver1.findElement(By.xpath("/html/body/app/div[3]/paymentschedule/form/div[1]/div/table/tbody/tr["+i+"]/td[2]/div/input"));
				///html/body/app/div[3]/paymentschedule/form/div[2]/div/table/tbody/tr[2]/td[3]/div/input
				Thread.sleep(500);
				 element.sendKeys(TestData1.getCellData(sheetName,"INST_amt_"+i,row));
				 //est.log(LogStatus.PASS,"Loan Amount entered :"+INST_amt_+i);
				List<WebElement> elements = driver1.findElements(By.name("numberOfPayments"));
				WebElement element1 = elements.get(i-1);
				element1.sendKeys("1");
				//test1.log(LogStatus.PASS,"number Of Payments entered :"+1);
				driver1.findElement(By.xpath("//*[@id='#table']/tbody/tr["+i+"]/td[4]/div/div/div/button")).click();
				  
				Thread.sleep(1000);
				driver1.findElement(By.id("loanDate")).sendKeys(TestData1.getCellData(sheetName,"Loan_date",row));
				//test1.log(LogStatus.PASS,"Loan Date entered :"+Loan_date);
				driver1.findElement(By.id("paymentDate")).sendKeys(TestData1.getCellData(sheetName,"INST_due_date_"+i,row));
				//test1.log(LogStatus.PASS,"Loan Date entered :"+"INST_due_date_"+i);
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
			test1.log(LogStatus.PASS,"Loan APR Value :"+Apr);
			String DApr = driver1.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[2]/div[4]")).getText();
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
				//driver1.navigate().refresh();
			}
			else
			{
				status="FAIL";
				test1.log(LogStatus.FAIL,"APR Value are not equal ");
				//driver1.navigate().refresh();
			}
			content = content+"\n"+LoanCode+"_"+PayFrequency+"_"+NumberofInstallments+"_"+Loan_amt+"_"+Unit_days+"_"+APR+"_"+Apr+"_"+Diff+"_"+status;
			//fw.write(contenet);
			
			reports1.endTest(test1);
			
			reports1.flush();
			//try{
	            // Create new file
	            //String content = "This is the content to write into create file";
	            String path="D:\\Set.txt";
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
	       // }
	       /* catch(Exception e){
	            System.out.println(e);
	        }*/
		}
			/*try{
	            // Create new file
	            //String content = "This is the content to write into create file";
	            String path="D:\\Set2.txt";
	            File file = new File(path);

	            // If file doesn't exists, then create it
	            if (!file.exists()) {
	                file.createNewFile();
	            }

	            FileWriter fw = new FileWriter(file.getAbsoluteFile());
	            BufferedWriter bw = new BufferedWriter(fw);

	            // Write in file
	            bw.write(content);

	            // Close connection
	            bw.close();
	        }
	        catch(Exception e){
	            System.out.println(e);
	        }*/
			
	}
		
		
		// Ending Test
				//reports1.endTest(test1);

				// writing everything into HTML report
				//reports1.flush();
		
				driver1.close();

    	}

        
        
    @Test    
    public void executeSessionTwo()throws Exception {
        //Second session of WebDriver
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	// Date D = new Date();

	String kfilename = "APRSet1" + timestamp + ".html";

	reports1 = new ExtentReports("D:\\Ram\\C\\AA_Batch\\AA_ILP\\ExecutionReports\\Set1\\"+ kfilename, true);
	//FileWriter fw=new FileWriter("D:\\testout.txt");
	//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
	//WebDriver driver = new InternetExplorerDriver();
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
   WebDriver driver = new ChromeDriver();
        //Goto guru99 site
    //driver.get("http://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");
    driver.manage().window().maximize();
    //find user name text box and fill it
   // driver.findElement(By.name("uid")).sendKeys("Driver 2");
    
   // String FileName= "Set1.xls";
    String FileName= "AA_Apr_Calclation_TestData2.xls";
    TestData1 = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna") + FileName); 
	//TestData1 = new Excel(System.getProperty("user.dir") +"\\TestData\\"+ FileName);
	System.out.println(prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna"));
	int lastrow=TestData1.getLastRow("Data1");
	String sheetName="Data1";
	String content="LoanCode_PayFrequency_NumberofInstallments_LoanAmount_UnitDays_APR_APRInApplication_Diffrence_Status";
	for(int row=2;row<=lastrow;row++)
	{
		String LoanCode = TestData1.getCellData(sheetName,"Loan_code",row);
		String RegLoan = TestData1.getCellData(sheetName,"Loan_code",row);
		String RunFlag = TestData1.getCellData(sheetName,"Run",row);
		String set = TestData1.getCellData(sheetName,"Set",row);
		//String RunFlag = TestData1.getCellData(sheetName,"Run",row);
		if(RunFlag.equals("Y"))
		{	
		/*if(LoanCode.equals(RegLoan))
			{*/
		
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
		//String INST_amt_1 = TestData1.getCellData(sheetName,"1stINST_amt",row);
		//String INST_amt_1 = TestData1.getCellData(sheetName,"INST_amt",row);
		String Inst_due_date_1 = TestData1.getCellData(sheetName,"1stInst_due_date",row);
		String Inst_days_1 = TestData1.getCellData(sheetName,"1stInst_days",row);
		String INST_amt_2 = TestData1.getCellData(sheetName,"2ndINST_amt",row);
		String Inst_due_date_2 = TestData1.getCellData(sheetName,"2ndInst_due_date",row);
		String Inst_days_2 = TestData1.getCellData(sheetName,"2ndInst_days",row);
		String INST_amt_3 = TestData1.getCellData(sheetName,"3rdINST_amt",row);
		String Inst_due_date_3 = TestData1.getCellData(sheetName,"3rdInst_due_date",row);
		String Inst_days_3 = TestData1.getCellData(sheetName,"3rdInst_days",row);
		String INST_amt_4 = TestData1.getCellData(sheetName,"4thINST_amt",row);
		String Inst_due_date_4 = TestData1.getCellData(sheetName,"4thInst_due_date",row);
		String Inst_days_4 = TestData1.getCellData(sheetName,"4thInst_days",row);
		String INST_amt_5 = TestData1.getCellData(sheetName,"5thINST_amt",row);
		String Inst_due_date_5 = TestData1.getCellData(sheetName,"5thInst_due_date",row);
		String Inst_days_5 = TestData1.getCellData(sheetName,"5thInst_days",row);
		//String set = TestData1.getCellData(sheetName,"Set",row);
		test1 = reports1.startTest(LoanCode+"_"+PayFrequency+"_"+NumberofInstallments);
		test1.log(LogStatus.PASS, "Installment number ::"+NumberofInstallments);
		driver.get("http://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");	
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
		      /* if(PayFrequency.equals("MM"))
		       {
				driver.findElement(By.id("radio-multiples")).click();
				 test1.log(LogStatus.PASS,"multipule of monthly redio button selected :");
				driver.findElement(By.id("monthsInUnitPeriod")).sendKeys("14");
				}*/
		     
		
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
			
			/*new WebDriverWait(driver, 9).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[@id='#table']/tbody["+j+"]")));*/
							
			//WebElement element = driver.findElement(By.xpath("//table[@id='#table']/tbody["+j+"]"));
			WebElement element = driver.findElement(By.xpath("/html/body/app/div[3]/paymentschedule/form/div[1]/div/table/tbody/tr["+i+"]/td[2]/div/input"));
			///html/body/app/div[3]/paymentschedule/form/div[2]/div/table/tbody/tr[2]/td[3]/div/input
			Thread.sleep(500);
			 element.sendKeys(TestData1.getCellData(sheetName,"INST_amt_"+i,row));
			 //est.log(LogStatus.PASS,"Loan Amount entered :"+INST_amt_+i);
			List<WebElement> elements = driver.findElements(By.name("numberOfPayments"));
			WebElement element1 = elements.get(i-1);
			element1.sendKeys("1");
			//test1.log(LogStatus.PASS,"number Of Payments entered :"+1);
			driver.findElement(By.xpath("//*[@id='#table']/tbody/tr["+i+"]/td[4]/div/div/div/button")).click();
			  
			Thread.sleep(1000);
			driver.findElement(By.id("loanDate")).sendKeys(TestData1.getCellData(sheetName,"Loan_date",row));
			//test1.log(LogStatus.PASS,"Loan Date entered :"+Loan_date);
			driver.findElement(By.id("paymentDate")).sendKeys(TestData1.getCellData(sheetName,"INST_due_date_"+i,row));
			//test1.log(LogStatus.PASS,"Loan Date entered :"+"INST_due_date_"+i);
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
		content = content+"\n"+LoanCode+"_"+PayFrequency+"_"+NumberofInstallments+"_"+Loan_amt+"_"+Unit_days+"_"+APR+"_"+Apr+"_"+Diff+"_"+status;
		//fw.write(contenet);
		
		reports1.endTest(test1);
		
		reports1.flush();
		//try{
            // Create new file
            //String content = "This is the content to write into create file";
            String path="D:\\Set1.txt";
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
       // }
       /* catch(Exception e){
            System.out.println(e);
        }*/
	}
		/*try{
            // Create new file
            //String content = "This is the content to write into create file";
            String path="D:\\Set2.txt";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            bw.write(content);

            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }*/
		
}
	
	
	// Ending Test
			//reports1.endTest(test1);

			// writing everything into HTML report
			//reports1.flush();
	
			driver.close();
}

     
        
    @Test    
    public void executSessionThree() throws Exception{
        //Third session of WebDriver
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	// Date D = new Date();

	String kfilename = "APRSet2" + timestamp + ".html";

	reports2 = new ExtentReports("D:\\Ram\\C\\AA_Batch\\AA_ILP\\ExecutionReports\\Set2\\"+ kfilename, true);
	//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
	//WebDriver driver2 = new InternetExplorerDriver();
	//driver2.manage().window().maximize();
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    WebDriver driver2 = new ChromeDriver();
        //Goto guru99 site
   // driver2.get("http://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");
    //find user name text box and fill it
   // driver.findElement(By.name("uid")).sendKeys("Driver 3");
    String content="LoanCode_PayFrequency_NumberofInstallments_LoanAmount_UnitDays_APR_APRInApplication_Diffrence_Status";
   // String FileName= "Set2.xls";
	//TestData2 = new Excel(System.getProperty("user.dir") +"\\TestData\\"+ FileName);
    String FileName= "AA_Apr_Calclation_TestData2.xls";
	TestData2 = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna") + FileName); 
	//System.out.println(prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna"));
	int lastrow=TestData2.getLastRow("Data2");
	System.out.println(lastrow);
	String sheetName="Data2";
	for(int row=2;row<=lastrow;row++)
	{
		String LoanCode = TestData2.getCellData(sheetName,"Loan_code",row);
		String RegLoan = TestData2.getCellData(sheetName,"Loan_code",row);
		String RunFlag = TestData2.getCellData(sheetName,"Run",row);
		String set = TestData2.getCellData(sheetName,"Set",row);
		//String RunFlag = TestData2.getCellData(sheetName,"Run",row);
		if(RunFlag.equals("Y"))
		{	
		/*if(LoanCode.equals(RegLoan))
			{*/
		
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
		//String INST_amt_1 = TestData2.getCellData(sheetName,"1stINST_amt",row);
		//String INST_amt_1 = TestData2.getCellData(sheetName,"INST_amt",row);
		String Inst_due_date_1 = TestData2.getCellData(sheetName,"1stInst_due_date",row);
		String Inst_days_1 = TestData2.getCellData(sheetName,"1stInst_days",row);
		String INST_amt_2 = TestData2.getCellData(sheetName,"2ndINST_amt",row);
		String Inst_due_date_2 = TestData2.getCellData(sheetName,"2ndInst_due_date",row);
		String Inst_days_2 = TestData2.getCellData(sheetName,"2ndInst_days",row);
		String INST_amt_3 = TestData2.getCellData(sheetName,"3rdINST_amt",row);
		String Inst_due_date_3 = TestData2.getCellData(sheetName,"3rdInst_due_date",row);
		String Inst_days_3 = TestData2.getCellData(sheetName,"3rdInst_days",row);
		String INST_amt_4 = TestData2.getCellData(sheetName,"4thINST_amt",row);
		String Inst_due_date_4 = TestData2.getCellData(sheetName,"4thInst_due_date",row);
		String Inst_days_4 = TestData2.getCellData(sheetName,"4thInst_days",row);
		String INST_amt_5 = TestData2.getCellData(sheetName,"5thINST_amt",row);
		String Inst_due_date_5 = TestData2.getCellData(sheetName,"5thInst_due_date",row);
		String Inst_days_5 = TestData2.getCellData(sheetName,"5thInst_days",row);
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
		      /* if(PayFrequency.equals("MM"))
		       {
				driver2.findElement(By.id("radio-multiples")).click();
				 test2.log(LogStatus.PASS,"multipule of monthly redio button selected :");
				driver2.findElement(By.id("monthsInUnitPeriod")).sendKeys("14");
				}*/
		     
		
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
			
			/*new WebdriverWait(driver2, 9).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[@id='#table']/tbody["+j+"]")));*/
							
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
		content = content+"\n"+LoanCode+"_"+PayFrequency+"_"+NumberofInstallments+"_"+Loan_amt+"_"+Unit_days+"_"+APR+"_"+Apr+"_"+Diff+"_"+status;
		 String path="D:\\Set2.txt";
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
	
	
	// Ending Test
			//reports2.endTest(test2);

			// writing everything into HTML report
			//reports2.flush();
			driver2.close();
}
   @Test    
    public void executSessionFIve() throws Exception{
        //Third session of WebDriver
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	// Date D = new Date();

	String kfilename = "APRSet5" + timestamp + ".html";

	reports3 = new ExtentReports("D:\\Ram\\C\\AA_Batch\\AA_ILP\\ExecutionReports\\Set4\\"+ kfilename, true);
	/*System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
	WebDriver driver3 = new InternetExplorerDriver();
	driver3.manage().window().maximize();*/
	String content="LoanCode_PayFrequency_NumberofInstallments_LoanAmount_UnitDays_APR_APRInApplication_Diffrence_Status";
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    WebDriver driver3 = new ChromeDriver();
    driver3.manage().window().maximize();
        //Goto guru99 site
   // driver3.get("http://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");
    //find user name text box and fill it
   // driver.findElement(By.name("uid")).sendKeys("Driver 3");
    //String FileName= "Set3.xls";
	//TestData3 = new Excel(System.getProperty("user.dir") +"\\TestData\\"+ FileName);
    String FileName= "AA_Apr_Calclation_TestData2.xls";
	TestData3 = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna") + FileName); 
	System.out.println(prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna"));
	int lastrow=TestData3.getLastRow("Data3");
	System.out.println(lastrow);
	String sheetName="Data3";
	for(int row=2;row<=lastrow;row++)
	{
		String LoanCode = TestData3.getCellData(sheetName,"Loan_code",row);
		String RegLoan = TestData3.getCellData(sheetName,"Loan_code",row);
		String RunFlag = TestData3.getCellData(sheetName,"Run",row);
		String set = TestData3.getCellData(sheetName,"Set",row);
		//String RunFlag = TestData3.getCellData(sheetName,"Run",row);
		if(RunFlag.equals("Y"))
		{	
		/*if(LoanCode.equals(RegLoan))
			{*/
		
		String NumberofInstallments=TestData3.getCellData(sheetName,"Number of Installments",row);
		String Unit_Period=TestData3.getCellData(sheetName,"Unit_Period",row);
		String Unit_days = Unit_Period.substring(0,3);
		
		int inum = Integer.parseInt(NumberofInstallments);
		String PayFrequency = TestData3.getCellData(sheetName,"Loan_freq",row);
		String Loan_amt = TestData3.getCellData(sheetName,"Loan_amt",row);
		String Fee_amt = TestData3.getCellData(sheetName,"Fee_amt",row);
		String APR = TestData3.getCellData(sheetName,"APR",row);
		//String Loan_freq = TestData3.getCellData(sheetName,"Loan_freq",row);
		String Loan_code=TestData3.getCellData(sheetName,"Loan_code",row);
		String Loan_date = TestData3.getCellData(sheetName,"Loan_date",row);	
		//String INST_amt_1 = TestData3.getCellData(sheetName,"1stINST_amt",row);
		//String INST_amt_1 = TestData3.getCellData(sheetName,"INST_amt",row);
		String Inst_due_date_1 = TestData3.getCellData(sheetName,"1stInst_due_date",row);
		String Inst_days_1 = TestData3.getCellData(sheetName,"1stInst_days",row);
		String INST_amt_2 = TestData3.getCellData(sheetName,"2ndINST_amt",row);
		String Inst_due_date_2 = TestData3.getCellData(sheetName,"2ndInst_due_date",row);
		String Inst_days_2 = TestData3.getCellData(sheetName,"2ndInst_days",row);
		String INST_amt_3 = TestData3.getCellData(sheetName,"3rdINST_amt",row);
		String Inst_due_date_3 = TestData3.getCellData(sheetName,"3rdInst_due_date",row);
		String Inst_days_3 = TestData3.getCellData(sheetName,"3rdInst_days",row);
		String INST_amt_4 = TestData3.getCellData(sheetName,"4thINST_amt",row);
		String Inst_due_date_4 = TestData3.getCellData(sheetName,"4thInst_due_date",row);
		String Inst_days_4 = TestData3.getCellData(sheetName,"4thInst_days",row);
		String INST_amt_5 = TestData3.getCellData(sheetName,"5thINST_amt",row);
		String Inst_due_date_5 = TestData3.getCellData(sheetName,"5thInst_due_date",row);
		String Inst_days_5 = TestData3.getCellData(sheetName,"5thInst_days",row);
		//String set = TestData3.getCellData(sheetName,"Set",row);
		test3 = reports3.startTest(LoanCode+"_"+PayFrequency+"_"+NumberofInstallments);
		test3.log(LogStatus.PASS, "Installment number ::"+NumberofInstallments);
		 driver3.get("http://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");
		 driver3.navigate().refresh();
		//Thread.sleep(3000);
		driver3.switchTo().defaultContent();	
		WebDriverWait wait = new WebDriverWait(driver3, 100);
		driver3.findElement(By.name("amountFinanced")).sendKeys(Loan_amt);
		test3.log(LogStatus.PASS, "Loan Amount   is ::"+Loan_amt);
		driver3.findElement(By.id("disclosedAPR")).sendKeys(APR);
		test3.log(LogStatus.PASS,"Enterd Disclosed APR Value :"+APR);
		//driver3.findElement(By.id("disclosedFinanceCharge")).sendKeys("200");
		//driver3.findElement(By.id("radio-installmentLoan")).click();
		
		       if(Unit_Period.equals(" 13/360"))
				{
				//driver3.findElement(By.id("radio-multiples")).click();
		    	   test3.log(LogStatus.PASS,"Monthly redio button selected :");
				}
		       else{
		       if(Unit_Period.equals(" 15/360"))
				{
		    	   driver3.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label")).click();
		    	 //*[@id="maincontent"]/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label
				//driver3.findElement(By.id("radio-semiMonthly")).click();
				test3.log(LogStatus.PASS,"semimonthly redio button selected :");
				}
		       else
		       //if(PayFrequency.equals(" BI"))
		       {
		    	   driver3.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[4]/label")).click();
		    	   test3.log(LogStatus.PASS,"actualDays redio button selected :");
		    	   //driver3.findElement(By.id("radio-actualDaysInstallment")).click();
		    	  // Thread.sleep(5000);
				driver3.findElement(By.id("installmentDaysInUnitPeriod")).sendKeys(Unit_days);
				test3.log(LogStatus.PASS,"actualDays entered :"+Unit_days);
				}
		       }
		      /* if(PayFrequency.equals("MM"))
		       {
				driver3.findElement(By.id("radio-multiples")).click();
				 test3.log(LogStatus.PASS,"multipule of monthly redio button selected :");
				driver3.findElement(By.id("monthsInUnitPeriod")).sendKeys("14");
				}*/
		     
		
		//driver3.findElement(By.id("radio-actualDaysInstallment")).click();
		driver3.findElement(By.name("goToResultsBtn")).click();
		//test3.log(LogStatus.PASS,"Continue  button is clicked :");
		for( String winHandle1 : driver3.getWindowHandles())
		{
			driver3.switchTo().window(winHandle1);
		}			
		driver3.switchTo().defaultContent();
		int i;
		int j=1;
		int k=inum-1;
		for (i = 1; i <= inum; i++) {
			
			/*new WebdriverWait(driver3, 9).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[@id='#table']/tbody["+j+"]")));*/
							
			//WebElement element = driver3.findElement(By.xpath("//table[@id='#table']/tbody["+j+"]"));
			WebElement element = driver3.findElement(By.xpath("/html/body/app/div[3]/paymentschedule/form/div[1]/div/table/tbody/tr["+i+"]/td[2]/div/input"));
			///html/body/app/div[3]/paymentschedule/form/div[2]/div/table/tbody/tr[2]/td[3]/div/input
			Thread.sleep(500);
			 element.sendKeys(TestData3.getCellData(sheetName,"INST_amt_"+i,row));
			 //est.log(LogStatus.PASS,"Loan Amount entered :"+INST_amt_+i);
			List<WebElement> elements = driver3.findElements(By.name("numberOfPayments"));
			WebElement element1 = elements.get(i-1);
			element1.sendKeys("1");
			//test3.log(LogStatus.PASS,"number Of Payments entered :"+1);
			driver3.findElement(By.xpath("//*[@id='#table']/tbody/tr["+i+"]/td[4]/div/div/div/button")).click();
			  
			Thread.sleep(1000);
			driver3.findElement(By.id("loanDate")).sendKeys(TestData3.getCellData(sheetName,"Loan_date",row));
			//test3.log(LogStatus.PASS,"Loan Date entered :"+Loan_date);
			driver3.findElement(By.id("paymentDate")).sendKeys(TestData3.getCellData(sheetName,"INST_due_date_"+i,row));
			//test3.log(LogStatus.PASS,"Loan Date entered :"+"INST_due_date_"+i);
			driver3.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")).click();
			Thread.sleep(2000);
			if(i<=k) 
			{
				driver3.findElement(By.name("addItem")).click();
			}
		}
		driver3.findElement(By.name("goToResultsBtn")).click();
		Thread.sleep(5000);
		String Apr = driver3.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[1]/div[8]")).getText();
		test3.log(LogStatus.PASS,"Loan APR Value :"+Apr);
		String DApr = driver3.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[2]/div[4]")).getText();
		test3.log(LogStatus.PASS,"Loan DAPR Value :"+DApr);
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
		test3.log(LogStatus.PASS,"APR Values Differnce:: "+Diff4);
		String status=null;
		if(Diff<=0.25 & Diff>=-0.25)
		{
			status="PASS";
			test3.log(LogStatus.PASS,"APR Value are equal ");
			//driver3.navigate().refresh();
		}
		else
		{
			status="FAIL";
			test3.log(LogStatus.FAIL,"APR Value are not equal ");
			//driver3.navigate().refresh();
		}
		content = content+"\n"+LoanCode+"_"+PayFrequency+"_"+NumberofInstallments+"_"+Loan_amt+"_"+Unit_days+"_"+APR+"_"+Apr+"_"+Diff+"_"+status;
		String path="D:\\Set3.txt"; 
		File file4 = new File(path);

         // If file doesn't exists, then create it
         if (!file4.exists()) {
             file4.createNewFile();
         }

         FileWriter fw4 = new FileWriter(file4.getAbsoluteFile());
         BufferedWriter bw4 = new BufferedWriter(fw4);

         // Write in file
         bw4.write(content);

         // Close connection
         bw4.close();
		reports3.endTest(test3);
		reports3.flush();
	}
		
}
	
	
	// Ending Test
			//reports3.endTest(test3);

			// writing everything into HTML report
			//reports3.flush();
			driver3.close();
}
   @Test    
   public void executSessionFour() throws Exception{
       //Third session of WebDriver
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	// Date D = new Date();

	String kfilename = "APRSet4" + timestamp + ".html";

	reports3 = new ExtentReports("D:\\Ram\\C\\AA_Batch\\AA_ILP\\ExecutionReports\\Set4\\"+ kfilename, true);
	/*System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
	WebDriver driver3 = new InternetExplorerDriver();
	driver4.manage().window().maximize();*/
	String content="LoanCode_PayFrequency_NumberofInstallments_LoanAmount_UnitDays_APR_APRInApplication_Diffrence_Status";
   System.setProperty("webdriver.chrome.driver","chromedriver.exe");
   WebDriver driver4 = new ChromeDriver();
   driver4.manage().window().maximize();
       //Goto guru99 site
  // driver4.get("http://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");
   //find user name text box and fill it
  // driver.findElement(By.name("uid")).sendKeys("Driver 3");
  // String FileName= "Set4.xls";
	//TestData4 = new Excel(System.getProperty("user.dir") +"\\TestData\\"+ FileName);
   String FileName= "AA_Apr_Calclation_TestData2.xls";
	TestData4 = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna") + FileName); 
	System.out.println(prop.getProperty("AA_Store_Test_data_APR_Calc_path_chenna"));
	int lastrow=TestData4.getLastRow("Data4");
	System.out.println(lastrow);
	String sheetName="Data4";
	for(int row=2;row<=lastrow;row++)
	{
		String LoanCode = TestData4.getCellData(sheetName,"Loan_code",row);
		String RegLoan = TestData4.getCellData(sheetName,"Loan_code",row);
		String RunFlag = TestData4.getCellData(sheetName,"Run",row);
		String set = TestData4.getCellData(sheetName,"Set",row);
		//String RunFlag = TestData4.getCellData(sheetName,"Run",row);
		if(RunFlag.equals("Y"))
		{	
		/*if(LoanCode.equals(RegLoan))
			{*/
		
		String NumberofInstallments=TestData4.getCellData(sheetName,"Number of Installments",row);
		String Unit_Period=TestData4.getCellData(sheetName,"Unit_Period",row);
		String Unit_days = Unit_Period.substring(0,3);
		
		int inum = Integer.parseInt(NumberofInstallments);
		String PayFrequency = TestData4.getCellData(sheetName,"Loan_freq",row);
		String Loan_amt = TestData4.getCellData(sheetName,"Loan_amt",row);
		String Fee_amt = TestData4.getCellData(sheetName,"Fee_amt",row);
		String APR = TestData4.getCellData(sheetName,"APR",row);
		//String Loan_freq = TestData4.getCellData(sheetName,"Loan_freq",row);
		String Loan_code=TestData4.getCellData(sheetName,"Loan_code",row);
		String Loan_date = TestData4.getCellData(sheetName,"Loan_date",row);	
		//String INST_amt_1 = TestData4.getCellData(sheetName,"1stINST_amt",row);
		//String INST_amt_1 = TestData4.getCellData(sheetName,"INST_amt",row);
		String Inst_due_date_1 = TestData4.getCellData(sheetName,"1stInst_due_date",row);
		String Inst_days_1 = TestData4.getCellData(sheetName,"1stInst_days",row);
		String INST_amt_2 = TestData4.getCellData(sheetName,"2ndINST_amt",row);
		String Inst_due_date_2 = TestData4.getCellData(sheetName,"2ndInst_due_date",row);
		String Inst_days_2 = TestData4.getCellData(sheetName,"2ndInst_days",row);
		String INST_amt_3 = TestData4.getCellData(sheetName,"3rdINST_amt",row);
		String Inst_due_date_3 = TestData4.getCellData(sheetName,"3rdInst_due_date",row);
		String Inst_days_3 = TestData4.getCellData(sheetName,"3rdInst_days",row);
		String INST_amt_4 = TestData4.getCellData(sheetName,"4thINST_amt",row);
		String Inst_due_date_4 = TestData4.getCellData(sheetName,"4thInst_due_date",row);
		String Inst_days_4 = TestData4.getCellData(sheetName,"4thInst_days",row);
		String INST_amt_5 = TestData4.getCellData(sheetName,"5thINST_amt",row);
		String Inst_due_date_5 = TestData4.getCellData(sheetName,"5thInst_due_date",row);
		String Inst_days_5 = TestData4.getCellData(sheetName,"5thInst_days",row);
		//String set = TestData4.getCellData(sheetName,"Set",row);
		test3 = reports4.startTest(LoanCode+"_"+PayFrequency+"_"+NumberofInstallments);
		test3.log(LogStatus.PASS, "Installment number ::"+NumberofInstallments);
		 driver4.get("http://www.ffiec.gov/examtools/FFIEC-Calculators/APR/#/loandata");
		 driver4.navigate().refresh();
		//Thread.sleep(3000);
		driver4.switchTo().defaultContent();	
		WebDriverWait wait = new WebDriverWait(driver4, 100);
		driver4.findElement(By.name("amountFinanced")).sendKeys(Loan_amt);
		test3.log(LogStatus.PASS, "Loan Amount   is ::"+Loan_amt);
		driver4.findElement(By.id("disclosedAPR")).sendKeys(APR);
		test3.log(LogStatus.PASS,"Enterd Disclosed APR Value :"+APR);
		//driver4.findElement(By.id("disclosedFinanceCharge")).sendKeys("200");
		//driver4.findElement(By.id("radio-installmentLoan")).click();
		
		       if(Unit_Period.equals(" 13/360"))
				{
				//driver4.findElement(By.id("radio-multiples")).click();
		    	   test3.log(LogStatus.PASS,"Monthly redio button selected :");
				}
		       else{
		       if(Unit_Period.equals(" 15/360"))
				{
		    	   driver4.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label")).click();
		    	 //*[@id="maincontent"]/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[3]/label
				//driver4.findElement(By.id("radio-semiMonthly")).click();
				test3.log(LogStatus.PASS,"semimonthly redio button selected :");
				}
		       else
		       //if(PayFrequency.equals(" BI"))
		       {
		    	   driver4.findElement(By.xpath("//*[@id='maincontent']/loandata/form/div[5]/div/div/div/div/div/fieldset/ul/li[4]/label")).click();
		    	   test3.log(LogStatus.PASS,"actualDays redio button selected :");
		    	   //driver4.findElement(By.id("radio-actualDaysInstallment")).click();
		    	  // Thread.sleep(5000);
				driver4.findElement(By.id("installmentDaysInUnitPeriod")).sendKeys(Unit_days);
				test3.log(LogStatus.PASS,"actualDays entered :"+Unit_days);
				}
		       }
		      /* if(PayFrequency.equals("MM"))
		       {
				driver4.findElement(By.id("radio-multiples")).click();
				 test3.log(LogStatus.PASS,"multipule of monthly redio button selected :");
				driver4.findElement(By.id("monthsInUnitPeriod")).sendKeys("14");
				}*/
		     
		
		//driver4.findElement(By.id("radio-actualDaysInstallment")).click();
		driver4.findElement(By.name("goToResultsBtn")).click();
		//test3.log(LogStatus.PASS,"Continue  button is clicked :");
		for( String winHandle1 : driver4.getWindowHandles())
		{
			driver4.switchTo().window(winHandle1);
		}			
		driver4.switchTo().defaultContent();
		int i;
		int j=1;
		int k=inum-1;
		for (i = 1; i <= inum; i++) {
			
			/*new WebdriverWait(driver3, 9).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[@id='#table']/tbody["+j+"]")));*/
							
			//WebElement element = driver4.findElement(By.xpath("//table[@id='#table']/tbody["+j+"]"));
			WebElement element = driver4.findElement(By.xpath("/html/body/app/div[3]/paymentschedule/form/div[1]/div/table/tbody/tr["+i+"]/td[2]/div/input"));
			///html/body/app/div[3]/paymentschedule/form/div[2]/div/table/tbody/tr[2]/td[3]/div/input
			Thread.sleep(500);
			 element.sendKeys(TestData4.getCellData(sheetName,"INST_amt_"+i,row));
			 //est.log(LogStatus.PASS,"Loan Amount entered :"+INST_amt_+i);
			List<WebElement> elements = driver4.findElements(By.name("numberOfPayments"));
			WebElement element1 = elements.get(i-1);
			element1.sendKeys("1");
			//test3.log(LogStatus.PASS,"number Of Payments entered :"+1);
			driver4.findElement(By.xpath("//*[@id='#table']/tbody/tr["+i+"]/td[4]/div/div/div/button")).click();
			  
			Thread.sleep(1000);
			driver4.findElement(By.id("loanDate")).sendKeys(TestData4.getCellData(sheetName,"Loan_date",row));
			//test3.log(LogStatus.PASS,"Loan Date entered :"+Loan_date);
			driver4.findElement(By.id("paymentDate")).sendKeys(TestData4.getCellData(sheetName,"INST_due_date_"+i,row));
			//test3.log(LogStatus.PASS,"Loan Date entered :"+"INST_due_date_"+i);
			driver4.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")).click();
			Thread.sleep(2000);
			if(i<=k) 
			{
				driver4.findElement(By.name("addItem")).click();
			}
		}
		driver4.findElement(By.name("goToResultsBtn")).click();
		Thread.sleep(5000);
		String Apr = driver4.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[1]/div[8]")).getText();
		test3.log(LogStatus.PASS,"Loan APR Value :"+Apr);
		String DApr = driver4.findElement(By.xpath("//*[@id='maincontent']/result/div[2]/div[2]/div[2]/div[4]")).getText();
		test3.log(LogStatus.PASS,"Loan DAPR Value :"+DApr);
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
		test3.log(LogStatus.PASS,"APR Values Differnce:: "+Diff4);
		String status=null;
		if(Diff<=0.25 & Diff>=-0.25)
		{
			status="PASS";
			test3.log(LogStatus.PASS,"APR Value are equal ");
			//driver4.navigate().refresh();
		}
		else
		{
			status="FAIL";
			test3.log(LogStatus.FAIL,"APR Value are not equal ");
			//driver4.navigate().refresh();
		}
		content = content+"\n"+LoanCode+"_"+PayFrequency+"_"+NumberofInstallments+"_"+Loan_amt+"_"+Unit_days+"_"+APR+"_"+Apr+"_"+Diff+"_"+status;
		String path="D:\\Set4.txt"; 
		File file5 = new File(path);

        // If file doesn't exists, then create it
        if (!file5.exists()) {
            file5.createNewFile();
        }

        FileWriter fw5 = new FileWriter(file5.getAbsoluteFile());
        BufferedWriter bw5 = new BufferedWriter(fw5);

        // Write in file
        bw5.write(content);

        // Close connection
        bw5.close();
		reports4.endTest(test3);
		reports4.flush();
	}
		
}
	
	
	// Ending Test
			//reports4.endTest(test3);

			// writing everything into HTML report
			//reports4.flush();
			driver4.close();
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