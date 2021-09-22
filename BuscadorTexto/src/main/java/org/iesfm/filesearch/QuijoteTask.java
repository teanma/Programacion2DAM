package org.iesfm.filesearch;

import java.util.Scanner;

public class QuijoteTask implements Runnable {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        System.out.println("Introduce un texto");
        String text = scanner.nextLine();
        while (!text.equals("exit")) {
            int number = BufferedReaderQuijote.searchWord(text);
            System.out.println("La palabra " + text + " aparece " + number + " veces");
            System.out.println("Introduce un texto");
            text = scanner.nextLine();
        }
    }
}
