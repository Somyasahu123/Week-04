package reflections.advancedlevel.jsonrepresentation;

import java.lang.reflect.Field;

public class JsonSerializer {

    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        StringBuilder json = new StringBuilder("{");

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            field.setAccessible(true); // Allow access to private fields
            try {
                if (!first) {
                    json.append(", ");
                }
                first = false;

                String name = field.getName();
                Object value = field.get(obj);

                json.append("\"").append(name).append("\": ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field: " + field.getName(), e);
            }
        }

        json.append("}");
        return json.toString();
    }
}

