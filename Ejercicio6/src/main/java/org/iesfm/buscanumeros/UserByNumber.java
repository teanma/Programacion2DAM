package org.iesfm.buscanumeros;

import java.util.Scanner;

public class UserByNumber {

    private static Scanner scan = new Scanner(System.in);

    public static int askForANumber() {
        System.out.println("Introduce un número");
        int number = scan.nextInt();
        scan.nextLine();
        return number;
    }
}


