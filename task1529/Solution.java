package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
        //add your code here - добавьте код тут
    }

    public static CanFly result;

    public static void reset() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String s = reader.readLine();
            if (s.equals("helicopter")) {
                result = new Helicopter();
            }
            else if (s.equals("plane")) {
                int x = Integer.parseInt(reader.readLine());
                result = new Plane(x);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("ashipka");
        }

    }
}
