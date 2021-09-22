package org.iesfm.filesearch;

public class MainQuijote {

    public static void main(String[] args) {
        Thread t = new Thread(new QuijoteTask());
        t.start();
    }
}
