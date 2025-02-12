package map_interface.word_frequency_counter;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        // Example input text
        String text = "Hello world, hello Java!";

        // Call method to count word frequency and print result
        System.out.println(countWordFrequency(text));
    }

    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Convert text to lowercase and remove punctuation
        text = text.toLowerCase().replaceAll("[^a-zA-Z ]", "");

        // Split text into words using whitespace
        String[] words = text.split("\\s+");

        // Count occurrences of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
}
