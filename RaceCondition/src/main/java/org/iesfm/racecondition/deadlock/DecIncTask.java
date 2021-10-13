package org.iesfm.racecondition.deadlock;

public class DecIncTask implements Runnable {

    private Accumulator decAccumulator;

    private Accumulator incAccumulator;

    private int numOfTimes;

    public DecIncTask(Accumulator decAccumulator, Accumulator incAccumulator, int numOfTimes) {
        this.decAccumulator = decAccumulator;
        this.incAccumulator = incAccumulator;
        this.numOfTimes = numOfTimes;
    }

    @Override
    public void run() {
        for (int i = 0; i < numOfTimes; i++) {
            synchronized (decAccumulator) {
                System.out.println("DecIncTask adquiere decAcc");
                synchronized (incAccumulator) {
                    System.out.println("DecIncTask adquiere incAcc");
                    decAccumulator.dec();
                    incAccumulator.inc();
                }
                System.out.println("DecIncTask adquiere incAcc");
            }
            System.out.println("DecIncTask adquiere decAcc");
        }
    }
}
