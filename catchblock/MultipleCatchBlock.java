package catchblock;

import java.util.Scanner;

public class MultipleCatchBlock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            // Accept array size
            System.out.print("Enter the size of the array: ");
            int size = input.nextInt();
            Integer[] array = new Integer[size];

            // Accept array elements
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                array[i] = input.nextInt();
            }

            // Accept index to retrieve value
            System.out.print("Enter the index number to retrieve: ");
            int index = input.nextInt();

            // Retrieve and print value at the given index
            System.out.println("Value at index " + index + " is: " + array[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of range.");
        } catch (NullPointerException e) {
            System.out.println("Error: The array is null.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}

