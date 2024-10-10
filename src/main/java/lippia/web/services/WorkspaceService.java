package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import junit.framework.Assert;
import lippia.web.constants.WorkspaceConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.crowdar.core.actions.ActionManager.click;
import static lippia.web.constants.WorkspaceConstants.*;


public class WorkspaceService {
    private static WebDriver driver;
    private Object ClockifyWorkspaceService;
    public static String workspaceName;


    public WorkspaceService(WebDriver driver) {
        WorkspaceService.driver = driver;
    }


    public static void performSuccessFulLogin(String email, String password, Object button) {
        click(LOG_IN_MANUALLY);
        WebActionManager.setInput(EMAIL_INPUT, email);
        WebActionManager.setInput(PASSWORD_INPUT, String.valueOf(password));
        click(LOG_IN_BUTTON, (String) button);
    }

    public static void navigateToManageWorkspaces() {
        click(MEATBALLS_MENU);
        click(MANAGE_WORKSPACES_OPTION);
    }

    public static void clickCreateNewWorkspaceButton() {
        click(String.valueOf(CREATE_NEW_WORKSPACE_BUTTON));
    }


    public void enterText(String xpath, String text) {
        // WebElement element = getDriver().findElement(By.xpath(xpath));

    }

    public static void clickCreateButton() {
        click(String.valueOf(CREATE_BUTTON));
    }

    public static void setName(String name) {

        ActionManager.setInput(WORKSPACE_NAME_INPUT, name);
    }

    public static boolean elementos(String nameWorkSpace) {
        System.out.println("[INFO] workspace name to search is " + nameWorkSpace);
        List<WebElement> workspaceRows = WebActionManager.getElements(WORKSPACE_ROW_TAG_SELECTOR);
        boolean flagOk = false;
        for (WebElement e : workspaceRows) {
            String workSpaceName = e.findElement(By.className("cl-cut-text")).getText();
            if (workSpaceName.equalsIgnoreCase(nameWorkSpace)) {
                flagOk = true;
                break;// Si encuentra el valor, retornamos true
            }
        }
        return flagOk;
    }

    public static void modificNameWorkSpace(String oldName, String newName) {
        List<WebElement> workspaceRows = WebActionManager.waitVisibilities("tag:workspace-row");
        for (WebElement e : workspaceRows) {
            String workSpaceName = e.findElement(By.className("cl-cut-text")).getText();
            if (oldName.compareToIgnoreCase(workSpaceName) == 0) {
                e.findElement(By.tagName("button")).click();
                WorkspaceSettingsService.modificWorkspacename(newName);
            }
        }
    }


}
