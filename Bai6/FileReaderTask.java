package Bai6;
import java.io.*;
import java.util.concurrent.*;

class FileReaderTask implements Callable<String> {
    private String filePath;
    private long start;
    private int size;

    public FileReaderTask(String filePath, long start, int size) {
        this.filePath = filePath;
        this.start = start;
        this.size = size;
    }

    @Override
    public String call() throws Exception {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(start);
        byte[] buffer = new byte[size];
        int bytesRead = file.read(buffer);
        file.close();
        return new String(buffer, 0, bytesRead);
    }
}


