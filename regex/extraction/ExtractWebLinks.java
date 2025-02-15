package regex.extraction;

import java.util.regex.*;
import java.util.Scanner;

public class ExtractWebLinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter the text containing URLs:");
        String text = scanner.nextLine();

        // Regular expression pattern for extracting URLs
        String urlPattern = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/\\S*)?\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Links:");
        boolean found = false;

        // Finding and printing all matching URLs
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        // If no links were found
        if (!found) {
            System.out.println("No valid links found.");
        }

        scanner.close();
    }
}


