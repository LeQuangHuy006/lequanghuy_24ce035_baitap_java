package Bai4;
import java.io.*;

public class bai4 {
    public static void main(String[] args) {
        String fileName = "numbers.txt";
        int[] numbers = {10, 20, 30, 40, 50}; 
        
      
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("Ghi danh sach so nguyen vao file thanh cong.");
        } catch (IOException e) {
            System.err.println("Loi khi ghi file: " + e.getMessage());
        }
        
      
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Cac so nguyen đoc tu file:");
            while (dis.available() > 0) {
                System.out.println(dis.readInt());
            }
        } catch (IOException e) {
            System.err.println("Loi khi đoc file: " + e.getMessage());
        }
    }
}
