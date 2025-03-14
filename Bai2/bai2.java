package Bai2;
import java.io.*;

public class bai2  {
    public static void main(String[] args) {
        String fileName = "output.txt"; 
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            
            System.out.println("Nhap du lieu (go 'exit' đe ket thuc):");
            String line;
            
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine(); 
            }
            
            System.out.println("Du lieu da duoc luu vao" + fileName);
        } catch (IOException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }
}

