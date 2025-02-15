package annotations.practiceproblems.intermediate.logexecutiontime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class ExecutionTimeHandler implements InvocationHandler {
    private final Object target;

    public ExecutionTimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();
            Object result = method.invoke(target, args);
            long endTime = System.nanoTime();
            System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
            return result;
        } else {
            return method.invoke(target, args);
        }
    }
}
