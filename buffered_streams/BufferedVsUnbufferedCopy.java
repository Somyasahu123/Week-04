package buffered_streams;

import java.io.*;

public class BufferedVsUnbufferedCopy{
    public static void main(String[] args) {
        String sourceFile = "large_log";  // Change to your actual file
        String destBuffered = "dest_buffered.txt";
        String destUnbuffered = "dest_unbuffered.txt";

        // Measure time for buffered copy
        long startTime = System.nanoTime();
        copyFileBuffered(sourceFile, destBuffered);
        long endTime = System.nanoTime();
        System.out.println("Buffered Copy Time: " + (endTime - startTime) / 1e6 + " ms");

        // Measure time for unbuffered copy
        startTime = System.nanoTime();
        copyFileUnbuffered(sourceFile, destUnbuffered);
        endTime = System.nanoTime();
        System.out.println("Unbuffered Copy Time: " + (endTime - startTime) / 1e6 + " ms");
    }

    // Copy using Buffered Streams (efficient way)
    private static void copyFileBuffered(String source, String destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Copy using Unbuffered Streams (slower way)
    private static void copyFileUnbuffered(String source, String destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            int byteData;
            while ((byteData = fis.read()) != -1) { // Reads byte by byte (slow)
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}