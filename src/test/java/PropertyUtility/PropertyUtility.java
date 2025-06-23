package PropertyUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertyUtility {
    public Properties properties;     //Properties: obiect pe care il are java

    //1.Facem un constructor gol
    public PropertyUtility(String testName) {
        loadFile(testName);
    }


    //2.logica prin care incarcam fisierul de date: PracticeFormTestData.properties
    //luam fisierul FileInputStrea-il instantiem;
    //Ca si constructor imi cere path-ul fisierului de properties
    //Apoi voi incarca fisierul respectiv properties.load(fileInputStream);
    public void loadFile(String testName){
        properties = new Properties();  //instantiem obiectul de properties
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/InputData/"+testName+"Data.properties");//ia-mi fiseirul de properties si fa-mi-l sa fie properties
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //3.Logica  prin care luam datele din acel fisier PracticeFormTestData.properties
    //vreau sa aceasta metoda sa imi ia din fiesirul meu key si value si ulterior sa fie salvata intr-un obiect
    public HashMap <String, String> getData(){
        HashMap <String,String> testData = new HashMap<>();
        for(Object key : properties.keySet())
        {
            testData.put(key.toString(), properties.getProperty(key.toString()));
        }
        return testData;
    }

    //4.Fac un nou package cu o clasa: ObjectData -ProcticeFormObject
    //4.Iau tot ce am in fisierul de properties si facand logica de sus sa imi fac eu acel obiect de practiceFormObject
    //In interior practiceFormObject ce am in fisierul nostru in proprietati ale obiectului respectiv


}
