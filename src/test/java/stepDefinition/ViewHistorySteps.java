package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.login.AppointmentConfirmPage;
import pageObjects.login.AppointmentPage;
import pageObjects.login.ViewHistoryPage;

import java.util.List;
import java.util.Map;

public class ViewHistorySteps {

    @And("^user clicks on sidebar$")
    public void userClicksOnSidebar() {
        ViewHistoryPage.sidebar().click();
    }

    @And("^user clicks on History$")
    public void userClicksOnHistory() {
        ViewHistoryPage.historyMenu().click();
    }

    @And("^user creat Appoinment as below$")
    public void userCreatAppoinmentAsBelow(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {

            AppointmentPage.facilityBox().sendKeys(data.get(i).get("facility"));
            if (data.get(i).get("action").equals("Yes"))
                AppointmentPage.applyCheckbox().click();
            if (data.get(i).get("HealthcareProgram").equals("Medicare"))
                AppointmentPage.MedicareRadiobtn().click();
            else if (data.get(i).get("HealthcareProgram").equals("Medicaid"))
                AppointmentPage.MedicaidRadiobtn().click();
            else
                AppointmentPage.NoneRadiobtn().click();
            AppointmentPage.dateBox().sendKeys(data.get(i).get("date"));
            AppointmentPage.commentBox().sendKeys(data.get(i).get("comment"));
            AppointmentPage.BookAppointmentbtn().click();
            AppointmentConfirmPage.Home().click();
        }


    }

    @And("^user sees ViewHistory page as below$")
    public void userSeesViewHistoryPageAsBelow(DataTable table) {
        List<Map<String, String>> data1 = table.asMaps(String.class, String.class);
        for(int i=0;i<data1.size();i++){
            Assert.assertEquals(ViewHistoryPage.facilityInfo().get(i).getText(),data1.get(i).get("facility1"));
            Assert.assertEquals(ViewHistoryPage.applyInfor().get(i).getText(),data1.get(i).get("action1"));
            Assert.assertEquals(ViewHistoryPage.HealthcareProgramInfo().get(i).getText(),data1.get(i).get("HealthcareProgram1"));
            Assert.assertEquals(ViewHistoryPage.dateInfo().get(i).getText(),data1.get(i).get("date1"));
            Assert.assertEquals(ViewHistoryPage.commentInfo().get(i).getText(),data1.get(i).get("comment1"));
        }
    }
}