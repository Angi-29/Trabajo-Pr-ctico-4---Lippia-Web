package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import junit.framework.Assert;
import lippia.web.constants.WorkspaceConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.crowdar.core.actions.ActionManager.click;
//import static lippia.web.constants.WorkspaceConstants.CREATE_BUTTON;
import static lippia.web.constants.WorkspaceConstants.CREATE_BUTTON;
import static lippia.web.constants.WorkspaceConstants.CREATE_NEW_WORKSPACE_BUTTON;


public class WorkspaceService {
    private static WebDriver driver;
    private Object ClockifyWorkspaceService;
    private String workspaceName;

    public WorkspaceService(WebDriverWait wait) {
    }


    public static void performSuccessFulLogin(String email, String password, Object button) {
        ActionManager.click(WorkspaceConstants.LOG_IN_MANUALLY);
        WebActionManager.setInput(WorkspaceConstants.EMAIL_INPUT, email);
        WebActionManager.setInput(WorkspaceConstants.PASSWORD_INPUT, String.valueOf(password));
        ActionManager.click(WorkspaceConstants.LOG_IN_BUTTON, (String) button);
    }

    public static void navigateToManageWorkspaces() {
        ActionManager.click(String.valueOf(WorkspaceConstants.MEATBALLS_MENU));
        ActionManager.click(String.valueOf(WorkspaceConstants.MANAGE_WORKSPACES_OPTION));
    }

    public static void clickCreateNewWorkspaceButton() {
        click(String.valueOf(CREATE_NEW_WORKSPACE_BUTTON));
    }

    public static boolean enterWorkspaceName(String workspaceName) {
        WebActionManager.setInput(WorkspaceConstants.WORKSPACE_NAME_INPUT, workspaceName);
        return false;
    }

    public static void createNewWorkspace(String workspaceName) {
    }

    public static void clickCreateButton() {
        ActionManager.click(String.valueOf(CREATE_BUTTON));
    }



}
