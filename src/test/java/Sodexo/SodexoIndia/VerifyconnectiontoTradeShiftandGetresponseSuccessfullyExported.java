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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyconnectiontoTradeShiftandGetresponseSuccessfullyExported {
	public WebDriver driver;
	public String getdocid;
	@Parameters({"username", "password", "URL" }) 
	 @BeforeTest
	  public void beforeTest(String username, String password, String URL) {
		  
		  System.out.println("Verify the connect page and approve the exception and get message successfully exported");
		  WebDriverManager.chromedriver().setup();	
			Reporter.log("Verify the connect page and approve the exception and get message successfully exported");
			   driver = new ChromeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			
				driver.findElement(By.xpath("//input[contains(@data-val-maxlength-max,'50')]")).sendKeys(username);
				driver.findElement(By.xpath("//input[contains(@data-val-required,'Password is required.')]")).sendKeys(password);
				driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Sign in')]")).click();
	  }
	
  @Test //(dataProvider = "dp")
  public void a_VerifyconnectiontoTradeShift() throws InterruptedException {
	 
			Thread.sleep(2500);
		/*	WebElement companysel=driver.findElement(By.xpath("/html/body/nav/ul/li[1]/div/select"));
			companysel.click();
			Select SAPoptionsinstatus=new Select(companysel);
			SAPoptionsinstatus.selectByVisibleText("Admin test");*/
	
			WebElement accountsystem = driver.findElement(By.xpath("//span[contains(.,'Accounting System')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", accountsystem);
			driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(.,'Connect')]")).click();
			Thread.sleep(2000);
			WebElement gettextofconnect=driver.findElement(By.xpath("//p[contains(@class,'ErpTitle')]"));
			String savetext=gettextofconnect.getText();
			Assert.assertTrue(savetext.equalsIgnoreCase("You are connected to Tradeshift"));
			Thread.sleep(2000);
  }
  @Test //(dataProvider = "dp")
  public void b_ApprovetheExceptionafteredit() throws InterruptedException {
	 
			driver.findElement(By.xpath("//img[@src='/Content/img/view-result.svg']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(.,'List')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
			
			WebElement statuswrtsearch=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
			statuswrtsearch.click();
			Select optionsinstatus=new Select(statuswrtsearch);
			optionsinstatus.selectByVisibleText("Exceptions Alert");
			WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
			searchby.click();
			Select optionsinstatus2=new Select(searchby);
			optionsinstatus2.selectByVisibleText("Buyer Name");
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys("Sodexo");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(1500);
			WebElement capturedocid=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[5]"));
			String getdocid=capturedocid.getText();
			System.out.println("Doc id:-"+getdocid);
			driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])[1]")).click();
			driver.findElement(By.xpath("//a[@type='button'][contains(.,'Edit')]")).click();
			Thread.sleep(3000);
			WebElement innertext=driver.findElement(By.xpath("(//input[@type='text'])[3]"));
				//innertext.click();
				String invoiceno=innertext.getAttribute("value");
				System.out.println("Invoice Number:"+invoiceno);
				Thread.sleep(1000);
				WebElement buyername=driver.findElement(By.xpath("//input[contains(@data-index,'3')]"));
				buyername.clear();
				Thread.sleep(1000);
				buyername.sendKeys("M/s. Sodexo India Services Private. Limited");
				buyername.click();
				//Thread.sleep(1000);
				WebElement savebutton=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Save')]"));
				//	js. executeScript("arguments[0]. scrollIntoView(true);", savebutton);
					savebutton.click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[@type='button'][contains(.,'Yes')]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[@type='button'][contains(.,'Ok')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
					
					WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
					statuswrtsearch1.click();
					Select optionsinstatus1=new Select(statuswrtsearch1);
					optionsinstatus1.selectByVisibleText("Exceptions Alert");
					/*WebElement searchby1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
					searchby1.click();
					Select optionsinstatus21=new Select(searchby1);
					optionsinstatus21.selectByVisibleText("Document ID");
					driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(getdocid);*/
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(@data-target,'Approved')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm')]")).click();
			Thread.sleep(3000);
			WebElement okonpopup=driver.findElement(By.xpath("//button[@type='button'][contains(.,'OK')]"));
			okonpopup.click();
			Thread.sleep(3000);
  }
  @Test //(dataProvider = "dp")
  public void c_getresponsesuccessfullyexported() throws InterruptedException {
	 
  
		//	driver.findElement(By.xpath("//button[@data-view='card']")).click();
			driver.navigate().refresh();
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
			Thread.sleep(3000);
			WebElement statuswrtsearch11=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
			statuswrtsearch11.click();
			Select optionsinstatus11=new Select(statuswrtsearch11);
			optionsinstatus11.selectByVisibleText("Exceptions Approved");
			Thread.sleep(1500);
			/*WebElement searchbyselect=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
			searchbyselect.click();
			Select optionsinserachby=new Select(searchbyselect);
			optionsinserachby.selectByVisibleText("Document ID");
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(getdocid);*/
			Thread.sleep(3500);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(1500);
			WebElement ele=driver.findElement(By.xpath("//th[contains(.,'Sync Status')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].scrollIntoView();",ele );
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[20]/span[1]")).getText(), "Successfully Exported");
			//driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions App')])[1]")).click();*/
			/*WebElement auditlogs = driver.findElement(By.xpath("//a[contains(.,'Audit Logs')]"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", auditlogs);
			driver.findElement(By.xpath("//a[contains(.,'Audit Logs')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[contains(.,'Accounting System Audit')]")).click();
			Thread.sleep(2500);
			WebElement verifylog=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[3]"));
			String textoflogs=verifylog.getText();
			System.out.println(textoflogs);
			Assert.assertEquals("Bill Exported Successfully, Invoice /"+invoiceno+"", textoflogs);
			Thread.sleep(2500);*/
			Thread.sleep(3000);
		     
  }



 

  @AfterTest
  public void afterTest() {
	  driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
      System.out.println("Pass");
	  driver.close();
	  System.out.println("finish");
  }
  
  }

