package list_interface.rotate_elements_in_a_list;

import java.util.*;
public class RotateList {
    // Method to rotate the elements of a list by a given number of positions
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size; // Handle cases where positions > size

        if (positions == 0) return; // No rotation needed if positions is 0 or a multiple of size

        // Extract the portion of the list from 'positions' to the end
        List<T> rotated = new ArrayList<>(list.subList(positions, size));

        // Append the first 'positions' elements to the end of the rotated list
        rotated.addAll(list.subList(0, positions));

        // Clear the original list and update it with the rotated elements
        list.clear();
        list.addAll(rotated);
    }

    public static void main(String[] args) {
        // Creating a list of integers
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2; // Number of positions to rotate

        System.out.println("Before Rotation: " + numbers); // Print original list

        rotateList(numbers, rotateBy); // Rotate the list

        System.out.println("After Rotation: " + numbers); // Print rotated list
    }
}

