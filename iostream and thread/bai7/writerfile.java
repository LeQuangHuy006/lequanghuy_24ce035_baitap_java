package bai7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class writerfile extends Thread {
    private String fileName;

    public writerfile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            System.out.println("nhap du lieu (go 'exit' de thoat):");

            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) break; 

                writer.write(input);
                writer.newLine();
                writer.flush();
            }

            System.out.println("du lieu da duoc luu vao file: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       writerfile writerThread = new writerfile ("D:\\java\\iostream and thread\\bai7\\file.txt");
        writerThread.start();
    }
}
