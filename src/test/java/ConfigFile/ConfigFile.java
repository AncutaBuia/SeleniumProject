package ConfigFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

//in acesta clasa vom avea logica care va citi din xml
public class ConfigFile {

    //facem o metoda generica care sa deserializeze xml file si sa returneze o bucata pe care mi-o doresc
    //metoda generica = ca sa nu faci mai multe instante ale metodei daca sti ca rezultatul de returnare este diferit
    //metoda generica zice ca trebuie sa identifici actiunea si trebuie sa identifici diferenta
    //diferenta= reprezentata de tipul clasei pe care vrei sa o returnezi si atunci definim un return custom:
    //<T> T = T reprezinta un parametru pe care tu il dai/ va tine locul returnului nostru

    public static <T> T createConfigNode(Class<T> klass){

        //try/ catch e folosit aici pt exceptii
        try {
            //deserializam clasa:
            //si sa mapeze tot ce exista cu clasa mea (ex clasa. DeriveConfigNode)
            //Unmarshaller - ma ajuta pe mine sa manageuiasca instanta de jos si sa o deserializeze dupa ce aleg eu
            JAXBContext jaxbContext = JAXBContext.newInstance(klass);   //facem o instanta noua
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller(); //facem un obiect care sa poata sa citeasca din XMl-ul meu

            //chemam clasa oe care o vreau (Klass), ii faceam cast()-adica sa se forteze sa fie de forma pe care eu i-o zic
            //in interior la cast(unmarshaller)-chem acel unmarshaller- care are o metoda unmarshaller
            //metoda unmarshaller: te intreaba care este nodul pe care vrei sa il returnezi:
            //nodul este de tipul clasei, trebuie sa ii zici de unde sa citeasca fisierul pe care il avem de configurari
            return klass.cast(unmarshaller.unmarshal(new File("src/test/resources/configFile/shareDataConfig.xml")));
        }

        catch (JAXBException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

}
