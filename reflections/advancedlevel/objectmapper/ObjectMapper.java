package reflections.advancedlevel.objectmapper;

import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {

            T instance = clazz.getDeclaredConstructor().newInstance();


            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {

                    Field field = clazz.getDeclaredField(fieldName);


                    field.setAccessible(true);


                    field.set(instance, value);
                } catch (NoSuchFieldException e) {

                    System.out.println("Field not found: " + fieldName);
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Error creating object", e);
        }
    }
}

