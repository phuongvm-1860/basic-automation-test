package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.login.AppointmentConfirmPage;
import pageObjects.login.AppointmentPage;
import pageObjects.login.LoginPage;
import utility.GetPropertiesValue;
import utility.TestBase;

public class MakeAppointmentSteps extends TestBase {
    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    @Given("^user is in Katalon login pages$")
    public void userIsInKatalonLoginPages() {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL"));
    }

    @When("^user signed in as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSignedInAsAnd(String username, String password) throws Throwable {
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
    }

    @And("^user clicks on login buttons$")
    public void userClicksOnLoginButtons() {
        LoginPage.loginButton().click();
    }


    @When("^user selects facility as \"([^\"]*)\"$")
    public void userSelectsFacilityAs(String facility) throws Throwable {
        AppointmentPage.facilityBox().sendKeys(facility);
    }

    @And("^user \"([^\"]*)\" in checkbox$")
    public void userInCheckbox(String action) throws Throwable {
        if (action.matches("Yes")) {
            AppointmentPage.applyCheckbox().click();
        }

    }

    @And("^user clicks on \"([^\"]*)\"$")
    public void userClicksOn(String HealthcareProgram) {
        if (HealthcareProgram.matches("Medicare")) {
            AppointmentPage.MedicareRadiobtn().click();
        }
        if (HealthcareProgram.matches("Medicaid")) {
            AppointmentPage.MedicaidRadiobtn().click();
        }
        if (HealthcareProgram.matches("None")) {
            AppointmentPage.NoneRadiobtn().click();
        }
    }


    @And("^user selects visit date as \"([^\"]*)\"$")
    public void userSelectsVisitDateAs(String date) throws Throwable {
        AppointmentPage.dateBox().sendKeys(date);
    }

    @And("^user selects comment as \"([^\"]*)\"$")
    public void userSelectsCommentAs(String comment) throws Throwable {
        AppointmentPage.commentBox().sendKeys(comment);
    }

    @And("^user clicks on Book Appointment button$")
    public void userClicksOnBookAppointmentButton() {
        AppointmentPage.BookAppointmentbtn().click();
    }

    @Then("^user sees Appointment Confirmation page$")
    public void userSeesAppointmentConfirmationPage() {
        Assert.assertTrue(AppointmentConfirmPage.Home().isDisplayed());
    }

}
