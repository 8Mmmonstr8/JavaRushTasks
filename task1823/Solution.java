package com.javarush.task.task18.task1823;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            for (fileName = reader.readLine(); !fileName.equals("exit"); fileName = reader.readLine()) {
                Thread th = new ReadThread(fileName);
                th.start();
                th.join();
            }
        } catch (Exception e) {}
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            try {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
                int nextByte;
                int[] bytesCount = new int[256];
                while ((nextByte = in.read()) != -1) {
                    if (nextByte < -1) throw new RuntimeException();
                    bytesCount[nextByte]++;
                }
                int maxI = 0;
                for (int i = 1; i < bytesCount.length; i++) {
                    if (bytesCount[i] > bytesCount[maxI])
                        maxI = i;
                }
                synchronized (Solution.class) {
                    resultMap.put(fileName, maxI);
                }
                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File \"" + fileName + "\" not found");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Read next byte error. File: \"" + fileName + "\"");
                e.printStackTrace();
            }
        }

    }
}