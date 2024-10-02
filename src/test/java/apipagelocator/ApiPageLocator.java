package apipagelocator;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ApiPageLocator {
    public AndroidDriver driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Text\"]")
    public static WebElement btn_text;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"KeyEventText\"]")
    public static WebElement btn_keyevent;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Linkify\"]")
    public static WebElement btn_linkify;

    public static By btn_textbutton = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Text\"]");

    public ApiPageLocator (AndroidDriver  driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    public void validateElementAndClick(){
        if(btn_text.isDisplayed()){
            btn_text.click();
        }
    }

    public void validateElementKeyEvent(){
        Assert.assertTrue(btn_keyevent.isDisplayed());
    }
    public void validateElementLinkify(){
        Assert.assertTrue(btn_linkify.isDisplayed());
    }
}
