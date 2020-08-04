package pack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class Historyvalidation_LOC extends AA_LOC{
	public  static void Historyvalidation_LOC(String SSN,String FileName) throws Exception
	{
		String sheetName_calc="HistoryFieldsValidation";
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
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;
				
				String Expected_Payment_Method = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",6);
				String pay_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
				String Credit_Line = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",8);
				String Current_Principal_Balance = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",9);
				String Total_Owed = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",10);
				String Available_Credit = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",11);
				String Customar_Fee_Perday = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",12);
				String Line_Status = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",14);
				String Remaining_Payment_Amount = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",15);
				String Statement_Min_Payment_Amount = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",16);
				String Past_Due_Amount = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);
				String Payment_Status = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",19);
				String Loan_in_Cure_Period = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",20);
				String Cure_Amount = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",21);
				String Marked_For_Sale = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",22);
				String Pending_Bankruptcy = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",23);
				String Bankrupt = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",24);
				String LoanInRCC = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",25);
				String Interest_Per_Day  = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",26);
				
				
				String Transaction_Number=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
				String Transaction=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",3);
				String Transaction_Amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",4);
				String Advance_Amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",5);
				String Int_Amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",6);
				String Lien_Fee_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",7);
				String Mem_Fee_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",8);
				String Customary_Fee_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",9);
				String Remaining_Payment_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",10);
				String Late_Fee_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",11);
				String NSF_Fee_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",12);
				String Other_Fee_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",13);
				String Disb_Type=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",15);
				
				
				
				
				
				
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
				if(ProductID.equals("LOC"))
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
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[9]/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td[12]/table/tbody/tr/td[2]/input[1]")).click();
				test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
				test.log(LogStatus.PASS, "Start for HISTORY Fields Validation");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				String Customer = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[1]/td[1]/span[2]")).getText();
				test.log(LogStatus.PASS,"CustomerName is ::::"+Customer);

				String CustomerNumber = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[2]/td[1]/span[2]")).getText();

				test.log(LogStatus.PASS,"Customer Nbr is ::::"+CustomerNumber);
			
				
				String AcountNumber = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[3]/td[1]/span[2]")).getText();

				test.log(LogStatus.PASS,"Customer Nbr is ::::"+AcountNumber);

				String SSNNumber = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[4]/td[1]/a")).getText();

				test.log(LogStatus.PASS, "SSN / ITIN  is ::::"+SSNNumber);

				String ExpectedPaymentMethod = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[1]/td[2]/span[2]")).getText();

				if(Expected_Payment_Method.equalsIgnoreCase(ExpectedPaymentMethod))
				{
					test.log(LogStatus.PASS, "Expected_Payment_Method->Expected value:"+Expected_Payment_Method +"; == Actual value:"+ExpectedPaymentMethod);
				}
				else
				{
					test.log(LogStatus.FAIL, "Expected_Payment_Method->Expected value:"+Expected_Payment_Method +"; not equals to Actual value:"+ExpectedPaymentMethod);

				}


				String PayFrequency = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[1]/td[3]/span[2]")).getText();
				if(pay_frequency.equalsIgnoreCase(PayFrequency))
				{
					test.log(LogStatus.PASS, "pay_frequency->Expected value:"+pay_frequency +"; == Actual value:"+PayFrequency);
				}
				else
				{
					test.log(LogStatus.FAIL, "pay_frequency->Expected value:"+pay_frequency +"; not equals to Actual value:"+PayFrequency);

				}

				String CreditLine = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[5]/td[2]/span[2]")).getText();
				//String GrossPay1 =  "$"+" "+GrossPay;
				if(Credit_Line.equalsIgnoreCase(CreditLine))
				{
					test.log(LogStatus.PASS, "Credit_Line->Expected value:"+Credit_Line +"; == Actual value:"+CreditLine);
				}
				else
				{
					test.log(LogStatus.FAIL, "Credit_Line->Expected value:"+Credit_Line +"; not equals to Actual value:"+CreditLine);

				}

				                                                              
				String CurrentPrincipalBalance = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[6]/td[2]/span[2]")).getText();
				if(Current_Principal_Balance.equalsIgnoreCase(CurrentPrincipalBalance))
				{
					test.log(LogStatus.PASS, "Current_Principal_Balance->Expected value:"+Current_Principal_Balance +"; == Actual value:"+CurrentPrincipalBalance);
				}
				else
				{
					test.log(LogStatus.FAIL, "Current_Principal_Balance->Expected value:"+Current_Principal_Balance +"; not equals to Actual value:"+CurrentPrincipalBalance);

				}
				String TotalOwed = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[9]/td[2]/span[2]")).getText();
				if(Total_Owed.equalsIgnoreCase(TotalOwed))
				{
					test.log(LogStatus.PASS, "Total_Owed->Expected value:"+Total_Owed +"; == Actual value:"+TotalOwed);
				}
				else
				{
					test.log(LogStatus.FAIL, "Total_Owed->Expected value:"+Total_Owed +"; not equals to Actual value:"+TotalOwed);

				}
				String AvailableCredit = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[10]/td[2]/span[2]")).getText();
				if(Available_Credit.equalsIgnoreCase(AvailableCredit))
				{
					test.log(LogStatus.PASS, "Available_Credit->Expected value:"+Available_Credit +"; == Actual value:"+AvailableCredit);
				}
				else
				{
					test.log(LogStatus.FAIL, "Available_Credit->Expected value:"+Available_Credit +"; not equals to Actual value:"+AvailableCredit);

				}
				String CustomarFeePerday = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[3]/td[2]/span[2]")).getText();
				if(Customar_Fee_Perday.equalsIgnoreCase(CustomarFeePerday))
				{
					test.log(LogStatus.PASS, "Customar_Fee_Perday->Expected value:"+Customar_Fee_Perday +"; == Actual value:"+CustomarFeePerday);
				}
				else
				{
					test.log(LogStatus.FAIL, "Customar_Fee_Perday->Expected value:"+Customar_Fee_Perday +"; not equals to Actual value:"+CustomarFeePerday);

				}
				String InterestPerDay = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[4]/td[2]/span[2]")).getText();
				if(Interest_Per_Day.equalsIgnoreCase(InterestPerDay))
				{
					test.log(LogStatus.PASS, "Interest_Per_Day->Expected value:"+Interest_Per_Day +"; == Actual value:"+InterestPerDay);
				}
				else
				{
					test.log(LogStatus.FAIL, "Interest_Per_Day->Expected value:"+Interest_Per_Day +"; not equals to Actual value:"+InterestPerDay);

				}
				String NextStatementDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[11]/td[2]/span[2]")).getText();
				test.log(LogStatus.PASS,"NextStatement Date is ::::"+NextStatementDate);
				
				String LineStatus = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[12]/td[2]/span[2]")).getText();
				if(Line_Status.equalsIgnoreCase(LineStatus))
				{
					test.log(LogStatus.PASS, "Line_Status->Expected value:"+Line_Status +"; == Actual value:"+LineStatus);
				}
				else
				{
					test.log(LogStatus.FAIL, "Line_Status->Expected value:"+Line_Status +"; not equals to Actual value:"+LineStatus);

				}
				String RemainingPaymentAmount = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[2]/td[3]/span[2]")).getText();
				if(Remaining_Payment_Amount.equalsIgnoreCase(RemainingPaymentAmount))
				{
					test.log(LogStatus.PASS, "Remaining_Payment_Amount->Expected value:"+Remaining_Payment_Amount +"; == Actual value:"+RemainingPaymentAmount);
				}
				else
				{
					test.log(LogStatus.FAIL, "Remaining_Payment_Amount->Expected value:"+Remaining_Payment_Amount +"; not equals to Actual value:"+RemainingPaymentAmount);

				}
				
				String StatementMinPaymentAmount = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[3]/td[3]/span[2]")).getText();
				if(Statement_Min_Payment_Amount .equalsIgnoreCase(StatementMinPaymentAmount))
				{
					test.log(LogStatus.PASS, "Statement_Min_Payment_Amount ->Expected value:"+Statement_Min_Payment_Amount  +"; == Actual value:"+StatementMinPaymentAmount);
				}
				else
				{
					test.log(LogStatus.FAIL, "Statement_Min_Payment_Amount ->Expected value:"+Statement_Min_Payment_Amount  +"; not equals to Actual value:"+StatementMinPaymentAmount);

				}
				String DueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[4]/td[3]/span[2]")).getText();
				test.log(LogStatus.PASS,"DueDate  is ::::"+DueDate);
				
				String PastDueAmount = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[5]/td[3]/span[2]")).getText();
				if(Past_Due_Amount .equalsIgnoreCase(PastDueAmount))
				{
					test.log(LogStatus.PASS, "Past_Due_Amount->Expected value:"+Past_Due_Amount  +"; == Actual value:"+PastDueAmount);
				}
				else
				{
					test.log(LogStatus.FAIL, "Past_Due_Amount->Expected value:"+Past_Due_Amount  +"; not equals to Actual value:"+PastDueAmount);

				}
				
				String PaymentStatus = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[6]/td[3]/span[2]")).getText();
				if(Payment_Status .equalsIgnoreCase(PaymentStatus))
				{
					test.log(LogStatus.PASS, "Payment_Status ->Expected value:"+Payment_Status  +"; == Actual value:"+PaymentStatus);
				}
				else
				{
					test.log(LogStatus.FAIL, "Payment_Status ->Expected value:"+Payment_Status  +"; not equals to Actual value:"+PaymentStatus);

				}
				String LoaninCurePeriod = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[10]/td[3]/span[2]")).getText();
				if(Loan_in_Cure_Period .equalsIgnoreCase(LoaninCurePeriod))
				{
					test.log(LogStatus.PASS, "Loan_in_Cure_Period ->Expected value:"+Loan_in_Cure_Period  +"; == Actual value:"+LoaninCurePeriod);
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan_in_Cure_Period ->Expected value:"+Loan_in_Cure_Period  +"; not equals to Actual value:"+LoaninCurePeriod);

				}
				String CureAmount = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[12]/td[3]/span[2]")).getText();
				if(Cure_Amount .equalsIgnoreCase(CureAmount))
				{
					test.log(LogStatus.PASS, "Cure_Amount ->Expected value:"+Cure_Amount  +"; == Actual value:"+CureAmount);
				}
				else
				{
					test.log(LogStatus.FAIL, "Cure_Amount ->Expected value:"+Cure_Amount  +"; not equals to Actual value:"+CureAmount);

				}
				String MarkedForSale  = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[13]/td[3]/span[2]")).getText();
				if(Marked_For_Sale .equalsIgnoreCase(MarkedForSale))
				{
					test.log(LogStatus.PASS, "Marked_For_Sale ->Expected value:"+Marked_For_Sale  +"; == Actual value:"+MarkedForSale);
				}
				else
				{
					test.log(LogStatus.FAIL, "Marked_For_Sale ->Expected value:"+Marked_For_Sale  +"; not equals to Actual value:"+MarkedForSale);

				}
				String PendingBankruptcy = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[11]/td[1]/span[2]")).getText();
				if(Pending_Bankruptcy .equalsIgnoreCase(PendingBankruptcy))
				{
					test.log(LogStatus.PASS, "Pending_Bankruptcy ->Expected value:"+Pending_Bankruptcy  +"; == Actual value:"+PendingBankruptcy);
				}
				else
				{
					test.log(LogStatus.FAIL, "Pending_Bankruptcy ->Expected value:"+Pending_Bankruptcy  +"; not equals to Actual value:"+PendingBankruptcy);

				}
				String bankrupt = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[12]/td[1]/span[2]")).getText();
				
				if(Bankrupt .equalsIgnoreCase(bankrupt))
				{
					test.log(LogStatus.PASS, "Bankrupt ->Expected value:"+Bankrupt  +"; == Actual value:"+bankrupt);
				}
				else
				{
					test.log(LogStatus.FAIL, "Bankrupt ->Expected value:"+Bankrupt  +"; not equals to Actual value:"+bankrupt);

				}
				String LoaninRCC = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[13]/td[1]/span[2]")).getText();
				if(LoanInRCC  .equalsIgnoreCase(LoaninRCC))
				{
					test.log(LogStatus.PASS, "LoanInRCC  ->Expected value:"+LoanInRCC   +"; == Actual value:"+LoaninRCC);
				}
				else
				{
					test.log(LogStatus.FAIL, "LoanInRCC  ->Expected value:"+LoanInRCC   +"; not equals to Actual value:"+LoaninRCC);

				}
				
				
				//RevolvingCreditTransactionDetails
				
				List<WebElement>options = driver.findElements(By.xpath("//table[@id='revolvingCreditDetailsTable']/tbody/tr"));	///table/tbody/tr/td/table[2]
				int schsize = options.size();
				
				String TransactionNumber = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[2]")).getText();
				test.log(LogStatus.PASS,"Transaction Number is ::::"+TransactionNumber);
				
				String transaction = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[5]")).getText();
				if(Transaction   .equalsIgnoreCase(transaction))
				{
					test.log(LogStatus.PASS, "Transaction   ->Expected value:"+Transaction    +"; == Actual value:"+transaction);
				}
				else
				{
					test.log(LogStatus.FAIL, "Transaction   ->Expected value:"+Transaction    +"; not equals to Actual value:"+transaction);

				}
				String TransactionAmount = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[6]")).getText();
				if(Transaction_Amount  .equalsIgnoreCase(TransactionAmount))
				{
					test.log(LogStatus.PASS, "Transaction_Amount  ->Expected value:"+Transaction_Amount   +"; == Actual value:"+TransactionAmount);
				}
				else
				{
					test.log(LogStatus.FAIL, "Transaction_Amount  ->Expected value:"+Transaction_Amount   +"; not equals to Actual value:"+TransactionAmount);

				}
				String AdvanceAmount = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[7]")).getText();
				if(Advance_Amount  .equalsIgnoreCase(AdvanceAmount))
				{
					test.log(LogStatus.PASS, "Advance_Amount  ->Expected value:"+Advance_Amount   +"; == Actual value:"+AdvanceAmount);
				}
				else
				{
					test.log(LogStatus.FAIL, "Advance_Amount  ->Expected value:"+Advance_Amount   +"; not equals to Actual value:"+AdvanceAmount);

				}
				String IntAmount = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[8]")).getText();
				if(Int_Amount  .equalsIgnoreCase(IntAmount))
				{
					test.log(LogStatus.PASS, "Int_Amount  ->Expected value:"+Int_Amount   +"; == Actual value:"+IntAmount);
				}
				else
				{
					test.log(LogStatus.FAIL, "Int_Amount  ->Expected value:"+Int_Amount   +"; not equals to Actual value:"+IntAmount);

				}
				String LienFeeAmt = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[9]")).getText();
				if(Lien_Fee_Amt  .equalsIgnoreCase(LienFeeAmt))
				{
					test.log(LogStatus.PASS, "Lien_Fee_Amt  ->Expected value:"+Lien_Fee_Amt   +"; == Actual value:"+LienFeeAmt);
				}
				else
				{
					test.log(LogStatus.FAIL, "Lien_Fee_Amt  ->Expected value:"+Lien_Fee_Amt   +"; not equals to Actual value:"+LienFeeAmt);

				}
				String MemFeeAmt = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[10]")).getText();
				if(Mem_Fee_Amt  .equalsIgnoreCase(MemFeeAmt))
				{
					test.log(LogStatus.PASS, "Mem_Fee_Amt  ->Expected value:"+Mem_Fee_Amt   +"; == Actual value:"+MemFeeAmt);
				}
				else
				{
					test.log(LogStatus.FAIL, "Mem_Fee_Amt  ->Expected value:"+Mem_Fee_Amt   +"; not equals to Actual value:"+MemFeeAmt);

				}
				String CustomaryFeeAmt  = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[11]")).getText();
				if(Customary_Fee_Amt  .equalsIgnoreCase(CustomaryFeeAmt))
				{
					test.log(LogStatus.PASS, "Customary_Fee_Amt  ->Expected value:"+Customary_Fee_Amt   +"; == Actual value:"+CustomaryFeeAmt);
				}
				else
				{
					test.log(LogStatus.FAIL, "Customary_Fee_Amt  ->Expected value:"+Customary_Fee_Amt   +"; not equals to Actual value:"+CustomaryFeeAmt);

				}
				
				String RemainingPaymentAmt	 = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[12]")).getText();
				if(Remaining_Payment_Amt  .equalsIgnoreCase(RemainingPaymentAmt))
				{
					test.log(LogStatus.PASS, "Remaining_Payment_Amt  ->Expected value:"+Remaining_Payment_Amt   +"; == Actual value:"+RemainingPaymentAmt);
				}
				else
				{
					test.log(LogStatus.FAIL, "Remaining_Payment_Amt  ->Expected value:"+Remaining_Payment_Amt   +"; not equals to Actual value:"+RemainingPaymentAmt);

				}
				String LateFeeAmt	 = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[13]")).getText();
				if(Late_Fee_Amt  .equalsIgnoreCase(LateFeeAmt))
				{
					test.log(LogStatus.PASS, "Late_Fee_Amt  ->Expected value:"+Late_Fee_Amt   +"; == Actual value:"+LateFeeAmt);
				}
				else
				{
					test.log(LogStatus.FAIL, "Late_Fee_Amt  ->Expected value:"+Late_Fee_Amt   +"; not equals to Actual value:"+LateFeeAmt);

				}
				String NSFFeeAmt = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[14]")).getText();
				if(NSF_Fee_Amt  .equalsIgnoreCase(NSFFeeAmt))
				{
					test.log(LogStatus.PASS, "NSF_Fee_Amt  ->Expected value:"+NSF_Fee_Amt   +"; == Actual value:"+NSFFeeAmt);
				}
				else
				{
					test.log(LogStatus.FAIL, "NSF_Fee_Amt  ->Expected value:"+NSF_Fee_Amt   +"; not equals to Actual value:"+NSFFeeAmt);

				}
				String OtherFeeAmt	 = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[15]")).getText();
				if(Other_Fee_Amt  .equalsIgnoreCase(OtherFeeAmt))
				{
					test.log(LogStatus.PASS, "Other_Fee_Amt  ->Expected value:"+Other_Fee_Amt   +"; == Actual value:"+OtherFeeAmt);
				}
				else
				{
					test.log(LogStatus.FAIL, "Other_Fee_Amt  ->Expected value:"+Other_Fee_Amt   +"; not equals to Actual value:"+OtherFeeAmt);

				}
				String FundingDate	 = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[16]")).getText();
				test.log(LogStatus.PASS,"Funding Date  is ::::"+FundingDate);
				
				String DisbType = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+schsize+"]/td[17]")).getText();
				if(Disb_Type .equalsIgnoreCase(DisbType))
				{
					test.log(LogStatus.PASS, "Disb_Type  ->Expected value:"+Disb_Type   +"; == Actual value:"+DisbType);
				}
				else
				{
					test.log(LogStatus.FAIL, "Disb_Type  ->Expected value:"+Disb_Type   +"; not equals to Actual value:"+DisbType);

				}
				
				//*[@id="achHistoryTable"]
				List<WebElement>options1 = driver.findElements(By.xpath("//table[@id='achHistoryTable']/tbody/tr"));	///table/tbody/tr/td/table[2]
				int schsize1 = options1.size();

				if(ESign_CollateralType.equals("ACH"))
				{
					String ACHType = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr["+schsize1+"]/td[2]")).getText();

					if(ACH_type.equalsIgnoreCase(ACHType))
					{
						test.log(LogStatus.PASS, "ACH_type->Expected value:"+ACH_type +"; == Actual value:"+ACHType);
					}
					else
					{
						test.log(LogStatus.FAIL, "ACH_type->Expected value:"+ACH_type +"; not equals to Actual value:"+ACHType);	

					}

					String Transactions = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr["+schsize1+"]/td[3]")).getText();
					if(ACH_transaction.equalsIgnoreCase(Transactions))
					{
						test.log(LogStatus.PASS, "ACH_transaction->Expected value:"+ACH_transaction +"; == Actual value:"+Transactions);
					}
					else
					{
						test.log(LogStatus.FAIL, "ACH_transaction->Expected value:"+ACH_transaction +"; not equals to Actual value:"+Transactions);	

					}

					String ACHStatus = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr["+schsize1+"]/td[5]")).getText();
					if(ACH_status.equalsIgnoreCase(ACHStatus))
					{
						test.log(LogStatus.PASS, "ACH_status->Expected value:"+ACH_status +"; == Actual value:"+ACHStatus);
					}
					else
					{
						test.log(LogStatus.FAIL, "ACH_status->Expected value:"+ACH_status +"; not equals to Actual value:"+ACHStatus);	

					}
					String ACHAmt = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr["+schsize1+"]/td[6]")).getText();
					if(ACH_amount.equalsIgnoreCase(ACHAmt))
					{
						test.log(LogStatus.PASS, "ACH_amount->Expected value:"+ACH_amount +"; == Actual value:"+ACHAmt);
					}
					else
					{
						test.log(LogStatus.FAIL, "ACH_amount->Expected value:"+ACH_amount +"; not equals to Actual value:"+ACHAmt);	

					}

					String ABACode = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr["+schsize1+"]/td[7]")).getText();
					if(ACH_ABA_code.equalsIgnoreCase(ABACode))
					{
						test.log(LogStatus.PASS, "ABA_code->Expected value:"+ACH_ABA_code +"; == Actual value:"+ABACode);
					}
					else
					{
						test.log(LogStatus.FAIL, "ABA_code->Expected value:"+ACH_ABA_code +"; not equals to Actual value:"+ABACode);	

					}

					String CheckAcountNo = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr["+schsize1+"]/td[8]")).getText();
					test.log(LogStatus.PASS,"Check AcountNo   is ::::"+CheckAcountNo);
					
					String ACH_Code = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr["+schsize1+"]/td[1]")).getText();
					test.log(LogStatus.PASS,"ACH_Code   is ::::"+ACH_Code);
					
				}
			}
		}
	}
}
