package cucumberoptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/java/features", glue = "stepDefinations")
public class TestRunner extends AbstractTestNGCucumberTests {

}
