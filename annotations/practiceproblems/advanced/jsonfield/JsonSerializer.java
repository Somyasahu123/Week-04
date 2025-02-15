package annotations.practiceproblems.advanced.jsonfield;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class JsonSerializer {

    public static String serialize(Object obj) {
        Map<String, String> jsonMap = new HashMap<>();

        Class<?> objClass = obj.getClass();
        for (Field field : objClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                try {
                    jsonMap.put(annotation.name(), field.get(obj).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return jsonMap.toString().replace("=", ":"); // Convert map to JSON-like string
    }
}

