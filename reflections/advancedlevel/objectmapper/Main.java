package reflections.advancedlevel.objectmapper;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Object> personData = new HashMap<>();
        personData.put("name", "John Doe");
        personData.put("age", 30);
        personData.put("city", "New York");


        Person person = ObjectMapper.toObject(Person.class, personData);


        System.out.println(person);
    }
}

