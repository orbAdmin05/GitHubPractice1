package mobile_automation;


import org.junit.Test;
import utilities.CreateDriverSession;

import java.io.File;

public class DummyApp {
    @Test
    public void launchDummyApp(){
        String deviceName = "Pixel 5";
        String udId = "emulator-5554";
        // src/test/resources/apps/ApiDemos-debug.apk
        String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator +"test" +File.separator
                + "resources" +File.separator + "apps" +File.separator + "ApiDemos-debug.apk";
        String appPackage = "io.appium.android.apis";
        String appActivity = "io.appium.android.apis.ApiDemos";
        CreateDriverSession.androidDriverSession(deviceName,udId,appPath,appPackage,appActivity);
    }
}
