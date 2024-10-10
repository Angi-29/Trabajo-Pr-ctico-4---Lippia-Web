package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import org.openqa.selenium.WebElement;

public class WorkspaceSettingsService {

    public static void modificWorkspacename(String newName){
        String WORK_SPACE_NAME= "id:workspaceName";
        WebElement nameWorkSpace = WebActionManager.getElement(WORK_SPACE_NAME);
        nameWorkSpace.clear();
        WebActionManager.setInput(WORK_SPACE_NAME,newName);
    }
}
