package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));

        while (br.ready()) {
            String[] nameAndDate = br.readLine().split(" ");

            SimpleDateFormat sdf = new SimpleDateFormat("dd M y", Locale.ENGLISH);
            Date bd = sdf.parse(nameAndDate[nameAndDate.length -3] + " " + nameAndDate[nameAndDate.length - 2] + " " + nameAndDate[nameAndDate.length - 1]);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nameAndDate.length - 3; i++) {
                sb.append(nameAndDate[i]);
                sb.append(" ");
            }

            PEOPLE.add(new Person(sb.toString().trim(), bd));

/*            int year = Integer.parseInt(nameAndDate[nameAndDate.length-1]);
            int month = Integer.parseInt(nameAndDate[nameAndDate.length-2]);
            int day = Integer.parseInt(nameAndDate[nameAndDate.length-3]);

            Date birthday = new GregorianCalendar(year, month - 1, day).getTime();*/
        }
        br.close();

    }
}
