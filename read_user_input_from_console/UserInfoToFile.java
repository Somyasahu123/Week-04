package read_user_input_from_console;

import java.io.*;

public class UserInfoToFile {
    public static void main(String[] args) {
        // Define the output file name
        String outputFile = "user_info.txt";

        // Using BufferedReader for console input
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(outputFile)) {

            // Prompting user for details
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Writing user data to file
            writer.write("User Information:\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("User information saved successfully to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: An I/O exception occurred!");
            e.printStackTrace();
        }
    }
}

