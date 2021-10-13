package org.iesfm.racecondition.deadlock;

public class IncDecTask implements Runnable {

    private Accumulator incAccumulator;

    private Accumulator decAccumulator;

    private int numOfTimes;

    public IncDecTask(Accumulator incAccumulator, Accumulator decAccumulator, int numOfTimes) {
        this.incAccumulator = incAccumulator;
        this.decAccumulator = decAccumulator;
        this.numOfTimes = numOfTimes;
    }

    @Override
    public void run() {
        for (int i = 0; i < numOfTimes; i++) {
            synchronized (incAccumulator) {
                System.out.println("DecIncTask adquiere incAcc");
                synchronized (decAccumulator) {
                    System.out.println("DecIncTask adquiere decAcc");
                    incAccumulator.inc();
                    decAccumulator.dec();
                }
                System.out.println("DecIncTask adquiere decAcc");
            }
            System.out.println("DecIncTask adquiere incAcc");
        }
    }
}
