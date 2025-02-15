package regex.advance;

import java.util.regex.*;
import java.util.Scanner;

public class CurrencyExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter a sentence containing currency values:");
        String text = scanner.nextLine();

        // Regular expression pattern to match currency values (with or without $ symbol)
        String currencyPattern = "\\$?\\d+\\.\\d{2}";

        // Compile the pattern
        Pattern pattern = Pattern.compile(currencyPattern);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Currency Values:");
        boolean found = false;

        // Finding and printing all matching currency values
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            found = true;
        }

        // If no currency values were found
        if (!found) {
            System.out.println("No currency values found.");
        }
        scanner.close();
    }
}


