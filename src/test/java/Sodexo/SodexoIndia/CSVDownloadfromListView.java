package Sodexo.SodexoIndia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

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

public class CSVDownloadfromListView {
	public WebDriver driver;
	
	@Parameters({"URL", "username", "password" })
  @Test
  public void ListViewCsvDownload(String URL, String username, String password) throws InterruptedException {
	  // System.setProperty("webdriver.chrome.driver","C:/Automation-Sonia-Scripts/basicfunctionsforcai/driver/chromedriver.exe");
		 WebDriverManager.chromedriver().setup();	
		Reporter.log("CSV File download from List View under View Results on India");
			
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
			WebElement viewdoc = driver.findElement(By.xpath("//a[@href='/Manage/Invoices?q=All'][contains(.,'View Results')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", viewdoc);
			Thread.sleep(1500);
			WebElement listview=driver.findElement(By.xpath("//button[@class='btn btn-default tab-grid tabbing'][contains(.,'List')]"));
			listview.click();
			listview.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Download CSV')]")).click();
			Thread.sleep(5000);
			isFileDownloaded(downloadFilePath, "List_Invoice.CSV");
			  Thread.sleep(5000);
				 driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
  }
  public boolean isFileDownloaded(String downloadFilePath, String fileName) {
	  File dir = new File(downloadFilePath);
	  File[] dirContents = dir.listFiles();

	  for (int i = 0; i < dirContents.length; i++) {
	      if (dirContents[i].getName().equals(fileName)) {
	          // File has been found, it can now be deleted:
	    	  try
	  		{
	  		ArrayList<String> ar = new ArrayList<String>();
	  		File csvFile = new File("C:\\GITRepo\\Sodexo_India\\DownloadCSVfilesforIndia\\List_Invoice.csv");
	  		BufferedReader br = new BufferedReader(new FileReader(csvFile));
	  		String line = "";
	  		StringTokenizer st = null;
	  		//int lineNumber = 0;
	  		//int tokenNumber = 0;
	  		if((line = br.readLine()) != null) {
	  		String[] arr = line.split(",");
	  		
	  		//for the first line it'll print
	  		System.out.println(arr[0].equalsIgnoreCase("Document Name")+" " + arr[1].equalsIgnoreCase("Document type")
	  				+" " + arr[2].equalsIgnoreCase("Scan date")+" " + arr[3].equalsIgnoreCase("Uploaded By")
	  				+" " + arr[4].equalsIgnoreCase("Document Id")+" " + arr[5].equalsIgnoreCase("Invoice Number")
	  				+" " + arr[6].equalsIgnoreCase("Invoice Date")+" " + arr[7].equalsIgnoreCase("Due Date")
	  				+" " + arr[8].equalsIgnoreCase("Submitted Date")+" " + arr[9].equalsIgnoreCase("Supplier Name")
	  				+" " + arr[10].equalsIgnoreCase("Supplier No")+" " + arr[11].equalsIgnoreCase("Buyer Name")
	  				+" " + arr[12].equalsIgnoreCase("Exceptions")+" " + arr[13].equalsIgnoreCase("Reject Reason")
	  				+" " + arr[14].equalsIgnoreCase("Currency")+" " + arr[15].equalsIgnoreCase("Gross Amount")
	  				+" " + arr[16].equalsIgnoreCase("GST/ABN/ACRA")+" " + arr[17].equalsIgnoreCase("PO Number")+" " + arr[18].equalsIgnoreCase("Status")
	  				+" " + arr[19].equalsIgnoreCase("Sync Status"));
	  		
	  		//+" " + arr[20]+" " + arr[21]+" " + arr[21]+" " + arr[23]); // h
	  		// System.out.println("arr[1] = " + arr[1]); // Vito
	  		//lineNumber++;
	  		//use comma as token separator
	  		}
	  		
	  		}
	  		catch(IOException ex) {
	  		ex.printStackTrace();
	  		}
	  		finally{
	  		//System.out.println("thank you");
	  		}
	    	  dirContents[i].delete();
	          System.out.println("File Downloaded"+dirContents[i].getName());
	          return true;
	      }
	          }
	      return false;
	  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("CSV File download from List View for Sodexo India");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Finish");
	  driver.close();
  }

}
