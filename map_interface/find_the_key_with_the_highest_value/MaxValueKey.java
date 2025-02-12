package map_interface.find_the_key_with_the_highest_value;

import java.util.*;

public class MaxValueKey {
    public static void main(String[] args) {
        // Example input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        // Call method to find max key and print result
        System.out.println(findMaxKey(inputMap));
    }

    public static String findMaxKey(Map<String, Integer> map) {
        // Find the entry with the highest value and return its key
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}

