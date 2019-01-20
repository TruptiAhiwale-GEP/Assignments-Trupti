package Selenium_Webdriver_TC;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

	public class TestNGcode {
		
		public static WebDriver driver;		
		
		@BeforeTest
		  public void begin() 
		 {
			  // The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.
			  System.out.println("This is before test");
			  System.setProperty( "webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\src\\Selenium_Webdriver_TC\\Driver_folder\\exes\\chromedriver.exe");
				 this.driver = new ChromeDriver();
					WebDriverWait wait=new WebDriverWait(driver, 90);
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(2,TimeUnit.MINUTES);
					driver.get("https://www.theswiftcodes.com/malaysia/");
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		  }
		 
		   
		@Test
		
		public void actualcode() 
		{
			//System.out.println("driver"+ driver);
			int rows = driver.findElements(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr[*]")).size();
			System.out.println("Total number of Rows---->" + rows);
			for(int i=1;i<rows;i++)
			{
				String name1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr["+(i+1)+"]")).getText();
				String code1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr["+(i+1)+"]")).getText();
				if (name1.isEmpty() && code1.isEmpty())
				{
					System.out.println("No row");
				}
				else
				{
				String name2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr["+(i+1)+"]/td[2]")).getText();
				String code2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr["+(i+1)+"]/td[5]")).getText();

				System.out.println("The Bank name is---->"+ name2 );
				System.out.println("The Swift code name is---->"+ code2 );

				}
			}
			
			
	    }

      @AfterTest
	  public void close() {
		  
		  // The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run. 
		  
			System.out.println("driver "+ driver);  
			System.out.println("======================================");  
			driver.close(); 
		  
	  }
	  

	}
	

