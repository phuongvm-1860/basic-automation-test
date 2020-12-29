package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.AppointmentConfirmationPage;
import pageObjects.AppointmentPage;
import pageObjects.LoginPage;
import utility.GetPropertiesValue;
import utility.TestBase;

public class AppointmentSteps extends TestBase {

    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    @Given("^user signed in with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userSignedInWithUsernameAsAndPasswordAs(String username, String password) {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL") + "/profile.php#login");
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
        LoginPage.loginButton().click();
    }

    @And("^user is in appointment page$")
    public void userIsInAppointmentPage() {
        Assert.assertTrue(AppointmentPage.facilityBox().isDisplayed());
    }

    @When("^user selects facility as \"([^\"]*)\"$")
    public void userSelectsFacilityAs(String facility) {
        Select facility_box = new Select(AppointmentPage.facilityBox());
        facility_box.selectByVisibleText(facility);
    }

    @And("^user select readmission as \"([^\"]*)\"$")
    public void userSelectReadmissionAs(String readmission)  {
        if (readmission.equals("Yes"))
            AppointmentPage.readmission().click();
    }

    @And("^user selects program as \"([^\"]*)\"$")
    public void userSelectsProgramAs(String program)  {
        switch (program){
            case "Medicare":
                AppointmentPage.program_medicare().click();
                break;
            case "Medicaid":
                AppointmentPage.program_medicaid().click();
                break;
            case "None":
                AppointmentPage.program_none().click();
                break;
        }
    }

    @And("^user selects date as \"([^\"]*)\"$")
    public void userSelectsDateAs(String date) {
        AppointmentPage.date().sendKeys(date);
    }

    @And("^user inputs comment as \"([^\"]*)\"$")
    public void userInputsCommentAs(String comment) {
        AppointmentPage.comment().sendKeys(comment);
    }

    @And("^user clicks book appointment button$")
    public void userClicksBookAppointmentButton() {
        AppointmentPage.buttonBookAppointment().click();
    }

    @Then("^user sees facility as \"([^\"]*)\"$")
    public void userSeesFacilityAs(String confirmFacility) {
        Assert.assertEquals(confirmFacility,AppointmentConfirmationPage.facilityInfo().getText());
    }

    @And("^user sees readmission as \"([^\"]*)\"$")
    public void userSeesReadmissionAs(String confirmReadmission) {
        Assert.assertEquals(confirmReadmission,AppointmentConfirmationPage.readmissionInfo().getText());
    }

    @And("^user sees program as \"([^\"]*)\"$")
    public void userSeesProgramAs(String confirmProgram) {
        Assert.assertEquals(confirmProgram,AppointmentConfirmationPage.programInfo().getText());}

    @And("^user sees date as \"([^\"]*)\"$")
    public void userSeesDateAs(String confirmDate) {
        Assert.assertEquals(confirmDate,AppointmentConfirmationPage.dateInfo().getText());}

    @And("^user sees comment as \"([^\"]*)\"$")
    public void userSeesCommentAs(String confirmComment) {
        Assert.assertEquals(confirmComment,AppointmentConfirmationPage.commentInfo().getText());}
}
