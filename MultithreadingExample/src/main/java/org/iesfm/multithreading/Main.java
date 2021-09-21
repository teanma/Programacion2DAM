package org.iesfm.multithreading;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Runnable holas = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    System.out.println("Hola");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //Thread holasThread = new Thread(holas);
        //holasThread.start();
        //for (int i = 0; i < 500; i++) {
        //    System.out.println("Adiós");
        //    try {
        //        Thread.sleep(10);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}

        Runnable adios = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    System.out.println("Adiós");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread holasThread = new Thread(holas);
        Thread adiosThread = new Thread(adios);
        holasThread.start();
        adiosThread.start();
    }
}
