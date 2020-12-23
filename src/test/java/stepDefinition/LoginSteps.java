package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.login.LoginPage;
import utility.GetPropertiesValue;
import utility.TestBase;

public class LoginSteps extends TestBase {

    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    @Given("^login page is opened$")
    public void loginPageIsOpened() {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL") + "/profile.php#login");
    }

    @When("^user inputs user name as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userInputsUserNameAsAndPasswordAs(String username, String password) {
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
    }

    @And("^user clicks on login button$")
    public void userClicksOnLoginButton() {
        LoginPage.loginButton().click();
    }

    @Then("^user sees error message as \"([^\"]*)\" is displayed$")
    public void userSeeErrorMessageAsIsDisplayed(String error) {
        Assert.assertEquals(LoginPage.message().getText(), error);
    }

    @When("^user sets username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userSetsUsernameAsAndPasswordAs(String username, String password) {
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
    }

    @Then("^user sees appointment page$")
    public void userSeesAppointmentPage() throws InterruptedException {
        Thread.sleep(1000);
    }
}
