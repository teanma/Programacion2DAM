package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ThreadQuijote {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(ThreadQuijote.class);

        Runnable buscadorQuijote1 = new Runnable() {
            @Override
            public void run() {
                String text = numberOfText();
                logger.info(text);
            }
        };
        Thread threadQuijote = new Thread(buscadorQuijote1);
        threadQuijote.start();

        Runnable buscadorQuijote2 = new Runnable() {
            @Override
            public void run() {
                String text = numberOfText();
                logger.info(text);
            }
        };
        Thread threadQuijote2 = new Thread(buscadorQuijote2);
        threadQuijote2.start();
    }

    public static String numberOfText() {
        System.out.println("Introduce un texto");
        String text = scan.nextLine();

        int number = BufferedReaderQuijote.searchWord(text);
        System.out.println("La palabra " + text + " aparece " + number + " veces");
        return text;
    }
}
