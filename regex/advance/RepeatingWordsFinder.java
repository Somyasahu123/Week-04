package regex.advance;

import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();

        // Regular expression pattern to find repeated words
        String wordPattern = "\\b(\\w+)\\b(?:\\s+\\1\\b)+";

        // Compile the pattern
        Pattern pattern = Pattern.compile(wordPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        // Using a Set to store unique repeated words
        Set<String> repeatedWords = new HashSet<>();

        // Finding repeated words
        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }

        // Displaying the repeated words
        System.out.println("Repeated Words:");
        if (repeatedWords.isEmpty()) {
            System.out.println("No repeated words found.");
        } else {
            System.out.println(String.join(", ", repeatedWords));
        }

        scanner.close();
    }
}


