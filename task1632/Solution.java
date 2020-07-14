package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());

    }

    public static void main(String[] args) {
    }

    public static class ThreadOne extends Thread {

        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class ThreadTwo extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted())
                {

                }
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadThree extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public static class ThreadFour extends Thread implements Message {
        private static volatile boolean repeat = true;

        @Override
        public void showWarning() {
            repeat = false;
        }

        @Override
        public void run() {
            while (repeat) {

            }
        }
    }

    public static class ThreadFive extends Thread {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int x = 0;

            try {
                while (!isInterrupted()) {
                    String s = reader.readLine();

                    if (s.equals("N")) this.interrupt();
                    else {
                        int digit = Integer.parseInt(s);
                        x += digit;
                    }
                }
                throw new InterruptedException();
            } catch (IOException e) {
            } catch (InterruptedException e) {
                System.out.println(x);
            }
        }
    }
}