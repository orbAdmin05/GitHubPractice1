package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    //Do not allow to initialize this class from outside
    private DriverFactory(){
        //Do- nothing----Empty Constructor
    }

    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);
    private static final DriverFactory instance = new DriverFactory();
    public static DriverFactory getInstance(){
        return instance;
    }
    // Thread local driver object for WebDriver
    ThreadLocal<AppiumDriver> driver = ThreadLocal.withInitial(() -> { //Using Lambda Expression
                URL url = null;

                try {
                    url = new URL(ReadConfigFiles.getPropertyValues("appiumURL"));
                    LOGGER.info("Appium URL is: " + url);
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }

                CapabilitiesManager caps = new CapabilitiesManager();
                return new AndroidDriver(url, caps.getCaps());
                 });

    // Call this method to get the driver object and launch the browser
    public  AppiumDriver getDriver(){
        return driver.get();
    }

    public void removeDriver(){
        driver.get().quit();
        driver.remove();
    }
}
