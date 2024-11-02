package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.ModifyTimeTrakerConstans;
import lippia.web.constants.TimeTrackerConstants;
import lippia.web.utils.Sleep;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModifyTimeTraker {
    public static void formModifyTimeTraker(String Description, String Project, String Time_START, String Time_END, String Date) {
        Sleep.Stop(3);//Esperamos que cargue la pagina


        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_DESCRIPTION_CHECK).click();
        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_DESCRIPTION_TXT).click();
        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_DESCRIPTION_TXT).clear();
        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_DESCRIPTION_TXT).sendKeys(Description);



        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_PROJECT_CHECK).click();
        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_PROJECT_BUTTON).click();
        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_PROJECT_TEXT).clear();
        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_PROJECT_TEXT).sendKeys(Project);
        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_PROJECT_TEXT).sendKeys(Keys.ENTER);

        String BULK_PROJECT_LBL = "xpath://button[@type='button' and contains(@title, '"+Project+"')]";
        Sleep.Stop(2);
        WebActionManager.waitPresence(BULK_PROJECT_LBL).click();


        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_TIME_CHECK).click();


        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_TIME_START_TXT).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_TIME_START_TXT).sendKeys(Time_START);

        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_TIME_END_TXT).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_TIME_END_TXT).sendKeys(Time_END);

        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_DATE_CHECK).click();

        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_DATE_TXT).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        WebActionManager.getElement(ModifyTimeTrakerConstans.BULK_DATE_TXT).sendKeys(Date);

    }

    public static void clicSaveModifyTime(){
        WebActionManager.waitClickable(ModifyTimeTrakerConstans.BULK_SAVE_BTN).click();
        System.out.println("");
    }
}
