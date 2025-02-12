package set_interface.symmetric_difference;
import java.util.HashSet;
import java.util.Set;
public class SymmetricDifference {
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

        // Computing the symmetric difference
        Set<Integer> symmetricDiff = new HashSet<>(set1); // Copy set1 into symmetricDiff
        symmetricDiff.addAll(set2); // Add all elements of set2

        Set<Integer> intersection = new HashSet<>(set1); // Copy set1 into intersection
        intersection.retainAll(set2); // Keep only common elements

        symmetricDiff.removeAll(intersection); // Remove common elements from union

        // Display results
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}

