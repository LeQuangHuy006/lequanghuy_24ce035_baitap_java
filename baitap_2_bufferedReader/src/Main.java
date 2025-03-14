import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "output.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            System.out.println("Nhập dữ liệu (exit để kết thúc):");
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line + "\n");
            }
            System.out.println("đã lưu vào " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
