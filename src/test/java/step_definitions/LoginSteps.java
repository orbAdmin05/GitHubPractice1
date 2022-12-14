package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.Login;

public class LoginSteps {
    AppiumDriver driver =Hooks.driver;
    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void userEnterUsernameAndPassword(String userName, String password){
            new Login(driver)
                    .enterUserName(userName)
                    .enterPassword(password);
    }
    @And("^click on login button$")
    public void clickOnLoginButton(){
        new Login(driver)
                .clickOnLoginButton();
    }
    @Then("^user should get an error message \"(.+?)\"$")
    public void userShouldGetErrorMessage(String errMsg){
        new Login(driver)
                .unsuccessfulLoginError(errMsg);
    }
    @Then("^user should see product page with title \"(.+?)\"$")
    public void userShouldSeeProductPageWithTitle(String title){
        new Login(driver)
                .LoginIsSuccessful(title);
    }
}
