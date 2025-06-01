package ShareData.Browser.service;

import ConfigFile.ConfigNode.DriverConfigNode;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class ChromeBrowserService implements BrowserService {

    private WebDriver driver;

    @Override
    public void openBrowser(DriverConfigNode driverConfigNode) {
        ChromeOptions options = (ChromeOptions) getBrowserOptions(driverConfigNode); // apelez configurarile de jos
        driver = new ChromeDriver(options);  //aici imi face un Chrome cu optiunile mele specifice
        driver.get(driverConfigNode.url); //comanda sa mearga spre url
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public Object getBrowserOptions(DriverConfigNode driverConfigNode) {
        ChromeOptions options = new ChromeOptions();
        if (!driverConfigNode.headless.isEmpty()) {
            options.addArguments(driverConfigNode.headless);
        }
        options.addArguments(driverConfigNode.resolution);
        options.addArguments(driverConfigNode.Gpu);
        options.addArguments(driverConfigNode.extensions);
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }


}
