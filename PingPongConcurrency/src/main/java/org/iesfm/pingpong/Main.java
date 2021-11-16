package org.iesfm.pingpong;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore semaphorePing = new Semaphore(1);
        Semaphore semaphorePong = new Semaphore(1);

        Thread ping = new Thread(new PingTask(semaphorePing, semaphorePong));
        Thread pong = new Thread(new PongTask(semaphorePing, semaphorePong));

        try {
            semaphorePong.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ping.start();
        pong.start();

        try {
            ping.join();
            pong.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
