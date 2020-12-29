package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.login.LoginPage;
import pageObjects.login.MenuPage;
import utility.GetPropertiesValue;
import utility.ScenarioContext;
import utility.TestBase;

public class LogoutSteps extends TestBase {
    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    public LogoutSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Given("^User login with account as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userLoginWithAccountAsAndPasswordAs(String arg0, String arg1) throws Throwable {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL") + "/profile.php#login");
        LoginPage.username().sendKeys(arg0);
        LoginPage.password().sendKeys(arg1);
        LoginPage.loginButton().click();
    }

    @When("^User click Menu button$")
    public void userClickMenuButton() {
        MenuPage.menuButton().click();
    }

    @And("^User click Logout button$")
    public void userClickLogoutButton() {
        MenuPage.logoutButton().click();
    }

    @Then("^User is in Home page with link \"([^\"]*)\"$")
    public void userIsInHomePageWithLink(String arg0) throws Throwable {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL"));

    }
}
