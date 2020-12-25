package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.login.AppointmentConfirmPage;
import pageObjects.login.AppointmentPage;
import pageObjects.login.Homepage;
import pageObjects.login.LoginPage;
import utility.GetPropertiesValue;
import utility.TestBase;

public class MakeAppointment extends TestBase {

    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    @Given("^user signed in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSignedWithAnd(String arg1, String arg2) {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL") + "/profile.php#login");
        LoginPage.username().sendKeys("John Doe");
        LoginPage.password().sendKeys("ThisIsNotAPassword");
        LoginPage.loginButton().click();
    }

    @When("^user selects facility as \"([^\"]*)\"$")
    public void userSelectsFacilityAs(String facility) {
        AppointmentPage.facilityBox().sendKeys(facility);

    }

    @And("^user clicks on action \"([^\"]*)\"$")
    public void userClicksaction(String action) {
        if (action.matches("Checked"))
            AppointmentPage.applyCheckbox().click();
    }

    @And("^user clicks on \"([^\"]*)\"$")
    public void userClicksOn(String Healthcare) {
        if (Healthcare.matches("Medicare")) {
            AppointmentPage.MedicareRadiobtn().click();
        } else if (Healthcare.matches("Medicaid"))
            AppointmentPage.MedicaidRadiobtn().click();
        else {
            AppointmentPage.NoneRadiobtn().click();
        }
    }

    @And("^user selects visit date as \"([^\"]*)\"$")
    public void userSelectsVisitDateAs(String date) {
        AppointmentPage.dateBox().sendKeys(date);
    }

    @And("^user selects comment as \"([^\"]*)\"$")
    public void userSelectsCommentAs(String comment) {
       AppointmentPage.commentBox().sendKeys(comment);
    }

    @And("^user clicks on Book Appointment button$")
    public void userClicksOnBookAppointmentButton() {
        AppointmentPage.BookAppointmentbtn().click();
    }

    @Then("^user sees Appointment Confirmation page$")
    public void userSeesAppointmentConfirmationPage() {
        Assert.assertTrue(AppointmentConfirmPage.goToBtn().isDisplayed());
    }

    @Then("^user sees \"([^\"]*)\" and \"([^\"]*)\" in checkbox and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSeesAndInCheckboxAndAndAnd(String facility, String action, String healthcare, String date, String comment) {

        Assert.assertEquals(facility, AppointmentConfirmPage.facility_confirm().getText());
        if (action.matches("Checked")) {
            Assert.assertEquals("Yes", AppointmentConfirmPage.apply_confirm().getText());
        } else {
            Assert.assertEquals("No", AppointmentConfirmPage.apply_confirm().getText());
        }
        if (healthcare.matches("Medicare"))
            Assert.assertEquals(healthcare, AppointmentConfirmPage.healthcare_confirm().getText());
        else if (healthcare.matches("Medicaid"))
            Assert.assertEquals(healthcare, AppointmentConfirmPage.healthcare_confirm().getText());
        else
            Assert.assertEquals(healthcare, AppointmentConfirmPage.healthcare_confirm().getText());

        Assert.assertEquals(date, AppointmentConfirmPage.date_confirm().getText());
        Assert.assertEquals(comment, AppointmentConfirmPage.comment_confirm().getText());
    }

    @And("^user clicks on Go to homepage button$")
    public void userClicksOnGoToHomepageButton() {
        AppointmentConfirmPage.goToBtn().click();
    }

    @Then("^user sees homepage$")
    public void userSeesHomepage() {
        Assert.assertTrue(Homepage.makeApointmentbtn().isDisplayed());
    }
}

