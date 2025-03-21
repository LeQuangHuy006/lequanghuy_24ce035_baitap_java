package bai1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileReaderThread extends Thread {
    private String filePath;

    public FileReaderThread(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Không thể mở file: " + filePath);
        }
    }
}

public class main {
    public static void main(String[] args) {
        String filePath = "D:\\java\\iostream and thread\\bai1\\file.txt";

        FileReaderThread thread = new FileReaderThread(filePath);
        thread.start();

        try {
            thread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
