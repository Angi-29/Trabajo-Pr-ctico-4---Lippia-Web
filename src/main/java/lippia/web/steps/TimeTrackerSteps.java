package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.lippia.api.lowcode.variables.VariablesManager;
import lippia.web.services.LandingPageWorkspaceService;
import lippia.web.services.LogInService;
import lippia.web.services.ModifyTimeTraker;
import lippia.web.services.TimeTrackerService;
import lippia.web.utils.MyDate;
import lippia.web.utils.Sleep;
import junit.framework.Assert;
import lippia.web.utils.AlphanumericGenerator;

import static lippia.web.constants.TimeTrackerConstants.LOGIN_PAGE_URL;


public class TimeTrackerSteps extends PageSteps {

    private String description;
    private String date;

    @Then("The client is on the time tracker page")
    public void theClientIsOnTheTimeTrackerPage() {
        LogInService.verifyClientIsOnTimeTrackerPage();
    }

    @Then("The client should see an error message {string}")
    public void theClientShouldSeeAnErrorMessage(String expectedMessage) {
        LogInService.verifyErrorMessage();
        String errorMessage = VariablesManager.getVariable("errorMessage").toString();
        Assert.assertEquals(errorMessage, expectedMessage);
    }


    @Then("The client should then be redirected to the login page {string}")
    public void theClientShouldThenBeRedirectedToTheLoginPage(String url) {
        Assert.assertEquals("https://app.clockify.me/en/login", LOGIN_PAGE_URL);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Cierra el navegador después del escenario
            System.out.println("Navegador cerrado después del escenario");
        }
    }

//1///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @And("the user clicks Time Tracker")
    public void theUserClicksTimeTracker() {
        TimeTrackerService.clickTimeTracker();
    }

    @Given("the user clicks add manual")
    public void theUserClicksAddManual() {
        TimeTrackerService.theUserClicksAddManual();
    }

    @And("The user enters the date {string}")
    public void theUserEntersTheDate(String date) {
        this.date = date;
        TimeTrackerService.enterDate(date);
    }

    @And("The user sets the start time to {string}")
    public void theUserSetsTheStartTimeTo(String starTime) {
        TimeTrackerService.setStartTime(starTime);
    }

    @And("The user sets the end time to {string}")
    public void theUserSetsTheEndTimeTo(String endTime) {
        TimeTrackerService.setEndTime(endTime);
    }

    @And("the user add description {string}")
    public void theUserAddDescription(String desc) {
        this.description = desc + "_" + AlphanumericGenerator.generateAlphanumeric(4);
        TimeTrackerService.addDescription(this.description);
    }

    @And("the user selects the {string}")
    public void theUserSelectsThe(String project) {
        TimeTrackerService.selectsProject(project);
    }

    @And("the user clicks the Add button")
    public void theUserClicksTheAddButton() {
        TimeTrackerService.clickAddButton();
    }

    @Then("the user sees the recorded time tracker")
    public void theUserSeesTheRecordedTimeTracker() {
        boolean flagDescription = TimeTrackerService.searchDescription(this.description);
        //convertimos la fecha a buscar en pagina
        String fechaFormateada = MyDate.formatDate(this.date);
        boolean flagDate = TimeTrackerService.searchTimeTracker(fechaFormateada);

        Assert.assertTrue("[WARNING] No se encontro la descripcion", flagDescription);
        Assert.assertTrue("[WARNING] No se encontro la fecha cargada", flagDate);

        System.out.println("");
    }

//2///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @When("the user click add timer")
    public void theUserClickAddTimer() {
        TimeTrackerService.theUserClickAddTimer();
    }

    @And("the user add a description {string}")
    public void theUserAddADescription(String Automation) {
        TimeTrackerService.theUserAddADescription(Automation);
    }

    @And("the user click on the start button")
    public void theUserClickOnTheStartButton() {
        TimeTrackerService.theUserClicksOnTheStartButton();
    }

    @And("the user opens the Kebab menu and selects {string}")
    public void theUserOpensTheKebabMenuAndSelects(String option) {
        TimeTrackerService.clickOnKebabMenu();
        TimeTrackerService.clickOnDiscard();
    }

    @And("the user click {string} to confirm cancellation")
    public void theUserClickToConfirmCancellation(String discard) {
        TimeTrackerService.clickButtonDiscard();
    }

    @Then("The user should see a {string} message")
    public void theUserSeesTheTimerCanceledMessage(String expectedMessage) {
        // Llama al servicio para obtener el mensaje actual
        String actualMessage = TimeTrackerService.verifyTimerCanceledMessage();

        // Imprime el mensaje obtenido para verificarlo (opcional)
        System.out.println("Mensaje de cancelación obtenido: " + actualMessage);

        // Compara el mensaje obtenido con el esperado
        org.testng.Assert.assertEquals(actualMessage, expectedMessage, "El mensaje de cancelación no coincide con el esperado.");
    }

    //3///////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Given("the user has a time entry registered {string}")
    public void theUserHasATimeEntryRegistered(String fecha) {
        TimeTrackerService.simpleTimeRecord(fecha);
    }

    @And("the user selects the time tracker entry for {string} to modify")
    public void theUserSelectsTheTimeTrackerEntryForToModify(String fecha) {
        TimeTrackerService.clicModifyTimeTraker(fecha);
    }


    @When("the user enters new data: {string},{string},{string},{string},{string}")
    public void theUserEntersNewData(String Description, String Project, String Time_START, String Time_END, String Date) {
        ModifyTimeTraker.formModifyTimeTraker(Description, Project, Time_START, Time_END, Date);
    }

    @And("the user click save modify")
    public void theUserClickSaveModify() {
        ModifyTimeTraker.clicSaveModifyTime();
        Sleep.Stop(2);

    }

    @Then("the user sees the modified data: {string},{string},{string},{string},{string}")
    public void theUserSeesTheModifiedData(String Description, String Project, String Time_START, String Time_END, String newDate) {
        boolean flag = TimeTrackerService.searchEntryDescription(Description);
        Assert.assertTrue("[WARNING] No se encontro la descripcion modificada", flag);
    }


}















