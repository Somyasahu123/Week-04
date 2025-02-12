package queue_interface.generate_binary_numbers_using_a_queue;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersQueue {

    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String binary = queue.poll(); // Remove the front element
            System.out.print(binary + " "); // Print the binary number

            queue.add(binary + "0"); // Enqueue next binary numbers
            queue.add(binary + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("First " + N + " binary numbers :");
        generateBinaryNumbers(N);
    }
}

