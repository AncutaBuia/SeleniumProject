package Pages;

import HelperMethods.ElementsMethod;
import HelperMethods.JavascriptHelpers;
import logger.LoggerUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class HomePage extends CommonPage{


    @FindBy(xpath = "//p[text()='Consent']")
    private WebElement consentElement;
    //Identificam WebElementele specifice pentru pagina asta cu page Factory
    @FindBy(xpath = "//h5") //declaram xpath-ul
            private List<WebElement> element; //declam cum se numeste elementul asta

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Facem metode specifice pentru pagina asta
    public void goToDesireMenu(String menu ){
        try {
            elementsMethod.clickOnElement(consentElement); //daca apare acel pop-up
            LoggerUtility.infoLog("The user clicks on consentElement");
        } catch (NoSuchElementException ignored){
        }
        //facem scroll ca sa fie elementul in pagina
        javascriptHelpers.scrollDown(400);
        LoggerUtility.infoLog("The user scroll down the page");
        elementsMethod.selectElementFromListByText(element, menu);
        LoggerUtility.infoLog("The user selects from menu the option with the value: " + menu);
    }





}

