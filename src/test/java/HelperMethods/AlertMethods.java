package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    //ca sa facem click pe element avem nevoie: sa vedem elementul(adica de un WebElement),si sa facem actiunea (click), sa identificam elementul (driver.findElement)
    WebDriver driver; //aici identificam elementul creand o variabila globala pe care o sa o initializam generand un constructor

    public AlertMethods(WebDriver driver){
        this.driver = driver;
          }

     //Metoda 3.1 Interactionam cu alerta la un singur buton
    public void interactWithAlertsOk(){
        //ne mutam cu focusul pe alerta:
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();
    }

    //Metoda care interactioneaza cu Alerte de tip wait Explicit
    public void explicitAlertWait(){
        //definim un wait explicit ca sa astepte dupa alerta, il punem inainte de alerta
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()); //ii zicem explicit pana cand asteptam,

    }

    //Metoda 3.2 Interactionam cu alerta de tip delay
    public void interractWithDelayAlert(){
        explicitAlertWait(); // apelam metoda care asteapta sa apara alerta
        //ne mutam cu focusul pe alerta
        Alert alertDelayOk = driver.switchTo().alert();
        alertDelayOk.accept();
    }

}
