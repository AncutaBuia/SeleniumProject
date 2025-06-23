package ObjectData;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//facem o metoda in care sa iau din PracticeFormTestData.properties o keye cu mai multe valori
public class CommonObject {

    public List<String> getValueList (String value)
    {
        String[] valueSplit = value.split(",");
        return Arrays.stream(valueSplit).collect(Collectors.toList());
    }

}
