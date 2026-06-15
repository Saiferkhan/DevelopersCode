package testNG_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProvider_Example {//method
	WebDriver driver;	
	@BeforeMethod
	public void browserLaunching() { 
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(dataProvider="testData")
	public void loginTest(String user, String pass) {
		
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.tagName("button")).click();
		
		WebElement pics=driver.findElement(By.xpath("//img[contains(@src,\"index.php/pim/viewPhoto/empNumber/7\")]"));
		Assert.assertEquals(pics.isDisplayed(), "login successfull");
	}
	
	
	@DataProvider(name ="testData")
	public Object [][] getData(){
		
		return new Object[][] {
			
			{"Admin","admin123"},
			{"admin","admin321"},
			{"admins","admins322"}
		};		
	}
	
	@AfterClass
	public void tearDown() {
		if(driver !=null) {
			driver.quit();
		}
	}
	
}
