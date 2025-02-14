package exception_propagation;

import java.util.Scanner;

public class ThrowVsThrows {

    // Method to calculate interest with exception handling
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return amount * rate * years / 100; // Simple interest formula
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Accept user input
            System.out.print("Enter the principal amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the interest rate: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter the number of years: ");
            int years = scanner.nextInt();

            // Calculate and print interest
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


