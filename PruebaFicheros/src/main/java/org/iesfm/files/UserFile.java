package org.iesfm.files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserFile {

    static Scanner scan = new Scanner(System.in);

    //Introducir ruta
    public static void main(String[] args) {
        System.out.println("Introduce la ruta donde guardar el fichero");
        String path = scan.nextLine();

        File folder = new File(path);

        if (folder.exists()) {
            System.out.println("Introduzca el nombre de usuario");
            String user = scan.nextLine();

            File file = new File(path + user + " .txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("No existe el directorio: " + folder.getAbsolutePath());
        }
        File userFolder = new File(path);
    }
}
