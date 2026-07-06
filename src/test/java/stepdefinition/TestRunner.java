package stepdefinition;

	import org.junit.runner.RunWith;
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	

	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "C:\\Users\\user\\eclipse-workspace\\TestNGProjectForPractice\\src\\test\\resources\\featurefiles\\dataTable.feature", // Path to your feature files
	    glue = "stepdefinition",                 // Package name where step definitions are located
	    plugin = {"pretty", "html:target/report.html"}, // Reporting options
	   // tags = "@valid and @invalid",                      // Filter to run specific scenarios by tag
	    dryRun = false                            // If set to true, it checks for missing step definitions without running the actual code
	)



	public class TestRunner {

	}



