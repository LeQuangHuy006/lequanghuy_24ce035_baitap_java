package Bai3;

import java.io.*;

public class bai3 {
    public static void main(String[] args) {
        String fileName = "C:\\Bài tập\\bt lập trình java\\Chương2\\BT_filett\\Bai3\\input.txt"; 
        int lineCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("So dong trong tep " + fileName + " la: " + lineCount);
        } catch (IOException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }
}
