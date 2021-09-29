package org.iesfm.searchandwrite;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce el archivo");
        String file = scan.nextLine();
        System.out.println("Introduce el texto");
        String text = scan.nextLine();
    }
}
