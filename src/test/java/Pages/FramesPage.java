package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends CommonPage{


    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "frame1")
    private WebElement frame1Element;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingElement;
    @FindBy(id = "frame2")
    private WebElement frame2Element;

    //metoda care Identificam elementul din Iframe face switch pe el, il afiseaza-l, switch to default
    public  void displayIframeContent(){
        framesMethods.switchToFrame(frame1Element);
        elementsMethod.displayContentOfElement(sampleHeadingElement);
        framesMethods.switchToDefaultContent();
    }

    public void scrollAndSwitchToIframe(){
        framesMethods.switchToFrame(frame2Element);
        javascriptHelpers.scroll(200,200);
    }
}
