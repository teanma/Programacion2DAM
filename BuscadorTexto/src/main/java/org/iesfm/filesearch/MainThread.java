package org.iesfm.filesearch;

public class MainThread {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadTask(100, "hola", 1000));
        thread1.start();
        Thread thread2 = new Thread(new ThreadTask(50, "adios", 1000));
        thread2.start();
    }
}
