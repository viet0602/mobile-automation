package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import platform.Platform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {

    public static AppiumDriver<MobileElement> getDriver(Platform platform) {
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, "Android");
        capabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(UDID, "R58N7200YDJ");
        capabilities.setCapability(APP_PACKAGE, "com.wdiodemoapp");
        capabilities.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        URL appiumServer = null;
        try {
            appiumServer = new URL(" http://localhost:4723/wd/hub");
            // appiumDriver = new AndroidDriver <MobileElement> (appiumServer,capabilities);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (appiumServer == null) {
            throw new RuntimeException("Can't construct the appium server url@http://localhost:4723/wd/hub");
        }
        switch (platform) {
            case ANDROID:
                appiumDriver = new AndroidDriver<>(appiumServer, capabilities);
                break;
            case IOS:
                appiumDriver = new IOSDriver<>(appiumServer, capabilities);
                break;
        }
        //Implicit wait = global wait of session| interval time 500ms
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return appiumDriver;
    }

}
