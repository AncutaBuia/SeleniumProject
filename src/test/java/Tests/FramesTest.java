package Tests;

import HelperMethods.JavascriptHelpers;
import Pages.CommonPage;
import Pages.FramesPage;
import Pages.HomePage;
import ShareData.Hooks;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class FramesTest extends Hooks {


   // public WebDriver driver; -- extends ShareData
    HomePage homePage;
    CommonPage commonPage;
    JavascriptHelpers javascriptHelpers;
    FramesPage framesPage;

    @Test
    public void automationMethod(){
       /* //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com");
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //facem browserul in modul maximize
        driver.manage().window().maximize();*/ // extends ShareData

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        javascriptHelpers = new JavascriptHelpers(getDriver());
        framesPage = new FramesPage(getDriver());

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,400)");

        homePage.goToDesireMenu("Alerts, Frame & Windows"); //1.
        commonPage.goToDesireSubMenu("Frames"); //2.
        framesPage.displayIframeContent();
        framesPage.scrollAndSwitchToIframe();

 /*
        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //1.interactionam cu butonul de tip meniu Alerts, Frame & Windows
        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        //2.Deschid submeniul  Frames
        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
         frameElement.click();


        //3.1 Identificam elementul din Iframe si face, switch pe el:
        WebElement frame1Element = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1Element);

        WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));   //gaseste elementul din iframe si afiseaza-l
        System.out.println("Textul din new frame este " + sampleHeadingWindowElement.getText());

        driver.switchTo().defaultContent();

        //3.2 Identificam elementul din Iframe si facem sroll apoi switch pe el:
        WebElement frame2Elements = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2Elements);
        js.executeScript("window.scrollBy(200,200)");
*/
    }

}
