package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.*;
import utility.GetPropertiesValue;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class ViewHistoryStep extends TestBase {
    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    @Given("^the user login with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void usersLoginWithUsernameAsAndPasswordAs(String username, String password) {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL") + "/profile.php#login");
        LoginPage.username().sendKeys("John Doe");
        LoginPage.password().sendKeys("ThisIsNotAPassword");
        LoginPage.loginButton().click();
    }

    @When("^user inputs all items value as below$")
    public void usersInputsAllItemsValueAsBelow(DataTable table) throws InterruptedException {
        List<Map<String, String>> tableInput = table.asMaps(String.class, String.class);
        int i;
        for (i = 0; i < tableInput.size(); i++) {
            Select facility = new Select(AppointmentPage.cb_facility());
            facility.selectByValue(tableInput.get(i).get("facility"));

            if (tableInput.get(i).get("apply_for_hospital").matches("yes"))
                AppointmentPage.cb_apply_for_hospital().click();

            if (tableInput.get(i).get("health_care").matches("Medicare"))
                AppointmentPage.radio_medicare().click();
            else if (tableInput.get(i).get("health_care").matches("Medicaid"))
                AppointmentPage.radio_medicaid().click();
            else
                AppointmentPage.radio_none().click();

            AppointmentPage.txt_visit_date().sendKeys(tableInput.get(i).get("visit_date"));
            AppointmentPage.txt_comment().sendKeys(tableInput.get(i).get("comment"));
            AppointmentPage.btn_book_appointment().click();
            Thread.sleep(500);
            AppointmentConfirmationPage.btn_goto_homepage().click();
            Thread.sleep(500);
        }
    }

    @And("^user clicks at menu$")
    public void userClicksAtMenu() {
        MenuPage.click_menu().click();
    }

    @And("^user selects history$")
    public void userSelectsHistory() {
        MenuPage.click_history().click();
    }

    @Then("^user sees appointment as below$")
    public void userSeesAppointmentConfirmScreenIsOpened(DataTable table) throws InterruptedException {
        List<Map<String, String>> tableResult = table.asMaps(String.class, String.class);
        for (int i = 0; i < tableResult.size(); i++) {
            Assert.assertEquals(ViewHistoryPage.lb_facility().get(i).getText(), tableResult.get(i).get("facility1"));
            Assert.assertEquals(ViewHistoryPage.lb_apply_for_hospital().get(i).getText(), tableResult.get(i).get("apply_for_hospital1"));
            Assert.assertEquals(ViewHistoryPage.lb_health_care().get(i).getText(), tableResult.get(i).get("health_care1"));
            Assert.assertEquals(ViewHistoryPage.lb_visit_date().get(i).getText(), tableResult.get(i).get("visit_date1"));
            Assert.assertEquals(ViewHistoryPage.lb_comment().get(i).getText(), tableResult.get(i).get("comment1"));
        }
        Thread.sleep(1500);
    }
}
