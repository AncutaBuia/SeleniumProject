package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethod;
import HelperMethods.JavascriptHelpers;
import Pages.AlertPage;
import Pages.CommonPage;
import Pages.HomePage;
import ShareData.ShareData;
import org.testng.annotations.Test;

public class AlertTest extends ShareData { //adaugam clasa parinte extends ShareData

//public WebDriver driver; -- nu mai este nevoie de el=> inlocuit de clasa parinte: extends ShareData
public ElementsMethod elementsMethod;
public AlertMethods alertMethods;
HomePage homePage;
CommonPage commonPage;
JavascriptHelpers javascriptHelpers;
AlertPage alertPage;

@Test
    public void automationMethod (){
       /* //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com");
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //facem browserul in modul maximize
        driver.manage().window().maximize(); *///nu mai este nevoie de el=> inlocuit de clasa parinte: extends ShareData

        //aducem metoda helper ELementsMethod
        elementsMethod = new ElementsMethod(driver);
        //aducem metoda helper
        alertMethods = new AlertMethods(driver);

        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        javascriptHelpers = new JavascriptHelpers(driver);
        alertPage = new AlertPage(driver);

/*
        //facem un scroll
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,400)");

    //1.interactionam cu butonul de tip meniu Alerts, Frame & Windows
    WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
    alertFrameWindowElement.click();
 *///inlocuim cu:
    homePage.goToDesireMenu("Alerts, Frame & Windows");

/*
    //2.Deschid submeniul  Alerts
    WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
    //alertElement.click(); inlocuim cu :
    elementsMethod.clickOnElement(alertElement);
 *///inlocuim cu:
    commonPage.goToDesireSubMenu("Alerts");

    //3.1 Interactionam cu alerta la un singur buton
 /*   WebElement alertOkElement = driver.findElement(By.id("alertButton"));
//    alertOkElement.click(); -inlocuim cu:
    elementsMethod.clickOnElement(alertOkElement);
//    //ne mutam cu focusul pe alerta:
//    Alert alertOk = driver.switchTo().alert(); - inlocuim cu:
//    alertOk.accept();
    alertMethods.interactWithAlertsOk(); */ //inlocuim cu:
    alertPage.alertClickButton();


    //3.2 Interactionam cu alerta de tip delay
   /* WebElement alertDelayElement  = driver.findElement(By.id("timerAlertButton"));
   // alertDelayElement.click(); -inlocuim cu:
    elementsMethod.clickOnElement(alertDelayElement);
//    //definim un wait explicit ca sa astepte dupa alerta, il punem inainte de alerta
//    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
//    wait.until(ExpectedConditions.alertIsPresent()); //ii zicem explicit pana cand asteptam
//    //ne mutam cu focusul pe alerta
//    Alert alertDelayOk = driver.switchTo().alert();
//    alertDelayOk.accept();
    //inlocuim cu:
    alertMethods.interractWithDelayAlert();
    *///inlocui cu:
    alertPage.alertDelayButton();



    //3.3 Interactiunea cu alerta ok/cancel
   /* WebElement alertConfirmationElement = driver.findElement(By.id("confirmButton"));
   // alertConfirmationElement.click();-inlocuim cu:
    elementsMethod.clickOnElement(alertConfirmationElement);
    //ne mutam cu focusul pe alerta
//    Alert alertConfirmation = driver.switchTo().alert();
//    alertConfirmation.dismiss(); inlocuim cu:
    alertMethods.dissmissAlert();*///inlocuim cu:
    alertPage.alertConfirmationButton();


    //3.4 Interactiunea cu alerta cu mesaj
   /* WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
    //alertPromptElement.click();- inlocui cu:
    elementsMethod.clickOnElement(alertPromptElement);
    //ne mutam cu focusul pe alerta
//    Alert alertPromt = driver.switchTo().alert();
//    alertPromt.sendKeys("Cristina");
//    alertPromt.accept(); //ca sa vedem ce am scris - inlocuit cu:
    alertMethods.messageAlert(); */ //inlocuim cu:
    alertPage.alertAddPrompt();

    }

}
