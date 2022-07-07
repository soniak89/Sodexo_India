package Sodexo.SodexoIndia;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FiledownloadfromAllStatus {
	
	public WebDriver driver;
	@Parameters({"URL", "username", "password" }) 
	@BeforeTest
	public void beforeTest(String URL, String username, String password) {
		  //System.out.println("File download view for Invoice status from View Results on Sodexo India");
		 WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		//	System.setProperty("webdriver.gecko.driver","C:/Selenium Documents/geckodriver.exe");
			// driver=new FirefoxDriver();
			
			
			//System.setProperty("webdriver.ie.driver", "C:/Selenium Documents/IEDriverServer.exe");
			//WebDriver driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			driver.get(URL);
		
			driver.findElement(By.xpath("//input[contains(@data-val-maxlength-max,'50')]")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains(@data-val-required,'Password is required.')]")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Sign in')]")).click();
			
			WebElement viewresult = driver.findElement(By.xpath("//a[@href='/Manage/Invoices?q=All'][contains(.,'View Results')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", viewresult);
	}
  @Test
  public void filedownloadfromUnderProcess() throws InterruptedException {
	 
		Thread.sleep(2500);
		Reporter.log("Verify the pdf format download option open in next tab for Under Process status");
		Thread.sleep(1000);
		WebElement clickonSearch=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]"));
		clickonSearch.click();
		Thread.sleep(3000);
		WebElement statuswrtsearch=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
		statuswrtsearch.click();
		//WebElement cardview=driver.findElement(By.xpath("//button[@class='btn btn-primary Dcard tabbing active'][contains(.,'Card')]"));
		
		Select optionsinstatus=new Select(statuswrtsearch);
		optionsinstatus.selectByVisibleText("Under Process");
		Thread.sleep(2000);
		WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
		searchby.click();
		Select optionsinstatus2=new Select(searchby);
		optionsinstatus2.selectByVisibleText("Document Name");
		driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(".pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("(//input[contains(@value,'View Document')])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-download')]")).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    Thread.sleep(3000);
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	    Thread.sleep(3000);
		
     WebElement pressback=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Back')]"));
     pressback.click();
     Thread.sleep(2000);
	}
     @Test
     public void filedownloadfromExceptionAlert() throws InterruptedException {
    	 Reporter.log("Verify the pdf format download option open in next tab for Exception Alert status");
    	 Thread.sleep(2000);
      driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
      WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
		statuswrtsearch1.click();
		//WebElement cardview=driver.findElement(By.xpath("//button[@class='btn btn-primary Dcard tabbing active'][contains(.,'Card')]"));
		
		Select optionsinstatus1=new Select(statuswrtsearch1);
		      optionsinstatus1.selectByVisibleText("Exceptions Alert");
      WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
		searchby.click();
		Select optionsinstatus2=new Select(searchby);
		optionsinstatus2.selectByVisibleText("Document Name");
		driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(".pdf");
		Thread.sleep(2000);
      driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-download')]")).click();
      Thread.sleep(2000);
      ArrayList<String> wt = new ArrayList<String> (driver.getWindowHandles());
      driver.switchTo().window(wt.get(1));
	    Thread.sleep(3000);
	    driver.close();
	    driver.switchTo().window(wt.get(0));
	    Thread.sleep(3000);
	    //driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//button[@type='button'][contains(.,'Back')]")).click();
	    Thread.sleep(2500);
     }
	    @Test
	     public void filedownloadfromExceptionApproved() throws InterruptedException {
	    	 Reporter.log("Verify the pdf format download option open in next tab for Exception Approved status");
driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
statuswrtsearch1.click();
Select optionsinstatus1=new Select(statuswrtsearch1);
optionsinstatus1.selectByVisibleText("Exceptions Approved");
WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
searchby.click();
Select optionsinstatus2=new Select(searchby);
optionsinstatus2.selectByVisibleText("Document Name");
driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(".pdf");
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
	Thread.sleep(2500);
	driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Approved')])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//i[contains(@class,'fa fa-download')]")).click();
Thread.sleep(2000);
ArrayList<String> wt1 = new ArrayList<String> (driver.getWindowHandles());
driver.switchTo().window(wt1.get(1));
  Thread.sleep(3000);
  driver.close();
  driver.switchTo().window(wt1.get(0));
  Thread.sleep(3000);
  //driver.switchTo().defaultContent();
  driver.findElement(By.xpath("//button[@type='button'][contains(.,'Back')]")).click();
  
	    }
	    
@Test
public void filedownloadfromRejected() throws InterruptedException {    
	 Reporter.log("Verify the pdf format download option open in next tab for Rejected status");
	Thread.sleep(2000);
driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
statuswrtsearch1.click();
Select optionsinstatus1=new Select(statuswrtsearch1);
optionsinstatus1.selectByVisibleText("Rejected");
WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
searchby.click();
Select optionsinstatus2=new Select(searchby);
optionsinstatus2.selectByVisibleText("Document Name");
driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(".pdf");
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
Thread.sleep(2500);
driver.findElement(By.xpath("(//a[@name='view'][contains(.,'View Rejection')])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//i[contains(@class,'fa fa-download')]")).click();
Thread.sleep(2000);
ArrayList<String> wt2 = new ArrayList<String> (driver.getWindowHandles());
driver.switchTo().window(wt2.get(1));
  Thread.sleep(3000);
  driver.close();
  driver.switchTo().window(wt2.get(0));
  Thread.sleep(4000);
  driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[2]/a[2]")).click();
}

  @Test
  public void filedownloadfromProcessed() throws InterruptedException {   
	  Reporter.log("Verify the pdf format download option open in next tab for Processed status");
	  Thread.sleep(2000);
  driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
  WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
  statuswrtsearch1.click();
  Select optionsinstatus1=new Select(statuswrtsearch1);
  optionsinstatus1.selectByVisibleText("Processed");
  WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
  searchby.click();
  Select optionsinstatus2=new Select(searchby);
  optionsinstatus2.selectByVisibleText("Document Name");
  driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(".pdf");
  Thread.sleep(2000);

  driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
  Thread.sleep(2500);
  driver.findElement(By.xpath("//a[contains(@data-status,'Processed')]")).click();
  Thread.sleep(1000);
  driver.findElement(By.xpath("//i[contains(@class,'fa fa-download')]")).click();
  Thread.sleep(2000);
  ArrayList<String> wt3 = new ArrayList<String> (driver.getWindowHandles());
  driver.switchTo().window(wt3.get(1));
    Thread.sleep(3000);
    driver.close();
    driver.switchTo().window(wt3.get(0));
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@type='button'][contains(.,'Back')]")).click();
  }
   // Thread.sleep(1000);
  /*  @Test
    public void filedownloadfromPendingSupplier() throws InterruptedException {  
    	 Reporter.log("Verify the pdf format download option open in next tab for Pending Supplier status");
   
    driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
    WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
    statuswrtsearch1.click();
    Select optionsinstatus1=new Select(statuswrtsearch1);
    optionsinstatus1.selectByVisibleText("Supplier Approval Pending");
    WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
    searchby.click();
    Select optionsinstatus2=new Select(searchby);
    optionsinstatus2.selectByVisibleText("Document Name");
    driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(".pdf");
 
    driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
    Thread.sleep(2500);
    driver.findElement(By.xpath("(//input[contains(@data-status,'Supplier Approval Pending')])")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//i[contains(@class,'fa fa-download')]")).click();
    Thread.sleep(2000);
    ArrayList<String> wt4 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(wt4.get(1));
      Thread.sleep(3000);
      driver.close();
      driver.switchTo().window(wt4.get(0));
      Thread.sleep(3000);
      driver.findElement(By.xpath("//button[@type='button'][contains(.,'Back')]")).click();
    }
    
   @Test
    public void filedownloadfromNoException() throws InterruptedException {  
     Reporter.log("Verify the pdf format download option open in next tab for No Exceptions status");
    	
     driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
    WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
    statuswrtsearch1.click();
    Select optionsinstatus1=new Select(statuswrtsearch1);
    optionsinstatus1.selectByVisibleText("No Exceptions");
    WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
    searchby.click();
    Select optionsinstatus2=new Select(searchby);
    optionsinstatus2.selectByVisibleText("Document Name");
    driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(".pdf");
    Thread.sleep(2000);
     /* driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
       Thread.sleep(1000);
  statuswrtsearch1.click();
  Thread.sleep(1000);
      optionsinstatus1.selectByVisibleText("No Exceptions");
      driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
      Thread.sleep(2500);
      driver.findElement(By.xpath("(//a[contains(@data-status,'No Exceptions')])[1]")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//i[contains(@class,'fa fa-download')]")).click();
      Thread.sleep(2000);
      ArrayList<String> wt5 = new ArrayList<String> (driver.getWindowHandles());
      driver.switchTo().window(wt5.get(1));
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(wt5.get(0));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Back')]")).click();
        Thread.sleep(2000);
 }*/


@AfterTest
public void afterTest() {
	driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
	//Thread.sleep(3000);
	 driver.close();
	  System.out.println("Ending on Chrome");
	  
}
}
