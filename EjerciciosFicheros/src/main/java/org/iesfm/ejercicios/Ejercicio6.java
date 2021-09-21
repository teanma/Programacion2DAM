package org.iesfm.ejercicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Ejercicio6 {

    public static Logger log = LoggerFactory.getLogger(Ejercicio6.class);

    public static void main(String[] args) {

        if (args.length == 0) {
            log.error("Debe introducir un argumento");
        } else {
            File file = new File(args[0]);
            showAtributeFiles(file);
        }
    }

    public static void showAtributeFiles(File atributeFiles) {

        if(atributeFiles.exists()) {
            log.info("Nombre del archivo: " + atributeFiles.getName());

            log.info("Camino absoluto: " + atributeFiles.getAbsolutePath());

            log.info("Tamaño: " + atributeFiles.length());

            if (atributeFiles.isFile()) {
                log.info("Es un fichero");
            } else if (atributeFiles.isDirectory()) {
                log.info("Es un directorio");
            }

            log.info("Última modificación: " + atributeFiles.lastModified());

            if (atributeFiles.canRead()) {
                log.info("Tiene permisos de escritura");
            } else {
                log.info("No tiene permisos de escritura");
            }

            if (atributeFiles.canRead()) {
                log.info("Tiene permisos de lectura");
            } else {
                log.info("No tiene permisos de lectura");
            }

            if (atributeFiles.canExecute()) {
                log.info("Tiene permisos de ejecución");
            } else {
                log.info("No tiene permisos de ejecución");
            }
        } else {
            log.error("No existe el archivo");
        }
    }
}
