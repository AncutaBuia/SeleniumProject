package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFromTest {

    public WebDriver driver;

    //facem o metoda de test:
    @Test
    public void automationMethod () {

        //deschidem un browser:
        driver = new ChromeDriver();

        //accesam pagina Web:
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver; // instanta care executa o bucata de script in site-ul respectiv care ne da un anumite rezultt
        js.executeScript("window, scrollBy(0,400)"); // coordonatele x si y

        //interactionam cu un buton de tip meniu care se numeste Forms
        WebElement formField = driver.findElement(By.xpath("//h5[text()= 'Forms']"));
        formField.click();

        WebElement practiceFormField = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormField.click();

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue= "Anca";  //declaram variabila unde se salveaza valoarea fieldului
        firstNameField.sendKeys(firstNameValue);  //metoda care ajuta sa completam o valoare pe un field

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Buia";
        lastNameField.sendKeys(lastNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailValue = "ancuta.buia@gmail.com";
        emailField.sendKeys(emailValue);

        //Css Selectors:
        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue = "0740000000";
        mobileNumberField.sendKeys(mobileNumberValue);

        //Upload file element:
        WebElement pictureField = driver.findElement(By.id("uploadPicture"));
        // Convert relative path to absolute path
        File file = new File("src/test/resources/File1.png");
        //Chemam elementul si adagam path-ul catre fiesier in sendKeys()
        pictureField.sendKeys(file.getAbsolutePath());

        WebElement MaleRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement FemaleRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement OtherRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue = "Male";
            if(genderValue.equals("Male")){
                MaleRadioButton.click();
            }
            else if (genderValue.equals("Female")) {
                FemaleRadioButton.click();
            }
           else if (genderValue.equals("Other")){
               OtherRadioButton.click();
            }

        //am un element in care rezultatele se filtreaza in functie de cum interactionez cu acesta
        WebElement SubjectsElement = driver.findElement(By.id("subjectsInput"));
        String SubjectsValues = "Social Studies";
        SubjectsElement.sendKeys(SubjectsValues);
        SubjectsElement.sendKeys(Keys.ENTER);


        //
        WebElement StateElement  = driver.findElement(By.id("react-select-3-input"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", StateElement);
        StateElement.sendKeys("NCR");
        StateElement.sendKeys(Keys.ENTER);


        WebElement CityElement = driver.findElement(By.id("react-select-4-input"));
        executor.executeScript("arguments[0].click();", CityElement);
        CityElement.sendKeys("Delhi");
        CityElement.sendKeys(Keys.ENTER);



        }

    }

