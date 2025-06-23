package ObjectData;

import java.util.HashMap;
import java.util.List;

public class PracticeFormObject extends CommonObject{
    private String firstName; //proprietatile din fisierul de proprietis pe care le voi initializa
    private String lastName;
    private String email;
    private String mobileNr;
    private String gender;
    private List<String> subjects;
    private List<String> hobbies;

    public PracticeFormObject(HashMap<String,String> testData) {
        populateData(testData);
    }

    //metoda care ia valorile din fisierul de properties si in functie de cheia  pe care o gaseste sa setez valoarea ei
    public void populateData(HashMap<String,String> testData)
    {
        for(String Key : testData.keySet())
        {
            switch (Key)
            {
                case "firstName":
                    setFirstName(testData.get(Key));
                    break;
                case "lastName":
                    setLastName(testData.get(Key));
                    break;
                case "email" :
                    setEmail(testData.get(Key));
                    break;
                case "mobileNr":
                    setMobileNr(testData.get(Key));
                    break;
                case "gender":
                    setGender(testData.get(Key));
                    break;
                case "subjects":
                    setSubjects(getValueList(testData.get(Key)));
                    break;
                case "hobbies":
                    setHobbies(getValueList(testData.get(Key)));
                    break;
            }

        }
    }


    //generate Getter and Setter- pt variabilele private de sus
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNr() {
        return mobileNr;
    }

    public void setMobileNr(String mobileNr) {
        this.mobileNr = mobileNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
