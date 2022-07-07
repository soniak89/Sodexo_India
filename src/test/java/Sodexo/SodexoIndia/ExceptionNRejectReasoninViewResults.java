package Sodexo.SodexoIndia;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionNRejectReasoninViewResults {
	 public WebDriver driver;
		@Parameters({ "URL", "username", "password" }) 
		@BeforeMethod
		  public void beforeMethod(String URL, String username, String password) {
			  System.out.println("Verify the pop-up for Exception and Reject Reason from List View for Sodexo India");
				 WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					Reporter.log("View Results using Search functionality on CAI India");
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
		  }
  @Test
  public void  ExceptionReasoninViewResults() throws InterruptedException {
	 		 // System.setProperty("webdriver.chrome.driver","C:/Automation-Sonia-Scripts/basicfunctionsforcai/driver/chromedriver.exe");
		
			WebElement viewdoc = driver.findElement(By.xpath("//a[@href='/Manage/Invoices?q=All'][contains(.,'View Results')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", viewdoc);
			Thread.sleep(2500);
			WebElement listview=driver.findElement(By.xpath("//button[@class='btn btn-default tab-grid tabbing'][contains(.,'List')]"));
			listview.click();
			listview.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
			
			WebElement statuswrtsearch=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
			statuswrtsearch.click();
			Select optionsinstatus=new Select(statuswrtsearch);
			optionsinstatus.selectByVisibleText("Exceptions Alert");
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//input[contains(@value,'View Exceptions')])[1]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//span[@aria-hidden='true'][contains(.,'×')]")).click();
			Thread.sleep(1500);
		}
  @Test
  public void RejectionReasoninViewResults() throws InterruptedException {
	 		 // System.setProperty("webdriver.chrome.driver","C:/Automation-Sonia-Scripts/basicfunctionsforcai/driver/chromedriver.exe");
		
			WebElement viewdoc = driver.findElement(By.xpath("//a[@href='/Manage/Invoices?q=All'][contains(.,'View Results')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", viewdoc);
			Thread.sleep(2500);
			WebElement listview=driver.findElement(By.xpath("//button[@class='btn btn-default tab-grid tabbing'][contains(.,'List')]"));
			listview.click();
			listview.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
			
			WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
			statuswrtsearch1.click();
			Select optionsinstatus1=new Select(statuswrtsearch1);
			optionsinstatus1.selectByVisibleText("Rejected");
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(1500);
			
			driver.findElement(By.xpath("(//input[contains(@value,'View Reason')])[1]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//span[@aria-hidden='true'][contains(.,'×')]")).click();
			Thread.sleep(1500);
			
		    //  driver.quit();
			
	  
  }
  
  @AfterMethod
		  public void afterMethod() {
			  System.out.println("Finish");
			  driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
		      System.out.println("Pass");
			  driver.close();
		  }
}
