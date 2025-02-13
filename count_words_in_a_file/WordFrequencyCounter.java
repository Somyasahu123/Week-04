package count_words_in_a_file;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "sample"; // Specify the text file path

        // HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read the file and count word occurrences
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Split line into words using regex (ignoring punctuation)
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) { // Ignore empty strings
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort by frequency

        // Display the total word count
        int totalWords = wordCountMap.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total words in file: " + totalWords);

        // Display the top 5 most frequent words
        System.out.println("\nTop 5 most frequently occurring words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedWords) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " times");
            if (++count == 5) break; // Stop after top 5 words
        }
    }
}

