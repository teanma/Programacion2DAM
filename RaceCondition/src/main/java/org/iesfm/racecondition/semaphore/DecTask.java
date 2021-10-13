package org.iesfm.racecondition.semaphore;

import java.util.concurrent.Semaphore;

public class DecTask implements Runnable{

    private Accumulator accumulator;
    private int numOfTimes;
    private Semaphore semaphore;

    public DecTask(Accumulator accumulator, int numOfTimes, Semaphore semaphore) {
        this.accumulator = accumulator;
        this.numOfTimes = numOfTimes;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < numOfTimes; i++) {
            try {
                semaphore.acquire();
                accumulator.dec();
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
