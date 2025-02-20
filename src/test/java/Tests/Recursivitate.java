package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class Recursivitate {

    //1. declaram o variabila WebDriver:
    public WebDriver driver;

    //facem o metoda de test:
    @Test
    public void parcurgereLista (){

        //deschidem un browser:
        driver = new ChromeDriver();

        //accesam pagina Web:
        driver.get("https://demoqa.com/sortable");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        Actions actions= new Actions(driver);
        //declam o lisra "List"
      List<WebElement> list= driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
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
