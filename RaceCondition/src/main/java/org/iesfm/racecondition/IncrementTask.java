package org.iesfm.racecondition;

public class IncrementTask implements Runnable {

    private Accumulator accumulator;
    private int numberOfTimes;

    public IncrementTask(Accumulator accumulator, int numberOfTimes) {
        this.accumulator = accumulator;
        this.numberOfTimes = numberOfTimes;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfTimes; i++) {
            accumulator.inc();
        }
    }
}
