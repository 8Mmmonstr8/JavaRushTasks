package com.javarush.task.task14.task1419;

import java.io.*;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
/*1*/   /*ArithmeticException*/
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

/*2*/   /*FileNotFoundException*/
        try {
            File file = new File("E://file.txt");
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e2) {
            exceptions.add(e2);
        }

/*3*/   /*ArrayIndexOutOfBoundException*/
        try {
            int num[] = {1, 2, 3, 4};
            System.out.println(num[5]);
        } catch (ArrayIndexOutOfBoundsException e3) {
            exceptions.add(e3);
        }

/*4*/   /*ArrayStoreException*/
        try {
            Object szStr[] = new String[10];
            szStr[0] = new Character('*');
        } catch (Exception e4) {
            exceptions.add(e4);
        }

/*5*/   /*ClassCastException*/
        try {
            Object ch = new Character('*');
            System.out.println((Byte)ch);
        } catch (Exception e5) {
            exceptions.add(e5);
        }

/*6*/   /*NullPointerException*/
        int[] nNulArray = new int[5];
        nNulArray = null;
        try {
            int i = nNulArray.length;
            System.out.println(i);
        } catch (NullPointerException e6) {
            exceptions.add(e6);
        }

/*7*/   /*NegativeArraySizeException*/
        try {
            int[] asd = new int[-5];
        } catch (NegativeArraySizeException e7) {
            exceptions.add(e7);
        }

/*8*/   /*NumberFormatException*/
        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (NumberFormatException e8) {
            exceptions.add(e8);
        }

/*9*/   /*StringIndexOutOfBoundException*/
        try {
            String szShortString = "123";
            char chr = szShortString.charAt(10);
        } catch (Exception e9) {
            exceptions.add(e9);
        }


/*10*/  /*IndexOutOfBoundException*/
        try {
            ArrayList<String> strings = new ArrayList<>();
            strings.get(4);
        } catch (Exception e10) {
            exceptions.add(e10);
        }

    }
}
