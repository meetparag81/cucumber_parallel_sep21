package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/resources/java/TestFeature/LoginwithSO.feature"},
		glue={"Steps","MyHooks"},
		//to generate different types of reporting
		plugin={"pretty","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},
		monochrome=true,
		publish=true,
		
		dryRun = false)


public class LoginwithScenarioOutlineRunner {

}
