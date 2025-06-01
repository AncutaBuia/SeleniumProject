package ShareData.Browser.service;

import ConfigFile.ConfigNode.DriverConfigNode;

public interface BrowserService {

    void openBrowser(DriverConfigNode driverConfigNode);
    //metoda care pregateste configurarile:
    Object getBrowserOptions (DriverConfigNode driverConfigNode);
}
