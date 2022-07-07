package Sodexo.SodexoIndia;
 
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

	public class CSVDownloadfromCardViewResult {
		public WebDriver driver;
		
		@Parameters({ "URL", "username", "password" })
	  @Test
	  public void downloadCSVfromViewResults(String URL, String username, String password) throws InterruptedException {
		//  System.setProperty("webdriver.chrome.driver","C:/Automation-Sonia-Scripts/basicfunctionsforcai/driver/chromedriver.exe");
			 WebDriverManager.chromedriver().setup();
			Reporter.log("CSV File download from Card View under View Results on India");
			
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

			//options.setExperimentalOption("prefs", chromePref);

	    driver = new ChromeDriver(options);
	    driver.manage().deleteAllCookies();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
			driver.findElement(By.xpath("//input[contains(@data-val-maxlength-max,'50')]")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains(@data-val-required,'Password is required.')]")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Sign in')]")).click();
			Thread.sleep(2500);
			WebElement viewdoc = driver.findElement(By.xpath("//a[@href='/Manage/Invoices?q=All'][contains(.,'View Results')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", viewdoc);
			Thread.sleep(1500);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Download CSV')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
			Thread.sleep(3000);
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("CSV File download from Card View under View Results on India");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
		  System.out.println("Ending on Chrome");
		  
	  }

	}
