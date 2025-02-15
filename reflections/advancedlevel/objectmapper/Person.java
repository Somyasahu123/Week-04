package reflections.advancedlevel.objectmapper;

public class Person {
    private String name;
    private int age;
    private String city;


    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", city='" + city + "'}";
    }
}

