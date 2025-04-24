package Pages;

import HelperMethods.ElementsMethod;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonSubmenuPage {

    WebDriver driver; //declaram
    ElementsMethod elementsMethod; // declam metoda creata de ajutor si apoi o initializam mai jos
    JavascriptHelpers javascriptHelpers; //declaram


    public CommonSubmenuPage(WebDriver driver) {
        this.driver = driver;  //initializam
        this.elementsMethod = new ElementsMethod(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        PageFactory.initElements(driver, this); //initilizam FindBy elements
    }

    //Identificam WebElementele specifice pentru pagina asta cu page Factory
    @FindBy(xpath = "//span[@class='text']") //declaram xpath-ul
            List<WebElement> element; //declam cum se numeste elementul asta

    //Facem metode specifice pentru pagina asta
    public void goToDesireSubMenu(String subMenu ){
        javascriptHelpers.scrollDown(400);
        elementsMethod.selectElementFromListByText(element, subMenu);
    }
}
