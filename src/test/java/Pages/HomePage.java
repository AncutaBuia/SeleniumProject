package Pages;

import HelperMethods.ElementsMethod;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;
    ElementsMethod elementsMethod; // declam metoda creata de ajutor si apoi o initializam mai jos
    JavascriptHelpers javascriptHelpers; //declaram


    public HomePage(WebDriver driver) {
        this.driver = driver; //initalizam
        this.elementsMethod = new ElementsMethod(driver); //initalizam
        this.javascriptHelpers = new JavascriptHelpers(driver); //initilizam
        PageFactory.initElements(driver, this); //initilizam FindBy elements
    }

    //Identificam WebElementele specifice pentru pagina asta cu page Factory
    @FindBy(xpath = "//h5") //declaram xpath-ul
    List<WebElement> element; //declam cum se numeste elementul asta

    //Facem metode specifice pentru pagina asta
    public void goToDesireMenu(String menu ){
        javascriptHelpers.scrollDown(400);
        elementsMethod.selectElementFromListByText(element, menu);
    }





}

