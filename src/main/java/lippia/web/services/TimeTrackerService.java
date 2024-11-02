package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.TimeTrackerConstants;
import lippia.web.utils.MyDate;
import lippia.web.utils.Sleep;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
        WebActionManager.getElement(TimeTrackerConstants.DATE_FIELD_TEXT).sendKeys(date); // Introduce el valor y manda Enter
    }

    public static void setStartTime(String startTime) {
        WebActionManager.click(TimeTrackerConstants.START_TIME_FIELD);
        WebActionManager.getElement(TimeTrackerConstants.START_TIME_FIELD).sendKeys(Keys.CONTROL + "a"); // Selecciona todo el texto
        WebActionManager.getElement(TimeTrackerConstants.START_TIME_FIELD).sendKeys(Keys.BACK_SPACE); // Borra el texto seleccionado
        WebActionManager.getElement(TimeTrackerConstants.START_TIME_FIELD).sendKeys(startTime + Keys.ENTER); // Introduce el valor y manda Enter
        //WebActionManager.click(TimeTrackerConstants.END_TIME_FIELD); // Asegura el foco en END_TIME_FIELD
    }

    public static void setEndTime(String endTime) {
        WebActionManager.click(TimeTrackerConstants.END_TIME_FIELD);
        WebActionManager.getElement(TimeTrackerConstants.END_TIME_FIELD).sendKeys(Keys.CONTROL + "a"); // Selecciona todo el texto
        WebActionManager.getElement(TimeTrackerConstants.END_TIME_FIELD).sendKeys(Keys.BACK_SPACE); // Borra el texto seleccionado
        WebActionManager.getElement(TimeTrackerConstants.END_TIME_FIELD).sendKeys(endTime + Keys.ENTER); // Introduce el valor y manda Enter
        //WebActionManager.click(TimeTrackerConstants.START_TIME_FIELD); // Asegura el foco en END_TIME_FIELD
    }

    public static void clickAddButton() {
        WebActionManager.waitPresence(TimeTrackerConstants.ADD_BTN).click();
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
        //Esperamos q cargue, este metodo lo utilizo ya q no me esta saliendo lo de la espera explicita
        //Sleep.Stop(10);
        //List<WebElement> listDescription = WebActionManager.getElements(TXT_DESCRIPTION);

        //PREGUNTAR
        //Como utilizar el wait explicito?? Ya que como lo estoy usando me devuelve error
        //Entiendo que utilizando waitVisibilities estoy esperando que el elemento se encuentre visible en la pagina
        List<WebElement> listDescription = WebActionManager.waitPresences(TXT_DESCRIPTION);

        //El return lo utilizo para devolver true si encontro mi descripcion, caso contrario me devuelve false
        return listDescription.size() == 1;

    }

    public static boolean searchTimeTracker(String fechaFormateada) {
        //Sleep.Stop(5);
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


    public static void theUserClickAddTimer() {
        WebActionManager.click(TimeTrackerConstants.ADD_TIMER);

    }

    public static void theUserAddADescription(String Automation) {
        WebActionManager.click(TimeTrackerConstants.ADD_NAME_DESCRIPTION);
        WebActionManager.getElement(TimeTrackerConstants.ADD_NAME_DESCRIPTION).sendKeys(Keys.CONTROL + "a"); // Selecciona todo el texto
        WebActionManager.getElement(TimeTrackerConstants.ADD_NAME_DESCRIPTION).sendKeys(Keys.BACK_SPACE); // Borra el texto seleccionado
        WebActionManager.getElement(TimeTrackerConstants.ADD_NAME_DESCRIPTION).sendKeys(Automation); // Introduce el valor y manda Enter

    }

    public static void theUserClicksOnTheStartButton() {
        WebActionManager.click(BTN_START);
    }

    public static void clickOnKebabMenu() {
        WebActionManager.click(TimeTrackerConstants.KEBAB_MENU);
    }

    public static void clickOnDiscard() {
        WebActionManager.click(TimeTrackerConstants.DISCARD_OPTION);
    }

    public static void clickButtonDiscard() {
        WebActionManager.click(TimeTrackerConstants.BTN_DISCARD);
    }


    public static void selectsProject(String project) {
        WebActionManager.click(TimeTrackerConstants.SELECTS_PROJECT);
        WebActionManager.getElement(TimeTrackerConstants.SEARCH_PROJECT).click();
        WebActionManager.getElement(TimeTrackerConstants.SEARCH_PROJECT).sendKeys(project);
        String LBL_PROJECT = "css:[title='" + project + "']";
        WebActionManager.waitClickable(LBL_PROJECT).click();
        Sleep.Stop(3);
    }

    public static void clicModifyTimeTraker(String fecha) {
        String TAG_ENTRY_GROUP = "xpath://a[@id='bulkEdit']";

        List<WebElement> bulkEdit = WebActionManager.waitPresences(TAG_ENTRY_GROUP);
        for (WebElement ec : bulkEdit) {
            ec.click();
        }
        //Invertimos y convertimos la fecha para la busqueda
        // DD/MM/YYYY = YYYY-MM-DD
        Sleep.Stop(3);
        String idFecha = MyDate.invertirFecha(fecha);
        List<WebElement> edit = WebActionManager.waitPresences("xpath://input[@type='checkbox' and contains(@id, '" + idFecha + "')]");
        for (WebElement ed : edit) {
            ed.click();
            String BTN_BULK_EDIT = "xpath://main[@id='layout-main']/div/tracker2/div/div/div/div/entry-group[2]/div/entry-group-header/div/div/span[2]/a/span";
            WebActionManager.getElement(BTN_BULK_EDIT).click();
        }

    }

    public static boolean searchEntryDescription(String descrip) {
        int i = WebActionManager.waitPresences("xpath://div[@data-cy='time-entry-description' and contains(text(), '" + descrip + "')]").size();

        //Si encunetro un elmento con la mism descripcion devuelvo true, caso contario si es 0 o mas de 1 devuelvo false
        return (i == 1);
    }

    public static void simpleTimeRecord(String fecha) {
        enterDate(fecha);
        clickAddButton();
    }
}

