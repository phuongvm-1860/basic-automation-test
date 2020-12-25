package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.login.AppointmentPage;
import pageObjects.login.Homepage;
import pageObjects.login.LoginPage;
import utility.GetPropertiesValue;
import utility.TestBase;

public class Logout extends TestBase {

    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    @When("^user clicks on menu button$")
    public void userClicksOnMenuButton() {
        AppointmentPage.menu().click();
    }

    @And("^user clicks on logout button$")
    public void userClicksOnLogoutButton() {
        AppointmentPage.logutBtn().click();
    }

    @Then("^user sees home screen$")
    public void userSeesHomeScreen() {
        Assert.assertTrue(Homepage.makeApointmentbtn().isDisplayed());
    }
}
