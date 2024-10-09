package lippia.web.services;


import com.crowdar.core.actions.ActionManager;
import junit.framework.Assert;
import lippia.web.constants.ProjectConstants;

public class ProjectService {


    public static void btnCreatenewproject() {
        ActionManager.waitClickable(ProjectConstants.BTN_CREATE_PROJECT).click();
        ActionManager.waitClickable(ProjectConstants.BTN_CREATE_NEW_PROJECT).click();
    }

    public static void inputNameNewProject(String nameNewProject) {
        ActionManager.setInput(ProjectConstants.INPUT_NAME_PROJECT, nameNewProject);
    }

    public static void clicCreateButton() {
        ActionManager.waitClickable(ProjectConstants.BTN_ADD_NEW_PROJECT).click();
    }

    public static String getNewProject() {
        return ActionManager.waitVisibility(ProjectConstants.LBL_NEW_PROJECT).getText();
    }


}
