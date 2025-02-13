package data_streams;

import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "students.dat"; // Binary file to store student details

        // Writing student details to the file
        writeStudentData(fileName);

        // Reading and displaying student details from the file
        readStudentData(fileName);
    }

    // Method to write student details to a binary file
    private static void writeStudentData(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // Writing multiple student records
            dos.writeInt(101); // Roll Number
            dos.writeUTF("Alice Johnson"); // Name
            dos.writeDouble(3.8); // GPA

            dos.writeInt(102);
            dos.writeUTF("Bob Smith");
            dos.writeDouble(3.5);

            dos.writeInt(103);
            dos.writeUTF("Charlie Brown");
            dos.writeDouble(3.9);

            System.out.println("Student details successfully written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read and display student details from the binary file
    private static void readStudentData(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nReading student details from " + fileName + ":");
            while (dis.available() > 0) { // Check if there is data left to read
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}

