package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
  //      out.writeObject(fileName);
  //      out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    //    fileName = (String) in.readObject();
        stream = new FileOutputStream(fileName, true);
        //     in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("D:/test.txt");
        solution.writeObject("shta mle?");
        solution.close();

        FileOutputStream fos = new FileOutputStream("D:/hui.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(solution);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("D:/hui.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution solution1 = (Solution) ois.readObject();
        ois.close();
        solution1.writeObject("ya ni4e ne ponIl");

    }
}
