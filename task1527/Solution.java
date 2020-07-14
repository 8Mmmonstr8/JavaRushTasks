package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        int indexM = s.indexOf("?");
        String s2 = s.substring(indexM + 1);

        ArrayList<String> Obj = new ArrayList<>();

        for (String x : s2.split("&")) {
            int index = x.indexOf("=");
            if (index != -1) {
                String b = x.substring(0, index);
                System.out.println(b);
                if (b.equals("obj")) {
                    Obj.add(x.substring(index + 1));
                }
            }
            else {
                System.out.println(x);
            }
            //         System.out.print(" ");
        }

        for (int i = 0; i < Obj.size(); i++) {
            try {
                double db = Double.parseDouble(Obj.get(i));
                alert(db);
            } catch (NumberFormatException e) {
                alert(Obj.get(i));
            }
        }
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

// http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo