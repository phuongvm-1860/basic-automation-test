package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pageObjects.login.MakeAppointmentPage;
import pageObjects.login.ViewHistory;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class ViewHistorySteps extends TestBase {
    @And("^user view history$")
    public void userViewHistory(DataTable table) {
        ViewHistory.menu().click();
        ViewHistory.btnViewHistory().click();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals(data.get(i).get("Result Facility"), ViewHistory.historyFacility().get(i).getText());
            Assert.assertEquals(data.get(i).get("Result Hospital Readmission"), ViewHistory.historyHospitalReadmission().get(i).getText());
            Assert.assertEquals(data.get(i).get("Result Healthcare Program"), ViewHistory.historyHealthcareProgram().get(i).getText());
            Assert.assertEquals(data.get(i).get("Result Date"), ViewHistory.historyDate().get(i).getText());
            Assert.assertEquals(data.get(i).get("Result Comment"), ViewHistory.historyComment().get(i).getText());
        }
    }

//    @And("^user goes back to Homepage$")
//    public void userGoesBackToHomepage() {
//        ViewHistory.btnHomePage().click();
//    }
//
//    @And("^user clicks button Make Appointment$")
//    public void userClicksButtonMakeAppointment() throws InterruptedException {
//        ViewHistory.btnMakeAppointment().click();
//        Thread.sleep(2000);
//    }

    @When("^user makes appointment with info as below$")
    public void userMakesAppointmentWithInfoAsBelow(DataTable table) throws InterruptedException {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            Select facilityOption = new Select(MakeAppointmentPage.facility());
            facilityOption.selectByVisibleText(data.get(i).get("Facility"));
            if (data.get(i).get("Hospital Readmission").matches("Check"))
                MakeAppointmentPage.checkbox().click();
            else {
            }
            if (data.get(i).get("Healthcare Program").matches("Medicaid"))
                MakeAppointmentPage.optionMedicaid().click();
            else if (data.get(i).get("Healthcare Program").matches("Medicare"))
                MakeAppointmentPage.optionMedicare().click();
            else
                MakeAppointmentPage.optionNone().click();
            MakeAppointmentPage.dateInput().click();
            MakeAppointmentPage.dateInput().sendKeys("13/3/1997");
            MakeAppointmentPage.commentInput().click();
            if (data.get(i).get("Comment").matches("Comment"))
                MakeAppointmentPage.commentInput().sendKeys("huhuhu");
            else
                MakeAppointmentPage.commentInput().click();
            MakeAppointmentPage.btnBookAppointment().click();
            ViewHistory.btnHomePage().click();
            ViewHistory.btnMakeAppointment().click();
            Thread.sleep(2000);
        }
    }
}