package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.login.LogoutPage;
import utility.GetPropertiesValue;
import utility.ScenarioContext;
import utility.TestBase;

public class LogoutSteps extends TestBase {
    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();
    public LogoutSteps(ScenarioContext context) {scenarioContext = context;}
    @And("^user clicks on logout button$")
    public void userClicksOnLogoutButton() {
        LogoutPage.logoutButton().click();
    }

    @Then("^user back to homepage$")
    public void userBackToHomepage() {driver.getCurrentUrl();
        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/",driver.getCurrentUrl());
    }
}
