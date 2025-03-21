package bai5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Log {
    static BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();
    static volatile boolean isRunning = true; 

    static class LogWriterThread extends Thread {
        private final String logFile;

        public LogWriterThread(String logFile) {
            this.logFile = logFile;
        }

        @Override
        public void run() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
                while (isRunning || !logQueue.isEmpty()) {
                    String logMessage = logQueue.poll();
                    if (logMessage != null) {
                        writer.write(logMessage);
                        writer.newLine();
                        writer.flush(); 
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void log(String message) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logEntry = timeStamp + " - " + message;
        logQueue.offer(logEntry);
    }

    public static void main(String[] args) throws InterruptedException {
        String logFile = "D:\\java\\iostream and thread\\bai5\\log.txt"; 
        LogWriterThread logWriter = new LogWriterThread(logFile);
        logWriter.start();

        log("Ứng dụng bắt đầu.");
        Thread.sleep(1000);
        log("Đang xử lý dữ liệu...");
        Thread.sleep(1000);
        log("Hoàn thành xử lý.");

        Thread.sleep(2000);
        isRunning = false;
        logWriter.join();
    }
}
