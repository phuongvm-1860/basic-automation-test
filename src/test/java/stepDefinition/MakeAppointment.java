package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.AppointmentPage;
import pageObjects.login.ConfirmPage;
import pageObjects.login.LoginPage;
import utility.GetPropertiesValue;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class MakeAppointment extends TestBase {

    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    @Given("^user login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLoginWithUsernameAndPassword(String username, String password) {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL")+"/profile.php#login");
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
        LoginPage.loginButton().click();
    }
    @When("^user sets facility as \"([^\"]*)\"$")
    public void userSetsFacilityAs(String facility) {
        Select facilityBox = new Select(AppointmentPage.facilityBox());
        facilityBox.selectByValue(facility);
    }
    @And("^user \"([^\"]*)\" on check box$")
    public void userOnCheckBox(String check) {
        if(check.matches("Yes")){
            AppointmentPage.checkBox().click();
        } else{
        }
    }
    @And("^user sets healthcare program as \"([^\"]*)\"$")
    public void userSetsHealthcareProgramAs1(String program) {
        if (program.matches("Medicare")) {
            AppointmentPage.medicareRadio().click();
        } else if (program.matches("Medicaid")) {
            AppointmentPage.medicaidRadio().click();
        } else if (program.matches("None")) {
            AppointmentPage.noneRadio().click();
        }
    }
    @And("^user set visit date as \"([^\"]*)\"$")
    public void userSetVisitDateAs(String date) {
        AppointmentPage.dateBox().sendKeys(date);
    }
    @And("^user sets comment as \"([^\"]*)\"$")
    public void userSetsCommentAs(String comment) {
        AppointmentPage.commentBox().sendKeys(comment);
    }
    @And("^user clicks on Booking Appointment button$")
    public void userClicksOnBookingAppointmentButton() {
        AppointmentPage.bookAppointmentButton().click();
    }
    @Then("^user sees Appointment Confirmation page with data$")
    public void userSeesAppointmentConfirmationPageWithData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals(ConfirmPage.facilityContent().getText(), data.get(i).get("facility"));
            Assert.assertEquals(ConfirmPage.checkValue().getText(), data.get(i).get("check"));
            Assert.assertEquals(ConfirmPage.radio().getText(), data.get(i).get("healthcare_program"));
            Assert.assertEquals(ConfirmPage.date().getText(), data.get(i).get("visit_date"));
            Assert.assertEquals(ConfirmPage.comment().getText(), data.get(i).get("comment"));
        }
    }
}
