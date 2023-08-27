package dbs.automation.interview.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "dbs.automation.interview.steps",
		tags = "@LoginFeature",
		monochrome = true,
		plugin = {"pretty", "json:target/cucumber.json"}
		)
public class CucumberRunner {

}
