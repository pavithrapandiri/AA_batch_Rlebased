
package pack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class HistoryFieldValidation_ILP extends AA_CO_ILP{
	public  static void HistoryFieldValidation_ILP(String SSN,String FileName) throws Exception
	{
		//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_PDL_path_Pavitra") + FileName);  

		String sheetName_calc="HistoryFieldsValidation";
		String sheetName_new_loan="NewLoan";

		//String sheetName="NewLoan";
		test.log(LogStatus.INFO, "Admin Checks");

		int lastrow=TestData.getLastRow("NewLoan");
		System.out.println("NewLoan "+lastrow);
		String sheetName="NewLoan";		
		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String TxnType=TestData.getCellData(sheetName,"TxnType",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);	
				String ProductID=TestData.getCellData(sheetName,"ProductID",row);
				String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
				String StoreId = TestData.getCellData(sheetName,"StoreID",row); 
				String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
	            String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);		           		            		            
	            String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;
	          //Transaction History
	            String pay_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",4);
				String loan_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",5);
				String loan_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",6);
 				String Number_Of_Insatallments=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
                String Remaining_Insatallments=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",8);  
                String interest_fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",9);
                String Next_Payment_Amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",10);
                String origination_fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",11);
                String Remaining_Payment_Amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",12);
                String Monthly_Handling_Fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",13);
                String Past_Due_AMT=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",14);
                String CSO_Fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",15);
                String Payment_Status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",16);
                String apr=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",17);
                String collateral=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);
                String Expected_Payment_Method=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",19);
                String Cure_Amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",20);
                String Return_Fee_Due=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",21);
                String Late_Fee_Due=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",22);
                String Current_principal_balance=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",23);
                String Total_Owed=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",24);
                String pay_off_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",25);
                String verification_fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",26);
                String verification_fee_Paid=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",27);
                //Transaction Details
                String transaction=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",3);
                String Total_Amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",4);
                String Tender_Type=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",5);
                String Installment_No=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",6);
                String advance_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",7);
                String Interest_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",8);
                String New_balance=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",9);
                String NSF_Fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",10);
                String Waived_NSF_Fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",11);
                String Late_Fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",12);
                String Waived_Late_Fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",13);
                String Other_Fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",14);
                String MHC_Fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",15);     
                String Promotions_Coupn_AMT=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",16);
                //ACH Table
                String ACH_type=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",2);
			    String ACH_transaction=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",3);
			    String ACH_status=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",4);
			    String ACH_amount=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",5);
			    String ACH_ABA_code=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",6);
			    String ACH_check_acc_no=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",7);
			       

				System.out.println(AdminURL);
				test.log(LogStatus.INFO, "Scheduler-Store Aging");
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(2000);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				test.log(LogStatus.PASS, "Clicked on Transactions");		
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
				if(ProductID.equals("ILP"))
				{

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				}
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("History");
				test.log(LogStatus.PASS, "In Transaction selected List HISTORY as selecte");
				driver.findElement(By.xpath("//*[@id='go_Button']")).click();
				test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
				//test.log(LogStatus.PASS, "Start for HISTORY Fields Validation");
				test.log(LogStatus.INFO,"<FONT color=green style=Arial>Start for HISTORY Fields Validation ::::");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				//Transaction History
				
				String Customer = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[1]/td/span[2]/span")).getText();
				test.log(LogStatus.PASS,"CustomerName is ::::"+Customer);
				           
				String CustomerNumber = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[2]/td/span[2]/span")).getText();
				
				test.log(LogStatus.PASS,"Customer Nbr is ::::"+CustomerNumber);
				
                String LoanNumber = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[3]/td/span[2]")).getText();
				
				test.log(LogStatus.PASS,"Loan Nbr is ::::"+LoanNumber);
				
				
				
				String PayFrequency = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[1]/td/span[2]")).getText();

				if(pay_frequency.equalsIgnoreCase(PayFrequency))
				{
					test.log(LogStatus.PASS, "pay_frequency->Expected value:"+pay_frequency +"; == Actual value:"+PayFrequency);
				}
				else
				{
					test.log(LogStatus.FAIL, "pay_frequency->Expected value:"+pay_frequency +"; not equals to Actual value:"+PayFrequency);

				}

				String LoanStatus = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[1]/td/span[2]")).getText();

				if(loan_status.equalsIgnoreCase(LoanStatus))
				{
					test.log(LogStatus.PASS, "loan_status->Expected value:"+loan_status +"; == Actual value:"+LoanStatus);
				}
				else
				{
					test.log(LogStatus.FAIL, "loan_status->Expected value:"+loan_status +"; not equals to Actual value:"+LoanStatus);

				}

				String SSNNumber = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[4]/td/span[2]/span")).getText();

				test.log(LogStatus.PASS, "SSN / ITIN  is ::::"+SSNNumber);
				
				String LoanDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[2]/td/span[2]")).getText();

		        test.log(LogStatus.PASS,"Loan Date   is ::::"+LoanDate);
		        
		        String NumberOfInstallments = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();
		        if(Number_Of_Insatallments.equalsIgnoreCase(NumberOfInstallments))
				{
					test.log(LogStatus.PASS, "Number_Of_Insatallments->Expected value:"+Number_Of_Insatallments +"; == Actual value:"+NumberOfInstallments);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number_Of_Insatallments->Expected value:"+Number_Of_Insatallments +"; not equals to Actual value:"+NumberOfInstallments);

				}
		        
		        String EffectiveDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[3]/td/span[2]")).getText();

		        test.log(LogStatus.PASS,"EffectiveDate   is ::::"+EffectiveDate);
		        
		        String RemainingInstallments = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();
		        if(Remaining_Insatallments.equalsIgnoreCase(NumberOfInstallments))
				{
					test.log(LogStatus.PASS, "Remaining_Insatallments->Expected value:"+Remaining_Insatallments +"; == Actual value:"+RemainingInstallments);
				}
				else
				{
					test.log(LogStatus.FAIL, "Remaining_Insatallments->Expected value:"+Remaining_Insatallments +"; not equals to Actual value:"+RemainingInstallments);

				}
		        String LoanAmount = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[4]/td/span[2]")).getText();

				if(loan_amount.equalsIgnoreCase(LoanAmount))
				{
					test.log(LogStatus.PASS, "loan_amount->Expected value:"+loan_amount +"; == Actual value:"+LoanAmount);
				}
				else
				{
					test.log(LogStatus.FAIL, "loan_amount->Expected value:"+loan_amount +"; not equals to Actual value:"+LoanAmount);

				}
				String NextDueDate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();

		        test.log(LogStatus.PASS,"NextDueDate   is ::::"+NextDueDate);
		        String InterestFee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[5]/td/span[2]")).getText();
				if(interest_fee.equalsIgnoreCase(InterestFee))
				{
					test.log(LogStatus.PASS, "interest_fee->Expected value:"+interest_fee +"; == Actual value:"+InterestFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "interest_fee->Expected value:"+interest_fee +"; not equals to Actual value:"+InterestFee);	

				}
				String NextPaymentAMT = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[5]/td/span[2]")).getText();
				
				if(Next_Payment_Amount.equalsIgnoreCase(NextPaymentAMT))
				{
					test.log(LogStatus.PASS, "Next_Payment_Amount->Expected value:"+Next_Payment_Amount +"; == Actual value:"+NextPaymentAMT);
				}
				else
				{
					test.log(LogStatus.FAIL, "Next_Payment_Amount->Expected value:"+Next_Payment_Amount +"; not equals to Actual value:"+NextPaymentAMT);	

				}
																			
				String OriginationFee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[6]/td/span[2]")).getText();
				if(origination_fee.equalsIgnoreCase(OriginationFee))
				{
					test.log(LogStatus.PASS, "origination_fee->Expected value:"+origination_fee +"; == Actual value:"+OriginationFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "origination_fee->Expected value:"+origination_fee +"; not equals to Actual value:"+OriginationFee);	

				}
				String RemainingPaymentAmount = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[6]/td/span[2]")).getText();
				if(Remaining_Payment_Amount.equalsIgnoreCase(RemainingPaymentAmount))
				{
					test.log(LogStatus.PASS, "Remaining_Payment_Amount->Expected value:"+Remaining_Payment_Amount +"; == Actual value:"+RemainingPaymentAmount);
				}
				else
				{
					test.log(LogStatus.FAIL, "Remaining_Payment_Amount->Expected value:"+Remaining_Payment_Amount +"; not equals to Actual value:"+RemainingPaymentAmount);	

				}
				
				String MonthlyHandlingFee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[7]/td/span[2]")).getText();
				if(Monthly_Handling_Fee.equalsIgnoreCase(MonthlyHandlingFee))
				{
					test.log(LogStatus.PASS, "Monthly_Handling_Fee->Expected value:"+Monthly_Handling_Fee +"; == Actual value:"+MonthlyHandlingFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "Monthly_Handling_Fee->Expected value:"+Monthly_Handling_Fee +"; not equals to Actual value:"+MonthlyHandlingFee);	

				}
				String PastDueAMT = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[7]/td/span[2]")).getText();
				if(Past_Due_AMT.equalsIgnoreCase(PastDueAMT))
				{
					test.log(LogStatus.PASS, "Past_Due_AMT->Expected value:"+Past_Due_AMT +"; == Actual value:"+PastDueAMT);
				}
				else
				{
					test.log(LogStatus.FAIL, "Past_Due_AMT->Expected value:"+Past_Due_AMT +"; not equals to Actual value:"+PastDueAMT);	

				}
				String CSOFee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[8]/td/span[2]")).getText();
				if(CSO_Fee.equalsIgnoreCase(CSOFee))
				{
					test.log(LogStatus.PASS, "CSO_Fee->Expected value:"+CSO_Fee +"; == Actual value:"+CSOFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "CSO_Fee->Expected value:"+CSO_Fee +"; not equals to Actual value:"+CSOFee);	

				}
				String PaymentStatus = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[8]/td/span[2]")).getText();
				if(Payment_Status.equalsIgnoreCase(PaymentStatus))
				{
					test.log(LogStatus.PASS, "Payment_Status->Expected value:"+Payment_Status +"; == Actual value:"+PaymentStatus);
				}
				else
				{
					test.log(LogStatus.FAIL, "Payment_Status->Expected value:"+Payment_Status +"; not equals to Actual value:"+PaymentStatus);	

				}
				String APR = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[9]/td/span[2]")).getText();

				if(apr.equalsIgnoreCase(APR))
				{
					test.log(LogStatus.PASS, "apr->Expected value:"+apr +"; == Actual value:"+APR);
				}
				else
				{
					test.log(LogStatus.FAIL, "apr->Expected value:"+apr +"; not equals to Actual value:"+APR);

				}
				String Collateral = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[10]/td/span[2]")).getText();
				if(collateral.equalsIgnoreCase(Collateral))
				{
					test.log(LogStatus.PASS, "collateral->Expected value:"+collateral +"; == Actual value:"+Collateral);
				}
				else
				{
					test.log(LogStatus.FAIL, "collateral->Expected value:"+collateral +"; not equals to Actual value:"+Collateral);

				}
				String ExpectedPaymentMethod = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[11]/td/span[2]")).getText();
				if(Expected_Payment_Method.equalsIgnoreCase(ExpectedPaymentMethod))
				{
					test.log(LogStatus.PASS, "Expected_Payment_Method->Expected value:"+Expected_Payment_Method +"; == Actual value:"+ExpectedPaymentMethod);
				}
				else
				{
					test.log(LogStatus.FAIL, "Expected_Payment_Method->Expected value:"+Expected_Payment_Method +"; not equals to Actual value:"+ExpectedPaymentMethod);

				}
				String CureAMT = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[12]/td/span[2]")).getText();
				if(Cure_Amount.equalsIgnoreCase(CureAMT))
				{
					test.log(LogStatus.PASS, "Cure_Amount->Expected value:"+Cure_Amount +"; == Actual value:"+CureAMT);
				}
				else
				{
					test.log(LogStatus.FAIL, "Cure_Amount->Expected value:"+Cure_Amount +"; not equals to Actual value:"+CureAMT);

				}
				String ReturnFeeDue = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[13]/td/span[2]")).getText();
				if(Return_Fee_Due.equalsIgnoreCase(ReturnFeeDue))
				{
					test.log(LogStatus.PASS, "Return_Fee_Due->Expected value:"+Return_Fee_Due +"; == Actual value:"+ReturnFeeDue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Return_Fee_Due->Expected value:"+Return_Fee_Due +"; not equals to Actual value:"+ReturnFeeDue);

				}
				String LateFeeDue = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[14]/td/span[2]")).getText();
				if(Late_Fee_Due.equalsIgnoreCase(LateFeeDue))
				{
					test.log(LogStatus.PASS, "Late_Fee_Due->Expected value:"+Late_Fee_Due +"; == Actual value:"+LateFeeDue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Late_Fee_Due->Expected value:"+Late_Fee_Due +"; not equals to Actual value:"+LateFeeDue);

				}
				
				
				String CurrentPrincipalBalance = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[15]/td/span[2]")).getText();

				if(Current_principal_balance.equalsIgnoreCase(CurrentPrincipalBalance))
				{
					test.log(LogStatus.PASS, "Current_principal_balance->Expected value:"+Current_principal_balance +"; == Actual value:"+CurrentPrincipalBalance);
				}
				else
				{
					test.log(LogStatus.FAIL, "Current_principal_balance->Expected value:"+Current_principal_balance +"; not equals to Actual value:"+CurrentPrincipalBalance);

				}
				
				String TotalOwed = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[16]/td/span[2]")).getText();
				if(Total_Owed.equalsIgnoreCase(TotalOwed))
				{
					test.log(LogStatus.PASS, "Total_Owed->Expected value:"+Total_Owed +"; == Actual value:"+TotalOwed);
				}
				else
				{
					test.log(LogStatus.FAIL, "Total_Owed->Expected value:"+Total_Owed +"; not equals to Actual value:"+TotalOwed);

				}
				
				String PayOffAMT = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[17]/td/span[2]")).getText();
				if(pay_off_amount.equalsIgnoreCase(PayOffAMT))
				{
					test.log(LogStatus.PASS, "pay_off_amount->Expected value:"+pay_off_amount +"; == Actual value:"+PayOffAMT);
				}
				else
				{
					test.log(LogStatus.FAIL, "pay_off_amount->Expected value:"+pay_off_amount +"; not equals to Actual value:"+PayOffAMT);

				}
				
				
				String VerificationFee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[17]/td/span[2]")).getText();
				if(verification_fee.equalsIgnoreCase(VerificationFee))
				{
					test.log(LogStatus.PASS, "verification_fee->Expected value:"+verification_fee +"; == Actual value:"+VerificationFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "verification_fee->Expected value:"+verification_fee +"; not equals to Actual value:"+VerificationFee);	

				}
				
				String VerificationFeePaid = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[18]/td/span[2]")).getText();
		    	if(verification_fee_Paid.equalsIgnoreCase(VerificationFeePaid))
				{
					test.log(LogStatus.PASS, "verification_feePaid->Expected value:"+verification_fee +"; == Actual value:"+VerificationFeePaid);
				}
				else
				{
					test.log(LogStatus.FAIL, "verification_feepaid->Expected value:"+verification_fee +"; not equals to Actual value:"+VerificationFeePaid);	

				}
		    	test.log(LogStatus.INFO,"<FONT color=green style=Arial>Transaction Detailes ::::");
		    	List<WebElement>options = driver.findElements(By.xpath("//table[@id='transactionDetailsTable']/tbody/tr"));	///table/tbody/tr/td/table[2] 
		    	int schsize = options.size();
		    	    schsize = schsize-1;
				String Transaction = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[5]/font")).getText();
				if(transaction.equalsIgnoreCase(Transaction))
				{
					test.log(LogStatus.PASS, "transaction->Expected value:"+transaction +"; == Actual value:"+Transaction);
				}
				else
				{
					test.log(LogStatus.FAIL, "transaction->Expected value:"+transaction +"; not equals to Actual value:"+Transaction);	

				}
				String TotalAMT = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[6]/font")).getText();
				if(Total_Amount.equalsIgnoreCase(TotalAMT))
				{
					test.log(LogStatus.PASS, "Total_Amount->Expected value:"+Total_Amount +"; == Actual value:"+TotalAMT);
				}
				else
				{
					test.log(LogStatus.FAIL, "Total_Amount->Expected value:"+Total_Amount +"; not equals to Actual value:"+TotalAMT);	

				}
				String tenderType = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[7]/font")).getText();
				if(Tender_Type.equalsIgnoreCase(tenderType))
				{
					test.log(LogStatus.PASS, "Tender_Type->Expected value:"+Tender_Type +"; == Actual value:"+tenderType);
				}
				else
				{
					test.log(LogStatus.FAIL, "Tender_Type->Expected value:"+Tender_Type +"; not equals to Actual value:"+tenderType);	

				}
				
				String Installments = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[8]/font")).getText();
				if(Installment_No.equalsIgnoreCase(Installments))
				{
					test.log(LogStatus.PASS, "Installment_No->Expected value:"+Installment_No +"; == Actual value:"+Installments);
				}
				else
				{
					test.log(LogStatus.FAIL, "Installment_No->Expected value:"+Installment_No +"; not equals to Actual value:"+Installments);	

				}
				
				String AdvanceAMT = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[9]/font")).getText();
				if(advance_amount.equalsIgnoreCase(AdvanceAMT))
				{
					test.log(LogStatus.PASS, "advance_amount->Expected value:"+advance_amount +"; == Actual value:"+AdvanceAMT);
				}
				else
				{
					test.log(LogStatus.FAIL, "advance_amount->Expected value:"+advance_amount +"; not equals to Actual value:"+AdvanceAMT);	

				}
				
				String Interest = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[10]/font")).getText();
				if(Interest_amount.equalsIgnoreCase(Interest))
				{
					test.log(LogStatus.PASS, "Interest_amount->Expected value:"+Interest_amount +"; == Actual value:"+Interest);
				}
				else
				{
					test.log(LogStatus.FAIL, "Interest_amount->Expected value:"+Interest_amount +"; not equals to Actual value:"+Interest);	

				}
				
				String NsfFee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[11]/font")).getText();
				if(NSF_Fee.equalsIgnoreCase(NsfFee))
				{
					test.log(LogStatus.PASS, "NSF_Fee->Expected value:"+NSF_Fee +"; == Actual value:"+NsfFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "NSF_Fee->Expected value:"+NSF_Fee +"; not equals to Actual value:"+NsfFee);	

				}
				                                                   
				String WaivedNsfFee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[12]/font")).getText();
				if(Waived_NSF_Fee.equalsIgnoreCase(WaivedNsfFee))
				{
					test.log(LogStatus.PASS, "Waived_NSF_Fee->Expected value:"+Waived_NSF_Fee +"; == Actual value:"+WaivedNsfFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "Waived_NSF_Fee->Expected value:"+Waived_NSF_Fee +"; not equals to Actual value:"+WaivedNsfFee);	

				}
				String LateFee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[13]/font")).getText();
				if(Late_Fee.equalsIgnoreCase(LateFee))
				{
					test.log(LogStatus.PASS, "Late_Fee->Expected value:"+Late_Fee +"; == Actual value:"+LateFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "Late_Fee->Expected value:"+Late_Fee +"; not equals to Actual value:"+LateFee);	

				}
				
				String WaivedLateFee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[14]/font")).getText();
				if(Waived_Late_Fee.equalsIgnoreCase(WaivedLateFee))
				{
					test.log(LogStatus.PASS, "Waived_Late_Fee->Expected value:"+Waived_Late_Fee +"; == Actual value:"+WaivedLateFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "Waived_Late_Fee->Expected value:"+Waived_Late_Fee +"; not equals to Actual value:"+WaivedLateFee);	

				}
				String OtherFee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[15]")).getText();
				if(Other_Fee.equalsIgnoreCase(OtherFee))
				{
					test.log(LogStatus.PASS, "Other_Fee->Expected value:"+Other_Fee +"; == Actual value:"+OtherFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "Other_Fee->Expected value:"+Other_Fee +"; not equals to Actual value:"+OtherFee);	

				}
				String MHCFee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[16]/font")).getText();
				if(MHC_Fee.equalsIgnoreCase(MHCFee))
				{
					test.log(LogStatus.PASS, "MHC_Fee->Expected value:"+MHC_Fee +"; == Actual value:"+MHCFee);
				}
				else
				{
					test.log(LogStatus.FAIL, "MHC_Fee->Expected value:"+MHC_Fee +"; not equals to Actual value:"+MHCFee);	

				}
				
				String Newbalance = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[19]/font")).getText();
				if(New_balance.equalsIgnoreCase(Newbalance))
				{
					test.log(LogStatus.PASS, "New_balance->Expected value:"+New_balance +"; == Actual value:"+Newbalance);
				}
				else
				{
					test.log(LogStatus.FAIL, "New_balance->Expected value:"+New_balance +"; not equals to Actual value:"+Newbalance);	

				}
				String Promotions = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+schsize+"]/td[20]/font")).getText();
				if(Promotions_Coupn_AMT.equalsIgnoreCase(Promotions))
				{
					test.log(LogStatus.PASS, "Promotions_Coupn_AMT->Expected value:"+Promotions_Coupn_AMT +"; == Actual value:"+Promotions);
				}
				else
				{
					test.log(LogStatus.FAIL, "Promotions_Coupn_AMT->Expected value:"+Promotions_Coupn_AMT +"; not equals to Actual value:"+Promotions);	

				}
				//}
				//ACH History
				if(ESign_CollateralType.equals("ACH"))
				{
					test.log(LogStatus.INFO,"<FONT color=green style=Arial>ACH History Detailes ::::");
					String ACHCode = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[1]")).getText();	
					test.log(LogStatus.PASS, "ACHCode is :::"+ACHCode);
					
					String InstallmentNbr = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[2]")).getText();	
					test.log(LogStatus.PASS, "InstallmentNbr is :::"+InstallmentNbr);
					
					
					String ACHType = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[3]")).getText();
					
					if(ACH_type.equalsIgnoreCase(ACHType))
					{
						test.log(LogStatus.PASS, "ACH_type->Expected value:"+ACH_type +"; == Actual value:"+ACHType);
					}
					else
					{
						test.log(LogStatus.FAIL, "ACH_type->Expected value:"+ACH_type +"; not equals to Actual value:"+ACHType);	

					}
					
					String Transactions = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[4]")).getText();
					if(ACH_transaction.equalsIgnoreCase(Transactions))
					{
						test.log(LogStatus.PASS, "ACH_transaction->Expected value:"+ACH_transaction +"; == Actual value:"+Transactions);
					}
					else
					{
						test.log(LogStatus.FAIL, "ACH_transaction->Expected value:"+ACH_transaction +"; not equals to Actual value:"+Transactions);	

					}
					
					String ACHStatus = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[6]")).getText();
					if(ACH_status.equalsIgnoreCase(ACHStatus))
					{
						test.log(LogStatus.PASS, "ACH_status->Expected value:"+ACH_status +"; == Actual value:"+ACHStatus);
					}
					else
					{
						test.log(LogStatus.FAIL, "ACH_status->Expected value:"+ACH_status +"; not equals to Actual value:"+ACHStatus);	

					}
					String ACHAmt = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[7]")).getText();
					if(ACH_amount.equalsIgnoreCase(ACHAmt))
					{
						test.log(LogStatus.PASS, "ACH_amount->Expected value:"+ACH_amount +"; == Actual value:"+ACHAmt);
					}
					else
					{
						test.log(LogStatus.FAIL, "ACH_amount->Expected value:"+ACH_amount +"; not equals to Actual value:"+ACHAmt);	

					}
					
					String ABACode = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[8]")).getText();
					if(ACH_ABA_code.equalsIgnoreCase(ABACode))
					{
						test.log(LogStatus.PASS, "ACH_ABA_code->Expected value:"+ACH_ABA_code +"; == Actual value:"+ABACode);
					}
					else
					{
						test.log(LogStatus.FAIL, "ACH_ABA_code->Expected value:"+ACH_ABA_code +"; not equals to Actual value:"+ABACode);	

					}
					
					String CheckAcountNo = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[9]")).getText();
					test.log(LogStatus.PASS, "CheckAcountNo :::"+CheckAcountNo);
					String ACHEffectivedate = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[2]/td[5]")).getText();
					test.log(LogStatus.PASS, "ACHEffectivedate :::"+ACHEffectivedate);
				}
			}
				
		}
				
	}	
	
}
