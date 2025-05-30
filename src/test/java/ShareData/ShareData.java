package ShareData;

import ConfigFile.ConfigNode.ConfigurationNode;
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

    @BeforeMethod //se executa inainte de @test
    public void prepareBrowser(){

        ConfigurationNode configurationNode = ConfigFile.ConfigFile.createConfigNode(ConfigurationNode.class); //INCARCA-MI xmL-ul si deserializeaza
        //dupa structura pe care i-am dat-o


        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
//        driver.get("https://demoqa.com"); inlocuim :
        driver.get(configurationNode.driverConfigNode.url);
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //facem browserul in modul maximize
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void clearBrowser(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
