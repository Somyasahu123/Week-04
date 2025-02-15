package reflections.advancedlevel.dependencyinjection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();


    public <T> void register(Class<T> clazz) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, instance);
    }

    public void injectDependencies(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> dependencyType = field.getType();
                Object dependency = instances.get(dependencyType);
                if (dependency == null) {
                    dependency = dependencyType.getDeclaredConstructor().newInstance();
                    instances.put(dependencyType, dependency);
                }
                field.setAccessible(true);
                field.set(object, dependency);
            }
        }
    }
}

