package org.iesfm.ejercicios;

import java.io.File;

public class Ejercicio2 {

    public static void main(String[] args) {
        File currentDirectory = new File(".");

        System.out.println(currentDirectory.getAbsolutePath());
    }
}
