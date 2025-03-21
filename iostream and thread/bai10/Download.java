package bai10;
import java.io.*;
import java.net.*;

public class Download {
    
    static class Downloader extends Thread {
        private String url;
        private String destinationFile;

        public Downloader(String url, String destinationFile) {
            this.url = url;
            this.destinationFile = destinationFile;
        }

        @Override
        public void run() {
            try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("Tai xuong hoan tat: " + destinationFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String url = "https://baomoi.com/"; 
        String destinationFile = "downloaded.txt";

        Downloader downloader = new Downloader(url, destinationFile);
        downloader.start();
    }
}
