package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        br.close();

        BufferedReader fbr = new BufferedReader((new FileReader(fileName1)));
        int count = 0;
        while (fbr.ready()) {
            String data = fbr.readLine();
            String[] strings = data.split("[^a-zA-Z0-9]");
            for (String s : strings) {
                if (s.equals("world")) count++;
            }
        }
        fbr.close();
        System.out.println(count);
    }
}

