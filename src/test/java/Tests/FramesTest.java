package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest {


    public WebDriver driver;

    @Test
    public void automationMethod(){
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com");
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //facem browserul in modul maximize
        driver.manage().window().maximize();
        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //1.interactionam cu butonul de tip meniu Alerts, Frame & Windows
        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        //2.Deschid submeniul  Frames
        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        frameElement.click();

        //3.1 Identificam elementul din Iframe si face, switch pe el:
        WebElement frame1Element = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1Element);

        WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));   //gaseste elementul din iframe si afiseaza-l
        System.out.println("Textul din new frame este " + sampleHeadingWindowElement.getText());

        driver.switchTo().defaultContent();

        //3.2 Identificam elementul din Iframe si facem sroll apoi switch pe el:
        WebElement frame2Elements = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2Elements);
        js.executeScript("window.scrollBy(200,200)");

    }

}
