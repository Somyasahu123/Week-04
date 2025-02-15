package regex.extraction;

import java.util.regex.*;
import java.util.Scanner;

public class ExtractAllCapitalWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();

        // Regular expression pattern to match capitalized words
        String capitalizedWordPattern = "\\b[A-Z][a-z]*\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(capitalizedWordPattern);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Capitalized Words:");
        boolean found = false;

        // Finding and printing all capitalized words
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            found = true;
        }

        // If no capitalized words were found
        if (!found) {
            System.out.println("No capitalized words found.");
        }

        scanner.close();
    }
}


