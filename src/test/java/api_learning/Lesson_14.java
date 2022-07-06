package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class Lesson_14 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("udid","id of device");
        capabilities.setCapability("appPackage","com.wdiodemoapp");
        capabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");

        try {
            URL appiumServer = new URL(" http://localhost:4723/wd/hub");
            appiumDriver = new AndroidDriver <MobileElement> (appiumServer,capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
