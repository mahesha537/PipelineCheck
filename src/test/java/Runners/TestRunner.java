package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/Features",
        glue = "stepDefinitions",
        monochrome = true,
        tags = "@check",
        plugin = {"pretty","junit:target/cucumber/cucumber.xml","json:target/cucumber/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}