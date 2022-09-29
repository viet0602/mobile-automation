package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class LaunchAppTest {

    public static void main(String[] args) {
        //Send request into appium server > ask to launch the app

        //Muon 1 appium driver. Chua co j, set la null
        AppiumDriver<MobileElement> appiumDriver = null;
        //Khoi tao Capability mong muon
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Platform name
        capabilities.setCapability("platformName","Android");
        //Automation name
        capabilities.setCapability("automationName","uiautomator2");
        //Device need to test, unit device identify
        capabilities.setCapability("udid","R58N7200YDJ");
        //Test which app in the phone
        capabilities.setCapability("appPackage","com.wdiodemoapp");
        //Main activity of app
        capabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");

        try {
            //Init appium session, wd/hub: end point
            URL appiumServer = new URL(" http://localhost:4723/wd/hub");
            appiumDriver = new AndroidDriver <MobileElement> (appiumServer,capabilities);

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (appiumDriver != null) appiumDriver.quit();
    }
}
