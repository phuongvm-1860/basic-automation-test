package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.AppointmentPage;
import pageObjects.login.HistoryPage;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class ViewHistory extends TestBase {
    @And("^user input data into all field into$")
    public void userInputDataIntoAllField(DataTable table) throws InterruptedException {
        List<Map<String, String>> dataTable = table.asMaps(String.class, String.class);
        for (int i = 0; i < dataTable.size(); i++) {
            Select facilityBox = new Select(AppointmentPage.facilityBox());
            facilityBox.selectByValue(dataTable.get(i).get("facility"));

            if (dataTable.get(i).get("check").matches("Yes")) {
                AppointmentPage.checkBox().click();
            } else {

            }
            if (dataTable.get(i).get("healthcare_program").matches("Mediacare")) {
                AppointmentPage.medicaidRadio().click();
            } else if (dataTable.get(i).get("healthcare_program").matches("Medicaid")) {
                AppointmentPage.medicaidRadio().click();
            } else if (dataTable.get(i).get("healthcare_program").matches("None")) {
                AppointmentPage.noneRadio().click();
            }
            AppointmentPage.dateBox().sendKeys(dataTable.get(i).get("visit_date"));
            AppointmentPage.commentBox().sendKeys(dataTable.get(i).get("comment"));
            AppointmentPage.bookAppointmentButton().click();
            AppointmentPage.remakeAppointmentButton().click();
        }
    }

    @When("^user click on icon menu$")
    public void userClickOnIconMenu() {
        HistoryPage.menuHistory().click();
    }

    @And("^user click on History button$")
    public void userClickOnHistoryButton() {
        HistoryPage.buttonHistory().click();
    }

    @Then("^user sees history appointment$")
    public void userSeesHistoryAppointmentConfirmation(DataTable table) throws InterruptedException {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals(HistoryPage.dateHistory().get(i).getText(), data.get(i).get("visit_date"));
            Assert.assertEquals(HistoryPage.facilityHistory().get(i).getText(), data.get(i).get("facility"));
            Assert.assertEquals(HistoryPage.hospitalHistory().get(i).getText(), data.get(i).get("check"));
            Assert.assertEquals(HistoryPage.programlHistory().get(i).getText(), data.get(i).get("healthcare_program"));
            Assert.assertEquals(HistoryPage.commentHistory().get(i).getText(), data.get(i).get("comment"));
        }
    }


}


