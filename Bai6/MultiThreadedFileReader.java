package Bai6;
import java.io.*;
import java.util.concurrent.*;

public class MultiThreadedFileReader {
    public static void main(String[] args) throws Exception {
        String inputFile = "largeFile.txt";
        String outputFile = "output.txt";
        int chunkSize = 1024 * 1024; 
        
        File file = new File(inputFile);
        long fileSize = file.length();
        int numChunks = (int) Math.ceil((double) fileSize / chunkSize);
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<String>[] results = new Future[numChunks];
        
        for (int i = 0; i < numChunks; i++) {
            long start = i * chunkSize;
            int size = (int) Math.min(chunkSize, fileSize - start);
            results[i] = executor.submit(new FileReaderTask(inputFile, start, size));
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        for (Future<String> result : results) {
            writer.write(result.get());
        }
        writer.close();
        executor.shutdown();
        
        System.out.println("Hoan thanh doc file bang da luong.");
    }
}