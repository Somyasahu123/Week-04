package queue_interface.hospital_triage_system;

import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    String name;
    int severity; // Higher value means more severe

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        // Priority Queue with a custom comparator (higher severity first)
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.severity));

        // Adding patients
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        System.out.println("Order of treatment :");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().name);
        }
    }
}

