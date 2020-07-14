package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
        }
    }
    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();

        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFilenName;
        private StringBuilder sb = new StringBuilder();

        public ReadFileThread() {}

        @Override
        public void setFileName(String fullFileName) {
            this.fullFilenName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return sb.toString();
        }

        public void run() {
            String string;

            try {
                BufferedReader in = new BufferedReader((new FileReader(fullFilenName)));
                while ((string = in.readLine()) != null) {
                    sb.append(string);
                    sb.append(" ");
                }
                in.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }
        }
    }
    //add your code here - добавьте код тут
}