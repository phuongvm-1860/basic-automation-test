package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.login.AppointmentConfirmPage;
import utility.GetPropertiesValue;

import java.util.List;
import java.util.Map;

public class ConfirmSteps {
    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();
    @Then("^user sees Appointment Confirmation page as below$")
    public void userSeesAppointmentConfirmationPageAsBelow(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(int i=0;i<data.size();i++){
            Assert.assertEquals(AppointmentConfirmPage.facilitys().get(i).getText(),data.get(i).get("facility"));
            Assert.assertEquals(AppointmentConfirmPage.actions().get(i).getText(),data.get(i).get("action"));
            Assert.assertEquals(AppointmentConfirmPage.HealthcarePrograms().get(i).getText(),data.get(i).get("HealthcareProgram"));
            Assert.assertEquals(AppointmentConfirmPage.dates().get(i).getText(),data.get(i).get("date"));
            Assert.assertEquals(AppointmentConfirmPage.comments().get(i).getText(),data.get(i).get("comment"));
        }
    }

    @Then("^user clicks on Homepage button$")
    public void userClicksOnHomepageButton() {
        AppointmentConfirmPage.Home().click();
    }
}
