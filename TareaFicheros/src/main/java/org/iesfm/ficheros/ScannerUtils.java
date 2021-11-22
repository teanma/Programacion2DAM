package org.iesfm.ficheros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerUtils {
    static final Logger log = LoggerFactory.getLogger(ScannerUtils.class);

    private static Scanner scanner = new Scanner(System.in);

    static String pideNombre() {
        log.info("Introduce el nombre de usuario");
        return scanner.nextLine();
    }

    static File pideRuta() throws IOException {
        log.info("Introduce la ruta al archivo de usuarios");
        File file = new File(scanner.nextLine());

        while (file.isDirectory()) {
            log.info("No puede ser un directorio, introduzca el archivo");
            file = new File(scanner.nextLine());
        }

        file.createNewFile();

        return file;
    }
}
