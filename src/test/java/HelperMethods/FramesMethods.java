package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesMethods{
    WebDriver driver;

    public FramesMethods(WebDriver driver) {
        this.driver = driver;
    }

    //metoda care face switch to frame
    public void switchToFrame(WebElement frameElement)
    {
        driver.switchTo().frame(frameElement);
    }
    //metoda care face switch to default
    public void switchToDefaultContent()
    {
        driver.switchTo().defaultContent();
    }


    }

