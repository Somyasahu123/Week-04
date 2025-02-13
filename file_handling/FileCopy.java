package file_handling;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // Source and destination file paths
        String sourceFile = "source"; // Change this to your source file path
        String destinationFile = "destination.txt"; // Change this to your destination file path

        // FileInputStream for reading the source file
        // FileOutputStream for writing to the destination file
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            // Buffer to hold file data
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read from source and write to destination
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found!");
        } catch (IOException e) {
            System.out.println("Error: An IO exception occurred!");
            e.printStackTrace();
        }
    }
}
