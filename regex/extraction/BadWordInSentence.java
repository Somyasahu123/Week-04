package regex.extraction;

import java.util.Scanner;

public class BadWordInSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List of bad words to censor (Modify as needed)
        String[] badWords = {"damn", "stupid"};

        // Taking input from the user
        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();

        // Censoring bad words by replacing them with ****
        for (String badWord : badWords) {
            text = text.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }

        System.out.println("Censored Sentence:");
        System.out.println(text);

        scanner.close();
    }
}


