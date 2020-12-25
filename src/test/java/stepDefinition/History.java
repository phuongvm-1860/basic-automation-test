package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.AppointmentConfirmPage;
import pageObjects.login.AppointmentPage;
import pageObjects.login.Historypage;
import pageObjects.login.LoginPage;
import utility.GetPropertiesValue;
import utility.TestBase;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class History extends TestBase {

    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();

    @Given("^user signed in with acc \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSignedInWithAccAnd(String arg0, String arg1) {
        driver.get(getPropertiesValue.getPropValues("Base_URL.properties", "BASE_URL") + "/profile.php#login");
        LoginPage.username().sendKeys("John Doe");
        LoginPage.password().sendKeys("ThisIsNotAPassword");
        LoginPage.loginButton().click();
    }

    @When("^user input as$")
    public void userInputAs(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps(String.class, String.class);
        for (int i = 0; i < dataTable.size(); i++) {
            Select facilityList = new Select(AppointmentPage.facilityBox());
            facilityList.selectByValue(dataTable.get(i).get("facility"));
            if (dataTable.get(i).get("action").matches("Checked")) {
                AppointmentPage.applyCheckbox().click();
            } else {

            }
            if (dataTable.get(i).get("Healthcare").matches("Medicare")) {
                AppointmentPage.MedicareRadiobtn().click();
            } else if (dataTable.get(i).get("Healthcare").matches("Medicaid")) {
                AppointmentPage.MedicaidRadiobtn().click();
            } else if (dataTable.get(i).get("Healthcare").matches("None")) {
                AppointmentPage.NoneRadiobtn().click();
            }
            AppointmentPage.dateBox().sendKeys(dataTable.get(i).get("date"));
            AppointmentPage.commentBox().sendKeys(dataTable.get(i).get("comment"));
            AppointmentPage.BookAppointmentbtn().click();
            AppointmentConfirmPage.goToBtn().click();
        }
    }

    @And("^user clicks on Menu button$")
    public void userClicksOnMenuButton() {
        Historypage.menu().click();
    }

    @And("^user clicks on history button$")
    public void userClicksOnHistoryButton() {
        Historypage.historyMenu().click();
    }

    @Then("^user can sees list appointment as$")
    public void userCanSeesListAppointmentAs(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals(Historypage.facility_history().get(i).getText(), data.get(i).get("facility_view"));
            Assert.assertEquals(Historypage.apply_history().get(i).getText(), data.get(i).get("action_view"));
            Assert.assertEquals(Historypage.healthcare_history().get(i).getText(), data.get(i).get("Healthcare_view"));
            Assert.assertEquals(Historypage.dateI_history().get(i).getText(), data.get(i).get("date_view"));
            Assert.assertEquals(Historypage.comment_history().get(i).getText(), data.get(i).get("comment_view"));
        }
    }
}
