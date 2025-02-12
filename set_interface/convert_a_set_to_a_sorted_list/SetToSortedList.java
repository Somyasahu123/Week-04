package set_interface.convert_a_set_to_a_sorted_list;

import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        // Creating a HashSet of integers
        Set<Integer> numberSet = new HashSet<>();

        // Adding elements to the set
        numberSet.add(5);
        numberSet.add(3);
        numberSet.add(9);
        numberSet.add(1);

        // Convert the set to a list
        List<Integer> sortedList = new ArrayList<>(numberSet);

        // Sort the list in ascending order
        Collections.sort(sortedList);

        // Display results
        System.out.println("Original Set: " + numberSet);
        System.out.println("Sorted List: " + sortedList);
    }
}

