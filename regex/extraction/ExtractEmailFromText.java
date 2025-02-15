package regex.extraction;

import java.util.regex.*;
import java.util.Scanner;

public class ExtractEmailFromText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        // Regular expression pattern for extracting email addresses
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Compile the pattern
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Email Addresses:");
        boolean found = false;

        // Finding and printing all email addresses in the text
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        // If no emails were found
        if (!found) {
            System.out.println("No valid email addresses found.");
        }

        scanner.close();
    }
}


