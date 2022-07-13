package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import platform.Platform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static AppiumDriver<MobileElement> getDriver(Platform platform) {

        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("udid", "R58N7200YDJ");
        capabilities.setCapability("appPackage", "com.wdiodemoapp");
        capabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
        try {
            URL appiumServer = new URL(" http://localhost:4723/wd/hub");

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (appiumDriver == null) {
            throw new RuntimeException("Can't construct the appium server url@http://localhost:4723/wd/hub");
        }
        switch (platform) {
            case ANDROID:
                appiumDriver = new AndroidDriver<>(capabilities);
                break;
            case IOS:
                appiumDriver = new IOSDriver<>(capabilities);
                break;
        }
        //Implicit wait = global wait of session| interval time 500ms
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return appiumDriver;
    }

}
