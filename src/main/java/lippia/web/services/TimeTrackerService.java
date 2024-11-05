package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.TimeTrackerConstants;
import lippia.web.utils.MyDate;
import lippia.web.utils.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static lippia.web.constants.TimeTrackerConstants.BTN_START;


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
        WebActionManager.click(TimeTrackerConstants.DATE_FIELD_TEXT);
        WebActionManager.getElement(TimeTrackerConstants.DATE_FIELD_TEXT).sendKeys(Keys.CONTROL + "a"); // Selecciona todo el texto
        WebActionManager.getElement(TimeTrackerConstants.DATE_FIELD_TEXT).sendKeys(Keys.BACK_SPACE); // Borra el texto seleccionado
        WebActionManager.getElement(TimeTrackerConstants.DATE_FIELD_TEXT).sendKeys(date); // Introduce el valor
    }

    public static void setStartTime(String startTime) {
        WebActionManager.click(TimeTrackerConstants.START_TIME_FIELD);
        WebActionManager.getElement(TimeTrackerConstants.START_TIME_FIELD).sendKeys(Keys.CONTROL + "a");
        WebActionManager.getElement(TimeTrackerConstants.START_TIME_FIELD).sendKeys(Keys.BACK_SPACE);
        WebActionManager.getElement(TimeTrackerConstants.START_TIME_FIELD).sendKeys(startTime + Keys.ENTER);

    }

    public static void setEndTime(String endTime) {
        WebActionManager.click(TimeTrackerConstants.END_TIME_FIELD);
        WebActionManager.getElement(TimeTrackerConstants.END_TIME_FIELD).sendKeys(Keys.CONTROL + "a");
        WebActionManager.getElement(TimeTrackerConstants.END_TIME_FIELD).sendKeys(Keys.BACK_SPACE);
        WebActionManager.getElement(TimeTrackerConstants.END_TIME_FIELD).sendKeys(endTime + Keys.ENTER);

    }

    public static void clickAddButton() {
        WebActionManager.waitClickable(TimeTrackerConstants.ADD_BTN).click();
        Sleep.Stop(2);
    }

    public static void addDescription(String description) {
        WebActionManager.click(TimeTrackerConstants.ADD_DESCRIPTION);
        WebActionManager.getElement(TimeTrackerConstants.ADD_DESCRIPTION).sendKeys(Keys.CONTROL + "a");
        WebActionManager.getElement(TimeTrackerConstants.ADD_DESCRIPTION).sendKeys(Keys.BACK_SPACE);
        WebActionManager.getElement(TimeTrackerConstants.ADD_DESCRIPTION).sendKeys(description);
        WebActionManager.click(TimeTrackerConstants.START_TIME_FIELD);
    }

    public static boolean searchDescription(String desc) {
        String TXT_DESCRIPTION = "xpath://*[contains(text(), '" + desc + "')]";

        List<WebElement> listDescription = WebActionManager.waitPresences(TXT_DESCRIPTION);


        return listDescription.size() == 1;

    }


    public static boolean searchTimeTracker(String fechaFormateada) {
        List<WebElement> listDescription = WebActionManager.waitPresences(TimeTrackerConstants.TAG_ENTRY_GROUP_HEADER);
        for (WebElement e : listDescription) {
            System.out.println("---> e " + e.getText());
            if (e.getText().contains(fechaFormateada)) {
                System.out.println("OK");
                return true;
            }
        }
        return false;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void theUserClickAddTimer() {
        WebActionManager.click(TimeTrackerConstants.ADD_TIMER);
    }

    public static void theUserAddADescription(String Automation) {
        WebActionManager.click(TimeTrackerConstants.ADD_NAME_DESCRIPTION);
        WebActionManager.getElement(TimeTrackerConstants.ADD_NAME_DESCRIPTION).sendKeys(Keys.CONTROL + "a");
        WebActionManager.getElement(TimeTrackerConstants.ADD_NAME_DESCRIPTION).sendKeys(Keys.BACK_SPACE);
        WebActionManager.getElement(TimeTrackerConstants.ADD_NAME_DESCRIPTION).sendKeys(Automation);

    }

    public static void theUserClicksOnTheStartButton() {
        WebActionManager.click(BTN_START);
    }

    public static void clickOnKebabMenu() {
        WebActionManager.waitClickable(TimeTrackerConstants.KEBAB_MENU).click();
    }

    public static void clickOnDiscard() {
        WebActionManager.click(TimeTrackerConstants.DISCARD_OPTION);
    }

    public static void clickButtonDiscard() {
        Sleep.Stop(1);
        WebActionManager.waitVisibility(TimeTrackerConstants.BTN_DISCARD).click();

    }
    ///////////////////////////////////////////////////////////////////////////////

    public static void selectsProject(String project) {
        WebActionManager.click(TimeTrackerConstants.SELECTS_PROJECT);
        WebActionManager.getElement(TimeTrackerConstants.SEARCH_PROJECT).click();
        WebActionManager.getElement(TimeTrackerConstants.SEARCH_PROJECT).sendKeys(project);
        String LBL_PROJECT = "css:[title='" + project + "']";
        Sleep.Stop(3);
        WebActionManager.waitClickable(LBL_PROJECT).click();

    }


    public static void clicModifyTimeTraker(String fecha) {
        Sleep.Stop(3);

        List<WebElement> bulkEdit = WebActionManager.waitPresences(TimeTrackerConstants.TAG_ENTRY_GROUP);
        for (WebElement ec : bulkEdit) {
            ec.click();
        }
        //Inverti y converti la fecha para la busqueda
        // DD/MM/YYYY = YYYY-MM-DD

        String idFecha = MyDate.invertirFecha(fecha);
        List<WebElement> edit = WebActionManager.waitPresences("xpath://input[@type='checkbox' and contains(@id, '" + idFecha + "')]");
        for (WebElement ed : edit) {
            ed.click();
            WebActionManager.getElement(TimeTrackerConstants.BTN_BULK_EDIT).click();

        }

    }

    public static boolean searchEntryDescription(String descrip) {
        int i = WebActionManager.waitPresences("xpath://div[@data-cy='time-entry-description' and contains(text(), '" + descrip + "')]").size();

        //Si encuentro un elemento con la misma descripcion devuelvo true, caso contario si es 0 o mas de 1 devuelvo false
        return (i == 1);
    }

    public static void simpleTimeRecord(String fecha) {
        theUserClicksAddManual();
        enterDate(fecha);
        clickAddButton();
    }

    public static String verifyTimerCanceledMessage() {
        List<WebElement> messages = WebActionManager.waitPresences(TimeTrackerConstants.VERIFY_MESSAGE);

        String expectedMessage = "Timer cancelled";
        for (WebElement message : messages) {
            if (message.getText().equals(expectedMessage)) {
                return message.getText();
            }
        }

        // Lanza una excepción si no se encuentra el mensaje esperado
        throw new AssertionError("El mensaje de 'Timer cancelled' no se encontró o el texto no coincide.");
    }


}
