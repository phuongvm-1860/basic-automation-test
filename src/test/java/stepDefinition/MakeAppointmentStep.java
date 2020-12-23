package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.AppointmentPage;
import pageObjects.login.LoginPage;
import utility.GetPropertiesValue;
import utility.ScenarioContext;
import utility.TestBase;

public class MakeAppointmentStep extends TestBase {

    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    public MakeAppointmentStep(ScenarioContext context) {
        scenarioContext = context;
    }

    @Given("^user login with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userLoginWithUsernameAsAndPasswordAs(String username, String password) {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL") + "/profile.php#login");
        LoginPage.username().sendKeys("John Doe");
        LoginPage.password().sendKeys("ThisIsNotAPassword");
        LoginPage.loginButton().click();
    }

    @When("^user inputs facility as \"([^\"]*)\"$")
    public void userInputsFacilityAs(String arg0) {
        Select facility = new Select(AppointmentPage.cb_facility());
        facility.selectByValue(arg0);
    }

    @And("^user selects status as \"([^\"]*)\"$")
    public void statusAs(String arg0) {
        if (arg0.matches("Checked"))
            AppointmentPage.cb_apply_for_hospital().click();
    }

    @And("^user clicks on book appointment button$")
    public void userClicksOnBookAppointmentButton() throws InterruptedException {
        AppointmentPage.btn_book_appointment().click();
        Thread.sleep(1000);
    }


    @And("^user selects healthcare program as \"([^\"]*)\"$")
    public void healthcareProgramAs(String arg0) {
        if (arg0.matches("Medicare")) {
            AppointmentPage.radio_medicare().click();
        } else if (arg0.matches("Medicaid"))
            AppointmentPage.radio_medicaid().click();
        else AppointmentPage.radio_none().click();
    }

    @And("^user inputs visit date as \"([^\"]*)\"$")
    public void visitdateAs(String arg0) {
        AppointmentPage.txt_visit_date().sendKeys(arg0);
    }

    @And("^user inputs comment as \"([^\"]*)\"$")
    public void commentAs(String keywords) {
        AppointmentPage.txt_comment().sendKeys(keywords);
    }

    @Then("^user sees appointment confirm screen is showed$")
    public void appointmentConfirmScreenIsOpenedAndShowInfomationAsBelow() throws InterruptedException {
        Thread.sleep(1500);
    }
}

