package Selenium_Webdriver_TC;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;

public class TestNG_code2 {
	
	public static WebDriver driver;	
	
	@BeforeTest
	  public void Start() 
	 {
		  System.out.println("This is before test");
			System.out.println("======================================"); 
		  System.setProperty( "webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\src\\Selenium_Webdriver_TC\\Driver_folder\\exes\\chromedriver.exe");
			 this.driver = new ChromeDriver();
				WebDriverWait wait=new WebDriverWait(driver, 90);
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(2,TimeUnit.MINUTES);
				driver.get("https://www.amazon.in/");
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
				
	 }
	
  @Test
  public void f() 
  {
	  List<WebElement> allimages = driver.findElements(By.tagName("img"));
		System.out.println("No. of images---->"+ allimages.size());
		for(WebElement element : allimages)
		{
			System.out.println(element.getAttribute("alt"));
		}
	}
		
		
		
@AfterTest
		  public void End() {
			  
			  System.out.println("After Test");
				System.out.println("======================================");  
				driver.close(); 
			  
		  }
}
