package regex.advance;

import java.util.regex.*;
import java.util.Scanner;

public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter a sentence containing programming languages:");
        String text = scanner.nextLine();

        // List of programming languages to extract (modify as needed)
        String[] languages = {"JavaScript", "Java", "Python", "C\\+\\+", "C#", "Go", "Swift", "Ruby", "Kotlin"};

        // Regular expression pattern to match programming languages
        String patternString = "\\b(" + String.join("|", languages) + ")\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Programming Languages:");
        boolean found = false;

        // Finding and printing all matching programming languages
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            found = true;
        }

        // If no languages were found
        if (!found) {
            System.out.println("No programming languages found.");
        }

        scanner.close();
    }
}


