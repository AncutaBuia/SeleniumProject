package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.JavascriptExecutor.*;

public class JavascriptHelpers {

    //1.Declaram driverul
    WebDriver driver;

    //2.Generam constructorul clasei
    public JavascriptHelpers(WebDriver driver) {
        this.driver = driver;
    }

    //3.Metoda de scroll
    public void scroll(int x, int y){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void scrollDown(int y){
        scroll(0 , y);
    }

    public void scrollRight(int x){
        scroll(x,0);
    }

}
