package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.login.AppointmentPage;
import pageObjects.login.HistoryPage;
import pageObjects.login.SummaryPage;
import utility.TestBase;
import java.util.List;
import java.util.Map;

public class HistorySteps extends TestBase {


    @And("^user clicks hamburger menu$")
    public void userClicksHamburgerMenu() {HistoryPage.hamburgerMenu().click();
    }

    @And("^user choose history$")
    public void userChooseHistory() {
        HistoryPage.history().click();
    }
    @And("^user goes to history page$")
    public void userGoesToHistoryPage() {
        driver.getCurrentUrl();
        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/history.php#history",driver.getCurrentUrl());
    }

    @Then("^user sees no Appointment$")
    public void userSeesNoAppointment() {
        Assert.assertEquals("No appointment.",HistoryPage.noAppointment().getText());
    }

    @When("^user select table as below:$")
    public void userSelectTableAsBelow(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(int i=0;i<data.size();i++){
            AppointmentPage.facilityBox().sendKeys(data.get(i).get("facilityBox"));
            if (data.get(i).get("action").equals("tick"))
                AppointmentPage.apply().click();
            if (data.get(i).get("program").equals("Medicare"))
                AppointmentPage.medicare().click();
            else if (data.get(i).get("program").equals("Medicaid"))
                AppointmentPage.medicaid().click();
            else AppointmentPage.none().click();
            AppointmentPage.date().sendKeys(data.get(i).get("date"));
            AppointmentPage.comment().sendKeys(data.get(i).get("comment"));
            AppointmentPage.bookingButton().click();
            SummaryPage.homepageButton().click();
        }
    }

    @Then("^user sees history as below:$")
    public void userSeesHistoryAsBelow(DataTable table1) {
        List<Map<String, String>> data = table1.asMaps(String.class, String.class);
        for(int i=0;i<data.size();i++){
            Assert.assertEquals(HistoryPage.facility().get(i).getText(),data.get(i).get("facility"));
            Assert.assertEquals(HistoryPage.appointmentDate().get(i).getText(),data.get(i).get("appointment date"));
            Assert.assertEquals(HistoryPage.apply().get(i).getText(),data.get(i).get("action"));
            Assert.assertEquals(HistoryPage.program().get(i).getText(),data.get(i).get("healthcare program"));
            Assert.assertEquals(HistoryPage.comment().get(i).getText(),data.get(i).get("comment"));
        }
    }

}
