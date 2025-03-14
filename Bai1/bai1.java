
package Bai1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class bai1 {
    public static void main(String[] args) {
        String sourceFile = "bt.txt";  
        String destinationFile = "output.txt"; 
        
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            
            System.out.println("Sao chep thanh cong!");
        } catch (IOException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }
}
