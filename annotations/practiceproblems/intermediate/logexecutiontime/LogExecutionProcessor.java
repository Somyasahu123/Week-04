package annotations.practiceproblems.intermediate.logexecutiontime;

import java.lang.reflect.Proxy;

public class LogExecutionProcessor {
    public static void main(String[] args) {
        Service service = new Service();
        Service proxyInstance = (Service) Proxy.newProxyInstance(
                Service.class.getClassLoader(),
                Service.class.getInterfaces(),
                new ExecutionTimeHandler(service)
        );
        service.processData();
        service.fetchData();
        service.helperMethod();
    }
}
