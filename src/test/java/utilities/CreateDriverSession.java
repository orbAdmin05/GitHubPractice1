package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static void androidDriverSession(String deviceName, String udId, String appPath, String appPackage, String appActivity){

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        caps.setCapability(MobileCapabilityType.APP,appPath);
        caps.setCapability("appPackage",appPackage);
        caps.setCapability("appActivity",appActivity);
        URL url = null;
        try {
            url = new URL("http://localhost:4723/wd/hub");
        }catch (MalformedURLException e){
            System.out.println("Unable to connect to APPIUM Server: " + e.getMessage());
        }
        AppiumDriver driver = new AndroidDriver(url,caps);
    }
}
