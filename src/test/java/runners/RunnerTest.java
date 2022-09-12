package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.ServerManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","summary","me.jvt.cucumber.report.PrettyReports:target/cucumber-reports"},
        features = "src/test/resources/features",
        glue = {"step_definitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
    static ServerManager serverManager = new ServerManager();

    @BeforeClass
    public static void serverInitialize(){
        serverManager.startAppiumServer();
    }

    @AfterClass
    public static void serverCleanup(){
        serverManager.stopAppiumServer();
    }
}
