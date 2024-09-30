package runnerfiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/apidemosapp",
        glue = {"stepdefinitions"},
        monochrome = true,
        dryRun = false,
//        tags = "@REGRESSIONTEST or @SMOKE",
//        tags = "@REGRESSIONTEST and @SMOKE",
//        tags = "@REGRESSIONTEST and not @SMOKE",
        tags = "(@REGRESSIONTEST or @SANITY) and not @SMOKE",
        plugin = {"pretty", "html:target/cucumber-reports.html","json:target/cucumber-reports.json"})
public class TestRunner {
}
