package annotations.exercise.customannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// Define custom annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime for reflection
@Target(ElementType.METHOD) // Can be used on methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}

