package map_interface.invert_a_map;

import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        // Example input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        // Call method to invert the map and print result
        System.out.println(invertMap(inputMap));
    }

    public static Map<Integer, List<String>> invertMap(Map<String, Integer> map) {
        Map<Integer, List<String>> invertedMap = new HashMap<>();

        // Iterate through the original map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // If key (value from original map) does not exist in invertedMap, create a new list
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        return invertedMap;
    }
}
