package Sodexo.SodexoIndia;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifytheExceptionChecks {
public WebDriver driver;
	
	@Parameters({"URL", "username", "password" }) 
  @Test
  public void verifythechecks(String URL, String username, String password) throws InterruptedException {
	  //4.pdf for Individual Tax ID,GST Type, PO Check, HSN Code Check, Transaction Limit, GST Number Mismatch-NDF
	  //3.pdf for GST Number Mismatch-fail,Older Invoices, Gross Total, Duplicate Invoice
	  //2.pdf for missing data
	  //walson-bill.pdf for Invoice Year Check
	  WebDriverManager.chromedriver().setup();	
		Reporter.log("Verify the exception checks with the help of some invoices");
			
			//System.setProperty("webdriver.gecko.driver","C:/Selenium Documents/geckodriver.exe");
			//WebDriver driver=new FirefoxDriver();
			
		
			//System.setProperty("webdriver.ie.driver", "C:/Selenium Documents/IEDriverServer.exe");
			//WebDriver driver=new InternetExplorerDriver();
			
			 driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
			driver.findElement(By.xpath("//input[contains(@data-val-maxlength-max,'50')]")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains(@data-val-required,'Password is required.')]")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Sign in')]")).click();
			WebElement viewdoc = driver.findElement(By.xpath("//a[@href='/Manage/Invoices?q=All'][contains(.,'View Results')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", viewdoc);
			Thread.sleep(1500);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
			
			WebElement statuswrtsearch=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
			statuswrtsearch.click();
			Select optionsinstatus=new Select(statuswrtsearch);
			optionsinstatus.selectByVisibleText("Exceptions Alert");
			WebElement searchbyselect=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
			searchbyselect.click();
			Select optionsinserachby=new Select(searchbyselect);
			optionsinserachby.selectByVisibleText("Document Name");
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys("4.pdf");
			Thread.sleep(1500);
			/*driver.findElement(By.xpath("//input[@class='form-control search-fromDate bootDatePicker']")).click();
			driver.findElement(By.xpath("//td[contains(@class,'day active today')]")).click();
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-toDate bootDatePicker')]")).click();
			driver.findElement(By.xpath("//td[contains(@class,'day active today')]")).click();*/
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])[1]")).click();
			Thread.sleep(3000);
			/*WebElement vendorname=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[3]/div/div/div[2]/div/div/table/tbody/tr[2]/td[1]"));
			String suppliername=vendorname.getText();
			System.out.println(suppliername);
			WebElement MSupplier = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][contains(.,'Manage Suppliers')]"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", MSupplier);
			WebElement PSupplier = driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(.,'Published')]"));
			JavascriptExecutor executor11 = (JavascriptExecutor)driver;
			executor11.executeScript("arguments[0].click();", PSupplier);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(suppliername);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[@class='btn edit-btn'][contains(.,'View')])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//i[contains(@title,'Edit Transaction Limit')]")).click();
			Thread.sleep(1000);
			WebElement transaction=driver.findElement(By.xpath("//input[contains(@name,'TransactionLimit')]"));
			transaction.clear();
			transaction.sendKeys("10");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//i[@onclick='supplierProfile.onTransactionSave()']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Back')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//img[@src='/Content/img/view-result.svg']")).click();
			Thread.sleep(1000);
driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
Thread.sleep(1000);
			WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
			statuswrtsearch1.click();
			Select optionsinstatus1=new Select(statuswrtsearch1);
			Thread.sleep(1000);
			optionsinstatus1.selectByVisibleText("Not Synced");
			WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
			searchby.click();
			Select optionsinstatus2=new Select(searchby);
			optionsinstatus2.selectByVisibleText("Supplier Name");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(suppliername);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@href='javascript:'][contains(.,'View Approval')])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@type='button'][contains(.,'Edit')]")).click();
			Thread.sleep(3000);
			WebElement taxid=driver.findElement(By.xpath("(//input[contains(@type,'text')])[10]"));
			js. executeScript("arguments[0]. scrollIntoView(true);", taxid);
			String pan=taxid.getText();
			if(pan!=null)
			{
				taxid.clear();
			}
			Thread.sleep(3000);
			WebElement buyer=driver.findElement(By.xpath("(//input[contains(@type,'text')])[6]"));
			js. executeScript("arguments[0]. scrollIntoView(true);", buyer);
			String buyerGST=buyer.getText();
			if(buyerGST!=null)
			{
				buyer.clear();
			}	
			Thread.sleep(3000);
			WebElement vendor=driver.findElement(By.xpath("(//input[contains(@type,'text')])[9]"));
			js. executeScript("arguments[0]. scrollIntoView(true);", vendor);
			String vendorGST=vendor.getText();
			if(vendorGST!=null)
			{
				vendor.clear();
			}	
			Thread.sleep(3000);
			WebElement po=driver.findElement(By.xpath("(//input[contains(@type,'text')])[15]"));
			js. executeScript("arguments[0]. scrollIntoView(true);", po);
			String poval=po.getText();
			if(poval!=null)
			{
				po.clear();
			}	
			
			Thread.sleep(3000);
			WebElement hsn=driver.findElement(By.xpath("(//input[contains(@maxlength,'10')])[5]"));
			js. executeScript("arguments[0]. scrollIntoView(true);", hsn);
			String sac=hsn.getText();
			if(sac!=null)
			{
				hsn.clear();
			}
			Thread.sleep(3000);
			WebElement savebutton=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Save')]"));
			js.executeScript("window.scrollBy(0,-350)", "");
				savebutton.click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Yes')]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Ok')]")).click();
				Thread.sleep(3000);	*/
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'Transaction Limit')]")).isDisplayed());
			WebElement descriptionofTransaction=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[3]/td[3]"));
			String verifydesofTransaction=descriptionofTransaction.getText();
			Assert.assertEquals(verifydesofTransaction, "This invoice exceeds the transaction limit set for this supplier.");
			
			Assert.assertTrue(driver.findElement(By.xpath("(//td[contains(.,'Individual Tax ID')])")).isDisplayed());
			WebElement descriptionofpan=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[4]/td[3]"));
			String verifydesofpan=descriptionofpan.getText();
			Assert.assertEquals(verifydesofpan, "Checks for Individual Tax ID could not be performed due to missing data in the invoice.");
			
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'GST Type')]")).isDisplayed());
			WebElement descriptionofGSTType=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[5]/td[3]"));
			String verifydesofGSType=descriptionofGSTType.getText();
			Assert.assertEquals(verifydesofGSType, "Buyer & Supplier GST number missing.");
			
			WebElement poborder=driver.findElement(By.xpath("//td[contains(.,'PO Check')]"));
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'PO Check')]")).isDisplayed());
			JavascriptExecutor js1 =(JavascriptExecutor)driver;
	        js1.executeScript("arguments[0].style.border='5px dotted green'", poborder);
			WebElement descriptionofPOCheck=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[6]/td[3]"));
			String verifydesofPOCheck=descriptionofPOCheck.getText();
			Assert.assertEquals(verifydesofPOCheck, "No PO number found in the Invoice and in Access HR data");
			
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'HSN Code Check')]")).isDisplayed());
			WebElement descriptionofHSNCheck=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[7]/td[3]"));
			String verifydesofHSNCheck=descriptionofHSNCheck.getText();
			Assert.assertEquals(verifydesofHSNCheck, "HSN code is missing in Invoice.");
			
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'GST Number Mismatch')]")).isDisplayed());
			WebElement descriptionofGSTNOMismatchCheck=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[8]/td[3]"));
			String verifydesofGSTNOMismatchCheck=descriptionofGSTNOMismatchCheck.getText();
			Assert.assertEquals(verifydesofGSTNOMismatchCheck, "GST number missing in the invoice.");
						
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'Duplicate Invoice')]")).isDisplayed());
			WebElement descriptionofDuplicateCheck=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[9]/td[3]"));
			String verifydesofduplicateCheck=descriptionofDuplicateCheck.getText();
			Assert.assertEquals(verifydesofduplicateCheck, "Confirmed duplicate invoice found with the same invoice number 022/21; Invoice date; Currency and Amount");
			
			Thread.sleep(2500);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Back')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
			Thread.sleep(1500);
			WebElement statuswrtsearch11=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
			statuswrtsearch11.click();
			Select optionsinstatus11=new Select(statuswrtsearch11);
			optionsinstatus11.selectByVisibleText("Exceptions Alert");
			WebElement searchbyselect1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
			searchbyselect1.click();
			Select optionsinserachby1=new Select(searchbyselect1);
			optionsinserachby1.selectByVisibleText("Document Name");
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys("3.pdf");
			Thread.sleep(1500);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])[1]")).click();
			Thread.sleep(3000);
			
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'GST Type')]")).isDisplayed());
			WebElement descriptionofmissingdataCheck=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[3]/td[3]"));
				String verifydesofmissingdataCheck=descriptionofmissingdataCheck.getText();
				Assert.assertEquals(verifydesofmissingdataCheck, "IGST charged incorrectly as the buyer and the seller state is same.");
				
				
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'HSN Code Check')]")).isDisplayed());
			WebElement descriptionofHSNfailCheck=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[4]/td[3]"));
			String verifydesofHSNfailCheck=descriptionofHSNfailCheck.getText();
			Assert.assertEquals(verifydesofHSNfailCheck, "Incorrect HSN code in the invoice, exceeding 8 digits.");
			
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'GST Number Mismatch')]")).isDisplayed());
			WebElement descriptionofGSTNumberFail=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[5]/td[3]"));
			String verifydesofGSTNumberFail=descriptionofGSTNumberFail.getText();
			Assert.assertEquals(verifydesofGSTNumberFail, "Vendor name & Address mismatch with the supplier master data.");
			
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'Older Invoices')]")).isDisplayed());
			WebElement descriptionofOlderInvociesCheck=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[6]/td[3]"));
			String verifydesofOlderInvoicesCheck=descriptionofOlderInvociesCheck.getText();
			Assert.assertEquals(verifydesofOlderInvoicesCheck, "invoice is older than 6 months.");
			
			/*Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'Gross Total')]")).isDisplayed());
			WebElement descriptionofgrosstotalCheck=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[6]/td[3]"));
			String verifydesofgrosstotalCheck=descriptionofgrosstotalCheck.getText();
			Assert.assertEquals(verifydesofgrosstotalCheck, "Gross total mismatch");*/
			
			
			
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'Invoice Year Check')]")).isDisplayed());
			WebElement descriptionofyearCheck=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[7]/td[3]"));
			String verifydesofyearCheck=descriptionofyearCheck.getText();
			Assert.assertEquals(verifydesofyearCheck, "Uploaded invoice belongs to the previous financial year.");
			
			/*WebElement duplicateborder=driver.findElement(By.xpath("//td[contains(.,'Duplicate Invoice')]"));	
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'Duplicate Invoice')]")).isDisplayed());
			//JavascriptExecutor js1 =(JavascriptExecutor)driver;
	        js1.executeScript("arguments[0].style.border='5px dotted green'", duplicateborder);
		WebElement descriptionofduplicateCheck=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[9]/td[3]"));
			String verifydesofduplicateInvCheck=descriptionofduplicateCheck.getText();
			Assert.assertEquals(verifydesofduplicateInvCheck, "Confirmed duplicate invoice found with the same invoice number HB/KA/21-22/1130; Vendor number; Invoice date;Currency and Amount");*/
			Thread.sleep(2500);
		   
  }
	/*
	@Test
	public void exceptionchecks() throws InterruptedException
	{
		 WebDriverManager.chromedriver().setup();	
			Reporter.log("Verify the exception checks with the help of some invoices");
				
				//System.setProperty("webdriver.gecko.driver","C:/Selenium Documents/geckodriver.exe");
				//WebDriver driver=new FirefoxDriver();
				
			
				//System.setProperty("webdriver.ie.driver", "C:/Selenium Documents/IEDriverServer.exe");
				//WebDriver driver=new InternetExplorerDriver();
				
				 driver = new ChromeDriver();
				driver.get("https://pita.checkaninvoice.in");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			
				driver.findElement(By.xpath("//input[contains(@data-val-maxlength-max,'50')]")).sendKeys("sthakrey90@gmail.com");
				driver.findElement(By.xpath("//input[contains(@data-val-required,'Password is required.')]")).sendKeys("Asdf@1234");
				driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Sign in')]")).click();
				WebElement viewdoc = driver.findElement(By.xpath("//a[@href='/Manage/Invoices?q=All'][contains(.,'View Results')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", viewdoc);
				Thread.sleep(1500);
				
				driver.findElement(By.xpath("//button[contains(.,'List')]")).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
				
				WebElement statuswrtsearch=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
				statuswrtsearch.click();
				Select optionsinstatus=new Select(statuswrtsearch);
				optionsinstatus.selectByVisibleText("Exceptions Alert");
				Thread.sleep(1500);
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
				Thread.sleep(1500);
				WebElement getdocid=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[1]/div[1]/div/div/div[2]/div[3]/div/div[2]/div[2]/table/tbody/tr[1]/td[5]"));
				String documentid=getdocid.getText();
				driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@type='button'][contains(.,'Edit')]")).click();
				Thread.sleep(3000);
				WebElement buyername=driver.findElement(By.xpath("(//input[contains(@type,'text')])[4]"));
				buyername.clear();
				buyername.sendKeys("Sodexo Test India Services Pvt. ltd.");
				WebElement invdate=driver.findElement(By.xpath("(//input[contains(@type,'text')])[12]"));
				invdate.clear();
				invdate.sendKeys("01/01/2023");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Save')]")).click();
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
				
				WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
				statuswrtsearch1.click();
				Select optionsinstatus1=new Select(statuswrtsearch1);
				optionsinstatus1.selectByVisibleText("Exceptions Alert");
				Thread.sleep(1500);
				WebElement searchbyselect1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
				searchbyselect1.click();
				Select optionsinserachby1=new Select(searchbyselect1);
				optionsinserachby1.selectByVisibleText("Document Id");
				driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(documentid);
				Thread.sleep(1500);
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])[1]")).click();
				Thread.sleep(3000);
			for(int i=3;i<=21; i++)
				{
					WebElement getbuyername=driver.findElement(By.xpath("/html/body/div/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[i]/td[i-2]"));
					String incorrectbuyer=getbuyername.getText();
					Assert.assertEquals(incorrectbuyer, "Incorrect Buyer Name");
					break;
				}
			// /html/body/div/div/div/section[2]/div[1]/div/div/div[2]/div/div/table/tbody/tr[3]/td[3]
			
			
	}*/
 
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Verify the exception checks with the help of some invoices");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
      System.out.println("Pass");
	  driver.close();
	  System.out.println("finish");
  }
}