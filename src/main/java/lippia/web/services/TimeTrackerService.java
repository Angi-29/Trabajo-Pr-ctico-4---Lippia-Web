package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.TimeTrackerConstants;
import lippia.web.utils.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.List;


public class TimeTrackerService {

    private static Object WebDriver;

    public static void clickTimeTracker() {
        WebActionManager.waitClickable(TimeTrackerConstants.BTN_MENU_TIME_TRACKER);
    }

    public static void theUserClicksAddManual() {
        WebActionManager.click(TimeTrackerConstants.ADD_MANUAL);
    }

    public static void clickOnTheCalendar() {
        WebActionManager.click(TimeTrackerConstants.BTN_CALENDAR);
    }

    public static void enterDate(String date) {
        WebActionManager.click(TimeTrackerConstants.DATE_FIELD, date);
    }

    public static void setStartTime(String startTime) {
        WebActionManager.click(TimeTrackerConstants.START_TIME_FIELD);
        WebActionManager.getElement(TimeTrackerConstants.START_TIME_FIELD).sendKeys(Keys.CONTROL + "a"); // Selecciona todo el texto
        WebActionManager.getElement(TimeTrackerConstants.START_TIME_FIELD).sendKeys(Keys.BACK_SPACE); // Borra el texto seleccionado
        WebActionManager.getElement(TimeTrackerConstants.START_TIME_FIELD).sendKeys(startTime + Keys.ENTER); // Introduce el valor y manda Enter
        WebActionManager.click(TimeTrackerConstants.END_TIME_FIELD); // Asegura el foco en END_TIME_FIELD
    }

    public static void setEndTime(String endTime) {
        WebActionManager.click(TimeTrackerConstants.END_TIME_FIELD);
        WebActionManager.getElement(TimeTrackerConstants.END_TIME_FIELD).sendKeys(Keys.CONTROL + "a"); // Selecciona todo el texto
        WebActionManager.getElement(TimeTrackerConstants.END_TIME_FIELD).sendKeys(Keys.BACK_SPACE); // Borra el texto seleccionado
        WebActionManager.getElement(TimeTrackerConstants.END_TIME_FIELD).sendKeys(endTime + Keys.ENTER); // Introduce el valor y manda Enter
        WebActionManager.click(TimeTrackerConstants.START_TIME_FIELD); // Asegura el foco en END_TIME_FIELD
    }

    public static void clickAddButton() {
        WebActionManager.click(TimeTrackerConstants.ADD_BTN);
        System.out.println("");
    }

    public static void addDescription(String description) {
        WebActionManager.click(TimeTrackerConstants.ADD_DESCRIPTION);
        WebActionManager.getElement(TimeTrackerConstants.ADD_DESCRIPTION).sendKeys(Keys.CONTROL + "a"); // Selecciona todo el texto
        WebActionManager.getElement(TimeTrackerConstants.ADD_DESCRIPTION).sendKeys(Keys.BACK_SPACE); // Borra el texto seleccionado
        WebActionManager.getElement(TimeTrackerConstants.ADD_DESCRIPTION).sendKeys(description); // Introduce el valor y manda Enter
        WebActionManager.click(TimeTrackerConstants.START_TIME_FIELD); // Asegura el foco en END_TIME_FIELD
    }

    public static boolean searchDescription(String desc) {
        String TXT_DESCRIPTION = "xpath://*[contains(text(), '" + desc + "')]";
        //Esperamos q cargue
        Sleep.Stop(5);
        List<WebElement> listDescription = WebActionManager.getElements(TXT_DESCRIPTION);
        return listDescription.size() == 1;

    }


}

