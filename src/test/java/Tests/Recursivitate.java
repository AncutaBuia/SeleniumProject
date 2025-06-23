package Tests;

import HelperMethods.JavascriptHelpers;
import Pages.CommonPage;
import Pages.HomePage;
import ShareData.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Recursivitate extends Hooks {

    //1. declaram o variabila WebDriver:

    HomePage homePage;
    CommonPage commonPage;



    //facem o metoda de test:
    @Test
    public void parcurgereLista (){


        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.goToDesireMenu("Interactions");
        commonPage.goToDesireSubMenu("Sortable");


        Actions actions= new Actions(getDriver());
        //declam o lisra "List"
      List<WebElement> list= getDriver().findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for(int i= 0; i < list.size()-1 ; i++ ){       //lista incepe de la 0 si se termnina la 5- adaugam -1
           // luam elementul curent 'i'-contorul , si il printam:
           WebElement webElement=list.get(i);  //ii atribuim elementul curent din lista unei variabile
           WebElement urmatorulElement = list.get(i++); //iau si elementul urmator
            System.out.println("Numarul elementului este: " + webElement.getText());
            actions.clickAndHold(webElement)
                    .moveToElement(urmatorulElement)
                    .release()
                    .build()
                    .perform();
        }
        // il punem un pic sa astepte ca sa putem sa vedem cand rulam cum interschimba elementele (linia actions. ...)
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
