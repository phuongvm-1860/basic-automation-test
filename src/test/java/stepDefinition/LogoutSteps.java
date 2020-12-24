package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.login.Logout;
import pageObjects.login.ViewHistory;
import utility.TestBase;

public class LogoutSteps extends TestBase {
    @When("^user clicks on menu$")
    public void userClicksOnMenu() {
        ViewHistory.menu().click();
    }

    @And("^user clicks on logout button$")
    public void userClicksOnLogoutButton() throws InterruptedException {
        Logout.btnLogout().click();;
        Thread.sleep(3000);
    }

    @Then("^user logs out successfully$")
    public void userLogsOutSuccessfully() {
        ViewHistory.menu().click();
        Assert.assertTrue(Logout.btnLogin().isDisplayed());
    }
}
