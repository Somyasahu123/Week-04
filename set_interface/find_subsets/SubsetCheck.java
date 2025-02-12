package set_interface.find_subsets;

import java.util.HashSet;
import java.util.Set;
public class SubsetCheck {
    public static void main(String[] args) {
        // Creating two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Adding elements to set1 (potential subset)
        set1.add(2);
        set1.add(3);

        // Adding elements to set2 (main set)
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Checking if set1 is a subset of set2
        boolean isSubset = set2.containsAll(set1);

        // Display results
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }
}
