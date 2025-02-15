package annotations.exercise.customannotation;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        try {
            Method method = TaskManager.class.getMethod("completeTask");

            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Task Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            // Call the annotated method
            new TaskManager().completeTask();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

