package finally_block;

import java.util.Scanner;

public class DivisionWithFinally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Accept two integers from the user
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            // Perform division
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Operation completed.");
            scanner.close();
        }
    }
}


