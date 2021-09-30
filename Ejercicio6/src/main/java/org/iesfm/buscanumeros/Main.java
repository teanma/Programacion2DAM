package org.iesfm.buscanumeros;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Escribe el número");
        int number = scan.nextInt();
        scan.nextLine();
        System.out.println("Crea el archivo");
    }
}
