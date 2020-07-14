package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        //      ArrayList<String> txt = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        BufferedReader fbr = new BufferedReader(new FileReader(fileName));
        while (fbr.ready()) {
            String line = fbr.readLine();
            String[] sepLine = line.split(" ");
            for (int i = 0; i < sepLine.length; i++) {
                if (sepLine[i].matches("\\b[0-9]\\b|\\b1[0-2]\\b")) {
                    sepLine[i] = map.get(Integer.parseInt(sepLine[i]));
                }
            }
            for (String x : sepLine) {
                System.out.print(x + " ");
            }

        }
        fbr.close();
    }
}
