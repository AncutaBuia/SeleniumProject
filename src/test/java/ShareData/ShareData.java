package ShareData;

import ConfigFile.ConfigNode.ConfigurationNode;
import ShareData.Browser.BrowserFactory;
import ShareData.Browser.service.BrowserService;
import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {

    private WebDriver driver; //facem un driver

    //facem un mecanism care inainte de pasii pe care i-am implementat sa se execute si
    // sa imi faca toata logica care e specificata acolo mai jos: sa deschida un Chrome, sa mearga pe Url etc
    // => sunt niste actiuni pe care le definic ca si preconditii


    //nu mai este nevoie de BeforeMethod pt ca le manage-uiesc in Hooks
    //@BeforeMethod si afterMethod //se executa inainte de @test
    public void prepareBrowser(){

        //driverul meu sa aibe o nou instanta de BrowserFactory si de aici chem metoda getBrowserFactory();
        // iar in interiorul metodei se va decide logica de cicd si de browser
        //daca e pe remote face modificarea (sa nu fie headless), daca e pe local face switch de browser si alege serviciul pt browserul pe care il avem
       driver =  new BrowserFactory().getBrowserFactory();
        LoggerUtility.infoLog("The Browser was opened successfuly");

//        ConfigurationNode configurationNode = ConfigFile.ConfigFile.createConfigNode(ConfigurationNode.class); //INCARCA-MI xmL-ul si deserializeaza
//        //dupa structura pe care i-am dat-o
//        //deschidem un browser de Chrome
//        driver = new ChromeDriver();
//        //accesam o pagina web
////        driver.get("https://demoqa.com"); inlocuim :
//        driver.get(configurationNode.driverConfigNode.url);
//        //definim un wait implicit pentru un interval maxim de timp
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        //facem browserul in modul maximize
//        driver.manage().window().maximize();
    }

   // @AfterMethod
    public void clearBrowser(){
        driver.quit();
        LoggerUtility.infoLog("The Browser was closed successfuly");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
