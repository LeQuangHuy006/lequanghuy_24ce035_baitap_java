package bai2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class main {
    private static final String FILE_NAME = "D:\\java\\iostream and thread\\bai2\\file.txt";
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new WriterTask("Thread 1: Xin chao toi la thread 1\n"));
        Thread thread2 = new Thread(new WriterTask("Thread 2: Xin chao toi la thread 2\n"));

        thread1.start();
        thread2.start();
    }

    static class WriterTask implements Runnable {
        private final String message;

        public WriterTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            lock.lock(); 
            try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
                writer.write(message);
                System.out.println("Written: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
