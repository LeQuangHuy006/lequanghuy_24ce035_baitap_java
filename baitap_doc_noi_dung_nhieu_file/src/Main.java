import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Admin\\OneDrive\\Documents\\Visual Studio 2017\\.vscode\\lt java ki2\\bt_java\\cac_file_noi_dung");
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Thư mục không chứa file nào.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            List<Thread> threads = new ArrayList<>();

            for (File file : files) {
                if (file.isFile()) {
                    Thread thread = new docfile(file, writer);
                    threads.add(thread);
                    thread.start();
                }
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("\nHoàn thành việc ghi nội dung vào file 'output.txt'");
        } catch (IOException e) {
            System.err.println("Lỗi khi tạo file đầu ra.");
        }
    }
}
