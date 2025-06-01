package ConfigFile.ConfigNode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="configuration")
//1.faci un obiect de configuration => automat va lua toate datele din shareDataConfig, le va mapa dupa structura mea( adica
//vezi ca DriverConfigNode asta este un field si el contine elementele etc
public class ConfigurationNode {

    //trebuie sa aduc copilul DriverConfig in parintele Configuration
    @XmlElement(name = "DriverConfig")
    public DriverConfigNode driverConfigNode;  //ii specific obiectul pe care eu l-am construit
    @XmlElement(name = "DataBaseConfig")
    public DataBaseConfigNode dataBaseConfigNode;
    @XmlElement(name = "ServerConfig")
    public  ServerConfigNode serverConfigNode;
}
