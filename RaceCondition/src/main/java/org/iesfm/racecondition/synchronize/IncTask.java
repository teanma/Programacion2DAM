package org.iesfm.racecondition.synchronize;

public class IncTask implements Runnable {

    private Accumulator accumulator;
    private int numOfTimes;

    public IncTask(Accumulator accumulator, int numOfTimes) {
        this.accumulator = accumulator;
        this.numOfTimes = numOfTimes;
    }

    @Override
    public void run() {
        for (int i = 0; i < numOfTimes; i++) {
            accumulator.inc();
        }
    }
}
