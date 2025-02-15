package regex.extraction;

import java.util.Scanner;

public class ReplaceAndModifyString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter a sentence with multiple spaces:");
        String text = scanner.nextLine();

        // Using regex to replace multiple spaces with a single space
        String normalizedText = text.replaceAll("\\s+", " ");

        System.out.println("Modified Text:");
        System.out.println(normalizedText);

        scanner.close();
    }
}

