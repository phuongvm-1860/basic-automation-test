package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.login.LoginPage;

public class DemoStepdefs {
    @When("^user sets usernames as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userSetsUsernameAsAndPasswordAs(String arg1, String arg2){
        LoginPage.username().sendKeys(arg1);
        LoginPage.password().sendKeys(arg2);
    }

    @Then("^user sees \"([^\"]*)\"$")
    public void userSees(String error){

        Assert.assertEquals(LoginPage.loginButton().getText(),error);
    }
}
