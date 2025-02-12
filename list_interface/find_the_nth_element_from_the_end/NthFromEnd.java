package list_interface.find_the_nth_element_from_the_end;
import java.util.*;
public class NthFromEnd {
    // Method to find the Nth element from the end
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        // Two-pointer approach
        Iterator<T> first = list.iterator(); // Fast pointer
        Iterator<T> second = list.iterator(); // Slow pointer

        // Move the first pointer N steps ahead
        for (int i = 0; i < n; i++) {
            if (first.hasNext()) {
                first.next();
            } else {
                throw new IllegalArgumentException("N is larger than the list size");
            }
        }

        // Move both pointers until first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        // The second pointer is now at the Nth element from the end
        return second.next();
    }

    public static void main(String[] args) {
        // Example linked list
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int N = 2;

        System.out.println("Linked List: " + list);
        System.out.println("Nth element from end: " + findNthFromEnd(list, N));
    }
}

