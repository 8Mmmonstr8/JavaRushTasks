package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        Map<Integer, Integer> listOfBytes = new HashMap<>();
        List<Integer> outPutList = new ArrayList<>();
        Integer tmpInt;
        Integer maxFreq = 0;

        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            tmpInt = fis.read();

            if (listOfBytes.containsKey(tmpInt)) {
                Integer tmp = (Integer) listOfBytes.get(tmpInt) + 1;
                listOfBytes.put(tmpInt, tmp);

                if (tmp > maxFreq) maxFreq = tmp;
            }
            else {
                listOfBytes.put(tmpInt, 1);
            }
        }

        for (Map.Entry<Integer, Integer> pair : listOfBytes.entrySet()) {
            if (pair.getValue().equals(maxFreq)) {
                if (!outPutList.contains(pair.getValue())) {
                    outPutList.add(pair.getKey());
                }
            }
        }

        for (Integer x : outPutList) {
            System.out.print(x + " ");
        }

        fis.close();
    }
}