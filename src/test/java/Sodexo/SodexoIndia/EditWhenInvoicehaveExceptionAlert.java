package Sodexo.SodexoIndia;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditWhenInvoicehaveExceptionAlert {
	 public	WebDriver driver;
	 @Parameters({ "username", "password", "URL" }) 
  @Test
  public void EditfunctionalityonExceptionAlertcase(String username, String password, String URL) throws InterruptedException {
	  
			 // System.setProperty("webdriver.chrome.driver","C:/Automation-Sonia-Scripts/basicfunctionsforcai/driver/chromedriver.exe");
			 WebDriverManager.chromedriver().setup();	
			driver=new ChromeDriver();
				Reporter.log("Edit the Invoice details when Invoice have Exceptions Alert");
			//	System.setProperty("webdriver.gecko.driver","C:/Selenium Documents/geckodriver.exe");
			// driver=new FirefoxDriver();
				
				//System.setProperty("webdriver.ie.driver", "C:/Selenium Documents/IEDriverServer.exe");
				//WebDriver driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
				/*WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
				searchby.click();
				Select optionsinstatus2=new Select(searchby);
				optionsinstatus2.selectByVisibleText("Supplier Name");
				driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys("HUMAIN HEALTH");*/
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("(//a[contains(@data-status,'Exceptions Alert')])[1]")).click();
				Thread.sleep(3000);
				


driver.findElement(By.xpath("//a[@type='button'][contains(.,'Edit')]")).click();

				
Thread.sleep(3000);
				
/*driver.findElement(By.xpath("//button[@type='button'][contains(.,'Save')]")).click();
	
			WebElement getetxtonpopup=driver.findElement(By.xpath("//div[contains(@id,'swal2-content')]"));
		
		String verifytext=getetxtonpopup.getText();
				
Assert.assertEquals(verifytext, "Please edit atleast one field.");
				
System.out.println(verifytext);*/
				Thread.sleep(5000);
		
WebElement innertext=driver.findElement(By.xpath("/html/body/section/div/div[2]/div/div[2]/div/div[3]/div/input"));
	
		//	innertext.click();
						
String documentname=innertext.getAttribute("value");
				
System.out.println(documentname);
				
WebElement buyername=driver.findElement(By.xpath("//input[contains(@data-index,'3')]"));
				buyername.clear();
				buyername.sendKeys("M/s. Sodexo India Services Private. Limited.");
				buyername.click();
				Thread.sleep(1000);
				
				
WebElement supplierno=driver.findElement(By.xpath("//input[contains(@data-index,'6')]"));
supplierno.clear();
supplierno.sendKeys("VMD1189808");
Thread.sleep(2000);
Actions act = new Actions(driver);               //Object of <em>Actions</em> class

//act.sendKeys(Keys.<strong><em>PAGE_DOWN</em></strong>).build().perform();  //Page Down  
 
act.sendKeys(Keys.PAGE_UP).build().perform();  
WebElement savebutton=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Save')]"));

//executor.executeScript("arguments[0]. scrollIntoView(true);", savebutton);
Thread.sleep(2000);	
savebutton.click();
Thread.sleep(2000);			
			
driver.findElement(By.xpath("//button[@type='button'][contains(.,'Yes')]")).click();
				
Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Ok')]")).click();
		
		Thread.sleep(3000);
				
/*driver.findElement(By.xpath("//button[@class='btn btn-default tab-grid tabbing'][contains(.,'List')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
				
				
WebElement statuswrtsearch1=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
	
			statuswrtsearch1.click();
				
Select optionsinstatus1=new Select(statuswrtsearch1);
		
		optionsinstatus1.selectByVisibleText("Exceptions Alert");

				
WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
		
		searchby.click();
				
Select optionsinstatus2=new Select(searchby);
				
optionsinstatus2.selectByVisibleText("Document Name");
				
driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys(documentname);
				
Thread.sleep(2000);
				
driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
	
			Thread.sleep(6000);
				
WebElement vcode=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[1]/div[1]/div/div/div[2]/div[3]/div/div/table/tbody/tr[1]/td[10]"));
	
		String valueofvendor=vcode.getAttribute("value");
				
Assert.assertEquals("VMD10898", valueofvendor);
				Thread.sleep(2000);
				
WebElement bname=driver.findElement(By.xpath("/html/body/div[1]/div/div/section[1]/div[1]/div/div/div[2]/div[3]/div/div/table/tbody/tr[1]/td[11]/span"));
	
			System.out.println(bname.getAttribute("value"));
				
Assert.assertEquals("Sodexo India Services Private Limited", valueofvendor);
				
System.out.println("pass");*/
				driver.navigate().refresh();
				
WebElement auditlogs = driver.findElement(By.xpath("//a[contains(.,'Audit Logs')]"));
				
JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				
executor1.executeScript("arguments[0].click();", auditlogs);
				
driver.findElement(By.xpath("//a[contains(.,'Audit Logs')]")).click();
				
Thread.sleep(3000);
				
driver.findElement(By.xpath("//a[contains(.,'Invoice Audit')]")).click();
				
Thread.sleep(3500);
				
//SoftAssert softassert = new SoftAssert();
				
				
WebElement verifylog=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[3]"));
				String textoflogs=verifylog.getText();
				System.out.println(textoflogs);
				if(textoflogs!="Buyer Name, Vendor Code has been reprocessed.")
				{
					WebElement verifylog1=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[2]/td[3]"));
					String textoflogs1=verifylog1.getText();
					System.out.println(textoflogs1);
					Assert.assertEquals("Buyer Name, Vendor Code has been reprocessed.", textoflogs1);
				}
				else
				{
					Assert.assertEquals("Buyer Name, Vendor Code has been reprocessed.", textoflogs);
				}
				
				/*try
				{
					WebElement verifylog=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[3]"));
					String textoflogs=verifylog.getText();
					System.out.println(textoflogs);
					
Assert.assertEquals("Buyer Name, Vendor Code has been reprocessed.", textoflogs);
				}
				catch(Exception e)
				{
					WebElement verifylog1=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[2]/td[3]"));
					String textoflogs1=verifylog1.getText();
					System.out.println(textoflogs1);
					Assert.assertEquals("Buyer Name, Vendor Code has been reprocessed.", textoflogs1);
				}*/
				
				
				
				driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
				Thread.sleep(3000);
  }


  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Edit the Invoice details when Invoice have Exceptions Alert");
  }

  @AfterMethod
  public void afterMethod() {
	 
	  driver.quit();
		 System.out.println("finish");
  }

}