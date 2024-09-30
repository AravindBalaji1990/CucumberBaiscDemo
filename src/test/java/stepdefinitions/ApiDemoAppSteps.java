package stepdefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.datatable.DataTable;
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

    public AndroidDriver driver;

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
    }

    @When("User clicks on the text button")
    public void user_clicks_on_the_text_button() {
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).isDisplayed());

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).click();

    }

    @When("User validates the text screen")
    public void user_validates_the_text_screen() {
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"KeyEventText\"]\n")).isDisplayed());

    }

    @When("User validates the text screen with Linkify")
    public void user_validates_the_text_screen_with_linkify() {
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Linkify\"]")).isDisplayed());

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
