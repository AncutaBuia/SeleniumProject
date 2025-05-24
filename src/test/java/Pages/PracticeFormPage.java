package Pages;

import HelperMethods.ElementsMethod;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends CommonPage{



    //Identificam WebElementele specifice pentru pagina asta cu page Factory
    @FindBy(id ="firstName") //declaram id-ul
    private WebElement firstNameField; //declam cum se numeste elementul asta
    @FindBy(id ="lastName") //declaram id-ul
    private  WebElement lastNameField; //declam cum se numeste elementul asta
    @FindBy(id ="userEmail") //declaram id-ul
    private WebElement emailField; //declam cum se numeste elementul asta
    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileNumberField;
    @FindBy(id = "uploadPicture")
    private  WebElement pictureField;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement otherGenderElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement sportHobbyElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement readingHobbyElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement musicHobbyElement;
//    @FindBy(xpath = "//div[@id = 'subjectsContainer']")
//    WebElement subjectElement;
    @FindBy(id="subjectsInput")
    private WebElement subjectElement;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    //Metoda pentru pagina practiceFormTest:
    //in interiorul metodei completam fieldurile de sus-> in fielduri vreau sa ii dau anumiti parametri cand apelez metoda
    //inseamna ca in interiorul metodei am nevoie de parametrii
    public  void completeFirstRegion(String firstName, String lastName, String email, String mobileNr){

        elementsMethod.fillElement(firstNameField, firstName);//ne folosim de o metoda helper pe care o avem deja
        elementsMethod.fillElement(lastNameField, lastName);
        elementsMethod.fillElement(emailField, email);
        elementsMethod.fillElement(mobileNumberField, mobileNr);

    }
    //metoda care completeaza gender-ul: folosim switch
    public void completeGender(String gender){
        switch (gender){
            case  "Male":
                elementsMethod.clickOnElement(maleGenderElement);
                break;
            case "Female":
                elementsMethod.clickOnElement(femaleGenderElement);
                break;
            case "Other":
                elementsMethod.clickOnElement(otherGenderElement);
                break;
        }
    }

    //metoda care completeaza subject-ul:
    public void completeSubject(String subject){
        elementsMethod.clickOnElement(subjectElement); // da click
        elementsMethod.fillWtihActions(subjectElement, subject); // fill subject
    }

    //metoda complete subject with list:
    public void completeSubjectWithList(List<String> list){
        elementsMethod.clickOnElement(subjectElement);
        elementsMethod.fillMultipleValues(subjectElement, list);
    }

    //metoda
    public void completeHobbies(List<String> hobbies){
       List<WebElement> hobbiesElement = new ArrayList<>();//ne definim noi lista de elemente
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(musicHobbyElement);
        hobbiesElement.add(readingHobbyElement);
        elementsMethod.clickMultipleValues(hobbiesElement,hobbies);
    }

}
