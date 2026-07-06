package stepdefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class data_Table {
	
	WebDriver driver;
	//---------------------hooks------------------
	@Before
	public void browserSetup() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://automationexercise.com/");
	}
//	@After
	public void tearDown() {
		
		if(driver!=null) {
			
			driver.quit();
		}
	}
	//----------------------------------------------------------
	 @Given("User is on the homepage")
	    public void user_is_on_the_homepage() {
		 
		 Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
	        System.out.println("User is on homepage");
	       
	    }

	    @When("User click on signup and login link")
	    public void user_click_on_signup_and_login_link() {
	        System.out.println("Click on Signup/Login link");
	        driver.findElement(By.xpath("//a[text()=\" Signup / Login\"]")).click();
	    }

	    @When("User enter valid name and email")
	    public void user_enter_valid_name_and_email(DataTable dataTable) {

	        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

	        String name = data.get(0).get("name");
	        String email = data.get(0).get("email");

	        System.out.println("Name: " + name);
	        System.out.println("Email: " + email);

	        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys(name);
	        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys(email);
	    }

	    @When("User click on signup button")
	    public void user_click_on_signup_button() {
	    	driver.findElement(By.xpath("//button[text()=\"Signup\"]")).click();
	        //System.out.println("Click on Signup button");
	    }

	    @Then("User navigate to enter account information")
	    public void user_navigate_to_enter_account_information() {
	        System.out.println("Navigated to Account Information page");
	    }

	    @When("User fill the required details")
	    public void user_fill_the_required_details(DataTable dataTable) {

	        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

	        Map<String, String> userData = data.get(0);
	         String var = userData.get("password");
	        //System.out.println("Password: " + userData.get("password"));
	        System.out.println("First Name: " + userData.get("firstname"));
	        System.out.println("Last Name: " + userData.get("lastname"));
	        System.out.println("Zip Code: " + userData.get("zipcode"));
	        System.out.println("Day: " + userData.get("day"));
	        System.out.println("Month: " + userData.get("month"));
	        System.out.println("Year: " + userData.get("year"));
	        System.out.println("Country: " + userData.get("country"));
	        System.out.println("State: " + userData.get("state"));
	        System.out.println("City: " + userData.get("City"));
	        System.out.println("Mobile No: " + userData.get("MobileNO"));
	        System.out.println("Address: " + userData.get("Address"));

	        // Selenium code goes here
	        
	        driver.findElement(By.id("password")).sendKeys(var);
	        driver.findElement(By.id("first_name")).sendKeys(userData.get("firstname"));
	        driver.findElement(By.id("last_name")).sendKeys(userData.get("lastname"));
	        driver.findElement(By.id("address1")).sendKeys(userData.get("Address"));
	        driver.findElement(By.id("country")).sendKeys(userData.get("country"));
	        driver.findElement(By.id("state")).sendKeys(userData.get("state"));
	        driver.findElement(By.id("city")).sendKeys(userData.get("City"));
	        driver.findElement(By.id("zipcode")).sendKeys(userData.get("zipcode"));
	        driver.findElement(By.id("mobile_number")).sendKeys(userData.get("Address"));
	    }

	    @When("User click on create account button")
	    public void user_click_on_create_account_button() {
	    	
	    	driver.findElement(By.xpath("//button[text()=\"Create Account\"]")).click();
	       // System.out.println("Click on Create Account button");
	    }

	    @Then("User should create account successfully")
	    public void user_should_create_account_successfully() {
	        System.out.println("Account created successfully");

	        WebElement txt=driver.findElement(By.xpath("//b[text()=\"Account Created!\"]"));
	        Assert.assertTrue(txt.isDisplayed());
	    }
	}


