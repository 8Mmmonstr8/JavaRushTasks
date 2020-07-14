package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 3) {
                            Person person;
                            String name = args[i];
                            String sex = args[i + 1];
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
                            Date date = sdf.parse(args[i + 2]);
                            person = sex.equals("м") ? Person.createMale(name, date) : Person.createFemale(name, date);
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                    }
                    break;

                case "-u":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 4) {
                            int id = Integer.parseInt(args[i]);
                            String name = args[i + 1];
                            String sex = args[i + 2];
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
                            Date date = sdf.parse(args[i + 3]);
                            allPeople.get(id).setName(name);
                            allPeople.get(id).setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
                            allPeople.get(id).setBirthDate(date);
                        }
                    }
                    break;

                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
                            allPeople.get(id).setName(null);
                            allPeople.get(id).setSex(null);
                            allPeople.get(id).setBirthDate(null);
                        }
                    }
                    break;

                case "-i":
                    synchronized (allPeople) {
                        for (int i = 0; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
                            String name = allPeople.get(id).getName();
                            String sex = allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж";
                            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
                            Date date = sdf2.format(allPeople.get(id).getBirthDate());
                            System.out.println(name + " " + sex + " " + date);
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //start here - начни тут
    }
}
