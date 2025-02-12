package list_interface.find_frequency_of_elements;
import java.util.*;

public class FrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : list) {
            // Increment count if the item already exists, otherwise initialize to 1
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        // Example input
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");

        // Get frequency map
        Map<String, Integer> result = countFrequency(words);

        // Print output
        System.out.println(result);
    }
}
