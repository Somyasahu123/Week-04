package reflections.advancedlevel.methodexecution;

import java.lang.reflect.Method;

public class MethodTimer {
    public static void measureExecutionTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);

        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time of " + methodName + ": " + executionTime + " ms");
    }
}
