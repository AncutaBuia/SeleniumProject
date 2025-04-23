package HelperMethods;

import org.openqa.selenium.*;

import java.io.File;
import java.util.List;

public class ElementsMethod {

    //ca sa facem click pe element avem nevoie: sa vedem elementul(adica de un WebElement),si sa facem actiunea (click), sa identificam elementul (driver.findElement)
     WebDriver driver; //aici identificam elementul creand o variabila globala pe care o sa o initializam generand un constructor

    public ElementsMethod(WebDriver driver) { //generate constructor
        this.driver = driver;
    }

    //metoda care face click
    public void clickOnElement(WebElement element){ //chemam un obiect de tip WebElement
        element.click();
    }

    //metoda care adauga valori
    public void fillElement(WebElement element, String value){ //chemam un obiect de tip WebElement; aici avem nevoie sa ii dam si o valoare
        element.sendKeys(value);
    }

    //metoda care adauga fisiere/poze
    public void uploadPicture(WebElement element){
        File file = new File("src/test/resources/File1.png");
        //Chemam elementul si adagam path-ul catre fiesier in sendKeys()
        element.sendKeys(file.getAbsolutePath());
    }

    //metoda ca parcurge o lista
    public void selectElementFromListByText(List<WebElement> elementList, String value){
        for(int i = 0; i < elementList.size(); i++){
            if(elementList.get(i).getText().equals(value)){
                clickOnElement(elementList.get(i));
            }
        }

    }


    // metoda un element in care rezultatele se filtreaza in functie de cum interactionez cu acesta
    public  void pressEnter(WebElement element) {
        if (element != null) {
            element.sendKeys(Keys.ENTER);
        }
    }

    //metoda pt React select
    public void selectFromReactSelect(WebDriver driver, By inputLocator, String value) {
        WebElement inputElement = driver.findElement(inputLocator);

        // Click using JS to focus the input
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inputElement);

        // Send value + press ENTER
        inputElement.sendKeys(value);
        inputElement.sendKeys(Keys.ENTER);
    }

}
