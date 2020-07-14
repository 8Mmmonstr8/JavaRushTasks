package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File tempFile = File.createTempFile("tempFile", ".txt", new File("D:/"));
            OutputStream outputStream = new FileOutputStream(tempFile.getAbsolutePath());
            InputStream inputStream = new FileInputStream(tempFile.getAbsolutePath());

            JavaRush javaRush = new JavaRush();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM y", Locale.ENGLISH);
            User user1 = new User();
            user1.setFirstName("Vasya");
            user1.setLastName("Pupkin");
            user1.setBirthDate(sdf.parse("11 02 1990"));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);

            User user2 = new User();
            user2.setFirstName("Mila");
            user2.setLastName("Yobovich");
            user2.setBirthDate(sdf.parse("22 03 1991"));
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user2);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            if (javaRush.users.hashCode() == loadedObject.users.hashCode());
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss:SSS z yyyy", Locale.ENGLISH);


            for (User x : users) {
                printWriter.println(x.getFirstName());
                printWriter.println(x.getLastName());
                printWriter.println(sdf.format(x.getBirthDate()));
                printWriter.println(x.isMale());
                printWriter.println(x.getCountry());
            }
            printWriter.flush();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat sdf2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss:SSS z yyyy", Locale.ENGLISH);

            String str;
            while ((str = br.readLine()) != null) {
                User user = new User();
                user.setFirstName(str);
                user.setLastName(br.readLine());
                user.setBirthDate(sdf2.parse(br.readLine()));
                user.setMale(Boolean.parseBoolean(br.readLine()));
                user.setCountry(User.Country.valueOf(br.readLine()));
                users.add(user);
            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}