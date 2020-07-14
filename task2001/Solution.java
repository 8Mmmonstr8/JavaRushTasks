package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File tempFile = File.createTempFile("tempFile", ".txt", new File("D:/"));
            OutputStream outputStream = new FileOutputStream(tempFile.getAbsolutePath());
            InputStream inputStream = new FileInputStream(tempFile.getAbsolutePath());

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            if (somePerson.hashCode() == ivanov.hashCode());
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            outputStream.write(name.getBytes());
            outputStream.write("\n".getBytes());

            String isAssetPresent = assets != null ? "Yes" : "No";
            outputStream.write(isAssetPresent.getBytes());
            outputStream.write("\n".getBytes());
            outputStream.flush();

            if (assets != null) {
                for (int i = 0; i < assets.size(); i++) {
                    outputStream.write(assets.get(i).getName().getBytes());
                    outputStream.write("\n".getBytes());
                    double x = assets.get(i).getPrice();
                    String z = Double.toString(x);
                    outputStream.write(z.getBytes());
                    outputStream.write("\n".getBytes());
                }
            }
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            ArrayList<String> list = new ArrayList<>();
            int i;
            StringBuilder sb = new StringBuilder();
            while((i = inputStream.read()) != -1) {
                if ((char)i == '\n') {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                else {
                    sb.append((char)i);
                }
            }

            name = list.get(0);

            if (list.get(1).equals("Yes")) {
                for (int m = 2; m < list.size(); m += 2) {
                    assets.add(new Asset(list.get(m), Double.parseDouble(list.get(m + 1))));
                }
            }
            //implement this method - реализуйте этот метод
        }
    }
}
