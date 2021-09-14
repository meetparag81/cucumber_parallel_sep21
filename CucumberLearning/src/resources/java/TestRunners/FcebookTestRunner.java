package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src\\resources\\java\\TestFeature\\Uber.feature"},
		glue={"Steps","MyHooks"},		
		plugin={"pretty"},
		monochrome=true,
		
		dryRun = false)
public class FcebookTestRunner {

}
