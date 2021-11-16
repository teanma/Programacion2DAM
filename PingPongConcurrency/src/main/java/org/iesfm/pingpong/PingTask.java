package org.iesfm.pingpong;

import java.util.concurrent.Semaphore;

public class PingTask implements Runnable {

    private Semaphore semaphorePing;
    private Semaphore semaphorePong;

    public PingTask(Semaphore semaphorePing, Semaphore semaphorePong) {
        this.semaphorePing = semaphorePing;
        this.semaphorePong = semaphorePong;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                semaphorePing.acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ping");
            semaphorePong.release();
        }
    }
}
