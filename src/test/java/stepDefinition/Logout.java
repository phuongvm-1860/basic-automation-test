package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.login.LogoutPage;

public class Logout {
    @When("^user click on icon menu button$")
    public void userClickOnIconMenuButton() {
        LogoutPage.menuIcon().click();
    }

    @And("^user clicks on logout button$")
    public void userClicksOnLogoutButton() {
        LogoutPage.logoutButton().click();
    }

    @Then("^user logout successfully and display login button$")
    public void userLogoutSuccessfullyAndDisplayLoginButton() {
        LogoutPage.menuIcon().click();
        Assert.assertTrue(LogoutPage.loginButton().isDisplayed());
    }
}
