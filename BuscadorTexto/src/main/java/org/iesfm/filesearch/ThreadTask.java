package org.iesfm.filesearch;

public class ThreadTask implements Runnable {

    private int number;
    private String word;
    private long timeToSleep;

    public ThreadTask(int number, String word, long timeToSleep) {
        this.number = number;
        this.word = word;
        this.timeToSleep = timeToSleep;
    }

    public static void printPhrase(int number, String word) {
        for (int i = 0; i < number; i++) {
            System.out.println(word);
        }
    }

    @Override
    public void run() {
        printPhrase(number, word);
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}