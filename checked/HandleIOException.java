package checked;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HandleIOException {
    public static void readFile(String filePath){

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            System.out.println("Lines containing 'error':\n");

            // Read the file line by line
            while ((line = reader.readLine()) != null) {

            }

        }catch (IOException e) {
            System.out.println("File not Found Exception \n" + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String filePath = "data.txt";
        readFile(filePath);
    }
}

