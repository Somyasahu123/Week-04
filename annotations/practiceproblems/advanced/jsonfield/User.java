package annotations.practiceproblems.advanced.jsonfield;

class User {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String ignoredField; // This field will not be serialized

    public User(String username, int age, String ignoredField) {
        this.username = username;
        this.age = age;
        this.ignoredField = ignoredField;
    }
}

