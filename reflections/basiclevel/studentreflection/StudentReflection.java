package reflections.basiclevel.studentreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class StudentReflection {
    public static void main(String[] args) {
        try {

            Class<?> studentClass = Class.forName("Student");


            Constructor<?> constructor = studentClass.getDeclaredConstructor();


            Object studentInstance = constructor.newInstance();

            Method displayMethod = studentClass.getMethod("display");
            displayMethod.invoke(studentInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
