package org.iesfm.buscanumeros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    public static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Escribe el número");
        int number = scan.nextInt();
        scan.nextLine();
        System.out.println("Crea el archivo");
    }
}
