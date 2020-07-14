package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        String line;
        List<String> list = new LinkedList<>();
        while((line = fr.readLine()) != null) {
            if (line.substring(0, 8).trim().equals(args[1])) {
                if ("u".equals(args[0])) {
                    list.add(String.format("%-8s%-30s%-8s%-4s", args[1], args[2], args[3], args[4]));
                }
            } else {
                list.add(line);
            }
        }
        FileOutputStream fos = new FileOutputStream(fileName);
        for (String s : list) {
            fos.write(s.getBytes());
        }
    }

}