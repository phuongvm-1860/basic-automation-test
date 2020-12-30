package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.MenuPage;

public class LogoutSteps {
    @And("^user clicks on logout$")
    public void userClicksOnLogout() {
        MenuPage.logOut().click();
    }

    @Then("^user sees top page$")
    public void userSeesTopPage() {
        Assert.assertTrue(MenuPage.makeAppointmentBtnTopPage().isDisplayed());
    }
}
