package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(name1));
        try {
            String string;
            while ((string = fileReader.readLine()) != null) {
                allLines.add(string);
            }
        } catch (IOException e) {
        }

        BufferedReader fileReader2 = new BufferedReader(new FileReader(name2));
        try {
            String string;
            while ((string = fileReader2.readLine()) != null) {
                forRemoveLines.add(string);
            }
        } catch (IOException e) {
        }

        reader.close();
        fileReader.close();
        fileReader2.close();

        new Solution().joinData();

/*        for (String x : allLines) {
            System.out.println(x);
        }
        System.out.println("");
        for (String z : forRemoveLines) {
            System.out.println(z);
        }*/
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
