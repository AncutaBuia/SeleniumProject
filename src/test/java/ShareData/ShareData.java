package ShareData;

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
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com");
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
