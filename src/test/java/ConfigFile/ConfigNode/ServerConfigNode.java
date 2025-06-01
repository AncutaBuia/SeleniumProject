package ConfigFile.ConfigNode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ServerConfigNode {
        //fac reprezentarea obiectului din XMl
        @XmlElement(name= "Port")
        public String port;
        @XmlElement (name= "DataBaseName")
        public String dataBaseName;
        @XmlElement (name= "Username")
        public String username;
        @XmlElement (name= "Password")
        public String password;

    }


