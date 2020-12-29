package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pageObjects.*;
import utility.GetPropertiesValue;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class HistorySteps extends TestBase {

    private GetPropertiesValue getPropertiesValue = new GetPropertiesValue();
    
    @When("^user books appointment as below$")
    public void userBooksAppointmentAsBelow(DataTable table) {
        List<Map<String, String>> table1 = table.asMaps(String.class,String.class);
        for (int i=0; i<table1.size(); i++) {
            
            Select facility_box = new Select(AppointmentPage.facilityBox());
            facility_box.selectByVisibleText(table1.get(i).get("facility_input"));
            
            if (table1.get(i).get("readmission_input").equals("Yes"))
                AppointmentPage.readmission().click();

            switch (table1.get(i).get("program_input")){
                case "Medicare":
                    AppointmentPage.program_medicare().click();
                    break;
                case "Medicaid":
                    AppointmentPage.program_medicaid().click();
                    break;
                case "None":
                    AppointmentPage.program_none().click();
                    break;
            }
            
            AppointmentPage.date().sendKeys(table1.get(i).get("date_input"));
            AppointmentPage.comment().sendKeys(table1.get(i).get("comment_input"));
            AppointmentPage.buttonBookAppointment().click();
            AppointmentConfirmationPage.goToHomePage().click();
        }
    }

    @And("^user clicks menu icon$")
    public void userClicksMenuIcon() {
        MenuPage.menu().click();
    }

    @And("^user clicks history$")
    public void userClicksHistory() {
        MenuPage.menu_history().click();
    }

    @Then("^user sees list of appointments as below$")
    public void userSeesListOfAppointmentsAsBelow(DataTable table) {
    List<Map<String, String>> table2 = table.asMaps(String.class, String.class);
    for (int i=0; i<table2.size(); i++){
        Assert.assertEquals(HistoryPage.facility().get(i).getText(),table2.get(i).get("facility_history"));
        Assert.assertEquals(HistoryPage.readmission().get(i).getText(),table2.get(i).get("readmission_history"));
        Assert.assertEquals(HistoryPage.program().get(i).getText(),table2.get(i).get("program_history"));
        Assert.assertEquals(HistoryPage.date().get(i).getText(),table2.get(i).get("date_history"));
        Assert.assertEquals(HistoryPage.comment().get(i).getText(),table2.get(i).get("comment_history"));
    }
    }
}
