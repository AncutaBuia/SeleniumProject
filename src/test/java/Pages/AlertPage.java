package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends CommonPage {

    /*WebDriver driver; //declaram
    ElementsMethod elementsMethod; // declam metoda creata de ajutor si apoi o initializam mai jos
    JavascriptHelpers javascriptHelpers; //declaram
    AlertMethods alertMethods;
    public AlertPage(WebDriver driver)

   //constructorul
    {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        alertMethods = new AlertMethods(driver);

        PageFactory.initElements(driver,this);
    }
    *///inlocuim cu constructorul clasei parinte CommonPage



    //Identificam WebElementele specifice pentru pagina asta cu page Factory
    @FindBy(id = "alertButton")
    private WebElement alertButton;
    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertElement;
    @FindBy(id = "confirmButton")
    private WebElement alertConfirmationElement;
    @FindBy(id = "promtButton")
    private WebElement alertPromptElement;

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    //Metoda pentru alerte la un singur buton
    public void alertClickButton(){
        elementsMethod.clickOnElement(alertButton);
        alertMethods.interactWithAlertsOk();
    }

    //Metoda wait explicit pentru alerte de tip delay care asteapta pana cand alerta e prezenta
    public void alertDelayButton(){
        elementsMethod.clickOnElement(timerAlertElement);
        alertMethods.interractWithDelayAlert();
    }

    //Metoda pentru  alerta ok/cancel
    public void alertConfirmationButton(){
        elementsMethod.clickOnElement(alertConfirmationElement);
        alertMethods.dissmissAlert();
    }

    //Metoda care adauga un mesaj in alerta
    public void alertAddPrompt(){
        elementsMethod.clickOnElement(alertPromptElement);
        alertMethods.messageAlert();
    }
}
