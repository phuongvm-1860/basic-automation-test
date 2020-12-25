package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.*;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class ViewHistorySteps extends TestBase {

    @Given("^the user login with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void usersLoginWithUsernameAsAndPasswordAs(String username, String password) {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        LoginPage.username().sendKeys(username);
        LoginPage.password().sendKeys(password);
        LoginPage.loginButton().click();
    }
    @When("^user inputs all items value as below$")
    public void usersInputsAllItemsValueAsBelow(DataTable table) throws InterruptedException {
        List<Map<String, String>> tableInput = table.asMaps(String.class, String.class);
        for (int i = 0; i < tableInput.size(); i++) {
            AppointmentPage.facilityBox().click();
            Select facility = new Select(AppointmentPage.facilityBox());
            facility.selectByValue(tableInput.get(i).get("viewFacility"));
            if (tableInput.get(i).get("viewApply").matches("Click")) {
                AppointmentPage.checkBox().click();
            }
            if (tableInput.get(i).get("viewHealthCare").matches("Medicare")) {
                AppointmentPage.MedicareRadioButton().click();
            } else if (tableInput.get(i).get("viewHealthCare").matches("Medicaid")) {
                AppointmentPage.MedicaidRadioButton().click();
            } else {
                AppointmentPage.NoneRadioButton().click();
            }
            AppointmentPage.visitDate().sendKeys(tableInput.get(i).get("viewVisitDate"));
            AppointmentPage.comment().sendKeys(tableInput.get(i).get("viewComment"));
            AppointmentPage.bookAppointmentBtn().click();
            Thread.sleep(500);
            ConfirmationPage.goToButton().click();
        }
    }
    @And("^user clicks at menu$")
    public void userClicksAtMenu() {
        MenuPage.menuBarBtn().click();
    }
    @And("^user selects history$")
    public void userSelectsHistory() {
        HistoryPage.historyBtn().click();
    }
    @Then("^user sees appointment as below$")
    public void userSeesAppointmentConfirmScreenIsOpened(DataTable table) {
        List<Map<String, String>> tableResult = table.asMaps(String.class, String.class);
        for (int i = 0; i < tableResult.size(); i++) {
            Assert.assertEquals(HistoryPage.viewFacility().get(i).getText(), tableResult.get(i).get("checkViewFacility"));
            Assert.assertEquals(HistoryPage.viewApply().get(i).getText(), tableResult.get(i).get("checkViewApply"));
            Assert.assertEquals(HistoryPage.viewHeathCare().get(i).getText(), tableResult.get(i).get("checkViewHealthCare"));
            Assert.assertEquals(HistoryPage.viewDate().get(i).getText(), tableResult.get(i).get("checkViewVisitDate"));
            Assert.assertEquals(HistoryPage.viewComment().get(i).getText(), tableResult.get(i).get("checkViewComment"));
        }
    }
}

