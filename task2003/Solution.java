package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        try {
            for (Map.Entry<String, String> map : runtimeStorage.entrySet()) {
                prop.put(map.getKey(), map.getValue());
            }
            prop.store(outputStream, null);
            outputStream.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
        //напишите тут ваш код
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
            for (String x : prop.stringPropertyNames()) {
                runtimeStorage.put(x, prop.getProperty(x));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
