package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.ConfirmationAppointmentPage;
import pageObjects.MakeAppointmentPage;
import pageObjects.MenuPage;
import pageObjects.ViewHistoryPage;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class ViewHistorySteps extends TestBase {
    @And("^user clicks on sidebar$")
    public void userClicksOnSidebar() {
        MenuPage.sideMenu().click();
    }

    @And("^user clicks on History$")
    public void userClicksOnHistory() {
        MenuPage.history().click();
    }


    @Then("^user sees List of Appointments as below$")
    public void userSeesListOfAppointmentsAsBelow(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals(ViewHistoryPage.facility().get(i).getText(), data.get(i).get("facility"));
            Assert.assertEquals(ViewHistoryPage.apply().get(i).getText(), data.get(i).get("apply read_mission"));
            Assert.assertEquals(ViewHistoryPage.healthcareInfo().get(i).getText(), data.get(i).get("healthcare_program"));
            Assert.assertEquals(ViewHistoryPage.date().get(i).getText(), data.get(i).get("date"));
            Assert.assertEquals(ViewHistoryPage.comment().get(i).getText(), data.get(i).get("comment"));
        }
    }

    @When("^user input data as below$")
    public void userInputDataAsBelow(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps(String.class, String.class);
        for (int i = 0; i < dataTable.size(); i++) {
            Select facilityList = new Select(MakeAppointmentPage.facility());
            facilityList.selectByValue(dataTable.get(i).get("facilityList"));
            if (dataTable.get(i).get("actionList").matches("Yes")) {
                MakeAppointmentPage.checkbox().click();
            }
            if (dataTable.get(i).get("programList").matches("Medicare")) {
                MakeAppointmentPage.radioBtn_medicare().click();
            } else if (dataTable.get(i).get("programList").matches("Medicaid")) {
                MakeAppointmentPage.radioBtn_medicaid().click();
            } else if (dataTable.get(i).get("programList").matches("None")) {
                MakeAppointmentPage.radioBtn_none().click();
            }
            MakeAppointmentPage.inputDate().sendKeys(dataTable.get(i).get("inputDate"));
            MakeAppointmentPage.comment().sendKeys(dataTable.get(i).get("inputComment"));
            MakeAppointmentPage.bookBtn().click();
            ConfirmationAppointmentPage.homePageBtn().click();
        }
    }
}
