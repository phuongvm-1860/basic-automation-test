package stepDefinition;

import cucumber.api.DataTable;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.AppointmentPage;
import pageObjects.login.ConfirmationPage;
import pageObjects.login.LoginPage;
import utility.TestBase;
import java.util.List;
import java.util.Map;

public class MakeAppointmentSteps extends TestBase {

    @Given("^user signed in as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSignedInAsUsernamePassword(String username, String password) {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
        LoginPage.loginButton().click();
    }
    @When("^user select \"([^\"]*)\"$")
    public void userSelectFacility(String facility) {
        Select facility1 = new Select(AppointmentPage.facilityBox());
        facility1.selectByVisibleText(facility);
    }
    @And("^user clicks on \"([^\"]*)\" apply$")
    public void userClicksOnApply(String checkBox) {
        if("Click".equals(checkBox))
        AppointmentPage.checkBox().click();
    }
    @And("^user choose \"([^\"]*)\"$")
    public void userChoose(String program) {
        if (program.matches("medicare")) {
            AppointmentPage.MedicareRadioButton().click();
        } else if (program.matches("medicaid")) {
            AppointmentPage.MedicaidRadioButton().click();
        } else if (program.matches("None")) {
            AppointmentPage.NoneRadioButton().click();
        }
    }
    @And("^user input \"([^\"]*)\"$")
    public void userInputDate(String visitDate) { AppointmentPage.visitDate().sendKeys(visitDate);
    }
    @And("^user add \"([^\"]*)\"$")
    public void userAdd(String comment) { AppointmentPage.comment().sendKeys(comment);
    }

    @And("^user clicks on Book Appointment button$")
    public void userClicksOnBookAppointmentButton() { AppointmentPage.bookAppointmentBtn().click();
    }
    @Then("^user confirmation appointment page$")
    public void userConfirmationAppointmentPage(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals(ConfirmationPage.confirmFacility().getText(), data.get(i).get("checkBoxConfirmFacility"));
            Assert.assertEquals(ConfirmationPage.confirmApply().getText(), data.get(i).get("checkApply"));
            Assert.assertEquals(ConfirmationPage.confirmHealthcareProgram().getText(), data.get(i).get("checkHealthcareProgram"));
            Assert.assertEquals(ConfirmationPage.confirmVisitDate().getText(), data.get(i).get("checkDate"));
            Assert.assertEquals(ConfirmationPage.confirmComment().getText(), data.get(i).get("checkComment"));
        }
    }
}
