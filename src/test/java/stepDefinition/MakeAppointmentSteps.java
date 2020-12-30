package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.ConfirmationAppointmentPage;
import pageObjects.LoginPage;
import pageObjects.MakeAppointmentPage;
import utility.GetPropertiesValue;
import utility.TestBase;

public class MakeAppointmentSteps extends TestBase {

    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    @And("^user clicks on Book Appointment button$")
    public void userClicksOnBookAppointmentButton() {
        MakeAppointmentPage.bookBtn().click();
    }

    @And("^user \"([^\"]*)\" in checkbox$")
    public void userInCheckbox(String action) {
        if (action.matches("Yes")) {
            MakeAppointmentPage.checkbox().click();
        }
    }

    @Then("^user sees alert$")
    public void userSeesAlert() {
        String alert = MakeAppointmentPage.inputDate().getAttribute("required");
        Assert.assertEquals("true", alert);
    }

    @Given("^user signed in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSignedInWithAnd(String username, String password) {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL") + "/profile.php#login");
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
        LoginPage.loginButton().click();
    }

    @Then("^user sees facility display as \"([^\"]*)\"$")
    public void userSeesFacilityDisplayAs(String facility) {
        Assert.assertEquals(facility, ConfirmationAppointmentPage.facilityInfo().getText());
    }

    @And("^user sees \"([^\"]*)\" in checkbox$")
    public void userSeesInCheckbox(String action) {
        if (action.matches("Yes")) {
            Assert.assertEquals("Yes", ConfirmationAppointmentPage.applyInfo().getText());
        } else {
            Assert.assertEquals("No", ConfirmationAppointmentPage.applyInfo().getText());
        }
    }

    @And("^user sees \"([^\"]*)\" is display$")
    public void userSeesIsDisplay(String healthcare_program) {
        Assert.assertEquals(healthcare_program, ConfirmationAppointmentPage.healthcareProgramInfo().getText());
    }

    @And("^user sees appointment date as \"([^\"]*)\"$")
    public void userSeesAppointmentDateAs(String date) {
        Assert.assertEquals(date, ConfirmationAppointmentPage.dateInfo().getText());
    }

    @And("^user sees comment as \"([^\"]*)\"$")
    public void userSeesCommentAs(String comment) {
        if (comment.matches("No comment added")) {
            Assert.assertEquals("No comment added", ConfirmationAppointmentPage.commentInfo().getText());
        } else {
            Assert.assertEquals("", ConfirmationAppointmentPage.commentInfo().getText());
        }
    }

    @When("^user select facility as \"([^\"]*)\"$")
    public void userSelectFacilityAs(String selectedFacility) {
        Select facility = new Select(MakeAppointmentPage.facility());
        facility.selectByValue(selectedFacility);
    }

    @And("^user choose program as \"([^\"]*)\"$")
    public void userChooseProgramAs(String program) {
        if (program.matches("Medicare")) {
            MakeAppointmentPage.radioBtn_medicare().click();
        } else if (program.matches("Medicaid")) {
            MakeAppointmentPage.radioBtn_medicaid().click();
        } else {
            MakeAppointmentPage.radioBtn_none().click();
        }
    }

    @And("^user input date as \"([^\"]*)\"$")
    public void userInputDateAs(String date) {
        MakeAppointmentPage.inputDate().sendKeys(date);
    }

    @And("^user add comment as \"([^\"]*)\"$")
    public void userAddCommentAs(String comment)  {
        MakeAppointmentPage.comment().sendKeys(comment);
    }
}
