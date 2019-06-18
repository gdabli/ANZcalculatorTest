package myRunner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/Users/gauravdabli/Documents/workspace4/Anzcalculator/src/main/java/Features/Borrowestimate.feature",
				"/Users/gauravdabli/Documents/workspace4/Anzcalculator/src/main/java/Features/dollorOneCheck.feature"},
		glue={"stepDefinitions"},
		format= {"pretty","html:test-outout"}
		)


public class TestRunner {
	

}

