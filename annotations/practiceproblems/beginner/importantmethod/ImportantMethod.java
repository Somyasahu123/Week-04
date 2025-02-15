package annotations.practiceproblems.beginner.importantmethod;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// Define @ImportantMethod annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime for reflection
@Target(ElementType.METHOD) // Can be used on methods
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with default value
}

