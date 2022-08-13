package tests.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameter {
    @Test
    @Parameters({"udid","systemPort"})
    public void testParameter(String udid, String systemPort){
        System.out.printf("Udid: %s |SystemPort: %s\n", udid,systemPort);
    }

}
