package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws Exception {
            String[] personLine = fileScanner.nextLine().split(" ");
            SimpleDateFormat sdf = new SimpleDateFormat("d M y", Locale.ENGLISH);
            Date birth = sdf.parse(personLine[3] + " " + personLine[4] + " " + personLine[5]);
            Person person = new Person(personLine[1], personLine[2], personLine[0], birth);
            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
