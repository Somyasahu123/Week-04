package set_interface.check_if_two_sets_are_equal;

import java.util.HashSet;
import java.util.Set;

public class SetEqualityCheck {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Adding elements to set1
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Adding elements to set2
        set2.add(3);
        set2.add(2);
        set2.add(1);

        // Checking if both sets are equal
        boolean isEqual = set1.equals(set2);
        System.out.println("Are the sets equal? " + isEqual);
    }
}

