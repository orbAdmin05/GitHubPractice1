package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.DriverFactory;

import java.time.Duration;

public class Hooks {
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    public  static AppiumDriver driver;

    @Before
    public void initialize(Scenario scenario){
        LOGGER.info(String.format("-----Scenario : %s------",scenario.getName()));
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void cleanup(Scenario scenario){
        DriverFactory.getInstance().removeDriver();
        LOGGER.info(String.format("-----End Scenario : %s------",scenario.getName()));
    }
}
