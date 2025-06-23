package Pages;

import HelperMethods.*;
import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

   protected WebDriver driver; //declaram
   protected ElementsMethod elementsMethod; // declam metoda creata de ajutor si apoi o initializam mai jos
   protected JavascriptHelpers javascriptHelpers; //declaram
   protected AlertMethods alertMethods;
   protected FramesMethods framesMethods;
   protected WindowsMethods windowsMethods;


    public CommonPage(WebDriver driver) {
        this.driver = driver;  //initializam
        this.elementsMethod = new ElementsMethod(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        this.alertMethods = new AlertMethods(driver);
        this.framesMethods = new FramesMethods(driver);
        this.windowsMethods = new WindowsMethods(driver);

        PageFactory.initElements(driver, this); //initilizam FindBy elements

    }

    //Identificam WebElementele specifice pentru pagina asta cu page Factory
    @FindBy(xpath = "//span[@class='text']") //declaram xpath-ul
            List<WebElement> element; //declam cum se numeste elementul asta

    //Facem metode specifice pentru pagina asta
    public void goToDesireSubMenu(String subMenu ){
        javascriptHelpers.scrollDown(400);
        LoggerUtility.infoLog("The user scrolls down the page");
        elementsMethod.selectElementFromListByText(element, subMenu);
        LoggerUtility.infoLog("The user selects from menu the option with the value: " + subMenu);
    }
}
