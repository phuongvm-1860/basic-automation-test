package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.*;
import utility.GetPropertiesValue;
import utility.ScenarioContext;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class HistorySteps extends TestBase {
    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    public HistorySteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Given("^an user login with account \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userLoginWithAccountAndPasswordAs(String username, String password) {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL") + "/profile.php#login");
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
        LoginPage.loginButton().click();
    }
    @When("^User input data as below$")
    public void userInputDataAsBelow(DataTable table) throws InterruptedException {
        List<Map<String, String>> tableInput = table.asMaps(String.class, String.class);
        int i;
        for (i = 0; i < tableInput.size(); i++) {
            Select facility = new Select(AppointmentPage.facilityBox());
            facility.selectByValue(tableInput.get(i).get("Facility"));

            if (tableInput.get(i).get("Apply for hospital readmission").matches("Yes"))
                AppointmentPage.readmission().click();

            if (tableInput.get(i).get("Healthcare Program").matches("Medicare"))
                AppointmentPage.healthProgram().click();
            else if (tableInput.get(i).get("Healthcare Program").matches("Medicaid"))
                AppointmentPage.healthProgram2().click();
            else
                AppointmentPage.healthProgram3().click();

            AppointmentPage.visitDateTextbox().sendKeys(tableInput.get(i).get("Visit Date"));
            AppointmentPage.commentBox().sendKeys(tableInput.get(i).get("Comment"));
            AppointmentPage.BookButton().click();
            Thread.sleep(500);
            ConfirmationPage.goToHomepage().click();
            Thread.sleep(500);
        }
    }

    @And("^User click to Menu button$")
    public void userClickToMenuButton() {
        MenuPage.menuButton().click();
    }

    @And("^User click to History$")
    public void userClickToHistory() {
        MenuPage.historyButton().click();
    }


    @Then("^User can see facility as below$")
    public void userCanSeeFacilityAsBelow(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals(HistoryPage.facility().get(i).getText(), data.get(i).get("Facility1"));
            Assert.assertEquals(HistoryPage.apply().get(i).getText(), data.get(i).get("Apply for hospital readmission1"));
            Assert.assertEquals(HistoryPage.healthcareInfo().get(i).getText(), data.get(i).get("Healthcare Program1"));
            Assert.assertEquals(HistoryPage.date().get(i).getText(), data.get(i).get("Visit Date1"));
            Assert.assertEquals(HistoryPage.comment().get(i).getText(), data.get(i).get("Comment1"));
        }
    }
}
