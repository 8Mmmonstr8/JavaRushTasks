package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(fileName1);
        byte[] buffer = new byte[fis.available()];
        while (fis.available() > 0) {
            int x = fis.read(buffer);
        }
        fis.close();

        String str = new String(buffer);
        String[] splitedStr = str.split(" ");

        FileOutputStream fos = new FileOutputStream(fileName2);
        for (String z : splitedStr) {
            int a = (int) Math.round(Double.parseDouble(z));
            String s = Integer.toString(a);
            String s1 = s + " ";
            fos.write(s1.getBytes());
        }
        fos.close();


    }
}