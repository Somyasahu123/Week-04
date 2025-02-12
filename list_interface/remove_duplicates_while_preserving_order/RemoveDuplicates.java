package list_interface.remove_duplicates_while_preserving_order;

import java.util.*;
public class RemoveDuplicates {
    // Method to remove duplicates while maintaining order
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>(); // HashSet to track seen elements
        List<T> result = new ArrayList<>(); // List to store unique elements

        for (T item : list) {
            // If the element is not in the set, add it to both set and result list
            if (seen.add(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example input list with duplicates
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);

        System.out.println("Before Removing Duplicates: " + numbers); // Print original list

        // Call method to remove duplicates
        List<Integer> uniqueNumbers = removeDuplicates(numbers);

        System.out.println("After Removing Duplicates: " + uniqueNumbers); // Print result
    }
}

