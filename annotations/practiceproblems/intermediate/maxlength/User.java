package annotations.practiceproblems.intermediate.maxlength;

import java.lang.reflect.Field;

class User {

    @MaxLength(10) // Maximum username length is 10 characters
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    // Validate fields using Reflection
    private void validateMaxLength(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                if (username.length() > annotation.value()) {
                    throw new IllegalArgumentException(
                            "Username exceeds max length of " + annotation.value() + " characters."
                    );
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

