package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(args[0]);

        byte[] symbols = new byte[fis.available()];
        fis.read(symbols);
        Arrays.sort(symbols);

        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();

        int count;

        for (byte x : symbols) {
            count = 0;

            for (byte x1 : symbols) {
                if (x == x1) {
                    count++;
                }
            }

            if (!map.containsKey(x)) {
                map.put(x, count);
                System.out.println((char) x + " " + count);
            }
        }
        fis.close();
    }
}