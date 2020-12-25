package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.login.AppointmentPage;
import pageObjects.login.LoginPage;
import pageObjects.login.LogoutPage;
import pageObjects.login.ViewHistoryPage;

public class LogoutSteps {

    @And("^user clicks Logout button$")
    public void userClicksLogoutButton() {
        LogoutPage.OUt().click();
    }

    @Then("^user sees Login page$")
    public void userSeesLoginPage() {
        Assert.assertTrue(LoginPage.MakeAppoinmentButton().isDisplayed());
    }
}
