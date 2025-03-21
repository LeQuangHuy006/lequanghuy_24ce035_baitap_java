package bai3;

import java.io.*;

public class main {
    public static void main(String[] args) {
        String sourceFile = "D:\\java\\iostream and thread\\bai3\\file.txt"; 
        String destinationFile = "D:\\java\\iostream and thread\\bai3\\filecopy.txt"; 

        Thread copyThread = new Thread(new FileCopy(sourceFile, destinationFile));
        copyThread.start();
    }
}

class FileCopy implements Runnable {
    private final String sourceFile;
    private final String destinationFile;

    public FileCopy(String sourceFile, String destinationFile) {
        this.sourceFile = sourceFile;
        this.destinationFile = destinationFile;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Sao chep hoan tat " + sourceFile + " sang " + destinationFile);
        } catch (IOException e) {
            System.err.println("Da bi loi: " + e.getMessage());
        }
    }
}
