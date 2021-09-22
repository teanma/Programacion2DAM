package org.iesfm.filesearch;

import java.util.Scanner;

public class Main {

    //public static Logger log = LoggerFactory.getLogger(Main.class);

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        numberOfText();
    }

    public static void numberOfText() {
        System.out.println("Introduce un texto");
        String text = scan.nextLine();

        int number = BufferedReaderQuijote.searchWord(text);

        System.out.println("La palabra " + text + " aparece " + number + " veces");
    }
}
