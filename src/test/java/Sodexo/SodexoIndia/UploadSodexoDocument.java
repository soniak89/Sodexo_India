package Sodexo.SodexoIndia;

import static io.restassured.RestAssured.given;

import java.io.IOException;
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
import io.restassured.RestAssured;

public class UploadSodexoDocument {
	public	WebDriver driver;
	@Parameters({"username", "password", "URL"})
  @Test
  public void uploaddocument(String username, String password, String URL) throws InterruptedException, IOException {
	 RestAssured.baseURI="https://pita-api.checkaninvoice.in";
	  given().log().all().header("Content-Type","application/json")
	  .header("Authorization","bearer HB2tX0PlxGRFZqcpvwUVgO02EvUT3nvJ015WXazZPuzeI4zjhZ_ywfiPGxUjWDzDNCpDwOHaE0khWOOOHkRQvh8ELXvPusSWwVldx52aKNQzG1Z0qkEYaNnQDou67DeJE8WImPtB8IGheqt8aLNvkPWP7ZTuDMeZHRahw3PwUI_KpTIQnCuZHYs-ri-vUPQgSX_nGT3N71UMiwrjZsRP63ECEfcPuCZIttqpUT-mS55I6-yO-JRscW5fbcRcdZXUt5Gnq-uSt2IhaDXh7SttC622NgvtcedHn3OmZRsXejjLDHTqnvNwyqiPu5TgDwXkDi3b8LA3WYIPV1EPOQ39hKYVUH0JwvEzJtA1KXnFQegVOM0JCIBnL9yiNnAOjTRFNv05YpOF-Zh2dJqp2kqXncRW-jNznFA_WtobO7XsdQydOZa11IMddxAKJSwle83P052vjP0SXFSj-3nfCtMb2nvHpcuBn4f2DNNu5V__Dun2lK4BgJEqkq1ekDHneXDMAqvoR4YLkMpyimJMYHYjKAaQbOWfPAZibmnWbM-QTg4")
	  .header("AppName","API").body(payload.Addplace())
	  .when().post("/document/uploadsodexodocument")
	  .then().log().all().assertThat().statusCode(200);
	  
	 Thread.sleep(5000);
	  WebDriverManager.chromedriver().setup();	
		driver=new ChromeDriver();
			Reporter.log("Verify the document uploaded via api");
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
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Search')]")).click();
			
			WebElement statuswrtsearch=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm manageSelect')]"));
			statuswrtsearch.click();
			Select optionsinstatus=new Select(statuswrtsearch);
			optionsinstatus.selectByVisibleText("Under Process");
			WebElement searchby=driver.findElement(By.xpath("//select[contains(@class,'form-control input-sm search-by')]"));
			searchby.click();
			Select optionsinstatus2=new Select(searchby);
			optionsinstatus2.selectByVisibleText("Document Name");
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-by-value')]")).sendKeys("SoniaTESTFILE.pdf");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-fromDate bootDatePicker')]")).click();
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-toDate bootDatePicker')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@type='button'][contains(.,'Apply')]")).click();
			Thread.sleep(2500);
			driver.findElement(By.xpath("//input[contains(@value,'View Document')][1]")).click();
			  Thread.sleep(2000);
			 WebElement pressback=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Back')]"));
		     pressback.click();
		     Thread.sleep(2000);
		     
		     driver.findElement(By.xpath("//a[contains(@title,'Log out')]")).click();
				Thread.sleep(3000);
				//driver.close();
	  	}
  
@BeforeMethod
public void beforeMethod() {
	  System.out.println("Verify the document uploaded via api on Sodexo India platform.");
}

@AfterMethod
public void afterMethod() {
	 driver.close();
	  System.out.println("Ending on Chrome");
	  
}
}
