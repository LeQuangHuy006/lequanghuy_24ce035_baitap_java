import javax.swing.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
                String line;
                int soDong=0;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    soDong++;
                }
            System.out.println("số dòng trong file: "+soDong );
        } catch (IOException e) {
                e.printStackTrace();
        }

    }
}