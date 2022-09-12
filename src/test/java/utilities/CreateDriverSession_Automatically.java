package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession_Automatically {

    public static void androidDriverSession_Automatically(String deviceName, String udId, String appPath){

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
       // caps.setCapability(MobileCapabilityType.APP,appPath);
        caps.setCapability("appPackage","io.appium.android.apis");
        caps.setCapability("appActivity","io.appium.android.apis.ApiDemos");
        caps.setCapability("avd","Pixel_4");
        caps.setCapability("avdLaunchTimeout",180000);
        URL url = null;
        try {
            url = new URL("http://localhost:4723/wd/hub");
        }catch (MalformedURLException e){
            System.out.println("Unable to connect to APPIUM Server: " + e.getMessage());
        }
        AppiumDriver driver = new AndroidDriver(url,caps);
    }
}
