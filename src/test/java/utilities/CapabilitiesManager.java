package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CapabilitiesManager {
    private  final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public static void androidDriverSession(String deviceName, String udId, String appPath, String appPackage, String appActivity ){
        //Setting Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        caps.setCapability(MobileCapabilityType.APP,appPath); // we have app already
        caps.setCapability("appPackage",appPackage);
        caps.setCapability("appActivity",appActivity);
        URL url = null;
        try {
            url = new URL("http://localhost:4723/wd/hub");
        }catch (MalformedURLException e){
            System.out.println("Unable to connect to APPIUM Server: " +e.getMessage());
        }
        AppiumDriver driver = new AndroidDriver(url,caps);
    }
    public DesiredCapabilities getCaps(){
        // Reading values from the config files
        String deviceName = ReadConfigFiles.getPropertyValues("deviceName");
        String udId = ReadConfigFiles.getPropertyValues("udId");
        String androidAutomationName = ReadConfigFiles.getPropertyValues("androidAutomationName");
        String appPackage = ReadConfigFiles.getPropertyValues("androidAppPackage");
        String appActivity = ReadConfigFiles.getPropertyValues("androidAppActivity");
        String appName = ReadConfigFiles.getPropertyValues("androidAppName");
        String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator +"test" +File.separator
                + "resources" +File.separator + "apps" +File.separator + appName;
        LOGGER.debug("App Location is: " +appPath);

        // Setting Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, androidAutomationName);
        caps.setCapability(MobileCapabilityType.UDID,udId);
        //caps.setCapability(MobileCapabilityType.APP,appPath); // we have app already
        caps.setCapability("appPackage",appPackage);
        caps.setCapability("appActivity",appActivity);

        return caps;
    }
}
