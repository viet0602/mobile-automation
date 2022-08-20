package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.List;

public class InputFormTest {

    public static void main(String[] args) {

        String inputText = "This is testing from Viet";

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);
        try {
            MobileElement navFormsBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormsBtnElem.click();

            // Wait until user is on Forms screen
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Form components\")")));

            // Find Forms form elements
            MobileElement textInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            MobileElement switchBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
            MobileElement dropDownBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Dropdown"));
            MobileElement activeBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-Active"));

            // Fill the forms
            textInputElem.sendKeys(inputText);
            // Check inputted and display text
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().text(\"This is testing from Viet\")")));

            // Click Switch button
            switchBtnElem.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Click to turn the switch OFF\")")));
            // Click dropdown button
            dropDownBtnElem.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.wdiodemoapp:id/select_dialog_listview")));
            // Click an item in Dropdown List
            MobileElement appiumOptionElem = appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Appium is awesome\")"));
            appiumOptionElem.click();
            //Verify Dropdown option display
            wait.until(ExpectedConditions
                            .visibilityOfElementLocated(MobileBy
                            .AndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").text(\"Appium is awesome\")")));
            activeBtnElem.click();
            wait.until(ExpectedConditions
                            .visibilityOfElementLocated(MobileBy
                            .AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"This button is active\")")));
            // Tear Down
            MobileElement cancelBtnElem = appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").text(\"CANCEL\")"));
            cancelBtnElem.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
