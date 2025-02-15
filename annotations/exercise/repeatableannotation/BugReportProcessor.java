package annotations.exercise.repeatableannotation;

import java.lang.reflect.Method;

public class BugReportProcessor {
    public static void main(String[] args) {
        try {
            Method method = BugTracker.class.getMethod("processTask");

            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);

                for (BugReport bug : bugReports.value()) {
                    System.out.println("Bug Report: " + bug.description());
                }
            }
            new BugTracker().processTask();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}


