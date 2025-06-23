package ShareData.Browser;

import ConfigFile.ConfigNode.ConfigurationNode;
import ShareData.Browser.service.ChromeBrowserService;
import ShareData.Browser.service.EdgeBrowserService;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

//aceasta clasa va avea rol sa defineasca pe care serviciu sa il apeleze in functie de ce alege userul in YML
//va avea rol sa defineasca ce browser sa ruleze cand esti pe local
public class BrowserFactory {

    //trebuie sa leg BrowserFactory de ShareData pt ca acolo am before si after-ul
    //cum fac asta: apelez serviciile si sa returnam driverul:
    public WebDriver getBrowserFactory(){

        //1.Vad ce valori a oferit userl pt noi
        String ciCd = System.getProperty("ciCd"); //iau parametrul din pom.xml: "cicd" :  <ciCd>false</ciCd>; si asa obtin valoare lui
        String browser = System.getProperty("browser").toLowerCase(Locale.ROOT); //la fel si aici ca sa obtin valoarea browserului



        //2.Dupa ce le-am accesat ma mai intereseaza sa vad ce valori sunt acolo
        //Pt. local imi trebuie toate configurarile din shraeDataConfig.xml
        ConfigurationNode configurationNode = ConfigFile.ConfigFile.createConfigNode(ConfigurationNode.class); //am copiat-o din ShareData

        //pt ca ii cicd este true sau flase: fac conversie din string in boolean
        if (Boolean.parseBoolean(ciCd)){
            configurationNode.driverConfigNode.headless = "--headless"; // avem aceasta conditie pt ca pe remote nu se poate rula daca este headless
        }
        else {
            //daca cicd e false- inseamna ca la else e pe local, deci vrem sa nu ia variabila din pom.xml ci din shareDataConfig.xml
            browser = configurationNode.driverConfigNode.localBrowser; //il suprascriem cand ruleaza pe local sa citeasca din pom.xml dar sa ia valoarea sin shareDataConfig.xml
        }

        //cum ii specific cand se ruleaza din Yml pe care serviciu sa il apeleze:
        switch (browser) //in functie de ce decizie iei cu browserul
        {
            case BrowserType.BROWSER_CHROME:
                ChromeBrowserService chromeService = new ChromeBrowserService();
                chromeService.openBrowser(configurationNode.driverConfigNode);
                return chromeService.getDriver();

            case BrowserType.BROWSER_EDGE:
                EdgeBrowserService edgeService = new EdgeBrowserService();
                edgeService.openBrowser(configurationNode.driverConfigNode);
                return edgeService.getDriver();
        }

        return null;
    }
}


