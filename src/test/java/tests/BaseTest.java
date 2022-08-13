package tests;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import platform.Platform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BaseTest {

    //List của DriverFactory, synchronized list: Trong quá trình ghi/ thay đổi dữ liệu 1 thành phần trên đó
    // thì ko thằng nào được đụng chạm tới list này
    private static final List<DriverFactory> driverThreadPool = Collections.synchronizedList(new ArrayList<>());
    //Thread local
    private static ThreadLocal<DriverFactory> driverThread;

    private String udid;
    private String systemPort;

    protected AppiumDriver<MobileElement> getDriver() {
        return driverThread.get().getDriver(Platform.ANDROID, udid, systemPort);
    }

    // TestNG chạy sẽ chia ra làm nhiều thread để chạy song song. Mỗi lần chia thread thì
    // tạo 1 DriverFactory rồi nhét vào trong driverThreadPool và trả về driverThread mình đang có
    //Đảm bảo: Cứ 1 thread run thì sẽ có 1 driver factory object khác nhau
    @BeforeTest
    @Parameters({"udid", "systemPort"})
    public void initAppiumSession(String udid, String systemPort) {
        this.udid = udid;
        this.systemPort = systemPort;
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory driverThread = new DriverFactory();
            driverThreadPool.add(driverThread);
            return driverThread;
        });
    }

    @AfterTest(alwaysRun = true)
    public void quitAppiumSession() {
        driverThread.get().quitAppiumDriver();
    }
}
