package org.iesfm.racecondition.synchronize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Accumulator accumulator = new Accumulator();

        Thread t1 = new Thread(new IncTask(accumulator, 10000));

        Thread t2 = new Thread(new DecTask(accumulator, 10000));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("El resultado es " + accumulator.getValue());
    }
}
