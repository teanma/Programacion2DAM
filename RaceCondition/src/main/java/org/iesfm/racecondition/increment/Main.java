package org.iesfm.racecondition.increment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Accumulator acc = new Accumulator();
        List<Thread> threadList = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new IncrementTask(acc, 100000));
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
        log.info("El resultado es " + acc.getValue());
    }
}
