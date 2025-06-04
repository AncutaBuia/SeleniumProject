package HelperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ElementsMethod {

    //ca sa facem click pe element avem nevoie: sa vedem elementul(adica de un WebElement),si sa facem actiunea (click), sa identificam elementul (driver.findElement)
     WebDriver driver; //aici identificam elementul creand o variabila globala pe care o sa o initializam generand un constructor
     Actions actions;


    public ElementsMethod(WebDriver driver) { //generate constructor

        this.driver = driver;

        this.actions = new Actions(driver);
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

    //metoda pentru ListByXPath varianta 1-nu merge
//    public void selectElementFromXpathListByText(String xpath, String value) {
//        List<WebElement> elementList = driver.findElements(By.xpath(xpath));
//        for (WebElement element : elementList) {
//            if (element.getText().equals(value)) {
//                clickOnElement(element);
//                break;
//            }
//        }
//    }
    //metoda pentru ListByXPath varianta 2
    public void selectElementFromXpathListByText(String xpath, String value) {
        List<WebElement> elementList = driver.findElements(By.xpath(xpath));

        for (WebElement element : elementList) {
            if (element.getText().equals(value)) {
                try {
                    // Scroll to the element
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

                    // Try normal click
                    element.click();
                } catch (ElementClickInterceptedException e) {
                    // Fallback: force click using JavaScript
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                }
                break;
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

    //metoda actions care scrie o valoare si apasa enter
    public void fillWtihActions(WebElement webElement, String value){
        actions.sendKeys(value).perform();
        waitVisibilityElement(webElement);
        actions.sendKeys(Keys.ENTER).perform();

    }
    //metoda care asteapta dupa un element
    public void waitVisibilityElement(WebElement element ){
        //definim un wait explicit ca sa astepte ca elementul sa fie vizibil,
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element)); //ii zicem explicit pana cand asteptam,

    }
    //metoda care filluieste  o valoare dintr-o lista
    public void fillMultipleValues (WebElement webElement, List<String> list){
        for( String value: list){
            webElement.sendKeys(value);
            webElement.sendKeys(Keys.ENTER);
        }
    }

    //metoda care da click pe o lista cu mai multe elemente --aceasta metoda o apelam ex. in PracticeFormPage
    public void clickMultipleValues (List<WebElement> webElements, List<String> list){
        for(String value: list){ //parcurg lista de stringuri
           for(WebElement webElement: webElements){   //parcurg lista de webElemente
               if (webElement.getText().equals(value)){ //daca o valoare a textului din element este egala cu o valoare din lista sa dea click
                   webElement.click();
               }
           }
        }
    }

    //Helper Method for Displaying Content:
    public void displayContentOfElement(WebElement sampleHeadingElement){
        System.out.println("Textul din new tab este " + sampleHeadingElement.getText());
    }

    //Helper Methods for Tabs:
    String mainTab;

    public void switchToOpenedTab() {
        mainTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(mainTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

    public void switchToMainTab() {
        driver.switchTo().window(mainTab);
    }

    public void closeCurrentTab() {
        driver.close();
    }
}
