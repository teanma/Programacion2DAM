package org.iesfm.ejercicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Ejercicio9 {

    public static Logger log = LoggerFactory.getLogger(Ejercicio9.class);

    public static void main(String[] args) {

        if (args.length == 0) {
            log.error("Debe introducir un argumento");
        } else {
            File file = new File(args[0]);
            listFiles(file);
        }
    }

    public static void listFiles(File folder) {
        for (File file : folder.listFiles()) {
            if (!file.exists()) {
                log.error("No existe el archivo");
            } else {
                if (file.isFile()) {
                    log.info("Es un fichero");
                    log.info("Nombre: " + file.getName());
                    log.info("Tamaño: " + file.length());
                } else if (file.isDirectory()) {
                    log.info("Es un directorio");
                    log.info("Nombre: " + file.getName());
                }
            }
        }
    }
}
