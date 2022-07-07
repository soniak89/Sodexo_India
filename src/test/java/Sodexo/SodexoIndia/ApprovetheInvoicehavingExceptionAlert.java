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

	public class ApprovetheInvoicehavingExceptionAlert {
		public	WebDriver driver;
		@Parameters({ "URL", "username", "password" })
		  @Test
		  public void approveinvoice(String URL, String username, String password) throws InterruptedException {
			 // System.setProperty("webdriver.chrome.driver","C:/Automation-Sonia-Scripts/basicfunctionsforcai/driver/chromedriver.exe");
			 WebDriverManager.chromedriver().setup();	
			driver=new ChromeDriver();
				Reporter.log("Approve the Invoice on CAI India");
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
				
				WebElement viewdoc = driver.findElement(By.xpath("//a[@href='/Manage/Invoices?q=All'][contains(.,'View Results')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", viewdoc);
				Thread.sleep(1500);
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
				
				WebElement statuswrtsearch=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
				statuswrtsearch.click();
				Select optionsinstatus=new Select(statuswrtsearch);
				optionsinstatus.selectByVisibleText("Exceptions Alert");
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[contains(@data-target,'Approved')]")).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm')]")).click();
				Thread.sleep(3000);
				WebElement okonpopup=driver.findElement(By.xpath("//button[@type='button'][contains(.,'OK')]"));
				okonpopup.click();
				Thread.sleep(3000);
			
					
					Thread.sleep(3000);
			      driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
			      System.out.println("Pass");
			
				}
				
				
		  
		  
		  @BeforeMethod
		  public void beforeMethod() {
			  System.out.println("Approve the Invoice having Exceptions");
		  }

		  @AfterMethod
		  public void afterMethod() {
			 
			  driver.quit();
				 System.out.println("finish");
		  }

		}