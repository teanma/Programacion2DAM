package org.iesfm.racecondition.semaphore;

public class Accumulator {

    private int value = 0;

    public synchronized void inc() {
        value = value + 1;
    }

    public synchronized void dec() {
        value = value - 1;
    }

    public int getValue() {
        return value;
    }
}
