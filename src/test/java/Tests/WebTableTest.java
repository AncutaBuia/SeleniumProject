package Tests;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    //1. declaram o variabila WebDriver:
    public WebDriver driver;

    //facem o metoda de test:
    @Test
    public void automationMethod (){

        //deschidem un browser:
        driver= new ChromeDriver();

        //accesam pagina Web:
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver; // instanta care executa o bucata de script in site-ul respectiv care ne da un anumite rezultt
        js.executeScript ("window, scrollBy(0,400)"); // coordonatele x si y

        //declaram un element: aceasta linie de cod: selenium identifica elementul dupa Xpath-ul compus
        WebElement elementsField = driver.findElement(By.xpath("//h5[text()= 'Elements']"));
        elementsField.click(); //facem o actiune cu elementul

        WebElement webtableField = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webtableField.click();

        WebElement addField = driver.findElement(By.id("addNewRecordButton"));
        addField.click();

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue= "Anca";  //declaram variabila unde se salveaza valoarea fieldului
        firstNameField.sendKeys(firstNameValue);  //metoda care ajuta sa completam o valoare pe un field

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Buia";
        lastNameField.sendKeys(lastNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailValue = "ancuta.buia@gmail.com";
        emailField.sendKeys(emailValue);

        WebElement ageField = driver.findElement(By.id("age"));
        String ageValue = "29";
        ageField.sendKeys(ageValue);

        WebElement salaryField = driver.findElement(By.id("salary"));
        String salaryValue = "1000";
        salaryField.sendKeys(salaryValue);

        WebElement departmentField = driver.findElement(By.id("departmnet"));
        String departmentValue = "IT";
        departmentField.sendKeys(departmentValue);

        WebElement sumbitField = driver.findElement(By.id("submit"));
        sumbitField.click();


    }
}
