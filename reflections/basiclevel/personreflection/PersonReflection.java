package reflections.basiclevel.personreflection;

import java.lang.reflect.Field;

public class PersonReflection {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);


            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);


            int initialAge = (int) ageField.get(person);
            System.out.println("Initial Age: " + initialAge);


            ageField.set(person, 30);
            System.out.println("Updated Age: " + person.getAge());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
