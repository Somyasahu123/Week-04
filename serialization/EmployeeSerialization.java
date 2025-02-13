package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees"; // Serialized file

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        // Taking user input for employees
        System.out.print("Enter number of employees: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Department: ");
            String department = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            employees.add(new Employee(id, name, department, salary));
        }

        // Serialize employee list
        serializeEmployees(employees);

        // Deserialize and display employee data
        deserializeEmployees();

        scanner.close();
    }

    /**
     * Serializes the list of employees and saves to a file
     */
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("\nEmployees serialized successfully!");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Deserializes the list of employees from a file and displays them
     */
    private static void deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employees:");
            for (Employee emp : employees) {
                emp.displayEmployee();
            }
        } catch (IOException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found during deserialization!");
            e.printStackTrace();
        }
    }
}

