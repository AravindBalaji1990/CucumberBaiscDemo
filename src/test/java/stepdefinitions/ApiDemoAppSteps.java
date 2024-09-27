package stepdefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.net.MalformedURLException;
import java.net.URL;

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

    @Then("User closes the app")
    public void user_closes_the_app() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }
}
