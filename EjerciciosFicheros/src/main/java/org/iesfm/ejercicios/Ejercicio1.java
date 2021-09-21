package org.iesfm.ejercicios;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        File userFolder = new File("/home/teodormardale");

        File[] files = userFolder.listFiles();

        File userFile = null;
        for (int i = 0; i < files.length; i++) {
            userFile = files[i];
            System.out.println(userFile);
        }
    }
}
