package bytearray_stream;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        // Define source and destination image file paths
        String sourceImage = "delete.png";  // Replace with your image file path
        String destinationImage = "copy.png";  // Output image file

        try {
            // Convert image to byte array
            byte[] imageData = imageToByteArray(sourceImage);

            // Write byte array back to new image file
            byteArrayToImage(imageData, destinationImage);

            System.out.println("Image copied successfully!");

        } catch (IOException e) {
            System.out.println("Error: An I/O exception occurred!");
            e.printStackTrace();
        }
    }

    /**
     * Reads an image file and converts it into a byte array.
     * @param imagePath Path of the source image file.
     * @return Byte array containing image data.
     * @throws IOException If file operations fail.
     */
    private static byte[] imageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray(); // Convert to byte array
        }
    }

    /**
     * Writes a byte array back into an image file.
     * @param imageData Byte array containing image data.
     * @param outputPath Path where the new image should be saved.
     * @throws IOException If file operations fail.
     */
    private static void byteArrayToImage(byte[] imageData, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}

