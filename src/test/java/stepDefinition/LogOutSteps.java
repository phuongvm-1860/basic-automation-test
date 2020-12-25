package stepDefinition;

import cucumber.api.java.da.Men;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.login.LoginPage;
import pageObjects.login.LogOutPage;
import pageObjects.login.MenuPage;
import utility.TestBase;

public class LogOutSteps extends TestBase {
    @Given("^Given user signed in as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void givenUserSignedInAsAnd(String username, String password) {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
        LoginPage.loginButton().click();
    }
    @And("^user clicks logout button on menu bar$")
    public void userClicksLogoutButtonOnMenuBar() {
        MenuPage.menuBarBtn().click();
    }
    @And("^user logout appointment page$")
    public void userLogoutAppointmentPage() { LogOutPage.logOutBtn().click();
    }
    @Then("^user can click login button on menubar$")
    public void userCanClickLoginButtonOnMenubar() {
        MenuPage.menuBarBtn().click();
        LogOutPage.loginBtn().click();
    }
}
