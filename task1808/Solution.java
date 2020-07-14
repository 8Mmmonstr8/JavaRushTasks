package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        FileInputStream fis1 = new FileInputStream(fileName1);
        FileOutputStream fos2 = new FileOutputStream(fileName2);
        FileOutputStream fos3 = new FileOutputStream(fileName3);

        byte[] buffer = new byte[fis1.available()];
        while (fis1.available() > 0) {
            int count = fis1.read(buffer);
            int temp = count % 2 == 0 ? count / 2 : count / 2 + 1;

            fos2.write(buffer, 0, temp);
            fos3.write(buffer, temp, count - temp);
        }

        fis1.close();
        fos2.close();
        fos3.close();

    }
}
