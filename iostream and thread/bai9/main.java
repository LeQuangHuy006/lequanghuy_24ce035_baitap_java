package bai9;

import java.io.*;

public class main {
    
    static class CharCounter extends Thread {
        private String sourceFile;
        private String resultFile;

        public CharCounter(String sourceFile, String resultFile) {
            this.sourceFile = sourceFile;
            this.resultFile = resultFile;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile))) {

                int charCount = 0;
                int ch;
                while ((ch = br.read()) != -1) {
                    charCount++;
                }

                String result = "So ki tu trong file: " + charCount;
                bw.write(result);
                bw.newLine();

                System.out.println(result); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String sourceFile = "D:\\java\\iostream and thread\\bai9\\file1.txt";
        String resultFile = "D:\\java\\iostream and thread\\bai9\\file2.txt";

        CharCounter counter = new CharCounter(sourceFile, resultFile);
        counter.start();
    }
}
