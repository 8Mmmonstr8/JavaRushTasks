package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case "-c":
                    if (args[2].equals("м"))
                        allPeople.add(Person.createMale(args[1], sdf.parse(args[3])));
                    else
                        allPeople.add(Person.createFemale(args[1], sdf.parse(args[3])));
                    System.out.println(allPeople.size() - 1);
                    break;
                case "-u":
                    int id = Integer.parseInt(args[1]);
                    allPeople.get(id).setName(args[2]);
                    if (args[3].equals("м"))
                        allPeople.get(id).setSex(Sex.MALE);
                    else
                        allPeople.get(id).setSex(Sex.FEMALE);
                    allPeople.get(id).setBirthDate(sdf.parse(args[4]));
                    break;
                case "-d":
                    allPeople.get(id).setName(null);
                    allPeople.get(id).setSex(null);
                    allPeople.get(id).setBirthDate(null);
                    break;
                case "-i":
                    String name = allPeople.get(id).getName();
                    String sex;
                    if (allPeople.get(id).getSex() == Sex.MALE) sex = "м";
                    else sex = "ж";
                    Date date = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH).format(allPeople.get(id).getBirthDate());
                    System.out.println(name + " " + sex + " " + date);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //start here - начни тут
    }
}
