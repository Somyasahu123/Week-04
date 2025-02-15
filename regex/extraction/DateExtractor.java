package regex.extraction;

import java.util.regex.*;
import java.util.Scanner;

public class DateExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        // Regular expression pattern for dates in dd/mm/yyyy format
        String datePattern = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Dates:");
        boolean found = false;

        // Finding and printing all matching dates
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        // If no dates were found
        if (!found) {
            System.out.println("No valid dates found.");
        }

        scanner.close();
    }
}


