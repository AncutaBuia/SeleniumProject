package Tests;
import HelperMethods.ElementsMethod;
import HelperMethods.JavascriptHelpers;
import Pages.CommonPage;
import Pages.HomePage;
import ShareData.ShareData;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class WebTableTest extends ShareData {

    //1. declaram o variabila WebDriver:
    //public WebDriver driver;// extends ShareData

    public ElementsMethod elementsMethod;
    JavascriptHelpers javascriptHelpers;
    HomePage homePage; //declaram
    CommonPage commonPage; //chemam obiectul/declaram

    //facem o metoda de test:
    @Test
    public void automationMethod (){

       /* //deschidem un browser:
        driver= new ChromeDriver();
        //accesam pagina Web:
        driver.get("https://demoqa.com/");
        //facem browserul in modul maximize
        driver.manage().window().maximize();*///extends ShareData

        elementsMethod = new ElementsMethod(driver);
        javascriptHelpers = new JavascriptHelpers(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);


//        //declaram un element: aceasta linie de cod: selenium identifica elementul dupa Xpath-ul compus
//        WebElement elementsField = driver.findElement(By.xpath("//h5[text()= 'Elements']"));
//        elementsField.click(); //facem o actiune cu elementul
/*        elementsMethod.selectElementFromXpathListByText("//h5", "Elements");

        WebElement webtableField = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webtableField.click();
*///inlocui cu:
        homePage.goToDesireMenu("Elements");
        commonPage.goToDesireSubMenu("Web Tables");

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

//        WebElement departmentField = driver.findElement(By.id("departmnet"));
//        String departmentValue = "IT";
//        departmentField.sendKeys(departmentValue);

        WebElement sumbitField = driver.findElement(By.id("submit"));
        sumbitField.click();


    }
}
