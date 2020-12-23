package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.login.AppointmentConfirmationPage;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class AppointmentConfirmationStep extends TestBase {
    @Then("^user sees value exactly as below$")
    public void useSeesValueExactlyAndAndAndAnd(DataTable table) throws InterruptedException {
        List<Map<String, String>> result_Data = table.asMaps(String.class, String.class);
        Assert.assertEquals(AppointmentConfirmationPage.lb_facility().getText(), result_Data.get(0).get("facility"));
        Assert.assertEquals(AppointmentConfirmationPage.lb_apply_for_hospital().getText(), result_Data.get(0).get("apply_for_hospital"));
        Assert.assertEquals(AppointmentConfirmationPage.lb_health_care().getText(), result_Data.get(0).get("health_care"));
        Assert.assertEquals(AppointmentConfirmationPage.lb_visit_date().getText(), result_Data.get(0).get("visit_date"));
        Assert.assertEquals(AppointmentConfirmationPage.lb_comment().getText(), result_Data.get(0).get("comment"));
        Thread.sleep(1500);
    }


}
