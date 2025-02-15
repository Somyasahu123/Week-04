package annotations.practiceproblems.beginner.todo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// Define @Todo annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime for reflection
@Target(ElementType.METHOD) // Can be used on methods
@interface Todo {
    String task(); // Task description
    String assignedTo(); // Developer responsible
    String priority() default "MEDIUM"; // Default priority is MEDIUM
}

