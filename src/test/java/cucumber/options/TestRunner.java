package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="C:\\RestAssured\\RestAssuredFramework\\src\\test\\java\\features\\PlaceApi.feature",
			plugin="json:target/jsonReports/cucumber-report.json",glue= {"stepDefinations"},
	monochrome= true
		)

public class TestRunner {

}
