package mobile_automation;


import org.junit.Test;
import utilities.CreateDriverSession;

import java.io.File;

public class SwagLabs {

    @Test
    public void launchSwagLabsApp(){
        String deviceName = "Pixel 5";
        String udId = "emulator-5554";
        // src/test/resources/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk
        String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator +"test" +File.separator
                + "resources" +File.separator + "apps" +File.separator + "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
        String appPackage = "com.swaglabsmobileapp";
        String appActivity = "com.swaglabsmobileapp.MainActivity";
        CreateDriverSession.androidDriverSession(deviceName,udId,appPath,appPackage,appActivity);
    }
}
