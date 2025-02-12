package set_interface.union_and_intersection_of_two_sets;
import java.util.HashSet;
import java.util.Set;
public class SetOperations {
    public static void main(String[] args) {
        // Creating two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Adding elements to set1
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Adding elements to set2
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Computing the union of set1 and set2
        Set<Integer> unionSet = new HashSet<>(set1); // Copy set1 into unionSet
        unionSet.addAll(set2); // Add all elements of set2

        // Computing the intersection of set1 and set2
        Set<Integer> intersectionSet = new HashSet<>(set1); // Copy set1 into intersectionSet
        intersectionSet.retainAll(set2); // Keep only common elements

        // Display results
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);
    }
}

