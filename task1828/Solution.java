package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
        r.close();
        List<String> list = new ArrayList<>();

        if (args.length > 0 && args[0].equals("-u") || args[0].equals("-d")) {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int id_temp;
            int id = Integer.parseInt(args[1]);
            while (reader.ready()) {

                String line = reader.readLine();
                id_temp = Integer.parseInt(line.substring(0, 8).trim());
                if (id == id_temp) {
                    if (args[0].equals("-u")) {
                        String newId = String.format("%-8d", id);
                        String productName = String.format("%-30.30s", args[2]);
                        String price = String.format("%-8.2f", Double.parseDouble(args[3]));
                        String quantity = String.format("%-4d", Integer.parseInt(args[4]));
                        line = newId + productName + price + quantity;
                    }
                    if (args[0].equals("-d"))
                        continue;
                }
                list.add(line);
            }
            reader.close();
        }

        if (args[0].equals("-u") || args[0].equals("-d")) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));
                writer.newLine();
            }
            writer.close();
        }
    }
}