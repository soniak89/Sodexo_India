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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RejecttheInvoicewithReason {
	public WebDriver driver;
	@Parameters({"username", "password", "URL"}) 

@BeforeTest
public void beforeTest(String username, String password,String URL) {
	  //System.out.println("Reject the Invoice with predefined reasons listed in the dropdown");
	WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver","C:/Selenium Documents/geckodriver.exe");
			// driver=new FirefoxDriver();
			
			
			//System.setProperty("webdriver.ie.driver", "C:/Selenium Documents/IEDriverServer.exe");
	
		//WebDriver driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


			driver.get(URL);
		
			driver.findElement(By.xpath("//input[contains(@data-val-maxlength-max,'50')]")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains(@data-val-required,'Password is required.')]")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Sign in')]")).click();
			WebElement viewdoc = driver.findElement(By.xpath("//a[@href='/Manage/Invoices?q=All'][contains(.,'View Results')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", viewdoc);
}
  @Test (priority=1)
  public void RejecttheInvoicewithReasonlisted() throws InterruptedException {
	  
			Thread.sleep(1500);
			Reporter.log("Reject the Invoice with predefined reasons listed in the dropdown");
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
			Thread.sleep(1000);
			WebElement statuswrtsearch=driver.findElement(By.xpath("//select[contains(@data-filter,'true')]"));
			statuswrtsearch.click();
			Select optionsinstatus=new Select(statuswrtsearch);
			optionsinstatus.selectByVisibleText("Exceptions Alert");
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])")).click();
			Thread.sleep(3000);
		Thread.sleep(3000);
	
		WebElement invnumber=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[3]/div/div/div[2]/div/div/table/tbody/tr[2]/td[2]"));
		String invoiceno=invnumber.getText();
			WebElement rejectbutton=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Reject')]"));
			rejectbutton.click();
			Thread.sleep(3000);
			//testcase1
			WebElement cancelbutton=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Cancel')]"));
			cancelbutton.click();
			Thread.sleep(3000);
			
			//testcase2
			rejectbutton.click();
			WebElement rejectdropdown=driver.findElement(By.xpath("//select[contains(@class,'swal2-select')]"));
		//	rejectdropdown.click();
			Select selindropdown=new Select(rejectdropdown);
			selindropdown.selectByIndex(4);
			Thread.sleep(1000);
			WebElement cancelbutton1=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Cancel')]"));
			cancelbutton1.click();
			Thread.sleep(3000);
			//testcase3
			///html/body/div[3]/div/div[3]/button[1]
			rejectbutton.click();
			//rejectdropdown.click();
			WebElement rejectdropdown1=driver.findElement(By.xpath("//select[contains(@class,'swal2-select')]"));
			Select selindropdown1=new Select(rejectdropdown1);
			//selindropdown.selectByIndex(4);
			selindropdown1.selectByVisibleText("HSN/SAC Code missing on the invoice");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Submit')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Ok')]")).click();
		Thread.sleep(3000);
		WebElement auditlogs = driver.findElement(By.xpath("//a[contains(.,'Audit Logs')]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", auditlogs);
		driver.findElement(By.xpath("//a[contains(.,'Audit Logs')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'Invoice Audit')]")).click();
		Thread.sleep(3500);
		WebElement verifylog=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[3]"));
		String textoflogs=verifylog.getText();
		System.out.println(textoflogs);
		Assert.assertEquals("Invoice number "+invoiceno+" is rejected for HSN/SAC Code missing on the invoice.", textoflogs);
		Thread.sleep(3000);
  }
  @Test (priority=2)
  public void RejecttheInvoicewithManualReason() throws InterruptedException {
	  
		Reporter.log("Reject the Invoice with Manual customize reason");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='/Content/img/view-result.svg']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
		Thread.sleep(1000);
		WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@data-filter,'true')]"));
		statuswrtsearch1.click();
		Select optionsinstatus1=new Select(statuswrtsearch1);
		optionsinstatus1.selectByVisibleText("Exceptions Alert");
		driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])")).click();
		Thread.sleep(3000);
		WebElement invnumber1=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div[3]/div/div/div[2]/div/div/table/tbody/tr[2]/td[2]"));
		String invoiceno1=invnumber1.getText();
		WebElement rejectbutton1=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Reject')]"));
		rejectbutton1.click();
		//rejectbutton.click();
		//rejectdropdown.click();
		WebElement rejectdropdown2=driver.findElement(By.xpath("//select[contains(@class,'swal2-select')]"));
		Select selindropdown2=new Select(rejectdropdown2);
		//selindropdown.selectByIndex(4);
		selindropdown2.selectByVisibleText("Others");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//textarea[contains(@class,'form-control')]")).sendKeys("Place your customized reason here");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='button'][contains(.,'Submit')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@type='button'][contains(.,'Ok')]")).click();
	Thread.sleep(3000);
	WebElement auditlogs1 = driver.findElement(By.xpath("//a[contains(.,'Audit Logs')]"));
	JavascriptExecutor executor11 = (JavascriptExecutor)driver;
	executor11.executeScript("arguments[0].click();", auditlogs1);
	driver.findElement(By.xpath("//a[contains(.,'Audit Logs')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[contains(.,'Invoice Audit')]")).click();
	Thread.sleep(3500);
	WebElement verifylog1=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[3]"));
	String textoflogs1=verifylog1.getText();
	System.out.println(textoflogs1);
	Assert.assertEquals("Invoice number "+invoiceno1+" is rejected for Place your customized reason here.", textoflogs1);
	Thread.sleep(3000);

Thread.sleep(3000);


  }



@AfterTest
public void afterTest() {
	driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
    System.out.println("Pass");
   	  driver.quit();
	  System.out.println("Ending on Chrome");
	  
}
}
