package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.TimeTrackerConstants;
import lippia.web.utils.Sleep;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModifyTimeTraker {
    public static void formModifyTimeTraker(String Description, String Project, String Time_START, String Time_END, String Date) {
        Sleep.Stop(3);//Esperamos que cargue la pagina
        String BULK_DESCRIPTION_CHECK = "css:label[for='desc-1']";
        String BULK_DESCRIPTION_TXT = "xpath://input[@type='text' and contains(@name, 'descriptionName')]";

        WebActionManager.getElement(BULK_DESCRIPTION_CHECK).click();
        WebActionManager.getElement(BULK_DESCRIPTION_TXT).click();
        WebActionManager.getElement(BULK_DESCRIPTION_TXT).clear();
        WebActionManager.getElement(BULK_DESCRIPTION_TXT).sendKeys(Description);


        String BULK_PROJECT_CHECK = "css:label[for='proj-1']";
        String BULK_PROJECT_BUTTON = "xpath://button[@type='button' and contains(@data-cy, 'project-dropdown')]";
        String BULK_PROJECT_TEXT = "xpath://input[@type='text' and contains(@id, 'app-text-field-0')]";

        WebActionManager.getElement(BULK_PROJECT_CHECK).click();
        WebActionManager.getElement(BULK_PROJECT_BUTTON).click();
        WebActionManager.getElement(BULK_PROJECT_TEXT).clear();
        WebActionManager.getElement(BULK_PROJECT_TEXT).sendKeys(Project);
        WebActionManager.getElement(BULK_PROJECT_TEXT).sendKeys(Keys.ENTER);

        String BULK_PROJECT_LBL = "xpath://button[@type='button' and contains(@title, '"+Project+"')]";
        Sleep.Stop(2);
        WebActionManager.waitPresence(BULK_PROJECT_LBL).click();

        String BULK_TIME_CHECK = "css:label[for='time-1']";
        WebActionManager.getElement(BULK_TIME_CHECK).click();

        String BULK_TIME_START_TXT = "xpath://ngb-modal-window//input-time-ampm[1]/input";
        WebActionManager.getElement(BULK_TIME_START_TXT).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        WebActionManager.getElement(BULK_TIME_START_TXT).sendKeys(Time_START);

        String BULK_TIME_END_TXT = "xpath://ngb-modal-window//input-time-ampm[2]/input";
        WebActionManager.getElement(BULK_TIME_END_TXT).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        WebActionManager.getElement(BULK_TIME_END_TXT).sendKeys(Time_END);

        //date-1
        String BULK_DATE_CHECK = "css:label[for='date-1']";
        WebActionManager.getElement(BULK_DATE_CHECK).click();

        String BULK_DATE_TXT = "xpath:(//ngb-modal-window//time-entry-bulk-edit//single-date-picker2//input)[3]";
        WebActionManager.getElement(BULK_DATE_TXT).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        WebActionManager.getElement(BULK_DATE_TXT).sendKeys(Date);

    }

    public static void clicSaveModifyTime(){
        String BULK_SAVE_BTN = "xpath://ngb-modal-window//time-entry-bulk-edit//app-button/button";
        WebActionManager.waitClickable(BULK_SAVE_BTN).click();
        System.out.println("");
    }
}
