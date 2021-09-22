package org.iesfm.filesearch;

public class MainSaludo {

    public static void main(String[] args) {
        Thread t = new Thread(new SaludoTask("hola", 2000));
        t.start();
        Thread t2 = new Thread(new SaludoTask("hello", 3000));
        t2.start();
    }
}
