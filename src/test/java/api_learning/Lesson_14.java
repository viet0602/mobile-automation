package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class Lesson_14 {

    public static void main(String[] args) {
        //Send request into appium server > as
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("udid","R58N7200YDJ");
        capabilities.setCapability("appPackage","com.wdiodemoapp");
        capabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");

        try {
            URL appiumServer = new URL(" http://localhost:4723/wd/hub");
            appiumDriver = new AndroidDriver <MobileElement> (appiumServer,capabilities);

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (appiumDriver != null) appiumDriver.quit();
    }
}
