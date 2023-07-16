package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
   (features = ".//Features/Apply.feature", 
    glue = "stepDefinitions",
    dryRun = true,
    plugin = {"pretty"})


public class TestRunner extends AbstractTestNGCucumberTests {

}
