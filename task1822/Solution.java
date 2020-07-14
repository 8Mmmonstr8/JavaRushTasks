package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        reader.close();
        BufferedReader fileBR = new BufferedReader(fr);

        String result;

        while ((result = fileBR.readLine()) != null) {
            if (result.startsWith(args[0] + " ")) {
                System.out.println(result);
                break;
            }
        }

        fr.close();
    }
}