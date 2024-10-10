package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.Utils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import lippia.web.services.LandingPageWorkspaceService;
import lippia.web.services.WorkspaceService;
import lippia.web.utils.AlphanumericGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static lippia.web.services.WorkspaceService.workspaceName;

public class WorkspaceSteps extends PageSteps {

    private String workSpaceName;

    @Given("The clients is on landing page")
    public void theClientsIsOnLandingPage() {
        LandingPageWorkspaceService.navegarWeb();
    }

    @And("The client clicks on {string}")
    public void theClientClicksOnLogIn() {
        LandingPageWorkspaceService.clickOnLogIn();
    }

    @Given("The client is logged in with email {string}, password {string} and click on button {string}")
    public void theClientIsLoggedInWithEmailCuentaparapruebasGmailComPasswordContrasenaAndClickOnButtonLogin(String email, String password, String button) {
        WorkspaceService.performSuccessFulLogin(email, password, button);
    }

    @When("The client clicks on the Meatballs menu and selects {string}")
    public void theClientClicksOnTheMeatballsMenuAndSelectsManageWorkspaces(String option) {
        if (option.equals("Manage Workspaces")) {
            WorkspaceService.navigateToManageWorkspaces();
        }
    }

    @And("the client clicks the {string} button")
    public void theClientClicksTheCreateNewWorkspaceButton(String buttonName) {
        if ("Create new workspace".equals(buttonName)) {
            WorkspaceService.clickCreateNewWorkspaceButton();
        }

    }

    @And("the client enters a valid name {string}")
    public void theClientEntersAValidNameCrowdarAcademyTests(String name) {
        this.workSpaceName = name + "_" + AlphanumericGenerator.generateAlphanumeric(4);
        WorkspaceService.setName(this.workSpaceName);
    }

    @And("the client clicks on the 'create' button")
    public void theClientClicksOnTheCreateButton() {
        WorkspaceService.clickCreateButton();
    }

    @Then("the new workspace {string} should be created correctly")
    public void theNewWorkspaceCrowdarAcademyTestsShouldBeCreatedCorrectly(String name) {
        boolean flagSearch = WorkspaceService.elementos(this.workSpaceName);
        Assert.assertTrue("[WARNING] No se encontro WorkSpace con el nombre de " + this.workSpaceName, flagSearch);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Cierra el navegador después del escenario
            System.out.println("Navegador cerrado después del escenario");
        }
    }


    @Given("the client has a workspace created")
    public void theClientHasAWorkspaceCreated() {
        WorkspaceService.navigateToManageWorkspaces();
        WorkspaceService.clickCreateNewWorkspaceButton();
        this.workSpaceName = "Workspace" + "_" + AlphanumericGenerator.generateAlphanumeric(4);
        WorkspaceService.setName(this.workSpaceName);
        WorkspaceService.clickCreateButton();
        WorkspaceService.elementos(this.workSpaceName);
    }

    @When("the client modifies the workspace name by {string}")
    public void theClientModifiesTheWorkspaceNameBy(String newName) {
        newName = "_" + newName;
        WorkspaceService.modificNameWorkSpace(this.workSpaceName, newName);
        WorkspaceService.navigateToManageWorkspaces();
        this.workSpaceName = this.workSpaceName + newName;
    }

    @Then("the new workspace name is updated")
    public void theNewWorkspaceNameIsUpdated() {
        boolean flagSearch = WorkspaceService.elementos(this.workSpaceName);
        Assert.assertTrue("[WARNING] No se encontro WorkSpace con el nombre de " + this.workSpaceName, flagSearch);

    }
}







