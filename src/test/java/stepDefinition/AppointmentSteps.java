package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.AppointmentPage;
import pageObjects.login.ConfirmationPage;
import pageObjects.login.LoginPage;
import utility.GetPropertiesValue;
import utility.ScenarioContext;
import utility.TestBase;

import java.awt.*;

public class AppointmentSteps extends TestBase {

    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    public AppointmentSteps(ScenarioContext context) {
        scenarioContext = context;
    }
    

    @Given("^User login with account \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userLoginWithAccountAndPasswordAs(String username, String password) {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL") + "/profile.php#login");
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
        LoginPage.loginButton().click();
    }

    @When("^User input facility as \"([^\"]*)\"$")
    public void userInputFacilityAs(String facility) throws Throwable {
        Select facilityItem = new Select(AppointmentPage.facilityBox());
        facilityItem.selectByVisibleText(facility);
    }


    @And("^User input readmission \"([^\"]*)\"$")
    public void userInputReadmission(String arg0) throws Throwable {
        if (arg0.matches("Yes")) {
            AppointmentPage.readmission().click();
        }
    }


    @And("^User input healthcare program as \"([^\"]*)\"$")
    public void userInputHealthcareProgramAs(String arg0) throws Throwable {
        AppointmentPage.healthProgram().click();
    }

    @And("^User input visit date as \"([^\"]*)\"$")
    public void userInputVisitDateAs(String arg0) throws Throwable {
        AppointmentPage.visitDateTextbox().sendKeys(arg0);
    }

    @And("^User input comment as \"([^\"]*)\" as below and submit the form$")
    public void userInputCommentAsAsBelowAndSubmitTheForm(String arg0) throws Throwable {
        AppointmentPage.commentBox().sendKeys(arg0);
    }
    @And("^User submit the form$")
    public void userSubmitTheForm() {
        AppointmentPage.BookButton().click();
    }

//    @Then("^Appointment Confirmation is opend with value correct as inpputted$")
//    public void appointmentConfirmationIsOpendWithValueCorrectAsInputted() {
//        Assert.assertTrue(ConfirmationPage.readmission().isDisplayed());
//    }

    @Then("^User can see facility as \"([^\"]*)\"$")
    public void userCanSeeFacilityAs(String arg0) throws Throwable {
        Assert.assertEquals(arg0, ConfirmationPage.facility().getText());
    }

    @And("^User can see readmission \"([^\"]*)\"$")
    public void userCanSeeReadmission(String arg0) throws Throwable {
        if (arg0.matches("Yes")) {
            Assert.assertEquals("Yes", ConfirmationPage.readmission().getText());
        } else {
            Assert.assertEquals("No", ConfirmationPage.readmission().getText());
        }
    }


    @And("^User can see healthcare program as \"([^\"]*)\"$")
    public void userCanSeeHealthcareProgramAs(String arg0) throws Throwable {
        Assert.assertEquals(arg0, ConfirmationPage.program().getText());

    }


    @And("^User can see visit date as \"([^\"]*)\"$")
    public void userCanSeeVisitDateAs(String arg0) throws Throwable {
        Assert.assertEquals(arg0, ConfirmationPage.visitDate().getText());
    }


    @And("^User can see comment as \"([^\"]*)\" as below and submit the form$")
    public void userCanSeeCommentAsAsBelowAndSubmitTheForm(String arg0) throws Throwable {
        if (arg0.matches(arg0)) {
            Assert.assertEquals(arg0, ConfirmationPage.comment().getText());
        } else {
            Assert.assertEquals("", ConfirmationPage.comment().getText());
        }
    }


}
