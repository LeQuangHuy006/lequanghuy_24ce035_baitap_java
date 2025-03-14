package Bai5;

import java.io.File;

public class bai5  {
    public static void main(String[] args) {
       
        String folderPath = "C:\\Users\\admin\\Downloads\\WEB DESIGN\\LAB1"; 
        
        File folder = new File(folderPath);
        
        if (folder.isDirectory()) {
            File[] fileList = folder.listFiles();
            
            if (fileList != null) {
                System.out.println("Danh sach cac file trong thu muc: " + folderPath);
                for (File file : fileList) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Thu muc trong hoac khong the đoc thu muc.");
            }
        } else {
            System.out.println("Đuong dan khong phai la thu muc hop le.");
        }
    }
}
