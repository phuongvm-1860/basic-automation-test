package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.LoginPage;
import pageObjects.login.MakeAppointmentPage;
import sun.rmi.runtime.Log;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class MakeAppointmentStep extends TestBase {
    @Given("^user signed in as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSignedInAsAnd(String arg0, String arg1) {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        LoginPage.username().sendKeys("John Doe");
        LoginPage.password().sendKeys("ThisIsNotAPassword");
        LoginPage.loginButton().click();
    }

    @When("^user selects facility \"([^\"]*)\"$")
    public void userSelectsFacility(String facility) {
        MakeAppointmentPage.facility().click();
        Select facilityOption = new Select(driver.findElement(By.xpath("//*[@id='combo_facility']")));
        facilityOption.selectByVisibleText(facility);
    }

    @And("^user selects hospital readmission \"([^\"]*)\"$")
    public void userSelectsHospitalReadmission(String checkHospitalReadmission) {
        if (checkHospitalReadmission.matches("Check"))
            MakeAppointmentPage.checkbox().click();
        else {

        }
    }

    @And("^user selects healthcare program\"([^\"]*)\"$")
    public void userSelectsHealthcareProgram(String checkHealthcareProgram) {
        if (checkHealthcareProgram.matches("Medicaid"))
            MakeAppointmentPage.optionMedicaid().click();
        else if (checkHealthcareProgram.matches("Medicare"))
            MakeAppointmentPage.optionMedicare().click();
        else
            MakeAppointmentPage.optionNone().click();
    }

    @And("^user inputs date\"([^\"]*)\"$")
    public void userInputsDate(String arg0) {
        MakeAppointmentPage.dateInput().click();
        MakeAppointmentPage.dateInput().sendKeys("13/3/1997");
    }

    @And("^user inputs comment\"([^\"]*)\"$")
    public void userInputsComment(String comment) {
        MakeAppointmentPage.commentInput().click();
        if (comment.matches("Comment"))
            MakeAppointmentPage.commentInput().sendKeys("huhuhu");
        else
            MakeAppointmentPage.commentInput().click();
    }

    @And("^user clicks button Book Appointment$")
    public void userClicksButtonBookAppointment() {
        MakeAppointmentPage.btnBookAppointment().click();
    }

    @Then("^user sees Appointment Confirmation$")
    public void userSeesAppointmentConfirmation(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals(MakeAppointmentPage.resultFacility().getText(), data.get(i).get("Result Facility"));
            Assert.assertEquals(MakeAppointmentPage.resultHospitalReadmission().getText(), data.get(i).get("Result Hospital Readmission"));
            Assert.assertEquals(MakeAppointmentPage.resultHealthcareProgram().getText(), data.get(i).get("Result Healthcare Program"));
            Assert.assertEquals(MakeAppointmentPage.resultDate().getText(), data.get(i).get("Result Date"));
            Assert.assertEquals(MakeAppointmentPage.resultComment().getText(), data.get(i).get("Result Comment"));
        }
    }
}