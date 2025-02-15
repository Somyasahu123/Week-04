package annotations.practiceproblems.intermediate.maxlength;

public class MaxLengthProcessor {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe"); // Valid case
            System.out.println("Created user: " + user1.getUsername());

            User user2 = new User("LongUsernameExceedsLimit"); // Invalid case
            System.out.println("Created user: " + user2.getUsername());

        } catch (IllegalArgumentException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }
    }
}
