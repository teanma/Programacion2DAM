package org.iesfm.pingpong;

import java.util.concurrent.Semaphore;

public class PongTask implements Runnable {

    private Semaphore semaphorePing;
    private Semaphore semaphorePong;

    public PongTask(Semaphore semaphorePing, Semaphore semaphorePong) {
        this.semaphorePing = semaphorePing;
        this.semaphorePong = semaphorePong;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                semaphorePong.acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Pong");
            semaphorePing.release();
        }
    }
}
