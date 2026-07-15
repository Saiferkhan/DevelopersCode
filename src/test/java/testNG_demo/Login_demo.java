package testNG_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_demo {
	
	WebDriver driver;
	@BeforeClass()
	@Test(groups="smoke",priority=0)
	@Parameters({"browser","url"})
	public void browserLaunch(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get(url);
	}
	
	else if(browser.equalsIgnoreCase("edge")) {
		driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get(url);
	}
	}

	@Test(groups="smoke",priority=1)
	public void enterCredentials() {
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
	}
	
	@Test(groups="smoke",priority=2)
	public void clickOnLoginbutton() {
		
		driver.findElement(By.xpath("//button[text()=\" Login \"]")).click();
	}
	
	@AfterClass
	@Test(groups="regression",priority=3)
	public void tearDown() {
		
		if(driver!=null) {
			
			driver.quit();
		}
		
		
	}
}
