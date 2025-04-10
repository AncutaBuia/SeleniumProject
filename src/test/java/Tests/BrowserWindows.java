package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindows {

        public WebDriver driver;

        @Test
        public void automationMethod() {
            //deschidem un browser de Chrome
            driver = new ChromeDriver();
            //accesam o pagina web
            driver.get("https://demoqa.com");

            //facem browserul in modul maximize
            driver.manage().window().maximize();
            //facem un scroll
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,400)");

            //1.interactionam cu butonul de tip meniu Alerts, Frame & Windows
            WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
            alertFrameWindowElement.click();

            //2.Deschid submeniul  Browser Windows
            WebElement browsedrWindowElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
            browsedrWindowElement.click();

            //3.Interactionam cu New Tab:
            WebElement newTabElement = driver.findElement(By.id("tabButton"));   //identificam elementul tabButton
            newTabElement.click();

            //3.1Salvam tab-urile intr-o lista si navigam printre ele:
            List<String> tabList = new ArrayList<>(driver.getWindowHandles());     //getWindowHandles returneaza toate taburile deschise
            driver.switchTo().window(tabList.get(1));    //mutam focusul pe al doilea tab

            WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));   //gaseste elementul din tab-ul al doilea si afiseaza-l
            System.out.println("Textul din new tab este " + sampleHeadingElement.getText());

            driver.close();
            driver.switchTo().window(tabList.get(0));    //revenim cu focusul pe primul tab

            //4.Interactionam cu New Window
            WebElement newWindowWElement = driver.findElement(By.id("windowButton"));
            newWindowWElement.click();

            //4.1Salvam windows-urile intr-o lista si navigam printre ele:
            List<String> windowList = new ArrayList<>(driver.getWindowHandles());     //getWindowHandles returneaza toate windowsurile deschise
            driver.switchTo().window(windowList.get(1));    //mutam focusul pe al window

            WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));   //gaseste elementul din windows-ul al doilea si afiseaza-l
            System.out.println("Textul din new tab este " + sampleHeadingWindowElement.getText());

            driver.close();
            driver.switchTo().window(windowList.get(0));    //revenim cu focusul pe primul window

        }

}

