package annotations.practiceproblems.advanced.cacheresult;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class CacheManager {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeCachedMethod(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, getParameterTypes(args));

        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = methodName + "_" + getArgsKey(args);

            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for: " + key);
                return cache.get(key);
            }

            Object result = method.invoke(obj, args);
            cache.put(key, result);
            return result;
        } else {
            return method.invoke(obj, args);
        }
    }

    private static String getArgsKey(Object... args) {
        StringBuilder key = new StringBuilder();
        for (Object arg : args) {
            key.append(arg.toString()).append("_");
        }
        return key.toString();
    }

    private static Class<?>[] getParameterTypes(Object... args) {
        Class<?>[] paramTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            paramTypes[i] = args[i].getClass();
        }
        return paramTypes;
    }
}
