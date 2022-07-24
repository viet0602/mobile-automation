package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import platform.Platform;

import java.io.File;

public class TakingScreenShot {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            // Navigate to Login screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            // Whole screen
            File basic64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginScreen.png");
            FileUtils.copyFile(basic64ScreenshotData, new File(fileLocation));
            // An area
            MobileElement loginFormElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            basic64ScreenshotData = loginFormElem.getScreenshotAs(OutputType.FILE);
            fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginForm.png");
            FileUtils.copyFile(basic64ScreenshotData, new File(fileLocation));

            // An element
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            basic64ScreenshotData = loginBtnElem.getScreenshotAs(OutputType.FILE);
            fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginBtn.png");
            FileUtils.copyFile(basic64ScreenshotData, new File(fileLocation));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
