package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine(), fileName2 = br.readLine();
        br.close();

        BufferedReader fbR = new BufferedReader(new FileReader(fileName1));


        ArrayList<Integer> intArray = new ArrayList<>();
        while (fbR.ready()) {
            String data = fbR.readLine();
            String[] dataArray = data.split(" ");

            for (String x : dataArray) {
                try {
                    int z = Integer.parseInt(x);
                    intArray.add(z);
                } catch (NumberFormatException e) { }
            }
        }

        fbR.close();
        try (BufferedWriter fbW = new BufferedWriter(new FileWriter(fileName2))) {

            for (int i = 0; i < intArray.size(); i++) {
                String o = intArray.get(i) + " ";
                fbW.write(o);
            }
        } catch (IOException e) { }

    }
}
