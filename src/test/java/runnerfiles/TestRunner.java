package runnerfiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/apidemosapp",
        glue = {"stepdefinitions"},
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html"})
public class TestRunner {
}
