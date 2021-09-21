package org.iesfm.ejercicios;

import java.io.File;

public class Ejercicio3 {

    public static void showFiles(File folder) {
        for (File file : folder.listFiles()) {
            if(file.isDirectory()) {
                showFiles(file);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        File directoryContent = new File(".");
        showFiles(directoryContent);
    }
}
