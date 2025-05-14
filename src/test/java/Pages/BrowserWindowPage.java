package Pages;

import HelperMethods.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowPage extends CommonPage {


    public BrowserWindowPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "tabButton")
    WebElement newTabButton;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingElement;
    @FindBy(id="windowButton")
    WebElement newWindowButton;


    //metoda care adauga tab-urile intr-o lista, navigheaza prin ele si muta focusul pe cel dorit
    public void DisplayTextFromNewTab()
    {
        elementsMethod.clickOnElement(newTabButton);
        windowsMethods.switchToOpenedTab();
        elementsMethod.displayContentOfElement(sampleHeadingElement);
        windowsMethods.switchToMainTab();
    }

    //metoda care descgide un new window
    public void DisplayTextFromNewWindow()
    {
        elementsMethod.clickOnElement(newWindowButton);
        windowsMethods.switchToWindowByIndex(1);
        windowsMethods.getTextFromWindowElementByIndex(1,sampleHeadingElement);
        windowsMethods.closeCurrentWindowAndReturnToFirst();

    }


}
