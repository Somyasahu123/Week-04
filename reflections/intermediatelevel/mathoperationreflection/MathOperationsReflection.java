package reflections.intermediatelevel.mathoperationreflection;

import java.lang.reflect.Method;
import java.util.Scanner;
public class MathOperationsReflection {
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);


            Class<?> mathClass = MathOperations.class;
            Object mathInstance = mathClass.getDeclaredConstructor().newInstance();


            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();


            Method method = mathClass.getMethod(methodName, int.class, int.class);


            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();


            Object result = method.invoke(mathInstance, num1, num2);


            System.out.println("Result: " + result);
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}