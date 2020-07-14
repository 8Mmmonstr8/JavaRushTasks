package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> fileSet = new TreeSet<>();
        String str;
        while (!(str = br.readLine()).equals("end")) {
            fileSet.add(str);
        }
        br.close();

        String outputFileName = fileSet.first();
        outputFileName = outputFileName.substring(0, outputFileName.lastIndexOf("."));
        FileOutputStream fos = new FileOutputStream(outputFileName, true);

        for (String fileName : fileSet) {
            FileInputStream fis = new FileInputStream(fileName);
            if (fis.available() > 0) {
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fos.write(buffer);
            }
            fis.close();
        }
        fos.close();
    }
}
