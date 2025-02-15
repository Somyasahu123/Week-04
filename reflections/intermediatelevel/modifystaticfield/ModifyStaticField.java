package reflections.intermediatelevel.modifystaticfield;

import java.lang.reflect.Field;

public class ModifyStaticField {
    public static void main(String[] args) {
        try {

            Class<Configuration> configClass = Configuration.class;


            Field apiKeyField = configClass.getDeclaredField("API_KEY");


            apiKeyField.setAccessible(true);


            apiKeyField.set(null, "NEW_UPDATED_KEY");

            System.out.println("Updated API_KEY: " + Configuration.getApiKey());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

