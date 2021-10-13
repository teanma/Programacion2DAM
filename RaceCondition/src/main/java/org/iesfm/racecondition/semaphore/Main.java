package org.iesfm.racecondition.semaphore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);

        Accumulator accumulator = new Accumulator();

        Thread t1 = new Thread(new IncTask(accumulator, 1000, semaphore));

        Thread t2 = new Thread(new DecTask(accumulator, 1000, semaphore));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            log.error("", e);
        }
        log.info("El resultado es " + accumulator.getValue());
    }
}
