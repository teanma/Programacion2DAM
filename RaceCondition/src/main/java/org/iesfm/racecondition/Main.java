package org.iesfm.racecondition;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Accumulator acc = new Accumulator();
        List<Thread> threadList = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new IncrementTask(acc, 1000000));
            thread.start();
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(acc.getValue());
    }
}
