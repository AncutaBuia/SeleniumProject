package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsMethods {
    WebDriver driver;
    private String mainTab;

    public WindowsMethods(WebDriver driver)
    {
        this.driver = driver;
    }


    // Save and switch to a new tab
    public void switchToOpenedTab()
    {
        mainTab = driver.getWindowHandle(); // save the original tab
        Set<String> allTabs = driver.getWindowHandles();

        for (String tab : allTabs)
        {
            if (!tab.equals(mainTab)) {
                driver.switchTo().window(tab); // switch to new
                break;
            }
        }
    }

    // Switch back to the original tab
    public void switchToMainTab()
    {
        if (mainTab != null) {
            driver.switchTo().window(mainTab);
        } else {
            throw new IllegalStateException("Main tab not stored. Call switchToOpenedTab() first.");
        }
    }

    // Metodă care mută focusul pe fereastra deschisă pe indexul dat (ex: 1 = a doua fereastră/tab)
    public void switchToWindowByIndex(int index)
    {
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        if (index < windowList.size()) {
            driver.switchTo().window(windowList.get(index));
        } else {
            throw new IndexOutOfBoundsException("Index invalid pentru fereastră: " + index);
        }
    }

    // Metodă care returnează textul unui element dintr-o fereastră dată
    public String getTextFromWindowElementByIndex(int index, WebElement element)
    {
        switchToWindowByIndex(index);
        return element.getText();
    }

    // Metodă care închide fereastra curentă și mută focusul înapoi pe prima (index 0)
    public void closeCurrentWindowAndReturnToFirst()
    {
        driver.close();
        switchToWindowByIndex(0);
    }
}

