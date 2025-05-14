package Pages;

import HelperMethods.ElementsMethod;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonPage{


    @FindBy(xpath = "//p[text()='Consent']")
    WebElement consentElement;
    //Identificam WebElementele specifice pentru pagina asta cu page Factory
    @FindBy(xpath = "//h5") //declaram xpath-ul
    List<WebElement> element; //declam cum se numeste elementul asta

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Facem metode specifice pentru pagina asta
    public void goToDesireMenu(String menu ){
      //  elementsMethod.clickOnElement(consentElement); --daca apare acel pop-up
        //facem scroll ca sa fie elementul in pagina
        javascriptHelpers.scrollDown(400);
        elementsMethod.selectElementFromListByText(element, menu);
    }





}

