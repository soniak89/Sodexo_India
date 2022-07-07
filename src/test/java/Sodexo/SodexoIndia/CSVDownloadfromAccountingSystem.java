package Sodexo.SodexoIndia;


	import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class CSVDownloadfromAccountingSystem {
		public WebDriver driver;
		
		@Parameters({"URL", "username", "password" })
		  @Test
		  public void CSVfiledownload(String URL, String username, String password) throws InterruptedException {
			 // System.setProperty("webdriver.chrome.driver","C:/Automation-Sonia-Scripts/basicfunctionsforcai/driver/chromedriver.exe");
			 WebDriverManager.chromedriver().setup();	
			Reporter.log("CSV File download from Accounting System on For Sodexo India");
				
				//System.setProperty("webdriver.gecko.driver","C:/Selenium Documents/geckodriver.exe");
				//WebDriver driver=new FirefoxDriver();
				
				//System.setProperty("webdriver.ie.driver", "C:/Selenium Documents/IEDriverServer.exe");
				//WebDriver driver=new InternetExplorerDriver();
				
				String downloadFilePath = "C:\\GITRepo\\SodexoIndia\\DownloadCSVfilesforIndia";

				 HashMap<String, Object> chromePref = new HashMap<String, Object>();

				chromePref.put("profile.default_content_settings.popups", 0);

				chromePref.put("download.default_directory", downloadFilePath);

				ChromeOptions options = new ChromeOptions();

				options.setExperimentalOption("prefs", chromePref);

		      driver = new ChromeDriver(options);
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			
				driver.findElement(By.xpath("//input[contains(@data-val-maxlength-max,'50')]")).sendKeys(username);
				driver.findElement(By.xpath("//input[contains(@data-val-required,'Password is required.')]")).sendKeys(password);
				driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Sign in')]")).click();
				Thread.sleep(2500);
			/*	WebElement companysel=driver.findElement(By.xpath("/html/body/nav/ul/li[1]/div/select"));
				companysel.click();
				Select SAPoptionsinstatus=new Select(companysel);
				SAPoptionsinstatus.selectByVisibleText("Admin test");*/
		
				WebElement accountsystem = driver.findElement(By.xpath("//span[contains(.,'Accounting System')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", accountsystem);
				driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(.,'Download Data')]")).click();
				driver.findElement(By.xpath("//input[contains(@data-required,'From Date is required.')]")).click();//.sendKeys("19/12/2020");
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//th[contains(@class,'prev')])[1]")).click();
				driver.findElement(By.xpath("(//td[@class='day'])[1]")).click();
				driver.findElement(By.xpath("//input[contains(@data-required,'To Date is required.')]")).click();//.sendKeys("29/12/2020");
				driver.findElement(By.xpath("//td[contains(@class,'day active today')]")).click();
				driver.findElement(By.xpath("//input[contains(@name,'chkboxAll')]")).click();
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
		      js1.executeScript("window.scrollBy(0,350)", "");
				Thread.sleep(8000);
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Submit')]")).click();
				Thread.sleep(5000);
				isFileDownloaded(downloadFilePath, "All.CSV");
				
			   System.out.println("File Downloaded");
			   Thread.sleep(5000);
				 driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
		   
		     
			}
			
		public boolean isFileDownloaded(String downloadFilePath, String fileName) {
			  File dir = new File(downloadFilePath);
			  File[] dirContents = dir.listFiles();

			  for (int i = 0; i < dirContents.length; i++) {
			      if (dirContents[i].getName().equals(fileName)) {
			          // File has been found, it can now be deleted:
			          dirContents[i].delete();
			          System.out.println("File Downloaded"+dirContents[i].getName());
			          return true;
			      }
			          }
			      return false;
			  }
		  @BeforeMethod
		  public void beforeMethod() {
			  System.out.println("CSV File download from Accounting System on India");
		  }

		  @AfterMethod
		  public void afterMethod() {
			 
			  System.out.println("Finish");
			  driver.quit();
		  }

		}