package stepdefinitions;

import apipagelocator.ApiPageLocator;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ApiDemoAppSteps {

    public ExtentTest test;
    public AndroidDriver driver;
    Scenario scenario;
    ApiPageLocator apiPageLocator;


    @Before
    public void beforescenario(Scenario scenario) throws MalformedURLException, InterruptedException {
        this.scenario = scenario;
        test = ExtentReportManager.createTest(scenario.getName());
        test.log(Status.INFO, "Starting scenario : " + scenario.getName());
        user_open_the_api_demos_app();
    }

    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            test.log(Status.FAIL,"Sceanrio Failed: " + scenario.getName());
        }else{
            test.log(Status.PASS,"Sceanrio Passed: " + scenario.getName());
        }

        ExtentReportManager.flush();
    }

    @Given("User open the api demos app")
    public void user_open_the_api_demos_app() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);

        // calling the andorid driver to run the app
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);
        scenario.log("test");
        ExtentReportManager.createTest(String.valueOf(scenario.getName())).log(Status.INFO, "Started the appium server");
        apiPageLocator = new ApiPageLocator(driver) ;
    }

    @When("User clicks on the text button")
    public void user_clicks_on_the_text_button() {
        apiPageLocator.validateElementAndClick();
        ExtentReportManager.createTest(scenario.getId()).log(Status.INFO, "Started the scenario clicked on ");

    }

    @When("User validates the text screen")
    public void user_validates_the_text_screen() {
        apiPageLocator.validateElementKeyEvent();

    }

    @When("User validates the text screen with Linkify")
    public void user_validates_the_text_screen_with_linkify() {
        apiPageLocator.validateElementLinkify();
    }

    @Then("User closes the app")
    public void user_closes_the_app() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

    @When("User validates the text screen with button {string}")
    public void user_validates_the_text_screen_with_button(String data) {
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='"+data+"']"));
        Assert.assertTrue(element.isDisplayed());
    }

    @When("User validates the text screen with list of options from the {}")
    public void validateOptionsfromScreen(String data) {
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='"+data+"']"));
        Assert.assertTrue(element.isDisplayed());
    }

    @When("User validates the text screen with list of options")
    public void user_validates_the_text_screen_with_list_of_options(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        for(Map<String, String> dataoptions: data){
            WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='"+dataoptions.get("options")+"']"));
            Assert.assertTrue(element.isDisplayed());
        }

    }
}
