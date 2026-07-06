package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginTest {
		
		WebDriver driver;
		//-------------------------------hooks execution---------------------
		@Before  //hooks
		public void setup() {
			
			driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
		
		@After //hooks
		public void tearDown() {
			
			if(driver !=null) {
				
				driver.quit();
			}
		}
	//---------------------------------------------------------------------------------	
		//background execution
		@Given("User go to the login page")
		public void User_go_to_the_login_page() {
			
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
			
		
	}
		//background execution
				@And("Click on login button")
				public void Click_on_login_button() {
					
					driver.findElement(By.tagName("button")).click();
				}
	//-----------------------------------scenario for valid test-------------------------------------------------			
		@When("the user Enter correct username and password")
		public void the_user_Enter_correct_username_and_password() {
			
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			
		}
		
		
		@Then("User should see homepage")
		public void User_should_see_homepage() {
			
			Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
			System.out.print("Page verified");
		}
		
		@And("user logged successfully")
		public void user_logged_successfully() {
			
			WebElement pic=driver.findElement(By.xpath("//img[contains(@src,\"p/pim/viewPhoto/empNumber/7\")]"));
			Assert.assertEquals(pic.isDisplayed(),false);
		}
	//-----------------------------scenarios for invalid test-------------------------	
		@When("the user Enter incorrect username and password")
		public void the_user_Enter_incorrect_username_and_password() {
			
			driver.findElement(By.name("username")).sendKeys("Adminsss");
			driver.findElement(By.name("password")).sendKeys("admin123222");
		}
		@Then("User should not see homepage")
		public void User_should_not_see_homepage() throws InterruptedException {
			
			Assert.assertNotEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
			System.out.print("Page verified");
			Thread.sleep(1000);
		}
		@And("user not logged successfully")
		public void user_not_logged_successfully() {
			
			WebElement pic=driver.findElement(By.xpath("//img[contains(@src,\"p/pim/viewPhoto/empNumber/7\")]"));
			Assert.assertNotEquals(pic.isDisplayed(),true);
			//Assert.assertNotEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
			System.out.println("user not logged In");
		}
}
