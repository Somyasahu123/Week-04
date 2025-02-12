package map_interface.merge_two_maps;

import java.util.*;

public class MergeMaps {
    public static void main(String[] args) {
        // Example input maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Call method to merge maps and print result
        System.out.println(mergeMaps(map1, map2));
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        // Create a new map with the contents of the first map
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        // Iterate through the second map
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            // Merge values if key exists, otherwise insert the key-value pair
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return mergedMap;
    }
}

