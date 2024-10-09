package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import lippia.web.services.LandingPageService;
import lippia.web.services.LandingPageWorkspaceService;
import lippia.web.services.ProjectService;
import lippia.web.services.WorkspaceService;
import lippia.web.utils.AlphanumericGenerator;


public class projectSteps extends PageSteps {

    private String nameProjec;

    @Given("The client is logged in on the page")
    public void theClientIsLoggedInOnThePage() {
        LandingPageWorkspaceService.navegarWeb();
        LandingPageService.clickOnLogIn();
        WorkspaceService.performSuccessFulLogin("cuentaparapruebas933@gmail.com", "Contrasena123", "Login");
    }

    @When("the user clicks Create new project")
    public void theUserClicksCreateNewProject() {
        ProjectService.btnCreatenewproject();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Cierra el navegador después del escenario
            System.out.println("Navegador cerrado después del escenario");
        }
    }

    @And("Enter a valid project name")
    public void enterAValidProjectName() {
        nameProjec = "Project_" + AlphanumericGenerator.generateAlphanumeric(4);
        ProjectService.inputNameNewProject(nameProjec);
    }

    @And("clicks the Create button")
    public void clicksTheCreateButton() {
        ProjectService.clicCreateButton();
    }

    @Then("The project should be created successfully")
    public void theProjectShouldBeCreatedSuccessfully() {
        String lblProject = ProjectService.getNewProject();
        Assert.assertEquals("[Warning] No se encontro resultado", lblProject, this.nameProjec);
    }
}







