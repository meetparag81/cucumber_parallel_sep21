package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/resources/java/TestFeature/Uber.feature"},
		glue={"Steps"},		
		plugin={"pretty"},
		monochrome=true,
		tags="@smoke or @Regression",
		dryRun = false)
public class UberRunner {

}
