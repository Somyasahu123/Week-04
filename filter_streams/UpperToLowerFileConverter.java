package filter_streams;

import java.io.*;

public class UpperToLowerFileConverter {
    public static void main(String[] args) {
        // Define input and output file names
        String inputFile = "input";   // Input file path
        String outputFile = "output.txt"; // Output file path

        // Use try-with-resources to handle file operations
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Convert the line to lowercase and write it to the output file
                writer.write(line.toLowerCase());
                writer.newLine(); // Add a new line after writing each line
            }

            System.out.println("File conversion completed. Check " + outputFile);
        } catch (IOException e) {
            // Handle exceptions related to file reading/writing
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

