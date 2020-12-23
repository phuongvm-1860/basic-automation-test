package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.login.LoginPage;
import pageObjects.login.MenuPage;
import utility.GetPropertiesValue;
import utility.TestBase;

public class LogoutStep extends TestBase {

    @And("^user clicks at logout$")
    public void userClicksAtLogout() {
        MenuPage.click_logout().click();
    }

    @Then("^user sees top page screen is opened$")
    public void userSeeTopageScreen() throws InterruptedException {
        Thread.sleep(1500);
    }
}
