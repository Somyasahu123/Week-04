package regex.advance;

import java.util.Scanner;
import java.util.regex.*;

public class CreditCardNumberValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter a credit card number:");
        String cardNumber = scanner.nextLine();

        // Regular expression patterns for Visa and MasterCard
        String visaPattern = "^4[0-9]{15}$";      // Visa: Starts with 4, 16 digits
        String masterCardPattern = "^5[1-5][0-9]{14}$";  // MasterCard: Starts with 51-55, 16 digits

        // Compiling the patterns
        Pattern visa = Pattern.compile(visaPattern);
        Pattern masterCard = Pattern.compile(masterCardPattern);

        Matcher visaMatcher = visa.matcher(cardNumber);
        Matcher masterCardMatcher = masterCard.matcher(cardNumber);

        // Checking if the entered card number is valid
        if (visaMatcher.matches()) {
            System.out.println("Valid Visa Card.");
        } else if (masterCardMatcher.matches()) {
            System.out.println("Valid MasterCard.");
        } else {
            System.out.println("Invalid Credit Card Number.");
        }

        scanner.close();
    }
}


