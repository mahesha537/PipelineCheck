package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/Features",
        glue = "stepDefinitions",
        monochrome = true,
        tags = "@check"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}